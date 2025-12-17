package app.dogo.com.dogo_android.d.b;

import app.dogo.com.dogo_android.model.DogProfileModel;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class s implements n {

    public final app.dogo.com.dogo_android.d.b.x a;
    public final DogProfileModel b;
    public s(app.dogo.com.dogo_android.d.b.x x, DogProfileModel dogProfileModel2) {
        super();
        this.a = x;
        this.b = dogProfileModel2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return x.C0(this.a, this.b, (DogProfile)object);
    }
}
