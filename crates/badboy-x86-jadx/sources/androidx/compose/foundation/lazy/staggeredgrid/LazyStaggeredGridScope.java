package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* loaded from: classes.dex */
@LazyStaggeredGridScopeMarker
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008w\u0018\u00002\u00020\u0001JO\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u001c\u0010\u0008\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\u0008\u000b¢\u0006\u0002\u0008\u000cH&¢\u0006\u0002\u0010\rJ½\u0001\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102%\u0008\u0002\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2%\u0008\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2%\u0008\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t21\u0010\u0014\u001a-\u0012\u0004\u0012\u00020\n\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u00020\u00030\u0015¢\u0006\u0002\u0008\u000b¢\u0006\u0002\u0008\u000cH&¢\u0006\u0002\u0010\u0016\u0082\u0001\u0001\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0018À\u0006\u0001", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "", "item", "", "key", "contentType", "span", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;Lkotlin/jvm/functions/Function3;)V", "items", "count", "", "Lkotlin/ParameterName;", "name", "index", "itemContent", "Lkotlin/Function2;", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridIntervalContent;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LazyStaggeredGridScope {
    public static void item$default(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope lazyStaggeredGridScope, Object object2, Object object3, androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan staggeredGridItemSpan4, Function3 function35, int i6, Object object7) {
        int obj2;
        int obj3;
        int obj4;
        if (object7 != null) {
        } else {
            final int i = 0;
            if (i6 & 1 != 0) {
                obj2 = i;
            }
            if (i6 & 2 != 0) {
                obj3 = i;
            }
            if (i6 &= 4 != 0) {
                obj4 = i;
            }
            lazyStaggeredGridScope.item(obj2, obj3, obj4, function35);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        throw obj1;
    }

    public static void items$default(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope lazyStaggeredGridScope, int i2, Function1 function13, Function1 function14, Function1 function15, Function4 function46, int i7, Object object8) {
        int obj3;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope.items.1 obj4;
        int obj5;
        if (object8 != null) {
        } else {
            final int i = 0;
            if (i7 & 2 != 0) {
                obj3 = i;
            }
            if (i7 & 4 != 0) {
                obj4 = LazyStaggeredGridScope.items.1.INSTANCE;
            }
            if (i7 &= 8 != 0) {
                obj5 = i;
            }
            lazyStaggeredGridScope.items(i2, obj3, obj4, obj5, function46);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        throw obj1;
    }

    public abstract void item(Object object, Object object2, androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan staggeredGridItemSpan3, Function3<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemScope, ? super Composer, ? super Integer, Unit> function34);

    public abstract void items(int i, Function1<? super Integer, ? extends Object> function12, Function1<? super Integer, ? extends Object> function13, Function1<? super Integer, androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan> function14, Function4<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function45);
}
