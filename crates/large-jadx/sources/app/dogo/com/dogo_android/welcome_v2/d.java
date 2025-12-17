package app.dogo.com.dogo_android.welcome_v2;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import kotlin.d0.c.p;

/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    public final app.dogo.com.dogo_android.welcome_v2.c0.g a;
    public final app.dogo.com.dogo_android.welcome_v2.c0 b;
    public final int c;
    public final p v;
    public final Button w;
    public d(app.dogo.com.dogo_android.welcome_v2.c0.g c0$g, app.dogo.com.dogo_android.welcome_v2.c0 c02, int i3, p p4, Button button5) {
        super();
        this.a = g;
        this.b = c02;
        this.c = i3;
        this.v = p4;
        this.w = button5;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        c0.g.d(this.a, this.b, this.c, this.v, this.w, view);
    }
}
