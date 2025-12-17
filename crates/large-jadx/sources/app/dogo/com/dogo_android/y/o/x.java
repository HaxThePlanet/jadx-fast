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
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.u2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.i2;
import app.dogo.com.dogo_android.w.l1;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p0;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.w2;
import f.d.a.a;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\n\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u0008\u00107\u001a\u0004\u0018\u000108J\u0008\u00109\u001a\u00020:H\u0002J\u0006\u0010;\u001a\u00020:J\u0006\u0010<\u001a\u00020=J\u0008\u0010>\u001a\u00020=H\u0002J\u0006\u0010?\u001a\u00020=J\u000e\u0010@\u001a\u00020=2\u0006\u00105\u001a\u000206J\u0006\u0010A\u001a\u00020=J\u000e\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u001cJ\u000e\u0010D\u001a\u00020=2\u0006\u00105\u001a\u000206J\u000e\u0010E\u001a\u00020=2\u0006\u00105\u001a\u000206J\u000e\u0010F\u001a\u00020=2\u0006\u00105\u001a\u000206R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010!\u001a\u00020\"¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$R\u0011\u0010%\u001a\u00020\"¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010$R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008'\u0010(R\u0017\u0010)\u001a\u0008\u0012\u0004\u0012\u00020*0\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010 R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010,\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b0-¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010/R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00080\u0010(\"\u0004\u00081\u00102R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "shouldScrollToLastUnlocked", "", "interactor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonsListInteractor;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "addExamHeadersInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/AddExamHeadersInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;ZLapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonsListInteractor;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/repository/interactor/AddExamHeadersInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamList;", "examCompleted", "Lcom/hadilq/liveevent/LiveEvent;", "getExamCompleted", "()Lcom/hadilq/liveevent/LiveEvent;", "examUpdateHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getExamUpdateHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "getHandler", "isUserIntroducedToExams", "()Z", "onError", "", "getOnError", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "getShouldScrollToLastUnlocked", "setShouldScrollToLastUnlocked", "(Z)V", "getExam", "Lapp/dogo/com/dogo_android/model/Exam;", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "getExamInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "getSelectedLocale", "", "getUserId", "loadList", "", "loadModuleExam", "retry", "setActiveExamReviewed", "setUserAsIntroducedToExams", "shouldShowExamCompletedScreen", "examsListData", "trackExamFeedbackPressed", "trackOnLockedPressed", "trackOnUnlockedPressed", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class x extends s {

    private final ProgramSaveInfo a;
    private boolean b;
    private final v2 c;
    private final h2 d;
    private final p2 e;
    private final u2 f;
    private final x1 g;
    private final o3 h;
    private final r2 i;
    private final j2 j;
    private final j1 k;
    private final x<y<ProgramExamList>> l;
    private final LiveData<y<ProgramExamList>> m;
    private final a<ProgramExamList> n;
    private final a<Throwable> o;
    private final CoroutineExceptionHandler p;
    private final CoroutineExceptionHandler q;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.y.o.x a;
        public c(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.y.o.x x2) {
            this.a = x2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            this.a.s().postValue(throwable2);
            y.a aVar = new y.a(throwable2);
            x.o(this.a).postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends a implements CoroutineExceptionHandler {
        public d(CoroutineExceptionHandler.a coroutineExceptionHandler$a) {
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            a.d(throwable2);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.examlist.LessonExamListViewModel$loadModuleExam$1", f = "LessonExamListViewModel.kt", l = 72, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.y.o.x this$0;
        a(app.dogo.com.dogo_android.y.o.x x, d<? super app.dogo.com.dogo_android.y.o.x.a> d2) {
            this.this$0 = x;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (x.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            x.a obj2 = new x.a(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            boolean aVar;
            Object unknownHostException;
            int dogId;
            String programId;
            Object obj5;
            Object obj = b.d();
            dogId = this.label;
            final int i = 1;
            if (dogId != 0) {
                if (dogId != i) {
                } else {
                    q.b(object);
                    obj5 = x.h(this.this$0).b(x.h(this.this$0).d((ProgramExamList)obj5), x.m(this.this$0).P());
                    unknownHostException = new y.c(obj5);
                    x.o(this.this$0).postValue(unknownHostException);
                    if (this.this$0.D(obj5)) {
                        this.this$0.q().postValue(obj5);
                    }
                    return w.a;
                }
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
            }
            q.b(object);
            x.o(this.this$0).postValue(y.b.a);
            if (!x.i(this.this$0).a()) {
                x.n(this.this$0).s("lesson_exam_list");
                UnknownHostException unknownHostException2 = new UnknownHostException();
                this.this$0.s().postValue(unknownHostException2);
                unknownHostException = new UnknownHostException();
                aVar = new y.a(unknownHostException);
                x.o(this.this$0).postValue(aVar);
            } else {
                this.label = i;
                if (x.j(this.this$0).v(x.l(this.this$0).getDogId(), x.l(this.this$0).getProgramId(), this) == obj) {
                    return obj;
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.examlist.LessonExamListViewModel$setActiveExamReviewed$1", f = "LessonExamListViewModel.kt", l = 117, m = "invokeSuspend")
    static final class b extends k implements p<m0, d<? super w>, Object> {

        final ProgramExam $item;
        int label;
        final app.dogo.com.dogo_android.y.o.x this$0;
        b(app.dogo.com.dogo_android.y.o.x x, ProgramExam programExam2, d<? super app.dogo.com.dogo_android.y.o.x.b> d3) {
            this.this$0 = x;
            this.$item = programExam2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (x.b)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            x.b obj3 = new x.b(this.this$0, this.$item, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int dogId;
            String programId;
            String trickId;
            Object obj6;
            Object obj = b.d();
            dogId = this.label;
            final int i = 1;
            if (dogId != 0) {
                if (dogId != i) {
                } else {
                    q.b(object);
                    return w.a;
                }
                obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj6;
            }
            q.b(object);
            this.label = i;
            if (x.k(this.this$0).F(x.l(this.this$0).getDogId(), x.l(this.this$0).getProgramId(), this.$item.getTrickId(), this) == obj) {
                return obj;
            }
        }
    }
    public x(ProgramSaveInfo programSaveInfo, boolean z2, v2 v23, h2 h24, p2 p25, u2 u26, x1 x17, o3 o38, r2 r29, j2 j210, j1 j111) {
        n.f(programSaveInfo, "programSaveInfo");
        n.f(v23, "interactor");
        n.f(h24, "authService");
        n.f(p25, "preferenceService");
        n.f(u26, "userLocalCacheService");
        n.f(x17, "addExamHeadersInteractor");
        n.f(o38, "tracker");
        n.f(r29, "remoteConfigService");
        n.f(j210, "connectivityService");
        n.f(j111, "programRepository");
        super();
        this.a = programSaveInfo;
        this.b = z2;
        this.c = v23;
        this.d = h24;
        this.e = p25;
        this.f = u26;
        this.g = x17;
        this.h = o38;
        this.i = r29;
        this.j = j210;
        this.k = j111;
        x obj2 = new x();
        this.l = obj2;
        this.m = obj2;
        obj2 = new a();
        this.n = obj2;
        obj2 = new a();
        this.o = obj2;
        obj2 = CoroutineExceptionHandler.r;
        x.c obj3 = new x.c(obj2, this);
        this.p = obj3;
        obj3 = new x.d(obj2);
        this.q = obj3;
    }

    public static final x1 h(app.dogo.com.dogo_android.y.o.x x) {
        return x.g;
    }

    public static final j2 i(app.dogo.com.dogo_android.y.o.x x) {
        return x.j;
    }

    public static final v2 j(app.dogo.com.dogo_android.y.o.x x) {
        return x.c;
    }

    public static final j1 k(app.dogo.com.dogo_android.y.o.x x) {
        return x.k;
    }

    public static final ProgramSaveInfo l(app.dogo.com.dogo_android.y.o.x x) {
        return x.a;
    }

    public static final r2 m(app.dogo.com.dogo_android.y.o.x x) {
        return x.i;
    }

    public static final o3 n(app.dogo.com.dogo_android.y.o.x x) {
        return x.h;
    }

    public static final x o(app.dogo.com.dogo_android.y.o.x x) {
        return x.l;
    }

    private final String t() {
        return this.e.W();
    }

    private final void y() {
        final int i = 0;
        x.a aVar = new x.a(this, i);
        k.d(f0.a(this), this.p, i, aVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void A(ProgramExam programExam) {
        boolean z;
        Object tRUE;
        CoroutineExceptionHandler exc;
        int i3;
        app.dogo.com.dogo_android.y.o.x.b bVar;
        int i2;
        int i;
        n.f(programExam, "item");
        if (n.b(programExam.getHasNewUpdates(), Boolean.TRUE)) {
            bVar = new x.b(this, programExam, 0);
            k.d(f0.a(this), this.q, 0, bVar, 2, 0);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void B(boolean z) {
        this.b = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void C() {
        this.e.I0(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean D(ProgramExamList programExamList) {
        ProgramExamSummary programExamSummary;
        int i;
        int i2;
        Object obj4;
        n.f(programExamList, "examsListData");
        programExamSummary = programExamList.getProgramExamSummary();
        final int i3 = 1;
        if (programExamSummary == null) {
            i = i2;
        } else {
        }
        if (i != 0 && programExamList.allExamsViewedByUser()) {
            if (programExamList.allExamsViewedByUser()) {
                i2 = i3;
            }
        }
        return i2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void E(ProgramExam programExam) {
        n.f(programExam, "item");
        n2 n2Var = new n2();
        i2 i2Var = new i2();
        r2 r2Var = new r2();
        this.h.d(p0.d.c(n2Var, programExam.getTrickId(), i2Var, programExam.getStatus(), r2Var, "lesson_exam_list"));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void F(ProgramExam programExam) {
        n.f(programExam, "item");
        l1 l1Var = new l1();
        this.h.d(q0.u.c(l1Var, programExam.getExamId()));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void G(ProgramExam programExam) {
        n.f(programExam, "item");
        l1 l1Var = new l1();
        this.h.d(q0.t.c(l1Var, programExam.getExamId()));
    }

    public final LiveData<y<ProgramExamList>> getResult() {
        return this.m;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Exam p(ProgramExam programExam) {
        n.f(programExam, "item");
        return j1.m0(programExam, this.f.A().g().toModel(this.d.v()), v(), t());
    }

    public final a<ProgramExamList> q() {
        return this.n;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final ProgramExamSummary r() {
        int value;
        ProgramExamSummary programExamSummary;
        if (value instanceof y.c) {
        } else {
            value = programExamSummary;
        }
        if (value == null) {
        } else {
            value = value.a();
            if ((ProgramExamList)value == null) {
            } else {
                programExamSummary = (ProgramExamList)value.getProgramExamSummary();
            }
        }
        return programExamSummary;
    }

    public final a<Throwable> s() {
        return this.o;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean u() {
        return this.b;
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
