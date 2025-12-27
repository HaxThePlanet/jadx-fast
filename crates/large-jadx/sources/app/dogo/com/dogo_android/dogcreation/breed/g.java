package app.dogo.com.dogo_android.dogcreation.j;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class g implements View.OnClickListener {

    public final /* synthetic */ l a;
    public /* synthetic */ g(l lVar) {
        super();
        this.a = lVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DogCreationBreedSearchDialog.H1(this.a, view);
    }
}
