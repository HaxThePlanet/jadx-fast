package app.dogo.com.dogo_android.f.k;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.WorkoutSession;
import app.dogo.com.dogo_android.s.a.r3;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import i.b.a0;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;

/* compiled from: DailyWorkoutOverviewViewModel.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0016J\u0014\u0010\u0018\u001a\u00020\u00162\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bJ\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0016R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b0\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/overview/DailyWorkoutOverviewViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "workoutSessionInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "_results", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "results", "Landroidx/lifecycle/LiveData;", "getResults", "()Landroidx/lifecycle/LiveData;", "startWorkout", "Lcom/hadilq/liveevent/LiveEvent;", "getStartWorkout", "()Lcom/hadilq/liveevent/LiveEvent;", "loadWorkout", "", "retry", "startWorkoutPressed", "trackWorkoutInfoClicked", "trackWorkoutStartClicked", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h, reason: from kotlin metadata */
public final class DailyWorkoutOverviewViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final r3 connectivityService;
    private final o3 b;
    private final j2 c;
    /* renamed from: d, reason: from kotlin metadata */
    private final x<y<WorkoutSession>> tracker = new x<>();
    /* renamed from: e, reason: from kotlin metadata */
    private final LiveData<y<WorkoutSession>> workoutSessionInteractor = new x<>();
    private final f.d.a.a<WorkoutSession> f = new a<>();

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, kotlin.w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            h.this.tracker.postValue(new LoadResult_Error(th));
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<WorkoutSession, kotlin.w> {
        @Override // kotlin.d0.d.p
        public final void a(WorkoutSession workoutSession) {
            h.this.tracker.postValue(new LoadResult_Success(workoutSession));
        }

        b() {
            super(1);
        }
    }
    public h(r3 r3Var, o3 o3Var, j2 j2Var) {
        n.f(r3Var, "workoutSessionInteractor");
        n.f(o3Var, "tracker");
        n.f(j2Var, "connectivityService");
        super();
        this.connectivityService = r3Var;
        this.b = o3Var;
        this.c = j2Var;
        x xVar = new x();
        f.d.a.a aVar = new a();
        loadWorkout();
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ x startWorkoutPressed(h results) {
        return results.tracker;
    }

    /* renamed from: l, reason: from kotlin metadata */
    private final void loadWorkout() {
        this.tracker.postValue(LoadResult_Loading.a);
        if (!this.c.a()) {
            this.b.s("daily_workout_overview");
            this.tracker.postValue(new LoadResult_Error(new UnknownHostException()));
        } else {
            a0 observable2 = this.connectivityService.d().map(new app.dogo.com.dogo_android.dailyworkout.overview.d(this)).subscribeOn(a.b()).observeOn(a.b());
            n.e(observable2, "workoutSessionInteractor.fetchWorkoutSession()\n                    .map {\n                        workoutSessionInteractor.resetStreakIfNeededAndSetStreakIncreaseFlag(it)\n                    }.subscribeOn(Schedulers.io())\n                    .observeOn(Schedulers.io())");
            getDisposable().b(a.g(observable2, new app.dogo.com.dogo_android.dailyworkout.overview.h.a(this), new app.dogo.com.dogo_android.dailyworkout.overview.h.b(this)));
        }
    }

    private static final WorkoutSession m(h hVar, WorkoutSession workoutSession) {
        n.f(hVar, "this$0");
        n.f(workoutSession, "it");
        return hVar.connectivityService.L(workoutSession);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<WorkoutSession>> i() {
        return this.workoutSessionInteractor;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<WorkoutSession> j() {
        return this.f;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n() {
        loadWorkout();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void o(y<WorkoutSession> yVar) {
        int i;
        Object component1;
        n.f(yVar, "results");
        Object yVar2 = yVar instanceof LoadResult_Success ? (LoadResult_Success)yVar2 : i;
        if (i != 0) {
        }
        if (component1 != null) {
            this.f.postValue(yVar.component1());
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p() {
        this.b.d(E_DailyWorkout.b);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void q() {
        this.b.d(E_DailyWorkout.c);
    }

    public static /* synthetic */ WorkoutSession k(h hVar, WorkoutSession workoutSession) {
        return DailyWorkoutOverviewViewModel.m(hVar, workoutSession);
    }
}
