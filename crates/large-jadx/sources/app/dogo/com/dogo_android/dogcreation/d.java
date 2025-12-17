package app.dogo.com.dogo_android.dogcreation;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class d implements y {

    public final app.dogo.com.dogo_android.dogcreation.DogCreationActivity a;
    public d(app.dogo.com.dogo_android.dogcreation.DogCreationActivity dogCreationActivity) {
        super();
        this.a = dogCreationActivity;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        DogCreationActivity.r(this.a, (Boolean)object);
    }
}
