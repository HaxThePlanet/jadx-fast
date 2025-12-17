package app.dogo.com.dogo_android.a0.g.f;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import app.dogo.com.dogo_android.util.l0.a;

/* loaded from: classes.dex */
public final class f implements DialogInterface.OnClickListener {

    public final a a;
    public f(a a) {
        super();
        this.a = a;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        g0.T1(this.a, dialogInterface, i2);
    }
}
