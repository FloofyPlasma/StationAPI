package com.floofyplasma.stationapi.api.util.math;

import com.google.common.collect.AbstractIterator;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import com.floofyplasma.stationapi.api.util.BlockRotation;
import com.floofyplasma.stationapi.api.util.Util;
import org.apache.commons.lang3.Validate;

import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static net.minecraft.util.math.MathHelper.floor;

public interface StationBlockPos {
    Codec<BlockPos> CODEC = Codec.INT_STREAM.comapFlatMap(
            stream -> Util.toArray(stream, 3).map(values -> new BlockPos(values[0], values[1], values[2])),
            pos -> IntStream.of(pos.getX(), pos.getY(), pos.getZ())
    ).stable();
    /**
     * The block position which x, y, and z values are all zero.
     */
    BlockPos ORIGIN = new BlockPos(0, 0, 0);
    int
            SIZE_BITS_X = 1 + MathHelper.floorLog2(MathHelper.smallestEncompassingPowerOfTwo(30000000)),
            SIZE_BITS_Z = SIZE_BITS_X,
            SIZE_BITS_Y = 64 - SIZE_BITS_X - SIZE_BITS_Z,
            BIT_SHIFT_X = SIZE_BITS_Y + SIZE_BITS_Z,
            BIT_SHIFT_Z = SIZE_BITS_Y;
    long
            BITS_X = (1L << SIZE_BITS_X) - 1L,
            BITS_Z = (1L << SIZE_BITS_Z) - 1L,
            BITS_Y = (1L << SIZE_BITS_Y) - 1L;

    static BlockPos create(double x, double y, double z) {
        return new BlockPos(floor(x), floor(y), floor(z));
    }

    static BlockPos create(Vec3d pos) {
        return create(pos.x, pos.y, pos.z);
    }

    static BlockPos create(Position pos) {
        return create(pos.getX(), pos.getY(), pos.getZ());
    }

    static BlockPos create(Vec3i pos) {
        return new BlockPos(pos.getX(), pos.getY(), pos.getZ());
    }

    static long offset(long value, Direction direction) {
        return add(value, direction.getOffsetX(), direction.getOffsetY(), direction.getOffsetZ());
    }

    static long add(long value, int x, int y, int z) {
        return asLong(unpackLongX(value) + x, unpackLongY(value) + y, unpackLongZ(value) + z);
    }

    static int unpackLongX(long packedPos) {
        return (int) (packedPos << 64 - BIT_SHIFT_X - SIZE_BITS_X >> 64 - SIZE_BITS_X);
    }

    static int unpackLongY(long packedPos) {
        return (int) (packedPos << 64 - SIZE_BITS_Y >> 64 - SIZE_BITS_Y);
    }

    static int unpackLongZ(long packedPos) {
        return (int) (packedPos << 64 - BIT_SHIFT_Z - SIZE_BITS_Z >> 64 - SIZE_BITS_Z);
    }

    static BlockPos fromLong(long packedPos) {
        return new BlockPos(unpackLongX(packedPos), unpackLongY(packedPos), unpackLongZ(packedPos));
    }

    static long asLong(int x, int y, int z) {
        long l = 0L;
        l |= ((long) x & BITS_X) << BIT_SHIFT_X;
        l |= ((long) y & BITS_Y);
        return l |= ((long) z & BITS_Z) << BIT_SHIFT_Z;
    }

    static long removeChunkSectionLocalY(long y) {
        return y & 0xFFFFFFFFFFFFFFF0L;
    }

    /**
     * Iterates through {@code count} random block positions in a given range around the given position.
     *
     * <p>The iterator yields positions in no specific order. The same position
     * may be returned multiple times by the iterator.
     *
     * @param range  the maximum distance from the given pos in any axis
     * @param around the {@link BlockPos} to iterate around
     * @param count  the number of positions to iterate
     */
    static Iterable<BlockPos> iterateRandomly(Random random, int count, BlockPos around, int range) {
        return iterateRandomly(
                random, count,
                around.getX() - range, around.getY() - range, around.getZ() - range,
                around.getX() + range, around.getY() + range, around.getZ() + range
        );
    }

    /**
     * Iterates through {@code count} random block positions in the given area.
     *
     * <p>The iterator yields positions in no specific order. The same position
     * may be returned multiple times by the iterator.
     *
     * @param count the number of positions to iterate
     * @param minX  the minimum x value for returned positions
     * @param minY  the minimum y value for returned positions
     * @param minZ  the minimum z value for returned positions
     * @param maxX  the maximum x value for returned positions
     * @param maxY  the maximum y value for returned positions
     * @param maxZ  the maximum z value for returned positions
     */
    static Iterable<BlockPos> iterateRandomly(Random random, int count, int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
        final int i = maxX - minX + 1;
        final int j = maxY - minY + 1;
        final int k = maxZ - minZ + 1;
        return () -> new AbstractIterator<>() {
            final MutableBlockPos pos = new MutableBlockPos();
            int remaining = count;

            @Override
            protected BlockPos computeNext() {
                if (this.remaining <= 0) {
                    return this.endOfData();
                }
                MutableBlockPos blockPos = this.pos.set(minX + random.nextInt(i), minY + random.nextInt(j), minZ + random.nextInt(k));
                --this.remaining;
                return blockPos;
            }
        };
    }

