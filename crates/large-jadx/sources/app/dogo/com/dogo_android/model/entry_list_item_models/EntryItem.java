package app.dogo.com.dogo_android.model.entry_list_item_models;

import h.a.b.h.c;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008&\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u000e\u0008\u0001\u0010\u0003*\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0007\u0008\u0016¢\u0006\u0002\u0010\u0006B\u000f\u0008\u0016\u0012\u0006\u0010\u0007\u001a\u00028\u0001¢\u0006\u0002\u0010\u0008J\u001a\u0010\r\u001a\u00020\u000e2\u0010\u0010\u000f\u001a\u000c\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u0003\u0018\u00010\u0000H\u0016R\u0014\u0010\t\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryItem;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "H", "Leu/davidea/flexibleadapter/items/IHeader;", "Leu/davidea/flexibleadapter/items/AbstractSectionableItem;", "()V", "header", "(Leu/davidea/flexibleadapter/items/IHeader;)V", "id", "", "getId", "()Ljava/lang/String;", "isItemOlderThen", "", "item", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class EntryItem<VH extends androidx.recyclerview.widget.RecyclerView.e0, H extends h.a.b.h.g<?>>  extends c<VH, H> {
    public EntryItem() {
        super(0);
    }

    public EntryItem(H h) {
        super(h);
    }

    @Override // h.a.b.h.c
    public abstract String getId();

    public boolean isItemOlderThen(app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem<?, ?> entryItem) {
        return 0;
    }
}
