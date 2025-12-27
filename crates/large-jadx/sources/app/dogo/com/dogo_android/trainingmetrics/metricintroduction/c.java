package app.dogo.com.dogo_android.x.c;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final /* synthetic */ g a;
    public /* synthetic */ c(g gVar) {
        super();
        this.a = gVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        MetricsIntroductionInteractionsFragment.F1(this.a, view);
    }
}
