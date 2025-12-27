package app.dogo.com.dogo_android.f.n;

import androidx.lifecycle.x;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.w.o3;
import f.d.a.a;
import i.b.b;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DailyWorkoutUnlockedViewModel.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/unlock/DailyWorkoutUnlockedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "dogId", "", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "dogLocalEntityDao", "Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;)V", "getDogId", "()Ljava/lang/String;", "goDailyWorkout", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoDailyWorkout", "()Lcom/hadilq/liveevent/LiveEvent;", "onDismiss", "getOnDismiss", "workoutLaterClicked", "", "workoutTryClicked", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class DailyWorkoutUnlockedViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final String dogId;
    /* renamed from: b, reason: from kotlin metadata */
    private final o3 dogLocalEntityDao;
    private final e.a.a.a.b.b.w c;
    private final a<Boolean> d = new a<>();
    /* renamed from: e, reason: from kotlin metadata */
    private final a<Boolean> tracker = new a<>();
    public e(String str, o3 o3Var, e.a.a.a.b.b.w wVar) {
        n.f(str, "dogId");
        n.f(o3Var, "tracker");
        n.f(wVar, "dogLocalEntityDao");
        super();
        this.dogId = str;
        this.dogLocalEntityDao = o3Var;
        this.c = wVar;
        a aVar = new a();
        a aVar2 = new a();
        wVar.doesDogLocalEntityExists(str).e();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: h, reason: from kotlin metadata */
    public final a<Boolean> workoutLaterClicked() {
        return this.d;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final a<Boolean> i() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void j() {
        this.dogLocalEntityDao.logEvent(E_DailyWorkout.e);
        this.tracker.postValue(Boolean.TRUE);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void k() {
        this.dogLocalEntityDao.logEvent(E_DailyWorkout.d);
        this.d.postValue(Boolean.TRUE);
    }
}
