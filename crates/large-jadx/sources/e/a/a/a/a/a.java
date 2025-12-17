package e.a.a.a.a;

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
import m.a.c.f.d;
import m.a.c.h.a;
import m.a.c.k.c;
import m.a.c.k.c.a;
import m.a.d.b;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"daoModule", "Lorg/koin/core/module/Module;", "getDaoModule", "()Lorg/koin/core/module/Module;", "persistencedb_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class a {

    private static final a a;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Lorg/koin/core/module/Module;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<a, w> {

        public static final e.a.a.a.a.a.a a;
        static {
            a.a aVar = new a.a();
            a.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(a a) {
            boolean z15;
            boolean z11;
            boolean z4;
            boolean z3;
            boolean z17;
            boolean z20;
            boolean z14;
            boolean z;
            boolean z13;
            boolean z2;
            boolean z6;
            boolean z8;
            boolean z10;
            boolean z19;
            boolean z9;
            boolean z18;
            boolean z5;
            boolean z12;
            boolean z7;
            boolean z16;
            n.f(a, "$this$module");
            final d singleton = d.Singleton;
            final c.a aVar62 = c.e;
            super(aVar62.a(), c0.b(ContentDatabase.class), 0, a.a.k.a, singleton, p.g());
            int i80 = 0;
            d dVar99 = new d(aVar);
            a.f(a, b.a(aVar.b(), i80, aVar62.a()), dVar99, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar99);
            }
            a aVar2 = new a(aVar62.a(), c0.b(ProgressDatabase.class), 0, a.a.m.a, singleton, p.g());
            d dVar2 = new d(aVar43);
            a.f(a, b.a(aVar43.b(), i80, aVar62.a()), dVar2, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar2);
            }
            super(aVar62.a(), c0.b(PremiumDatabase.class), 0, a.a.n.a, singleton, p.g());
            d dVar4 = new d(aVar44);
            a.f(a, b.a(aVar44.b(), i80, aVar62.a()), dVar4, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar4);
            }
            super(aVar62.a(), c0.b(LocalOnlyDatabase.class), 0, a.a.o.a, singleton, p.g());
            d dVar6 = new d(aVar45);
            a.f(a, b.a(aVar45.b(), i80, aVar62.a()), dVar6, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar6);
            }
            super(aVar62.a(), c0.b(UserDatabase.class), 0, a.a.p.a, singleton, p.g());
            d dVar8 = new d(aVar46);
            a.f(a, b.a(aVar46.b(), i80, aVar62.a()), dVar8, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar8);
            }
            super(aVar62.a(), c0.b(m0.class), 0, a.a.q.a, singleton, p.g());
            d dVar10 = new d(aVar47);
            a.f(a, b.a(aVar47.b(), i80, aVar62.a()), dVar10, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar10);
            }
            super(aVar62.a(), c0.b(i0.class), 0, a.a.r.a, singleton, p.g());
            d dVar12 = new d(aVar48);
            a.f(a, b.a(aVar48.b(), i80, aVar62.a()), dVar12, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar12);
            }
            super(aVar62.a(), c0.b(g0.class), 0, a.a.s.a, singleton, p.g());
            d dVar14 = new d(aVar49);
            a.f(a, b.a(aVar49.b(), i80, aVar62.a()), dVar14, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar14);
            }
            super(aVar62.a(), c0.b(e0.class), 0, a.a.t.a, singleton, p.g());
            d dVar16 = new d(aVar50);
            a.f(a, b.a(aVar50.b(), i80, aVar62.a()), dVar16, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar16);
            }
            super(aVar62.a(), c0.b(o0.class), 0, a.a.a.a, singleton, p.g());
            d dVar18 = new d(aVar51);
            a.f(a, b.a(aVar51.b(), i80, aVar62.a()), dVar18, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar18);
            }
            super(aVar62.a(), c0.b(y.class), 0, a.a.b.a, singleton, p.g());
            d dVar20 = new d(aVar52);
            a.f(a, b.a(aVar52.b(), i80, aVar62.a()), dVar20, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar20);
            }
            super(aVar62.a(), c0.b(a0.class), 0, a.a.c.a, singleton, p.g());
            d dVar22 = new d(aVar53);
            a.f(a, b.a(aVar53.b(), i80, aVar62.a()), dVar22, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar22);
            }
            super(aVar62.a(), c0.b(s.class), 0, a.a.d.a, singleton, p.g());
            d dVar24 = new d(aVar54);
            a.f(a, b.a(aVar54.b(), i80, aVar62.a()), dVar24, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar24);
            }
            super(aVar62.a(), c0.b(q.class), 0, a.a.e.a, singleton, p.g());
            d dVar26 = new d(aVar55);
            a.f(a, b.a(aVar55.b(), i80, aVar62.a()), dVar26, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar26);
            }
            super(aVar62.a(), c0.b(c0.class), 0, a.a.f.a, singleton, p.g());
            d dVar28 = new d(aVar56);
            a.f(a, b.a(aVar56.b(), i80, aVar62.a()), dVar28, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar28);
            }
            super(aVar62.a(), c0.b(s0.class), 0, a.a.g.a, singleton, p.g());
            d dVar30 = new d(aVar57);
            a.f(a, b.a(aVar57.b(), i80, aVar62.a()), dVar30, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar30);
            }
            super(aVar62.a(), c0.b(w.class), 0, a.a.h.a, singleton, p.g());
            d dVar32 = new d(aVar58);
            a.f(a, b.a(aVar58.b(), i80, aVar62.a()), dVar32, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar32);
            }
            super(aVar62.a(), c0.b(u.class), 0, a.a.i.a, singleton, p.g());
            d dVar34 = new d(aVar59);
            a.f(a, b.a(aVar59.b(), i80, aVar62.a()), dVar34, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar34);
            }
            super(aVar62.a(), c0.b(q0.class), 0, a.a.j.a, singleton, p.g());
            d dVar36 = new d(aVar60);
            a.f(a, b.a(aVar60.b(), i80, aVar62.a()), dVar36, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar36);
            }
            super(aVar62.a(), c0.b(k0.class), 0, a.a.l.a, singleton, p.g());
            d dVar38 = new d(aVar61);
            a.f(a, b.a(aVar61.b(), i80, aVar62.a()), dVar38, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar38);
            }
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((a)object);
            return w.a;
        }
    }
    static {
        a.a = b.b(false, a.a.a, 1, 0);
    }

    public static final a a() {
        return a.a;
    }
}
