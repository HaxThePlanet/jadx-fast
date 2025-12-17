package app.dogo.com.dogo_android.t;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* loaded from: classes.dex */
public final class n implements DialogInterface.OnClickListener {

    public final app.dogo.com.dogo_android.t.c0 a;
    public n(app.dogo.com.dogo_android.t.c0 c0) {
        super();
        this.a = c0;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        c0.R1(this.a, dialogInterface, i2);
    }
}
