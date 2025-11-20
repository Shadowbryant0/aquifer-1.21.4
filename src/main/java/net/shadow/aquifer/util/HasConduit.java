package net.shadow.aquifer.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;

public class HasConduit {
    public static boolean Conduit(LivingEntity entity) {
        return entity.hasStatusEffect(StatusEffects.CONDUIT_POWER);
    }
}
