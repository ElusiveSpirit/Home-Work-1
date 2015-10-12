


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import adv.android_11.solleks.homework1.IntInText;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestIntToText {

    private String mText;
    private int mNumber;

    public TestIntToText(String text, int number) {
        this.mText = text;
        this.mNumber = number;
    }

    @Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                        {" один", 1},
                        {" два", 2},
                        {" одиннадцать", 11},
                        {" двадцать один", 21},
                        {" сто три", 103},
                        {" двести тридцать два", 232},
                        {" пятьсот одиннадцать", 511},
                        {" сто двадцать один", 121},
                        {" тысяча", 1000},
                }
        );
    }

    @Test
    public void testConvert() {
        assertEquals(mText, IntInText.convert(mNumber));
    }

}
