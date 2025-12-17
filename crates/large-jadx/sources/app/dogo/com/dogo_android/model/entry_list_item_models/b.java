package app.dogo.com.dogo_android.model.entry_list_item_models;

import app.dogo.com.dogo_android.util.n0.h;

/* loaded from: classes.dex */
public final class b implements h {

    public final app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterItem.ViewHolder a;
    public final app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterViewModel b;
    public b(app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterItem.ViewHolder entryFilterItem$ViewHolder, app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterViewModel entryFilterViewModel2) {
        super();
        this.a = viewHolder;
        this.b = entryFilterViewModel2;
    }

    @Override // app.dogo.com.dogo_android.util.n0.h
    public final void a(int i) {
        this.a.b(this.b, i);
    }
}
