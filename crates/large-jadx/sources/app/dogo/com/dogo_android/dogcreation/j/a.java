package app.dogo.com.dogo_android.dogcreation.j;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final app.dogo.com.dogo_android.dogcreation.j.i a;
    public final app.dogo.com.dogo_android.dogcreation.j.i.a b;
    public a(app.dogo.com.dogo_android.dogcreation.j.i i, app.dogo.com.dogo_android.dogcreation.j.i.a i$a2) {
        super();
        this.a = i;
        this.b = a2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        i.a.d(this.a, this.b, view);
    }
}
