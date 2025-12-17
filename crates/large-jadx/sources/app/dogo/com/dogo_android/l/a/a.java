package app.dogo.com.dogo_android.l.a;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/* loaded from: classes.dex */
public final class a implements CompoundButton.OnCheckedChangeListener {

    final app.dogo.com.dogo_android.l.a.a.a a;
    final int b;

    public interface a {
        public abstract void c(int i, CompoundButton compoundButton2, boolean z3);
    }
    public a(app.dogo.com.dogo_android.l.a.a.a a$a, int i2) {
        super();
        this.a = a;
        this.b = i2;
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        this.a.c(this.b, compoundButton, z2);
    }
}
