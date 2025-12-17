package com.google.android.play.core.review;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.google.android.play.core.tasks.d;
import com.google.android.play.core.tasks.f;
import com.google.android.play.core.tasks.o;

/* loaded from: classes2.dex */
public final class g implements com.google.android.play.core.review.a {

    private final com.google.android.play.core.review.l a;
    private final Handler b;
    g(com.google.android.play.core.review.l l) {
        super();
        Handler handler = new Handler(Looper.getMainLooper());
        this.b = handler;
        this.a = l;
    }

    public final d<Void> a(Activity activity, com.google.android.play.core.review.ReviewInfo reviewInfo2) {
        if (reviewInfo2.b()) {
            return f.c(0);
        }
        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", reviewInfo2.a());
        intent.putExtra("window_flags", activity.getWindow().getDecorView().getWindowSystemUiVisibility());
        o obj5 = new o();
        f fVar = new f(this, this.b, obj5);
        intent.putExtra("result_receiver", fVar);
        activity.startActivity(intent);
        return obj5.a();
    }

    public final d<com.google.android.play.core.review.ReviewInfo> b() {
        return this.a.b();
    }
}
