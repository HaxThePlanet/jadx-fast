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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0015\u0016B'\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\u000c\u001a\u00020\u000bH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/settings/language/LanguageSelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/settings/language/LanguageSelectAdapter$Holder;", "list", "", "", "initialSelectedLanguage", "callback", "Lapp/dogo/com/dogo_android/settings/language/LanguageSelectAdapter$Callbacks;", "(Ljava/util/List;Ljava/lang/String;Lapp/dogo/com/dogo_android/settings/language/LanguageSelectAdapter$Callbacks;)V", "lastSelectedPosition", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "Holder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends RecyclerView.h<app.dogo.com.dogo_android.t.h0.i.b> {

    private final List<String> a;
    private final app.dogo.com.dogo_android.t.h0.i.a b;
    private int c;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/settings/language/LanguageSelectAdapter$Callbacks;", "", "onLanguageSelected", "", "language", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void P(String string);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/settings/language/LanguageSelectAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellRowLanguageRowBinding;", "(Lapp/dogo/com/dogo_android/settings/language/LanguageSelectAdapter;Lapp/dogo/com/dogo_android/databinding/CellRowLanguageRowBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellRowLanguageRowBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends RecyclerView.e0 {

        private final w6 a;
        final app.dogo.com.dogo_android.t.h0.i b;
        public b(app.dogo.com.dogo_android.t.h0.i i, w6 w62) {
            n.f(i, "this$0");
            n.f(w62, "binding");
            this.b = i;
            super(w62.w());
            this.a = w62;
            a aVar = new a(i, this);
            w62.w().setOnClickListener(aVar);
        }

        private static final void a(app.dogo.com.dogo_android.t.h0.i i, app.dogo.com.dogo_android.t.h0.i.b i$b2, View view3) {
            n.f(i, "this$0");
            n.f(b2, "this$1");
            i.i(i, b2.getAdapterPosition());
            Integer valueOf = 0;
            i.notifyItemChanged(i.g(i), valueOf);
            i.notifyItemChanged(b2.getAdapterPosition(), valueOf);
            final app.dogo.com.dogo_android.t.h0.i.a obj2 = i.f(i);
            if (obj2 == null) {
            } else {
                obj2.P((String)i.h(i).get(b2.getAdapterPosition()));
            }
        }

        public static void c(app.dogo.com.dogo_android.t.h0.i i, app.dogo.com.dogo_android.t.h0.i.b i$b2, View view3) {
            i.b.a(i, b2, view3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final w6 b() {
            return this.a;
        }
    }
    public i(List<String> list, String string2, app.dogo.com.dogo_android.t.h0.i.a i$a3) {
        n.f(list, "list");
        super();
        this.a = list;
        this.b = a3;
        this.c = g.b(p.c0(list, string2), 0);
    }

    public static final app.dogo.com.dogo_android.t.h0.i.a f(app.dogo.com.dogo_android.t.h0.i i) {
        return i.b;
    }

    public static final int g(app.dogo.com.dogo_android.t.h0.i i) {
        return i.c;
    }

    public static final List h(app.dogo.com.dogo_android.t.h0.i i) {
        return i.a;
    }

    public static final void i(app.dogo.com.dogo_android.t.h0.i i, int i2) {
        i.c = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void j(app.dogo.com.dogo_android.t.h0.i.b i$b, int i2) {
        int obj4;
        n.f(b, "holder");
        b.b().V((String)this.a.get(i2));
        obj4 = i2 == this.c ? 1 : 0;
        w6Var.O.setChecked(obj4);
        b.b().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.t.h0.i.b l(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final w6 obj3 = w6.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj3, "inflate(inflater, parent, false)");
        i.b bVar = new i.b(this, obj3);
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        j((i.b)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return l(viewGroup, i2);
    }
}
