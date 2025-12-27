package app.dogo.com.dogo_android.i;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c0 implements View.OnClickListener {

    public final /* synthetic */ n0 a;
    public final /* synthetic */ n0.i b;
    public /* synthetic */ c0(n0 n0Var, n0.i iVar) {
        super();
        this.a = n0Var;
        this.b = iVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DebugFeatureListAdapter_StringHolder.b(this.a, this.b, view);
    }
}
