package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.h.a2;
import app.dogo.com.dogo_android.util.n0.e;

/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final app.dogo.com.dogo_android.model.entry_list_item_models.EntryOldPhotoItem.ViewHolder a;
    public final e b;
    public final a2 c;
    public c(app.dogo.com.dogo_android.model.entry_list_item_models.EntryOldPhotoItem.ViewHolder entryOldPhotoItem$ViewHolder, e e2, a2 a23) {
        super();
        this.a = viewHolder;
        this.b = e2;
        this.c = a23;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.a.k(this.b, this.c, view);
    }
}
