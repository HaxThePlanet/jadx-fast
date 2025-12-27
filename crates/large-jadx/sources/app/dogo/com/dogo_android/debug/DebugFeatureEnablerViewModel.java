package app.dogo.com.dogo_android.i;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.e0;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel;
import app.dogo.com.dogo_android.repository.domain.Dashboard.DashboardCardsEnum;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.PottyOverviewCardEnum;
import app.dogo.com.dogo_android.s.b.i1;
import app.dogo.com.dogo_android.s.b.o1;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import i.b.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.d.g;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: DebugFeatureEnablerViewModel.kt */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0015R \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000f0\u000e0\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000f0\u000e0\r0\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureEnablerViewModel;", "Landroidx/lifecycle/ViewModel;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "programContentRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/TricksRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem;", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "updateFeature", "", "key", "", "value", "", "updateList", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l0, reason: from kotlin metadata */
public final class DebugFeatureEnablerViewModel extends e0 {

    /* renamed from: a, reason: from kotlin metadata */
    private final r2 dispatcher;
    /* renamed from: b, reason: from kotlin metadata */
    private final o1 programContentRepository;
    /* renamed from: c, reason: from kotlin metadata */
    private final i1 remoteConfigService;
    private final h0 d;
    /* renamed from: e, reason: from kotlin metadata */
    private final x<y<List<m0>>> tricksRepository;
    private final LiveData<y<List<m0>>> f;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.debug.DebugFeatureEnablerViewModel$updateList$1", f = "DebugFeatureEnablerViewModel.kt", l = 39, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super w>, Object> {

