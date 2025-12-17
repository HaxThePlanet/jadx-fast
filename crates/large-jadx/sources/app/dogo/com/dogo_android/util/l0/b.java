package app.dogo.com.dogo_android.util.l0;

import app.dogo.com.dogo_android.w.i3;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0008\u0010\u0004\u001a\u00020\u0003H&J\u0014\u0010\u0005\u001a\u00020\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/util/listeners/ViewPagerListener;", "", "onItemClicked", "", "onLastItemSwiped", "onPageChange", "screen", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface b {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static void a(app.dogo.com.dogo_android.util.l0.b b, i3 i32, int i3, Object object4) {
            int obj1;
            if (object4 != null) {
            } else {
                if (i3 &= 1 != 0) {
                    obj1 = 0;
                }
                b.s1(obj1);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPageChange");
            throw obj0;
        }
    }
    public abstract void f();

    public abstract void p();

    public abstract void s1(i3 i3);
}
