package app.dogo.com.dogo_android.d.d;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class e implements y {

    public final app.dogo.com.dogo_android.d.d.p a;
    public e(app.dogo.com.dogo_android.d.d.p p) {
        super();
        this.a = p;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        p.G(this.a, (DogProfile)object);
    }
}
