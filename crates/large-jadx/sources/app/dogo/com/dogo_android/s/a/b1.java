package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo;
import i.b.l0.n;
import java.util.List;

/* loaded from: classes.dex */
public final class b1 implements n {

    public final List a;
    public final app.dogo.com.dogo_android.s.a.r3 b;
    public final WorkoutStreakInfo c;
    public final String v;
    public b1(List list, app.dogo.com.dogo_android.s.a.r3 r32, WorkoutStreakInfo workoutStreakInfo3, String string4) {
        super();
        this.a = list;
        this.b = r32;
        this.c = workoutStreakInfo3;
        this.v = string4;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return r3.v(this.a, this.b, this.c, this.v, (List)object);
    }
}
