package nl.dionsegijn.konfetti.e;

import android.content.res.Resources;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class c {

    private final int a;
    private final float b;
    public c(int i, float f2) {
        int obj2;
        super();
        this.a = i;
        this.b = f2;
        obj2 = Float.compare(f2, obj2) != 0 ? 1 : 0;
        if (obj2 == null) {
        } else {
        }
        obj2 = new StringBuilder();
        obj2.append("mass=");
        obj2.append(f2);
        obj2.append(" must be != 0");
        IllegalArgumentException obj3 = new IllegalArgumentException(obj2.toString().toString());
        throw obj3;
    }

    public c(int i, float f2, int i3, g g4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 1084227584 : obj2;
        super(i, obj2);
    }

    public final float a() {
        return this.b;
    }

    public final float b() {
        Resources system = Resources.getSystem();
        n.e(system, "Resources.getSystem()");
        return f *= density;
    }

    public boolean equals(Object object) {
        boolean z;
        int i;
        Object obj3;
        if (this != (c)object && object instanceof c && this.a == object.a && Float.compare(this.b, object.b) == 0) {
            if (object instanceof c) {
                if (this.a == object.a) {
                    if (Float.compare(this.b, object.b) == 0) {
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    public int hashCode() {
        return i2 += floatToIntBits;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Size(sizeInDp=");
        stringBuilder.append(this.a);
        stringBuilder.append(", mass=");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
