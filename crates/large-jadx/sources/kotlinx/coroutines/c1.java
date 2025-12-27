package app.dogo.com.dogo_android.s.a;

import app.dogo.externalmodel.model.responses.DogWorkoutResponse;
import java.util.concurrent.Callable;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c1 implements Callable {

    public final /* synthetic */ DogWorkoutResponse a;
    public /* synthetic */ c1(DogWorkoutResponse dogWorkoutResponse) {
        super();
        this.a = dogWorkoutResponse;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return WorkoutSessionInteractor.c(this.a);
    }
}
