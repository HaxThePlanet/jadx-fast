package app.dogo.com.dogo_android.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* loaded from: classes.dex */
public final class h implements DialogInterface.OnClickListener {

    public final app.dogo.com.dogo_android.view.SplashActivity a;
    public h(app.dogo.com.dogo_android.view.SplashActivity splashActivity) {
        super();
        this.a = splashActivity;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        SplashActivity.l(this.a, dialogInterface, i2);
    }
}
