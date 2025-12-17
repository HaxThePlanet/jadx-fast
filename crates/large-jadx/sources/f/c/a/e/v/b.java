package f.c.a.e.v;

import android.os.Bundle;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes2.dex */
public final class b {

    private final View a;
    private boolean b = false;
    private int c = 0;
    public b(f.c.a.e.v.a a) {
        super();
        final int i = 0;
        this.a = (View)a;
    }

    private void a() {
        boolean z;
        android.view.ViewParent parent = this.a.getParent();
        if (parent instanceof CoordinatorLayout) {
            (CoordinatorLayout)parent.dispatchDependentViewsChanged(this.a);
        }
    }

    public int b() {
        return this.c;
    }

    public boolean c() {
        return this.b;
    }

    public void d(Bundle bundle) {
        final int i = 0;
        this.b = bundle.getBoolean("expanded", i);
        this.c = bundle.getInt("expandedComponentIdHint", i);
        if (this.b) {
            a();
        }
    }

    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.b);
        bundle.putInt("expandedComponentIdHint", this.c);
        return bundle;
    }

    public void f(int i) {
        this.c = i;
    }
}
