package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.q;
import app.dogo.com.dogo_android.h.oh;
import app.dogo.com.dogo_android.util.n0.e;
import h.a.b.b;
import h.a.b.h.f;
import h.a.c.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u0014\u0012\u0008\u0012\u00060\u0002R\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001\u001eB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008JB\u0010\u000b\u001a\u00020\u000c2\u0014\u0010\r\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000e2\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016J(\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u000eH\u0016J\u0013\u0010\u001a\u001a\u00020\u00072\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\u0008\u0010\u001c\u001a\u00020\u0013H\u0016J\u0008\u0010\u001d\u001a\u00020\u0013H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/model/entry_list_item_models/BecomePremiumBannerItem;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryItem;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/BecomePremiumBannerItem$ViewHolder;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem;", "id", "", "isVisible", "", "(Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "bindViewHolder", "", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "Leu/davidea/flexibleadapter/items/IFlexible;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "position", "", "payload", "", "", "createViewHolder", "view", "Landroid/view/View;", "equals", "other", "getLayoutRes", "hashCode", "ViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BecomePremiumBannerItem extends app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem<app.dogo.com.dogo_android.model.entry_list_item_models.BecomePremiumBannerItem.ViewHolder, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem> {

    private final String id;
    private final boolean isVisible;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/model/entry_list_item_models/BecomePremiumBannerItem$ViewHolder;", "Leu/davidea/viewholders/FlexibleViewHolder;", "view", "Landroid/view/View;", "adapter", "Lapp/dogo/com/dogo_android/util/recycle_views/ChallengeEntryListAdapter;", "isVisible", "", "(Lapp/dogo/com/dogo_android/model/entry_list_item_models/BecomePremiumBannerItem;Landroid/view/View;Lapp/dogo/com/dogo_android/util/recycle_views/ChallengeEntryListAdapter;Z)V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class ViewHolder extends b {

        final app.dogo.com.dogo_android.model.entry_list_item_models.BecomePremiumBannerItem this$0;
        public ViewHolder(app.dogo.com.dogo_android.model.entry_list_item_models.BecomePremiumBannerItem becomePremiumBannerItem, View view2, e e3, boolean z4) {
            androidx.constraintlayout.widget.ConstraintLayout obj3;
            RecyclerView.q obj4;
            n.f(becomePremiumBannerItem, "this$0");
            n.f(view2, "view");
            n.f(e3, "adapter");
            this.this$0 = becomePremiumBannerItem;
            super(view2, e3);
            obj3 = oh.T(view2);
            n.e(obj3, "bind(view)");
            int i = -2;
            obj4 = new RecyclerView.q(-1, i);
            androidx.constraintlayout.widget.ConstraintLayout obj5 = obj3.O;
            n.e(obj5, "holderBinding.becomePremium");
            obj3.P.setOnClickListener(this);
            int i2 = 0;
            if (z4) {
                obj4.height = i;
                obj5.setLayoutParams(obj4);
                obj3.O.setVisibility(i2);
            } else {
                obj4.height = i2;
                obj5.setLayoutParams(obj4);
                obj3.O.setVisibility(8);
            }
        }
    }
    public BecomePremiumBannerItem(String string, boolean z2) {
        n.f(string, "id");
        super(0);
        this.id = string;
        this.isVisible = z2;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3, List list4) {
        bindViewHolder(b, (BecomePremiumBannerItem.ViewHolder)e02, i3, list4);
    }

    public void bindViewHolder(b<f<RecyclerView.e0>> b, app.dogo.com.dogo_android.model.entry_list_item_models.BecomePremiumBannerItem.ViewHolder becomePremiumBannerItem$ViewHolder2, int i3, List<Object> list4) {
        n.f(viewHolder2, "viewHolder");
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public RecyclerView.e0 createViewHolder(View view, b b2) {
        return createViewHolder(view, b2);
    }

    public app.dogo.com.dogo_android.model.entry_list_item_models.BecomePremiumBannerItem.ViewHolder createViewHolder(View view, b<f<RecyclerView.e0>> b2) {
        n.f(view, "view");
        n.f(b2, "adapter");
        BecomePremiumBannerItem.ViewHolder viewHolder = new BecomePremiumBannerItem.ViewHolder(this, view, (e)b2, this.isVisible);
        return viewHolder;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        if (object instanceof BecomePremiumBannerItem) {
            return n.b(getId(), (BecomePremiumBannerItem)object.getId());
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return this.id;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return 2131558736;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int hashCode() {
        return i2 += i4;
    }
}
