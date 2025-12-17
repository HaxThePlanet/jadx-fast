package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class s implements View.OnClickListener {

    public final app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoItem.ViewHolder a;
    public s(app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoItem.ViewHolder entryUserPhotoItem$ViewHolder) {
        super();
        this.a = viewHolder;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.a.i(view);
    }
}
