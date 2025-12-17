package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010)\n\u0002\u0008\u0003\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u0002H\u0086\u0002\u001a0\u0010\r\u001a\u00020\u000e*\u00020\u00032!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\u0008\u001aE\u0010\u0013\u001a\u00020\u000e*\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u00020\u000e0\u0014H\u0086\u0008\u001a\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\n\u001a\r\u0010\u0017\u001a\u00020\u000b*\u00020\u0003H\u0086\u0008\u001a\r\u0010\u0018\u001a\u00020\u000b*\u00020\u0003H\u0086\u0008\u001a\u0013\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u001a*\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\u001b\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u001c\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\u0008\"\u001b\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u001d", d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroid/view/MenuItem;", "Landroid/view/Menu;", "getChildren", "(Landroid/view/Menu;)Lkotlin/sequences/Sequence;", "size", "", "getSize", "(Landroid/view/Menu;)I", "contains", "", "item", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "removeItemAt", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MenuKt {
    public static final boolean contains(Menu $this$contains, MenuItem item) {
        int index;
        boolean equal;
        index = 0;
        while (index < $this$contains.size()) {
            index++;
        }
        return 0;
    }

    public static final void forEach(Menu $this$forEach, Function1<? super MenuItem, Unit> action) {
        int index;
        MenuItem item;
        final int i = 0;
        index = 0;
        while (index < $this$forEach.size()) {
            action.invoke($this$forEach.getItem(index));
            index++;
        }
    }

    public static final void forEachIndexed(Menu $this$forEachIndexed, Function2<? super Integer, ? super MenuItem, Unit> action) {
        int index;
        Integer valueOf;
        MenuItem item;
        final int i = 0;
        index = 0;
        while (index < $this$forEachIndexed.size()) {
            action.invoke(Integer.valueOf(index), $this$forEachIndexed.getItem(index));
            index++;
        }
    }

    public static final MenuItem get(Menu $this$get, int index) {
        final int i = 0;
        return $this$get.getItem(index);
    }

    public static final Sequence<MenuItem> getChildren(Menu $this$children) {
        MenuKt.children.1 anon = new MenuKt.children.1($this$children);
        return (Sequence)anon;
    }

    public static final int getSize(Menu $this$size) {
        final int i = 0;
        return $this$size.size();
    }

    public static final boolean isEmpty(Menu $this$isEmpty) {
        int i;
        final int i2 = 0;
        i = $this$isEmpty.size() == 0 ? 1 : 0;
        return i;
    }

    public static final boolean isNotEmpty(Menu $this$isNotEmpty) {
        int i;
        final int i2 = 0;
        i = $this$isNotEmpty.size() != 0 ? 1 : 0;
        return i;
    }

    public static final Iterator<MenuItem> iterator(Menu $this$iterator) {
        MenuKt.iterator.1 anon = new MenuKt.iterator.1($this$iterator);
        return (Iterator)anon;
    }

    public static final void minusAssign(Menu $this$minusAssign, MenuItem item) {
        final int i = 0;
        $this$minusAssign.removeItem(item.getItemId());
    }

    public static final void removeItemAt(Menu $this$removeItemAt, int index) {
        Unit it;
        int i;
        int itemId;
        final int i2 = 0;
        MenuItem item = $this$removeItemAt.getItem(index);
        if (item != null) {
            i = 0;
            $this$removeItemAt.removeItem(item.getItemId());
            it = Unit.INSTANCE;
        } else {
            it = 0;
        }
        if (it == null) {
        } else {
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
        throw indexOutOfBoundsException;
    }
}
