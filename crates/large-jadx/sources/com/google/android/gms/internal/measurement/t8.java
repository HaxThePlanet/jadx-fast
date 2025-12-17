package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public class t8<MessageType extends com.google.android.gms.internal.measurement.w8<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.measurement.t8<MessageType, BuilderType>>  extends com.google.android.gms.internal.measurement.j7<MessageType, BuilderType> {

    private final MessageType a;
    protected MessageType b;
    protected boolean c = false;
    protected t8(MessageType messagetype) {
        super();
        this.a = messagetype;
        final int i2 = 0;
        this.b = (w8)messagetype.v(4, i2, i2);
        int obj3 = 0;
    }

    private static final void k(MessageType messagetype, MessageType messagetype2) {
        ga.a().b(messagetype.getClass()).e(messagetype, messagetype2);
    }

    @Override // com.google.android.gms.internal.measurement.j7
    public final Object clone() {
        return o();
    }

    @Override // com.google.android.gms.internal.measurement.j7
    public final com.google.android.gms.internal.measurement.y9 e() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.measurement.j7
    protected final com.google.android.gms.internal.measurement.j7 g(com.google.android.gms.internal.measurement.k7 k7) {
        p((w8)k7);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.j7
    public final com.google.android.gms.internal.measurement.j7 h(byte[] bArr, int i2, int i3) {
        r(bArr, 0, i3, j8.a());
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.j7
    public final com.google.android.gms.internal.measurement.j7 j(byte[] bArr, int i2, int i3, com.google.android.gms.internal.measurement.j8 j84) {
        r(bArr, 0, i3, j84);
        return this;
    }

    public final MessageType l() {
        com.google.android.gms.internal.measurement.w8 w8Var;
        int i;
        byte byteValue;
        int i2;
        final com.google.android.gms.internal.measurement.w8 w8Var2 = m();
        i = 1;
        final int i3 = 0;
        byteValue = (Byte)w8Var2.v(i, i3, i3).byteValue();
        if (byteValue == i) {
        } else {
            if (byteValue == 0) {
                i = 0;
            } else {
                byteValue = ga.a().b(w8Var2.getClass()).f(w8Var2);
                w8Var = i != byteValue ? i3 : w8Var2;
                w8Var2.v(2, w8Var, i3);
                i = byteValue;
            }
        }
        if (i == 0) {
        } else {
            return w8Var2;
        }
        zzma zzma = new zzma(w8Var2);
        throw zzma;
    }

    public MessageType m() {
        if (this.c) {
            return this.b;
        }
        com.google.android.gms.internal.measurement.w8 w8Var2 = this.b;
        ga.a().b(w8Var2.getClass()).c(w8Var2);
        this.c = true;
        return this.b;
    }

    @Override // com.google.android.gms.internal.measurement.j7
    protected void n() {
        final int i2 = 0;
        Object obj = this.b.v(4, i2, i2);
        t8.k((w8)obj, this.b);
        this.b = obj;
    }

    public final BuilderType o() {
        final int i2 = 0;
        Object obj = this.a.v(5, i2, i2);
        (t8)obj.p(m());
        return obj;
    }

    public final BuilderType p(MessageType messagetype) {
        boolean z;
        if (this.c) {
            n();
            this.c = false;
        }
        t8.k(this.b, messagetype);
        return this;
    }

    public final BuilderType r(byte[] bArr, int i2, int i3, com.google.android.gms.internal.measurement.j8 j84) {
        boolean obj9;
        if (this.c) {
            n();
            this.c = false;
        }
        n7 n7Var = new n7(j84);
        ga.a().b(this.b.getClass()).g(this.b, bArr, 0, i3, n7Var);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.j7
    public com.google.android.gms.internal.measurement.y9 t0() {
        return m();
    }
}
