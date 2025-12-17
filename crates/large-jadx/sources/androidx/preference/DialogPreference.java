package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.core.content.e.g;

/* loaded from: classes.dex */
public abstract class DialogPreference extends androidx.preference.Preference {

    private java.lang.CharSequence L;
    public DialogPreference(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, g.a(context, c.b, 16842897));
    }

    public DialogPreference(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet2, int i3, int i4) {
        Object obj3;
        super(context, attributeSet2, i3, i4);
        final TypedArray obj2 = context.obtainStyledAttributes(attributeSet2, f.h, i3, i4);
        obj3 = g.o(obj2, f.r, f.i);
        this.L = obj3;
        if (obj3 == null) {
            this.L = n();
        }
        g.o(obj2, f.q, f.j);
        g.c(obj2, f.o, f.k);
        g.o(obj2, f.t, f.l);
        g.o(obj2, f.s, f.m);
        g.n(obj2, f.p, f.n, 0);
        obj2.recycle();
    }
}
