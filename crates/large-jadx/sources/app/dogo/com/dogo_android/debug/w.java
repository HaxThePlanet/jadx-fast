package app.dogo.com.dogo_android.i;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class w implements View.OnClickListener {

    public final /* synthetic */ j0 a;
    public /* synthetic */ w(j0 j0Var) {
        super();
        this.a = j0Var;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DebugFeatureEnablerFragment.F1(this.a, view);
    }
}
