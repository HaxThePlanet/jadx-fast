package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
abstract class z extends com.google.android.gms.common.x {

    private static final WeakReference<byte[]> c;
    private WeakReference<byte[]> b;
    static {
        WeakReference weakReference = new WeakReference(0);
        z.c = weakReference;
    }

    z(byte[] bArr) {
        super(bArr);
        this.b = z.c;
    }

    @Override // com.google.android.gms.common.x
    final byte[] n() {
        Object obj;
        WeakReference weakReference;
        synchronized (this) {
            try {
                weakReference = new WeakReference(q2());
                this.b = weakReference;
                return obj;
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.x
    protected abstract byte[] q2();
}
