package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001e\u0012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0008\u0007¢\u0006\u0002\u0010\u0008J?\u0010\u0014\u001a\u00020\u00062\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0008\u0019¢\u0006\u0002\u0008\u0007H\u0016¢\u0006\u0002\u0010\u001aJ\u0092\u0001\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000b2#\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\u000c\u0008\u001d\u0012\u0008\u0008\u001e\u0012\u0004\u0008\u0008(\u001f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00052#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\u000c\u0008\u001d\u0012\u0008\u0008\u001e\u0012\u0004\u0008\u0008(\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000521\u0010 \u001a-\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u000b¢\u0006\u000c\u0008\u001d\u0012\u0008\u0008\u001e\u0012\u0004\u0008\u0008(\u001f\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\u0008\u0019¢\u0006\u0002\u0008\u0007H\u0016¢\u0006\u0002\u0010\"J?\u0010#\u001a\u00020\u00062\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0008\u0019¢\u0006\u0002\u0008\u0007H\u0017¢\u0006\u0002\u0010\u001aR\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\r8F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0011X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006$", d2 = {"Landroidx/compose/foundation/lazy/LazyListIntervalContent;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/lazy/LazyListInterval;", "Landroidx/compose/foundation/lazy/LazyListScope;", "content", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "_headerIndexes", "", "", "headerIndexes", "", "getHeaderIndexes", "()Ljava/util/List;", "intervals", "Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "item", "key", "", "contentType", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "items", "count", "Lkotlin/ParameterName;", "name", "index", "itemContent", "Lkotlin/Function2;", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "stickyHeader", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyListIntervalContent extends LazyLayoutIntervalContent<androidx.compose.foundation.lazy.LazyListInterval> implements androidx.compose.foundation.lazy.LazyListScope {

    public static final int $stable = 8;
    private List<Integer> _headerIndexes;
    private final MutableIntervalList<androidx.compose.foundation.lazy.LazyListInterval> intervals;
    static {
        final int i = 8;
    }

    public LazyListIntervalContent(Function1<? super androidx.compose.foundation.lazy.LazyListScope, Unit> content) {
        super();
        MutableIntervalList mutableIntervalList = new MutableIntervalList();
        this.intervals = mutableIntervalList;
        content.invoke(this);
    }

    public final List<Integer> getHeaderIndexes() {
        List _headerIndexes;
        if (this._headerIndexes == null) {
            _headerIndexes = CollectionsKt.emptyList();
        }
        return _headerIndexes;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    public IntervalList getIntervals() {
        return (IntervalList)getIntervals();
    }

    public MutableIntervalList<androidx.compose.foundation.lazy.LazyListInterval> getIntervals() {
        return this.intervals;
    }

    public void item(Object key, Object contentType, Function3<? super androidx.compose.foundation.lazy.LazyItemScope, ? super Composer, ? super Integer, Unit> content) {
        androidx.compose.foundation.lazy.LazyListIntervalContent.item.1 anon;
        if (key != null) {
            anon = new LazyListIntervalContent.item.1(key);
        } else {
            anon = 0;
        }
        LazyListIntervalContent.item.2 anon2 = new LazyListIntervalContent.item.2(contentType);
        LazyListIntervalContent.item.3 anon3 = new LazyListIntervalContent.item.3(content);
        final int i2 = 1;
        LazyListInterval lazyListInterval = new LazyListInterval(anon, (Function1)anon2, (Function4)ComposableLambdaKt.composableLambdaInstance(-1010194746, i2, anon3));
        getIntervals().addInterval(i2, lazyListInterval);
    }

    public void items(int count, Function1<? super Integer, ? extends Object> key, Function1<? super Integer, ? extends Object> contentType, Function4<? super androidx.compose.foundation.lazy.LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> itemContent) {
        LazyListInterval lazyListInterval = new LazyListInterval(key, contentType, itemContent);
        getIntervals().addInterval(count, lazyListInterval);
    }

    public void stickyHeader(Object key, Object contentType, Function3<? super androidx.compose.foundation.lazy.LazyItemScope, ? super Composer, ? super Integer, Unit> content) {
        Object _headerIndexes;
        ArrayList list;
        int i;
        if (this._headerIndexes == null) {
            _headerIndexes = new ArrayList();
            i = 0;
            this._headerIndexes = (List)_headerIndexes;
        }
        _headerIndexes.add(Integer.valueOf(getIntervals().getSize()));
        item(key, contentType, content);
    }
}
