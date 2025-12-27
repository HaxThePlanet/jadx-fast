package app.dogo.com.dogo_android.subscription.benefits;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.activity.ComponentActivity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import app.dogo.com.dogo_android.h.sg;
import app.dogo.com.dogo_android.q.p.f0;
import app.dogo.com.dogo_android.q.r.c;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;
import app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo;
import app.dogo.com.dogo_android.subscription.SubscriptionViewModel;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.i1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.h;
import kotlin.m;

/* compiled from: SubscriptionBenefitsFragment.kt */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J$\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0016J\u0008\u0010%\u001a\u00020\u0018H\u0016J\u0008\u0010&\u001a\u00020\u0018H\u0016J\u0008\u0010'\u001a\u00020\u0018H\u0016J\u001a\u0010(\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006)", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter$Callbacks;", "Lapp/dogo/com/dogo_android/subscription/benefits/UserTestimonialsCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentSubscriptionBenefitsBinding;", "recoveringPurchaseDialog", "Landroid/app/Dialog;", "screenKey", "Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsScreen;", "viewModel", "Lapp/dogo/com/dogo_android/subscription/SubscriptionViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/subscription/SubscriptionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isFullViewVisible", "", "view", "Landroid/view/View;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemSelect", "position", "", "onItemSwitched", "onPause", "onSelectedItemClick", "onViewCreated", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SubscriptionBenefitsFragment extends Fragment implements SubscriptionBenefitsOfferAdapter.Callbacks, UserTestimonialsCallback {

    private sg binding;
    private Dialog recoveringPurchaseDialog;
    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final h viewModel;
    public SubscriptionBenefitsFragment() {
        super();
        this.viewModel = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new SubscriptionBenefitsFragment.special$$inlined.viewModel.default.AnonymousClass1(this, null, new SubscriptionBenefitsFragment.viewModel.AnonymousClass2(this)));
    }

    public static final /* synthetic */ SubscriptionBenefitsScreen access$getScreenKey(SubscriptionBenefitsFragment subscriptionBenefitsFragment) {
        return subscriptionBenefitsFragment.getScreenKey();
    }

    public static final /* synthetic */ SubscriptionViewModel access$getViewModel(SubscriptionBenefitsFragment subscriptionBenefitsFragment) {
        return subscriptionBenefitsFragment.getViewModel();
    }

    private final SubscriptionBenefitsScreen getScreenKey() {
        return (SubscriptionBenefitsScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final SubscriptionViewModel getViewModel() {
        return (SubscriptionViewModel)this.viewModel.getValue();
    }

    private final boolean isFullViewVisible(View view) {
        Rect rect;
        boolean z = false;
        rect = new Rect();
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            binding2.c0.getDrawingRect(rect);
            float f3 = view.getY();
            f = (float)view.getHeight() + f3;
            float f4 = (float)rect.top;
            if (rect.top < f3) {
                float f2 = (float)rect.bottom;
                view = rect.bottom > f ? 1 : 0;
            }
            return (rect.bottom > f ? 1 : 0);
        }
    }

    private static final void onViewCreated$lambda_0(SubscriptionBenefitsFragment subscriptionBenefitsFragment, View view) {
        n.f(subscriptionBenefitsFragment, "this$0");
        final androidx.fragment.app.e requireActivity = subscriptionBenefitsFragment.requireActivity();
        n.e(requireActivity, "requireActivity()");
        subscriptionBenefitsFragment.getViewModel().makePurchase(requireActivity);
    }

    private static final void onViewCreated$lambda_1(SubscriptionBenefitsFragment subscriptionBenefitsFragment, View view) {
        n.f(subscriptionBenefitsFragment, "this$0");
        subscriptionBenefitsFragment.getViewModel().trackCloseIfNeeded();
        final androidx.fragment.app.e activity = subscriptionBenefitsFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void onViewCreated$lambda_2(SubscriptionBenefitsFragment subscriptionBenefitsFragment, Boolean boolean) {
        n.f(subscriptionBenefitsFragment, "this$0");
        final androidx.fragment.app.e requireActivity = subscriptionBenefitsFragment.requireActivity();
        n.e(requireActivity, "requireActivity()");
        subscriptionBenefitsFragment.getViewModel().makePurchase(requireActivity);
    }

    private static final void onViewCreated$lambda_4(SubscriptionBenefitsFragment subscriptionBenefitsFragment, Boolean boolean) {
        ProfilePreview profilePreview;
        int i = 2131886123;
        ProfilePreview profilePreview2 = null;
        f0 boolean22;
        app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile;
        boolean z = true;
        boolean z2 = false;
        app.dogo.com.dogo_android.y.j jVar = null;
        boolean z3 = false;
        int i2 = 4;
        boolean z4 = false;
        kotlin.d0.d.g gVar = null;
        android.content.Intent intent = null;
        n.f(subscriptionBenefitsFragment, "this$0");
        profilePreview = subscriptionBenefitsFragment.getScreenKey().getProfilePreview();
        if (profilePreview == null) {
        } else {
            profilePreview2 = null;
            dogProfile = 1;
            z2 = false;
            z3 = false;
            z4 = false;
            boolean z5 = false;
            int i3 = 0;
            int i4 = 0;
            int i5 = 509;
            Object obj = null;
        }
        if (profilePreview != null) {
            if (subscriptionBenefitsFragment.getScreenKey().getInitiatedByDogParentFlow()) {
                String str = "requireActivity()";
                if (!subscriptionBenefitsFragment.getViewModel().isUserSignedIn()) {
                    androidx.fragment.app.e requireActivity2 = subscriptionBenefitsFragment.requireActivity();
                    n.e(requireActivity2, str);
                    requireActivity2.onBackPressed();
                    androidx.fragment.app.e activity3 = subscriptionBenefitsFragment.getActivity();
                    if (activity3 != null) {
                        androidx.fragment.app.e activity4 = subscriptionBenefitsFragment.getActivity();
                        if (activity4 != null) {
                            intent = app.dogo.com.dogo_android.util.extensionfunction.i1.f(activity4, "dog_profile", profilePreview, null, 4, null);
                        }
                        activity3.startActivityForResult(intent, 134679);
                    }
                } else {
                    if (subscriptionBenefitsFragment.getViewModel().isUserNameSet()) {
                        boolean z6 = true;
                        if (profilePreview.getFullScreen() != null) {
                            app.dogo.com.dogo_android.q.p.y dogPreviewFullscreenScreen = new DogPreviewFullscreenScreen(z6, profilePreview);
                        } else {
                            z = true;
                            jVar = null;
                            i2 = 4;
                            gVar = null;
                            boolean22 = new DogPreviewScreen(z, profilePreview, jVar, i2, gVar);
                        }
                        androidx.fragment.app.e activity = subscriptionBenefitsFragment.getActivity();
                        if (activity != null) {
                            app.dogo.com.dogo_android.util.extensionfunction.g1.e(activity, boolean22.getTag(), boolean22, z6);
                        }
                    } else {
                        androidx.fragment.app.e requireActivity = subscriptionBenefitsFragment.requireActivity();
                        n.e(requireActivity, str);
                        requireActivity.onBackPressed();
                        activity = subscriptionBenefitsFragment.getActivity();
                        if (activity != null) {
                            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new UserInformationScreen(profilePreview));
                        }
                    }
                }
            } else {
                if (!subscriptionBenefitsFragment.getViewModel().isUserSignedIn()) {
                    if (subscriptionBenefitsFragment.getViewModel().getPurchaseWasMade()) {
                        androidx.fragment.app.e activity2 = subscriptionBenefitsFragment.getActivity();
                        if (activity2 != null) {
                            app.dogo.com.dogo_android.util.extensionfunction.g1.H(activity2, 0, "purchase_completed", null, 5, null);
                        }
                        activity = subscriptionBenefitsFragment.getActivity();
                        if (activity != null) {
                            activity.onBackPressed();
                        }
                    } else {
                        if (subscriptionBenefitsFragment.getViewModel().getResult().getValue() instanceof LoadResult_Error) {
                            requireActivity = subscriptionBenefitsFragment.getActivity();
                            if (requireActivity != null) {
                                i = 2131886123;
                                app.dogo.com.dogo_android.util.extensionfunction.g1.g0(requireActivity, i);
                            }
                            activity = subscriptionBenefitsFragment.getActivity();
                            if (activity != null) {
                                activity.onBackPressed();
                            }
                        } else {
                            activity = subscriptionBenefitsFragment.getActivity();
                            if (activity != null) {
                                activity.onBackPressed();
                                app.dogo.com.dogo_android.util.extensionfunction.f1.showCloseDogInviteDialog(activity);
                            }
                        }
                    }
                }
            }
        }
    }

    private static final void onViewCreated$lambda_5(SubscriptionBenefitsFragment subscriptionBenefitsFragment, app.dogo.com.dogo_android.util.e0.y yVar) {
        app.dogo.com.dogo_android.util.f0.n nVar;
        Context requireContext;
        String str;
        n.f(subscriptionBenefitsFragment, "this$0");
        z = yVar instanceof LoadResult_Success;
        if (yVar instanceof oadResult_Success) {
            if ((Boolean)yVar.component1().booleanValue()) {
                androidx.fragment.app.e activity = subscriptionBenefitsFragment.getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, 2131887148);
                }
            } else {
                activity = subscriptionBenefitsFragment.getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, 2131887237);
                }
            }
        } else {
            z = yVar instanceof LoadResult_Error;
            if (yVar instanceof oadResult_Error) {
                a.d(yVar.component1());
                androidx.fragment.app.e activity2 = subscriptionBenefitsFragment.getActivity();
                if (activity2 != null) {
                    requireContext = subscriptionBenefitsFragment.requireContext();
                    str = "requireContext()";
                    n.e(requireContext, str);
                    app.dogo.com.dogo_android.util.extensionfunction.g1.i0(activity2, BindingAdapters.a.i(yVar.component1(), requireContext));
                }
                if (subscriptionBenefitsFragment.recoveringPurchaseDialog != null) {
                    subscriptionBenefitsFragment.recoveringPurchaseDialog.dismiss();
                }
                androidx.fragment.app.e activity3 = subscriptionBenefitsFragment.getActivity();
                if (activity3 != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.f1.v0(activity3, new SubscriptionBenefitsFragment.onViewCreated.AnonymousClass5.AnonymousClass1(subscriptionBenefitsFragment));
                }
            }
        }
    }

    private static final void onViewCreated$lambda_6(SubscriptionBenefitsFragment subscriptionBenefitsFragment, app.dogo.com.dogo_android.util.e0.y yVar) {
        Dialog showDeleteDialog = null;
        n.f(subscriptionBenefitsFragment, "this$0");
        z = yVar instanceof LoadResult_Error;
        if (yVar instanceof oadResult_Error && activity == null) {
            int i = 0;
            subscriptionBenefitsFragment.recoveringPurchaseDialog = showDeleteDialog;
        }
    }

    private static final void onViewCreated$lambda_7(SubscriptionBenefitsFragment subscriptionBenefitsFragment, ZendeskConfigurationInfo zendeskConfigurationInfo) {
        n.f(subscriptionBenefitsFragment, "this$0");
        final androidx.fragment.app.e requireActivity = subscriptionBenefitsFragment.requireActivity();
        n.e(requireActivity, "requireActivity()");
        n.e(zendeskConfigurationInfo, "it");
        app.dogo.com.dogo_android.util.extensionfunction.g1.o0(requireActivity, zendeskConfigurationInfo);
    }

    private static final void onViewCreated$lambda_8(SubscriptionBenefitsFragment subscriptionBenefitsFragment) {
        n.f(subscriptionBenefitsFragment, "this$0");
        int i = 0;
        final String str4 = "binding";
        if (!subscriptionBenefitsFragment.getViewModel().getAllPlansTracked()) {
            if (subscriptionBenefitsFragment.binding == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                str = "binding.offeringList";
                n.e(binding22.a0, str);
                if (subscriptionBenefitsFragment.isFullViewVisible(binding22.a0)) {
                    subscriptionBenefitsFragment.getViewModel().trackAllPlansShowedOnce();
                }
            }
        }
        if (!subscriptionBenefitsFragment.getViewModel().getUserTestimonialsTracked() && subscriptionBenefitsFragment.binding != null) {
            n.e(binding2.V, "binding.experienceViewPager");
            if (subscriptionBenefitsFragment.isFullViewVisible(binding2.V)) {
                subscriptionBenefitsFragment.getViewModel().trackTestimonialsShowedOnce();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        androidx.fragment.app.e activity = null;
        n.f(context, "context");
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            activity.F();
        }
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        sg sgVar = sg.T(inflater, container, false);
        n.e(sgVar, "inflate(inflater, container, false)");
        this.binding = sgVar;
        int i = 0;
        String str4 = "binding";
        if (sgVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            sgVar.M(getViewLifecycleOwner());
            if (this.binding == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.X(getViewModel());
                if (this.binding == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.binding.V(this);
                    if (this.binding == null) {
                        n.w(str4);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        this.binding.W(this);
                        if (this.binding == null) {
                            n.w(str4);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i;
                        } else {
                            View view = this.binding.w();
                            n.e(view, "binding.root");
                            return view;
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onItemSelect(int position) {
        getViewModel().onSkuSelected(position);
    }

    @Override // androidx.fragment.app.Fragment
    public void onItemSwitched() {
        getViewModel().trackTestimonialsSwitchedOnce();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.recoveringPurchaseDialog = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSelectedItemClick() {
        final androidx.fragment.app.e requireActivity = requireActivity();
        n.e(requireActivity, "requireActivity()");
        getViewModel().makePurchase(requireActivity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) throws b {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        int i = 0;
        String str2 = "binding";
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            binding2.X.setOnClickListener(new f(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.Q.setOnClickListener(new e(this));
                androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
                String str3 = "viewLifecycleOwner";
                n.e(viewLifecycleOwner, str3);
                getViewModel().getClickedOnSelectedBestValueCard().observe(viewLifecycleOwner, new a(this));
                androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
                n.e(viewLifecycleOwner2, str3);
                getViewModel().getShouldGoBack().observe(viewLifecycleOwner2, new h(this));
                androidx.lifecycle.q viewLifecycleOwner3 = getViewLifecycleOwner();
                n.e(viewLifecycleOwner3, str3);
                getViewModel().isPurchaseRestored().observe(viewLifecycleOwner3, new g(this));
                androidx.lifecycle.q viewLifecycleOwner4 = getViewLifecycleOwner();
                n.e(viewLifecycleOwner4, str3);
                getViewModel().getShowInfoDialog().observe(viewLifecycleOwner4, new d(this));
                androidx.fragment.app.e requireActivity = requireActivity();
                n.e(requireActivity, "requireActivity()");
                getViewModel().getOnZendeskOpen().observe(requireActivity, new c(this));
                getViewModel().loadOffers(getScreenKey().getPreloadedOffer());
                if (this.binding == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    binding23.c0.getViewTreeObserver().addOnScrollChangedListener(new b(this));
                    return;
                }
            }
        }
    }


    /* renamed from: B1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(SubscriptionBenefitsFragment view, Boolean savedInstanceState) {
        SubscriptionBenefitsFragment.onViewCreated$lambda_2(view, savedInstanceState);
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public static /* synthetic */ void isFullViewVisible(SubscriptionBenefitsFragment view) {
        SubscriptionBenefitsFragment.onViewCreated$lambda_8(view);
    }

    public static /* synthetic */ void D1(SubscriptionBenefitsFragment subscriptionBenefitsFragment, ZendeskConfigurationInfo zendeskConfigurationInfo) {
        SubscriptionBenefitsFragment.onViewCreated$lambda_7(subscriptionBenefitsFragment, zendeskConfigurationInfo);
    }

    public static /* synthetic */ void E1(SubscriptionBenefitsFragment subscriptionBenefitsFragment, app.dogo.com.dogo_android.util.e0.y yVar) {
        SubscriptionBenefitsFragment.onViewCreated$lambda_6(subscriptionBenefitsFragment, yVar);
    }

    public static /* synthetic */ void F1(SubscriptionBenefitsFragment subscriptionBenefitsFragment, View view) {
        SubscriptionBenefitsFragment.onViewCreated$lambda_1(subscriptionBenefitsFragment, view);
    }

    public static /* synthetic */ void G1(SubscriptionBenefitsFragment subscriptionBenefitsFragment, View view) {
        SubscriptionBenefitsFragment.onViewCreated$lambda_0(subscriptionBenefitsFragment, view);
    }

    public static /* synthetic */ void H1(SubscriptionBenefitsFragment subscriptionBenefitsFragment, app.dogo.com.dogo_android.util.e0.y yVar) {
        SubscriptionBenefitsFragment.onViewCreated$lambda_5(subscriptionBenefitsFragment, yVar);
    }

    public static /* synthetic */ void I1(SubscriptionBenefitsFragment subscriptionBenefitsFragment, Boolean boolean) {
        SubscriptionBenefitsFragment.onViewCreated$lambda_4(subscriptionBenefitsFragment, boolean);
    }

    @Override // androidx.fragment.app.Fragment
    public void _$_clearFindViewByIdCache() {
    }
}
