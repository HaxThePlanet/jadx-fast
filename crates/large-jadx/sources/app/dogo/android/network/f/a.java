package app.dogo.android.network.f;

import java.util.HashSet;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.w;
import m.a.c.k.c;
import m.a.c.k.c.a;

/* compiled from: apiModule.kt */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"apiModule", "Lorg/koin/core/module/Module;", "getApiModule", "()Lorg/koin/core/module/Module;", "network_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class a {

    private static final m.a.c.h.a a;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Lorg/koin/core/module/Module;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements l<m.a.c.h.a, w> {

        public static final a.a a = new a$a();
        @Override // kotlin.d0.d.p
        public final void a(m.a.c.h.a aVar) {
            n.f(aVar, "$this$module");
            final m.a.c.e.d singleton2 = Kind.Singleton;
            final c.a aVar7 = ScopeRegistry.e;
            BeanDefinition beanDefinition = new BeanDefinition(aVar7.a(), c0.b(ApiAdapter.class), null, a.a.a.a, singleton2, p.g());
            m.a.c.j.a aVar5 = null;
            m.a.c.f.d singleInstanceFactory2 = new SingleInstanceFactory(beanDefinition);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition.b(), aVar5, aVar7.a()), singleInstanceFactory2, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory2);
            }
            BeanDefinition beanDefinition2 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(DogoApiClient.class), null, a.a.b.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory = new SingleInstanceFactory(beanDefinition2);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition2.b(), aVar5, ScopeRegistry.e.a()), singleInstanceFactory, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory);
            }
        }


        a() {
            super(1);
        }
    }
    static {
        a.a = b.b(false, a.a.a, 1, null);
    }

    public static final m.a.c.h.a a() {
        return a.a;
    }
}
