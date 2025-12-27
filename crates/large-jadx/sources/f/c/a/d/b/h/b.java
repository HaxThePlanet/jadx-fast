package f.c.a.d.b.h;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.FieldDescriptor.Builder;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;

/* compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* loaded from: classes2.dex */
final class b implements ObjectEncoder<MessagingClientEventExtension> {

    static final b a = new b();
    private static final FieldDescriptor b;
    static {
        f.c.a.d.b.h.o oVar = new o();
        oVar.a(1);
        b.b = FieldDescriptor.builder("messagingClientEvent").withProperty(oVar.b()).build();
    }

    private b() {
        super();
    }
}
