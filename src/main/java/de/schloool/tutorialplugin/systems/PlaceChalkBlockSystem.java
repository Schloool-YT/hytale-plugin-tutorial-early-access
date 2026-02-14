package de.schloool.tutorialplugin.systems;

import com.hypixel.hytale.component.Archetype;
import com.hypixel.hytale.component.ArchetypeChunk;
import com.hypixel.hytale.component.CommandBuffer;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.component.query.Query;
import com.hypixel.hytale.component.system.EntityEventSystem;
import com.hypixel.hytale.math.vector.Vector3i;
import com.hypixel.hytale.server.core.event.events.ecs.PlaceBlockEvent;
import com.hypixel.hytale.server.core.universe.Universe;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class PlaceChalkBlockSystem extends EntityEventSystem<EntityStore, PlaceBlockEvent> {
    public PlaceChalkBlockSystem() {
        super(PlaceBlockEvent.class);
    }

    @Override
    public void handle(int i, @NonNullDecl ArchetypeChunk<EntityStore> archetypeChunk, @NonNullDecl Store<EntityStore> store, @NonNullDecl CommandBuffer<EntityStore> commandBuffer, @NonNullDecl PlaceBlockEvent placeBlockEvent) {
        if (placeBlockEvent.getItemInHand().getBlockKey().equals("Rock_Chalk")) {
            placeBlockEvent.setCancelled(true);
            Vector3i pos = placeBlockEvent.getTargetBlock();
            Universe.get().getDefaultWorld().setBlock(pos.x, pos.y, pos.z, "Rock_Aqua");
        }
    }

    @NullableDecl
    @Override
    public Query<EntityStore> getQuery() {
        return Archetype.empty();
    }
}
