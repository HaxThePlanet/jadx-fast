package app.dogo.com.dogo_android.w;

import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: Events.kt */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B1\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/tracking/ParameterizedEvent;", "", "event", "Lapp/dogo/com/dogo_android/tracking/Event;", "parameters", "", "Lapp/dogo/com/dogo_android/tracking/EventParameter;", "fbEvent", "Lapp/dogo/com/dogo_android/tracking/FBEvent;", "(Lapp/dogo/com/dogo_android/tracking/Event;Ljava/util/Map;Lapp/dogo/com/dogo_android/tracking/FBEvent;)V", "getEvent", "()Lapp/dogo/com/dogo_android/tracking/Event;", "getFbEvent", "()Lapp/dogo/com/dogo_android/tracking/FBEvent;", "name", "", "getName", "()Ljava/lang/String;", "getParameters", "()Ljava/util/Map;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h3, reason: from kotlin metadata */
public final class ParameterizedEvent {

    private final s2 a;
    private final Map<z2, Object> b;
    private final a3 c;
    private final String d;
    public h3(s2 s2Var, Map<z2, ? extends Object> map, a3 a3Var) {
        n.f(s2Var, "event");
        n.f(map, "parameters");
        super();
        this.a = s2Var;
        this.b = map;
        this.c = a3Var;
        this.d = s2Var.a();
    }

    public final a3 a() {
        return this.c;
    }

    public final String b() {
        return this.d;
    }

    public final Map<z2, Object> c() {
        return this.b;
    }
}
