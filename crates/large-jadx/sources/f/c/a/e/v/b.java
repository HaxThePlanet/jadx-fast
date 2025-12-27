package f.c.a.e.v;

import android.os.Bundle;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: ExpandableWidgetHelper.java */
/* loaded from: classes2.dex */
public final class b {

    private final View a;
    private boolean b = false;
    private int c = 0;
    public b(a aVar) {
        super();
        this.a = aVar;
    }

    private void a() {
        android.view.ViewParent parent = this.a.getParent();
        z = parent instanceof CoordinatorLayout;
        if (parent instanceof CoordinatorLayout) {
            parent.dispatchDependentViewsChanged(this.a);
        }
    }

    public int b() {
        return this.c;
    }

    public boolean c() {
        return this.b;
    }

    public void d(Bundle bundle) {
        final boolean z = false;
        this.b = bundle.getBoolean("expanded", z);
        this.c = bundle.getInt("expandedComponentIdHint", z);
        if (this.b) {
            a();
        }
    }

    public Bundle e() {
        final Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.b);
        bundle.putInt("expandedComponentIdHint", this.c);
        return bundle;
    }

    public void f(int i) {
        this.c = i;
    }
}
