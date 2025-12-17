package app.dogo.com.dogo_android.g;

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
import kotlin.d0.c.l;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.e0.a;
import kotlin.j0.h;
import kotlin.j0.i;
import kotlin.k0.l;
import kotlin.o;
import kotlin.w;
import kotlin.y.j0;
import kotlin.y.p;
import net.time4j.g1.v;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0002J*\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\u000c2\u0006\u0010\u000e\u001a\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J&\u0010\u0018\u001a\u00020\u0004*\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u001b2\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u0016\u0010\u001c\u001a\u00020\u0004*\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u0016\u0010 \u001a\u00020\u0004*\u00020\u001d2\u0008\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u001b\u0010#\u001a\u00020\u0004*\u00020\u001d2\u0008\u0010$\u001a\u0004\u0018\u00010%H\u0007¢\u0006\u0002\u0010&J \u0010'\u001a\u00020\u0004*\u00020(2\u0008\u0010\u001a\u001a\u0004\u0018\u00010)2\u0008\u0010\t\u001a\u0004\u0018\u00010*H\u0007J0\u0010+\u001a\u00020\u0004*\u00020\u000f2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001d2\u0008\u0010\t\u001a\u0004\u0018\u00010*2\u0008\u0010\u001e\u001a\u0004\u0018\u00010)H\u0007¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/dashboard/DashboardBindingAdapters;", "", "()V", "configureBinding", "", "binding", "Landroidx/databinding/ViewDataBinding;", "dashboard", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard;", "callback", "Lapp/dogo/com/dogo_android/dashboard/DashboardCallback;", "getBindings", "", "", "parent", "Landroid/view/ViewGroup;", "orderList", "", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard$DashboardCardsEnum;", "setMarginsForDashboardCard", "layout", "Landroid/widget/LinearLayout$LayoutParams;", "context", "Landroid/content/Context;", "setDashboardAdapter", "Landroid/widget/LinearLayout;", "result", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "setDashboardCardsTitle", "Landroid/widget/TextView;", "item", "Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram;", "setDashboardExamTitle", "examItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "setDashboardTrainingTimeText", "durationSec", "", "(Landroid/widget/TextView;Ljava/lang/Integer;)V", "setTrainingWeekSummary", "Landroidx/recyclerview/widget/RecyclerView;", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "Lapp/dogo/com/dogo_android/dashboard/TrainingWeekSummaryCallback;", "setupMetricsTooltip", "tooltip", "Lapp/dogo/com/dogo_android/databinding/LayoutDashboardMetricTooltipBinding;", "title", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class n {

    public static final app.dogo.com.dogo_android.g.n a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[Dashboard.DashboardCardsEnum.RECENT.ordinal()] = 1;
            iArr[Dashboard.DashboardCardsEnum.PROGRAM.ordinal()] = 2;
            iArr[Dashboard.DashboardCardsEnum.EXAM.ordinal()] = 3;
            iArr[Dashboard.DashboardCardsEnum.POTTY.ordinal()] = 4;
            iArr[Dashboard.DashboardCardsEnum.BITING.ordinal()] = 5;
            iArr[Dashboard.DashboardCardsEnum.WORKOUT.ordinal()] = 6;
            iArr[Dashboard.DashboardCardsEnum.SUBSCRIPTION.ordinal()] = 7;
            iArr[Dashboard.DashboardCardsEnum.TRAINING_TIME_SUMMARY.ordinal()] = 8;
            n.a.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "Landroidx/databinding/ViewDataBinding;", "it", "Landroid/view/View;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<View, ViewDataBinding> {

        public static final app.dogo.com.dogo_android.g.n.b a;
        static {
            n.b bVar = new n.b();
            n.b.a = bVar;
        }

        b() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final ViewDataBinding a(View view) {
            n.f(view, "it");
            return f.d(view);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((View)object);
        }
    }
    static {
        n nVar = new n();
        n.a = nVar;
    }

    private final void a(ViewDataBinding viewDataBinding, Dashboard dashboard2, app.dogo.com.dogo_android.g.o o3) {
        boolean str;
        int i12;
        Object tRUE;
        Dashboard.PottyProgramCard pottyProgramCard7;
        int recentlyViewed;
        int i15;
        int i7;
        int i14;
        TrainingTimeMetrics programExamSummary;
        int i6;
        int i9;
        int i8;
        Dashboard.PottyProgramCard pottyProgramCard8;
        int i2;
        int i10;
        Dashboard.PottyProgramCard pottyProgramCard4;
        int pottyTrackerNewUiEnabled2;
        int i;
        int i5;
        int pottyTrackerNewUiEnabled;
        Dashboard.PottyProgramCard pottyProgramCard3;
        int i11;
        Dashboard.PottyProgramCard pottyProgramCard6;
        Dashboard.PottyProgramCard pottyProgramCard2;
        Dashboard.PottyProgramCard pottyProgramCard;
        Dashboard.PottyProgramCard pottyProgramCard5;
        Dashboard.BitingProgramCard bitingProgramCard3;
        int i4;
        int i13;
        int i3;
        Dashboard.BitingProgramCard bitingProgramCard;
        Object bitingProgramCard2;
        app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescription2;
        app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescription;
        Object obj8;
        TrainingTimeMetrics obj9;
        Object obj10;
        str = viewDataBinding instanceof ij;
        i12 = 8;
        final int i16 = 0;
        if (str != null) {
            tRUE = viewDataBinding;
            (ij)tRUE.W(dashboard2.getRecentlyViewed());
            tRUE.V(o3);
            obj9 = dashboard2.getRecentlyViewed();
            if (obj9 == null) {
                obj9 = i16;
            } else {
            }
            if (obj9 > 0) {
                i12 = i16;
            }
            tRUE.w().setVisibility(i12);
        } else {
            recentlyViewed = 1;
            if (viewDataBinding instanceof ek) {
                tRUE = viewDataBinding;
                (ek)tRUE.W(dashboard2.getTrainingMetrics());
                tRUE.V(o3);
                obj9 = dashboard2.getTrainingMetrics();
                if (obj9 == null) {
                    recentlyViewed = i16;
                } else {
                }
                if (recentlyViewed != 0) {
                    i12 = i16;
                }
                tRUE.w().setVisibility(i12);
            } else {
                if (viewDataBinding instanceof mi) {
                    tRUE = viewDataBinding;
                    (mi)tRUE.W(dashboard2.getProgramItem());
                    tRUE.V(o3);
                    obj9 = dashboard2.getProgramItem();
                    if (obj9 == null) {
                    } else {
                        obj9 = obj9.getType();
                        if (obj9 == null) {
                        } else {
                            i15 = obj9 == DashboardProgram.CardType.QUESTIONNAIRE ? i16 : i12;
                            tRUE.S.w().setVisibility(i15);
                            i7 = obj9 == DashboardProgram.CardType.PROGRAM_COMPLETED ? i16 : i12;
                            tRUE.O.w().setVisibility(i7);
                            i14 = obj9 == DashboardProgram.CardType.RECOMMENDED_PROGRAM ? i16 : i12;
                            tRUE.P.w().setVisibility(i14);
                            recentlyViewed = obj9 == DashboardProgram.CardType.LESSON ? i16 : i12;
                            tRUE.R.w().setVisibility(recentlyViewed);
                            if (obj9 == DashboardProgram.CardType.RECOMMENDED_PROGRAM_V2) {
                                i12 = i16;
                            }
                            tRUE.Q.w().setVisibility(i12);
                        }
                    }
                } else {
                    programExamSummary = 0;
                    if (viewDataBinding instanceof wi) {
                        tRUE = viewDataBinding;
                        recentlyViewed = dashboard2.getProgramItem();
                        if (recentlyViewed == null) {
                        } else {
                            programExamSummary = recentlyViewed.getProgramExamSummary();
                        }
                        (wi)tRUE.W(programExamSummary);
                        tRUE.V(o3);
                        if (dashboard2.isExamCardVisible()) {
                            i12 = i16;
                        }
                        tRUE.w().setVisibility(i12);
                    } else {
                        if (viewDataBinding instanceof ki) {
                            Object obj = viewDataBinding;
                            Dashboard.PottyProgramCard pottyProgramCard9 = dashboard2.getPottyProgramCard();
                            if (pottyProgramCard9 == null) {
                                programDescription2 = programExamSummary;
                            } else {
                                programDescription2 = pottyProgramCard9.getProgramDescription();
                            }
                            (ki)obj.X(programDescription2);
                            bitingProgramCard2 = dashboard2.getPottyProgramCard();
                            if (bitingProgramCard2 == null) {
                            } else {
                                programExamSummary = bitingProgramCard2.getProgramProgress();
                            }
                            obj.Y(programExamSummary);
                            obj.V(o3);
                            obj.W(dashboard2.getPottyCheckmarks());
                            pottyProgramCard5 = dashboard2.getPottyProgramCard();
                            if (pottyProgramCard5 == null) {
                                i6 = i16;
                            } else {
                            }
                            i9 = i6 != 0 ? i16 : i12;
                            obj.w().setVisibility(i9);
                            obj10 = obj.P.w();
                            n.e(obj10, "binding.programCard.root");
                            pottyProgramCard = dashboard2.getPottyProgramCard();
                            if (pottyProgramCard == null) {
                                i8 = i16;
                            } else {
                            }
                            if (i8 != 0) {
                                pottyProgramCard8 = dashboard2.getPottyProgramCard();
                                if (pottyProgramCard8 == null) {
                                    i8 = i16;
                                } else {
                                }
                                i2 = i8 != 0 ? recentlyViewed : i16;
                            } else {
                            }
                            i10 = i2 != 0 ? i16 : i12;
                            obj10.setVisibility(i10);
                            obj10 = obj.Q.w();
                            n.e(obj10, "binding.programCardV2.root");
                            pottyProgramCard4 = dashboard2.getPottyProgramCard();
                            if (pottyProgramCard4 == null) {
                                pottyTrackerNewUiEnabled2 = i16;
                            } else {
                            }
                            if (pottyTrackerNewUiEnabled2 != 0) {
                                pottyProgramCard2 = dashboard2.getPottyProgramCard();
                                if (pottyProgramCard2 == null) {
                                    pottyTrackerNewUiEnabled2 = i16;
                                } else {
                                }
                                if (pottyTrackerNewUiEnabled2 != 0 && dashboard2.getPottyTrackerNewUiEnabled()) {
                                    i = dashboard2.getPottyTrackerNewUiEnabled() ? recentlyViewed : i16;
                                } else {
                                }
                            } else {
                            }
                            i5 = i != 0 ? i16 : i12;
                            obj10.setVisibility(i5);
                            obj10 = obj.S.w();
                            n.e(obj10, "binding.scheduleCard.root");
                            pottyProgramCard6 = dashboard2.getPottyProgramCard();
                            if (pottyProgramCard6 == null) {
                                pottyTrackerNewUiEnabled = i16;
                            } else {
                            }
                            if (pottyTrackerNewUiEnabled == 0) {
                                pottyProgramCard3 = dashboard2.getPottyProgramCard();
                                if (pottyProgramCard3 == null) {
                                    pottyTrackerNewUiEnabled = i16;
                                } else {
                                }
                                if (pottyTrackerNewUiEnabled != 0 && !dashboard2.getPottyTrackerNewUiEnabled()) {
                                    i11 = !dashboard2.getPottyTrackerNewUiEnabled() ? recentlyViewed : i16;
                                } else {
                                }
                            } else {
                            }
                            programExamSummary = i11 != 0 ? i16 : i12;
                            obj10.setVisibility(programExamSummary);
                            obj10 = obj.O.w();
                            n.e(obj10, "binding.pottyCheckmarksCard.root");
                            pottyProgramCard7 = dashboard2.getPottyProgramCard();
                            if (pottyProgramCard7 == null) {
                                tRUE = i16;
                            } else {
                            }
                            if (tRUE != 0 && dashboard2.getPottyTrackerNewUiEnabled()) {
                                if (dashboard2.getPottyTrackerNewUiEnabled()) {
                                } else {
                                    recentlyViewed = i16;
                                }
                            } else {
                            }
                            if (recentlyViewed != 0) {
                                i12 = i16;
                            }
                            obj10.setVisibility(i12);
                        } else {
                            if (viewDataBinding instanceof oi) {
                                tRUE = viewDataBinding;
                                Dashboard.BitingProgramCard bitingProgramCard4 = dashboard2.getBitingProgramCard();
                                if (bitingProgramCard4 == null) {
                                    programDescription = programExamSummary;
                                } else {
                                    programDescription = bitingProgramCard4.getProgramDescription();
                                }
                                (oi)tRUE.X(programDescription);
                                bitingProgramCard2 = dashboard2.getBitingProgramCard();
                                if (bitingProgramCard2 == null) {
                                } else {
                                    programExamSummary = bitingProgramCard2.getProgramCompletion();
                                }
                                tRUE.W(programExamSummary);
                                tRUE.V(o3);
                                bitingProgramCard3 = dashboard2.getBitingProgramCard();
                                if (bitingProgramCard3 == null) {
                                    i4 = i16;
                                } else {
                                }
                                i13 = i4 != 0 ? i16 : i12;
                                tRUE.w().setVisibility(i13);
                                bitingProgramCard = dashboard2.getBitingProgramCard();
                                if (bitingProgramCard == null) {
                                    i3 = i16;
                                } else {
                                }
                                programExamSummary = i3 != 0 ? i16 : i12;
                                tRUE.O.w().setVisibility(programExamSummary);
                                obj9 = dashboard2.getBitingProgramCard();
                                if (obj9 == null) {
                                    recentlyViewed = i16;
                                } else {
                                }
                                if (recentlyViewed != 0) {
                                } else {
                                    i12 = i16;
                                }
                                tRUE.P.w().setVisibility(i12);
                            } else {
                                if (viewDataBinding instanceof qi) {
                                    i12 = viewDataBinding;
                                    (qi)i12.W(dashboard2.getWorkoutSession());
                                    i12.V(o3);
                                } else {
                                    if (viewDataBinding instanceof wj) {
                                        Object obj2 = viewDataBinding;
                                        (wj)obj2.V(o3);
                                        if (n.b(dashboard2.isDogPremium(), Boolean.TRUE)) {
                                        } else {
                                            i12 = i16;
                                        }
                                        obj2.w().setVisibility(i12);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        obj9 = viewDataBinding.w().getLayoutParams();
        Objects.requireNonNull(obj9, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        if (str == null && !viewDataBinding instanceof ek) {
            if (!viewDataBinding instanceof ek) {
                obj8 = viewDataBinding.w().getContext();
                n.e(obj8, "binding.root.context");
                n.a.j((LinearLayout.LayoutParams)obj9, obj8);
            }
        }
    }

    private final Map<String, ViewDataBinding> b(ViewGroup viewGroup, List<? extends Dashboard.DashboardCardsEnum> list2) {
        int i;
        int cardType;
        o oVar;
        Object iterator;
        String str;
        int i3;
        int i2;
        boolean next;
        boolean z;
        h hVar2 = i.v(x.b(viewGroup), n.b.a);
        ArrayList arrayList = new ArrayList(p.r(list2, 10));
        final Iterator obj11 = list2.iterator();
        for (Dashboard.DashboardCardsEnum next3 : obj11) {
            str = "inflate(LayoutInflater.from(parent.context), parent, false)";
            i3 = 0;
            i2 = 0;
            iterator = hVar2.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (obj6 instanceof ek) {
                    break loop_5;
                } else {
                }
            }
            if ((ViewDataBinding)i2 == 0) {
            }
            oVar = new o(next3.getCardType(), i2);
            arrayList.add(oVar);
            n.e(ek.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, i3), str);
            next = iterator.next();
            if (obj6 instanceof ek) {
            } else {
            }
            i2 = next;
            iterator = hVar2.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (obj7 instanceof wj) {
                    break loop_11;
                } else {
                }
            }
            if ((ViewDataBinding)i2 == 0) {
            }
            n.e(wj.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, i3), str);
            next = iterator.next();
            if (obj7 instanceof wj) {
            } else {
            }
            i2 = next;
            iterator = hVar2.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (obj8 instanceof qi) {
                    break loop_17;
                } else {
                }
            }
            if ((ViewDataBinding)i2 == 0) {
            }
            n.e(qi.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, i3), str);
            next = iterator.next();
            if (obj8 instanceof qi) {
            } else {
            }
            i2 = next;
            iterator = hVar2.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (obj instanceof oi) {
                    break loop_23;
                } else {
                }
            }
            if ((ViewDataBinding)i2 == 0) {
            }
            n.e(oi.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, i3), str);
            next = iterator.next();
            if (obj instanceof oi) {
            } else {
            }
            i2 = next;
            iterator = hVar2.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (obj2 instanceof ki) {
                    break loop_29;
                } else {
                }
            }
            if ((ViewDataBinding)i2 == 0) {
            }
            n.e(ki.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, i3), str);
            next = iterator.next();
            if (obj2 instanceof ki) {
            } else {
            }
            i2 = next;
            iterator = hVar2.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (obj3 instanceof wi) {
                    break loop_35;
                } else {
                }
            }
            if ((ViewDataBinding)i2 == 0) {
            }
            n.e(wi.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, i3), str);
            next = iterator.next();
            if (obj3 instanceof wi) {
            } else {
            }
            i2 = next;
            iterator = hVar2.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (obj4 instanceof mi) {
                    break loop_41;
                } else {
                }
            }
            if ((ViewDataBinding)i2 == 0) {
            }
            n.e(mi.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, i3), str);
            next = iterator.next();
            if (obj4 instanceof mi) {
            } else {
            }
            i2 = next;
            iterator = hVar2.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (obj5 instanceof ij) {
                    break loop_47;
                } else {
                }
            }
            if ((ViewDataBinding)i2 == 0) {
            }
            n.e(ij.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, i3), str);
            next = iterator.next();
            if (obj5 instanceof ij) {
            } else {
            }
            i2 = next;
        }
        return j0.s(arrayList);
    }

    public static void c(RecyclerView recyclerView) {
        n.l(recyclerView);
    }

    public static void d(TrainingTimeMetrics trainingTimeMetrics, app.dogo.com.dogo_android.g.d0 d02, yi yi3, View view4) {
        n.o(trainingTimeMetrics, d02, yi3, view4);
    }

    public static void e(app.dogo.com.dogo_android.g.d0 d0, yi yi2, View view3) {
        n.n(d0, yi2, view3);
    }

    public static final void f(LinearLayout linearLayout, y<Dashboard> y2, app.dogo.com.dogo_android.g.o o3) {
        boolean z;
        Iterator iterator;
        boolean next;
        app.dogo.com.dogo_android.g.n nVar;
        Object obj5;
        app.dogo.com.dogo_android.g.o obj6;
        n.f(linearLayout, "<this>");
        if (y2 instanceof y.c && o3 != null) {
            if (o3 != null) {
                obj5 = (y.c)y2.a();
                z = n.a.b(linearLayout, (Dashboard)obj5.getCardsOrder());
                iterator = z.values().iterator();
                for (ViewDataBinding next : iterator) {
                    n.a.a(next, obj5, o3);
                }
                if (linearLayout.getChildCount() == 0) {
                    obj5 = obj5.getCardsOrder().iterator();
                    for (Dashboard.DashboardCardsEnum obj6 : obj5) {
                        linearLayout.addView((ViewDataBinding)j0.i(z, obj6.getCardType()).w());
                    }
                }
            }
        }
    }

    public static final void g(TextView textView, DashboardProgram dashboardProgram2) {
        int lessonItem;
        String obj2;
        n.f(textView, "<this>");
        if (dashboardProgram2 == null) {
            lessonItem = 0;
        } else {
            lessonItem = dashboardProgram2.getLessonItem();
        }
        if (lessonItem == 0) {
            obj2 = textView.getContext().getString(2131887140);
        } else {
            obj2 = dashboardProgram2.getLessonItem().getProgramName();
        }
        textView.setText(obj2);
    }

    public static final void h(TextView textView, ProgramExamSummary programExamSummary2) {
        Integer passedExamsCount;
        int i;
        Integer allExamsCount;
        String obj3;
        n.f(textView, "<this>");
        if (programExamSummary2 == null) {
            allExamsCount = passedExamsCount;
        } else {
            allExamsCount = programExamSummary2.getAllExamsCount();
        }
        if (programExamSummary2 == null) {
        } else {
            passedExamsCount = programExamSummary2.getPassedExamsCount();
        }
        if (n.b(allExamsCount, passedExamsCount)) {
            obj3 = textView.getContext().getString(2131886519);
        } else {
            obj3 = textView.getContext().getString(2131887709);
        }
        textView.setText(obj3);
    }

    public static final void i(TextView textView, Integer integer2) {
        String format;
        TimeUnit sECONDS;
        int i2;
        long arr;
        Object[] valueOf;
        int i7;
        int i4;
        int nARROW;
        String str5;
        int i;
        int i3;
        int i9;
        String str3;
        String str4;
        String str2;
        String str;
        int i5;
        int i8;
        int i6;
        final Object obj = textView;
        n.f(obj, "<this>");
        if (integer2 == null) {
        } else {
            sECONDS = TimeUnit.SECONDS;
            long l = (long)intValue;
            long hours = sECONDS.toHours(l);
            minutes -= minutes2;
            i4 = 1;
            i7 = 0;
            str5 = "java.lang.String.format(format, *args)";
            i = 1;
            i3 = 0;
            i9 = 2;
            str3 = "%d:%02d";
            if (Long.compare(hours, i7) == 0) {
                f0 f0Var2 = f0.a;
                valueOf = new Object[i9];
                valueOf[i3] = Long.valueOf(i10);
                valueOf[i] = Long.valueOf(l2 %= seconds);
                n.e(String.format(str3, Arrays.copyOf(valueOf, i9)), str5);
            } else {
                String str6 = l.G(v2.Companion.c(i7, i4, v2.b.HOURS), "0", "", false, 4, 0);
                Objects.requireNonNull(str6, "null cannot be cast to non-null type kotlin.CharSequence");
                f0 f0Var = f0.a;
                arr = new Object[i9];
                arr[i3] = Long.valueOf(hours);
                arr[i] = Long.valueOf(i10);
                n.e(String.format(n.o(str3, l.a1(str6).toString()), Arrays.copyOf(arr, i9)), str5);
            }
            obj.setText(format);
        }
    }

    private final void j(LinearLayout.LayoutParams linearLayout$LayoutParams, Context context2) {
        final int i3 = 2131165626;
        layoutParams.setMarginStart((int)dimension);
        layoutParams.setMarginEnd((int)dimension2);
        layoutParams.topMargin = (int)obj4;
    }

    public static final void k(RecyclerView recyclerView, TrainingTimeMetrics trainingTimeMetrics2, app.dogo.com.dogo_android.g.d0 d03) {
        String c0Var;
        int obj3;
        n.f(recyclerView, "<this>");
        c0Var = new c0(d03);
        c0Var.i(trainingTimeMetrics2.getWeekTrainingSummary());
        obj3 = w.a;
        recyclerView.setAdapter(c0Var);
        if (trainingTimeMetrics2 != 0 && d03 != null && recyclerView.getItemDecorationCount() == 0) {
            if (d03 != null) {
                c0Var = new c0(d03);
                c0Var.i(trainingTimeMetrics2.getWeekTrainingSummary());
                obj3 = w.a;
                recyclerView.setAdapter(c0Var);
                if (recyclerView.getItemDecorationCount() == 0) {
                    obj3 = new a(recyclerView);
                    recyclerView.postDelayed(obj3, 1);
                }
            }
        }
    }

    private static final void l(RecyclerView recyclerView) {
        n.f(recyclerView, "$this_setTrainingWeekSummary");
        z zVar = new z(a.b(Math.max(i3 /= i7, recyclerView.getResources().getDimension(2131165631))));
        recyclerView.h(zVar);
    }

    public static final void m(ViewGroup viewGroup, yi yi2, TextView textView3, app.dogo.com.dogo_android.g.d0 d04, TrainingTimeMetrics trainingTimeMetrics5) {
        boolean tooltipVisible;
        View view;
        int obj2;
        Object obj4;
        n.f(viewGroup, "<this>");
        n.f(yi2, "tooltip");
        n.f(textView3, "title");
        tooltipVisible = "tooltip.root";
        if (trainingTimeMetrics5 != null) {
            view = yi2.w();
            n.e(view, tooltipVisible);
            if (trainingTimeMetrics5.isTooltipVisible()) {
                obj2 = 0;
            }
            view.setVisibility(obj2);
        } else {
            view = yi2.w();
            n.e(view, tooltipVisible);
            view.setVisibility(8);
        }
        if (d04 == null) {
        } else {
            obj2 = new c(d04, yi2);
            textView3.setOnClickListener(obj2);
            obj4 = new b(trainingTimeMetrics5, d04, yi2);
            yi2.P.setOnClickListener(obj4);
        }
    }

    private static final void n(app.dogo.com.dogo_android.g.d0 d0, yi yi2, View view3) {
        n.f(yi2, "$tooltip");
        d0.l0(yi2);
    }

    private static final void o(TrainingTimeMetrics trainingTimeMetrics, app.dogo.com.dogo_android.g.d0 d02, yi yi3, View view4) {
        String obj3;
        n.f(yi3, "$tooltip");
        if (trainingTimeMetrics == null) {
        } else {
            trainingTimeMetrics.setTooltipVisible(false);
        }
        d02.u0(yi3);
    }
}
