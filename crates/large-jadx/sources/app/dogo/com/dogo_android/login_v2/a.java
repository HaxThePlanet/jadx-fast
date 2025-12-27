package app.dogo.com.dogo_android.login_v2;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final /* synthetic */ LoginActivity a;
    public /* synthetic */ a(LoginActivity loginActivity) {
        super();
        this.a = loginActivity;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        LoginActivity.r(this.a, view);
    }
}
