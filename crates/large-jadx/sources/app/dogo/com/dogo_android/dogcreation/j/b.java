package app.dogo.com.dogo_android.dogcreation.j;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final app.dogo.com.dogo_android.dogcreation.j.i a;
    public final app.dogo.com.dogo_android.dogcreation.j.i.c b;
    public b(app.dogo.com.dogo_android.dogcreation.j.i i, app.dogo.com.dogo_android.dogcreation.j.i.c i$c2) {
        super();
        this.a = i;
        this.b = c2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        i.c.d(this.a, this.b, view);
    }
}
