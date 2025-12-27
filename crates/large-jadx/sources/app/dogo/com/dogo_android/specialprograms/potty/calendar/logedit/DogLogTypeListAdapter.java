package app.dogo.com.dogo_android.u.n.p.l;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.o1;
import app.dogo.com.dogo_android.h.s1;
import app.dogo.com.dogo_android.k.e;
import app.dogo.com.dogo_android.util.n0.i;
import app.dogo.com.dogo_android.util.n0.i.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;

/* compiled from: DogLogTypeListAdapter.kt */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0005#$%&'B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000fR\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011j\u0008\u0012\u0004\u0012\u00020\t`\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$Holder;", "callback", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$Callback;", "items", "", "Lapp/dogo/com/dogo_android/util/recycle_views/DogLogSelection;", "initialSelection", "", "isNewLog", "", "(Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$Callback;Ljava/util/List;Ljava/lang/String;Z)V", "getInitialSelection", "()Ljava/lang/String;", "()Z", "selectedTags", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSelectedTags", "()Ljava/util/ArrayList;", "getItemCount", "", "getItemViewType", "position", "handleAddingNewLog", "", "tagId", "handleEditingExistingLog", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callback", "CellHolder", "DividerHolder", "Holder", "ItemTypes", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final class DogLogTypeListAdapter extends RecyclerView.h<j.d> {

    /* renamed from: a, reason: from kotlin metadata */
    private final j.a callback;
    private final List<i> b;
    private final String c;
    /* renamed from: d, reason: from kotlin metadata */
    private final boolean items;
    /* renamed from: e, reason: from kotlin metadata */
    private final ArrayList<String> selectedTags = new ArrayList<>();

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\u0008\u0012\u0004\u0012\u00020\u0006`\u0007H&¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$Callback;", "", "onTagSelected", "", "types", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: C0, reason: from kotlin metadata */
        void onTagSelected(ArrayList<String> types);
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0086\u0001\u0018\u0000 \u00052\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$ItemTypes;", "", "(Ljava/lang/String;I)V", "ITEM", "DIVIDER", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum e {

        DIVIDER,
        ITEM;
        private static final /* synthetic */ j.e[] $values() {
            app.dogo.com.dogo_android.u.n.p.l.j.e[] arr = new j.e[2];
            return new j.e[] { DogLogTypeListAdapter_ItemTypes.ITEM, DogLogTypeListAdapter_ItemTypes.DIVIDER };
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class f {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[DogLogTypeListAdapter_ItemTypes.values().length];
            iArr[DogLogTypeListAdapter_ItemTypes.DIVIDER.ordinal()] = 1;
            iArr[DogLogTypeListAdapter_ItemTypes.ITEM.ordinal()] = 2;
            app.dogo.com.dogo_android.specialprograms.potty.calendar.logedit.j.f.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class d extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding bind;
        public d(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.bind = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.bind;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$CellHolder;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellDogLogTypeBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter;Lapp/dogo/com/dogo_android/databinding/CellDogLogTypeBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellDogLogTypeBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends j.d {

        private final s1 b;
        final /* synthetic */ j c;
        public b(s1 s1Var) {
            n.f(jVar, "this$0");
            n.f(s1Var, "binding");
            this.c = jVar;
            super(s1Var);
            this.b = s1Var;
            s1Var.w().setOnClickListener(new app.dogo.com.dogo_android.specialprograms.potty.calendar.logedit.f(jVar, this));
        }

        private static final void b(j jVar, j.b bVar, View view) {
            n.f(jVar, "this$0");
            n.f(bVar, "this$1");
            Object item = jVar.b.get(bVar.getBindingAdapterPosition());
            if (jVar.n()) {
                jVar.handleEditingExistingLog(item.a().getTagId());
            } else {
                jVar.m(item.a().getTagId());
            }
            jVar.notifyItemChanged(bVar.getBindingAdapterPosition(), null);
            jVar.callback.onTagSelected(jVar.j());
        }

        @Override // app.dogo.com.dogo_android.u.n.p.l.j$d
        public final s1 c() {
            return this.b;
        }

        public static /* synthetic */ void d(j jVar, j.b bVar, View view) {
            DogLogTypeListAdapter_CellHolder.b(jVar, bVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$DividerHolder;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellDogLogDividerBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter;Lapp/dogo/com/dogo_android/databinding/CellDogLogDividerBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellDogLogDividerBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends j.d {
        public c(o1 o1Var) {
            n.f(jVar, "this$0");
            n.f(o1Var, "binding");
            super(o1Var);
        }
    }
    public j(j.a aVar, List<? extends i> list, String str, boolean z) {
        n.f(aVar, "callback");
        n.f(list, "items");
        super();
        this.callback = aVar;
        this.b = list;
        this.c = str;
        this.items = z;
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            j().add(str);
        }
    }

    /* renamed from: f, reason: from kotlin metadata */
    public static final /* synthetic */ j.a getItemViewType(j position) {
        return position.callback;
    }

    /* renamed from: g, reason: from kotlin metadata */
    public static final /* synthetic */ List handleAddingNewLog(j tagId) {
        return tagId.b;
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ void onBindViewHolder(j holder, String position) {
        holder.handleEditingExistingLog(position);
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ void onCreateViewHolder(j parent, String viewType) {
        parent.m(viewType);
    }

    /* renamed from: l, reason: from kotlin metadata */
    private final void handleEditingExistingLog(String tagId) {
        if (this.selectedTags.contains(tagId)) {
            this.selectedTags.remove(tagId);
        } else {
            this.selectedTags.add(tagId);
        }
    }

    private final void m(String str) {
        int i;
        boolean hasNext;
        boolean z;
        Iterator it2 = this.selectedTags.iterator();
        while (it2.hasNext()) {
            Iterator it = this.b.iterator();
            i = 0;
            while (it.hasNext()) {
                Object item = it.next();
                z = item instanceof DogLogSelection_SelectionItem;
                if (i != 0) {
                    break loop_3;
                }
            }
            i = -1;
            notifyItemChanged(i, Integer.valueOf(i));
            item = it.next();
            z = item instanceof DogLogSelection_SelectionItem;
        }
        this.selectedTags.clear();
        this.selectedTags.add(str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        return DogLogTypeListAdapter_ItemTypes.INSTANCE.a((DogLogSelection)this.b.get(i)).ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final ArrayList<String> j() {
        return this.selectedTags;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final boolean n() {
        return this.items;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void o(j.d dVar, int i) {
        n.f(dVar, "holder");
        z = dVar instanceof DogLogTypeListAdapter_CellHolder;
        if (dVar instanceof DogLogTypeListAdapter_CellHolder) {
            Object item = this.b.get(i);
            Object dVar2 = dVar;
            dVar2.c().V(item.component1());
            dVar2.c().W(Boolean.valueOf(this.selectedTags.contains(item.component1().getTagId())));
        }
        dVar.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public j.d p(ViewGroup viewGroup, int i) throws NoWhenBranchMatchedException {
        app.dogo.com.dogo_android.u.n.p.l.j.b dogLogTypeListAdapter_CellHolder;
        n.f(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        int i3 = app.dogo.com.dogo_android.specialprograms.potty.calendar.logedit.j.f.a[DogLogTypeListAdapter_ItemTypes.values()[i].ordinal()];
        i = 1;
        final boolean z = false;
        if (i3 != 1) {
            i = 2;
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                s1 s1Var = s1.T(from, viewGroup, z);
                str = "inflate(inflater, parent, false)";
                n.e(s1Var, str);
                dogLogTypeListAdapter_CellHolder = new DogLogTypeListAdapter_CellHolder(this, s1Var);
                return dogLogTypeListAdapter_CellHolder;
            }
        }
        o1 o1Var = o1.T(from, viewGroup, z);
        str = "inflate(\n                    inflater,\n                    parent,\n                    false\n                )";
        n.e(o1Var, str);
        app.dogo.com.dogo_android.u.n.p.l.j.c dogLogTypeListAdapter_DividerHolder = new DogLogTypeListAdapter_DividerHolder(this, o1Var);
    }
}
