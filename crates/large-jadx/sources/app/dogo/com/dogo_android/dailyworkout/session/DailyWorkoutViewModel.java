package app.dogo.com.dogo_android.f.l;

import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.WorkoutSession;
import app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo;
import app.dogo.com.dogo_android.s.a.r3;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import e.a.a.a.b.b.s0;
import f.d.a.a;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: DailyWorkoutViewModel.kt */
@Metadata(d1 = "\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001:\u00013BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0006\u0010$\u001a\u00020\u001fJ\u0006\u0010%\u001a\u00020\u001fJ\u0006\u0010&\u001a\u00020\u001fJ\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0006\u0010*\u001a\u00020(J\u0006\u0010+\u001a\u00020(J\u000e\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020(J\u0010\u00100\u001a\u00020(2\u0006\u0010-\u001a\u00020.H\u0002J\u0011\u00101\u001a\u00020.H\u0082@ø\u0001\u0000¢\u0006\u0002\u00102R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u00064", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "workoutSession", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "workoutEntityDao", "Lapp/dogo/android/persistencedb/room/dao/WorkoutEntityDao;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "workoutSessionInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "trainingTimeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/TrainingTimeInteractor;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "trainingTimer", "Lapp/dogo/com/dogo_android/util/TrainingTimer;", "(Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/android/persistencedb/room/dao/WorkoutEntityDao;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/interactor/TrainingTimeInteractor;Lkotlinx/coroutines/CoroutineDispatcher;Lapp/dogo/com/dogo_android/util/TrainingTimer;)V", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutViewModel$WorkoutResults;", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "streakSaveState", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "getStreakSaveState", "()Landroidx/lifecycle/MutableLiveData;", "getWorkoutSession", "()Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "isTrainingStreaksEnabled", "isWorkoutStreaksEnabled", "isWorkoutTutorialNotCompleted", "onWorkoutComplete", "", "pauseTimer", "saveStreak", "setWorkoutTutorialAsCompleted", "showWorkoutCompletedScreen", "workoutStreakInfo", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutStreakInfo;", "startTimer", "trackUserProperties", "updateWorkoutStreakInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "WorkoutResults", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public final class DailyWorkoutViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final WorkoutSession connectivityService;
    /* renamed from: b, reason: from kotlin metadata */
    private final p2 dispatcher;
    private final s0 c;
    /* renamed from: d, reason: from kotlin metadata */
    private final o3 preferenceService;
    /* renamed from: e, reason: from kotlin metadata */
    private final r3 remoteConfigService;
    private final j2 f;
    /* renamed from: g, reason: from kotlin metadata */
    private final r2 tracker;
    /* renamed from: h, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.s.a.q3 trainingTimeInteractor;
    /* renamed from: i, reason: from kotlin metadata */
    private final h0 trainingTimer;
    /* renamed from: j, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.util.a0 workoutEntityDao;
    private final x<y<Boolean>> k;
    /* renamed from: l, reason: from kotlin metadata */
    private final a<l.a> workoutSessionInteractor;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutViewModel$WorkoutResults;", "", "()V", "TrainingStreak", "WorkoutStreak", "Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutViewModel$WorkoutResults$WorkoutStreak;", "Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutViewModel$WorkoutResults$TrainingStreak;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dailyworkout.session.DailyWorkoutViewModel", f = "DailyWorkoutViewModel.kt", l = 90, m = "updateWorkoutStreakInfo")
    static final class c extends kotlin.b0.k.a.d {

        int label;
        /* synthetic */ Object result;
        c(kotlin.b0.d<? super l.c> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return l.this.trackUserProperties(this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dailyworkout.session.DailyWorkoutViewModel$saveStreak$1", f = "DailyWorkoutViewModel.kt", l = {53, 56}, m = "invokeSuspend")
    static final class b extends kotlin.b0.k.a.k implements p<m0, kotlin.b0.d<? super kotlin.w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            app.dogo.com.dogo_android.f.l.l.a.a dailyWorkoutViewModel_WorkoutResults_TrainingStreak;
            y.b bVar;
            app.dogo.com.dogo_android.s.a.q3 q3Var;
            long l;
            app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo = null;
            String str = null;
            String str2 = null;
            kotlin.b0.d dVar;
            int i2 = 14;
            Object obj = null;
            app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics trainingTimeMetrics;
            WorkoutStreakInfo workoutStreakInfo;
            Object obj2 = b.d();
            int i = 2;
            final int i3 = 1;
            if (this.label != 0) {
                if (this.label != i3) {
                    if (this.label != i) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        try {
                            q.b(object);
                        } catch (Exception e) {
                        }
                        app.dogo.com.dogo_android.f.l.l.a.b dailyWorkoutViewModel_WorkoutResults_WorkoutStreak = new DailyWorkoutViewModel_WorkoutResults_WorkoutStreak((WorkoutStreakInfo)workoutStreakInfo);
                        l.this.q().postValue(new LoadResult_Success(b.a(true)));
                        l.this.p().postValue(dailyWorkoutViewModel_WorkoutResults_TrainingStreak);
                    }
                }
                try {
                    q.b(e);
                } catch (Exception e) {
                }
                dailyWorkoutViewModel_WorkoutResults_TrainingStreak = new DailyWorkoutViewModel_WorkoutResults_TrainingStreak((TrainingTimeMetrics)trainingTimeMetrics);
            } else {
                q.b(e);
                l.this.q().postValue(LoadResult_Loading.a);
                if (!l.this.f.a()) {
                    l.this.preferenceService.s("daily_workout_overview");
                    l.this.q().postValue(new LoadResult_Error(new UnknownHostException()));
                } else {
                    try {
                        if (l.this.tracker.g0()) {
                            programSaveInfo = null;
                            str = null;
                            str2 = null;
                            i2 = 14;
                            obj = null;
                            this.label = i3;
                            if (TrainingTimeInteractor.k(l.this.trainingTimeInteractor, l.this.workoutEntityDao.g(), programSaveInfo, str, str2, this, i2, obj) == obj2) {
                                return obj2;
                            }
                        } else {
                            this.label = i;
                            if (l.this.trackUserProperties(this) == obj2) {
                                return obj2;
                            }
                        }
                        l.this.q().postValue(new LoadResult_Success(b.a(true)));
                        l.this.p().postValue(dailyWorkoutViewModel_WorkoutResults_TrainingStreak);
                    } catch (Exception e) {
                    }
                    app.dogo.com.dogo_android.f.l.l lVar = l.this.q();
                    l.this.postValue(new LoadResult_Error(e));
                }
            }
            return w.a;
        }

        b(kotlin.b0.d<? super l.b> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super kotlin.w> dVar) {
            return (app.dogo.com.dogo_android.dailyworkout.session.l.b)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<kotlin.w> create(Object object, kotlin.b0.d<?> dVar) {
            return new app.dogo.com.dogo_android.dailyworkout.session.l.b(l.this, dVar);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutStreakInfo;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dailyworkout.session.DailyWorkoutViewModel$updateWorkoutStreakInfo$2", f = "DailyWorkoutViewModel.kt", l = {}, m = "invokeSuspend")
    static final class d extends kotlin.b0.k.a.k implements p<m0, kotlin.b0.d<? super WorkoutStreakInfo>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(object);
                Object blockingGet = l.this.remoteConfigService.T(l.this.r().getDogId()).blockingGet();
                n.e(blockingGet, "workoutStreakInfo");
                l.this.showWorkoutCompletedScreen(blockingGet);
                return blockingGet;
            }
        }

        d(kotlin.b0.d<? super l.d> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super WorkoutStreakInfo> dVar) {
            return (app.dogo.com.dogo_android.dailyworkout.session.l.d)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<kotlin.w> create(Object object, kotlin.b0.d<?> dVar) {
            return new app.dogo.com.dogo_android.dailyworkout.session.l.d(l.this, dVar);
        }
    }
    public /* synthetic */ l(WorkoutSession workoutSession, p2 p2Var, s0 s0Var, o3 o3Var, r3 r3Var, j2 j2Var, r2 r2Var, app.dogo.com.dogo_android.s.a.q3 q3Var, h0 h0Var, app.dogo.com.dogo_android.util.a0 a0Var, int i, g gVar) {
        h0 h0Var92;
        app.dogo.com.dogo_android.util.a0 a0Var102;
        int i112 = i;
        h0Var92 = i112 & 256 != 0 ? h0Var92 : h0Var;
        i = i112 & 512;
        if (i112 & 512 != 0) {
            int i2 = 1;
            gVar = null;
        } else {
            a0Var102 = a0Var;
        }
        this(workoutSession, p2Var, s0Var, o3Var, r3Var, j2Var, r2Var, q3Var, h0Var92, a0Var102);
    }

    /* renamed from: B, reason: from kotlin metadata */
    private final void showWorkoutCompletedScreen(WorkoutStreakInfo workoutStreakInfo) {
        this.preferenceService.q(UserProperty.CurrentStreak, Integer.valueOf(workoutStreakInfo.getCurrentStreak()));
        this.preferenceService.q(UserProperty.LongestStreak, Integer.valueOf(workoutStreakInfo.getLongestStreak()));
        this.preferenceService.q(UserProperty.LastWorkoutTime, Long.valueOf(workoutStreakInfo.getLastAchievedStreakTimestampMs()));
    }

    /* renamed from: C, reason: from kotlin metadata */
    private final Object trackUserProperties(kotlin.b0.d<? super WorkoutStreakInfo> workoutStreakInfo) {
        Object workoutStreakInfo2;
        int label2;
        int i = -2147483648;
        int i2;
        Object result2;
        z = workoutStreakInfo instanceof app.dogo.com.dogo_android.dailyworkout.session.l.c;
        if (workoutStreakInfo instanceof app.dogo.com.dogo_android.dailyworkout.session.l.c) {
            workoutStreakInfo2 = workoutStreakInfo;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                workoutStreakInfo2.label -= i;
            } else {
                app.dogo.com.dogo_android.f.l.l.c cVar = new app.dogo.com.dogo_android.dailyworkout.session.l.c(this, workoutStreakInfo);
            }
        }
        Object obj = b.d();
        int i3 = 1;
        if (workoutStreakInfo2.label != 0 && workoutStreakInfo2.label == i3) {
            q.b(workoutStreakInfo2.result);
            n.e(result2, "private suspend fun updateWorkoutStreakInfo(): WorkoutStreakInfo {\n        return withContext(dispatcher) {\n            val workoutStreakInfo = workoutSessionInteractor.updateWorkoutStreak(workoutSession.dogId).blockingGet()\n            trackUserProperties(workoutStreakInfo)\n            workoutStreakInfo\n        }\n    }");
            return result2;
        }
        q.b(workoutStreakInfo2.result);
        kotlin.b0.d dVar = null;
        workoutStreakInfo2.label = i3;
        if (kotlinx.coroutines.internal.k.e(this.trainingTimer, new app.dogo.com.dogo_android.dailyworkout.session.l.d(this, dVar), workoutStreakInfo2) == obj) {
            return obj;
        }
    }

    public static final /* synthetic */ j2 h(l lVar) {
        return lVar.f;
    }

    public static final /* synthetic */ r2 i(l lVar) {
        return lVar.tracker;
    }

    public static final /* synthetic */ o3 j(l lVar) {
        return lVar.preferenceService;
    }

    public static final /* synthetic */ app.dogo.com.dogo_android.s.a.q3 k(l lVar) {
        return lVar.trainingTimeInteractor;
    }

    public static final /* synthetic */ app.dogo.com.dogo_android.util.a0 l(l lVar) {
        return lVar.workoutEntityDao;
    }

    public static final /* synthetic */ r3 m(l lVar) {
        return lVar.remoteConfigService;
    }

    public static final /* synthetic */ void n(l lVar, WorkoutStreakInfo workoutStreakInfo) {
        lVar.showWorkoutCompletedScreen(workoutStreakInfo);
    }

    public static final /* synthetic */ Object o(l lVar, kotlin.b0.d dVar) {
        return lVar.trackUserProperties(dVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: A, reason: from kotlin metadata */
    /* suspend */ public final void isTrainingStreaksEnabled() {
        final m0 m0Var = null;
        TrainingTimer.n(this.workoutEntityDao, m0Var, 1, m0Var);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final a<l.a> p() {
        return this.workoutSessionInteractor;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<Boolean>> q() {
        return this.k;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final WorkoutSession r() {
        return this.connectivityService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean s() {
        return this.tracker.g0();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean t() {
        return this.connectivityService.isStreaksEnabled();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean u() {
        return !this.dispatcher.g0();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v() {
        final boolean z = true;
        this.preferenceService.e(E_DailyWorkout.a, z);
        this.dispatcher.q1(z);
        this.c.getDogWorkoutInfo(this.connectivityService.getDogId()).e();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w() {
        if (this.workoutEntityDao.k()) {
            this.workoutEntityDao.l();
            app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo = null;
            String str = null;
            String str2 = null;
            int i = 14;
            Object obj = null;
            TrainingTimeInteractor.m(this.trainingTimeInteractor, this.workoutEntityDao.g(), programSaveInfo, str, str2, i, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        final kotlin.b0.d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), dVar, null, new app.dogo.com.dogo_android.dailyworkout.session.l.b(this, dVar), 3, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y() {
        this.dispatcher.A1(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean z(WorkoutStreakInfo workoutStreakInfo) {
        boolean z2 = false;
        n.f(workoutStreakInfo, "workoutStreakInfo");
        workoutStreakInfo = workoutStreakInfo.getCurrentStreak() != this.connectivityService.getCurrentStreak() && this.t() ? 1 : 0;
        return (workoutStreakInfo.getCurrentStreak() != this.connectivityService.getCurrentStreak() && this.t() ? 1 : 0);
    }

    public l(WorkoutSession workoutSession, p2 p2Var, s0 s0Var, o3 o3Var, r3 r3Var, j2 j2Var, r2 r2Var, app.dogo.com.dogo_android.s.a.q3 q3Var, h0 h0Var, app.dogo.com.dogo_android.util.a0 a0Var) {
        n.f(workoutSession, "workoutSession");
        n.f(p2Var, "preferenceService");
        n.f(s0Var, "workoutEntityDao");
        n.f(o3Var, "tracker");
        n.f(r3Var, "workoutSessionInteractor");
        n.f(j2Var, "connectivityService");
        n.f(r2Var, "remoteConfigService");
        n.f(q3Var, "trainingTimeInteractor");
        n.f(h0Var, "dispatcher");
        n.f(a0Var, "trainingTimer");
        super();
        this.connectivityService = workoutSession;
        this.dispatcher = p2Var;
        this.c = s0Var;
        this.preferenceService = o3Var;
        this.remoteConfigService = r3Var;
        this.f = j2Var;
        this.tracker = r2Var;
        this.trainingTimeInteractor = q3Var;
        this.trainingTimer = h0Var;
        this.workoutEntityDao = a0Var;
        this.k = new x();
        this.workoutSessionInteractor = new a();
    }
}
