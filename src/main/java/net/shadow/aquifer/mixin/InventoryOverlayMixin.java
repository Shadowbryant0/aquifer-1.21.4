package net.shadow.aquifer.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.shadow.aquifer.Aquifer;
import net.shadow.aquifer.util.UuidCheck;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;

import java.util.function.Function;

@Mixin(InGameHud.class)
public abstract class InventoryOverlayMixin {


    @Unique
    private static final Identifier CORALBAR = Identifier.of(Aquifer.MOD_ID, "hud/coralbar");
    @Unique
    private static final Identifier DRAGONSELECT = Identifier.of(Aquifer.MOD_ID, "hud/dragonselector");
    @Unique
    private static final Identifier CORALBOFFLEFT = Identifier.of(Aquifer.MOD_ID, "hud/coraloffhandleft");
    @Unique
    private static final Identifier CORALBOFFRIGHT = Identifier.of(Aquifer.MOD_ID, "hud/coraloffhandright");
    @Shadow
    @Nullable
    protected abstract PlayerEntity getCameraPlayer();

    @Shadow
    protected abstract void renderHotbar(DrawContext context, RenderTickCounter tickCounter);


    @WrapOperation(at = @At(ordinal = 0, value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawGuiTexture(Ljava/util/function/Function;Lnet/minecraft/util/Identifier;IIII)V"), method = "renderHotbar")
    private void HOTBAROVERIDE(DrawContext instance, Function<Identifier, RenderLayer> renderLayers, Identifier sprite, int x, int y, int width, int height, Operation<Void> original) {
        PlayerEntity player = this.getCameraPlayer();
        if(player != null){

            int i = instance.getScaledWindowWidth() / 2;
            if(UuidCheck.isUUID(player)){
                original.call(instance, renderLayers, CORALBAR, x, y, width, height);}
            else {
                original.call(instance, renderLayers, sprite, x, y, width, height);
            }

        }
    }
    @WrapOperation(at = @At(ordinal = 1, value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawGuiTexture(Ljava/util/function/Function;Lnet/minecraft/util/Identifier;IIII)V"), method = "renderHotbar")
    private void SELECTOROVERIDE(DrawContext instance, Function<Identifier, RenderLayer> renderLayers, Identifier sprite, int x, int y, int width, int height, Operation<Void> original) {
        PlayerEntity player = this.getCameraPlayer();
        if(player != null){

            int i = instance.getScaledWindowWidth() / 2;
            if(UuidCheck.isUUID(player)){
                original.call(instance, renderLayers, DRAGONSELECT, x, y, width, height);}
            else {
                original.call(instance, renderLayers, sprite, x, y, width, height);
            }

        }
    }
    @WrapOperation(at = @At(ordinal = 2, value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawGuiTexture(Ljava/util/function/Function;Lnet/minecraft/util/Identifier;IIII)V"), method = "renderHotbar")
    private void OFFHANDLEFTOVERRIDE(DrawContext instance, Function<Identifier, RenderLayer> renderLayers, Identifier sprite, int x, int y, int width, int height, Operation<Void> original) {
        PlayerEntity player = this.getCameraPlayer();
        if(player != null){

            int i = instance.getScaledWindowWidth() / 2;
            if(UuidCheck.isUUID(player)){
                original.call(instance, renderLayers, CORALBOFFLEFT, x, y, width, height);}
            else {
                original.call(instance, renderLayers, sprite, x, y, width, height);
            }

        }
    }
    @WrapOperation(at = @At(ordinal = 3, value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawGuiTexture(Ljava/util/function/Function;Lnet/minecraft/util/Identifier;IIII)V"), method = "renderHotbar")
    private void OFFHANDRIGHTOVERRIDE(DrawContext instance, Function<Identifier, RenderLayer> renderLayers, Identifier sprite, int x, int y, int width, int height, Operation<Void> original) {
        PlayerEntity player = this.getCameraPlayer();
        if(player != null){

            int i = instance.getScaledWindowWidth() / 2;
            if(UuidCheck.isUUID(player)){
                original.call(instance, renderLayers, CORALBOFFRIGHT, x, y, width, height);}
            else {
                original.call(instance, renderLayers, sprite, x, y, width, height);
            }

        }
    }
}