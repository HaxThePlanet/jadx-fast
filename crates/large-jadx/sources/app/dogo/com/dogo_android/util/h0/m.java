package app.dogo.com.dogo_android.util.h0;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import kotlin.d0.c.l;

/* loaded from: classes.dex */
public final class m implements DialogInterface.OnClickListener {

    public final l a;
    public m(l l) {
        super();
        this.a = l;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        f1.r(this.a, dialogInterface, i2);
    }
}
