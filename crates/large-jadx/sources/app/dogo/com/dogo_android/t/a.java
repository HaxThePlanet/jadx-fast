package app.dogo.com.dogo_android.t;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.util.e0.y;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final app.dogo.com.dogo_android.t.b0 a;
    public final y b;
    public a(app.dogo.com.dogo_android.t.b0 b0, y y2) {
        super();
        this.a = b0;
        this.b = y2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        a0.a(this.a, this.b, view);
    }
}
