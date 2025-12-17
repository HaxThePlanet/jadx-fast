package f.c.a.d.b.h;

import com.google.firebase.encoders.ObjectEncoder;

/* loaded from: classes2.dex */
public final class t implements ObjectEncoder {

    public static final f.c.a.d.b.h.t a;
    static {
        t tVar = new t();
        t.a = tVar;
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final void encode(Object object, Object object2) {
        u.g((Map.Entry)object, (ObjectEncoderContext)object2);
    }
}
