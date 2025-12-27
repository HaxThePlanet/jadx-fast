package f.c.a.d.c;

import android.content.Context;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.common.internal.q;

/* loaded from: classes2.dex */
public class f extends c<com.google.android.gms.common.api.a.d.c> {
    f(Context context) {
        super(context, c.c, null, new b());
    }

    @Override // com.google.android.gms.common.api.c
    public com.google.android.gms.tasks.j<d> b(byte[] bArr, String str) {
        return q.a(j.a(asGoogleApiClient(), bArr, str), new d());
    }
}
