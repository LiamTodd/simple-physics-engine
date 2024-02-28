package engine;

import java.util.List;

public abstract class World {
    private List<Entity> entities;

    public World(List<Entity> entities) {
        this.entities = entities;
    }

    public abstract void tick();
}
