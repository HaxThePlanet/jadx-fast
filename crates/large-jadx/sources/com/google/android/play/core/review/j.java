package com.google.android.play.core.review;

import android.os.Bundle;
import com.google.android.play.core.internal.e;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.o;

/* loaded from: classes2.dex */
class j<T>  extends e {

    final h a;
    final o<T> b;
    final com.google.android.play.core.review.l c;
    j(com.google.android.play.core.review.l l, h h2, o o3) {
        this.c = l;
        super();
        this.a = h2;
        this.b = o3;
    }

    @Override // com.google.android.play.core.internal.e
    public void k(Bundle bundle) {
        o oVar;
        t obj3 = obj3.a;
        if (obj3 != null) {
            obj3.s(this.b);
        }
        this.a.d("onGetLaunchReviewFlowInfo", new Object[0]);
    }
}
