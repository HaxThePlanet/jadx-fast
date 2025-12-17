package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
public final class z extends com.google.android.gms.internal.measurement.x {
    public z() {
        super();
        this.a.add(n0.zzx);
        this.a.add(n0.zzL);
        this.a.add(n0.zzM);
        this.a.add(n0.zzN);
        this.a.add(n0.zzO);
        this.a.add(n0.zzQ);
        this.a.add(n0.zzR);
        this.a.add(n0.zzW);
    }

    private static boolean c(com.google.android.gms.internal.measurement.q q, com.google.android.gms.internal.measurement.q q2) {
        boolean z5;
        boolean naN;
        boolean z2;
        boolean z4;
        boolean z3;
        int i;
        double doubleValue;
        boolean z;
        Object obj5;
        int i2 = 0;
        i = 1;
        if (q.getClass().equals(q2.getClass()) && !q instanceof v) {
            if (!q instanceof v) {
                if (q instanceof o) {
                } else {
                    if (q instanceof i && !Double.isNaN(q.zzh().doubleValue())) {
                        if (!Double.isNaN(q.zzh().doubleValue())) {
                            if (Double.isNaN(q2.zzh().doubleValue())) {
                            } else {
                                if (Double.compare(doubleValue, obj5) == 0) {
                                    return i;
                                }
                            }
                        }
                        return i2;
                    }
                    if (q instanceof u) {
                        return q.zzi().equals(q2.zzi());
                    }
                    if (q instanceof g) {
                        return q.d().equals(q2.d());
                    }
                    if (q == q2) {
                        return i;
                    }
                }
                return i2;
            }
            return i;
        }
        if (!q instanceof v) {
            if (q instanceof o) {
                z4 = q instanceof i;
                if (!q2 instanceof v && !q2 instanceof o && z4 && !q2 instanceof u) {
                    if (!q2 instanceof o) {
                        z4 = q instanceof i;
                        if (z4) {
                            if (!q2 instanceof u) {
                            }
                            i iVar = new i(q2.zzh());
                            return z.c(q, iVar);
                        }
                        boolean z9 = q instanceof u;
                        if (z9 && !q2 instanceof i) {
                            if (!q2 instanceof i) {
                            }
                            i iVar2 = new i(q.zzh());
                            return z.c(iVar2, q2);
                        }
                        if (q instanceof g) {
                            i iVar4 = new i(q.zzh());
                            return z.c(iVar4, q2);
                        }
                        if (q2 instanceof g) {
                            i iVar3 = new i(q2.zzh());
                            return z.c(q, iVar3);
                        }
                        if (!z9) {
                            if (z4) {
                                if (!q2 instanceof m && q instanceof m && !q2 instanceof u && q2 instanceof i) {
                                    if (q instanceof m) {
                                        if (!q2 instanceof u) {
                                            if (q2 instanceof i) {
                                            }
                                        }
                                        u uVar2 = new u(q.zzi());
                                        return z.c(uVar2, q2);
                                    }
                                }
                            } else {
                            }
                            return i2;
                        } else {
                        }
                    }
                }
            } else {
            }
            u uVar = new u(q2.zzi());
            return z.c(q, uVar);
        } else {
        }
        return i;
    }

    private static boolean d(com.google.android.gms.internal.measurement.q q, com.google.android.gms.internal.measurement.q q2) {
        boolean uVar2;
        boolean uVar;
        boolean z;
        int naN;
        int i;
        int cmp;
        Object obj8;
        Object obj9;
        if (q instanceof m) {
            uVar2 = new u(q.zzi());
            obj8 = uVar2;
        }
        if (q2 instanceof m) {
            uVar = new u(q2.zzi());
            obj9 = uVar;
        }
        final int i2 = 1;
        final int i3 = 0;
        if (obj8 instanceof u) {
            if (!obj9 instanceof u) {
            } else {
                if (obj8.zzi().compareTo(obj9.zzi()) < 0) {
                    return i2;
                }
            }
            return i3;
        }
        final double doubleValue = obj8.zzh().doubleValue();
        obj8 = obj9.zzh().doubleValue();
        if (!Double.isNaN(doubleValue)) {
            if (Double.isNaN(obj8)) {
            } else {
                i = 0;
                naN = Double.compare(doubleValue, i);
                if (naN == 0) {
                    if (Double.compare(obj8, i) != 0 && naN == 0 && Double.compare(obj8, i) != 0) {
                        if (naN == 0) {
                            if (Double.compare(obj8, i) != 0) {
                            }
                        }
                    }
                    return i3;
                } else {
                }
                if (Double.compare(doubleValue, obj4) < 0) {
                    return i2;
                }
            }
        }
        return i3;
    }

    private static boolean e(com.google.android.gms.internal.measurement.q q, com.google.android.gms.internal.measurement.q q2) {
        boolean uVar2;
        boolean uVar;
        boolean naN;
        double doubleValue;
        Object obj4;
        Object obj5;
        if (q instanceof m) {
            uVar2 = new u(q.zzi());
            obj4 = uVar2;
        }
        if (q2 instanceof m) {
            uVar = new u(q2.zzi());
            obj5 = uVar;
        }
        if (obj4 instanceof u) {
            if (!obj5 instanceof u) {
                if (!Double.isNaN(obj4.zzh().doubleValue()) && !Double.isNaN(obj5.zzh().doubleValue()) && !z.d(obj5, obj4)) {
                    if (!Double.isNaN(obj5.zzh().doubleValue())) {
                        if (!z.d(obj5, obj4)) {
                            return 1;
                        }
                    }
                }
            } else {
            }
        } else {
        }
        return 0;
    }

    public final com.google.android.gms.internal.measurement.q a(String string, com.google.android.gms.internal.measurement.b5 b52, List<com.google.android.gms.internal.measurement.q> list3) {
        int i;
        boolean obj4;
        b6.h(b6.e(string).name(), 2, list3);
        com.google.android.gms.internal.measurement.q qVar = b52.b((q)list3.get(0));
        int i5 = 1;
        final com.google.android.gms.internal.measurement.q obj5 = b52.b((q)list3.get(i5));
        int obj6 = b6.e(string).ordinal();
        if (obj6 != 23) {
            if (obj6 != 48) {
                if (obj6 != 42) {
                    if (obj6 != 43) {
                        switch (obj6) {
                            case 37:
                                obj4 = z.d(obj5, qVar);
                                obj4 = q.m;
                                obj4 = q.n;
                                return obj4;
                            case 38:
                                obj4 = z.e(obj5, qVar);
                                obj4 = q.m;
                                obj4 = q.n;
                                return obj4;
                            case 39:
                                obj4 = b6.l(qVar, obj5);
                                obj4 = q.m;
                                obj4 = q.n;
                                return obj4;
                            case 40:
                                obj4 = b6.l(qVar, obj5);
                                break;
                            default:
                                super.b(string);
                                throw 0;
                        }
                        obj4 ^= i5;
                    }
                    obj4 = z.e(qVar, obj5);
                } else {
                    obj4 = z.d(qVar, obj5);
                }
            } else {
            }
        } else {
            obj4 = z.c(qVar, obj5);
        }
    }
}
