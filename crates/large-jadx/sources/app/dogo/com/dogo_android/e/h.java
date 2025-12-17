package app.dogo.com.dogo_android.e;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class h implements View.OnClickListener {

    public final app.dogo.com.dogo_android.e.p a;
    public h(app.dogo.com.dogo_android.e.p p) {
        super();
        this.a = p;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        p.B1(this.a, view);
    }
}
