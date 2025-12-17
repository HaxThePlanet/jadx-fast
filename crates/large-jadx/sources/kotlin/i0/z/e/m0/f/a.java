package kotlin.i0.z.e.m0.f;

import kotlin.k0.l;

/* loaded from: classes3.dex */
public final class a {

    private final kotlin.i0.z.e.m0.f.b a;
    private final kotlin.i0.z.e.m0.f.b b;
    private final boolean c;
    static {
    }

    public a(kotlin.i0.z.e.m0.f.b b, kotlin.i0.z.e.m0.f.b b2, boolean z3) {
        final int i = 0;
        if (b == null) {
        } else {
            if (b2 == null) {
            } else {
                super();
                this.a = b;
                this.b = b2;
                this.c = z3;
            }
            a.a(2);
            throw i;
        }
        a.a(1);
        throw i;
    }

    public a(kotlin.i0.z.e.m0.f.b b, kotlin.i0.z.e.m0.f.e e2) {
        int i = 0;
        if (b == null) {
        } else {
            if (e2 == null) {
            } else {
                super(b, b.k(e2), 0);
            }
            a.a(4);
            throw i;
        }
        a.a(3);
        throw i;
    }

    private static void a(int i) {
        String str3;
        int i2;
        String str;
        String str2;
        Object obj12;
        final int i3 = 14;
        final int i4 = 13;
        final int i5 = 9;
        final int i6 = 7;
        final int i7 = 6;
        final int i8 = 5;
        if (i != i8 && i != i7 && i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i7) {
                if (i != i6) {
                    if (i != i5) {
                        if (i != i4) {
                            str3 = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
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
        final int i9 = 2;
        if (i != i8 && i != i7 && i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i7) {
                if (i != i6) {
                    if (i != i5) {
                        if (i != i4) {
                            i2 = i != i3 ? 3 : i9;
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
        Object[] arr = new Object[i2];
        str = "kotlin/reflect/jvm/internal/impl/name/ClassId";
        int i10 = 0;
        switch (i) {
            case 1:
                arr[i10] = "packageFqName";
                break;
            case 2:
                arr[i10] = "relativeClassName";
                break;
            case 3:
                arr[i10] = "topLevelName";
                break;
            case 4:
                arr[i10] = str;
                break;
            case 5:
                arr[i10] = "name";
                break;
            case 6:
                arr[i10] = "segment";
                break;
            case 7:
                arr[i10] = "string";
                break;
            default:
                arr[i10] = "topLevelFqName";
        }
        int i11 = 1;
        if (i != i8) {
            if (i != i7) {
                if (i != i6) {
                    if (i != i5) {
                        if (i != i4 && i != i3) {
                            if (i != i3) {
                                arr[i11] = str;
                            } else {
                                arr[i11] = "asString";
                            }
                        } else {
                        }
                    } else {
                        arr[i11] = "asSingleFqName";
                    }
                } else {
                    arr[i11] = "getShortClassName";
                }
            } else {
                arr[i11] = "getRelativeClassName";
            }
        } else {
            arr[i11] = "getPackageFqName";
        }
        switch (i) {
            case 1:
                arr[i9] = "<init>";
                break;
            case 3:
                arr[i9] = "createNestedClassId";
                break;
            case 4:
                arr[i9] = "startsWith";
                break;
            case 5:
                arr[i9] = "fromString";
                break;
            default:
                arr[i9] = "topLevel";
        }
        String format = String.format(str3, arr);
        if (i != i8 && i != i7 && i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i7) {
                if (i != i6) {
                    if (i != i5) {
                        if (i != i4) {
                            if (i != i3) {
                                obj12 = new IllegalArgumentException(format);
                            } else {
                                obj12 = new IllegalStateException(format);
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
        throw obj12;
    }

    public static kotlin.i0.z.e.m0.f.a e(String string) {
        if (string == null) {
        } else {
            return a.f(string, false);
        }
        a.a(11);
        throw 0;
    }

    public static kotlin.i0.z.e.m0.f.a f(String string, boolean z2) {
        if (string == null) {
        } else {
            int i = 47;
            b bVar2 = new b(l.Y0(string, i, "").replace(i, '.'));
            b bVar = new b(l.Q0(string, i, string));
            a aVar = new a(bVar2, bVar, z2);
            return aVar;
        }
        a.a(12);
        throw 0;
    }

    public static kotlin.i0.z.e.m0.f.a m(kotlin.i0.z.e.m0.f.b b) {
        if (b == null) {
        } else {
            a aVar = new a(b.e(), b.g());
            return aVar;
        }
        a.a(0);
        throw 0;
    }

    public kotlin.i0.z.e.m0.f.b b() {
        if (this.a.d()) {
            kotlin.i0.z.e.m0.f.b bVar2 = this.b;
            if (bVar2 == null) {
            } else {
                return bVar2;
            }
            a.a(9);
            throw 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.b());
        stringBuilder.append(".");
        stringBuilder.append(this.b.b());
        b bVar3 = new b(stringBuilder.toString());
        return bVar3;
    }

    public String c() {
        final int i3 = 0;
        if (this.a.d()) {
            String str = this.b.b();
            if (str == null) {
            } else {
                return str;
            }
            a.a(13);
            throw i3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.b().replace('.', '/'));
        stringBuilder.append("/");
        stringBuilder.append(this.b.b());
        String string = stringBuilder.toString();
        if (string == null) {
        } else {
            return string;
        }
        a.a(14);
        throw i3;
    }

    public kotlin.i0.z.e.m0.f.a d(kotlin.i0.z.e.m0.f.e e) {
        if (e == null) {
        } else {
            a aVar = new a(h(), this.b.c(e), this.c);
            return aVar;
        }
        a.a(8);
        throw 0;
    }

    public boolean equals(Object object) {
        int i;
        boolean equals;
        Class<kotlin.i0.z.e.m0.f.a> obj;
        kotlin.i0.z.e.m0.f.b bVar;
        Class class;
        boolean obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (a.class != object.getClass()) {
            } else {
                if (this.a.equals(object.a) && this.b.equals(object.b) && this.c == object.c) {
                    if (this.b.equals(object.b)) {
                        if (this.c == object.c) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    public kotlin.i0.z.e.m0.f.a g() {
        int i;
        boolean aVar;
        kotlin.i0.z.e.m0.f.b bVar;
        boolean z;
        kotlin.i0.z.e.m0.f.b bVar3 = this.b.e();
        if (bVar3.d()) {
            i = 0;
        } else {
            aVar = new a(h(), bVar3, this.c);
            i = aVar;
        }
        return i;
    }

    public kotlin.i0.z.e.m0.f.b h() {
        kotlin.i0.z.e.m0.f.b bVar = this.a;
        if (bVar == null) {
        } else {
            return bVar;
        }
        a.a(5);
        throw 0;
    }

    public int hashCode() {
        return i4 += i7;
    }

    public kotlin.i0.z.e.m0.f.b i() {
        kotlin.i0.z.e.m0.f.b bVar = this.b;
        if (bVar == null) {
        } else {
            return bVar;
        }
        a.a(6);
        throw 0;
    }

    public kotlin.i0.z.e.m0.f.e j() {
        kotlin.i0.z.e.m0.f.e eVar = this.b.g();
        if (eVar == null) {
        } else {
            return eVar;
        }
        a.a(7);
        throw 0;
    }

    public boolean k() {
        return this.c;
    }

    public boolean l() {
        return z ^= 1;
    }

    public String toString() {
        String string;
        String str;
        if (this.a.d()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("/");
            stringBuilder.append(c());
            string = stringBuilder.toString();
        } else {
            string = c();
        }
        return string;
    }
}
