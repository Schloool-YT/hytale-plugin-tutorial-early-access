package de.schloool.tutorialplugin;

import com.hypixel.hytale.server.core.event.events.entity.LivingEntityInventoryChangeEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import de.schloool.tutorialplugin.commands.JumpCommand;
import de.schloool.tutorialplugin.commands.TestCommand;
import de.schloool.tutorialplugin.listeners.InventoryChangeChatListener;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class TutorialPlugin extends JavaPlugin {
    public TutorialPlugin(@NonNullDecl JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        super.setup();
        getLogger().atInfo().log("Tutorial-Plugin durchläuft setup...");
        getLogger().atInfo().log("Mal sehen, wie lange das dauert...");

        getCommandRegistry().registerCommand(new TestCommand());
        getCommandRegistry().registerCommand(new JumpCommand());

        getEventRegistry().registerGlobal(LivingEntityInventoryChangeEvent.class, InventoryChangeChatListener::onInventoryChange);
    }

    @Override
    protected void start() {
        super.start();
        getLogger().atInfo().log("Tutorial-Plugin durchläuft start...");
        getLogger().atWarning().log("Das Plugin befindet sich noch in Entwicklung!");
    }

    @Override
    protected void shutdown() {
        super.shutdown();
        getLogger().atInfo().log("Tutorial-Plugin wurde beendet.");
    }
}
