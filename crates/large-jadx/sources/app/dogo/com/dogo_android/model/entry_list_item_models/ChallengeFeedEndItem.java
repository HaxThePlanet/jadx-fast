package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView.e0;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.h.w0;
import app.dogo.com.dogo_android.util.n0.e;
import h.a.b.b;
import h.a.b.h.f;
import h.a.c.b;
import java.util.List;

/* loaded from: classes.dex */
public class ChallengeFeedEndItem extends app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem<app.dogo.com.dogo_android.model.entry_list_item_models.ChallengeFeedEndItem.ViewHolder, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem> {

    public app.dogo.com.dogo_android.model.entry_list_item_models.ChallengeFeedEndObservable.LabelState labelState;

    static final class ViewHolder extends b {

        private app.dogo.com.dogo_android.model.entry_list_item_models.ChallengeFeedEndObservable vm;
        public ViewHolder(View view, e e2) {
            super(view, e2);
            w0 obj2 = w0.T(view);
            ChallengeFeedEndObservable challengeFeedEndObservable = new ChallengeFeedEndObservable();
            this.vm = challengeFeedEndObservable;
            obj2.V(challengeFeedEndObservable);
            a aVar = new a(e2);
            obj2.O.setOnClickListener(aVar);
        }

        static void a(e e, View view2) {
            e.n2().I();
        }

        @Override // h.a.c.b
        public void setData(app.dogo.com.dogo_android.model.entry_list_item_models.ChallengeFeedEndObservable.LabelState challengeFeedEndObservable$LabelState) {
            this.vm.setData(labelState);
        }
    }
    public ChallengeFeedEndItem(app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem entrySortingTabItem, app.dogo.com.dogo_android.model.entry_list_item_models.ChallengeFeedEndObservable.LabelState challengeFeedEndObservable$LabelState2) {
        super(entrySortingTabItem);
        this.labelState = labelState2;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3, List list4) {
        bindViewHolder(b, (ChallengeFeedEndItem.ViewHolder)e02, i3, list4);
    }

    public void bindViewHolder(b<f> b, app.dogo.com.dogo_android.model.entry_list_item_models.ChallengeFeedEndItem.ViewHolder challengeFeedEndItem$ViewHolder2, int i3, List<Object> list4) {
        viewHolder2.setData(this.labelState);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public RecyclerView.e0 createViewHolder(View view, b b2) {
        return createViewHolder(view, b2);
    }

    public app.dogo.com.dogo_android.model.entry_list_item_models.ChallengeFeedEndItem.ViewHolder createViewHolder(View view, b<f> b2) {
        ChallengeFeedEndItem.ViewHolder viewHolder = new ChallengeFeedEndItem.ViewHolder(view, (e)b2);
        return viewHolder;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        if (object instanceof ChallengeFeedEndItem) {
            return getId().equals((ChallengeFeedEndItem)object.getId());
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("challenge_feed_end_card_");
        stringBuilder.append(this.labelState.ordinal());
        return stringBuilder.toString();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return 2131558469;
    }
}
