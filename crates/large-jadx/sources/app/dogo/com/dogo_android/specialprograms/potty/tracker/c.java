package app.dogo.com.dogo_android.u.n.r;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final /* synthetic */ f a;
    public /* synthetic */ c(f fVar) {
        super();
        this.a = fVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        PottyTrackerOverviewFragment.P1(this.a, view);
    }
}
