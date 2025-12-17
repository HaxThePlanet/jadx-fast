package app.dogo.com.dogo_android.s.a;

import app.dogo.android.persistencedb.room.entity.WorkoutInfoEntity;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class l0 implements n {

    public final WorkoutInfoEntity a;
    public l0(WorkoutInfoEntity workoutInfoEntity) {
        super();
        this.a = workoutInfoEntity;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return l3.b(this.a, (DogLocalEntity)object);
    }
}
