package app.dogo.com.dogo_android.i;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b0 implements View.OnClickListener {

    public final /* synthetic */ n0 a;
    public final /* synthetic */ n0.h b;
    public /* synthetic */ b0(n0 n0Var, n0.h hVar) {
        super();
        this.a = n0Var;
        this.b = hVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DebugFeatureListAdapter_LongHolder.b(this.a, this.b, view);
    }
}
