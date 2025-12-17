package d.h.e;

import android.util.Property;

/* loaded from: classes.dex */
public abstract class i<T>  extends Property<T, Float> {
    public i() {
        super(Float.class, "");
    }

    public final void a(T t, Float float2) {
        b(t, float2.floatValue());
    }

    public abstract void b(T t, float f2);

    @Override // android.util.Property
    public void set(Object object, Object object2) {
        a(object, (Float)object2);
    }
}
