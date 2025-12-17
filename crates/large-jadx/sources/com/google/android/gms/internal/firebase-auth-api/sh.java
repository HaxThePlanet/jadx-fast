package com.google.android.gms.internal.firebase-auth-api;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* loaded from: classes2.dex */
public final class sh {

    private final com.google.android.gms.internal.firebase-auth-api.dn a;
    public sh(com.google.android.gms.internal.firebase-auth-api.dn dn) {
        super();
        r.j(dn);
        this.a = (dn)dn;
    }

    private final void m(String string, com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.to> cn2) {
        r.j(cn2);
        r.f(string);
        com.google.android.gms.internal.firebase-auth-api.to obj3 = to.l2(string);
        if (obj3.n2()) {
            cn2.b(obj3);
        }
        io ioVar = new io(obj3.zzf());
        rh rhVar = new rh(this, cn2);
        this.a.f(ioVar, rhVar);
    }

    private final void n(com.google.android.gms.internal.firebase-auth-api.bo bo, com.google.android.gms.internal.firebase-auth-api.nl nl2) {
        r.j(bo);
        r.j(nl2);
        dg dgVar = new dg(this, nl2);
        this.a.c(bo, dgVar);
    }

    private final void o(com.google.android.gms.internal.firebase-auth-api.to to, String string2, String string3, Boolean boolean4, zze zze5, com.google.android.gms.internal.firebase-auth-api.nl nl6, com.google.android.gms.internal.firebase-auth-api.bn bn7) {
        r.j(to);
        r.j(bn7);
        r.j(nl6);
        jo joVar = new jo(to.zze());
        super(this, bn7, string3, string2, boolean4, zze5, nl6, to);
        obj.a.g(joVar, ggVar2);
    }

    private final void p(com.google.android.gms.internal.firebase-auth-api.qo qo, com.google.android.gms.internal.firebase-auth-api.nl nl2) {
        r.j(qo);
        r.j(nl2);
        kh khVar = new kh(this, nl2);
        this.a.h(qo, khVar);
    }

    static com.google.android.gms.internal.firebase-auth-api.dn q(com.google.android.gms.internal.firebase-auth-api.sh sh) {
        return sh.a;
    }

    static void r(com.google.android.gms.internal.firebase-auth-api.sh sh, com.google.android.gms.internal.firebase-auth-api.to to2, String string3, String string4, Boolean boolean5, zze zze6, com.google.android.gms.internal.firebase-auth-api.nl nl7, com.google.android.gms.internal.firebase-auth-api.bn bn8) {
        sh.o(to2, 0, string4, boolean5, 0, nl7, bn8);
    }

    static void s(com.google.android.gms.internal.firebase-auth-api.sh sh, com.google.android.gms.internal.firebase-auth-api.wp wp2, com.google.android.gms.internal.firebase-auth-api.nl nl3, com.google.android.gms.internal.firebase-auth-api.bn bn4) {
        boolean z;
        Status obj11;
        if (wp2.o()) {
            if (wp2.m()) {
                obj11 = new Status(17012);
            } else {
                obj11 = zzai.zza(wp2.d());
            }
            vf vfVar = new vf(obj11, wp2.b(), wp2.c(), wp2.j());
            nl3.e(vfVar);
        }
        to toVar = new to(wp2.i(), wp2.e(), Long.valueOf(wp2.a()), "Bearer");
        sh.o(toVar, wp2.h(), wp2.g(), Boolean.valueOf(wp2.n()), wp2.b(), nl3, bn4);
    }

    static void t(com.google.android.gms.internal.firebase-auth-api.sh sh, com.google.android.gms.internal.firebase-auth-api.nl nl2, com.google.android.gms.internal.firebase-auth-api.to to3, com.google.android.gms.internal.firebase-auth-api.kp kp4, com.google.android.gms.internal.firebase-auth-api.bn bn5) {
        r.j(nl2);
        r.j(to3);
        r.j(kp4);
        r.j(bn5);
        jo joVar = new jo(to3.zze());
        super(sh, bn5, nl2, to3, kp4);
        sh.a.g(joVar, egVar2);
    }

    static void u(com.google.android.gms.internal.firebase-auth-api.sh sh, com.google.android.gms.internal.firebase-auth-api.bo bo2, com.google.android.gms.internal.firebase-auth-api.nl nl3) {
        sh.n(bo2, nl3);
    }

    static void v(com.google.android.gms.internal.firebase-auth-api.sh sh, com.google.android.gms.internal.firebase-auth-api.nl nl2, com.google.android.gms.internal.firebase-auth-api.to to3, com.google.android.gms.internal.firebase-auth-api.mo mo4, com.google.android.gms.internal.firebase-auth-api.kp kp5, com.google.android.gms.internal.firebase-auth-api.bn bn6) {
        r.j(nl2);
        r.j(to3);
        r.j(mo4);
        r.j(kp5);
        r.j(bn6);
        super(sh, kp5, mo4, nl2, to3, bn6);
        sh.a.k(kp5, fgVar2);
    }

