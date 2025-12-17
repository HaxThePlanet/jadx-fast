package app.dogo.com.dogo_android.view.dailytraining;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class b implements y {

    public final app.dogo.com.dogo_android.view.dailytraining.l a;
    public b(app.dogo.com.dogo_android.view.dailytraining.l l) {
        super();
        this.a = l;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        l.R(this.a, (DogProfile)object);
    }
}
