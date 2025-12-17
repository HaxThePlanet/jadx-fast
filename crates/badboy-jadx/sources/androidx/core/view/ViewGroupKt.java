package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010)\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\u001a\u0015\u0010\u0010\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\n\u001a0\u0010\u0013\u001a\u00020\u0014*\u00020\u00032!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0017\u0012\u0008\u0008\u0018\u0012\u0004\u0008\u0008(\u0012\u0012\u0004\u0012\u00020\u00140\u0016H\u0086\u0008\u001aE\u0010\u0019\u001a\u00020\u0014*\u00020\u000326\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\u000c\u0008\u0017\u0012\u0008\u0008\u0018\u0012\u0004\u0008\u0008(\u001b\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0017\u0012\u0008\u0008\u0018\u0012\u0004\u0008\u0008(\u0012\u0012\u0004\u0012\u00020\u00140\u001aH\u0086\u0008\u001a\u0015\u0010\u001c\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u001b\u001a\u00020\rH\u0086\u0002\u001a\r\u0010\u001d\u001a\u00020\u0011*\u00020\u0003H\u0086\u0008\u001a\r\u0010\u001e\u001a\u00020\u0011*\u00020\u0003H\u0086\u0008\u001a\u0013\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00020 *\u00020\u0003H\u0086\u0002\u001a\u0015\u0010!\u001a\u00020\u0014*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\"\u001a\u00020\u0014*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\n\u001a\u0017\u0010#\u001a\u00020\u0014*\u00020$2\u0008\u0008\u0001\u0010\u000c\u001a\u00020\rH\u0086\u0008\u001a5\u0010%\u001a\u00020\u0014*\u00020$2\u0008\u0008\u0003\u0010&\u001a\u00020\r2\u0008\u0008\u0003\u0010'\u001a\u00020\r2\u0008\u0008\u0003\u0010(\u001a\u00020\r2\u0008\u0008\u0003\u0010)\u001a\u00020\rH\u0086\u0008\u001a5\u0010*\u001a\u00020\u0014*\u00020$2\u0008\u0008\u0003\u0010+\u001a\u00020\r2\u0008\u0008\u0003\u0010'\u001a\u00020\r2\u0008\u0008\u0003\u0010,\u001a\u00020\r2\u0008\u0008\u0003\u0010)\u001a\u00020\rH\u0086\u0008\"\u001b\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005\"\u001b\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0005\"\u0016\u0010\u0008\u001a\u00020\t*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000b\"\u0016\u0010\u000c\u001a\u00020\r*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006-", d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "Landroid/view/ViewGroup;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "descendants", "getDescendants", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "(Landroid/view/ViewGroup;)Lkotlin/ranges/IntRange;", "size", "", "getSize", "(Landroid/view/ViewGroup;)I", "contains", "", "view", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "plusAssign", "setMargins", "Landroid/view/ViewGroup$MarginLayoutParams;", "updateMargins", "left", "top", "right", "bottom", "updateMarginsRelative", "start", "end", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ViewGroupKt {
    public static final boolean contains(ViewGroup $this$contains, View view) {
        int i;
        final int i2 = 0;
        i = $this$contains.indexOfChild(view) != -1 ? 1 : 0;
        return i;
    }

    public static final void forEach(ViewGroup $this$forEach, Function1<? super View, Unit> action) {
        int index;
        View childAt;
        final int i = 0;
        index = 0;
        while (index < $this$forEach.getChildCount()) {
            action.invoke($this$forEach.getChildAt(index));
            index++;
        }
    }

    public static final void forEachIndexed(ViewGroup $this$forEachIndexed, Function2<? super Integer, ? super View, Unit> action) {
        int index;
        Integer valueOf;
        View childAt;
        final int i = 0;
        index = 0;
        while (index < $this$forEachIndexed.getChildCount()) {
            action.invoke(Integer.valueOf(index), $this$forEachIndexed.getChildAt(index));
            index++;
        }
    }

    public static final View get(ViewGroup $this$get, int index) {
        View childAt = $this$get.getChildAt(index);
        if (childAt == null) {
        } else {
            return childAt;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("Index: ").append(index).append(", Size: ").append($this$get.getChildCount()).toString());
        throw indexOutOfBoundsException;
    }

    public static final Sequence<View> getChildren(ViewGroup $this$children) {
        ViewGroupKt.children.1 anon = new ViewGroupKt.children.1($this$children);
        return (Sequence)anon;
    }

    public static final Sequence<View> getDescendants(ViewGroup $this$descendants) {
        ViewGroupKt.special$$inlined.Sequence.1 anon = new ViewGroupKt.special$$inlined.Sequence.1($this$descendants);
        return (Sequence)anon;
    }

    public static final IntRange getIndices(ViewGroup $this$indices) {
        final int i = 0;
        return RangesKt.until(0, $this$indices.getChildCount());
    }

    public static final int getSize(ViewGroup $this$size) {
        final int i = 0;
        return $this$size.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup $this$isEmpty) {
        int i;
        final int i2 = 0;
        i = $this$isEmpty.getChildCount() == 0 ? 1 : 0;
        return i;
    }

    public static final boolean isNotEmpty(ViewGroup $this$isNotEmpty) {
        int i;
        final int i2 = 0;
        i = $this$isNotEmpty.getChildCount() != 0 ? 1 : 0;
        return i;
    }

    public static final Iterator<View> iterator(ViewGroup $this$iterator) {
        ViewGroupKt.iterator.1 anon = new ViewGroupKt.iterator.1($this$iterator);
        return (Iterator)anon;
    }

    public static final void minusAssign(ViewGroup $this$minusAssign, View view) {
        final int i = 0;
        $this$minusAssign.removeView(view);
    }

    public static final void plusAssign(ViewGroup $this$plusAssign, View view) {
        final int i = 0;
        $this$plusAssign.addView(view);
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams $this$setMargins, int size) {
        final int i = 0;
        $this$setMargins.setMargins(size, size, size, size);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams $this$updateMargins, int left, int top, int right, int bottom) {
        final int i = 0;
        $this$updateMargins.setMargins(left, top, right, bottom);
    }

    public static void updateMargins$default(ViewGroup.MarginLayoutParams $this$updateMargins_u24default, int left, int top, int right, int bottom, int i6, Object object7) {
        int obj1;
        int obj2;
        int obj3;
        int obj4;
        if (i6 & 1 != 0) {
            obj1 = $this$updateMargins_u24default.leftMargin;
        }
        if (i6 & 2 != 0) {
            obj2 = $this$updateMargins_u24default.topMargin;
        }
        if (i6 & 4 != 0) {
            obj3 = $this$updateMargins_u24default.rightMargin;
        }
        if (i6 &= 8 != 0) {
            obj4 = $this$updateMargins_u24default.bottomMargin;
        }
        int obj5 = 0;
        $this$updateMargins_u24default.setMargins(obj1, obj2, obj3, obj4);
    }

    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams $this$updateMarginsRelative, int start, int top, int end, int bottom) {
        final int i = 0;
        $this$updateMarginsRelative.setMarginStart(start);
        $this$updateMarginsRelative.topMargin = top;
        $this$updateMarginsRelative.setMarginEnd(end);
        $this$updateMarginsRelative.bottomMargin = bottom;
    }

    public static void updateMarginsRelative$default(ViewGroup.MarginLayoutParams $this$updateMarginsRelative_u24default, int start, int top, int end, int bottom, int i6, Object object7) {
        int obj1;
        int obj2;
        int obj3;
        int obj4;
        if (i6 & 1 != 0) {
            obj1 = $this$updateMarginsRelative_u24default.getMarginStart();
        }
        if (i6 & 2 != 0) {
            obj2 = $this$updateMarginsRelative_u24default.topMargin;
        }
        if (i6 & 4 != 0) {
            obj3 = $this$updateMarginsRelative_u24default.getMarginEnd();
        }
        if (i6 &= 8 != 0) {
            obj4 = $this$updateMarginsRelative_u24default.bottomMargin;
        }
        int obj5 = 0;
        $this$updateMarginsRelative_u24default.setMarginStart(obj1);
        $this$updateMarginsRelative_u24default.topMargin = obj2;
        $this$updateMarginsRelative_u24default.setMarginEnd(obj3);
        $this$updateMarginsRelative_u24default.bottomMargin = obj4;
    }
}
