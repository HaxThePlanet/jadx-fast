package app.dogo.com.dogo_android.q;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.q.q.f.a;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final f.a a;
    public final boolean b;
    public a(f.a f$a, boolean z2) {
        super();
        this.a = a;
        this.b = z2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        o.e(this.a, this.b, view);
    }
}
