package ru.axalit.graalvm.javafx.sharedlib.lib.jni;

import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.function.CFunctionPointer;
import org.graalvm.nativeimage.c.function.InvokeCFunctionPointer;
import org.graalvm.nativeimage.c.struct.CField;
import org.graalvm.nativeimage.c.struct.CStruct;
import org.graalvm.nativeimage.c.type.CCharPointer;
import org.graalvm.word.PointerBase;

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
        JNIFields.JMethodID find(JNIEnvironment env, JNIFields.JClass clazz, CCharPointer name, CCharPointer sig);

    }

    public interface CallStaticVoidMethod extends CFunctionPointer {

        @InvokeCFunctionPointer
        void call(JNIEnvironment env, JNIFields.JClass cls, JNIFields.JMethodID methodid, JNIFields.JValue args);

    }

    public interface FindClass extends CFunctionPointer {

        @InvokeCFunctionPointer
        JNIFields.JClass find(JNIEnvironment env, CCharPointer name);

    }

    public interface AllocObject extends CFunctionPointer {

        @InvokeCFunctionPointer
        JNIFields.JObject alloc(JNIEnvironment env, JNIFields.JClass jClass);

    }

    public interface GetFieldID extends CFunctionPointer {

        @InvokeCFunctionPointer
        JNIFields.JFieldID get(JNIEnvironment env, JNIFields.JClass jclass, CCharPointer name, CCharPointer sig);

    }

    public interface SetObjectField extends CFunctionPointer {

        @InvokeCFunctionPointer
        void set(JNIEnvironment env, JNIFields.JObject object, JNIFields.JFieldID fieldID, JNIFields.JObject string);

    }

    public interface NewStringUTF extends CFunctionPointer {

        @InvokeCFunctionPointer
        JNIFields.JString newString(JNIEnvironment env, CCharPointer stringChar);

    }

    public interface GetObjectClass extends CFunctionPointer {

        @InvokeCFunctionPointer
        JNIFields.JClass get(JNIEnvironment env, JNIFields.JObject object);

    }

}
