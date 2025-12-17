package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.DogProfile;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class t implements n {

    public final app.dogo.com.dogo_android.s.a.t2 a;
    public final DogProfile b;
    public final Boolean c;
    public final boolean v;
    public t(app.dogo.com.dogo_android.s.a.t2 t2, DogProfile dogProfile2, Boolean boolean3, boolean z4) {
        super();
        this.a = t2;
        this.b = dogProfile2;
        this.c = boolean3;
        this.v = z4;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return t2.h(this.a, this.b, this.c, this.v, (TrainingStreakEntity)object);
    }
}
