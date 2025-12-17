package kotlin.reflect.jvm.internal.impl.protobuf;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class i {

    public static final byte[] a;

    public interface a {
        public abstract int getNumber();
    }

    public interface b {
        public abstract T findValueByNumber(int i);
    }
    static {
        byte[] bArr = new byte[0];
        i.a = bArr;
        ByteBuffer.wrap(bArr);
    }

    public static boolean a(byte[] bArr) {
        return v.e(bArr);
    }

    public static String b(byte[] bArr) {
        try {
            String string = new String(bArr, "UTF-8");
            return string;
            RuntimeException runtimeException = new RuntimeException("UTF-8 not supported?", bArr);
            throw runtimeException;
        }
    }
}
