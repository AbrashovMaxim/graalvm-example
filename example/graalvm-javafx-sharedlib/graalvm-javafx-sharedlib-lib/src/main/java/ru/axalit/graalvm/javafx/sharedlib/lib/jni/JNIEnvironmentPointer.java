package ru.axalit.graalvm.javafx.sharedlib.lib.jni;

import org.graalvm.nativeimage.c.struct.CPointerTo;
import org.graalvm.word.PointerBase;

@CPointerTo(JNIEnvironment.class)
public interface JNIEnvironmentPointer extends PointerBase {

    JNIEnvironment read();
    void write(JNIEnvironment value);

}