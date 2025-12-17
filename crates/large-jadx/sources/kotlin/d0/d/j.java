package kotlin.d0.d;

import kotlin.i0.c;
import kotlin.i0.g;

/* loaded from: classes3.dex */
public class j extends kotlin.d0.d.c implements kotlin.d0.d.i, g {

    private final int arity;
    private final int flags;
    public j(int i) {
        super(i, c.NO_RECEIVER, 0, 0, 0, 0);
    }

    public j(int i, Object object2) {
        super(i, object2, 0, 0, 0, 0);
    }

    public j(int i, Object object2, Class class3, String string4, String string5, int i6) {
        int i2;
        int i3;
        final int i4 = 1;
        i3 = i6 & 1 == i4 ? i4 : i2;
        super(object2, class3, string4, string5, i3);
        this.arity = i;
        this.flags = i6 >> 1;
    }

    @Override // kotlin.d0.d.c
    protected c computeReflected() {
        return c0.a(this);
    }

    @Override // kotlin.d0.d.c
    public boolean equals(Object object) {
        int i;
        Object boundReceiver;
        int signature;
        boolean obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof j) {
            if (n.b(getOwner(), (j)object.getOwner()) && getName().equals(object.getName()) && getSignature().equals(object.getSignature()) && this.flags == object.flags && this.arity == object.arity && n.b(getBoundReceiver(), object.getBoundReceiver())) {
                if (getName().equals(object.getName())) {
                    if (getSignature().equals(object.getSignature())) {
                        if (this.flags == object.flags) {
                            if (this.arity == object.arity) {
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
                } else {
                }
            } else {
            }
            return i;
        }
        if (object instanceof g) {
            return object.equals(compute());
        }
        return i2;
    }

    @Override // kotlin.d0.d.c
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.d0.d.c
    protected c getReflected() {
        return j();
    }

    @Override // kotlin.d0.d.c
    public int hashCode() {
        int i;
        if (getOwner() == null) {
            i = 0;
        } else {
            i5 *= 31;
        }
        return i3 += i7;
    }

    @Override // kotlin.d0.d.c
    public boolean isSuspend() {
        return j().isSuspend();
    }

    @Override // kotlin.d0.d.c
    protected g j() {
        return (g)super.getReflected();
    }

    @Override // kotlin.d0.d.c
    public String toString() {
        String string;
        String str;
        c compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            string = "constructor (Kotlin reflection is not available)";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("function ");
            stringBuilder.append(getName());
            stringBuilder.append(" (Kotlin reflection is not available)");
            string = stringBuilder.toString();
        }
        return string;
    }
}
