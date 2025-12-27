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
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.t;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;

/* compiled from: ProgramListCardAdapter.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0002\u001b\u001cB\u0011\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/library/program/ProgramListCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/library/program/ProgramListCardAdapter$SliderViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/library/program/ProgramListCardAdapter$Callback;", "(Lapp/dogo/com/dogo_android/library/program/ProgramListCardAdapter$Callback;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "programs", "getPrograms", "()Ljava/util/List;", "setPrograms", "(Ljava/util/List;)V", "programs$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callback", "SliderViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b, reason: from kotlin metadata */
public final class ProgramListCardAdapter extends RecyclerView.h<b.b> implements app.dogo.com.dogo_android.util.d0.a {

    static final /* synthetic */ l<Object>[] c;
    /* renamed from: a, reason: from kotlin metadata */
    private final b.a callbacks;
    private final c b;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/library/program/ProgramListCardAdapter$Callback;", "", "onComingSoonItemSelect", "", "program", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "onProgramSelected", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: b, reason: from kotlin metadata */
        void onComingSoonItemSelect(ProgramDescriptionItem program);

        /* renamed from: g, reason: from kotlin metadata */
        void onProgramSelected(ProgramDescriptionItem program);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/library/program/ProgramListCardAdapter$SliderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellLibraryProgramCardBinding;", "(Lapp/dogo/com/dogo_android/library/program/ProgramListCardAdapter;Lapp/dogo/com/dogo_android/databinding/CellLibraryProgramCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellLibraryProgramCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends RecyclerView.e0 {

        private final c3 a;
        final /* synthetic */ b b;
        public b(c3 c3Var) {
            n.f(bVar, "this$0");
            n.f(c3Var, "binding");
            this.b = bVar;
            super(c3Var.w());
            this.a = c3Var;
            c3Var.w().setOnClickListener(new app.dogo.com.dogo_android.library.program.a(this, bVar));
        }

        private static final void a(b.b bVar, b bVar2, View view) {
            n.f(bVar, "this$0");
            str = "this$1";
            n.f(bVar2, str);
            ProgramDescriptionItem programDescriptionItem = bVar.b().T();
            if (programDescriptionItem != null) {
                if (programDescriptionItem.getProgramState() != ProgramDescriptionItem_State.COMING_SOON) {
                    app.dogo.com.dogo_android.n.l.b.a aVar = bVar2.callbacks;
                    if (aVar != null) {
                        aVar.onProgramSelected(programDescriptionItem);
                    }
                } else {
                    aVar = bVar2.callbacks;
                    if (aVar != null) {
                        aVar.onComingSoonItemSelect(programDescriptionItem);
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final c3 b() {
            return this.a;
        }

        public static /* synthetic */ void c(b.b bVar, b bVar2, View view) {
            ProgramListCardAdapter_SliderViewHolder.a(bVar, bVar2, view);
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class d extends b<List<? extends ProgramDescriptionItem>> {

        final /* synthetic */ Object a;
        final /* synthetic */ b b;
        public d(Object object, Object object2, b bVar) {
            this.a = object;
            this.b = bVar;
            super(object2);
        }

        @Override // kotlin.f0.b
        protected void afterChange(l<?> property, List<? extends ProgramDescriptionItem> oldValue, List<? extends ProgramDescriptionItem> newValue) {
            n.f(property, "property");
            this.b.autoNotify(this.b, oldValue, newValue, app.dogo.com.dogo_android.library.program.b.c.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends kotlin.d0.d.p implements kotlin.d0.c.p<ProgramDescriptionItem, ProgramDescriptionItem, Boolean> {

        public static final b.c a = new b$c();
        @Override // kotlin.d0.d.p
        public final boolean a(ProgramDescriptionItem programDescriptionItem, ProgramDescriptionItem programDescriptionItem2) {
            n.f(programDescriptionItem, "o");
            n.f(programDescriptionItem2, "n");
            return n.b(programDescriptionItem.getId(), programDescriptionItem2.getId());
        }


        c() {
            super(2);
        }
    }
    static {
        l[] arr = new l[1];
        ProgramListCardAdapter.c = new l[] { c0.f(new t(c0.b(ProgramListCardAdapter.class), "programs", "getPrograms()Ljava/util/List;")) };
    }

    public /* synthetic */ b(b.a aVar, int i, g gVar) {
        app.dogo.com.dogo_android.n.l.b.a aVar2 = null;
        i = i & 1 != 0 ? 0 : i;
        this(aVar2);
    }

    public static final /* synthetic */ b.a f(b bVar) {
        return bVar.callbacks;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public <T> void autoNotify(RecyclerView.h<?> hVar, List<? extends T> list, List<? extends T> list2, kotlin.d0.c.p<? super T, ? super T, Boolean> pVar) {
        app.dogo.com.dogo_android.util.adapter.a.a.a(this, hVar, list, list2, pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public final List<ProgramDescriptionItem> getItemCount() {
        return (List)this.b.getValue(this, ProgramListCardAdapter.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return getItemCount().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(b.b holder, int position) {
        n.f(holder, "holder");
        holder.b().W((ProgramDescriptionItem)getItemCount().get(position));
        holder.b().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public b.b onCreateViewHolder(ViewGroup parent, int viewType) {
        n.f(parent, "parent");
        final c3 c3Var = c3.U(LayoutInflater.from(parent.getContext()), parent, false);
        n.e(c3Var, "inflate(inflater, parent, false)");
        return new ProgramListCardAdapter_SliderViewHolder(this, c3Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void j(List<ProgramDescriptionItem> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, ProgramListCardAdapter.c[0], list);
    }

    public b(b.a aVar) {
        super();
        this.callbacks = aVar;
        List list = p.g();
        this.b = new Delegates_observable_1(list, list, this);
    }

    public b() {
        final app.dogo.com.dogo_android.n.l.b.a aVar = null;
        this(aVar, 1, aVar);
    }
}
