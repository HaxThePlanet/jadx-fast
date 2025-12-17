package f.c.a.d.b.h;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.FieldDescriptor.Builder;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;

/* loaded from: classes2.dex */
final class b implements ObjectEncoder<MessagingClientEventExtension> {

    static final f.c.a.d.b.h.b a;
    private static final FieldDescriptor b;
    static {
        b bVar = new b();
        b.a = bVar;
        o oVar = new o();
        oVar.a(1);
        b.b = FieldDescriptor.builder("messagingClientEvent").withProperty(oVar.b()).build();
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final void encode(Object object, Object object2) {
        (ObjectEncoderContext)object2.add(b.b, (MessagingClientEventExtension)object.getMessagingClientEventInternal());
    }
}
