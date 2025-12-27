package app.dogo.com.dogo_android.subscription.benefits;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.s7;
import app.dogo.com.dogo_android.subscription.DogoSkuDetails;
import java.util.List;
import kotlin.Metadata;

/* compiled from: SubscriptionBenefitsOfferAdapter.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001f B+\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0008\u0010\u0015\u001a\u00020\u000eH\u0016J\u001c\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter$ViewHolder;", "skuList", "", "Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;", "freeTrailEligible", "", "pricePerPeriodType", "Lapp/dogo/com/dogo_android/enums/PricePerPeriodType;", "callback", "Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter$Callbacks;", "(Ljava/util/List;ZLapp/dogo/com/dogo_android/enums/PricePerPeriodType;Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter$Callbacks;)V", "position", "", "currentSelectedValue", "getCurrentSelectedValue", "()I", "setCurrentSelectedValue", "(I)V", "lastSelectedPosition", "getItemCount", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onNewItemSelected", "lastPosition", "Callbacks", "ViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SubscriptionBenefitsOfferAdapter extends RecyclerView.h<SubscriptionBenefitsOfferAdapter.ViewHolder> {

    private final SubscriptionBenefitsOfferAdapter.Callbacks callback;
    private final boolean freeTrailEligible;
    private int lastSelectedPosition;
    private final app.dogo.com.dogo_android.k.n pricePerPeriodType;
    private final List<DogoSkuDetails> skuList;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0008\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter$Callbacks;", "", "onItemSelect", "", "position", "", "onSelectedItemClick", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Callbacks {
        void onItemSelect(int position);

        void onSelectedItemClick();
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellSubscriptionPlanInformationCardBinding;", "(Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter;Lapp/dogo/com/dogo_android/databinding/CellSubscriptionPlanInformationCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellSubscriptionPlanInformationCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class ViewHolder extends RecyclerView.e0 {

        private final s7 binding;
        public ViewHolder(s7 s7Var) {
            n.f(subscriptionBenefitsOfferAdapter, "this$0");
            n.f(s7Var, "binding");
            this.this$0 = subscriptionBenefitsOfferAdapter;
            super(s7Var.w());
            this.binding = s7Var;
            s7Var.w().setOnClickListener(new i(subscriptionBenefitsOfferAdapter, this));
        }

        private static final void _init_$lambda_1(SubscriptionBenefitsOfferAdapter subscriptionBenefitsOfferAdapter, SubscriptionBenefitsOfferAdapter.ViewHolder viewHolder, View view) {
            n.f(subscriptionBenefitsOfferAdapter, "this$0");
            n.f(viewHolder, "this$1");
            int i = subscriptionBenefitsOfferAdapter.lastSelectedPosition;
            if (i == viewHolder.getAdapterPosition()) {
                subscriptionBenefitsOfferAdapter.callback.onSelectedItemClick();
            } else {
                subscriptionBenefitsOfferAdapter.onNewItemSelected(viewHolder.getAdapterPosition(), i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final s7 getBinding() {
            return this.binding;
        }

        public static /* synthetic */ void a(SubscriptionBenefitsOfferAdapter subscriptionBenefitsOfferAdapter, SubscriptionBenefitsOfferAdapter.ViewHolder viewHolder, View view) {
            SubscriptionBenefitsOfferAdapter_ViewHolder._init_$lambda_1(subscriptionBenefitsOfferAdapter, viewHolder, view);
        }
    }
    public SubscriptionBenefitsOfferAdapter(List<DogoSkuDetails> list, boolean z, app.dogo.com.dogo_android.k.n nVar, SubscriptionBenefitsOfferAdapter.Callbacks callbacks) {
        n.f(list, "skuList");
        n.f(nVar, "pricePerPeriodType");
        n.f(callbacks, "callback");
        super();
        this.skuList = list;
        this.freeTrailEligible = z;
        this.pricePerPeriodType = nVar;
        this.callback = callbacks;
    }

    public static final /* synthetic */ SubscriptionBenefitsOfferAdapter.Callbacks access$getCallback$p(SubscriptionBenefitsOfferAdapter subscriptionBenefitsOfferAdapter) {
        return subscriptionBenefitsOfferAdapter.callback;
    }

    public static final /* synthetic */ int access$getLastSelectedPosition$p(SubscriptionBenefitsOfferAdapter subscriptionBenefitsOfferAdapter) {
        return subscriptionBenefitsOfferAdapter.lastSelectedPosition;
    }

    public static final /* synthetic */ void access$onNewItemSelected(SubscriptionBenefitsOfferAdapter subscriptionBenefitsOfferAdapter, int i, int i2) {
        subscriptionBenefitsOfferAdapter.onNewItemSelected(i, i2);
    }

    private final void onNewItemSelected(int position, int lastPosition) {
        this.lastSelectedPosition = position;
        Integer num = 0;
        notifyItemChanged(lastPosition, num);
        notifyItemChanged(position, num);
        this.callback.onItemSelect(position);
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
    public final void setCurrentSelectedValue(int i) {
        onNewItemSelected(i, this.lastSelectedPosition);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(SubscriptionBenefitsOfferAdapter.ViewHolder viewHolder, int i) {
        boolean z = true;
        n.f(viewHolder, "holder");
        final s7 binding = viewHolder.getBinding();
        i = i == this.lastSelectedPosition ? 1 : 0;
        binding.X((i == this.lastSelectedPosition ? 1 : 0));
        binding.Y((DogoSkuDetails)this.skuList.get(i));
        binding.W((i == this.lastSelectedPosition ? 1 : 0));
        binding.V((i == this.lastSelectedPosition ? 1 : 0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public SubscriptionBenefitsOfferAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        n.f(viewGroup, "parent");
        final s7 s7Var = s7.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(s7Var, "inflate(inflater, parent, false)");
        return new SubscriptionBenefitsOfferAdapter_ViewHolder(this, s7Var);
    }
}
