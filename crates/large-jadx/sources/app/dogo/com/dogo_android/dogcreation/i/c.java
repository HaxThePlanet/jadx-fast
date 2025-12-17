package app.dogo.com.dogo_android.dogcreation.i;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final app.dogo.com.dogo_android.dogcreation.i.d a;
    public c(app.dogo.com.dogo_android.dogcreation.i.d d) {
        super();
        this.a = d;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        d.J1(this.a, view);
    }
}
