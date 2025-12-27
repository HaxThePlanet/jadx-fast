package app.dogo.com.dogo_android.u.n.q;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class i implements View.OnClickListener {

    public final /* synthetic */ n a;
    public /* synthetic */ i(n nVar) {
        super();
        this.a = nVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ReminderIntervalDialog.G1(this.a, view);
    }
}
