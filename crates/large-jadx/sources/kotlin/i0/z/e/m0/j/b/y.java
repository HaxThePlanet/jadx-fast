package kotlin.i0.z.e.m0.j.b;

import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.c.c;
import kotlin.i0.z.e.m0.e.k;
import kotlin.i0.z.e.m0.e.q.b.c;
import kotlin.i0.z.e.m0.e.s.c;
import kotlin.i0.z.e.m0.e.x;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.z;

/* loaded from: classes3.dex */
public final class y {

    public static final kotlin.i0.z.e.m0.j.b.y a;

    public class a {

        public static final int[] a;
        public static final int[] b;
        public static final int[] c;
        public static final int[] d;
        static {
            int[] iArr = new int[values.length];
            final int i = 1;
            iArr[k.FINAL.ordinal()] = i;
            final int i2 = 2;
            iArr[k.OPEN.ordinal()] = i2;
            final int i3 = 3;
            iArr[k.ABSTRACT.ordinal()] = i3;
            final int i4 = 4;
            iArr[k.SEALED.ordinal()] = i4;
            y.a.a = iArr;
            int[] iArr2 = new int[values2.length];
            iArr2[z.FINAL.ordinal()] = i;
            iArr2[z.OPEN.ordinal()] = i2;
            iArr2[z.ABSTRACT.ordinal()] = i3;
            iArr2[z.SEALED.ordinal()] = i4;
            int[] iArr3 = new int[values3.length];
            iArr3[x.INTERNAL.ordinal()] = i;
            iArr3[x.PRIVATE.ordinal()] = i2;
            iArr3[x.PRIVATE_TO_THIS.ordinal()] = i3;
            iArr3[x.PROTECTED.ordinal()] = i4;
            final int i5 = 5;
            iArr3[x.PUBLIC.ordinal()] = i5;
            final int i6 = 6;
            iArr3[x.LOCAL.ordinal()] = i6;
            int[] iArr4 = new int[values4.length];
            iArr4[c.c.CLASS.ordinal()] = i;
            iArr4[c.c.INTERFACE.ordinal()] = i2;
            iArr4[c.c.ENUM_CLASS.ordinal()] = i3;
            iArr4[c.c.ENUM_ENTRY.ordinal()] = i4;
            iArr4[c.c.ANNOTATION_CLASS.ordinal()] = i5;
            iArr4[c.c.OBJECT.ordinal()] = i6;
            iArr4[c.c.COMPANION_OBJECT.ordinal()] = 7;
            y.a.b = iArr4;
            int[] iArr5 = new int[values5.length];
            iArr5[f.CLASS.ordinal()] = i;
            iArr5[f.INTERFACE.ordinal()] = i2;
            iArr5[f.ENUM_CLASS.ordinal()] = i3;
            iArr5[f.ENUM_ENTRY.ordinal()] = i4;
            iArr5[f.ANNOTATION_CLASS.ordinal()] = i5;
            iArr5[f.OBJECT.ordinal()] = i6;
            int[] iArr6 = new int[values6.length];
            iArr6[s.c.IN.ordinal()] = i;
            iArr6[s.c.OUT.ordinal()] = i2;
            iArr6[s.c.INV.ordinal()] = i3;
            y.a.c = iArr6;
            int[] iArr7 = new int[values7.length];
            iArr7[q.b.c.IN.ordinal()] = i;
            iArr7[q.b.c.OUT.ordinal()] = i2;
            iArr7[q.b.c.INV.ordinal()] = i3;
            iArr7[q.b.c.STAR.ordinal()] = i4;
            y.a.d = iArr7;
            int[] iArr8 = new int[values8.length];
            iArr8[h1.IN_VARIANCE.ordinal()] = i;
            iArr8[h1.OUT_VARIANCE.ordinal()] = i2;
            iArr8[h1.INVARIANT.ordinal()] = i3;
        }
    }
    static {
        y yVar = new y();
        y.a = yVar;
    }

    public final f a(c.c c$c) {
        int[] iArr;
        int obj2;
        if (c == null) {
            obj2 = -1;
        } else {
            obj2 = y.a.b[c.ordinal()];
        }
        switch (obj2) {
            case 1:
                obj2 = f.CLASS;
                break;
            case 2:
                obj2 = f.INTERFACE;
                break;
            case 3:
                obj2 = f.ENUM_CLASS;
                break;
            case 4:
                obj2 = f.ENUM_ENTRY;
                break;
            case 5:
                obj2 = f.ANNOTATION_CLASS;
                break;
            case 6:
                obj2 = f.OBJECT;
                break;
            default:
                obj2 = f.CLASS;
        }
        return obj2;
    }

    public final z b(k k) {
        int[] iArr;
        int i;
        int obj2;
        if (k == null) {
            obj2 = -1;
        } else {
            obj2 = y.a.a[k.ordinal()];
        }
        if (obj2 != 1) {
            if (obj2 != 2) {
                if (obj2 != 3) {
                    obj2 = obj2 != 4 ? z.FINAL : z.SEALED;
                } else {
                    obj2 = z.ABSTRACT;
                }
            } else {
                obj2 = z.OPEN;
            }
        } else {
            obj2 = z.FINAL;
        }
        return obj2;
    }

    public final h1 c(q.b.c q$b$c) {
        int i;
        h1 obj3;
        n.f(c, "projection");
        int i2 = y.a.d[c.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3 && i2 != 4) {
                    if (i2 != 4) {
                        obj3 = new NoWhenBranchMatchedException();
                        throw obj3;
                    }
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(n.o("Only IN, OUT and INV are supported. Actual argument: ", c));
                    throw illegalArgumentException;
                }
                obj3 = h1.INVARIANT;
            } else {
                obj3 = h1.OUT_VARIANCE;
            }
        } else {
            obj3 = h1.IN_VARIANCE;
        }
        return obj3;
    }

    public final h1 d(s.c s$c) {
        int i;
        h1 obj2;
        n.f(c, "variance");
        obj2 = y.a.c[c.ordinal()];
        if (obj2 != 1) {
            if (obj2 != 2) {
                if (obj2 != 3) {
                } else {
                    obj2 = h1.INVARIANT;
                }
                obj2 = new NoWhenBranchMatchedException();
                throw obj2;
            }
            obj2 = h1.OUT_VARIANCE;
        } else {
            obj2 = h1.IN_VARIANCE;
        }
        return obj2;
    }
}
