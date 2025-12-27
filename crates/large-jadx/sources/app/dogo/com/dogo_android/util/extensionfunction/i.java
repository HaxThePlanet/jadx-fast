package app.dogo.com.dogo_android.util.h0;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class i implements DialogInterface.OnClickListener {

    public static final /* synthetic */ i a = new i();

    private /* synthetic */ i() {
        super();
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.buildPermissionNoticeList(dialogInterface, i);
    }
}
