package app.dogo.com.dogo_android.view.main_screen;

import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView.c;

/* loaded from: classes.dex */
public final class a implements BottomNavigationView.c {

    public final app.dogo.com.dogo_android.view.main_screen.MainScreenActivity a;
    public a(app.dogo.com.dogo_android.view.main_screen.MainScreenActivity mainScreenActivity) {
        super();
        this.a = mainScreenActivity;
    }

    @Override // com.google.android.material.bottomnavigation.BottomNavigationView$c
    public final boolean a(MenuItem menuItem) {
        return MainScreenActivity.V0(this.a, menuItem);
    }
}
