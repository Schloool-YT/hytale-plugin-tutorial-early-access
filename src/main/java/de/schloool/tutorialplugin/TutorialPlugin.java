package de.schloool.tutorialplugin;

import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
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
