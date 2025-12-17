package app.dogo.com.dogo_android.q.p;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    public final app.dogo.com.dogo_android.q.p.s a;
    public d(app.dogo.com.dogo_android.q.p.s s) {
        super();
        this.a = s;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        s.D1(this.a, view);
    }
}
