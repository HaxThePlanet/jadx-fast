package app.dogo.com.dogo_android.o;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final app.dogo.com.dogo_android.o.c a;
    public b(app.dogo.com.dogo_android.o.c c) {
        super();
        this.a = c;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        c.D1(this.a, view);
    }
}
