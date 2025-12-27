package d.h.l;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.d0.d.j0.a;
import kotlin.d0.d.n;
import kotlin.j0.h;

/* compiled from: ViewGroup.kt */
@Metadata(d1 = "\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010)\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\u001a\u0015\u0010\u000c\u001a\u00020\r*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0086\n\u001a3\u0010\u000f\u001a\u00020\u0010*\u00020\u00032!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u000e\u0012\u0004\u0012\u00020\u00100\u0012H\u0086\u0008ø\u0001\u0000\u001aH\u0010\u0015\u001a\u00020\u0010*\u00020\u000326\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u0017\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u000e\u0012\u0004\u0012\u00020\u00100\u0016H\u0086\u0008ø\u0001\u0000\u001a\u0015\u0010\u0018\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\tH\u0086\u0002\u001a\r\u0010\u0019\u001a\u00020\r*\u00020\u0003H\u0086\u0008\u001a\r\u0010\u001a\u001a\u00020\r*\u00020\u0003H\u0086\u0008\u001a\u0013\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u001c*\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\u001d\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u001e\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0086\n\u001a\u0017\u0010\u001f\u001a\u00020\u0010*\u00020 2\u0008\u0008\u0001\u0010\u0008\u001a\u00020\tH\u0086\u0008\u001a5\u0010!\u001a\u00020\u0010*\u00020 2\u0008\u0008\u0003\u0010\"\u001a\u00020\t2\u0008\u0008\u0003\u0010#\u001a\u00020\t2\u0008\u0008\u0003\u0010$\u001a\u00020\t2\u0008\u0008\u0003\u0010%\u001a\u00020\tH\u0086\u0008\u001a5\u0010&\u001a\u00020\u0010*\u00020 2\u0008\u0008\u0003\u0010'\u001a\u00020\t2\u0008\u0008\u0003\u0010#\u001a\u00020\t2\u0008\u0008\u0003\u0010(\u001a\u00020\t2\u0008\u0008\u0003\u0010%\u001a\u00020\tH\u0087\u0008\"\u001b\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005\"\u001b\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0005\"\u0016\u0010\u0008\u001a\u00020\t*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000b\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006)", d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "Landroid/view/ViewGroup;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "descendants", "getDescendants", "size", "", "getSize", "(Landroid/view/ViewGroup;)I", "contains", "", "view", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "plusAssign", "setMargins", "Landroid/view/ViewGroup$MarginLayoutParams;", "updateMargins", "left", "top", "right", "bottom", "updateMarginsRelative", "start", "end", "core-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class x {

    @Metadata(d1 = "\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0004H\u0096\u0002¨\u0006\u0005", d2 = {"androidx/core/view/ViewGroupKt$children$1", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "iterator", "", "core-ktx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a implements h<View> {

        final /* synthetic */ ViewGroup a;
        a(ViewGroup viewGroup) {
            this.a = viewGroup;
            super();
        }

        /* operator */ public Iterator<View> iterator() {
            return x.forEach(this.a);
        }
    }

    @Metadata(d1 = "\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0002J\u0008\u0010\u0008\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"androidx/core/view/ViewGroupKt$iterator$1", "", "Landroid/view/View;", "index", "", "hasNext", "", "next", "remove", "", "core-ktx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b implements Iterator<View>, a {

        /* renamed from: a, reason: from kotlin metadata */
        private int index;
        final /* synthetic */ ViewGroup b;
        b(ViewGroup viewGroup) {
            this.b = viewGroup;
            super();
        }

        /* renamed from: c, reason: from kotlin metadata */
        /* operator */ public View hasNext() {
            this.index++;
            View childAt = this.b.getChildAt(this.index);
            if (childAt == null) {
                throw new IndexOutOfBoundsException();
            } else {
                return childAt;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            boolean z = true;
            int r0 = this.index < this.b.getChildCount() ? 1 : 0;
            return (this.index < this.b.getChildCount() ? 1 : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            this.index--;
            this.b.removeViewAt(i);
        }
    }
    public static final View a(ViewGroup viewGroup, int i) {
        n.f(viewGroup, "<this>");
        View childAt = viewGroup.getChildAt(i);
        if (childAt == null) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str2 = "Index: ";
            final String str3 = ", Size: ";
            int childCount = viewGroup.getChildCount();
            viewGroup = str2 + i + str3 + childCount;
            throw new IndexOutOfBoundsException(viewGroup);
        } else {
            return childAt;
        }
    }

    /* renamed from: b, reason: from kotlin metadata */
    /* inline operator */ public static final h<View> contains(ViewGroup view) {
        n.f(view, "<this>");
        return new ViewGroupKt_children_1(view);
    }

    /* renamed from: c, reason: from kotlin metadata */
    /* inline */ public static final Iterator<View> forEach(ViewGroup action) {
        n.f(action, "<this>");
        return new ViewGroupKt_iterator_1(action);
    }
}
