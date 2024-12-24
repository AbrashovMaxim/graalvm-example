package ru.axalit.graalvm.javafx.sharedlib.lib.jni;

import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.struct.CField;
import org.graalvm.nativeimage.c.struct.CStruct;
import org.graalvm.word.PointerBase;

public class JNIFields {


    public interface JObject extends PointerBase { }
    public interface JClass extends PointerBase { }
    public interface JMethodID extends PointerBase { }
    public interface JFieldID extends PointerBase { }
    public interface JString extends JObject { }


    @CContext(JNIHeaderDirectives.class)
    @CStruct("jvalue")
    public interface JValue extends PointerBase {

        @CField
        boolean z();
        @CField byte b();
        @CField char c();
        @CField short s();
        @CField int i();
        @CField long j();
        @CField float f();
        @CField double d();
        @CField JObject l();


        @CField void z(boolean b);
        @CField void b(byte b);
        @CField void c(char ch);
        @CField void s(short s);
        @CField void i(int i);
        @CField void j(long l);
        @CField void f(float f);
        @CField void d(double d);
        @CField void l(JObject obj);

        JValue addressOf(int index);

    }

}
