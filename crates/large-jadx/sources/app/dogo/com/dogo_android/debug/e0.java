package app.dogo.com.dogo_android.i;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class e0 implements View.OnClickListener {

    public final /* synthetic */ p0 a;
    public /* synthetic */ e0(p0 p0Var) {
        super();
        this.a = p0Var;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        JsonArrayEditDialog.G1(this.a, view);
    }
}
