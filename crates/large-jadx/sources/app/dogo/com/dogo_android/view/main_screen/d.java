package app.dogo.com.dogo_android.view.main_screen;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class d implements y {

    public final app.dogo.com.dogo_android.view.main_screen.MainScreenActivity a;
    public d(app.dogo.com.dogo_android.view.main_screen.MainScreenActivity mainScreenActivity) {
        super();
        this.a = mainScreenActivity;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        MainScreenActivity.Y0(this.a, (y)object);
    }
}
