package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.DogProfile;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class l implements n {

    public final DogProfile a;
    public l(DogProfile dogProfile) {
        super();
        this.a = dogProfile;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return m2.h(this.a, (String)object);
    }
}
