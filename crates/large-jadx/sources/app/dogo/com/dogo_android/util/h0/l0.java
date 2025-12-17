package app.dogo.com.dogo_android.util.h0;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* loaded from: classes.dex */
public final class l0 implements DialogInterface.OnClickListener {

    public static final app.dogo.com.dogo_android.util.h0.l0 a;
    static {
        l0 l0Var = new l0();
        l0.a = l0Var;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        g1.E(dialogInterface, i2);
    }
}
