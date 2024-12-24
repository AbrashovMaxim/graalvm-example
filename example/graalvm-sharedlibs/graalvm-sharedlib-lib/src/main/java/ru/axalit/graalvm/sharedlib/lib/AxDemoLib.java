package ru.axalit.graalvm.sharedlib.lib;

import org.graalvm.nativeimage.IsolateThread;
import org.graalvm.nativeimage.c.function.CEntryPoint;
import org.graalvm.word.Pointer;

public class AxDemoLib {

    public static void main(String[] args) {}


    @CEntryPoint(name = "Java_ru_axalit_graalvm_sharedlib_test_AxDemoJNIController_createIsolate", builtin=CEntryPoint.Builtin.CREATE_ISOLATE)
    public static native IsolateThread createIsolate();

    @CEntryPoint(name = "Java_ru_axalit_graalvm_sharedlib_test_AxDemoJNIController_add")
    public static int add(Pointer env, Pointer clazz, @CEntryPoint.IsolateThreadContext long isolateId, int a, int b) {
        long isolate = AxDemoControllerJNI.createIsolate();
        return AxDemoControllerJNI.add(isolate, a, b);
    }

}
