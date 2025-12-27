@Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* renamed from: 1 */
public static final class Delegates_observable_1 extends kotlin.f0.b<java.util.List<? extends app.dogo.com.dogo_android.repository.domain.CustomerExperience>> {

    final /* synthetic */ Object $initialValue;
    public 1(Object object, Object object2, SubscriptionTestimonialsAdapter subscriptionTestimonialsAdapter) {
        this.$initialValue = object;
        super(object2);
    }

    @Override // kotlin.f0.b
    protected void afterChange(kotlin.i0.l<?> property, java.util.List<? extends app.dogo.com.dogo_android.repository.domain.CustomerExperience> oldValue, java.util.List<? extends app.dogo.com.dogo_android.repository.domain.CustomerExperience> newValue) {
        n.f(property, "property");
        SubscriptionTestimonialsAdapter.this.autoNotify(SubscriptionTestimonialsAdapter.this, oldValue, newValue, SubscriptionTestimonialsAdapter.experienceItemsList.AnonymousClass2.AnonymousClass1.INSTANCE);
    }
}
