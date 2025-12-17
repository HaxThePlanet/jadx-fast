package com.google.android.gms.internal.measurement;

import android.accounts.Account;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class j0 extends com.google.android.gms.internal.measurement.x {
    protected j0() {
        super();
        this.a.add(n0.zzA);
        this.a.add(n0.zzB);
        this.a.add(n0.zzC);
        this.a.add(n0.zzD);
        this.a.add(n0.zzE);
        this.a.add(n0.zzF);
        this.a.add(n0.zzG);
        this.a.add(n0.zzan);
    }

    private static com.google.android.gms.internal.measurement.q c(com.google.android.gms.internal.measurement.h0 h0, Iterator<com.google.android.gms.internal.measurement.q> iterator2, com.google.android.gms.internal.measurement.q q3) {
        boolean next;
        boolean equals;
        String str;
        if (iterator2 != null) {
        }
        return q.h;
    }

    private static com.google.android.gms.internal.measurement.q d(com.google.android.gms.internal.measurement.h0 h0, com.google.android.gms.internal.measurement.q q2, com.google.android.gms.internal.measurement.q q3) {
        return j0.c(h0, q2.h(), q3);
    }

    private static com.google.android.gms.internal.measurement.q e(com.google.android.gms.internal.measurement.h0 h0, com.google.android.gms.internal.measurement.q q2, com.google.android.gms.internal.measurement.q q3) {
        if (!q2 instanceof Iterable) {
        } else {
            return j0.c(h0, (Iterable)q2.iterator(), q3);
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("Non-iterable type in for...of loop.");
        throw obj1;
    }

    public final com.google.android.gms.internal.measurement.q a(String string, com.google.android.gms.internal.measurement.b5 b52, List<com.google.android.gms.internal.measurement.q> list3) {
        com.google.android.gms.internal.measurement.q booleanValue;
        com.google.android.gms.internal.measurement.b5 b5Var;
        boolean equals;
        int i;
        com.google.android.gms.internal.measurement.q qVar;
        int i2;
        int equals2;
        int i3;
        com.google.android.gms.internal.measurement.q qVar2;
        com.google.android.gms.internal.measurement.n0 zza = n0.zza;
        int ordinal = b6.e(string).ordinal();
        equals = 4;
        final String str6 = "return";
        final String str7 = "break";
        int i6 = 2;
        i2 = 3;
        i3 = 1;
        final int i7 = 0;
        if (ordinal != 65) {
            switch (ordinal) {
                case 26:
                    b6.h(n0.zzA.name(), i2, list3);
                    i0 i0Var2 = new i0(b52, (q)list3.get(i7).zzi());
                    return j0.d(i0Var2, b52.b((q)list3.get(i3)), b52.b((q)list3.get(i6)));
                    IllegalArgumentException obj11 = new IllegalArgumentException("Variable name in FOR_IN must be a string");
                    throw obj11;
                case 27:
                    b6.h(n0.zzB.name(), i2, list3);
                    f0 f0Var2 = new f0(b52, (q)list3.get(i7).zzi());
                    return j0.d(f0Var2, b52.b((q)list3.get(i3)), b52.b((q)list3.get(i6)));
                    obj11 = new IllegalArgumentException("Variable name in FOR_IN_CONST must be a string");
                    throw obj11;
                case 28:
                    b6.h(n0.zzC.name(), i2, list3);
                    g0 g0Var2 = new g0(b52, (q)list3.get(i7).zzi());
                    return j0.d(g0Var2, b52.b((q)list3.get(i3)), b52.b((q)list3.get(i6)));
                    obj11 = new IllegalArgumentException("Variable name in FOR_IN_LET must be a string");
                    throw obj11;
                case 29:
                    b6.h(n0.zzD.name(), equals, list3);
                    obj11 = b52.b((q)list3.get(i7));
                    obj11 = new IllegalArgumentException("Initializer variables in FOR_LET must be an ArrayList");
                    throw obj11;
                case 30:
                    b6.h(n0.zzE.name(), i2, list3);
                    i0 i0Var = new i0(b52, (q)list3.get(i7).zzi());
                    return j0.e(i0Var, b52.b((q)list3.get(i3)), b52.b((q)list3.get(i6)));
                    obj11 = new IllegalArgumentException("Variable name in FOR_OF must be a string");
                    throw obj11;
                case 31:
                    b6.h(n0.zzF.name(), i2, list3);
                    f0 f0Var = new f0(b52, (q)list3.get(i7).zzi());
                    return j0.e(f0Var, b52.b((q)list3.get(i3)), b52.b((q)list3.get(i6)));
                    obj11 = new IllegalArgumentException("Variable name in FOR_OF_CONST must be a string");
                    throw obj11;
                case 32:
                    b6.h(n0.zzG.name(), i2, list3);
                    g0 g0Var = new g0(b52, (q)list3.get(i7).zzi());
                    return j0.e(g0Var, b52.b((q)list3.get(i3)), b52.b((q)list3.get(i6)));
                    obj11 = new IllegalArgumentException("Variable name in FOR_OF_LET must be a string");
                    throw obj11;
                default:
                    super.b(string);
                    throw 0;
            }
            i = i7;
            while (i < (f)obj11.q()) {
                i2 = obj11.s(i).zzi();
                b52.a().g(i2, b52.d(i2));
                i++;
            }
            while (b52.b((q)list3.get(i3)).d().booleanValue()) {
                qVar = b52.c((f)b52.b((q)list3.get(i2)));
                if (qVar instanceof h) {
                    break;
                } else {
                }
                i = b52.a();
                equals2 = i7;
                while (equals2 < obj11.q()) {
                    i3 = obj11.s(equals2).zzi();
                    i.g(i3, b5Var.d(i3));
                    equals2++;
                }
                i.b((q)list3.get(i6));
                b5Var = i;
                i3 = obj11.s(equals2).zzi();
                i.g(i3, b5Var.d(i3));
                equals2++;
                if (str6.equals(qVar.c())) {
                    break;
                } else {
                }
            }
            qVar = q.h;
            return qVar;
        }
        b6.h(n0.zzan.name(), equals, list3);
        com.google.android.gms.internal.measurement.q obj13 = b52.b((q)list3.get(i2));
        if (!b52.b((q)list3.get(i6)).d().booleanValue()) {
            while (b52.b((q)list3.get(i7)).d().booleanValue()) {
                booleanValue = b52.c((f)obj13);
                b52.b((q)list3.get(i3));
            }
            booleanValue = q.h;
        } else {
            booleanValue = b52.c((f)obj13);
            if (booleanValue instanceof h) {
                if (str7.equals((h)booleanValue.c())) {
                    booleanValue = q.h;
                } else {
                    if (str6.equals(booleanValue.c())) {
                    }
                }
            }
        }
        return booleanValue;
    }
}
