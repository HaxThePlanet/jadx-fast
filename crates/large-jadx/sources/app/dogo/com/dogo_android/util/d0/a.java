package app.dogo.com.dogo_android.util.d0;

import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.h.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.p;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0008f\u0018\u00002\u00020\u0001JL\u0010\u0002\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0006\u0012\u0002\u0008\u00030\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u00072\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "", "autoNotify", "", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "old", "", "new", "compare", "Lkotlin/Function2;", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface a {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static <T> void a(app.dogo.com.dogo_android.util.d0.a a, RecyclerView.h<?> recyclerView$h2, List<? extends T> list3, List<? extends T> list4, p<? super T, ? super T, Boolean> p5) {
            n.f(a, "this");
            n.f(h2, "receiver");
            n.f(list3, "old");
            n.f(list4, "new");
            n.f(p5, "compare");
            a.a.a obj1 = new a.a.a(p5, list3, list4);
            obj1 = h.b(obj1);
            n.e(obj1, "old: List<T>, new: List<T>, compare: (T, T) -> Boolean) {\n        val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {\n\n            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {\n                return compare(old[oldItemPosition], new[newItemPosition])\n            }\n\n            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {\n                return old[oldItemPosition] == new[newItemPosition]\n            }\n\n            override fun getOldListSize() = old.size\n\n            override fun getNewListSize() = new.size\n        })");
            obj1.c(h2);
        }
    }
}
