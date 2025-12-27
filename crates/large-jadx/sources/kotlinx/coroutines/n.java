package app.dogo.com.dogo_android.t;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class n implements DialogInterface.OnClickListener {

    public final /* synthetic */ c0 a;
    public /* synthetic */ n(c0 c0Var) {
        super();
        this.a = c0Var;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        SettingsFragment.D1(this.a, dialogInterface, i);
    }
}
