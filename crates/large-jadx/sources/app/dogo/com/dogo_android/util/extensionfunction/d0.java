package app.dogo.com.dogo_android.util.h0;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d0 implements DialogInterface.OnClickListener {

    public final /* synthetic */ Activity a;
    public final /* synthetic */ ZendeskConfigurationInfo b;
    public /* synthetic */ d0(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo) {
        super();
        this.a = activity;
        this.b = zendeskConfigurationInfo;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.g1.e0(this.a, this.b, dialogInterface, i);
    }
}
