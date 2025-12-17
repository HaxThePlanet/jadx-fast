package app.dogo.com.dogo_android.util.h0;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* loaded from: classes.dex */
public final class i implements DialogInterface.OnClickListener {

    public static final app.dogo.com.dogo_android.util.h0.i a;
    static {
        i iVar = new i();
        i.a = iVar;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        f1.n(dialogInterface, i2);
    }
}
