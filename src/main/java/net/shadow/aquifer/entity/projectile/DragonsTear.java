package net.shadow.aquifer.entity.projectile;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.shadow.aquifer.entity.AquiferEntities;
import org.jetbrains.annotations.Nullable;

public class DragonsTear extends ArrowEntity {

    public DragonsTear (EntityType<? extends DragonsTear> entityType, World world) {
        super(entityType, world);
    }

// :0 woahs
    public DragonsTear (World world, LivingEntity owner) {
        super(AquiferEntities.TEAR, world);
        this.setOwner(owner);
        this.setPosition(owner.getX(), owner.getEyeY() - 0.1, owner.getZ());
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient) {
            this.getWorld().addParticle(ParticleTypes.BUBBLE, this.getX(), this.getY(), this.getZ(), 0, 0, 0);
        }

    }
    @Override
    protected void onEntityHit(EntityHitResult hitResult) {
        super.onEntityHit(hitResult);
    }
    @Override
    protected void onBlockHit(BlockHitResult hitResult) {
        super.onBlockHit(hitResult);
        this.discard();
    }
    protected float getDragInRainOrWater(){
        return 1F;
    }
    protected Boolean SeaProjectile(){
        return true;
    }
    @Override
    protected float getDragInWater() {
        return 1F;
    }
    @Override
    protected void onHit(LivingEntity target) {
        super.onHit(target);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(Items.ARROW);
    }
}

