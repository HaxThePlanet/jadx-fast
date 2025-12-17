package app.dogo.com.dogo_android.i;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.e0;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.k.n;
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
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlin.y.p;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0015R \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000f0\u000e0\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000f0\u000e0\r0\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureEnablerViewModel;", "Landroidx/lifecycle/ViewModel;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "programContentRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/TricksRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem;", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "updateFeature", "", "key", "", "value", "", "updateList", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l0 extends e0 {

    private final r2 a;
    private final o1 b;
    private final i1 c;
    private final h0 d;
    private final x<y<List<app.dogo.com.dogo_android.i.m0>>> e;
    private final LiveData<y<List<app.dogo.com.dogo_android.i.m0>>> f;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.debug.DebugFeatureEnablerViewModel$updateList$1", f = "DebugFeatureEnablerViewModel.kt", l = 39, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        Object L$0;
        Object L$1;
        int label;
        final app.dogo.com.dogo_android.i.l0 this$0;
        a(app.dogo.com.dogo_android.i.l0 l0, d<? super app.dogo.com.dogo_android.i.l0.a> d2) {
            this.this$0 = l0;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (l0.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            l0.a obj2 = new l0.a(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object l$1;
            Object arrayList;
            int i3;
            int i;
            ArrayList arrayList2;
            int length;
            int i2;
            int cardType;
            String cardType4;
            int cardType2;
            int cardType3;
            String cardType5;
            Object obj11;
            Object obj = b.d();
            int label = this.label;
            i3 = 0;
            int i15 = 10;
            int i16 = 1;
            if (label != 0) {
                if (label != i16) {
                } else {
                    l$1 = this.L$1;
                    arrayList = this.L$0;
                    q.b(object);
                    app.dogo.com.dogo_android.i.m0[] arr = new m0[22];
                    List list4 = l0.i(this.this$0).l();
                    ArrayList arrayList4 = new ArrayList(p.r(list4, i15));
                    Iterator iterator2 = list4.iterator();
                    for (SpecialProgramOverviewItem.PottyOverviewCardEnum next6 : iterator2) {
                        arrayList4.add(next6.getCardType());
                    }
                    m0.c cVar5 = new m0.c("Biting cards order", "android_config_biting_order", arrayList4, l$1);
                    arr[i3] = cVar5;
                    List list5 = l0.i(this.this$0).q();
                    ArrayList arrayList5 = new ArrayList(p.r(list5, i15));
                    Iterator iterator3 = list5.iterator();
                    for (SpecialProgramOverviewItem.PottyOverviewCardEnum next8 : iterator3) {
                        arrayList5.add(next8.getCardType());
                    }
                    m0.c cVar6 = new m0.c("Potty cards order", "android_config_potty_order", arrayList5, l$1);
                    arr[i16] = cVar6;
                    String str30 = "Workout streaks experiment";
                    m0.a aVar8 = new m0.a(str30, "android_config_workout_streaks", l0.i(this.this$0).O());
                    arr[2] = aVar8;
                    m0.d dVar2 = new m0.d("trick count for share popup", "android_trick_threshold_for_share", l0.i(this.this$0).K(), str30);
                    arr[3] = dVar2;
                    m0.d dVar3 = new m0.d("Photo Like count for share popup", "android_photo_like_threshold_for_share", l0.i(this.this$0).y(), str30);
                    arr[4] = dVar3;
                    m0.a aVar9 = new m0.a("Content Lock", "android_lock_premium_content", l0.i(this.this$0).b0());
                    arr[5] = aVar9;
                    m0.a aVar10 = new m0.a("Customer experience Enabled", "android_config_customers_experience_enabled", l0.i(this.this$0).R());
                    arr[6] = aVar10;
                    m0.e eVar3 = new m0.e("Offering Id", "android_config_current_offering_id", l0.i(this.this$0).h());
                    arr[7] = eVar3;
                    m0.a aVar11 = new m0.a("Iterable mobile inbox enabled", "android_config_mobile_inbox", l0.i(this.this$0).Y());
                    arr[8] = aVar11;
                    List list3 = l0.i(this.this$0).m();
                    ArrayList arrayList3 = new ArrayList(p.r(list3, i15));
                    Iterator iterator = list3.iterator();
                    for (Dashboard.DashboardCardsEnum next4 : iterator) {
                        arrayList3.add(next4.getCardType());
                    }
                    Dashboard.DashboardCardsEnum[] values = Dashboard.DashboardCardsEnum.values();
                    ArrayList arrayList6 = new ArrayList(values.length);
                    while (i3 < values.length) {
                        arrayList6.add(values[i3].getCardType());
                        i3++;
                    }
                    m0.c cVar3 = new m0.c("Dashboard cards order", "android_config_dashboard_card_order", arrayList3, arrayList6);
                    arr[9] = cVar3;
                    m0.a aVar = new m0.a("New recommended program card enabled", "android_config_recommended_program_new_ui_v2", l0.i(this.this$0).Z());
                    arr[i15] = aVar;
                    m0.e eVar2 = new m0.e("User location code", "location_code", l0.i(this.this$0).v());
                    arr[11] = eVar2;
                    m0.c cVar4 = new m0.c("Whitelisted program ids", "android_config_program_whitelist", l0.i(this.this$0).M(), (List)obj11);
                    arr[12] = cVar4;
                    m0.a aVar2 = new m0.a("First lesson flow", "android_config_rt_1_lesson_flow", l0.i(this.this$0).W());
                    arr[13] = aVar2;
                    m0.c cVar = new m0.c("Force Image Tricks", "android_config_force_image_trick", l0.i(this.this$0).k(), arrayList);
                    arr[14] = cVar;
                    m0.a aVar3 = new m0.a("Subscription all plans top enabled", "android_config_show_all_plans_top", l0.i(this.this$0).f0());
                    arr[15] = aVar3;
                    m0.e eVar = new m0.e("Price per period type", "android_config_price_per", l0.i(this.this$0).H().getTag());
                    arr[16] = eVar;
                    String str5 = "Time metric enabled";
                    m0.a aVar4 = new m0.a(str5, "android_config_rn_time_metric", l0.i(this.this$0).g0());
                    arr[17] = aVar4;
                    m0.d dVar = new m0.d("Metric goal sec", "android_config_rn_time_goal_seconds", (long)i14, str5);
                    arr[18] = dVar;
                    m0.a aVar5 = new m0.a("Contact Us badge enabled", "android_config_first_time_help_center_red_badge", l0.i(this.this$0).Q());
                    arr[19] = aVar5;
                    m0.a aVar6 = new m0.a("Local reminder Disabled", "android_config_iterable_notifications", l0.i(this.this$0).V());
                    arr[20] = aVar6;
                    m0.a aVar7 = new m0.a("Potty tracker new UI", "android_config_rt_potty_tracker_ui", l0.i(this.this$0).a0());
                    arr[21] = aVar7;
                    y.c cVar2 = new y.c(p.j(arr));
                    l0.k(this.this$0).postValue(cVar2);
                    return w.a;
                }
                obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj11;
            }
            q.b(object);
            obj11 = l0.j(this.this$0).h().blockingGet();
            n.e((List)obj11, "trickItems");
            arrayList = new ArrayList(p.r(obj11, i15));
            obj11 = obj11.iterator();
            for (TrickModel next2 : obj11) {
                arrayList.add(next2.getId());
            }
            obj11 = SpecialProgramOverviewItem.PottyOverviewCardEnum.values();
            arrayList2 = new ArrayList(obj11.length);
            i2 = i3;
            while (i2 < obj11.length) {
                arrayList2.add(obj11[i2].getCardType());
                i2++;
            }
            this.L$0 = arrayList;
            this.L$1 = arrayList2;
            this.label = i16;
            if (l0.h(this.this$0).b(this) == obj) {
                return obj;
            }
            l$1 = arrayList2;
        }
    }
    public l0(r2 r2, o1 o12, i1 i13, h0 h04) {
        n.f(r2, "remoteConfigService");
        n.f(o12, "tricksRepository");
        n.f(i13, "programContentRepository");
        n.f(h04, "dispatcher");
        super();
        this.a = r2;
        this.b = o12;
        this.c = i13;
        this.d = h04;
        x obj2 = new x();
        this.e = obj2;
        this.f = obj2;
        m();
    }

    public l0(r2 r2, o1 o12, i1 i13, h0 h04, int i5, g g6) {
        h0 obj4;
        if (i5 &= 8 != 0) {
            obj4 = c1.b();
        }
        super(r2, o12, i13, obj4);
    }

    public static final i1 h(app.dogo.com.dogo_android.i.l0 l0) {
        return l0.c;
    }

    public static final r2 i(app.dogo.com.dogo_android.i.l0 l0) {
        return l0.a;
    }

    public static final o1 j(app.dogo.com.dogo_android.i.l0 l0) {
        return l0.b;
    }

    public static final x k(app.dogo.com.dogo_android.i.l0 l0) {
        return l0.e;
    }

    public final LiveData<y<List<app.dogo.com.dogo_android.i.m0>>> getResult() {
        return this.f;
    }

    @Override // androidx.lifecycle.e0
    public final void l(String string, Object object2) {
        n.f(string, "key");
        n.f(object2, "value");
        this.a.a(string, object2);
    }

    @Override // androidx.lifecycle.e0
    public final void m() {
        final int i = 0;
        l0.a aVar = new l0.a(this, i);
        k.d(f0.a(this), this.d, i, aVar, 2, 0);
    }
}
