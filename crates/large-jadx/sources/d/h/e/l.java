package d.h.e;

import android.util.Property;

/* loaded from: classes.dex */
public abstract class l<T>  extends Property<T, Integer> {
    public l() {
        super(Integer.class, "");
    }

    public final void a(T t, Integer integer2) {
        b(t, integer2.intValue());
    }

    public abstract void b(T t, int i2);

    @Override // android.util.Property
    public void set(Object object, Object object2) {
        a(object, (Integer)object2);
    }
}
