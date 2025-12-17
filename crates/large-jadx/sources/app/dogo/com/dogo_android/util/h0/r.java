package app.dogo.com.dogo_android.util.h0;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import kotlin.d0.c.a;

/* loaded from: classes.dex */
public final class r implements DialogInterface.OnClickListener {

    public final a a;
    public r(a a) {
        super();
        this.a = a;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        f1.w(this.a, dialogInterface, i2);
    }
}
