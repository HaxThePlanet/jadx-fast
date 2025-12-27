package f.c.a.b.i;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import com.google.firebase.encoders.proto.ProtobufEncoder.Builder;
import f.c.a.b.i.x.a.a;

/* compiled from: ProtoEncoderDoNotUse.java */
@Encodable
/* loaded from: classes.dex */
public abstract class m {

    private static final ProtobufEncoder a;
    static {
        m.a = ProtobufEncoder.builder().configureWith(b.a).build();
    }

    private m() {
        super();
    }

    public static byte[] a(Object object) {
        return m.a.encode(object);
    }

    public abstract a b();
}
