package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.util.n0.e;

/* loaded from: classes.dex */
public final class p implements View.OnClickListener {

    public final app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoItem.ViewHolder a;
    public final e b;
    public p(app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoItem.ViewHolder entryPhotoItem$ViewHolder, e e2) {
        super();
        this.a = viewHolder;
        this.b = e2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.a.k(this.b, view);
    }
}
