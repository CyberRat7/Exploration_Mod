package net.temporal.venturer.core.mixin;

import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.Zombie;
import net.temporal.venturer.common.object.entity.Coyote;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Zombie.class)
public class ZombieAvoidCoyoteMixin {
	
	@Inject(method = "registerGoals", at = @At("HEAD"))
	private void injected(CallbackInfo ci) {
		((Zombie)(Object)this).goalSelector.addGoal(3, new AvoidEntityGoal<>(((Zombie)(Object)this), Coyote.class, 6.0F, 1.0, 1.2));
	}
}
