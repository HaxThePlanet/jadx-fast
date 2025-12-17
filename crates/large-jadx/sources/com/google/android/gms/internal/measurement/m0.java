package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class m0 extends com.google.android.gms.internal.measurement.x {
    protected m0() {
        super();
        this.a.add(n0.zzd);
        this.a.add(n0.zzo);
        this.a.add(n0.zzr);
        this.a.add(n0.zzs);
        this.a.add(n0.zzy);
        this.a.add(n0.zzH);
        this.a.add(n0.zzJ);
        this.a.add(n0.zzK);
        this.a.add(n0.zzX);
        this.a.add(n0.zzag);
        this.a.add(n0.zzak);
        this.a.add(n0.zzal);
        this.a.add(n0.zzam);
    }

    public final com.google.android.gms.internal.measurement.q a(String string, com.google.android.gms.internal.measurement.b5 b52, List<com.google.android.gms.internal.measurement.q> list3) {
        int doubleValue;
        int i3;
        int i6;
        int i4;
        int i5;
        int i2;
        int i;
        int obj7;
        boolean obj8;
        Object obj9;
        com.google.android.gms.internal.measurement.n0 zza = n0.zza;
        doubleValue = b6.e(string).ordinal();
        i3 = 3;
        i2 = 2;
        final int i10 = 1;
        i = 0;
        if (doubleValue != i3 && doubleValue != 14 && doubleValue != 24 && doubleValue != 33 && doubleValue != 49 && doubleValue != 58 && doubleValue != 17 && doubleValue != 18 && doubleValue != 35 && doubleValue != 36) {
            if (doubleValue != 14) {
                if (doubleValue != 24) {
                    if (doubleValue != 33) {
                        if (doubleValue != 49) {
                            if (doubleValue != 58) {
                                if (doubleValue != 17) {
                                    if (doubleValue != 18) {
                                        if (doubleValue != 35) {
                                            if (doubleValue != 36) {
                                                switch (doubleValue) {
                                                    case 62:
                                                        b6.h(n0.zzak.name(), i10, list3);
                                                        obj7 = b52.b((q)list3.get(i));
                                                        obj7 = "undefined";
                                                        obj7 = "boolean";
                                                        obj7 = "number";
                                                        obj7 = "string";
                                                        obj7 = "function";
                                                        obj7 = "object";
                                                        obj8 = new u(obj7);
                                                        return obj8;
                                                        obj9 = new Object[i10];
                                                        obj9[i] = obj7;
                                                        obj8 = new IllegalArgumentException(String.format("Unsupported value type %s in typeof", obj9));
                                                        throw obj8;
                                                    case 63:
                                                        b6.h(n0.zzal.name(), i, list3);
                                                        return q.h;
                                                    case 64:
                                                        b6.i(n0.zzam.name(), i10, list3);
                                                        obj7 = list3.iterator();
                                                        obj9 = b52.b((q)obj7.next());
                                                        b52.e(obj9.zzi(), q.h);
                                                        obj8 = new Object[i10];
                                                        obj8[i] = obj9.getClass().getCanonicalName();
                                                        obj7 = new IllegalArgumentException(String.format("Expected string for var name. got %s", obj8));
                                                        throw obj7;
                                                        return q.h;
                                                    default:
                                                        super.b(string);
                                                        throw 0;
                                                }
                                            }
                                        }
                                        b6.h(n0.zzK.name(), i2, list3);
                                        obj7 = b52.b((q)list3.get(i));
                                        obj8 = b52.b((q)list3.get(i10));
                                        if (obj7 instanceof f && b6.k(obj8)) {
                                            if (b6.k(obj8)) {
                                                obj7 = (f)obj7.s(obj8.zzh().intValue());
                                            } else {
                                                if (obj7 instanceof m) {
                                                    obj7 = (m)obj7.l(obj8.zzi());
                                                } else {
                                                    if (obj7 instanceof u) {
                                                        if ("length".equals(obj8.zzi())) {
                                                            obj8 = new i(Double.valueOf((double)obj7));
                                                            obj7 = obj8;
                                                        } else {
                                                            if (b6.k(obj8) && Double.compare(doubleValue, i2) < 0) {
                                                                if (Double.compare(doubleValue, i2) < 0) {
                                                                    obj9 = new u(String.valueOf(obj7.zzi().charAt(obj8.zzh().intValue())));
                                                                    obj7 = obj9;
                                                                } else {
                                                                    obj7 = q.h;
                                                                }
                                                            } else {
                                                            }
                                                        }
                                                    } else {
                                                    }
                                                }
                                            }
                                        } else {
                                        }
                                        return obj7;
                                    }
                                    if (list3.isEmpty()) {
                                        obj7 = new n();
                                        return obj7;
                                    } else {
                                        if (obj7 %= i2 != 0) {
                                        } else {
                                            obj7 = new n();
                                            while (i < size3--) {
                                                com.google.android.gms.internal.measurement.q qVar2 = b52.b((q)list3.get(i));
                                                i4 = b52.b((q)list3.get(i + 1));
                                                obj7.i(qVar2.zzi(), i4);
                                                i += 2;
                                            }
                                        }
                                    }
                                    obj8 = new Object[i10];
                                    obj8[i] = Integer.valueOf(list3.size());
                                    obj7 = new IllegalArgumentException(String.format("CREATE_OBJECT requires an even number of arguments, found %s", obj8));
                                    throw obj7;
                                }
                                if (list3.isEmpty()) {
                                    obj7 = new f();
                                } else {
                                    obj7 = new f();
                                    obj9 = list3.iterator();
                                    for (q next : obj9) {
                                        doubleValue = b52.b(next);
                                        obj7.A(i, doubleValue);
                                        i = i6;
                                    }
                                }
                                return obj7;
                            }
                            b6.h(n0.zzag.name(), i3, list3);
                            obj7 = b52.b((q)list3.get(i));
                            com.google.android.gms.internal.measurement.q qVar3 = b52.b((q)list3.get(i10));
                            obj8 = b52.b((q)list3.get(i2));
                            if (obj7 == q.h) {
                            } else {
                                if (obj7 == q.i) {
                                } else {
                                    if (obj7 instanceof f && qVar3 instanceof i) {
                                        if (qVar3 instanceof i) {
                                            (f)obj7.A(qVar3.zzh().intValue(), obj8);
                                        } else {
                                            if (obj7 instanceof m) {
                                                (m)obj7.i(qVar3.zzi(), obj8);
                                            }
                                        }
                                    } else {
                                    }
                                    return obj8;
                                }
                            }
                            obj9 = new Object[i2];
                            obj9[i] = qVar3.zzi();
                            obj9[i10] = obj7.zzi();
                            obj8 = new IllegalStateException(String.format("Can't set property %s of %s", obj9));
                            throw obj8;
                        }
                        b6.h(n0.zzX.name(), i, list3);
                        return q.i;
                    }
                    b6.h(n0.zzH.name(), i10, list3);
                    obj7 = b52.b((q)list3.get(i));
                    if (!obj7 instanceof u) {
                    } else {
                        return b52.d(obj7.zzi());
                    }
                    obj9 = new Object[i10];
                    obj9[i] = obj7.getClass().getCanonicalName();
                    obj8 = new IllegalArgumentException(String.format("Expected string for get var. got %s", obj9));
                    throw obj8;
                }
                b6.i(n0.zzy.name(), i10, list3);
                obj7 = q.h;
                while (i < list3.size()) {
                    i++;
                }
                return obj7;
            }
            b6.i(n0.zzo.name(), i2, list3);
            if (obj7 %= i2 != 0) {
            } else {
                obj7 = i;
                while (obj7 < size--) {
                    com.google.android.gms.internal.measurement.q qVar = b52.b((q)list3.get(obj7));
                    b52.f(qVar.zzi(), b52.b((q)list3.get(obj7 + 1)));
                    obj7 += 2;
                }
                return q.h;
            }
            obj8 = new Object[i10];
            obj8[i] = Integer.valueOf(list3.size());
            obj7 = new IllegalArgumentException(String.format("CONST requires an even number of arguments, found %s", obj8));
            throw obj7;
        }
        b6.h(n0.zzd.name(), i2, list3);
        obj7 = b52.b((q)list3.get(i));
        if (!obj7 instanceof u) {
        } else {
            if (!b52.h(obj7.zzi())) {
            } else {
                obj9 = b52.b((q)list3.get(i10));
                b52.g(obj7.zzi(), obj9);
                return obj9;
            }
            obj9 = new Object[i10];
            obj9[i] = obj7.zzi();
            obj8 = new IllegalArgumentException(String.format("Attempting to assign undefined value %s", obj9));
            throw obj8;
        }
        obj9 = new Object[i10];
        obj9[i] = obj7.getClass().getCanonicalName();
        obj8 = new IllegalArgumentException(String.format("Expected string for assign var. got %s", obj9));
        throw obj8;
    }
}
