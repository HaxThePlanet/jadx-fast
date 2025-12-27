package app.dogo.com.dogo_android.s.a;

import i.b.l0.n;
import java.util.List;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class k1 implements n {

    public final /* synthetic */ r3 a;
    public final /* synthetic */ List b;
    public final /* synthetic */ String c;
    public /* synthetic */ k1(r3 r3Var, List list, String str) {
        super();
        this.a = r3Var;
        this.b = list;
        this.c = str;
    }

    public final Object apply(Object object) {
        return WorkoutSessionInteractor.k(this.a, this.b, this.c, object);
    }
}
