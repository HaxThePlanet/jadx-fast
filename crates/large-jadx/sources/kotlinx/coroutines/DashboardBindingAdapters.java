package app.dogo.com.dogo_android.g;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.h.ek;
import app.dogo.com.dogo_android.h.ij;
import app.dogo.com.dogo_android.h.ki;
import app.dogo.com.dogo_android.h.mi;
import app.dogo.com.dogo_android.h.oi;
import app.dogo.com.dogo_android.h.qi;
import app.dogo.com.dogo_android.h.wi;
import app.dogo.com.dogo_android.h.wj;
import app.dogo.com.dogo_android.h.yi;
import app.dogo.com.dogo_android.repository.domain.Dashboard;
import app.dogo.com.dogo_android.repository.domain.Dashboard.BitingProgramCard;
import app.dogo.com.dogo_android.repository.domain.Dashboard.DashboardCardsEnum;
import app.dogo.com.dogo_android.repository.domain.Dashboard.PottyProgramCard;
import app.dogo.com.dogo_android.repository.domain.DashboardProgram;
import app.dogo.com.dogo_android.repository.domain.DashboardProgram.CardType;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.service.v2.a;
import app.dogo.com.dogo_android.service.v2.b;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.n0.z;
import d.h.l.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import kotlin.e0.a;
import kotlin.j0.h;
import kotlin.j0.i;
import kotlin.o;
import kotlin.w;
import kotlin.y.j0;
import net.time4j.g1.v;

