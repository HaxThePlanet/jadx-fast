package app.dogo.com.dogo_android.r;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final /* synthetic */ j a;
    public /* synthetic */ b(j jVar) {
        super();
        this.a = jVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        TrainingReminderFragment.G1(this.a, view);
    }
}
