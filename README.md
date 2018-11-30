## 简介
> java和c++交互，调用c++提供的native方法，java使用javah生成头文件，c++实现方法供java调用。配合工程[MyNativeCpp](https://github.com/feifa168/MyNativeCpp)配套使用。
后期会使用该方法提供class文件加解密，java可以使用java -agentlib或-agentpath启动jar包时加载动态库
用于解密jar包中的class文件。使用以下两个命令（例子）。
* **java -Djava.library.path=./encrypt/ -cp .** Encrypt -src Test.jar -dst Test_encrypt.jar
    * Encrypt是加密程序
    * -src Test.jar -dst Test_encrypt.jar 是其参数，用于加密Test.jar文件，生成Test_encrypt.jar

>使用环境
* 环境 win7 64位系统
* java: IDEA 2018.1 + jdk1.8
* c++ : CLion 2018.2 + mingw-w64
* 依赖库及文件
    * **%JAVA_HOME%\lib\jvm.lib**
    * **%JAVA_HOME%\include\jni.h**
     * **%JAVA_HOME%\include\win32\jni_md.h**
    
## 模块
* jni概述
* native接口文件
* 动态库提供本地方法
* java使用本地方法

### jni概述
>待补充

>参考
* [JNI学习笔记](http://jellypaul.github.io/java/2016/08/08/JNI%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0.html)
* [Java Programming Tutorial Java Native Interface](https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaNativeInterface.html)

### native接口文件
>include目录下javah生成的接口文件，使用如下命令
* 方法1
    * javac -h include com\ft\mynative\MyNativeJava.java
* 方法2
    * javac com\ft\mynative\MyNativeJava.java 详情参见[MyNativeJava.java](https://github.com/feifa168/MyNativeJava/blob/master/src/main/java/com/ft/mynative/MyNativeJava.java)
    * javah MyNativeJava
详情参见 [com_ft_mynative_MyNativeJava.h](https://github.com/feifa168/MyNativeJava/blob/master/src/main/java/include/com_ft_mynative_MyNativeJava.h)提供测试函数


### 动态库提供本地方法
>CLion生成动态库，jdk是64位，原本使用的Mingw是32位程序，生成的dll在64位java程序中不能使用，
又下载了mingw64，配置使CLion使用64位mingw，CLion使用CMake编译程序。
动态库部分请参见[本地方法库](https://github.com/feifa168/MyNativeCpp/blob/master/README.md)

### java使用本地方法
>静态块加载dll
```java
public class MyNativeJava {
    static {
        System.loadLibrary("libMyNativeJava");
    }
}
```
>加载成功就可以使用native方法了，fun，fun2，fun3是测试用的几个方法，后续会加入更多内容，比如类成员修改，类方法执行等。
详情参见[MyNativeJava.java](https://github.com/feifa168/MyNativeJava/blob/master/src/main/java/com/ft/mynative/MyNativeJava.java)
```java
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
```

