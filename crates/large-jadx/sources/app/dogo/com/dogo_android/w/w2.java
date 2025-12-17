package app.dogo.com.dogo_android.w;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.u;
import kotlin.y.j0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u0008\u0008\u0001\u0010\u0003*\u00020\u0002*\u0008\u0008\u0002\u0010\u0004*\u00020\u00022\u00020\u0005B+\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001c\u0008\u0002\u0010\u0008\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\t¢\u0006\u0002\u0010\nJ2\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u0018\u0010\u0008\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\tJA\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00028\u00012\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00028\u00022\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0017JH\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00182\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00182\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0018R%\u0010\u0008\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/tracking/Event3;", "P1", "Lapp/dogo/com/dogo_android/tracking/EventParameter;", "P2", "P3", "Lapp/dogo/com/dogo_android/tracking/Event;", "name", "", "fbEventFactory", "Lapp/dogo/com/dogo_android/tracking/FacebookEventFactory3;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/tracking/FacebookEventFactory3;)V", "getFbEventFactory", "()Lapp/dogo/com/dogo_android/tracking/FacebookEventFactory3;", "withFacebookEvent", "withParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedEvent;", "param1", "value1", "", "param2", "value2", "param3", "value3", "(Lapp/dogo/com/dogo_android/tracking/EventParameter;Ljava/lang/Object;Lapp/dogo/com/dogo_android/tracking/EventParameter;Ljava/lang/Object;Lapp/dogo/com/dogo_android/tracking/EventParameter;Ljava/lang/Object;)Lapp/dogo/com/dogo_android/tracking/ParameterizedEvent;", "Lkotlin/Pair;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class w2<P1 extends app.dogo.com.dogo_android.w.z2, P2 extends app.dogo.com.dogo_android.w.z2, P3 extends app.dogo.com.dogo_android.w.z2>  extends app.dogo.com.dogo_android.w.s2 {

    private final app.dogo.com.dogo_android.w.e3<P1, P2, P3> b;
    public w2(String string, app.dogo.com.dogo_android.w.e3<P1, P2, P3> e32) {
        n.f(string, "name");
        super(string);
        this.b = e32;
    }

    public w2(String string, app.dogo.com.dogo_android.w.e3 e32, int i3, g g4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(string, obj2);
    }

    public final app.dogo.com.dogo_android.w.w2<P1, P2, P3> b(app.dogo.com.dogo_android.w.e3<P1, P2, P3> e3) {
        n.f(e3, "fbEventFactory");
        w2 w2Var = new w2(a(), e3);
        return w2Var;
    }

    public final app.dogo.com.dogo_android.w.h3 c(P1 p1, Object object2, P2 p23, Object object4, P3 p35, Object object6) {
        n.f(p1, "param1");
        n.f(p23, "param2");
        n.f(p35, "param3");
        return d(u.a(p1, object2), u.a(p23, object4), u.a(p35, object6));
    }

    @Override // app.dogo.com.dogo_android.w.s2
    public final app.dogo.com.dogo_android.w.h3 d(o o, o o2, o o3) {
        int obj4;
        n.f(o, "param1");
        n.f(o2, "param2");
        n.f(o3, "param3");
        o[] arr = new o[3];
        app.dogo.com.dogo_android.w.e3 e3Var = this.b;
        if (e3Var == null) {
            obj4 = 0;
        } else {
            obj4 = e3Var.a(o, o2, o3);
        }
        h3 h3Var = new h3(this, j0.k(o, o2, o3), obj4);
        return h3Var;
    }
}
