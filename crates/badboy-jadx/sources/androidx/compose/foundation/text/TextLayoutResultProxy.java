package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect.Companion;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000f\u0008\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017J\"\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\u0008 \u0010!J\u001a\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH\u0000ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$J\u001a\u0010%\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH\u0000ø\u0001\u0000¢\u0006\u0004\u0008&\u0010$J\u0016\u0010'\u001a\u00020\u001a*\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\u0008(\u0010$R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\t\"\u0004\u0008\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006)", d2 = {"Landroidx/compose/foundation/text/TextLayoutResultProxy;", "", "value", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "decorationBoxCoordinates", "(Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;)V", "getDecorationBoxCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setDecorationBoxCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "getInnerTextFieldCoordinates", "setInnerTextFieldCoordinates", "getValue", "()Landroidx/compose/ui/text/TextLayoutResult;", "getLineEnd", "", "lineIndex", "visibleEnd", "", "getLineForVerticalPosition", "vertical", "", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "coerceInVisibleBounds", "getOffsetForPosition-3MmeM6k", "(JZ)I", "isPositionOnText", "offset", "isPositionOnText-k-4lQ0M", "(J)Z", "translateDecorationToInnerCoordinates", "translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release", "(J)J", "translateInnerToDecorationCoordinates", "translateInnerToDecorationCoordinates-MK-Hz9U$foundation_release", "coercedInVisibleBoundsOfInputText", "coercedInVisibleBoundsOfInputText-MK-Hz9U", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextLayoutResultProxy {

    public static final int $stable = 8;
    private LayoutCoordinates decorationBoxCoordinates;
    private LayoutCoordinates innerTextFieldCoordinates;
    private final TextLayoutResult value;
    static {
        final int i = 8;
    }

    public TextLayoutResultProxy(TextLayoutResult value, LayoutCoordinates innerTextFieldCoordinates, LayoutCoordinates decorationBoxCoordinates) {
        super();
        this.value = value;
        this.innerTextFieldCoordinates = innerTextFieldCoordinates;
        this.decorationBoxCoordinates = decorationBoxCoordinates;
    }

    public TextLayoutResultProxy(TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates2, LayoutCoordinates layoutCoordinates3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj3;
        int obj4;
        final int i = 0;
        obj3 = i4 & 2 != 0 ? i : obj3;
        obj4 = i4 &= 4 != 0 ? i : obj4;
        super(textLayoutResult, obj3, obj4);
    }

    private final long coercedInVisibleBoundsOfInputText-MK-Hz9U(long $this$coercedInVisibleBoundsOfInputText_u2dMK_u2dHz9U) {
        Object innerTextFieldCoordinates;
        int i2;
        LayoutCoordinates decorationBoxCoordinates;
        Rect localBoundingBoxOf$default;
        int i3;
        int i;
        innerTextFieldCoordinates = this.innerTextFieldCoordinates;
        if (innerTextFieldCoordinates != null) {
            i2 = 0;
            if (innerTextFieldCoordinates.isAttached()) {
                decorationBoxCoordinates = this.decorationBoxCoordinates;
                if (decorationBoxCoordinates != null) {
                    localBoundingBoxOf$default = LayoutCoordinates.localBoundingBoxOf$default(decorationBoxCoordinates, innerTextFieldCoordinates, false, 2, 0);
                }
            } else {
                localBoundingBoxOf$default = Rect.Companion.getZero();
            }
            if (localBoundingBoxOf$default == 0) {
                localBoundingBoxOf$default = Rect.Companion.getZero();
            }
        } else {
        }
        return TextLayoutResultProxyKt.access$coerceIn-3MmeM6k($this$coercedInVisibleBoundsOfInputText_u2dMK_u2dHz9U, obj8);
    }

    public static int getLineEnd$default(androidx.compose.foundation.text.TextLayoutResultProxy textLayoutResultProxy, int i2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return textLayoutResultProxy.getLineEnd(i2, obj2);
    }

    public static int getOffsetForPosition-3MmeM6k$default(androidx.compose.foundation.text.TextLayoutResultProxy textLayoutResultProxy, long l2, boolean z3, int i4, Object object5) {
        int obj3;
        if (object5 &= 2 != 0) {
            obj3 = 1;
        }
        return textLayoutResultProxy.getOffsetForPosition-3MmeM6k(l2, z3);
    }

    public final LayoutCoordinates getDecorationBoxCoordinates() {
        return this.decorationBoxCoordinates;
    }

    public final LayoutCoordinates getInnerTextFieldCoordinates() {
        return this.innerTextFieldCoordinates;
    }

    public final int getLineEnd(int lineIndex, boolean visibleEnd) {
        return this.value.getLineEnd(lineIndex, visibleEnd);
    }

    public final int getLineForVerticalPosition(float vertical) {
        return this.value.getLineForVerticalPosition(Offset.getY-impl(translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release(coercedInVisibleBoundsOfInputText-MK-Hz9U(OffsetKt.Offset(0, vertical)))));
    }

    public final int getOffsetForPosition-3MmeM6k(long position, boolean coerceInVisibleBounds) {
        long coercedInVisibleBoundsOfInputText-MK-Hz9U;
        if (obj8 != null) {
            coercedInVisibleBoundsOfInputText-MK-Hz9U = coercedInVisibleBoundsOfInputText-MK-Hz9U(position);
        } else {
            coercedInVisibleBoundsOfInputText-MK-Hz9U = position;
        }
        return this.value.getOffsetForPosition-k-4lQ0M(translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release(coercedInVisibleBoundsOfInputText-MK-Hz9U));
    }

    public final TextLayoutResult getValue() {
        return this.value;
    }

    public final boolean isPositionOnText-k-4lQ0M(long offset) {
        int cmp;
        int i;
        float lineRight;
        final long translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release = translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release(coercedInVisibleBoundsOfInputText-MK-Hz9U(offset));
        int lineForVerticalPosition = this.value.getLineForVerticalPosition(Offset.getY-impl(translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release));
        if (Float.compare(x-impl, lineRight) >= 0 && Float.compare(x-impl2, lineRight) <= 0) {
            i = Float.compare(x-impl2, lineRight) <= 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    public final void setDecorationBoxCoordinates(LayoutCoordinates <set-?>) {
        this.decorationBoxCoordinates = <set-?>;
    }

    public final void setInnerTextFieldCoordinates(LayoutCoordinates <set-?>) {
        this.innerTextFieldCoordinates = <set-?>;
    }

    public final long translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release(long offset) {
        LayoutCoordinates innerTextFieldCoordinates;
        boolean it;
        int $i$a$TakeIfTextLayoutResultProxy$translateDecorationToInnerCoordinates$innerCoords$1;
        boolean it2;
        int i;
        innerTextFieldCoordinates = this.innerTextFieldCoordinates;
        if (innerTextFieldCoordinates != null) {
            int i2 = 0;
            if (innerTextFieldCoordinates.isAttached()) {
            } else {
                innerTextFieldCoordinates = $i$a$TakeIfTextLayoutResultProxy$translateDecorationToInnerCoordinates$innerCoords$1;
            }
            if (innerTextFieldCoordinates == 0) {
            } else {
                LayoutCoordinates decorationBoxCoordinates = this.decorationBoxCoordinates;
                i = 0;
                if (decorationBoxCoordinates != null && decorationBoxCoordinates.isAttached()) {
                    i = 0;
                    if (decorationBoxCoordinates.isAttached()) {
                        $i$a$TakeIfTextLayoutResultProxy$translateDecorationToInnerCoordinates$innerCoords$1 = decorationBoxCoordinates;
                    }
                    if ($i$a$TakeIfTextLayoutResultProxy$translateDecorationToInnerCoordinates$innerCoords$1 == 0) {
                    }
                    return innerTextFieldCoordinates.localPositionOf-R5De75A($i$a$TakeIfTextLayoutResultProxy$translateDecorationToInnerCoordinates$innerCoords$1, offset);
                }
            }
            return offset;
        }
        return offset;
    }

    public final long translateInnerToDecorationCoordinates-MK-Hz9U$foundation_release(long offset) {
        LayoutCoordinates innerTextFieldCoordinates;
        boolean it;
        int $i$a$TakeIfTextLayoutResultProxy$translateInnerToDecorationCoordinates$innerCoords$1;
        boolean it2;
        int i;
        innerTextFieldCoordinates = this.innerTextFieldCoordinates;
        if (innerTextFieldCoordinates != null) {
            int i2 = 0;
            if (innerTextFieldCoordinates.isAttached()) {
            } else {
                innerTextFieldCoordinates = $i$a$TakeIfTextLayoutResultProxy$translateInnerToDecorationCoordinates$innerCoords$1;
            }
            if (innerTextFieldCoordinates == 0) {
            } else {
                LayoutCoordinates decorationBoxCoordinates = this.decorationBoxCoordinates;
                i = 0;
                if (decorationBoxCoordinates != null && decorationBoxCoordinates.isAttached()) {
                    i = 0;
                    if (decorationBoxCoordinates.isAttached()) {
                        $i$a$TakeIfTextLayoutResultProxy$translateInnerToDecorationCoordinates$innerCoords$1 = decorationBoxCoordinates;
                    }
                    if ($i$a$TakeIfTextLayoutResultProxy$translateInnerToDecorationCoordinates$innerCoords$1 == 0) {
                    }
                    return $i$a$TakeIfTextLayoutResultProxy$translateInnerToDecorationCoordinates$innerCoords$1.localPositionOf-R5De75A(innerTextFieldCoordinates, offset);
                }
            }
            return offset;
        }
        return offset;
    }
}
