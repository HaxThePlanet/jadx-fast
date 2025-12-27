package app.dogo.com.dogo_android.dogcreation.l;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final /* synthetic */ k a;
    public /* synthetic */ b(k kVar) {
        super();
        this.a = kVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DogCreationEmailRegisterFragment.F1(this.a, view);
    }
}
