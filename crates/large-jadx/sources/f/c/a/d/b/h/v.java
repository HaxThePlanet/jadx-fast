package f.c.a.d.b.h;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;

/* compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* loaded from: classes2.dex */
public final class v implements ObjectEncoder {

    public static final /* synthetic */ v a = new v();
    public final void encode(Object object, Object object2) throws java.io.UnsupportedEncodingException, EncodingException {
        String concatenated;
        String str2 = String.valueOf(object.getClass().getCanonicalName());
        final String str = "Couldn't find encoder for type ";
        if (str2.length() != 0) {
            concatenated = str.concat(str2);
        } else {
            concatenated = new String(str);
        }
        EncodingException encodingException = new EncodingException(concatenated);
        throw encodingException;
    }


    private /* synthetic */ v() {
        super();
    }
}
