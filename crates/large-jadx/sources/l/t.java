package l;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.a;
import kotlin.y.b;
import kotlin.y.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class t extends b<l.i> implements RandomAccess {

    public static final l.t.a v;
    private final l.i[] b;
    private final int[] c;

    public static final class a {
        public a(g g) {
            super();
        }

        private final void a(long l, l.f f2, int i3, List<? extends l.i> list4, int i5, int i6, List<Integer> list7) {
            int i7;
            int intValue;
            byte b2;
            int i2;
            int i11;
            byte b;
            int i14;
            int i13;
            int i12;
            Object obj2;
            Object obj;
            int i4;
            int i;
            byte b3;
            int i10;
            long l3;
            l.f fVar4;
            int fVar;
            l.f fVar3;
            int i9;
            l.f fVar2;
            int i8;
            long l2;
            final int i38 = this;
            final l.f fVar5 = i3;
            fVar = list4;
            final int i39 = i5;
            int i15 = i6;
            final int i40 = list7;
            final l.f fVar6 = obj27;
            i13 = i15 < i40 ? 1 : 0;
            String str2 = "Failed requirement.";
            if (i13 == 0) {
            } else {
                i12 = i15;
                while (i12 < i40) {
                    if ((i)i39.get(i12).A() >= fVar) {
                    } else {
                    }
                    i4 = 0;
                    i12++;
                    i4 = 1;
                }
                obj = i39.get(i40 + -1);
                if (fVar == (i)i5.get(i6).A()) {
                    i15++;
                    i10 = i23;
                    i7 = intValue2;
                    obj2 = i;
                } else {
                    i10 = i15;
                    i7 = i9;
                }
                fVar4 = 2;
                if (obj2.j(fVar) != (i)obj.j(fVar)) {
                    i11 = i10 + 1;
                    i14 = 1;
                    while (i11 < i40) {
                        if ((i)i39.get(i11 + -1).j(fVar) != (i)i39.get(i11).j(fVar)) {
                        }
                        i11++;
                        i14++;
                    }
                    i8 = obj2 + l3;
                    fVar5.G0(i14);
                    fVar5.G0(i7);
                    intValue = i10;
                    while (intValue < i40) {
                        i2 = (i)i39.get(intValue).j(fVar);
                        if (intValue != i10) {
                        } else {
                        }
                        fVar5.G0(i2 &= 255);
                        intValue++;
                        if (i2 != (i)i39.get(intValue + -1).j(fVar)) {
                        }
                    }
                    fVar4 = new f();
                    while (i10 < i40) {
                        i2 = i10 + 1;
                        i14 = i2;
                        while (i14 < i40) {
                            i14++;
                        }
                        l3 = i40;
                        if (i2 == l3 && fVar + 1 == (i)i39.get(i10).A()) {
                        } else {
                        }
                        fVar5.G0(i17 *= i9);
                        l2 = l3;
                        fVar2 = fVar4;
                        this.a(i8, i14, fVar4, fVar + 1, i5, i10, l3);
                        fVar4 = fVar2;
                        i10 = l2;
                        i9 = -1;
                        if (fVar + 1 == (i)i39.get(i10).A()) {
                        } else {
                        }
                        fVar5.G0((Number)fVar6.get(i10).intValue());
                        l2 = l3;
                        fVar2 = fVar4;
                        if ((i)i39.get(i10).j(fVar) != (i)i39.get(i14).j(fVar)) {
                        } else {
                        }
                        i14++;
                        l3 = i14;
                    }
                    fVar5.W0(fVar4);
                } else {
                    l3 = fVar;
                    fVar3 = 0;
                    while (l3 < Math.min(obj2.A(), obj.A())) {
                        if (obj2.j(l3) == obj.j(l3)) {
                        }
                        fVar3++;
                        l3++;
                    }
                    i26 += i32;
                    fVar5.G0(-fVar3);
                    fVar5.G0(i7);
                    obj = fVar + fVar3;
                    while (fVar < obj) {
                        fVar5.G0(b4 &= 255);
                        fVar++;
                    }
                    if (i10 + 1 == i40) {
                        i2 = obj == (i)i39.get(i10).A() ? 1 : 0;
                        if (i2 == 0) {
                        } else {
                            fVar5.G0((Number)fVar6.get(i10).intValue());
                        }
                        IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
                        throw illegalStateException;
                    }
                    fVar = new f();
                    fVar5.G0(i21 *= i30);
                    this.a(i2, i14, fVar, obj, i5, i10, list7);
                    fVar5.W0(fVar);
                }
            }
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(str2.toString());
            throw illegalArgumentException2;
        }

        static void b(l.t.a t$a, long l2, l.f f3, int i4, List list5, int i6, int i7, List list8, int i9, Object object10) {
            int i2;
            int size;
            int i5;
            int i3;
            int i8;
            int i;
            i5 = object10 & 1 != 0 ? i2 : l2;
            final int i12 = 0;
            i3 = object10 & 4 != 0 ? i12 : list5;
            i8 = object10 & 16 != 0 ? i12 : i7;
            if (object10 & 32 != 0) {
                i = size;
            } else {
                i = list8;
            }
            a.a(i5, obj4, i4, i3, i6, i8, i);
        }

        private final long c(l.f f) {
            return size /= l;
        }

        public final l.t d(l.i... iArr) {
            int i;
            int i5;
            Object[] copyOf;
            int i9;
            int i6;
            int valueOf2;
            int i7;
            int int;
            Integer valueOf;
            int intValue;
            int intValue2;
            int i4;
            int length;
            int i2;
            int i3;
            int i8;
            Object obj2 = iArr;
            n.f(obj2, "byteStrings");
            int i10 = 1;
            i5 = 0;
            i = obj2.length == 0 ? i10 : i5;
            final int i12 = 0;
            if (i != 0) {
                int[] iArr2 = new int[2];
                iArr2 = new int[]{0, -1};
                t tVar = new t(new i[i5], iArr2, i12);
                return tVar;
            }
            List list = i.j0(iArr);
            p.w(list);
            ArrayList arrayList = new ArrayList(obj2.length);
            int = i5;
            while (int < obj2.length) {
                Object obj8 = obj2[int];
                arrayList.add(-1);
                int++;
            }
            Object[] array = arrayList.toArray(new Integer[i5]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            final List list4 = p.m((Integer[])Arrays.copyOf((Integer[])array, array.length));
            i3 = i2;
            while (i2 < obj2.length) {
                list4.set(p.f(list, obj2[i2], 0, 0, 6, 0), Integer.valueOf(i3));
                i2++;
                i3 = i8;
            }
            i9 = (i)list.get(i5).A() > 0 ? i10 : i5;
            if (i9 == 0) {
            } else {
                i6 = i5;
                while (i6 < list.size()) {
                    valueOf2 = list.get(i6);
                    int = i6 + 1;
                    valueOf = int;
                    while (valueOf < list.size()) {
                        intValue = list.get(valueOf);
                        if (intValue.A() != valueOf2.A()) {
                        } else {
                        }
                        i4 = i5;
                        if ((Number)list4.get(valueOf).intValue() > (Number)list4.get(i6).intValue()) {
                        } else {
                        }
                        valueOf++;
                        list.remove(valueOf);
                        list4.remove(valueOf);
                        i4 = i10;
                    }
                    i6 = int;
                    intValue = list.get(valueOf);
                    if (intValue.A() != valueOf2.A()) {
                    } else {
                    }
                    i4 = i5;
                    if ((Number)list4.get(valueOf).intValue() > (Number)list4.get(i6).intValue()) {
                    } else {
                    }
                    valueOf++;
                    list.remove(valueOf);
                    list4.remove(valueOf);
                    i4 = i10;
                }
                f fVar = new f();
                t.a.b(this, 0, int, fVar, 0, list, 0, 0, list4, 53);
                int[] iArr3 = new int[(int)l];
                while (!fVar.b0()) {
                    iArr3[i5] = fVar.readInt();
                    i5 = i7;
                }
                Object[] copyOf2 = Arrays.copyOf(obj2, obj2.length);
                n.e(copyOf2, "java.util.Arrays.copyOf(this, size)");
                t tVar2 = new t((i[])copyOf2, iArr3, i12);
                return tVar2;
            }
            Object obj3 = this;
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("the empty byte string is not a supported option".toString());
            throw illegalArgumentException;
        }
    }
    static {
        t.a aVar = new t.a(0);
        t.v = aVar;
    }

    private t(l.i[] iArr, int[] i2Arr2) {
        super();
        this.b = iArr;
        this.c = i2Arr2;
    }

    public t(l.i[] iArr, int[] i2Arr2, g g3) {
        super(iArr, i2Arr2);
    }

    public static final l.t q(l.i... iArr) {
        return t.v.d(iArr);
    }

    @Override // kotlin.y.b
    public final boolean contains(Object object) {
        if (object instanceof i) {
            return g((i)object);
        }
        return 0;
    }

    @Override // kotlin.y.b
    public int d() {
        return objArr.length;
    }

    @Override // kotlin.y.b
    public boolean g(l.i i) {
        return super.contains(i);
    }

    @Override // kotlin.y.b
    public Object get(int i) {
        return h(i);
    }

    @Override // kotlin.y.b
    public l.i h(int i) {
        return this.b[i];
    }

    @Override // kotlin.y.b
    public final l.i[] i() {
        return this.b;
    }

    @Override // kotlin.y.b
    public final int indexOf(Object object) {
        if (object instanceof i) {
            return m((i)object);
        }
        return -1;
    }

    @Override // kotlin.y.b
    public final int[] l() {
        return this.c;
    }

    @Override // kotlin.y.b
    public final int lastIndexOf(Object object) {
        if (object instanceof i) {
            return p((i)object);
        }
        return -1;
    }

    @Override // kotlin.y.b
    public int m(l.i i) {
        return super.indexOf(i);
    }

    @Override // kotlin.y.b
    public int p(l.i i) {
        return super.lastIndexOf(i);
    }
}
