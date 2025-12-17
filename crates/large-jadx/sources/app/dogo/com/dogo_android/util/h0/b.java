package app.dogo.com.dogo_android.util.h0;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo;

/* loaded from: classes.dex */
public final class b implements DialogInterface.OnClickListener {

    public final Activity a;
    public final ZendeskConfigurationInfo b;
    public b(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo2) {
        super();
        this.a = activity;
        this.b = zendeskConfigurationInfo2;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        f1.g(this.a, this.b, dialogInterface, i2);
    }
}
