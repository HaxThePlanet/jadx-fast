package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.measurement.b;
import com.google.android.gms.internal.measurement.de;
import com.google.android.gms.internal.measurement.f5;
import com.google.android.gms.internal.measurement.h5;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.j5;
import com.google.android.gms.internal.measurement.j8;
import com.google.android.gms.internal.measurement.l3;
import com.google.android.gms.internal.measurement.l4;
import com.google.android.gms.internal.measurement.n3;
import com.google.android.gms.internal.measurement.n4;
import com.google.android.gms.internal.measurement.o4;
import com.google.android.gms.internal.measurement.p4;
import com.google.android.gms.internal.measurement.r3;
import com.google.android.gms.internal.measurement.s4;
import com.google.android.gms.internal.measurement.t3;
import com.google.android.gms.internal.measurement.t4;
import com.google.android.gms.internal.measurement.t8;
import com.google.android.gms.internal.measurement.x3;
import com.google.android.gms.internal.measurement.x4;
import com.google.android.gms.internal.measurement.x9;
import com.google.android.gms.internal.measurement.y4;
import com.google.android.gms.internal.measurement.z4;
import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public final class da extends com.google.android.gms.measurement.internal.r9 {
    da(com.google.android.gms.measurement.internal.ba ba) {
        super(ba);
    }

    static <Builder extends x9> Builder D(Builder builder, byte[] b2Arr2) {
        final j8 j8Var = j8.b();
        if (j8Var != null) {
            builder.H1(b2Arr2, j8Var);
            return builder;
        }
        builder.B1(b2Arr2);
        return builder;
    }

    static List<t4> H(Bundle[] bundleArr) {
        int i;
        Object obj;
        s4 s4Var;
        Iterator iterator;
        boolean next;
        s4 s4Var2;
        long doubleValue;
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < bundleArr.length) {
            obj = bundleArr[i];
            if (obj == null) {
            } else {
            }
            s4Var = t4.A();
            iterator = obj.keySet().iterator();
            while (iterator.hasNext()) {
                Object next2 = iterator.next();
                s4Var2 = t4.A();
                s4Var2.B((String)next2);
                next = obj.get(next2);
                if (next instanceof Long) {
                } else {
                }
                if (next instanceof String != null) {
                } else {
                }
                if (next instanceof Double) {
                }
                s4Var2.z((Double)next.doubleValue());
                s4Var.u(s4Var2);
                s4Var2.C((String)next);
                s4Var2.A((Long)next.longValue());
            }
            if (s4Var.s() > 0) {
            }
            i++;
            arrayList.add((t4)s4Var.l());
            next2 = iterator.next();
            s4Var2 = t4.A();
            s4Var2.B((String)next2);
            next = obj.get(next2);
            if (next instanceof Long) {
            } else {
            }
            if (next instanceof String != null) {
            } else {
            }
            if (next instanceof Double) {
            }
            s4Var2.z((Double)next.doubleValue());
            s4Var.u(s4Var2);
            s4Var2.C((String)next);
            s4Var2.A((Long)next.longValue());
        }
        return arrayList;
    }

    static List<Long> J(BitSet bitSet) {
        int i;
        Long valueOf;
        int i4;
        int i2;
        int i3;
        int length;
        final int i7 = 64;
        i5 /= i7;
        ArrayList arrayList = new ArrayList(i6);
        final int i8 = 0;
        i = i8;
        while (i < i6) {
            i4 = 0;
            i2 = i8;
            while (i2 < i7) {
                i9 += i2;
                if (i3 >= bitSet.length()) {
                    break loop_3;
                } else {
                }
                if (bitSet.get(i3)) {
                }
                i2++;
                i4 |= i3;
            }
            arrayList.add(Long.valueOf(i4));
            i++;
            i9 += i2;
            if (i3 >= bitSet.length()) {
            } else {
            }
            if (bitSet.get(i3)) {
            }
            i2++;
            i4 |= i3;
        }
        return arrayList;
    }

    static boolean N(List<Long> list, int i2) {
        int i;
        int i3;
        int obj4;
        int obj5;
        if (i2 < size *= 64 && Long.compare(obj4, i) != 0) {
            if (Long.compare(obj4, i) != 0) {
                return 1;
            }
        }
        return 0;
    }

    static boolean P(String string) {
        boolean matches;
        int obj1;
        if (string != null && string.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && string.length() <= 310) {
            if (string.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)")) {
                if (string.length() <= 310) {
                    return 1;
                }
            }
        }
        return 0;
    }

    static final void m(o4 o4, String string2, Object object3) {
        int i;
        boolean equals;
        long obj4;
        List list = o4.H();
        i = 0;
        while (i < list.size()) {
            i++;
        }
        i = -1;
        s4 s4Var = t4.A();
        s4Var.B(string2);
        if (object3 instanceof Long) {
            s4Var.A((Long)object3.longValue());
        } else {
            if (object3 instanceof String != null) {
                s4Var.C((String)object3);
            } else {
                if (object3 instanceof Double) {
                    s4Var.z((Double)object3.doubleValue());
                } else {
                    if (object3 instanceof Bundle[]) {
                        s4Var.t(da.H((Bundle[])object3));
                    }
                }
            }
        }
        if (i >= 0) {
            o4.B(i, s4Var);
        }
        o4.w(s4Var);
    }

    static final boolean n(com.google.android.gms.measurement.internal.u u, com.google.android.gms.measurement.internal.na na2) {
        boolean obj0;
        r.j(u);
        r.j(na2);
        if (TextUtils.isEmpty(na2.b) && TextUtils.isEmpty(na2.I)) {
            if (TextUtils.isEmpty(na2.I)) {
                return 0;
            }
        }
        return 1;
    }

    static final t4 o(p4 p4, String string2) {
        Object next;
        boolean equals;
        Iterator obj2 = p4.E().iterator();
        for (t4 next : obj2) {
        }
        return null;
    }

    static final Object p(p4 p4, String string2) {
        Object empty;
        Bundle bundle;
        boolean next;
        String str;
        double d;
        String obj7;
        t4 obj6 = da.o(p4, string2);
        if (obj6 != null && obj6.T()) {
            if (obj6.T()) {
                return obj6.D();
            }
            obj7 = obj6.R();
            if (obj7 != null) {
                return Long.valueOf(obj6.z());
            }
            obj7 = obj6.P();
            if (obj7 != null) {
                return Double.valueOf(obj6.w());
            }
            if (obj6.y() > 0) {
                obj7 = new ArrayList();
                obj6 = obj6.E().iterator();
                while (obj6.hasNext()) {
                    empty = obj6.next();
                    if ((t4)empty != null) {
                    }
                    bundle = new Bundle();
                    Iterator iterator = (t4)empty.E().iterator();
                    while (iterator.hasNext()) {
                        next = iterator.next();
                        if ((t4)next.T()) {
                        } else {
                        }
                        if (next.R()) {
                        } else {
                        }
                        if (next.P()) {
                        }
                        bundle.putDouble(next.C(), next.w());
                        bundle.putLong(next.C(), next.z());
                        bundle.putString(next.C(), next.D());
                    }
                    if (!bundle.isEmpty()) {
                    }
                    obj7.add(bundle);
                    next = iterator.next();
                    if ((t4)next.T()) {
                    } else {
                    }
                    if (next.R()) {
                    } else {
                    }
                    if (next.P()) {
                    }
                    bundle.putDouble(next.C(), next.w());
                    bundle.putLong(next.C(), next.z());
                    bundle.putString(next.C(), next.D());
                }
                return (Bundle[])obj7.toArray(new Bundle[obj7.size()]);
            }
        }
        return null;
    }

    private final void q(StringBuilder stringBuilder, int i2, List<t4> list3) {
        Object next;
        int i;
        String str2;
        String str4;
        Long valueOf;
        boolean z;
        int valueOf2;
        String str;
        long str3;
        if (list3 == null) {
        }
        i2++;
        final Iterator obj8 = list3.iterator();
        while (obj8.hasNext()) {
            next = obj8.next();
            if ((t4)next != null) {
            }
            da.s(stringBuilder, obj7);
            stringBuilder.append("param {\n");
            valueOf2 = 0;
            if ((t4)next.S()) {
            } else {
            }
            str2 = valueOf2;
            da.v(stringBuilder, obj7, "name", str2);
            if (next.T()) {
            } else {
            }
            str4 = valueOf2;
            da.v(stringBuilder, obj7, "string_value", str4);
            if (next.R()) {
            } else {
            }
            valueOf = valueOf2;
            da.v(stringBuilder, obj7, "int_value", valueOf);
            if (next.P()) {
            }
            da.v(stringBuilder, obj7, "double_value", valueOf2);
            if (next.y() > 0) {
            }
            da.s(stringBuilder, obj7);
            stringBuilder.append("}\n");
            q(stringBuilder, obj7, next.E());
            valueOf2 = Double.valueOf(next.w());
            valueOf = Long.valueOf(next.z());
            str4 = next.D();
            str2 = this.a.D().e(next.C());
        }
    }

    private final void r(StringBuilder stringBuilder, int i2, n3 n33) {
        boolean valueOf;
        boolean z3;
        boolean z2;
        boolean z4;
        String str4;
        Object iterator;
        String str;
        boolean z;
        boolean valueOf2;
        int next;
        String str2;
        String str3;
        r3 obj8;
        if (n33 == null) {
        }
        da.s(stringBuilder, i2);
        stringBuilder.append("filter {\n");
        if (n33.D()) {
            da.v(stringBuilder, i2, "complement", Boolean.valueOf(n33.C()));
        }
        if (n33.F()) {
            da.v(stringBuilder, i2, "param_name", this.a.D().e(n33.A()));
        }
        String str6 = "}\n";
        if (n33.G()) {
            z2 = i2 + 1;
            iterator = n33.z();
            if (iterator == null) {
            } else {
                da.s(stringBuilder, z2);
                stringBuilder.append("string_filter {\n");
                if (iterator.E()) {
                    switch (i3) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case 4:
                            str = "ENDS_WITH";
                            break;
                        case 5:
                            str = "PARTIAL";
                            break;
                        case 6:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                    }
                    da.v(stringBuilder, z2, "match_type", str);
                }
                if (iterator.D()) {
                    da.v(stringBuilder, z2, "expression", iterator.z());
                }
                if (iterator.C()) {
                    da.v(stringBuilder, z2, "case_sensitive", Boolean.valueOf(iterator.B()));
                }
                if (iterator.w() > 0) {
                    da.s(stringBuilder, z2 + 1);
                    stringBuilder.append("expression_list {\n");
                    iterator = iterator.A().iterator();
                    for (String next2 : iterator) {
                        da.s(stringBuilder, z2 + 2);
                        stringBuilder.append(next2);
                        stringBuilder.append("\n");
                    }
                    stringBuilder.append(str6);
                }
                da.s(stringBuilder, z2);
                stringBuilder.append(str6);
            }
        }
        if (n33.E()) {
            da.w(stringBuilder, i2 + 1, "number_filter", n33.y());
        }
        da.s(stringBuilder, i2);
        stringBuilder.append(str6);
    }

    private static final void s(StringBuilder stringBuilder, int i2) {
        int i;
        String str;
        i = 0;
        while (i < i2) {
            stringBuilder.append("  ");
            i++;
        }
    }

    private static final String t(boolean z, boolean z2, boolean z3) {
        String obj1;
        StringBuilder stringBuilder = new StringBuilder();
        if (z != null) {
            stringBuilder.append("Dynamic ");
        }
        if (z2) {
            stringBuilder.append("Sequence ");
        }
        if (z3) {
            stringBuilder.append("Session-Scoped ");
        }
        return stringBuilder.toString();
    }

    private static final void u(StringBuilder stringBuilder, int i2, String string3, f5 f54) {
        int next;
        int i3;
        Object next2;
        Integer valueOf;
        Long valueOf2;
        int longValue;
        int i;
        int i4;
        int obj11;
        int obj12;
        if (f54 == 0) {
        }
        final int obj10 = 3;
        da.s(stringBuilder, obj10);
        stringBuilder.append(string3);
        stringBuilder.append(" {\n");
        int i5 = 10;
        next = 4;
        final String str = ", ";
        final int i7 = 0;
        if (f54.x() != 0) {
            da.s(stringBuilder, next);
            stringBuilder.append("results: ");
            obj11 = f54.G().iterator();
            i3 = i7;
            while (obj11.hasNext()) {
                if (i3 != 0) {
                }
                stringBuilder.append((Long)obj11.next());
                i3 = longValue;
                stringBuilder.append(str);
            }
            stringBuilder.append(i5);
        }
        if (f54.z() != 0) {
            da.s(stringBuilder, next);
            stringBuilder.append("status: ");
            obj11 = f54.I().iterator();
            i3 = i7;
            while (obj11.hasNext()) {
                if (i3 != 0) {
                }
                stringBuilder.append((Long)obj11.next());
                i3 = longValue;
                stringBuilder.append(str);
            }
            stringBuilder.append(i5);
        }
        int i6 = 0;
        String str2 = "}\n";
        if (f54.w() != 0) {
            da.s(stringBuilder, next);
            stringBuilder.append("dynamic_filter_timestamps: {");
            obj11 = f54.F().iterator();
            next2 = i7;
            while (obj11.hasNext()) {
                longValue = obj11.next();
                if (next2 != 0) {
                }
                if ((n4)longValue.D()) {
                } else {
                }
                valueOf = i6;
                stringBuilder.append(valueOf);
                stringBuilder.append(":");
                if (longValue.C()) {
                } else {
                }
                valueOf2 = i6;
                stringBuilder.append(valueOf2);
                next2 = i;
                valueOf2 = Long.valueOf(longValue.x());
                valueOf = Integer.valueOf(longValue.w());
                stringBuilder.append(str);
            }
            stringBuilder.append(str2);
        }
        if (f54.y() != 0) {
            da.s(stringBuilder, next);
            stringBuilder.append("sequence_filter_timestamps: {");
            obj11 = f54.H().iterator();
            obj12 = i7;
            while (obj11.hasNext()) {
                Object next3 = obj11.next();
                if (obj12 != null) {
                }
                if ((h5)next3.E()) {
                } else {
                }
                obj12 = i6;
                stringBuilder.append(obj12);
                stringBuilder.append(": [");
                obj12 = next3.B().iterator();
                next = i7;
                while (obj12.hasNext()) {
                    if (next != 0) {
                    }
                    stringBuilder.append((Long)obj12.next().longValue());
                    next = i4;
                    stringBuilder.append(str);
                }
                stringBuilder.append("]");
                obj12 = next2;
                if (next != 0) {
                }
                stringBuilder.append((Long)obj12.next().longValue());
                next = i4;
                stringBuilder.append(str);
                obj12 = Integer.valueOf(next3.x());
                stringBuilder.append(str);
            }
            stringBuilder.append(str2);
        }
        da.s(stringBuilder, obj10);
        stringBuilder.append(str2);
    }

    private static final void v(StringBuilder stringBuilder, int i2, String string3, Object object4) {
        if (object4 == null) {
        }
        da.s(stringBuilder, i2++);
        stringBuilder.append(string3);
        stringBuilder.append(": ");
        stringBuilder.append(object4);
        stringBuilder.append('\n');
    }

    private static final void w(StringBuilder stringBuilder, int i2, String string3, r3 r34) {
        int i;
        String str;
        String obj3;
        String obj4;
        if (r34 == null) {
        }
        da.s(stringBuilder, i2);
        stringBuilder.append(string3);
        stringBuilder.append(" {\n");
        if (r34.C()) {
            obj3 = r34.H();
            if (obj3 != 1) {
                if (obj3 != 2) {
                    if (obj3 != 3) {
                        obj3 = obj3 != 4 ? "BETWEEN" : "EQUAL";
                    } else {
                        obj3 = "GREATER_THAN";
                    }
                } else {
                    obj3 = "LESS_THAN";
                }
            } else {
                obj3 = "UNKNOWN_COMPARISON_TYPE";
            }
            da.v(stringBuilder, i2, "comparison_type", obj3);
        }
        if (r34.E()) {
            da.v(stringBuilder, i2, "match_as_float", Boolean.valueOf(r34.B()));
        }
        if (r34.D()) {
            da.v(stringBuilder, i2, "comparison_value", r34.y());
        }
        if (r34.G()) {
            da.v(stringBuilder, i2, "min_comparison_value", r34.A());
        }
        if (r34.F()) {
            da.v(stringBuilder, i2, "max_comparison_value", r34.z());
        }
        da.s(stringBuilder, i2);
        stringBuilder.append("}\n");
    }

    static int x(y4 y4, String string2) {
        int i;
        boolean equals;
        i = 0;
        while (i < y4.i0()) {
            i++;
        }
        return -1;
    }

    final <T extends android.os.Parcelable> T A(byte[] bArr, Parcelable.Creator<T> parcelable$Creator2) {
        if (bArr == null) {
            return 0;
        }
        final Parcel obtain = Parcel.obtain();
        final int i2 = 0;
        obtain.unmarshall(bArr, i2, bArr.length);
        obtain.setDataPosition(i2);
        obtain.recycle();
        return (Parcelable)creator2.createFromParcel(obtain);
    }

    @Override // com.google.android.gms.measurement.internal.r9
    final com.google.android.gms.measurement.internal.u B(b b) {
        Object str;
        String string;
        String str2;
        Bundle bundle = z(b.e(), true);
        str = "_o";
        str = bundle.get(str);
        if (bundle.containsKey(str) && str != null) {
            str = bundle.get(str);
            if (str != null) {
                string = str.toString();
            } else {
                string = "app";
            }
        } else {
        }
        if (z5.b(b.d()) == null) {
            str2 = b.d();
        }
        s sVar = new s(bundle);
        super(str2, sVar, string, b.a(), obj7);
        return uVar;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    final p4 C(com.google.android.gms.measurement.internal.p p) {
        com.google.android.gms.measurement.internal.s sVar;
        s4 s4Var;
        com.google.android.gms.measurement.internal.s sVar2;
        final o4 o4Var = p4.A();
        o4Var.D(p.e);
        r rVar = new r(p.f);
        while (rVar.hasNext()) {
            String str = rVar.b();
            s4Var = t4.A();
            s4Var.B(str);
            sVar = p.f.n2(str);
            r.j(sVar);
            L(s4Var, sVar);
            o4Var.w(s4Var);
        }
        return (p4)o4Var.l();
    }

    @Override // com.google.android.gms.measurement.internal.r9
    final String E(x4 x4) {
        String iterator2;
        String str7;
        int i;
        boolean iterator3;
        boolean valueOf4;
        boolean valueOf14;
        boolean valueOf21;
        boolean valueOf8;
        boolean valueOf9;
        boolean valueOf15;
        boolean valueOf26;
        boolean valueOf13;
        boolean valueOf2;
        boolean valueOf7;
        boolean valueOf5;
        boolean valueOf3;
        boolean valueOf19;
        boolean valueOf16;
        boolean valueOf10;
        boolean valueOf23;
        boolean valueOf;
        boolean valueOf6;
        boolean z;
        Object iterator;
        String str10;
        String str8;
        String str;
        String str2;
        String str9;
        String str3;
        String str4;
        Object str11;
        boolean next;
        boolean valueOf17;
        boolean valueOf22;
        boolean valueOf25;
        int i2;
        boolean valueOf20;
        boolean valueOf24;
        boolean valueOf18;
        long str5;
        int valueOf11;
        int valueOf12;
        long str6;
        if (x4 == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nbatch {\n");
        Iterator obj12 = x4.z().iterator();
        str7 = "}\n";
        while (obj12.hasNext()) {
            iterator2 = obj12.next();
            i = 1;
            da.s(stringBuilder, i);
            stringBuilder.append("bundle {\n");
            if (iterator2 != null && (z4)iterator2.h1()) {
            }
            str7 = "}\n";
            i = 1;
            da.s(stringBuilder, i);
            stringBuilder.append("bundle {\n");
            if (iterator2.h1()) {
            }
            str8 = "platform";
            da.v(stringBuilder, i, str8, iterator2.G());
            if (iterator2.d1()) {
            }
            if (iterator2.n1()) {
            }
            if (iterator2.b1()) {
            }
            if (iterator2.v0()) {
            }
            da.v(stringBuilder, i, "gmp_app_id", iterator2.D());
            da.v(stringBuilder, i, "admob_app_id", iterator2.K1());
            da.v(stringBuilder, i, "app_id", iterator2.L1());
            da.v(stringBuilder, i, "app_version", iterator2.x());
            if (iterator2.s0()) {
            }
            str2 = "firebase_instance_id";
            da.v(stringBuilder, i, str2, iterator2.B());
            if (iterator2.a1()) {
            }
            str9 = "app_store";
            da.v(stringBuilder, i, str9, iterator2.w());
            if (iterator2.m1()) {
            }
            if (iterator2.k1()) {
            }
            if (iterator2.c1()) {
            }
            if (iterator2.g1()) {
            }
            if (iterator2.f1()) {
            }
            da.v(stringBuilder, i, "app_instance_id", iterator2.M1());
            da.v(stringBuilder, i, "resettable_device_id", iterator2.H());
            da.v(stringBuilder, i, "ds_id", iterator2.A());
            if (iterator2.e1()) {
            }
            da.v(stringBuilder, i, "os_version", iterator2.F());
            da.v(stringBuilder, i, "device_model", iterator2.z());
            da.v(stringBuilder, i, "user_default_language", iterator2.I());
            if (iterator2.l1()) {
            }
            if (iterator2.u0()) {
            }
            if (iterator2.j1()) {
            }
            da.v(stringBuilder, i, "health_monitor", iterator2.E());
            str11 = c3.m0;
            next = 0;
            if (!this.a.z().B(next, str11) && iterator2.r0() && Long.compare(l3, i2) != 0) {
            }
            if (iterator2.i1()) {
            }
            if (iterator2.w0()) {
            }
            iterator = iterator2.L();
            str10 = "name";
            i2 = 2;
            if (iterator == null) {
            } else {
            }
            iterator = iterator.iterator();
            while (iterator.hasNext()) {
                valueOf20 = iterator.next();
                if ((j5)valueOf20 != null) {
                }
                da.s(stringBuilder, i2);
                stringBuilder.append("user_property {\n");
                if ((j5)valueOf20.N()) {
                } else {
                }
                valueOf11 = next;
                da.v(stringBuilder, i2, "set_timestamp_millis", valueOf11);
                da.v(stringBuilder, i2, str10, this.a.D().f(valueOf20.B()));
                String str43 = "string_value";
                da.v(stringBuilder, i2, str43, valueOf20.C());
                if (valueOf20.M()) {
                } else {
                }
                valueOf12 = next;
                da.v(stringBuilder, i2, "int_value", valueOf12);
                boolean z7 = valueOf20.L();
                if (z7) {
                } else {
                }
                valueOf20 = next;
                da.v(stringBuilder, i2, "double_value", valueOf20);
                da.s(stringBuilder, i2);
                stringBuilder.append(str7);
                valueOf20 = Double.valueOf(valueOf20.w());
                valueOf12 = Long.valueOf(valueOf20.x());
                valueOf11 = Long.valueOf(valueOf20.y());
            }
            iterator3 = iterator2.J();
            if (iterator3 == null) {
            } else {
            }
            iterator3 = iterator3.iterator();
            while (iterator3.hasNext()) {
                next = iterator3.next();
                da.s(stringBuilder, i2);
                stringBuilder.append("audience_membership {\n");
                if (next != 0 && (l4)next.G()) {
                }
                da.s(stringBuilder, i2);
                stringBuilder.append("audience_membership {\n");
                if (next.G()) {
                }
                if (next.H()) {
                }
                da.u(stringBuilder, i2, "current_data", next.z());
                if (next.I()) {
                }
                da.s(stringBuilder, i2);
                stringBuilder.append(str7);
                da.u(stringBuilder, i2, "previous_data", next.A());
                da.v(stringBuilder, i2, "new_audience", Boolean.valueOf(next.F()));
                da.v(stringBuilder, i2, "audience_id", Integer.valueOf(next.w()));
            }
            iterator2 = iterator2.K();
            if (iterator2 == null) {
            } else {
            }
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                iterator3 = iterator2.next();
                da.s(stringBuilder, i2);
                stringBuilder.append("event {\n");
                da.v(stringBuilder, i2, str10, this.a.D().d((p4)iterator3.D()));
                if (iterator3 != null && iterator3.P()) {
                }
                da.s(stringBuilder, i2);
                stringBuilder.append("event {\n");
                da.v(stringBuilder, i2, str10, this.a.D().d(iterator3.D()));
                if (iterator3.P()) {
                }
                if (iterator3.O()) {
                }
                if (iterator3.N()) {
                }
                if (iterator3.x()) {
                }
                da.s(stringBuilder, i2);
                stringBuilder.append(str7);
                q(stringBuilder, i2, iterator3.E());
                da.v(stringBuilder, i2, "count", Integer.valueOf(iterator3.w()));
                da.v(stringBuilder, i2, "previous_timestamp_millis", Long.valueOf(iterator3.y()));
                da.v(stringBuilder, i2, "timestamp_millis", Long.valueOf(iterator3.z()));
            }
            da.s(stringBuilder, i);
            stringBuilder.append(str7);
            iterator3 = iterator2.next();
            da.s(stringBuilder, i2);
            stringBuilder.append("event {\n");
            da.v(stringBuilder, i2, str10, this.a.D().d((p4)iterator3.D()));
            if (iterator3 != null && iterator3.P()) {
            }
            da.s(stringBuilder, i2);
            stringBuilder.append("event {\n");
            da.v(stringBuilder, i2, str10, this.a.D().d(iterator3.D()));
            if (iterator3.P()) {
            }
            if (iterator3.O()) {
            }
            if (iterator3.N()) {
            }
            if (iterator3.x()) {
            }
            da.s(stringBuilder, i2);
            stringBuilder.append(str7);
            q(stringBuilder, i2, iterator3.E());
            da.v(stringBuilder, i2, "count", Integer.valueOf(iterator3.w()));
            da.v(stringBuilder, i2, "previous_timestamp_millis", Long.valueOf(iterator3.y()));
            da.v(stringBuilder, i2, "timestamp_millis", Long.valueOf(iterator3.z()));
            next = iterator3.next();
            da.s(stringBuilder, i2);
            stringBuilder.append("audience_membership {\n");
            if (next != 0 && (l4)next.G()) {
            }
            da.s(stringBuilder, i2);
            stringBuilder.append("audience_membership {\n");
            if (next.G()) {
            }
            if (next.H()) {
            }
            da.u(stringBuilder, i2, "current_data", next.z());
            if (next.I()) {
            }
            da.s(stringBuilder, i2);
            stringBuilder.append(str7);
            da.u(stringBuilder, i2, "previous_data", next.A());
            da.v(stringBuilder, i2, "new_audience", Boolean.valueOf(next.F()));
            da.v(stringBuilder, i2, "audience_id", Integer.valueOf(next.w()));
            valueOf20 = iterator.next();
            if ((j5)valueOf20 != null) {
            }
            da.s(stringBuilder, i2);
            stringBuilder.append("user_property {\n");
            if ((j5)valueOf20.N()) {
            } else {
            }
            valueOf11 = next;
            da.v(stringBuilder, i2, "set_timestamp_millis", valueOf11);
            da.v(stringBuilder, i2, str10, this.a.D().f(valueOf20.B()));
            str43 = "string_value";
            da.v(stringBuilder, i2, str43, valueOf20.C());
            if (valueOf20.M()) {
            } else {
            }
            valueOf12 = next;
            da.v(stringBuilder, i2, "int_value", valueOf12);
            z7 = valueOf20.L();
            if (z7) {
            } else {
            }
            valueOf20 = next;
            da.v(stringBuilder, i2, "double_value", valueOf20);
            da.s(stringBuilder, i2);
            stringBuilder.append(str7);
            valueOf20 = Double.valueOf(valueOf20.w());
            valueOf12 = Long.valueOf(valueOf20.x());
            valueOf11 = Long.valueOf(valueOf20.y());
            da.v(stringBuilder, i, "consent_signals", iterator2.y());
            da.v(stringBuilder, i, "retry_counter", Integer.valueOf(iterator2.q1()));
            if (iterator2.r0()) {
            }
            if (Long.compare(l3, i2) != 0) {
            }
            da.v(stringBuilder, i, "android_id", Long.valueOf(iterator2.t1()));
            da.v(stringBuilder, i, "service_upload", Boolean.valueOf(iterator2.q0()));
            da.v(stringBuilder, i, "bundle_sequential_index", Integer.valueOf(iterator2.X0()));
            da.v(stringBuilder, i, "time_zone_offset_minutes", Integer.valueOf(iterator2.r1()));
            da.v(stringBuilder, i, "limited_ad_tracking", Boolean.valueOf(iterator2.p0()));
            da.v(stringBuilder, i, "previous_bundle_end_timestamp_millis", Long.valueOf(iterator2.z1()));
            da.v(stringBuilder, i, "previous_bundle_start_timestamp_millis", Long.valueOf(iterator2.A1()));
            da.v(stringBuilder, i, "end_timestamp_millis", Long.valueOf(iterator2.x1()));
            da.v(stringBuilder, i, "start_timestamp_millis", Long.valueOf(iterator2.C1()));
            da.v(stringBuilder, i, "upload_timestamp_millis", Long.valueOf(iterator2.D1()));
            da.v(stringBuilder, i, "dev_cert_hash", Long.valueOf(iterator2.v1()));
            da.v(stringBuilder, i, "app_version_major", Integer.valueOf(iterator2.V()));
            da.v(stringBuilder, i, "config_version", Long.valueOf(iterator2.u1()));
            da.v(stringBuilder, i, "dynamite_version", Long.valueOf(iterator2.w1()));
            da.v(stringBuilder, i, "uploading_gmp_version", Long.valueOf(iterator2.E1()));
            da.v(stringBuilder, i, "gmp_version", Long.valueOf(iterator2.y1()));
            da.v(stringBuilder, i, "protocol_version", Integer.valueOf(iterator2.p1()));
        }
        stringBuilder.append(str7);
        return stringBuilder.toString();
    }

    @Override // com.google.android.gms.measurement.internal.r9
    final String F(l3 l3) {
        boolean valueOf;
        boolean z;
        String str;
        int next;
        String str2;
        boolean empty;
        Iterator obj6;
        if (l3 == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nevent_filter {\n");
        int i2 = 0;
        if (l3.K()) {
            da.v(stringBuilder, i2, "filter_id", Integer.valueOf(l3.x()));
        }
        da.v(stringBuilder, i2, "event_name", this.a.D().d(l3.C()));
        String str5 = da.t(l3.G(), l3.H(), l3.I());
        if (!str5.isEmpty()) {
            da.v(stringBuilder, i2, "filter_type", str5);
        }
        int i3 = 1;
        if (l3.J()) {
            da.w(stringBuilder, i3, "event_count_filter", l3.B());
        }
        if (l3.w() > 0) {
            stringBuilder.append("  filters {\n");
            obj6 = l3.D().iterator();
            for (n3 empty : obj6) {
                r(stringBuilder, 2, empty);
            }
        }
        da.s(stringBuilder, i3);
        stringBuilder.append("}\n}\n");
        return stringBuilder.toString();
    }

    @Override // com.google.android.gms.measurement.internal.r9
    final String G(t3 t3) {
        boolean valueOf;
        String str;
        boolean empty;
        if (t3 == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nproperty_filter {\n");
        final int i3 = 0;
        if (t3.F()) {
            da.v(stringBuilder, i3, "filter_id", Integer.valueOf(t3.w()));
        }
        da.v(stringBuilder, i3, "property_name", this.a.D().f(t3.A()));
        String str4 = da.t(t3.C(), t3.D(), t3.E());
        if (!str4.isEmpty()) {
            da.v(stringBuilder, i3, "filter_type", str4);
        }
        r(stringBuilder, 1, t3.x());
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    final List<Long> I(List<Long> list, List<Integer> list2) {
        com.google.android.gms.measurement.internal.o3 cmp;
        String valueOf;
        long str;
        int i;
        int i2;
        int obj8;
        Object obj9;
        ArrayList arrayList = new ArrayList(list);
        obj8 = list2.iterator();
        while (obj8.hasNext()) {
            obj9 = obj8.next();
            if ((Integer)obj9.intValue() < 0) {
            } else {
            }
            intValue2 /= 64;
            if (cmp >= arrayList.size()) {
            } else {
            }
            arrayList.set(cmp, Long.valueOf(longValue2 &= i));
            this.a.b().w().c("Ignoring bit index greater than bitSet size", obj9, Integer.valueOf(arrayList.size()));
            this.a.b().w().b("Ignoring negative bit index to be cleared", obj9);
        }
        obj8 = arrayList.size();
        obj9--;
        obj8 = i2;
        while (obj8 >= 0) {
            if (Long.compare(longValue, str) != 0) {
                break;
            } else {
            }
            obj9 = obj8 + -1;
            obj8 = i2;
        }
        return arrayList.subList(0, obj8);
    }

    final Map<String, Object> K(Bundle bundle, boolean z2) {
        Object next;
        Object obj2;
        boolean arrayList;
        int length;
        com.google.android.gms.measurement.internal.b3 b3Var;
        int i;
        Object obj;
        boolean z;
        HashMap hashMap = new HashMap();
        Iterator iterator = bundle.keySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            obj2 = bundle.get((String)next);
            de.b();
            if (this.a.z().B(0, c3.s0)) {
            } else {
            }
            if (!obj2 instanceof Bundle[] && obj2 instanceof ArrayList == null) {
            } else {
            }
            if (z2) {
            }
            arrayList = new ArrayList();
            b3Var = 0;
            if (obj2 instanceof Parcelable[]) {
            } else {
            }
            if (obj2 instanceof ArrayList != null) {
            } else {
            }
            if (obj2 instanceof Bundle != null) {
            }
            hashMap.put(next, arrayList);
            arrayList.add(K((Bundle)obj2, b3Var));
            i = b3Var;
            while (i < (ArrayList)obj2.size()) {
                obj = obj2.get(i);
                if (obj instanceof Bundle != null) {
                }
                i++;
                arrayList.add(K((Bundle)obj, b3Var));
            }
            obj = obj2.get(i);
            if (obj instanceof Bundle != null) {
            }
            i++;
            arrayList.add(K((Bundle)obj, b3Var));
            i = b3Var;
            while (i < obj2.length) {
                obj = (Parcelable[])obj2[i];
                if (obj instanceof Bundle != null) {
                }
                i++;
                arrayList.add(K((Bundle)obj, b3Var));
            }
            obj = obj2[i];
            if (obj instanceof Bundle != null) {
            }
            i++;
            arrayList.add(K((Bundle)obj, b3Var));
            if (obj2 instanceof ArrayList == null) {
            } else {
            }
            if (obj2 instanceof Bundle != null) {
            } else {
            }
            if (obj2 != null) {
            }
            hashMap.put(next, obj2);
            if (!obj2 instanceof Parcelable[] && obj2 instanceof ArrayList == null) {
            } else {
            }
            if (obj2 instanceof ArrayList == null) {
            } else {
            }
            if (obj2 instanceof Bundle != null) {
            } else {
            }
        }
        return hashMap;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    final void L(s4 s4, Object object2) {
        r.j(object2);
        s4.y();
        s4.w();
        s4.v();
        s4.x();
        if (object2 instanceof String != null) {
            s4.C((String)object2);
        }
        if (object2 instanceof Long) {
            s4.A((Long)object2.longValue());
        }
        if (object2 instanceof Double) {
            s4.z((Double)object2.doubleValue());
        }
        if (object2 instanceof Bundle[]) {
            s4.t(da.H((Bundle[])object2));
        }
        this.a.b().r().b("Ignoring invalid (type) event param value", object2);
    }

    @Override // com.google.android.gms.measurement.internal.r9
    final void M(i5 i5, Object object2) {
        r.j(object2);
        i5.u();
        i5.t();
        i5.s();
        if (object2 instanceof String != null) {
            i5.z((String)object2);
        }
        if (object2 instanceof Long) {
            i5.w((Long)object2.longValue());
        }
        if (object2 instanceof Double) {
            i5.v((Double)object2.doubleValue());
        }
        this.a.b().r().b("Ignoring invalid (type) user attribute value", object2);
    }

    @Override // com.google.android.gms.measurement.internal.r9
    final boolean O(long l, long l2) {
        int cmp;
        int obj4;
        cmp = 0;
        if (Long.compare(l, cmp) != 0 && Long.compare(obj6, cmp) > 0 && Long.compare(obj4, obj6) > 0) {
            if (Long.compare(obj6, cmp) > 0) {
                if (Long.compare(obj4, obj6) > 0) {
                }
                return 0;
            }
        }
        return 1;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    final byte[] Q(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
            com.google.android.gms.measurement.internal.b5 b5Var = this.a;
            b5Var = b5Var.b();
            b5Var = b5Var.r();
            b5Var.b("Failed to gzip content", bArr);
            throw bArr;
        }
    }

    @Override // com.google.android.gms.measurement.internal.r9
    protected final boolean l() {
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    final long y(byte[] bArr) {
        r.j(bArr);
        this.a.N().h();
        MessageDigest messageDigest = ia.s();
        if (messageDigest == null) {
            this.a.b().r().a("Failed to get MD5");
            return 0;
        }
        return ia.q0(messageDigest.digest(bArr));
    }

    final Bundle z(Map<String, Object> map, boolean z2) {
        Object next;
        Object doubleValue;
        int arrayList;
        boolean z;
        int size;
        int i;
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            doubleValue = map.get((String)next);
            arrayList = 0;
            if (doubleValue == null) {
            } else {
            }
            if (doubleValue instanceof Long) {
            } else {
            }
            if (doubleValue instanceof Double) {
            } else {
            }
            if (doubleValue instanceof ArrayList != null) {
            } else {
            }
            bundle2.putString(next, doubleValue.toString());
            if (z2) {
            }
            de.b();
            z = 0;
            if (this.a.z().B(arrayList, c3.s0)) {
            } else {
            }
            arrayList = new ArrayList();
            i = z;
            while (i < (ArrayList)doubleValue.size()) {
                arrayList.add(z((Map)doubleValue.get(i), z));
                i++;
            }
            bundle2.putParcelableArrayList(next, arrayList);
            arrayList.add(z((Map)doubleValue.get(i), z));
            i++;
            arrayList = new ArrayList();
            i = z;
            while (i < (ArrayList)doubleValue.size()) {
                arrayList.add(z((Map)doubleValue.get(i), z));
                i++;
            }
            bundle2.putParcelableArray(next, (Parcelable[])arrayList.toArray(new Parcelable[z]));
            arrayList.add(z((Map)doubleValue.get(i), z));
            i++;
            bundle2.putDouble(next, (Double)doubleValue.doubleValue());
            bundle2.putLong(next, (Long)doubleValue.longValue());
            bundle2.putString(next, arrayList);
        }
        return bundle2;
    }
}
