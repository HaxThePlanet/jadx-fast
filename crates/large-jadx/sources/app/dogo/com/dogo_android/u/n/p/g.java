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
import app.dogo.com.dogo_android.util.d0.a;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.p;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.t;
import kotlin.f0.a;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0003\u001d\u001e\u001fB\u0011\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0013J\u0008\u0010\u0014\u001a\u00020\u0013H\u0016J\u0006\u0010\u0015\u001a\u00020\u0013J\u001c\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$Callback;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$Callback;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$CalendarCellItem;", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "items$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItem", "position", "", "getItemCount", "getTodayItemPosition", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "CalendarCellItem", "Callback", "DefaultViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g extends RecyclerView.h<app.dogo.com.dogo_android.u.n.p.g.c> implements a {

    static final l<Object>[] c;
    private final app.dogo.com.dogo_android.u.n.p.g.b a;
    private final c b;

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u000f\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bHÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000c\u0010 \u001a\u0008\u0012\u0004\u0012\u00020!0\u000bJ\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u000fR\u0017\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u000f¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$CalendarCellItem;", "", "isToday", "", "dayOfMonth", "", "month", "weekday", "dayStartTimeMs", "", "tags", "", "Lapp/dogo/com/dogo_android/repository/domain/DogLog;", "(ZIIIJLjava/util/List;)V", "getDayOfMonth", "()I", "getDayStartTimeMs", "()J", "()Z", "getMonth", "getTags", "()Ljava/util/List;", "getWeekday", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "getCalendarTags", "Lapp/dogo/com/dogo_android/util/customview/DogLogView$CalendarTag;", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {

        private final boolean a;
        private final int b;
        private final int c;
        private final int d;
        private final long e;
        private final List<DogLog> f;
        public a(boolean z, int i2, int i3, int i4, long l5, List<DogLog> list6) {
            n.f(obj8, "tags");
            super();
            this.a = z;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = l5;
            this.f = obj8;
        }

        public final List<DogLogView.a> a() {
            int style;
            DogLogView.a aVar;
            int i2;
            int i;
            List list = this.f;
            ArrayList arrayList = new ArrayList(p.r(list, 10));
            Iterator iterator = list.iterator();
            for (DogLog next2 : iterator) {
                aVar = new DogLogView.a(eventTimeMs -= l, obj5, 0, next2.getStyle());
                arrayList.add(aVar);
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

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i5 = 0;
            if (!object instanceof g.a) {
                return i5;
            }
            if (this.a != object.a) {
                return i5;
            }
            if (this.b != object.b) {
                return i5;
            }
            if (this.c != object.c) {
                return i5;
            }
            if (this.d != object.d) {
                return i5;
            }
            if (Long.compare(l, l2) != 0) {
                return i5;
            }
            if (!n.b(this.f, object.f)) {
                return i5;
            }
            return i;
        }

        public final int f() {
            return this.d;
        }

        public final boolean g() {
            return this.a;
        }

        public int hashCode() {
            boolean z;
            if (this.a) {
                z = 1;
            }
            return i9 += i18;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CalendarCellItem(isToday=");
            stringBuilder.append(this.a);
            stringBuilder.append(", dayOfMonth=");
            stringBuilder.append(this.b);
            stringBuilder.append(", month=");
            stringBuilder.append(this.c);
            stringBuilder.append(", weekday=");
            stringBuilder.append(this.d);
            stringBuilder.append(", dayStartTimeMs=");
            stringBuilder.append(this.e);
            stringBuilder.append(", tags=");
            stringBuilder.append(this.f);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008H&¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$Callback;", "", "onEmptyCellClicked", "", "eventTimeMs", "", "onTagsClicked", "selectedTags", "", "Lapp/dogo/com/dogo_android/repository/domain/DogLog;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface b {
        public abstract void G0(List<DogLog> list);

        public abstract void O0(long l);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellDogLogCalendarDayBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter;Lapp/dogo/com/dogo_android/databinding/CellDogLogCalendarDayBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellDogLogCalendarDayBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends RecyclerView.e0 {

        private final m1 a;
        final app.dogo.com.dogo_android.u.n.p.g b;
        public c(app.dogo.com.dogo_android.u.n.p.g g, m1 m12) {
            n.f(g, "this$0");
            n.f(m12, "binding");
            this.b = g;
            super(m12.w());
            this.a = m12;
            g.c.a aVar = new g.c.a(g, this);
            m12.O.setOnClickEventListener(aVar);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final m1 a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class e extends b<List<? extends app.dogo.com.dogo_android.u.n.p.g.a>> {

        final Object a;
        final app.dogo.com.dogo_android.u.n.p.g b;
        public e(Object object, Object object2, app.dogo.com.dogo_android.u.n.p.g g3) {
            this.a = object;
            this.b = g3;
            super(object2);
        }

        protected void afterChange(l<?> l, List<? extends app.dogo.com.dogo_android.u.n.p.g.a> list2, List<? extends app.dogo.com.dogo_android.u.n.p.g.a> list3) {
            n.f(l, "property");
            final app.dogo.com.dogo_android.u.n.p.g obj2 = this.b;
            obj2.autoNotify(obj2, (List)list2, (List)list3, g.d.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$CalendarCellItem;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements p<app.dogo.com.dogo_android.u.n.p.g.a, app.dogo.com.dogo_android.u.n.p.g.a, Boolean> {

        public static final app.dogo.com.dogo_android.u.n.p.g.d a;
        static {
            g.d dVar = new g.d();
            g.d.a = dVar;
        }

        d() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(app.dogo.com.dogo_android.u.n.p.g.a g$a, app.dogo.com.dogo_android.u.n.p.g.a g$a2) {
            boolean z;
            List list;
            Object obj3;
            Object obj4;
            n.f(a, "o");
            n.f(a2, "n");
            if (n.b(a.e(), a2.e()) && a.g() == a2.g() && a.b() == a2.b() && a.d() == a2.d()) {
                if (a.g() == a2.g()) {
                    if (a.b() == a2.b()) {
                        obj3 = a.d() == a2.d() ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
            return obj3;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return Boolean.valueOf(a((g.a)object, (g.a)object2));
        }
    }
    static {
        l[] arr = new l[1];
        t tVar = new t(c0.b(g.class), "items", "getItems()Ljava/util/List;");
        g.c = arr;
    }

    public g() {
        final int i = 0;
        super(i, 1, i);
    }

    public g(app.dogo.com.dogo_android.u.n.p.g.b g$b) {
        super();
        this.a = b;
        a obj2 = a.a;
        obj2 = p.g();
        g.e eVar = new g.e(obj2, obj2, this);
        this.b = eVar;
    }

    public g(app.dogo.com.dogo_android.u.n.p.g.b g$b, int i2, g g3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public static final app.dogo.com.dogo_android.u.n.p.g.b f(app.dogo.com.dogo_android.u.n.p.g g) {
        return g.a;
    }

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final app.dogo.com.dogo_android.u.n.p.g.a g(int i) {
        return (g.a)p.a0(h(), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return h().size();
    }

    public final List<app.dogo.com.dogo_android.u.n.p.g.a> h() {
        return (List)this.b.getValue(this, g.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final int i() {
        int i;
        boolean next;
        Iterator iterator = h().iterator();
        i = 0;
        for (g.a next2 : iterator) {
            i++;
        }
        i = -1;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void j(app.dogo.com.dogo_android.u.n.p.g.c g$c, int i2) {
        n.f(c, "holder");
        Object obj3 = h().get(i2);
        c.a().V((g.a)obj3);
        obj2.O.setTags(obj3.a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.u.n.p.g.c l(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final m1 obj3 = m1.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj3, "inflate(inflater, parent, false)");
        g.c cVar = new g.c(this, obj3);
        return cVar;
    }

    public final void m(List<app.dogo.com.dogo_android.u.n.p.g.a> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, g.c[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        j((g.c)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return l(viewGroup, i2);
    }
}
