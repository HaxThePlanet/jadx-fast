package kotlin.i0.z.e.m0.e.a0.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.i0.z.e.m0.e.a0.a.e;
import kotlin.i0.z.e.m0.e.a0.a.e.c;
import kotlin.i0.z.e.m0.e.a0.a.e.c.c;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.k0.l;
import kotlin.w;
import kotlin.y.e0;
import kotlin.y.j0;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public final class g implements c {

    public static final kotlin.i0.z.e.m0.e.a0.b.g.a e;
    private static final String f;
    private static final List<String> g;
    private final a.e a;
    private final String[] b;
    private final Set<Integer> c;
    private final List<a.e.c> d;

    public static final class a {
        public a(g g) {
            super();
        }

        public final List<String> a() {
            return g.c();
        }
    }

    public class b {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[a.e.c.c.NONE.ordinal()] = 1;
            iArr[a.e.c.c.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            iArr[a.e.c.c.DESC_TO_CLASS_ID.ordinal()] = 3;
            g.b.a = iArr;
        }
    }
    static {
        int valueOf;
        String[] strArr;
        g.a aVar = new g.a(0);
        g.e = aVar;
        int i2 = 6;
        Character[] arr = new Character[i2];
        int i14 = 0;
        arr[i14] = 'k';
        int i19 = 1;
        arr[i19] = 'o';
        int i26 = 2;
        arr[i26] = 't';
        final int i53 = 3;
        arr[i53] = 'l';
        final int i54 = 4;
        arr[i54] = 'i';
        final int i55 = 5;
        arr[i55] = 'n';
        String str75 = p.h0(p.j(arr), "", 0, 0, 0, 0, 0, 62, 0);
        g.f = str75;
        strArr = new String[44];
        strArr[i14] = n.o(str75, "/Any");
        strArr[i19] = n.o(str75, "/Nothing");
        strArr[i26] = n.o(str75, "/Unit");
        strArr[i53] = n.o(str75, "/Throwable");
        strArr[i54] = n.o(str75, "/Number");
        strArr[i55] = n.o(str75, "/Byte");
        strArr[i2] = n.o(str75, "/Double");
        strArr[7] = n.o(str75, "/Float");
        strArr[8] = n.o(str75, "/Int");
        strArr[9] = n.o(str75, "/Long");
        int i18 = 10;
        strArr[i18] = n.o(str75, "/Short");
        strArr[11] = n.o(str75, "/Boolean");
        strArr[12] = n.o(str75, "/Char");
        strArr[13] = n.o(str75, "/CharSequence");
        strArr[14] = n.o(str75, "/String");
        strArr[15] = n.o(str75, "/Comparable");
        int i25 = 16;
        strArr[i25] = n.o(str75, "/Enum");
        strArr[17] = n.o(str75, "/Array");
        strArr[18] = n.o(str75, "/ByteArray");
        strArr[19] = n.o(str75, "/DoubleArray");
        strArr[20] = n.o(str75, "/FloatArray");
        strArr[21] = n.o(str75, "/IntArray");
        strArr[22] = n.o(str75, "/LongArray");
        strArr[23] = n.o(str75, "/ShortArray");
        strArr[24] = n.o(str75, "/BooleanArray");
        strArr[25] = n.o(str75, "/CharArray");
        strArr[26] = n.o(str75, "/Cloneable");
        strArr[27] = n.o(str75, "/Annotation");
        strArr[28] = n.o(str75, "/collections/Iterable");
        strArr[29] = n.o(str75, "/collections/MutableIterable");
        strArr[30] = n.o(str75, "/collections/Collection");
        strArr[31] = n.o(str75, "/collections/MutableCollection");
        strArr[32] = n.o(str75, "/collections/List");
        strArr[33] = n.o(str75, "/collections/MutableList");
        strArr[34] = n.o(str75, "/collections/Set");
        strArr[35] = n.o(str75, "/collections/MutableSet");
        strArr[36] = n.o(str75, "/collections/Map");
        strArr[37] = n.o(str75, "/collections/MutableMap");
        strArr[38] = n.o(str75, "/collections/Map.Entry");
        strArr[39] = n.o(str75, "/collections/MutableMap.MutableEntry");
        strArr[40] = n.o(str75, "/collections/Iterator");
        strArr[41] = n.o(str75, "/collections/MutableIterator");
        strArr[42] = n.o(str75, "/collections/ListIterator");
        strArr[43] = n.o(str75, "/collections/MutableListIterator");
        g.g = p.j(strArr);
        Iterable iterable = p.R0(aVar.a());
        LinkedHashMap linkedHashMap = new LinkedHashMap(g.b(j0.d(p.r(iterable, i18)), i25));
        Iterator iterator = iterable.iterator();
        for (e0 next2 : iterator) {
            linkedHashMap.put((String)next2.d(), Integer.valueOf(next2.c()));
        }
    }

    public g(a.e a$e, String[] string2Arr2) {
        int size;
        int i2;
        int i;
        Set obj4;
        String obj5;
        n.f(e, "types");
        n.f(string2Arr2, "strings");
        super();
        this.a = e;
        this.b = string2Arr2;
        obj4 = e.r();
        if (obj4.isEmpty()) {
            obj4 = q0.b();
        } else {
            n.e(obj4, "");
            obj4 = p.P0(obj4);
        }
        this.c = obj4;
        obj4 = new ArrayList();
        obj5 = d().s();
        obj4.ensureCapacity(obj5.size());
        obj5 = obj5.iterator();
        for (a.e.c size : obj5) {
            i = 0;
            while (i < size.z()) {
                obj4.add(size);
                i++;
            }
            obj4.add(size);
            i++;
        }
        obj4.trimToSize();
        obj5 = w.a;
        this.d = obj4;
    }

    public static final List c() {
        return g.g;
    }

    @Override // kotlin.i0.z.e.m0.e.z.c
    public String a(int i) {
        return getString(i);
    }

    @Override // kotlin.i0.z.e.m0.e.z.c
    public boolean b(int i) {
        return this.c.contains(Integer.valueOf(i));
    }

    @Override // kotlin.i0.z.e.m0.e.z.c
    public final a.e d() {
        return this.a;
    }

    @Override // kotlin.i0.z.e.m0.e.z.c
    public String getString(int i) {
        Object substring;
        int intValue5;
        a.e.c.c nONE;
        int length;
        int[] iArr;
        boolean z;
        int intValue4;
        boolean z2;
        int i5;
        int i4;
        Object intValue2;
        String str;
        int intValue;
        String substring2;
        int intValue3;
        int i2;
        int i3;
        int i8;
        int i7;
        int i6;
        final Object obj = this;
        int i9 = i;
        Object obj3 = obj.d.get(i9);
        final int i10 = 0;
        final int i11 = 1;
        if ((a.e.c)obj3.J()) {
            substring = obj3.C();
        } else {
            if (obj3.H()) {
                z2 = g.e;
                i4 = obj3.y();
                if (i4 >= 0 && i4 <= size--) {
                    i5 = i4 <= size-- ? i11 : i10;
                } else {
                }
                if (i5 != 0) {
                    substring = z2.a().get(obj3.y());
                } else {
                    substring = obj.b[i9];
                }
            } else {
            }
        }
        String str3 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
        int i13 = 2;
        final String str4 = "string";
        List list4 = obj3.F();
        n.e(list4, "substringIndexList");
        intValue2 = list4.get(i10);
        intValue4 = list4.get(i11);
        n.e((Integer)intValue2, "begin");
        n.e((Integer)intValue4, "end");
        if (obj3.E() >= i13 && intValue2.intValue() >= 0 && intValue2.intValue() <= intValue4.intValue() && intValue4.intValue() <= substring.length()) {
            list4 = obj3.F();
            n.e(list4, "substringIndexList");
            intValue2 = list4.get(i10);
            intValue4 = list4.get(i11);
            n.e((Integer)intValue2, "begin");
            if (intValue2.intValue() >= 0) {
                n.e((Integer)intValue4, "end");
                if (intValue2.intValue() <= intValue4.intValue()) {
                    if (intValue4.intValue() <= substring.length()) {
                        n.e(substring, str4);
                        n.e(substring.substring(intValue2.intValue(), intValue4.intValue()), str3);
                    }
                }
            }
        }
        str = substring;
        if (obj3.A() >= i13) {
            List list = obj3.B();
            n.e(list, "replaceCharList");
            n.e(str, str4);
            str = l.F(str, (char)intValue4, (char)intValue5, false, 4, 0);
        }
        substring2 = str;
        if (obj3.x() == null) {
            nONE = a.e.c.c.NONE;
        }
        length = g.b.a[nONE.ordinal()];
        if (length != i13) {
            if (length != 3) {
            } else {
                if (substring2.length() >= i13) {
                    n.e(substring2, str4);
                    n.e(substring2.substring(i11, length2 -= i11), str3);
                }
                intValue3 = substring2;
                n.e(intValue3, str4);
                substring2 = l.F(intValue3, '$', '.', false, 4, 0);
            }
        } else {
            n.e(substring2, str4);
            substring2 = l.F(substring2, '$', '.', false, 4, 0);
        }
        n.e(substring2, str4);
        return substring2;
    }
}