/* compiled from: DashboardBindingAdapters.kt */
@Metadata(d1 = "\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0002J*\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\u000c2\u0006\u0010\u000e\u001a\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J&\u0010\u0018\u001a\u00020\u0004*\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u001b2\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u0016\u0010\u001c\u001a\u00020\u0004*\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u0016\u0010 \u001a\u00020\u0004*\u00020\u001d2\u0008\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u001b\u0010#\u001a\u00020\u0004*\u00020\u001d2\u0008\u0010$\u001a\u0004\u0018\u00010%H\u0007¢\u0006\u0002\u0010&J \u0010'\u001a\u00020\u0004*\u00020(2\u0008\u0010\u001a\u001a\u0004\u0018\u00010)2\u0008\u0010\t\u001a\u0004\u0018\u00010*H\u0007J0\u0010+\u001a\u00020\u0004*\u00020\u000f2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001d2\u0008\u0010\t\u001a\u0004\u0018\u00010*2\u0008\u0010\u001e\u001a\u0004\u0018\u00010)H\u0007¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/dashboard/DashboardBindingAdapters;", "", "()V", "configureBinding", "", "binding", "Landroidx/databinding/ViewDataBinding;", "dashboard", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard;", "callback", "Lapp/dogo/com/dogo_android/dashboard/DashboardCallback;", "getBindings", "", "", "parent", "Landroid/view/ViewGroup;", "orderList", "", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard$DashboardCardsEnum;", "setMarginsForDashboardCard", "layout", "Landroid/widget/LinearLayout$LayoutParams;", "context", "Landroid/content/Context;", "setDashboardAdapter", "Landroid/widget/LinearLayout;", "result", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "setDashboardCardsTitle", "Landroid/widget/TextView;", "item", "Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram;", "setDashboardExamTitle", "examItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "setDashboardTrainingTimeText", "durationSec", "", "(Landroid/widget/TextView;Ljava/lang/Integer;)V", "setTrainingWeekSummary", "Landroidx/recyclerview/widget/RecyclerView;", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "Lapp/dogo/com/dogo_android/dashboard/TrainingWeekSummaryCallback;", "setupMetricsTooltip", "tooltip", "Lapp/dogo/com/dogo_android/databinding/LayoutDashboardMetricTooltipBinding;", "title", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n, reason: from kotlin metadata */
public final class DashboardBindingAdapters {

    public static final n a = new n();

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[Dashboard_DashboardCardsEnum.values().length];
            iArr[Dashboard_DashboardCardsEnum.RECENT.ordinal()] = 1;
            iArr[Dashboard_DashboardCardsEnum.PROGRAM.ordinal()] = 2;
            iArr[Dashboard_DashboardCardsEnum.EXAM.ordinal()] = 3;
            iArr[Dashboard_DashboardCardsEnum.POTTY.ordinal()] = 4;
            iArr[Dashboard_DashboardCardsEnum.BITING.ordinal()] = 5;
            iArr[Dashboard_DashboardCardsEnum.WORKOUT.ordinal()] = 6;
            iArr[Dashboard_DashboardCardsEnum.SUBSCRIPTION.ordinal()] = 7;
            iArr[Dashboard_DashboardCardsEnum.TRAINING_TIME_SUMMARY.ordinal()] = 8;
            kotlinx.coroutines.n.a.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "Landroidx/databinding/ViewDataBinding;", "it", "Landroid/view/View;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements kotlin.d0.c.l<View, ViewDataBinding> {

        public static final n.b a = new n$b();
        @Override // kotlin.d0.d.p
        public final ViewDataBinding a(View view) {
            n.f(view, "it");
            return f.d(view);
        }


        b() {
            super(1);
        }
    }
    private n() {
        super();
    }

    /* renamed from: a, reason: from kotlin metadata */
    private final void configureBinding(ViewDataBinding binding, Dashboard dashboard, o callback) {
        int size = 8;
        ProgramExamSummary programExamSummary = null;
        app.dogo.com.dogo_android.repository.domain.PottyProgramProgress programProgress = null;
        app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData programCompletion = null;
        app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescription;
        app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescription2;
        TrainingTimeMetrics trainingMetrics2;
        boolean shouldShowMetricsInDashboard;
        Dashboard.BitingProgramCard bitingProgramCard3;
        z = binding instanceof ij;
        size = 8;
        size = 0;
        if (z) {
            binding2 = binding;
            binding2.W(dashboard.getRecentlyViewed());
            binding2.V(callback);
            RecentlyViewedTricks recentlyViewed = dashboard.getRecentlyViewed();
            dashboard = size;
            if (size > 0) {
            }
            binding2.w().setVisibility(size);
        } else {
            size = 1;
            if (binding instanceof ek) {
                binding2 = binding;
                binding2.W(dashboard.getTrainingMetrics());
                binding2.V(callback);
                trainingMetrics2 = dashboard.getTrainingMetrics();
                int r4 = size;
                if (size != 0) {
                }
                binding2.w().setVisibility(size);
            } else {
                if (binding instanceof mi) {
                    binding2 = binding;
                    binding2.W(dashboard.getProgramItem());
                    binding2.V(callback);
                    DashboardProgram programItem3 = dashboard.getProgramItem();
                    if (programItem3 != null) {
                        DashboardProgram.CardType type = programItem3.getType();
                        if (type != null) {
                            r4 = size;
                            binding2.S.w().setVisibility(size);
                            r4 = size;
                            binding2.O.w().setVisibility(size);
                            r4 = size;
                            binding2.P.w().setVisibility(size);
                            r4 = size;
                            binding2.R.w().setVisibility(size);
                            if (type == DashboardProgram_CardType.RECOMMENDED_PROGRAM_V2) {
                            }
                            binding2.Q.w().setVisibility(size);
                        }
                    }
                } else {
                    int i = 0;
                    if (binding instanceof wi) {
                        binding2 = binding;
                        DashboardProgram programItem = dashboard.getProgramItem();
                        if (programItem != null) {
                            programExamSummary = programItem.getProgramExamSummary();
                        }
                        binding2.W(programExamSummary);
                        binding2.V(callback);
                        if (dashboard.isExamCardVisible()) {
                        }
                        binding2.w().setVisibility(size);
                    } else {
                        if (binding instanceof ki) {
                            Object binding2 = binding;
                            Dashboard.PottyProgramCard pottyProgramCard10 = dashboard.getPottyProgramCard();
                            if (pottyProgramCard10 == null) {
                            } else {
                                programDescription = pottyProgramCard10.getProgramDescription();
                            }
                            binding2.X(programDescription);
                            Dashboard.PottyProgramCard pottyProgramCard9 = dashboard.getPottyProgramCard();
                            if (pottyProgramCard9 != null) {
                                programProgress = pottyProgramCard9.getProgramProgress();
                            }
                            binding2.Y(programProgress);
                            binding2.V(callback);
                            binding2.W(dashboard.getPottyCheckmarks());
                            Dashboard.PottyProgramCard pottyProgramCard2 = dashboard.getPottyProgramCard();
                            int r5 = size;
                            r5 = size;
                            binding2.w().setVisibility(size);
                            View view5 = binding2.P.w();
                            n.e(view5, size);
                            Dashboard.PottyProgramCard pottyProgramCard3 = dashboard.getPottyProgramCard();
                            r5 = size;
                            if ("binding.programCard.root" != 0) {
                                Dashboard.PottyProgramCard pottyProgramCard4 = dashboard.getPottyProgramCard();
                                r5 = size;
                                r5 = size;
                            }
                            r5 = size;
                            view5.setVisibility(size);
                            View view6 = binding2.Q.w();
                            n.e(view6, size);
                            Dashboard.PottyProgramCard pottyProgramCard5 = dashboard.getPottyProgramCard();
                            r5 = size;
                            if ("binding.programCardV2.root" != 0) {
                                Dashboard.PottyProgramCard pottyProgramCard8 = dashboard.getPottyProgramCard();
                                r5 = size;
                                r5 = size;
                            }
                            r5 = size;
                            view6.setVisibility(size);
                            View view7 = binding2.S.w();
                            n.e(view7, size);
                            Dashboard.PottyProgramCard pottyProgramCard6 = dashboard.getPottyProgramCard();
                            r5 = size;
                            if ("binding.programCardV2.root" == 0) {
                                Dashboard.PottyProgramCard pottyProgramCard7 = dashboard.getPottyProgramCard();
                                r5 = size;
                                r5 = size;
                            }
                            r5 = size;
                            view7.setVisibility(size);
                            View view = binding2.O.w();
                            n.e(view, "binding.pottyCheckmarksCard.root");
                            Dashboard.PottyProgramCard pottyProgramCard = dashboard.getPottyProgramCard();
                            int r3 = size;
                            if (DashboardProgram_CardType.RECOMMENDED_PROGRAM_V2 == 0 || !dashboard.getPottyTrackerNewUiEnabled()) {
                            }
                            if (DashboardProgram_CardType.LESSON != 0) {
                            }
                            view.setVisibility(size);
                        } else {
                            if (binding instanceof oi) {
                                binding2 = binding;
                                Dashboard.BitingProgramCard bitingProgramCard4 = dashboard.getBitingProgramCard();
                                if (bitingProgramCard4 == null) {
                                } else {
                                    programDescription2 = bitingProgramCard4.getProgramDescription();
                                }
                                binding2.X(programDescription2);
                                Dashboard.BitingProgramCard bitingProgramCard5 = dashboard.getBitingProgramCard();
                                if (bitingProgramCard5 != null) {
                                    programCompletion = bitingProgramCard5.getProgramCompletion();
                                }
                                binding2.W(programCompletion);
                                binding2.V(callback);
                                Dashboard.BitingProgramCard bitingProgramCard = dashboard.getBitingProgramCard();
                                r5 = size;
                                r5 = size;
                                binding2.w().setVisibility(size);
                                Dashboard.BitingProgramCard bitingProgramCard2 = dashboard.getBitingProgramCard();
                                r5 = size;
                                r5 = size;
                                binding2.O.w().setVisibility(size);
                                bitingProgramCard3 = dashboard.getBitingProgramCard();
                                r4 = size;
                                if (DashboardProgram_CardType.LESSON == 0) {
                                }
                                binding2.P.w().setVisibility(size);
                            } else {
                                if (binding instanceof qi) {
                                    binding2 = binding;
                                    binding2.W(dashboard.getWorkoutSession());
                                    binding2.V(callback);
                                } else {
                                    if (binding instanceof wj) {
                                        binding2 = binding;
                                        binding2.V(callback);
                                        if (!(n.b(dashboard.isDogPremium(), Boolean.TRUE))) {
                                        }
                                        binding2.w().setVisibility(size);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        android.view.ViewGroup.LayoutParams layoutParams = binding.w().getLayoutParams();
        str = "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams";
        Objects.requireNonNull(layoutParams, str);
        if (!z) {
            if (!(binding instanceof ek)) {
                Context context = binding.w().getContext();
                n.e(context, "binding.root.context");
                DashboardBindingAdapters.a.j(layoutParams, context);
            }
        }
    }

    /* renamed from: b, reason: from kotlin metadata */
    private final Map<String, ViewDataBinding> getBindings(ViewGroup parent, List<? extends Dashboard.DashboardCardsEnum> orderList) throws NoWhenBranchMatchedException {
        boolean z;
        int i2 = 0;
        oi oiVar;
        boolean hasNext;
        boolean z3;
        h hVar2 = i.v(x.b(parent), kotlinx.coroutines.n.b.a);
        ArrayList arrayList = new ArrayList(p.r(orderList, 10));
        final Iterator it2 = orderList.iterator();
        while (it2.hasNext()) {
            Object item9 = it2.next();
            str = "inflate(LayoutInflater.from(parent.context), parent, false)";
            boolean z2 = false;
            i2 = 0;
            Iterator it = hVar2.iterator();
            while (it.hasNext()) {
                Object item6 = it.next();
                z3 = (ViewDataBinding)item6 instanceof ek;
                if (item6 instanceof ek) {
                    break loop_5;
                }
            }
            arrayList.add(new Pair(item9.getCardType(), oiVar));
            item6 = it.next();
            z3 = (ViewDataBinding)item6 instanceof ek;
            it = hVar2.iterator();
            while (it.hasNext()) {
                Object item7 = it.next();
                z3 = (ViewDataBinding)item7 instanceof wj;
                if (item7 instanceof wj) {
                    break loop_11;
                }
            }
            item7 = it.next();
            z3 = (ViewDataBinding)item7 instanceof wj;
            it = hVar2.iterator();
            while (it.hasNext()) {
                Object item8 = it.next();
                z3 = (ViewDataBinding)item8 instanceof qi;
                if (item8 instanceof qi) {
                    break loop_17;
                }
            }
            item8 = it.next();
            z3 = (ViewDataBinding)item8 instanceof qi;
            it = hVar2.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                z3 = (ViewDataBinding)item instanceof oi;
                if (item instanceof oi) {
                    break loop_23;
                }
            }
            item = it.next();
            z3 = (ViewDataBinding)item instanceof oi;
            it = hVar2.iterator();
            while (it.hasNext()) {
                Object item2 = it.next();
                z3 = (ViewDataBinding)item2 instanceof ki;
                if (item2 instanceof ki) {
                    break loop_29;
                }
            }
            item2 = it.next();
            z3 = (ViewDataBinding)item2 instanceof ki;
            it = hVar2.iterator();
            while (it.hasNext()) {
                Object item3 = it.next();
                z3 = (ViewDataBinding)item3 instanceof wi;
                if (item3 instanceof wi) {
                    break loop_35;
                }
            }
            item3 = it.next();
            z3 = (ViewDataBinding)item3 instanceof wi;
            it = hVar2.iterator();
            while (it.hasNext()) {
                Object item4 = it.next();
                z3 = (ViewDataBinding)item4 instanceof mi;
                if (item4 instanceof mi) {
                    break loop_41;
                }
            }
            item4 = it.next();
            z3 = (ViewDataBinding)item4 instanceof mi;
            it = hVar2.iterator();
            while (it.hasNext()) {
                Object item5 = it.next();
                z3 = (ViewDataBinding)item5 instanceof ij;
                if (item5 instanceof ij) {
                    break loop_47;
                }
            }
            item5 = it.next();
            z3 = (ViewDataBinding)item5 instanceof ij;
        }
        return j0.s(arrayList);
    }

    public static final void f(LinearLayout linearLayout, y<Dashboard> yVar, o oVar) {
        app.dogo.com.dogo_android.g.n nVar;
        n.f(linearLayout, "<this>");
        z = yVar instanceof LoadResult_Success;
        if (yVar instanceof oadResult_Success && oVar != null) {
            Object component1 = yVar.component1();
            Map bindings = DashboardBindingAdapters.a.getBindings(linearLayout, component1.getCardsOrder());
            Iterator it = bindings.values().iterator();
            while (it.hasNext()) {
                DashboardBindingAdapters.a.configureBinding((ViewDataBinding)it.next(), component1, oVar);
            }
            if (linearLayout.getChildCount() == 0) {
                Iterator it2 = component1.getCardsOrder().iterator();
                while (it2.hasNext()) {
                    linearLayout.addView((ViewDataBinding)j0.i(bindings, (Dashboard_DashboardCardsEnum)it2.next().getCardType()).w());
                }
            }
        }
    }

    /* renamed from: g, reason: from kotlin metadata */
    public static final void setMarginsForDashboardCard(TextView layout, DashboardProgram context) {
        int i = 0;
        Object obj;
        n.f(layout, "<this>");
        if (context == null) {
            i = 0;
        } else {
            ProgramLessonItem lessonItem = context.getLessonItem();
        }
        if (i == 0) {
            i = 2131887140;
            String string = layout.getContext().getString(i);
        } else {
            String programName = context.getLessonItem().getProgramName();
        }
        layout.setText(obj);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final void setDashboardAdapter(TextView result, ProgramExamSummary callback) {
        Integer passedExamsCount = null;
        Integer allExamsCount;
        Object obj;
        n.f(result, "<this>");
        if (callback == null) {
        } else {
            allExamsCount = callback.getAllExamsCount();
        }
        if (callback != null) {
            passedExamsCount = callback.getPassedExamsCount();
        }
        if (n.b(allExamsCount, passedExamsCount)) {
            int i2 = 2131886519;
            String string = result.getContext().getString(i2);
        } else {
            i2 = 2131887709;
            String string2 = result.getContext().getString(i2);
        }
        result.setText(obj);
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final void setTrainingWeekSummary(TextView result, Integer callback) {
        Object obj2;
        long l;
        Object[] arr;
        Object[] arr2;
        int cmp;
        String str4;
        String str5;
        String str6;
        boolean z = false;
        int i4 = 4;
        Object obj = null;
        final Object result2 = result;
        str = "<this>";
        n.f(result2, str);
        if (callback != null) {
            sECONDS2 = TimeUnit.SECONDS;
            long l5 = (long)callback.intValue();
            long hours = sECONDS2.toHours(l5);
            long l4 = sECONDS2.toMinutes(l5) - TimeUnit.HOURS.toMinutes(hours);
            long l3 = 1L;
            l = (long)callback.intValue() % TimeUnit.MINUTES.toSeconds(l3);
            long l2 = 0L;
            str2 = "java.lang.String.format(format, *args)";
            int i = 1;
            int i2 = 0;
            int i3 = 2;
            str3 = "%d:%02d";
            if (hours == l2) {
                arr2 = new Object[i3];
                n.e(String.format(str3, Arrays.copyOf(new Object[] { Long.valueOf(l4), Long.valueOf((long)callback.intValue() % TimeUnit.MINUTES.toSeconds(l3, obj3)) }, i3)), str2);
            } else {
                z = false;
                i4 = 4;
                obj = null;
                str5 = "0";
                str6 = "";
                String str7 = l.G(Utilities.Companion.c(l2, Utilities_TimeUnit.HOURS, v.NARROW), str5, str6, z, i4, obj);
                Objects.requireNonNull(str7, "null cannot be cast to non-null type kotlin.CharSequence");
                arr = new Object[i3];
                n.e(String.format(n.o(str3, l.a1(str7).toString()), Arrays.copyOf(new Object[] { Long.valueOf(hours), Long.valueOf(l4) }, i3)), str2);
            }
            result2.setText(obj2);
        }
    }

    private final void j(LinearLayout.LayoutParams layoutParams, Context context) throws android.content.res.Resources.NotFoundException {
        final int i3 = 2131165626;
        layoutParams.setMarginStart((int)context.getResources().getDimension(i3));
        layoutParams.setMarginEnd((int)context.getResources().getDimension(i3));
        layoutParams.topMargin = (int)context.getResources().getDimension(i3);
    }

    public static final void k(RecyclerView recyclerView, TrainingTimeMetrics trainingTimeMetrics, d0 d0Var) {
        str = "<this>";
        n.f(recyclerView, str);
        if (trainingTimeMetrics != null && d0Var != null) {
            app.dogo.com.dogo_android.g.c0 trainingWeekSummaryAdapter = new TrainingWeekSummaryAdapter(d0Var);
            trainingWeekSummaryAdapter.i(trainingTimeMetrics.getWeekTrainingSummary());
            recyclerView.setAdapter(trainingWeekSummaryAdapter);
            if (recyclerView.getItemDecorationCount() == 0) {
                recyclerView.postDelayed(new kotlinx.coroutines.a(recyclerView), 1L);
            }
        }
    }

    /* renamed from: l, reason: from kotlin metadata */
    private static final void setDashboardExamTitle(RecyclerView examItem) throws android.content.res.Resources.NotFoundException {
        n.f(examItem, "$this_setTrainingWeekSummary");
        examItem.h(new WeekSummaryDecoration(a.b(Math.max((float)(examItem.getWidth() - examItem.getPaddingEnd()) - examItem.getPaddingStart() - (TypedValue.applyDimension(1, 40f, examItem.getResources().getDisplayMetrics())) * (float)7 / 6f, examItem.getResources().getDimension(2131165631)))));
    }

    public static final void m(ViewGroup viewGroup, yi yiVar, TextView textView, d0 d0Var, TrainingTimeMetrics trainingTimeMetrics) {
        int i = 8;
        n.f(viewGroup, "<this>");
        n.f(yiVar, "tooltip");
        n.f(textView, "title");
        i = 8;
        String str2 = "tooltip.root";
        if (trainingTimeMetrics != null) {
            View view = yiVar.w();
            n.e(view, "tooltip.root");
            if (trainingTimeMetrics.isTooltipVisible()) {
                i = 0;
            }
            view.setVisibility(i);
        } else {
            view = yiVar.w();
            n.e(view, "tooltip.root");
            view.setVisibility(8);
        }
        if (d0Var != null) {
            textView.setOnClickListener(new kotlinx.coroutines.c(d0Var, yiVar));
            yiVar.P.setOnClickListener(new kotlinx.coroutines.b(trainingTimeMetrics, d0Var, yiVar));
        }
    }

    private static final void n(d0 d0Var, yi yiVar, View view) {
        n.f(yiVar, "$tooltip");
        d0Var.onTimeMetricTooltipTap(yiVar);
    }

    private static final void o(TrainingTimeMetrics trainingTimeMetrics, d0 d0Var, yi yiVar, View view) {
        str = "$tooltip";
        n.f(yiVar, str);
        if (trainingTimeMetrics != null) {
            trainingTimeMetrics.setTooltipVisible(false);
        }
        d0Var.onToggleMetricTooltipTap(yiVar);
    }


    /* renamed from: c, reason: from kotlin metadata */
    public static /* synthetic */ void setDashboardCardsTitle(RecyclerView item) {
        DashboardBindingAdapters.setDashboardExamTitle(item);
    }

    /* renamed from: d, reason: from kotlin metadata */
    public static /* synthetic */ void setupMetricsTooltip(TrainingTimeMetrics tooltip, d0 title, yi callback, View item) {
        DashboardBindingAdapters.o(tooltip, title, callback, item);
    }

    public static /* synthetic */ void e(d0 d0Var, yi yiVar, View view) {
        DashboardBindingAdapters.n(d0Var, yiVar, view);
    }
}
