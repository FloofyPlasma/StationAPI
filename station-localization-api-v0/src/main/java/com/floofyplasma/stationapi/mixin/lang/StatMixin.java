package com.floofyplasma.stationapi.mixin.lang;

import net.mine_diver.unsafeevents.listener.Listener;
import net.minecraft.stat.Stat;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.resource.language.TranslationInvalidationEvent;
import com.floofyplasma.stationapi.impl.resource.language.DeferredTranslationKeyHolder;
import org.spongepowered.asm.mixin.*;

import java.util.function.Supplier;

@Mixin(Stat.class)
class StatMixin implements DeferredTranslationKeyHolder {
    @Mutable
    @Shadow @Final public String stringId;

    @Override
    @Unique
    public void stationapi_initTranslationKey(Supplier<String> translator) {
        StationAPI.EVENT_BUS.register(
                Listener.<TranslationInvalidationEvent>simple()
                        .phase(StationAPI.INTERNAL_PHASE)
                        .listener(event -> stringId = translator.get())
                        .build()
        );
    }
}
