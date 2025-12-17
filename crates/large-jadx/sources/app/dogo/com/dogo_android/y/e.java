package app.dogo.com.dogo_android.y;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.u.j;
import app.dogo.com.dogo_android.util.e0.y.c;

/* loaded from: classes.dex */
public final class e implements View.OnClickListener {

    public final j a;
    public final y.c b;
    public e(j j, y.c y$c2) {
        super();
        this.a = j;
        this.b = c2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        l.p(this.a, this.b, view);
    }
}
