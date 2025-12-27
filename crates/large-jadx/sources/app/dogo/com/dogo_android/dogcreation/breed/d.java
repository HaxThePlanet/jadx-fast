package app.dogo.com.dogo_android.dogcreation.j;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    public final /* synthetic */ j a;
    public /* synthetic */ d(j jVar) {
        super();
        this.a = jVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DogCreationBreedFragment.O1(this.a, view);
    }
}
