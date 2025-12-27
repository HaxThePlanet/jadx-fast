@Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/subscription/SubscriptionBindingAdapters$setCustomerExperienceList$2", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageScrollStateChanged", "", "state", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* renamed from: 2 */
public static final class SubscriptionBindingAdapters_setCustomerExperienceList_2 extends androidx.viewpager2.widget.ViewPager2.i {

    final /* synthetic */ app.dogo.com.dogo_android.subscription.benefits.UserTestimonialsCallback $callback;
    2(app.dogo.com.dogo_android.subscription.benefits.UserTestimonialsCallback userTestimonialsCallback) {
        this.$callback = userTestimonialsCallback;
        super();
    }

    @Override // androidx.viewpager2.widget.ViewPager2$i
    public void onPageScrollStateChanged(int state) {
        super.onPageScrollStateChanged(state);
        if (state == 0) {
            this.$callback.onItemSwitched();
        }
    }
}
