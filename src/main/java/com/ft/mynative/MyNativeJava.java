package com.ft.mynative;

public class MyNativeJava {
    static {
        System.loadLibrary("libMyNativeJava");
    }

    private native void fun();
    private native int fun2(String s);
    private native void fun3(Integer[] ia);

    public static void main(String[] args) {
        MyNativeJava nativeHello = new MyNativeJava();
        nativeHello.fun();
        System.out.println(nativeHello.fun2("hello, tom"));
        nativeHello.fun3(new Integer[]{3, 5});
    }
}