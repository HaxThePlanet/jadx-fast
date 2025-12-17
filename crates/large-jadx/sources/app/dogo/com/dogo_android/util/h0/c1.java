package app.dogo.com.dogo_android.util.h0;

import android.view.View;
import android.view.View.OnClickListener;
import com.skydoves.balloon.Balloon;

/* loaded from: classes.dex */
public final class c1 implements View.OnClickListener {

    public final app.dogo.com.dogo_android.util.h0.h1 a;
    public final Balloon b;
    public c1(app.dogo.com.dogo_android.util.h0.h1 h1, Balloon balloon2) {
        super();
        this.a = h1;
        this.b = balloon2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        n1.c(this.a, this.b, view);
    }
}
