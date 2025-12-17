package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.h.a2;

/* loaded from: classes.dex */
public final class f implements View.OnClickListener {

    public final app.dogo.com.dogo_android.model.entry_list_item_models.EntryOldPhotoItem.ViewHolder a;
    public final a2 b;
    public f(app.dogo.com.dogo_android.model.entry_list_item_models.EntryOldPhotoItem.ViewHolder entryOldPhotoItem$ViewHolder, a2 a22) {
        super();
        this.a = viewHolder;
        this.b = a22;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.a.m(this.b, view);
    }
}
