package app.dogo.com.dogo_android.f.l;

import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.WorkoutSession;
import app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo;
import app.dogo.com.dogo_android.s.a.q3;
import app.dogo.com.dogo_android.s.a.r3;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.a0;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q3;
import app.dogo.com.dogo_android.w.w;
import e.a.a.a.b.b.s0;
import f.d.a.a;
import i.b.a0;
import i.b.b;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001:\u00013BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0006\u0010$\u001a\u00020\u001fJ\u0006\u0010%\u001a\u00020\u001fJ\u0006\u0010&\u001a\u00020\u001fJ\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0006\u0010*\u001a\u00020(J\u0006\u0010+\u001a\u00020(J\u000e\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020(J\u0010\u00100\u001a\u00020(2\u0006\u0010-\u001a\u00020.H\u0002J\u0011\u00101\u001a\u00020.H\u0082@ø\u0001\u0000¢\u0006\u0002\u00102R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u00064", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "workoutSession", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "workoutEntityDao", "Lapp/dogo/android/persistencedb/room/dao/WorkoutEntityDao;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "workoutSessionInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "trainingTimeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/TrainingTimeInteractor;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "trainingTimer", "Lapp/dogo/com/dogo_android/util/TrainingTimer;", "(Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/android/persistencedb/room/dao/WorkoutEntityDao;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/interactor/TrainingTimeInteractor;Lkotlinx/coroutines/CoroutineDispatcher;Lapp/dogo/com/dogo_android/util/TrainingTimer;)V", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutViewModel$WorkoutResults;", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "streakSaveState", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "getStreakSaveState", "()Landroidx/lifecycle/MutableLiveData;", "getWorkoutSession", "()Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "isTrainingStreaksEnabled", "isWorkoutStreaksEnabled", "isWorkoutTutorialNotCompleted", "onWorkoutComplete", "", "pauseTimer", "saveStreak", "setWorkoutTutorialAsCompleted", "showWorkoutCompletedScreen", "workoutStreakInfo", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutStreakInfo;", "startTimer", "trackUserProperties", "updateWorkoutStreakInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "WorkoutResults", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l extends s {

    private final WorkoutSession a;
    private final p2 b;
    private final s0 c;
    private final o3 d;
    private final r3 e;
    private final j2 f;
    private final r2 g;
    private final q3 h;
    private final h0 i;
    private final a0 j;
    private final x<y<Boolean>> k;
    private final a<app.dogo.com.dogo_android.f.l.l.a> l;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutViewModel$WorkoutResults;", "", "()V", "TrainingStreak", "WorkoutStreak", "Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutViewModel$WorkoutResults$WorkoutStreak;", "Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutViewModel$WorkoutResults$TrainingStreak;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dailyworkout.session.DailyWorkoutViewModel", f = "DailyWorkoutViewModel.kt", l = 90, m = "updateWorkoutStreakInfo")
    static final class c extends d {

        int label;
        Object result;
        final app.dogo.com.dogo_android.f.l.l this$0;
        c(app.dogo.com.dogo_android.f.l.l l, d<? super app.dogo.com.dogo_android.f.l.l.c> d2) {
            this.this$0 = l;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return l.o(this.this$0, this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dailyworkout.session.DailyWorkoutViewModel$saveStreak$1", f = "DailyWorkoutViewModel.kt", l = {53, 56}, m = "invokeSuspend")
    static final class b extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.f.l.l this$0;
        b(app.dogo.com.dogo_android.f.l.l l, d<? super app.dogo.com.dogo_android.f.l.l.b> d2) {
            this.this$0 = l;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (l.b)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            l.b obj2 = new l.b(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object aVar;
            int label;
            Object unknownHostException;
            int i;
            q3 q3Var;
            long l;
            int i3;
            int i2;
            int i5;
            Object obj;
            int i4;
            int i6;
            Object obj14;
            Object obj2 = b.d();
            label = this.label;
            i = 2;
            final int i7 = 1;
            if (label != 0) {
                if (label != i7) {
                    if (label != i) {
                    } else {
                        q.b(object);
                        aVar = new l.a.b((WorkoutStreakInfo)obj14);
                        unknownHostException = new y.c(b.a(i7));
                        this.this$0.q().postValue(unknownHostException);
                        this.this$0.p().postValue(aVar);
                    }
                    obj14 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj14;
                }
                q.b(object);
                aVar = new l.a.a((TrainingTimeMetrics)obj14);
            } else {
                q.b(object);
                this.this$0.q().postValue(y.b.a);
                if (!l.h(this.this$0).a()) {
                    l.j(this.this$0).s("daily_workout_overview");
                    unknownHostException = new UnknownHostException();
                    aVar = new y.a(unknownHostException);
                    this.this$0.q().postValue(aVar);
                } else {
                    if (l.i(this.this$0).g0()) {
                        this.label = i7;
                        if (q3.k(l.k(this.this$0), l.l(this.this$0).g(), obj6, 0, 0, 0, this, 14) == obj2) {
                            return obj2;
                        }
                    } else {
                        this.label = i;
                        if (l.o(this.this$0, this) == obj2) {
                            try {
                                return obj2;
                                aVar = new l.a.b((WorkoutStreakInfo)obj14);
                                unknownHostException = new y.c(b.a(i7));
                                this.this$0.q().postValue(unknownHostException);
                                this.this$0.p().postValue(aVar);
                            }
                        }
                    }
                }
            }
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutStreakInfo;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dailyworkout.session.DailyWorkoutViewModel$updateWorkoutStreakInfo$2", f = "DailyWorkoutViewModel.kt", l = {}, m = "invokeSuspend")
    static final class d extends k implements p<m0, d<? super WorkoutStreakInfo>, Object> {

        int label;
        final app.dogo.com.dogo_android.f.l.l this$0;
        d(app.dogo.com.dogo_android.f.l.l l, d<? super app.dogo.com.dogo_android.f.l.l.d> d2) {
            this.this$0 = l;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super WorkoutStreakInfo> d2) {
            return (l.d)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            l.d obj2 = new l.d(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
            } else {
                q.b(object);
                Object obj3 = l.m(this.this$0).T(this.this$0.r().getDogId()).blockingGet();
                n.e((WorkoutStreakInfo)obj3, "workoutStreakInfo");
                l.n(this.this$0, obj3);
                return obj3;
            }
            obj3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj3;
        }
    }
    public l(WorkoutSession workoutSession, p2 p22, s0 s03, o3 o34, r3 r35, j2 j26, r2 r27, q3 q38, h0 h09, a0 a010) {
        n.f(workoutSession, "workoutSession");
        n.f(p22, "preferenceService");
        n.f(s03, "workoutEntityDao");
        n.f(o34, "tracker");
        n.f(r35, "workoutSessionInteractor");
        n.f(j26, "connectivityService");
        n.f(r27, "remoteConfigService");
        n.f(q38, "trainingTimeInteractor");
        n.f(h09, "dispatcher");
        n.f(a010, "trainingTimer");
        super();
        this.a = workoutSession;
        this.b = p22;
        this.c = s03;
        this.d = o34;
        this.e = r35;
        this.f = j26;
        this.g = r27;
        this.h = q38;
        this.i = h09;
        this.j = a010;
        x obj2 = new x();
        this.k = obj2;
        obj2 = new a();
        this.l = obj2;
    }

    public l(WorkoutSession workoutSession, p2 p22, s0 s03, o3 o34, r3 r35, j2 j26, r2 r27, q3 q38, h0 h09, a0 a010, int i11, g g12) {
        int a0Var;
        h0 i;
        int i2;
        int i3;
        h0 h0Var;
        a0 a0Var2;
        int i4 = i11;
        if (i4 & 256 != 0) {
            h0Var = i;
        } else {
            h0Var = h09;
        }
        if (i4 &= 512 != 0) {
            a0Var = new a0(0, 1, 0);
            a0Var2 = a0Var;
        } else {
            a0Var2 = a010;
        }
        super(workoutSession, p22, s03, o34, r35, j26, r27, q38, h0Var, a0Var2);
    }

    private final void B(WorkoutStreakInfo workoutStreakInfo) {
        this.d.q(q3.CurrentStreak, Integer.valueOf(workoutStreakInfo.getCurrentStreak()));
        this.d.q(q3.LongestStreak, Integer.valueOf(workoutStreakInfo.getLongestStreak()));
        this.d.q(q3.LastWorkoutTime, Long.valueOf(workoutStreakInfo.getLastAchievedStreakTimestampMs()));
    }

    private final Object C(d<? super WorkoutStreakInfo> d) {
        boolean cVar;
        int label;
        int i2;
        int dVar;
        int i3;
        int i;
        Object obj6;
        cVar = d;
        label = cVar.label;
        i2 = Integer.MIN_VALUE;
        if (d instanceof l.c && label & i2 != 0) {
            cVar = d;
            label = cVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                cVar.label = label -= i2;
            } else {
                cVar = new l.c(this, d);
            }
        } else {
        }
        obj6 = cVar.result;
        Object obj = b.d();
        dVar = cVar.label;
        int i4 = 1;
        if (dVar != 0) {
            if (dVar != i4) {
            } else {
                q.b(obj6);
                n.e(obj6, "private suspend fun updateWorkoutStreakInfo(): WorkoutStreakInfo {\n        return withContext(dispatcher) {\n            val workoutStreakInfo = workoutSessionInteractor.updateWorkoutStreak(workoutSession.dogId).blockingGet()\n            trackUserProperties(workoutStreakInfo)\n            workoutStreakInfo\n        }\n    }");
                return obj6;
            }
            obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj6;
        }
        q.b(obj6);
        dVar = new l.d(this, 0);
        cVar.label = i4;
        if (k.e(this.i, dVar, cVar) == obj) {
            return obj;
        }
    }

    public static final j2 h(app.dogo.com.dogo_android.f.l.l l) {
        return l.f;
    }

    public static final r2 i(app.dogo.com.dogo_android.f.l.l l) {
        return l.g;
    }

    public static final o3 j(app.dogo.com.dogo_android.f.l.l l) {
        return l.d;
    }

    public static final q3 k(app.dogo.com.dogo_android.f.l.l l) {
        return l.h;
    }

    public static final a0 l(app.dogo.com.dogo_android.f.l.l l) {
        return l.j;
    }

    public static final r3 m(app.dogo.com.dogo_android.f.l.l l) {
        return l.e;
    }

    public static final void n(app.dogo.com.dogo_android.f.l.l l, WorkoutStreakInfo workoutStreakInfo2) {
        l.B(workoutStreakInfo2);
    }

    public static final Object o(app.dogo.com.dogo_android.f.l.l l, d d2) {
        return l.C(d2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void A() {
        final int i = 0;
        a0.n(this.j, i, 1, i);
    }

    public final a<app.dogo.com.dogo_android.f.l.l.a> p() {
        return this.l;
    }

    public final x<y<Boolean>> q() {
        return this.k;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final WorkoutSession r() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean s() {
        return this.g.g0();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean t() {
        return this.a.isStreaksEnabled();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean u() {
        return z ^= 1;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v() {
        final int i = 1;
        this.d.e(w.a, i);
        this.b.q1(i);
        this.c.g(this.a.getDogId()).e();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w() {
        boolean z;
        q3 q3Var;
        long l;
        int i2;
        int i5;
        int i4;
        int i;
        int i3;
        if (this.j.k()) {
            this.j.l();
            q3.m(this.h, this.j.g(), obj3, 0, 0, 0, 14);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        final int i = 0;
        l.b bVar = new l.b(this, i);
        k.d(f0.a(this), i, 0, bVar, 3, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y() {
        this.b.A1(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean z(WorkoutStreakInfo workoutStreakInfo) {
        int obj2;
        n.f(workoutStreakInfo, "workoutStreakInfo");
        if (workoutStreakInfo.getCurrentStreak() != this.a.getCurrentStreak() && t()) {
            obj2 = t() ? 1 : 0;
        } else {
        }
        return obj2;
    }
}
