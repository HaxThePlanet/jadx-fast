package com.google.common.base;

import java.util.Objects;

/* loaded from: classes2.dex */
public final class n {
    private static String a(int i, int i2, String string3) {
        int i3 = 1;
        final int i4 = 0;
        final int i5 = 2;
        if (i < 0) {
            Object[] obj5 = new Object[i5];
            obj5[i4] = string3;
            obj5[i3] = Integer.valueOf(i);
            return r.c("%s (%s) must not be negative", obj5);
        }
        if (i2 < 0) {
        } else {
            Object[] arr = new Object[3];
            arr[i4] = string3;
            arr[i3] = Integer.valueOf(i);
            arr[i5] = Integer.valueOf(i2);
            return r.c("%s (%s) must be less than size (%s)", arr);
        }
        StringBuilder stringBuilder = new StringBuilder(26);
        stringBuilder.append("negative size: ");
        stringBuilder.append(i2);
        IllegalArgumentException obj4 = new IllegalArgumentException(stringBuilder.toString());
        throw obj4;
    }

    private static String b(int i, int i2, String string3) {
        int i3 = 1;
        final int i4 = 0;
        final int i5 = 2;
        if (i < 0) {
            Object[] obj5 = new Object[i5];
            obj5[i4] = string3;
            obj5[i3] = Integer.valueOf(i);
            return r.c("%s (%s) must not be negative", obj5);
        }
        if (i2 < 0) {
        } else {
            Object[] arr = new Object[3];
            arr[i4] = string3;
            arr[i3] = Integer.valueOf(i);
            arr[i5] = Integer.valueOf(i2);
            return r.c("%s (%s) must not be greater than size (%s)", arr);
        }
        StringBuilder stringBuilder = new StringBuilder(26);
        stringBuilder.append("negative size: ");
        stringBuilder.append(i2);
        IllegalArgumentException obj4 = new IllegalArgumentException(stringBuilder.toString());
        throw obj4;
    }

    private static String c(int i, int i2, int i3) {
        if (i >= 0) {
            if (i > i3) {
            } else {
                if (i2 >= 0 && i2 > i3) {
                    if (i2 > i3) {
                    }
                    Object[] obj3 = new Object[2];
                    return r.c("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
                }
            }
            return n.b(i2, i3, "end index");
        }
        return n.b(i, i3, "start index");
    }

    public static void d(boolean z) {
        if (!z) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException();
        throw obj0;
    }

    public static void e(boolean z, Object object2) {
        if (!z) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException(String.valueOf(object2));
        throw obj0;
    }

    public static void f(boolean z, String string2, char c3) {
        if (!z) {
        } else {
        }
        Object[] arr = new Object[1];
        IllegalArgumentException obj2 = new IllegalArgumentException(r.c(string2, Character.valueOf(c3)));
        throw obj2;
    }

    public static void g(boolean z, String string2, char c3, Object object4) {
        if (!z) {
        } else {
        }
        Object[] arr = new Object[2];
        IllegalArgumentException obj2 = new IllegalArgumentException(r.c(string2, Character.valueOf(c3), object4));
        throw obj2;
    }

    public static void h(boolean z, String string2, int i3) {
        if (!z) {
        } else {
        }
        Object[] arr = new Object[1];
        IllegalArgumentException obj2 = new IllegalArgumentException(r.c(string2, Integer.valueOf(i3)));
        throw obj2;
    }

    public static void i(boolean z, String string2, int i3, int i4) {
        if (!z) {
        } else {
        }
        Object[] arr = new Object[2];
        IllegalArgumentException obj2 = new IllegalArgumentException(r.c(string2, Integer.valueOf(i3), Integer.valueOf(i4)));
        throw obj2;
    }

    public static void j(boolean z, String string2, long l3) {
        if (!z) {
        } else {
        }
        Object[] arr = new Object[1];
        IllegalArgumentException obj2 = new IllegalArgumentException(r.c(string2, Long.valueOf(l3)));
        throw obj2;
    }

    public static void k(boolean z, String string2, Object object3) {
        if (!z) {
        } else {
        }
        Object[] arr = new Object[1];
        IllegalArgumentException obj2 = new IllegalArgumentException(r.c(string2, object3));
        throw obj2;
    }

    public static void l(boolean z, String string2, Object object3, Object object4) {
        if (!z) {
        } else {
        }
        Object[] arr = new Object[2];
        IllegalArgumentException obj2 = new IllegalArgumentException(r.c(string2, object3, object4));
        throw obj2;
    }

    public static int m(int i, int i2) {
        n.n(i, i2, "index");
        return i;
    }

    public static int n(int i, int i2, String string3) {
        if (i < 0) {
        } else {
            if (i >= i2) {
            } else {
                return i;
            }
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(n.a(i, i2, string3));
        throw indexOutOfBoundsException;
    }

    public static <T> T o(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static <T> T p(T t, Object object2) {
        if (t == 0) {
        } else {
            return t;
        }
        NullPointerException obj0 = new NullPointerException(String.valueOf(object2));
        throw obj0;
    }

    public static <T> T q(T t, String string2, Object object3) {
        if (t == 0) {
        } else {
            return t;
        }
        Object[] arr = new Object[1];
        NullPointerException obj2 = new NullPointerException(r.c(string2, object3));
        throw obj2;
    }

    public static int r(int i, int i2) {
        n.s(i, i2, "index");
        return i;
    }

    public static int s(int i, int i2, String string3) {
        if (i < 0) {
        } else {
            if (i > i2) {
            } else {
                return i;
            }
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(n.b(i, i2, string3));
        throw indexOutOfBoundsException;
    }

    public static void t(int i, int i2, int i3) {
        if (i < 0) {
        } else {
            if (i2 < i) {
            } else {
                if (i2 > i3) {
                } else {
                }
            }
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(n.c(i, i2, i3));
        throw indexOutOfBoundsException;
    }

    public static void u(boolean z) {
        if (!z) {
        } else {
        }
        IllegalStateException obj0 = new IllegalStateException();
        throw obj0;
    }

    public static void v(boolean z, Object object2) {
        if (!z) {
        } else {
        }
        IllegalStateException obj0 = new IllegalStateException(String.valueOf(object2));
        throw obj0;
    }

    public static void w(boolean z, String string2, int i3) {
        if (!z) {
        } else {
        }
        Object[] arr = new Object[1];
        IllegalStateException obj2 = new IllegalStateException(r.c(string2, Integer.valueOf(i3)));
        throw obj2;
    }

    public static void x(boolean z, String string2, Object object3) {
        if (!z) {
        } else {
        }
        Object[] arr = new Object[1];
        IllegalStateException obj2 = new IllegalStateException(r.c(string2, object3));
        throw obj2;
    }
}
