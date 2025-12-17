package app.dogo.com.dogo_android.y.w;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class e implements View.OnClickListener {

    public final app.dogo.com.dogo_android.y.w.l a;
    public final app.dogo.com.dogo_android.y.w.l.i b;
    public e(app.dogo.com.dogo_android.y.w.l l, app.dogo.com.dogo_android.y.w.l.i l$i2) {
        super();
        this.a = l;
        this.b = i2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        l.i.d(this.a, this.b, view);
    }
}
