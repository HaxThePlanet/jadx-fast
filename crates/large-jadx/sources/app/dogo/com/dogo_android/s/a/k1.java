package app.dogo.com.dogo_android.s.a;

import i.b.l0.n;
import java.util.List;

/* loaded from: classes.dex */
public final class k1 implements n {

    public final app.dogo.com.dogo_android.s.a.r3 a;
    public final List b;
    public final String c;
    public k1(app.dogo.com.dogo_android.s.a.r3 r3, List list2, String string3) {
        super();
        this.a = r3;
        this.b = list2;
        this.c = string3;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return r3.E(this.a, this.b, this.c, (WorkoutStreakInfo)object);
    }
}
