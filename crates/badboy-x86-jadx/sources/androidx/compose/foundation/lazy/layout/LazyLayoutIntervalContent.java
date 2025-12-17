package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008'\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nJT\u0010\u0010\u001a\u0002H\u0011\"\u0004\u0008\u0001\u0010\u00112\u0006\u0010\u0012\u001a\u00020\n26\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0017\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0018\u0012\u0004\u0012\u0002H\u00110\u0014H\u0086\u0008¢\u0006\u0002\u0010\u0019R\u0018\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001a", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Interval", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent$Interval;", "", "()V", "intervals", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/IntervalList;", "itemCount", "", "getItemCount", "()I", "getContentType", "index", "getKey", "withInterval", "T", "globalIndex", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "localIntervalIndex", "content", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class LazyLayoutIntervalContent<Interval extends androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval>  {

    public static final int $stable;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008g\u0018\u00002\u00020\u0001R1\u0010\u0002\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR1\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000cÀ\u0006\u0001", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent$Interval;", "", "key", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "index", "getKey", "()Lkotlin/jvm/functions/Function1;", "type", "getType", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Interval {
        public Function1<Integer, Object> getKey() {
            return 0;
        }

        public Function1<Integer, Object> getType() {
            return (Function1)LazyLayoutIntervalContent.Interval.type.1.INSTANCE;
        }
    }
    static {
    }

    public final Object getContentType(int index) {
        final int i = 0;
        androidx.compose.foundation.lazy.layout.IntervalList.Interval list = this.getIntervals().get(index);
        final int i4 = 0;
        return (LazyLayoutIntervalContent.Interval)list.getValue().getType().invoke(Integer.valueOf(index - startIndex));
    }

    public abstract androidx.compose.foundation.lazy.layout.IntervalList<Interval> getIntervals();

    public final int getItemCount() {
        return getIntervals().getSize();
    }

    public final Object getKey(int index) {
        Object defaultLazyLayoutKey;
        Integer valueOf;
        final int i = 0;
        androidx.compose.foundation.lazy.layout.IntervalList.Interval list = this.getIntervals().get(index);
        final int i4 = 0;
        defaultLazyLayoutKey = (LazyLayoutIntervalContent.Interval)list.getValue().getKey();
        if (defaultLazyLayoutKey != null) {
            if (defaultLazyLayoutKey.invoke(Integer.valueOf(index - startIndex)) == null) {
                defaultLazyLayoutKey = Lazy_androidKt.getDefaultLazyLayoutKey(index);
            }
        } else {
        }
        return defaultLazyLayoutKey;
    }

    public final <T> T withInterval(int globalIndex, Function2<? super Integer, ? super Interval, ? extends T> block) {
        final int i = 0;
        androidx.compose.foundation.lazy.layout.IntervalList.Interval list = getIntervals().get(globalIndex);
        return block.invoke(Integer.valueOf(globalIndex - startIndex), list.getValue());
    }
}
