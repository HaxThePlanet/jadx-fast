package app.dogo.com.dogo_android.y;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.u.j;

/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final j a;
    public final SpecialProgramOverviewItem b;
    public c(j j, SpecialProgramOverviewItem specialProgramOverviewItem2) {
        super();
        this.a = j;
        this.b = specialProgramOverviewItem2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        l.n(this.a, this.b, view);
    }
}
