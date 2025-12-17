package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.o;

/* loaded from: classes2.dex */
final class f extends ResultReceiver {

    final o a;
    f(com.google.android.play.core.review.g g, Handler handler2, o o3) {
        this.a = o3;
        super(handler2);
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle2) {
        this.a.e(0);
    }
}
