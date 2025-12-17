package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.DogProfile;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class g implements n {

    public final app.dogo.com.dogo_android.s.a.f2 a;
    public final DogProfile b;
    public g(app.dogo.com.dogo_android.s.a.f2 f2, DogProfile dogProfile2) {
        super();
        this.a = f2;
        this.b = dogProfile2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return f2.i(this.a, this.b, (CreateDogInviteResponse)object);
    }
}
