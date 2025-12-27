package app.dogo.com.dogo_android.w;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.u;
import kotlin.y.j0;

/* compiled from: Events.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0008\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u001a\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007J\u001d\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u001c\u0010\u000c\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0012R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/tracking/Event1;", "P1", "Lapp/dogo/com/dogo_android/tracking/EventParameter;", "Lapp/dogo/com/dogo_android/tracking/Event;", "name", "", "fbEventFactory", "Lapp/dogo/com/dogo_android/tracking/FacebookEventFactory1;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/tracking/FacebookEventFactory1;)V", "getFbEventFactory", "()Lapp/dogo/com/dogo_android/tracking/FacebookEventFactory1;", "withFacebookEvent", "withParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedEvent;", "param1", "value1", "", "(Lapp/dogo/com/dogo_android/tracking/EventParameter;Ljava/lang/Object;)Lapp/dogo/com/dogo_android/tracking/ParameterizedEvent;", "Lkotlin/Pair;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: u2, reason: from kotlin metadata */
public final class Event1<P1 extends z2> extends s2 {

    private final c3<P1> b;
    public u2(String str, c3<P1> c3Var) {
        n.f(str, "name");
        super(str);
        this.b = c3Var;
    }

    @Override // app.dogo.com.dogo_android.w.s2
    /* renamed from: b, reason: from kotlin metadata */
    public final u2<P1> withFacebookEvent(c3<P1> fbEventFactory) {
        n.f(fbEventFactory, "fbEventFactory");
        return new Event1(a(), fbEventFactory);
    }

    @Override // app.dogo.com.dogo_android.w.s2
    /* renamed from: c, reason: from kotlin metadata */
    public final h3 withParameters(P1 param1, Object value1) {
        n.f(param1, "param1");
        return withParameters(u.a(param1, value1));
    }

    @Override // app.dogo.com.dogo_android.w.s2
    /* renamed from: d, reason: from kotlin metadata */
    public final /* synthetic */ h3 withParameters(o param1) {
        app.dogo.com.dogo_android.w.a3 a3Var = null;
        n.f(param1, "param1");
        if (this.b == null) {
            int i = 0;
        } else {
            a3Var = this.b.a(param1);
        }
        ParameterizedEvent parameterizedEvent = new ParameterizedEvent(this, j0.e(param1), a3Var);
        return parameterizedEvent;
    }

    public /* synthetic */ u2(String str, c3 c3Var, int i, g gVar) {
        i = i & 2 != 0 ? 0 : i;
        this(str, c3Var);
    }
}
