package de.schloool.tutorialplugin.listeners;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.entity.LivingEntityInventoryChangeEvent;

public class InventoryChangeChatListener {
    public static void onInventoryChange(LivingEntityInventoryChangeEvent event) {
        if (event.getEntity() instanceof Player player) {
            player.sendMessage(Message.raw("Dein Inventar hat sich geändert!"));
        }
    }
}
