package androidx.compose.material3.carousel;

import androidx.compose.ui.util.MathHelpersKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001a\u0008\u0010\u0000\u001a\u00020\u0001H\u0000\u001aC\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0017\u0010\u0008\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0008\u000cH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000e\u001aA\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0017\u0010\u0008\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0008\u000cH\u0000\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0004H\u0000\u001a \u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0004H\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0019", d2 = {"emptyKeylineList", "Landroidx/compose/material3/carousel/KeylineList;", "keylineListOf", "carouselMainAxisSize", "", "itemSpacing", "carouselAlignment", "Landroidx/compose/material3/carousel/CarouselAlignment;", "keylines", "Lkotlin/Function1;", "Landroidx/compose/material3/carousel/KeylineListScope;", "", "Lkotlin/ExtensionFunctionType;", "keylineListOf-WNYm7Xg", "(FFILkotlin/jvm/functions/Function1;)Landroidx/compose/material3/carousel/KeylineList;", "pivotIndex", "", "pivotOffset", "lerp", "Landroidx/compose/material3/carousel/Keyline;", "start", "end", "fraction", "from", "to", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class KeylineListKt {
    public static final androidx.compose.material3.carousel.KeylineList emptyKeylineList() {
        return KeylineList.Companion.getEmpty();
    }

    public static final androidx.compose.material3.carousel.KeylineList keylineListOf(float carouselMainAxisSize, float itemSpacing, int pivotIndex, float pivotOffset, Function1<? super androidx.compose.material3.carousel.KeylineListScope, Unit> keylines) {
        KeylineListScopeImpl keylineListScopeImpl = new KeylineListScopeImpl();
        keylines.invoke(keylineListScopeImpl);
        return keylineListScopeImpl.createWithPivot(carouselMainAxisSize, itemSpacing, pivotIndex, pivotOffset);
    }

    public static final androidx.compose.material3.carousel.KeylineList keylineListOf-WNYm7Xg(float carouselMainAxisSize, float itemSpacing, int carouselAlignment, Function1<? super androidx.compose.material3.carousel.KeylineListScope, Unit> keylines) {
        KeylineListScopeImpl keylineListScopeImpl = new KeylineListScopeImpl();
        keylines.invoke(keylineListScopeImpl);
        return keylineListScopeImpl.createWithAlignment-waks0t8(carouselMainAxisSize, itemSpacing, carouselAlignment);
    }

    public static final androidx.compose.material3.carousel.Keyline lerp(androidx.compose.material3.carousel.Keyline start, androidx.compose.material3.carousel.Keyline end, float fraction) {
        boolean pivot;
        boolean focal;
        boolean anchor;
        int i = 1056964608;
        if (Float.compare(fraction, i) < 0) {
            focal = start.isFocal();
        } else {
            focal = end.isFocal();
        }
        if (Float.compare(fraction, i) < 0) {
            anchor = start.isAnchor();
        } else {
            anchor = end.isAnchor();
        }
        if (Float.compare(fraction, i) < 0) {
            pivot = start.isPivot();
        } else {
            pivot = end.isPivot();
        }
        Keyline keyline = new Keyline(MathHelpersKt.lerp(start.getSize(), end.getSize(), fraction), MathHelpersKt.lerp(start.getOffset(), end.getOffset(), fraction), MathHelpersKt.lerp(start.getUnadjustedOffset(), end.getUnadjustedOffset(), fraction), focal, anchor, pivot, MathHelpersKt.lerp(start.getCutoff(), end.getCutoff(), fraction));
        return keyline;
    }

    public static final androidx.compose.material3.carousel.KeylineList lerp(androidx.compose.material3.carousel.KeylineList from, androidx.compose.material3.carousel.KeylineList to, float fraction) {
        List list;
        int i4;
        int index$iv$iv;
        Object obj2;
        int i;
        Object obj;
        int i5;
        ArrayList list2;
        Object obj3;
        int i6;
        int i3;
        Object obj4;
        Object obj5;
        int i2;
        list = from;
        i4 = 0;
        ArrayList arrayList = new ArrayList((List)list.size());
        List list4 = list;
        final int i7 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list4.size()) {
            i5 = 0;
            i3 = 0;
            (Collection)arrayList.add(KeylineListKt.lerp((Keyline)list4.get(index$iv$iv), to.get(index$iv$iv), fraction));
            index$iv$iv++;
            list = obj5;
            i4 = i2;
        }
        Object $this$fastMapIndexed$iv = list;
        KeylineList keylineList = new KeylineList((List)arrayList);
        return keylineList;
    }
}
