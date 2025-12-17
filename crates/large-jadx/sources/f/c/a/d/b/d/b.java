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
public final class b extends h<f.c.a.d.b.d.c> {

    private final Bundle a;
    public b(Context context, Looper looper2, d d3, c c4, d.a d$a5, d.b d$b6) {
        super(context, looper2, 16, d3, a5, b6);
        if (c4 != null) {
        } else {
            Bundle obj8 = new Bundle();
            this.a = obj8;
        }
        obj8 = new NoSuchMethodError();
        throw obj8;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface localInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        if (localInterface instanceof c) {
            return (c)localInterface;
        }
        d dVar = new d(iBinder);
        return dVar;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final Bundle getGetServiceRequestExtraArgs() {
        return this.a;
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

    @Override // com.google.android.gms.common.internal.h
    public final boolean requiresSignIn() {
        d clientSettings;
        boolean empty;
        clientSettings = getClientSettings();
        if (!TextUtils.isEmpty(clientSettings.b()) && !clientSettings.e(b.c).isEmpty()) {
            if (!clientSettings.e(b.c).isEmpty()) {
                return 1;
            }
        }
        return 0;
    }
}
