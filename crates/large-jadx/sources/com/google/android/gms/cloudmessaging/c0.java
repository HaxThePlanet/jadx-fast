package com.google.android.gms.cloudmessaging;

import android.util.Log;
import com.google.android.gms.tasks.k;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class c0 implements Runnable {

    public final k a;
    public c0(k k) {
        super();
        this.a = k;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean str;
        Object iOException;
        iOException = new IOException("TIMEOUT");
        if (this.a.d(iOException)) {
            Log.w("Rpc", "No response");
        }
    }
}
