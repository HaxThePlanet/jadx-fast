package app.dogo.com.dogo_android.login_v2;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class e implements y {

    public final app.dogo.com.dogo_android.login_v2.LoginActivity a;
    public e(app.dogo.com.dogo_android.login_v2.LoginActivity loginActivity) {
        super();
        this.a = loginActivity;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        LoginActivity.p(this.a, (y)object);
    }
}
