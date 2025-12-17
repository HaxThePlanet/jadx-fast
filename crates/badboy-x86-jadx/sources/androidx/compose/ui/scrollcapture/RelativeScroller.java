package androidx.compose.ui.scrollcapture;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0008\u0008\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\u0010\u0008J\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0013R\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR,\u0010\u0004\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Landroidx/compose/ui/scrollcapture/RelativeScroller;", "", "viewportSize", "", "scrollBy", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "(ILkotlin/jvm/functions/Function2;)V", "<set-?>", "scrollAmount", "getScrollAmount", "()F", "Lkotlin/jvm/functions/Function2;", "mapOffsetToViewport", "offset", "reset", "", "delta", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollRangeIntoView", "min", "max", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollTo", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RelativeScroller {

    private float scrollAmount;
    private final Function2<Float, Continuation<? super Float>, Object> scrollBy;
    private final int viewportSize;
    public RelativeScroller(int viewportSize, Function2<? super Float, ? super Continuation<? super Float>, ? extends Object> scrollBy) {
        super();
        this.viewportSize = viewportSize;
        this.scrollBy = scrollBy;
    }

    public static final Object access$scrollBy(androidx.compose.ui.scrollcapture.RelativeScroller $this, float delta, Continuation $completion) {
        return $this.scrollBy(delta, $completion);
    }

    private final Object scrollBy(float f, Continuation<? super Unit> continuation2) {
        boolean anon;
        int i3;
        int i;
        Object relativeScroller;
        Function2 scrollBy;
        Float boxFloat;
        int i2;
        Object obj7;
        Object obj8;
        anon = continuation2;
        i = Integer.MIN_VALUE;
        if (continuation2 instanceof RelativeScroller.scrollBy.1 && label &= i != 0) {
            anon = continuation2;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                anon.label = obj8 -= i;
            } else {
                anon = new RelativeScroller.scrollBy.1(this, continuation2);
            }
        } else {
        }
        obj8 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj8);
                relativeScroller = this;
                anon.L$0 = relativeScroller;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                ResultKt.throwOnFailure(obj8);
                relativeScroller = obj7;
                obj7 = obj8;
                break;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        relativeScroller.scrollAmount = scrollAmount += obj7;
        return Unit.INSTANCE;
    }

    public final float getScrollAmount() {
        return this.scrollAmount;
    }

    public final int mapOffsetToViewport(int offset) {
        return RangesKt.coerceIn(offset - roundToInt, 0, this.viewportSize);
    }

    public final void reset() {
        this.scrollAmount = 0;
    }

    public final Object scrollRangeIntoView(int min, int max, Continuation<? super Unit> $completion) {
        int i4;
        int cmp;
        int i3;
        float scrollAmount;
        int i2;
        int i;
        int i6 = 0;
        i2 = min <= max ? i4 : i6;
        if (i2 == 0) {
        } else {
            if (max - min <= this.viewportSize) {
            } else {
                i4 = i6;
            }
            if (i4 == 0) {
            } else {
                if (Float.compare(f, scrollAmount) >= 0 && Float.compare(f3, scrollAmount) <= 0) {
                    if (Float.compare(f3, scrollAmount) <= 0) {
                        return Unit.INSTANCE;
                    }
                }
                i3 = Float.compare(f2, scrollAmount2) < 0 ? min : max - viewportSize;
                Object scrollTo = scrollTo((float)i3, $completion);
                if (scrollTo == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return scrollTo;
                }
                return Unit.INSTANCE;
            }
            int target = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected range (").append(max - min).append(") to be ≤ viewportSize=").append(this.viewportSize).toString().toString());
            throw illegalArgumentException;
        }
        int i5 = 0;
        StringBuilder stringBuilder2 = new StringBuilder();
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("Expected min=").append(min).append(" ≤ max=").append(max).toString().toString());
        throw illegalArgumentException2;
    }

    public final Object scrollTo(float offset, Continuation<? super Unit> $completion) {
        Object scrollBy = scrollBy(offset - scrollAmount, $completion);
        if (scrollBy == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return scrollBy;
        }
        return Unit.INSTANCE;
    }
}