    /**
     * Iterates block positions around the {@code center}. The iteration order
     * is mainly based on the manhattan distance of the position from the
     * center.
     *
     * <p>For the same manhattan distance, the positions are iterated by y
     * offset, from negative to positive. For the same y offset, the positions
     * are iterated by x offset, from negative to positive. For the two
     * positions with the same x and y offsets and the same manhattan distance,
     * the one with a positive z offset is visited first before the one with a
     * negative z offset.
     *
     * @param rangeY the maximum y difference from the center
     * @param rangeZ the maximum z difference from the center
     * @param center the center of iteration
     * @param rangeX the maximum x difference from the center
     */
    static Iterable<BlockPos> iterateOutwards(BlockPos center, int rangeX, int rangeY, int rangeZ) {
        final int sum = rangeX + rangeY + rangeZ;
        final int x = center.getX();
        final int y = center.getY();
        final int z = center.getZ();
        return () -> new AbstractIterator<>() {
            private final MutableBlockPos pos = new MutableBlockPos();
            private int manhattanDistance;
            private int limitX;
            private int limitY;
            private int dx;
            private int dy;
            private boolean swapZ;

            @Override
            protected BlockPos computeNext() {
                if (this.swapZ) {
                    this.swapZ = false;
                    this.pos.setZ(z - (this.pos.z - z));
                    return this.pos;
                }
                MutableBlockPos blockPos = null;
                while (blockPos == null) {
                    if (this.dy > this.limitY) {
                        ++this.dx;
                        if (this.dx > this.limitX) {
                            ++this.manhattanDistance;
                            if (this.manhattanDistance > sum) {
                                return this.endOfData();
                            }
                            this.limitX = Math.min(rangeX, this.manhattanDistance);
                            this.dx = -this.limitX;
                        }
                        this.limitY = Math.min(rangeY, this.manhattanDistance - Math.abs(this.dx));
                        this.dy = -this.limitY;
                    }
                    int i2 = this.dx;
                    int j2 = this.dy;
                    int k2 = this.manhattanDistance - Math.abs(i2) - Math.abs(j2);
                    if (k2 <= rangeZ) {
                        this.swapZ = k2 != 0;
                        blockPos = this.pos.set(x + i2, y + j2, z + k2);
                    }
                    ++this.dy;
                }
                return blockPos;
            }
        };
    }

    static Optional<BlockPos> findClosest(BlockPos pos, int horizontalRange, int verticalRange, Predicate<BlockPos> condition) {
        for (BlockPos blockPos : iterateOutwards(pos, horizontalRange, verticalRange, horizontalRange)) {
            if (!condition.test(blockPos)) continue;
            return Optional.of(blockPos);
        }
        return Optional.empty();
    }

    static Stream<BlockPos> streamOutwards(BlockPos center, int maxX, int maxY, int maxZ) {
        return StreamSupport.stream(iterateOutwards(center, maxX, maxY, maxZ).spliterator(), false);
    }

    static Iterable<BlockPos> iterate(BlockPos start, BlockPos end) {
        return iterate(
                Math.min(start.getX(), end.getX()), Math.min(start.getY(), end.getY()), Math.min(start.getZ(), end.getZ()),
                Math.max(start.getX(), end.getX()), Math.max(start.getY(), end.getY()), Math.max(start.getZ(), end.getZ())
        );
    }

    static Stream<BlockPos> stream(BlockPos start, BlockPos end) {
        return StreamSupport.stream(iterate(start, end).spliterator(), false);
    }

    static Stream<BlockPos> stream(Box box) {
        return stream(floor(box.minX), floor(box.minY), floor(box.minZ), floor(box.maxX), floor(box.maxY), floor(box.maxZ));
    }

    static Stream<BlockPos> stream(int startX, int startY, int startZ, int endX, int endY, int endZ) {
        return StreamSupport.stream(iterate(startX, startY, startZ, endX, endY, endZ).spliterator(), false);
    }

    static Iterable<BlockPos> iterate(int startX, int startY, int startZ, int endX, int endY, int endZ) {
        final int i = endX - startX + 1;
        final int j = endY - startY + 1;
        int k = endZ - startZ + 1;
        final int l = i * j * k;
        return () -> new AbstractIterator<>() {
            private final MutableBlockPos pos = new MutableBlockPos();
            private int index;

            @Override
            protected BlockPos computeNext() {
                if (this.index == l) {
                    return this.endOfData();
                }
                int i2 = this.index % i;
                int j2 = this.index / i;
                int k = j2 % j;
                int l2 = j2 / j;
                ++this.index;
                return this.pos.set(startX + i2, startY + k, startZ + l2);
            }
        };
    }

