package app.dogo.com.dogo_android.util.n0;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.model.entry_list_item_models.ChallengePagerCardItem;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final app.dogo.com.dogo_android.util.n0.g a;
    public final ChallengePagerCardItem b;
    public final int c;
    public b(app.dogo.com.dogo_android.util.n0.g g, ChallengePagerCardItem challengePagerCardItem2, int i3) {
        super();
        this.a = g;
        this.b = challengePagerCardItem2;
        this.c = i3;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.a.B(this.b, this.c, view);
    }
}
