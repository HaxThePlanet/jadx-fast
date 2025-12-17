package app.dogo.com.dogo_android.login_v2;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class b implements y {

    public final app.dogo.com.dogo_android.login_v2.LoginActivity a;
    public b(app.dogo.com.dogo_android.login_v2.LoginActivity loginActivity) {
        super();
        this.a = loginActivity;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        LoginActivity.m(this.a, (t)object);
    }
}
