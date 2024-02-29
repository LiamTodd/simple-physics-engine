package engine;

public class VectorUtils {

    public static Vector add(Vector v, Vector u) {
        return new Vector(v.getX() + u.getX(), v.getY() + u.getY());
    }
}
