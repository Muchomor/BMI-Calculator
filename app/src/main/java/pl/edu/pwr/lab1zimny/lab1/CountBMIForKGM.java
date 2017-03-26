package pl.edu.pwr.lab1zimny.lab1;

/**
 * Created by KubaLaptop on 15.03.2017.
 */

public class CountBMIForKGM implements ICountBMI {
    static final float MINIMAL_MASS = 10.0f;
    static final float MAXIMAL_MASS = 250.0f;
    static final float MINIMAL_HEIGHT = 0.5f;
    static final float MAXIMAL_HEIGHT = 2.5f;

    @Override
    public boolean isMassValid(float mass) {
        return (mass>=MINIMAL_MASS && mass<=MAXIMAL_MASS);
    }

    @Override
    public boolean isHeightValid(float height) {
        return (height>=MINIMAL_HEIGHT && height<=MAXIMAL_HEIGHT);
    }

    @Override
    public float calculateBMI(float mass, float height) {
        if (!isHeightValid(height) || !isMassValid(mass)) {
            throw new IllegalArgumentException("upsi");
        } else {
            return mass / (height * height);
        }
    }
}
