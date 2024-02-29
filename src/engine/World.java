package engine;

import java.util.List;

public abstract class World {
    private List<Entity> entities;
    private int height;
    private int width;

    public World(List<Entity> entities, int height, int width) {
        this.entities = entities;
        this.height = height;
        this.width = width;
    }

    protected List<Entity> getEntities() {
        return entities;
    }

    protected int getHeight() {
        return height;
    }

    protected int getWidth() {
        return width;
    }

    public abstract void tick();
}
