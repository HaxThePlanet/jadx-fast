package app.dogo.com.dogo_android.w;

import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.u;
import kotlin.y.j0;

/* compiled from: Screens.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\u0008\u0016\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u0008\u0008\u0001\u0010\u0003*\u00020\u0002*\u0008\u0008\u0002\u0010\u0004*\u00020\u00022\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008JA\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00028\u00012\u0008\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00028\u00022\u0008\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0012JH\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00132\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00132\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0013¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/tracking/Screen3;", "P1", "Lapp/dogo/com/dogo_android/tracking/EventParameter;", "P2", "P3", "Lapp/dogo/com/dogo_android/tracking/BaseScreen;", "name", "", "(Ljava/lang/String;)V", "withParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "param1", "value1", "", "param2", "value2", "param3", "value3", "(Lapp/dogo/com/dogo_android/tracking/EventParameter;Ljava/lang/Object;Lapp/dogo/com/dogo_android/tracking/EventParameter;Ljava/lang/Object;Lapp/dogo/com/dogo_android/tracking/EventParameter;Ljava/lang/Object;)Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "Lkotlin/Pair;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n3, reason: from kotlin metadata */
public class Screen3<P1 extends z2, P2 extends z2, P3 extends z2> extends m {
    public n3(String str) {
        n.f(str, "name");
        super(str);
    }

    @Override // app.dogo.com.dogo_android.w.m
    /* renamed from: b, reason: from kotlin metadata */
    public final i3 withParameters(P1 param1, Object value1, P2 param2, Object value2, P3 param3, Object value3) {
        n.f(param1, "param1");
        n.f(param2, "param2");
        n.f(param3, "param3");
        kotlin.o[] arr = new o[3];
        return new ParameterizedScreen(this, j0.k(new o[] { u.a(param1, value1), u.a(param2, value2), u.a(param3, value3) }));
    }
}
