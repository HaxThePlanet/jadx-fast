package app.dogo.com.dogo_android.w;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.u;
import kotlin.y.j0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0008\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u001a\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007J\u001d\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u001c\u0010\u000c\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0012R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/tracking/Event1;", "P1", "Lapp/dogo/com/dogo_android/tracking/EventParameter;", "Lapp/dogo/com/dogo_android/tracking/Event;", "name", "", "fbEventFactory", "Lapp/dogo/com/dogo_android/tracking/FacebookEventFactory1;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/tracking/FacebookEventFactory1;)V", "getFbEventFactory", "()Lapp/dogo/com/dogo_android/tracking/FacebookEventFactory1;", "withFacebookEvent", "withParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedEvent;", "param1", "value1", "", "(Lapp/dogo/com/dogo_android/tracking/EventParameter;Ljava/lang/Object;)Lapp/dogo/com/dogo_android/tracking/ParameterizedEvent;", "Lkotlin/Pair;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class u2<P1 extends app.dogo.com.dogo_android.w.z2>  extends app.dogo.com.dogo_android.w.s2 {

    private final app.dogo.com.dogo_android.w.c3<P1> b;
    public u2(String string, app.dogo.com.dogo_android.w.c3<P1> c32) {
        n.f(string, "name");
        super(string);
        this.b = c32;
    }

    public u2(String string, app.dogo.com.dogo_android.w.c3 c32, int i3, g g4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(string, obj2);
    }

    public final app.dogo.com.dogo_android.w.u2<P1> b(app.dogo.com.dogo_android.w.c3<P1> c3) {
        n.f(c3, "fbEventFactory");
        u2 u2Var = new u2(a(), c3);
        return u2Var;
    }

    public final app.dogo.com.dogo_android.w.h3 c(P1 p1, Object object2) {
        n.f(p1, "param1");
        return d(u.a(p1, object2));
    }

    @Override // app.dogo.com.dogo_android.w.s2
    public final app.dogo.com.dogo_android.w.h3 d(o o) {
        int obj4;
        n.f(o, "param1");
        final app.dogo.com.dogo_android.w.c3 c3Var = this.b;
        if (c3Var == null) {
            obj4 = 0;
        } else {
            obj4 = c3Var.a(o);
        }
        h3 h3Var = new h3(this, j0.e(o), obj4);
        return h3Var;
    }
}
