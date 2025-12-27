package app.dogo.com.dogo_android.y.o;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.model.Exam;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.s.a.n2;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.a0;
import app.dogo.com.dogo_android.w.k1;
import app.dogo.com.dogo_android.w.l1;
import app.dogo.com.dogo_android.w.m2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.m0;

/* compiled from: LessonExamHistoryViewModel.kt */
@Metadata(d1 = "\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0006\u0010'\u001a\u00020\u0005J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0018J\u001c\u0010+\u001a\u00020\u00052\u0014\u0010 \u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00180\u0017\u0018\u00010\u0016J\u0008\u0010,\u001a\u00020\u0005H\u0002J\u0006\u0010-\u001a\u00020\u0005J\u0006\u0010.\u001a\u00020/J\u0008\u00100\u001a\u00020/H\u0002J\u0006\u00101\u001a\u00020/J\u0006\u00102\u001a\u00020/J\u000e\u00103\u001a\u00020/2\u0006\u00104\u001a\u00020\u0005J\u000e\u00105\u001a\u00020/2\u0006\u00106\u001a\u00020\u0005R \u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00180\u00170\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001fR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00180\u00170\u00160!¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010%R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "trickName", "", "trickId", "interactor", "Lapp/dogo/com/dogo_android/repository/interactor/GetExamHistoryListInteractor;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/interactor/GetExamHistoryListInteractor;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "isUserIntroducedToExams", "", "()Z", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "getTrickId", "()Ljava/lang/String;", "getTrickName", "getCountryCode", "getExam", "Lapp/dogo/com/dogo_android/model/Exam;", "item", "getLoadedTrickName", "getSelectedLocale", "getUserId", "loadList", "", "loadModuleExam", "retry", "setUserAsIntroducedToExams", "trackLeaveFeedbackTapped", "trainerName", "trackRetakeExamTapped", "examId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: t, reason: from kotlin metadata */
public final class LessonExamHistoryViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final ProgramSaveInfo authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final String connectivityService;
    private final String c;
    /* renamed from: d, reason: from kotlin metadata */
    private final n2 interactor;
    private final h2 e;
    /* renamed from: f, reason: from kotlin metadata */
    private final p2 preferenceService;
    /* renamed from: g, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.service.u2 programSaveInfo;
    private final o3 h;
    /* renamed from: i, reason: from kotlin metadata */
    private final j2 tracker;
    private final CoroutineExceptionHandler j = new t$b();
    private final x<y<List<ProgramExam>>> k = new x<>();
    /* renamed from: l, reason: from kotlin metadata */
    private final LiveData<y<List<ProgramExam>>> userLocalCacheService = new x<>();

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ t a;
        public b(CoroutineExceptionHandler.a exc, t tVar) {
            this.a = tVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(g context, Throwable exception) {
            this.a.k.postValue(new LoadResult_Error(exception));
            a.d(exception);
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Exam with trickId: ";
            String str3 = this.a.q();
            String str4 = " fetch failed";
            str = str2 + str3 + str4;
            this.a.h.logEvent(E_General.j.d(u.a(new EP_ErrorMessage(), str)));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.examlist.LessonExamHistoryViewModel$loadModuleExam$1", f = "LessonExamHistoryViewModel.kt", l = 60, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            String programId;
            String str;
            Object obj;
            Object obj2 = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    t.this.k.postValue(new LoadResult_Success((List)obj));
                    return w.a;
                }
            }
            q.b(object);
            t.this.k.postValue(LoadResult_Loading.a);
            if (t.this.tracker.a()) {
                this.label = i;
                if (t.this.interactor.e(t.this.authService.getDogId(), t.this.authService.getProgramId(), t.this.q(), this) == obj2) {
                    return obj2;
                }
            } else {
                t.this.h.setTrainingReminderUserProperties("lesson_exam_list");
                t.this.k.postValue(new LoadResult_Error(new UnknownHostException()));
            }
        }

        a(d<? super t.a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.t.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.t.a(t.this, dVar);
        }
    }
    public t(ProgramSaveInfo programSaveInfo, String str, String str2, n2 n2Var, h2 h2Var, p2 p2Var, app.dogo.com.dogo_android.service.u2 u2Var, o3 o3Var, j2 j2Var) {
        n.f(programSaveInfo, "programSaveInfo");
        n.f(str, "trickName");
        n.f(str2, "trickId");
        n.f(n2Var, "interactor");
        n.f(h2Var, "authService");
        n.f(p2Var, "preferenceService");
        n.f(u2Var, "userLocalCacheService");
        n.f(o3Var, "tracker");
        n.f(j2Var, "connectivityService");
        super();
        this.authService = programSaveInfo;
        this.connectivityService = str;
        this.c = str2;
        this.interactor = n2Var;
        this.e = h2Var;
        this.preferenceService = p2Var;
        this.programSaveInfo = u2Var;
        this.h = o3Var;
        this.tracker = j2Var;
        final app.dogo.com.dogo_android.y.o.t.b coroutineExceptionHandlerKt_CoroutineExceptionHandler_1 = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
        x xVar = new x();
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j2 getExam(t item) {
        return item.tracker;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ n2 getLoadedTrickName(t result) {
        return result.interactor;
    }

    /* renamed from: j, reason: from kotlin metadata */
    public static final /* synthetic */ ProgramSaveInfo trackLeaveFeedbackTapped(t trainerName) {
        return trainerName.authService;
    }

    /* renamed from: k, reason: from kotlin metadata */
    public static final /* synthetic */ o3 trackRetakeExamTapped(t examId) {
        return examId.h;
    }

    public static final /* synthetic */ x l(t tVar) {
        return tVar.k;
    }

    /* renamed from: p, reason: from kotlin metadata */
    private final String getCountryCode() {
        return this.preferenceService.W();
    }

    private final void u() {
        final d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), this.j, dVar, new kotlinx.coroutines.t.a(this, dVar), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<List<ProgramExam>>> getResult() {
        return this.userLocalCacheService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String m() {
        String str;
        if (this.programSaveInfo.A().i().b() == null) {
            str = "null";
        }
        return str;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Exam n(ProgramExam programExam) {
        n.f(programExam, "item");
        return app.dogo.com.dogo_android.util.extensionfunction.j1.m0(programExam, this.programSaveInfo.A().g().toModel(this.e.v()), r(), getCountryCode());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String o(y<? extends List<ProgramExam>> yVar) {
        int i;
        boolean z2;
        String str;
        z = yVar instanceof LoadResult_Success;
        i = 0;
        yVar = yVar instanceof oadResult_Success ? (oadResult_Success)yVar : i;
        if (i != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                Iterator it = component1.iterator();
                while (it.hasNext()) {
                    if (n.b((ProgramExam)item.getTrickId(), q())) {
                        break;
                    }
                }
                if (i != 0) {
                    String name = i.getName();
                }
            }
        }
        if (i == 0) {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String q() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String r() {
        return this.e.v();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean s() {
        return this.preferenceService.s();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void t() {
        u();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v() {
        t();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w() {
        this.preferenceService.I0(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x(String str) {
        n.f(str, "trainerName");
        this.h.logEvent(E_TrainingProgram.w.c(new EP_TrainerName(), str));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y(String str) {
        n.f(str, "examId");
        this.h.logEvent(E_TrainingProgram.v.c(new EP_ExamId(), str));
    }
}
