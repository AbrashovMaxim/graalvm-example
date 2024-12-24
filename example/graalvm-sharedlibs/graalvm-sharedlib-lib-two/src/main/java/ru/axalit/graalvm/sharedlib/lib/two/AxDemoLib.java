package ru.axalit.graalvm.sharedlib.lib.two;

import org.graalvm.nativeimage.IsolateThread;
import org.graalvm.nativeimage.c.function.CEntryPoint;
import org.graalvm.word.Pointer;

public class AxDemoLib {

    public static void main(String[] args) {}


    @CEntryPoint(name = "Java_ru_axalit_graalvm_sharedlib_lib_AxDemoControllerJNI_createIsolate", builtin=CEntryPoint.Builtin.CREATE_ISOLATE)
    public static native IsolateThread createIsolate();

    @CEntryPoint(name = "Java_ru_axalit_graalvm_sharedlib_lib_AxDemoControllerJNI_add")
    public static int add(Pointer env, Pointer clazz, @CEntryPoint.IsolateThreadContext long isolateId, int a, int b) {
        return a + b;
    }

}
