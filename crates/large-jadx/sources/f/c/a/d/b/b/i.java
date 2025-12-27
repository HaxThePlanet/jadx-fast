package f.c.a.d.b.b;

import android.content.Context;
import com.google.android.gms.auth.a.d.b;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.tasks.j;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
/* loaded from: classes2.dex */
public final class i extends b {
    public i(Context context) {
        super(context);
    }

    @Override // com.google.android.gms.auth.a.d.b
    public final j<Void> b() {
        t.a builder = t.builder();
        builder.b(new k(this));
        com.google.android.gms.common.d[] arr = new d[1];
        builder.d(b.b);
        return doWrite(builder.a());
    }
}
