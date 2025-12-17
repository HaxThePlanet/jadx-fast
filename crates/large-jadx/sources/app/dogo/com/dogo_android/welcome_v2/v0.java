package app.dogo.com.dogo_android.welcome_v2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.SurveyAnswers;
import app.dogo.com.dogo_android.repository.domain.SurveyQuestion;
import app.dogo.com.dogo_android.s.a.s2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.f2;
import app.dogo.com.dogo_android.w.g0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.t2;
import app.dogo.com.dogo_android.w.u0;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.v2;
import f.d.a.a;
import i.b.a0;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.o;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\n\u0018\u0000 ,2\u00020\u0001:\u0001,B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0014\u0010 \u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110!H\u0002J\u0008\u0010\"\u001a\u00020#H\u0002J\u0006\u0010$\u001a\u00020#J\u001e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0017J\u0006\u0010)\u001a\u00020#J\u0006\u0010*\u001a\u00020#J\u000e\u0010+\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0003R \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R#\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u00100\u001b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSurveyViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "dogId", "", "dogName", "getOnboardingQuestionsInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetOnboardingQuestionsInteractor;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "sharedPreferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/interactor/GetOnboardingQuestionsInteractor;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "Lapp/dogo/com/dogo_android/repository/domain/SurveyQuestion;", "answers", "", "goNext", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoNext", "()Lcom/hadilq/liveevent/LiveEvent;", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "getAnswers", "Lapp/dogo/com/dogo_android/repository/domain/SurveyAnswers;", "getItems", "Lio/reactivex/Single;", "load", "", "retry", "saveAnswerAndGoNextIfLast", "questionId", "answerId", "isLastCard", "saveOnboardingComplete", "trackSurveyCompleted", "trackSurveySkip", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class v0 extends s {

    public static final app.dogo.com.dogo_android.welcome_v2.v0.a Companion;
    private final String a;
    private final String b;
    private final s2 c;
    private final j2 d;
    private final o3 e;
    private final p2 f;
    private final Map<String, String> g;
    private final a<Boolean> h;
    private final x<y<List<SurveyQuestion>>> i;
    private final LiveData<y<List<SurveyQuestion>>> j;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSurveyViewModel$Companion;", "", "()V", "BITING_TRAINING_ID", "", "HAS_ANSWERED_POSITIVE", "POTTY_TRAINING_ID", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.welcome_v2.v0 this$0;
        b(app.dogo.com.dogo_android.welcome_v2.v0 v0) {
            this.this$0 = v0;
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
            v0.h(this.this$0).postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "", "Lapp/dogo/com/dogo_android/repository/domain/SurveyQuestion;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<List<? extends SurveyQuestion>, w> {

        final app.dogo.com.dogo_android.welcome_v2.v0 this$0;
        c(app.dogo.com.dogo_android.welcome_v2.v0 v0) {
            this.this$0 = v0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((List)object);
            return w.a;
        }

        public final void invoke(List<SurveyQuestion> list) {
            y.c cVar = new y.c(list);
            v0.h(this.this$0).postValue(cVar);
        }
    }
    static {
        v0.a aVar = new v0.a(0);
        v0.Companion = aVar;
    }

    public v0(String string, String string2, s2 s23, j2 j24, o3 o35, p2 p26) {
        n.f(string, "dogId");
        n.f(string2, "dogName");
        n.f(s23, "getOnboardingQuestionsInteractor");
        n.f(j24, "connectivityService");
        n.f(o35, "tracker");
        n.f(p26, "sharedPreferenceService");
        super();
        this.a = string;
        this.b = string2;
        this.c = s23;
        this.d = j24;
        this.e = o35;
        this.f = p26;
        LinkedHashMap obj2 = new LinkedHashMap();
        this.g = obj2;
        obj2 = new a();
        this.h = obj2;
        obj2 = new x();
        this.i = obj2;
        this.j = obj2;
        load();
    }

    public static final x h(app.dogo.com.dogo_android.welcome_v2.v0 v0) {
        return v0.i;
    }

    private final a0<List<SurveyQuestion>> k() {
        return this.c.c(this.b);
    }

    private final void load() {
        Object disposable;
        Object aVar;
        Object unknownHostException;
        app.dogo.com.dogo_android.welcome_v2.v0.c cVar;
        this.i.postValue(y.b.a);
        if (!this.d.a()) {
            this.e.s("onboarding_survey");
            unknownHostException = new UnknownHostException();
            aVar = new y.a(unknownHostException);
            this.i.postValue(aVar);
        } else {
            a0 subscribeOn = k().observeOn(a.b()).subscribeOn(a.b());
            n.e(subscribeOn, "getItems()\n                    .observeOn(Schedulers.io())\n                    .subscribeOn(Schedulers.io())");
            unknownHostException = new v0.b(this);
            cVar = new v0.c(this);
            getDisposable().b(a.g(subscribeOn, unknownHostException, cVar));
        }
    }

    public final LiveData<y<List<SurveyQuestion>>> getResult() {
        return this.j;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final SurveyAnswers i() {
        int value;
        o oVar;
        Object key;
        Map map = this.g;
        ArrayList arrayList = new ArrayList(map.size());
        Iterator iterator = map.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            oVar = new o(next2.getKey(), next2.getValue());
            arrayList.add(oVar);
        }
        SurveyAnswers surveyAnswers = new SurveyAnswers(arrayList);
        return surveyAnswers;
    }

    public final a<Boolean> j() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void l() {
        load();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m(String string, String string2, boolean z3) {
        boolean z;
        Object oVar;
        boolean obj6;
        Object obj7;
        n.f(string, "questionId");
        n.f(string2, "answerId");
        f2 f2Var = new f2();
        oVar = new o(f2Var, string);
        u0 u0Var = new u0();
        o oVar2 = new o(u0Var, string2);
        this.e.d(g0.a.d(oVar, oVar2));
        this.g.put(string, string2);
        String str5 = "id_yes";
        if (n.b(string, "id_potty_training") && n.b(string2, str5)) {
            if (n.b(string2, str5)) {
                this.f.G0(this.a);
            }
        }
        if (n.b(string, "id_puppy_bitting") && n.b(string2, str5)) {
            if (n.b(string2, str5)) {
                this.f.F0(this.a);
            }
        }
        if (z3) {
            o();
            this.h.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n() {
        this.f.T0(false);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void o() {
        this.e.d(g0.b.h());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p(String string) {
        n.f(string, "questionId");
        f2 f2Var = new f2();
        o oVar = new o(f2Var, string);
        this.e.d(g0.c.d(oVar));
    }
}
