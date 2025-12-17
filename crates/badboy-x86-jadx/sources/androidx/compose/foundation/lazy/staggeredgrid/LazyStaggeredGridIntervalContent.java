package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00030\u0002B\u001e\u0012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0008\u0007¢\u0006\u0002\u0010\u0008JI\u0010\u0011\u001a\u00020\u00062\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0008\u0018¢\u0006\u0002\u0008\u0007H\u0016¢\u0006\u0002\u0010\u0019J·\u0001\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2#\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u001c¢\u0006\u000c\u0008\u001d\u0012\u0008\u0008\u001e\u0012\u0004\u0008\u0008(\u001f\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00052#\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u001c¢\u0006\u000c\u0008\u001d\u0012\u0008\u0008\u001e\u0012\u0004\u0008\u0008(\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00052#\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u001c¢\u0006\u000c\u0008\u001d\u0012\u0008\u0008\u001e\u0012\u0004\u0008\u0008(\u001f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000521\u0010 \u001a-\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\u001c¢\u0006\u000c\u0008\u001d\u0012\u0008\u0008\u001e\u0012\u0004\u0008\u0008(\u001f\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\u0008\u0018¢\u0006\u0002\u0008\u0007H\u0016¢\u0006\u0002\u0010\"R\u001a\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00030\nX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006#", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridIntervalContent;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridInterval;", "content", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "intervals", "Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "spanProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "getSpanProvider", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "item", "key", "", "contentType", "span", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;Lkotlin/jvm/functions/Function3;)V", "items", "count", "", "Lkotlin/ParameterName;", "name", "index", "itemContent", "Lkotlin/Function2;", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridIntervalContent extends LazyLayoutIntervalContent<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridInterval> implements androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope {

    public static final int $stable = 8;
    private final MutableIntervalList<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridInterval> intervals;
    private final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSpanProvider spanProvider;
    static {
        final int i = 8;
    }

    public LazyStaggeredGridIntervalContent(Function1<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope, Unit> content) {
        super();
        MutableIntervalList mutableIntervalList = new MutableIntervalList();
        this.intervals = mutableIntervalList;
        LazyStaggeredGridSpanProvider lazyStaggeredGridSpanProvider = new LazyStaggeredGridSpanProvider((IntervalList)getIntervals());
        this.spanProvider = lazyStaggeredGridSpanProvider;
        content.invoke(this);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    public IntervalList getIntervals() {
        return (IntervalList)getIntervals();
    }

    public MutableIntervalList<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridInterval> getIntervals() {
        return this.intervals;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    public final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSpanProvider getSpanProvider() {
        return this.spanProvider;
    }

    public void item(Object key, Object contentType, androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan span, Function3<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemScope, ? super Composer, ? super Integer, Unit> content) {
        int it;
        Object obj;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridIntervalContent.item.2 anon;
        int anon3;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridIntervalContent.item.1.1 anon2;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridIntervalContent.item.1.1 anon4;
        int i;
        it = 0;
        if (key != null) {
            obj = key;
            anon3 = 0;
            anon2 = new LazyStaggeredGridIntervalContent.item.1.1(key);
            anon4 = anon2;
        } else {
            anon4 = it;
        }
        anon = new LazyStaggeredGridIntervalContent.item.2(contentType);
        if (span != null) {
            androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan staggeredGridItemSpan = span;
            anon = 0;
            anon3 = new LazyStaggeredGridIntervalContent.item.3.1(span);
            i = it;
        } else {
            i = it;
        }
        LazyStaggeredGridIntervalContent.item.4 anon5 = new LazyStaggeredGridIntervalContent.item.4(content);
        this.items(1, anon4, (Function1)anon, i, (Function4)ComposableLambdaKt.composableLambdaInstance(657818596, true, anon5));
    }

    public void items(int count, Function1<? super Integer, ? extends Object> key, Function1<? super Integer, ? extends Object> contentType, Function1<? super Integer, androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan> span, Function4<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> itemContent) {
        LazyStaggeredGridInterval lazyStaggeredGridInterval = new LazyStaggeredGridInterval(key, contentType, span, itemContent);
        getIntervals().addInterval(count, lazyStaggeredGridInterval);
    }
}
