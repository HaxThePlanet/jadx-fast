package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.DogProfile;
import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class t implements n {

    public final /* synthetic */ t2 a;
    public final /* synthetic */ DogProfile b;
    public final /* synthetic */ Boolean c;
    public final /* synthetic */ boolean v;
    public /* synthetic */ t(t2 t2Var, DogProfile dogProfile, Boolean boolean, boolean z) {
        super();
        this.a = t2Var;
        this.b = dogProfile;
        this.c = boolean;
        this.v = z;
    }

    public final Object apply(Object object) {
        return GetProfilePreviewInteractor.d(this.a, this.b, this.c, this.v, object);
    }
}