    /**
     * Iterates block positions around the {@code center} in a square of
     * ({@code 2 * radius + 1}) by ({@code 2 * radius + 1}). The blocks
     * are iterated in a (square) spiral around the center.
     *
     * <p>The first block returned is the center, then the iterator moves
     * a block towards the first direction, followed by moving along
     * the second direction.
     *
     * @param firstDirection  the direction the iterator moves first
     * @param secondDirection the direction the iterator moves after the first
     * @param center          the center of iteration
     * @param radius          the maximum chebychev distance
     * @throws IllegalStateException when the 2 directions lie on the same axis
     */
    static Iterable<MutableBlockPos> iterateInSquare(BlockPos center, int radius, Direction firstDirection, Direction secondDirection) {
        Validate.validState(firstDirection.getAxis() != secondDirection.getAxis(), "The two directions cannot be on the same axis");
        return () -> new AbstractIterator<>() {
            private final Direction[] directions;
            private final MutableBlockPos pos;
            private final int maxDirectionChanges;
            private int directionChangeCount;
            private int maxSteps;
            private int steps;
            private int currentX;
            private int currentY;
            private int currentZ;

            {
                this.directions = new Direction[]{firstDirection, secondDirection, firstDirection.getOpposite(), secondDirection.getOpposite()};
                this.pos = center.mutableCopy().move(secondDirection);
                this.maxDirectionChanges = 4 * radius;
                this.directionChangeCount = -1;
                this.currentX = this.pos.getX();
                this.currentY = this.pos.getY();
                this.currentZ = this.pos.getZ();
            }

            @Override
            protected MutableBlockPos computeNext() {
                this.pos.set(this.currentX, this.currentY, this.currentZ).move(this.directions[(this.directionChangeCount + 4) % 4]);
                this.currentX = this.pos.getX();
                this.currentY = this.pos.getY();
                this.currentZ = this.pos.getZ();
                if (this.steps >= this.maxSteps) {
                    if (this.directionChangeCount >= this.maxDirectionChanges) {
                        return this.endOfData();
                    }
                    ++this.directionChangeCount;
                    this.steps = 0;
                    this.maxSteps = this.directionChangeCount / 2 + 1;
                }
                ++this.steps;
                return this.pos;
            }
        };
    }

    default int getX() {
        return Util.assertImpl();
    }

    default int getY() {
        return Util.assertImpl();
    }

    default int getZ() {
        return Util.assertImpl();
    }

    default long asLong() {
        return asLong(getX(), getY(), getZ());
    }

    default BlockPos add(double d, double e, double f) {
        return Util.assertImpl();
    }

    default BlockPos add(int i, int j, int k) {
        return Util.assertImpl();
    }

    default BlockPos add(Vec3i vec3i) {
        return add(vec3i.getX(), vec3i.getY(), vec3i.getZ());
    }

    default BlockPos subtract(Vec3i vec3i) {
        return add(-vec3i.getX(), -vec3i.getY(), -vec3i.getZ());
    }

    default BlockPos multiply(int i) {
        return Util.assertImpl();
    }

    default BlockPos down() {
        return new BlockPos(getX(), getY() - 1, getZ());
    }

    default BlockPos down(int distance) {
        return new BlockPos(getX(), getY() - distance, getZ());
    }

    default BlockPos up() {
        return new BlockPos(getX(), getY() + 1, getZ());
    }

    default BlockPos up(int distance) {
        return new BlockPos(getX(), getY() + distance, getZ());
    }

    default BlockPos east() {
        return new BlockPos(getX(), getY(), getZ() - 1);
    }

    default BlockPos east(int distance) {
        return new BlockPos(getX(), getY(), getZ() - distance);
    }

    default BlockPos west() {
        return new BlockPos(getX(), getY(), getZ() + 1);
    }

    default BlockPos west(int distance) {
        return new BlockPos(getX(), getY(), getZ() + distance);
    }

    default BlockPos north() {
        return new BlockPos(getX() - 1, getY(), getZ());
    }

    default BlockPos north(int distance) {
        return new BlockPos(getX() - distance, getY(), getZ());
    }

    default BlockPos south() {
        return new BlockPos(getX() + 1, getY(), getZ());
    }

    default BlockPos south(int distance) {
        return new BlockPos(getX() + distance, getY(), getZ());
    }

    default BlockPos offset(Direction direction) {
        return new BlockPos(getX() + direction.getOffsetX(), getY() + direction.getOffsetY(), getZ() + direction.getOffsetZ());
    }

    default BlockPos offset(Direction direction, int i) {
        return Util.assertImpl();
    }

    default BlockPos offset(Direction.Axis axis, int i) {
        return Util.assertImpl();
    }

    default BlockPos rotate(BlockRotation rotation) {
        return Util.assertImpl();
    }

    default BlockPos crossProduct(Vec3i pos) {
        return new BlockPos(
                getY() * pos.getZ() - getZ() * pos.getY(),
                getZ() * pos.getX() - getX() * pos.getZ(),
                getX() * pos.getY() - getY() * pos.getX()
        );
    }

    default BlockPos withY(int y) {
        return new BlockPos(this.getX(), y, this.getZ());
    }

    default BlockPos toImmutable() {
        return Util.assertImpl();
    }

    default MutableBlockPos mutableCopy() {
        return new MutableBlockPos(getX(), getY(), getZ());
    }
}
