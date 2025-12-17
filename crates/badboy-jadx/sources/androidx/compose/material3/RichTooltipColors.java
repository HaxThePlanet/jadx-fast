package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J8\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016R\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u0008\u0010\tR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u000b\u0010\tR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u000c\u0010\tR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\r\u0010\t\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0016", d2 = {"Landroidx/compose/material3/RichTooltipColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "titleContentColor", "actionContentColor", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActionContentColor-0d7_KjU", "()J", "J", "getContainerColor-0d7_KjU", "getContentColor-0d7_KjU", "getTitleContentColor-0d7_KjU", "copy", "copy-jRlVdoo", "(JJJJ)Landroidx/compose/material3/RichTooltipColors;", "equals", "", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RichTooltipColors {

    public static final int $stable;
    private final long actionContentColor;
    private final long containerColor;
    private final long contentColor;
    private final long titleContentColor;
    static {
    }

    private RichTooltipColors(long containerColor, long contentColor, long titleContentColor, long actionContentColor) {
        super();
        this.containerColor = containerColor;
        this.contentColor = titleContentColor;
        this.titleContentColor = obj5;
        this.actionContentColor = obj7;
    }

    public RichTooltipColors(long l, long l2, long l3, long l4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(l, l2, l3, l4, defaultConstructorMarker5, obj6, obj7, obj8);
    }

    public static androidx.compose.material3.RichTooltipColors copy-jRlVdoo$default(androidx.compose.material3.RichTooltipColors richTooltipColors, long l2, long l3, long l4, long l5, int i6, Object object7) {
        long l6;
        long l7;
        long l8;
        long l;
        long obj10;
        long obj12;
        long obj14;
        l6 = obj18 & 1 != 0 ? obj10 : l2;
        l7 = obj18 & 2 != 0 ? obj12 : l4;
        l8 = obj18 & 4 != 0 ? obj14 : i6;
        l = obj18 & 8 != 0 ? obj10 : obj16;
        return richTooltipColors.copy-jRlVdoo(l6, obj2, l7, obj4);
    }

    public final androidx.compose.material3.RichTooltipColors copy-jRlVdoo(long containerColor, long contentColor, long titleContentColor, long actionContentColor) {
        int $i$a$TakeOrElseDxMtmZcRichTooltipColors$copy$1;
        int $i$a$TakeOrElseDxMtmZcRichTooltipColors$copy$2;
        int $this$isSpecified$iv$iv;
        int $i$a$TakeOrElseDxMtmZcRichTooltipColors$copy$4;
        int i2;
        long l;
        long l3;
        long l2;
        long i;
        final Object obj = this;
        int i3 = containerColor;
        int i4 = 0;
        int i15 = 0;
        int i19 = 16;
        i2 = 1;
        final int i20 = 0;
        $i$a$TakeOrElseDxMtmZcRichTooltipColors$copy$1 = Long.compare(i8, i19) != 0 ? i2 : i20;
        if ($i$a$TakeOrElseDxMtmZcRichTooltipColors$copy$1 != 0) {
            l = i3;
        } else {
            int i14 = 0;
            l = $i$a$TakeOrElseDxMtmZcRichTooltipColors$copy$1;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv = titleContentColor;
        int i5 = 0;
        int i16 = 0;
        $i$a$TakeOrElseDxMtmZcRichTooltipColors$copy$2 = Long.compare(i9, i19) != 0 ? i2 : i20;
        if ($i$a$TakeOrElseDxMtmZcRichTooltipColors$copy$2 != 0) {
            l3 = $this$takeOrElse_u2dDxMtmZc$iv;
        } else {
            int i10 = 0;
            l3 = $i$a$TakeOrElseDxMtmZcRichTooltipColors$copy$2;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv2 = obj27;
        int i6 = 0;
        int i17 = 0;
        $this$isSpecified$iv$iv = Long.compare(i11, i19) != 0 ? i2 : i20;
        if ($this$isSpecified$iv$iv != 0) {
            l2 = $this$takeOrElse_u2dDxMtmZc$iv2;
        } else {
            int i12 = 0;
            l2 = $this$isSpecified$iv$iv;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv3 = obj29;
        int i7 = 0;
        int i18 = 0;
        if (Long.compare($i$a$TakeOrElseDxMtmZcRichTooltipColors$copy$4, i19) != 0) {
        } else {
            i2 = i20;
        }
        if (i2 != 0) {
            i = $this$takeOrElse_u2dDxMtmZc$iv3;
        } else {
            int i13 = 0;
            i = $i$a$TakeOrElseDxMtmZcRichTooltipColors$copy$4;
        }
        RichTooltipColors richTooltipColors = new RichTooltipColors(l, obj14, l3, obj16, l2, obj18, i, obj20, 0);
        return richTooltipColors;
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof RichTooltipColors) {
            return i2;
        }
        if (!Color.equals-impl0(this.containerColor, obj4)) {
            return i2;
        }
        if (!Color.equals-impl0(this.contentColor, obj4)) {
            return i2;
        }
        if (!Color.equals-impl0(this.titleContentColor, obj4)) {
            return i2;
        }
        if (!Color.equals-impl0(this.actionContentColor, obj4)) {
            return i2;
        }
        return i;
    }

    public final long getActionContentColor-0d7_KjU() {
        return this.actionContentColor;
    }

    public final long getContainerColor-0d7_KjU() {
        return this.containerColor;
    }

    public final long getContentColor-0d7_KjU() {
        return this.contentColor;
    }

    public final long getTitleContentColor-0d7_KjU() {
        return this.titleContentColor;
    }

    public int hashCode() {
        return result2 += i8;
    }
}
