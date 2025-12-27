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

/* compiled from: Options.kt */
/* loaded from: classes3.dex */
public final class t extends b<i> implements RandomAccess {

    public static final t.a v = new t$a(0);
    private final i[] b;
    private final int[] c;

    public static final class a {
        private a() {
            super();
        }

        private final void a(long j, f fVar, int i, List<? extends i> list, int i2, int i3, List<Integer> list2) {
            int intValue;
            int i62;
            byte b2;
            byte b3;
            l.f fVar3;
            int i4 = 0;
            Object item;
            long l2;
            byte b4;
            Object item2;
            int i7 = 0;
            byte b5;
            long l3;
            int list42;
            int i9 = 0;
            i62 = this;
            final l.f i32 = fVar;
            list42 = i;
            final int i52 = list;
            i62 = i2;
            final int list72 = i3;
            fVar = list2;
            int r3 = i62 < list72 ? 1 : 0;
            String str2 = "Failed requirement.";
            if (i4 == 0) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            } else {
                while (i62 < list72) {
                    int r5 = (i)i52.get(i62).A() >= list42 ? 1 : 0;
                    if (i7 == 0) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                item2 = i52.get(list72 - 1);
                intValue = -1;
                if (list42 == (i)list.get(i2).A()) {
                    i62++;
                } else {
                }
                int i30 = 2;
                if (item.j(list42) != item2.j(list42)) {
                    i2 = i62 + 1;
                    i = 1;
                    while (i2 < list72) {
                        i2 = i2 + 1;
                    }
                    l2 = (j + i62.c(i32)) + (long)i30;
                    i = i * 2;
                    l3 = (long)i;
                    l = l2 + l3;
                    i32.G0(i);
                    i32.G0(intValue);
                    while (i62 < list72) {
                        byte b7 = (i)i52.get(i62).j(list42);
                        i62 = i62 + 1;
                    }
                    fVar = new f();
                    while (i62 < list72) {
                        i = i62 + 1;
                        while (i < list72) {
                            if ((i)i52.get(i62).j(list42) != (i)i52.get(i).j(list42)) {
                                break loop_30;
                            }
                        }
                        i62 = list;
                        intValue = -1;
                    }
                    i32.W0(fVar);
                } else {
                    i9 = 0;
                    while (list42 < Math.min(item.A(), item2.A())) {
                        if (item.j(list42) != item2.j(list42)) {
                            break;
                        }
                    }
                    long l10 = (j + i62.c(i32)) + (long)i30 + (long)i9 + 1L;
                    i32.G0(-i9);
                    i32.G0(intValue);
                    int i26 = list42 + i9;
                    while (list42 < "Failed requirement.") {
                        intValue = item.j(list42) & 255;
                        i32.G0(intValue);
                        list42 = list42 + 1;
                    }
                    if (i62 + 1 == list72) {
                        int r1 = "Failed requirement." == (i)i52.get(i62).A() ? 1 : 0;
                        if (i == 0) {
                            throw new IllegalStateException("Check failed.".toString());
                        } else {
                            i32.G0((Number)fVar.get(i62).intValue());
                        }
                    }
                    l.f fVar4 = new f();
                    i32.G0(-(int)(i62.c(fVar4) + l10));
                    this.a(l10, fVar4, i26, list, i62, i3, list2);
                    i32.W0(fVar4);
                }
                return;
            }
        }

        static /* synthetic */ void b(t.a aVar, long j, f fVar, int i, List list, int i2, int i3, List list2, int i4, Object object) {
            List list52;
            int i72;
            List list82;
            i = i4 & 1;
            i = i4 & 1 != 0 ? i : j;
            i72 = 0;
            int r6 = i4 & 4 != 0 ? i72 : i;
            int r8 = i4 & 16 != 0 ? i72 : i2;
            size = i4 & 32;
            int size = i4 & 32 != 0 ? size : i3;
            aVar.a(i, fVar, list52, list, i72, list82, list2);
        }

        private final long c(f fVar) {
            return fVar.size() / (long)4;
        }

        public final t d(i... iVarArr) {
            int _int;
            int length;
            Integer num;
            int intValue = 6;
            Object obj = null;
            int length2;
            Object[] iVarArr2 = iVarArr;
            n.f(iVarArr2, "byteStrings");
            _int = 1;
            _int = 0;
            int r1 = _int;
            final g gVar = null;
            if (iVarArr2.length != 0) {
                return new t(new i[_int], new int[] { 0, -1 }, gVar);
            }
            List list = m.j0(iVarArr);
            v.w(list);
            ArrayList arrayList = new ArrayList(iVarArr2.length);
            while (_int < iVarArr2.length) {
                Object obj4 = iVarArr2[_int];
                arrayList.add(-1);
                _int = _int + 1;
            }
            Object[] array = arrayList.toArray(new Integer[_int]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            length = array.length;
            final List list2 = r.m((Integer[])Arrays.copyOf(array, length));
            length2 = iVarArr2.length;
            for (Object obj3 : iVarArr2) {
                _int = _int + 1;
                _int = 0;
                intValue = 6;
                obj = null;
                list2.set(r.f(list, obj3, _int, i5, intValue, obj), Integer.valueOf(_int));
            }
            int r5 = _int;
            if (_int == 0) {
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            } else {
                while (_int < list.size()) {
                    Object item2 = list.get(_int);
                    _int = _int + 1;
                    while (_int < list.size()) {
                        Object item3 = list.get(_int);
                    }
                    item3 = list.get(_int);
                }
                l.f fVar = new f();
                l.t.a aVar = null;
                t.a.b(this, aVar, fVar, 0, list, 0, 0, list2, 53, null);
                int[] iArr2 = new int[(int)this.c(fVar)];
                while (!fVar.b0()) {
                    aVar = _int + 1;
                    iArr2[_int] = fVar.readInt();
                    _int = aVar;
                }
                Object[] copy2 = Arrays.copyOf(iVarArr2, iVarArr2.length);
                n.e(copy2, "java.util.Arrays.copyOf(this, size)");
                return new t(copy2, iArr2, gVar);
            }
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    public /* synthetic */ t(i[] iVarArr, int[] iArr, g gVar) {
        this(iVarArr, iArr);
    }

    @Override // kotlin.y.b
    public final boolean contains(Object object) {
        if (object instanceof i) {
            return g(object);
        }
        return false;
    }

    @Override // kotlin.y.b
    public int d() {
        return this.b.length;
    }

    @Override // kotlin.y.b
    public boolean g(i iVar) {
        return super.contains(iVar);
    }

    @Override // kotlin.y.b
    public i h(int i) {
        return this.b[i];
    }

    @Override // kotlin.y.b
    public final i[] i() {
        return this.b;
    }

    @Override // kotlin.y.b
    public final int indexOf(Object object) {
        if (object instanceof i) {
            return m(object);
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
            return p(object);
        }
        return -1;
    }

    @Override // kotlin.y.b
    public int m(i iVar) {
        return super.indexOf(iVar);
    }

    @Override // kotlin.y.b
    public int p(i iVar) {
        return super.lastIndexOf(iVar);
    }

    private t(i[] iVarArr, int[] iArr) {
        super();
        this.b = iVarArr;
        this.c = iArr;
    }


    public static final t q(i... iVarArr) {
        return t.v.d(iVarArr);
    }
}
