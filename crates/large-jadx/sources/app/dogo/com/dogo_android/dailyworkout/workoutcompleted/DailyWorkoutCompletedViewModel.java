package app.dogo.com.dogo_android.f.o;

import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.w;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DailyWorkoutCompletedViewModel.kt */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/workoutcompleted/DailyWorkoutCompletedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "(Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/Utilities;)V", "setTodaysWorkoutCompletedShowedTime", "", "trackWorkoutCompletedContinueClicked", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public final class DailyWorkoutCompletedViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final o3 preferenceService;
    /* renamed from: b, reason: from kotlin metadata */
    private final p2 tracker;
    /* renamed from: c, reason: from kotlin metadata */
    private final v2 utilities;
    public d(o3 o3Var, p2 p2Var, v2 v2Var) {
        n.f(o3Var, "tracker");
        n.f(p2Var, "preferenceService");
        n.f(v2Var, "utilities");
        super();
        this.preferenceService = o3Var;
        this.tracker = p2Var;
        this.utilities = v2Var;
        setTodaysWorkoutCompletedShowedTime();
    }

    /* renamed from: h, reason: from kotlin metadata */
    private final void setTodaysWorkoutCompletedShowedTime() {
        this.tracker.d1(this.utilities.g());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i() {
        this.preferenceService.logEvent(E_DailyWorkout.f);
    }
}
