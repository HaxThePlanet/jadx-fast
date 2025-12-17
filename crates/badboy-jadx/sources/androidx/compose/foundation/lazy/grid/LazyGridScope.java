package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* loaded from: classes.dex */
@LazyGridScopeMarker
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008w\u0018\u00002\u00020\u0001J`\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u001b\u0008\u0002\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0006¢\u0006\u0002\u0008\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00012\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0008\r¢\u0006\u0002\u0008\tH&¢\u0006\u0002\u0010\u000eJÈ\u0001\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112%\u0008\u0002\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000620\u0008\u0002\u0010\u0005\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0014\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0015¢\u0006\u0002\u0008\t2%\u0008\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000621\u0010\u0016\u001a-\u0012\u0004\u0012\u00020\u000c\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0014\u0012\u0004\u0012\u00020\u00030\u0015¢\u0006\u0002\u0008\r¢\u0006\u0002\u0008\tH&¢\u0006\u0002\u0010\u0017\u0082\u0001\u0001\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0019À\u0006\u0001", d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "", "item", "", "key", "span", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "Lkotlin/ExtensionFunctionType;", "contentType", "content", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "items", "count", "", "Lkotlin/ParameterName;", "name", "index", "Lkotlin/Function2;", "itemContent", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LazyGridScope {
    public static void item$default(androidx.compose.foundation.lazy.grid.LazyGridScope lazyGridScope, Object object2, Function1 function13, Object object4, Function3 function35, int i6, Object object7) {
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
            lazyGridScope.item(obj2, obj3, obj4, function35);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        throw obj1;
    }

    public static void items$default(androidx.compose.foundation.lazy.grid.LazyGridScope lazyGridScope, int i2, Function1 function13, Function2 function24, Function1 function15, Function4 function46, int i7, Object object8) {
        int obj3;
        int obj4;
        androidx.compose.foundation.lazy.grid.LazyGridScope.items.1 obj5;
        if (object8 != null) {
        } else {
            final int i = 0;
            if (i7 & 2 != 0) {
                obj3 = i;
            }
            if (i7 & 4 != 0) {
                obj4 = i;
            }
            if (i7 &= 8 != 0) {
                obj5 = LazyGridScope.items.1.INSTANCE;
            }
            lazyGridScope.items(i2, obj3, obj4, obj5, function46);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        throw obj1;
    }

    public abstract void item(Object object, Function1<? super androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope, androidx.compose.foundation.lazy.grid.GridItemSpan> function12, Object object3, Function3<? super androidx.compose.foundation.lazy.grid.LazyGridItemScope, ? super Composer, ? super Integer, Unit> function34);

    public abstract void items(int i, Function1<? super Integer, ? extends Object> function12, Function2<? super androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope, ? super Integer, androidx.compose.foundation.lazy.grid.GridItemSpan> function23, Function1<? super Integer, ? extends Object> function14, Function4<? super androidx.compose.foundation.lazy.grid.LazyGridItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function45);
}
