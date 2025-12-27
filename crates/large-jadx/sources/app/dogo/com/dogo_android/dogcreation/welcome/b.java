package app.dogo.com.dogo_android.dogcreation.o;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final /* synthetic */ c a;
    public /* synthetic */ b(c cVar) {
        super();
        this.a = cVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DogCreationWelcomeFragment.D1(this.a, view);
    }
}
