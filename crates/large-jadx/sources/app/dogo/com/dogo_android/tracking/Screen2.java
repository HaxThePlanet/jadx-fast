package app.dogo.com.dogo_android.w;

import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.u;
import kotlin.y.j0;

/* compiled from: Screens.kt */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0016\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u0008\u0008\u0001\u0010\u0003*\u00020\u00022\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J/\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0006\u0010\r\u001a\u00028\u00012\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000c¢\u0006\u0002\u0010\u000fJ2\u0010\u0008\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u00102\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u0010¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/tracking/Screen2;", "P1", "Lapp/dogo/com/dogo_android/tracking/EventParameter;", "P2", "Lapp/dogo/com/dogo_android/tracking/BaseScreen;", "name", "", "(Ljava/lang/String;)V", "withParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "param1", "value1", "", "param2", "value2", "(Lapp/dogo/com/dogo_android/tracking/EventParameter;Ljava/lang/Object;Lapp/dogo/com/dogo_android/tracking/EventParameter;Ljava/lang/Object;)Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "Lkotlin/Pair;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m3, reason: from kotlin metadata */
public class Screen2<P1 extends z2, P2 extends z2> extends m {
    public m3(String str) {
        n.f(str, "name");
        super(str);
    }

    @Override // app.dogo.com.dogo_android.w.m
    /* renamed from: b, reason: from kotlin metadata */
    public final i3 withParameters(P1 param1, Object value1, P2 param2, Object value2) {
        n.f(param1, "param1");
        n.f(param2, "param2");
        o[] arr = new o[2];
        return new ParameterizedScreen(this, j0.k(new o[] { u.a(param1, value1), u.a(param2, value2) }));
    }

    @Override // app.dogo.com.dogo_android.w.m
    /* renamed from: c, reason: from kotlin metadata */
    public final /* synthetic */ i3 withParameters(o param1, o param2) {
        n.f(param1, "param1");
        n.f(param2, "param2");
        o[] arr = new o[2];
        return new ParameterizedScreen(this, j0.k(new o[] { param1, param2 }));
    }
}
