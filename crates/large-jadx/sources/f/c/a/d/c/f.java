package f.c.a.d.c;

import android.content.Context;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.j;
import f.c.a.d.b.j.j;

/* loaded from: classes2.dex */
public class f extends c<com.google.android.gms.common.api.a.d.c> {
    f(Context context) {
        b bVar = new b();
        super(context, c.c, 0, bVar);
    }

    public j<f.c.a.d.c.d> b(byte[] bArr, String string2) {
        d obj3 = new d();
        return q.a(j.a(asGoogleApiClient(), bArr, string2), obj3);
    }
}
