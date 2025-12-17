package app.dogo.com.dogo_android.i;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class d0 implements View.OnClickListener {

    public final app.dogo.com.dogo_android.i.o0 a;
    public final app.dogo.com.dogo_android.i.o0.b b;
    public d0(app.dogo.com.dogo_android.i.o0 o0, app.dogo.com.dogo_android.i.o0.b o0$b2) {
        super();
        this.a = o0;
        this.b = b2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        o0.b.d(this.a, this.b, view);
    }
}
