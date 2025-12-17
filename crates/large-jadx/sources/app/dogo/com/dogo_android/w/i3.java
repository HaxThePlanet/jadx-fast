package app.dogo.com.dogo_android.w;

import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B%\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005¢\u0006\u0002\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "Lapp/dogo/com/dogo_android/tracking/Screen;", "event", "Lapp/dogo/com/dogo_android/tracking/BaseScreen;", "parameters", "", "Lapp/dogo/com/dogo_android/tracking/EventParameter;", "", "(Lapp/dogo/com/dogo_android/tracking/BaseScreen;Ljava/util/Map;)V", "getEvent", "()Lapp/dogo/com/dogo_android/tracking/BaseScreen;", "getParameters", "()Ljava/util/Map;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i3 extends app.dogo.com.dogo_android.w.k3 {

    private final Map<app.dogo.com.dogo_android.w.z2, Object> b;
    public i3(app.dogo.com.dogo_android.w.m m, Map<app.dogo.com.dogo_android.w.z2, ? extends Object> map2) {
        n.f(m, "event");
        n.f(map2, "parameters");
        super(m.a());
        this.b = map2;
    }

    public final Map<app.dogo.com.dogo_android.w.z2, Object> g() {
        return this.b;
    }
}
