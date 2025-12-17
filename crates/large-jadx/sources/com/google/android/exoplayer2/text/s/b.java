package com.google.android.exoplayer2.text.s;

import android.text.TextUtils;
import com.google.common.base.b;
import com.google.common.collect.a0;
import com.google.common.collect.y0;
import com.google.common.collect.z;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class b {

    private static final Pattern d;
    private static final z<String> e;
    private static final z<String> f;
    private static final z<String> g;
    private static final z<String> h;
    public final int a;
    public final int b;
    public final int c;
    static {
        b.d = Pattern.compile("\\s+");
        b.e = z.z("auto", "none");
        b.f = z.A("dot", "sesame", "circle");
        b.g = z.z("filled", "open");
        b.h = z.A("after", "before", "outside");
    }

    private b(int i, int i2, int i3) {
        super();
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public static com.google.android.exoplayer2.text.s.b a(String string) {
        int i = 0;
        if (string == null) {
            return i;
        }
        String obj2 = b.c(string.trim());
        if (obj2.isEmpty()) {
            return i;
        }
        return b.b(z.t(TextUtils.split(obj2, b.d)));
    }

    private static com.google.android.exoplayer2.text.s.b b(z<String> z) {
        int i2;
        int i;
        boolean equals;
        String str4;
        String str2;
        int i5;
        int i6;
        boolean equals2;
        int i8;
        boolean empty;
        String str3;
        String str;
        int i9;
        int i3;
        int i4;
        int i7;
        boolean obj9;
        str4 = "outside";
        equals = a0.b(y0.c(b.h, z), str4);
        int i10 = (String)equals.hashCode();
        i3 = 2;
        i4 = -1;
        final int i14 = 0;
        i7 = 1;
        if (i10 != -1392885889) {
            if (i10 != -1106037339) {
                if (i10 != 92734940) {
                    i2 = i4;
                } else {
                    if (equals.equals("after")) {
                        i2 = i14;
                    } else {
                    }
                }
            } else {
                if (equals.equals(str4)) {
                    i2 = i7;
                } else {
                }
            }
        } else {
            if (equals.equals("before")) {
                i2 = i3;
            } else {
            }
        }
        if (i2 != 0) {
            i = i2 != i7 ? i7 : -2;
        } else {
            i = i3;
        }
        com.google.common.collect.y0.c cVar2 = y0.c(b.e, z);
        if (!cVar2.isEmpty()) {
            obj9 = cVar2.iterator().next();
            str2 = (String)obj9.hashCode();
            if (str2 != 3005871) {
                if (str2 != 3387192) {
                    i7 = i4;
                } else {
                    if (obj9.equals("none")) {
                        i7 = i14;
                    } else {
                    }
                }
            } else {
                if (obj9.equals("auto")) {
                } else {
                }
            }
            if (i7 != 0) {
            } else {
                i4 = i14;
            }
            obj9 = new b(i4, i14, i);
            return obj9;
        }
        com.google.common.collect.y0.c cVar3 = y0.c(b.g, z);
        obj9 = y0.c(b.f, z);
        if (cVar3.isEmpty() && obj9.isEmpty()) {
            if (obj9.isEmpty()) {
                obj9 = new b(i4, i14, i);
                return obj9;
            }
        }
        str3 = "filled";
        equals2 = a0.b(cVar3, str3);
        int i12 = (String)equals2.hashCode();
        if (i12 != -1274499742) {
            if (i12 != 3417674) {
                i5 = i4;
            } else {
                if (equals2.equals("open")) {
                    i5 = i14;
                } else {
                }
            }
        } else {
            if (equals2.equals(str3)) {
                i5 = i7;
            } else {
            }
        }
        i6 = i5 != 0 ? i7 : i3;
        str = "circle";
        obj9 = a0.b(obj9, str);
        int i13 = (String)obj9.hashCode();
        if (i13 != -1360216880) {
            if (i13 != -905816648) {
                if (i13 != 99657) {
                } else {
                    if (obj9.equals("dot")) {
                        i4 = i14;
                    }
                }
            } else {
                if (obj9.equals("sesame")) {
                    i4 = i7;
                }
            }
        } else {
            if (obj9.equals(str)) {
                i4 = i3;
            }
        }
        if (i4 != 0) {
            i3 = i4 != i7 ? i7 : 3;
        }
        obj9 = new b(i3, i6, i);
        return obj9;
    }
}
