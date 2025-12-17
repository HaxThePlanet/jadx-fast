package app.dogo.com.dogo_android.subscription;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.a;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.h.ak;
import app.dogo.com.dogo_android.h.ck;
import app.dogo.com.dogo_android.h.ei;
import app.dogo.com.dogo_android.h.kk;
import app.dogo.com.dogo_android.h.mk;
import app.dogo.com.dogo_android.h.oj;
import app.dogo.com.dogo_android.h.ui;
import app.dogo.com.dogo_android.k.n;
import app.dogo.com.dogo_android.k.r;
import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import app.dogo.com.dogo_android.repository.domain.CouponDiscount.Companion;
import app.dogo.com.dogo_android.repository.domain.CouponTimer;
import app.dogo.com.dogo_android.repository.domain.CustomerExperience;
import app.dogo.com.dogo_android.repository.domain.Dashboard;
import app.dogo.com.dogo_android.repository.domain.SubscriptionOffer;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.service.v2.a;
import app.dogo.com.dogo_android.service.v2.b;
import app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter;
import app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter.Callbacks;
import app.dogo.com.dogo_android.subscription.benefits.SubscriptionTestimonialsAdapter;
import app.dogo.com.dogo_android.subscription.benefits.UserTestimonialsCallback;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.n0.y;
import com.android.billingclient.api.SkuDetails;
import com.revenuecat.purchases.PackageType;
import d.h.l.u;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import kotlin.e0.a;
import kotlin.k0.l;
import kotlin.o;
import n.a.a;
import net.time4j.g1.v;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000cH\u0002J0\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000cH\u0002J0\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000cH\u0002J0\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000cH\u0002J(\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000cH\u0002J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J \u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\u001bH\u0002J\u0014\u0010\u001c\u001a\u00020\u000c*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002JI\u0010 \u001a\u00020\u0004*\u00020!2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#2\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0008\u0010'\u001a\u0004\u0018\u00010(2\u0008\u0010)\u001a\u0004\u0018\u00010\n2\u0008\u0010*\u001a\u0004\u0018\u00010+H\u0007¢\u0006\u0002\u0010,J$\u0010-\u001a\u00020\u0004*\u00020.2\u000c\u0010/\u001a\u0008\u0012\u0004\u0012\u0002000#2\u0008\u00101\u001a\u0004\u0018\u000102H\u0007J$\u00103\u001a\u00020\u0004*\u00020\u001d2\u000e\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\u0006\u00107\u001a\u00020\u001dH\u0007J\u0016\u00108\u001a\u00020\u0004*\u00020\u001d2\u0008\u00109\u001a\u0004\u0018\u00010:H\u0007J\u0016\u0010;\u001a\u00020\u0004*\u00020\u001d2\u0008\u0010<\u001a\u0004\u0018\u00010$H\u0007J\u001e\u0010=\u001a\u00020\u0004*\u00020\u001d2\u0008\u0010<\u001a\u0004\u0018\u00010$2\u0006\u0010>\u001a\u00020+H\u0007J$\u0010?\u001a\u00020\u0004*\u00020\u001d2\u000e\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\u0006\u0010@\u001a\u00020\nH\u0007J4\u0010A\u001a\u00020\u0004*\u00020B2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020EH\u0007J%\u0010H\u001a\u00020\u0004*\u00020\u001d2\u0008\u0010<\u001a\u0004\u0018\u00010$2\u0008\u0010I\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0002\u0010JJ\u001c\u0010K\u001a\u00020\u0004*\u00020\u001d2\u000e\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u000105H\u0007JP\u0010L\u001a\u00020\u0004*\u00020M2\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0010N\u001a\u0004\u0018\u00010O2\u0008\u00101\u001a\u0004\u0018\u00010P2\u0006\u0010Q\u001a\u00020\n2\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020R\u0018\u0001052\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0007J\u001e\u0010L\u001a\u00020\u0004*\u00020M2\u0008\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010\u0005\u001a\u00020WH\u0007J+\u0010X\u001a\u00020\u0004*\u00020M2\u0008\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010[\u001a\u00020\u001d2\u0006\u0010\\\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010]J\u001e\u0010^\u001a\u00020\u0004*\u00020M2\u0008\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010\u0005\u001a\u00020_H\u0007J\u001e\u0010`\u001a\u00020\u0004*\u00020\u001d2\u0008\u0010<\u001a\u0004\u0018\u00010$2\u0006\u0010I\u001a\u00020\nH\u0007¨\u0006a", d2 = {"Lapp/dogo/com/dogo_android/subscription/SubscriptionBindingAdapters;", "", "()V", "setBlackStyleAndText", "", "timerBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutDashboardDiscountCounterBinding;", "resources", "Landroid/content/res/Resources;", "shouldShowSpecialOffer", "", "discountText", "", "specialOfferDiscountText", "setPinkStyleAndText", "setRedStyleAndText", "setSpecialBannerStyleAndText", "setupDashboardDiscountTimer", "dashboardCouponTimer", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "userLanguage", "setupDashboardDiscountTimerSegment", "timerStyle", "Lapp/dogo/com/dogo_android/enums/TimerSegmentStyle;", "segmentBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutDashboardTimerSquareSegmentBinding;", "setupSubscriptionDiscountTimerSegment", "Lapp/dogo/com/dogo_android/databinding/LayoutDiscountTimerSquareSegmentBinding;", "getReadableTimePeriod", "Landroid/widget/TextView;", "skuDetails", "Lcom/android/billingclient/api/SkuDetails;", "setBenefitListAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "skuList", "", "Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;", "benefitCallback", "Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter$Callbacks;", "selected", "", "freeTrailEligible", "pricePerPeriod", "Lapp/dogo/com/dogo_android/enums/PricePerPeriodType;", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter$Callbacks;Ljava/lang/Integer;Ljava/lang/Boolean;Lapp/dogo/com/dogo_android/enums/PricePerPeriodType;)V", "setCustomerExperienceList", "Landroidx/viewpager2/widget/ViewPager2;", "list", "Lapp/dogo/com/dogo_android/repository/domain/CustomerExperience;", "callback", "Lapp/dogo/com/dogo_android/subscription/benefits/UserTestimonialsCallback;", "setDiscountText", "result", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "titleText", "setDiscountTimerLabel", "timeUnit", "Lapp/dogo/com/dogo_android/service/Utilities$TimeUnit;", "setOldStrikedPrice", "subscription", "setPerPeriod", "pricePerPeriodType", "setSubscriptionBenefitPlanTitle", "freeTrialAvailable", "setSubscriptionImage", "Landroid/widget/ImageView;", "couponDiscount", "statusBarLayout", "Landroid/widget/FrameLayout;", "onlyNowText", "loadingLayout", "setSubscriptionPlanButton", "isFreeTrailAvailable", "(Landroid/widget/TextView;Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;Ljava/lang/Boolean;)V", "setSubscriptionPlanTitleText", "setupTimerDashboard", "Landroid/view/View;", "couponTimer", "Lapp/dogo/com/dogo_android/repository/domain/CouponTimer;", "Lapp/dogo/com/dogo_android/dashboard/DashboardCallback;", "discountVisible", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard;", "resubscribeBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutDashboardResubscribeBinding;", "currentDogBarBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutCurrentDogViewV2Binding;", "Lapp/dogo/com/dogo_android/databinding/LayoutDashboardTimerBinding;", "setupTimerSegment", "time", "", "rightSegment", "leftSegment", "(Landroid/view/View;Ljava/lang/Long;Landroid/widget/TextView;Landroid/widget/TextView;)V", "setupTimerSubscribe", "Lapp/dogo/com/dogo_android/databinding/LayoutDiscountTimerBinding;", "subscriptionPerPeriod", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SubscriptionBindingAdapters {

    public static final app.dogo.com.dogo_android.subscription.SubscriptionBindingAdapters INSTANCE;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        public static final int[] $EnumSwitchMapping$1;
        public static final int[] $EnumSwitchMapping$2;
        static {
            int[] iArr = new int[values.length];
            int i = 1;
            iArr[r.YELLOW.ordinal()] = i;
            final int i3 = 2;
            iArr[r.GRAY.ordinal()] = i3;
            SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[values2.length];
            iArr2[v2.b.SECONDS.ordinal()] = i;
            iArr2[v2.b.MINUTES.ordinal()] = i3;
            SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[values3.length];
            iArr3[n.DAY.ordinal()] = i;
            iArr3[n.WEEK.ordinal()] = i3;
            iArr3[n.MONTH.ordinal()] = 3;
            SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$2 = iArr3;
        }
    }
    static {
        SubscriptionBindingAdapters subscriptionBindingAdapters = new SubscriptionBindingAdapters();
        SubscriptionBindingAdapters.INSTANCE = subscriptionBindingAdapters;
    }

    public static void a(int i, int i2, View view3, float f4) {
        SubscriptionBindingAdapters.setCustomerExperienceList$lambda-2(i, i2, view3, f4);
    }

    public static void b(RecyclerView recyclerView) {
        SubscriptionBindingAdapters.setBenefitListAdapter$lambda-0(recyclerView);
    }

    public static void c(ei ei, View view2, View view3, int i4, int i5, int i6, int i7) {
        SubscriptionBindingAdapters.setupTimerDashboard$lambda-8(ei, view2, view3, i4, i5, i6, i7);
    }

    private final String getReadableTimePeriod(TextView textView, SkuDetails skuDetails2) {
        String str;
        String obj2;
        boolean obj3;
        switch (obj3) {
            case "P1M":
                n.e(textView.getResources().getString(2131887429), "resources.getString(R.string.subscription_price_per_month_dynamic_key)");
                obj2 = "";
                break;
            case "P1W":
                n.e(textView.getResources().getString(2131886721), "resources.getString(R.string.generic_duration_week)");
                obj2 = "";
                break;
            case "P1Y":
                n.e(textView.getResources().getString(2131886722), "resources.getString(R.string.generic_duration_year)");
                obj2 = "";
                break;
            case "P3M":
                n.e(textView.getResources().getString(2131886719), "resources.getString(R.string.generic_duration_quarter)");
                obj2 = "";
                break;
            case "P6M":
                n.e(textView.getResources().getString(2131886718), "resources.getString(R.string.generic_duration_half_year)");
                obj2 = "";
                break;
            default:
                obj2 = "";
        }
        return obj2;
    }

    public static final void setBenefitListAdapter(RecyclerView recyclerView, List<app.dogo.com.dogo_android.subscription.DogoSkuDetails> list2, SubscriptionBenefitsOfferAdapter.Callbacks subscriptionBenefitsOfferAdapter$Callbacks3, Integer integer4, Boolean boolean5, n n6) {
        RecyclerView.h subscriptionBenefitsOfferAdapter;
        Object obj2;
        Object obj3;
        SubscriptionBenefitsOfferAdapter.Callbacks obj4;
        int obj6;
        n.f(recyclerView, "<this>");
        if (subscriptionBenefitsOfferAdapter instanceof SubscriptionBenefitsOfferAdapter != null) {
        } else {
            subscriptionBenefitsOfferAdapter = 0;
        }
        if (list2 != null && callbacks3 != null && boolean5 != 0 && integer4 != null && n6 != null && subscriptionBenefitsOfferAdapter == null) {
            if (callbacks3 != null) {
                if (boolean5 != 0) {
                    if (integer4 != null) {
                        if (n6 != null) {
                            if (subscriptionBenefitsOfferAdapter == null) {
                                subscriptionBenefitsOfferAdapter = new SubscriptionBenefitsOfferAdapter(list2, boolean5.booleanValue(), n6, callbacks3);
                                recyclerView.setAdapter(subscriptionBenefitsOfferAdapter);
                                obj3 = new y((int)obj4);
                                recyclerView.h(obj3);
                                obj3 = new l(recyclerView);
                                recyclerView.postDelayed(obj3, 1000);
                            }
                        }
                    }
                }
            }
        }
        if (subscriptionBenefitsOfferAdapter != null && integer4 != null && integer4.intValue() != subscriptionBenefitsOfferAdapter.getCurrentSelectedValue()) {
            if (integer4 != null) {
                if (integer4.intValue() != subscriptionBenefitsOfferAdapter.getCurrentSelectedValue()) {
                    subscriptionBenefitsOfferAdapter.setCurrentSelectedValue(integer4.intValue());
                }
            }
        }
    }

    private static final void setBenefitListAdapter$lambda-0(RecyclerView recyclerView) {
        RecyclerView.h obj1;
        n.f(recyclerView, "$this_setBenefitListAdapter");
        obj1 = recyclerView.getAdapter();
        if (obj1 == null) {
        } else {
            obj1.notifyDataSetChanged();
        }
    }

    private final void setBlackStyleAndText(ui ui, Resources resources2, boolean z3, String string4, String string5) {
        ui.P.setBackgroundResource(2131231305);
        this.setSpecialBannerStyleAndText(resources2, ui, z3, string4, string5);
    }

    public static final void setCustomerExperienceList(ViewPager2 viewPager2, List<CustomerExperience> list2, UserTestimonialsCallback userTestimonialsCallback3) {
        RecyclerView.h dimensionPixelOffset;
        app.dogo.com.dogo_android.subscription.k kVar;
        Object obj3;
        n.f(viewPager2, "<this>");
        n.f(list2, "list");
        if (viewPager2.getAdapter() == null && userTestimonialsCallback3 != null) {
            if (userTestimonialsCallback3 != null) {
                SubscriptionTestimonialsAdapter subscriptionTestimonialsAdapter = new SubscriptionTestimonialsAdapter();
                subscriptionTestimonialsAdapter.setExperienceItemsList(list2);
                viewPager2.setAdapter(subscriptionTestimonialsAdapter);
                viewPager2.k(1073741825, false);
                viewPager2.setOffscreenPageLimit(3);
                int i2 = 2131165618;
                kVar = new k(viewPager2.getResources().getDimensionPixelOffset(i2), viewPager2.getResources().getDimensionPixelOffset(i2));
                viewPager2.setPageTransformer(kVar);
                obj3 = new SubscriptionBindingAdapters.setCustomerExperienceList.2(userTestimonialsCallback3);
                viewPager2.h(obj3);
            }
        }
    }

    private static final void setCustomerExperienceList$lambda-2(int i, int i2, View view3, float f4) {
        int obj2;
        int obj3;
        n.f(view3, "page");
        ViewParent parent2 = view3.getParent().getParent();
        Objects.requireNonNull(parent2, "null cannot be cast to non-null type androidx.viewpager2.widget.ViewPager2");
        f4 *= obj2;
        if ((ViewPager2)parent2.getOrientation() == 0) {
            if (u.B(parent2) == 1) {
                view3.setTranslationX(-obj5);
            } else {
                view3.setTranslationX(obj5);
            }
        } else {
            view3.setTranslationY(obj5);
        }
    }

    public static final void setDiscountText(TextView textView, y<SubscriptionOffer> y2, TextView textView3) {
        Object resources;
        int i;
        Object[] arr;
        Object obj4;
        int obj5;
        n.f(textView, "<this>");
        n.f(textView3, "titleText");
        if (y2 instanceof y.c) {
        } else {
            obj4 = 0;
        }
        obj5 = 0;
        if (obj4 == null) {
            obj4 = obj5;
        } else {
        }
        if (obj4 > 0) {
            arr = new Object[1];
            arr[obj5] = Integer.valueOf(obj4);
            obj4 = textView.getResources().getString(2131887405, arr);
        } else {
            obj4 = textView.getResources().getString(2131887347);
        }
        textView.setText(obj4);
    }

    public static final void setDiscountTimerLabel(TextView textView, v2.b v2$b2) {
        String str;
        v nARROW;
        v2.a companion;
        int i;
        int i3;
        String str3;
        String str2;
        String str4;
        int i4;
        int i2;
        int i5;
        int obj11;
        n.f(textView, "<this>");
        if (b2 != null) {
            textView.setVisibility(0);
            int i7 = SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$1[b2.ordinal()];
            if (i7 != 1 && i7 != 2) {
                nARROW = i7 != 2 ? v.NARROW : v.SHORT;
            } else {
            }
            obj11 = l.G(v2.Companion.c(0, obj3, b2), "0", "", false, 4, 0);
            Objects.requireNonNull(obj11, "null cannot be cast to non-null type kotlin.CharSequence");
            textView.setText(l.a1(obj11).toString());
        } else {
            textView.setVisibility(8);
        }
    }

    public static final void setOldStrikedPrice(TextView textView, app.dogo.com.dogo_android.subscription.DogoSkuDetails dogoSkuDetails2) {
        String strikethroughSpan;
        String sku;
        int i;
        SpannableString spannableString;
        int i4;
        String str;
        double string;
        int i5;
        int i2;
        int i6;
        int i3;
        int obj11;
        n.f(textView, "<this>");
        if (dogoSkuDetails2 == null) {
            sku = strikethroughSpan;
        } else {
        }
        i = j1.C(sku);
        if (dogoSkuDetails2 != null) {
            if (i == 0) {
                textView.setVisibility(8);
            } else {
                int i9 = 0;
                textView.setVisibility(i9);
                obj11 = dogoSkuDetails2.getOriginalJson();
                if (obj11 == null) {
                } else {
                    strikethroughSpan = obj11;
                }
                SkuDetails skuDetails = new SkuDetails(strikethroughSpan);
                obj11 = j1.x(skuDetails).format(d2 -= l2);
                Object[] arr = new Object[1];
                arr[i9] = obj11;
                String string2 = textView.getResources().getString(2131887469, arr);
                n.e(string2, "resources.getString(R.string.subscription_was_previous_price, originalPrice)");
                i = l.e0(string2, obj11.toString(), 0, false, 6, 0);
                spannableString = new SpannableString(string2);
                strikethroughSpan = new StrikethroughSpan();
                spannableString.setSpan(strikethroughSpan, i, obj11 += i, 33);
                textView.setText(spannableString);
            }
        } else {
        }
    }

    public static final void setPerPeriod(TextView textView, app.dogo.com.dogo_android.subscription.DogoSkuDetails dogoSkuDetails2, n n3) {
        String string;
        String originalJson;
        int i2;
        Resources resources;
        int i3;
        Object[] arr;
        int i;
        double d;
        PackageType obj10;
        n.f(textView, "<this>");
        n.f(n3, "pricePerPeriodType");
        if (dogoSkuDetails2 == null) {
        }
        if (dogoSkuDetails2.getOriginalJson() == null) {
            originalJson = "";
        }
        SkuDetails skuDetails = new SkuDetails(originalJson);
        final PackageType lIFETIME = PackageType.LIFETIME;
        if (dogoSkuDetails2.getSubscriptionPeriod() == lIFETIME) {
            string = textView.getResources().getString(2131887475);
        } else {
            i4 /= d3;
            int i5 = SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$2[n3.ordinal()];
            i3 = 0;
            int i6 = 1;
            if (i5 != i6) {
                if (i5 != 2) {
                    if (i5 != 3) {
                    } else {
                        arr = new Object[i6];
                        arr[i3] = j1.x(skuDetails).format(i2 *= d);
                        string = textView.getResources().getString(2131887428, arr);
                    }
                    NoWhenBranchMatchedException obj9 = new NoWhenBranchMatchedException();
                    throw obj9;
                }
                arr = new Object[i6];
                arr[i3] = j1.x(skuDetails).format(i2 *= d);
                string = textView.getResources().getString(2131887430, arr);
            } else {
                arr = new Object[i6];
                arr[i3] = j1.x(skuDetails).format(i2);
                string = textView.getResources().getString(2131887425, arr);
            }
        }
        textView.setText(string);
        if (dogoSkuDetails2.getSubscriptionPeriod() == PackageType.MONTHLY && n3 == n.MONTH) {
            if (n3 == n.MONTH) {
                textView.setVisibility(4);
            }
        }
    }

    private final void setPinkStyleAndText(ui ui, Resources resources2, boolean z3, String string4, String string5) {
        ui.P.setBackgroundResource(2131231236);
        this.setSpecialBannerStyleAndText(resources2, ui, z3, string4, string5);
    }

    private final void setRedStyleAndText(ui ui, Resources resources2, boolean z3, String string4, String string5) {
        ui.P.setBackgroundResource(2131230871);
        this.setSpecialBannerStyleAndText(resources2, ui, z3, string4, string5);
    }

    private final void setSpecialBannerStyleAndText(Resources resources, ui ui2, boolean z3, String string4, String string5) {
        Object foregroundColorSpan;
        int i4;
        int i3;
        int i;
        int i5;
        int i2;
        Object obj8;
        SpannableString obj9;
        Object obj10;
        int obj11;
        r yELLOW = r.YELLOW;
        ck ckVar = akVar.P;
        n.e(ckVar, "timerBinding.timerLayout.hourSegment");
        setupDashboardDiscountTimerSegment(yELLOW, resources, ckVar);
        ck ckVar2 = akVar2.Q;
        n.e(ckVar2, "timerBinding.timerLayout.minuteSegment");
        setupDashboardDiscountTimerSegment(yELLOW, resources, ckVar2);
        ck ckVar3 = akVar3.R;
        n.e(ckVar3, "timerBinding.timerLayout.secondSegment");
        setupDashboardDiscountTimerSegment(yELLOW, resources, ckVar3);
        ck ckVar4 = akVar4.O;
        n.e(ckVar4, "timerBinding.timerLayout.daysSegment");
        setupDashboardDiscountTimerSegment(r.GRAY, resources, ckVar4);
        ui2.O.setTypeface(Typeface.create("sans-serif-medium", 0));
        ui2.O.setTextColor(resources.getColor(2131100379, 0));
        if (z3 != null) {
            obj9 = new SpannableString(string4);
            obj10 = l.j0(string4, string5, 0, false, 6, 0);
            foregroundColorSpan = new ForegroundColorSpan(a.d(ui2.w().getContext(), 2131100336));
            obj9.setSpan(foregroundColorSpan, obj10, obj11 += obj10, 33);
            obj10 = obj9;
        }
        ui2.O.setText(obj10);
    }

    public static final void setSubscriptionBenefitPlanTitle(TextView textView, y<SubscriptionOffer> y2, boolean z3) {
        boolean empty;
        String originalJson;
        int i2;
        int i;
        SkuDetails skuDetails;
        Object obj5;
        int obj6;
        n.f(textView, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj5 = 0;
        }
        if (obj5 == null) {
        } else {
            obj5 = obj5.a();
            if ((SubscriptionOffer)obj5 == null) {
            } else {
                obj5 = (SubscriptionOffer)obj5.getList();
                i2 = 1;
                i = 0;
                if (obj5 instanceof Collection != null && obj5.isEmpty()) {
                    if (obj5.isEmpty()) {
                        obj5 = i;
                    } else {
                        obj5 = obj5.iterator();
                        while (obj5.hasNext()) {
                            if ((DogoSkuDetails)obj5.next().getOriginalJson() == null) {
                            }
                            skuDetails = new SkuDetails(originalJson);
                            if (j1.n0(skuDetails) > 0) {
                            } else {
                            }
                            empty = i;
                            empty = i2;
                            originalJson = "";
                        }
                    }
                } else {
                }
                if (obj5 != null && z3 != 0) {
                    if (z3 != 0) {
                    } else {
                        i2 = i;
                    }
                } else {
                }
                if (i2 != 0) {
                    obj5 = textView.getResources().getString(2131887624);
                } else {
                    obj5 = textView.getResources().getString(2131887386);
                }
                textView.setText(obj5);
            }
        }
    }

    public static final void setSubscriptionImage(ImageView imageView, y<SubscriptionOffer> y2, FrameLayout frameLayout3, TextView textView4, FrameLayout frameLayout5) {
        boolean i;
        String style;
        int obj2;
        Object obj3;
        n.f(imageView, "<this>");
        n.f(frameLayout3, "statusBarLayout");
        n.f(textView4, "onlyNowText");
        n.f(frameLayout5, "loadingLayout");
        if (y2 instanceof y.c) {
        } else {
            obj3 = style;
        }
        if (obj3 == null) {
        } else {
            obj3 = obj3.a();
            if ((SubscriptionOffer)obj3 == null) {
            } else {
                obj3 = (SubscriptionOffer)obj3.getCoupon();
                if (obj3 == null) {
                } else {
                    style = obj3.getStyle();
                }
                i = 8;
                if (n.b(style, "red")) {
                    imageView.setBackgroundResource(2131230944);
                    frameLayout3.setBackgroundColor(imageView.getContext().getColor(2131100352));
                    textView4.setVisibility(i);
                } else {
                    if (n.b(style, "pink")) {
                        imageView.setBackgroundResource(2131231235);
                        frameLayout3.setBackgroundColor(imageView.getContext().getColor(2131100327));
                        textView4.setVisibility(i);
                    } else {
                        imageView.setBackgroundResource(2131230838);
                        frameLayout3.setBackgroundColor(imageView.getContext().getColor(2131099699));
                        textView4.setVisibility(0);
                    }
                }
                frameLayout5.setVisibility(i);
            }
        }
    }

    public static final void setSubscriptionPlanButton(TextView textView, app.dogo.com.dogo_android.subscription.DogoSkuDetails dogoSkuDetails2, Boolean boolean3) {
        Object skuDetails;
        Object[] arr;
        int i;
        Integer valueOf;
        String obj5;
        Object obj6;
        n.f(textView, "<this>");
        if (dogoSkuDetails2 == null) {
        }
        if (dogoSkuDetails2.getOriginalJson() == null) {
            obj5 = "";
        }
        skuDetails = new SkuDetails(obj5);
        obj5 = j1.n0(skuDetails);
        if (obj5 > 0 && n.b(boolean3, Boolean.TRUE)) {
            if (n.b(boolean3, Boolean.TRUE)) {
                arr = new Object[1];
                obj5 = textView.getResources().getQuantityString(2131755023, obj5, Integer.valueOf(obj5));
            } else {
                obj5 = textView.getResources().getString(2131886679);
            }
        } else {
        }
        textView.setText(obj5);
    }

    public static final void setSubscriptionPlanTitleText(TextView textView, y<SubscriptionOffer> y2) {
        boolean z;
        Resources resources;
        int i;
        Object[] arr;
        Object obj5;
        n.f(textView, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj5 = 0;
        }
        if (obj5 == null) {
        } else {
            obj5 = obj5.a();
            if ((SubscriptionOffer)obj5 == null) {
            } else {
                obj5 = (SubscriptionOffer)obj5.getCoupon();
                z = 0;
                if (obj5 == null) {
                    obj5 = z;
                } else {
                }
                if (obj5 > 0) {
                    arr = new Object[1];
                    arr[z] = Integer.valueOf(obj5);
                    obj5 = textView.getResources().getString(2131887405, arr);
                } else {
                    obj5 = textView.getResources().getString(2131887347);
                }
                textView.setText(obj5);
            }
        }
    }

    private final void setupDashboardDiscountTimer(Resources resources, ui ui2, CouponDiscount couponDiscount3, String string4) {
        String format;
        int i2;
        Object str;
        int i;
        Object[] arr;
        Resources resources2;
        int i3;
        String str2;
        Object obj;
        Object obj9;
        boolean obj11;
        int obj12;
        Object obj2 = couponDiscount3.getDiscountText().get(string4);
        obj = (String)obj2 == null ? str : obj2;
        obj12 = couponDiscount3.getOfferText().get(string4);
        if ((String)obj12 == null) {
        } else {
            str = obj12;
        }
        format = 1;
        i = 0;
        if (obj12 ^= format != 0 && obj12 ^= format != 0) {
            i3 = obj12 ^= format != 0 ? format : i;
        } else {
        }
        obj12 = couponDiscount3.getDiscount();
        if (obj12 == null) {
            obj12 = i;
        } else {
            obj12 = Integer.parseInt(obj12);
        }
        if (i3 != 0) {
            f0 f0Var = f0.a;
            arr = new Object[format];
            arr[i] = obj;
            n.e(String.format(str, Arrays.copyOf(arr, format)), "java.lang.String.format(format, *args)");
            str2 = format;
        } else {
            str2 = obj12;
        }
        obj11 = couponDiscount3.getStyle();
        obj12 = obj11.hashCode();
        if (obj12 != 112785) {
            if (obj12 != 3441014) {
                if (obj12 != 93818879) {
                    ui2.O.setText(str2);
                } else {
                    if (!obj11.equals("black")) {
                    } else {
                        this.setBlackStyleAndText(ui2, resources, i3, str2, obj);
                    }
                }
            } else {
                if (!obj11.equals("pink")) {
                } else {
                    this.setPinkStyleAndText(ui2, resources, i3, str2, obj);
                }
            }
        } else {
            if (!obj11.equals("red")) {
            } else {
                this.setRedStyleAndText(ui2, resources, i3, str2, obj);
            }
        }
    }

    private static final String setupDashboardDiscountTimer$getDefaultDiscountText(Resources resources, int i2) {
        int i3;
        Object[] arr;
        int i;
        String obj3;
        String obj4;
        if (i2 == 0) {
            n.e(resources.getString(2131887347), "{\n                resources.getString(R.string.special_offer2_title)\n            }");
        } else {
            arr = new Object[1];
            n.e(resources.getString(2131887405, Integer.valueOf(i2)), "{\n                resources.getString(R.string.subscription_discount_offer, discount)\n            }");
        }
        return obj3;
    }

    private final void setupDashboardDiscountTimerSegment(r r, Resources resources2, ck ck3) {
        Integer valueOf2;
        Integer valueOf;
        o obj5;
        obj5 = SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$0[r.ordinal()];
        if (obj5 != 1) {
            if (obj5 != 2) {
            } else {
                obj5 = new o(2131099683, 2131099767);
                int intValue = (Number)obj5.a().intValue();
                obj5 = (Number)obj5.b().intValue();
                final int i7 = 0;
                ck3.P.setBackgroundTintList(resources2.getColorStateList(intValue, i7));
                ck3.Q.setBackgroundTintList(resources2.getColorStateList(intValue, i7));
                ck3.P.setTextColor(resources2.getColor(obj5, i7));
                ck3.Q.setTextColor(resources2.getColor(obj5, i7));
            }
            obj5 = new NoWhenBranchMatchedException();
            throw obj5;
        }
        obj5 = new o(2131100336, 2131099706);
    }

    private final void setupSubscriptionDiscountTimerSegment(r r, Resources resources2, mk mk3) {
        Integer valueOf;
        Integer valueOf2;
        o obj5;
        obj5 = SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$0[r.ordinal()];
        if (obj5 != 1) {
            if (obj5 != 2) {
            } else {
                obj5 = new o(2131099683, 2131099767);
                int intValue = (Number)obj5.a().intValue();
                obj5 = (Number)obj5.b().intValue();
                final int i7 = 0;
                mk3.P.setBackgroundTintList(resources2.getColorStateList(intValue, i7));
                mk3.Q.setBackgroundTintList(resources2.getColorStateList(intValue, i7));
                mk3.P.setTextColor(resources2.getColor(obj5, i7));
                mk3.Q.setTextColor(resources2.getColor(obj5, i7));
            }
            obj5 = new NoWhenBranchMatchedException();
            throw obj5;
        }
        obj5 = new o(2131100336, 2131099706);
    }

    public static final void setupTimerDashboard(View view, ui ui2, CouponTimer couponTimer3, o o4, boolean z5, y<Dashboard> y6, oj oj7, ei ei8) {
        String str;
        CouponDiscount couponDiscount;
        String userLanguage;
        Object obj4;
        boolean obj5;
        int obj6;
        int obj9;
        n.f(view, "<this>");
        n.f(ui2, "timerBinding");
        n.f(oj7, "resubscribeBinding");
        n.f(ei8, "currentDogBarBinding");
        if (couponTimer3 == null) {
        } else {
            ui2.U(couponTimer3);
            ui2.T(o4);
        }
        if (y6 instanceof y.c && o4 != null) {
            if (o4 != null) {
                (y.c)y6.a();
                str = 8;
                obj6 = (Dashboard)y6.a().getUserCancelledSubscription() ? obj9 : str;
                oj7.w().setVisibility(obj6);
                obj6 = view.getResources();
                n.e(obj6, "resources");
                if ((Dashboard)y6.a().getCouponDiscount() == null) {
                    couponDiscount = CouponDiscount.Companion.createEmptyObject();
                }
                SubscriptionBindingAdapters.INSTANCE.setupDashboardDiscountTimer(obj6, ui2, couponDiscount, (Dashboard)y6.a().getUserLanguage());
                if (z5 && n.b((Dashboard)y6.a().isUserPremium(), Boolean.FALSE)) {
                    if (n.b(obj5.isUserPremium(), Boolean.FALSE)) {
                    } else {
                        obj9 = str;
                    }
                } else {
                }
                ui2.w().setVisibility(obj9);
            }
        }
        obj4 = new m(ei8, view);
        view.setOnScrollChangeListener(obj4);
    }

    public static final void setupTimerDashboard(View view, CouponTimer couponTimer2, ak ak3) {
        n.f(view, "<this>");
        n.f(ak3, "timerBinding");
        if (couponTimer2 == null) {
        } else {
            ak3.T(couponTimer2);
        }
    }

    private static final void setupTimerDashboard$lambda-8(ei ei, View view2, View view3, int i4, int i5, int i6, int i7) {
        Object obj0;
        float obj1;
        n.f(ei, "$currentDogBarBinding");
        n.f(view2, "$this_setupTimerDashboard");
        ei.W.setElevation(view2.getResources().getDimension(2131165278));
        if (i5 == 0) {
            ei.W.setElevation(0);
        }
    }

    public static final void setupTimerSegment(View view, Long long2, TextView textView3, TextView textView4) {
        String valueOf;
        long l;
        long l2;
        String obj6;
        n.f(view, "<this>");
        n.f(textView3, "rightSegment");
        n.f(textView4, "leftSegment");
        if (long2 == 0) {
        } else {
            long2.longValue();
            l = (long)obj6;
            textView3.setText(String.valueOf(longValue %= l));
            textView4.setText(String.valueOf(obj6 /= l));
        }
    }

    public static final void setupTimerSubscribe(View view, CouponTimer couponTimer2, kk kk3) {
        Object gRAY;
        String str2;
        String str;
        mk mkVar;
        String str3;
        Object obj5;
        Object obj6;
        Object obj7;
        n.f(view, "<this>");
        n.f(kk3, "timerBinding");
        if (couponTimer2 == null) {
        } else {
            kk3.T(couponTimer2);
            obj6 = SubscriptionBindingAdapters.INSTANCE;
            r yELLOW = r.YELLOW;
            Resources resources = view.getResources();
            str = "resources";
            n.e(resources, str);
            mk mkVar2 = kk3.P;
            n.e(mkVar2, "timerBinding.hourSegment");
            obj6.setupSubscriptionDiscountTimerSegment(yELLOW, resources, mkVar2);
            Resources resources2 = view.getResources();
            n.e(resources2, str);
            mk mkVar3 = kk3.Q;
            n.e(mkVar3, "timerBinding.minuteSegment");
            obj6.setupSubscriptionDiscountTimerSegment(yELLOW, resources2, mkVar3);
            Resources resources3 = view.getResources();
            n.e(resources3, str);
            mkVar = kk3.R;
            n.e(mkVar, "timerBinding.secondSegment");
            obj6.setupSubscriptionDiscountTimerSegment(yELLOW, resources3, mkVar);
            obj5 = view.getResources();
            n.e(obj5, str);
            obj7 = kk3.O;
            n.e(obj7, "timerBinding.daySegment");
            obj6.setupSubscriptionDiscountTimerSegment(r.GRAY, obj5, obj7);
        }
    }

    public static final void subscriptionPerPeriod(TextView textView, app.dogo.com.dogo_android.subscription.DogoSkuDetails dogoSkuDetails2, boolean z3) {
        Object[] arr2;
        String originalJson;
        Object[] arr;
        Integer valueOf;
        String obj9;
        int obj10;
        n.f(textView, "<this>");
        if (dogoSkuDetails2 == null) {
        }
        if (dogoSkuDetails2.getOriginalJson() == null) {
            originalJson = "";
        }
        SkuDetails skuDetails = new SkuDetails(originalJson);
        String format = j1.x(skuDetails).format(d /= l2);
        String readableTimePeriod = SubscriptionBindingAdapters.INSTANCE.getReadableTimePeriod(textView, skuDetails);
        arr2 = j1.n0(skuDetails);
        final int i2 = 2;
        int i3 = 1;
        final int i4 = 0;
        if (arr2 > 0 && z3) {
            if (z3) {
                arr = new Object[3];
                arr[i4] = Integer.valueOf(arr2);
                arr[i3] = format;
                arr[i2] = readableTimePeriod;
                obj9 = textView.getResources().getQuantityString(2131755022, arr2, arr);
            } else {
                if (dogoSkuDetails2.getSubscriptionPeriod() == PackageType.LIFETIME) {
                    arr2 = new Object[i3];
                    arr2[i4] = format;
                    obj9 = textView.getResources().getString(2131887476, arr2);
                } else {
                    arr2 = new Object[i2];
                    arr2[i4] = format;
                    arr2[i3] = readableTimePeriod;
                    obj9 = textView.getResources().getString(2131887427, arr2);
                }
            }
        } else {
        }
        textView.setText(obj9);
    }
}
