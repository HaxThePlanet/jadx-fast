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
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.h.ak;
import app.dogo.com.dogo_android.h.ck;
import app.dogo.com.dogo_android.h.ei;
import app.dogo.com.dogo_android.h.kk;
import app.dogo.com.dogo_android.h.mk;
import app.dogo.com.dogo_android.h.oj;
import app.dogo.com.dogo_android.h.ui;
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
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.j1;
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
import kotlin.k0.l;
import net.time4j.g1.v;

/* compiled from: SubscriptionBindingAdapters.kt */
@Metadata(d1 = "\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000cH\u0002J0\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000cH\u0002J0\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000cH\u0002J0\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000cH\u0002J(\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000cH\u0002J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J \u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\u001bH\u0002J\u0014\u0010\u001c\u001a\u00020\u000c*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002JI\u0010 \u001a\u00020\u0004*\u00020!2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#2\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0008\u0010'\u001a\u0004\u0018\u00010(2\u0008\u0010)\u001a\u0004\u0018\u00010\n2\u0008\u0010*\u001a\u0004\u0018\u00010+H\u0007¢\u0006\u0002\u0010,J$\u0010-\u001a\u00020\u0004*\u00020.2\u000c\u0010/\u001a\u0008\u0012\u0004\u0012\u0002000#2\u0008\u00101\u001a\u0004\u0018\u000102H\u0007J$\u00103\u001a\u00020\u0004*\u00020\u001d2\u000e\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\u0006\u00107\u001a\u00020\u001dH\u0007J\u0016\u00108\u001a\u00020\u0004*\u00020\u001d2\u0008\u00109\u001a\u0004\u0018\u00010:H\u0007J\u0016\u0010;\u001a\u00020\u0004*\u00020\u001d2\u0008\u0010<\u001a\u0004\u0018\u00010$H\u0007J\u001e\u0010=\u001a\u00020\u0004*\u00020\u001d2\u0008\u0010<\u001a\u0004\u0018\u00010$2\u0006\u0010>\u001a\u00020+H\u0007J$\u0010?\u001a\u00020\u0004*\u00020\u001d2\u000e\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\u0006\u0010@\u001a\u00020\nH\u0007J4\u0010A\u001a\u00020\u0004*\u00020B2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020EH\u0007J%\u0010H\u001a\u00020\u0004*\u00020\u001d2\u0008\u0010<\u001a\u0004\u0018\u00010$2\u0008\u0010I\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0002\u0010JJ\u001c\u0010K\u001a\u00020\u0004*\u00020\u001d2\u000e\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u000105H\u0007JP\u0010L\u001a\u00020\u0004*\u00020M2\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0010N\u001a\u0004\u0018\u00010O2\u0008\u00101\u001a\u0004\u0018\u00010P2\u0006\u0010Q\u001a\u00020\n2\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020R\u0018\u0001052\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0007J\u001e\u0010L\u001a\u00020\u0004*\u00020M2\u0008\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010\u0005\u001a\u00020WH\u0007J+\u0010X\u001a\u00020\u0004*\u00020M2\u0008\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010[\u001a\u00020\u001d2\u0006\u0010\\\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010]J\u001e\u0010^\u001a\u00020\u0004*\u00020M2\u0008\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010\u0005\u001a\u00020_H\u0007J\u001e\u0010`\u001a\u00020\u0004*\u00020\u001d2\u0008\u0010<\u001a\u0004\u0018\u00010$2\u0006\u0010I\u001a\u00020\nH\u0007¨\u0006a", d2 = {"Lapp/dogo/com/dogo_android/subscription/SubscriptionBindingAdapters;", "", "()V", "setBlackStyleAndText", "", "timerBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutDashboardDiscountCounterBinding;", "resources", "Landroid/content/res/Resources;", "shouldShowSpecialOffer", "", "discountText", "", "specialOfferDiscountText", "setPinkStyleAndText", "setRedStyleAndText", "setSpecialBannerStyleAndText", "setupDashboardDiscountTimer", "dashboardCouponTimer", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "userLanguage", "setupDashboardDiscountTimerSegment", "timerStyle", "Lapp/dogo/com/dogo_android/enums/TimerSegmentStyle;", "segmentBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutDashboardTimerSquareSegmentBinding;", "setupSubscriptionDiscountTimerSegment", "Lapp/dogo/com/dogo_android/databinding/LayoutDiscountTimerSquareSegmentBinding;", "getReadableTimePeriod", "Landroid/widget/TextView;", "skuDetails", "Lcom/android/billingclient/api/SkuDetails;", "setBenefitListAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "skuList", "", "Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;", "benefitCallback", "Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter$Callbacks;", "selected", "", "freeTrailEligible", "pricePerPeriod", "Lapp/dogo/com/dogo_android/enums/PricePerPeriodType;", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter$Callbacks;Ljava/lang/Integer;Ljava/lang/Boolean;Lapp/dogo/com/dogo_android/enums/PricePerPeriodType;)V", "setCustomerExperienceList", "Landroidx/viewpager2/widget/ViewPager2;", "list", "Lapp/dogo/com/dogo_android/repository/domain/CustomerExperience;", "callback", "Lapp/dogo/com/dogo_android/subscription/benefits/UserTestimonialsCallback;", "setDiscountText", "result", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "titleText", "setDiscountTimerLabel", "timeUnit", "Lapp/dogo/com/dogo_android/service/Utilities$TimeUnit;", "setOldStrikedPrice", "subscription", "setPerPeriod", "pricePerPeriodType", "setSubscriptionBenefitPlanTitle", "freeTrialAvailable", "setSubscriptionImage", "Landroid/widget/ImageView;", "couponDiscount", "statusBarLayout", "Landroid/widget/FrameLayout;", "onlyNowText", "loadingLayout", "setSubscriptionPlanButton", "isFreeTrailAvailable", "(Landroid/widget/TextView;Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;Ljava/lang/Boolean;)V", "setSubscriptionPlanTitleText", "setupTimerDashboard", "Landroid/view/View;", "couponTimer", "Lapp/dogo/com/dogo_android/repository/domain/CouponTimer;", "Lapp/dogo/com/dogo_android/dashboard/DashboardCallback;", "discountVisible", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard;", "resubscribeBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutDashboardResubscribeBinding;", "currentDogBarBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutCurrentDogViewV2Binding;", "Lapp/dogo/com/dogo_android/databinding/LayoutDashboardTimerBinding;", "setupTimerSegment", "time", "", "rightSegment", "leftSegment", "(Landroid/view/View;Ljava/lang/Long;Landroid/widget/TextView;Landroid/widget/TextView;)V", "setupTimerSubscribe", "Lapp/dogo/com/dogo_android/databinding/LayoutDiscountTimerBinding;", "subscriptionPerPeriod", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SubscriptionBindingAdapters {

    public static final SubscriptionBindingAdapters INSTANCE = new SubscriptionBindingAdapters();

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class WhenMappings {

        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        static {
            int[] iArr = new int[TimerSegmentStyle.values().length];
            int i = 1;
            iArr[TimerSegmentStyle.YELLOW.ordinal()] = i;
            final int i3 = 2;
            iArr[TimerSegmentStyle.GRAY.ordinal()] = i3;
            SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Utilities_TimeUnit.values().length];
            iArr2[Utilities_TimeUnit.SECONDS.ordinal()] = i;
            iArr2[Utilities_TimeUnit.MINUTES.ordinal()] = i3;
            SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[PricePerPeriodType.values().length];
            iArr3[PricePerPeriodType.DAY.ordinal()] = i;
            iArr3[PricePerPeriodType.WEEK.ordinal()] = i3;
            iArr3[PricePerPeriodType.MONTH.ordinal()] = 3;
            SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$2 = iArr3;
        }
    }
    private SubscriptionBindingAdapters() {
        super();
    }

    private final String getReadableTimePeriod(TextView textView, SkuDetails skuDetails) throws android.content.res.Resources.NotFoundException {
        String str;
        String string;
        boolean equals;
        String str3 = skuDetails.o();
        switch (str3.hashCode()) {
            case 78476:
                str = "P1M";
                str2 = "resources.getString(R.string.subscription_price_per_month_dynamic_key)";
                n.e(textView.getResources().getString(R.string.subscription.price.per.month.dynamic.key), "resources.getString(R.string.subscription_price_per_month_dynamic_key)");
                string = "";
                break;
            case 78486:
                str = "P1W";
                str2 = "resources.getString(R.string.generic_duration_week)";
                n.e(textView.getResources().getString(R.string.generic.duration.week), "resources.getString(R.string.generic_duration_week)");
                string = "";
                break;
            case 78488:
                str = "P1Y";
                str2 = "resources.getString(R.string.generic_duration_year)";
                n.e(textView.getResources().getString(R.string.generic.duration.year), "resources.getString(R.string.generic_duration_year)");
                string = "";
                break;
            case 78538:
                str = "P3M";
                str2 = "resources.getString(R.string.generic_duration_quarter)";
                n.e(textView.getResources().getString(R.string.generic.duration.quarter), "resources.getString(R.string.generic_duration_quarter)");
                string = "";
                break;
            case 78631:
                str = "P6M";
                str2 = "resources.getString(R.string.generic_duration_half_year)";
                n.e(textView.getResources().getString(R.string.generic.duration.half.year), "resources.getString(R.string.generic_duration_half_year)");
                string = "";
                break;
            default:
                string = "";
        }
        return string;
    }

    public static final void setBenefitListAdapter(RecyclerView skuList, List<DogoSkuDetails> benefitCallback, SubscriptionBenefitsOfferAdapter.Callbacks selected, Integer freeTrailEligible, Boolean pricePerPeriod, app.dogo.com.dogo_android.k.n nVar) throws android.content.res.Resources.NotFoundException {
        RecyclerView.h adapter = null;
        app.dogo.com.dogo_android.subscription.l lVar;
        n.f(skuList, "<this>");
        SubscriptionBenefitsOfferAdapter r0 = skuList.getAdapter() instanceof SubscriptionBenefitsOfferAdapter ? (SubscriptionBenefitsOfferAdapter)skuList.getAdapter() : 0;
        if (benefitCallback != null && selected != null && pricePerPeriod != null && freeTrailEligible != null && nVar != null && adapter == null) {
            skuList.setAdapter(new SubscriptionBenefitsOfferAdapter(benefitCallback, pricePerPeriod.booleanValue(), nVar, selected));
            i = (int)skuList.getResources().getDimension(2131165638);
            skuList.h(new VerticalSpaceItemDecoration(i));
            long l = 1000L;
            skuList.postDelayed(new l(skuList), l);
        }
        if (adapter != null && freeTrailEligible != null) {
            if (freeTrailEligible.intValue() != adapter.getCurrentSelectedValue()) {
                adapter.setCurrentSelectedValue(freeTrailEligible.intValue());
            }
        }
    }

    private static final void setBenefitListAdapter$lambda_0(RecyclerView recyclerView) {
        n.f(recyclerView, "$this_setBenefitListAdapter");
        try {
            RecyclerView.h adapter = recyclerView.getAdapter();
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            a.d(e);
        }
    }

    private final void setBlackStyleAndText(ui timerBinding, Resources resources, boolean shouldShowSpecialOffer, String discountText, String specialOfferDiscountText) {
        timerBinding.P.setBackgroundResource(2131231305);
        this.setSpecialBannerStyleAndText(resources, timerBinding, shouldShowSpecialOffer, discountText, specialOfferDiscountText);
    }

    public static final void setCustomerExperienceList(ViewPager2 list, List<CustomerExperience> callback, UserTestimonialsCallback userTestimonialsCallback) throws android.content.res.Resources.NotFoundException {
        n.f(list, "<this>");
        n.f(callback, "list");
        if (list.getAdapter() == null && userTestimonialsCallback != null) {
            SubscriptionTestimonialsAdapter subscriptionTestimonialsAdapter = new SubscriptionTestimonialsAdapter();
            subscriptionTestimonialsAdapter.setExperienceItemsList(callback);
            list.setAdapter(subscriptionTestimonialsAdapter);
            list.k(1073741825, false);
            list.setOffscreenPageLimit(3);
            int i2 = 2131165618;
            list.setPageTransformer(new k(list.getResources().getDimensionPixelOffset(i2), list.getResources().getDimensionPixelOffset(i2)));
            list.h(new SubscriptionBindingAdapters_setCustomerExperienceList_2(userTestimonialsCallback));
        }
    }

    private static final void setCustomerExperienceList$lambda_2(int i, int i2, View view, float f) {
        n.f(view, "page");
        ViewParent parent2 = view.getParent().getParent();
        Objects.requireNonNull(parent2, "null cannot be cast to non-null type androidx.viewpager2.widget.ViewPager2");
        f *= f;
        if (parent2.getOrientation() != 0) {
            view.setTranslationY(f2);
        } else {
            int i3 = 1;
            if (u.B(parent2) == 1) {
                orientation = -f2;
                view.setTranslationX(orientation);
            } else {
                view.setTranslationX(f2);
            }
        }
    }

    public static final void setDiscountText(TextView result, app.dogo.com.dogo_android.util.e0.y<SubscriptionOffer> titleText, TextView textView) throws android.content.res.Resources.NotFoundException {
        int i2 = 0;
        int textView32;
        Object obj;
        n.f(result, "<this>");
        n.f(textView, "titleText");
        titleText = titleText instanceof LoadResult_Success ? (oadResult_Success)titleText : 0;
        textView32 = 0;
        titleText = textView32;
        if (textView32 > 0) {
            int i = 2131887405;
            Object[] arr = new Object[1];
            String string = result.getResources().getString(i, new Object[] { Integer.valueOf(textView32) });
        } else {
            textView32 = 2131887347;
            String string2 = result.getResources().getString(textView32);
        }
        result.setText(obj);
    }

    public static final void setDiscountTimerLabel(TextView timeUnit, v2.b bVar) {
        v nARROW2;
        int i = 1;
        str = "<this>";
        n.f(timeUnit, str);
        if (bVar != null) {
            timeUnit.setVisibility(0);
            int i5 = SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$1[bVar.ordinal()];
            i = 1;
            v r0 = SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$1 != 1 && SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$1 != 2 ? v.NARROW : v.SHORT;
            long l = 0L;
            boolean z = false;
            int i2 = 4;
            Object obj = null;
            str3 = "0";
            str4 = "";
            String str5 = l.G(Utilities.Companion.c(0L, bVar, bVar, (SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$1 != 1 && SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$1 != 2 ? v.NARROW : v.SHORT)), "0", "", false, 4, null);
            str = "null cannot be cast to non-null type kotlin.CharSequence";
            Objects.requireNonNull(str5, (SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$1 != 1 && SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$1 != 2 ? v.NARROW : v.SHORT));
            timeUnit.setText(l.a1(str5).toString());
        } else {
            int i3 = 8;
            timeUnit.setVisibility(i3);
        }
    }

    public static final void setOldStrikedPrice(TextView subscription, DogoSkuDetails dogoSkuDetails) throws android.content.res.Resources.NotFoundException {
        String dogoSkuDetails22;
        n.f(subscription, "<this>");
        dogoSkuDetails22 = "";
        String r1 = dogoSkuDetails == null ? "" : dogoSkuDetails22;
        int percent = app.dogo.com.dogo_android.util.extensionfunction.j1.getPercent((dogoSkuDetails == null ? "" : dogoSkuDetails22));
        if (dogoSkuDetails == null || percent == 0) {
            int i4 = 8;
            subscription.setVisibility(i4);
        }
    }

    public static final void setPerPeriod(TextView subscription, DogoSkuDetails pricePerPeriodType, app.dogo.com.dogo_android.k.n nVar) throws NoWhenBranchMatchedException, android.content.res.Resources.NotFoundException {
        Object obj;
        String originalJson;
        n.f(subscription, "<this>");
        n.f(nVar, "pricePerPeriodType");
        if (pricePerPeriodType == null) {
            return;
        }
        if (pricePerPeriodType.getOriginalJson() == null) {
            originalJson = "";
        }
        SkuDetails skuDetails = new SkuDetails(originalJson);
        final PackageType lIFETIME2 = PackageType.LIFETIME;
        if (pricePerPeriodType.getSubscriptionPeriod() == PackageType.LIFETIME) {
            String string4 = subscription.getResources().getString(2131887475);
        } else {
            d = (double)skuDetails.l() / 1000000d / (double)pricePerPeriodType.getPeriodInDays();
            int i4 = SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$2[nVar.ordinal()];
            int i = 0;
            int i5 = 1;
            if (SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$2 != i5) {
                if (SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$2 != 2 && SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$2 == 3) {
                    int i2 = 2131887428;
                    Object[] arr = new Object[i5];
                    d2 = (double)30;
                    d = d * d2;
                    String string3 = subscription.getResources().getString(i2, new Object[] { app.dogo.com.dogo_android.util.extensionfunction.j1.x(skuDetails).format(d) });
                }
                i2 = 2131887430;
                arr = new Object[i5];
                d2 = (double)7;
                d = d * d2;
                String string2 = subscription.getResources().getString(i2, new Object[] { app.dogo.com.dogo_android.util.extensionfunction.j1.x(skuDetails).format(d) });
            } else {
                i2 = 2131887425;
                arr = new Object[i5];
                String string = subscription.getResources().getString(i2, new Object[] { app.dogo.com.dogo_android.util.extensionfunction.j1.x(skuDetails).format(d) });
            }
        }
        subscription.setText(obj);
        if (pricePerPeriodType.getSubscriptionPeriod() == PackageType.MONTHLY && nVar == PricePerPeriodType.MONTH) {
            subscription.setVisibility(4);
        }
    }

    private final void setPinkStyleAndText(ui timerBinding, Resources resources, boolean shouldShowSpecialOffer, String discountText, String specialOfferDiscountText) {
        timerBinding.P.setBackgroundResource(2131231236);
        this.setSpecialBannerStyleAndText(resources, timerBinding, shouldShowSpecialOffer, discountText, specialOfferDiscountText);
    }

    private final void setRedStyleAndText(ui timerBinding, Resources resources, boolean shouldShowSpecialOffer, String discountText, String specialOfferDiscountText) {
        timerBinding.P.setBackgroundResource(2131230871);
        this.setSpecialBannerStyleAndText(resources, timerBinding, shouldShowSpecialOffer, discountText, specialOfferDiscountText);
    }

    private final void setSpecialBannerStyleAndText(Resources resources, ui timerBinding, boolean shouldShowSpecialOffer, String discountText, String specialOfferDiscountText) throws android.content.res.Resources.NotFoundException {
        Object obj2;
        r yELLOW2 = TimerSegmentStyle.YELLOW;
        n.e(timerBinding.R.P, "timerBinding.timerLayout.hourSegment");
        setupDashboardDiscountTimerSegment(yELLOW2, resources, timerBinding.R.P);
        n.e(timerBinding.R.Q, "timerBinding.timerLayout.minuteSegment");
        setupDashboardDiscountTimerSegment(yELLOW2, resources, timerBinding.R.Q);
        n.e(timerBinding.R.R, "timerBinding.timerLayout.secondSegment");
        setupDashboardDiscountTimerSegment(yELLOW2, resources, timerBinding.R.R);
        n.e(timerBinding.R.O, "timerBinding.timerLayout.daysSegment");
        setupDashboardDiscountTimerSegment(TimerSegmentStyle.GRAY, resources, timerBinding.R.O);
        timerBinding.O.setTypeface(Typeface.create("sans-serif-medium", 0));
        int i = 2131100379;
        android.content.res.Resources.Theme theme = null;
        timerBinding.O.setTextColor(resources.getColor(i, theme));
        if (shouldShowSpecialOffer) {
            SpannableString shouldShowSpecialOffer2 = new SpannableString(discountText);
            boolean z = false;
            int i2 = 6;
            Object obj = null;
            int i9 = l.j0(discountText, specialOfferDiscountText, 0, z, i2, obj);
            i4 = specialOfferDiscountText.length() + i9;
            int i3 = 33;
            shouldShowSpecialOffer2.setSpan(new ForegroundColorSpan(a.d(timerBinding.w().getContext(), 2131100336)), i9, i4, i3);
        }
        timerBinding.O.setText(obj2);
    }

    public static final void setSubscriptionBenefitPlanTitle(TextView result, app.dogo.com.dogo_android.util.e0.y<SubscriptionOffer> freeTrialAvailable, boolean z) throws android.content.res.Resources.NotFoundException {
        boolean hasNext;
        String originalJson;
        int i = 1;
        SkuDetails skuDetails;
        int i2 = 0;
        Object obj;
        int i3 = 2131887386;
        n.f(result, "<this>");
        hasNext = freeTrialAvailable instanceof LoadResult_Success;
        freeTrialAvailable = freeTrialAvailable instanceof oadResult_Success ? (oadResult_Success)freeTrialAvailable : 0;
        if (i2 != 0) {
            Object component1 = i2.component1();
            if (component1 != null) {
                List list = component1.getList();
                hasNext = list instanceof Collection;
                i = 1;
                i = 0;
                freeTrialAvailable = i;
                if (i == 0 || !z) {
                }
                if (i != 0) {
                    i3 = 2131887624;
                    String string2 = result.getResources().getString(i3);
                } else {
                    i3 = 2131887386;
                    String string = result.getResources().getString(i3);
                }
                result.setText(obj);
            }
        }
    }

    public static final void setSubscriptionImage(ImageView couponDiscount, app.dogo.com.dogo_android.util.e0.y<SubscriptionOffer> statusBarLayout, FrameLayout onlyNowText, TextView loadingLayout, FrameLayout frameLayout) {
        String style = null;
        int color = 0;
        int i;
        n.f(couponDiscount, "<this>");
        n.f(onlyNowText, "statusBarLayout");
        n.f(loadingLayout, "onlyNowText");
        n.f(frameLayout, "loadingLayout");
        z = statusBarLayout instanceof LoadResult_Success;
        i = 0;
        statusBarLayout = statusBarLayout instanceof oadResult_Success ? (oadResult_Success)statusBarLayout : 0;
        if (i != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                CouponDiscount coupon = component1.getCoupon();
                if (coupon != null) {
                    style = coupon.getStyle();
                }
                int i2 = 8;
                if (n.b(style, "red")) {
                    couponDiscount.setBackgroundResource(2131230944);
                    i = 2131100352;
                    onlyNowText.setBackgroundColor(couponDiscount.getContext().getColor(i));
                    loadingLayout.setVisibility(i2);
                } else {
                    if (n.b(style, "pink")) {
                        couponDiscount.setBackgroundResource(2131231235);
                        i = 2131100327;
                        onlyNowText.setBackgroundColor(couponDiscount.getContext().getColor(i));
                        loadingLayout.setVisibility(i2);
                    } else {
                        couponDiscount.setBackgroundResource(2131230838);
                        i = 2131099699;
                        onlyNowText.setBackgroundColor(couponDiscount.getContext().getColor(i));
                        color = 0;
                        loadingLayout.setVisibility(color);
                    }
                }
                frameLayout.setVisibility(i2);
            }
        }
    }

    public static final void setSubscriptionPlanButton(TextView subscription, DogoSkuDetails isFreeTrailAvailable, Boolean boolean) throws android.content.res.Resources.NotFoundException {
        SkuDetails skuDetails;
        String originalJson;
        Object obj;
        n.f(subscription, "<this>");
        if (isFreeTrailAvailable == null) {
            return;
        }
        if (isFreeTrailAvailable.getOriginalJson() == null) {
            originalJson = "";
        }
        skuDetails = new SkuDetails(originalJson);
        int i5 = app.dogo.com.dogo_android.util.extensionfunction.j1.n0(skuDetails);
        if (i5 > 0) {
            if (n.b(boolean, Boolean.TRUE)) {
                Object[] arr = new Object[1];
                int i = 0;
                arr[i] = Integer.valueOf(i5);
                String quantityString = subscription.getResources().getQuantityString(2131755023, i5, arr);
            } else {
                int i2 = 2131886679;
                String string = subscription.getResources().getString(i2);
            }
        }
        subscription.setText(obj);
    }

    public static final void setSubscriptionPlanTitleText(TextView result, app.dogo.com.dogo_android.util.e0.y<SubscriptionOffer> yVar) throws android.content.res.Resources.NotFoundException {
        int value = 0;
        Resources resources;
        int i = 2131887405;
        Object[] arr;
        int i2 = 0;
        Object obj;
        n.f(result, "<this>");
        z = yVar instanceof LoadResult_Success;
        yVar = yVar instanceof oadResult_Success ? (oadResult_Success)yVar : 0;
        if (i2 != 0) {
            Object component1 = i2.component1();
            if (component1 != null) {
                CouponDiscount coupon = component1.getCoupon();
                value = 0;
                yVar = value;
                if (value > 0) {
                    i = 2131887405;
                    arr = new Object[1];
                    String string = result.getResources().getString(i, new Object[] { Integer.valueOf(value) });
                } else {
                    value = 2131887347;
                    String string2 = result.getResources().getString(value);
                }
                result.setText(obj);
            }
        }
    }

    private final void setupDashboardDiscountTimer(Resources resources, ui uiVar, CouponDiscount couponDiscount, String str) {
        String str42;
        int i2 = 93818879;
        java.lang.CharSequence charSequence;
        Object[] arr;
        boolean z;
        java.lang.CharSequence charSequence2;
        String style;
        int i3;
        int parsed;
        int i4;
        Object value = couponDiscount.getDiscountText().get(str);
        String r7 = value == null ? "" : value;
        Object str43 = couponDiscount.getOfferText().get(str);
        if (str43 != null) {
        }
        int i = 1;
        i3 = l.z(charSequence2) ^ i;
        parsed = 0;
        if (l.z(charSequence2) ^ i != 0) {
            i3 = l.z(charSequence) ^ i;
            int r5 = l.z(charSequence) ^ i != 0 ? i : parsed;
        }
        String discount = couponDiscount.getDiscount();
        if (discount == null) {
        } else {
            parsed = Integer.parseInt(discount);
        }
        if (z) {
            try {
                arr = new Object[i];
                n.e(String.format(charSequence, Arrays.copyOf(new Object[] { charSequence2 }, i)), "java.lang.String.format(format, *args)");
            } catch (Exception e) {
                a.d(e);
            }
        } else {
        }
        style = couponDiscount.getStyle();
        i4 = style.hashCode();
        i2 = 112785;
        if (i4 != 112785) {
            i2 = 3441014;
            if (i4 != 3441014) {
                i2 = 93818879;
                if (i4 != 93818879) {
                    uiVar.O.setText(str42);
                } else {
                    if (style.equals("black")) {
                        this.setBlackStyleAndText(uiVar, resources, z, str42, charSequence2);
                    }
                }
            } else {
                if (style.equals("pink")) {
                    this.setPinkStyleAndText(uiVar, resources, z, str42, charSequence2);
                }
            }
        } else {
            if (style.equals("red")) {
                this.setRedStyleAndText(uiVar, resources, z, str42, charSequence2);
            }
        }
    }

    private static final String setupDashboardDiscountTimer$getDefaultDiscountText(Resources resources, int i) throws android.content.res.Resources.NotFoundException {
        String string;
        if (i == 0) {
            str = "{\n                resources.getString(R.string.special_offer2_title)\n            }";
            n.e(resources.getString(2131887347), str);
        } else {
            i = 2131887405;
            Object[] arr = new Object[1];
            int i3 = 0;
            arr[i3] = Integer.valueOf(i);
            str = "{\n                resources.getString(R.string.subscription_discount_offer, discount)\n            }";
            n.e(resources.getString(i, arr), str);
        }
        return string;
    }

    private final void setupDashboardDiscountTimerSegment(r timerStyle, Resources resources, ck segmentBinding) throws NoWhenBranchMatchedException, android.content.res.Resources.NotFoundException {
        kotlin.o pair;
        int i7 = SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$0[timerStyle.ordinal()];
        if (i7 != 1 && i7 == 2) {
            pair = new Pair(2131099683, 2131099767);
            int intValue = (Number)pair.a().intValue();
            int intValue2 = (Number)pair.b().intValue();
            final android.content.res.Resources.Theme theme = null;
            segmentBinding.P.setBackgroundTintList(resources.getColorStateList(intValue, theme));
            segmentBinding.Q.setBackgroundTintList(resources.getColorStateList(intValue, theme));
            segmentBinding.P.setTextColor(resources.getColor(intValue2, theme));
            segmentBinding.Q.setTextColor(resources.getColor(intValue2, theme));
            return;
        }
        pair = new Pair(2131100336, 2131099706);
    }

    private final void setupSubscriptionDiscountTimerSegment(r timerStyle, Resources resources, mk segmentBinding) throws android.content.res.Resources.NotFoundException, NoWhenBranchMatchedException {
        kotlin.o pair;
        int i7 = SubscriptionBindingAdapters.WhenMappings.$EnumSwitchMapping$0[timerStyle.ordinal()];
        if (i7 != 1 && i7 == 2) {
            pair = new Pair(2131099683, 2131099767);
            int intValue = (Number)pair.a().intValue();
            int intValue2 = (Number)pair.b().intValue();
            final android.content.res.Resources.Theme theme = null;
            segmentBinding.P.setBackgroundTintList(resources.getColorStateList(intValue, theme));
            segmentBinding.Q.setBackgroundTintList(resources.getColorStateList(intValue, theme));
            segmentBinding.P.setTextColor(resources.getColor(intValue2, theme));
            segmentBinding.Q.setTextColor(resources.getColor(intValue2, theme));
            return;
        }
        pair = new Pair(2131100336, 2131099706);
    }

    public static final void setupTimerDashboard(View couponTimer, ui timerBinding, CouponTimer couponTimer2, app.dogo.com.dogo_android.g.o oVar, boolean z, app.dogo.com.dogo_android.util.e0.y<Dashboard> yVar, oj ojVar, ei eiVar) {
        CouponDiscount couponDiscount;
        Object component1;
        int ojVar72;
        Boolean fALSE2;
        Resources resources;
        n.f(couponTimer, "<this>");
        n.f(timerBinding, "timerBinding");
        n.f(ojVar, "resubscribeBinding");
        str = "currentDogBarBinding";
        n.f(eiVar, str);
        if (couponTimer2 != null) {
            timerBinding.U(couponTimer2);
            timerBinding.T(oVar);
        }
        z = yVar instanceof LoadResult_Success;
        if (yVar instanceof oadResult_Success && oVar != null) {
            yVar.component1();
            ojVar72 = 0;
            ojVar72 = 8;
            oVar = (Dashboard)yVar.component1().getUserCancelledSubscription() ? 0 : ojVar72;
            ojVar.w().setVisibility(((Dashboard)yVar.component1().getUserCancelledSubscription() ? 0 : ojVar72));
            resources = couponTimer.getResources();
            n.e(oVar, "resources");
            if (yVar.component1().getCouponDiscount() == null) {
                couponDiscount = CouponDiscount.INSTANCE.createEmptyObject();
            }
            SubscriptionBindingAdapters.INSTANCE.setupDashboardDiscountTimer(oVar, timerBinding, couponDiscount, (Dashboard)yVar.component1().getUserLanguage());
            if (z) {
                if (!(n.b((Dashboard)yVar.component1().isUserPremium(), Boolean.FALSE))) {
                }
            }
            timerBinding.w().setVisibility(ojVar72);
        }
        couponTimer.setOnScrollChangeListener(new m(eiVar, couponTimer));
    }

    private static final void setupTimerDashboard$lambda_8(ei eiVar, View view, View view2, int i, int i2, int i3, int i4) throws android.content.res.Resources.NotFoundException {
        n.f(eiVar, "$currentDogBarBinding");
        n.f(view, "$this_setupTimerDashboard");
        eiVar.W.setElevation(view.getResources().getDimension(2131165278));
        if (i2 == 0) {
            float dimension = 0.0f;
            eiVar.W.setElevation(dimension);
        }
    }

    public static final void setupTimerSegment(View time, Long rightSegment, TextView leftSegment, TextView textView) {
        str = "<this>";
        n.f(time, str);
        n.f(leftSegment, "rightSegment");
        str2 = "leftSegment";
        n.f(textView, str2);
        if (rightSegment != 0) {
            rightSegment.longValue();
            l = (long)10;
            l2 = (long)100;
            leftSegment.setText(String.valueOf(rightSegment.longValue() % l));
            textView.setText(String.valueOf((rightSegment.longValue() % l2) / l));
        }
    }

    public static final void setupTimerSubscribe(View couponTimer, CouponTimer timerBinding, kk kkVar) {
        n.f(couponTimer, "<this>");
        str = "timerBinding";
        n.f(kkVar, str);
        if (timerBinding != null) {
            kkVar.T(timerBinding);
            iNSTANCE2 = SubscriptionBindingAdapters.INSTANCE;
            r yELLOW2 = TimerSegmentStyle.YELLOW;
            Resources resources2 = couponTimer.getResources();
            str3 = "resources";
            n.e(resources2, str3);
            n.e(kkVar.P, "timerBinding.hourSegment");
            iNSTANCE2.setupSubscriptionDiscountTimerSegment(yELLOW2, resources2, kkVar.P);
            Resources resources3 = couponTimer.getResources();
            n.e(resources3, str3);
            n.e(kkVar.Q, "timerBinding.minuteSegment");
            iNSTANCE2.setupSubscriptionDiscountTimerSegment(yELLOW2, resources3, kkVar.Q);
            Resources resources4 = couponTimer.getResources();
            n.e(resources4, str3);
            str4 = "timerBinding.secondSegment";
            n.e(kkVar.R, str4);
            iNSTANCE2.setupSubscriptionDiscountTimerSegment(yELLOW2, resources4, kkVar.R);
            Resources resources = couponTimer.getResources();
            n.e(resources, str3);
            str2 = "timerBinding.daySegment";
            n.e(kkVar.O, str2);
            iNSTANCE2.setupSubscriptionDiscountTimerSegment(TimerSegmentStyle.GRAY, resources, kkVar.O);
        }
    }

    public static final void subscriptionPerPeriod(TextView subscription, DogoSkuDetails isFreeTrailAvailable, boolean z) throws android.content.res.Resources.NotFoundException {
        String originalJson;
        Object obj2;
        n.f(subscription, "<this>");
        if (isFreeTrailAvailable == null) {
            return;
        }
        if (isFreeTrailAvailable.getOriginalJson() == null) {
            originalJson = "";
        }
        SkuDetails skuDetails = new SkuDetails(originalJson);
        String format = app.dogo.com.dogo_android.util.extensionfunction.j1.x(skuDetails).format((double)skuDetails.l() / 1000000d);
        String readableTimePeriod = SubscriptionBindingAdapters.INSTANCE.getReadableTimePeriod(subscription, skuDetails);
        int i2 = app.dogo.com.dogo_android.util.extensionfunction.j1.n0(skuDetails);
        final int i3 = 2;
        int i4 = 1;
        final int i5 = 0;
        if (i2 <= 0 || !z) {
            if (isFreeTrailAvailable.getSubscriptionPeriod() == PackageType.LIFETIME) {
                int i = 2131887476;
                Object[] arr = new Object[i4];
                String string2 = subscription.getResources().getString(i, new Object[] { format });
            } else {
                i = 2131887427;
                arr = new Object[i3];
                String string = subscription.getResources().getString(i, new Object[] { format, readableTimePeriod });
            }
        } else {
            i = 2131755022;
            Object[] arr2 = new Object[3];
            String quantityString = subscription.getResources().getQuantityString(i, i2, new Object[] { Integer.valueOf(i2), format, readableTimePeriod });
        }
        subscription.setText(obj2);
    }

    public static final void setupTimerDashboard(View view, CouponTimer couponTimer, ak akVar) {
        n.f(view, "<this>");
        n.f(akVar, "timerBinding");
        if (couponTimer != null) {
            akVar.T(couponTimer);
        }
    }


    /* renamed from: a, reason: from kotlin metadata */
    public static /* synthetic */ void setupDashboardDiscountTimer(int resources, int timerBinding, View dashboardCouponTimer, float userLanguage) {
        SubscriptionBindingAdapters.setCustomerExperienceList$lambda_2(resources, timerBinding, dashboardCouponTimer, userLanguage);
    }

    /* renamed from: b, reason: from kotlin metadata */
    public static /* synthetic */ void getReadableTimePeriod(RecyclerView skuDetails) {
        SubscriptionBindingAdapters.setBenefitListAdapter$lambda_0(skuDetails);
    }

    /* renamed from: c, reason: from kotlin metadata */
    public static /* synthetic */ void setupTimerDashboard(ei timerBinding, View couponTimer, View callback, int discountVisible, int result, int resubscribeBinding, int currentDogBarBinding) {
        SubscriptionBindingAdapters.setupTimerDashboard$lambda_8(timerBinding, couponTimer, callback, discountVisible, result, resubscribeBinding, currentDogBarBinding);
    }
}
