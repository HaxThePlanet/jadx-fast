package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.q;
import app.dogo.com.dogo_android.h.oh;
import app.dogo.com.dogo_android.util.n0.e;
import h.a.b.h.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: BecomePremiumBannerItem.kt */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u0014\u0012\u0008\u0012\u00060\u0002R\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001\u001eB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008JB\u0010\u000b\u001a\u00020\u000c2\u0014\u0010\r\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000e2\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016J(\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u000eH\u0016J\u0013\u0010\u001a\u001a\u00020\u00072\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\u0008\u0010\u001c\u001a\u00020\u0013H\u0016J\u0008\u0010\u001d\u001a\u00020\u0013H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/model/entry_list_item_models/BecomePremiumBannerItem;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryItem;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/BecomePremiumBannerItem$ViewHolder;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntrySortingTabItem;", "id", "", "isVisible", "", "(Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "bindViewHolder", "", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "Leu/davidea/flexibleadapter/items/IFlexible;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "position", "", "payload", "", "", "createViewHolder", "view", "Landroid/view/View;", "equals", "other", "getLayoutRes", "hashCode", "ViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class BecomePremiumBannerItem extends EntryItem<BecomePremiumBannerItem.ViewHolder, EntrySortingTabItem> {

    private final String id;
    private final boolean isVisible;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/model/entry_list_item_models/BecomePremiumBannerItem$ViewHolder;", "Leu/davidea/viewholders/FlexibleViewHolder;", "view", "Landroid/view/View;", "adapter", "Lapp/dogo/com/dogo_android/util/recycle_views/ChallengeEntryListAdapter;", "isVisible", "", "(Lapp/dogo/com/dogo_android/model/entry_list_item_models/BecomePremiumBannerItem;Landroid/view/View;Lapp/dogo/com/dogo_android/util/recycle_views/ChallengeEntryListAdapter;Z)V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class ViewHolder extends h.a.c.b {
        public ViewHolder(View view, e eVar, boolean z) {
            n.f(becomePremiumBannerItem, "this$0");
            n.f(view, "view");
            n.f(eVar, "adapter");
            this.this$0 = becomePremiumBannerItem;
            super(view, eVar);
            oh ohVar = oh.T(view);
            n.e(ohVar, "bind(view)");
            int i = -2;
            RecyclerView.q qVar = new RecyclerView.q(-1, i);
            n.e(ohVar.O, "holderBinding.becomePremium");
            ohVar.P.setOnClickListener(this);
            int i2 = 0;
            if (z) {
                qVar.height = i;
                ohVar.O.setLayoutParams(qVar);
                ohVar.O.setVisibility(i2);
            } else {
                qVar.height = i2;
                ohVar.O.setLayoutParams(qVar);
                ohVar.O.setVisibility(8);
            }
        }
    }
    public BecomePremiumBannerItem(String str, boolean z) {
        n.f(str, "id");
        super(null);
        this.id = str;
        this.isVisible = z;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    /* operator */ public boolean equals(Object other) {
        if (other instanceof BecomePremiumBannerItem) {
            return n.b(getId(), other.getId());
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return this.id;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int hashCode() {
        return (getId().hashCode() * 31) + Boolean.hashCode(this.isVisible);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public BecomePremiumBannerItem.ViewHolder createViewHolder(View view, h.a.b.b<f<RecyclerView.e0>> bVar) {
        n.f(view, "view");
        n.f(bVar, "adapter");
        return new BecomePremiumBannerItem_ViewHolder(this, view, bVar, this.isVisible);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(h.a.b.b<f<RecyclerView.e0>> bVar, BecomePremiumBannerItem.ViewHolder viewHolder, int i, List<Object> list) {
        n.f(viewHolder, "viewHolder");
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return R.layout.layout_become_premium_banner;
    }
}
