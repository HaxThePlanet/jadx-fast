package app.dogo.com.dogo_android.util.h0;

import android.view.View;
import android.view.View.OnClickListener;
import com.skydoves.balloon.Balloon;

/* loaded from: classes.dex */
public final class e1 implements View.OnClickListener {

    public final app.dogo.com.dogo_android.util.h0.o1 a;
    public final Balloon b;
    public e1(app.dogo.com.dogo_android.util.h0.o1 o1, Balloon balloon2) {
        super();
        this.a = o1;
        this.b = balloon2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        n1.e(this.a, this.b, view);
    }
}
