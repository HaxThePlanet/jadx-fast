package app.dogo.com.dogo_android.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.e1;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ClickerSelectAdapter.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u0000 \u001c2\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003\u001b\u001c\u001dB%\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0008\u0010\u0012\u001a\u00020\tH\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter$Holder;", "list", "", "", "callback", "Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter$Callbacks;", "initialSelection", "", "(Ljava/util/List;Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter$Callbacks;I)V", "getCallback", "()Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter$Callbacks;", "clickTimeout", "", "lastSelectedPosition", "getList", "()Ljava/util/List;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "Companion", "Holder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k, reason: from kotlin metadata */
public final class ClickerSelectAdapter extends RecyclerView.h<k.c> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final k.b INSTANCE = new k$b(0);
    private final List<String> a;
    /* renamed from: b, reason: from kotlin metadata */
    private final k.a clickTimeout;
    /* renamed from: c, reason: from kotlin metadata */
    private long lastSelectedPosition;
    private int d;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter$Callbacks;", "", "onSelected", "", "position", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: l, reason: from kotlin metadata */
        void onSelected(int position);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter$Companion;", "", "()V", "CLICK_TIMEOUT_VALUE_MS", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b {
        private b() {
            super();
        }

        public /* synthetic */ b(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellClickerSelectRowBinding;", "(Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter;Lapp/dogo/com/dogo_android/databinding/CellClickerSelectRowBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellClickerSelectRowBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends RecyclerView.e0 {

        private final e1 a;
        final /* synthetic */ k b;
        public c(e1 e1Var) {
            n.f(kVar, "this$0");
            n.f(e1Var, "binding");
            this.b = kVar;
            super(e1Var.w());
            this.a = e1Var;
            e1Var.w().setOnClickListener(new app.dogo.com.dogo_android.clicker.d(kVar, this));
        }

        private static final void a(k kVar, k.c cVar, View view) {
            n.f(kVar, "this$0");
            n.f(cVar, "this$1");
            long time = System.currentTimeMillis();
            long l3 = kVar.lastSelectedPosition + (long)300;
            if (time > l3) {
                kVar.lastSelectedPosition = System.currentTimeMillis();
                kVar.d = cVar.getAdapterPosition();
                int i = 0;
                kVar.notifyItemChanged(kVar.d, Integer.valueOf(i));
                kVar.notifyItemChanged(cVar.getAdapterPosition(), Integer.valueOf(i));
                kVar.j().onSelected(cVar.getAdapterPosition());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final e1 b() {
            return this.a;
        }

        public static /* synthetic */ void c(k kVar, k.c cVar, View view) {
            ClickerSelectAdapter_Holder.a(kVar, cVar, view);
        }
    }
    public k(List<String> list, k.a aVar, int i) {
        n.f(list, "list");
        n.f(aVar, "callback");
        super();
        this.a = list;
        this.clickTimeout = aVar;
        this.d = g.b(i, 0);
    }

    public static final /* synthetic */ long f(k kVar) {
        return kVar.lastSelectedPosition;
    }

    public static final /* synthetic */ int g(k kVar) {
        return kVar.d;
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ void onBindViewHolder(k holder, long position) {
        holder.lastSelectedPosition = position;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ void onCreateViewHolder(k parent, int viewType) {
        parent.d = viewType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final k.a j() {
        return this.clickTimeout;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void l(k.c cVar, int i) {
        boolean z = true;
        n.f(cVar, "holder");
        cVar.b().V((String)this.a.get(i));
        i = i == this.d ? 1 : 0;
        cVar.b().O.setChecked((i == this.d ? 1 : 0));
        cVar.b().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public k.c m(ViewGroup viewGroup, int i) {
        n.f(viewGroup, "parent");
        final e1 e1Var = e1.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(e1Var, "inflate(inflater, parent, false)");
        return new ClickerSelectAdapter_Holder(this, e1Var);
    }

}
