package app.dogo.com.dogo_android.dogcreation.l;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    public final app.dogo.com.dogo_android.dogcreation.l.m a;
    public d(app.dogo.com.dogo_android.dogcreation.l.m m) {
        super();
        this.a = m;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        m.G1(this.a, view);
    }
}
