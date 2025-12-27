package app.dogo.com.dogo_android.util.n0;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.model.entry_list_item_models.ChallengePagerCardItem;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final /* synthetic */ g a;
    public final /* synthetic */ ChallengePagerCardItem b;
    public final /* synthetic */ int c;
    public /* synthetic */ b(g gVar, ChallengePagerCardItem challengePagerCardItem, int i) {
        super();
        this.a = gVar;
        this.b = challengePagerCardItem;
        this.c = i;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.a.B(this.b, this.c, view);
    }
}
