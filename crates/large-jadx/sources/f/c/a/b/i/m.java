package f.c.a.b.i;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import com.google.firebase.encoders.proto.ProtobufEncoder.Builder;
import f.c.a.b.i.x.a.a;

/* loaded from: classes.dex */
@Encodable
public abstract class m {

    private static final ProtobufEncoder a;
    static {
        m.a = ProtobufEncoder.builder().configureWith(b.a).build();
    }

    public static byte[] a(Object object) {
        return m.a.encode(object);
    }

    public abstract a b();
}
