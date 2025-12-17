package app.dogo.com.dogo_android.service;

import app.dogo.externalmodel.model.responses.DogCreateResponse;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class z1 implements Callable {

    public final DogCreateResponse a;
    public z1(DogCreateResponse dogCreateResponse) {
        super();
        this.a = dogCreateResponse;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return u2.N(this.a);
    }
}
