package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0018\u0008\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0017\u001a\u00020\u0008H\u0002J\u001d\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\u0008J\u0006\u0010\u001c\u001a\u00020\u0008J\u0006\u0010\u001d\u001a\u00020\u0008J\u0006\u0010\u001e\u001a\u00020\u0008J\u0006\u0010\u001f\u001a\u00020\u0008J\u0006\u0010 \u001a\u00020\u0008J\u0006\u0010!\u001a\u00020\u0008J\u0006\u0010\"\u001a\u00020\u0008J\u0006\u0010#\u001a\u00020\u0008J\u0006\u0010$\u001a\u00020\u0014J\u0006\u0010%\u001a\u00020\u0014J\u0006\u0010&\u001a\u00020\u0014J\u0006\u0010'\u001a\u00020\u0014J\u0006\u0010(\u001a\u00020\u0014J\u0006\u0010)\u001a\u00020\u0014J\u0006\u0010*\u001a\u00020\u0014J\u0006\u0010+\u001a\u00020\u0014J\u0006\u0010,\u001a\u00020\u0014J\u0006\u0010-\u001a\u00020\u0014J\u0006\u0010.\u001a\u00020\u0014J\u0006\u0010/\u001a\u00020\u0014J\u0018\u00100\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\u00081\u00102R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u00020\u000fX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014*\u0004\u0018\u00010\u00088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0014*\u0004\u0018\u00010\u00088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0015\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00063", d2 = {"Landroidx/compose/foundation/EdgeEffectWrapper;", "", "context", "Landroid/content/Context;", "glowColor", "", "(Landroid/content/Context;I)V", "bottomEffect", "Landroid/widget/EdgeEffect;", "bottomEffectNegation", "leftEffect", "leftEffectNegation", "rightEffect", "rightEffectNegation", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "topEffect", "topEffectNegation", "isAnimating", "", "(Landroid/widget/EdgeEffect;)Z", "isStretched", "createEdgeEffect", "forEachEffect", "", "action", "Lkotlin/Function1;", "getOrCreateBottomEffect", "getOrCreateBottomEffectNegation", "getOrCreateLeftEffect", "getOrCreateLeftEffectNegation", "getOrCreateRightEffect", "getOrCreateRightEffectNegation", "getOrCreateTopEffect", "getOrCreateTopEffectNegation", "isBottomAnimating", "isBottomNegationStretched", "isBottomStretched", "isLeftAnimating", "isLeftNegationStretched", "isLeftStretched", "isRightAnimating", "isRightNegationStretched", "isRightStretched", "isTopAnimating", "isTopNegationStretched", "isTopStretched", "setSize", "setSize-ozmzZPI", "(J)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class EdgeEffectWrapper {

    private EdgeEffect bottomEffect;
    private EdgeEffect bottomEffectNegation;
    private final Context context;
    private final int glowColor;
    private EdgeEffect leftEffect;
    private EdgeEffect leftEffectNegation;
    private EdgeEffect rightEffect;
    private EdgeEffect rightEffectNegation;
    private long size;
    private EdgeEffect topEffect;
    private EdgeEffect topEffectNegation;
    public EdgeEffectWrapper(Context context, int glowColor) {
        super();
        this.context = context;
        this.glowColor = glowColor;
        this.size = IntSize.Companion.getZero-YbymL2g();
    }

    public static final EdgeEffect access$getBottomEffect$p(androidx.compose.foundation.EdgeEffectWrapper $this) {
        return $this.bottomEffect;
    }

    public static final EdgeEffect access$getLeftEffect$p(androidx.compose.foundation.EdgeEffectWrapper $this) {
        return $this.leftEffect;
    }

    public static final EdgeEffect access$getRightEffect$p(androidx.compose.foundation.EdgeEffectWrapper $this) {
        return $this.rightEffect;
    }

    public static final EdgeEffect access$getTopEffect$p(androidx.compose.foundation.EdgeEffectWrapper $this) {
        return $this.topEffect;
    }

    private final EdgeEffect createEdgeEffect() {
        boolean width-impl;
        long height-impl;
        EdgeEffect create = EdgeEffectCompat.INSTANCE.create(this.context);
        EdgeEffect edgeEffect = create;
        final int i = 0;
        edgeEffect.setColor(this.glowColor);
        long zero-YbymL2g = IntSize.Companion.getZero-YbymL2g();
        if (!IntSize.equals-impl0(this.size, obj4)) {
            edgeEffect.setSize(IntSize.getWidth-impl(this.size), IntSize.getHeight-impl(this.size));
        }
        return create;
    }

    private final boolean isAnimating(EdgeEffect $this$isAnimating) {
        if ($this$isAnimating == null) {
            return 0;
        }
        return finished ^= 1;
    }

    private final boolean isStretched(EdgeEffect $this$isStretched) {
        int i;
        if ($this$isStretched == null) {
            return 0;
        }
        int i4 = 1;
        if (Float.compare(distanceCompat, i3) == 0) {
            i = i4;
        }
        return i ^= i4;
    }

    public final void forEachEffect(Function1<? super EdgeEffect, Unit> action) {
        final int i = 0;
        EdgeEffect edgeEffect = EdgeEffectWrapper.access$getTopEffect$p(this);
        if (edgeEffect != null) {
            action.invoke(edgeEffect);
        }
        EdgeEffect edgeEffect2 = EdgeEffectWrapper.access$getBottomEffect$p(this);
        if (edgeEffect2 != null) {
            action.invoke(edgeEffect2);
        }
        EdgeEffect edgeEffect3 = EdgeEffectWrapper.access$getLeftEffect$p(this);
        if (edgeEffect3 != null) {
            action.invoke(edgeEffect3);
        }
        EdgeEffect edgeEffect4 = EdgeEffectWrapper.access$getRightEffect$p(this);
        if (edgeEffect4 != null) {
            action.invoke(edgeEffect4);
        }
    }

    public final EdgeEffect getOrCreateBottomEffect() {
        EdgeEffect bottomEffect;
        EdgeEffect edgeEffect;
        int i;
        if (this.bottomEffect == null) {
            i = 0;
            this.bottomEffect = createEdgeEffect();
        }
        return bottomEffect;
    }

    public final EdgeEffect getOrCreateBottomEffectNegation() {
        EdgeEffect bottomEffectNegation;
        EdgeEffect edgeEffect;
        int i;
        if (this.bottomEffectNegation == null) {
            i = 0;
            this.bottomEffectNegation = createEdgeEffect();
        }
        return bottomEffectNegation;
    }

    public final EdgeEffect getOrCreateLeftEffect() {
        EdgeEffect leftEffect;
        EdgeEffect edgeEffect;
        int i;
        if (this.leftEffect == null) {
            i = 0;
            this.leftEffect = createEdgeEffect();
        }
        return leftEffect;
    }

    public final EdgeEffect getOrCreateLeftEffectNegation() {
        EdgeEffect leftEffectNegation;
        EdgeEffect edgeEffect;
        int i;
        if (this.leftEffectNegation == null) {
            i = 0;
            this.leftEffectNegation = createEdgeEffect();
        }
        return leftEffectNegation;
    }

    public final EdgeEffect getOrCreateRightEffect() {
        EdgeEffect rightEffect;
        EdgeEffect edgeEffect;
        int i;
        if (this.rightEffect == null) {
            i = 0;
            this.rightEffect = createEdgeEffect();
        }
        return rightEffect;
    }

    public final EdgeEffect getOrCreateRightEffectNegation() {
        EdgeEffect rightEffectNegation;
        EdgeEffect edgeEffect;
        int i;
        if (this.rightEffectNegation == null) {
            i = 0;
            this.rightEffectNegation = createEdgeEffect();
        }
        return rightEffectNegation;
    }

    public final EdgeEffect getOrCreateTopEffect() {
        EdgeEffect edgeEffect2;
        EdgeEffect edgeEffect;
        int i;
        if (this.topEffect == null) {
            i = 0;
            this.topEffect = createEdgeEffect();
        }
        return edgeEffect2;
    }

    public final EdgeEffect getOrCreateTopEffectNegation() {
        EdgeEffect topEffectNegation;
        EdgeEffect edgeEffect;
        int i;
        if (this.topEffectNegation == null) {
            i = 0;
            this.topEffectNegation = createEdgeEffect();
        }
        return topEffectNegation;
    }

    public final boolean isBottomAnimating() {
        return isAnimating(this.bottomEffect);
    }

    public final boolean isBottomNegationStretched() {
        return isStretched(this.bottomEffectNegation);
    }

    public final boolean isBottomStretched() {
        return isStretched(this.bottomEffect);
    }

    public final boolean isLeftAnimating() {
        return isAnimating(this.leftEffect);
    }

    public final boolean isLeftNegationStretched() {
        return isStretched(this.leftEffectNegation);
    }

    public final boolean isLeftStretched() {
        return isStretched(this.leftEffect);
    }

    public final boolean isRightAnimating() {
        return isAnimating(this.rightEffect);
    }

    public final boolean isRightNegationStretched() {
        return isStretched(this.rightEffectNegation);
    }

    public final boolean isRightStretched() {
        return isStretched(this.rightEffect);
    }

    public final boolean isTopAnimating() {
        return isAnimating(this.topEffect);
    }

    public final boolean isTopNegationStretched() {
        return isStretched(this.topEffectNegation);
    }

    public final boolean isTopStretched() {
        return isStretched(this.topEffect);
    }

    public final void setSize-ozmzZPI(long size) {
        int height-impl2;
        int height-impl;
        this.size = size;
        EdgeEffect topEffect = this.topEffect;
        if (topEffect != null) {
            topEffect.setSize(IntSize.getWidth-impl(size), IntSize.getHeight-impl(size));
        }
        EdgeEffect bottomEffect = this.bottomEffect;
        if (bottomEffect != null) {
            bottomEffect.setSize(IntSize.getWidth-impl(size), IntSize.getHeight-impl(size));
        }
        EdgeEffect leftEffect = this.leftEffect;
        if (leftEffect != null) {
            leftEffect.setSize(IntSize.getHeight-impl(size), IntSize.getWidth-impl(size));
        }
        EdgeEffect rightEffect = this.rightEffect;
        if (rightEffect != null) {
            rightEffect.setSize(IntSize.getHeight-impl(size), IntSize.getWidth-impl(size));
        }
        EdgeEffect topEffectNegation = this.topEffectNegation;
        if (topEffectNegation != null) {
            topEffectNegation.setSize(IntSize.getWidth-impl(size), IntSize.getHeight-impl(size));
        }
        EdgeEffect bottomEffectNegation = this.bottomEffectNegation;
        if (bottomEffectNegation != null) {
            bottomEffectNegation.setSize(IntSize.getWidth-impl(size), IntSize.getHeight-impl(size));
        }
        EdgeEffect leftEffectNegation = this.leftEffectNegation;
        if (leftEffectNegation != null) {
            leftEffectNegation.setSize(IntSize.getHeight-impl(size), IntSize.getWidth-impl(size));
        }
        EdgeEffect rightEffectNegation = this.rightEffectNegation;
        if (rightEffectNegation != null) {
            rightEffectNegation.setSize(IntSize.getHeight-impl(size), IntSize.getWidth-impl(size));
        }
    }
}
