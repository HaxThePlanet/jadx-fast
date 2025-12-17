package app.dogo.com.dogo_android.welcome_v2;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final app.dogo.com.dogo_android.welcome_v2.c0.f a;
    public final app.dogo.com.dogo_android.welcome_v2.c0 b;
    public final int c;
    public final Button v;
    public c(app.dogo.com.dogo_android.welcome_v2.c0.f c0$f, app.dogo.com.dogo_android.welcome_v2.c0 c02, int i3, Button button4) {
        super();
        this.a = f;
        this.b = c02;
        this.c = i3;
        this.v = button4;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        c0.f.d(this.a, this.b, this.c, this.v, view);
    }
}
