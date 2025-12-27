package app.dogo.com.dogo_android.n.m;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final /* synthetic */ o.c a;
    public final /* synthetic */ o b;
    public /* synthetic */ a(o.c cVar, o oVar) {
        super();
        this.a = cVar;
        this.b = oVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        TrickListAdapter_TrickItemViewHolder.b(this.a, this.b, view);
    }
}
