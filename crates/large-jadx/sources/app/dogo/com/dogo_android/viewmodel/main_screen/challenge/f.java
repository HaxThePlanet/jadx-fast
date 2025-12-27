package app.dogo.com.dogo_android.a0.g.f;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import app.dogo.com.dogo_android.util.l0.a;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class f implements DialogInterface.OnClickListener {

    public final /* synthetic */ a a;
    public /* synthetic */ f(a aVar) {
        super();
        this.a = aVar;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.a(dialogInterface, i);
    }
}
