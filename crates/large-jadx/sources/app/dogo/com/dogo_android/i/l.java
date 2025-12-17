package app.dogo.com.dogo_android.i;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;

/* loaded from: classes.dex */
public final class l implements DialogInterface.OnClickListener {

    public final app.dogo.com.dogo_android.i.g0 a;
    public final EditText b;
    public l(app.dogo.com.dogo_android.i.g0 g0, EditText editText2) {
        super();
        this.a = g0;
        this.b = editText2;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        g0.R1(this.a, this.b, dialogInterface, i2);
    }
}
