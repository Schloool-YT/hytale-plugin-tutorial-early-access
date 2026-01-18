package de.schloool.tutorialplugin.commands;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.math.vector.Vector3d;
import com.hypixel.hytale.protocol.ChangeVelocityType;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.CommandSender;
import com.hypixel.hytale.server.core.command.system.arguments.system.RequiredArg;
import com.hypixel.hytale.server.core.command.system.arguments.types.ArgTypes;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.modules.physics.component.Velocity;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class JumpCommand extends AbstractPlayerCommand {
    public JumpCommand() {
        super("jump", "Katapultiert dich in die Luft");
    }

    RequiredArg<Integer> arg = withRequiredArg("force", "Sprungkraft", ArgTypes.INTEGER);

    @Override
    protected void execute(@NonNullDecl CommandContext commandContext, @NonNullDecl Store<EntityStore> store, @NonNullDecl Ref<EntityStore> ref, @NonNullDecl PlayerRef playerRef, @NonNullDecl World world) {
        Velocity velocity = store.getComponent(ref, Velocity.getComponentType());
        velocity.addInstruction(new Vector3d(0, arg.get(commandContext), 0), null, ChangeVelocityType.Set);
        store.replaceComponent(ref, Velocity.getComponentType(), velocity);
    }

//    @Override
//    public boolean hasPermission(@NonNullDecl CommandSender sender) {
//        return true;
//    }

    @NullableDecl
    @Override
    public String getPermission() {
        return "tutorialplugin.jump";
    }
}
