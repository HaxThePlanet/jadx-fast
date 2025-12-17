package app.dogo.com.dogo_android.inappmessaging;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* loaded from: classes.dex */
public final class b implements DialogInterface.OnClickListener {

    public final app.dogo.com.dogo_android.inappmessaging.i a;
    public b(app.dogo.com.dogo_android.inappmessaging.i i) {
        super();
        this.a = i;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        i.G1(this.a, dialogInterface, i2);
    }
}
