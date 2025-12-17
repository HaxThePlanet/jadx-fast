package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.e0;
import app.dogo.com.dogo_android.h.a0;
import app.dogo.com.dogo_android.util.e0.b0;
import h.a.b.b;
import h.a.b.h.f;
import h.a.c.b;
import java.util.List;

/* loaded from: classes.dex */
public class BlankScreenCell extends app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem<app.dogo.com.dogo_android.model.entry_list_item_models.BlankScreenCell.ViewHolder, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem> implements b0<app.dogo.com.dogo_android.model.entry_list_item_models.BlankScreenCell.ViewHolder> {

    private String id;
    private int priority;

    static final class ViewHolder extends b {
        public ViewHolder(View view, b<f> b2) {
            super(view, b2);
            obj1.O.setVisibility(0);
        }
    }
    public BlankScreenCell(app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem entrySortingTabItem) {
        super("blank", entrySortingTabItem);
    }

    private BlankScreenCell(String string, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem entrySortingTabItem2) {
        super(entrySortingTabItem2);
        this.priority = -2147483647;
        this.id = string;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3, List list4) {
        bindViewHolder(b, (BlankScreenCell.ViewHolder)e02, i3, list4);
    }

    public void bindViewHolder(b<f> b, app.dogo.com.dogo_android.model.entry_list_item_models.BlankScreenCell.ViewHolder blankScreenCell$ViewHolder2, int i3, List<Object> list4) {
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public RecyclerView.e0 createViewHolder(View view, b b2) {
        return createViewHolder(view, b2);
    }

    public app.dogo.com.dogo_android.model.entry_list_item_models.BlankScreenCell.ViewHolder createViewHolder(View view, b<f> b2) {
        BlankScreenCell.ViewHolder viewHolder = new BlankScreenCell.ViewHolder(view, b2);
        return viewHolder;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        boolean z;
        Object obj2;
        if (object instanceof BlankScreenCell && object.id.equals(this.id)) {
            obj2 = object.id.equals(this.id) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return this.id;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return 2131558457;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getSortingPriority() {
        return this.priority;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean isContentSame(b0 b0) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean isSwipeable() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void setSortingPriority(int i) {
        this.priority = i;
    }
}
