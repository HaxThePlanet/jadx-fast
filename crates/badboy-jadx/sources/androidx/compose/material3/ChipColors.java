package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0007\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019J`\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00172\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u001f\u001a\u00020 H\u0016J\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\u0019J\u001d\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010\u0019J\u001d\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008#\u0010\u0019R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u000c\u0010\rR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u000f\u0010\rR\u0019\u0010\u0008\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u0010\u0010\rR\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u0011\u0010\rR\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u0012\u0010\rR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u0013\u0010\rR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u0014\u0010\rR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u0015\u0010\r\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006$", d2 = {"Landroidx/compose/material3/ChipColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "leadingIconContentColor", "trailingIconContentColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconContentColor", "disabledTrailingIconContentColor", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getDisabledContainerColor-0d7_KjU", "getDisabledLabelColor-0d7_KjU", "getDisabledLeadingIconContentColor-0d7_KjU", "getDisabledTrailingIconContentColor-0d7_KjU", "getLabelColor-0d7_KjU", "getLeadingIconContentColor-0d7_KjU", "getTrailingIconContentColor-0d7_KjU", "enabled", "", "containerColor-vNxB06k$material3_release", "(Z)J", "copy", "copy-FD3wquc", "(JJJJJJJJ)Landroidx/compose/material3/ChipColors;", "equals", "other", "hashCode", "", "labelColor-vNxB06k$material3_release", "leadingIconContentColor-vNxB06k$material3_release", "trailingIconContentColor-vNxB06k$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ChipColors {

    public static final int $stable;
    private final long containerColor;
    private final long disabledContainerColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconContentColor;
    private final long disabledTrailingIconContentColor;
    private final long labelColor;
    private final long leadingIconContentColor;
    private final long trailingIconContentColor;
    static {
    }

    private ChipColors(long containerColor, long labelColor, long leadingIconContentColor, long trailingIconContentColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconContentColor, long disabledTrailingIconContentColor) {
        super();
        this.containerColor = containerColor;
        this.labelColor = leadingIconContentColor;
        this.leadingIconContentColor = disabledContainerColor;
        this.trailingIconContentColor = disabledLeadingIconContentColor;
        this.disabledContainerColor = obj23;
        this.disabledLabelColor = obj25;
        this.disabledLeadingIconContentColor = obj27;
        this.disabledTrailingIconContentColor = obj29;
    }

    public ChipColors(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, DefaultConstructorMarker defaultConstructorMarker9) {
        super(l, l2, l3, l4, l5, l6, l7, l8, defaultConstructorMarker9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    public static androidx.compose.material3.ChipColors copy-FD3wquc$default(androidx.compose.material3.ChipColors chipColors, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, int i10, Object object11) {
        long disabledTrailingIconContentColor;
        long containerColor;
        long labelColor;
        long leadingIconContentColor;
        long trailingIconContentColor;
        long disabledContainerColor;
        long disabledLabelColor;
        long disabledLeadingIconContentColor;
        long l;
        Object obj = chipColors;
        int i = obj35;
        containerColor = i & 1 != 0 ? obj.containerColor : l2;
        labelColor = i & 2 != 0 ? obj.labelColor : l4;
        leadingIconContentColor = i & 4 != 0 ? obj.leadingIconContentColor : l6;
        trailingIconContentColor = i & 8 != 0 ? obj.trailingIconContentColor : l8;
        disabledContainerColor = i & 16 != 0 ? obj.disabledContainerColor : i10;
        disabledLabelColor = i & 32 != 0 ? obj.disabledLabelColor : obj29;
        disabledLeadingIconContentColor = i & 64 != 0 ? obj.disabledLeadingIconContentColor : obj31;
        disabledTrailingIconContentColor = i &= 128 != 0 ? obj.disabledTrailingIconContentColor : obj33;
        return obj.copy-FD3wquc(l, l4, labelColor, l6, leadingIconContentColor, l8, trailingIconContentColor, i10);
    }

    public final long containerColor-vNxB06k$material3_release(boolean enabled) {
        long disabledContainerColor;
        disabledContainerColor = enabled ? this.containerColor : this.disabledContainerColor;
        return disabledContainerColor;
    }

    public final androidx.compose.material3.ChipColors copy-FD3wquc(long containerColor, long labelColor, long leadingIconContentColor, long trailingIconContentColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconContentColor, long disabledTrailingIconContentColor) {
        int $i$a$TakeOrElseDxMtmZcChipColors$copy$1;
        int $i$a$TakeOrElseDxMtmZcChipColors$copy$2;
        int $i$a$TakeOrElseDxMtmZcChipColors$copy$3;
        int $i$a$TakeOrElseDxMtmZcChipColors$copy$4;
        int $this$isSpecified$iv$iv2;
        int $this$isSpecified$iv$iv;
        int $this$isSpecified$iv$iv3;
        long $i$a$TakeOrElseDxMtmZcChipColors$copy$8;
        int i4;
        long l3;
        long l2;
        long l;
        long i5;
        long i;
        long i2;
        long i3;
        long l4;
        final Object obj = this;
        int i6 = containerColor;
        int i7 = 0;
        int i30 = 0;
        int i38 = 16;
        i4 = 1;
        final int i39 = 0;
        $i$a$TakeOrElseDxMtmZcChipColors$copy$1 = Long.compare(i15, i38) != 0 ? i4 : i39;
        if ($i$a$TakeOrElseDxMtmZcChipColors$copy$1 != 0) {
            l3 = i6;
        } else {
            int i29 = 0;
            l3 = $i$a$TakeOrElseDxMtmZcChipColors$copy$1;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv = leadingIconContentColor;
        int i8 = 0;
        int i31 = 0;
        $i$a$TakeOrElseDxMtmZcChipColors$copy$2 = Long.compare(i16, i38) != 0 ? i4 : i39;
        if ($i$a$TakeOrElseDxMtmZcChipColors$copy$2 != 0) {
            l2 = $this$takeOrElse_u2dDxMtmZc$iv;
        } else {
            int i28 = 0;
            l2 = $i$a$TakeOrElseDxMtmZcChipColors$copy$2;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv2 = disabledContainerColor;
        int i9 = 0;
        int i32 = 0;
        $i$a$TakeOrElseDxMtmZcChipColors$copy$3 = Long.compare(i17, i38) != 0 ? i4 : i39;
        if ($i$a$TakeOrElseDxMtmZcChipColors$copy$3 != 0) {
            l = $this$takeOrElse_u2dDxMtmZc$iv2;
        } else {
            int i27 = 0;
            l = $i$a$TakeOrElseDxMtmZcChipColors$copy$3;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv3 = disabledLeadingIconContentColor;
        int i10 = 0;
        int i33 = 0;
        $i$a$TakeOrElseDxMtmZcChipColors$copy$4 = Long.compare(i18, i38) != 0 ? i4 : i39;
        if ($i$a$TakeOrElseDxMtmZcChipColors$copy$4 != 0) {
            i5 = $this$takeOrElse_u2dDxMtmZc$iv3;
        } else {
            int i26 = 0;
            i5 = $i$a$TakeOrElseDxMtmZcChipColors$copy$4;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv4 = obj39;
        int i11 = 0;
        int i34 = 0;
        $this$isSpecified$iv$iv2 = Long.compare(i19, i38) != 0 ? i4 : i39;
        if ($this$isSpecified$iv$iv2 != 0) {
            i = $this$takeOrElse_u2dDxMtmZc$iv4;
        } else {
            int i25 = 0;
            i = $this$isSpecified$iv$iv2;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv5 = obj41;
        int i12 = 0;
        int i35 = 0;
        $this$isSpecified$iv$iv = Long.compare(i20, i38) != 0 ? i4 : i39;
        if ($this$isSpecified$iv$iv != 0) {
            i2 = $this$takeOrElse_u2dDxMtmZc$iv5;
        } else {
            int i24 = 0;
            i2 = $this$isSpecified$iv$iv;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv6 = obj43;
        int i13 = 0;
        int i36 = 0;
        $this$isSpecified$iv$iv3 = Long.compare(i21, i38) != 0 ? i4 : i39;
        if ($this$isSpecified$iv$iv3 != 0) {
            i3 = $this$takeOrElse_u2dDxMtmZc$iv6;
        } else {
            int i23 = 0;
            i3 = $this$isSpecified$iv$iv3;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv7 = obj45;
        int i14 = 0;
        int i37 = 0;
        if (Long.compare($i$a$TakeOrElseDxMtmZcChipColors$copy$8, i38) != 0) {
        } else {
            i4 = i39;
        }
        if (i4 != 0) {
            l4 = $this$takeOrElse_u2dDxMtmZc$iv7;
        } else {
            int i22 = 0;
            l4 = $i$a$TakeOrElseDxMtmZcChipColors$copy$8;
        }
        ChipColors chipColors = new ChipColors(l3, obj14, l2, obj16, l, obj18, i5, obj20, i, obj22, i2, obj24, i3, obj26, l4, obj28, 0);
        return chipColors;
    }

    public boolean equals(Object other) {
        boolean z;
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other != null) {
            if (!other instanceof ChipColors) {
            } else {
                if (!Color.equals-impl0(this.containerColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.labelColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.leadingIconContentColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.trailingIconContentColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledContainerColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledLabelColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledLeadingIconContentColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledTrailingIconContentColor, obj3)) {
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

    public final long getDisabledContainerColor-0d7_KjU() {
        return this.disabledContainerColor;
    }

    public final long getDisabledLabelColor-0d7_KjU() {
        return this.disabledLabelColor;
    }

    public final long getDisabledLeadingIconContentColor-0d7_KjU() {
        return this.disabledLeadingIconContentColor;
    }

    public final long getDisabledTrailingIconContentColor-0d7_KjU() {
        return this.disabledTrailingIconContentColor;
    }

    public final long getLabelColor-0d7_KjU() {
        return this.labelColor;
    }

    public final long getLeadingIconContentColor-0d7_KjU() {
        return this.leadingIconContentColor;
    }

    public final long getTrailingIconContentColor-0d7_KjU() {
        return this.trailingIconContentColor;
    }

    public int hashCode() {
        return result6 += i16;
    }

    public final long labelColor-vNxB06k$material3_release(boolean enabled) {
        long disabledLabelColor;
        disabledLabelColor = enabled ? this.labelColor : this.disabledLabelColor;
        return disabledLabelColor;
    }

    public final long leadingIconContentColor-vNxB06k$material3_release(boolean enabled) {
        long leadingIconContentColor;
        leadingIconContentColor = enabled ? this.leadingIconContentColor : this.disabledLeadingIconContentColor;
        return leadingIconContentColor;
    }

    public final long trailingIconContentColor-vNxB06k$material3_release(boolean enabled) {
        long trailingIconContentColor;
        trailingIconContentColor = enabled ? this.trailingIconContentColor : this.disabledTrailingIconContentColor;
        return trailingIconContentColor;
    }
}
