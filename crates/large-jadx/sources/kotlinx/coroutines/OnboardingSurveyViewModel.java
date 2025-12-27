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
import i.b.a0;
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

/* compiled from: OnboardingSurveyViewModel.kt */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\n\u0018\u0000 ,2\u00020\u0001:\u0001,B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0014\u0010 \u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110!H\u0002J\u0008\u0010\"\u001a\u00020#H\u0002J\u0006\u0010$\u001a\u00020#J\u001e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0017J\u0006\u0010)\u001a\u00020#J\u0006\u0010*\u001a\u00020#J\u000e\u0010+\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0003R \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R#\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u00100\u001b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSurveyViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "dogId", "", "dogName", "getOnboardingQuestionsInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetOnboardingQuestionsInteractor;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "sharedPreferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/interactor/GetOnboardingQuestionsInteractor;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "Lapp/dogo/com/dogo_android/repository/domain/SurveyQuestion;", "answers", "", "goNext", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoNext", "()Lcom/hadilq/liveevent/LiveEvent;", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "getAnswers", "Lapp/dogo/com/dogo_android/repository/domain/SurveyAnswers;", "getItems", "Lio/reactivex/Single;", "load", "", "retry", "saveAnswerAndGoNextIfLast", "questionId", "answerId", "isLastCard", "saveOnboardingComplete", "trackSurveyCompleted", "trackSurveySkip", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: v0, reason: from kotlin metadata */
public final class OnboardingSurveyViewModel extends s {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final v0.a INSTANCE = new v0$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final String answers;
    /* renamed from: b, reason: from kotlin metadata */
    private final String connectivityService;
    /* renamed from: c, reason: from kotlin metadata */
    private final s2 dogId;
    /* renamed from: d, reason: from kotlin metadata */
    private final j2 dogName;
    /* renamed from: e, reason: from kotlin metadata */
    private final o3 getOnboardingQuestionsInteractor;
    private final p2 f;
    private final Map<String, String> g = new LinkedHashMap<>();
    /* renamed from: h, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> sharedPreferenceService = new a<>();
    /* renamed from: i, reason: from kotlin metadata */
    private final x<y<List<SurveyQuestion>>> tracker = new x<>();
    private final LiveData<y<List<SurveyQuestion>>> j = new x<>();

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSurveyViewModel$Companion;", "", "()V", "BITING_TRAINING_ID", "", "HAS_ANSWERED_POSITIVE", "POTTY_TRAINING_ID", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            v0.this.tracker.postValue(new LoadResult_Error(th));
        }

        b() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "", "Lapp/dogo/com/dogo_android/repository/domain/SurveyQuestion;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<List<? extends SurveyQuestion>, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(List<SurveyQuestion> list) {
            v0.this.tracker.postValue(new LoadResult_Success(list));
        }

        c() {
            super(1);
        }
    }
    public v0(String str, String str2, s2 s2Var, j2 j2Var, o3 o3Var, p2 p2Var) {
        n.f(str, "dogId");
        n.f(str2, "dogName");
        n.f(s2Var, "getOnboardingQuestionsInteractor");
        n.f(j2Var, "connectivityService");
        n.f(o3Var, "tracker");
        n.f(p2Var, "sharedPreferenceService");
        super();
        this.answers = str;
        this.connectivityService = str2;
        this.dogId = s2Var;
        this.dogName = j2Var;
        this.getOnboardingQuestionsInteractor = o3Var;
        this.f = p2Var;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        f.d.a.a aVar = new a();
        x xVar = new x();
        load();
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ x trackSurveySkip(v0 questionId) {
        return questionId.tracker;
    }

    /* renamed from: k, reason: from kotlin metadata */
    private final a0<List<SurveyQuestion>> getAnswers() {
        return this.dogId.c(this.connectivityService);
    }

    private final void load() {
        this.tracker.postValue(LoadResult_Loading.a);
        if (!this.dogName.a()) {
            this.getOnboardingQuestionsInteractor.setTrainingReminderUserProperties("onboarding_survey");
            this.tracker.postValue(new LoadResult_Error(new UnknownHostException()));
        } else {
            a0 observable2 = getAnswers().observeOn(a.b()).subscribeOn(a.b());
            n.e(observable2, "getItems()\n                    .observeOn(Schedulers.io())\n                    .subscribeOn(Schedulers.io())");
            getDisposable().b(a.g(observable2, new kotlinx.coroutines.v0.b(this), new kotlinx.coroutines.v0.c(this)));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<List<SurveyQuestion>>> getResult() {
        return this.j;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final SurveyAnswers i() {
        final ArrayList arrayList = new ArrayList(this.g.size());
        Iterator it = this.g.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            arrayList.add(new Pair(item.getKey(), item.getValue()));
        }
        return new SurveyAnswers(arrayList);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> j() {
        return this.sharedPreferenceService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void l() {
        load();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: m, reason: from kotlin metadata */
    public final void saveAnswerAndGoNextIfLast(String questionId, String answerId, boolean isLastCard) {
        boolean z2;
        String answers2;
        n.f(questionId, "questionId");
        n.f(answerId, "answerId");
        this.getOnboardingQuestionsInteractor.logEvent(E_OnboardingV2.a.withParameters(new Pair(new EP_QuestionId(), questionId), new Pair(new EP_AnswerId(), answerId)));
        this.g.put(questionId, answerId);
        String str5 = "id_yes";
        if (n.b(questionId, "id_potty_training") && n.b(answerId, str5)) {
            this.f.G0(this.answers);
        }
        if (n.b(questionId, "id_puppy_bitting") && n.b(answerId, str5)) {
            this.f.F0(this.answers);
        }
        if (isLastCard) {
            o();
            this.sharedPreferenceService.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n() {
        this.f.T0(false);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void o() {
        this.getOnboardingQuestionsInteractor.logEvent(E_OnboardingV2.b.h());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p(String str) {
        n.f(str, "questionId");
        this.getOnboardingQuestionsInteractor.logEvent(E_OnboardingV2.c.d(new Pair(new EP_QuestionId(), str)));
    }

}
