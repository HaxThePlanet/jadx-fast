package kotlin.i0.z.e.m0.i.t;

import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;

/* loaded from: classes3.dex */
public class c {

    private final String a;
    private c(String string) {
        if (string == null) {
        } else {
            super();
            this.a = string;
        }
        c.a(5);
        throw 0;
    }

    private static void a(int i) {
        String str3;
        int i2;
        String str;
        String str2;
        Object obj10;
        final int i3 = 8;
        final int i4 = 7;
        final int i5 = 6;
        final int i6 = 3;
        if (i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i5) {
                if (i != i4) {
                    str3 = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
                } else {
                }
            } else {
            }
        } else {
        }
        final int i7 = 2;
        if (i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i5) {
                if (i != i4) {
                    i2 = i != i3 ? i6 : i7;
                } else {
                }
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i2];
        str = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
        int i8 = 0;
        switch (i) {
            case 1:
                arr[i8] = "classId";
                break;
            case 2:
                arr[i8] = "fqName";
                break;
            case 3:
                arr[i8] = str;
                break;
            default:
                arr[i8] = "internalName";
        }
        String str4 = "byFqNameWithoutInnerClasses";
        int i9 = 1;
        if (i != i6) {
            if (i != i5) {
                if (i != i4) {
                    if (i != i3) {
                        arr[i9] = str;
                    } else {
                        arr[i9] = "getInternalName";
                    }
                } else {
                    arr[i9] = "getPackageFqName";
                }
            } else {
                arr[i9] = "getFqNameForClassNameWithoutDollars";
            }
        } else {
            arr[i9] = str4;
        }
        switch (i) {
            case 1:
                arr[i7] = "byClassId";
                break;
            case 2:
                arr[i7] = str4;
                break;
            case 4:
                arr[i7] = "<init>";
                break;
            default:
                arr[i7] = "byInternalName";
        }
        String format = String.format(str3, arr);
        if (i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i5) {
                if (i != i4) {
                    if (i != i3) {
                        obj10 = new IllegalArgumentException(format);
                    } else {
                        obj10 = new IllegalStateException(format);
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        throw obj10;
    }

    public static kotlin.i0.z.e.m0.i.t.c b(a a) {
        kotlin.i0.z.e.m0.i.t.c cVar2;
        kotlin.i0.z.e.m0.i.t.c cVar;
        StringBuilder stringBuilder;
        int i;
        String obj5;
        if (a == null) {
        } else {
            b bVar = a.h();
            final int i3 = 46;
            obj5 = a.i().b().replace(i3, '$');
            if (bVar.d()) {
                cVar2 = new c(obj5);
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(bVar.b().replace(i3, '/'));
                stringBuilder.append("/");
                stringBuilder.append(obj5);
                cVar = new c(stringBuilder.toString());
                cVar2 = cVar;
            }
            return cVar2;
        }
        c.a(1);
        throw 0;
    }

    public static kotlin.i0.z.e.m0.i.t.c c(b b) {
        if (b == null) {
        } else {
            c cVar = new c(b.b().replace('.', '/'));
            return cVar;
        }
        c.a(2);
        throw 0;
    }

    public static kotlin.i0.z.e.m0.i.t.c d(String string) {
        if (string == null) {
        } else {
            c cVar = new c(string);
            return cVar;
        }
        c.a(0);
        throw 0;
    }

    public b e() {
        b bVar = new b(this.a.replace('/', '.'));
        return bVar;
    }

    public boolean equals(Object object) {
        Class<kotlin.i0.z.e.m0.i.t.c> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        if (object != null && c.class != object.getClass()) {
            if (c.class != object.getClass()) {
            }
            return this.a.equals(object.a);
        }
        return 0;
    }

    public String f() {
        String str = this.a;
        if (str == null) {
        } else {
            return str;
        }
        c.a(8);
        throw 0;
    }

    public b g() {
        int lastIndexOf = this.a.lastIndexOf("/");
        if (lastIndexOf == -1) {
            b bVar = b.c;
            if (bVar == null) {
            } else {
                return bVar;
            }
            c.a(7);
            throw 0;
        }
        b bVar2 = new b(this.a.substring(0, lastIndexOf).replace('/', '.'));
        return bVar2;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a;
    }
}
