package net.shadow.aquifer.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(LivingEntity.class)
public abstract class AntiRespiration{
    @Shadow
    public abstract Map<RegistryEntry<StatusEffect>, StatusEffectInstance> getActiveStatusEffects();

    @Shadow
    public abstract boolean hasStatusEffect(RegistryEntry<StatusEffect> effect);

    @Inject(at = @At(value = "RETURN", target = "Lnet/minecraft/entity/LivingEntity;getNextAirUnderwater(I)I"), method = "getNextAirUnderwater", cancellable = true)
    public void init(int air, CallbackInfoReturnable<Integer> cir) {
        if(this.hasStatusEffect(StatusEffects.LEVITATION)){
            cir.setReturnValue(air-1);
        }
        else {
            cir.cancel();
        }
    }



//    @WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getNextAirUnderwater(I)I"), method = "baseTick")
//    public int init(LivingEntity instance, int air, Operation<Integer> original) {
//        if(this.hasStatusEffect(StatusEffects.LEVITATION)){
//            return original.call(instance, air-1);
//        }
//        return original.call(instance, air);
//    }

}