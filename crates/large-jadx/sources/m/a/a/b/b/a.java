package m.a.a.b.b;

import android.content.Context;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.w;
import m.a.c.k.c.a;

/* compiled from: KoinExt.kt */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¨\u0006\t", d2 = {"androidContext", "Lorg/koin/core/KoinApplication;", "Landroid/content/Context;", "androidFileProperties", "koinPropertyFile", "", "androidLogger", "level", "Lorg/koin/core/logger/Level;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a {

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Lorg/koin/core/module/Module;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements l<m.a.c.h.a, w> {

        final /* synthetic */ Context $androidContext;
        @Override // kotlin.d0.d.p
        public final void a(m.a.c.h.a aVar) {
            final Object aVar2 = aVar;
            n.f(aVar2, "$this$module");
            c.a aVar3 = ScopeRegistry.e;
            BeanDefinition beanDefinition = new BeanDefinition(aVar3.a(), c0.b(Context.class), null, new a.a.a(this.$androidContext), Kind.Singleton, r.g());
            m.a.c.f.d singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
            Module.f(aVar, str, singleInstanceFactory, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory);
            }
            a.a(new Pair(aVar2, singleInstanceFactory), c0.b(Application.class));
        }

        a(Context context) {
            this.$androidContext = context;
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Lorg/koin/core/module/Module;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements l<m.a.c.h.a, w> {

        final /* synthetic */ Context $androidContext;
        @Override // kotlin.d0.d.p
        public final void a(m.a.c.h.a aVar) {
            n.f(aVar, "$this$module");
            c.a aVar4 = ScopeRegistry.e;
            BeanDefinition beanDefinition = new BeanDefinition(aVar4.a(), c0.b(Context.class), null, new a.b.a(this.$androidContext), Kind.Singleton, r.g());
            m.a.c.f.d singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
            Module.f(aVar, str, singleInstanceFactory, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory);
            }
        }

        b(Context context) {
            this.$androidContext = context;
            super(1);
        }
    }
    public static final m.a.c.b a(m.a.c.b bVar, Context context) {
        n.f(bVar, "<this>");
        n.f(context, "androidContext");
        if (bVar.b().c().isAt(Level.INFO)) {
            bVar.b().c().info("[init] declare Android Context");
        }
        int i = 2;
        final int i2 = 1;
        final Object obj = null;
        final boolean z3 = false;
        if (context instanceof Application) {
            Koin.f(bVar.b(), q.b(b.b(z3, new a.a(context), i2, obj)), z3, i, obj);
        } else {
            Koin.f(bVar.b(), q.b(b.b(z3, new a.b(context), i2, obj)), z3, i, obj);
        }
        return bVar;
    }
}
