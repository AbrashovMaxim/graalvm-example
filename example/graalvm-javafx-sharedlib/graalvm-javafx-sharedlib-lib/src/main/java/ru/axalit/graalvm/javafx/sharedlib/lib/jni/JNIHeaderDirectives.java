package ru.axalit.graalvm.javafx.sharedlib.lib.jni;

import org.graalvm.nativeimage.c.CContext;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class JNIHeaderDirectives implements CContext.Directives {

    // Обязательно нужно поменять на свой путь до GraalVM JDK
    private static final String PATH_TO_GRAALVM_JDK = System.getProperty("java.home");


    public JNIHeaderDirectives() {}


    @Override
    public List<String> getOptions() {
        File[] jnis = findJNIHeaders();
        return Arrays.asList("-I" + jnis[0].getParent(), "-I" + jnis[1].getParent());
    }

    @Override
    public List<String> getHeaderFiles() {
        File[] jnis = findJNIHeaders();
        return Arrays.asList("<" + jnis[0] + ">", "<" + jnis[1] + ">");
    }

    private static File[] findJNIHeaders() throws IllegalStateException {
        File jreHome = new File(PATH_TO_GRAALVM_JDK);
        File include = new File(jreHome, "include");
        File[] jnis = {
                new File(include, "jni.h"),
                new File(new File(include, "win32"), "jni_md.h"),
        };
        return jnis;
    }

}
