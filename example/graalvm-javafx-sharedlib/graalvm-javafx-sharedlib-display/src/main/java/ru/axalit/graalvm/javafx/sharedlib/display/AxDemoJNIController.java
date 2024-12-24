package ru.axalit.graalvm.javafx.sharedlib.display;

import java.io.File;

public class AxDemoJNIController {

    public static boolean isConnectedLib = true;
    static {
        try {
            System.load(System.getProperty("user.dir") + File.separator + "libs" + File.separator + "app-name.dll");
        } catch (UnsatisfiedLinkError e) {
            isConnectedLib = false;
            e.printStackTrace();
        }
    }

    public static void hello(boolean z, char c, byte b, short s, int i, long j, float f, double d) {
        System.err.println("Hi, I have just been called back!");
        System.err.print("With: " + z + " " + c + " " + b + " " + s);
        System.err.println(" and: " + i + " " + j + " " + f + " " + d);
    }

    public static native long createIsolate(); // ОБЯЗАТЕЛЬНО
    public static native int add(long isolateThread, int a, int b);
    public static native void callFromDll(long isolateThread);

    public static native Object createObject(long isolateThread);
    public static native void changeObjectString(long isolateThread, Object object, String value);

}
