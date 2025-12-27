package app.dogo.com.dogo_android.i;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class y implements CompoundButton.OnCheckedChangeListener {

    public final /* synthetic */ n0 a;
    public final /* synthetic */ n0.a b;
    public /* synthetic */ y(n0 n0Var, n0.a aVar) {
        super();
        this.a = n0Var;
        this.b = aVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        DebugFeatureListAdapter_BooleanHolder.b(this.a, this.b, compoundButton, z);
    }
}
