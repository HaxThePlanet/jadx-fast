@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
public static final class 1<T> implements androidx.lifecycle.y<T> {
    public final void onChanged(T t) {
        app.dogo.com.dogo_android.util.f0.n nVar;
        android.content.Context requireContext;
        String str;
        z = t instanceof LoadResult_Success;
        if (t instanceof oadResult_Success) {
            if ((Boolean)t.component1().booleanValue()) {
                androidx.fragment.app.e activity = SubscriptionPlanFragment.this.getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, 2131887148);
                }
            } else {
                activity = SubscriptionPlanFragment.this.getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, 2131887237);
                }
            }
        } else {
            z = t instanceof LoadResult_Error;
            if (t instanceof oadResult_Error) {
                a.d(t.component1());
                androidx.fragment.app.e activity2 = SubscriptionPlanFragment.this.getActivity();
                if (activity2 != null) {
                    requireContext = SubscriptionPlanFragment.this.requireContext();
                    str = "requireContext()";
                    n.e(requireContext, str);
                    app.dogo.com.dogo_android.util.extensionfunction.g1.i0(activity2, BindingAdapters.a.i(t.component1(), requireContext));
                }
                android.app.Dialog dialog = SubscriptionPlanFragment.this.recoveringPurchaseDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                activity = SubscriptionPlanFragment.this.getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.f1.v0(activity, new SubscriptionPlanFragment.onViewCreated.AnonymousClass5.AnonymousClass1(SubscriptionPlanFragment.this));
                }
            }
        }
    }

    public 1(SubscriptionPlanFragment subscriptionPlanFragment) {
        super();
    }
}
