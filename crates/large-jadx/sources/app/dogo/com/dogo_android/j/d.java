package app.dogo.com.dogo_android.j;

import java.util.HashSet;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;
import kotlin.y.p;
import m.a.c.e.a;
import m.a.c.e.b;
import m.a.c.e.d;
import m.a.c.f.a;
import m.a.c.f.d;
import m.a.c.h.a;
import m.a.c.k.c;
import m.a.c.k.c.a;
import m.a.d.b;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"appModule", "Lorg/koin/core/module/Module;", "getAppModule", "()Lorg/koin/core/module/Module;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class d {

    private static final a a;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Lorg/koin/core/module/Module;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<a, w> {

        public static final app.dogo.com.dogo_android.j.d.a a;
        static {
            d.a aVar = new d.a();
            d.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(a a) {
            boolean z2;
            boolean z10;
            boolean z17;
            boolean z42;
            boolean z27;
            boolean z40;
            boolean z44;
            boolean z6;
            boolean z25;
            boolean z47;
            boolean z;
            boolean z13;
            boolean z5;
            boolean z11;
            boolean z45;
            boolean z19;
            boolean z7;
            boolean z8;
            boolean z28;
            boolean z14;
            boolean z43;
            boolean z4;
            boolean z33;
            boolean z41;
            boolean z38;
            boolean z37;
            boolean z18;
            boolean z9;
            boolean z29;
            boolean z39;
            boolean z20;
            boolean z22;
            boolean z35;
            boolean z15;
            boolean z24;
            boolean z16;
            boolean z26;
            boolean z32;
            boolean z36;
            boolean z21;
            boolean z46;
            boolean z3;
            boolean z23;
            boolean z30;
            boolean z31;
            boolean z12;
            boolean z34;
            n.f(a, "$this$module");
            final d singleton = d.Singleton;
            final c.a aVar146 = c.e;
            super(aVar146.a(), c0.b(p2.class), 0, d.a.k.a, singleton, p.g());
            int i191 = 0;
            d dVar235 = new d(aVar);
            a.f(a, b.a(aVar.b(), i191, aVar146.a()), dVar235, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar235);
            }
            a aVar2 = new a(aVar146.a(), c0.b(Resources.class), 0, d.a.v.a, singleton, p.g());
            d dVar2 = new d(aVar100);
            a.f(a, b.a(aVar100.b(), i191, aVar146.a()), dVar2, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar2);
            }
            super(aVar146.a(), c0.b(PackageManager.class), 0, d.a.g0.a, singleton, p.g());
            d dVar4 = new d(aVar101);
            a.f(a, b.a(aVar101.b(), i191, aVar146.a()), dVar4, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar4);
            }
            m.a.c.j.c cVar = aVar146.a();
            super(cVar, c0.b(i.class), 0, d.a.q0.a, d.Factory, p.g());
            a aVar97 = new a(aVar51);
            a.f(a, b.a(aVar51.b(), i191, cVar), aVar97, false, 4, 0);
            super(aVar146.a(), c0.b(o3.class), 0, d.a.r0.a, singleton, p.g());
            d dVar6 = new d(aVar102);
            a.f(a, b.a(aVar102.b(), i191, aVar146.a()), dVar6, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar6);
            }
            super(aVar146.a(), c0.b(v2.class), 0, d.a.s0.a, singleton, p.g());
            d dVar8 = new d(aVar103);
            a.f(a, b.a(aVar103.b(), i191, aVar146.a()), dVar8, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar8);
            }
            super(aVar146.a(), c0.b(k.class), 0, d.a.t0.a, singleton, p.g());
            d dVar10 = new d(aVar104);
            a.f(a, b.a(aVar104.b(), i191, aVar146.a()), dVar10, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar10);
            }
            super(aVar146.a(), c0.b(ConnectivityManager.class), 0, d.a.u0.a, singleton, p.g());
            d dVar12 = new d(aVar105);
            a.f(a, b.a(aVar105.b(), i191, aVar146.a()), dVar12, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar12);
            }
            super(aVar146.a(), c0.b(p.class), 0, d.a.v0.a, singleton, p.g());
            d dVar14 = new d(aVar106);
            a.f(a, b.a(aVar106.b(), i191, aVar146.a()), dVar14, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar14);
            }
            super(aVar146.a(), c0.b(b.class), 0, d.a.a.a, singleton, p.g());
            d dVar16 = new d(aVar107);
            a.f(a, b.a(aVar107.b(), i191, aVar146.a()), dVar16, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar16);
            }
            super(aVar146.a(), c0.b(l2.class), 0, d.a.b.a, singleton, p.g());
            d dVar18 = new d(aVar108);
            a.f(a, b.a(aVar108.b(), i191, aVar146.a()), dVar18, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar18);
            }
            super(aVar146.a(), c0.b(t2.class), 0, d.a.c.a, singleton, p.g());
            d dVar20 = new d(aVar109);
            a.f(a, b.a(aVar109.b(), i191, aVar146.a()), dVar20, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar20);
            }
            super(aVar146.a(), c0.b(o2.class), 0, d.a.d.a, singleton, p.g());
            d dVar22 = new d(aVar110);
            a.f(a, b.a(aVar110.b(), i191, aVar146.a()), dVar22, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar22);
            }
            super(aVar146.a(), c0.b(k2.class), 0, d.a.e.a, singleton, p.g());
            d dVar24 = new d(aVar111);
            a.f(a, b.a(aVar111.b(), i191, aVar146.a()), dVar24, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar24);
            }
            super(aVar146.a(), c0.b(u2.class), 0, d.a.f.a, singleton, p.g());
            d dVar26 = new d(aVar112);
            a.f(a, b.a(aVar112.b(), i191, aVar146.a()), dVar26, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar26);
            }
            super(aVar146.a(), c0.b(a1.class), 0, d.a.g.a, singleton, p.g());
            d dVar28 = new d(aVar113);
            a.f(a, b.a(aVar113.b(), i191, aVar146.a()), dVar28, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar28);
            }
            super(aVar146.a(), c0.b(j.class), 0, d.a.h.a, singleton, p.g());
            d dVar30 = new d(aVar114);
            a.f(a, b.a(aVar114.b(), i191, aVar146.a()), dVar30, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar30);
            }
            super(aVar146.a(), c0.b(h2.class), 0, d.a.i.a, singleton, p.g());
            d dVar32 = new d(aVar115);
            a.f(a, b.a(aVar115.b(), i191, aVar146.a()), dVar32, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar32);
            }
            super(aVar146.a(), c0.b(m2.class), 0, d.a.j.a, singleton, p.g());
            d dVar34 = new d(aVar116);
            a.f(a, b.a(aVar116.b(), i191, aVar146.a()), dVar34, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar34);
            }
            super(aVar146.a(), c0.b(VimeoClient.class), 0, d.a.l.a, singleton, p.g());
            d dVar36 = new d(aVar117);
            a.f(a, b.a(aVar117.b(), i191, aVar146.a()), dVar36, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar36);
            }
            super(aVar146.a(), c0.b(r2.class), 0, d.a.m.a, singleton, p.g());
            d dVar38 = new d(aVar118);
            a.f(a, b.a(aVar118.b(), i191, aVar146.a()), dVar38, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar38);
            }
            super(aVar146.a(), c0.b(FirebaseDatabase.class), 0, d.a.n.a, singleton, p.g());
            d dVar40 = new d(aVar119);
            a.f(a, b.a(aVar119.b(), i191, aVar146.a()), dVar40, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar40);
            }
            super(aVar146.a(), c0.b(q2.class), 0, d.a.o.a, singleton, p.g());
            d dVar42 = new d(aVar120);
            a.f(a, b.a(aVar120.b(), i191, aVar146.a()), dVar42, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar42);
            }
            super(aVar146.a(), c0.b(a.class), 0, d.a.p.a, singleton, p.g());
            d dVar44 = new d(aVar121);
            a.f(a, b.a(aVar121.b(), i191, aVar146.a()), dVar44, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar44);
            }
            super(aVar146.a(), c0.b(j2.class), 0, d.a.q.a, singleton, p.g());
            d dVar46 = new d(aVar122);
            a.f(a, b.a(aVar122.b(), i191, aVar146.a()), dVar46, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar46);
            }
            super(aVar146.a(), c0.b(b.class), 0, d.a.r.a, singleton, p.g());
            d dVar48 = new d(aVar123);
            a.f(a, b.a(aVar123.b(), i191, aVar146.a()), dVar48, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar48);
            }
            super(aVar146.a(), c0.b(s2.class), 0, d.a.s.a, singleton, p.g());
            d dVar50 = new d(aVar124);
            a.f(a, b.a(aVar124.b(), i191, aVar146.a()), dVar50, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar50);
            }
            super(aVar146.a(), c0.b(FirebaseAuth.class), 0, d.a.t.a, singleton, p.g());
            d dVar52 = new d(aVar125);
            a.f(a, b.a(aVar125.b(), i191, aVar146.a()), dVar52, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar52);
            }
            super(aVar146.a(), c0.b(FirebaseFirestore.class), 0, d.a.u.a, singleton, p.g());
            d dVar54 = new d(aVar126);
            a.f(a, b.a(aVar126.b(), i191, aVar146.a()), dVar54, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar54);
            }
            super(aVar146.a(), c0.b(FirebaseRemoteConfig.class), 0, d.a.w.a, singleton, p.g());
            d dVar56 = new d(aVar127);
            a.f(a, b.a(aVar127.b(), i191, aVar146.a()), dVar56, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar56);
            }
            super(aVar146.a(), c0.b(FirebaseFunctions.class), 0, d.a.x.a, singleton, p.g());
            d dVar58 = new d(aVar128);
            a.f(a, b.a(aVar128.b(), i191, aVar146.a()), dVar58, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar58);
            }
            super(aVar146.a(), c0.b(i2.class), 0, d.a.y.a, singleton, p.g());
            d dVar60 = new d(aVar129);
            a.f(a, b.a(aVar129.b(), i191, aVar146.a()), dVar60, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar60);
            }
            super(aVar146.a(), c0.b(Purchases.class), 0, d.a.z.a, singleton, p.g());
            d dVar62 = new d(aVar130);
            a.f(a, b.a(aVar130.b(), i191, aVar146.a()), dVar62, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar62);
            }
            super(aVar146.a(), c0.b(g.class), 0, d.a.a0.a, singleton, p.g());
            d dVar64 = new d(aVar131);
            a.f(a, b.a(aVar131.b(), i191, aVar146.a()), dVar64, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar64);
            }
            super(aVar146.a(), c0.b(FirebaseAnalytics.class), 0, d.a.b0.a, singleton, p.g());
            d dVar66 = new d(aVar132);
            a.f(a, b.a(aVar132.b(), i191, aVar146.a()), dVar66, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar66);
            }
            super(aVar146.a(), c0.b(AppsFlyerLib.class), 0, d.a.c0.a, singleton, p.g());
            d dVar68 = new d(aVar133);
            a.f(a, b.a(aVar133.b(), i191, aVar146.a()), dVar68, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar68);
            }
            super(aVar146.a(), c0.b(FirebasePerformance.class), 0, d.a.d0.a, singleton, p.g());
            d dVar70 = new d(aVar134);
            a.f(a, b.a(aVar134.b(), i191, aVar146.a()), dVar70, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar70);
            }
            super(aVar146.a(), c0.b(FirebaseMessaging.class), 0, d.a.e0.a, singleton, p.g());
            d dVar72 = new d(aVar135);
            a.f(a, b.a(aVar135.b(), i191, aVar146.a()), dVar72, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar72);
            }
            super(aVar146.a(), c0.b(f.class), 0, d.a.f0.a, singleton, p.g());
            d dVar74 = new d(aVar136);
            a.f(a, b.a(aVar136.b(), i191, aVar146.a()), dVar74, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar74);
            }
            super(aVar146.a(), c0.b(Zendesk.class), 0, d.a.h0.a, singleton, p.g());
            d dVar76 = new d(aVar137);
            a.f(a, b.a(aVar137.b(), i191, aVar146.a()), dVar76, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar76);
            }
            super(aVar146.a(), c0.b(Support.class), 0, d.a.i0.a, singleton, p.g());
            d dVar78 = new d(aVar138);
            a.f(a, b.a(aVar138.b(), i191, aVar146.a()), dVar78, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar78);
            }
            super(aVar146.a(), c0.b(a.class), 0, d.a.j0.a, singleton, p.g());
            d dVar80 = new d(aVar139);
            a.f(a, b.a(aVar139.b(), i191, aVar146.a()), dVar80, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar80);
            }
            super(aVar146.a(), c0.b(AlarmManager.class), 0, d.a.k0.a, singleton, p.g());
            d dVar82 = new d(aVar140);
            a.f(a, b.a(aVar140.b(), i191, aVar146.a()), dVar82, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar82);
            }
            super(aVar146.a(), c0.b(CouponNotificationBroadcaster.a.a.class), 0, d.a.l0.a, singleton, p.g());
            d dVar84 = new d(aVar141);
            a.f(a, b.a(aVar141.b(), i191, aVar146.a()), dVar84, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar84);
            }
            super(aVar146.a(), c0.b(j.class), 0, d.a.m0.a, singleton, p.g());
            d dVar86 = new d(aVar142);
            a.f(a, b.a(aVar142.b(), i191, aVar146.a()), dVar86, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar86);
            }
            super(aVar146.a(), c0.b(c.class), 0, d.a.n0.a, singleton, p.g());
            d dVar88 = new d(aVar143);
            a.f(a, b.a(aVar143.b(), i191, aVar146.a()), dVar88, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar88);
            }
            super(aVar146.a(), c0.b(g2.class), 0, d.a.o0.a, singleton, p.g());
            d dVar90 = new d(aVar144);
            a.f(a, b.a(aVar144.b(), i191, aVar146.a()), dVar90, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar90);
            }
            super(aVar146.a(), c0.b(FirebaseDynamicLinks.class), 0, d.a.p0.a, singleton, p.g());
            d dVar92 = new d(aVar145);
            a.f(a, b.a(aVar145.b(), i191, aVar146.a()), dVar92, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar92);
            }
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((a)object);
            return w.a;
        }
    }
    static {
        d.a = b.b(false, d.a.a, 1, 0);
    }

    public static final a a() {
        return d.a;
    }
}
