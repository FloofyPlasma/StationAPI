package com.floofyplasma.stationapi.impl.vanillafix.client.gui.screen;

import com.mojang.serialization.Dynamic;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.nbt.NbtCompound;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.client.event.gui.screen.EditWorldScreenEvent;
import com.floofyplasma.stationapi.api.client.gui.widget.ButtonWidgetDetachedContext;
import com.floofyplasma.stationapi.api.datafixer.DataFixers;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;
import com.floofyplasma.stationapi.api.nbt.NbtHelper;
import com.floofyplasma.stationapi.api.nbt.NbtOps;
import com.floofyplasma.stationapi.impl.vanillafix.datafixer.VanillaDataFixerImpl;
import com.floofyplasma.stationapi.impl.world.storage.FlattenedWorldStorage;
import com.floofyplasma.stationapi.mixin.vanillafix.client.ScreenAccessor;

import java.lang.invoke.MethodHandles;

import static net.mine_diver.unsafeevents.listener.ListenerPriority.LOW;
import static com.floofyplasma.stationapi.api.StationAPI.NAMESPACE;

@Environment(EnvType.CLIENT)
@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
@EventListener(phase = StationAPI.INTERNAL_PHASE)
public final class EditWorldScreenImpl {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    private static final String
            ROOT_KEY = "selectWorld." + NAMESPACE,
            CONVERT_TO_MCREGION_KEY = ROOT_KEY + ".convertToMcRegion";

    @EventListener(priority = LOW)
    private static void registerConversionButton(EditWorldScreenEvent.ScrollableButtonContextRegister event) {
        event.contexts.add(screen -> new ButtonWidgetDetachedContext(
                id -> {
                    ButtonWidget button = new ButtonWidget(id, 0, 0, I18n.getTranslation(CONVERT_TO_MCREGION_KEY));
                    button.active = NbtHelper.getDataVersions(((FlattenedWorldStorage) ((ScreenAccessor) screen).getMinecraft().method_2127()).getWorldTag(screen.worldData.method_1956())).contains(NAMESPACE.toString());
                    return button;
                },
                button -> ((ScreenAccessor) screen).getMinecraft().setScreen(new WarningScreen(screen, () -> {
                    Minecraft mc = ((ScreenAccessor) screen).getMinecraft();
                    mc.setScreen(null);
                    FlattenedWorldStorage worldStorage = (FlattenedWorldStorage) mc.method_2127();
                    mc.field_2817.method_1491("Converting World to " + worldStorage.getPreviousWorldFormat());
                    mc.field_2817.method_1796("This may take a while :)");
                    worldStorage.convertWorld(screen.worldData.method_1956(), (type, compound) -> (NbtCompound) VanillaDataFixerImpl.DATA_DAMAGER.get().update(type, new Dynamic<>(NbtOps.INSTANCE, compound).remove(DataFixers.DATA_VERSIONS), VanillaDataFixerImpl.HIGHEST_VERSION - NbtHelper.getDataVersions(compound).getInt(NAMESPACE.toString()), VanillaDataFixerImpl.VANILLA_VERSION).getValue(), mc.field_2817);
                    mc.setScreen(screen);
                }, WorldConversionWarning.TO_MCREGION_EXPLANATION_KEY, WorldConversionWarning.CONVERT_KEY))
        ));
    }
}
