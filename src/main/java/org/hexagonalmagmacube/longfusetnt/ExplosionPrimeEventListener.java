package org.hexagonalmagmacube.longfusetnt;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class ExplosionPrimeEventListener implements Listener {

    private final Random rand = new Random();

    @EventHandler
    public void onEvent(ExplosionPrimeEvent event) {
        Entity original = event.getEntity();
        if (rand.nextInt(15) == 0) {
            Bukkit.getLogger().info(original.getEntityId() + " will explode now.");
            return;
        }
        event.setCancelled(true);

        TNTPrimed newTNT = original.getWorld().spawn(original.getLocation(), TNTPrimed.class);
        newTNT.setFuseTicks(100);
        original.remove();

        Bukkit.getLogger().info(original.getEntityId() + " was replaced by " + newTNT.getEntityId());
        return;
    }
}
