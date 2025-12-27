package app.dogo.com.dogo_android.util.l0;

import app.dogo.com.dogo_android.w.i3;
import kotlin.Metadata;

/* compiled from: ViewPagerListener.kt */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0008\u0010\u0004\u001a\u00020\u0003H&J\u0014\u0010\u0005\u001a\u00020\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/util/listeners/ViewPagerListener;", "", "onItemClicked", "", "onLastItemSwiped", "onPageChange", "screen", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b, reason: from kotlin metadata */
public interface ViewPagerListener {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static /* synthetic */ void a(b bVar, i3 i3Var, int i, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPageChange");
            } else {
                if (i & 1 != 0) {
                    i = 0;
                }
                bVar.onPageChange(i3Var);
                return;
            }
        }
    }
    /* renamed from: f, reason: from kotlin metadata */
    void onItemClicked();

    void p();

    /* renamed from: s1, reason: from kotlin metadata */
    void onPageChange(i3 screen);
}
