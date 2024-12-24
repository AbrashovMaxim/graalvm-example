package ru.axalit.graalvm.javafx.sharedlib.lib;

import org.graalvm.nativeimage.IsolateThread;
import org.graalvm.nativeimage.StackValue;
import org.graalvm.nativeimage.c.function.CEntryPoint;
import org.graalvm.nativeimage.c.type.CTypeConversion;
import ru.axalit.graalvm.javafx.sharedlib.lib.jni.JNIEnvironment;
import ru.axalit.graalvm.javafx.sharedlib.lib.jni.JNIFields.*;
import ru.axalit.graalvm.javafx.sharedlib.lib.jni.JNINativeInterfaces;

public class AxDemoLib {

    public static void main(String[] args) {}


    @CEntryPoint(name = "Java_ru_axalit_graalvm_javafx_sharedlib_display_AxDemoJNIController_createIsolate", builtin=CEntryPoint.Builtin.CREATE_ISOLATE)
    public static native IsolateThread createIsolate();

    @CEntryPoint(name = "Java_ru_axalit_graalvm_javafx_sharedlib_display_AxDemoJNIController_callFromDll")
    public static void callFromDll(JNIEnvironment env, JClass clazz, @CEntryPoint.IsolateThreadContext long isolateId) {
        JNINativeInterfaces.JNINativeInterface fn = env.getFunctions();

        try (
                CTypeConversion.CCharPointerHolder name = CTypeConversion.toCString("hello");
                CTypeConversion.CCharPointerHolder sig = CTypeConversion.toCString("(ZCBSIJFD)V");
        ) {
            JMethodID helloId = fn.getGetStaticMethodID().find(env, clazz, name.get(), sig.get());

            JValue args = StackValue.get(8, JValue.class);
            args.addressOf(0).z(false);
            args.addressOf(1).c('A');
            args.addressOf(2).b((byte)22);
            args.addressOf(3).s((short)33);
            args.addressOf(4).i(39);
            args.addressOf(5).j(Long.MAX_VALUE / 2l);
            args.addressOf(6).f((float) Math.PI);
            args.addressOf(7).d(Math.PI);
            fn.getCallStaticVoidMethodA().call(env, clazz, helloId, args);
        }
    }


    @CEntryPoint(name = "Java_ru_axalit_graalvm_javafx_sharedlib_display_AxDemoJNIController_add")
    public static int add(JNIEnvironment env, JClass clazz, @CEntryPoint.IsolateThreadContext long isolateId, int a, int b) {
        return a + b;
    }

    @CEntryPoint(name = "Java_ru_axalit_graalvm_javafx_sharedlib_display_AxDemoJNIController_createObject")
    public static JObject createObject(JNIEnvironment env, JClass clazz, @CEntryPoint.IsolateThreadContext long isolateId) {
        JNINativeInterfaces.JNINativeInterface fn = env.getFunctions();

        try (
                CTypeConversion.CCharPointerHolder className = CTypeConversion.toCString("ru/axalit/graalvm/javafx/sharedlib/proxy/AxDemoProxy");
                CTypeConversion.CCharPointerHolder stringSig = CTypeConversion.toCString("Ljava/lang/String;");
                CTypeConversion.CCharPointerHolder fieldName = CTypeConversion.toCString("nameCamera");
                CTypeConversion.CCharPointerHolder stringReturn = CTypeConversion.toCString("Axalit Camera V8 BiTurbo AMG Competition");
        ) {
            JClass jClass = fn.getFindClass().find(env, className.get());
            JObject jObject = fn.getAllocObject().alloc(env, jClass);
            JFieldID nameField = fn.getGetFieldID().get(env, jClass, fieldName.get(), stringSig.get());

            JString string = fn.getNewStringUTF().newString(env, stringReturn.get());
            fn.getSetObjectField().set(env, jObject, nameField, string);

            return jObject;
        }

    }

    @CEntryPoint(name = "Java_ru_axalit_graalvm_javafx_sharedlib_display_AxDemoJNIController_changeObjectString")
    public static void changeObjectString(JNIEnvironment env, JClass clazz, @CEntryPoint.IsolateThreadContext long isolateId, JObject object, JString string) {
        JNINativeInterfaces.JNINativeInterface fn = env.getFunctions();

        try (
                CTypeConversion.CCharPointerHolder stringSig = CTypeConversion.toCString("Ljava/lang/String;");
                CTypeConversion.CCharPointerHolder fieldName = CTypeConversion.toCString("nameCamera");
        ) {
            JClass jClass = fn.getGetObjectClass().get(env, object);
            JFieldID nameField = fn.getGetFieldID().get(env, jClass, fieldName.get(), stringSig.get());

            fn.getSetObjectField().set(env, object, nameField, string);
        }

    }

}
