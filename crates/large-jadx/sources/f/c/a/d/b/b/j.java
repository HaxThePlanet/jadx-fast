package f.c.a.d.b.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.internal.h;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
/* loaded from: classes2.dex */
public final class j extends h<f> {
    public j(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, f fVar, m mVar) {
        super(context, looper, 126, dVar, fVar, mVar);
    }

    @Override // com.google.android.gms.common.internal.h
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface localInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
        if (localInterface instanceof f) {
            return localInterface;
        }
        return new e(iBinder);
    }

    @Override // com.google.android.gms.common.internal.h
    public final com.google.android.gms.common.d[] getApiFeatures() {
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
