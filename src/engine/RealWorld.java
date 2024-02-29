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

            verticalBounce(entity);
            horizontalBounce(entity);

        }

    }

    private void verticalBounce(Entity entity) {
//                    check if entity hit the floor or ceiling
        if (entity.getPosition().getY() <= 0 || entity.getPosition().getY() >= this.getHeight()) {
//                reverse y-velocity
//                todo: add in energy loss
            entity.setVelocity(new Vector(entity.getVelocity().getX(), -entity.getVelocity().getY()));
        }
    }

    private void horizontalBounce(Entity entity) {
//                    check if entity hit either side
        if (entity.getPosition().getX() <= 0 || entity.getPosition().getX() >= this.getWidth()) {
//                reverse x-velocity
//                todo: add in energy loss
            entity.setVelocity(new Vector(-entity.getVelocity().getX(), entity.getVelocity().getY()));
        }
    }
}
