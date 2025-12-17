package app.dogo.com.dogo_android.util.h0;

import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.material.timepicker.b;
import kotlin.d0.c.p;

/* loaded from: classes.dex */
public final class h0 implements View.OnClickListener {

    public final p a;
    public final b b;
    public h0(p p, b b2) {
        super();
        this.a = p;
        this.b = b2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        g1.A(this.a, this.b, view);
    }
}
