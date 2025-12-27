package app.dogo.com.dogo_android.f.l;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class f implements View.OnClickListener {

    public final /* synthetic */ j a;
    public /* synthetic */ f(j jVar) {
        super();
        this.a = jVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DailyWorkoutFragment.X1(this.a, view);
    }
}
