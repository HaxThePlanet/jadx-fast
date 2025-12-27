package f.c.a.d.b.c;

import android.util.Base64;
import java.util.Random;

/* compiled from: com.google.android.gms:play-services-auth@@19.2.0 */
/* loaded from: classes2.dex */
public final class b {

    private static final Random a = new Random();

    public static String a() {
        byte[] bArr = new byte[16];
        b.a.nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }
}
