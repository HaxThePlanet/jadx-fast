package app.dogo.com.dogo_android.n;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final /* synthetic */ h a;
    public /* synthetic */ b(h hVar) {
        super();
        this.a = hVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        LibraryFragment.M1(this.a, view);
    }
}
