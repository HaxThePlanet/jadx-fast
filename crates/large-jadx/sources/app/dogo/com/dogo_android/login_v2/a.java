package app.dogo.com.dogo_android.login_v2;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final app.dogo.com.dogo_android.login_v2.LoginActivity a;
    public a(app.dogo.com.dogo_android.login_v2.LoginActivity loginActivity) {
        super();
        this.a = loginActivity;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        LoginActivity.l(this.a, view);
    }
}
