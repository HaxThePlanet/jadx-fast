package app.dogo.com.dogo_android.subscription.benefits;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.g1;
import app.dogo.com.dogo_android.repository.domain.CustomerExperience;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.t;
import kotlin.f0.c;
import kotlin.i0.l;

/* compiled from: SubscriptionTestimonialsAdapter.kt */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0004J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016R7\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000c¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionTestimonialsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionTestimonialsAdapter$ViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "()V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/CustomerExperience;", "experienceItemsList", "getExperienceItemsList", "()Ljava/util/List;", "setExperienceItemsList", "(Ljava/util/List;)V", "experienceItemsList$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SubscriptionTestimonialsAdapter extends RecyclerView.h<SubscriptionTestimonialsAdapter.ViewHolder> implements app.dogo.com.dogo_android.util.d0.a {

    static final /* synthetic */ l<Object>[] $$delegatedProperties;
    /* renamed from: experienceItemsList$delegate, reason: from kotlin metadata */
    private final c experienceItemsList = new SubscriptionTestimonialsAdapter$special$$inlined$observable$1();

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionTestimonialsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellCustomerExperienceBinding;", "(Lapp/dogo/com/dogo_android/databinding/CellCustomerExperienceBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellCustomerExperienceBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ViewHolder extends RecyclerView.e0 {

        private final g1 binding;
        public ViewHolder(g1 g1Var) {
            n.f(g1Var, "binding");
            super(g1Var.w());
            this.binding = g1Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final g1 getBinding() {
            return this.binding;
        }
    }
    static {
        l[] arr = new l[1];
        SubscriptionTestimonialsAdapter.$$delegatedProperties = new l[] { c0.f(new t(c0.b(SubscriptionTestimonialsAdapter.class), "experienceItemsList", "getExperienceItemsList()Ljava/util/List;")) };
    }

    public SubscriptionTestimonialsAdapter() {
        super();
        List list = p.g();
        final app.dogo.com.dogo_android.subscription.benefits.SubscriptionTestimonialsAdapter.special$$inlined.observable.AnonymousClass1 delegates_observable_1 = new Delegates_observable_1(list, list, this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public <T> void autoNotify(RecyclerView.h<?> hVar, List<? extends T> list, List<? extends T> list2, kotlin.d0.c.p<? super T, ? super T, Boolean> pVar) {
        app.dogo.com.dogo_android.util.adapter.a.a.a(this, hVar, list, list2, pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final List<CustomerExperience> getExperienceItemsList() {
        return (List)this.experienceItemsList.getValue(this, SubscriptionTestimonialsAdapter.$$delegatedProperties[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void setExperienceItemsList(List<CustomerExperience> list) {
        n.f(list, "<set-?>");
        this.experienceItemsList.setValue(this, SubscriptionTestimonialsAdapter.$$delegatedProperties[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(SubscriptionTestimonialsAdapter.ViewHolder viewHolder, int i) {
        n.f(viewHolder, "holder");
        viewHolder.getBinding().V((CustomerExperience)getExperienceItemsList().get(i % getExperienceItemsList().size()));
        viewHolder.getBinding().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public SubscriptionTestimonialsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        n.f(viewGroup, "parent");
        final g1 g1Var = g1.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(g1Var, "inflate(inflater, parent, false)");
        return new SubscriptionTestimonialsAdapter_ViewHolder(g1Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return 0x7fffffff /* Unknown resource */;
    }
}
