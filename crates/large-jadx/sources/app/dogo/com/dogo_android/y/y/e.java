package app.dogo.com.dogo_android.y.y;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.a4;
import app.dogo.com.dogo_android.h.c4;
import app.dogo.com.dogo_android.h.m5;
import app.dogo.com.dogo_android.h.s6;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State;
import app.dogo.com.dogo_android.util.d0.a;
import app.dogo.com.dogo_android.util.d0.a.a;
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
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0006\u001c\u001d\u001e\u001f !B\u0011\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$Callbacks;", "(Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$Callbacks;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "list", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "list$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "ComingSoonItem", "DefaultViewHolder", "HeaderItem", "ItemHolder", "RecommendedProgramItem", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends RecyclerView.h<app.dogo.com.dogo_android.y.y.e.c> implements a {

    static final l<Object>[] c;
    private final app.dogo.com.dogo_android.y.y.e.a a;
    private final c b;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$Callbacks;", "", "onComingSoonItemSelect", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "onItemSelected", "onRecommendedItemSelect", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void R0(ProgramDescriptionItem programDescriptionItem);

        public abstract void b(ProgramDescriptionItem programDescriptionItem);

        public abstract void x1(ProgramDescriptionItem programDescriptionItem);
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class g {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[ProgramDescriptionItem.State.HEADER.ordinal()] = 1;
            iArr[ProgramDescriptionItem.State.RECOMMENDED_BIG.ordinal()] = 2;
            iArr[ProgramDescriptionItem.State.COMING_SOON.ordinal()] = 3;
            e.g.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class c extends RecyclerView.e0 {

        private final ViewDataBinding a;
        public c(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.a = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$ComingSoonItem;", "Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramComingSoonCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramComingSoonCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramComingSoonCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends app.dogo.com.dogo_android.y.y.e.c {

        private final c4 b;
        final app.dogo.com.dogo_android.y.y.e c;
        public b(app.dogo.com.dogo_android.y.y.e e, c4 c42) {
            n.f(e, "this$0");
            n.f(c42, "binding");
            this.c = e;
            super(c42);
            this.b = c42;
            a aVar = new a(e, this);
            c42.O.setOnClickListener(aVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.y.e e, app.dogo.com.dogo_android.y.y.e.b e$b2, View view3) {
            Object obj0;
            Object obj1;
            n.f(e, "this$0");
            n.f(b2, "this$1");
            app.dogo.com.dogo_android.y.y.e.a obj2 = e.f(e);
            if (obj2 == null) {
            } else {
                obj2.b((ProgramDescriptionItem)e.g().get(b2.getAdapterPosition()));
            }
        }

        public static void d(app.dogo.com.dogo_android.y.y.e e, app.dogo.com.dogo_android.y.y.e.b e$b2, View view3) {
            e.b.b(e, b2, view3);
        }

        @Override // app.dogo.com.dogo_android.y.y.e$c
        public final c4 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$HeaderItem;", "Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramListHeaderBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramListHeaderBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramListHeaderBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class d extends app.dogo.com.dogo_android.y.y.e.c {
        public d(app.dogo.com.dogo_android.y.y.e e, m5 m52) {
            n.f(e, "this$0");
            n.f(m52, "binding");
            super(m52);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$ItemHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class e extends app.dogo.com.dogo_android.y.y.e.c {

        private final a4 b;
        final app.dogo.com.dogo_android.y.y.e c;
        public e(app.dogo.com.dogo_android.y.y.e e, a4 a42) {
            n.f(e, "this$0");
            n.f(a42, "binding");
            this.c = e;
            super(a42);
            this.b = a42;
            b bVar = new b(e, this);
            a42.w().setOnClickListener(bVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.y.e e, app.dogo.com.dogo_android.y.y.e.e e$e2, View view3) {
            Object obj0;
            Object obj1;
            n.f(e, "this$0");
            n.f(e2, "this$1");
            app.dogo.com.dogo_android.y.y.e.a obj2 = e.f(e);
            if (obj2 == null) {
            } else {
                obj2.R0((ProgramDescriptionItem)e.g().get(e2.getAdapterPosition()));
            }
        }

        public static void d(app.dogo.com.dogo_android.y.y.e e, app.dogo.com.dogo_android.y.y.e.e e$e2, View view3) {
            e.e.b(e, e2, view3);
        }

        @Override // app.dogo.com.dogo_android.y.y.e$c
        public final a4 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$RecommendedProgramItem;", "Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellRecommendedProgramCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter;Lapp/dogo/com/dogo_android/databinding/CellRecommendedProgramCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellRecommendedProgramCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class f extends app.dogo.com.dogo_android.y.y.e.c {

        private final s6 b;
        final app.dogo.com.dogo_android.y.y.e c;
        public f(app.dogo.com.dogo_android.y.y.e e, s6 s62) {
            n.f(e, "this$0");
            n.f(s62, "binding");
            this.c = e;
            super(s62);
            this.b = s62;
            c cVar = new c(e, this);
            s62.R.setOnClickListener(cVar);
        }

        private static final void b(app.dogo.com.dogo_android.y.y.e e, app.dogo.com.dogo_android.y.y.e.f e$f2, View view3) {
            Object obj0;
            Object obj1;
            n.f(e, "this$0");
            n.f(f2, "this$1");
            app.dogo.com.dogo_android.y.y.e.a obj2 = e.f(e);
            if (obj2 == null) {
            } else {
                obj2.x1((ProgramDescriptionItem)e.g().get(f2.getAdapterPosition()));
            }
        }

        public static void d(app.dogo.com.dogo_android.y.y.e e, app.dogo.com.dogo_android.y.y.e.f e$f2, View view3) {
            e.f.b(e, f2, view3);
        }

        @Override // app.dogo.com.dogo_android.y.y.e$c
        public final s6 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class i extends b<List<? extends ProgramDescriptionItem>> {

        final Object a;
        final app.dogo.com.dogo_android.y.y.e b;
        public i(Object object, Object object2, app.dogo.com.dogo_android.y.y.e e3) {
            this.a = object;
            this.b = e3;
            super(object2);
        }

        protected void afterChange(l<?> l, List<? extends ProgramDescriptionItem> list2, List<? extends ProgramDescriptionItem> list3) {
            n.f(l, "property");
            final app.dogo.com.dogo_android.y.y.e obj2 = this.b;
            obj2.autoNotify(obj2, (List)list2, (List)list3, e.h.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class h extends p implements p<ProgramDescriptionItem, ProgramDescriptionItem, Boolean> {

        public static final app.dogo.com.dogo_android.y.y.e.h a;
        static {
            e.h hVar = new e.h();
            e.h.a = hVar;
        }

        h() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(ProgramDescriptionItem programDescriptionItem, ProgramDescriptionItem programDescriptionItem2) {
            n.f(programDescriptionItem, "o");
            n.f(programDescriptionItem2, "n");
            return n.b(programDescriptionItem.getId(), programDescriptionItem2.getId());
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return Boolean.valueOf(a((ProgramDescriptionItem)object, (ProgramDescriptionItem)object2));
        }
    }
    static {
        l[] arr = new l[1];
        t tVar = new t(c0.b(e.class), "list", "getList()Ljava/util/List;");
        e.c = arr;
    }

    public e() {
        final int i = 0;
        super(i, 1, i);
    }

    public e(app.dogo.com.dogo_android.y.y.e.a e$a) {
        super();
        this.a = a;
        a obj2 = a.a;
        obj2 = p.g();
        e.i iVar = new e.i(obj2, obj2, this);
        this.b = iVar;
    }

    public e(app.dogo.com.dogo_android.y.y.e.a e$a, int i2, g g3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public static final app.dogo.com.dogo_android.y.y.e.a f(app.dogo.com.dogo_android.y.y.e e) {
        return e.a;
    }

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    public final List<ProgramDescriptionItem> g() {
        return (List)this.b.getValue(this, e.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return g().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        return (ProgramDescriptionItem)g().get(i).getProgramState().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.y.y.e.c e$c, int i2) {
        s6 s6Var;
        List list;
        Object obj4;
        n.f(c, "holder");
        if (c instanceof e.f) {
            (e.f)c.c().V((ProgramDescriptionItem)g().get(i2));
        } else {
            if (c instanceof e.e) {
                (e.e)c.c().V((ProgramDescriptionItem)g().get(i2));
            } else {
                if (c instanceof e.b) {
                    (e.b)c.c().V((ProgramDescriptionItem)g().get(i2));
                }
            }
        }
        c.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.y.y.e.c i(ViewGroup viewGroup, int i2) {
        int i;
        ViewDataBinding obj5;
        app.dogo.com.dogo_android.y.y.e.c obj6;
        n.f(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        obj6 = e.g.a[ProgramDescriptionItem.State.values()[i2].ordinal()];
        final String str2 = "inflate(inflater, parent, false)";
        final int i3 = 0;
        if (obj6 != 1) {
            if (obj6 != 2) {
                if (obj6 != 3) {
                    obj5 = a4.T(from, viewGroup, i3);
                    n.e(obj5, str2);
                    obj6 = new e.e(this, obj5);
                } else {
                    obj5 = c4.T(from, viewGroup, i3);
                    n.e(obj5, str2);
                    obj6 = new e.b(this, obj5);
                }
            } else {
                obj5 = s6.T(from, viewGroup, i3);
                n.e(obj5, str2);
                obj6 = new e.f(this, obj5);
            }
        } else {
            obj5 = m5.T(from, viewGroup, i3);
            n.e(obj5, str2);
            obj6 = new e.d(this, obj5);
        }
        return obj6;
    }

    public final void j(List<ProgramDescriptionItem> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, e.c[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((e.c)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }
}
