package kotlin.i0.z.e.m0.d.b;

import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.i;
import kotlin.i0.z.e.m0.i.t.c;
import kotlin.i0.z.e.m0.i.t.d;
import kotlin.k0.l;

/* loaded from: classes3.dex */
final class l implements kotlin.i0.z.e.m0.d.b.k<kotlin.i0.z.e.m0.d.b.j> {

    public static final kotlin.i0.z.e.m0.d.b.l a;

    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[i.BOOLEAN.ordinal()] = 1;
            iArr[i.CHAR.ordinal()] = 2;
            iArr[i.BYTE.ordinal()] = 3;
            iArr[i.SHORT.ordinal()] = 4;
            iArr[i.INT.ordinal()] = 5;
            iArr[i.FLOAT.ordinal()] = 6;
            iArr[i.LONG.ordinal()] = 7;
            iArr[i.DOUBLE.ordinal()] = 8;
            l.a.a = iArr;
        }
    }
    static {
        l lVar = new l();
        l.a = lVar;
    }

    @Override // kotlin.i0.z.e.m0.d.b.k
    public String a(Object object) {
        return l((j)object);
    }

    @Override // kotlin.i0.z.e.m0.d.b.k
    public Object b(String string) {
        return h(string);
    }

    @Override // kotlin.i0.z.e.m0.d.b.k
    public Object c(String string) {
        return i(string);
    }

    @Override // kotlin.i0.z.e.m0.d.b.k
    public Object d(Object object) {
        return g((j)object);
    }

    @Override // kotlin.i0.z.e.m0.d.b.k
    public Object e() {
        return k();
    }

    @Override // kotlin.i0.z.e.m0.d.b.k
    public Object f(i i) {
        return j(i);
    }

    @Override // kotlin.i0.z.e.m0.d.b.k
    public kotlin.i0.z.e.m0.d.b.j g(kotlin.i0.z.e.m0.d.b.j j) {
        boolean str;
        d dVar;
        Object obj3;
        n.f(j, "possiblyPrimitiveType");
        str = j;
        if (j instanceof j.d && (j.d)str.i() != null) {
            str = j;
            if ((j.d)str.i() != null) {
                obj3 = c.c(str.i().getWrapperFqName()).f();
                n.e(obj3, "byFqNameWithoutInnerClasses(possiblyPrimitiveType.jvmPrimitiveType.wrapperFqName).internalName");
                obj3 = i(obj3);
            }
        }
        return obj3;
    }

    @Override // kotlin.i0.z.e.m0.d.b.k
    public kotlin.i0.z.e.m0.d.b.j h(String string) {
        kotlin.i0.z.e.m0.d.b.j cVar;
        String charAt;
        int i3;
        int i;
        int i5;
        int i4;
        d dVar;
        int i2;
        Object obj10;
        n.f(string, "representation");
        int length = string.length();
        cVar = 0;
        charAt = string.charAt(cVar);
        d[] values = d.values();
        i = cVar;
        i5 = 0;
        i4 = 1;
        while (i < values.length) {
            if (values[i].getDesc().charAt(cVar) == charAt) {
            } else {
            }
            i2 = cVar;
            i++;
            i5 = 0;
            i4 = 1;
            i2 = i4;
        }
        dVar = i5;
        if (dVar == null) {
            if (charAt == 86) {
                obj10 = new j.d(i5);
            } else {
                if (charAt == 91) {
                    obj10 = string.substring(i4);
                    n.e(obj10, "(this as java.lang.String).substring(startIndex)");
                    cVar = new j.a(h(obj10));
                } else {
                    if (charAt == 76) {
                        cVar = l.U(string, ';', cVar, 2, i5);
                    }
                    obj10 = string.substring(i4, length2 -= i4);
                    n.e(obj10, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    cVar = new j.c(obj10);
                }
                obj10 = cVar;
            }
            return obj10;
        }
        obj10 = new j.d(dVar);
        return obj10;
    }

    @Override // kotlin.i0.z.e.m0.d.b.k
    public kotlin.i0.z.e.m0.d.b.j.c i(String string) {
        n.f(string, "internalName");
        j.c cVar = new j.c(string);
        return cVar;
    }

    @Override // kotlin.i0.z.e.m0.d.b.k
    public kotlin.i0.z.e.m0.d.b.j j(i i) {
        kotlin.i0.z.e.m0.d.b.j.d obj2;
        n.f(i, "primitiveType");
        switch (obj2) {
            case 1:
                obj2 = j.a.a();
                break;
            case 2:
                obj2 = j.a.c();
                break;
            case 3:
                obj2 = j.a.b();
                break;
            case 4:
                obj2 = j.a.h();
                break;
            case 5:
                obj2 = j.a.f();
                break;
            case 6:
                obj2 = j.a.e();
                break;
            case 7:
                obj2 = j.a.g();
                break;
            case 8:
                obj2 = j.a.d();
                break;
            default:
                obj2 = new NoWhenBranchMatchedException();
                throw obj2;
        }
        return obj2;
    }

    @Override // kotlin.i0.z.e.m0.d.b.k
    public kotlin.i0.z.e.m0.d.b.j k() {
        return i("java/lang/Class");
    }

    @Override // kotlin.i0.z.e.m0.d.b.k
    public String l(kotlin.i0.z.e.m0.d.b.j j) {
        Object stringBuilder;
        int i;
        d obj3;
        n.f(j, "type");
        if (j instanceof j.a) {
            obj3 = n.o("[", l((j.a)j.i()));
            return obj3;
        } else {
            if (j instanceof j.d) {
                obj3 = (j.d)j.i();
                if (obj3 == null) {
                    obj3 = stringBuilder;
                } else {
                }
            } else {
                if (!j instanceof j.c) {
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append('L');
                    stringBuilder.append((j.c)j.i());
                    stringBuilder.append(';');
                    obj3 = stringBuilder.toString();
                }
            }
        }
        obj3 = new NoWhenBranchMatchedException();
        throw obj3;
    }
}
