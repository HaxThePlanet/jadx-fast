package com.google.android.play.core.review;

import android.os.Bundle;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.tasks.o;

/* loaded from: classes2.dex */
final class k extends com.google.android.play.core.review.j<com.google.android.play.core.review.ReviewInfo> {
    k(com.google.android.play.core.review.l l, o o2, String string3) {
        h obj4 = new h("OnRequestInstallCallback");
        super(l, obj4, o2);
    }

    @Override // com.google.android.play.core.review.j
    public final void k(Bundle bundle) {
        super.k(bundle);
        d dVar = new d((PendingIntent)bundle.get("confirmation_intent"), bundle.getBoolean("is_review_no_op"));
        this.b.e(dVar);
    }
}
