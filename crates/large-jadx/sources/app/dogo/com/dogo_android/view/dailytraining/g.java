package app.dogo.com.dogo_android.view.dailytraining;

import app.dogo.com.dogo_android.repository.domain.DogProfile;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class g implements n {

    public final app.dogo.com.dogo_android.view.dailytraining.l a;
    public final DogProfile b;
    public g(app.dogo.com.dogo_android.view.dailytraining.l l, DogProfile dogProfile2) {
        super();
        this.a = l;
        this.b = dogProfile2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return l.W(this.a, this.b, (Map)object);
    }
}
