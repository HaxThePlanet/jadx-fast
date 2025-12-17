package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000 *2\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00030\u0002:\u0001*B\u001e\u0012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0008\u0007¢\u0006\u0002\u0010\u0008JZ\u0010\u0017\u001a\u00020\u00062\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0019\u0010\u001a\u001a\u0015\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0005¢\u0006\u0002\u0008\u00072\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u00192\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0008\u001f¢\u0006\u0002\u0008\u0007H\u0016¢\u0006\u0002\u0010 J³\u0001\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#2#\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110#¢\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(&\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00052\u001f\u0010\u001a\u001a\u001b\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001c\u0018\u00010'¢\u0006\u0002\u0008\u00072#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110#¢\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(&\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u000521\u0010(\u001a-\u0012\u0004\u0012\u00020\u001e\u0012\u0013\u0012\u00110#¢\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(&\u0012\u0004\u0012\u00020\u00060'¢\u0006\u0002\u0008\u001f¢\u0006\u0002\u0008\u0007H\u0016¢\u0006\u0002\u0010)R\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u001a\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0010X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006+", d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/lazy/grid/LazyGridInterval;", "content", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "hasCustomSpans", "", "getHasCustomSpans$foundation_release", "()Z", "setHasCustomSpans$foundation_release", "(Z)V", "intervals", "Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "getSpanLayoutProvider$foundation_release", "()Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "item", "key", "", "span", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "items", "count", "", "Lkotlin/ParameterName;", "name", "index", "Lkotlin/Function2;", "itemContent", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyGridIntervalContent extends LazyLayoutIntervalContent<androidx.compose.foundation.lazy.grid.LazyGridInterval> implements androidx.compose.foundation.lazy.grid.LazyGridScope {

    public static final int $stable = 8;
    private static final androidx.compose.foundation.lazy.grid.LazyGridIntervalContent.Companion Companion;
    private static final Function2<androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope, Integer, androidx.compose.foundation.lazy.grid.GridItemSpan> DefaultSpan = 8;
    private boolean hasCustomSpans;
    private final MutableIntervalList<androidx.compose.foundation.lazy.grid.LazyGridInterval> intervals;
    private final androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider spanLayoutProvider;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\u0008\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent$Companion;", "", "()V", "DefaultSpan", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "Lkotlin/ExtensionFunctionType;", "getDefaultSpan", "()Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Function2<androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope, Integer, androidx.compose.foundation.lazy.grid.GridItemSpan> getDefaultSpan() {
            return LazyGridIntervalContent.access$getDefaultSpan$cp();
        }
    }
    static {
        LazyGridIntervalContent.Companion companion = new LazyGridIntervalContent.Companion(0);
        LazyGridIntervalContent.Companion = companion;
        int i = 8;
        androidx.compose.foundation.lazy.grid.LazyGridIntervalContent.Companion.DefaultSpan.1 iNSTANCE = LazyGridIntervalContent.Companion.DefaultSpan.1.INSTANCE;
    }

    public LazyGridIntervalContent(Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, Unit> content) {
        super();
        LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider = new LazyGridSpanLayoutProvider(this);
        this.spanLayoutProvider = lazyGridSpanLayoutProvider;
        MutableIntervalList mutableIntervalList = new MutableIntervalList();
        this.intervals = mutableIntervalList;
        content.invoke(this);
    }

    public static final Function2 access$getDefaultSpan$cp() {
        return LazyGridIntervalContent.DefaultSpan;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    public final boolean getHasCustomSpans$foundation_release() {
        return this.hasCustomSpans;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    public IntervalList getIntervals() {
        return (IntervalList)getIntervals();
    }

    public MutableIntervalList<androidx.compose.foundation.lazy.grid.LazyGridInterval> getIntervals() {
        return this.intervals;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    public final androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider getSpanLayoutProvider$foundation_release() {
        return this.spanLayoutProvider;
    }

    public void item(Object key, Function1<? super androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope, androidx.compose.foundation.lazy.grid.GridItemSpan> span, Object contentType, Function3<? super androidx.compose.foundation.lazy.grid.LazyGridItemScope, ? super Composer, ? super Integer, Unit> content) {
        Object obj;
        int i;
        int anon;
        Function2 defaultSpan;
        if (key != null) {
            obj = key;
            i = 0;
            anon = new LazyGridIntervalContent.item.1.1(key);
        } else {
            anon = 0;
        }
        if (span != null) {
            obj = span;
            i = 0;
            defaultSpan = new LazyGridIntervalContent.item.2.1(span);
        } else {
            defaultSpan = LazyGridIntervalContent.DefaultSpan;
        }
        LazyGridIntervalContent.item.3 anon2 = new LazyGridIntervalContent.item.3(contentType);
        LazyGridIntervalContent.item.4 anon3 = new LazyGridIntervalContent.item.4(content);
        final int i3 = 1;
        LazyGridInterval lazyGridInterval = new LazyGridInterval(anon, defaultSpan, (Function1)anon2, (Function4)ComposableLambdaKt.composableLambdaInstance(-34608120, i3, anon3));
        getIntervals().addInterval(i3, lazyGridInterval);
        if (span != null) {
            this.hasCustomSpans = i3;
        }
    }

    public void items(int count, Function1<? super Integer, ? extends Object> key, Function2<? super androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope, ? super Integer, androidx.compose.foundation.lazy.grid.GridItemSpan> span, Function1<? super Integer, ? extends Object> contentType, Function4<? super androidx.compose.foundation.lazy.grid.LazyGridItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> itemContent) {
        MutableIntervalList intervals;
        Function2 defaultSpan;
        defaultSpan = span == null ? LazyGridIntervalContent.DefaultSpan : span;
        LazyGridInterval lazyGridInterval = new LazyGridInterval(key, defaultSpan, contentType, itemContent);
        getIntervals().addInterval(count, lazyGridInterval);
        if (span != null) {
            this.hasCustomSpans = true;
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    public final void setHasCustomSpans$foundation_release(boolean <set-?>) {
        this.hasCustomSpans = <set-?>;
    }
}
