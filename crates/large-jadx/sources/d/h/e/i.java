package d.h.e;

import android.util.Property;

/* compiled from: FloatProperty.java */
/* loaded from: classes.dex */
public abstract class i<T> extends Property<T, Float> {
    public i() {
        super(Float.class, "");
    }

    @Override // android.util.Property
    public final void a(T t, Float float) {
        b(t, float.floatValue());
    }

    @Override // android.util.Property
    public abstract void b(T t, float f);
}
