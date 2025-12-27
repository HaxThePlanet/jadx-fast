package app.dogo.com.dogo_android.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class h implements DialogInterface.OnClickListener {

    public final /* synthetic */ SplashActivity a;
    public /* synthetic */ h(SplashActivity splashActivity) {
        super();
        this.a = splashActivity;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        SplashActivity.v(this.a, dialogInterface, i);
    }
}
