package app.dogo.com.dogo_android.u.n.p.l;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    public final /* synthetic */ g a;
    public /* synthetic */ d(g gVar) {
        super();
        this.a = gVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DogLogEditFragment.N1(this.a, view);
    }
}
