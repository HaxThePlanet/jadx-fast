package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.util.n0.e;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final /* synthetic */ e a;
    public /* synthetic */ a(e eVar) {
        super();
        this.a = eVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ChallengeFeedEndItem.ViewHolder.a(this.a, view);
    }
}
