package pl.edu.pwr.lab1zimny.lab1;

import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by KubaLaptop on 15.03.2017.
 */

public class CountBMITest {
    @Test
    public void massUnderZeroIsInvalid(){
        //given
        float mass=-5.0f;

        //when
        CountBMIForKGM c = new CountBMIForKGM();
        boolean bool = c.isMassValid(mass);
        //then

        assertFalse(bool);
    }

    @Test
    public void heightUnderHalfIsInvalid(){
        //given
        float height = 0.4f;

        //when
        CountBMIForKGM c = new CountBMIForKGM();
        boolean bool = c.isHeightValid(height);

        //then
        assertFalse(bool);

    }

    @Test
    public void BMITest(){
        //given
        float height = 1.8f;
        float mass = 75.0f;

        //when
        CountBMIForKGM c = new CountBMIForKGM();
        float res = c.calculateBMI(mass, height);

        //then
        assertEquals(23.15, res, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException(){
        //given
        float height = 1.8f;
        float mass = 500.0f;

        //when
        CountBMIForKGM c = new CountBMIForKGM();
        float res = c.calculateBMI(mass, height);

        //then

    }
}
