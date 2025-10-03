package com.floofyplasma.stationapi.api.registry.legacy;

import net.minecraft.nbt.NbtCompound;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.registry.legacy.PostRegistryRemapEvent;
import com.floofyplasma.stationapi.api.registry.Registries;
import com.floofyplasma.stationapi.api.registry.Registry;
import com.floofyplasma.stationapi.api.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.floofyplasma.stationapi.api.StationAPI.LOGGER;

/**
 * An interface extension of {@link AbstractLegacyRegistry} that has different legacy ID mappings for each Minecraft world.
 *
 * <p>Such implementation is necessary for block and item registries, because there's no way to provide unique legacy IDs
 * for each modded setup without collisions, so we store the unique {@link Identifier} to legacy ID mappings of those objects
 * in the game's worlds, so they can be shared and used on different modded setups and servers.
 *
 * @param <T> the object's type that's stored in the registry.
 * @author mine_diver
 */
public interface WorldLegacyRegistry<T> {

    /**
     * This method writes the {@code Identifier -> Legacy ID} mappings of this registry
     * into the level properties located in level.dat file.
     *
     * @param tag the level properties NBT tag.
     */
    private void save(@NotNull NbtCompound tag) {
        //noinspection unchecked
        AbstractLegacyRegistry<T> registry = (AbstractLegacyRegistry<T>) this;
        registry.forEach(value -> tag.putInt(Objects.requireNonNull(registry.getId(value)).toString(), registry.getLegacyId(value)));
    }

    /**
     * This method loads the {@code Identifier -> Legacy ID} mappings into the registry from level.dat
     * of world that's being loaded.
     *
     * @param tag the level properties NBT tag.
     */
    private void load(@NotNull NbtCompound tag) {
        //noinspection unchecked
        AbstractLegacyRegistry<T> registry = (AbstractLegacyRegistry<T>) this;
        registry.forEach(value -> {
            String id = Objects.requireNonNull(registry.getId(value)).toString();
            if (tag.contains(id))
                remap(tag.getInt(id), value);
        });
    }

    /**
     * Internal registry method for remapping the given object's legacy ID.
     *
     * <p>This is used for actually applying the changes from level.dat of the loading world to the current game.
     *
     * @param newLegacyId the new legacy ID that the object should be remapped to.
     * @param value the object that should be remapped.
     */
    void remap(int newLegacyId, T value);

    /**
     * Writes all LevelLegacyRegistries into an NBT tag.
     *
     * @param tag the tag to save all registries to.
     */
    static void saveAll(NbtCompound tag) {
        Registries.REGISTRIES.getIds().forEach(registryId -> {
            Registry<?> registry = Registries.REGISTRIES.get(registryId);
            if (registry instanceof WorldLegacyRegistry<?> llRegistry) {
                NbtCompound registryTag = new NbtCompound();
                llRegistry.save(registryTag);
                tag.put(registryId.toString(), registryTag);
            }
        });
    }

    /**
     * Reads all LevelLegacyRegistries from an NBT tag.
     *
     * @param tag the tag to load all registries from.
     */
    static void loadAll(NbtCompound tag) {
        Registries.REGISTRIES.getIds().forEach(registryId -> {
            Registry<?> registry = Registries.REGISTRIES.get(registryId);
            String id = registryId.toString();
            if (registry instanceof WorldLegacyRegistry<?> llRegistry && tag.contains(id)) {
                LOGGER.info("Remapping \"" + id + "\" registry...");
                llRegistry.load(tag.getCompound(id));
            }
        });
        StationAPI.EVENT_BUS.post(PostRegistryRemapEvent.builder().build());
    }
}
