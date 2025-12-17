package app.dogo.com.dogo_android.model.entry_list_item_models;

import app.dogo.com.dogo_android.util.n0.u;

/* loaded from: classes.dex */
public final class u implements u {

    public final app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoItem.ViewHolder a;
    public final int b;
    public u(app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoItem.ViewHolder entryUserPhotoItem$ViewHolder, int i2) {
        super();
        this.a = viewHolder;
        this.b = i2;
    }

    @Override // app.dogo.com.dogo_android.util.n0.u
    public final boolean a(Object object, int i2) {
        return this.a.e(this.b, (List)object, i2);
    }
}
