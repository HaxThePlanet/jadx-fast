package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0008\u0007\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000c\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J%\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0092\u0001\u0010\u0017\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\r\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00132\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u001c\u001a\u00020\u001dH\u0016J%\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u0016J%\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008 \u0010\u0016J%\u0010!\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u0008\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u000c\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\r\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u000e\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u000f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006#", d2 = {"Landroidx/compose/material3/SelectableChipColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "leadingIconColor", "trailingIconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "(JJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "enabled", "", "selected", "containerColor-WaAFU9c$material3_release", "(ZZ)J", "copy", "copy-daRQuJA", "(JJJJJJJJJJJJJ)Landroidx/compose/material3/SelectableChipColors;", "equals", "other", "hashCode", "", "labelColor-WaAFU9c$material3_release", "leadingIconContentColor", "leadingIconContentColor-WaAFU9c$material3_release", "trailingIconContentColor", "trailingIconContentColor-WaAFU9c$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectableChipColors {

    public static final int $stable;
    private final long containerColor;
    private final long disabledContainerColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledSelectedContainerColor;
    private final long disabledTrailingIconColor;
    private final long labelColor;
    private final long leadingIconColor;
    private final long selectedContainerColor;
    private final long selectedLabelColor;
    private final long selectedLeadingIconColor;
    private final long selectedTrailingIconColor;
    private final long trailingIconColor;
    static {
    }

    private SelectableChipColors(long containerColor, long labelColor, long leadingIconColor, long trailingIconColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconColor, long disabledTrailingIconColor, long selectedContainerColor, long disabledSelectedContainerColor, long selectedLabelColor, long selectedLeadingIconColor, long selectedTrailingIconColor) {
        super();
        this.containerColor = containerColor;
        this.labelColor = leadingIconColor;
        this.leadingIconColor = disabledContainerColor;
        this.trailingIconColor = disabledLeadingIconColor;
        this.disabledContainerColor = selectedContainerColor;
        this.disabledLabelColor = selectedLabelColor;
        this.disabledLeadingIconColor = selectedTrailingIconColor;
        this.disabledTrailingIconColor = obj29;
        this.selectedContainerColor = obj31;
        this.disabledSelectedContainerColor = obj33;
        this.selectedLabelColor = obj35;
        this.selectedLeadingIconColor = obj37;
        this.selectedTrailingIconColor = obj39;
    }

    public SelectableChipColors(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, long l13, DefaultConstructorMarker defaultConstructorMarker14) {
        super(l, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, defaultConstructorMarker14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26);
    }

    public static androidx.compose.material3.SelectableChipColors copy-daRQuJA$default(androidx.compose.material3.SelectableChipColors selectableChipColors, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, long l13, long l14, int i15, Object object16) {
        long selectedTrailingIconColor;
        long containerColor;
        long disabledTrailingIconColor;
        long selectedContainerColor;
        long disabledSelectedContainerColor;
        long selectedLabelColor;
        long selectedLeadingIconColor;
        long labelColor;
        long leadingIconColor;
        long trailingIconColor;
        long disabledContainerColor;
        long disabledLabelColor;
        long disabledLeadingIconColor;
        long obj27;
        Object obj = selectableChipColors;
        int i = obj45;
        containerColor = i & 1 != 0 ? obj.containerColor : l2;
        labelColor = i & 2 != 0 ? obj.labelColor : l4;
        leadingIconColor = i & 4 != 0 ? obj.leadingIconColor : l6;
        trailingIconColor = i & 8 != 0 ? obj.trailingIconColor : l8;
        disabledContainerColor = i & 16 != 0 ? obj.disabledContainerColor : l10;
        disabledLabelColor = i & 32 != 0 ? obj.disabledLabelColor : l12;
        disabledLeadingIconColor = i & 64 != 0 ? obj.disabledLeadingIconColor : l14;
        disabledTrailingIconColor = i & 128 != 0 ? obj.disabledTrailingIconColor : object16;
        selectedContainerColor = i & 256 != 0 ? obj.selectedContainerColor : obj35;
        final long obj21 = selectedContainerColor;
        disabledSelectedContainerColor = i & 512 != 0 ? obj.disabledSelectedContainerColor : obj37;
        final long obj23 = disabledSelectedContainerColor;
        selectedLabelColor = i & 1024 != 0 ? obj.selectedLabelColor : obj39;
        final long obj25 = selectedLabelColor;
        selectedLeadingIconColor = i & 2048 != 0 ? obj.selectedLeadingIconColor : obj41;
        selectedTrailingIconColor = i &= 4096 != 0 ? obj.selectedTrailingIconColor : obj43;
        return obj.copy-daRQuJA(containerColor, obj21, labelColor, obj23, leadingIconColor, obj25, trailingIconColor, obj27, disabledContainerColor, l12, disabledLabelColor, l14, disabledLeadingIconColor);
    }

    public final long containerColor-WaAFU9c$material3_release(boolean enabled, boolean selected) {
        long disabledContainerColor;
        if (!enabled) {
            disabledContainerColor = selected ? this.disabledSelectedContainerColor : this.disabledContainerColor;
        } else {
            disabledContainerColor = !selected ? this.containerColor : this.selectedContainerColor;
        }
        return disabledContainerColor;
    }

    public final androidx.compose.material3.SelectableChipColors copy-daRQuJA(long containerColor, long labelColor, long leadingIconColor, long trailingIconColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconColor, long disabledTrailingIconColor, long selectedContainerColor, long disabledSelectedContainerColor, long selectedLabelColor, long selectedLeadingIconColor, long selectedTrailingIconColor) {
        int $i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$1;
        int $i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$2;
        int $i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$3;
        int $i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$4;
        int $this$isSpecified$iv$iv7;
        int $this$isSpecified$iv$iv2;
        int $this$isSpecified$iv$iv5;
        int $this$isSpecified$iv$iv3;
        int $this$isSpecified$iv$iv;
        int $this$isSpecified$iv$iv6;
        int $this$isSpecified$iv$iv4;
        int $i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$12;
        long $i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$13;
        int i;
        long l13;
        long l;
        long l5;
        long l4;
        long l11;
        long l6;
        long l7;
        long l8;
        long l9;
        long l2;
        long l3;
        long l12;
        long l10;
        final Object obj = this;
        int i2 = containerColor;
        int i3 = 0;
        int i41 = 0;
        int i54 = 16;
        i = 1;
        final int i55 = 0;
        $i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$1 = Long.compare(i16, i54) != 0 ? i : i55;
        if ($i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$1 != 0) {
            l13 = i2;
        } else {
            int i40 = 0;
            l13 = $i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$1;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv = leadingIconColor;
        int i4 = 0;
        int i42 = 0;
        $i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$2 = Long.compare(i17, i54) != 0 ? i : i55;
        if ($i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$2 != 0) {
            l = $this$takeOrElse_u2dDxMtmZc$iv;
        } else {
            int i39 = 0;
            l = $i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$2;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv2 = disabledContainerColor;
        int i5 = 0;
        int i43 = 0;
        $i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$3 = Long.compare(i18, i54) != 0 ? i : i55;
        if ($i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$3 != 0) {
            l5 = $this$takeOrElse_u2dDxMtmZc$iv2;
        } else {
            int i38 = 0;
            l5 = $i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$3;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv3 = disabledLeadingIconColor;
        int i6 = 0;
        int i44 = 0;
        $i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$4 = Long.compare(i19, i54) != 0 ? i : i55;
        if ($i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$4 != 0) {
            l4 = $this$takeOrElse_u2dDxMtmZc$iv3;
        } else {
            int i37 = 0;
            l4 = $i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$4;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv4 = selectedContainerColor;
        int i7 = 0;
        int i45 = 0;
        $this$isSpecified$iv$iv7 = Long.compare(i20, i54) != 0 ? i : i55;
        if ($this$isSpecified$iv$iv7 != 0) {
            l11 = $this$takeOrElse_u2dDxMtmZc$iv4;
        } else {
            int i36 = 0;
            l11 = $this$isSpecified$iv$iv7;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv5 = selectedLabelColor;
        int i8 = 0;
        int i46 = 0;
        $this$isSpecified$iv$iv2 = Long.compare(i21, i54) != 0 ? i : i55;
        if ($this$isSpecified$iv$iv2 != 0) {
            l6 = $this$takeOrElse_u2dDxMtmZc$iv5;
        } else {
            int i35 = 0;
            l6 = $this$isSpecified$iv$iv2;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv6 = selectedTrailingIconColor;
        int i9 = 0;
        int i47 = 0;
        $this$isSpecified$iv$iv5 = Long.compare(i22, i54) != 0 ? i : i55;
        if ($this$isSpecified$iv$iv5 != 0) {
            l7 = $this$takeOrElse_u2dDxMtmZc$iv6;
        } else {
            int i34 = 0;
            l7 = $this$isSpecified$iv$iv5;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv7 = obj55;
        int i10 = 0;
        int i48 = 0;
        $this$isSpecified$iv$iv3 = Long.compare(i23, i54) != 0 ? i : i55;
        if ($this$isSpecified$iv$iv3 != 0) {
            l8 = $this$takeOrElse_u2dDxMtmZc$iv7;
        } else {
            int i33 = 0;
            l8 = $this$isSpecified$iv$iv3;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv8 = obj57;
        int i11 = 0;
        int i49 = 0;
        $this$isSpecified$iv$iv = Long.compare(i24, i54) != 0 ? i : i55;
        if ($this$isSpecified$iv$iv != 0) {
            l9 = $this$takeOrElse_u2dDxMtmZc$iv8;
        } else {
            int i32 = 0;
            l9 = $this$isSpecified$iv$iv;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv9 = obj59;
        int i12 = 0;
        int i50 = 0;
        $this$isSpecified$iv$iv6 = Long.compare(i25, i54) != 0 ? i : i55;
        if ($this$isSpecified$iv$iv6 != 0) {
            l2 = $this$takeOrElse_u2dDxMtmZc$iv9;
        } else {
            int i31 = 0;
            l2 = $this$isSpecified$iv$iv6;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv10 = obj61;
        int i13 = 0;
        int i51 = 0;
        $this$isSpecified$iv$iv4 = Long.compare(i26, i54) != 0 ? i : i55;
        if ($this$isSpecified$iv$iv4 != 0) {
            l3 = $this$takeOrElse_u2dDxMtmZc$iv10;
        } else {
            int i30 = 0;
            l3 = $this$isSpecified$iv$iv4;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv11 = obj63;
        int i14 = 0;
        int i52 = 0;
        $i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$12 = Long.compare(i27, i54) != 0 ? i : i55;
        if ($i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$12 != 0) {
            l12 = $this$takeOrElse_u2dDxMtmZc$iv11;
        } else {
            int i29 = 0;
            l12 = $i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$12;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv12 = obj65;
        int i15 = 0;
        int i53 = 0;
        if (Long.compare($i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$13, i54) != 0) {
        } else {
            i = i55;
        }
        if (i != 0) {
            l10 = $this$takeOrElse_u2dDxMtmZc$iv12;
        } else {
            int i28 = 0;
            l10 = $i$a$TakeOrElseDxMtmZcSelectableChipColors$copy$13;
        }
        SelectableChipColors selectableChipColors = new SelectableChipColors(l13, obj14, l, obj16, l5, obj18, l4, obj20, l11, obj22, l6, obj24, l7, obj26, l8, obj28, l9, obj30, l2, obj32, l3, obj34, l12, obj36, l10, obj38, 0);
        return selectableChipColors;
    }

    public boolean equals(Object other) {
        boolean z;
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other != null) {
            if (!other instanceof SelectableChipColors) {
            } else {
                if (!Color.equals-impl0(this.containerColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.labelColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.leadingIconColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.trailingIconColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledContainerColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledLabelColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledLeadingIconColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledTrailingIconColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.selectedContainerColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledSelectedContainerColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.selectedLabelColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.selectedLeadingIconColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.selectedTrailingIconColor, obj3)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        return result6 += i26;
    }

    public final long labelColor-WaAFU9c$material3_release(boolean enabled, boolean selected) {
        long disabledLabelColor;
        disabledLabelColor = !enabled ? this.disabledLabelColor : !selected ? this.labelColor : this.selectedLabelColor;
        return disabledLabelColor;
    }

    public final long leadingIconContentColor-WaAFU9c$material3_release(boolean enabled, boolean selected) {
        long disabledLeadingIconColor;
        disabledLeadingIconColor = !enabled ? this.disabledLeadingIconColor : !selected ? this.leadingIconColor : this.selectedLeadingIconColor;
        return disabledLeadingIconColor;
    }

    public final long trailingIconContentColor-WaAFU9c$material3_release(boolean enabled, boolean selected) {
        long disabledTrailingIconColor;
        disabledTrailingIconColor = !enabled ? this.disabledTrailingIconColor : !selected ? this.trailingIconColor : this.selectedTrailingIconColor;
        return disabledTrailingIconColor;
    }
}
