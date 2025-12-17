package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0000\u0018\u00002\u00020\u0001B\u0092\u0001\u0012#\u0010\u0002\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0003\u0012\u001d\u0010\t\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000c0\n¢\u0006\u0002\u0008\r\u0012#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0003\u0012\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\n¢\u0006\u0002\u0008\u0012¢\u0006\u0002\u0008\r¢\u0006\u0002\u0010\u0013R/\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\n¢\u0006\u0002\u0008\u0012¢\u0006\u0002\u0008\r¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008\u0014\u0010\u0015R1\u0010\u0002\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R(\u0010\t\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000c0\n¢\u0006\u0002\u0008\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR1\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0018¨\u0006\u001c", d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridInterval;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent$Interval;", "key", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "index", "", "span", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "Lkotlin/ExtensionFunctionType;", "type", "item", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "getItem", "()Lkotlin/jvm/functions/Function4;", "Lkotlin/jvm/functions/Function4;", "getKey", "()Lkotlin/jvm/functions/Function1;", "getSpan", "()Lkotlin/jvm/functions/Function2;", "getType", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyGridInterval implements LazyLayoutIntervalContent.Interval {

    public static final int $stable;
    private final Function4<androidx.compose.foundation.lazy.grid.LazyGridItemScope, Integer, Composer, Integer, Unit> item;
    private final Function1<Integer, Object> key;
    private final Function2<androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope, Integer, androidx.compose.foundation.lazy.grid.GridItemSpan> span;
    private final Function1<Integer, Object> type;
    static {
    }

    public LazyGridInterval(Function1<? super Integer, ? extends Object> key, Function2<? super androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope, ? super Integer, androidx.compose.foundation.lazy.grid.GridItemSpan> span, Function1<? super Integer, ? extends Object> type, Function4<? super androidx.compose.foundation.lazy.grid.LazyGridItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> item) {
        super();
        this.key = key;
        this.span = span;
        this.type = type;
        this.item = item;
    }

    public final Function4<androidx.compose.foundation.lazy.grid.LazyGridItemScope, Integer, Composer, Integer, Unit> getItem() {
        return this.item;
    }

    public Function1<Integer, Object> getKey() {
        return this.key;
    }

    public final Function2<androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope, Integer, androidx.compose.foundation.lazy.grid.GridItemSpan> getSpan() {
        return this.span;
    }

    public Function1<Integer, Object> getType() {
        return this.type;
    }
}
