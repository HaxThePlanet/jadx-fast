package f.c.a.d.b.h;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* loaded from: classes2.dex */
final class c implements ObjectEncoder<e> {

    static final c a = new c();
    private static final FieldDescriptor b;
    static {
        c.b = FieldDescriptor.of("messagingClientEventExtension");
    }

    private c() {
        super();
    }
}
