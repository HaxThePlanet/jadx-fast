package app.dogo.com.dogo_android.view.dailytraining;

import app.dogo.com.dogo_android.repository.domain.DogProfile;
import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class g implements n {

    public final /* synthetic */ l a;
    public final /* synthetic */ DogProfile b;
    public /* synthetic */ g(l lVar, DogProfile dogProfile) {
        super();
        this.a = lVar;
        this.b = dogProfile;
    }

    public final Object apply(Object object) {
        return SessionViewModel.z(this.a, this.b, object);
    }
}
