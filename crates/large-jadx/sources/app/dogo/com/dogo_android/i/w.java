package app.dogo.com.dogo_android.i;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class w implements View.OnClickListener {

    public final app.dogo.com.dogo_android.i.j0 a;
    public w(app.dogo.com.dogo_android.i.j0 j0) {
        super();
        this.a = j0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        j0.C1(this.a, view);
    }
}
