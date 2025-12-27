package app.dogo.com.dogo_android.u.n.p.l;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class f implements View.OnClickListener {

    public final /* synthetic */ j a;
    public final /* synthetic */ j.b b;
    public /* synthetic */ f(j jVar, j.b bVar) {
        super();
        this.a = jVar;
        this.b = bVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DogLogTypeListAdapter_CellHolder.b(this.a, this.b, view);
    }
}
