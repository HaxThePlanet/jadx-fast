package app.dogo.com.dogo_android.dogcreation;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class e implements y {

    public final app.dogo.com.dogo_android.dogcreation.DogCreationActivity a;
    public e(app.dogo.com.dogo_android.dogcreation.DogCreationActivity dogCreationActivity) {
        super();
        this.a = dogCreationActivity;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        DogCreationActivity.s(this.a, (Boolean)object);
    }
}
