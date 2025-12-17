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
import app.dogo.com.dogo_android.util.j0.a;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.r1;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.y.i;
import app.dogo.com.dogo_android.y.k;
import f.d.a.a;
import i.b.a0;
import java.net.UnknownHostException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlin.y.p;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0008\u0010'\u001a\u00020$H\u0002J\u0006\u0010(\u001a\u00020)J\"\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020&2\u0008\u0010+\u001a\u0004\u0018\u00010&2\u0008\u0010,\u001a\u0004\u0018\u00010&J\u0008\u0010-\u001a\u00020)H\u0002J\u0006\u0010.\u001a\u00020$J\u000e\u0010/\u001a\u00020)2\u0006\u00100\u001a\u000201R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u00150\u001c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00160 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lesson/ProgramLessonViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "trainingSessionInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/TrainingSessionInteractor;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "lessonCardListGenerationInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/LessonCardListGenerationInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "lessonItemHelper", "Lapp/dogo/com/dogo_android/util/helpers/LessonItemHelper;", "(Lapp/dogo/com/dogo_android/repository/interactor/TrainingSessionInteractor;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/interactor/LessonCardListGenerationInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lkotlinx/coroutines/CoroutineDispatcher;Lapp/dogo/com/dogo_android/util/helpers/LessonItemHelper;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "shouldOpenProgramCompletionScreen", "Lcom/hadilq/liveevent/LiveEvent;", "getShouldOpenProgramCompletionScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "didDogIdChange", "", "newDogId", "", "getCompletionData", "refreshLesson", "", "dogId", "lessonId", "programId", "resetCompletionProgress", "shouldPreventExitOnceAndSave", "trackIndicatorActive", "status", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$ProgramLessonStatus;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l extends s {

    private final p3 a;
    private final p1 b;
    private final e3 c;
    private final o3 d;
    private final j2 e;
    private final j1 f;
    private final h0 g;
    private final a h;
    private final x<y<ProgramLessonItem>> i;
    private final LiveData<y<ProgramLessonItem>> j;
    private final a<ProgramLessonItem> k;
    private final CoroutineExceptionHandler l;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.y.s.l a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.y.s.l l2) {
            this.a = l2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            l.p(this.a).postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.lesson.ProgramLessonViewModel$refreshLesson$1", f = "ProgramLessonViewModel.kt", l = {51, 54, 59}, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        final String $dogId;
        final String $lessonId;
        final String $programId;
        Object L$0;
        int label;
        final app.dogo.com.dogo_android.y.s.l this$0;
        a(app.dogo.com.dogo_android.y.s.l l, String string2, String string3, String string4, d<? super app.dogo.com.dogo_android.y.s.l.a> d5) {
            this.this$0 = l;
            this.$dogId = string2;
            this.$programId = string3;
            this.$lessonId = string4;
            super(2, d5);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (l.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            super(this.this$0, this.$dogId, this.$programId, this.$lessonId, d2);
            return obj7;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            boolean aVar;
            Object l$0;
            int $dogId;
            Object unknownHostException;
            int i;
            int $dogId2;
            String $programId;
            String $programId2;
            Object obj;
            Object obj9;
            Object obj2 = b.d();
            $dogId = this.label;
            final int i2 = 3;
            i = 2;
            $dogId2 = 1;
            if ($dogId != 0) {
                if ($dogId != $dogId2) {
                    if ($dogId != i) {
                        if ($dogId != i2) {
                        } else {
                            q.b(object);
                            obj9 = l.j(this.this$0).a((ProgramLessonItem)obj9).blockingGet();
                            unknownHostException = new y.c((ProgramLessonItem)obj9);
                            l.p(this.this$0).postValue(unknownHostException);
                            if (l.h(this.this$0)) {
                                this.this$0.t().postValue(obj9);
                                l.o(this.this$0).k0();
                                l.q(this.this$0);
                            }
                        }
                        obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw obj9;
                    }
                    l$0 = this.L$0;
                    q.b(object);
                    l$0 = obj9;
                    obj9 = obj;
                } else {
                    q.b(object);
                    if ((i)obj9.a() == null) {
                        l$0 = obj9;
                    }
                    if (this.$programId != null) {
                        this.L$0 = l$0;
                        this.label = i;
                        if (l.l(this.this$0).r(this.$dogId, this.$programId, this) == obj2) {
                            return obj2;
                        }
                    } else {
                        obj9 = l$0;
                    }
                }
                this.L$0 = 0;
                this.label = i2;
                if (l.n(this.this$0).a(l.k(this.this$0).e(l$0, this.$dogId, this.$lessonId, n.b(obj9.a().getId(), this.$programId)), this) == obj2) {
                    return obj2;
                }
            } else {
                q.b(object);
                l.p(this.this$0).postValue(y.b.a);
                if (!l.i(this.this$0).a()) {
                    l.m(this.this$0).s("lesson");
                    unknownHostException = new UnknownHostException();
                    aVar = new y.a(unknownHostException);
                    l.p(this.this$0).postValue(aVar);
                } else {
                    this.label = $dogId2;
                    if (l.l(this.this$0).o(this.$dogId, this) == obj2) {
                        return obj2;
                    }
                }
            }
            return w.a;
        }
    }
    public l(p3 p3, p1 p12, e3 e33, o3 o34, j2 j25, j1 j16, h0 h07, a a8) {
        n.f(p3, "trainingSessionInteractor");
        n.f(p12, "userRepository");
        n.f(e33, "lessonCardListGenerationInteractor");
        n.f(o34, "tracker");
        n.f(j25, "connectivityService");
        n.f(j16, "programRepository");
        n.f(h07, "dispatcher");
        n.f(a8, "lessonItemHelper");
        super();
        this.a = p3;
        this.b = p12;
        this.c = e33;
        this.d = o34;
        this.e = j25;
        this.f = j16;
        this.g = h07;
        this.h = a8;
        x obj2 = new x(y.b.a);
        this.i = obj2;
        this.j = obj2;
        obj2 = new a();
        this.k = obj2;
        l.b obj3 = new l.b(CoroutineExceptionHandler.r, this);
        this.l = obj3;
    }

    public l(p3 p3, p1 p12, e3 e33, o3 o34, j2 j25, j1 j16, h0 h07, a a8, int i9, g g10) {
        int aVar;
        h0 i;
        h0 h0Var;
        a aVar2;
        int i2 = i9;
        if (i2 & 64 != 0) {
            h0Var = i;
        } else {
            h0Var = h07;
        }
        if (i2 &= 128 != 0) {
            aVar = new a();
            aVar2 = aVar;
        } else {
            aVar2 = a8;
        }
        super(p3, p12, e33, o34, j25, j16, h0Var, aVar2);
    }

    public static final boolean h(app.dogo.com.dogo_android.y.s.l l) {
        return l.s();
    }

    public static final j2 i(app.dogo.com.dogo_android.y.s.l l) {
        return l.e;
    }

    public static final e3 j(app.dogo.com.dogo_android.y.s.l l) {
        return l.c;
    }

    public static final a k(app.dogo.com.dogo_android.y.s.l l) {
        return l.h;
    }

    public static final j1 l(app.dogo.com.dogo_android.y.s.l l) {
        return l.f;
    }

    public static final o3 m(app.dogo.com.dogo_android.y.s.l l) {
        return l.d;
    }

    public static final p3 n(app.dogo.com.dogo_android.y.s.l l) {
        return l.a;
    }

    public static final p1 o(app.dogo.com.dogo_android.y.s.l l) {
        return l.b;
    }

    public static final x p(app.dogo.com.dogo_android.y.s.l l) {
        return l.i;
    }

    public static final void q(app.dogo.com.dogo_android.y.s.l l) {
        l.w();
    }

    private final boolean s() {
        int booleanValue;
        Object value = this.f.u().getValue();
        if ((Boolean)value == null) {
            booleanValue = 0;
        } else {
            booleanValue = (Boolean)value.booleanValue();
        }
        return booleanValue;
    }

    private final void w() {
        this.f.y();
    }

    public final LiveData<y<ProgramLessonItem>> getResult() {
        return this.j;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean r(String string) {
        n.f(string, "newDogId");
        Object value = this.i.getValue();
        if (value instanceof y.c) {
            return obj3 ^= 1;
        }
        return 0;
    }

    public final a<ProgramLessonItem> t() {
        return this.k;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u() {
        this.b.t0();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v(String string, String string2, String string3) {
        n.f(string, "dogId");
        super(this, string, string3, string2, 0);
        k.d(f0.a(this), this.g.plus(this.l), 0, aVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean x() {
        p1 p1Var;
        boolean z = this.b.q0();
        if (z) {
            this.b.l0();
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y(ProgramLessonItem.ProgramLessonStatus programLessonItem$ProgramLessonStatus) {
        int obj4;
        n.f(programLessonStatus, "status");
        r1 r1Var = new r1();
        obj4 = programLessonStatus == ProgramLessonItem.ProgramLessonStatus.PASSED ? 1 : 0;
        this.d.d(q0.e.d(u.a(r1Var, Boolean.valueOf(obj4))));
    }
}
