package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.a;
import com.google.android.gms.common.api.d.a;
import com.google.android.gms.common.api.d.b;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.h;
import f.c.a.d.b.c.b;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class h extends h<com.google.android.gms.auth.api.signin.internal.t> {

    private final GoogleSignInOptions a;
    public h(Context context, Looper looper2, d d3, GoogleSignInOptions googleSignInOptions4, d.a d$a5, d.b d$b6) {
        GoogleSignInOptions.a obj8;
        boolean obj9;
        boolean obj10;
        GoogleSignInOptions obj11;
        super(context, looper2, 91, d3, a5, b6);
        if (googleSignInOptions4 != null) {
            obj8 = new GoogleSignInOptions.a(googleSignInOptions4);
        } else {
            obj8 = new GoogleSignInOptions.a();
        }
        obj8.g(b.a());
        if (!d3.d().isEmpty()) {
            obj9 = d3.d().iterator();
            for (Scope obj10 : obj9) {
                obj8.f(obj10, new Scope[0]);
            }
        }
        this.a = obj8.a();
    }

    @Override // com.google.android.gms.common.internal.h
    public final GoogleSignInOptions c() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final IInterface createServiceInterface(IBinder iBinder) {
        IInterface localInterface;
        boolean z;
        int obj3;
        if (iBinder == null) {
            obj3 = 0;
        } else {
            localInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            if (localInterface instanceof t) {
                obj3 = localInterface;
            } else {
                localInterface = new t(iBinder);
                obj3 = localInterface;
            }
        }
        return obj3;
    }

    @Override // com.google.android.gms.common.internal.h
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.h
    public final Intent getSignInIntent() {
        return n.c(getContext(), this.a);
    }

    @Override // com.google.android.gms.common.internal.h
    protected final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.h
    public final boolean providesSignIn() {
        return 1;
    }
}
