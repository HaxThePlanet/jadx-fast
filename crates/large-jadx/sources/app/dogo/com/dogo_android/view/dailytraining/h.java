package app.dogo.com.dogo_android.view.dailytraining;

import app.dogo.com.dogo_android.repository.domain.DogProfile;
import i.b.l0.n;
import java.util.Map;

/* loaded from: classes.dex */
public final class h implements n {

    public final DogProfile a;
    public final Map b;
    public h(DogProfile dogProfile, Map map2) {
        super();
        this.a = dogProfile;
        this.b = map2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return l.X(this.a, this.b, (DogBreed)object);
    }
}
