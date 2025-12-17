package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class l1 implements n {

    public final WorkoutStreakInfo a;
    public final app.dogo.com.dogo_android.s.a.r3 b;
    public final String c;
    public l1(WorkoutStreakInfo workoutStreakInfo, app.dogo.com.dogo_android.s.a.r3 r32, String string3) {
        super();
        this.a = workoutStreakInfo;
        this.b = r32;
        this.c = string3;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return r3.F(this.a, this.b, this.c, (DogWorkoutResponse)object);
    }
}
