package app.dogo.com.dogo_android.i;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class q implements View.OnClickListener {

    public final /* synthetic */ g0 a;
    public /* synthetic */ q(g0 g0Var) {
        super();
        this.a = g0Var;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DebugDataFragment.w2(this.a, view);
    }
}
