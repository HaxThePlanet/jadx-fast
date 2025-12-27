package app.dogo.com.dogo_android.i;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a0 implements View.OnClickListener {

    public final /* synthetic */ n0 a;
    public final /* synthetic */ n0.g b;
    public /* synthetic */ a0(n0 n0Var, n0.g gVar) {
        super();
        this.a = n0Var;
        this.b = gVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DebugFeatureListAdapter_JsonArrayHolder.b(this.a, this.b, view);
    }
}
