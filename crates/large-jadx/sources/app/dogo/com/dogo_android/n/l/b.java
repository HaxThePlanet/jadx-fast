package app.dogo.com.dogo_android.n.l;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.c3;
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
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0002\u001b\u001cB\u0011\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/library/program/ProgramListCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/library/program/ProgramListCardAdapter$SliderViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/library/program/ProgramListCardAdapter$Callback;", "(Lapp/dogo/com/dogo_android/library/program/ProgramListCardAdapter$Callback;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "programs", "getPrograms", "()Ljava/util/List;", "setPrograms", "(Ljava/util/List;)V", "programs$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callback", "SliderViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class b extends RecyclerView.h<app.dogo.com.dogo_android.n.l.b.b> implements a {

    static final l<Object>[] c;
    private final app.dogo.com.dogo_android.n.l.b.a a;
    private final c b;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/library/program/ProgramListCardAdapter$Callback;", "", "onComingSoonItemSelect", "", "program", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "onProgramSelected", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void b(ProgramDescriptionItem programDescriptionItem);

        public abstract void g(ProgramDescriptionItem programDescriptionItem);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/library/program/ProgramListCardAdapter$SliderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellLibraryProgramCardBinding;", "(Lapp/dogo/com/dogo_android/library/program/ProgramListCardAdapter;Lapp/dogo/com/dogo_android/databinding/CellLibraryProgramCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellLibraryProgramCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends RecyclerView.e0 {

        private final c3 a;
        final app.dogo.com.dogo_android.n.l.b b;
        public b(app.dogo.com.dogo_android.n.l.b b, c3 c32) {
            n.f(b, "this$0");
            n.f(c32, "binding");
            this.b = b;
            super(c32.w());
            this.a = c32;
            a aVar = new a(this, b);
            c32.w().setOnClickListener(aVar);
        }

        private static final void a(app.dogo.com.dogo_android.n.l.b.b b$b, app.dogo.com.dogo_android.n.l.b b2, View view3) {
            ProgramDescriptionItem.State cOMING_SOON;
            Object obj2;
            Object obj3;
            n.f(b, "this$0");
            n.f(b2, "this$1");
            ProgramDescriptionItem obj1 = b.b().T();
            if (obj1 != null) {
                if (obj1.getProgramState() != ProgramDescriptionItem.State.COMING_SOON) {
                    obj2 = b.f(b2);
                    if (obj2 == null) {
                    } else {
                        obj2.g(obj1);
                    }
                } else {
                    obj2 = b.f(b2);
                    if (obj2 == null) {
                    } else {
                        obj2.b(obj1);
                    }
                }
            }
        }

        public static void c(app.dogo.com.dogo_android.n.l.b.b b$b, app.dogo.com.dogo_android.n.l.b b2, View view3) {
            b.b.a(b, b2, view3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final c3 b() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class d extends b<List<? extends ProgramDescriptionItem>> {

        final Object a;
        final app.dogo.com.dogo_android.n.l.b b;
        public d(Object object, Object object2, app.dogo.com.dogo_android.n.l.b b3) {
            this.a = object;
            this.b = b3;
            super(object2);
        }

        protected void afterChange(l<?> l, List<? extends ProgramDescriptionItem> list2, List<? extends ProgramDescriptionItem> list3) {
            n.f(l, "property");
            final app.dogo.com.dogo_android.n.l.b obj2 = this.b;
            obj2.autoNotify(obj2, (List)list2, (List)list3, b.c.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements p<ProgramDescriptionItem, ProgramDescriptionItem, Boolean> {

        public static final app.dogo.com.dogo_android.n.l.b.c a;
        static {
            b.c cVar = new b.c();
            b.c.a = cVar;
        }

        c() {
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
        t tVar = new t(c0.b(b.class), "programs", "getPrograms()Ljava/util/List;");
        b.c = arr;
    }

    public b() {
        final int i = 0;
        super(i, 1, i);
    }

    public b(app.dogo.com.dogo_android.n.l.b.a b$a) {
        super();
        this.a = a;
        a obj2 = a.a;
        obj2 = p.g();
        b.d dVar = new b.d(obj2, obj2, this);
        this.b = dVar;
    }

    public b(app.dogo.com.dogo_android.n.l.b.a b$a, int i2, g g3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public static final app.dogo.com.dogo_android.n.l.b.a f(app.dogo.com.dogo_android.n.l.b b) {
        return b.a;
    }

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    public final List<ProgramDescriptionItem> g() {
        return (List)this.b.getValue(this, b.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return g().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.n.l.b.b b$b, int i2) {
        n.f(b, "holder");
        b.b().W((ProgramDescriptionItem)g().get(i2));
        b.b().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.n.l.b.b i(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final c3 obj3 = c3.U(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj3, "inflate(inflater, parent, false)");
        b.b bVar = new b.b(this, obj3);
        return bVar;
    }

    public final void j(List<ProgramDescriptionItem> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, b.c[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((b.b)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }
}
