package app.dogo.com.dogo_android.util.h0;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import kotlin.d0.c.a;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class z implements DialogInterface.OnClickListener {

    public final /* synthetic */ Activity a;
    public final /* synthetic */ a b;
    public /* synthetic */ z(Activity activity, a aVar) {
        super();
        this.a = activity;
        this.b = aVar;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.l0(this.a, this.b, dialogInterface, i);
    }
}
