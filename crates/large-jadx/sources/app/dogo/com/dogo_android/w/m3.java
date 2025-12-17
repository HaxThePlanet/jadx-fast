package app.dogo.com.dogo_android.w;

import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.u;
import kotlin.y.j0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0016\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u0008\u0008\u0001\u0010\u0003*\u00020\u00022\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J/\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0006\u0010\r\u001a\u00028\u00012\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000c¢\u0006\u0002\u0010\u000fJ2\u0010\u0008\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u00102\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u0010¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/tracking/Screen2;", "P1", "Lapp/dogo/com/dogo_android/tracking/EventParameter;", "P2", "Lapp/dogo/com/dogo_android/tracking/BaseScreen;", "name", "", "(Ljava/lang/String;)V", "withParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "param1", "value1", "", "param2", "value2", "(Lapp/dogo/com/dogo_android/tracking/EventParameter;Ljava/lang/Object;Lapp/dogo/com/dogo_android/tracking/EventParameter;Ljava/lang/Object;)Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "Lkotlin/Pair;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class m3<P1 extends app.dogo.com.dogo_android.w.z2, P2 extends app.dogo.com.dogo_android.w.z2>  extends app.dogo.com.dogo_android.w.m {
    public m3(String string) {
        n.f(string, "name");
        super(string);
    }

    public final app.dogo.com.dogo_android.w.i3 b(P1 p1, Object object2, P2 p23, Object object4) {
        n.f(p1, "param1");
        n.f(p23, "param2");
        o[] arr = new o[2];
        i3 i3Var = new i3(this, j0.k(u.a(p1, object2), u.a(p23, object4)));
        return i3Var;
    }

    @Override // app.dogo.com.dogo_android.w.m
    public final app.dogo.com.dogo_android.w.i3 c(o o, o o2) {
        n.f(o, "param1");
        n.f(o2, "param2");
        o[] arr = new o[2];
        i3 i3Var = new i3(this, j0.k(o, o2));
        return i3Var;
    }
}
