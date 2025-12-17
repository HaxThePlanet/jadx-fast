package app.dogo.com.dogo_android.i;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/* loaded from: classes.dex */
public final class y implements CompoundButton.OnCheckedChangeListener {

    public final app.dogo.com.dogo_android.i.n0 a;
    public final app.dogo.com.dogo_android.i.n0.a b;
    public y(app.dogo.com.dogo_android.i.n0 n0, app.dogo.com.dogo_android.i.n0.a n0$a2) {
        super();
        this.a = n0;
        this.b = a2;
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        n0.a.d(this.a, this.b, compoundButton, z2);
    }
}
