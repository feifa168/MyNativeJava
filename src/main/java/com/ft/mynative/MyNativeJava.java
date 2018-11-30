package com.ft.mynative;

public class MyNativeJava {
    static {
        System.loadLibrary("libMyNativeJava");
    }

    private int num = 5;
    private char[] ca = {5, 3};
    private String str = "tom";
    private String[] strA = {"one", "two"};

    private static int snum = 5;
    private static char[] sca = {5, 3};
    private static String sstr = "bruce";
    private static String[] sstrA = {"Monday", "Tuesty"};

    private void testInt(int a) {
        System.out.println("testInt(int " + a + ")");
    }
    private void testString(String s) {
        System.out.println("testString(String " + s + ")");
    }

    private static void stestInt(int a) {
        System.out.println("testInt(int " + a + ")");
    }
    private static void stestString(String s) {
        System.out.println("testString(String " + s + ")");
    }

    private native void fun();
    private native int fun2(String s);
    private native void fun3(Integer[] ia);

    private native boolean baseTypes(int intA, char charB, boolean boolC, short shortD, long longE, float floatF, double doubleG, byte byteH);
    private native Boolean wrapBaseTypes(Integer intA, Character charB, Boolean boolC6, Short shortD, Long longE, Float floatF, Double doubleG, Byte byteH);
    private native boolean[] intArray(int[] iarr);
    private native Boolean[] wrapIntArray(Integer[] iarr);
    private native String stringTest(String s);
    private native String[] strArrTest(String[] sa);
    private native void modifyFields();
    private native void testMethod();

    public static void main(String[] args) {
        MyNativeJava nativeJava = new MyNativeJava();
//        nativeJava.fun();
//        System.out.println(nativeJava.fun2("hello, tom"));
//        nativeJava.fun3(new Integer[]{3, 5});

        nativeJava.baseTypes(4, 'a', true, (short)8, 100, 1.5f, 2.79, (byte)57);
        new Integer(5).intValue();
        new Boolean(false).booleanValue();
        new Short((short)4).shortValue();
        new Long((long)6).longValue();
        new Character('a').charValue();
        new Float(5.0f).floatValue();
        new Double(5.9).doubleValue();
        new Byte((byte)5).byteValue();
        Boolean.valueOf(false);
        Boolean b = nativeJava.wrapBaseTypes(Integer.valueOf(5), Character.valueOf('a'), Boolean.valueOf(true),
                Short.valueOf((short)6), Long.valueOf((long)800), Float.valueOf(1.2f), Double.valueOf(3.4), Byte.valueOf((byte)'a'));
        System.out.println(b);

        int ia[] = {1, 2, 3, 4, 5, 6};
        boolean[] ba = nativeJava.intArray(ia);
        for (int i=0; i<ba.length; i++) {
            System.out.println("num is " + ia[i] + ", &1=" + ba[i]);
        }
    }
}