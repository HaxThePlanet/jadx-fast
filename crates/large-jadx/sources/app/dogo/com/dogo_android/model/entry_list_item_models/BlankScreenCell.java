package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.e0;
import app.dogo.com.dogo_android.h.a0;
import app.dogo.com.dogo_android.util.e0.b0;
import h.a.b.h.f;
import java.util.List;

/* compiled from: BlankScreenCell.java */
/* loaded from: classes.dex */
public class BlankScreenCell extends EntryItem<BlankScreenCell.ViewHolder, EntrySortingTabItem> implements b0<BlankScreenCell.ViewHolder> {

    private String id;
    private int priority;

    static final class ViewHolder extends h.a.c.b {
        public ViewHolder(View view, h.a.b.b<f> bVar) {
            super(view, bVar);
            a0.T(view).O.setVisibility(0);
        }
    }
    private BlankScreenCell(String str, EntrySortingTabItem entrySortingTabItem) {
        super(entrySortingTabItem);
        this.priority = -2147483647;
        this.id = str;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        boolean z;
        boolean z2 = false;
        z = object instanceof BlankScreenCell;
        if (object instanceof BlankScreenCell) {
            object = object.id.equals(this.id) ? 1 : 0;
        }
        return (object.id.equals(this.id) ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return this.id;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getSortingPriority() {
        return this.priority;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void setSortingPriority(int i) {
        this.priority = i;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public BlankScreenCell.ViewHolder createViewHolder(View view, h.a.b.b<f> bVar) {
        return new BlankScreenCell.ViewHolder(view, bVar);
    }

    public BlankScreenCell(EntrySortingTabItem entrySortingTabItem) {
        this("blank", entrySortingTabItem);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(h.a.b.b<f> bVar, BlankScreenCell.ViewHolder viewHolder, int i, List<Object> list) {
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return R.layout.cell_blank_screen_row;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean isContentSame(b0 b0Var) {
        return true;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean isSwipeable() {
        return false;
    }
}
