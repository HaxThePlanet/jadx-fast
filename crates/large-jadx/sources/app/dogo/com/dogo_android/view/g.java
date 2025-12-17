package app.dogo.com.dogo_android.view;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class g implements y {

    public final app.dogo.com.dogo_android.view.SplashActivity a;
    public g(app.dogo.com.dogo_android.view.SplashActivity splashActivity) {
        super();
        this.a = splashActivity;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        SplashActivity.k(this.a, (SplashDataHolder)object);
    }
}