    public final void A(String string, String string2, String string3, com.google.android.gms.internal.firebase-auth-api.nl nl4) {
        r.f(string);
        r.f(string2);
        r.j(nl4);
        ep epVar = new ep(string, string2, string3);
        lg obj3 = new lg(this, nl4);
        this.a.i(epVar, obj3);
    }

    public final void B(String string, String string2, String string3, com.google.android.gms.internal.firebase-auth-api.nl nl4) {
        r.f(string);
        r.f(string2);
        r.j(nl4);
        mp mpVar = new mp(string, string2, 0, string3);
        ag obj4 = new ag(this, nl4);
        this.a.m(mpVar, obj4);
    }

    public final void C(String string, com.google.android.gms.internal.firebase-auth-api.nl nl2) {
        r.f(string);
        r.j(nl2);
        ih ihVar = new ih(this, nl2);
        m(string, ihVar);
    }

    public final void D(Context context, com.google.android.gms.internal.firebase-auth-api.do do2, String string3, com.google.android.gms.internal.firebase-auth-api.nl nl4) {
        r.j(do2);
        r.j(nl4);
        ch obj2 = new ch(this, do2, 0, nl4);
        m(string3, obj2);
    }

    public final void E(Context context, com.google.android.gms.internal.firebase-auth-api.fo fo2, com.google.android.gms.internal.firebase-auth-api.nl nl3) {
        r.j(fo2);
        r.j(nl3);
        dh dhVar = new dh(this, nl3);
        this.a.e(0, fo2, dhVar);
    }

    public final void F(String string, com.google.android.gms.internal.firebase-auth-api.nl nl2) {
        r.f(string);
        r.j(nl2);
        io ioVar = new io(string);
        kg kgVar = new kg(this, nl2);
        this.a.f(ioVar, kgVar);
    }

    public final void G(String string, String string2, com.google.android.gms.internal.firebase-auth-api.nl nl3) {
        r.f(string);
        r.j(nl3);
        xn xnVar = new xn(string, string2);
        hg obj3 = new hg(this, nl3);
        this.a.a(xnVar, obj3);
    }

    public final void H(String string, String string2, String string3, com.google.android.gms.internal.firebase-auth-api.nl nl4) {
        r.f(string);
        r.f(string2);
        r.f(string3);
        r.j(nl4);
        og ogVar = new og(this, string, string2, nl4);
        m(string3, ogVar);
    }

    public final void I(String string, com.google.android.gms.internal.firebase-auth-api.up up2, com.google.android.gms.internal.firebase-auth-api.nl nl3) {
        r.f(string);
        r.j(up2);
        r.j(nl3);
        sg sgVar = new sg(this, up2, nl3);
        m(string, sgVar);
    }

    public final void J(Context context, String string2, com.google.android.gms.internal.firebase-auth-api.cq cq3, com.google.android.gms.internal.firebase-auth-api.nl nl4) {
        r.f(string2);
        r.j(cq3);
        r.j(nl4);
        qg obj2 = new qg(this, cq3, 0, nl4);
        m(string2, obj2);
    }

    public final void K(String string, com.google.android.gms.internal.firebase-auth-api.nl nl2) {
        r.f(string);
        r.j(nl2);
        gh ghVar = new gh(this, nl2);
        m(string, ghVar);
    }

    public final void L(String string, ActionCodeSettings actionCodeSettings2, com.google.android.gms.internal.firebase-auth-api.nl nl3) {
        r.f(string);
        r.j(nl3);
        qo qoVar = new qo(4);
        qoVar.f(string);
        if (actionCodeSettings2 != null) {
            qoVar.c(actionCodeSettings2);
        }
        p(qoVar, nl3);
    }

    public final void M(String string, ActionCodeSettings actionCodeSettings2, String string3, com.google.android.gms.internal.firebase-auth-api.nl nl4) {
        r.f(string);
        r.j(nl4);
        qo qoVar = new qo(actionCodeSettings2.zza());
        qoVar.d(string);
        qoVar.c(actionCodeSettings2);
        qoVar.e(string3);
        ig obj4 = new ig(this, nl4);
        this.a.h(qoVar, obj4);
    }

    public final void N(com.google.android.gms.internal.firebase-auth-api.hp hp, com.google.android.gms.internal.firebase-auth-api.nl nl2) {
        r.f(hp.zzd());
        r.j(nl2);
        mg mgVar = new mg(this, nl2);
        this.a.j(hp, mgVar);
    }

    public final void O(String string, com.google.android.gms.internal.firebase-auth-api.nl nl2) {
        r.j(nl2);
        jh jhVar = new jh(this, nl2);
        this.a.l(string, jhVar);
    }

    public final void P(String string, com.google.android.gms.internal.firebase-auth-api.nl nl2) {
        r.j(nl2);
        mp mpVar = new mp(string);
        mh mhVar = new mh(this, nl2);
        this.a.m(mpVar, mhVar);
    }

