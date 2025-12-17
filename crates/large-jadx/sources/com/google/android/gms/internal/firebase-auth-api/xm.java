package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.internal.zzao;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class xm extends com.google.android.gms.internal.firebase-auth-api.yl {

    final com.google.android.gms.internal.firebase-auth-api.an a;
    xm(com.google.android.gms.internal.firebase-auth-api.an an) {
        this.a = an;
        super();
    }

    private final void m(com.google.android.gms.internal.firebase-auth-api.ym ym) {
        wm wmVar = new wm(this, ym);
        anVar.h.execute(wmVar);
    }

    private final void n(Status status, AuthCredential authCredential2, String string3, String string4) {
        an.h(this.a, status);
        com.google.android.gms.internal.firebase-auth-api.an anVar2 = this.a;
        anVar2.o = authCredential2;
        anVar2.p = string3;
        anVar2.q = string4;
        zzao obj3 = anVar2.f;
        if (obj3 != null) {
            obj3.zzb(status);
        }
        this.a.i(status);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.yl
    public final void A(Status status, PhoneAuthCredential phoneAuthCredential2) {
        int i;
        int i2 = anVar.a;
        i = i2 == 2 ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder(36);
        stringBuilder.append("Unexpected response type ");
        stringBuilder.append(i2);
        r.n(i, stringBuilder.toString());
        int i3 = 0;
        n(status, phoneAuthCredential2, i3, i3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.yl
    public final void M(com.google.android.gms.internal.firebase-auth-api.yn yn) {
        int i;
        int i2 = anVar.a;
        i = i2 == 3 ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder(36);
        stringBuilder.append("Unexpected response type ");
        stringBuilder.append(i2);
        r.n(i, stringBuilder.toString());
        com.google.android.gms.internal.firebase-auth-api.an anVar2 = this.a;
        anVar2.k = yn;
        an.g(anVar2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.yl
    public final void O1(com.google.android.gms.internal.firebase-auth-api.yf yf) {
        final com.google.android.gms.internal.firebase-auth-api.an anVar = this.a;
        anVar.r = yf;
        anVar.i(zzai.zza("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.yl
    public final void S1(Status status) {
        String contains2;
        boolean contains;
        Status obj4;
        contains2 = status.l2();
        if (contains2 == null) {
        } else {
            if (contains2.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                obj4 = new Status(17081);
            } else {
                if (contains2.contains("MISSING_MFA_ENROLLMENT_ID")) {
                    obj4 = new Status(17082);
                } else {
                    if (contains2.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                        obj4 = new Status(17083);
                    } else {
                        if (contains2.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                            obj4 = new Status(17084);
                        } else {
                            if (contains2.contains("ADMIN_ONLY_OPERATION")) {
                                obj4 = new Status(17085);
                            } else {
                                if (contains2.contains("UNVERIFIED_EMAIL")) {
                                    obj4 = new Status(17086);
                                } else {
                                    if (contains2.contains("SECOND_FACTOR_EXISTS")) {
                                        obj4 = new Status(17087);
                                    } else {
                                        if (contains2.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                                            obj4 = new Status(17088);
                                        } else {
                                            if (contains2.contains("UNSUPPORTED_FIRST_FACTOR")) {
                                                obj4 = new Status(17089);
                                            } else {
                                                if (contains2.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                                                    obj4 = new Status(17090);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        com.google.android.gms.internal.firebase-auth-api.an anVar = this.a;
        if (anVar.a == 8) {
            an.k(anVar, true);
            vm vmVar = new vm(this, obj4);
            m(vmVar);
        }
        an.h(anVar, obj4);
        this.a.i(obj4);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.yl
    public final void V0(PhoneAuthCredential phoneAuthCredential) {
        int i;
        int i2 = anVar.a;
        final int i3 = 1;
        i = i2 == 8 ? i3 : 0;
        StringBuilder stringBuilder = new StringBuilder(36);
        stringBuilder.append("Unexpected response type ");
        stringBuilder.append(i2);
        r.n(i, stringBuilder.toString());
        an.k(this.a, i3);
        tm tmVar = new tm(this, phoneAuthCredential);
        m(tmVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.yl
    public final void Y0(com.google.android.gms.internal.firebase-auth-api.to to, com.google.android.gms.internal.firebase-auth-api.mo mo2) {
        int i;
        int i2 = anVar.a;
        i = i2 == 2 ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append("Unexpected response type: ");
        stringBuilder.append(i2);
        r.n(i, stringBuilder.toString());
        com.google.android.gms.internal.firebase-auth-api.an anVar2 = this.a;
        anVar2.i = to;
        anVar2.j = mo2;
        an.g(anVar2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.yl
    public final void d() {
        int i;
        int i2 = anVar.a;
        i = i2 == 5 ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder(36);
        stringBuilder.append("Unexpected response type ");
        stringBuilder.append(i2);
        r.n(i, stringBuilder.toString());
        an.g(this.a);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.yl
    public final void e() {
        int i;
        int i2 = anVar.a;
        i = i2 == 9 ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder(36);
        stringBuilder.append("Unexpected response type ");
        stringBuilder.append(i2);
        r.n(i, stringBuilder.toString());
        an.g(this.a);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.yl
    public final void f() {
        int i;
        int i2 = anVar.a;
        i = i2 == 6 ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder(36);
        stringBuilder.append("Unexpected response type ");
        stringBuilder.append(i2);
        r.n(i, stringBuilder.toString());
        an.g(this.a);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.yl
    public final void g0(String string) {
        int i;
        int i2 = anVar.a;
        i = i2 == 8 ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder(36);
        stringBuilder.append("Unexpected response type ");
        stringBuilder.append(i2);
        r.n(i, stringBuilder.toString());
        anVar2.n = string;
        sm smVar = new sm(this, string);
        m(smVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.yl
    public final void m1(String string) {
        int i;
        int i2 = anVar.a;
        i = i2 == 7 ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder(36);
        stringBuilder.append("Unexpected response type ");
        stringBuilder.append(i2);
        r.n(i, stringBuilder.toString());
        com.google.android.gms.internal.firebase-auth-api.an anVar2 = this.a;
        anVar2.m = string;
        an.g(anVar2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.yl
    public final void m2(com.google.android.gms.internal.firebase-auth-api.to to) {
        int i;
        int i2 = anVar.a;
        if (i2 == 1) {
        } else {
            i = 0;
        }
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append("Unexpected response type: ");
        stringBuilder.append(i2);
        r.n(i, stringBuilder.toString());
        com.google.android.gms.internal.firebase-auth-api.an anVar2 = this.a;
        anVar2.i = to;
        an.g(anVar2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.yl
    public final void r1(com.google.android.gms.internal.firebase-auth-api.vf vf) {
        n(vf.j2(), vf.k2(), vf.zzc(), vf.zzd());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.yl
    public final void v0(com.google.android.gms.internal.firebase-auth-api.fp fp) {
        int i;
        int i2 = anVar.a;
        i = i2 == 4 ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder(36);
        stringBuilder.append("Unexpected response type ");
        stringBuilder.append(i2);
        r.n(i, stringBuilder.toString());
        com.google.android.gms.internal.firebase-auth-api.an anVar2 = this.a;
        anVar2.l = fp;
        an.g(anVar2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.yl
    public final void x0(String string) {
        int i;
        int i2 = anVar.a;
        final int i3 = 1;
        i = i2 == 8 ? i3 : 0;
        StringBuilder stringBuilder = new StringBuilder(36);
        stringBuilder.append("Unexpected response type ");
        stringBuilder.append(i2);
        r.n(i, stringBuilder.toString());
        com.google.android.gms.internal.firebase-auth-api.an anVar2 = this.a;
        anVar2.n = string;
        an.k(anVar2, i3);
        um umVar = new um(this, string);
        m(umVar);
    }
}
