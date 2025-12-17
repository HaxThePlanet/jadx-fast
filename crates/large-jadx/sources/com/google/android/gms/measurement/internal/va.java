package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.measurement.r3;
import com.google.android.gms.internal.measurement.x3;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
abstract class va {

    final String a;
    final int b;
    Boolean c;
    Boolean d;
    Long e;
    Long f;
    va(String string, int i2) {
        super();
        this.a = string;
        this.b = i2;
    }

    private static Boolean d(String string, int i2, boolean z3, String string4, List<String> list5, String string6, com.google.android.gms.measurement.internal.q3 q37) {
        int i;
        int eNGLISH;
        Object obj2;
        int obj3;
        final int i4 = 0;
        if (i2 == 7 && list5 != null && list5.size() != 0) {
            if (list5 != null) {
                if (list5.size() != 0) {
                    if (z3 == 0 && i2 != 2) {
                        if (i2 != 2) {
                            obj2 = string.toUpperCase(Locale.ENGLISH);
                        }
                    }
                    switch (obj3) {
                        case 1:
                            obj3 = 66;
                            obj3 = 0;
                            return Boolean.valueOf(Pattern.compile(string6, obj3).matcher(obj2).matches());
                        case 2:
                            return Boolean.valueOf(obj2.startsWith(string4));
                        case 3:
                            return Boolean.valueOf(obj2.endsWith(string4));
                        case 4:
                            return Boolean.valueOf(obj2.contains(string4));
                        case 5:
                            return Boolean.valueOf(obj2.equals(string4));
                        case 6:
                            return i4;
                            return Boolean.valueOf(list5.contains(obj2));
                        default:
                            return i4;
                    }
                    return i4;
                }
            }
            return i4;
        }
        if (string4 == null) {
            return i4;
        }
    }

