package app.dogo.com.dogo_android.view;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class b implements y {

    public final app.dogo.com.dogo_android.view.m a;
    public b(app.dogo.com.dogo_android.view.m m) {
        super();
        this.a = m;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        m.C1(this.a, (ReviewInfo)object);
    }
}
