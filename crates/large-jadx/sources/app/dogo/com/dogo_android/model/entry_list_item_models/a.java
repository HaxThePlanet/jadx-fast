package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.util.n0.e;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final e a;
    public a(e e) {
        super();
        this.a = e;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ChallengeFeedEndItem.ViewHolder.a(this.a, view);
    }
}
