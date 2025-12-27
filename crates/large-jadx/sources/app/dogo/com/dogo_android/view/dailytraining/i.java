package app.dogo.com.dogo_android.view.dailytraining;

import i.b.l0.c;
import java.util.List;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class i implements c {

    public final /* synthetic */ l a;
    public final /* synthetic */ List b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;
    public /* synthetic */ i(l lVar, List list, boolean z, boolean z2) {
        super();
        this.a = lVar;
        this.b = list;
        this.c = z;
        this.d = z2;
    }

    public final Object apply(Object object, Object object2) {
        return SessionViewModel.u(this.a, this.b, this.c, this.d, (DogProfile)object, (Boolean)object2);
    }
}
