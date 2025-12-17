package kotlin.i0.z.e.m0.f;

/* loaded from: classes3.dex */
public final class e implements Comparable<kotlin.i0.z.e.m0.f.e> {

    private final String a;
    private final boolean b;
    private e(String string, boolean z2) {
        if (string == null) {
        } else {
            super();
            this.a = string;
            this.b = z2;
        }
        e.a(0);
        throw 0;
    }

    private static void a(int i) {
        String str2;
        int i2;
        String str;
        String str3;
        Object obj7;
        final int i3 = 1;
        final int i4 = 2;
        if (i != i3 && i != i4) {
            str2 = i != i4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        } else {
        }
        if (i != i3 && i != i4) {
            i2 = i != i4 ? 3 : i4;
        } else {
        }
        Object[] arr = new Object[i2];
        str = "kotlin/reflect/jvm/internal/impl/name/Name";
        final int i5 = 0;
        if (i != i3 && i != i4) {
            if (i != i4) {
                arr[i5] = "name";
            } else {
                arr[i5] = str;
            }
        } else {
        }
        if (i != i3) {
            if (i != i4) {
                arr[i3] = str;
            } else {
                arr[i3] = "getIdentifier";
            }
        } else {
            arr[i3] = "asString";
        }
        switch (i) {
            case 2:
                arr[i4] = "identifier";
                break;
            case 3:
                arr[i4] = "isValidIdentifier";
                break;
            case 4:
                arr[i4] = "special";
                break;
            case 5:
                arr[i4] = "guessByFirstCharacter";
                break;
            default:
                arr[i4] = "<init>";
        }
        String format = String.format(str2, arr);
        if (i != i3 && i != i4) {
            if (i != i4) {
                obj7 = new IllegalArgumentException(format);
            } else {
                obj7 = new IllegalStateException(format);
            }
        } else {
        }
        throw obj7;
    }

    public static kotlin.i0.z.e.m0.f.e i(String string) {
        if (string == null) {
        } else {
            if (string.startsWith("<")) {
                return e.n(string);
            }
            return e.j(string);
        }
        e.a(6);
        throw 0;
    }

    public static kotlin.i0.z.e.m0.f.e j(String string) {
        if (string == null) {
        } else {
            e eVar = new e(string, 0);
            return eVar;
        }
        e.a(3);
        throw 0;
    }

    public static boolean m(String string) {
        int i;
        boolean startsWith;
        char charAt;
        int i2;
        if (string == null) {
        } else {
            final int i3 = 0;
            if (!string.isEmpty()) {
                if (string.startsWith("<")) {
                } else {
                    i = i3;
                    while (i < string.length()) {
                        charAt = string.charAt(i);
                        i++;
                    }
                }
                return 1;
            }
            return i3;
        }
        e.a(4);
        throw 0;
    }

    public static kotlin.i0.z.e.m0.f.e n(String string) {
        if (string == null) {
        } else {
            if (!string.startsWith("<")) {
            } else {
                e eVar = new e(string, 1);
                return eVar;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("special name must start with '<': ");
            stringBuilder.append(string);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        e.a(5);
        throw 0;
    }

    @Override // java.lang.Comparable
    public String c() {
        String str = this.a;
        if (str == null) {
        } else {
            return str;
        }
        e.a(1);
        throw 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return e((e)object);
    }

    @Override // java.lang.Comparable
    public int e(kotlin.i0.z.e.m0.f.e e) {
        return this.a.compareTo(e.a);
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof e) {
            return i2;
        }
        if (this.b != object.b) {
            return i2;
        }
        if (!this.a.equals(object.a)) {
            return i2;
        }
        return i;
    }

    @Override // java.lang.Comparable
    public String f() {
        if (this.b) {
        } else {
            String str = c();
            if (str == null) {
            } else {
                return str;
            }
            e.a(2);
            throw 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("not identifier: ");
        stringBuilder.append(this);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return i2 += z;
    }

    @Override // java.lang.Comparable
    public boolean k() {
        return this.b;
    }

    @Override // java.lang.Comparable
    public String toString() {
        return this.a;
    }
}
