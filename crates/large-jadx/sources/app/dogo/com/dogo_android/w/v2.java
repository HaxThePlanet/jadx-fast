package app.dogo.com.dogo_android.w;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.u;
import kotlin.y.j0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u0008\u0008\u0001\u0010\u0003*\u00020\u00022\u00020\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\u0008\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ&\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0008J/\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00028\u00012\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0014J2\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00152\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0015R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/tracking/Event2;", "P1", "Lapp/dogo/com/dogo_android/tracking/EventParameter;", "P2", "Lapp/dogo/com/dogo_android/tracking/Event;", "name", "", "fbEventFactory", "Lapp/dogo/com/dogo_android/tracking/FacebookEventFactory2;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/tracking/FacebookEventFactory2;)V", "getFbEventFactory", "()Lapp/dogo/com/dogo_android/tracking/FacebookEventFactory2;", "withFacebookEvent", "withParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedEvent;", "param1", "value1", "", "param2", "value2", "(Lapp/dogo/com/dogo_android/tracking/EventParameter;Ljava/lang/Object;Lapp/dogo/com/dogo_android/tracking/EventParameter;Ljava/lang/Object;)Lapp/dogo/com/dogo_android/tracking/ParameterizedEvent;", "Lkotlin/Pair;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class v2<P1 extends app.dogo.com.dogo_android.w.z2, P2 extends app.dogo.com.dogo_android.w.z2>  extends app.dogo.com.dogo_android.w.s2 {

    private final app.dogo.com.dogo_android.w.d3<P1, P2> b;
    public v2(String string, app.dogo.com.dogo_android.w.d3<P1, P2> d32) {
        n.f(string, "name");
        super(string);
        this.b = d32;
    }

    public v2(String string, app.dogo.com.dogo_android.w.d3 d32, int i3, g g4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(string, obj2);
    }

    public final app.dogo.com.dogo_android.w.v2<P1, P2> b(app.dogo.com.dogo_android.w.d3<P1, P2> d3) {
        n.f(d3, "fbEventFactory");
        v2 v2Var = new v2(a(), d3);
        return v2Var;
    }

    public final app.dogo.com.dogo_android.w.h3 c(P1 p1, Object object2, P2 p23, Object object4) {
        n.f(p1, "param1");
        n.f(p23, "param2");
        return d(u.a(p1, object2), u.a(p23, object4));
    }

    @Override // app.dogo.com.dogo_android.w.s2
    public final app.dogo.com.dogo_android.w.h3 d(o o, o o2) {
        int obj4;
        n.f(o, "param1");
        n.f(o2, "param2");
        o[] arr = new o[2];
        app.dogo.com.dogo_android.w.d3 d3Var = this.b;
        if (d3Var == null) {
            obj4 = 0;
        } else {
            obj4 = d3Var.a(o, o2);
        }
        h3 h3Var = new h3(this, j0.k(o, o2), obj4);
        return h3Var;
    }
}
