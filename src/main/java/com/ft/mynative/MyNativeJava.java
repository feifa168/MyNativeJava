package com.ft.mynative;

import org.junit.Test;

public class MyNativeJava {
    static {
        System.loadLibrary("libMyNativeJava");
    }

    private int num = 5;
    private char[] ca = new char[]{'a', 'b'};
    private String str = "tom";
    private String[] strA = {"one", "two"};

    private static int snum = 5;
    private static char[] sca = new char[]{'a', 'b'};
    private static String sstr = "bruce";
    private static String[] sstrA = {"Monday", "Tuesty"};

    @Test
    public void test1243() {
        this.testInt(5);
    }
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

        // test int, short, byte, long, float, double, char
        nativeJava.baseTypes(4, 'a', true, (short)8, 100, 1.5f, 2.79, (byte)57);

        // test Integer, Short, Long, Float, Double, Byte, Boolean, Character
        Boolean b = nativeJava.wrapBaseTypes(Integer.valueOf(5), Character.valueOf('a'), Boolean.valueOf(true),
                Short.valueOf((short)6), Long.valueOf((long)800), Float.valueOf(1.2f), Double.valueOf(3.4), Byte.valueOf((byte)'a'));
        System.out.println(b);

        // test int[]
        int ia[] = {1, 2, 3, 4, 5, 6};
        boolean[] ba = nativeJava.intArray(ia);
        for (int i=0; i<ba.length; i++) {
            System.out.println("num is " + ia[i] + ", &1=" + ba[i]);
        }

        // test Integer[]
        Integer[] integerA  = {1, 2, 3, 4, 5, 6};
        Boolean[] boolA     = nativeJava.wrapIntArray(integerA);
        for (int i=0; i<boolA.length; i++) {
            System.out.println("num is " + integerA[i] + ", &1=" + boolA[i]);
        }

        // test String
        String retStr = nativeJava.stringTest("string in java");
        System.out.println(retStr);

        // test String[]
        String[] strs = nativeJava.strArrTest(new String[]{"one", "two", "three"});
        for (int i=0; i<strs.length; i++) {
            System.out.println("string is " + strs[i]);
        }

        // test field
        nativeJava.modifyFields();

        // test method
        nativeJava.testMethod();
    }
}