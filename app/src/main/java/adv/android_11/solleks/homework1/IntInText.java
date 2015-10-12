package adv.android_11.solleks.homework1;

import java.lang.reflect.Field;

public class IntInText {
    public final static String x="ноль";

    public final static String x1="один";
    public final static String xx1="одна";

    public final static String x2="два";
    public final static String xx2="две";


    public final static String x3="три";
    public final static String x4="четыре";
    public final static String x5="пять";
    public final static String x6="шесть";
    public final static String x7="семь";
    public final static String x8="восемь";
    public final static String x9="девять";
    public final static String x10="десять";

    public final static String x11="одиннадцать";
    public final static String x12="двенадцать";
    public final static String x13="тринадцать";
    public final static String x14="четырнадцать";
    public final static String x15="пятнадцать";
    public final static String x16="шестнадцать";
    public final static String x17="семнадцать";
    public final static String x18="восемнадцать";
    public final static String x19="девятнадцать";

    public final static String x20="двадцать";
    public final static String x30="тридцать";
    public final static String x40="сорок";
    public final static String x50="пятьдесят";
    public final static String x60="шесдесят";
    public final static String x70="семдесят";
    public final static String x80="восемдесят";
    public final static String x90="девяноста";

    public final static String x100="сто";
    public final static String x200="двести";
    public final static String x300="триста";
    public final static String x400="четыреста";
    public final static String x500="пятьсот";
    public final static String x600="шестьсот";
    public final static String x700="семьсот";
    public final static String x800="восемьсот";
    public final static String x900="девятьсот";

    public final static String x1000="тысяча";
    public final static String xx1000="тысячи";
    public final static String xхx1000="тысяч";



    public static String convert(int x){
        String no=String.valueOf(x);
        String res="";
        Field fild;
        try{
            Class clas = IntInText.class;

            if(x > 999){
                fild = IntInText.class.getField("x"+no.charAt(no.length() - 4)+"000");
                res+=" "+fild.get(clas).toString();
                x = x % 1000;
                no = String.valueOf(x);
            }
            if(x>99){
                fild = IntInText.class.getField("x"+no.charAt(no.length()-3)+"00");
                res+=" "+fild.get(clas).toString()+res;
                x = x % 100;
                no = String.valueOf(x);
            }
            if(x>19) {
                    fild = IntInText.class.getField("x" + no.charAt(no.length() - 2) + "0");
                    res += " " + fild.get(clas).toString();
            }
            if(no.length()-2>-1 && no.charAt(no.length()-2)=='1'){
                fild = IntInText.class.getField("x1"+no.charAt(no.length()-1));
                res+=" "+fild.get(clas).toString();
            } else if(no.charAt(no.length()-1)!='0'){
                fild = IntInText.class.getField("x"+no.charAt(no.length()-1));
                res+=" "+fild.get(clas).toString();
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return res;
    }
}