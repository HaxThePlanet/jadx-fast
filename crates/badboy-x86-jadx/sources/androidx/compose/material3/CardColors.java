package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011J\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0011J8\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u000f2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u0008\u0010\tR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u000b\u0010\tR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u000c\u0010\tR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\r\u0010\t\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001a", d2 = {"Landroidx/compose/material3/CardColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getDisabledContainerColor-0d7_KjU", "getDisabledContentColor-0d7_KjU", "enabled", "", "containerColor-vNxB06k$material3_release", "(Z)J", "contentColor-vNxB06k$material3_release", "copy", "copy-jRlVdoo", "(JJJJ)Landroidx/compose/material3/CardColors;", "equals", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CardColors {

    public static final int $stable;
    private final long containerColor;
    private final long contentColor;
    private final long disabledContainerColor;
    private final long disabledContentColor;
    static {
    }

    private CardColors(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor) {
        super();
        this.containerColor = containerColor;
        this.contentColor = disabledContainerColor;
        this.disabledContainerColor = obj5;
        this.disabledContentColor = obj7;
    }

    public CardColors(long l, long l2, long l3, long l4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(l, l2, l3, l4, defaultConstructorMarker5, obj6, obj7, obj8);
    }

    public static androidx.compose.material3.CardColors copy-jRlVdoo$default(androidx.compose.material3.CardColors cardColors, long l2, long l3, long l4, long l5, int i6, Object object7) {
        long l;
        long l7;
        long l8;
        long l6;
        long obj10;
        long obj12;
        long obj14;
        l = obj18 & 1 != 0 ? obj10 : l2;
        l7 = obj18 & 2 != 0 ? obj12 : l4;
        l8 = obj18 & 4 != 0 ? obj14 : i6;
        l6 = obj18 & 8 != 0 ? obj10 : obj16;
        return cardColors.copy-jRlVdoo(l, obj2, l7, obj4);
    }

    public final long containerColor-vNxB06k$material3_release(boolean enabled) {
        long disabledContainerColor;
        disabledContainerColor = enabled ? this.containerColor : this.disabledContainerColor;
        return disabledContainerColor;
    }

    public final long contentColor-vNxB06k$material3_release(boolean enabled) {
        long disabledContentColor;
        disabledContentColor = enabled ? this.contentColor : this.disabledContentColor;
        return disabledContentColor;
    }

    public final androidx.compose.material3.CardColors copy-jRlVdoo(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor) {
        int $i$a$TakeOrElseDxMtmZcCardColors$copy$1;
        int $i$a$TakeOrElseDxMtmZcCardColors$copy$2;
        int $this$isSpecified$iv$iv;
        int $i$a$TakeOrElseDxMtmZcCardColors$copy$4;
        int i2;
        long l2;
        long l;
        long l3;
        long i;
        final Object obj = this;
        int i3 = containerColor;
        int i4 = 0;
        int i15 = 0;
        int i19 = 16;
        i2 = 1;
        final int i20 = 0;
        $i$a$TakeOrElseDxMtmZcCardColors$copy$1 = Long.compare(i8, i19) != 0 ? i2 : i20;
        if ($i$a$TakeOrElseDxMtmZcCardColors$copy$1 != 0) {
            l2 = i3;
        } else {
            int i14 = 0;
            l2 = $i$a$TakeOrElseDxMtmZcCardColors$copy$1;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv = disabledContainerColor;
        int i5 = 0;
        int i16 = 0;
        $i$a$TakeOrElseDxMtmZcCardColors$copy$2 = Long.compare(i9, i19) != 0 ? i2 : i20;
        if ($i$a$TakeOrElseDxMtmZcCardColors$copy$2 != 0) {
            l = $this$takeOrElse_u2dDxMtmZc$iv;
        } else {
            int i10 = 0;
            l = $i$a$TakeOrElseDxMtmZcCardColors$copy$2;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv2 = obj27;
        int i6 = 0;
        int i17 = 0;
        $this$isSpecified$iv$iv = Long.compare(i11, i19) != 0 ? i2 : i20;
        if ($this$isSpecified$iv$iv != 0) {
            l3 = $this$takeOrElse_u2dDxMtmZc$iv2;
        } else {
            int i12 = 0;
            l3 = $this$isSpecified$iv$iv;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv3 = obj29;
        int i7 = 0;
        int i18 = 0;
        if (Long.compare($i$a$TakeOrElseDxMtmZcCardColors$copy$4, i19) != 0) {
        } else {
            i2 = i20;
        }
        if (i2 != 0) {
            i = $this$takeOrElse_u2dDxMtmZc$iv3;
        } else {
            int i13 = 0;
            i = $i$a$TakeOrElseDxMtmZcCardColors$copy$4;
        }
        CardColors cardColors = new CardColors(l2, obj14, l, obj16, l3, obj18, i, obj20, 0);
        return cardColors;
    }

    public boolean equals(Object other) {
        boolean z;
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other != null) {
            if (!other instanceof CardColors) {
            } else {
                if (!Color.equals-impl0(this.containerColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.contentColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledContainerColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledContentColor, obj3)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public final long getContainerColor-0d7_KjU() {
        return this.containerColor;
    }

    public final long getContentColor-0d7_KjU() {
        return this.contentColor;
    }

    public final long getDisabledContainerColor-0d7_KjU() {
        return this.disabledContainerColor;
    }

    public final long getDisabledContentColor-0d7_KjU() {
        return this.disabledContentColor;
    }

    public int hashCode() {
        return result2 += i8;
    }
}
