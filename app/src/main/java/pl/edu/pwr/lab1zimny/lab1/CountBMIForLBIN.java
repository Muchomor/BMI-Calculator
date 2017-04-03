package pl.edu.pwr.lab1zimny.lab1;

/**
 * Created by KubaLaptop on 26.03.2017.
 */

public class CountBMIForLBIN implements ICountBMI {
        static final float METERS_TO_INCHES_RATIO = 2.204f;
        static final float KILOGRAMS_TO_POUNDS_RATIO = 39.37f;
        static final float MINIMAL_MASS = CountBMIForKGM.getMinimalMass() * METERS_TO_INCHES_RATIO;
        static final float MAXIMAL_MASS = CountBMIForKGM.getMaximalMass() * METERS_TO_INCHES_RATIO;
        static final float MINIMAL_HEIGHT = CountBMIForKGM.getMinimalHeight() * KILOGRAMS_TO_POUNDS_RATIO;
        static final float MAXIMAL_HEIGHT = CountBMIForKGM.getMaximalHeight() * KILOGRAMS_TO_POUNDS_RATIO;


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
