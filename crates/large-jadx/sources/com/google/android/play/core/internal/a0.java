package com.google.android.play.core.internal;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
final class a0 implements com.google.android.play.core.internal.z0 {

    private final ByteBuffer a;
    public a0(ByteBuffer byteBuffer) {
        super();
        this.a = byteBuffer.slice();
    }

    @Override // com.google.android.play.core.internal.z0
    public final void a(MessageDigest[] messageDigestArr, long l2, int i3) {
        int i;
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2 = this.a;
        int obj4 = (int)l2;
        this.a.position(obj4);
        this.a.limit(obj4 += obj6);
        obj4 = this.a.slice();
        final int obj6 = 0;
        i = obj6;
        synchronized (byteBuffer2) {
            byteBuffer2 = this.a;
            obj4 = (int)l2;
            this.a.position(obj4);
            this.a.limit(obj4 += obj6);
            obj4 = this.a.slice();
            obj6 = 0;
            i = obj6;
        }
        while (i < messageDigestArr.length) {
            obj4.position(obj6);
            messageDigestArr[i].update(obj4);
            i++;
        }
        try {
            throw messageDigestArr;
        }
    }

    @Override // com.google.android.play.core.internal.z0
    public final long zza() {
        return (long)capacity;
    }
}
