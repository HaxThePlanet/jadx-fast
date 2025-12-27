package app.dogo.com.dogo_android.i;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class l implements DialogInterface.OnClickListener {

    public final /* synthetic */ g0 a;
    public final /* synthetic */ EditText b;
    public /* synthetic */ l(g0 g0Var, EditText editText) {
        super();
        this.a = g0Var;
        this.b = editText;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        DebugDataFragment.k2(this.a, this.b, dialogInterface, i);
    }
}
