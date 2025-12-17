package androidx.compose.material3.carousel;

import androidx.compose.foundation.pager.PageSize;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001BM\u00126\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0008\u0012\u0004\u0012\u00020\t0\u0003\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0002\u0010\u000cJ\u001c\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0008\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R+\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0013\u0010\u0010\"\u0004\u0008\u0014\u0010\u0015¨\u0006\u001c", d2 = {"Landroidx/compose/material3/carousel/CarouselPageSize;", "Landroidx/compose/foundation/pager/PageSize;", "keylineList", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "availableSpace", "itemSpacing", "Landroidx/compose/material3/carousel/KeylineList;", "beforeContentPadding", "afterContentPadding", "(Lkotlin/jvm/functions/Function2;FF)V", "strategy", "Landroidx/compose/material3/carousel/Strategy;", "getStrategy", "()Landroidx/compose/material3/carousel/Strategy;", "<set-?>", "strategyState", "getStrategyState", "setStrategyState", "(Landroidx/compose/material3/carousel/Strategy;)V", "strategyState$delegate", "Landroidx/compose/runtime/MutableState;", "calculateMainAxisPageSize", "", "Landroidx/compose/ui/unit/Density;", "pageSpacing", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CarouselPageSize implements PageSize {

    public static final int $stable;
    private final float afterContentPadding;
    private final float beforeContentPadding;
    private final Function2<Float, Float, androidx.compose.material3.carousel.KeylineList> keylineList;
    private final MutableState strategyState$delegate;
    static {
    }

    public CarouselPageSize(Function2<? super Float, ? super Float, androidx.compose.material3.carousel.KeylineList> keylineList, float beforeContentPadding, float afterContentPadding) {
        super();
        this.keylineList = keylineList;
        this.beforeContentPadding = beforeContentPadding;
        this.afterContentPadding = afterContentPadding;
        final int i = 0;
        this.strategyState$delegate = SnapshotStateKt.mutableStateOf$default(Strategy.Companion.getEmpty(), i, 2, i);
    }

    private final androidx.compose.material3.carousel.Strategy getStrategyState() {
        final int i = 0;
        final int i2 = 0;
        return (Strategy)(State)this.strategyState$delegate.getValue();
    }

    private final void setStrategyState(androidx.compose.material3.carousel.Strategy <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.strategyState$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.foundation.pager.PageSize
    public int calculateMainAxisPageSize(Density $this$calculateMainAxisPageSize, int availableSpace, int pageSpacing) {
        int roundToInt;
        Strategy strategy3 = new Strategy((KeylineList)this.keylineList.invoke(Float.valueOf((float)availableSpace), Float.valueOf((float)pageSpacing)), (float)availableSpace, (float)pageSpacing, this.beforeContentPadding, this.afterContentPadding);
        setStrategyState(strategy3);
        if (getStrategy().isValid()) {
            roundToInt = MathKt.roundToInt(getStrategy().getItemMainAxisSize());
        } else {
            roundToInt = availableSpace;
        }
        return roundToInt;
    }

    @Override // androidx.compose.foundation.pager.PageSize
    public final androidx.compose.material3.carousel.Strategy getStrategy() {
        return getStrategyState();
    }
}
