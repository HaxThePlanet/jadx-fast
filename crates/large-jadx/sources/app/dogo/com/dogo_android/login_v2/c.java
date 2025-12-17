package app.dogo.com.dogo_android.login_v2;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class c implements y {

    public final app.dogo.com.dogo_android.login_v2.LoginActivity a;
    public c(app.dogo.com.dogo_android.login_v2.LoginActivity loginActivity) {
        super();
        this.a = loginActivity;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        LoginActivity.n(this.a, (Boolean)object);
    }
}
