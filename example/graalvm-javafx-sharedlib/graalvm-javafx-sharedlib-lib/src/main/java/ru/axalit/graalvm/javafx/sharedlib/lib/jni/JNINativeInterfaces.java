package ru.axalit.graalvm.javafx.sharedlib.lib.jni;

import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.function.CFunctionPointer;
import org.graalvm.nativeimage.c.function.InvokeCFunctionPointer;
import org.graalvm.nativeimage.c.struct.CField;
import org.graalvm.nativeimage.c.struct.CStruct;
import org.graalvm.nativeimage.c.type.CCharPointer;
import org.graalvm.word.PointerBase;
import ru.axalit.graalvm.javafx.sharedlib.lib.jni.JNIFields.*;

public class JNINativeInterfaces {

    @CContext(JNIHeaderDirectives.class)
    @CStruct(value = "JNINativeInterface_", addStructKeyword = true)
    public interface JNINativeInterface extends PointerBase {

        @CField
        GetMethodId getGetStaticMethodID();

        @CField
        CallStaticVoidMethod getCallStaticVoidMethodA();

        @CField
        FindClass getFindClass();

        @CField
        AllocObject getAllocObject();

        @CField
        GetFieldID getGetFieldID();

        @CField
        SetObjectField getSetObjectField();

        @CField
        NewStringUTF getNewStringUTF();

        @CField
        GetObjectClass getGetObjectClass();

    }

    public interface GetMethodId extends CFunctionPointer {

        @InvokeCFunctionPointer
        JMethodID find(JNIEnvironment env, JClass clazz, CCharPointer name, CCharPointer sig);

    }

    public interface CallStaticVoidMethod extends CFunctionPointer {

        @InvokeCFunctionPointer
        void call(JNIEnvironment env, JClass cls, JMethodID methodid, JValue args);

    }

    public interface FindClass extends CFunctionPointer {

        @InvokeCFunctionPointer
        JClass find(JNIEnvironment env, CCharPointer name);

    }

    public interface AllocObject extends CFunctionPointer {

        @InvokeCFunctionPointer
        JObject alloc(JNIEnvironment env, JClass jClass);

    }

    public interface GetFieldID extends CFunctionPointer {

        @InvokeCFunctionPointer
        JFieldID get(JNIEnvironment env, JClass jclass, CCharPointer name, CCharPointer sig);

    }

    public interface SetObjectField extends CFunctionPointer {

        @InvokeCFunctionPointer
        void set(JNIEnvironment env, JObject object, JFieldID fieldID, JObject string);

    }

    public interface NewStringUTF extends CFunctionPointer {

        @InvokeCFunctionPointer
        JString newString(JNIEnvironment env, CCharPointer stringChar);

    }

    public interface GetObjectClass extends CFunctionPointer {

        @InvokeCFunctionPointer
        JClass get(JNIEnvironment env, JObject object);

    }

}
