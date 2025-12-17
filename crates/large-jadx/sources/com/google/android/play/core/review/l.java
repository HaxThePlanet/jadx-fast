package com.google.android.play.core.review;

import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.internal.d;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.h1;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.d;
import com.google.android.play.core.tasks.f;
import com.google.android.play.core.tasks.o;

/* loaded from: classes2.dex */
public final class l {

    private static final h c;
    t<d> a;
    private final String b;
    static {
        h hVar = new h("ReviewService");
        l.c = hVar;
    }

    public l(Context context) {
        boolean tVar;
        String str2;
        t tVar2;
        Context context2;
        h hVar2;
        String str;
        Intent package;
        com.google.android.play.core.review.h hVar;
        int i;
        super();
        this.b = context.getPackageName();
        if (h1.b(context)) {
            Intent intent = new Intent("com.google.android.finsky.BIND_IN_APP_REVIEW_SERVICE");
            super(context, l.c, "com.google.android.finsky.inappreviewservice.InAppReviewService", intent.setPackage("com.android.vending"), h.a, 0);
            this.a = tVar;
        }
    }

    static h a() {
        return l.c;
    }

    static String c(com.google.android.play.core.review.l l) {
        return l.b;
    }

    public final d<com.google.android.play.core.review.ReviewInfo> b() {
        h hVar = l.c;
        Object[] arr = new Object[1];
        final int i3 = 0;
        arr[i3] = this.b;
        hVar.d("requestInAppReview (%s)", arr);
        if (this.a == null) {
            hVar.b("Play Store app is either not installed or not the official version", new Object[i3]);
            ReviewException reviewException = new ReviewException(-1);
            return f.b(reviewException);
        }
        o oVar = new o();
        i iVar = new i(this, oVar, oVar);
        this.a.q(iVar, oVar);
        return oVar.a();
    }
}
