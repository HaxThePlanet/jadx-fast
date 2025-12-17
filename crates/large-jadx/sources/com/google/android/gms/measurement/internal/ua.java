package com.google.android.gms.measurement.internal;

import android.util.Log;
import com.google.android.gms.internal.measurement.l3;
import com.google.android.gms.internal.measurement.n3;
import com.google.android.gms.internal.measurement.p4;
import com.google.android.gms.internal.measurement.t4;
import com.google.android.gms.internal.measurement.yc;
import d.e.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
final class ua extends com.google.android.gms.measurement.internal.va {

    private final l3 g;
    final com.google.android.gms.measurement.internal.xa h;
    ua(com.google.android.gms.measurement.internal.xa xa, String string2, int i3, l3 l34) {
        this.h = xa;
        super(string2, i3);
        this.g = l34;
    }

    @Override // com.google.android.gms.measurement.internal.va
    final int a() {
        return this.g.x();
    }

    @Override // com.google.android.gms.measurement.internal.va
    final boolean b() {
        return this.g.J();
    }

    @Override // com.google.android.gms.measurement.internal.va
    final boolean c() {
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.va
    final boolean k(Long long, Long long2, p4 p43, long l4, com.google.android.gms.measurement.internal.q q5, boolean z6) {
        boolean z;
        long booleanValue2;
        Long valueOf;
        boolean z7;
        boolean z4;
        Object aVar;
        Object str3;
        boolean booleanValue3;
        boolean loggable;
        boolean z2;
        int i;
        int valueOf2;
        String str2;
        int valueOf3;
        String str4;
        l3 booleanValue;
        String str5;
        String str;
        String str6;
        Object iterator;
        boolean z5;
        boolean doubleValue;
        Object contains;
        boolean z3;
        final Object obj = this;
        yc.b();
        aVar = c3.Z;
        z = xaVar.a.z().B(obj.a, aVar);
        booleanValue2 = obj.g.I() ? obj3.e : l4;
        valueOf2 = 0;
        if (Log.isLoggable(xaVar23.a.b().C(), 2)) {
            if (obj.g.K()) {
                valueOf3 = Integer.valueOf(obj.g.x());
            } else {
                valueOf3 = valueOf2;
            }
            xaVar24.a.b().v().d("Evaluating filter. audience, filter, event", Integer.valueOf(obj.b), valueOf3, xaVar34.a.D().d(obj.g.C()));
            xaVar25.a.b().v().b("Filter definition", xaVar27.b.e0().F(obj.g));
        }
        int i5 = 0;
        if (obj.g.K()) {
            if (obj.g.x() > 256) {
            } else {
                int i7 = 1;
                if (!obj.g.G() && !obj.g.H()) {
                    if (!obj.g.H()) {
                        if (obj.g.I()) {
                            i = i7;
                        } else {
                            i = i5;
                        }
                    } else {
                    }
                } else {
                }
                if (obj22 != null && i == 0 && obj.g.K()) {
                    if (i == 0) {
                        if (obj.g.K()) {
                            valueOf2 = Integer.valueOf(obj.g.x());
                        }
                        xaVar3.a.b().v().c("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(obj.b), valueOf2);
                        return i7;
                    }
                }
                booleanValue = obj.g;
                str = p43.D();
                if (booleanValue.J()) {
                    booleanValue2 = va.h(booleanValue2, aVar);
                    if (booleanValue2 == null) {
                    } else {
                        if (!booleanValue2.booleanValue()) {
                            valueOf2 = Boolean.FALSE;
                        } else {
                            HashSet hashSet = new HashSet();
                            Iterator iterator2 = booleanValue.D().iterator();
                            for (n3 iterator : iterator2) {
                                hashSet.add(iterator.A());
                            }
                            aVar = new a();
                            iterator = p43.E().iterator();
                            for (t4 doubleValue : iterator) {
                                aVar.put(doubleValue.C(), doubleValue.D());
                                if (doubleValue.P()) {
                                } else {
                                }
                                doubleValue = valueOf2;
                                aVar.put(doubleValue.C(), doubleValue);
                                doubleValue = Double.valueOf(doubleValue.w());
                                if (doubleValue.R()) {
                                } else {
                                }
                                doubleValue = valueOf2;
                                aVar.put(doubleValue.C(), doubleValue);
                                doubleValue = Long.valueOf(doubleValue.z());
                            }
                            booleanValue2 = booleanValue.D().iterator();
                            while (booleanValue2.hasNext()) {
                                Object next = booleanValue2.next();
                                if ((n3)next.D() && next.C()) {
                                } else {
                                }
                                iterator = i5;
                                doubleValue = next.A();
                                contains = aVar.get(doubleValue);
                                booleanValue = va.i(contains, next.y());
                                booleanValue = va.f((String)contains, next.z(), xaVar35.a.b());
                                booleanValue = va.g((Double)contains.doubleValue(), contains);
                                booleanValue = va.h((Long)contains.longValue(), contains);
                                if (next.C()) {
                                } else {
                                }
                                iterator = i7;
                            }
                            valueOf2 = Boolean.TRUE;
                        }
                    }
                } else {
                }
                str3 = valueOf2 == null ? "null" : valueOf2;
                xaVar4.a.b().v().b("Event filter result", str3);
                if (valueOf2 == null) {
                    return i5;
                }
                valueOf = Boolean.TRUE;
                obj.c = valueOf;
                booleanValue3 = valueOf2.booleanValue();
                if (!booleanValue3) {
                    return i7;
                }
                obj.d = valueOf;
                if (i != 0 && p43.P()) {
                    if (p43.P()) {
                        valueOf = Long.valueOf(p43.z());
                        if (obj.g.H()) {
                            if (z) {
                                if (!obj.g.J()) {
                                } else {
                                    valueOf = long;
                                }
                            }
                            obj.f = valueOf;
                        } else {
                            if (z && obj.g.J()) {
                                if (obj.g.J()) {
                                    valueOf = long2;
                                }
                            }
                            obj.e = valueOf;
                        }
                    }
                }
            }
            return i7;
        }
        if (obj.g.K()) {
            valueOf2 = Integer.valueOf(obj.g.x());
        }
        xaVar2.a.b().w().c("Invalid event filter ID. appId, id", q3.z(obj.a), String.valueOf(valueOf2));
        return i5;
    }
}
