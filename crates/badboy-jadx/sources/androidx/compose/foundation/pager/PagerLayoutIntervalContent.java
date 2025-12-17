package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001Be\u00121\u0010\u0003\u001a-\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\u0002\u0008\u000b¢\u0006\u0002\u0008\u000c\u0012#\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0002\u0010\u0012R\u001a\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0014X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R.\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R>\u0010\u0003\u001a-\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\u0002\u0008\u000b¢\u0006\u0002\u0008\u000c¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001d¨\u0006\u001e", d2 = {"Landroidx/compose/foundation/pager/PagerLayoutIntervalContent;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/pager/PagerIntervalContent;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "", "Lkotlin/ParameterName;", "name", "page", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "key", "Lkotlin/Function1;", "index", "", "pageCount", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;I)V", "intervals", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/IntervalList;", "getKey", "()Lkotlin/jvm/functions/Function1;", "getPageContent", "()Lkotlin/jvm/functions/Function4;", "Lkotlin/jvm/functions/Function4;", "getPageCount", "()I", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PagerLayoutIntervalContent extends LazyLayoutIntervalContent<androidx.compose.foundation.pager.PagerIntervalContent> {

    private final IntervalList<androidx.compose.foundation.pager.PagerIntervalContent> intervals;
    private final Function1<Integer, Object> key;
    private final Function4<androidx.compose.foundation.pager.PagerScope, Integer, Composer, Integer, Unit> pageContent;
    private final int pageCount;
    public PagerLayoutIntervalContent(Function4<? super androidx.compose.foundation.pager.PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> pageContent, Function1<? super Integer, ? extends Object> key, int pageCount) {
        super();
        this.pageContent = pageContent;
        this.key = key;
        this.pageCount = pageCount;
        MutableIntervalList mutableIntervalList = new MutableIntervalList();
        final int i = 0;
        PagerIntervalContent pagerIntervalContent = new PagerIntervalContent(this.key, this.pageContent);
        mutableIntervalList.addInterval(this.pageCount, pagerIntervalContent);
        this.intervals = (IntervalList)mutableIntervalList;
    }

    public IntervalList<androidx.compose.foundation.pager.PagerIntervalContent> getIntervals() {
        return this.intervals;
    }

    public final Function1<Integer, Object> getKey() {
        return this.key;
    }

    public final Function4<androidx.compose.foundation.pager.PagerScope, Integer, Composer, Integer, Unit> getPageContent() {
        return this.pageContent;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    public final int getPageCount() {
        return this.pageCount;
    }
}
