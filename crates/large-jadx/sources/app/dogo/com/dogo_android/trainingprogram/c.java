package app.dogo.com.dogo_android.y;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.u.j;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final /* synthetic */ j a;
    public final /* synthetic */ SpecialProgramOverviewItem b;
    public /* synthetic */ c(j jVar, SpecialProgramOverviewItem specialProgramOverviewItem) {
        super();
        this.a = jVar;
        this.b = specialProgramOverviewItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ProgramBindingAdapters.v(this.a, this.b, view);
    }
}
