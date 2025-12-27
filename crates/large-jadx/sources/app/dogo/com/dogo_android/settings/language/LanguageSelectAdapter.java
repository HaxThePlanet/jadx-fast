package app.dogo.com.dogo_android.t.h0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.w6;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.y.p;

/* compiled from: LanguageSelectAdapter.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0015\u0016B'\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\u000c\u001a\u00020\u000bH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/settings/language/LanguageSelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/settings/language/LanguageSelectAdapter$Holder;", "list", "", "", "initialSelectedLanguage", "callback", "Lapp/dogo/com/dogo_android/settings/language/LanguageSelectAdapter$Callbacks;", "(Ljava/util/List;Ljava/lang/String;Lapp/dogo/com/dogo_android/settings/language/LanguageSelectAdapter$Callbacks;)V", "lastSelectedPosition", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "Holder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final class LanguageSelectAdapter extends RecyclerView.h<i.b> {

    /* renamed from: a, reason: from kotlin metadata */
    private final List<String> callback;
    /* renamed from: b, reason: from kotlin metadata */
    private final i.a lastSelectedPosition;
    /* renamed from: c, reason: from kotlin metadata */
    private int list;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/settings/language/LanguageSelectAdapter$Callbacks;", "", "onLanguageSelected", "", "language", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: P, reason: from kotlin metadata */
        void onLanguageSelected(String language);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/settings/language/LanguageSelectAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellRowLanguageRowBinding;", "(Lapp/dogo/com/dogo_android/settings/language/LanguageSelectAdapter;Lapp/dogo/com/dogo_android/databinding/CellRowLanguageRowBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellRowLanguageRowBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends RecyclerView.e0 {

        private final w6 a;
        final /* synthetic */ i b;
        public b(w6 w6Var) {
            n.f(iVar, "this$0");
            n.f(w6Var, "binding");
            this.b = iVar;
            super(w6Var.w());
            this.a = w6Var;
            w6Var.w().setOnClickListener(new app.dogo.com.dogo_android.settings.language.a(iVar, this));
        }

        private static final void a(i iVar, i.b bVar, View view) {
            n.f(iVar, "this$0");
            n.f(bVar, "this$1");
            iVar.list = bVar.getAdapterPosition();
            Integer num = 0;
            iVar.notifyItemChanged(iVar.list, num);
            iVar.notifyItemChanged(bVar.getAdapterPosition(), num);
            final app.dogo.com.dogo_android.t.h0.i.a aVar = iVar.lastSelectedPosition;
            if (aVar != null) {
                aVar.onLanguageSelected((String)iVar.callback.get(bVar.getAdapterPosition()));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final w6 b() {
            return this.a;
        }

        public static /* synthetic */ void c(i iVar, i.b bVar, View view) {
            LanguageSelectAdapter_Holder.a(iVar, bVar, view);
        }
    }
    public i(List<String> list, String str, i.a aVar) {
        n.f(list, "list");
        super();
        this.callback = list;
        this.lastSelectedPosition = aVar;
        this.list = g.b(p.c0(list, str), 0);
    }

    public static final /* synthetic */ i.a f(i iVar) {
        return iVar.lastSelectedPosition;
    }

    public static final /* synthetic */ int g(i iVar) {
        return iVar.list;
    }

    public static final /* synthetic */ List h(i iVar) {
        return iVar.callback;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ void onBindViewHolder(i holder, int position) {
        holder.list = position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.callback.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: j, reason: from kotlin metadata */
    public void onCreateViewHolder(i.b parent, int viewType) {
        boolean z = true;
        n.f(parent, "holder");
        parent.b().V((String)this.callback.get(viewType));
        viewType = viewType == this.list ? 1 : 0;
        parent.b().O.setChecked((viewType == this.list ? 1 : 0));
        parent.b().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public i.b l(ViewGroup viewGroup, int i) {
        n.f(viewGroup, "parent");
        final w6 w6Var = w6.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(w6Var, "inflate(inflater, parent, false)");
        return new LanguageSelectAdapter_Holder(this, w6Var);
    }
}
