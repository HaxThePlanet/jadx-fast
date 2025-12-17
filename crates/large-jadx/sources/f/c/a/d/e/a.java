package f.c.a.d.e;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.internal.p;

/* loaded from: classes2.dex */
public final class a implements a.d {

    public static final f.c.a.d.e.a B;
    private final Long A = null;
    private final boolean a = false;
    private final boolean b = false;
    private final String c = null;
    private final boolean v = false;
    private final String w = null;
    private final String x = null;
    private final boolean y = false;
    private final Long z = null;
    static {
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        a.B = aVar2;
    }

    a(boolean z, boolean z2, String string3, boolean z4, String string5, String string6, boolean z7, Long long8, Long long9, f.c.a.d.e.h h10) {
        super();
        final int obj1 = 0;
        final int obj2 = 0;
    }

    @Override // com.google.android.gms.common.api.a$d
    public final boolean equals(Object object) {
        boolean z;
        Object obj5;
        final int i = 1;
        if (object == this) {
            return i;
        }
        final int i3 = 0;
        if (!object instanceof a) {
            return i3;
        }
        boolean z3 = object.a;
        boolean z4 = object.b;
        String str = object.c;
        int i2 = 0;
        boolean z5 = object.v;
        boolean z6 = object.y;
        String str2 = object.w;
        String str3 = object.x;
        Long num = object.z;
        obj5 = object.A;
        if (p.a(i2, i2) && p.a(i2, i2) && p.a(i2, i2) && p.a(i2, i2) && p.a(i2, i2)) {
            z5 = object.v;
            z6 = object.y;
            str2 = object.w;
            if (p.a(i2, i2)) {
                str3 = object.x;
                if (p.a(i2, i2)) {
                    num = object.z;
                    if (p.a(i2, i2)) {
                        obj5 = object.A;
                        if (p.a(i2, i2)) {
                            return i;
                        }
                    }
                }
            }
        }
        return i3;
    }

    @Override // com.google.android.gms.common.api.a$d
    public final int hashCode() {
        Object[] arr = new Object[9];
        Boolean fALSE = Boolean.FALSE;
        final int i12 = 0;
        return p.b(fALSE, fALSE, i12, fALSE, fALSE, i12, i12, i12, i12);
    }
}
