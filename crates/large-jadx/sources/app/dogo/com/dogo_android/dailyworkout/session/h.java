package app.dogo.com.dogo_android.f.l;

import android.view.View;
import android.view.View.OnClickListener;
import com.skydoves.balloon.Balloon;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class h implements View.OnClickListener {

    public final /* synthetic */ Balloon a;
    public final /* synthetic */ j b;
    public /* synthetic */ h(Balloon balloon, j jVar) {
        super();
        this.a = balloon;
        this.b = jVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DailyWorkoutFragment.i2(this.a, this.b, view);
    }
}
