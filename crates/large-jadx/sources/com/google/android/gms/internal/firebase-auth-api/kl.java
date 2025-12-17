package com.google.android.gms.internal.firebase-auth-api;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzan;
import com.google.firebase.auth.internal.zzba;
import com.google.firebase.auth.internal.zzbk;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzt;
import com.google.firebase.auth.internal.zzx;
import com.google.firebase.auth.internal.zzz;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public final class kl extends com.google.android.gms.internal.firebase-auth-api.xh<com.google.android.gms.internal.firebase-auth-api.im> {

    private final Context b;
    private final com.google.android.gms.internal.firebase-auth-api.im c;
    private final Future<com.google.android.gms.internal.firebase-auth-api.th<com.google.android.gms.internal.firebase-auth-api.im>> d;
    kl(Context context, com.google.android.gms.internal.firebase-auth-api.im im2) {
        super();
        this.b = context;
        this.c = im2;
        this.d = d();
    }

    static zzx v(FirebaseApp firebaseApp, com.google.android.gms.internal.firebase-auth-api.mo mo2) {
        int empty;
        zzt size;
        Object obj;
        r.j(firebaseApp);
        r.j(mo2);
        ArrayList arrayList = new ArrayList();
        zzt zzt = new zzt(mo2, "firebase");
        arrayList.add(zzt);
        List list = mo2.A2();
        if (list != null && !list.isEmpty()) {
            if (!list.isEmpty()) {
                empty = 0;
                while (empty < list.size()) {
                    size = new zzt((zo)list.get(empty));
                    arrayList.add(size);
                    empty++;
                }
            }
        }
        zzx zzx = new zzx(firebaseApp, arrayList);
        zzz obj6 = new zzz(mo2.k2(), size, mo2.j2(), obj5);
        zzx.zzr(obj6);
        zzx.zzq(mo2.B2());
        zzx.zzp(mo2.m2());
        zzx.zzi(zzba.zzb(mo2.z2()));
        return zzx;
    }

    public final j<AuthResult> A(FirebaseApp firebaseApp, String string2, String string3, String string4, zzg zzg5) {
        gi giVar = new gi(string2, string3, string4);
        giVar.d(firebaseApp);
        giVar.b(zzg5);
        return b(giVar);
    }

    public final j<Void> B(FirebaseUser firebaseUser, zzan zzan2) {
        ii iiVar = new ii();
        iiVar.e(firebaseUser);
        iiVar.b(zzan2);
        iiVar.c(zzan2);
        return b(iiVar);
    }

    public final j<SignInMethodQueryResult> C(FirebaseApp firebaseApp, String string2, String string3) {
        ki kiVar = new ki(string2, string3);
        kiVar.d(firebaseApp);
        return a(kiVar);
    }

    public final j<Void> D(FirebaseApp firebaseApp, PhoneMultiFactorAssertion phoneMultiFactorAssertion2, FirebaseUser firebaseUser3, String string4, zzg zzg5) {
        kn.c();
        mi miVar = new mi(phoneMultiFactorAssertion2, firebaseUser3.zzf(), string4);
        miVar.d(firebaseApp);
        miVar.b(zzg5);
        return b(miVar);
    }

    public final j<AuthResult> E(FirebaseApp firebaseApp, FirebaseUser firebaseUser2, PhoneMultiFactorAssertion phoneMultiFactorAssertion3, String string4, zzg zzg5) {
        kn.c();
        oi oiVar = new oi(phoneMultiFactorAssertion3, string4);
        oiVar.d(firebaseApp);
        oiVar.b(zzg5);
        if (firebaseUser2 != null) {
            oiVar.e(firebaseUser2);
        }
        return b(oiVar);
    }

    public final j<GetTokenResult> F(FirebaseApp firebaseApp, FirebaseUser firebaseUser2, String string3, zzbk zzbk4) {
        qi qiVar = new qi(string3);
        qiVar.d(firebaseApp);
        qiVar.e(firebaseUser2);
        qiVar.b(zzbk4);
        qiVar.c(zzbk4);
        return a(qiVar);
    }

    public final j<AuthResult> G(FirebaseApp firebaseApp, FirebaseUser firebaseUser2, AuthCredential authCredential3, zzbk zzbk4) {
        List contains;
        String provider;
        r.j(firebaseApp);
        r.j(authCredential3);
        r.j(firebaseUser2);
        r.j(zzbk4);
        contains = firebaseUser2.zzg();
        if (contains != null && !contains.contains(authCredential3.getProvider())) {
            if (!contains.contains(authCredential3.getProvider())) {
            }
            Status obj3 = new Status(17015);
            return m.d(ql.a(obj3));
        }
        if (authCredential3 instanceof EmailAuthCredential && !(EmailAuthCredential)authCredential3.zzg()) {
            if (!(EmailAuthCredential)authCredential3.zzg()) {
                si siVar = new si(authCredential3);
                siVar.d(firebaseApp);
                siVar.e(firebaseUser2);
                siVar.b(zzbk4);
                siVar.c(zzbk4);
                return b(siVar);
            }
            yi yiVar = new yi(authCredential3);
            yiVar.d(firebaseApp);
            yiVar.e(firebaseUser2);
            yiVar.b(zzbk4);
            yiVar.c(zzbk4);
            return b(yiVar);
        }
        if (authCredential3 instanceof PhoneAuthCredential) {
            kn.c();
            wi wiVar = new wi((PhoneAuthCredential)authCredential3);
            wiVar.d(firebaseApp);
            wiVar.e(firebaseUser2);
            wiVar.b(zzbk4);
            wiVar.c(zzbk4);
            return b(wiVar);
        }
        r.j(firebaseApp);
        r.j(authCredential3);
        r.j(firebaseUser2);
        r.j(zzbk4);
        ui uiVar = new ui(authCredential3);
        uiVar.d(firebaseApp);
        uiVar.e(firebaseUser2);
        uiVar.b(zzbk4);
        uiVar.c(zzbk4);
        return b(uiVar);
    }

    public final j<Void> H(FirebaseApp firebaseApp, FirebaseUser firebaseUser2, AuthCredential authCredential3, String string4, zzbk zzbk5) {
        bj bjVar = new bj(authCredential3, string4);
        bjVar.d(firebaseApp);
        bjVar.e(firebaseUser2);
        bjVar.b(zzbk5);
        bjVar.c(zzbk5);
        return b(bjVar);
    }

    public final j<AuthResult> I(FirebaseApp firebaseApp, FirebaseUser firebaseUser2, AuthCredential authCredential3, String string4, zzbk zzbk5) {
        dj djVar = new dj(authCredential3, string4);
        djVar.d(firebaseApp);
        djVar.e(firebaseUser2);
        djVar.b(zzbk5);
        djVar.c(zzbk5);
        return b(djVar);
    }

    public final j<Void> J(FirebaseApp firebaseApp, FirebaseUser firebaseUser2, EmailAuthCredential emailAuthCredential3, zzbk zzbk4) {
        fj fjVar = new fj(emailAuthCredential3);
        fjVar.d(firebaseApp);
        fjVar.e(firebaseUser2);
        fjVar.b(zzbk4);
        fjVar.c(zzbk4);
        return b(fjVar);
    }

    public final j<AuthResult> K(FirebaseApp firebaseApp, FirebaseUser firebaseUser2, EmailAuthCredential emailAuthCredential3, zzbk zzbk4) {
        hj hjVar = new hj(emailAuthCredential3);
        hjVar.d(firebaseApp);
        hjVar.e(firebaseUser2);
        hjVar.b(zzbk4);
        hjVar.c(zzbk4);
        return b(hjVar);
    }

    public final j<Void> L(FirebaseApp firebaseApp, FirebaseUser firebaseUser2, String string3, String string4, String string5, zzbk zzbk6) {
        jj jjVar = new jj(string3, string4, string5);
        jjVar.d(firebaseApp);
        jjVar.e(firebaseUser2);
        jjVar.b(zzbk6);
        jjVar.c(zzbk6);
        return b(jjVar);
    }

    public final j<AuthResult> M(FirebaseApp firebaseApp, FirebaseUser firebaseUser2, String string3, String string4, String string5, zzbk zzbk6) {
        lj ljVar = new lj(string3, string4, string5);
        ljVar.d(firebaseApp);
        ljVar.e(firebaseUser2);
        ljVar.b(zzbk6);
        ljVar.c(zzbk6);
        return b(ljVar);
    }

    public final j<Void> N(FirebaseApp firebaseApp, FirebaseUser firebaseUser2, PhoneAuthCredential phoneAuthCredential3, String string4, zzbk zzbk5) {
        kn.c();
        nj njVar = new nj(phoneAuthCredential3, string4);
        njVar.d(firebaseApp);
        njVar.e(firebaseUser2);
        njVar.b(zzbk5);
        njVar.c(zzbk5);
        return b(njVar);
    }

    public final j<AuthResult> O(FirebaseApp firebaseApp, FirebaseUser firebaseUser2, PhoneAuthCredential phoneAuthCredential3, String string4, zzbk zzbk5) {
        kn.c();
        pj pjVar = new pj(phoneAuthCredential3, string4);
        pjVar.d(firebaseApp);
        pjVar.e(firebaseUser2);
        pjVar.b(zzbk5);
        pjVar.c(zzbk5);
        return b(pjVar);
    }

    public final j<Void> P(FirebaseApp firebaseApp, FirebaseUser firebaseUser2, zzbk zzbk3) {
        rj rjVar = new rj();
        rjVar.d(firebaseApp);
        rjVar.e(firebaseUser2);
        rjVar.b(zzbk3);
        rjVar.c(zzbk3);
        return a(rjVar);
    }

    public final j<Void> Q(FirebaseApp firebaseApp, ActionCodeSettings actionCodeSettings2, String string3) {
        tj tjVar = new tj(string3, actionCodeSettings2);
        tjVar.d(firebaseApp);
        return b(tjVar);
    }

    public final j<Void> R(FirebaseApp firebaseApp, String string2, ActionCodeSettings actionCodeSettings3, String string4) {
        actionCodeSettings3.zzg(1);
        vj vjVar = new vj(string2, actionCodeSettings3, string4, "sendPasswordResetEmail");
        vjVar.d(firebaseApp);
        return b(vjVar);
    }

    public final j<Void> S(FirebaseApp firebaseApp, String string2, ActionCodeSettings actionCodeSettings3, String string4) {
        actionCodeSettings3.zzg(6);
        vj vjVar = new vj(string2, actionCodeSettings3, string4, "sendSignInLinkToEmail");
        vjVar.d(firebaseApp);
        return b(vjVar);
    }

    final Future<com.google.android.gms.internal.firebase-auth-api.th<com.google.android.gms.internal.firebase-auth-api.im>> d() {
        Future future = this.d;
        if (future != null) {
            return future;
        }
        ll llVar = new ll(this.c, this.b);
        return u8.a().e(2).submit(llVar);
    }

    public final j<Void> e(String string) {
        xj xjVar = new xj(string);
        return b(xjVar);
    }

    public final j<AuthResult> f(FirebaseApp firebaseApp, zzg zzg2, String string3) {
        zj zjVar = new zj(string3);
        zjVar.d(firebaseApp);
        zjVar.b(zzg2);
        return b(zjVar);
    }

    public final j<AuthResult> g(FirebaseApp firebaseApp, AuthCredential authCredential2, String string3, zzg zzg4) {
        ck ckVar = new ck(authCredential2, string3);
        ckVar.d(firebaseApp);
        ckVar.b(zzg4);
        return b(ckVar);
    }

    public final j<AuthResult> h(FirebaseApp firebaseApp, String string2, String string3, zzg zzg4) {
        ek ekVar = new ek(string2, string3);
        ekVar.d(firebaseApp);
        ekVar.b(zzg4);
        return b(ekVar);
    }

    public final j<AuthResult> i(FirebaseApp firebaseApp, String string2, String string3, String string4, zzg zzg5) {
        gk gkVar = new gk(string2, string3, string4);
        gkVar.d(firebaseApp);
        gkVar.b(zzg5);
        return b(gkVar);
    }

    public final j<AuthResult> j(FirebaseApp firebaseApp, EmailAuthCredential emailAuthCredential2, zzg zzg3) {
        ik ikVar = new ik(emailAuthCredential2);
        ikVar.d(firebaseApp);
        ikVar.b(zzg3);
        return b(ikVar);
    }

    public final j<AuthResult> k(FirebaseApp firebaseApp, PhoneAuthCredential phoneAuthCredential2, String string3, zzg zzg4) {
        kn.c();
        kk kkVar = new kk(phoneAuthCredential2, string3);
        kkVar.d(firebaseApp);
        kkVar.b(zzg4);
        return b(kkVar);
    }

    public final j<Void> l(zzag zzag, String string2, String string3, long l4, boolean z5, boolean z6, String string7, String string8, boolean z9, PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthProvider$OnVerificationStateChangedCallbacks10, Executor executor11, Activity activity12) {
        super(zzag, string2, string3, l4, obj5, z6, string7, string8, z9, onVerificationStateChangedCallbacks10);
        String str = string2;
        mkVar2.f(executor11, obj25, activity12, string2);
        Object obj = this;
        return b(mkVar2);
    }

    public final j<Void> m(zzag zzag, PhoneMultiFactorInfo phoneMultiFactorInfo2, String string3, long l4, boolean z5, boolean z6, String string7, String string8, boolean z9, PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthProvider$OnVerificationStateChangedCallbacks10, Executor executor11, Activity activity12) {
        super(phoneMultiFactorInfo2, zzag.zzd(), string3, l4, obj5, z6, string7, string8, z9, onVerificationStateChangedCallbacks10);
        okVar2.f(executor11, obj25, activity12, phoneMultiFactorInfo2.getUid());
        Object obj = this;
        return b(okVar2);
    }

    public final j<Void> n(FirebaseApp firebaseApp, FirebaseUser firebaseUser2, String string3, zzbk zzbk4) {
        qk qkVar = new qk(firebaseUser2.zzf(), string3);
        qkVar.d(firebaseApp);
        qkVar.e(firebaseUser2);
        qkVar.b(zzbk4);
        qkVar.c(zzbk4);
        return b(qkVar);
    }

    public final j<AuthResult> o(FirebaseApp firebaseApp, FirebaseUser firebaseUser2, String string3, zzbk zzbk4) {
        boolean anonymous;
        int i;
        boolean equals;
        r.j(firebaseApp);
        r.f(string3);
        r.j(firebaseUser2);
        r.j(zzbk4);
        anonymous = firebaseUser2.zzg();
        if (anonymous != null) {
            if (anonymous.contains(string3) && firebaseUser2.isAnonymous()) {
                if (firebaseUser2.isAnonymous()) {
                }
            }
            Status obj3 = new Status(17016, string3);
            return m.d(ql.a(obj3));
        } else {
        }
        if (string3.hashCode() != 1216985755) {
            i = -1;
        } else {
            if (string3.equals("password")) {
                i = 0;
            } else {
            }
        }
        if (i != 0) {
            uk ukVar = new uk(string3);
            ukVar.d(firebaseApp);
            ukVar.e(firebaseUser2);
            ukVar.b(zzbk4);
            ukVar.c(zzbk4);
            return b(ukVar);
        }
        sk obj5 = new sk();
        obj5.d(firebaseApp);
        obj5.e(firebaseUser2);
        obj5.b(zzbk4);
        obj5.c(zzbk4);
        return b(obj5);
    }

    public final j<Void> p(FirebaseApp firebaseApp, FirebaseUser firebaseUser2, String string3, zzbk zzbk4) {
        wk wkVar = new wk(string3);
        wkVar.d(firebaseApp);
        wkVar.e(firebaseUser2);
        wkVar.b(zzbk4);
        wkVar.c(zzbk4);
        return b(wkVar);
    }

    public final j<Void> q(FirebaseApp firebaseApp, FirebaseUser firebaseUser2, String string3, zzbk zzbk4) {
        yk ykVar = new yk(string3);
        ykVar.d(firebaseApp);
        ykVar.e(firebaseUser2);
        ykVar.b(zzbk4);
        ykVar.c(zzbk4);
        return b(ykVar);
    }

    public final j<Void> r(FirebaseApp firebaseApp, FirebaseUser firebaseUser2, PhoneAuthCredential phoneAuthCredential3, zzbk zzbk4) {
        kn.c();
        al alVar = new al(phoneAuthCredential3);
        alVar.d(firebaseApp);
        alVar.e(firebaseUser2);
        alVar.b(zzbk4);
        alVar.c(zzbk4);
        return b(alVar);
    }

    public final j<Void> s(FirebaseApp firebaseApp, FirebaseUser firebaseUser2, UserProfileChangeRequest userProfileChangeRequest3, zzbk zzbk4) {
        dl dlVar = new dl(userProfileChangeRequest3);
        dlVar.d(firebaseApp);
        dlVar.e(firebaseUser2);
        dlVar.b(zzbk4);
        dlVar.c(zzbk4);
        return b(dlVar);
    }

    public final j<Void> t(String string, String string2, ActionCodeSettings actionCodeSettings3) {
        actionCodeSettings3.zzg(7);
        fl flVar = new fl(string, string2, actionCodeSettings3);
        return b(flVar);
    }

    public final j<String> u(FirebaseApp firebaseApp, String string2, String string3) {
        hl hlVar = new hl(string2, string3);
        hlVar.d(firebaseApp);
        return b(hlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xh
    public final void w(FirebaseApp firebaseApp, com.google.android.gms.internal.firebase-auth-api.hp hp2, PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthProvider$OnVerificationStateChangedCallbacks3, Activity activity4, Executor executor5) {
        jl jlVar = new jl(hp2);
        jlVar.d(firebaseApp);
        jlVar.f(onVerificationStateChangedCallbacks3, activity4, executor5, hp2.zzd());
        b(jlVar);
    }

    public final j<Void> x(FirebaseApp firebaseApp, String string2, String string3) {
        ai aiVar = new ai(string2, string3);
        aiVar.d(firebaseApp);
        return b(aiVar);
    }

    public final j<ActionCodeResult> y(FirebaseApp firebaseApp, String string2, String string3) {
        ci ciVar = new ci(string2, string3);
        ciVar.d(firebaseApp);
        return b(ciVar);
    }

    public final j<Void> z(FirebaseApp firebaseApp, String string2, String string3, String string4) {
        ei eiVar = new ei(string2, string3, string4);
        eiVar.d(firebaseApp);
        return b(eiVar);
    }
}
