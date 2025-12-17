package app.dogo.com.dogo_android.s.a;

import app.dogo.android.persistencedb.room.entity.DogLocalEntity;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class o1 implements n {

    public final DogLocalEntity a;
    public o1(DogLocalEntity dogLocalEntity) {
        super();
        this.a = dogLocalEntity;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return r3.I(this.a, (DogWorkoutResponse)object);
    }
}
