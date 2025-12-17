package app.dogo.com.dogo_android.dogcreation.i;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final app.dogo.com.dogo_android.dogcreation.i.d a;
    public b(app.dogo.com.dogo_android.dogcreation.i.d d) {
        super();
        this.a = d;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        d.I1(this.a, view);
    }
}
