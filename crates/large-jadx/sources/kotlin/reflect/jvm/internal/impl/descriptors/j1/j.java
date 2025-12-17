package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.h.c;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.m;

/* loaded from: classes3.dex */
public abstract class j extends b implements m {

    private final e b;
    public j(g g, e e2) {
        final int i = 0;
        if (g == null) {
        } else {
            if (e2 == null) {
            } else {
                super(g);
                this.b = e2;
            }
            j.E(1);
            throw i;
        }
        j.E(0);
        throw i;
    }

    private static void E(int i) {
        String str3;
        int i2;
        String str;
        String str2;
        Object obj9;
        final int i3 = 6;
        final int i4 = 5;
        final int i5 = 3;
        final int i6 = 2;
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
        if (i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i5) {
                if (i != i4) {
                    i2 = i != i3 ? i5 : i6;
                } else {
                }
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i2];
        str = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        int i7 = 0;
        switch (i) {
            case 1:
                arr[i7] = "name";
                break;
            case 2:
                arr[i7] = str;
                break;
            case 3:
                arr[i7] = "descriptor";
                break;
            default:
                arr[i7] = "annotations";
        }
        String str4 = "toString";
        int i8 = 1;
        if (i != i6) {
            if (i != i5) {
                if (i != i4 && i != i3) {
                    if (i != i3) {
                        arr[i8] = str;
                    } else {
                        arr[i8] = str4;
                    }
                } else {
                }
            } else {
                arr[i8] = "getOriginal";
            }
        } else {
            arr[i8] = "getName";
        }
        if (i != i6 && i != i5) {
            if (i != i5) {
                if (i != 4) {
                    if (i != i4 && i != i3) {
                        if (i != i3) {
                            arr[i6] = "<init>";
                        }
                    }
                } else {
                    arr[i6] = str4;
                }
            }
        }
        String format = String.format(str3, arr);
        if (i != i6 && i != i5 && i != i4 && i != i3) {
            if (i != i5) {
                if (i != i4) {
                    if (i != i3) {
                        obj9 = new IllegalArgumentException(format);
                    } else {
                        obj9 = new IllegalStateException(format);
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        throw obj9;
    }

    public static String F(m m) {
        final int i = 0;
        if (m == null) {
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(c.c.r(m));
            stringBuilder2.append("[");
            stringBuilder2.append(m.getClass().getSimpleName());
            stringBuilder2.append("@");
            stringBuilder2.append(Integer.toHexString(System.identityHashCode(m)));
            stringBuilder2.append("]");
            String obj3 = stringBuilder2.toString();
            if (obj3 == null) {
            } else {
                return obj3;
            }
            try {
                j.E(5);
                throw i;
                StringBuilder stringBuilder = new StringBuilder();
                Class str = m.getClass();
                str = str.getSimpleName();
                stringBuilder.append(str);
                str = " ";
                stringBuilder.append(str);
                m = m.getName();
                stringBuilder.append(m);
                m = stringBuilder.toString();
                if (m == null) {
                } else {
                }
                return m;
                m = 6;
                j.E(m);
                throw obj0;
                j.E(4);
                throw i;
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.b
    public m a() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.b
    public e getName() {
        e eVar = this.b;
        if (eVar == null) {
        } else {
            return eVar;
        }
        j.E(2);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.b
    public String toString() {
        return j.F(this);
    }
}
