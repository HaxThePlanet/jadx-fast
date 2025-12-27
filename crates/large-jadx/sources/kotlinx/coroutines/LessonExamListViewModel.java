package app.dogo.com.dogo_android.y.o;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.model.Exam;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.repository.domain.ProgramExamList;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.s.a.v2;
import app.dogo.com.dogo_android.s.a.x1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.i2;
import app.dogo.com.dogo_android.w.l1;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p0;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.w2;
import java.net.UnknownHostException;
import kotlin.Metadata;
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

/* compiled from: LessonExamListViewModel.kt */
@Metadata(d1 = "\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\n\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u0008\u00107\u001a\u0004\u0018\u000108J\u0008\u00109\u001a\u00020:H\u0002J\u0006\u0010;\u001a\u00020:J\u0006\u0010<\u001a\u00020=J\u0008\u0010>\u001a\u00020=H\u0002J\u0006\u0010?\u001a\u00020=J\u000e\u0010@\u001a\u00020=2\u0006\u00105\u001a\u000206J\u0006\u0010A\u001a\u00020=J\u000e\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u001cJ\u000e\u0010D\u001a\u00020=2\u0006\u00105\u001a\u000206J\u000e\u0010E\u001a\u00020=2\u0006\u00105\u001a\u000206J\u000e\u0010F\u001a\u00020=2\u0006\u00105\u001a\u000206R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010!\u001a\u00020\"¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$R\u0011\u0010%\u001a\u00020\"¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010$R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008'\u0010(R\u0017\u0010)\u001a\u0008\u0012\u0004\u0012\u00020*0\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010 R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010,\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b0-¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010/R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00080\u0010(\"\u0004\u00081\u00102R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "shouldScrollToLastUnlocked", "", "interactor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonsListInteractor;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "addExamHeadersInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/AddExamHeadersInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;ZLapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonsListInteractor;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/repository/interactor/AddExamHeadersInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamList;", "examCompleted", "Lcom/hadilq/liveevent/LiveEvent;", "getExamCompleted", "()Lcom/hadilq/liveevent/LiveEvent;", "examUpdateHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getExamUpdateHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "getHandler", "isUserIntroducedToExams", "()Z", "onError", "", "getOnError", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "getShouldScrollToLastUnlocked", "setShouldScrollToLastUnlocked", "(Z)V", "getExam", "Lapp/dogo/com/dogo_android/model/Exam;", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "getExamInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "getSelectedLocale", "", "getUserId", "loadList", "", "loadModuleExam", "retry", "setActiveExamReviewed", "setUserAsIntroducedToExams", "shouldShowExamCompletedScreen", "examsListData", "trackExamFeedbackPressed", "trackOnLockedPressed", "trackOnUnlockedPressed", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: x, reason: from kotlin metadata */
public final class LessonExamListViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final ProgramSaveInfo addExamHeadersInteractor;
    /* renamed from: b, reason: from kotlin metadata */
    private boolean authService;
    /* renamed from: c, reason: from kotlin metadata */
    private final v2 connectivityService;
    private final h2 d;
    private final p2 e;
    private final app.dogo.com.dogo_android.service.u2 f;
    /* renamed from: g, reason: from kotlin metadata */
    private final x1 interactor;
    private final o3 h;
    private final app.dogo.com.dogo_android.service.r2 i;
    /* renamed from: j, reason: from kotlin metadata */
    private final j2 preferenceService;
    /* renamed from: k, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.s.b.j1 programRepository;
    /* renamed from: l, reason: from kotlin metadata */
    private final x<y<ProgramExamList>> programSaveInfo = new x<>();
    /* renamed from: m, reason: from kotlin metadata */
    private final LiveData<y<ProgramExamList>> remoteConfigService = new x<>();
    private final f.d.a.a<ProgramExamList> n = new a<>();
    private final f.d.a.a<Throwable> o = new a<>();
    /* renamed from: p, reason: from kotlin metadata */
    private final CoroutineExceptionHandler tracker = new x$c();
    /* renamed from: q, reason: from kotlin metadata */
    private final CoroutineExceptionHandler userLocalCacheService = new x$d();

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ x a;
        public c(CoroutineExceptionHandler.a exc, x xVar) {
            this.a = xVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(g context, Throwable exception) {
            this.a.s().postValue(exception);
            this.a.programSaveInfo.postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends kotlin.b0.a implements CoroutineExceptionHandler {
        public d(CoroutineExceptionHandler.a exc) {
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(g context, Throwable exception) {
            a.d(exception);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.examlist.LessonExamListViewModel$loadModuleExam$1", f = "LessonExamListViewModel.kt", l = 72, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            String programId;
            ProgramExamList programExamList2;
            Object obj = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    ProgramExamList programExamList = x.this.interactor.b(x.this.interactor.d((ProgramExamList)programExamList2), x.this.i.P());
                    x.this.programSaveInfo.postValue(new LoadResult_Success(programExamList));
                    if (x.this.D(programExamList)) {
                        x.this.q().postValue(programExamList);
                    }
                    return w.a;
                }
            }
            q.b(object);
            x.this.programSaveInfo.postValue(LoadResult_Loading.a);
            if (x.this.preferenceService.a()) {
                this.label = i;
                if (x.this.connectivityService.v(x.this.addExamHeadersInteractor.getDogId(), x.this.addExamHeadersInteractor.getProgramId(), this) == obj) {
                    return obj;
                }
            } else {
                x.this.h.setTrainingReminderUserProperties("lesson_exam_list");
                x.this.s().postValue(new UnknownHostException());
                x.this.programSaveInfo.postValue(new LoadResult_Error(new UnknownHostException()));
            }
        }

        a(d<? super x.a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.x.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.x.a(x.this, dVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.examlist.LessonExamListViewModel$setActiveExamReviewed$1", f = "LessonExamListViewModel.kt", l = 117, m = "invokeSuspend")
    static final class b extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        final /* synthetic */ ProgramExam $item;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj2 = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    return w.a;
                }
            }
            q.b(object);
            this.label = i;
            if (x.this.programRepository.F(x.this.addExamHeadersInteractor.getDogId(), x.this.addExamHeadersInteractor.getProgramId(), this.$item.getTrickId(), this) == obj2) {
                return obj2;
            }
        }

        b(ProgramExam programExam, d<? super x.b> dVar) {
            this.$item = programExam;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.x.b)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.x.b(x.this, this.$item, dVar);
        }
    }
    public x(ProgramSaveInfo programSaveInfo, boolean z, v2 v2Var, h2 h2Var, p2 p2Var, app.dogo.com.dogo_android.service.u2 u2Var, x1 x1Var, o3 o3Var, app.dogo.com.dogo_android.service.r2 r2Var, j2 j2Var, app.dogo.com.dogo_android.s.b.j1 j1Var) {
        n.f(programSaveInfo, "programSaveInfo");
        n.f(v2Var, "interactor");
        n.f(h2Var, "authService");
        n.f(p2Var, "preferenceService");
        n.f(u2Var, "userLocalCacheService");
        n.f(x1Var, "addExamHeadersInteractor");
        n.f(o3Var, "tracker");
        n.f(r2Var, "remoteConfigService");
        n.f(j2Var, "connectivityService");
        n.f(j1Var, "programRepository");
        super();
        this.addExamHeadersInteractor = programSaveInfo;
        this.authService = z;
        this.connectivityService = v2Var;
        this.d = h2Var;
        this.e = p2Var;
        this.f = u2Var;
        this.interactor = x1Var;
        this.h = o3Var;
        this.i = r2Var;
        this.preferenceService = j2Var;
        this.programRepository = j1Var;
        x xVar = new x();
        f.d.a.a aVar = new a();
        f.d.a.a aVar2 = new a();
        CoroutineExceptionHandler.a aVar3 = kotlinx.coroutines.internal.CoroutineExceptionHandler.r;
        app.dogo.com.dogo_android.y.o.x.c coroutineExceptionHandlerKt_CoroutineExceptionHandler_1 = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(aVar3, this);
        app.dogo.com.dogo_android.y.o.x.d coroutineExceptionHandlerKt_CoroutineExceptionHandler_12 = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(aVar3);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ x1 getExam(x item) {
        return item.interactor;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ j2 setActiveExamReviewed(x item) {
        return item.preferenceService;
    }

    /* renamed from: j, reason: from kotlin metadata */
    public static final /* synthetic */ v2 shouldShowExamCompletedScreen(x examsListData) {
        return examsListData.connectivityService;
    }

    /* renamed from: k, reason: from kotlin metadata */
    public static final /* synthetic */ app.dogo.com.dogo_android.s.b.j1 trackExamFeedbackPressed(x item) {
        return item.programRepository;
    }

    /* renamed from: l, reason: from kotlin metadata */
    public static final /* synthetic */ ProgramSaveInfo trackOnLockedPressed(x item) {
        return item.addExamHeadersInteractor;
    }

    /* renamed from: m, reason: from kotlin metadata */
    public static final /* synthetic */ app.dogo.com.dogo_android.service.r2 trackOnUnlockedPressed(x item) {
        return item.i;
    }

    public static final /* synthetic */ o3 n(x xVar) {
        return xVar.h;
    }

    public static final /* synthetic */ x o(x xVar) {
        return xVar.programSaveInfo;
    }

    /* renamed from: t, reason: from kotlin metadata */
    private final String getExamInfo() {
        return this.e.W();
    }

    private final void y() {
        final d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), this.tracker, dVar, new kotlinx.coroutines.x.a(this, dVar), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void A(ProgramExam programExam) {
        n.f(programExam, "item");
        if (n.b(programExam.getHasNewUpdates(), Boolean.TRUE)) {
            kotlinx.coroutines.o0 o0Var = null;
            int i = 2;
            Object obj = null;
            kotlinx.coroutines.internal.k.d(f0.a(this), this.userLocalCacheService, o0Var, new kotlinx.coroutines.x.b(this, programExam, null), i, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void B(boolean z) {
        this.authService = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void C() {
        this.e.I0(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean D(ProgramExamList list) {
        int i;
        boolean z = false;
        n.f(list, "examsListData");
        ProgramExamSummary programExamSummary = list.getProgramExamSummary();
        i = 1;
        int r0 = programExamSummary == null ? 0 : i;
        if (i != 0 && list.allExamsViewedByUser()) {
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void E(ProgramExam programExam) {
        n.f(programExam, "item");
        this.h.logEvent(E_Training.d.c(new EP_TrickId(), programExam.getTrickId(), new EP_Status(), programExam.getStatus(), new EP_ViewSource(), "lesson_exam_list"));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void F(ProgramExam programExam) {
        n.f(programExam, "item");
        this.h.logEvent(E_TrainingProgram.u.c(new EP_ExamId(), programExam.getExamId()));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void G(ProgramExam programExam) {
        n.f(programExam, "item");
        this.h.logEvent(E_TrainingProgram.t.c(new EP_ExamId(), programExam.getExamId()));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<ProgramExamList>> getResult() {
        return this.remoteConfigService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Exam p(ProgramExam programExam) {
        n.f(programExam, "item");
        return app.dogo.com.dogo_android.util.extensionfunction.j1.m0(programExam, this.f.A().g().toModel(this.d.v()), v(), getExamInfo());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<ProgramExamList> q() {
        return this.n;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final ProgramExamSummary r() {
        int i;
        ProgramExamSummary programExamSummary = null;
        LoadResult_Success r0 = this.remoteConfigService.getValue() instanceof LoadResult_Success ? (oadResult_Success)this.remoteConfigService.getValue() : 0;
        if (this.remoteConfigService != null) {
            Object component1 = i.component1();
            if (component1 != null) {
                programExamSummary = component1.getProgramExamSummary();
            }
        }
        return programExamSummary;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Throwable> s() {
        return this.o;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean u() {
        return this.authService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String v() {
        return this.d.v();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean w() {
        return this.e.s();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        y();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void z() {
        x();
    }
}
