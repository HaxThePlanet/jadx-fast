package app.dogo.com.dogo_android.j;

import java.util.HashSet;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.w;
import m.a.c.k.c;
import m.a.c.k.c.a;

/* compiled from: interactorModule.kt */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"interactorModule", "Lorg/koin/core/module/Module;", "getInteractorModule", "()Lorg/koin/core/module/Module;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class e {

    private static final m.a.c.h.a a;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Lorg/koin/core/module/Module;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements l<m.a.c.h.a, w> {

        public static final e.a a = new e$a();
        @Override // kotlin.d0.d.p
        public final void a(m.a.c.h.a aVar) {
            n.f(aVar, "$this$module");
            m.a.c.e.d singleton2 = Kind.Singleton;
            c.a aVar55 = ScopeRegistry.e;
            BeanDefinition beanDefinition = new BeanDefinition(aVar55.a(), c0.b(GetProgramLessonsListInteractor.class), null, app.dogo.com.dogo_android.di.e.a.k.a, singleton2, p.g());
            m.a.c.j.a aVar54 = null;
            m.a.c.f.d singleInstanceFactory45 = new SingleInstanceFactory(beanDefinition);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition.b(), aVar54, aVar55.a()), singleInstanceFactory45, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory45);
            }
            BeanDefinition beanDefinition2 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(GetTrickVideoGoodExamplesInteractor.class), null, app.dogo.com.dogo_android.di.e.a.v.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory = new SingleInstanceFactory(beanDefinition2);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition2.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory);
            }
            BeanDefinition beanDefinition3 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(GetProgramTricksInteractor.class), null, app.dogo.com.dogo_android.di.e.a.g0.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory2 = new SingleInstanceFactory(beanDefinition3);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition3.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory2, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory2);
            }
            BeanDefinition beanDefinition4 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(TrainingSessionInteractor.class), null, app.dogo.com.dogo_android.di.e.a.r0.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory3 = new SingleInstanceFactory(beanDefinition4);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition4.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory3, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory3);
            }
            BeanDefinition beanDefinition5 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(GetProgramListInteractor.class), null, app.dogo.com.dogo_android.di.e.a.t0.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory4 = new SingleInstanceFactory(beanDefinition5);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition5.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory4, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory4);
            }
            BeanDefinition beanDefinition6 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(GetRecommendedProgramRequestInteractor.class), null, app.dogo.com.dogo_android.di.e.a.u0.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory5 = new SingleInstanceFactory(beanDefinition6);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition6.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory5, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory5);
            }
            BeanDefinition beanDefinition7 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(LessonCardListGenerationInteractor.class), null, app.dogo.com.dogo_android.di.e.a.v0.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory6 = new SingleInstanceFactory(beanDefinition7);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition7.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory6, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory6);
            }
            BeanDefinition beanDefinition8 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(GetOnboardingQuestionsInteractor.class), null, app.dogo.com.dogo_android.di.e.a.w0.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory7 = new SingleInstanceFactory(beanDefinition8);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition8.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory7, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory7);
            }
            BeanDefinition beanDefinition9 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(ExperimentInteractor.class), null, app.dogo.com.dogo_android.di.e.a.x0.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory8 = new SingleInstanceFactory(beanDefinition9);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition9.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory8, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory8);
            }
            BeanDefinition beanDefinition10 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(GetOnboardingDogIdInteractor.class), null, app.dogo.com.dogo_android.di.e.a.a.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory9 = new SingleInstanceFactory(beanDefinition10);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition10.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory9, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory9);
            }
            BeanDefinition beanDefinition11 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(SubscribeInteractor.class), null, app.dogo.com.dogo_android.di.e.a.b.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory10 = new SingleInstanceFactory(beanDefinition11);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition11.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory10, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory10);
            }
            BeanDefinition beanDefinition12 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(GetLibraryTrickListInteractor.class), null, app.dogo.com.dogo_android.di.e.a.c.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory11 = new SingleInstanceFactory(beanDefinition12);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition12.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory11, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory11);
            }
            m.a.c.j.c cVar = ScopeRegistry.e.a();
            m.a.c.e.d factory2 = Kind.Factory;
            BeanDefinition beanDefinition47 = new BeanDefinition(cVar, c0.b(GetProgramLessonIntroductionInteractor.class), null, app.dogo.com.dogo_android.di.e.a.d.a, factory2, p.g());
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition47.b(), aVar54, cVar), new FactoryInstanceFactory(beanDefinition47), false, 4, null);
            BeanDefinition beanDefinition13 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(GetLibraryArticleListInteractor.class), null, app.dogo.com.dogo_android.di.e.a.e.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory12 = new SingleInstanceFactory(beanDefinition13);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition13.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory12, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory12);
            }
            BeanDefinition beanDefinition14 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(CacheUpdaterInteractor.class), null, app.dogo.com.dogo_android.di.e.a.f.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory13 = new SingleInstanceFactory(beanDefinition14);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition14.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory13, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory13);
            }
            BeanDefinition beanDefinition15 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(PremiumContentLockInteractor.class), null, app.dogo.com.dogo_android.di.e.a.g.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory14 = new SingleInstanceFactory(beanDefinition15);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition15.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory14, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory14);
            }
            BeanDefinition beanDefinition16 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(ProgramContentRepository.class), null, app.dogo.com.dogo_android.di.e.a.h.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory15 = new SingleInstanceFactory(beanDefinition16);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition16.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory15, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory15);
            }
            BeanDefinition beanDefinition17 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(AddExamHeadersInteractor.class), null, app.dogo.com.dogo_android.di.e.a.i.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory16 = new SingleInstanceFactory(beanDefinition17);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition17.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory16, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory16);
            }
            BeanDefinition beanDefinition18 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(GetDashboardProgramCardTypeInteractor.class), null, app.dogo.com.dogo_android.di.e.a.j.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory17 = new SingleInstanceFactory(beanDefinition18);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition18.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory17, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory17);
            }
            BeanDefinition beanDefinition19 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(GetLibraryProgramListInteractor.class), null, app.dogo.com.dogo_android.di.e.a.l.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory18 = new SingleInstanceFactory(beanDefinition19);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition19.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory18, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory18);
            }
            BeanDefinition beanDefinition20 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(GetExamHistoryListInteractor.class), null, app.dogo.com.dogo_android.di.e.a.m.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory19 = new SingleInstanceFactory(beanDefinition20);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition20.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory19, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory19);
            }
            BeanDefinition beanDefinition21 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(GetPremiumOfferingsInteractor.class), null, app.dogo.com.dogo_android.di.e.a.n.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory20 = new SingleInstanceFactory(beanDefinition21);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition21.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory20, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory20);
            }
            BeanDefinition beanDefinition22 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(IsDogPremiumInteractor.class), null, app.dogo.com.dogo_android.di.e.a.o.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory21 = new SingleInstanceFactory(beanDefinition22);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition22.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory21, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory21);
            }
            BeanDefinition beanDefinition23 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(GetDashboardExamCardInteractor.class), null, app.dogo.com.dogo_android.di.e.a.p.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory22 = new SingleInstanceFactory(beanDefinition23);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition23.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory22, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory22);
            }
            BeanDefinition beanDefinition24 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(GetDogProfileInteractor.class), null, app.dogo.com.dogo_android.di.e.a.q.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory23 = new SingleInstanceFactory(beanDefinition24);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition24.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory23, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory23);
            }
            BeanDefinition beanDefinition25 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(GetProfilePreviewInteractor.class), null, app.dogo.com.dogo_android.di.e.a.r.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory24 = new SingleInstanceFactory(beanDefinition25);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition25.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory24, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory24);
            }
            BeanDefinition beanDefinition26 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(LoginOnResultInteractor.class), null, app.dogo.com.dogo_android.di.e.a.s.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory25 = new SingleInstanceFactory(beanDefinition26);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition26.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory25, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory25);
            }
            BeanDefinition beanDefinition27 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(DeferredLinkInteractor.class), null, app.dogo.com.dogo_android.di.e.a.t.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory26 = new SingleInstanceFactory(beanDefinition27);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition27.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory26, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory26);
            }
            BeanDefinition beanDefinition28 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(GetCertificateInfoInteractor.class), null, app.dogo.com.dogo_android.di.e.a.u.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory27 = new SingleInstanceFactory(beanDefinition28);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition28.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory27, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory27);
            }
            BeanDefinition beanDefinition29 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(RequestCertificateInfoInteractor.class), null, app.dogo.com.dogo_android.di.e.a.w.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory28 = new SingleInstanceFactory(beanDefinition29);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition29.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory28, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory28);
            }
            BeanDefinition beanDefinition30 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(CouponNotificationInteractor.class), null, app.dogo.com.dogo_android.di.e.a.x.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory29 = new SingleInstanceFactory(beanDefinition30);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition30.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory29, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory29);
            }
            m.a.c.j.c cVar2 = ScopeRegistry.e.a();
            BeanDefinition beanDefinition48 = new BeanDefinition(cVar2, c0.b(GetCustomerExperienceInteractor.class), null, app.dogo.com.dogo_android.di.e.a.y.a, factory2, p.g());
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition48.b(), aVar54, cVar2), new FactoryInstanceFactory(beanDefinition48), false, 4, null);
            BeanDefinition beanDefinition31 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(WorkoutSessionInteractor.class), null, app.dogo.com.dogo_android.di.e.a.z.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory30 = new SingleInstanceFactory(beanDefinition31);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition31.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory30, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory30);
            }
            BeanDefinition beanDefinition32 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(ShouldShowWorkoutUnlockedInteractor.class), null, app.dogo.com.dogo_android.di.e.a.a0.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory31 = new SingleInstanceFactory(beanDefinition32);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition32.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory31, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory31);
            }
            BeanDefinition beanDefinition33 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(SpecialOfferInteractor.class), null, app.dogo.com.dogo_android.di.e.a.b0.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory32 = new SingleInstanceFactory(beanDefinition33);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition33.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory32, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory32);
            }
            BeanDefinition beanDefinition34 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(GetVideoStepsInteractor.class), null, app.dogo.com.dogo_android.di.e.a.c0.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory33 = new SingleInstanceFactory(beanDefinition34);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition34.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory33, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory33);
            }
            BeanDefinition beanDefinition35 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(SettingsInteractor.class), null, app.dogo.com.dogo_android.di.e.a.d0.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory34 = new SingleInstanceFactory(beanDefinition35);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition35.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory34, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory34);
            }
            BeanDefinition beanDefinition36 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(GetProgramOverviewInteractor.class), null, app.dogo.com.dogo_android.di.e.a.e0.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory35 = new SingleInstanceFactory(beanDefinition36);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition36.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory35, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory35);
            }
            m.a.c.j.c cVar3 = ScopeRegistry.e.a();
            m.a.c.j.a aVar57 = null;
            BeanDefinition beanDefinition49 = new BeanDefinition(cVar3, c0.b(TrainingReminderNotificationInteractor.class), aVar57, app.dogo.com.dogo_android.di.e.a.f0.a, factory2, p.g());
            boolean z47 = false;
            int i131 = 4;
            Object obj97 = null;
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition49.b(), aVar54, cVar3), new FactoryInstanceFactory(beanDefinition49), z47, i131, obj97);
            m.a.c.j.c cVar4 = ScopeRegistry.e.a();
            BeanDefinition beanDefinition50 = new BeanDefinition(cVar4, c0.b(PottyReminderNotificationInteractor.class), aVar57, app.dogo.com.dogo_android.di.e.a.h0.a, factory2, p.g());
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition50.b(), aVar54, cVar4), new FactoryInstanceFactory(beanDefinition50), z47, i131, obj97);
            BeanDefinition beanDefinition37 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(DogParentInteractor.class), null, app.dogo.com.dogo_android.di.e.a.i0.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory36 = new SingleInstanceFactory(beanDefinition37);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition37.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory36, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory36);
            }
            BeanDefinition beanDefinition38 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(DogInviteAcceptanceInteractor.class), null, app.dogo.com.dogo_android.di.e.a.j0.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory37 = new SingleInstanceFactory(beanDefinition38);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition38.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory37, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory37);
            }
            BeanDefinition beanDefinition39 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(GetSubscriptionOffersInteractor.class), null, app.dogo.com.dogo_android.di.e.a.k0.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory38 = new SingleInstanceFactory(beanDefinition39);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition39.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory38, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory38);
            }
            BeanDefinition beanDefinition40 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(PottyProgramOverviewInteractor.class), null, app.dogo.com.dogo_android.di.e.a.l0.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory39 = new SingleInstanceFactory(beanDefinition40);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition40.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory39, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory39);
            }
            BeanDefinition beanDefinition41 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(PottyProgramCardInteractor.class), null, app.dogo.com.dogo_android.di.e.a.m0.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory40 = new SingleInstanceFactory(beanDefinition41);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition41.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory40, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory40);
            }
            BeanDefinition beanDefinition42 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(DogLogCalendarInteractor.class), null, app.dogo.com.dogo_android.di.e.a.n0.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory41 = new SingleInstanceFactory(beanDefinition42);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition42.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory41, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory41);
            }
            BeanDefinition beanDefinition43 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(BitingProgramOverviewInteractor.class), null, app.dogo.com.dogo_android.di.e.a.o0.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory42 = new SingleInstanceFactory(beanDefinition43);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition43.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory42, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory42);
            }
            BeanDefinition beanDefinition44 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(BitingProgramCardInteractor.class), null, app.dogo.com.dogo_android.di.e.a.p0.a, singleton2, p.g());
            m.a.c.f.d singleInstanceFactory43 = new SingleInstanceFactory(beanDefinition44);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition44.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory43, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory43);
            }
            m.a.c.e.d singleton22 = Kind.Singleton;
            c.a aVar56 = ScopeRegistry.e;
            BeanDefinition beanDefinition45 = new BeanDefinition(aVar56.a(), c0.b(TrainingTimeInteractor.class), null, app.dogo.com.dogo_android.di.e.a.q0.a, singleton22, p.g());
            m.a.c.f.d singleInstanceFactory46 = new SingleInstanceFactory(beanDefinition45);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition45.b(), aVar54, aVar56.a()), singleInstanceFactory46, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory46);
            }
            BeanDefinition beanDefinition46 = new BeanDefinition(ScopeRegistry.e.a(), c0.b(DogUpdateInteractor.class), null, app.dogo.com.dogo_android.di.e.a.s0.a, singleton22, p.g());
            m.a.c.f.d singleInstanceFactory44 = new SingleInstanceFactory(beanDefinition46);
            Module.f(aVar, org.koin.core.definition.b.a(beanDefinition46.b(), aVar54, ScopeRegistry.e.a()), singleInstanceFactory44, false, 4, null);
            if (aVar.a()) {
                aVar.b().add(singleInstanceFactory44);
            }
        }


        a() {
            super(1);
        }
    }
    static {
        app.dogo.com.dogo_android.di.e.a = b.b(false, app.dogo.com.dogo_android.di.e.a.a, 1, null);
    }

    public static final m.a.c.h.a a() {
        return app.dogo.com.dogo_android.di.e.a;
    }
}
