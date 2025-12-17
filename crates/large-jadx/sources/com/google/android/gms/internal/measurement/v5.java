package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
final class v5 extends ContentObserver {
    v5(Handler handler) {
        super(0);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        w5.b().set(true);
    }
}
