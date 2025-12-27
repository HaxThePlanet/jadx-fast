package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo;
import i.b.l0.n;
import java.util.List;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b1 implements n {

    public final /* synthetic */ List a;
    public final /* synthetic */ r3 b;
    public final /* synthetic */ WorkoutStreakInfo c;
    public final /* synthetic */ String v;
    public /* synthetic */ b1(List list, r3 r3Var, WorkoutStreakInfo workoutStreakInfo, String str) {
        super();
        this.a = list;
        this.b = r3Var;
        this.c = workoutStreakInfo;
        this.v = str;
    }

    public final Object apply(Object object) {
        return WorkoutSessionInteractor.l(this.a, this.b, this.c, this.v, object);
    }
}