    public final void a(Context context, com.google.android.gms.internal.firebase-auth-api.up up2, com.google.android.gms.internal.firebase-auth-api.nl nl3) {
        r.j(up2);
        r.j(nl3);
        up2.l2(true);
        lh lhVar = new lh(this, nl3);
        this.a.p(0, up2, lhVar);
    }

    public final void b(com.google.android.gms.internal.firebase-auth-api.xp xp, com.google.android.gms.internal.firebase-auth-api.nl nl2) {
        r.j(xp);
        r.j(nl2);
        ah ahVar = new ah(this, nl2);
        this.a.q(xp, ahVar);
    }

    public final void c(Context context, String string2, String string3, String string4, com.google.android.gms.internal.firebase-auth-api.nl nl5) {
        r.f(string2);
        r.f(string3);
        r.j(nl5);
        aq obj1 = new aq(string2, string3, string4);
        bg obj3 = new bg(this, nl5);
        this.a.r(0, obj1, obj3);
    }

    public final void d(EmailAuthCredential emailAuthCredential, com.google.android.gms.internal.firebase-auth-api.nl nl2) {
        r.j(emailAuthCredential);
        r.j(nl2);
        if (emailAuthCredential.zzh()) {
            cg cgVar = new cg(this, emailAuthCredential, nl2);
            m(emailAuthCredential.zzc(), cgVar);
        }
        bo boVar = new bo(emailAuthCredential, 0);
        n(boVar, nl2);
    }

    public final void e(Context context, com.google.android.gms.internal.firebase-auth-api.cq cq2, com.google.android.gms.internal.firebase-auth-api.nl nl3) {
        r.j(cq2);
        r.j(nl3);
        ng ngVar = new ng(this, nl3);
        this.a.s(0, cq2, ngVar);
    }

    public final void f(com.google.android.gms.internal.firebase-auth-api.op op, com.google.android.gms.internal.firebase-auth-api.nl nl2) {
        r.j(op);
        r.j(nl2);
        zg zgVar = new zg(this, nl2);
        this.a.n(op, zgVar);
    }

    public final void g(com.google.android.gms.internal.firebase-auth-api.qp qp, com.google.android.gms.internal.firebase-auth-api.nl nl2) {
        r.j(qp);
        r.j(nl2);
        eh ehVar = new eh(this, nl2);
        this.a.o(qp, ehVar);
    }

    public final void h(String string, String string2, com.google.android.gms.internal.firebase-auth-api.nl nl3) {
        r.f(string);
        r.f(string2);
        r.j(nl3);
        xg xgVar = new xg(this, string2, nl3);
        m(string, xgVar);
    }

    public final void i(String string, com.google.android.gms.internal.firebase-auth-api.nl nl2) {
        r.f(string);
        r.j(nl2);
        tg tgVar = new tg(this, nl2);
        m(string, tgVar);
    }

    public final void j(String string, String string2, com.google.android.gms.internal.firebase-auth-api.nl nl3) {
        r.f(string);
        r.f(string2);
        r.j(nl3);
        vg vgVar = new vg(this, string, nl3);
        m(string2, vgVar);
    }

    public final void k(String string, UserProfileChangeRequest userProfileChangeRequest2, com.google.android.gms.internal.firebase-auth-api.nl nl3) {
        r.f(string);
        r.j(userProfileChangeRequest2);
        r.j(nl3);
        nh nhVar = new nh(this, userProfileChangeRequest2, nl3);
        m(string, nhVar);
    }

    public final void l(com.google.android.gms.internal.firebase-auth-api.qo qo, com.google.android.gms.internal.firebase-auth-api.nl nl2) {
        p(qo, nl2);
    }

    public final void w(String string, String string2, com.google.android.gms.internal.firebase-auth-api.nl nl3) {
        r.f(string);
        r.j(nl3);
        kp kpVar = new kp();
        kpVar.e(string);
        kpVar.h(string2);
        qh obj3 = new qh(this, nl3);
        this.a.k(kpVar, obj3);
    }

    public final void x(String string, String string2, com.google.android.gms.internal.firebase-auth-api.nl nl3) {
        r.f(string);
        r.f(string2);
        r.j(nl3);
        oh ohVar = new oh(this, string2, nl3);
        m(string, ohVar);
    }

    public final void y(String string, String string2, com.google.android.gms.internal.firebase-auth-api.nl nl3) {
        r.f(string);
        r.f(string2);
        r.j(nl3);
        ph phVar = new ph(this, string2, nl3);
        m(string, phVar);
    }

    public final void z(String string, String string2, com.google.android.gms.internal.firebase-auth-api.nl nl3) {
        r.f(string);
        r.j(nl3);
        ep epVar = new ep(string, 0, string2);
        jg obj4 = new jg(this, nl3);
        this.a.i(epVar, obj4);
    }
}