        Object L$0;
        Object L$1;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            List list;
            List list2;
            int i = 0;
            String cardType;
            List list8;
            Object obj = b.d();
            i = 0;
            int i17 = 10;
            int i18 = 1;
            if (this.label != 0) {
                if (this.label != i18) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    app.dogo.com.dogo_android.i.m0[] arr = new m0[22];
                    List list6 = l0.this.dispatcher.l();
                    ArrayList arrayList4 = new ArrayList(p.r(list6, i17));
                    Iterator it2 = list6.iterator();
                    while (it2.hasNext()) {
                        arrayList4.add((SpecialProgramOverviewItem_PottyOverviewCardEnum)it2.next().getCardType());
                    }
                    List list7 = l0.this.dispatcher.q();
                    ArrayList arrayList5 = new ArrayList(p.r(list7, i17));
                    Iterator it3 = list7.iterator();
                    while (it3.hasNext()) {
                        arrayList5.add((SpecialProgramOverviewItem_PottyOverviewCardEnum)it3.next().getCardType());
                    }
                    String str30 = "Workout streaks experiment";
                    cardType2 = "android_photo_like_threshold_for_share";
                    List list5 = l0.this.dispatcher.m();
                    ArrayList arrayList3 = new ArrayList(p.r(list5, i17));
                    Iterator it = list5.iterator();
                    while (it.hasNext()) {
                        arrayList3.add((Dashboard_DashboardCardsEnum)it.next().getCardType());
                    }
                    Dashboard.DashboardCardsEnum[] values = Dashboard_DashboardCardsEnum.values();
                    ArrayList arrayList6 = new ArrayList(values.length);
                    for (Dashboard.DashboardCardsEnum dashboardCardsEnum : values) {
                        arrayList6.add(dashboardCardsEnum.getCardType());
                    }
                    String str5 = "Time metric enabled";
                    l0.this.tricksRepository.postValue(new LoadResult_Success(p.j(new m0[] { new DebugFeatureItem_JsonArrayDebugFeatureItem("Biting cards order", "android_config_biting_order", arrayList4, list), new DebugFeatureItem_JsonArrayDebugFeatureItem("Potty cards order", "android_config_potty_order", arrayList5, list), new DebugFeatureItem_BooleanDebugFeatureItem(str30, "android_config_workout_streaks", l0.this.dispatcher.O()), new DebugFeatureItem_LongDebugFeatureItem("trick count for share popup", "android_trick_threshold_for_share", l0.this.dispatcher.K(), str30), new DebugFeatureItem_LongDebugFeatureItem("Photo Like count for share popup", cardType2, l0.this.dispatcher.y(), str30), new DebugFeatureItem_BooleanDebugFeatureItem("Content Lock", "android_lock_premium_content", l0.this.dispatcher.b0()), new DebugFeatureItem_BooleanDebugFeatureItem("Customer experience Enabled", "android_config_customers_experience_enabled", l0.this.dispatcher.R()), new DebugFeatureItem_StringDebugFeatureItem("Offering Id", "android_config_current_offering_id", l0.this.dispatcher.h()), new DebugFeatureItem_BooleanDebugFeatureItem("Iterable mobile inbox enabled", "android_config_mobile_inbox", l0.this.dispatcher.Y()), new DebugFeatureItem_JsonArrayDebugFeatureItem("Dashboard cards order", "android_config_dashboard_card_order", arrayList3, arrayList6), new DebugFeatureItem_BooleanDebugFeatureItem("New recommended program card enabled", "android_config_recommended_program_new_ui_v2", l0.this.dispatcher.Z()), new DebugFeatureItem_StringDebugFeatureItem("User location code", "location_code", l0.this.dispatcher.v()), new DebugFeatureItem_JsonArrayDebugFeatureItem("Whitelisted program ids", "android_config_program_whitelist", l0.this.dispatcher.M(), (List)list8), new DebugFeatureItem_BooleanDebugFeatureItem("First lesson flow", "android_config_rt_1_lesson_flow", l0.this.dispatcher.W()), new DebugFeatureItem_JsonArrayDebugFeatureItem("Force Image Tricks", "android_config_force_image_trick", l0.this.dispatcher.k(), list2), new DebugFeatureItem_BooleanDebugFeatureItem("Subscription all plans top enabled", "android_config_show_all_plans_top", l0.this.dispatcher.f0()), new DebugFeatureItem_StringDebugFeatureItem("Price per period type", "android_config_price_per", l0.this.dispatcher.H().getTag()), new DebugFeatureItem_BooleanDebugFeatureItem(str5, "android_config_rn_time_metric", l0.this.dispatcher.g0()), new DebugFeatureItem_LongDebugFeatureItem("Metric goal sec", "android_config_rn_time_goal_seconds", (long)l0.this.dispatcher.s(), str5), new DebugFeatureItem_BooleanDebugFeatureItem("Contact Us badge enabled", "android_config_first_time_help_center_red_badge", l0.this.dispatcher.Q()), new DebugFeatureItem_BooleanDebugFeatureItem("Local reminder Disabled", "android_config_iterable_notifications", l0.this.dispatcher.V()), new DebugFeatureItem_BooleanDebugFeatureItem("Potty tracker new UI", "android_config_rt_potty_tracker_ui", l0.this.dispatcher.a0()) })));
                    return w.a;
                }
            }
            q.b(object);
            Object blockingGet = l0.this.programContentRepository.h().blockingGet();
            n.e(blockingGet, "trickItems");
            ArrayList arrayList2 = new ArrayList(p.r(blockingGet, i17));
            Iterator it4 = blockingGet.iterator();
            while (it4.hasNext()) {
                arrayList2.add((TrickModel)it4.next().getId());
            }
            SpecialProgramOverviewItem.PottyOverviewCardEnum[] values2 = SpecialProgramOverviewItem_PottyOverviewCardEnum.values();
            ArrayList arrayList = new ArrayList(values2.length);
            length = values2.length;
            for (SpecialProgramOverviewItem.PottyOverviewCardEnum pottyOverviewCardEnum : values2) {
                arrayList.add(pottyOverviewCardEnum.getCardType());
            }
            this.L$0 = arrayList2;
            this.L$1 = arrayList;
            this.label = i18;
            if (l0.this.remoteConfigService.b(this) == obj) {
                return obj;
            }
        }

        a(d<? super l0.a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.debug.l0.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.debug.l0.a(l0.this, dVar);
        }
    }
    public /* synthetic */ l0(r2 r2Var, o1 o1Var, i1 i1Var, h0 h0Var, int i, g gVar) {
        if (i & 8 != 0) {
            h0Var = Dispatchers.b();
        }
        this(r2Var, o1Var, i1Var, h0Var);
    }

    public static final /* synthetic */ i1 h(l0 l0Var) {
        return l0Var.remoteConfigService;
    }

    public static final /* synthetic */ r2 i(l0 l0Var) {
        return l0Var.dispatcher;
    }

    public static final /* synthetic */ o1 j(l0 l0Var) {
        return l0Var.programContentRepository;
    }

    public static final /* synthetic */ x k(l0 l0Var) {
        return l0Var.tricksRepository;
    }

    @Override // androidx.lifecycle.e0
    public final LiveData<y<List<m0>>> getResult() {
        return this.f;
    }

    @Override // androidx.lifecycle.e0
    /* renamed from: l, reason: from kotlin metadata */
    public final void updateFeature(String key, Object value) {
        n.f(key, "key");
        n.f(value, "value");
        this.dispatcher.a(key, value);
    }

    @Override // androidx.lifecycle.e0
    /* renamed from: m, reason: from kotlin metadata */
    public final void updateList() {
        final d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), this.d, dVar, new app.dogo.com.dogo_android.debug.l0.a(this, dVar), 2, null);
    }

    public l0(r2 r2Var, o1 o1Var, i1 i1Var, h0 h0Var) {
        n.f(r2Var, "remoteConfigService");
        n.f(o1Var, "tricksRepository");
        n.f(i1Var, "programContentRepository");
        n.f(h0Var, "dispatcher");
        super();
        this.dispatcher = r2Var;
        this.programContentRepository = o1Var;
        this.remoteConfigService = i1Var;
        this.d = h0Var;
        final x xVar = new x();
        this.tricksRepository = xVar;
        this.f = xVar;
        updateList();
    }
}
