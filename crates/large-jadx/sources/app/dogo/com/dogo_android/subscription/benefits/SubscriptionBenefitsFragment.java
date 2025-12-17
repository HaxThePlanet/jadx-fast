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
import app.dogo.com.dogo_android.q.p.y;
import app.dogo.com.dogo_android.q.r.c;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;
import app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo;
import app.dogo.com.dogo_android.subscription.SubscriptionViewModel;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.i1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.y.j;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J$\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0016J\u0008\u0010%\u001a\u00020\u0018H\u0016J\u0008\u0010&\u001a\u00020\u0018H\u0016J\u0008\u0010'\u001a\u00020\u0018H\u0016J\u001a\u0010(\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006)", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter$Callbacks;", "Lapp/dogo/com/dogo_android/subscription/benefits/UserTestimonialsCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentSubscriptionBenefitsBinding;", "recoveringPurchaseDialog", "Landroid/app/Dialog;", "screenKey", "Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsScreen;", "viewModel", "Lapp/dogo/com/dogo_android/subscription/SubscriptionViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/subscription/SubscriptionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isFullViewVisible", "", "view", "Landroid/view/View;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemSelect", "position", "", "onItemSwitched", "onPause", "onSelectedItemClick", "onViewCreated", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SubscriptionBenefitsFragment extends Fragment implements app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter.Callbacks, app.dogo.com.dogo_android.subscription.benefits.UserTestimonialsCallback {

    private sg binding;
    private Dialog recoveringPurchaseDialog;
    private final h viewModel$delegate;
    static {
    }

    public SubscriptionBenefitsFragment() {
        super();
        SubscriptionBenefitsFragment.viewModel.2 anon = new SubscriptionBenefitsFragment.viewModel.2(this);
        SubscriptionBenefitsFragment.special$$inlined.viewModel.default.1 anon2 = new SubscriptionBenefitsFragment.special$$inlined.viewModel.default.1(this, 0, anon);
        this.viewModel$delegate = j.a(m.SYNCHRONIZED, anon2);
    }

    public static void B1(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment, Boolean boolean2) {
        SubscriptionBenefitsFragment.onViewCreated$lambda-2(subscriptionBenefitsFragment, boolean2);
    }

    public static void C1(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment) {
        SubscriptionBenefitsFragment.onViewCreated$lambda-8(subscriptionBenefitsFragment);
    }

    public static void D1(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment, ZendeskConfigurationInfo zendeskConfigurationInfo2) {
        SubscriptionBenefitsFragment.onViewCreated$lambda-7(subscriptionBenefitsFragment, zendeskConfigurationInfo2);
    }

    public static void E1(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment, y y2) {
        SubscriptionBenefitsFragment.onViewCreated$lambda-6(subscriptionBenefitsFragment, y2);
    }

    public static void F1(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment, View view2) {
        SubscriptionBenefitsFragment.onViewCreated$lambda-1(subscriptionBenefitsFragment, view2);
    }

    public static void G1(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment, View view2) {
        SubscriptionBenefitsFragment.onViewCreated$lambda-0(subscriptionBenefitsFragment, view2);
    }

    public static void H1(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment, y y2) {
        SubscriptionBenefitsFragment.onViewCreated$lambda-5(subscriptionBenefitsFragment, y2);
    }

    public static void I1(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment, Boolean boolean2) {
        SubscriptionBenefitsFragment.onViewCreated$lambda-4(subscriptionBenefitsFragment, boolean2);
    }

    public static final app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsScreen access$getScreenKey(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment) {
        return subscriptionBenefitsFragment.getScreenKey();
    }

    public static final SubscriptionViewModel access$getViewModel(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment) {
        return subscriptionBenefitsFragment.getViewModel();
    }

    private final app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsScreen getScreenKey() {
        return (SubscriptionBenefitsScreen)k1.a(this);
    }

    private final SubscriptionViewModel getViewModel() {
        return (SubscriptionViewModel)this.viewModel$delegate.getValue();
    }

    private final boolean isFullViewVisible(View view) {
        Rect rect;
        int obj4;
        rect = new Rect();
        sg binding = this.binding;
        if (binding == null) {
        } else {
            binding.c0.getDrawingRect(rect);
            float f = view.getY();
            if (Float.compare(f2, f) < 0 && Float.compare(rect, obj4) > 0) {
                obj4 = Float.compare(rect, obj4) > 0 ? 1 : 0;
            } else {
            }
            return obj4;
        }
        n.w("binding");
        throw 0;
    }

    private static final void onViewCreated$lambda-0(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment, View view2) {
        n.f(subscriptionBenefitsFragment, "this$0");
        final androidx.fragment.app.e obj1 = subscriptionBenefitsFragment.requireActivity();
        n.e(obj1, "requireActivity()");
        subscriptionBenefitsFragment.getViewModel().makePurchase(obj1);
    }

    private static final void onViewCreated$lambda-1(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment, View view2) {
        n.f(subscriptionBenefitsFragment, "this$0");
        subscriptionBenefitsFragment.getViewModel().trackCloseIfNeeded();
        final androidx.fragment.app.e obj0 = subscriptionBenefitsFragment.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void onViewCreated$lambda-2(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment, Boolean boolean2) {
        n.f(subscriptionBenefitsFragment, "this$0");
        final androidx.fragment.app.e obj1 = subscriptionBenefitsFragment.requireActivity();
        n.e(obj1, "requireActivity()");
        subscriptionBenefitsFragment.getViewModel().makePurchase(obj1);
    }

    private static final void onViewCreated$lambda-4(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment, Boolean boolean2) {
        ProfilePreview initiatedByDogParentFlow;
        int activity;
        int str;
        ProfilePreview profilePreview;
        int i4;
        int i7;
        int i2;
        int i5;
        int i3;
        int i8;
        int i6;
        int i;
        androidx.fragment.app.e obj13;
        boolean obj14;
        n.f(subscriptionBenefitsFragment, "this$0");
        initiatedByDogParentFlow = subscriptionBenefitsFragment.getScreenKey().getProfilePreview();
        if (initiatedByDogParentFlow == null) {
            profilePreview = obj14;
        } else {
            profilePreview = initiatedByDogParentFlow;
        }
        if (profilePreview != null && subscriptionBenefitsFragment.getScreenKey().getInitiatedByDogParentFlow()) {
            if (subscriptionBenefitsFragment.getScreenKey().getInitiatedByDogParentFlow()) {
                activity = "requireActivity()";
                if (!subscriptionBenefitsFragment.getViewModel().isUserSignedIn()) {
                    androidx.fragment.app.e requireActivity = subscriptionBenefitsFragment.requireActivity();
                    n.e(requireActivity, activity);
                    requireActivity.onBackPressed();
                    initiatedByDogParentFlow = subscriptionBenefitsFragment.getActivity();
                    if (initiatedByDogParentFlow == null) {
                    } else {
                        activity = subscriptionBenefitsFragment.getActivity();
                        if (activity == null) {
                        } else {
                            obj14 = i1.f(activity, "dog_profile", profilePreview, 0, 4, 0);
                        }
                        initiatedByDogParentFlow.startActivityForResult(obj14, 134679);
                    }
                } else {
                    if (!subscriptionBenefitsFragment.getViewModel().isUserNameSet()) {
                        obj14 = subscriptionBenefitsFragment.requireActivity();
                        n.e(obj14, activity);
                        obj14.onBackPressed();
                        obj13 = subscriptionBenefitsFragment.getActivity();
                        if (obj13 == null) {
                        } else {
                            obj14 = new c(profilePreview);
                            g1.n(obj13, obj14);
                        }
                    } else {
                        initiatedByDogParentFlow = 1;
                        if (profilePreview.getFullScreen() != null) {
                            obj14 = new y(initiatedByDogParentFlow, profilePreview);
                        } else {
                            super(1, profilePreview, 0, 4, 0);
                        }
                        obj13 = subscriptionBenefitsFragment.getActivity();
                        if (obj13 == null) {
                        } else {
                            g1.e(obj13, obj14.getTag(), obj14, initiatedByDogParentFlow);
                        }
                    }
                }
            } else {
                if (!subscriptionBenefitsFragment.getViewModel().isUserSignedIn() && subscriptionBenefitsFragment.getViewModel().getPurchaseWasMade()) {
                    if (subscriptionBenefitsFragment.getViewModel().getPurchaseWasMade()) {
                        initiatedByDogParentFlow = subscriptionBenefitsFragment.getActivity();
                        if (initiatedByDogParentFlow == null) {
                        } else {
                            g1.H(initiatedByDogParentFlow, 0, "purchase_completed", 0, 5, 0);
                        }
                        obj13 = subscriptionBenefitsFragment.getActivity();
                        if (obj13 == null) {
                        } else {
                            obj13.onBackPressed();
                        }
                    } else {
                        if (obj14 instanceof y.a) {
                            obj14 = subscriptionBenefitsFragment.getActivity();
                            if (obj14 == null) {
                            } else {
                                g1.g0(obj14, 2131886123);
                            }
                            obj13 = subscriptionBenefitsFragment.getActivity();
                            if (obj13 == null) {
                            } else {
                                obj13.onBackPressed();
                            }
                        } else {
                            obj13 = subscriptionBenefitsFragment.getActivity();
                            if (obj13 == null) {
                            } else {
                                obj13.onBackPressed();
                                f1.I(obj13);
                            }
                        }
                    }
                } else {
                }
            }
        } else {
        }
    }

    private static final void onViewCreated$lambda-5(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment, y y2) {
        boolean activity;
        n nVar;
        Context requireContext;
        String str;
        Object obj4;
        boolean obj5;
        n.f(subscriptionBenefitsFragment, "this$0");
        if (y2 instanceof y.c) {
            if ((Boolean)(y.c)y2.a().booleanValue()) {
                obj4 = subscriptionBenefitsFragment.getActivity();
                if (obj4 == null) {
                } else {
                    g1.g0(obj4, 2131887148);
                }
            } else {
                obj4 = subscriptionBenefitsFragment.getActivity();
                if (obj4 == null) {
                } else {
                    g1.g0(obj4, 2131887237);
                }
            }
        } else {
            if (y2 instanceof y.a) {
                a.d((y.a)y2.a());
                activity = subscriptionBenefitsFragment.getActivity();
                if (activity == null) {
                } else {
                    requireContext = subscriptionBenefitsFragment.requireContext();
                    n.e(requireContext, "requireContext()");
                    g1.i0(activity, n.a.i(y2.a(), requireContext));
                }
                obj5 = subscriptionBenefitsFragment.recoveringPurchaseDialog;
                if (obj5 == null) {
                } else {
                    obj5.dismiss();
                }
                obj5 = subscriptionBenefitsFragment.getActivity();
                if (obj5 == null) {
                } else {
                    activity = new SubscriptionBenefitsFragment.onViewCreated.5.1(subscriptionBenefitsFragment);
                    f1.v0(obj5, activity);
                }
            }
        }
    }

    private static final void onViewCreated$lambda-6(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment, y y2) {
        Dialog obj2;
        n.f(subscriptionBenefitsFragment, "this$0");
        if (y2 instanceof y.a) {
            obj2 = subscriptionBenefitsFragment.getActivity();
            if (obj2 == null) {
                obj2 = 0;
            } else {
                obj2 = f1.x0(obj2);
            }
            subscriptionBenefitsFragment.recoveringPurchaseDialog = obj2;
        }
    }

    private static final void onViewCreated$lambda-7(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment, ZendeskConfigurationInfo zendeskConfigurationInfo2) {
        n.f(subscriptionBenefitsFragment, "this$0");
        final androidx.fragment.app.e obj1 = subscriptionBenefitsFragment.requireActivity();
        n.e(obj1, "requireActivity()");
        n.e(zendeskConfigurationInfo2, "it");
        g1.o0(obj1, zendeskConfigurationInfo2);
    }

    private static final void onViewCreated$lambda-8(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment) {
        boolean allPlansTracked;
        boolean userTestimonialsTracked;
        int str2;
        String str;
        Object obj4;
        n.f(subscriptionBenefitsFragment, "this$0");
        str2 = 0;
        final String str4 = "binding";
        if (!subscriptionBenefitsFragment.getViewModel().getAllPlansTracked()) {
            sg binding2 = subscriptionBenefitsFragment.binding;
            if (binding2 == null) {
            } else {
                androidx.recyclerview.widget.RecyclerView view2 = binding2.a0;
                n.e(view2, "binding.offeringList");
                if (subscriptionBenefitsFragment.isFullViewVisible(view2)) {
                    subscriptionBenefitsFragment.getViewModel().trackAllPlansShowedOnce();
                }
            }
            n.w(str4);
            throw str2;
        }
        if (!subscriptionBenefitsFragment.getViewModel().getUserTestimonialsTracked()) {
            sg binding = subscriptionBenefitsFragment.binding;
            if (binding == null) {
            } else {
                androidx.viewpager2.widget.ViewPager2 view = binding.V;
                n.e(view, "binding.experienceViewPager");
                if (subscriptionBenefitsFragment.isFullViewVisible(view)) {
                    subscriptionBenefitsFragment.getViewModel().trackTestimonialsShowedOnce();
                }
            }
            n.w(str4);
            throw str2;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        androidx.fragment.app.e activity;
        n.f(context, "context");
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.F();
        }
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        sg obj2 = sg.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.binding = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.M(getViewLifecycleOwner());
            obj2 = this.binding;
            if (obj2 == null) {
            } else {
                obj2.X(getViewModel());
                obj2 = this.binding;
                if (obj2 == null) {
                } else {
                    obj2.V(this);
                    obj2 = this.binding;
                    if (obj2 == null) {
                    } else {
                        obj2.W(this);
                        obj2 = this.binding;
                        if (obj2 == null) {
                        } else {
                            obj2 = obj2.w();
                            n.e(obj2, "binding.root");
                            return obj2;
                        }
                        n.w(obj4);
                        throw obj3;
                    }
                    n.w(obj4);
                    throw obj3;
                }
                n.w(obj4);
                throw obj3;
            }
            n.w(obj4);
            throw obj3;
        }
        n.w(obj4);
        throw obj3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onItemSelect(int i) {
        getViewModel().onSkuSelected(i);
    }

    @Override // androidx.fragment.app.Fragment
    public void onItemSwitched() {
        getViewModel().trackTestimonialsSwitchedOnce();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.recoveringPurchaseDialog = 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSelectedItemClick() {
        final androidx.fragment.app.e requireActivity = requireActivity();
        n.e(requireActivity, "requireActivity()");
        getViewModel().makePurchase(requireActivity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        sg obj5 = this.binding;
        int obj6 = 0;
        String str2 = "binding";
        if (obj5 == null) {
        } else {
            f fVar = new f(this);
            obj5.X.setOnClickListener(fVar);
            obj5 = this.binding;
            if (obj5 == null) {
            } else {
                e eVar = new e(this);
                obj5.Q.setOnClickListener(eVar);
                androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
                String str3 = "viewLifecycleOwner";
                n.e(viewLifecycleOwner, str3);
                a aVar = new a(this);
                getViewModel().getClickedOnSelectedBestValueCard().observe(viewLifecycleOwner, aVar);
                androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
                n.e(viewLifecycleOwner2, str3);
                h hVar = new h(this);
                getViewModel().getShouldGoBack().observe(viewLifecycleOwner2, hVar);
                androidx.lifecycle.q viewLifecycleOwner3 = getViewLifecycleOwner();
                n.e(viewLifecycleOwner3, str3);
                g gVar = new g(this);
                getViewModel().isPurchaseRestored().observe(viewLifecycleOwner3, gVar);
                androidx.lifecycle.q viewLifecycleOwner4 = getViewLifecycleOwner();
                n.e(viewLifecycleOwner4, str3);
                d dVar = new d(this);
                getViewModel().getShowInfoDialog().observe(viewLifecycleOwner4, dVar);
                androidx.fragment.app.e requireActivity = requireActivity();
                n.e(requireActivity, "requireActivity()");
                c cVar = new c(this);
                getViewModel().getOnZendeskOpen().observe(requireActivity, cVar);
                getViewModel().loadOffers(getScreenKey().getPreloadedOffer());
                obj5 = this.binding;
                if (obj5 == null) {
                } else {
                    obj6 = new b(this);
                    obj5.c0.getViewTreeObserver().addOnScrollChangedListener(obj6);
                }
                n.w(str2);
                throw obj6;
            }
            n.w(str2);
            throw obj6;
        }
        n.w(str2);
        throw obj6;
    }
}
