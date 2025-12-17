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
import f.d.a.a;
import i.b.a0;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.o;
import kotlin.u;
import kotlin.w;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001bJ\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u0010H\u0002J\u0008\u0010!\u001a\u00020\u001bH\u0002R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/dashboard/survey/DashboardProgramGenerationViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "answers", "Lapp/dogo/com/dogo_android/repository/domain/SurveyAnswers;", "getRecommendedProgramRequestInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetRecommendedProgramRequestInteractor;", "sharedPreferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/SurveyAnswers;Lapp/dogo/com/dogo_android/repository/interactor/GetRecommendedProgramRequestInteractor;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/RecommendedOrderedPrograms;", "onSuccessfulFinished", "Lcom/hadilq/liveevent/LiveEvent;", "", "getOnSuccessfulFinished", "()Lcom/hadilq/liveevent/LiveEvent;", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "loadList", "", "delay", "", "retry", "saveRecommendedProgramId", "recommendedProgram", "setProgramTutorialAsStarted", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h extends s {

    private final SurveyAnswers a;
    private final z2 b;
    private final p2 c;
    private final o3 d;
    private final j2 e;
    private final x<y<RecommendedOrderedPrograms>> f;
    private final LiveData<y<RecommendedOrderedPrograms>> g;
    private final a<Boolean> h;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.g.g0.h this$0;
        a(app.dogo.com.dogo_android.g.g0.h h) {
            this.this$0 = h;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            y.a aVar = new y.a(throwable);
            h.h(this.this$0).postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/RecommendedOrderedPrograms;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<RecommendedOrderedPrograms, w> {

        final app.dogo.com.dogo_android.g.g0.h this$0;
        b(app.dogo.com.dogo_android.g.g0.h h) {
            this.this$0 = h;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(RecommendedOrderedPrograms recommendedOrderedPrograms) {
            y.c cVar = new y.c(recommendedOrderedPrograms);
            h.h(this.this$0).postValue(cVar);
            this.this$0.i().postValue(Boolean.TRUE);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((RecommendedOrderedPrograms)object);
            return w.a;
        }
    }
    public h(SurveyAnswers surveyAnswers, z2 z22, p2 p23, o3 o34, j2 j25) {
        n.f(surveyAnswers, "answers");
        n.f(z22, "getRecommendedProgramRequestInteractor");
        n.f(p23, "sharedPreferenceService");
        n.f(o34, "tracker");
        n.f(j25, "connectivityService");
        super();
        this.a = surveyAnswers;
        this.b = z22;
        this.c = p23;
        this.d = o34;
        this.e = j25;
        x obj2 = new x();
        this.f = obj2;
        this.g = obj2;
        obj2 = new a();
        this.h = obj2;
        k(3);
    }

    public static final x h(app.dogo.com.dogo_android.g.g0.h h) {
        return h.f;
    }

    public static RecommendedOrderedPrograms j(app.dogo.com.dogo_android.g.g0.h h, RecommendedOrderedPrograms recommendedOrderedPrograms2) {
        h.m(h, recommendedOrderedPrograms2);
        return recommendedOrderedPrograms2;
    }

    public static void l(app.dogo.com.dogo_android.g.g0.h h, long l2, int i3, Object object4) {
        int obj1;
        if (object4 &= 1 != 0) {
            obj1 = 0;
        }
        h.k(obj1);
    }

    private static final RecommendedOrderedPrograms m(app.dogo.com.dogo_android.g.g0.h h, RecommendedOrderedPrograms recommendedOrderedPrograms2) {
        n.f(h, "this$0");
        n.f(recommendedOrderedPrograms2, "it");
        h.d.q(q3.OnboardingSurvey, h.a.getUserPropertyTrackingData());
        h.o(recommendedOrderedPrograms2);
        h.p();
        return recommendedOrderedPrograms2;
    }

    private final void o(RecommendedOrderedPrograms recommendedOrderedPrograms) {
        this.c.n1(recommendedOrderedPrograms.getDogId(), recommendedOrderedPrograms.getRecommendedProgramId());
    }

    private final void p() {
        this.c.l1(false);
    }

    public final LiveData<y<RecommendedOrderedPrograms>> getResult() {
        return this.g;
    }

    public final a<Boolean> i() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void k(long l) {
        Object unknownHostException;
        Object bVar;
        TimeUnit sECONDS;
        ArrayList arrayList;
        boolean next;
        int i;
        Object obj;
        Object obj7;
        Object obj8;
        this.f.postValue(y.b.a);
        if (!this.e.a()) {
            this.d.s("program_generation");
            unknownHostException = new UnknownHostException();
            obj8 = new y.a(unknownHostException);
            this.f.postValue(obj8);
        } else {
            java.util.List answers = this.a.getAnswers();
            arrayList = new ArrayList(p.r(answers, 10));
            Iterator iterator = answers.iterator();
            for (o next2 : iterator) {
                arrayList.add(u.a(next2.c(), next2.d()));
            }
            b bVar2 = new b(this);
            obj7 = this.b.f(j0.s(arrayList)).map(bVar2).observeOn(a.b()).subscribeOn(a.b()).delay(l, obj8);
            n.e(obj7, "getRecommendedProgramRequestInteractor.submitRecommendedProgram(answers.answers.map { it.first to it.second }.toMap())\n                    .map {\n                        tracker.setUserProperty(UserProperty.OnboardingSurvey, answers.getUserPropertyTrackingData())\n                        saveRecommendedProgramId(it)\n                        setProgramTutorialAsStarted()\n                        it\n                    }\n                    .observeOn(Schedulers.io())\n                    .subscribeOn(Schedulers.io())\n                    .delay(delay, TimeUnit.SECONDS)");
            obj8 = new h.a(this);
            bVar = new h.b(this);
            getDisposable().b(a.g(obj7, obj8, bVar));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n() {
        h.l(this, 0, obj1, 1);
    }
}
