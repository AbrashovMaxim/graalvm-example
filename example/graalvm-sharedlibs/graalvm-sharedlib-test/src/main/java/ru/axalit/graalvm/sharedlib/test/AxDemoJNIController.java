package ru.axalit.graalvm.sharedlib.test;

import java.io.File;

public class AxDemoJNIController {

    static {
        try {
            System.load(System.getProperty("user.dir") + File.separator + "libs" + File.separator + "app-name-lib.dll");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    public static native long createIsolate(); // ОБЯЗАТЕЛЬНО
    public static native int add(long isolateThread, int a, int b);

}
