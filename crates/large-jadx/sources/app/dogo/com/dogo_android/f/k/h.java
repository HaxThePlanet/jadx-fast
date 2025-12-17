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
import app.dogo.com.dogo_android.w.w;
import f.d.a.a;
import i.b.a0;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0016J\u0014\u0010\u0018\u001a\u00020\u00162\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bJ\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0016R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b0\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/overview/DailyWorkoutOverviewViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "workoutSessionInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "_results", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "results", "Landroidx/lifecycle/LiveData;", "getResults", "()Landroidx/lifecycle/LiveData;", "startWorkout", "Lcom/hadilq/liveevent/LiveEvent;", "getStartWorkout", "()Lcom/hadilq/liveevent/LiveEvent;", "loadWorkout", "", "retry", "startWorkoutPressed", "trackWorkoutInfoClicked", "trackWorkoutStartClicked", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h extends s {

    private final r3 a;
    private final o3 b;
    private final j2 c;
    private final x<y<WorkoutSession>> d;
    private final LiveData<y<WorkoutSession>> e;
    private final a<WorkoutSession> f;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.f.k.h this$0;
        a(app.dogo.com.dogo_android.f.k.h h) {
            this.this$0 = h;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            y.a aVar = new y.a(throwable);
            h.h(this.this$0).postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<WorkoutSession, w> {

        final app.dogo.com.dogo_android.f.k.h this$0;
        b(app.dogo.com.dogo_android.f.k.h h) {
            this.this$0 = h;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(WorkoutSession workoutSession) {
            y.c cVar = new y.c(workoutSession);
            h.h(this.this$0).postValue(cVar);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((WorkoutSession)object);
            return w.a;
        }
    }
    public h(r3 r3, o3 o32, j2 j23) {
        n.f(r3, "workoutSessionInteractor");
        n.f(o32, "tracker");
        n.f(j23, "connectivityService");
        super();
        this.a = r3;
        this.b = o32;
        this.c = j23;
        x obj2 = new x();
        this.d = obj2;
        this.e = obj2;
        obj2 = new a();
        this.f = obj2;
        l();
    }

    public static final x h(app.dogo.com.dogo_android.f.k.h h) {
        return h.d;
    }

    public static WorkoutSession k(app.dogo.com.dogo_android.f.k.h h, WorkoutSession workoutSession2) {
        return h.m(h, workoutSession2);
    }

    private final void l() {
        Object disposable;
        Object aVar;
        Object unknownHostException;
        app.dogo.com.dogo_android.f.k.h.b bVar;
        this.d.postValue(y.b.a);
        if (!this.c.a()) {
            this.b.s("daily_workout_overview");
            unknownHostException = new UnknownHostException();
            aVar = new y.a(unknownHostException);
            this.d.postValue(aVar);
        } else {
            d dVar = new d(this);
            a0 observeOn = this.a.d().map(dVar).subscribeOn(a.b()).observeOn(a.b());
            n.e(observeOn, "workoutSessionInteractor.fetchWorkoutSession()\n                    .map {\n                        workoutSessionInteractor.resetStreakIfNeededAndSetStreakIncreaseFlag(it)\n                    }.subscribeOn(Schedulers.io())\n                    .observeOn(Schedulers.io())");
            unknownHostException = new h.a(this);
            bVar = new h.b(this);
            getDisposable().b(a.g(observeOn, unknownHostException, bVar));
        }
    }

    private static final WorkoutSession m(app.dogo.com.dogo_android.f.k.h h, WorkoutSession workoutSession2) {
        n.f(h, "this$0");
        n.f(workoutSession2, "it");
        return h.a.L(workoutSession2);
    }

    public final LiveData<y<WorkoutSession>> i() {
        return this.e;
    }

    public final a<WorkoutSession> j() {
        return this.f;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n() {
        l();
    }

    public final void o(y<WorkoutSession> y) {
        int i2;
        Object i;
        Object obj3;
        n.f(y, "results");
        if (y instanceof y.c) {
            i2 = y;
        } else {
            i2 = i;
        }
        if (i2 == 0) {
        } else {
            i = i2;
        }
        if (i != null) {
            this.f.postValue((y.c)y.a());
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p() {
        this.b.d(w.b);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void q() {
        this.b.d(w.c);
    }
}
