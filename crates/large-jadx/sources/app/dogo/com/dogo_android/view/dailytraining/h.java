package app.dogo.com.dogo_android.view.dailytraining;

import app.dogo.com.dogo_android.repository.domain.DogProfile;
import i.b.l0.n;
import java.util.Map;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class h implements n {

    public final /* synthetic */ DogProfile a;
    public final /* synthetic */ Map b;
    public /* synthetic */ h(DogProfile dogProfile, Map map) {
        super();
        this.a = dogProfile;
        this.b = map;
    }

    public final Object apply(Object object) {
        return SessionViewModel.A(this.a, this.b, object);
    }
}
