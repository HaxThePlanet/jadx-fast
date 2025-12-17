package com.google.android.gms.internal.firebase-auth-api;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.l.a;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes2.dex */
public final class pl extends h<com.google.android.gms.internal.firebase-auth-api.dm> implements com.google.android.gms.internal.firebase-auth-api.ol {

    private static final a c;
    private final Context a;
    private final com.google.android.gms.internal.firebase-auth-api.im b;
    static {
        a aVar = new a("FirebaseAuth", /* result */);
        pl.c = aVar;
    }

    public pl(Context context, Looper looper2, d d3, com.google.android.gms.internal.firebase-auth-api.im im4, f f5, m m6) {
        super(context, looper2, 112, d3, f5, m6);
        r.j(context);
        this.a = (Context)context;
        this.b = im4;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final IInterface createServiceInterface(IBinder iBinder) {
        IInterface localInterface;
        boolean z;
        int obj3;
        if (iBinder == null) {
            obj3 = 0;
        } else {
            localInterface = iBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            if (localInterface instanceof dm) {
                obj3 = localInterface;
            } else {
                localInterface = new am(iBinder);
                obj3 = localInterface;
            }
        }
        return obj3;
    }

    @Override // com.google.android.gms.common.internal.h
    public final d[] getApiFeatures() {
        return q4.d;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final Bundle getGetServiceRequestExtraArgs() {
        Bundle getServiceRequestExtraArgs;
        Object imVar;
        String str;
        if (super.getGetServiceRequestExtraArgs() == null) {
            getServiceRequestExtraArgs = new Bundle();
        }
        imVar = this.b;
        if (imVar != null) {
            getServiceRequestExtraArgs.putString("com.google.firebase.auth.API_KEY", imVar.b());
        }
        getServiceRequestExtraArgs.putString("com.google.firebase.auth.LIBRARY_VERSION", nm.c());
        return getServiceRequestExtraArgs;
    }

    @Override // com.google.android.gms.common.internal.h
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final String getServiceDescriptor() {
        return "com.google.firebase.auth.api.internal.IFirebaseAuthService";
    }

    @Override // com.google.android.gms.common.internal.h
    protected final String getStartServiceAction() {
        return "com.google.firebase.auth.api.gms.service.START";
    }

    @Override // com.google.android.gms.common.internal.h
    protected final String getStartServicePackage() {
        int i = 0;
        if (imVar.a) {
            pl.c.e("Preparing to create service connection to fallback implementation", new Object[i]);
            return this.a.getPackageName();
        }
        pl.c.e("Preparing to create service connection to gms implementation", new Object[i]);
        return "com.google.android.gms";
    }

    @Override // com.google.android.gms.common.internal.h
    public final com.google.android.gms.internal.firebase-auth-api.dm j() {
        return (dm)super.getService();
    }

    @Override // com.google.android.gms.common.internal.h
    public final boolean requiresGooglePlayServices() {
        if (DynamiteModule.a(this.a, "com.google.firebase.auth") == 0) {
            return 1;
        }
        return 0;
    }
}
