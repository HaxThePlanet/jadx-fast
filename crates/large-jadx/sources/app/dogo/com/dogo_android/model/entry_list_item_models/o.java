package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.h.c2;
import app.dogo.com.dogo_android.util.n0.e;

/* loaded from: classes.dex */
public final class o implements View.OnClickListener {

    public final app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoItem.ViewHolder a;
    public final e b;
    public final c2 c;
    public o(app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoItem.ViewHolder entryPhotoItem$ViewHolder, e e2, c2 c23) {
        super();
        this.a = viewHolder;
        this.b = e2;
        this.c = c23;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.a.m(this.b, this.c, view);
    }
}
