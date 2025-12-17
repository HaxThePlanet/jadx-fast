package kotlin.reflect.jvm.internal.impl.descriptors.h1;

import java.util.Map;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.h.c;
import kotlin.i0.z.e.m0.i.q.g;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* loaded from: classes3.dex */
public class d implements kotlin.reflect.jvm.internal.impl.descriptors.h1.c {

    private final b0 a;
    private final Map<e, g<?>> b;
    private final u0 c;
    public d(b0 b0, Map<e, g<?>> map2, u0 u03) {
        final int i = 0;
        if (b0 == null) {
        } else {
            if (map2 == null) {
            } else {
                if (u03 == null) {
                } else {
                    super();
                    this.a = b0;
                    this.b = map2;
                    this.c = u03;
                }
                d.b(2);
                throw i;
            }
            d.b(1);
            throw i;
        }
        d.b(0);
        throw i;
    }

    private static void b(int i) {
        String str;
        int i2;
        String str2;
        String str3;
        Object obj10;
        final int i3 = 5;
        final int i4 = 4;
        final int i5 = 3;
        if (i != i5 && i != i4 && i != i3) {
            if (i != i4) {
                str = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            } else {
            }
        } else {
        }
        final int i6 = 2;
        if (i != i5 && i != i4 && i != i3) {
            if (i != i4) {
                i2 = i != i3 ? i5 : i6;
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i2];
        str2 = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        final int i7 = 0;
        final int i8 = 1;
        if (i != i8) {
            if (i != i6) {
                if (i != i5 && i != i4 && i != i3) {
                    if (i != i4) {
                        if (i != i3) {
                            arr[i7] = "annotationType";
                        } else {
                            arr[i7] = str2;
                        }
                    } else {
                    }
                } else {
                }
            } else {
                arr[i7] = "source";
            }
        } else {
            arr[i7] = "valueArguments";
        }
        if (i != i5) {
            if (i != i4) {
                if (i != i3) {
                    arr[i8] = str2;
                } else {
                    arr[i8] = "getSource";
                }
            } else {
                arr[i8] = "getAllValueArguments";
            }
        } else {
            arr[i8] = "getType";
        }
        if (i != i5 && i != i4 && i != i3) {
            if (i != i4) {
                if (i != i3) {
                    arr[i6] = "<init>";
                }
            }
        }
        String format = String.format(str, arr);
        if (i != i5 && i != i4 && i != i3) {
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
        throw obj10;
    }

    public Map<e, g<?>> a() {
        Map map = this.b;
        if (map == null) {
        } else {
            return map;
        }
        d.b(4);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    public b d() {
        return c.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    public u0 getSource() {
        u0 u0Var = this.c;
        if (u0Var == null) {
        } else {
            return u0Var;
        }
        d.b(5);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    public b0 getType() {
        b0 b0Var = this.a;
        if (b0Var == null) {
        } else {
            return b0Var;
        }
        d.b(3);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    public String toString() {
        return c.b.s(this, 0);
    }
}
