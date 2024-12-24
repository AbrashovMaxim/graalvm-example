package ru.axalit.graalvm.javafx.sharedlib.lib.jni;

import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.struct.CField;
import org.graalvm.nativeimage.c.struct.CStruct;
import org.graalvm.word.PointerBase;
import ru.axalit.graalvm.javafx.sharedlib.lib.jni.JNINativeInterfaces.JNINativeInterface;

@CContext(JNIHeaderDirectives.class)
@CStruct(value = "JNIEnv_", addStructKeyword = true)
public  interface JNIEnvironment extends PointerBase {

    @CField("functions")
    JNINativeInterface getFunctions();

}
