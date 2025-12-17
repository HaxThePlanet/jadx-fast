package com.google.android.exoplayer2.n2;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.a2;
import com.google.android.exoplayer2.b2;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.source.k0;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.source.y.a;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.n;
import com.google.common.collect.p0;
import com.google.common.collect.v;
import f.c.c.b.b;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class f extends com.google.android.exoplayer2.n2.i {

    private static final int[] d;
    private static final p0<Integer> e;
    private static final p0<Integer> f;
    private final com.google.android.exoplayer2.n2.g.b b;
    private final AtomicReference<com.google.android.exoplayer2.n2.f.d> c;

    static class a {
    }

    protected static final class b implements Comparable<com.google.android.exoplayer2.n2.f.b> {

        private final int A = 0;
        private final boolean B = false;
        private final int C = 0;
        private final int D;
        private final int E;
        private final int F = 0;
        public final boolean a = false;
        private final String b;
        private final com.google.android.exoplayer2.n2.f.d c;
        private final boolean v;
        private final int w = 0;
        private final int x = Integer.MAX_VALUE;
        private final int y;
        private final int z = Integer.MAX_VALUE;
        public b(i1 i1, com.google.android.exoplayer2.n2.f.d f$d2, int i3) {
            int i6;
            int i8;
            int i7;
            int i4;
            int i2;
            int i;
            int i5;
            int obj9;
            super();
            this.c = d2;
            this.b = f.x(i1.c);
            i6 = 0;
            this.v = f.r(i3, i6);
            obj9 = i6;
            i2 = Integer.MAX_VALUE;
            while (obj9 < d2.E.size()) {
                obj9++;
                i2 = Integer.MAX_VALUE;
            }
            int i9 = i6;
            obj9 = i2;
            this.y = Integer.bitCount(obj9 &= i10);
            int i11 = 1;
            if (obj9 &= i11 != 0) {
                obj9 = i11;
            } else {
                obj9 = i6;
                obj9 = i1.Q;
                this.D = i1.R;
                i = i1.z;
                this.E = i;
                final int i16 = -1;
                if (i != i16) {
                    if (i <= d2.H) {
                        if (obj9 <= d2.G) {
                        } else {
                            int i12 = i6;
                            obj9 = p0.Y();
                            i7 = i6;
                            for (Object str3 : i3) {
                            }
                            int i15 = i6;
                            i4 = i2;
                            while (i6 < d2.I.size()) {
                                obj9 = i1.D;
                                if (obj9 != null) {
                                    break;
                                } else {
                                }
                                i6++;
                                if (obj9.equals(d2.I.get(i6))) {
                                    break;
                                } else {
                                }
                            }
                            int i13 = i6;
                        }
                    } else {
                    }
                } else {
                }
            }
        }

        @Override // java.lang.Comparable
        public int a(com.google.android.exoplayer2.n2.f.b f$b) {
            boolean z;
            p0 p0Var;
            p0 p0Var2;
            if (this.a && this.v) {
                if (this.v) {
                    p0Var = f.i();
                } else {
                    p0Var = f.i().f();
                }
            } else {
            }
            if (dVar.M) {
                p0Var2 = f.i().f();
            } else {
                p0Var2 = f.j();
            }
            if (p0.b(this.b, b.b)) {
            } else {
                p0Var = f.j();
            }
            return n.i().f(this.v, b.v).e(Integer.valueOf(this.x), Integer.valueOf(b.x), p0.c().f()).d(this.w, b.w).d(this.y, b.y).f(this.a, b.a).e(Integer.valueOf(this.F), Integer.valueOf(b.F), p0.c().f()).e(Integer.valueOf(this.E), Integer.valueOf(b.E), p0Var2).f(this.B, b.B).e(Integer.valueOf(this.z), Integer.valueOf(b.z), p0.c().f()).d(this.A, b.A).e(Integer.valueOf(this.C), Integer.valueOf(b.C), p0Var).e(Integer.valueOf(this.D), Integer.valueOf(b.D), p0Var).e(Integer.valueOf(this.E), Integer.valueOf(b.E), p0Var).h();
        }

        @Override // java.lang.Comparable
        public int compareTo(Object object) {
            return a((f.b)object);
        }
    }

    protected static final class c implements Comparable<com.google.android.exoplayer2.n2.f.c> {

        private final boolean a = false;
        private final boolean b;
        public c(i1 i1, int i2) {
            super();
            final int i4 = 0;
            if (obj3 &= i != 0) {
            }
            int i3 = i4;
            this.b = f.r(i2, i4);
        }

        @Override // java.lang.Comparable
        public int a(com.google.android.exoplayer2.n2.f.c f$c) {
            return n.i().f(this.b, c.b).f(this.a, c.a).h();
        }

        @Override // java.lang.Comparable
        public int compareTo(Object object) {
            return a((f.c)object);
        }
    }

    public static final class f implements Parcelable {

        public static final Parcelable.Creator<com.google.android.exoplayer2.n2.f.f> CREATOR;
        public final int a;
        public final int[] b;
        public final int c;
        public final int v;
        static {
            f.f.a aVar = new f.f.a();
            f.f.CREATOR = aVar;
        }

        public f(int i, int... i2Arr2) {
            super(i, i2Arr2, 0);
        }

        public f(int i, int[] i2Arr2, int i3) {
            super();
            this.a = i;
            int[] obj1 = Arrays.copyOf(i2Arr2, i2Arr2.length);
            this.b = obj1;
            this.c = i2Arr2.length;
            this.v = i3;
            Arrays.sort(obj1);
        }

        f(Parcel parcel) {
            super();
            this.a = parcel.readInt();
            byte byte = parcel.readByte();
            this.c = byte;
            int[] iArr = new int[byte];
            this.b = iArr;
            parcel.readIntArray(iArr);
            this.v = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public boolean a(int i) {
            int i2;
            int i3;
            final int[] iArr = this.b;
            final int i4 = 0;
            i2 = i4;
            while (i2 < iArr.length) {
                i2++;
            }
            return i4;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public boolean equals(Object object) {
            int i;
            int equals;
            Class<com.google.android.exoplayer2.n2.f.f> obj;
            int[] i2;
            Class class;
            int obj5;
            if (this == object) {
                return 1;
            }
            final int i3 = 0;
            if (object != null) {
                if (f.f.class != object.getClass()) {
                } else {
                    if (this.a == object.a && Arrays.equals(this.b, object.b) && this.v == object.v) {
                        if (Arrays.equals(this.b, object.b)) {
                            if (this.v == object.v) {
                            } else {
                                i = i3;
                            }
                        } else {
                        }
                    } else {
                    }
                }
                return i;
            }
            return i3;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i4 += i7;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.a);
            parcel.writeInt(obj2.length);
            parcel.writeIntArray(this.b);
            parcel.writeInt(this.v);
        }
    }

    protected static final class g implements Comparable<com.google.android.exoplayer2.n2.f.g> {

        private final boolean A = false;
        public final boolean a = true;
        private final boolean b;
        private final boolean c = false;
        private final boolean v = false;
        private final int w = 0;
        private final int x = 0;
        private final int y;
        private final int z;
        public g(i1 i1, com.google.android.exoplayer2.n2.f.d f$d2, int i3, String string4) {
            v vVar;
            int i;
            int i4;
            int i2;
            boolean z;
            Object obj8;
            super();
            int i5 = 0;
            this.b = f.r(i3, i5);
            obj9 &= i8;
            final int i17 = 1;
            int i10 = obj9 & 1 != 0 ? i17 : i10;
            int i11 = i5;
            int obj9 = obj9 &= 2 != 0 ? i17 : obj9;
            obj9 = i5;
            obj9 = Integer.MAX_VALUE;
            if (d2.J.isEmpty()) {
                vVar = v.A("");
            } else {
                vVar = d2.J;
            }
            i4 = i5;
            while (i4 < vVar.size()) {
                if (f.o(i1, (String)vVar.get(i4), d2.L) > 0) {
                    break;
                }
                i4++;
            }
            obj9 = Integer.bitCount(obj9 &= i12);
            this.y = obj9;
            int i16 = i13 &= 1088 != 0 ? i17 : i16;
            int i15 = i5;
            i = f.x(string4) == null ? i17 : i5;
            final int obj7 = f.o(i1, string4, i);
            this.z = obj7;
            if (i5 <= 0) {
                if (d2.J.isEmpty()) {
                    if (obj9 <= 0 && !this.c) {
                        if (!this.c) {
                        }
                    }
                } else {
                }
            }
            int i6 = i17;
        }

        @Override // java.lang.Comparable
        public int a(com.google.android.exoplayer2.n2.f.g f$g) {
            n nVar;
            int i;
            p0 p0Var;
            Object obj5;
            if (this.x == 0) {
                p0Var = p0.c();
            } else {
                p0Var = p0.c().f();
            }
            if (this.y == 0) {
                nVar = n.i().f(this.b, g.b).e(Integer.valueOf(this.w), Integer.valueOf(g.w), p0.c().f()).d(this.x, g.x).d(this.y, g.y).f(this.c, g.c).e(Boolean.valueOf(this.v), Boolean.valueOf(g.v), p0Var).d(this.z, g.z).g(this.A, g.A);
            }
            return nVar.h();
        }

        @Override // java.lang.Comparable
        public int compareTo(Object object) {
            return a((f.g)object);
        }
    }

    protected static final class h implements Comparable<com.google.android.exoplayer2.n2.f.h> {

        public final boolean a = false;
        private final com.google.android.exoplayer2.n2.f.d b;
        private final boolean c = false;
        private final boolean v;
        private final int w;
        private final int x;
        private final int y = 0;
        public h(i1 i1, com.google.android.exoplayer2.n2.f.d f$d2, int i3, boolean z4) {
            int cmp;
            int i2;
            float cmp2;
            int i;
            int cmp3;
            float obj10;
            super();
            this.b = d2;
            cmp = -1082130432;
            i2 = 0;
            final int i7 = -1;
            if (z4 != 0) {
                cmp2 = i1.I;
                if (cmp2 != i7) {
                    if (cmp2 <= d2.a) {
                        cmp2 = i1.J;
                        if (cmp2 != i7) {
                            if (cmp2 <= d2.b) {
                                cmp2 = i1.K;
                                if (Float.compare(cmp2, cmp) != 0) {
                                    if (Float.compare(cmp2, cmp3) <= 0) {
                                        cmp2 = i1.z;
                                        if (cmp2 != i7) {
                                            if (cmp2 <= d2.v) {
                                                int i8 = i5;
                                            } else {
                                                i = i2;
                                                if (z4 != 0) {
                                                    obj10 = i1.I;
                                                    if (obj10 != i7) {
                                                        if (obj10 >= d2.w) {
                                                            obj10 = i1.J;
                                                            if (obj10 != i7) {
                                                                if (obj10 >= d2.x) {
                                                                    obj10 = i1.K;
                                                                    if (Float.compare(obj10, cmp) != 0) {
                                                                        if (Float.compare(obj10, cmp) >= 0) {
                                                                            obj10 = i1.z;
                                                                            if (obj10 >= d2.z) {
                                                                            } else {
                                                                                int i6 = i2;
                                                                                this.v = f.r(i3, i2);
                                                                                this.w = i1.z;
                                                                                this.x = i1.c();
                                                                                int obj9 = Integer.MAX_VALUE;
                                                                                while (i2 < d2.D.size()) {
                                                                                    obj10 = i1.D;
                                                                                    if (obj10 != null) {
                                                                                        break;
                                                                                    } else {
                                                                                    }
                                                                                    i2++;
                                                                                    if (obj10.equals(d2.D.get(i2))) {
                                                                                        break;
                                                                                    } else {
                                                                                    }
                                                                                }
                                                                                obj9 = i2;
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
                                                    } else {
                                                    }
                                                } else {
                                                }
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
                    } else {
                    }
                } else {
                }
            } else {
            }
        }

        @Override // java.lang.Comparable
        public int a(com.google.android.exoplayer2.n2.f.h f$h) {
            boolean z;
            p0 p0Var2;
            p0 p0Var;
            if (this.a && this.v) {
                if (this.v) {
                    p0Var2 = f.i();
                } else {
                    p0Var2 = f.i().f();
                }
            } else {
            }
            if (dVar.M) {
                p0Var = f.i().f();
            } else {
                p0Var = f.j();
            }
            return n.i().f(this.v, h.v).f(this.a, h.a).f(this.c, h.c).e(Integer.valueOf(this.y), Integer.valueOf(h.y), p0.c().f()).e(Integer.valueOf(this.w), Integer.valueOf(h.w), p0Var).e(Integer.valueOf(this.x), Integer.valueOf(h.x), p0Var2).e(Integer.valueOf(this.w), Integer.valueOf(h.w), p0Var2).h();
        }

        @Override // java.lang.Comparable
        public int compareTo(Object object) {
            return a((f.h)object);
        }
    }

    public static final class d extends com.google.android.exoplayer2.n2.l implements Parcelable {

        public static final Parcelable.Creator<com.google.android.exoplayer2.n2.f.d> CREATOR;
        public static final com.google.android.exoplayer2.n2.f.d c0;
        public final int P;
        public final boolean Q;
        public final boolean R;
        public final boolean S;
        public final boolean T;
        public final boolean U;
        public final boolean V;
        public final boolean W;
        public final boolean X;
        public final boolean Y;
        public final boolean Z;
        private final SparseArray<Map<l0, com.google.android.exoplayer2.n2.f.f>> a0;
        private final SparseBooleanArray b0;
        static {
            f.e eVar = new f.e();
            f.d.c0 = eVar.O();
            f.d.a aVar = new f.d.a();
            f.d.CREATOR = aVar;
        }

        d(Parcel parcel) {
            super(parcel);
            this.Q = p0.w0(parcel);
            this.R = p0.w0(parcel);
            this.S = p0.w0(parcel);
            this.T = p0.w0(parcel);
            this.U = p0.w0(parcel);
            this.V = p0.w0(parcel);
            this.W = p0.w0(parcel);
            this.P = parcel.readInt();
            this.X = p0.w0(parcel);
            this.Y = p0.w0(parcel);
            this.Z = p0.w0(parcel);
            this.a0 = f.d.h(parcel);
            final SparseBooleanArray obj2 = parcel.readSparseBooleanArray();
            p0.i(obj2);
            this.b0 = (SparseBooleanArray)obj2;
        }

        private d(com.google.android.exoplayer2.n2.f.e f$e) {
            super(e);
            this.Q = f.e.H(e);
            this.R = f.e.I(e);
            this.S = f.e.J(e);
            this.T = f.e.K(e);
            this.U = f.e.L(e);
            this.V = f.e.M(e);
            this.W = f.e.N(e);
            this.P = f.e.B(e);
            this.X = f.e.C(e);
            this.Y = f.e.D(e);
            this.Z = f.e.E(e);
            this.a0 = f.e.F(e);
            this.b0 = f.e.G(e);
        }

        d(com.google.android.exoplayer2.n2.f.e f$e, com.google.android.exoplayer2.n2.f.a f$a2) {
            super(e);
        }

        private static boolean a(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int i;
            int indexOfKey;
            final int size = sparseBooleanArray.size();
            final int i2 = 0;
            if (sparseBooleanArray2.size() != size) {
                return i2;
            }
            i = i2;
            while (i < size) {
                i++;
            }
            return 1;
        }

        private static boolean b(SparseArray<Map<l0, com.google.android.exoplayer2.n2.f.f>> sparseArray, SparseArray<Map<l0, com.google.android.exoplayer2.n2.f.f>> sparseArray2) {
            int i;
            boolean indexOfKey;
            Object valueAt;
            final int size = sparseArray.size();
            final int i2 = 0;
            if (sparseArray2.size() != size) {
                return i2;
            }
            i = i2;
            while (i < size) {
                indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i));
                i++;
            }
            return 1;
        }

        private static boolean c(Map<l0, com.google.android.exoplayer2.n2.f.f> map, Map<l0, com.google.android.exoplayer2.n2.f.f> map2) {
            int size2;
            int size;
            boolean key;
            final int i = 0;
            if (map2.size() != map.size()) {
                return i;
            }
            Iterator obj4 = map.entrySet().iterator();
            for (Map.Entry size2 : obj4) {
                size = size2.getKey();
            }
            return 1;
        }

        public static com.google.android.exoplayer2.n2.f.d d(Context context) {
            f.e eVar = new f.e(context);
            return eVar.O();
        }

        private static SparseArray<Map<l0, com.google.android.exoplayer2.n2.f.f>> h(Parcel parcel) {
            int i2;
            int int;
            int int2;
            HashMap hashMap;
            int i;
            Parcelable parcelable2;
            Parcelable parcelable;
            final int int3 = parcel.readInt();
            SparseArray sparseArray = new SparseArray(int3);
            final int i3 = 0;
            i2 = i3;
            while (i2 < int3) {
                int2 = parcel.readInt();
                hashMap = new HashMap(int2);
                i = i3;
                while (i < int2) {
                    parcelable2 = parcel.readParcelable(l0.class.getClassLoader());
                    g.e((l0)parcelable2);
                    hashMap.put((l0)parcelable2, (f.f)parcel.readParcelable(f.f.class.getClassLoader()));
                    i++;
                }
                sparseArray.put(parcel.readInt(), hashMap);
                i2++;
                parcelable2 = parcel.readParcelable(l0.class.getClassLoader());
                g.e((l0)parcelable2);
                hashMap.put((l0)parcelable2, (f.f)parcel.readParcelable(f.f.class.getClassLoader()));
                i++;
            }
            return sparseArray;
        }

        private static void i(Parcel parcel, SparseArray<Map<l0, com.google.android.exoplayer2.n2.f.f>> sparseArray2) {
            int i;
            Iterator iterator;
            boolean next;
            Object valueAt;
            int size;
            final int size2 = sparseArray2.size();
            parcel.writeInt(size2);
            final int i2 = 0;
            i = i2;
            while (i < size2) {
                valueAt = sparseArray2.valueAt(i);
                parcel.writeInt(sparseArray2.keyAt(i));
                parcel.writeInt((Map)valueAt.size());
                iterator = valueAt.entrySet().iterator();
                for (Map.Entry next2 : iterator) {
                    parcel.writeParcelable((Parcelable)next2.getKey(), i2);
                    parcel.writeParcelable((Parcelable)next2.getValue(), i2);
                }
                i++;
                Object next2 = iterator.next();
                parcel.writeParcelable((Parcelable)(Map.Entry)next2.getKey(), i2);
                parcel.writeParcelable((Parcelable)next2.getValue(), i2);
            }
        }

        @Override // com.google.android.exoplayer2.n2.l
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.n2.l
        public final boolean e(int i) {
            return this.b0.get(i);
        }

        @Override // com.google.android.exoplayer2.n2.l
        public boolean equals(Object object) {
            int i;
            boolean equals;
            Class<com.google.android.exoplayer2.n2.f.d> obj;
            Class class;
            Object obj5;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (object != null) {
                if (f.d.class != object.getClass()) {
                } else {
                    if (super.equals((f.d)object) && this.Q == object.Q && this.R == object.R && this.S == object.S && this.T == object.T && this.U == object.U && this.V == object.V && this.W == object.W && this.P == object.P && this.X == object.X && this.Y == object.Y && this.Z == object.Z && f.d.a(this.b0, object.b0) && f.d.b(this.a0, object.a0)) {
                        if (this.Q == object.Q) {
                            if (this.R == object.R) {
                                if (this.S == object.S) {
                                    if (this.T == object.T) {
                                        if (this.U == object.U) {
                                            if (this.V == object.V) {
                                                if (this.W == object.W) {
                                                    if (this.P == object.P) {
                                                        if (this.X == object.X) {
                                                            if (this.Y == object.Y) {
                                                                if (this.Z == object.Z) {
                                                                    if (f.d.a(this.b0, object.b0)) {
                                                                        if (f.d.b(this.a0, object.a0)) {
                                                                        } else {
                                                                            i = i2;
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
                            } else {
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

        @Override // com.google.android.exoplayer2.n2.l
        public final com.google.android.exoplayer2.n2.f.f f(int i, l0 l02) {
            Object obj2;
            obj2 = this.a0.get(i);
            if ((Map)obj2 != null) {
                obj2 = (Map)obj2.get(l02);
            } else {
                obj2 = 0;
            }
            return obj2;
        }

        @Override // com.google.android.exoplayer2.n2.l
        public final boolean g(int i, l0 l02) {
            Object obj2;
            obj2 = this.a0.get(i);
            if (obj2 != null && (Map)obj2.containsKey(l02)) {
                obj2 = obj2.containsKey(l02) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // com.google.android.exoplayer2.n2.l
        public int hashCode() {
            int i25 = 31;
            return i23 += z;
        }

        @Override // com.google.android.exoplayer2.n2.l
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            p0.L0(parcel, this.Q);
            p0.L0(parcel, this.R);
            p0.L0(parcel, this.S);
            p0.L0(parcel, this.T);
            p0.L0(parcel, this.U);
            p0.L0(parcel, this.V);
            p0.L0(parcel, this.W);
            parcel.writeInt(this.P);
            p0.L0(parcel, this.X);
            p0.L0(parcel, this.Y);
            p0.L0(parcel, this.Z);
            f.d.i(parcel, this.a0);
            parcel.writeSparseBooleanArray(this.b0);
        }
    }

    public static final class e extends com.google.android.exoplayer2.n2.l.b {

        private boolean A;
        private boolean B;
        private boolean C;
        private int D;
        private boolean E;
        private boolean F;
        private boolean G;
        private final SparseArray<Map<l0, com.google.android.exoplayer2.n2.f.f>> H;
        private final SparseBooleanArray I;
        private boolean w;
        private boolean x;
        private boolean y;
        private boolean z;
        @Deprecated
        public e() {
            super();
            SparseArray sparseArray = new SparseArray();
            this.H = sparseArray;
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            this.I = sparseBooleanArray;
            P();
        }

        public e(Context context) {
            super(context);
            SparseArray obj1 = new SparseArray();
            this.H = obj1;
            obj1 = new SparseBooleanArray();
            this.I = obj1;
            P();
        }

        static int B(com.google.android.exoplayer2.n2.f.e f$e) {
            return e.D;
        }

        static boolean C(com.google.android.exoplayer2.n2.f.e f$e) {
            return e.E;
        }

        static boolean D(com.google.android.exoplayer2.n2.f.e f$e) {
            return e.F;
        }

        static boolean E(com.google.android.exoplayer2.n2.f.e f$e) {
            return e.G;
        }

        static SparseArray F(com.google.android.exoplayer2.n2.f.e f$e) {
            return e.H;
        }

        static SparseBooleanArray G(com.google.android.exoplayer2.n2.f.e f$e) {
            return e.I;
        }

        static boolean H(com.google.android.exoplayer2.n2.f.e f$e) {
            return e.w;
        }

        static boolean I(com.google.android.exoplayer2.n2.f.e f$e) {
            return e.x;
        }

        static boolean J(com.google.android.exoplayer2.n2.f.e f$e) {
            return e.y;
        }

        static boolean K(com.google.android.exoplayer2.n2.f.e f$e) {
            return e.z;
        }

        static boolean L(com.google.android.exoplayer2.n2.f.e f$e) {
            return e.A;
        }

        static boolean M(com.google.android.exoplayer2.n2.f.e f$e) {
            return e.B;
        }

        static boolean N(com.google.android.exoplayer2.n2.f.e f$e) {
            return e.C;
        }

        private void P() {
            final int i = 1;
            this.w = i;
            final int i2 = 0;
            this.x = i2;
            this.y = i;
            this.z = i;
            this.A = i2;
            this.B = i2;
            this.C = i2;
            this.D = i2;
            this.E = i;
            this.F = i2;
            this.G = i;
        }

        @Override // com.google.android.exoplayer2.n2.l$b
        public com.google.android.exoplayer2.n2.l.b A(Context context, boolean z2) {
            S(context, z2);
            return this;
        }

        @Override // com.google.android.exoplayer2.n2.l$b
        public com.google.android.exoplayer2.n2.f.d O() {
            f.d dVar = new f.d(this, 0);
            return dVar;
        }

        @Override // com.google.android.exoplayer2.n2.l$b
        public com.google.android.exoplayer2.n2.f.e Q(Context context) {
            super.x(context);
            return this;
        }

        @Override // com.google.android.exoplayer2.n2.l$b
        public com.google.android.exoplayer2.n2.f.e R(int i, int i2, boolean z3) {
            super.z(i, i2, z3);
            return this;
        }

        @Override // com.google.android.exoplayer2.n2.l$b
        public com.google.android.exoplayer2.n2.f.e S(Context context, boolean z2) {
            super.A(context, z2);
            return this;
        }

        @Override // com.google.android.exoplayer2.n2.l$b
        public com.google.android.exoplayer2.n2.l w() {
            return O();
        }

        @Override // com.google.android.exoplayer2.n2.l$b
        public com.google.android.exoplayer2.n2.l.b x(Context context) {
            Q(context);
            return this;
        }

        @Override // com.google.android.exoplayer2.n2.l$b
        public com.google.android.exoplayer2.n2.l.b z(int i, int i2, boolean z3) {
            R(i, i2, z3);
            return this;
        }
    }
    static {
        f.d = new int[0];
        f.e = p0.a(c.a);
        f.f = p0.a(b.a);
    }

    public f(Context context) {
        d.b bVar = new d.b();
        super(context, bVar);
    }

    public f(Context context, com.google.android.exoplayer2.n2.g.b g$b2) {
        super(f.d.d(context), b2);
    }

    public f(com.google.android.exoplayer2.n2.f.d f$d, com.google.android.exoplayer2.n2.g.b g$b2) {
        super();
        this.b = b2;
        AtomicReference obj2 = new AtomicReference(d);
        this.c = obj2;
    }

    private static com.google.android.exoplayer2.n2.g.a C(l0 l0, int[][] i2Arr2Arr2, com.google.android.exoplayer2.n2.f.d f$d3) {
        int[] iArr;
        com.google.android.exoplayer2.n2.g.a aVar;
        int i6;
        int i;
        int i3;
        int i2;
        k0 k0Var;
        List list;
        Object obj;
        int i4;
        int i5;
        boolean hVar;
        boolean z;
        boolean contains;
        iArr = l0;
        final Object obj2 = d3;
        final int i8 = 0;
        i6 = -1;
        i = i8;
        i2 = i3;
        while (i < iArr.a) {
            k0Var = iArr.a(i);
            obj = i2Arr2Arr2[i];
            i4 = i8;
            while (i4 < k0Var.a) {
                i5 = k0Var.a(i4);
                if (i12 &= 16384 != 0) {
                } else {
                }
                if (f.r(obj[i4], obj2.X)) {
                }
                i4++;
                hVar = new f.h(i5, obj2, obj[i4], f.q(k0Var, obj2.A, obj2.B, obj2.C).contains(Integer.valueOf(i4)));
                if (!hVar.a && !obj2.Q) {
                } else {
                }
                if (i2 != 0) {
                } else {
                }
                i3 = k0Var;
                i6 = i4;
                i2 = hVar;
                if (hVar.a(i2) > 0) {
                }
                if (!obj2.Q) {
                } else {
                }
            }
            i++;
            i5 = k0Var.a(i4);
            if (i12 &= 16384 != 0) {
            } else {
            }
            if (f.r(obj[i4], obj2.X)) {
            }
            i4++;
            hVar = new f.h(i5, obj2, obj[i4], list.contains(Integer.valueOf(i4)));
            if (!hVar.a && !obj2.Q) {
            } else {
            }
            if (i2 != 0) {
            } else {
            }
            i3 = k0Var;
            i6 = i4;
            i2 = hVar;
            if (hVar.a(i2) > 0) {
            }
            if (!obj2.Q) {
            } else {
            }
        }
        if (i3 == 0) {
        } else {
            iArr = new int[1];
            iArr[i8] = i6;
            aVar = new g.a(i3, iArr);
        }
        return aVar;
    }

    static p0 i() {
        return f.e;
    }

    static p0 j() {
        return f.f;
    }

    private static void k(k0 k0, int[] i2Arr2, int i3, String string4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, List<Integer> list13) {
        int i16;
        boolean z;
        Object obj3;
        i1 i1Var;
        String str;
        int i14;
        int i;
        int i18;
        int i17;
        int i13;
        int i2;
        int i4;
        int i20;
        int i15;
        int i19;
        final Object obj = list13;
        size--;
        while (i16 >= 0) {
            int intValue = (Integer)obj.get(i16).intValue();
            if (!f.t(k0.a(intValue), string4, i2Arr2[intValue], i3, i5, i6, i7, i8, i9, i10, i11, i12)) {
            }
            i16--;
            obj.remove(i16);
        }
    }

    private static int[] l(k0 k0, int[] i2Arr2, int i3, int i4, boolean z5, boolean z6, boolean z7) {
        int i2;
        int i6;
        i1 i1Var;
        int i5;
        boolean z3;
        boolean z;
        boolean z2;
        int i;
        int i7;
        Object obj = k0;
        final int[] iArr = new int[obj.a];
        i7 = i;
        while (i < obj.a) {
            if (i != i3) {
            } else {
            }
            iArr[i7] = i;
            i7 = i2;
            i++;
            if (f.s(k0.a(i), i2Arr2[i], k0.a(i3), i4, z5, z6, z7)) {
            }
        }
        return Arrays.copyOf(iArr, i7);
    }

    private static int m(k0 k0, int[] i2Arr2, int i3, String string4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, List<Integer> list13) {
        int i20;
        int i18;
        Object obj;
        boolean z;
        Object obj3;
        i1 i1Var;
        String str;
        int i15;
        int i;
        int i17;
        int i4;
        int i14;
        int i2;
        int i21;
        int i13;
        int i16;
        int i19;
        i18 = i20;
        while (i20 < list13.size()) {
            int intValue = (Integer)list13.get(i20).intValue();
            if (f.t(k0.a(intValue), string4, i2Arr2[intValue], i3, i5, i6, i7, i8, i9, i10, i11, i12)) {
            }
            i20++;
            i18++;
        }
        return i18;
    }

    private static int[] n(k0 k0, int[] i2Arr2, boolean z3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, boolean z15) {
        int size;
        int[] iArr;
        int i24;
        boolean z;
        int i23;
        String str3;
        int i3;
        int i21;
        int i22;
        int i15;
        int i18;
        String str2;
        int i20;
        int i2;
        HashSet hashSet;
        int i16;
        int i;
        int i17;
        String str;
        int i19;
        HashSet set;
        final Object obj2 = k0;
        i16 = 2;
        if (obj2.a < i16) {
            return f.d;
        }
        final List list2 = f.q(obj2, i13, i14, z15);
        if (list2.size() < i16) {
            return f.d;
        }
        size = 0;
        if (!z3) {
            hashSet = new HashSet();
            i17 = size;
            i2 = i20;
            while (i2 < list2.size()) {
                str2 = i1Var.D;
                if (hashSet.add(str2)) {
                } else {
                }
                i = i20;
                i19 = i2;
                set = hashSet;
                i20 = i;
                i2 = i19 + 1;
                hashSet = set;
                i16 = 2;
                i19 = i2;
                set = hashSet;
                size = f.m(k0, i2Arr2, i4, str2, i5, i6, i7, i8, i9, i10, i11, i12, list2);
                if (size > i20) {
                } else {
                }
                i20 = size;
                i17 = str;
            }
            i23 = i17;
        } else {
            i23 = size;
        }
        f.k(k0, i2Arr2, i4, i23, i5, i6, i7, i8, i9, i10, i11, i12, list2);
        if (list2.size() < 2) {
            iArr = f.d;
        } else {
            iArr = b.k(list2);
        }
        return iArr;
    }

    protected static int o(i1 i1, String string2, boolean z3) {
        boolean equals;
        int i;
        boolean obj3;
        if (!TextUtils.isEmpty(string2) && string2.equals(i1.c)) {
            if (string2.equals(i1.c)) {
                return 4;
            }
        }
        String obj2 = f.x(string2);
        String obj1 = f.x(i1.c);
        i = 0;
        if (obj1 != null) {
            if (obj2 == null) {
            } else {
                if (!obj1.startsWith(obj2)) {
                    if (obj2.startsWith(obj1)) {
                    } else {
                        obj3 = "-";
                        if (p0.D0(obj1, obj3)[i].equals(p0.D0(obj2, obj3)[i])) {
                            return 2;
                        }
                    }
                    return i;
                }
            }
            return 3;
        }
        if (z3 && obj1 == null) {
            if (obj1 == null) {
                i = 1;
            }
        }
        return i;
    }

    private static Point p(boolean z, int i2, int i3, int i4, int i5) {
        int i;
        int i6;
        int i7;
        int obj3;
        int obj4;
        int obj5;
        if (z != 0) {
            i = 0;
            i6 = i4 > i5 ? obj3 : i;
            if (i2 > i3) {
            } else {
                obj3 = i;
            }
            if (i6 != obj3) {
            } else {
                obj5 = i2;
                obj4 = i7;
            }
        } else {
        }
        obj3 = i4 * obj4;
        int i8 = i5 * obj5;
        if (obj3 >= i8) {
            obj3 = new Point(obj5, p0.k(i8, i4));
            return obj3;
        }
        obj5 = new Point(p0.k(obj3, i5), obj4);
        return obj5;
    }

    private static List<Integer> q(k0 k0, int i2, int i3, boolean z4) {
        int i7;
        int i9;
        Integer valueOf;
        int i4;
        int i;
        int i5;
        int i11;
        int i6;
        int i10;
        int i8;
        int obj11;
        int obj12;
        boolean obj13;
        ArrayList arrayList = new ArrayList(k0.a);
        i9 = i7;
        while (i9 < k0.a) {
            arrayList.add(Integer.valueOf(i9));
            i9++;
        }
        int i13 = Integer.MAX_VALUE;
        if (i2 != i13) {
            if (i3 == i13) {
            } else {
                i4 = i13;
                while (i7 < k0.a) {
                    i = k0.a(i7);
                    i5 = i.I;
                    i11 = i.J;
                    i5 = f.p(z4, i2, i3, i5, i11);
                    i11 = i.I;
                    i = i.J;
                    i6 = i11 * i;
                    i8 = 1065017672;
                    if (i5 > 0 && i11 > 0 && i11 >= (int)i17 && i >= (int)i15 && i6 < i4) {
                    }
                    i7++;
                    i11 = i.J;
                    if (i11 > 0) {
                    }
                    i5 = f.p(z4, i2, i3, i5, i11);
                    i11 = i.I;
                    i = i.J;
                    i6 = i11 * i;
                    i8 = 1065017672;
                    if (i11 >= (int)i17) {
                    }
                    if (i >= (int)i15) {
                    }
                    if (i6 < i4) {
                    }
                    i4 = i6;
                }
                if (i4 != i13) {
                    obj11--;
                    while (obj11 >= 0) {
                        obj12 = k0.a((Integer)arrayList.get(obj11).intValue()).c();
                        if (obj12 != true) {
                        } else {
                        }
                        arrayList.remove(obj11);
                        obj11--;
                        if (obj12 > i4) {
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    protected static boolean r(int i, boolean z2) {
        int obj1;
        int obj2;
        obj1 = a2.B(i);
        if (obj1 != 4) {
            if (z2 != 0 && obj1 == 3) {
                if (obj1 == 3) {
                    obj1 = 1;
                } else {
                    obj1 = 0;
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    private static boolean s(i1 i1, int i2, i1 i13, int i4, boolean z5, boolean z6, boolean z7) {
        int i;
        int i3;
        Object obj2;
        boolean obj3;
        int obj5;
        obj3 = i1.z;
        i3 = -1;
        if (f.r(i2, false) && obj3 != i3 && obj3 <= i4) {
            obj3 = i1.z;
            i3 = -1;
            if (obj3 != i3) {
                if (obj3 <= i4) {
                    if (!z7) {
                        obj3 = i1.Q;
                        if (obj3 != i3 && obj3 == i13.Q) {
                            if (obj3 == i13.Q) {
                                if (!z5) {
                                    obj3 = i1.D;
                                    if (obj3 != null && TextUtils.equals(obj3, i13.D)) {
                                        if (TextUtils.equals(obj3, i13.D)) {
                                            if (!z6) {
                                                obj2 = i1.R;
                                                if (obj2 != i3 && obj2 == i13.R) {
                                                    if (obj2 == i13.R) {
                                                        i = 1;
                                                    }
                                                }
                                            } else {
                                            }
                                        }
                                    }
                                } else {
                                }
                            }
                        }
                    } else {
                    }
                }
            }
        }
        return i;
    }

    private static boolean t(i1 i1, String string2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        int i;
        Object obj2;
        Object obj3;
        int obj4;
        int obj5;
        i = 0;
        if (i2 &= 16384 != 0) {
            return i;
        }
        if (f.r(i3, i) && i3 &= i4 != 0) {
            if (i3 &= i4 != 0) {
                if (string2 != null) {
                    if (p0.b(i1.D, string2)) {
                        obj3 = i1.I;
                        obj4 = -1;
                        if (obj3 != obj4) {
                            if (i9 <= obj3 && obj3 <= i5) {
                                if (obj3 <= i5) {
                                    obj3 = i1.J;
                                    if (obj3 != obj4) {
                                        if (i10 <= obj3 && obj3 <= i6) {
                                            if (obj3 <= i6) {
                                                obj3 = i1.K;
                                                if (Float.compare(obj3, obj5) != 0) {
                                                    obj2 = i1.z;
                                                    if (Float.compare(obj5, obj3) <= 0 && Float.compare(obj3, obj5) <= 0 && obj2 != obj4 && i12 <= obj2 && obj2 <= i8) {
                                                        if (Float.compare(obj3, obj5) <= 0) {
                                                            obj2 = i1.z;
                                                            if (obj2 != obj4) {
                                                                if (i12 <= obj2) {
                                                                    if (obj2 <= i8) {
                                                                        i = 1;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                }
                                            }
                                        }
                                    } else {
                                    }
                                }
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
        }
        return i;
    }

    static int u(Integer integer, Integer integer2) {
        int intValue;
        int i;
        int obj2;
        int obj3;
        i = -1;
        if (integer.intValue() == i) {
            if (integer2.intValue() == i) {
                i = 0;
            }
        } else {
            if (integer2.intValue() == i) {
                i = 1;
            } else {
                i = obj2 - obj3;
            }
        }
        return i;
    }

    static int v(Integer integer, Integer integer2) {
        return 0;
    }

    private static void w(com.google.android.exoplayer2.n2.i.a i$a, int[][][] i2Arr2Arr2Arr2, b2[] b23Arr3, com.google.android.exoplayer2.n2.g[] g4Arr4) {
        int i2;
        int i7;
        int i;
        int i4;
        int i5;
        int i3;
        Object obj;
        int i6;
        l0 l0Var;
        int obj10;
        i2 = 0;
        final int i8 = -1;
        i7 = i2;
        i4 = i;
        i3 = 1;
        while (i7 < a.c()) {
            i5 = a.d(i7);
            obj = g4Arr4[i7];
            i7++;
            i3 = 1;
            i = i7;
            i4 = i7;
        }
        obj10 = i3;
        if (i4 != i8 && i != i8) {
            if (i != i8) {
                i2 = i3;
            }
        }
        if (obj10 &= i2 != 0) {
            obj10 = new b2(i3);
            b23Arr3[i4] = obj10;
            b23Arr3[i] = obj10;
        }
    }

    protected static String x(String string) {
        boolean equals;
        java.lang.CharSequence obj1;
        if (!TextUtils.isEmpty(string)) {
            if (TextUtils.equals(string, "und")) {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    private static boolean y(int[][] iArrArr, l0 l02, com.google.android.exoplayer2.n2.g g3) {
        int i3;
        int i;
        int i2;
        final int i4 = 0;
        if (g3 == null) {
            return i4;
        }
        i3 = i4;
        while (i3 < g3.length()) {
            i3++;
        }
        return 1;
    }

    private static com.google.android.exoplayer2.n2.g.a z(l0 l0, int[][] i2Arr2Arr2, int i3, com.google.android.exoplayer2.n2.f.d f$d4) {
        Object obj;
        Object obj2;
        int i15;
        boolean length;
        int i5;
        int i;
        int i10;
        int i2;
        int i12;
        int i8;
        int i4;
        int i13;
        int i17;
        int i14;
        int i6;
        int i11;
        int i16;
        boolean z;
        int i7;
        int i9;
        obj = l0;
        obj2 = d4;
        i15 = obj2.S ? 24 : 16;
        i5 = 0;
        if (obj2.R && i3 & i15 != 0) {
            i7 = i3 & i15 != 0 ? length : i5;
        } else {
        }
        i11 = i5;
        while (i11 < obj.a) {
            k0 k0Var3 = obj.a(i11);
            int[] iArr = f.n(k0Var3, i2Arr2Arr2[i11], i7, i15, obj2.a, obj2.b, obj2.c, obj2.v, obj2.w, obj2.x, obj2.y, obj2.z, obj2.A, obj2.B, obj2.C);
            i11 = i9 + 1;
            obj = l0;
            obj2 = d4;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.n2.i
    protected com.google.android.exoplayer2.n2.g.a[] A(com.google.android.exoplayer2.n2.i.a i$a, int[][][] i2Arr2Arr2Arr2, int[] i3Arr3, com.google.android.exoplayer2.n2.f.d f$d4) {
        int second2;
        int second;
        int i5;
        int i7;
        Object obj2;
        int i4;
        int i12;
        int i18;
        com.google.android.exoplayer2.n2.f.d dVar;
        int i9;
        int i10;
        int i;
        int i17;
        int i2;
        int i19;
        int i3;
        int i11;
        int i13;
        int i14;
        int i8;
        Object obj;
        int i16;
        int i6;
        int i15;
        final Object obj5 = this;
        final Object obj6 = a;
        final Object obj7 = d4;
        final int i22 = a.c();
        final com.google.android.exoplayer2.n2.g.a[] arr = new g.a[i22];
        i17 = 0;
        i19 = i2;
        while (i2 < i22) {
            if (2 == obj6.d(i2) && second2 == 0) {
            }
            i2++;
            if (second2 == 0) {
            }
            if (l0Var.a > 0) {
            } else {
            }
            i13 = i17;
            i19 |= i13;
            arr[i2] = this.F(obj6.e(i2), i2Arr2Arr2Arr2[i2], i3Arr3[i2], d4, true);
            if (arr[i2] != null) {
            } else {
            }
            second2 = i17;
            second2 = i13;
        }
        int i23 = -1;
        final int i24 = 0;
        i = i17;
        i4 = i23;
        i9 = i18;
        while (i < i22) {
            if (i13 == obj6.d(i)) {
            } else {
            }
            i11 = i4;
            i14 = i18;
            i6 = i9;
            i16 = i;
            i4 = i11;
            i18 = i14;
            i9 = i6;
            i = i16 + 1;
            i3 = 2;
            i13 = 1;
            if (!obj7.Z) {
            } else {
            }
            i8 = i13;
            i11 = i4;
            i14 = i18;
            i6 = i9;
            i16 = i;
            second2 = this.B(obj6.e(i), i2Arr2Arr2Arr2[i], i3Arr3[i], d4, i8);
            if (second2 != null) {
            } else {
            }
            if (i14 != 0) {
            } else {
            }
            if (i11 != i23) {
            }
            Object first2 = second2.first;
            arr[i16] = (g.a)first2;
            i9 = i5.c;
            i18 = second2;
            i4 = i16;
            arr[i11] = i24;
            if ((f.b)second2.second.a(i14) > 0) {
            } else {
            }
            if (i19 == 0) {
            } else {
            }
            i8 = i17;
        }
        i15 = i9;
        i7 = i23;
        second = i24;
        while (i17 < i22) {
            i4 = obj6.d(i17);
            if (i4 != 1) {
            } else {
            }
            i19 = i15;
            i9 = 2;
            i17++;
            i15 = i19;
            if (i4 != 2) {
            } else {
            }
            i19 = i15;
            if (i4 != 3) {
            } else {
            }
            i4 = obj5.E(obj6.e(i17), i2Arr2Arr2Arr2[i17], obj7, i15);
            if (i4 != null) {
            }
            if (second != 0) {
            } else {
            }
            if (i7 != i23) {
            }
            arr[i17] = (g.a)i4.first;
            second = i4.second;
            i7 = i17;
            arr[i7] = i24;
            if ((f.g)i4.second.a(second) > 0 && i7 != i23) {
            }
            arr[i17] = obj5.D(i4, obj6.e(i17), i2Arr2Arr2Arr2[i17], obj7);
        }
        return arr;
    }

    protected Pair<com.google.android.exoplayer2.n2.g.a, com.google.android.exoplayer2.n2.f.b> B(l0 l0, int[][] i2Arr2Arr2, int i3, com.google.android.exoplayer2.n2.f.d f$d4, boolean z5) {
        Object iArr;
        int aVar;
        boolean length;
        int i2;
        int i5;
        k0 k0Var;
        int i;
        Object obj;
        int i4;
        int i6;
        boolean bVar;
        boolean z2;
        boolean z;
        int i8;
        int i7;
        Object obj2 = l0;
        iArr = d4;
        final int i9 = 0;
        aVar = 0;
        int i10 = -1;
        i2 = i9;
        i7 = aVar;
        i8 = i5;
        while (i2 < obj2.a) {
            k0Var = obj2.a(i2);
            obj = i2Arr2Arr2[i2];
            i4 = i9;
            while (i4 < k0Var.a) {
                if (f.r(obj[i4], iArr.X)) {
                }
                i4++;
                bVar = new f.b(k0Var.a(i4), iArr, obj[i4]);
                if (!bVar.a && !iArr.T) {
                } else {
                }
                if (i7 != 0) {
                } else {
                }
                i5 = i2;
                i8 = i4;
                i7 = bVar;
                if (bVar.a(i7) > 0) {
                }
                if (!iArr.T) {
                } else {
                }
            }
            i2++;
            if (f.r(obj[i4], iArr.X)) {
            }
            i4++;
            bVar = new f.b(k0Var.a(i4), iArr, obj[i4]);
            if (!bVar.a && !iArr.T) {
            } else {
            }
            if (i7 != 0) {
            } else {
            }
            i5 = i2;
            i8 = i4;
            i7 = bVar;
            if (bVar.a(i7) > 0) {
            }
            if (!iArr.T) {
            } else {
            }
        }
        if (i5 == i10) {
            return aVar;
        }
        k0 k0Var2 = obj2.a(i5);
        int i11 = 1;
        iArr = f.l(k0Var2, i2Arr2Arr2[i5], i8, iArr.H, iArr.U, iArr.V, iArr.W);
        if (!iArr.N && !iArr.M && z5 && iArr.length > i11) {
            if (!iArr.M) {
                if (z5) {
                    iArr = f.l(k0Var2, i2Arr2Arr2[i5], i8, iArr.H, iArr.U, iArr.V, iArr.W);
                    if (iArr.length > i11) {
                        aVar = new g.a(k0Var2, iArr);
                    }
                }
            }
        }
        if (aVar == 0) {
            iArr = new int[i11];
            iArr[i9] = i8;
            aVar = new g.a(k0Var2, iArr);
        }
        g.e(i7);
        return Pair.create(aVar, (f.b)i7);
    }

    @Override // com.google.android.exoplayer2.n2.i
    protected com.google.android.exoplayer2.n2.g.a D(int i, l0 l02, int[][] i3Arr3Arr3, com.google.android.exoplayer2.n2.f.d f$d4) {
        int i6;
        int i2;
        int i7;
        int i4;
        k0 k0Var;
        Object obj;
        int i5;
        int i3;
        boolean cVar;
        int i8;
        int obj12;
        Object obj13;
        final int i9 = 0;
        i4 = i2;
        i7 = i6;
        while (i6 < l02.a) {
            k0Var = l02.a(i6);
            obj = i3Arr3Arr3[i6];
            i5 = i9;
            while (i5 < k0Var.a) {
                if (f.r(obj[i5], d4.X)) {
                }
                i5++;
                cVar = new f.c(k0Var.a(i5), obj[i5]);
                if (i4 != 0) {
                } else {
                }
                i2 = k0Var;
                i7 = i5;
                i4 = cVar;
                if (cVar.a(i4) > 0) {
                }
            }
            i6++;
            if (f.r(obj[i5], d4.X)) {
            }
            i5++;
            cVar = new f.c(k0Var.a(i5), obj[i5]);
            if (i4 != 0) {
            } else {
            }
            i2 = k0Var;
            i7 = i5;
            i4 = cVar;
            if (cVar.a(i4) > 0) {
            }
        }
        if (i2 == 0) {
        } else {
            obj13 = new int[1];
            obj13[i9] = i7;
            obj12 = new g.a(i2, obj13);
        }
        return obj12;
    }

    protected Pair<com.google.android.exoplayer2.n2.g.a, com.google.android.exoplayer2.n2.f.g> E(l0 l0, int[][] i2Arr2Arr2, com.google.android.exoplayer2.n2.f.d f$d3, String string4) {
        Object aVar;
        int[] iArr;
        Pair create;
        int i3;
        int i7;
        int i5;
        int i;
        k0 k0Var;
        Object obj;
        int i4;
        int i6;
        boolean gVar;
        int i2;
        String str;
        aVar = l0;
        iArr = d3;
        final int i9 = 0;
        i3 = -1;
        i7 = i9;
        i = i5;
        while (i7 < aVar.a) {
            k0Var = aVar.a(i7);
            obj = i2Arr2Arr2[i7];
            i4 = i9;
            while (i4 < k0Var.a) {
                if (f.r(obj[i4], iArr.X)) {
                } else {
                }
                str = string4;
                i4++;
                gVar = new f.g(k0Var.a(i4), iArr, obj[i4], string4);
                if (gVar.a) {
                }
                if (i != 0) {
                } else {
                }
                i5 = k0Var;
                i3 = i4;
                i = gVar;
                if (gVar.a(i) > 0) {
                }
            }
            str = string4;
            i7++;
            if (f.r(obj[i4], iArr.X)) {
            } else {
            }
            str = string4;
            i4++;
            gVar = new f.g(k0Var.a(i4), iArr, obj[i4], string4);
            if (gVar.a) {
            }
            if (i != 0) {
            } else {
            }
            i5 = k0Var;
            i3 = i4;
            i = gVar;
            if (gVar.a(i) > 0) {
            }
        }
        if (i5 == 0) {
        } else {
            iArr = new int[1];
            iArr[i9] = i3;
            aVar = new g.a(i5, iArr);
            g.e(i);
            create = Pair.create(aVar, (f.g)i);
        }
        return create;
    }

    @Override // com.google.android.exoplayer2.n2.i
    protected com.google.android.exoplayer2.n2.g.a F(l0 l0, int[][] i2Arr2Arr2, int i3, com.google.android.exoplayer2.n2.f.d f$d4, boolean z5) {
        boolean z;
        com.google.android.exoplayer2.n2.g.a obj4;
        if (!d4.N && !d4.M && z5) {
            if (!d4.M) {
                if (z5) {
                    obj4 = f.z(l0, i2Arr2Arr2, i3, d4);
                } else {
                    obj4 = 0;
                }
            } else {
            }
        } else {
        }
        if (obj4 == null) {
            obj4 = f.C(l0, i2Arr2Arr2, d4);
        }
        return obj4;
    }

    protected final Pair<b2[], com.google.android.exoplayer2.n2.g[]> h(com.google.android.exoplayer2.n2.i.a i$a, int[][][] i2Arr2Arr2Arr2, int[] i3Arr3, y.a y$a4, g2 g25) {
        int i;
        com.google.android.exoplayer2.n2.g.b bVar;
        int i2;
        int z;
        int aVar;
        boolean z3;
        com.google.android.exoplayer2.upstream.g gVar;
        boolean z2;
        int[] iArr;
        int obj13;
        Object obj = this.c.get();
        final int i3 = a.c();
        com.google.android.exoplayer2.n2.g.a[] obj11 = A(a, i2Arr2Arr2Arr2, i3Arr3, (f.d)obj);
        final int i4 = 0;
        i = i4;
        aVar = 0;
        while (i < i3) {
            if (obj.e(i)) {
            } else {
            }
            z3 = a.e(i);
            if (obj.g(i, z3)) {
            }
            i++;
            aVar = 0;
            z2 = obj.f(i, z3);
            if (z2 == null) {
            } else {
            }
            aVar = new g.a(z3.a(z2.a), z2.b, z2.v);
            obj11[i] = aVar;
            obj11[i] = aVar;
        }
        obj11 = this.b.a(obj11, a(), a4, g25);
        final b2[] obj12 = new b2[i3];
        obj13 = i4;
        while (obj13 < i3) {
            if (!obj.e(obj13)) {
            } else {
            }
            i2 = i4;
            if (i2 != 0) {
            } else {
            }
            bVar = aVar;
            obj12[obj13] = bVar;
            obj13++;
            bVar = b2.b;
            if (a.d(obj13) != 7) {
            } else {
            }
            i2 = 1;
            if (obj11[obj13] != null) {
            } else {
            }
        }
        if (obj.Y) {
            f.w(a, i2Arr2Arr2Arr2, obj12, obj11);
        }
        return Pair.create(obj12, obj11);
    }
}