    static Boolean e(BigDecimal bigDecimal, r3 r32, double d3) {
        boolean z2;
        boolean z;
        int bigDecimal3;
        int valueOf;
        int i2;
        int i3;
        boolean z3;
        int bigDecimal4;
        BigDecimal bigDecimal2;
        int i;
        int i4;
        int obj8;
        BigDecimal obj9;
        int obj10;
        r.j(r32);
        valueOf = 0;
        if (r32.C()) {
            i2 = 1;
            if (r32.H() == i2) {
            } else {
                i3 = 5;
                if (r32.H() == i3 && r32.G() && r32.F()) {
                    if (r32.G()) {
                        if (r32.F()) {
                            bigDecimal3 = r32.H();
                            if (r32.H() == i3 && da.P(r32.A()) && !da.P(r32.z())) {
                                if (da.P(r32.A())) {
                                    if (!da.P(r32.z())) {
                                    }
                                    BigDecimal bigDecimal5 = new BigDecimal(r32.A());
                                    bigDecimal2 = new BigDecimal(r32.z());
                                    obj9 = bigDecimal5;
                                    bigDecimal4 = valueOf;
                                    if (bigDecimal3 == i3) {
                                        if (obj9 != null) {
                                            bigDecimal3--;
                                            i3 = 0;
                                            if (bigDecimal3 != i2) {
                                                i = 2;
                                                if (bigDecimal3 != i) {
                                                    if (bigDecimal3 != 3) {
                                                        if (bigDecimal3 != 4) {
                                                        } else {
                                                            if (obj9 != null) {
                                                                if (bigDecimal.compareTo(obj9) >= 0 && bigDecimal.compareTo(bigDecimal2) <= 0) {
                                                                    if (bigDecimal.compareTo(bigDecimal2) <= 0) {
                                                                    } else {
                                                                        i2 = i3;
                                                                    }
                                                                } else {
                                                                }
                                                                valueOf = Boolean.valueOf(i2);
                                                            }
                                                        }
                                                    } else {
                                                        if (bigDecimal4 == 0) {
                                                        } else {
                                                            if (Double.compare(d3, bigDecimal3) != 0) {
                                                                obj9 = new BigDecimal(d3, obj11);
                                                                bigDecimal3 = new BigDecimal(i);
                                                                obj9 = new BigDecimal(d3, obj11);
                                                                obj10 = new BigDecimal(i);
                                                                if (bigDecimal.compareTo(bigDecimal4.subtract(obj9.multiply(bigDecimal3))) > 0 && bigDecimal.compareTo(bigDecimal4.add(obj9.multiply(obj10))) < 0) {
                                                                    obj9 = new BigDecimal(d3, obj11);
                                                                    obj10 = new BigDecimal(i);
                                                                    if (bigDecimal.compareTo(bigDecimal4.add(obj9.multiply(obj10))) < 0) {
                                                                    } else {
                                                                        i2 = i3;
                                                                    }
                                                                } else {
                                                                }
                                                                valueOf = Boolean.valueOf(i2);
                                                            } else {
                                                                if (bigDecimal.compareTo(bigDecimal4) == 0) {
                                                                } else {
                                                                    i2 = i3;
                                                                }
                                                                valueOf = Boolean.valueOf(i2);
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (bigDecimal4 == 0) {
                                                    } else {
                                                        if (bigDecimal.compareTo(bigDecimal4) > 0) {
                                                        } else {
                                                            i2 = i3;
                                                        }
                                                    }
                                                }
                                                return Boolean.valueOf(i2);
                                            }
                                            if (bigDecimal4 == 0) {
                                            }
                                        }
                                        return valueOf;
                                    } else {
                                        if (bigDecimal4 == 0) {
                                        } else {
                                        }
                                    }
                                    if (bigDecimal.compareTo(bigDecimal4) < 0) {
                                    } else {
                                        i2 = i3;
                                    }
                                }
                                return valueOf;
                            }
                            if (!da.P(r32.y())) {
                                return valueOf;
                            }
                            bigDecimal4 = new BigDecimal(r32.y());
                            bigDecimal2 = obj9;
                        }
                    }
                    return valueOf;
                }
                if (!r32.D()) {
                    return valueOf;
                }
            }
            return Boolean.valueOf(i2);
        }
        return valueOf;
    }

    static Boolean f(String string, x3 x32, com.google.android.gms.measurement.internal.q3 q33) {
        int i;
        boolean z;
        String upperCase;
        int arrayList;
        int i4;
        Locale eNGLISH2;
        int upperCase2;
        int i2;
        Locale eNGLISH;
        int i3;
        Object obj11;
        r.j(x32);
        final int i5 = 0;
        if (string == null) {
            return i5;
        }
        if (x32.E()) {
            if (x32.F() == 1) {
            } else {
                int i8 = 7;
                if (x32.F() == i8 && x32.w() != 0) {
                    if (x32.w() != 0) {
                        final int i9 = x32.F();
                        final boolean z2 = x32.B();
                        int i7 = 2;
                        if (!z2 && i9 != i7) {
                            if (i9 != i7) {
                                if (i9 == i8) {
                                    upperCase = x32.z();
                                } else {
                                    upperCase = x32.z().toUpperCase(Locale.ENGLISH);
                                }
                            } else {
                            }
                        } else {
                        }
                        final String str3 = upperCase;
                        if (x32.w() == 0) {
                            i2 = i5;
                        } else {
                            obj11 = x32.A();
                            if (!z2) {
                                arrayList = new ArrayList(obj11.size());
                                obj11 = obj11.iterator();
                                for (String next : obj11) {
                                    arrayList.add(next.toUpperCase(Locale.ENGLISH));
                                }
                                obj11 = Collections.unmodifiableList(arrayList);
                            }
                            i2 = obj11;
                        }
                        i3 = i9 == i7 ? str3 : i5;
                    }
                    return i5;
                }
                if (!x32.D()) {
                    return i5;
                }
            }
            return va.d(string, i9, z2, str3, i2, i3, q33);
        }
        return i5;
    }

    static Boolean g(double d, r3 r32) {
        try {
            BigDecimal bigDecimal = new BigDecimal(d, r32);
            return va.e(bigDecimal, obj3, Math.ulp(d));
            d = 0.0d;
            return d;
        }
    }

    static Boolean h(long l, r3 r32) {
        try {
            BigDecimal bigDecimal = new BigDecimal(l, r32);
            return va.e(bigDecimal, obj3, 0);
            l = 0L;
            return l;
        }
    }

    static Boolean i(String string, r3 r32) {
        if (!da.P(string)) {
            return null;
        }
        BigDecimal bigDecimal = new BigDecimal(string);
        return va.e(bigDecimal, r32, 0);
    }

    static Boolean j(Boolean boolean, boolean z2) {
        int obj0;
        if (boolean == null) {
            return null;
        }
        obj0 = boolean.booleanValue() != z2 ? 1 : 0;
        return Boolean.valueOf(obj0);
    }

    abstract int a();

    abstract boolean b();

    abstract boolean c();
}
