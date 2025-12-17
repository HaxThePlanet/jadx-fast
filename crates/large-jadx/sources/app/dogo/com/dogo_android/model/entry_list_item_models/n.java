package app.dogo.com.dogo_android.model.entry_list_item_models;

import app.dogo.com.dogo_android.util.n0.e;
import kotlin.d0.c.a;

/* loaded from: classes.dex */
public final class n implements a {

    public final app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoItem.ViewHolder a;
    public final int b;
    public final e c;
    public n(app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoItem.ViewHolder entryPhotoItem$ViewHolder, int i2, e e3) {
        super();
        this.a = viewHolder;
        this.b = i2;
        this.c = e3;
    }

    @Override // kotlin.d0.c.a
    public final Object invoke() {
        return this.a.e(this.b, this.c);
    }
}
