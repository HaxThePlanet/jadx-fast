package app.dogo.com.dogo_android.u;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class e implements View.OnClickListener {

    public final /* synthetic */ l a;
    public final /* synthetic */ l.e b;
    public /* synthetic */ e(l lVar, l.e eVar) {
        super();
        this.a = lVar;
        this.b = eVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SpecialProgramVariationAdapter_VariationViewHolder.b(this.a, this.b, view);
    }
}
