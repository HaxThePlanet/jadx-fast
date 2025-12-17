package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.e0;
import app.dogo.com.dogo_android.h.i7;
import h.a.b.b;
import h.a.b.h.a;
import h.a.b.h.f;
import h.a.c.b;
import java.util.List;

/* loaded from: classes.dex */
public class ChallengeTitleItem extends app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem<app.dogo.com.dogo_android.model.entry_list_item_models.ChallengeTitleItem.ViewHolder, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem> {

    public static int NOTIFICATION_CLICK_AREA = 2131362900;

    static final class ViewHolder extends b {
        public ViewHolder(View view, b b2) {
            super(view, b2);
            obj1.O.setOnClickListener(this);
        }
    }
    static {
    }

    public ChallengeTitleItem() {
        super(0);
        setSelectable(false);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3, List list4) {
        bindViewHolder(b, (ChallengeTitleItem.ViewHolder)e02, i3, list4);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(b b, app.dogo.com.dogo_android.model.entry_list_item_models.ChallengeTitleItem.ViewHolder challengeTitleItem$ViewHolder2, int i3, List list4) {
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public RecyclerView.e0 createViewHolder(View view, b b2) {
        return createViewHolder(view, b2);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public app.dogo.com.dogo_android.model.entry_list_item_models.ChallengeTitleItem.ViewHolder createViewHolder(View view, b b2) {
        ChallengeTitleItem.ViewHolder viewHolder = new ChallengeTitleItem.ViewHolder(view, b2);
        return viewHolder;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        return object instanceof ChallengeTitleItem;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return "SOCIAL_HEADER";
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return 2131558554;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void unbindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3) {
        unbindViewHolder(b, (ChallengeTitleItem.ViewHolder)e02, i3);
    }

    public void unbindViewHolder(b<f> b, app.dogo.com.dogo_android.model.entry_list_item_models.ChallengeTitleItem.ViewHolder challengeTitleItem$ViewHolder2, int i3) {
    }
}
