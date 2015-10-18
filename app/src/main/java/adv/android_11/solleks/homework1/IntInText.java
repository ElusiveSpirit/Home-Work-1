package adv.android_11.solleks.homework1;

import java.lang.reflect.Field;

import android.app.Activity;
import android.content.res.Resources;

public class IntInText {

    public static Activity activity;

    public static String convert(int x){
        String  no = String.valueOf(x),
                res = "";
        Field field;
        try{
            Class pickClass = R.string.class;

            if (x == 0) {
                return Resources.getSystem().getString(R.string.x);
            } else {
                int thisNumber,
                    index = (int)Math.pow(10, no.length() - 1);
                while (index > 0) {
                    switch (thisNumber = x / index) {
                        case 0 :
                            x %= index;
                            index /= 10;
                            continue;
                        case 1 :
                            if (index == 10 && (x / (index + 1) != 0)) {
                                // TODO Найти способ вызова ресурсов
                                field = pickClass.getField("x" + (x % 100));
                                res += " " + activity.getResources().getString(R.string.app_name);

                                index = 0;
                                continue;
                            }
                    }
                    field = pickClass.getField("x" + thisNumber * index);
                    res += " " + Resources.getSystem().getString((int)field.get(pickClass));
                    x %= index;
                    index /= 10;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return res;
    }
}