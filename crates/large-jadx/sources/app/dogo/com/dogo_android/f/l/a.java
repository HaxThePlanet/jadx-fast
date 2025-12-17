package app.dogo.com.dogo_android.f.l;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final app.dogo.com.dogo_android.f.l.i a;
    public final int b;
    public a(app.dogo.com.dogo_android.f.l.i i, int i2) {
        super();
        this.a = i;
        this.b = i2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        i.v(this.a, this.b, view);
    }
}
