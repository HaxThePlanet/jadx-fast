package com.google.android.play.core.review;

import com.google.android.play.core.common.b;
import com.google.android.play.core.internal.d;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.i;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.o;

/* loaded from: classes2.dex */
final class i extends i {

    final o b;
    final com.google.android.play.core.review.l c;
    i(com.google.android.play.core.review.l l, o o2, o o3) {
        this.c = l;
        this.b = o3;
        super(o2);
    }

    @Override // com.google.android.play.core.internal.i
    protected final void a() {
        try {
            final com.google.android.play.core.review.l lVar4 = this.c;
            k kVar = new k(lVar4, this.b, l.c(lVar4));
            (d)lVar.a.e().i2(l.c(this.c), b.a("review"), kVar);
            h hVar = l.a();
            int runtimeException = 1;
            runtimeException = new Object[runtimeException];
            int str3 = 0;
            com.google.android.play.core.review.l lVar3 = this.c;
            lVar3 = l.c(lVar3);
            runtimeException[str3] = lVar3;
            str3 = "error requesting in-app review for %s";
            hVar.c(th, str3, runtimeException);
            hVar = this.b;
            runtimeException = new RuntimeException(th);
            hVar.d(runtimeException);
        }
    }
}
