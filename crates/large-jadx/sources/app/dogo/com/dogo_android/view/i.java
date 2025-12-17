package app.dogo.com.dogo_android.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* loaded from: classes.dex */
public final class i implements DialogInterface.OnCancelListener {

    public final app.dogo.com.dogo_android.view.SplashActivity a;
    public i(app.dogo.com.dogo_android.view.SplashActivity splashActivity) {
        super();
        this.a = splashActivity;
    }

    @Override // android.content.DialogInterface$OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        SplashActivity.m(this.a, dialogInterface);
    }
}
