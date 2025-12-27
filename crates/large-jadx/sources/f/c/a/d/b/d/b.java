package f.c.a.d.b.d;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.a.b;
import com.google.android.gms.auth.a.c;
import com.google.android.gms.common.api.d.a;
import com.google.android.gms.common.api.d.b;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.h;
import java.util.Set;

/* loaded from: classes2.dex */
public final class b extends h<c> {

    private final Bundle a = new Bundle();
    public b(Context context, Looper looper, d dVar, c cVar, d.a aVar, d.b bVar) throws java.lang.NoSuchMethodError {
        super(context, looper, 16, dVar, aVar, bVar);
        if (cVar != null) {
            throw new NoSuchMethodError();
        } else {
            Bundle bundle = new Bundle();
            return;
        }
    }

    @Override // com.google.android.gms.common.internal.h
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface localInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        if (localInterface instanceof c) {
            return localInterface;
        }
        return new d(iBinder);
    }

    @Override // com.google.android.gms.common.internal.h
    protected final Bundle getGetServiceRequestExtraArgs() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.h
    public final boolean requiresSignIn() {
        d clientSettings = getClientSettings();
        if (!TextUtils.isEmpty(clientSettings.b())) {
            if (!clientSettings.e(b.c).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.common.internal.h
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    @Override // com.google.android.gms.common.internal.h
    protected final String getStartServiceAction() {
        return "com.google.android.gms.auth.service.START";
    }
}
