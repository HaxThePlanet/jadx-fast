package com.google.android.gms.internal.firebase-auth-api;

import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;
import com.google.firebase.auth.internal.zzao;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
abstract class an<ResultT, CallbackT>  implements com.google.android.gms.internal.firebase-auth-api.wh<com.google.android.gms.internal.firebase-auth-api.ol, ResultT> {

    protected final int a;
    final com.google.android.gms.internal.firebase-auth-api.xm b;
    protected FirebaseApp c;
    protected FirebaseUser d;
    protected CallbackT e;
    protected zzao f;
    protected final List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> g;
    protected Executor h;
    protected com.google.android.gms.internal.firebase-auth-api.to i;
    protected com.google.android.gms.internal.firebase-auth-api.mo j;
    protected com.google.android.gms.internal.firebase-auth-api.yn k;
    protected com.google.android.gms.internal.firebase-auth-api.fp l;
    protected String m;
    protected String n;
    protected AuthCredential o;
    protected String p;
    protected String q;
    protected com.google.android.gms.internal.firebase-auth-api.yf r;
    private boolean s;
    ResultT t;
    protected com.google.android.gms.internal.firebase-auth-api.zm u;
    public an(int i) {
        super();
        xm xmVar = new xm(this);
        this.b = xmVar;
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        this.a = i;
    }

    static void g(com.google.android.gms.internal.firebase-auth-api.an an) {
        an.a();
        r.n(an.s, "no success or failure set on method implementation");
    }

    static void h(com.google.android.gms.internal.firebase-auth-api.an an, Status status2) {
        final zzao obj0 = an.f;
        if (obj0 != null) {
            obj0.zzb(status2);
        }
    }

    static boolean k(com.google.android.gms.internal.firebase-auth-api.an an, boolean z2) {
        final int obj1 = 1;
        an.s = obj1;
        return obj1;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.wh
    public abstract void a();

    public final com.google.android.gms.internal.firebase-auth-api.an<ResultT, CallbackT> b(CallbackT callbackt) {
        r.k(callbackt, "external callback cannot be null");
        this.e = callbackt;
        return this;
    }

    public final com.google.android.gms.internal.firebase-auth-api.an<ResultT, CallbackT> c(zzao zzao) {
        r.k(zzao, "external failure callback cannot be null");
        this.f = (zzao)zzao;
        return this;
    }

    public final com.google.android.gms.internal.firebase-auth-api.an<ResultT, CallbackT> d(FirebaseApp firebaseApp) {
        r.k(firebaseApp, "firebaseApp cannot be null");
        this.c = (FirebaseApp)firebaseApp;
        return this;
    }

    public final com.google.android.gms.internal.firebase-auth-api.an<ResultT, CallbackT> e(FirebaseUser firebaseUser) {
        r.k(firebaseUser, "firebaseUser cannot be null");
        this.d = (FirebaseUser)firebaseUser;
        return this;
    }

    public final com.google.android.gms.internal.firebase-auth-api.an<ResultT, CallbackT> f(PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthProvider$OnVerificationStateChangedCallbacks, Activity activity2, Executor executor3, String string4) {
        Object obj2;
        obj2 = kn.a(string4, onVerificationStateChangedCallbacks, this);
        final List obj5 = this.g;
        r.j(obj2);
        this.g.add((PhoneAuthProvider.OnVerificationStateChangedCallbacks)obj2);
        synchronized (obj5) {
            obj2 = kn.a(string4, onVerificationStateChangedCallbacks, this);
            obj5 = this.g;
            r.j(obj2);
            this.g.add((PhoneAuthProvider.OnVerificationStateChangedCallbacks)obj2);
        }
        rm.a(activity2, this.g);
        r.j(executor3);
        this.h = (Executor)executor3;
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.wh
    public final void i(Status status) {
        this.s = true;
        this.u.a(0, status);
    }

    public final void j(ResultT resultt) {
        this.s = true;
        this.t = resultt;
        this.u.a(resultt, 0);
    }
}
