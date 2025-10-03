package com.floofyplasma.stationapi.mixin.achievement;

import net.minecraft.achievement.Achievement;
import net.minecraft.achievement.Achievements;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.achievement.AchievementRegisterEvent;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Achievements.class)
class AchievementsMixin {
    @Shadow
    public static List<Achievement> ACHIEVEMENTS;

    @Inject(
            method = "<clinit>",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/achievement/Achievements;FLY_PIG:Lnet/minecraft/achievement/Achievement;",
                    opcode = Opcodes.PUTSTATIC,
                    shift = At.Shift.AFTER
            )
    )
    private static void stationapi_afterAchievementRegister(CallbackInfo ci) {
        StationAPI.EVENT_BUS.post(AchievementRegisterEvent.builder().achievements(ACHIEVEMENTS).build());
    }
}
