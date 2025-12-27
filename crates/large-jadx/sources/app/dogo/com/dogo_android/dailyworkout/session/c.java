package app.dogo.com.dogo_android.f.l;

import android.view.View;
import android.view.View.OnClickListener;
import com.skydoves.balloon.Balloon;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final /* synthetic */ j a;
    public final /* synthetic */ Balloon b;
    public /* synthetic */ c(j jVar, Balloon balloon) {
        super();
        this.a = jVar;
        this.b = balloon;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DailyWorkoutFragment.f2(this.a, this.b, view);
    }
}
