package com.google.android.gms.internal.firebase-auth-api;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.firebase.auth.ActionCodeSettings;

/* loaded from: classes2.dex */
final class om extends com.google.android.gms.internal.firebase-auth-api.dn implements com.google.android.gms.internal.firebase-auth-api.tn {

    private com.google.android.gms.internal.firebase-auth-api.em a;
    private com.google.android.gms.internal.firebase-auth-api.fm b;
    private com.google.android.gms.internal.firebase-auth-api.hn c;
    private final com.google.android.gms.internal.firebase-auth-api.nm d;
    private final Context e;
    private final String f;
    com.google.android.gms.internal.firebase-auth-api.pm g;
    om(Context context, String string2, com.google.android.gms.internal.firebase-auth-api.nm nm3, com.google.android.gms.internal.firebase-auth-api.hn hn4, com.google.android.gms.internal.firebase-auth-api.em em5, com.google.android.gms.internal.firebase-auth-api.fm fm6) {
        super();
        r.j(context);
        this.e = (Context)context.getApplicationContext();
        r.f(string2);
        this.f = string2;
        r.j(nm3);
        this.d = (nm)nm3;
        int obj1 = 0;
        v(obj1, obj1, obj1);
        un.e(string2, this);
    }

    private final com.google.android.gms.internal.firebase-auth-api.pm u() {
        com.google.android.gms.internal.firebase-auth-api.pm pmVar;
        Context context;
        String str;
        if (this.g == null) {
            pmVar = new pm(this.e, this.d.b());
            this.g = pmVar;
        }
        return this.g;
    }

    private final void v(com.google.android.gms.internal.firebase-auth-api.hn hn, com.google.android.gms.internal.firebase-auth-api.em em2, com.google.android.gms.internal.firebase-auth-api.fm fm3) {
        String str;
        int length;
        String obj3;
        boolean obj4;
        Object obj5;
        obj3 = 0;
        this.c = obj3;
        this.a = obj3;
        this.b = obj3;
        obj3 = rn.a("firebear.secureToken");
        obj5 = "LocalClient";
        if (TextUtils.isEmpty(obj3)) {
            obj3 = un.d(this.f);
        } else {
            obj4 = String.valueOf(obj3);
            str = "Found hermetic configuration for secureToken URL: ";
            if (obj4.length() != 0) {
                obj4 = str.concat(obj4);
            } else {
                obj4 = new String(str);
            }
            Log.e(obj5, obj4);
        }
        if (this.c == null) {
            obj4 = new hn(obj3, u());
            this.c = obj4;
        }
        obj3 = rn.a("firebear.identityToolkit");
        if (TextUtils.isEmpty(obj3)) {
            obj3 = un.b(this.f);
        } else {
            obj4 = String.valueOf(obj3);
            str = "Found hermetic configuration for identityToolkit URL: ";
            if (obj4.length() != 0) {
                obj4 = str.concat(obj4);
            } else {
                obj4 = new String(str);
            }
            Log.e(obj5, obj4);
        }
        if (this.a == null) {
            obj4 = new em(obj3, u());
            this.a = obj4;
        }
        obj3 = rn.a("firebear.identityToolkitV2");
        if (TextUtils.isEmpty(obj3)) {
            obj3 = un.c(this.f);
        } else {
            obj4 = String.valueOf(obj3);
            str = "Found hermetic configuration for identityToolkitV2 URL: ";
            if (obj4.length() != 0) {
                obj4 = str.concat(obj4);
            } else {
                obj4 = new String(str);
            }
            Log.e(obj5, obj4);
        }
        if (this.b == null) {
            obj4 = new fm(obj3, u());
            this.b = obj4;
        }
    }

    public final void a(com.google.android.gms.internal.firebase-auth-api.xn xn, com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.yn> cn2) {
        r.j(xn);
        r.j(cn2);
        com.google.android.gms.internal.firebase-auth-api.em emVar = this.a;
        en.a(emVar.a("/createAuthUri", this.f), xn, cn2, yn.class, emVar.b);
    }

    public final void b(com.google.android.gms.internal.firebase-auth-api.ao ao, com.google.android.gms.internal.firebase-auth-api.cn<Void> cn2) {
        r.j(ao);
        r.j(cn2);
        com.google.android.gms.internal.firebase-auth-api.em emVar = this.a;
        en.a(emVar.a("/deleteAccount", this.f), ao, cn2, Void.class, emVar.b);
    }

    public final void c(com.google.android.gms.internal.firebase-auth-api.bo bo, com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.co> cn2) {
        r.j(bo);
        r.j(cn2);
        com.google.android.gms.internal.firebase-auth-api.em emVar = this.a;
        en.a(emVar.a("/emailLinkSignin", this.f), bo, cn2, co.class, emVar.b);
    }

    public final void d(Context context, com.google.android.gms.internal.firebase-auth-api.do do2, com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.eo> cn3) {
        r.j(do2);
        r.j(cn3);
        com.google.android.gms.internal.firebase-auth-api.fm obj3 = this.b;
        en.a(obj3.a("/mfaEnrollment:finalize", this.f), do2, cn3, eo.class, obj3.b);
    }

    public final void e(Context context, com.google.android.gms.internal.firebase-auth-api.fo fo2, com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.go> cn3) {
        r.j(fo2);
        r.j(cn3);
        com.google.android.gms.internal.firebase-auth-api.fm obj3 = this.b;
        en.a(obj3.a("/mfaSignIn:finalize", this.f), fo2, cn3, go.class, obj3.b);
    }

