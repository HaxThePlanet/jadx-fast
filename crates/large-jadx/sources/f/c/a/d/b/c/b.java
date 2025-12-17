package f.c.a.d.b.c;

import android.util.Base64;
import java.util.Random;

/* loaded from: classes2.dex */
public final class b {

    private static final Random a;
    static {
        Random random = new Random();
        b.a = random;
    }

    public static String a() {
        byte[] bArr = new byte[16];
        b.a.nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }
}
