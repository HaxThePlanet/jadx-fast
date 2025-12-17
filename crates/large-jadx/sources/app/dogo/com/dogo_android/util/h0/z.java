package app.dogo.com.dogo_android.util.h0;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import kotlin.d0.c.a;

/* loaded from: classes.dex */
public final class z implements DialogInterface.OnClickListener {

    public final Activity a;
    public final a b;
    public z(Activity activity, a a2) {
        super();
        this.a = activity;
        this.b = a2;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        f1.E(this.a, this.b, dialogInterface, i2);
    }
}
