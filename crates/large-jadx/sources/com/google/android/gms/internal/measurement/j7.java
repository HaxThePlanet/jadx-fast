package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public abstract class j7<MessageType extends com.google.android.gms.internal.measurement.k7<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.measurement.j7<MessageType, BuilderType>>  implements com.google.android.gms.internal.measurement.x9 {
    @Override // com.google.android.gms.internal.measurement.x9
    public final com.google.android.gms.internal.measurement.x9 B1(byte[] bArr) {
        h(bArr, 0, bArr.length);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.x9
    public final com.google.android.gms.internal.measurement.x9 H1(byte[] bArr, com.google.android.gms.internal.measurement.j8 j82) {
        j(bArr, 0, bArr.length, j82);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.x9
    public final com.google.android.gms.internal.measurement.x9 J0(com.google.android.gms.internal.measurement.y9 y9) {
        if (!e().getClass().isInstance(y9)) {
        } else {
            g((k7)y9);
            return this;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        throw obj2;
    }

    protected abstract BuilderType g(MessageType messagetype);

    public abstract BuilderType h(byte[] bArr, int i2, int i3);

    public abstract BuilderType j(byte[] bArr, int i2, int i3, com.google.android.gms.internal.measurement.j8 j84);
}
