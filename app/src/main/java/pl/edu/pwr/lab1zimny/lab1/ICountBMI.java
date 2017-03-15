package pl.edu.pwr.lab1zimny.lab1;

/**
 * Created by KubaLaptop on 15.03.2017.
 */

public interface ICountBMI {

    public boolean isMassValid(float mass);

    public boolean isHeightValid(float height);

    public float calculateBMI(float mass, float height);
}
