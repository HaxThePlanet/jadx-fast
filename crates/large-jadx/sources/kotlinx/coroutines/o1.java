package app.dogo.com.dogo_android.s.a;

import app.dogo.android.persistencedb.room.entity.DogLocalEntity;
import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class o1 implements n {

    public final /* synthetic */ DogLocalEntity a;
    public /* synthetic */ o1(DogLocalEntity dogLocalEntity) {
        super();
        this.a = dogLocalEntity;
    }

    public final Object apply(Object object) {
        return WorkoutSessionInteractor.o(this.a, object);
    }
}
