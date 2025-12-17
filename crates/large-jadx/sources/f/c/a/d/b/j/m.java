package f.c.a.d.b.j;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.d.a;
import com.google.android.gms.common.api.d.b;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.h;

/* loaded from: classes2.dex */
public final class m extends h<f.c.a.d.b.j.h> {

    private final Context a;
    public m(Context context, Looper looper2, d d3, d.a d$a4, d.b d$b5) {
        super(context, looper2, 45, d3, a4, b5);
        this.a = context;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final String c(String string) {
        final int i = 0;
        PackageManager packageManager = this.a.getPackageManager();
        if (packageManager == null) {
            try {
                return i;
                android.content.pm.ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.a.getPackageName(), 128);
                if (applicationInfo == null) {
                }
                return i;
                Bundle metaData = applicationInfo.metaData;
                if (metaData == null) {
                }
                return i;
                return (String)metaData.get(string);
                return obj0;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.h
    protected final IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface localInterface = iBinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
        if (localInterface instanceof h) {
            return (h)localInterface;
        }
        i iVar = new i(iBinder);
        return iVar;
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
