package app.dogo.com.dogo_android.y.s;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.s.a.e3;
import app.dogo.com.dogo_android.s.a.p3;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.r1;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.y.i;
import i.b.a0;
import java.net.UnknownHostException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: ProgramLessonViewModel.kt */
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0008\u0010'\u001a\u00020$H\u0002J\u0006\u0010(\u001a\u00020)J\"\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020&2\u0008\u0010+\u001a\u0004\u0018\u00010&2\u0008\u0010,\u001a\u0004\u0018\u00010&J\u0008\u0010-\u001a\u00020)H\u0002J\u0006\u0010.\u001a\u00020$J\u000e\u0010/\u001a\u00020)2\u0006\u00100\u001a\u000201R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u00150\u001c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00160 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lesson/ProgramLessonViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "trainingSessionInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/TrainingSessionInteractor;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "lessonCardListGenerationInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/LessonCardListGenerationInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "lessonItemHelper", "Lapp/dogo/com/dogo_android/util/helpers/LessonItemHelper;", "(Lapp/dogo/com/dogo_android/repository/interactor/TrainingSessionInteractor;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/interactor/LessonCardListGenerationInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lkotlinx/coroutines/CoroutineDispatcher;Lapp/dogo/com/dogo_android/util/helpers/LessonItemHelper;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "shouldOpenProgramCompletionScreen", "Lcom/hadilq/liveevent/LiveEvent;", "getShouldOpenProgramCompletionScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "didDogIdChange", "", "newDogId", "", "getCompletionData", "refreshLesson", "", "dogId", "lessonId", "programId", "resetCompletionProgress", "shouldPreventExitOnceAndSave", "trackIndicatorActive", "status", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$ProgramLessonStatus;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public final class ProgramLessonViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final p3 connectivityService;
    /* renamed from: b, reason: from kotlin metadata */
    private final p1 dispatcher;
    private final e3 c;
    /* renamed from: d, reason: from kotlin metadata */
    private final o3 lessonCardListGenerationInteractor;
    /* renamed from: e, reason: from kotlin metadata */
    private final j2 lessonItemHelper;
    /* renamed from: f, reason: from kotlin metadata */
    private final j1 programRepository;
    private final h0 g;
    private final app.dogo.com.dogo_android.util.j0.a h;
    /* renamed from: i, reason: from kotlin metadata */
    private final x<y<ProgramLessonItem>> tracker;
    /* renamed from: j, reason: from kotlin metadata */
    private final LiveData<y<ProgramLessonItem>> trainingSessionInteractor;
    /* renamed from: k, reason: from kotlin metadata */
    private final f.d.a.a<ProgramLessonItem> userRepository;
    private final CoroutineExceptionHandler l;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ l a;
        public b(CoroutineExceptionHandler.a exc, l lVar) {
            this.a = lVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            this.a.tracker.postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.lesson.ProgramLessonViewModel$refreshLesson$1", f = "ProgramLessonViewModel.kt", l = {51, 54, 59}, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super w>, Object> {

        final /* synthetic */ String $dogId;
        final /* synthetic */ String $lessonId;
        final /* synthetic */ String $programId;
        Object L$0;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj;
            app.dogo.com.dogo_android.y.k.b component1;
            int i = 2;
            int i2 = 1;
            String $programId2;
            String $lessonId2;
            String $programId22;
            Object object2;
            Object object3;
            ProgramLessonItem programLessonItem;
            Object obj2 = b.d();
            final int i3 = 3;
            i = 2;
            i2 = 1;
            if (this.label != 0) {
                if (this.label != i2) {
                    if (this.label != i) {
                        if (this.label != i3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(object);
                            Object blockingGet = l.this.c.isTrainingInProgress((ProgramLessonItem)programLessonItem).blockingGet();
                            l.this.tracker.postValue(new LoadResult_Success(blockingGet));
                            if (l.this.getCompletionData()) {
                                l.this.t().postValue(blockingGet);
                                l.this.dispatcher.k0();
                                l.this.w();
                            }
                        }
                    }
                    q.b(object);
                } else {
                    q.b(object);
                    if (object3.component1() == null) {
                    }
                    if (this.$programId != null) {
                        this.L$0 = component1;
                        this.label = i;
                        if (l.this.programRepository.r(this.$dogId, this.$programId, this) == obj2) {
                            return obj2;
                        }
                    } else {
                    }
                }
                this.L$0 = null;
                this.label = i3;
                if (l.this.connectivityService.a(l.this.h.generateLessonItem(component1, this.$dogId, this.$lessonId, n.b(obj.a().getId(), this.$programId)), this) == obj2) {
                    return obj2;
                }
            } else {
                q.b(object);
                l.this.tracker.postValue(LoadResult_Loading.a);
                if (l.this.lessonItemHelper.a()) {
                    this.label = i2;
                    if (l.this.programRepository.o(this.$dogId, this) == obj2) {
                        return obj2;
                    }
                } else {
                    l.this.lessonCardListGenerationInteractor.setTrainingReminderUserProperties("lesson");
                    l.this.tracker.postValue(new LoadResult_Error(new UnknownHostException()));
                }
            }
            return w.a;
        }

        a(String str, String str2, String str3, d<? super l.a> dVar) {
            this.$dogId = str;
            this.$programId = str2;
            this.$lessonId = str3;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.l.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            kotlinx.coroutines.l.a object2 = new kotlinx.coroutines.l.a(l.this, this.$dogId, this.$programId, this.$lessonId, dVar);
            return object2;
        }
    }
    public /* synthetic */ l(p3 p3Var, p1 p1Var, e3 e3Var, o3 o3Var, j2 j2Var, j1 j1Var, h0 h0Var, app.dogo.com.dogo_android.util.j0.a aVar, int i, kotlin.d0.d.g gVar) {
        h0 h0Var72;
        app.dogo.com.dogo_android.util.j0.a aVar82;
        int i92 = i;
        h0Var72 = i92 & 64 != 0 ? h0Var72 : h0Var;
        i = i92 & 128;
        LessonItemHelper r10 = i92 & 128 != 0 ? new essonItemHelper() : aVar;
        this(p3Var, p1Var, e3Var, o3Var, j2Var, j1Var, h0Var72, (i92 & 128 != 0 ? new essonItemHelper() : aVar));
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ boolean didDogIdChange(l newDogId) {
        return newDogId.getCompletionData();
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ j2 trackIndicatorActive(l status) {
        return status.lessonItemHelper;
    }

    public static final /* synthetic */ e3 j(l lVar) {
        return lVar.c;
    }

    public static final /* synthetic */ app.dogo.com.dogo_android.util.j0.a k(l lVar) {
        return lVar.h;
    }

    public static final /* synthetic */ j1 l(l lVar) {
        return lVar.programRepository;
    }

    public static final /* synthetic */ o3 m(l lVar) {
        return lVar.lessonCardListGenerationInteractor;
    }

    public static final /* synthetic */ p3 n(l lVar) {
        return lVar.connectivityService;
    }

    public static final /* synthetic */ p1 o(l lVar) {
        return lVar.dispatcher;
    }

    public static final /* synthetic */ x p(l lVar) {
        return lVar.tracker;
    }

    public static final /* synthetic */ void q(l lVar) {
        lVar.w();
    }

    /* renamed from: s, reason: from kotlin metadata */
    private final boolean getCompletionData() {
        boolean booleanValue = false;
        Object value = this.programRepository.u().getValue();
        if (value == null) {
            int i = 0;
        } else {
            booleanValue = value.booleanValue();
        }
        return booleanValue;
    }

    private final void w() {
        this.programRepository.y();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<ProgramLessonItem>> getResult() {
        return this.trainingSessionInteractor;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean r(String str) {
        n.f(str, "newDogId");
        Object value = this.tracker.getValue();
        if (value instanceof LoadResult_Success) {
            return !(n.b((ProgramLessonItem)value.component1().getProgramSaveInfo().getDogId(), str));
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<ProgramLessonItem> t() {
        return this.userRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u() {
        this.dispatcher.t0();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: v, reason: from kotlin metadata */
    public final void refreshLesson(String dogId, String lessonId, String programId) {
        n.f(dogId, "dogId");
        kotlinx.coroutines.l.a aVar = new kotlinx.coroutines.l.a(this, dogId, programId, lessonId, null);
        kotlinx.coroutines.internal.k.d(f0.a(this), this.g.plus(this.l), null, aVar, 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean x() {
        boolean z = this.dispatcher.q0();
        if (z) {
            this.dispatcher.l0();
        }
        return this.dispatcher.q0();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y(ProgramLessonItem.ProgramLessonStatus programLessonStatus) {
        boolean z = true;
        n.f(programLessonStatus, "status");
        programLessonStatus = programLessonStatus == ProgramLessonItem_ProgramLessonStatus.PASSED ? 1 : 0;
        this.lessonCardListGenerationInteractor.logEvent((programLessonStatus == ProgramLessonItem_ProgramLessonStatus.PASSED ? 1 : 0));
    }

    public l(p3 p3Var, p1 p1Var, e3 e3Var, o3 o3Var, j2 j2Var, j1 j1Var, h0 h0Var, app.dogo.com.dogo_android.util.j0.a aVar) {
        n.f(p3Var, "trainingSessionInteractor");
        n.f(p1Var, "userRepository");
        n.f(e3Var, "lessonCardListGenerationInteractor");
        n.f(o3Var, "tracker");
        n.f(j2Var, "connectivityService");
        n.f(j1Var, "programRepository");
        n.f(h0Var, "dispatcher");
        n.f(aVar, "lessonItemHelper");
        super();
        this.connectivityService = p3Var;
        this.dispatcher = p1Var;
        this.c = e3Var;
        this.lessonCardListGenerationInteractor = o3Var;
        this.lessonItemHelper = j2Var;
        this.programRepository = j1Var;
        this.g = h0Var;
        this.h = aVar;
        x xVar = new x(LoadResult_Loading.a);
        this.tracker = xVar;
        this.trainingSessionInteractor = xVar;
        this.userRepository = new a();
        this.l = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
    }
}
