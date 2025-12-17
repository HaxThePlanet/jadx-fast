package app.dogo.com.dogo_android.view.dailytraining;

import i.b.l0.c;
import java.util.List;

/* loaded from: classes.dex */
public final class i implements c {

    public final app.dogo.com.dogo_android.view.dailytraining.l a;
    public final List b;
    public final boolean c;
    public final boolean d;
    public i(app.dogo.com.dogo_android.view.dailytraining.l l, List list2, boolean z3, boolean z4) {
        super();
        this.a = l;
        this.b = list2;
        this.c = z3;
        this.d = z4;
    }

    @Override // i.b.l0.c
    public final Object apply(Object object, Object object2) {
        return l.Y(this.a, this.b, this.c, this.d, (DogProfile)object, (Boolean)object2);
    }
}
