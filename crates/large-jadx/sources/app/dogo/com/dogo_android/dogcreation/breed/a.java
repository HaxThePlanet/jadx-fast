package app.dogo.com.dogo_android.dogcreation.j;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final /* synthetic */ i a;
    public final /* synthetic */ i.a b;
    public /* synthetic */ a(i iVar, i.a aVar) {
        super();
        this.a = iVar;
        this.b = aVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        BreedSearchListAdapter_BreedHolder.b(this.a, this.b, view);
    }
}
