package app.dogo.com.dogo_android.i;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class e0 implements View.OnClickListener {

    public final app.dogo.com.dogo_android.i.p0 a;
    public e0(app.dogo.com.dogo_android.i.p0 p0) {
        super();
        this.a = p0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        p0.F1(this.a, view);
    }
}
