package app.dogo.com.dogo_android.y.w;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.Program;
import app.dogo.com.dogo_android.s.a.v2;
import app.dogo.com.dogo_android.s.b.k1;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.t2;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.m0;

/* compiled from: ProgramLessonsListViewModel.kt */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010(\u001a\u00020\u0014J\u0006\u0010)\u001a\u00020\u0014J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020+J\u0006\u0010-\u001a\u00020+J\u0006\u0010.\u001a\u00020\u0014J\u0006\u0010/\u001a\u00020+J\u0006\u00100\u001a\u00020+J\u0006\u00101\u001a\u00020+R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u001dR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010 \u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110!¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u001a\u0010$\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010\u0016\"\u0004\u0008&\u0010'R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "programId", "", "interactor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonsListInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "rateRepository", "Lapp/dogo/com/dogo_android/repository/local/RateRepository;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonsListInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/RateRepository;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/Program;", "certificateEnabled", "", "getCertificateEnabled", "()Z", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "programDescription", "getProgramDescription", "()Landroidx/lifecycle/MutableLiveData;", "programName", "getProgramName", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "shouldScrollToLastUnlocked", "getShouldScrollToLastUnlocked", "setShouldScrollToLastUnlocked", "(Z)V", "getIntroductionShowedFlag", "isProgramTutorialFinished", "loadList", "", "setIntroductionShowedFlag", "setLastRateUsPopUpCallTime", "timeToShowPopUp", "trackLessonTutorialShowed", "trackLockedItemPressed", "trackPremiumOpenFromLockedAlert", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: o, reason: from kotlin metadata */
public final class ProgramLessonsListViewModel extends s {

    private final String a;
    private final v2 b;
    /* renamed from: c, reason: from kotlin metadata */
    private final o3 interactor;
    /* renamed from: d, reason: from kotlin metadata */
    private final r2 preferenceService;
    private final k1 e;
    /* renamed from: f, reason: from kotlin metadata */
    private final p2 programId;
    private final x<String> g = new x<>();
    /* renamed from: h, reason: from kotlin metadata */
    private final x<String> rateRepository = new x<>();
    /* renamed from: i, reason: from kotlin metadata */
    private boolean remoteConfigService = true;
    private final x<y<Program>> j = new x<>();
    private final LiveData<y<Program>> k = new x<>();
    /* renamed from: l, reason: from kotlin metadata */
    private final CoroutineExceptionHandler tracker = new o$b();

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final /* synthetic */ o a;
        public b(CoroutineExceptionHandler.a exc, o oVar) {
            this.a = oVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(g context, Throwable exception) {
            this.a.j.postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.lessonslist.ProgramLessonsListViewModel$loadList$1", f = "ProgramLessonsListViewModel.kt", l = 49, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object activeLessonId;
            Object obj = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    o.this.j.postValue(new LoadResult_Success(activeLessonId));
                    o.this.o().postValue(activeLessonId.getName());
                    o.this.n().postValue(activeLessonId.getDescription());
                    return w.a;
                }
            }
            q.b(object);
            o.this.j.postValue(LoadResult_Loading.a);
            if (App.INSTANCE.e().getActiveNetworkType()) {
                this.label = i;
                if (o.this.b.findActiveLessonId(o.this.a, this) == obj) {
                    return obj;
                }
            } else {
                o.this.interactor.setTrainingReminderUserProperties("program_lesson_list");
                o.this.j.postValue(new LoadResult_Error(new UnknownHostException()));
            }
        }

        a(d<? super o.a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.o.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.o.a(o.this, dVar);
        }
    }
    public o(String str, v2 v2Var, o3 o3Var, r2 r2Var, k1 k1Var, p2 p2Var) {
        n.f(str, "programId");
        n.f(v2Var, "interactor");
        n.f(o3Var, "tracker");
        n.f(r2Var, "remoteConfigService");
        n.f(k1Var, "rateRepository");
        n.f(p2Var, "preferenceService");
        super();
        this.a = str;
        this.b = v2Var;
        this.interactor = o3Var;
        this.preferenceService = r2Var;
        this.e = k1Var;
        this.programId = p2Var;
        x xVar = new x();
        x xVar2 = new x();
        x xVar3 = new x();
        final app.dogo.com.dogo_android.y.w.o.b coroutineExceptionHandlerKt_CoroutineExceptionHandler_1 = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
    }

    public static final /* synthetic */ v2 h(o oVar) {
        return oVar.b;
    }

    public static final /* synthetic */ String i(o oVar) {
        return oVar.a;
    }

    public static final /* synthetic */ o3 j(o oVar) {
        return oVar.interactor;
    }

    public static final /* synthetic */ x k(o oVar) {
        return oVar.j;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<Program>> getResult() {
        return this.k;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: l, reason: from kotlin metadata */
    public final boolean getIntroductionShowedFlag() {
        return this.preferenceService.P();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean m() {
        return this.programId.N();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<String> n() {
        return this.rateRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<String> o() {
        return this.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean p() {
        return this.remoteConfigService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean q() {
        return this.programId.k0();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void r() {
        final d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), this.tracker, dVar, new kotlinx.coroutines.o.a(this, dVar), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s() {
        this.programId.f1(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void t() {
        this.e.f();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u(boolean z) {
        this.remoteConfigService = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean v() {
        return this.e.i();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w() {
        this.interactor.logEvent(E_TrainingProgram.q.withoutParameters());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        this.interactor.logEvent(E_TrainingProgram.c.withoutParameters());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y() {
        this.interactor.logEvent(E_TrainingProgram.c.withoutParameters());
    }
}
