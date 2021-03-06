package com.teamaurora.frostburn_expansion.core.event;

import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import com.teamaurora.frostburn_expansion.core.registry.FrostburnExpansionEffects;

import net.minecraft.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=FrostburnExpansion.MODID)
public class EventHandler {
	@SubscribeEvent
	public static void onEntityHurt(LivingHurtEvent event) {
		if (event.getEntity() instanceof LivingEntity) {
			LivingEntity entity = event.getEntityLiving();
			if (entity.isPotionActive(FrostburnExpansionEffects.FRAILTY.get())) {
				int lv = entity.getActivePotionEffect(FrostburnExpansionEffects.FRAILTY.get()).getAmplifier();
				float fulldamage = event.getAmount() * ((lv*0.2F));
				event.setAmount(event.getAmount()+fulldamage);
			}
		}
	}

}
