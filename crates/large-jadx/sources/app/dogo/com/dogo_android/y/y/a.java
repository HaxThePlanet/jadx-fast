package app.dogo.com.dogo_android.y.y;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final app.dogo.com.dogo_android.y.y.e a;
    public final app.dogo.com.dogo_android.y.y.e.b b;
    public a(app.dogo.com.dogo_android.y.y.e e, app.dogo.com.dogo_android.y.y.e.b e$b2) {
        super();
        this.a = e;
        this.b = b2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        e.b.d(this.a, this.b, view);
    }
}
