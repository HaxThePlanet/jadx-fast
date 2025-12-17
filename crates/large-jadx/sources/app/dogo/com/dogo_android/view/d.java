package app.dogo.com.dogo_android.view;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class d implements y {

    public final app.dogo.com.dogo_android.view.m a;
    public d(app.dogo.com.dogo_android.view.m m) {
        super();
        this.a = m;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        m.E1(this.a, (Boolean)object);
    }
}
