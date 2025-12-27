@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
public static final class 2<T> implements androidx.lifecycle.y<T> {
    public final void onChanged(T t) {
        android.app.Dialog showDeleteDialog = null;
        z = t instanceof LoadResult_Error;
        if (t instanceof oadResult_Error) {
            androidx.fragment.app.e activity = SubscriptionPlanFragment.this.getActivity();
            if (activity == null) {
                int i = 0;
            } else {
                showDeleteDialog = app.dogo.com.dogo_android.util.extensionfunction.f1.showDeleteDialog(activity);
            }
            SubscriptionPlanFragment.this.recoveringPurchaseDialog = showDeleteDialog;
        }
    }

    public 2(SubscriptionPlanFragment subscriptionPlanFragment) {
        super();
    }
}
