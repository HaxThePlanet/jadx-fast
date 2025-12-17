package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.j5;
import com.google.android.gms.internal.measurement.n3;
import com.google.android.gms.internal.measurement.t3;
import com.google.android.gms.internal.measurement.yc;

/* loaded from: classes2.dex */
final class wa extends com.google.android.gms.measurement.internal.va {

    private final t3 g;
    final com.google.android.gms.measurement.internal.xa h;
    wa(com.google.android.gms.measurement.internal.xa xa, String string2, int i3, t3 t34) {
        this.h = xa;
        super(string2, i3);
        this.g = t34;
    }

    @Override // com.google.android.gms.measurement.internal.va
    final int a() {
        return this.g.w();
    }

    @Override // com.google.android.gms.measurement.internal.va
    final boolean b() {
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.va
    final boolean c() {
        return 1;
    }

    @Override // com.google.android.gms.measurement.internal.va
    final boolean k(Long long, Long long2, j5 j53, boolean z4) {
        int i;
        Boolean valueOf;
        boolean booleanValue;
        Object n3Var;
        boolean z;
        Object str3;
        long str;
        long str2;
        Long obj11;
        long obj13;
        boolean obj14;
        yc.b();
        booleanValue = this.g.E();
        int i2 = 0;
        final int i3 = 1;
        if (!this.g.C() && !this.g.D()) {
            if (!this.g.D()) {
                if (booleanValue) {
                    i = i3;
                } else {
                    i = i2;
                }
            } else {
            }
        } else {
        }
        valueOf = 0;
        if (z4 && i == 0 && this.g.F()) {
            if (i == 0) {
                if (this.g.F()) {
                    valueOf = Integer.valueOf(this.g.w());
                }
                obj11.a.b().v().c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.b), valueOf);
                return i3;
            }
        }
        n3Var = this.g.x();
        z = n3Var.C();
        if (j53.M()) {
            if (!n3Var.E()) {
                xaVar3.a.b().w().b("No number filter for long property. property", xaVar8.a.D().f(j53.B()));
            } else {
                valueOf = va.j(va.h(j53.x(), obj9), z);
            }
        } else {
            if (j53.L()) {
                if (!n3Var.E()) {
                    xaVar4.a.b().w().b("No number filter for double property. property", xaVar9.a.D().f(j53.B()));
                } else {
                    valueOf = va.j(va.g(j53.w(), obj9), z);
                }
            } else {
                if (j53.O()) {
                    if (!n3Var.G()) {
                        if (!n3Var.E()) {
                            xaVar6.a.b().w().b("No string or number filter defined. property", xaVar11.a.D().f(j53.B()));
                        } else {
                            if (da.P(j53.C())) {
                                valueOf = va.j(va.i(j53.C(), n3Var.y()), z);
                            } else {
                                xaVar7.a.b().w().c("Invalid user property value for Numeric number filter. property, value", xaVar12.a.D().f(j53.B()), j53.C());
                            }
                        }
                    } else {
                        valueOf = va.j(va.f(j53.C(), n3Var.z(), xaVar13.a.b()), z);
                    }
                } else {
                    xaVar5.a.b().w().b("User property has no value, property", xaVar10.a.D().f(j53.B()));
                }
            }
        }
        str3 = valueOf == null ? "null" : valueOf;
        xaVar2.a.b().v().b("Property filter result", str3);
        if (valueOf == null) {
            return i2;
        }
        this.c = Boolean.TRUE;
        if (booleanValue && valueOf.booleanValue()) {
            if (valueOf.booleanValue()) {
            }
            return i3;
        }
        if (z4) {
            if (this.g.C()) {
                this.d = valueOf;
            }
        } else {
        }
        obj14 = j53.N();
        obj13 = j53.y();
        if (valueOf.booleanValue() && i != 0 && obj14 != null && long) {
            if (i != 0) {
                obj14 = j53.N();
                if (obj14 != null) {
                    obj13 = j53.y();
                    if (long) {
                        obj13 = long.longValue();
                    }
                    if (xaVar.a.z().B(this.a, c3.X) && this.g.C() && !this.g.D() && long2 != null) {
                        if (this.g.C()) {
                            if (!this.g.D()) {
                                if (long2 != null) {
                                    obj13 = long2.longValue();
                                }
                            }
                        }
                    }
                    if (this.g.D()) {
                        this.f = Long.valueOf(obj13);
                    } else {
                        this.e = Long.valueOf(obj13);
                    }
                }
            }
        }
        return i3;
    }
}
