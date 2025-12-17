package app.dogo.com.dogo_android.util.f0;

import android.view.View;

/* loaded from: classes.dex */
public final class c implements Runnable {

    public final View a;
    public c(View view) {
        super();
        this.a = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m.f(this.a);
    }
}
