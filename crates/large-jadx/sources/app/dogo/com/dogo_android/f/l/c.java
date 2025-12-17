package app.dogo.com.dogo_android.f.l;

import android.view.View;
import android.view.View.OnClickListener;
import com.skydoves.balloon.Balloon;

/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final app.dogo.com.dogo_android.f.l.j a;
    public final Balloon b;
    public c(app.dogo.com.dogo_android.f.l.j j, Balloon balloon2) {
        super();
        this.a = j;
        this.b = balloon2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        j.R1(this.a, this.b, view);
    }
}
