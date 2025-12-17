package app.dogo.com.dogo_android.util.f0;

import android.view.View;

/* loaded from: classes.dex */
public final class b implements Runnable {

    public final View a;
    public b(View view) {
        super();
        this.a = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m.e(this.a);
    }
}
