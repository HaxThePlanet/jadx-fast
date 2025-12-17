package app.dogo.com.dogo_android.util.h0;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import androidx.appcompat.app.c;
import androidx.fragment.app.e;

/* loaded from: classes.dex */
public final class c0 implements DialogInterface.OnShowListener {

    public final e a;
    public final String b;
    public final c c;
    public c0(e e, String string2, c c3) {
        super();
        this.a = e;
        this.b = string2;
        this.c = c3;
    }

    @Override // android.content.DialogInterface$OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        g1.v(this.a, this.b, this.c, dialogInterface);
    }
}
