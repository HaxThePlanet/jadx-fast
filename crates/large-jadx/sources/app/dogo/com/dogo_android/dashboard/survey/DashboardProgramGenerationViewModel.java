package app.dogo.com.dogo_android.g.g0;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms;
import app.dogo.com.dogo_android.repository.domain.SurveyAnswers;
import app.dogo.com.dogo_android.s.a.z2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q3;
import i.b.a0;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.u;
import kotlin.w;
import kotlin.y.j0;

/* compiled from: DashboardProgramGenerationViewModel.kt */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001bJ\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u0010H\u0002J\u0008\u0010!\u001a\u00020\u001bH\u0002R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/dashboard/survey/DashboardProgramGenerationViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "answers", "Lapp/dogo/com/dogo_android/repository/domain/SurveyAnswers;", "getRecommendedProgramRequestInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetRecommendedProgramRequestInteractor;", "sharedPreferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/SurveyAnswers;Lapp/dogo/com/dogo_android/repository/interactor/GetRecommendedProgramRequestInteractor;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/RecommendedOrderedPrograms;", "onSuccessfulFinished", "Lcom/hadilq/liveevent/LiveEvent;", "", "getOnSuccessfulFinished", "()Lcom/hadilq/liveevent/LiveEvent;", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "loadList", "", "delay", "", "retry", "saveRecommendedProgramId", "recommendedProgram", "setProgramTutorialAsStarted", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h, reason: from kotlin metadata */
public final class DashboardProgramGenerationViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final SurveyAnswers answers;
    /* renamed from: b, reason: from kotlin metadata */
    private final z2 connectivityService;
    /* renamed from: c, reason: from kotlin metadata */
    private final p2 getRecommendedProgramRequestInteractor;
    private final o3 d;
    private final j2 e;
    /* renamed from: f, reason: from kotlin metadata */
    private final x<y<RecommendedOrderedPrograms>> sharedPreferenceService = new x<>();
    /* renamed from: g, reason: from kotlin metadata */
    private final LiveData<y<RecommendedOrderedPrograms>> tracker = new x<>();
    private final f.d.a.a<Boolean> h = new a<>();

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            h.this.sharedPreferenceService.postValue(new LoadResult_Error(th));
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/RecommendedOrderedPrograms;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements l<RecommendedOrderedPrograms, w> {
        @Override // kotlin.d0.d.p
        public final void a(RecommendedOrderedPrograms recommendedOrderedPrograms) {
            h.this.sharedPreferenceService.postValue(new LoadResult_Success(recommendedOrderedPrograms));
            h.this.i().postValue(Boolean.TRUE);
        }

        b() {
            super(1);
        }
    }
    public h(SurveyAnswers surveyAnswers, z2 z2Var, p2 p2Var, o3 o3Var, j2 j2Var) {
        n.f(surveyAnswers, "answers");
        n.f(z2Var, "getRecommendedProgramRequestInteractor");
        n.f(p2Var, "sharedPreferenceService");
        n.f(o3Var, "tracker");
        n.f(j2Var, "connectivityService");
        super();
        this.answers = surveyAnswers;
        this.connectivityService = z2Var;
        this.getRecommendedProgramRequestInteractor = p2Var;
        this.d = o3Var;
        this.e = j2Var;
        x xVar = new x();
        f.d.a.a aVar = new a();
        k(3L);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ x loadList(h delay) {
        return delay.sharedPreferenceService;
    }

    public static /* synthetic */ void l(h hVar, long j, int i, Object object) {
        if (i & 1 != 0) {
            i = 0;
        }
        hVar.k(i);
    }

    private static final RecommendedOrderedPrograms m(h hVar, RecommendedOrderedPrograms recommendedOrderedPrograms) {
        n.f(hVar, "this$0");
        n.f(recommendedOrderedPrograms, "it");
        hVar.d.setUserProperty(UserProperty.OnboardingSurvey, hVar.answers.getUserPropertyTrackingData());
        hVar.saveRecommendedProgramId(recommendedOrderedPrograms);
        hVar.retry();
        return recommendedOrderedPrograms;
    }

    /* renamed from: o, reason: from kotlin metadata */
    private final void saveRecommendedProgramId(RecommendedOrderedPrograms recommendedProgram) {
        this.getRecommendedProgramRequestInteractor.n1(recommendedProgram.getDogId(), recommendedProgram.getRecommendedProgramId());
    }

    /* renamed from: p, reason: from kotlin metadata */
    private final void retry() {
        this.getRecommendedProgramRequestInteractor.l1(false);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<RecommendedOrderedPrograms>> getResult() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> i() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void k(long j) {
        Object obj;
        this.sharedPreferenceService.postValue(LoadResult_Loading.a);
        if (!this.e.a()) {
            this.d.setTrainingReminderUserProperties("program_generation");
            this.sharedPreferenceService.postValue(new LoadResult_Error(new UnknownHostException()));
        } else {
            java.util.List answers = this.answers.getAnswers();
            ArrayList arrayList = new ArrayList(p.r(answers, 10));
            Iterator it = answers.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                arrayList.add(u.a(item.c(), item.d()));
            }
            a0 delay = this.connectivityService.f(j0.s(arrayList)).map(new app.dogo.com.dogo_android.dashboard.survey.b(this)).observeOn(a.b()).subscribeOn(a.b()).delay(j, TimeUnit.SECONDS);
            n.e(delay, "getRecommendedProgramRequestInteractor.submitRecommendedProgram(answers.answers.map { it.first to it.second }.toMap())\n                    .map {\n                        tracker.setUserProperty(UserProperty.OnboardingSurvey, answers.getUserPropertyTrackingData())\n                        saveRecommendedProgramId(it)\n                        setProgramTutorialAsStarted()\n                        it\n                    }\n                    .observeOn(Schedulers.io())\n                    .subscribeOn(Schedulers.io())\n                    .delay(delay, TimeUnit.SECONDS)");
            getDisposable().b(a.g(delay, new app.dogo.com.dogo_android.dashboard.survey.h.a(this), new app.dogo.com.dogo_android.dashboard.survey.h.b(this)));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n() {
        DashboardProgramGenerationViewModel.l(this, 0L, 1, null);
    }

    public static /* synthetic */ RecommendedOrderedPrograms j(h hVar, RecommendedOrderedPrograms recommendedOrderedPrograms) {
        DashboardProgramGenerationViewModel.m(hVar, recommendedOrderedPrograms);
        return recommendedOrderedPrograms;
    }
}
