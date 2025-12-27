package app.dogo.com.dogo_android.w;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.u;
import kotlin.y.j0;

/* compiled from: Events.kt */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u0008\u0008\u0001\u0010\u0003*\u00020\u00022\u00020\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\u0008\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ&\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0008J/\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00028\u00012\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0014J2\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00152\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0015R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/tracking/Event2;", "P1", "Lapp/dogo/com/dogo_android/tracking/EventParameter;", "P2", "Lapp/dogo/com/dogo_android/tracking/Event;", "name", "", "fbEventFactory", "Lapp/dogo/com/dogo_android/tracking/FacebookEventFactory2;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/tracking/FacebookEventFactory2;)V", "getFbEventFactory", "()Lapp/dogo/com/dogo_android/tracking/FacebookEventFactory2;", "withFacebookEvent", "withParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedEvent;", "param1", "value1", "", "param2", "value2", "(Lapp/dogo/com/dogo_android/tracking/EventParameter;Ljava/lang/Object;Lapp/dogo/com/dogo_android/tracking/EventParameter;Ljava/lang/Object;)Lapp/dogo/com/dogo_android/tracking/ParameterizedEvent;", "Lkotlin/Pair;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: v2, reason: from kotlin metadata */
public final class Event2<P1 extends z2, P2 extends z2> extends s2 {

    private final d3<P1, P2> b;
    public /* synthetic */ v2(String str, d3 d3Var, int i, g gVar) {
        i = i & 2 != 0 ? 0 : i;
        this(str, d3Var);
    }

    @Override // app.dogo.com.dogo_android.w.s2
    /* renamed from: b, reason: from kotlin metadata */
    public final v2<P1, P2> withFacebookEvent(d3<P1, P2> fbEventFactory) {
        n.f(fbEventFactory, "fbEventFactory");
        return new Event2(a(), fbEventFactory);
    }

    @Override // app.dogo.com.dogo_android.w.s2
    /* renamed from: c, reason: from kotlin metadata */
    public final h3 withParameters(P1 param1, Object value1, P2 param2, Object value2) {
        n.f(param1, "param1");
        n.f(param2, "param2");
        return withParameters(u.a(param1, value1), u.a(param2, value2));
    }

    @Override // app.dogo.com.dogo_android.w.s2
    /* renamed from: d, reason: from kotlin metadata */
    public final /* synthetic */ h3 withParameters(o param1, o param2) {
        app.dogo.com.dogo_android.w.a3 a3Var = null;
        n.f(param1, "param1");
        n.f(param2, "param2");
        o[] arr = new o[2];
        if (this.b == null) {
            int i4 = 0;
        } else {
            a3Var = this.b.a(param1, param2);
        }
        ParameterizedEvent parameterizedEvent = new ParameterizedEvent(this, j0.k(new o[] { param1, param2 }), a3Var);
        return parameterizedEvent;
    }

    public v2(String str, d3<P1, P2> d3Var) {
        n.f(str, "name");
        super(str);
        this.b = d3Var;
    }
}
