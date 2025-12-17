package f.c.a.d.b.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.h;

/* loaded from: classes2.dex */
public final class j extends h<f.c.a.d.b.b.f> {
    public j(Context context, Looper looper2, d d3, f f4, m m5) {
        super(context, looper2, 126, d3, f4, m5);
    }

    @Override // com.google.android.gms.common.internal.h
    protected final IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface localInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
        if (localInterface instanceof f) {
            return (f)localInterface;
        }
        e eVar = new e(iBinder);
        return eVar;
    }

    @Override // com.google.android.gms.common.internal.h
    public final d[] getApiFeatures() {
        return b.d;
    }

    @Override // com.google.android.gms.common.internal.h
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService";
    }

    @Override // com.google.android.gms.common.internal.h
    protected final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.phone.service.SmsRetrieverApiService.START";
    }
}
