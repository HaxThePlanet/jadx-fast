package app.dogo.com.dogo_android.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class j implements DialogInterface.OnCancelListener {

    public final /* synthetic */ SplashActivity a;
    public /* synthetic */ j(SplashActivity splashActivity) {
        super();
        this.a = splashActivity;
    }

    @Override // android.content.DialogInterface$OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        SplashActivity.w(this.a, dialogInterface);
    }
}
