package pl.edu.pwr.lab1zimny.lab1;

/**
 * Created by KubaLaptop on 26.03.2017.
 */

public class CountBMIForLBIN implements ICountBMI {
        static final float MINIMAL_MASS = 22.07f;
        static final float MAXIMAL_MASS = 551.25f;
        static final float MINIMAL_HEIGHT = 19.69f;
        static final float MAXIMAL_HEIGHT = 98.43f;

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
                throw new IllegalArgumentException();
            } else {
                return mass / (height * height) * 703;
            }
        }
}
