package app.dogo.com.dogo_android.view;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class c implements y {

    public final app.dogo.com.dogo_android.view.m a;
    public c(app.dogo.com.dogo_android.view.m m) {
        super();
        this.a = m;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        m.D1(this.a, (Boolean)object);
    }
}
