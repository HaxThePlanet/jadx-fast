package app.dogo.com.dogo_android.w;

import kotlin.Metadata;

/* compiled from: Events.kt */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$DailyWorkout;", "", "()V", "DailyGoalCompleted", "Lapp/dogo/com/dogo_android/tracking/ParameterizedEvent;", "DailyWorkoutCompleted", "OverviewWorkoutCompletedContinueTapped", "OverviewWorkoutInfoTapped", "OverviewWorkoutLaterTapped", "OverviewWorkoutStartTapped", "OverviewWorkoutTryTapped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: w, reason: from kotlin metadata */
public final class E_DailyWorkout {

    public static final h3 a;
    public static final h3 b;
    public static final h3 c;
    public static final h3 d;
    public static final h3 e;
    public static final h3 f;
    static {
        app.dogo.com.dogo_android.w.s2.a iNSTANCE2 = Event.INSTANCE;
        iNSTANCE2.of("daily_goal_completed").h();
        E_DailyWorkout.a = iNSTANCE2.of("daily_workout_completed").h();
        E_DailyWorkout.b = iNSTANCE2.of("daily_workout_info_tapped").h();
        E_DailyWorkout.c = iNSTANCE2.of("daily_workout_start_session_tapped").h();
        E_DailyWorkout.d = iNSTANCE2.of("daily_session_unlocked_try_tapped").h();
        E_DailyWorkout.e = iNSTANCE2.of("daily_session_unlocked_later_tapped").h();
        E_DailyWorkout.f = iNSTANCE2.of("daily_workout_completed_continue_tapped").h();
    }
}
