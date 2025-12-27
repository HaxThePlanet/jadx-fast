package app.dogo.com.dogo_android.l.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: OnClickListener.java */
/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    final b.a a;
    final int b;

    public interface a {
        void b(int i, View view);
    }
    public b(b.a aVar, int i) {
        super();
        this.a = aVar;
        this.b = i;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        this.a.b(this.b, view);
    }
}
