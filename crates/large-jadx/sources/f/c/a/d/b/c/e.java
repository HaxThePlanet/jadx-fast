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

/* loaded from: classes2.dex */
public final class e extends h<f.c.a.d.b.c.f> {

    private final a.a a;
    public e(Context context, Looper looper2, d d3, a.a a$a4, d.a d$a5, d.b d$b6) {
        a.a obj11;
        super(context, looper2, 68, d3, a5, b6);
        obj11 = a4 == null ? a.a.v : obj11;
        a.a.a obj8 = new a.a.a(obj11);
        obj8.a(b.a());
        a.a obj9 = new a.a(obj8);
        this.a = obj9;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final IInterface createServiceInterface(IBinder iBinder) {
        IInterface localInterface;
        boolean z;
        int obj3;
        if (iBinder == null) {
            obj3 = 0;
        } else {
            localInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            if (localInterface instanceof f) {
                obj3 = localInterface;
            } else {
                localInterface = new f(iBinder);
                obj3 = localInterface;
            }
        }
        return obj3;
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
