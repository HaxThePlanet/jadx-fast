package app.dogo.com.dogo_android.t.h0;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final app.dogo.com.dogo_android.t.h0.i a;
    public final app.dogo.com.dogo_android.t.h0.i.b b;
    public a(app.dogo.com.dogo_android.t.h0.i i, app.dogo.com.dogo_android.t.h0.i.b i$b2) {
        super();
        this.a = i;
        this.b = b2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        i.b.c(this.a, this.b, view);
    }
}
