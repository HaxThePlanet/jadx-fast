package app.dogo.com.dogo_android.view;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class f implements y {

    public final app.dogo.com.dogo_android.view.p a;
    public f(app.dogo.com.dogo_android.view.p p) {
        super();
        this.a = p;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        p.D1(this.a, (Intent)object);
    }
}
