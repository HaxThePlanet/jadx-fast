package f.c.a.d.b.j;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.d.a;
import com.google.android.gms.common.api.d.b;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.h;

/* loaded from: classes2.dex */
public final class m extends h<h> {

    private final Context a;
    public m(Context context, Looper looper, d dVar, d.a aVar, d.b bVar) {
        super(context, looper, 45, dVar, aVar, bVar);
        this.a = context;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final String c(String str) {
        final int i = 0;
        try {
            PackageManager packageManager = this.a.getPackageManager();
            if (packageManager == null) {
                return i;
            }
            return i;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return obj;
        }
        return obj2;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface localInterface = iBinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
        if (localInterface instanceof h) {
            return localInterface;
        }
        return new i(iBinder);
    }

    @Override // com.google.android.gms.common.internal.h
    public final int getMinApkVersion() {
        return 12200000;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.safetynet.internal.ISafetyNetService";
    }

    @Override // com.google.android.gms.common.internal.h
    protected final String getStartServiceAction() {
        return "com.google.android.gms.safetynet.service.START";
    }
}
