package app.dogo.com.dogo_android.u.n.p;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.m1;
import app.dogo.com.dogo_android.repository.domain.DogLog;
import app.dogo.com.dogo_android.util.customview.DogLogView;
import app.dogo.com.dogo_android.util.customview.DogLogView.a;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.t;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;

/* compiled from: DogLogCalendarAdapter.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0003\u001d\u001e\u001fB\u0011\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0013J\u0008\u0010\u0014\u001a\u00020\u0013H\u0016J\u0006\u0010\u0015\u001a\u00020\u0013J\u001c\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$Callback;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$Callback;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$CalendarCellItem;", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "items$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItem", "position", "", "getItemCount", "getTodayItemPosition", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "CalendarCellItem", "Callback", "DefaultViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public final class DogLogCalendarAdapter extends RecyclerView.h<g.c> implements app.dogo.com.dogo_android.util.d0.a {

    static final /* synthetic */ l<Object>[] c;
    /* renamed from: a, reason: from kotlin metadata */
    private final g.b callbacks;
    private final c b;

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u000f\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bHÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000c\u0010 \u001a\u0008\u0012\u0004\u0012\u00020!0\u000bJ\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u000fR\u0017\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u000f¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$CalendarCellItem;", "", "isToday", "", "dayOfMonth", "", "month", "weekday", "dayStartTimeMs", "", "tags", "", "Lapp/dogo/com/dogo_android/repository/domain/DogLog;", "(ZIIIJLjava/util/List;)V", "getDayOfMonth", "()I", "getDayStartTimeMs", "()J", "()Z", "getMonth", "getTags", "()Ljava/util/List;", "getWeekday", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "getCalendarTags", "Lapp/dogo/com/dogo_android/util/customview/DogLogView$CalendarTag;", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {

        private final boolean a;
        private final int b;
        private final int c;
        /* renamed from: d, reason: from kotlin metadata */
        private final int month;
        private final long e;
        private final List<DogLog> f;
        public a(boolean z, int i, int i2, int i3, long j, List<DogLog> list) {
            n.f(list, "tags");
            super();
            this.a = z;
            this.b = i;
            this.c = i2;
            this.month = i3;
            this.e = j;
            this.f = list;
        }

        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public final List<DogLogView.a> component1() {
            final ArrayList arrayList = new ArrayList(p.r(this.f, 10));
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                l = item.getEventTimeMs() - c();
                app.dogo.com.dogo_android.util.customview.DogLogView.a.b bVar = null;
                arrayList.add(new DogLogView_CalendarTag(l, r5, bVar, item.getStyle()));
            }
            return arrayList;
        }

        public final int b() {
            return this.b;
        }

        public final long c() {
            return this.e;
        }

        public final int d() {
            return this.c;
        }

        public final List<DogLog> e() {
            return this.f;
        }

        public final int f() {
            return this.month;
        }

        public final boolean g() {
            return this.a;
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z4 = false;
            if (!(other instanceof DogLogCalendarAdapter_CalendarCellItem)) {
                return false;
            }
            if (this.a != other.a) {
                return false;
            }
            if (this.b != other.b) {
                return false;
            }
            if (this.c != other.c) {
                return false;
            }
            if (this.month != other.month) {
                return false;
            }
            if (this.e != other.e) {
                return false;
            }
            return !n.b(this.f, other.f) ? z4 : z;
        }

        public int hashCode() {
            boolean z = true;
            if (this.a) {
                int i11 = 1;
            }
            return (z * 31) + Integer.hashCode(this.b) * 31 + Integer.hashCode(this.c) * 31 + Integer.hashCode(this.month) * 31 + Long.hashCode(this.e) * 31 + this.f.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "CalendarCellItem(isToday=";
            String str3 = ", dayOfMonth=";
            String str4 = ", month=";
            String str5 = ", weekday=";
            String str6 = ", dayStartTimeMs=";
            String str7 = ", tags=";
            str = str2 + this.a + str3 + this.b + str4 + this.c + str5 + this.month + str6 + this.e + str7 + this.f + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008H&¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$Callback;", "", "onEmptyCellClicked", "", "eventTimeMs", "", "onTagsClicked", "selectedTags", "", "Lapp/dogo/com/dogo_android/repository/domain/DogLog;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface b {
        /* renamed from: G0, reason: from kotlin metadata */
        void onEmptyCellClicked(List<DogLog> eventTimeMs);

        /* renamed from: O0, reason: from kotlin metadata */
        void onTagsClicked(long selectedTags);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellDogLogCalendarDayBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter;Lapp/dogo/com/dogo_android/databinding/CellDogLogCalendarDayBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellDogLogCalendarDayBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends RecyclerView.e0 {

        private final m1 a;
        final /* synthetic */ g b;
        public c(m1 m1Var) {
            n.f(gVar, "this$0");
            n.f(m1Var, "binding");
            this.b = gVar;
            super(m1Var.w());
            this.a = m1Var;
            m1Var.O.setOnClickEventListener(new DogLogCalendarAdapter_DefaultViewHolder_1(gVar, this));
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final m1 a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class e extends b<List<? extends g.a>> {

        final /* synthetic */ Object a;
        final /* synthetic */ g b;
        public e(Object object, Object object2, g gVar) {
            this.a = object;
            this.b = gVar;
            super(object2);
        }

        @Override // kotlin.f0.b
        protected void afterChange(l<?> property, List<? extends g.a> oldValue, List<? extends g.a> newValue) {
            n.f(property, "property");
            this.b.autoNotify(this.b, oldValue, newValue, kotlinx.coroutines.g.d.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$CalendarCellItem;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends kotlin.d0.d.p implements kotlin.d0.c.p<g.a, g.a, Boolean> {

        public static final g.d a = new g$d();
        @Override // kotlin.d0.d.p
        public final boolean a(g.a aVar, g.a aVar2) {
            boolean z;
            List list;
            boolean z3 = true;
            int i4;
            n.f(aVar, "o");
            n.f(aVar2, "n");
            if (n.b(aVar.e(), aVar2.e())) {
                if (aVar.g() == aVar2.g()) {
                    if (aVar.b() == aVar2.b()) {
                        aVar = aVar.d() == aVar2.d() ? 1 : 0;
                    }
                }
            }
            return (aVar.d() == aVar2.d() ? 1 : 0);
        }


        d() {
            super(2);
        }
    }
    static {
        l[] arr = new l[1];
        DogLogCalendarAdapter.c = new l[] { c0.f(new t(c0.b(DogLogCalendarAdapter.class), "items", "getItems()Ljava/util/List;")) };
    }

    public /* synthetic */ g(g.b bVar, int i, g gVar) {
        app.dogo.com.dogo_android.u.n.p.g.b bVar2 = null;
        i = i & 1 != 0 ? 0 : i;
        this(bVar2);
    }

    /* renamed from: f, reason: from kotlin metadata */
    public static final /* synthetic */ g.b getItem(g position) {
        return position.callbacks;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public <T> void autoNotify(RecyclerView.h<?> hVar, List<? extends T> list, List<? extends T> list2, kotlin.d0.c.p<? super T, ? super T, Boolean> pVar) {
        app.dogo.com.dogo_android.util.adapter.a.a.a(this, hVar, list, list2, pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final g.a g(int i) {
        return (DogLogCalendarAdapter_CalendarCellItem)p.a0(getTodayItemPosition(), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return getTodayItemPosition().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public final List<g.a> getTodayItemPosition() {
        return (List)this.b.getValue(this, DogLogCalendarAdapter.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final int i() {
        int i = 0;
        Iterator it = getTodayItemPosition().iterator();
        i = 0;
        while (it.hasNext()) {
            if ((DogLogCalendarAdapter_CalendarCellItem)it.next().g()) {
                break;
            }
        }
        i = -1;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: j, reason: from kotlin metadata */
    public void onBindViewHolder(g.c holder, int position) {
        n.f(holder, "holder");
        Object item = getTodayItemPosition().get(position);
        holder.a().V(item);
        holder.a().O.setTags(item.component1());
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: l, reason: from kotlin metadata */
    public g.c onCreateViewHolder(ViewGroup parent, int viewType) {
        n.f(parent, "parent");
        final m1 m1Var = m1.T(LayoutInflater.from(parent.getContext()), parent, false);
        n.e(m1Var, "inflate(inflater, parent, false)");
        return new DogLogCalendarAdapter_DefaultViewHolder(this, m1Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void m(List<g.a> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, DogLogCalendarAdapter.c[0], list);
    }

    public g(g.b bVar) {
        super();
        this.callbacks = bVar;
        List list = p.g();
        this.b = new Delegates_observable_1(list, list, this);
    }

    public g() {
        final app.dogo.com.dogo_android.u.n.p.g.b bVar = null;
        this(bVar, 1, bVar);
    }
}
