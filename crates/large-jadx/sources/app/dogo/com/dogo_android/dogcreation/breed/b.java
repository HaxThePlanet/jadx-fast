package app.dogo.com.dogo_android.dogcreation.j;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final /* synthetic */ i a;
    public final /* synthetic */ i.c b;
    public /* synthetic */ b(i iVar, i.c cVar) {
        super();
        this.a = iVar;
        this.b = cVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        BreedSearchListAdapter_CustomHolder.b(this.a, this.b, view);
    }
}
