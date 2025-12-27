package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView.e0;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.h.w0;
import app.dogo.com.dogo_android.util.n0.e;
import h.a.b.h.f;
import java.util.List;

/* compiled from: ChallengeFeedEndItem.java */
/* loaded from: classes.dex */
public class ChallengeFeedEndItem extends EntryItem<ChallengeFeedEndItem.ViewHolder, EntrySortingTabItem> {

    public ChallengeFeedEndObservable.LabelState labelState;

    static final class ViewHolder extends h.a.c.b {

        private ChallengeFeedEndObservable vm = new ChallengeFeedEndObservable();
        public ViewHolder(View view, e eVar) {
            super(view, eVar);
            w0 w0Var = w0.T(view);
            w0Var.V(new ChallengeFeedEndObservable());
            w0Var.O.setOnClickListener(new a(eVar));
        }

        static /* synthetic */ void a(e eVar, View view) {
            eVar.n2().I();
        }

        @Override // h.a.c.b
        public void setData(ChallengeFeedEndObservable.LabelState labelState) {
            this.vm.setData(labelState);
        }
    }
    public ChallengeFeedEndItem(EntrySortingTabItem entrySortingTabItem, ChallengeFeedEndObservable.LabelState labelState) {
        super(entrySortingTabItem);
        this.labelState = labelState;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        if (object instanceof ChallengeFeedEndItem) {
            return getId().equals(object.getId());
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "challenge_feed_end_card_";
        int ordinal = this.labelState.ordinal();
        str = str2 + ordinal;
        return str;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(h.a.b.b<f> bVar, ChallengeFeedEndItem.ViewHolder viewHolder, int i, List<Object> list) {
        viewHolder.setData(this.labelState);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public ChallengeFeedEndItem.ViewHolder createViewHolder(View view, h.a.b.b<f> bVar) {
        return new ChallengeFeedEndItem.ViewHolder(view, bVar);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return R.layout.cell_challenge_feed_end_card;
    }
}
