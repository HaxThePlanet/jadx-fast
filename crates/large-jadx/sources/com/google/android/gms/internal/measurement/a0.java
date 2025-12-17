package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class a0 extends com.google.android.gms.internal.measurement.x {
    protected a0() {
        super();
        this.a.add(n0.zzc);
        this.a.add(n0.zzl);
        this.a.add(n0.zzm);
        this.a.add(n0.zzn);
        this.a.add(n0.zzt);
        this.a.add(n0.zzp);
        this.a.add(n0.zzu);
        this.a.add(n0.zzz);
        this.a.add(n0.zzP);
        this.a.add(n0.zzac);
        this.a.add(n0.zzaf);
        this.a.add(n0.zzai);
        this.a.add(n0.zzaj);
    }

    private static com.google.android.gms.internal.measurement.q c(com.google.android.gms.internal.measurement.b5 b5, List<com.google.android.gms.internal.measurement.q> list2) {
        Object arrayList;
        int i2 = 2;
        b6.i(n0.zzz.name(), i2, list2);
        int i = 0;
        int i3 = 1;
        com.google.android.gms.internal.measurement.q qVar2 = b5.b((q)list2.get(i3));
        if (!qVar2 instanceof f) {
        } else {
            arrayList = new ArrayList();
            if (list2.size() > i2) {
                arrayList = list2.subList(i2, list2.size());
            }
            p obj7 = new p(b5.b((q)list2.get(i)).zzi(), (f)qVar2.v(), arrayList, b5);
            return obj7;
        }
        obj7 = new Object[i3];
        obj7[i] = qVar2.getClass().getCanonicalName();
        IllegalArgumentException obj6 = new IllegalArgumentException(String.format("FN requires an ArrayValue of parameter names found %s", obj7));
        throw obj6;
    }

    public final com.google.android.gms.internal.measurement.q a(String string, com.google.android.gms.internal.measurement.b5 b52, List<com.google.android.gms.internal.measurement.q> list3) {
        int i;
        int equals;
        int i4;
        int i3;
        int i2;
        com.google.android.gms.internal.measurement.q obj9;
        Object obj10;
        Object obj11;
        com.google.android.gms.internal.measurement.n0 zza = n0.zza;
        int ordinal = b6.e(string).ordinal();
        int i5 = 3;
        int i6 = 2;
        final int i7 = 1;
        final int i8 = 0;
        final String str3 = "return";
        if (ordinal != i6 && ordinal != 15 && ordinal != 25 && ordinal != 41 && ordinal != 54 && ordinal != 57 && ordinal != 19 && ordinal != 20 && ordinal != 60 && ordinal != 61) {
            if (ordinal != 15) {
                if (ordinal != 25) {
                    if (ordinal != 41) {
                        if (ordinal != 54) {
                            str3 = "return";
                            if (ordinal != 57) {
                                if (ordinal != 19) {
                                    if (ordinal != 20) {
                                        if (ordinal != 60) {
                                            if (ordinal != 61) {
                                                switch (ordinal) {
                                                    case 11:
                                                        obj10 = new f(list3);
                                                        return b52.a().c(obj10);
                                                    case 12:
                                                        b6.h(n0.zzm.name(), i8, list3);
                                                        return q.k;
                                                    case 13:
                                                        obj9 = b52.b((q)list3.get(i8));
                                                        obj9 = b52.c((f)obj9);
                                                        obj9 = q.h;
                                                        return obj9;
                                                    default:
                                                        super.b(string);
                                                        throw 0;
                                                }
                                                obj9 = q.h;
                                            }
                                            b6.h(n0.zzaj.name(), i5, list3);
                                            if (b52.b((q)list3.get(i8)).d().booleanValue()) {
                                                obj9 = b52.b((q)list3.get(i7));
                                            } else {
                                                obj9 = b52.b((q)list3.get(i6));
                                            }
                                            return obj9;
                                        }
                                        b6.h(n0.zzai.name(), i5, list3);
                                        com.google.android.gms.internal.measurement.q qVar3 = b52.b((q)list3.get(i7));
                                        obj11 = b52.b((q)list3.get(i6));
                                        if (!qVar3 instanceof f) {
                                        } else {
                                            if (!obj11 instanceof f) {
                                            } else {
                                                equals = i;
                                                while (i < (f)qVar3.q()) {
                                                    equals = b52.b((f)obj11.s(i));
                                                    equals = i7;
                                                    i++;
                                                    equals = i8;
                                                }
                                                equals = b52.b(obj11.s(qVar3.q()));
                                                obj9 = (h)equals.c();
                                                if (obj9 += i7 == obj11.q() && equals instanceof h && !obj9.equals(str3) && !obj9.equals("continue")) {
                                                    equals = b52.b(obj11.s(qVar3.q()));
                                                    if (equals instanceof h) {
                                                        obj9 = (h)equals.c();
                                                        if (!obj9.equals(str3)) {
                                                            if (!obj9.equals("continue")) {
                                                            }
                                                        }
                                                        return equals;
                                                    }
                                                }
                                                return q.h;
                                            }
                                            obj9 = new IllegalArgumentException("Malformed SWITCH statement, case statements are not a list");
                                            throw obj9;
                                        }
                                        obj9 = new IllegalArgumentException("Malformed SWITCH statement, cases are not a list");
                                        throw obj9;
                                    }
                                    b6.i(n0.zzu.name(), i6, list3);
                                    obj9 = a0.c(b52, list3);
                                    obj11 = obj9;
                                    if ((j)obj11.c() == null) {
                                        b52.g("", obj9);
                                    } else {
                                        b52.g(obj11.c(), obj9);
                                    }
                                    return obj9;
                                }
                            }
                            if (list3.isEmpty()) {
                                obj9 = q.l;
                            } else {
                                b6.h(n0.zzaf.name(), i7, list3);
                                obj10 = new h(str3, b52.b((q)list3.get(i8)));
                                obj9 = obj10;
                            }
                            return obj9;
                        }
                        obj9 = new f(list3);
                        return obj9;
                    }
                    b6.i(n0.zzP.name(), i6, list3);
                    if (list3.size() > i6) {
                        i2 = b52.b((q)list3.get(i6));
                    }
                    obj11 = q.h;
                    if (b52.b((q)list3.get(i8)).d().booleanValue()) {
                        obj9 = b52.c((f)b52.b((q)list3.get(i7)));
                    } else {
                        if (i2 != 0) {
                            obj9 = b52.c((f)i2);
                        } else {
                            obj9 = obj11;
                        }
                    }
                    if (obj9 instanceof h) {
                        return obj9;
                    }
                    return obj11;
                }
                return a0.c(b52, list3);
            }
            b6.h(n0.zzm.name(), i8, list3);
            return q.j;
        }
        b6.h(n0.zzc.name(), i5, list3);
        String str = b52.b((q)list3.get(i7)).zzi();
        obj11 = b52.b((q)list3.get(i6));
        if (!obj11 instanceof f) {
        } else {
            if (str.isEmpty()) {
            } else {
                return b52.b((q)list3.get(i8)).m(str, b52, (f)obj11.v());
            }
            obj9 = new IllegalArgumentException("Function name for apply is undefined");
            throw obj9;
        }
        obj10 = new Object[i7];
        obj10[i8] = obj11.getClass().getCanonicalName();
        obj9 = new IllegalArgumentException(String.format("Function arguments for Apply are not a list found %s", obj10));
        throw obj9;
    }
}
