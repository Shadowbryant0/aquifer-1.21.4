package net.shadow.aquifer.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class HasSuffocation {
    public static boolean Suff(LivingEntity entity) {
        return entity.hasStatusEffect(StatusEffects.LEVITATION);
    }
}
