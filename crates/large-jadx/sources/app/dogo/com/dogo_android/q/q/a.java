package app.dogo.com.dogo_android.q.q;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final app.dogo.com.dogo_android.q.q.f a;
    public final app.dogo.com.dogo_android.q.q.f.b b;
    public a(app.dogo.com.dogo_android.q.q.f f, app.dogo.com.dogo_android.q.q.f.b f$b2) {
        super();
        this.a = f;
        this.b = b2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        f.b.c(this.a, this.b, view);
    }
}
