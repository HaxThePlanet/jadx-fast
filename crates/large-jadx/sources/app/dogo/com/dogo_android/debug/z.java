package app.dogo.com.dogo_android.i;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class z implements View.OnClickListener {

    public final /* synthetic */ n0 a;
    public final /* synthetic */ n0.d b;
    public /* synthetic */ z(n0 n0Var, n0.d dVar) {
        super();
        this.a = n0Var;
        this.b = dVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DebugFeatureListAdapter_DoubleHolder.b(this.a, this.b, view);
    }
}
