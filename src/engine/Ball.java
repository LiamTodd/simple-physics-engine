package engine;

public class Ball extends Entity {
    public Ball(Vector position, Vector velocity, Vector acceleration, float mass) {
        super(position, velocity, acceleration, mass);
    }

    @Override
    public boolean isSharp() {
        return false;
    }

    @Override
    public boolean canPop() {
        return true;
    }

    @Override
    public String noiseOnContact() {
        return "boing!";
    }
}
