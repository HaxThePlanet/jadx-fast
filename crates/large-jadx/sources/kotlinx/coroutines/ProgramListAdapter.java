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

/* compiled from: ProgramListAdapter.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0006\u001c\u001d\u001e\u001f !B\u0011\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$Callbacks;", "(Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$Callbacks;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "list", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "list$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "ComingSoonItem", "DefaultViewHolder", "HeaderItem", "ItemHolder", "RecommendedProgramItem", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class ProgramListAdapter extends RecyclerView.h<e.c> implements app.dogo.com.dogo_android.util.d0.a {

    static final /* synthetic */ l<Object>[] c;
    /* renamed from: a, reason: from kotlin metadata */
    private final e.a callbacks;
    private final c b;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$Callbacks;", "", "onComingSoonItemSelect", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "onItemSelected", "onRecommendedItemSelect", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: R0, reason: from kotlin metadata */
        void onComingSoonItemSelect(ProgramDescriptionItem item);

        /* renamed from: b, reason: from kotlin metadata */
        void onItemSelected(ProgramDescriptionItem item);

        /* renamed from: x1, reason: from kotlin metadata */
        void onRecommendedItemSelect(ProgramDescriptionItem item);
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class g {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[ProgramDescriptionItem_State.values().length];
            iArr[ProgramDescriptionItem_State.HEADER.ordinal()] = 1;
            iArr[ProgramDescriptionItem_State.RECOMMENDED_BIG.ordinal()] = 2;
            iArr[ProgramDescriptionItem_State.COMING_SOON.ordinal()] = 3;
            kotlinx.coroutines.e.g.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class c extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding bind;
        public c(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.bind = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.bind;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$ComingSoonItem;", "Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramComingSoonCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramComingSoonCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramComingSoonCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends e.c {

        private final c4 b;
        final /* synthetic */ e c;
        public b(c4 c4Var) {
            n.f(eVar, "this$0");
            n.f(c4Var, "binding");
            this.c = eVar;
            super(c4Var);
            this.b = c4Var;
            c4Var.O.setOnClickListener(new kotlinx.coroutines.a(eVar, this));
        }

        private static final void b(e eVar, e.b bVar, View view) {
            n.f(eVar, "this$0");
            n.f(bVar, "this$1");
            app.dogo.com.dogo_android.y.y.e.a itemViewType = eVar.callbacks;
            if (itemViewType != null) {
                itemViewType.onItemSelected((ProgramDescriptionItem)eVar.getItemCount().get(bVar.getAdapterPosition()));
            }
        }

        @Override // app.dogo.com.dogo_android.y.y.e$c
        public final c4 c() {
            return this.b;
        }

        public static /* synthetic */ void d(e eVar, e.b bVar, View view) {
            ProgramListAdapter_ComingSoonItem.b(eVar, bVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$HeaderItem;", "Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramListHeaderBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramListHeaderBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramListHeaderBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class d extends e.c {
        public d(m5 m5Var) {
            n.f(eVar, "this$0");
            n.f(m5Var, "binding");
            super(m5Var);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$ItemHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class e extends e.c {

        private final a4 b;
        final /* synthetic */ e c;
        public e(a4 a4Var) {
            n.f(eVar, "this$0");
            n.f(a4Var, "binding");
            this.c = eVar;
            super(a4Var);
            this.b = a4Var;
            a4Var.w().setOnClickListener(new kotlinx.coroutines.b(eVar, this));
        }

        private static final void b(e eVar, e.e eVar2, View view) {
            n.f(eVar, "this$0");
            n.f(eVar2, "this$1");
            app.dogo.com.dogo_android.y.y.e.a itemViewType = eVar.callbacks;
            if (itemViewType != null) {
                itemViewType.onComingSoonItemSelect((ProgramDescriptionItem)eVar.getItemCount().get(eVar2.getAdapterPosition()));
            }
        }

        @Override // app.dogo.com.dogo_android.y.y.e$c
        public final a4 c() {
            return this.b;
        }

        public static /* synthetic */ void d(e eVar, e.e eVar2, View view) {
            ProgramListAdapter_ItemHolder.b(eVar, eVar2, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$RecommendedProgramItem;", "Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellRecommendedProgramCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter;Lapp/dogo/com/dogo_android/databinding/CellRecommendedProgramCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellRecommendedProgramCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class f extends e.c {

        private final s6 b;
        final /* synthetic */ e c;
        public f(s6 s6Var) {
            n.f(eVar, "this$0");
            n.f(s6Var, "binding");
            this.c = eVar;
            super(s6Var);
            this.b = s6Var;
            s6Var.R.setOnClickListener(new kotlinx.coroutines.c(eVar, this));
        }

        private static final void b(e eVar, e.f fVar, View view) {
            n.f(eVar, "this$0");
            n.f(fVar, "this$1");
            app.dogo.com.dogo_android.y.y.e.a itemViewType = eVar.callbacks;
            if (itemViewType != null) {
                itemViewType.onRecommendedItemSelect((ProgramDescriptionItem)eVar.getItemCount().get(fVar.getAdapterPosition()));
            }
        }

        @Override // app.dogo.com.dogo_android.y.y.e$c
        public final s6 c() {
            return this.b;
        }

        public static /* synthetic */ void d(e eVar, e.f fVar, View view) {
            ProgramListAdapter_RecommendedProgramItem.b(eVar, fVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class i extends b<List<? extends ProgramDescriptionItem>> {

        final /* synthetic */ Object a;
        final /* synthetic */ e b;
        public i(Object object, Object object2, e eVar) {
            this.a = object;
            this.b = eVar;
            super(object2);
        }

        @Override // kotlin.f0.b
        protected void afterChange(l<?> property, List<? extends ProgramDescriptionItem> oldValue, List<? extends ProgramDescriptionItem> newValue) {
            n.f(property, "property");
            this.b.autoNotify(this.b, oldValue, newValue, kotlinx.coroutines.e.h.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class h extends kotlin.d0.d.p implements kotlin.d0.c.p<ProgramDescriptionItem, ProgramDescriptionItem, Boolean> {

        public static final e.h a = new e$h();
        @Override // kotlin.d0.d.p
        public final boolean a(ProgramDescriptionItem programDescriptionItem, ProgramDescriptionItem programDescriptionItem2) {
            n.f(programDescriptionItem, "o");
            n.f(programDescriptionItem2, "n");
            return n.b(programDescriptionItem.getId(), programDescriptionItem2.getId());
        }


        h() {
            super(2);
        }
    }
    static {
        l[] arr = new l[1];
        ProgramListAdapter.c = new l[] { c0.f(new t(c0.b(ProgramListAdapter.class), "list", "getList()Ljava/util/List;")) };
    }

    public /* synthetic */ e(e.a aVar, int i, g gVar) {
        app.dogo.com.dogo_android.y.y.e.a aVar2 = null;
        i = i & 1 != 0 ? 0 : i;
        this(aVar2);
    }

    /* renamed from: f, reason: from kotlin metadata */
    public static final /* synthetic */ e.a getItemViewType(e position) {
        return position.callbacks;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public <T> void autoNotify(RecyclerView.h<?> hVar, List<? extends T> list, List<? extends T> list2, kotlin.d0.c.p<? super T, ? super T, Boolean> pVar) {
        app.dogo.com.dogo_android.util.adapter.a.a.a(this, hVar, list, list2, pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public final List<ProgramDescriptionItem> getItemCount() {
        return (List)this.b.getValue(this, ProgramListAdapter.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return getItemCount().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        return (ProgramDescriptionItem)getItemCount().get(i).getProgramState().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(e.c holder, int position) {
        n.f(holder, "holder");
        if (holder instanceof ProgramListAdapter_RecommendedProgramItem) {
            (ProgramListAdapter_RecommendedProgramItem)holder.c().V((ProgramDescriptionItem)getItemCount().get(position));
        } else {
            if (holder instanceof ProgramListAdapter_ItemHolder) {
                (ProgramListAdapter_ItemHolder)holder.c().V((ProgramDescriptionItem)getItemCount().get(position));
            } else {
                if (holder instanceof ProgramListAdapter_ComingSoonItem) {
                    (ProgramListAdapter_ComingSoonItem)holder.c().V((ProgramDescriptionItem)getItemCount().get(position));
                }
            }
        }
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public e.c onCreateViewHolder(ViewGroup parent, int viewType) {
        app.dogo.com.dogo_android.y.y.e.d programListAdapter_HeaderItem;
        n.f(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        int i2 = kotlinx.coroutines.e.g.a[ProgramDescriptionItem_State.values()[viewType].ordinal()];
        int i = 1;
        final String str2 = "inflate(inflater, parent, false)";
        final boolean z = false;
        if (i2 == 1) {
            m5 m5Var = m5.T(from, parent, z);
            n.e(m5Var, str2);
            programListAdapter_HeaderItem = new ProgramListAdapter_HeaderItem(this, m5Var);
        } else {
            i = 2;
            if (i2 == 2) {
                s6 s6Var = s6.T(from, parent, z);
                n.e(s6Var, str2);
                app.dogo.com.dogo_android.y.y.e.f programListAdapter_RecommendedProgramItem = new ProgramListAdapter_RecommendedProgramItem(this, s6Var);
            } else {
                i = 3;
                if (i2 != 3) {
                    a4 a4Var = a4.T(from, parent, z);
                    n.e(a4Var, str2);
                    app.dogo.com.dogo_android.y.y.e.e programListAdapter_ItemHolder = new ProgramListAdapter_ItemHolder(this, a4Var);
                } else {
                    c4 c4Var = c4.T(from, parent, z);
                    n.e(c4Var, str2);
                    app.dogo.com.dogo_android.y.y.e.b programListAdapter_ComingSoonItem = new ProgramListAdapter_ComingSoonItem(this, c4Var);
                }
            }
        }
        return programListAdapter_HeaderItem;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void j(List<ProgramDescriptionItem> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, ProgramListAdapter.c[0], list);
    }

    public e(e.a aVar) {
        super();
        this.callbacks = aVar;
        List list = p.g();
        this.b = new Delegates_observable_1(list, list, this);
    }

    public e() {
        final app.dogo.com.dogo_android.y.y.e.a aVar = null;
        this(aVar, 1, aVar);
    }
}
