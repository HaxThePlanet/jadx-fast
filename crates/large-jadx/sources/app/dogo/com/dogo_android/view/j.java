package app.dogo.com.dogo_android.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* loaded from: classes.dex */
public final class j implements DialogInterface.OnCancelListener {

    public final app.dogo.com.dogo_android.view.SplashActivity a;
    public j(app.dogo.com.dogo_android.view.SplashActivity splashActivity) {
        super();
        this.a = splashActivity;
    }

    @Override // android.content.DialogInterface$OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        SplashActivity.n(this.a, dialogInterface);
    }
}
