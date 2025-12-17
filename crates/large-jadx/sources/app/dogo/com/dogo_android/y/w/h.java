package app.dogo.com.dogo_android.y.w;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* loaded from: classes.dex */
public final class h implements DialogInterface.OnClickListener {

    public final app.dogo.com.dogo_android.y.w.m a;
    public h(app.dogo.com.dogo_android.y.w.m m) {
        super();
        this.a = m;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        m.G1(this.a, dialogInterface, i2);
    }
}
