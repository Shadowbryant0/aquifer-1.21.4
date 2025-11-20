package net.shadow.aquifer.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.render.entity.state.ArrowEntityRenderState;
import net.minecraft.util.Identifier;
import net.shadow.aquifer.Aquifer;
import net.shadow.aquifer.entity.projectile.DragonsTear;

@Environment(EnvType.CLIENT)
public class ErrorzArrowRenderer extends ProjectileEntityRenderer<DragonsTear, ArrowEntityRenderState> {
    public static final Identifier TEXTURE = Identifier.of(Aquifer.MOD_ID, "textures/entity/projectiles/dragons_tear.png");
    public ErrorzArrowRenderer(EntityRendererFactory.Context context) {
        super(context);
    }
    @Override
    protected Identifier getTexture(ArrowEntityRenderState state) {
        return TEXTURE;
    }
    @Override
    public ArrowEntityRenderState createRenderState() {
        return new ArrowEntityRenderState();
    }

    @Override
    public void updateRenderState(DragonsTear entity, ArrowEntityRenderState state, float tickDelta) {
        super.updateRenderState(entity, state, tickDelta);
    }
}