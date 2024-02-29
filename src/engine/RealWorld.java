package engine;

import java.util.List;

public class RealWorld extends World {
    private static final Vector GRAVITATIONAL_ACCELERATION = new Vector(0, -9.8);
    private static final int TIME_DELTA = 1;

    public RealWorld(List<Entity> entities, int height, int width) {
        super(entities, height, width);
    }

    @Override
    public void tick() {

        Vector position;
        Vector velocity;
        Vector acceleration;

        for (Entity entity : this.getEntities()) {
            position = entity.getPosition();
            velocity = entity.getVelocity();
            acceleration = entity.getAcceleration();
//            update position: x = x+v_x*t, y=y+v_y*t, t=1
            entity.setPosition(VectorUtils.add(position, velocity));
//            update velocity: v_x = u_x+a_x*t, y_x = u_y+a_y*t, t=1
            entity.setVelocity(VectorUtils.add(velocity, acceleration));
//            update acceleration: todo


//            bouncing off world boundaries
            handleBoundaryCollisions(entity);

//            collisions
            handleEntityCollisions(entity);

        }

    }

    private void handleEntityCollisions(Entity entity) {
//        todo
    }

    private void handleBoundaryCollisions(Entity entity) {
        this.verticalBounce(entity);
        this.horizontalBounce(entity);
    }

    private void verticalBounce(Entity entity) {
//        todo: energy loss
        double x = entity.getPosition().getX();
        double y = entity.getPosition().getY();
        double vX = entity.getVelocity().getX();
        double vY = entity.getVelocity().getY();
//        entity hit floor
        if (y < 0) {
            entity.setPosition(new Vector(x, 0));
            entity.setVelocity(new Vector(vX, -vY));
        }
//        entity hit ceiling
        else if (y > this.getHeight()) {
            entity.setPosition(new Vector(x, this.getHeight()));
            entity.setVelocity(new Vector(vX, -vY));
        }
    }

    private void horizontalBounce(Entity entity) {
//        todo: energy loss
        double x = entity.getPosition().getX();
        double y = entity.getPosition().getY();
        double vX = entity.getVelocity().getX();
        double vY = entity.getVelocity().getY();
//        entity hit left wall
        if (x < 0) {
            entity.setPosition(new Vector(0, y));
            entity.setVelocity(new Vector(-vX, vY));
        }
//        entity hit right wall
        else if (x > this.getWidth()) {
            entity.setPosition(new Vector(this.getWidth(), y));
            entity.setVelocity(new Vector(-vX, vY));
        }
    }
}
