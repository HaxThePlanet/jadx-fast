package app.dogo.com.dogo_android.a0.g.f;

import com.google.android.gms.tasks.g;
import java.util.Set;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d implements g {

    public final /* synthetic */ g0 a;
    public final /* synthetic */ g0.c b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Set d;
    public /* synthetic */ d(g0 g0Var, g0.c cVar, String str, Set set) {
        super();
        this.a = g0Var;
        this.b = cVar;
        this.c = str;
        this.d = set;
    }

    public final void onSuccess(Object object) {
        this.a.C1(this.b, this.c, this.d, object);
    }
}
