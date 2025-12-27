package f.c.a.d.b.c;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.a.a.a;
import com.google.android.gms.auth.a.a.a.a;
import com.google.android.gms.common.api.d.a;
import com.google.android.gms.common.api.d.b;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.h;

/* compiled from: com.google.android.gms:play-services-auth@@19.2.0 */
/* loaded from: classes2.dex */
public final class e extends h<f> {

    private final a.a a = new a$a();
    public e(Context context, Looper looper, d dVar, a.a aVar, d.a aVar2, d.b bVar) {
        super(context, looper, 68, dVar, aVar2, bVar);
        aVar = aVar == null ? a.a.v : aVar;
        aVar2 = new a.a.a(aVar);
        aVar2.a(b.a());
        a.a aVar3 = new a.a(aVar2);
    }

    @Override // com.google.android.gms.common.internal.h
    protected final Bundle getGetServiceRequestExtraArgs() {
        return this.a.a();
    }

    @Override // com.google.android.gms.common.internal.h
    public final int getMinApkVersion() {
        return 12800000;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    @Override // com.google.android.gms.common.internal.h
    protected final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }
}
