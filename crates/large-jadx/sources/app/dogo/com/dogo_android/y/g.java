package app.dogo.com.dogo_android.y;

import android.widget.Button;

/* loaded from: classes.dex */
public final class g implements Runnable {

    public final Button a;
    public g(Button button) {
        super();
        this.a = button;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l.e.a(this.a);
    }
}
