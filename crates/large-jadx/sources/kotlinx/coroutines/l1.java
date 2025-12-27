package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo;
import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class l1 implements n {

    public final /* synthetic */ WorkoutStreakInfo a;
    public final /* synthetic */ r3 b;
    public final /* synthetic */ String c;
    public /* synthetic */ l1(WorkoutStreakInfo workoutStreakInfo, r3 r3Var, String str) {
        super();
        this.a = workoutStreakInfo;
        this.b = r3Var;
        this.c = str;
    }

    public final Object apply(Object object) {
        return WorkoutSessionInteractor.N(this.a, this.b, this.c, object);
    }
}