    public final void f(com.google.android.gms.internal.firebase-auth-api.io io, com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.to> cn2) {
        r.j(io);
        r.j(cn2);
        com.google.android.gms.internal.firebase-auth-api.hn hnVar = this.c;
        en.a(hnVar.a("/token", this.f), io, cn2, to.class, hnVar.b);
    }

    public final void g(com.google.android.gms.internal.firebase-auth-api.jo jo, com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.ko> cn2) {
        r.j(jo);
        r.j(cn2);
        com.google.android.gms.internal.firebase-auth-api.em emVar = this.a;
        en.a(emVar.a("/getAccountInfo", this.f), jo, cn2, ko.class, emVar.b);
    }

    public final void h(com.google.android.gms.internal.firebase-auth-api.qo qo, com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.ro> cn2) {
        Object set;
        String str;
        r.j(qo);
        r.j(cn2);
        if (qo.a() != null) {
            u().c(qo.a().zze());
        }
        com.google.android.gms.internal.firebase-auth-api.em emVar = this.a;
        en.a(emVar.a("/getOobConfirmationCode", this.f), qo, cn2, ro.class, emVar.b);
    }

    public final void i(com.google.android.gms.internal.firebase-auth-api.ep ep, com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.fp> cn2) {
        r.j(ep);
        r.j(cn2);
        com.google.android.gms.internal.firebase-auth-api.em emVar = this.a;
        en.a(emVar.a("/resetPassword", this.f), ep, cn2, fp.class, emVar.b);
    }

    public final void j(com.google.android.gms.internal.firebase-auth-api.hp hp, com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.jp> cn2) {
        boolean empty;
        String str;
        r.j(hp);
        r.j(cn2);
        if (!TextUtils.isEmpty(hp.zzc())) {
            u().c(hp.zzc());
        }
        com.google.android.gms.internal.firebase-auth-api.em emVar = this.a;
        en.a(emVar.a("/sendVerificationCode", this.f), hp, cn2, jp.class, emVar.b);
    }

    public final void k(com.google.android.gms.internal.firebase-auth-api.kp kp, com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.lp> cn2) {
        r.j(kp);
        r.j(cn2);
        com.google.android.gms.internal.firebase-auth-api.em emVar = this.a;
        en.a(emVar.a("/setAccountInfo", this.f), kp, cn2, lp.class, emVar.b);
    }

    public final void l(String string, com.google.android.gms.internal.firebase-auth-api.cn<Void> cn2) {
        r.j(cn2);
        u().b(string);
        cn2.a.m();
    }

    public final void m(com.google.android.gms.internal.firebase-auth-api.mp mp, com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.np> cn2) {
        r.j(mp);
        r.j(cn2);
        com.google.android.gms.internal.firebase-auth-api.em emVar = this.a;
        en.a(emVar.a("/signupNewUser", this.f), mp, cn2, np.class, emVar.b);
    }

    public final void n(com.google.android.gms.internal.firebase-auth-api.op op, com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.pp> cn2) {
        boolean empty;
        String str;
        r.j(op);
        r.j(cn2);
        if (!TextUtils.isEmpty(op.b())) {
            u().c(op.b());
        }
        com.google.android.gms.internal.firebase-auth-api.fm fmVar = this.b;
        en.a(fmVar.a("/mfaEnrollment:start", this.f), op, cn2, pp.class, fmVar.b);
    }

    public final void o(com.google.android.gms.internal.firebase-auth-api.qp qp, com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.rp> cn2) {
        boolean empty;
        String str;
        r.j(qp);
        r.j(cn2);
        if (!TextUtils.isEmpty(qp.b())) {
            u().c(qp.b());
        }
        com.google.android.gms.internal.firebase-auth-api.fm fmVar = this.b;
        en.a(fmVar.a("/mfaSignIn:start", this.f), qp, cn2, rp.class, fmVar.b);
    }

    public final void p(Context context, com.google.android.gms.internal.firebase-auth-api.up up2, com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.wp> cn3) {
        r.j(up2);
        r.j(cn3);
        com.google.android.gms.internal.firebase-auth-api.em obj3 = this.a;
        en.a(obj3.a("/verifyAssertion", this.f), up2, cn3, wp.class, obj3.b);
    }

    public final void q(com.google.android.gms.internal.firebase-auth-api.xp xp, com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.yp> cn2) {
        r.j(xp);
        r.j(cn2);
        com.google.android.gms.internal.firebase-auth-api.em emVar = this.a;
        en.a(emVar.a("/verifyCustomToken", this.f), xp, cn2, yp.class, emVar.b);
    }

    public final void r(Context context, com.google.android.gms.internal.firebase-auth-api.aq aq2, com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.bq> cn3) {
        r.j(aq2);
        r.j(cn3);
        com.google.android.gms.internal.firebase-auth-api.em obj3 = this.a;
        en.a(obj3.a("/verifyPassword", this.f), aq2, cn3, bq.class, obj3.b);
    }

    public final void s(Context context, com.google.android.gms.internal.firebase-auth-api.cq cq2, com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.dq> cn3) {
        r.j(cq2);
        r.j(cn3);
        com.google.android.gms.internal.firebase-auth-api.em obj3 = this.a;
        en.a(obj3.a("/verifyPhoneNumber", this.f), cq2, cn3, dq.class, obj3.b);
    }

    public final void t(com.google.android.gms.internal.firebase-auth-api.fq fq, com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.gq> cn2) {
        r.j(fq);
        r.j(cn2);
        com.google.android.gms.internal.firebase-auth-api.fm fmVar = this.b;
        en.a(fmVar.a("/mfaEnrollment:withdraw", this.f), fq, cn2, gq.class, fmVar.b);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dn
    public final void zzi() {
        final int i = 0;
        v(i, i, i);
    }
}
