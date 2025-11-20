package net.shadow.aquifer.items.weapons;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.item.consume.UseAction;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.shadow.aquifer.components.AquiferDataComponentsType;
import net.shadow.aquifer.entity.projectile.DragonsTear;
import net.shadow.aquifer.util.UuidCheck;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class DragonsEye extends BowItem {
    public static final int TICKS_PER_SECOND = 20;
    public static final int RANGE = 15;
    private static final String CHARGE_KEY = "charge";
    private static final int MAX_CHARGE = 100;
    public DragonsEye(Settings settings) {
        super(settings);
    }
    @Override
    public boolean onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!(user instanceof PlayerEntity player)) return false;

        ItemStack arrows = player.getProjectileType(stack);
        if (arrows.isEmpty() && !player.isCreative() && !UuidCheck.isUUID(player)) {
            return false;
        }

//        if(UuidCheck.isUUID(player)){
//            return false;
//        }
        int usedTicks = this.getMaxUseTime(stack, user) - remainingUseTicks;
        float pull = getPullProgress(usedTicks);
        if (pull < 0.1F) return false;
        if (!world.isClient) {
            DragonsTear arrow = new DragonsTear(world, player);
            arrow.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, pull * 3.0F, 1.0F);
            if (pull == 1.0F) {
                arrow.setCritical(true);
            }
            world.spawnEntity(arrow);
            if (!player.isCreative() && !UuidCheck.isUUID(player)) {
                arrows.decrement(1);
            }
        }
        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (world.getRandom().nextFloat() * 0.4F + 1.2F) + pull * 0.5F);
        player.incrementStat(Stats.USED.getOrCreateStat(this));
        return true;
    }
    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }
    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return ActionResult.CONSUME;
    }
    public static float getPullProgress(int ticks) {
        float f = ticks / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        return Math.min(f, 1.0F);
    }
    public Predicate<ItemStack> getProjectiles() {
        return BOW_PROJECTILES;
    }
    @Override
    public int getRange() {
        return 15;
    }
    @Override
    protected void shoot(LivingEntity shooter, ProjectileEntity projectile, int index, float speed, float divergence, float yaw, @Nullable LivingEntity target) {
        projectile.setVelocity(shooter, shooter.getPitch(), shooter.getYaw() + yaw, 0.0F, speed, divergence);
    }
//:0 you are so much better at helping then dino, his code didnt work once he handed it over :/
}
