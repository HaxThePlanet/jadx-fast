package app.dogo.com.dogo_android.w;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.y.j0;

/* compiled from: Events.kt */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u0008\u0008\u0001\u0010\u0003*\u00020\u0002*\u0008\u0008\u0002\u0010\u0004*\u00020\u0002*\u0008\u0008\u0003\u0010\u0005*\u00020\u00022\u00020\u0006B1\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\"\u0008\u0002\u0010\t\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ>\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nJS\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u00002\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00028\u00012\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00028\u00022\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0018\u001a\u00028\u00032\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u001aJ^\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001b2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001b2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001b2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00028\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001bR+\u0010\t\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/tracking/Event4;", "P1", "Lapp/dogo/com/dogo_android/tracking/EventParameter;", "P2", "P3", "P4", "Lapp/dogo/com/dogo_android/tracking/Event;", "name", "", "fbEventFactory", "Lapp/dogo/com/dogo_android/tracking/FacebookEventFactory4;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/tracking/FacebookEventFactory4;)V", "getFbEventFactory", "()Lapp/dogo/com/dogo_android/tracking/FacebookEventFactory4;", "withFacebookEvent", "withParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedEvent;", "param1", "value1", "", "param2", "value2", "param3", "value3", "param4", "value4", "(Lapp/dogo/com/dogo_android/tracking/EventParameter;Ljava/lang/Object;Lapp/dogo/com/dogo_android/tracking/EventParameter;Ljava/lang/Object;Lapp/dogo/com/dogo_android/tracking/EventParameter;Ljava/lang/Object;Lapp/dogo/com/dogo_android/tracking/EventParameter;Ljava/lang/Object;)Lapp/dogo/com/dogo_android/tracking/ParameterizedEvent;", "Lkotlin/Pair;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: x2, reason: from kotlin metadata */
public final class Event4<P1 extends z2, P2 extends z2, P3 extends z2, P4 extends z2> extends s2 {

    private final f3<P1, P2, P3, P4> b;
    public /* synthetic */ x2(String str, f3 f3Var, int i, g gVar) {
        i = i & 2 != 0 ? 0 : i;
        this(str, f3Var);
    }

    @Override // app.dogo.com.dogo_android.w.s2
    /* renamed from: b, reason: from kotlin metadata */
    public final /* synthetic */ h3 withParameters(o param1, o param2, o param3, o param4) {
        app.dogo.com.dogo_android.w.a3 a3Var = null;
        n.f(param1, "param1");
        n.f(param2, "param2");
        n.f(param3, "param3");
        n.f(param4, "param4");
        o[] arr = new o[4];
        if (this.b == null) {
            int i6 = 0;
        } else {
            a3Var = this.b.a(param1, param2, param3, param4);
        }
        ParameterizedEvent parameterizedEvent = new ParameterizedEvent(this, j0.k(new o[] { param1, param2, param3, param4 }), a3Var);
        return parameterizedEvent;
    }

    public x2(String str, f3<P1, P2, P3, P4> f3Var) {
        n.f(str, "name");
        super(str);
        this.b = f3Var;
    }
}
