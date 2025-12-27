package app.dogo.com.dogo_android.i;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d0 implements View.OnClickListener {

    public final /* synthetic */ o0 a;
    public final /* synthetic */ o0.b b;
    public /* synthetic */ d0(o0 o0Var, o0.b bVar) {
        super();
        this.a = o0Var;
        this.b = bVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        JsonArrayEditAdapter_CheckBoxHolder.b(this.a, this.b, view);
    }
}
