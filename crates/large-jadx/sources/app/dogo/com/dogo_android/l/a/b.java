package app.dogo.com.dogo_android.l.a;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    final app.dogo.com.dogo_android.l.a.b.a a;
    final int b;

    public interface a {
        public abstract void b(int i, View view2);
    }
    public b(app.dogo.com.dogo_android.l.a.b.a b$a, int i2) {
        super();
        this.a = a;
        this.b = i2;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        this.a.b(this.b, view);
    }
}
