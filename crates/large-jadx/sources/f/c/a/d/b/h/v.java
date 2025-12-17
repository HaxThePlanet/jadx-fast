package f.c.a.d.b.h;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;

/* loaded from: classes2.dex */
public final class v implements ObjectEncoder {

    public static final f.c.a.d.b.h.v a;
    static {
        v vVar = new v();
        v.a = vVar;
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final void encode(Object object, Object object2) {
        String obj3;
        int obj4 = w.e;
        obj3 = String.valueOf(object.getClass().getCanonicalName());
        final String str = "Couldn't find encoder for type ";
        if (obj3.length() != 0) {
            obj3 = str.concat(obj3);
        } else {
            obj3 = new String(str);
        }
        obj4 = new EncodingException(obj3);
        throw obj4;
    }
}
