package com.google.android.gms.internal.firebase-auth-api;

import android.content.Context;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.l.a;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneMultiFactorInfo;

/* loaded from: classes2.dex */
public final class rl extends com.google.android.gms.internal.firebase-auth-api.bm {

    private static final a c;
    private final com.google.android.gms.internal.firebase-auth-api.sh a;
    private final com.google.android.gms.internal.firebase-auth-api.qn b;
    static {
        a aVar = new a("FirebaseAuth", /* result */);
        rl.c = aVar;
    }

    public rl(Context context, String string2) {
        super();
        r.j(context);
        r.f(string2);
        super(context, string2, nm.a(), 0, 0, 0);
        sh shVar = new sh(omVar2);
        this.a = shVar;
        qn obj11 = new qn(context);
        this.b = obj11;
    }

    private static boolean m(long l, boolean z2) {
        if (Long.compare(l, i) > 0 && obj4 == null) {
            if (obj4 == null) {
            }
            return 1;
        }
        final int obj3 = 0;
        rl.c.h("App hash will not be appended to the request.", new Object[obj3]);
        return obj3;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void B0(com.google.android.gms.internal.firebase-auth-api.rd rd, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(rd);
        r.f(rd.zza());
        r.f(rd.zzb());
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.B(rd.zza(), rd.zzb(), rd.zzc(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void B1(com.google.android.gms.internal.firebase-auth-api.ie ie, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(zl2);
        r.j(ie);
        PhoneAuthCredential phoneAuthCredential = ie.j2();
        r.j(phoneAuthCredential);
        final String obj5 = ie.zzb();
        r.f(obj5);
        nl nlVar = new nl(zl2, rl.c);
        this.a.J(0, obj5, gn.a((PhoneAuthCredential)phoneAuthCredential), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void C1(com.google.android.gms.internal.firebase-auth-api.td td, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(td);
        r.f(td.zza());
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.C(td.zza(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void D(com.google.android.gms.internal.firebase-auth-api.tf tf, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(tf);
        nl nlVar = new nl(zl2, rl.c);
        this.a.l(qo.b(tf.j2(), tf.zzb(), tf.zzc()), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void F0(com.google.android.gms.internal.firebase-auth-api.me me, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(me);
        r.f(me.zzb());
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.L(me.zzb(), me.j2(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void G1(com.google.android.gms.internal.firebase-auth-api.df df, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(df);
        r.j(df.j2());
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.d(df.j2(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void H0(com.google.android.gms.internal.firebase-auth-api.hd hd, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(hd);
        r.f(hd.zza());
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.w(hd.zza(), hd.zzb(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void H1(com.google.android.gms.internal.firebase-auth-api.yd yd, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(yd);
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.E(0, fo.a(yd.zzb(), yd.j2().zzg(), yd.j2().getSmsCode()), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void I1(com.google.android.gms.internal.firebase-auth-api.hf hf, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        String str;
        boolean obj10;
        r.j(hf);
        r.j(zl2);
        final String str5 = hf.zzd();
        nl nlVar2 = new nl(zl2, rl.c);
        if (this.b.l(str5) && hf.zzg()) {
            if (hf.zzg()) {
                this.b.j(str5);
            }
            this.b.i(nlVar2, str5);
        }
        final long l = hf.j2();
        final boolean z = hf.zzh();
        com.google.android.gms.internal.firebase-auth-api.op obj9 = op.a(hf.zzb(), hf.zzd(), hf.zzc(), hf.zze(), hf.zzf());
        if (rl.m(l, obj4)) {
            obj10 = new vn(this.b.c());
            obj9.c(obj10);
        }
        this.b.k(str5, nlVar2, l, obj4);
        nn nnVar = new nn(this.b, nlVar2, str5);
        this.a.f(obj9, nnVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void K(com.google.android.gms.internal.firebase-auth-api.jf jf, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        boolean z;
        boolean vnVar;
        Object obj;
        final Object obj2 = this;
        r.j(jf);
        r.j(zl2);
        String phoneNumber = jf.k2().getPhoneNumber();
        nl nlVar2 = new nl(zl2, rl.c);
        if (obj2.b.l(phoneNumber) && jf.zzg()) {
            if (jf.zzg()) {
                obj2.b.j(phoneNumber);
            }
            obj2.b.i(nlVar2, phoneNumber);
        }
        final long l = jf.j2();
        final boolean z3 = jf.zzh();
        com.google.android.gms.internal.firebase-auth-api.qp qpVar = qp.a(jf.zzd(), jf.k2().getUid(), jf.k2().getPhoneNumber(), jf.zzc(), jf.zze(), jf.zzf());
        if (rl.m(l, obj6)) {
            vnVar = new vn(obj2.b.c());
            qpVar.c(vnVar);
        }
        obj2.b.k(phoneNumber, nlVar2, l, obj6);
        nn nnVar = new nn(obj2.b, nlVar2, phoneNumber);
        obj2.a.g(qpVar, nnVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void N0(com.google.android.gms.internal.firebase-auth-api.ce ce, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(ce);
        r.f(ce.zza());
        nl nlVar = new nl(zl2, rl.c);
        this.a.G(ce.zza(), ce.zzb(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void O(com.google.android.gms.internal.firebase-auth-api.ae ae, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(ae);
        r.j(zl2);
        r.f(ae.zza());
        nl nlVar = new nl(zl2, rl.c);
        this.a.F(ae.zza(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void R0(com.google.android.gms.internal.firebase-auth-api.lf lf, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(lf);
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.h(lf.zza(), lf.zzb(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void R1(com.google.android.gms.internal.firebase-auth-api.jd jd, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(jd);
        r.f(jd.zza());
        r.f(jd.zzb());
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.x(jd.zza(), jd.zzb(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void S(com.google.android.gms.internal.firebase-auth-api.ld ld, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(ld);
        r.f(ld.zza());
        r.f(ld.zzb());
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.y(ld.zza(), ld.zzb(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void V1(com.google.android.gms.internal.firebase-auth-api.ee ee, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(ee);
        r.f(ee.zzb());
        r.f(ee.zzc());
        r.f(ee.zza());
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.H(ee.zzb(), ee.zzc(), ee.zza(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void Z(com.google.android.gms.internal.firebase-auth-api.ff ff, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(zl2);
        r.j(ff);
        PhoneAuthCredential obj4 = ff.j2();
        r.j(obj4);
        nl nlVar = new nl(zl2, rl.c);
        this.a.e(0, gn.a((PhoneAuthCredential)obj4), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void b2(com.google.android.gms.internal.firebase-auth-api.oe oe, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(oe);
        r.f(oe.zzb());
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.M(oe.zzb(), oe.j2(), oe.zzc(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void g1(com.google.android.gms.internal.firebase-auth-api.nd nd, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(nd);
        r.f(nd.zza());
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.z(nd.zza(), nd.zzb(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void h0(com.google.android.gms.internal.firebase-auth-api.qe qe, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        Object aVar;
        boolean obj10;
        r.j(zl2);
        r.j(qe);
        com.google.android.gms.internal.firebase-auth-api.hp obj9 = qe.j2();
        r.j(obj9);
        final String str2 = (hp)obj9.zzd();
        nl nlVar2 = new nl(zl2, rl.c);
        if (this.b.l(str2) && obj9.l2()) {
            if (obj9.l2()) {
                this.b.j(str2);
            }
            this.b.i(nlVar2, str2);
        }
        final long l = obj9.j2();
        final boolean z = obj9.zzg();
        if (rl.m(l, obj4)) {
            obj10 = new vn(this.b.c());
            obj9.k2(obj10);
        }
        this.b.k(str2, nlVar2, l, obj4);
        nn nnVar = new nn(this.b, nlVar2, str2);
        this.a.N(obj9, nnVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void j2(com.google.android.gms.internal.firebase-auth-api.nf nf, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(nf);
        r.f(nf.zza());
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.i(nf.zza(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void m0(com.google.android.gms.internal.firebase-auth-api.wd wd, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(wd);
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.D(0, do.a(wd.zzb(), wd.j2().zzg(), wd.j2().getSmsCode(), wd.zzc()), wd.zzb(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void n1(com.google.android.gms.internal.firebase-auth-api.se se, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(se);
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.O(se.zza(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void o(com.google.android.gms.internal.firebase-auth-api.ue ue, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(ue);
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.P(ue.zza(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void p0(com.google.android.gms.internal.firebase-auth-api.ge ge, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(ge);
        r.f(ge.zzb());
        r.j(ge.j2());
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.I(ge.zzb(), ge.j2(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void q(com.google.android.gms.internal.firebase-auth-api.pd pd, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(pd);
        r.f(pd.zza());
        r.f(pd.zzb());
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.A(pd.zza(), pd.zzb(), pd.zzc(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void r0(com.google.android.gms.internal.firebase-auth-api.pf pf, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(pf);
        r.f(pf.zzb());
        r.f(pf.zza());
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.j(pf.zzb(), pf.zza(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void t0(com.google.android.gms.internal.firebase-auth-api.bf bf, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(bf);
        r.f(bf.zza());
        r.f(bf.zzb());
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.c(0, bf.zza(), bf.zzb(), bf.zzc(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void t1(com.google.android.gms.internal.firebase-auth-api.xe xe, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(xe);
        r.j(xe.j2());
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.a(0, xe.j2(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void v(com.google.android.gms.internal.firebase-auth-api.ze ze, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(ze);
        r.f(ze.zzb());
        r.j(zl2);
        xp xpVar = new xp(ze.zzb(), ze.zza());
        nl nlVar = new nl(zl2, rl.c);
        this.a.b(xpVar, nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void v1(com.google.android.gms.internal.firebase-auth-api.rf rf, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(rf);
        r.f(rf.zzb());
        r.j(rf.j2());
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.k(rf.zzb(), rf.j2(), nlVar);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.bm
    public final void y(com.google.android.gms.internal.firebase-auth-api.ke ke, com.google.android.gms.internal.firebase-auth-api.zl zl2) {
        r.j(ke);
        r.f(ke.zza());
        r.j(zl2);
        nl nlVar = new nl(zl2, rl.c);
        this.a.K(ke.zza(), nlVar);
    }
}
