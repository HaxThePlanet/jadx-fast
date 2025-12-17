package app.dogo.com.dogo_android.g;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.h.yi;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final TrainingTimeMetrics a;
    public final app.dogo.com.dogo_android.g.d0 b;
    public final yi c;
    public b(TrainingTimeMetrics trainingTimeMetrics, app.dogo.com.dogo_android.g.d0 d02, yi yi3) {
        super();
        this.a = trainingTimeMetrics;
        this.b = d02;
        this.c = yi3;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        n.d(this.a, this.b, this.c, view);
    }
}
