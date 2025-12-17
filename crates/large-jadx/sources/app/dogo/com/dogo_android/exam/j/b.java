package app.dogo.com.dogo_android.exam.j;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final app.dogo.com.dogo_android.exam.j.g a;
    public b(app.dogo.com.dogo_android.exam.j.g g) {
        super();
        this.a = g;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        g.P1(this.a, view);
    }
}
