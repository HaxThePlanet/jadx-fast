package com.google.android.gms.common;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class y extends com.google.android.gms.common.x {

    private final byte[] b;
    y(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.b = bArr;
    }

    @Override // com.google.android.gms.common.x
    final byte[] n() {
        return this.b;
    }
}
