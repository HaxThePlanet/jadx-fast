package app.dogo.com.dogo_android.l.a;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/* compiled from: OnCheckedChangeListener.java */
/* loaded from: classes.dex */
public final class a implements CompoundButton.OnCheckedChangeListener {

    final a.a a;
    final int b;

    public interface a {
        void c(int i, CompoundButton compoundButton, boolean z);
    }
    public a(a.a aVar, int i) {
        super();
        this.a = aVar;
        this.b = i;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.a.c(this.b, compoundButton, z);
    }
}
