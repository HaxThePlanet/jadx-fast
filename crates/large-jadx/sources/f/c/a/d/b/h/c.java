package f.c.a.d.b.h;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* loaded from: classes2.dex */
final class c implements ObjectEncoder<f.c.a.d.b.h.e> {

    static final f.c.a.d.b.h.c a;
    private static final FieldDescriptor b;
    static {
        c cVar = new c();
        c.a = cVar;
        c.b = FieldDescriptor.of("messagingClientEventExtension");
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final void encode(Object object, Object object2) {
        (ObjectEncoderContext)object2.add(c.b, (e)object.a());
    }
}
