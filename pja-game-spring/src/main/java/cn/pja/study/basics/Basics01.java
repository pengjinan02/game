package cn.pja.study.basics;

/**
 * java基础-01
 */
public class Basics01 {
    public static void main(String[] args) {
        test001();
    }

    /**
     * 1.Java数据类型
     *         基本数据类型：byte，short，int，long，float，double，char，boolean，
     *         枚举类型：枚举enum
     *         引用数据类型：类class，接口interface，数组array
     */
    public static void test001(){
        System.out.println("基本数据类型：");
        System.out.println("\t"+Byte.TYPE+"\t:"+"最大值("+Byte.MAX_VALUE+")\t最小值("+Byte.MIN_VALUE+")\t"+"bit("+Byte.SIZE+")\t占字节("+Byte.BYTES+")");
        System.out.println("\t"+Short.TYPE+"\t:"+"最大值("+Short.MAX_VALUE+")\t最小值("+Short.MIN_VALUE+")\t"+"bit("+Short.SIZE+")\t占字节("+Short.BYTES+")");
        System.out.println("\t"+Integer.TYPE+"\t\t:"+"最大值("+Integer.MAX_VALUE+")\t最小值("+Integer.MIN_VALUE+")\t"+"bit("+Integer.SIZE+")\t占字节("+Integer.BYTES+")");
        System.out.println("\t"+Long.TYPE+"\t:"+"最大值("+Long.MAX_VALUE+")\t最小值("+Long.MIN_VALUE+")\t"+"bit("+Long.SIZE+")\t占字节("+Long.BYTES+")");
        System.out.println("\t"+Float.TYPE+"\t:"+"最大值("+Float.MAX_VALUE+")\t最小值("+Float.MIN_VALUE+")\t"+"bit("+Float.SIZE+")\t占字节("+Float.BYTES+")");
        System.out.println("\t"+Double.TYPE+"\t:"+"最大值("+Double.MAX_VALUE+")\t最小值("+Double.MIN_VALUE+")\t"+"bit("+Double.SIZE+")\t占字节("+Double.BYTES+")");
        System.out.println("\t"+Character.TYPE+"\t:"+"最大值("+Character.MAX_VALUE+")\t最小值("+Character.MIN_VALUE+")\t"+"bit("+Character.SIZE+")\t占字节("+Character.BYTES+")");
        System.out.println("\t"+Boolean.TYPE+"\t:"+"最大值("+Boolean.TRUE+")\t最小值("+Boolean.FALSE+")");

        int b = 1200000000;
        System.out.println("内存溢出:"+(b + b));

        Integer a1=128,b1=127;
        Integer a2=128,b2=127;
        System.out.println("a1==a2 "+(a1==a2?"等于":"不等于"));
        System.out.println("b1==b2 "+(b1==b2?"等于":"不等于"));
        System.out.println("a1.equals(a2) "+(a1.equals(a2)?"等于":"不等于"));

        Integer.valueOf(128);
        Integer a3=new Integer(128),b3=new Integer(127);
        Integer a4=new Integer(128),b4=new Integer(127);
        System.out.println("a3==a4 "+(a3==a4?"等于":"不等于"));
        System.out.println("b3==b4 "+(b3==b4?"等于":"不等于"));

        System.out.println("左移运算：3<<3="+(3<<3));
        System.out.println("右移运算：8>>3="+(8>>3));

    }

}
