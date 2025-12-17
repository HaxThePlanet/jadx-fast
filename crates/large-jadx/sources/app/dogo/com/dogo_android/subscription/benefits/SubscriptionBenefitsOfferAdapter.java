package app.dogo.com.dogo_android.subscription.benefits;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.s7;
import app.dogo.com.dogo_android.k.n;
import app.dogo.com.dogo_android.subscription.DogoSkuDetails;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001f B+\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0008\u0010\u0015\u001a\u00020\u000eH\u0016J\u001c\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter$ViewHolder;", "skuList", "", "Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;", "freeTrailEligible", "", "pricePerPeriodType", "Lapp/dogo/com/dogo_android/enums/PricePerPeriodType;", "callback", "Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter$Callbacks;", "(Ljava/util/List;ZLapp/dogo/com/dogo_android/enums/PricePerPeriodType;Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter$Callbacks;)V", "position", "", "currentSelectedValue", "getCurrentSelectedValue", "()I", "setCurrentSelectedValue", "(I)V", "lastSelectedPosition", "getItemCount", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onNewItemSelected", "lastPosition", "Callbacks", "ViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SubscriptionBenefitsOfferAdapter extends RecyclerView.h<app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter.ViewHolder> {

    private final app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter.Callbacks callback;
    private final boolean freeTrailEligible;
    private int lastSelectedPosition;
    private final n pricePerPeriodType;
    private final List<DogoSkuDetails> skuList;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0008\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter$Callbacks;", "", "onItemSelect", "", "position", "", "onSelectedItemClick", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Callbacks {
        public abstract void onItemSelect(int i);

        public abstract void onSelectedItemClick();
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellSubscriptionPlanInformationCardBinding;", "(Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter;Lapp/dogo/com/dogo_android/databinding/CellSubscriptionPlanInformationCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellSubscriptionPlanInformationCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class ViewHolder extends RecyclerView.e0 {

        private final s7 binding;
        final app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter this$0;
        public ViewHolder(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter subscriptionBenefitsOfferAdapter, s7 s72) {
            n.f(subscriptionBenefitsOfferAdapter, "this$0");
            n.f(s72, "binding");
            this.this$0 = subscriptionBenefitsOfferAdapter;
            super(s72.w());
            this.binding = s72;
            i iVar = new i(subscriptionBenefitsOfferAdapter, this);
            s72.w().setOnClickListener(iVar);
        }

        private static final void _init_$lambda-1(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter subscriptionBenefitsOfferAdapter, app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter.ViewHolder subscriptionBenefitsOfferAdapter$ViewHolder2, View view3) {
            Object obj1;
            Object obj2;
            n.f(subscriptionBenefitsOfferAdapter, "this$0");
            n.f(viewHolder2, "this$1");
            int obj3 = SubscriptionBenefitsOfferAdapter.access$getLastSelectedPosition$p(subscriptionBenefitsOfferAdapter);
            if (obj3 == viewHolder2.getAdapterPosition()) {
                SubscriptionBenefitsOfferAdapter.access$getCallback$p(subscriptionBenefitsOfferAdapter).onSelectedItemClick();
            } else {
                SubscriptionBenefitsOfferAdapter.access$onNewItemSelected(subscriptionBenefitsOfferAdapter, viewHolder2.getAdapterPosition(), obj3);
            }
        }

        public static void a(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter subscriptionBenefitsOfferAdapter, app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter.ViewHolder subscriptionBenefitsOfferAdapter$ViewHolder2, View view3) {
            SubscriptionBenefitsOfferAdapter.ViewHolder._init_$lambda-1(subscriptionBenefitsOfferAdapter, viewHolder2, view3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final s7 getBinding() {
            return this.binding;
        }
    }
    public SubscriptionBenefitsOfferAdapter(List<DogoSkuDetails> list, boolean z2, n n3, app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter.Callbacks subscriptionBenefitsOfferAdapter$Callbacks4) {
        n.f(list, "skuList");
        n.f(n3, "pricePerPeriodType");
        n.f(callbacks4, "callback");
        super();
        this.skuList = list;
        this.freeTrailEligible = z2;
        this.pricePerPeriodType = n3;
        this.callback = callbacks4;
    }

    public static final app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter.Callbacks access$getCallback$p(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter subscriptionBenefitsOfferAdapter) {
        return subscriptionBenefitsOfferAdapter.callback;
    }

    public static final int access$getLastSelectedPosition$p(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter subscriptionBenefitsOfferAdapter) {
        return subscriptionBenefitsOfferAdapter.lastSelectedPosition;
    }

    public static final void access$onNewItemSelected(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter subscriptionBenefitsOfferAdapter, int i2, int i3) {
        subscriptionBenefitsOfferAdapter.onNewItemSelected(i2, i3);
    }

    private final void onNewItemSelected(int i, int i2) {
        this.lastSelectedPosition = i;
        Integer valueOf = 0;
        notifyItemChanged(i2, valueOf);
        notifyItemChanged(i, valueOf);
        this.callback.onItemSelect(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final int getCurrentSelectedValue() {
        return this.lastSelectedPosition;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.skuList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        onBindViewHolder((SubscriptionBenefitsOfferAdapter.ViewHolder)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter.ViewHolder subscriptionBenefitsOfferAdapter$ViewHolder, int i2) {
        int obj4;
        n.f(viewHolder, "holder");
        final s7 obj3 = viewHolder.getBinding();
        obj4 = i2 == this.lastSelectedPosition ? 1 : 0;
        obj3.X(Boolean.valueOf(obj4));
        obj3.Y((DogoSkuDetails)this.skuList.get(i2));
        obj3.W(this.pricePerPeriodType);
        obj3.V(Boolean.valueOf(this.freeTrailEligible));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return onCreateViewHolder(viewGroup, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final s7 obj2 = s7.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj2, "inflate(inflater, parent, false)");
        SubscriptionBenefitsOfferAdapter.ViewHolder obj3 = new SubscriptionBenefitsOfferAdapter.ViewHolder(this, obj2);
        return obj3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void setCurrentSelectedValue(int i) {
        onNewItemSelected(i, this.lastSelectedPosition);
    }
}
