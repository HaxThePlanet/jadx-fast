package app.dogo.com.dogo_android.dogcreation.j;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class e implements View.OnClickListener {

    public final /* synthetic */ j a;
    public /* synthetic */ e(j jVar) {
        super();
        this.a = jVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DogCreationBreedFragment.M1(this.a, view);
    }
}
