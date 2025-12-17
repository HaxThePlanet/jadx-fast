package kotlin.d0.d;

import kotlin.i0.c;
import kotlin.i0.l;

/* loaded from: classes3.dex */
public abstract class y extends kotlin.d0.d.c implements l {
    public y(Object object) {
        super(object);
    }

    public y(Object object, Class class2, String string3, String string4, int i5) {
        int i;
        i = 1;
        if (i5 &= i == i) {
        } else {
            i = 0;
        }
        super(object, class2, string3, string4, i);
    }

    @Override // kotlin.d0.d.c
    public boolean equals(Object object) {
        int i;
        boolean boundReceiver;
        Object signature;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof y) {
            if (getOwner().equals((y)object.getOwner()) && getName().equals(object.getName()) && getSignature().equals(object.getSignature()) && n.b(getBoundReceiver(), object.getBoundReceiver())) {
                if (getName().equals(object.getName())) {
                    if (getSignature().equals(object.getSignature())) {
                        if (n.b(getBoundReceiver(), object.getBoundReceiver())) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        if (object instanceof l) {
            return object.equals(compute());
        }
        return i2;
    }

    @Override // kotlin.d0.d.c
    protected c getReflected() {
        return getReflected();
    }

    @Override // kotlin.d0.d.c
    protected l getReflected() {
        return (l)super.getReflected();
    }

    @Override // kotlin.d0.d.c
    public int hashCode() {
        return i4 += i7;
    }

    @Override // kotlin.d0.d.c
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // kotlin.d0.d.c
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    @Override // kotlin.d0.d.c
    public String toString() {
        c compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("property ");
        stringBuilder.append(getName());
        stringBuilder.append(" (Kotlin reflection is not available)");
        return stringBuilder.toString();
    }
}
