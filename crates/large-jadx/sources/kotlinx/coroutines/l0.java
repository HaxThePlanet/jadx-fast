package app.dogo.com.dogo_android.s.a;

import app.dogo.android.persistencedb.room.entity.WorkoutInfoEntity;
import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class l0 implements n {

    public final /* synthetic */ WorkoutInfoEntity a;
    public /* synthetic */ l0(WorkoutInfoEntity workoutInfoEntity) {
        super();
        this.a = workoutInfoEntity;
    }

    public final Object apply(Object object) {
        return ShouldShowWorkoutUnlockedInteractor.g(this.a, object);
    }
}
