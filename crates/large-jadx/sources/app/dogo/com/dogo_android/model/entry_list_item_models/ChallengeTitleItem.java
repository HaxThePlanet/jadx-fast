package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.e0;
import app.dogo.com.dogo_android.h.i7;
import h.a.b.h.a;
import h.a.b.h.f;
import java.util.List;

/* compiled from: ChallengeTitleItem.java */
/* loaded from: classes.dex */
public class ChallengeTitleItem extends EntryItem<ChallengeTitleItem.ViewHolder, EntrySortingTabItem> {

    public static int NOTIFICATION_CLICK_AREA = 2131362900;

    static final class ViewHolder extends h.a.c.b {
        public ViewHolder(View view, h.a.b.b bVar) {
            super(view, bVar);
            i7.T(view).O.setOnClickListener(this);
        }
    }
    public ChallengeTitleItem() {
        super(null);
        setSelectable(false);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        return object instanceof ChallengeTitleItem;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public ChallengeTitleItem.ViewHolder createViewHolder(View view, h.a.b.b bVar) {
        return new ChallengeTitleItem.ViewHolder(view, bVar);
    }


    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(h.a.b.b bVar, ChallengeTitleItem.ViewHolder viewHolder, int i, List list) {
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return "SOCIAL_HEADER";
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return R.layout.cell_social_header;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void unbindViewHolder(h.a.b.b<f> bVar, ChallengeTitleItem.ViewHolder viewHolder, int i) {
    }
}
