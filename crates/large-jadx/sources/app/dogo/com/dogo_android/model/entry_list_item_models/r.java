package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.util.n0.e;

/* loaded from: classes.dex */
public final class r implements View.OnClickListener {

    public final app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoItem.ViewHolder a;
    public final e b;
    public r(app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoItem.ViewHolder entryUserPhotoItem$ViewHolder, e e2) {
        super();
        this.a = viewHolder;
        this.b = e2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.a.m(this.b, view);
    }
}
