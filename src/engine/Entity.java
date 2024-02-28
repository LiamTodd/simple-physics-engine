package engine;

public abstract class Entity {
    private Vector position;
    private Vector velocity;
    private Vector acceleration;
    private float mass;
    private Vector momentum;

    public Entity(Vector position, Vector velocity, Vector acceleration, float mass) {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.mass = mass;
        this.momentum = new Vector(this.velocity.getX() * this.mass, this.velocity.getY() * this.mass);
    }

    public abstract boolean isSharp();

    public abstract boolean canPop();

    public abstract String noiseOnContact();

    public Vector getMomentum() {
        return momentum;
    }

    public void setMomentum(Vector momentum) {
        this.momentum = momentum;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public Vector getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector acceleration) {
        this.acceleration = acceleration;
    }
}
