package app.dogo.com.dogo_android.f.j;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final /* synthetic */ b a;
    public /* synthetic */ a(b bVar) {
        super();
        this.a = bVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DailyWorkoutInfoFragment.C1(this.a, view);
    }
}
