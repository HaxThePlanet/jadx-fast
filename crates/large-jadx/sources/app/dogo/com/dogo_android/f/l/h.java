package app.dogo.com.dogo_android.f.l;

import android.view.View;
import android.view.View.OnClickListener;
import com.skydoves.balloon.Balloon;

/* loaded from: classes.dex */
public final class h implements View.OnClickListener {

    public final Balloon a;
    public final app.dogo.com.dogo_android.f.l.j b;
    public h(Balloon balloon, app.dogo.com.dogo_android.f.l.j j2) {
        super();
        this.a = balloon;
        this.b = j2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        j.W1(this.a, this.b, view);
    }
}
