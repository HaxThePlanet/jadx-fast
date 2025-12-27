package app.dogo.com.dogo_android.view.main_screen;

import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView.c;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements BottomNavigationView.c {

    public final /* synthetic */ MainScreenActivity a;
    public /* synthetic */ a(MainScreenActivity mainScreenActivity) {
        super();
        this.a = mainScreenActivity;
    }

    public final boolean a(MenuItem menuItem) {
        return MainScreenActivity.f1(this.a, menuItem);
    }
}
