package app.dogo.com.dogo_android.dogcreation.l;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final /* synthetic */ m a;
    public /* synthetic */ c(m mVar) {
        super();
        this.a = mVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DogCreationLoginFragment.O1(this.a, view);
    }
}
