package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.h.c2;

/* loaded from: classes.dex */
public final class m implements View.OnClickListener {

    public final app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoItem.ViewHolder a;
    public final c2 b;
    public m(app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoItem.ViewHolder entryPhotoItem$ViewHolder, c2 c22) {
        super();
        this.a = viewHolder;
        this.b = c22;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.a.o(this.b, view);
    }
}
