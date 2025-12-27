package app.dogo.com.dogo_android.e;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final /* synthetic */ i a;
    public /* synthetic */ b(i iVar) {
        super();
        this.a = iVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ClickerFragment.H1(this.a, view);
    }
}
