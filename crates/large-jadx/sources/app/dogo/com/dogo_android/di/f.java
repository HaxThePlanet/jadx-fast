package app.dogo.com.dogo_android.j;

import java.util.HashSet;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.w;
import m.a.c.k.c;
import m.a.c.k.c.a;

/* compiled from: repositoryModule.kt */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"repositoryModule", "Lorg/koin/core/module/Module;", "getRepositoryModule", "()Lorg/koin/core/module/Module;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class f {

    private static final m.a.c.h.a a;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Lorg/koin/core/module/Module;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements l<m.a.c.h.a, w> {

        public static final f.a a = new f$a();
        @Override // kotlin.d0.d.p
        public final void a(m.a.c.h.a aVar) {
            n.f(aVar, "$this$module");
            final m.a.c.e.d singleton2 = Kind.Singleton;
            final c.a aVar26 = ScopeRegistry.e;
            BeanDefinition beanDefinition = new BeanDefinition(aVar26.a(), c0.b(TricksRepository.class), null, app.dogo.com.dogo_android.di.f.a.k.a, singleton2, p.g());
            m.a.c.j.a aVar25 = null;
            m.a.c.f.d singleInstanceFactory20 = new SingleInstanceFactory(beanDefinition);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition.b(), aVar25, aVar26.a()), singleInstanceFactory20, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory20);
            }
            BeanDefinition beanDefinition2 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(UserRepository.class), null, app.dogo.com.dogo_android.di.f.a.n.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory = new SingleInstanceFactory(beanDefinition2);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition2.b(), aVar25, ScopeRegistry.e.a()), singleInstanceFactory, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory);
            }
            BeanDefinition beanDefinition3 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(AppUpdateRepository.class), null, app.dogo.com.dogo_android.di.f.a.o.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory2 = new SingleInstanceFactory(beanDefinition3);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition3.b(), aVar25, ScopeRegistry.e.a()), singleInstanceFactory2, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory2);
            }
            BeanDefinition beanDefinition4 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(ProgramRepository.class), null, app.dogo.com.dogo_android.di.f.a.p.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory3 = new SingleInstanceFactory(beanDefinition4);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition4.b(), aVar25, ScopeRegistry.e.a()), singleInstanceFactory3, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory3);
            }
            BeanDefinition beanDefinition5 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(BillingRepository.class), null, app.dogo.com.dogo_android.di.f.a.q.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory4 = new SingleInstanceFactory(beanDefinition5);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition5.b(), aVar25, ScopeRegistry.e.a()), singleInstanceFactory4, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory4);
            }
            BeanDefinition beanDefinition6 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(RateRepository.class), null, app.dogo.com.dogo_android.di.f.a.r.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory5 = new SingleInstanceFactory(beanDefinition6);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition6.b(), aVar25, ScopeRegistry.e.a()), singleInstanceFactory5, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory5);
            }
            BeanDefinition beanDefinition7 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(SurveyRepository.class), null, app.dogo.com.dogo_android.di.f.a.s.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory6 = new SingleInstanceFactory(beanDefinition7);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition7.b(), aVar25, ScopeRegistry.e.a()), singleInstanceFactory6, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory6);
            }
            BeanDefinition beanDefinition8 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(ArticlesRepository.class), null, app.dogo.com.dogo_android.di.f.a.t.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory7 = new SingleInstanceFactory(beanDefinition8);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition8.b(), aVar25, ScopeRegistry.e.a()), singleInstanceFactory7, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory7);
            }
            BeanDefinition beanDefinition9 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(ContentRepository.class), null, app.dogo.com.dogo_android.di.f.a.u.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory8 = new SingleInstanceFactory(beanDefinition9);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition9.b(), aVar25, ScopeRegistry.e.a()), singleInstanceFactory8, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory8);
            }
            BeanDefinition beanDefinition10 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(BreedRepository.class), null, app.dogo.com.dogo_android.di.f.a.a.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory9 = new SingleInstanceFactory(beanDefinition10);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition10.b(), aVar25, ScopeRegistry.e.a()), singleInstanceFactory9, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory9);
            }
            BeanDefinition beanDefinition11 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(DebugRepository.class), null, app.dogo.com.dogo_android.di.f.a.b.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory10 = new SingleInstanceFactory(beanDefinition11);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition11.b(), aVar25, ScopeRegistry.e.a()), singleInstanceFactory10, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory10);
            }
            m.a.c.j.c cVar = ScopeRegistry.e.a();
            BeanDefinition beanDefinition21 = new BeanDefinition(cVar, c0.b(PredefinedContentRepository.class), null, app.dogo.com.dogo_android.di.f.a.c.a, Kind.Factory, p.g());
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition21.b(), aVar25, cVar), new FactoryInstanceFactory(beanDefinition21), false, 4, null);
            BeanDefinition beanDefinition12 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(CredentialsRepository.class), null, app.dogo.com.dogo_android.di.f.a.d.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory11 = new SingleInstanceFactory(beanDefinition12);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition12.b(), aVar25, ScopeRegistry.e.a()), singleInstanceFactory11, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory11);
            }
            BeanDefinition beanDefinition13 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(InAppRateRepository.class), null, app.dogo.com.dogo_android.di.f.a.e.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory12 = new SingleInstanceFactory(beanDefinition13);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition13.b(), aVar25, ScopeRegistry.e.a()), singleInstanceFactory12, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory12);
            }
            BeanDefinition beanDefinition14 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(VideoRepository.class), null, app.dogo.com.dogo_android.di.f.a.f.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory13 = new SingleInstanceFactory(beanDefinition14);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition14.b(), aVar25, ScopeRegistry.e.a()), singleInstanceFactory13, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory13);
            }
            BeanDefinition beanDefinition15 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(VideoPlayerFactory.class), null, app.dogo.com.dogo_android.di.f.a.g.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory14 = new SingleInstanceFactory(beanDefinition15);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition15.b(), aVar25, ScopeRegistry.e.a()), singleInstanceFactory14, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory14);
            }
            BeanDefinition beanDefinition16 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(DogLogRepository.class), null, app.dogo.com.dogo_android.di.f.a.h.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory15 = new SingleInstanceFactory(beanDefinition16);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition16.b(), aVar25, ScopeRegistry.e.a()), singleInstanceFactory15, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory15);
            }
            BeanDefinition beanDefinition17 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(ReminderRepository.class), null, app.dogo.com.dogo_android.di.f.a.i.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory16 = new SingleInstanceFactory(beanDefinition17);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition17.b(), aVar25, ScopeRegistry.e.a()), singleInstanceFactory16, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory16);
            }
            BeanDefinition beanDefinition18 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(ZendeskInteractor.class), null, app.dogo.com.dogo_android.di.f.a.j.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory17 = new SingleInstanceFactory(beanDefinition18);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition18.b(), aVar25, ScopeRegistry.e.a()), singleInstanceFactory17, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory17);
            }
            BeanDefinition beanDefinition19 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(TrainingTimeRepository.class), null, app.dogo.com.dogo_android.di.f.a.l.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory18 = new SingleInstanceFactory(beanDefinition19);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition19.b(), aVar25, ScopeRegistry.e.a()), singleInstanceFactory18, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory18);
            }
            BeanDefinition beanDefinition20 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(DogLogStyleRepository.class), null, app.dogo.com.dogo_android.di.f.a.m.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory19 = new SingleInstanceFactory(beanDefinition20);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition20.b(), aVar25, ScopeRegistry.e.a()), singleInstanceFactory19, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory19);
            }
        }


        a() {
            super(1);
        }
    }
    static {
        app.dogo.com.dogo_android.di.f.a = b.b(false, app.dogo.com.dogo_android.di.f.a.a, 1, null);
    }

    public static final m.a.c.h.a a() {
        return app.dogo.com.dogo_android.di.f.a;
    }
}
