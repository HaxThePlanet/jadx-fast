package app.dogo.android.network.f;

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
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"apiModule", "Lorg/koin/core/module/Module;", "getApiModule", "()Lorg/koin/core/module/Module;", "network_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class a {

    private static final a a;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Lorg/koin/core/module/Module;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<a, w> {

        public static final app.dogo.android.network.f.a.a a;
        static {
            a.a aVar = new a.a();
            a.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(a a) {
            boolean z2;
            boolean z;
            n.f(a, "$this$module");
            final d singleton = d.Singleton;
            final c.a aVar8 = c.e;
            super(aVar8.a(), c0.b(c.class), 0, a.a.a.a, singleton, p.g());
            int i8 = 0;
            d dVar8 = new d(aVar);
            a.f(a, b.a(aVar.b(), i8, aVar8.a()), dVar8, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar8);
            }
            a aVar2 = new a(aVar8.a(), c0.b(DogoApiClient.class), 0, a.a.b.a, singleton, p.g());
            d dVar2 = new d(aVar6);
            a.f(a, b.a(aVar6.b(), i8, aVar8.a()), dVar2, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar2);
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
