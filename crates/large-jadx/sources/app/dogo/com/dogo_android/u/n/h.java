package app.dogo.com.dogo_android.u.n;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/* loaded from: classes.dex */
public final class h implements CompoundButton.OnCheckedChangeListener {

    public final app.dogo.com.dogo_android.u.n.o a;
    public final app.dogo.com.dogo_android.u.n.o.e b;
    public h(app.dogo.com.dogo_android.u.n.o o, app.dogo.com.dogo_android.u.n.o.e o$e2) {
        super();
        this.a = o;
        this.b = e2;
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        o.e.e(this.a, this.b, compoundButton, z2);
    }
}
