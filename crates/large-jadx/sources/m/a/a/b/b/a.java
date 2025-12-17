package m.a.a.b.b;

import android.content.Context;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.o;
import kotlin.w;
import kotlin.y.p;
import m.a.c.a;
import m.a.c.b;
import m.a.c.e.a;
import m.a.c.e.b;
import m.a.c.e.d;
import m.a.c.f.d;
import m.a.c.g.b;
import m.a.c.g.c;
import m.a.c.h.a;
import m.a.c.k.c;
import m.a.c.k.c.a;
import m.a.d.a;
import m.a.d.b;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¨\u0006\t", d2 = {"androidContext", "Lorg/koin/core/KoinApplication;", "Landroid/content/Context;", "androidFileProperties", "koinPropertyFile", "", "androidLogger", "level", "Lorg/koin/core/logger/Level;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class a {

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Lorg/koin/core/module/Module;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<a, w> {

        final Context $androidContext;
        a(Context context) {
            this.$androidContext = context;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(a a) {
            boolean z;
            final Object obj3 = a;
            n.f(obj3, "$this$module");
            a.a.a aVar5 = new a.a.a(obj4.$androidContext);
            c.a aVar = c.e;
            super(aVar.a(), c0.b(Context.class), 0, aVar5, d.Singleton, p.g());
            d dVar4 = new d(aVar3);
            a.f(a, b.a(aVar3.b(), 0, aVar.a()), dVar4, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar4);
            }
            o oVar = new o(obj3, dVar4);
            a.a(oVar, c0.b(Application.class));
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((a)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Lorg/koin/core/module/Module;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<a, w> {

        final Context $androidContext;
        b(Context context) {
            this.$androidContext = context;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(a a) {
            boolean z;
            n.f(a, "$this$module");
            a.b.a aVar5 = new a.b.a(obj.$androidContext);
            c.a aVar = c.e;
            super(aVar.a(), c0.b(Context.class), 0, aVar5, d.Singleton, p.g());
            d dVar3 = new d(aVar3);
            a.f(a, b.a(aVar3.b(), 0, aVar.a()), dVar3, false, 4, 0);
            if (a.a()) {
                a.b().add(dVar3);
            }
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((a)object);
            return w.a;
        }
    }
    public static final b a(b b, Context context2) {
        boolean z;
        a aVar;
        Object iNFO;
        p aVar2;
        java.util.List obj7;
        n.f(b, "<this>");
        n.f(context2, "androidContext");
        if (b.b().c().f(b.INFO)) {
            b.b().c().e("[init] declare Android Context");
        }
        int i = 2;
        final int i2 = 1;
        final int i3 = 0;
        final int i4 = 0;
        if (context2 instanceof Application) {
            aVar2 = new a.a(context2);
            a.f(b.b(), p.b(b.b(i4, aVar2, i2, i3)), i4, i, i3);
        } else {
            aVar2 = new a.b(context2);
            a.f(b.b(), p.b(b.b(i4, aVar2, i2, i3)), i4, i, i3);
        }
        return b;
    }
}
