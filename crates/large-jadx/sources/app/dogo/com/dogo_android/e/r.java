package app.dogo.com.dogo_android.e;

import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.v;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/clicker/ClickerViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "trackClickerClicked", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class r extends s {

    private final o3 a;
    public r(o3 o3) {
        n.f(o3, "tracker");
        super();
        this.a = o3;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void h() {
        this.a.d(v.a);
    }
}
