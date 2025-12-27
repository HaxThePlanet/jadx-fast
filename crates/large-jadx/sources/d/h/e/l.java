package d.h.e;

import android.util.Property;

/* compiled from: IntProperty.java */
/* loaded from: classes.dex */
public abstract class l<T> extends Property<T, Integer> {
    public l() {
        super(Integer.class, "");
    }

    @Override // android.util.Property
    public final void a(T t, Integer integer) {
        b(t, integer.intValue());
    }

    @Override // android.util.Property
    public abstract void b(T t, int i);
}
