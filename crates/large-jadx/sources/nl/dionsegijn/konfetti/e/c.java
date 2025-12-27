package nl.dionsegijn.konfetti.e;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: Size.kt */
/* loaded from: classes3.dex */
public final class c {

    private final int a;
    private final float b;
    public c(int i, float f) {
        int i2 = 1;
        super();
        this.a = i;
        this.b = f;
        i = f != 0 ? 1 : 0;
        if (i2 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "mass=";
            String str3 = " must be != 0";
            str2 = str + f + str3;
            throw new IllegalArgumentException(str2.toString());
        }
    }

    public final float a() {
        return this.b;
    }

    public final float b() {
        Resources system = Resources.getSystem();
        n.e(system, "Resources.getSystem()");
        return (float)this.a * system.getDisplayMetrics().density;
    }

    public /* synthetic */ c(int i, float f, int i2, g gVar) {
        i2 = i2 & 2 != 0 ? 1084227584 : i2;
        this(i, i2);
    }

    public boolean equals(Object object) {
        if (this != object) {
            z = object instanceof c;
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.a * 31) + Float.floatToIntBits(this.b);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Size(sizeInDp=";
        String str3 = ", mass=";
        String str4 = ")";
        str = str2 + this.a + str3 + this.b + str4;
        return str;
    }
}
