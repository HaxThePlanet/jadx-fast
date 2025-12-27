package app.dogo.com.dogo_android.dogcreation.l;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class h implements View.OnClickListener {

    public final /* synthetic */ m a;
    public /* synthetic */ h(m mVar) {
        super();
        this.a = mVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DogCreationLoginFragment.M1(this.a, view);
    }
}
