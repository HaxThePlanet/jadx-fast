package com.google.android.play.core.internal;

import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
final class s1 implements com.google.android.play.core.internal.z0 {

    private final FileChannel a;
    private final long b;
    private final long c;
    public s1(FileChannel fileChannel, long l2, long l3) {
        super();
        this.a = fileChannel;
        this.b = l2;
        this.c = obj4;
    }

    @Override // com.google.android.play.core.internal.z0
    public final void a(MessageDigest[] messageDigestArr, long l2, int i3) {
        int i;
        Object obj;
        final MappedByteBuffer obj10 = this.a.map(FileChannel.MapMode.READ_ONLY, l + l2, obj5);
        obj10.load();
        final int obj12 = 0;
        i = obj12;
        while (i < messageDigestArr.length) {
            obj10.position(obj12);
            messageDigestArr[i].update(obj10);
            i++;
        }
    }

    @Override // com.google.android.play.core.internal.z0
    public final long zza() {
        return this.c;
    }
}
