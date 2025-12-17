package app.dogo.com.dogo_android.view;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class e implements y {

    public final app.dogo.com.dogo_android.view.p a;
    public e(app.dogo.com.dogo_android.view.p p) {
        super();
        this.a = p;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        p.C1(this.a, (Boolean)object);
    }
}
