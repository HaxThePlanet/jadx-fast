package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B-\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008J2\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\"\u0010\u0007\u001a\u00020\u0006X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\"\u0010\u0005\u001a\u00020\u0006X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\u0008\u0012\u0010\u000e\"\u0004\u0008\u0013\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\n\"\u0004\u0008\u0015\u0010\u000c\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001a", d2 = {"Landroidx/compose/foundation/layout/FlowLineInfo;", "", "lineIndex", "", "positionInLine", "maxMainAxisSize", "Landroidx/compose/ui/unit/Dp;", "maxCrossAxisSize", "(IIFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLineIndex$foundation_layout_release", "()I", "setLineIndex$foundation_layout_release", "(I)V", "getMaxCrossAxisSize-D9Ej5fM$foundation_layout_release", "()F", "setMaxCrossAxisSize-0680j_4$foundation_layout_release", "(F)V", "F", "getMaxMainAxisSize-D9Ej5fM$foundation_layout_release", "setMaxMainAxisSize-0680j_4$foundation_layout_release", "getPositionInLine$foundation_layout_release", "setPositionInLine$foundation_layout_release", "update", "", "update-4j6BHR0$foundation_layout_release", "(IIFF)V", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlowLineInfo {

    public static final int $stable = 8;
    private int lineIndex;
    private float maxCrossAxisSize;
    private float maxMainAxisSize;
    private int positionInLine;
    static {
        final int i = 8;
    }

    private FlowLineInfo(int lineIndex, int positionInLine, float maxMainAxisSize, float maxCrossAxisSize) {
        super();
        this.lineIndex = lineIndex;
        this.positionInLine = positionInLine;
        this.maxMainAxisSize = maxMainAxisSize;
        this.maxCrossAxisSize = maxCrossAxisSize;
    }

    public FlowLineInfo(int i, int i2, float f3, float f4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int i3;
        int i4;
        float f;
        float f2;
        int obj8;
        int obj9;
        float obj10;
        float obj11;
        final int i6 = 0;
        i3 = i5 & 1 != 0 ? i6 : i;
        i4 = i5 & 2 != 0 ? i6 : i2;
        if (i5 & 4 != 0) {
            obj9 = 0;
            f = obj10;
        } else {
            f = f3;
        }
        if (i5 & 8 != 0) {
            obj9 = 0;
            f2 = obj11;
        } else {
            f2 = f4;
        }
        super(i3, i4, f, f2, 0);
    }

    public FlowLineInfo(int i, int i2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(i, i2, f3, f4);
    }

    public final int getLineIndex$foundation_layout_release() {
        return this.lineIndex;
    }

    public final float getMaxCrossAxisSize-D9Ej5fM$foundation_layout_release() {
        return this.maxCrossAxisSize;
    }

    public final float getMaxMainAxisSize-D9Ej5fM$foundation_layout_release() {
        return this.maxMainAxisSize;
    }

    public final int getPositionInLine$foundation_layout_release() {
        return this.positionInLine;
    }

    public final void setLineIndex$foundation_layout_release(int <set-?>) {
        this.lineIndex = <set-?>;
    }

    public final void setMaxCrossAxisSize-0680j_4$foundation_layout_release(float <set-?>) {
        this.maxCrossAxisSize = <set-?>;
    }

    public final void setMaxMainAxisSize-0680j_4$foundation_layout_release(float <set-?>) {
        this.maxMainAxisSize = <set-?>;
    }

    public final void setPositionInLine$foundation_layout_release(int <set-?>) {
        this.positionInLine = <set-?>;
    }

    public final void update-4j6BHR0$foundation_layout_release(int lineIndex, int positionInLine, float maxMainAxisSize, float maxCrossAxisSize) {
        this.lineIndex = lineIndex;
        this.positionInLine = positionInLine;
        this.maxMainAxisSize = maxMainAxisSize;
        this.maxCrossAxisSize = maxCrossAxisSize;
    }
}
