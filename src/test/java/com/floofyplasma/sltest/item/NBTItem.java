package com.floofyplasma.sltest.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import com.floofyplasma.stationapi.api.client.item.CustomTooltipProvider;
import com.floofyplasma.stationapi.api.item.StationItemNbt;
import com.floofyplasma.stationapi.api.template.item.TemplateItem;
import com.floofyplasma.stationapi.api.util.Identifier;

import java.util.Random;

import static com.floofyplasma.sltest.SLTest.NAMESPACE;
import static com.floofyplasma.stationapi.api.util.Identifier.of;

public class NBTItem extends TemplateItem implements CustomTooltipProvider {

    protected NBTItem(Identifier id) {
        super(id);
    }

    @Override
    public boolean useOnBlock(ItemStack item, PlayerEntity player, World level, int x, int y, int z, int facing) {
        NbtCompound nbt = StationItemNbt.class.cast(item).getStationNbt();
        if (!nbt.contains(of(NAMESPACE, "rand_num").toString()))
            nbt.putInt(of(NAMESPACE, "rand_num").toString(), new Random().nextInt(3));
        player.method_490("Woah: " + nbt.getInt(of(NAMESPACE, "rand_num").toString()));
        return true;
    }

    @Override
    public ItemStack use(ItemStack arg, World arg2, PlayerEntity arg3) {
//        CompoundTag chunkTag = new CompoundTag();
//        CompoundTag levelTag = new CompoundTag();
//        ListTag entities = new ListTag();
//        CompoundTag itemEntity = new CompoundTag();
//        itemEntity.put("id", "Item");
//        CompoundTag itemEntityStack = new CompoundTag();
//        itemEntityStack.put("id", (short) 1);
//        itemEntity.put("Item", itemEntityStack);
//        entities.add(itemEntity);
//        levelTag.put("Entities", entities);
//        chunkTag.put("Level", levelTag);
//        CompoundTag newChunk = NbtHelper.update(TypeReferences.CHUNK, chunkTag);
//        System.out.println(((CompoundTag) newChunk.getCompoundTag("Level").getListTag("Entities").get(0)).getCompoundTag("Item").getString(STATION_ID));
        return super.use(arg, arg2, arg3);
    }

    @Override
    public String[] getTooltip(ItemStack stack, String originalTooltip) {
        return new String[] {
                originalTooltip,
                String.valueOf(stack.getStationNbt().getInt(of(NAMESPACE, "rand_num").toString()))
        };
    }
}
