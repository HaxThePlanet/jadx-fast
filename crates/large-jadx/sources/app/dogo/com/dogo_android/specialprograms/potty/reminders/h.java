package app.dogo.com.dogo_android.u.n.q;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class h implements View.OnClickListener {

    public final /* synthetic */ m a;
    public final /* synthetic */ m.b b;
    public /* synthetic */ h(m mVar, m.b bVar) {
        super();
        this.a = mVar;
        this.b = bVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ReminderIntervalAdapter_Holder.a(this.a, this.b, view);
    }
}
