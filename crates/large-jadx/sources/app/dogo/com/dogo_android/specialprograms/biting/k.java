package app.dogo.com.dogo_android.u.m;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class k implements View.OnClickListener {

    public final /* synthetic */ v a;
    public final /* synthetic */ v.b b;
    public /* synthetic */ k(v vVar, v.b bVar) {
        super();
        this.a = vVar;
        this.b = bVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        VariationsUnlockedListAdapter_DefaultViewHolder.a(this.a, this.b, view);
    }
}
