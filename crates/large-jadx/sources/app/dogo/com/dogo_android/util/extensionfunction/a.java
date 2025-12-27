package app.dogo.com.dogo_android.util.h0;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import kotlin.d0.c.a;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements DialogInterface.OnClickListener {

    public final /* synthetic */ a a;
    public /* synthetic */ a(a aVar) {
        super();
        this.a = aVar;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.showPermissionDialog(this.a, dialogInterface, i);
    }
}
