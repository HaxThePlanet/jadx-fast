package app.dogo.com.dogo_android.subscription.benefits;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.g1;
import app.dogo.com.dogo_android.repository.domain.CustomerExperience;
import app.dogo.com.dogo_android.util.d0.a;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.p;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.t;
import kotlin.f0.a;
import kotlin.f0.c;
import kotlin.i0.l;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0004J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016R7\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000c¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionTestimonialsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionTestimonialsAdapter$ViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "()V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/CustomerExperience;", "experienceItemsList", "getExperienceItemsList", "()Ljava/util/List;", "setExperienceItemsList", "(Ljava/util/List;)V", "experienceItemsList$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SubscriptionTestimonialsAdapter extends RecyclerView.h<app.dogo.com.dogo_android.subscription.benefits.SubscriptionTestimonialsAdapter.ViewHolder> implements a {

    static final l<Object>[] $$delegatedProperties;
    private final c experienceItemsList$delegate;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionTestimonialsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellCustomerExperienceBinding;", "(Lapp/dogo/com/dogo_android/databinding/CellCustomerExperienceBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellCustomerExperienceBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ViewHolder extends RecyclerView.e0 {

        private final g1 binding;
        public ViewHolder(g1 g1) {
            n.f(g1, "binding");
            super(g1.w());
            this.binding = g1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final g1 getBinding() {
            return this.binding;
        }
    }
    static {
        l[] arr = new l[1];
        t tVar = new t(c0.b(SubscriptionTestimonialsAdapter.class), "experienceItemsList", "getExperienceItemsList()Ljava/util/List;");
        SubscriptionTestimonialsAdapter.$$delegatedProperties = arr;
    }

    public SubscriptionTestimonialsAdapter() {
        super();
        a aVar = a.a;
        List list = p.g();
        SubscriptionTestimonialsAdapter.special$$inlined.observable.1 anon = new SubscriptionTestimonialsAdapter.special$$inlined.observable.1(list, list, this);
        this.experienceItemsList$delegate = anon;
    }

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    public final List<CustomerExperience> getExperienceItemsList() {
        return (List)this.experienceItemsList$delegate.getValue(this, SubscriptionTestimonialsAdapter.$$delegatedProperties[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        onBindViewHolder((SubscriptionTestimonialsAdapter.ViewHolder)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(app.dogo.com.dogo_android.subscription.benefits.SubscriptionTestimonialsAdapter.ViewHolder subscriptionTestimonialsAdapter$ViewHolder, int i2) {
        n.f(viewHolder, "holder");
        viewHolder.getBinding().V((CustomerExperience)getExperienceItemsList().get(i2 %= size));
        viewHolder.getBinding().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return onCreateViewHolder(viewGroup, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.subscription.benefits.SubscriptionTestimonialsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final g1 obj2 = g1.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj2, "inflate(inflater, parent, false)");
        SubscriptionTestimonialsAdapter.ViewHolder obj3 = new SubscriptionTestimonialsAdapter.ViewHolder(obj2);
        return obj3;
    }

    public final void setExperienceItemsList(List<CustomerExperience> list) {
        n.f(list, "<set-?>");
        this.experienceItemsList$delegate.setValue(this, SubscriptionTestimonialsAdapter.$$delegatedProperties[0], list);
    }
}
