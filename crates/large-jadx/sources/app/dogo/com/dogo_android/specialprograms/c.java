package app.dogo.com.dogo_android.u;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final /* synthetic */ i a;
    public final /* synthetic */ i.e b;
    public /* synthetic */ c(i iVar, i.e eVar) {
        super();
        this.a = iVar;
        this.b = eVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SpecialProgramExercisesAdapter_TrickWithVariationHolder.b(this.a, this.b, view);
    }
}
