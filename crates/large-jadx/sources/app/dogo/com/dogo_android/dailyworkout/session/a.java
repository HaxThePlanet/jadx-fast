package app.dogo.com.dogo_android.f.l;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final /* synthetic */ i a;
    public final /* synthetic */ int b;
    public /* synthetic */ a(i iVar, int i) {
        super();
        this.a = iVar;
        this.b = i;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DailyWorkoutAdapter.u(this.a, this.b, view);
    }
}
