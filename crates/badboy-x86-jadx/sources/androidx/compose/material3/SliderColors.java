package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u001a\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\n\u0008\u0007\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000c\u001a\u00020\u0003¢\u0006\u0002\u0010\rJt\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010 \u001a\u00020!H\u0016J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u001eH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$J%\u0010%\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u001eH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(J%\u0010)\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u001eH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008*\u0010(R\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u000e\u0010\u000fR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u0011\u0010\u000fR\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u0012\u0010\u000fR\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u0013\u0010\u000fR\u0019\u0010\u000c\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u0014\u0010\u000fR\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u0015\u0010\u000fR\u0019\u0010\u0008\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u0016\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u0017\u0010\u000fR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u0018\u0010\u000fR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u0019\u0010\u000f\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006+", d2 = {"Landroidx/compose/material3/SliderColors;", "", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "(JJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActiveTickColor-0d7_KjU", "()J", "J", "getActiveTrackColor-0d7_KjU", "getDisabledActiveTickColor-0d7_KjU", "getDisabledActiveTrackColor-0d7_KjU", "getDisabledInactiveTickColor-0d7_KjU", "getDisabledInactiveTrackColor-0d7_KjU", "getDisabledThumbColor-0d7_KjU", "getInactiveTickColor-0d7_KjU", "getInactiveTrackColor-0d7_KjU", "getThumbColor-0d7_KjU", "copy", "copy--K518z4", "(JJJJJJJJJJ)Landroidx/compose/material3/SliderColors;", "equals", "", "other", "hashCode", "", "enabled", "thumbColor-vNxB06k$material3_release", "(Z)J", "tickColor", "active", "tickColor-WaAFU9c$material3_release", "(ZZ)J", "trackColor", "trackColor-WaAFU9c$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SliderColors {

    public static final int $stable;
    private final long activeTickColor;
    private final long activeTrackColor;
    private final long disabledActiveTickColor;
    private final long disabledActiveTrackColor;
    private final long disabledInactiveTickColor;
    private final long disabledInactiveTrackColor;
    private final long disabledThumbColor;
    private final long inactiveTickColor;
    private final long inactiveTrackColor;
    private final long thumbColor;
    static {
    }

    private SliderColors(long thumbColor, long activeTrackColor, long activeTickColor, long inactiveTrackColor, long inactiveTickColor, long disabledThumbColor, long disabledActiveTrackColor, long disabledActiveTickColor, long disabledInactiveTrackColor, long disabledInactiveTickColor) {
        super();
        this.thumbColor = thumbColor;
        this.activeTrackColor = activeTickColor;
        this.activeTickColor = inactiveTickColor;
        this.inactiveTrackColor = disabledActiveTrackColor;
        this.inactiveTickColor = disabledInactiveTrackColor;
        this.disabledThumbColor = obj25;
        this.disabledActiveTrackColor = obj27;
        this.disabledActiveTickColor = obj29;
        this.disabledInactiveTrackColor = obj31;
        this.disabledInactiveTickColor = obj33;
    }

    public SliderColors(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, DefaultConstructorMarker defaultConstructorMarker11) {
        super(l, l2, l3, l4, l5, l6, l7, l8, l9, l10, defaultConstructorMarker11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    public static androidx.compose.material3.SliderColors copy--K518z4$default(androidx.compose.material3.SliderColors sliderColors, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, int i12, Object object13) {
        long disabledInactiveTickColor;
        long thumbColor;
        long disabledActiveTickColor;
        long disabledInactiveTrackColor;
        long activeTrackColor;
        long activeTickColor;
        long inactiveTrackColor;
        long inactiveTickColor;
        long disabledThumbColor;
        long disabledActiveTrackColor;
        long obj21;
        Object obj = sliderColors;
        int i = obj39;
        thumbColor = i & 1 != 0 ? obj.thumbColor : l2;
        activeTrackColor = i & 2 != 0 ? obj.activeTrackColor : l4;
        activeTickColor = i & 4 != 0 ? obj.activeTickColor : l6;
        inactiveTrackColor = i & 8 != 0 ? obj.inactiveTrackColor : l8;
        inactiveTickColor = i & 16 != 0 ? obj.inactiveTickColor : l10;
        disabledThumbColor = i & 32 != 0 ? obj.disabledThumbColor : i12;
        disabledActiveTrackColor = i & 64 != 0 ? obj.disabledActiveTrackColor : obj31;
        disabledActiveTickColor = i & 128 != 0 ? obj.disabledActiveTickColor : obj33;
        disabledInactiveTrackColor = i & 256 != 0 ? obj.disabledInactiveTrackColor : obj35;
        disabledInactiveTickColor = i &= 512 != 0 ? obj.disabledInactiveTickColor : obj37;
        return obj.copy--K518z4(thumbColor, obj21, activeTrackColor, l6, activeTickColor, l8, inactiveTrackColor, l10, inactiveTickColor, i12);
    }

    public final androidx.compose.material3.SliderColors copy--K518z4(long thumbColor, long activeTrackColor, long activeTickColor, long inactiveTrackColor, long inactiveTickColor, long disabledThumbColor, long disabledActiveTrackColor, long disabledActiveTickColor, long disabledInactiveTrackColor, long disabledInactiveTickColor) {
        int $this$isSpecified$iv$iv5;
        int $this$isSpecified$iv$iv8;
        int $this$isSpecified$iv$iv;
        int $this$isSpecified$iv$iv6;
        int $this$isSpecified$iv$iv2;
        int $this$isSpecified$iv$iv3;
        int $this$isSpecified$iv$iv7;
        int $this$isSpecified$iv$iv4;
        int $this$isSpecified$iv$iv9;
        long disabledInactiveTickColor2;
        int i;
        long l5;
        long l6;
        long l9;
        long l2;
        long l;
        long l4;
        long l3;
        long l8;
        long l10;
        long l7;
        final Object obj = this;
        int i2 = thumbColor;
        int i3 = 0;
        int i32 = 0;
        int i42 = 16;
        i = 1;
        final int i43 = 0;
        $this$isSpecified$iv$iv5 = Long.compare(i13, i42) != 0 ? i : i43;
        if ($this$isSpecified$iv$iv5 != 0) {
            l5 = i2;
        } else {
            int i31 = 0;
            l5 = $this$isSpecified$iv$iv5;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv = activeTickColor;
        int i4 = 0;
        int i33 = 0;
        $this$isSpecified$iv$iv8 = Long.compare(i14, i42) != 0 ? i : i43;
        if ($this$isSpecified$iv$iv8 != 0) {
            l6 = $this$takeOrElse_u2dDxMtmZc$iv;
        } else {
            int i30 = 0;
            l6 = $this$isSpecified$iv$iv8;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv2 = inactiveTickColor;
        int i5 = 0;
        int i34 = 0;
        $this$isSpecified$iv$iv = Long.compare(i15, i42) != 0 ? i : i43;
        if ($this$isSpecified$iv$iv != 0) {
            l9 = $this$takeOrElse_u2dDxMtmZc$iv2;
        } else {
            int i29 = 0;
            l9 = $this$isSpecified$iv$iv;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv3 = disabledActiveTrackColor;
        int i6 = 0;
        int i35 = 0;
        $this$isSpecified$iv$iv6 = Long.compare(i16, i42) != 0 ? i : i43;
        if ($this$isSpecified$iv$iv6 != 0) {
            l2 = $this$takeOrElse_u2dDxMtmZc$iv3;
        } else {
            int i28 = 0;
            l2 = $this$isSpecified$iv$iv6;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv4 = disabledInactiveTrackColor;
        int i7 = 0;
        int i36 = 0;
        $this$isSpecified$iv$iv2 = Long.compare(i17, i42) != 0 ? i : i43;
        if ($this$isSpecified$iv$iv2 != 0) {
            l = $this$takeOrElse_u2dDxMtmZc$iv4;
        } else {
            int i27 = 0;
            l = $this$isSpecified$iv$iv2;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv5 = obj45;
        int i8 = 0;
        int i37 = 0;
        $this$isSpecified$iv$iv3 = Long.compare(i18, i42) != 0 ? i : i43;
        if ($this$isSpecified$iv$iv3 != 0) {
            l4 = $this$takeOrElse_u2dDxMtmZc$iv5;
        } else {
            int i26 = 0;
            l4 = $this$isSpecified$iv$iv3;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv6 = obj47;
        int i9 = 0;
        int i38 = 0;
        $this$isSpecified$iv$iv7 = Long.compare(i19, i42) != 0 ? i : i43;
        if ($this$isSpecified$iv$iv7 != 0) {
            l3 = $this$takeOrElse_u2dDxMtmZc$iv6;
        } else {
            int i25 = 0;
            l3 = $this$isSpecified$iv$iv7;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv7 = obj49;
        int i10 = 0;
        int i39 = 0;
        $this$isSpecified$iv$iv4 = Long.compare(i20, i42) != 0 ? i : i43;
        if ($this$isSpecified$iv$iv4 != 0) {
            l8 = $this$takeOrElse_u2dDxMtmZc$iv7;
        } else {
            int i24 = 0;
            l8 = $this$isSpecified$iv$iv4;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv8 = obj51;
        int i11 = 0;
        int i40 = 0;
        $this$isSpecified$iv$iv9 = Long.compare(i21, i42) != 0 ? i : i43;
        if ($this$isSpecified$iv$iv9 != 0) {
            l10 = $this$takeOrElse_u2dDxMtmZc$iv8;
        } else {
            int i23 = 0;
            l10 = $this$isSpecified$iv$iv9;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv9 = obj53;
        int i12 = 0;
        int i41 = 0;
        if (Long.compare(disabledInactiveTickColor2, i42) != 0) {
        } else {
            i = i43;
        }
        if (i != 0) {
            l7 = $this$takeOrElse_u2dDxMtmZc$iv9;
        } else {
            int i22 = 0;
            l7 = disabledInactiveTickColor2;
        }
        SliderColors sliderColors = new SliderColors(l5, obj14, l6, obj16, l9, obj18, l2, obj20, l, obj22, l4, obj24, l3, obj26, l8, obj28, l10, obj30, l7, obj32, 0);
        return sliderColors;
    }

    public boolean equals(Object other) {
        boolean z;
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other != null) {
            if (!other instanceof SliderColors) {
            } else {
                if (!Color.equals-impl0(this.thumbColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.activeTrackColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.activeTickColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.inactiveTrackColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.inactiveTickColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledThumbColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledActiveTrackColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledActiveTickColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledInactiveTrackColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledInactiveTickColor, obj3)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public final long getActiveTickColor-0d7_KjU() {
        return this.activeTickColor;
    }

    public final long getActiveTrackColor-0d7_KjU() {
        return this.activeTrackColor;
    }

    public final long getDisabledActiveTickColor-0d7_KjU() {
        return this.disabledActiveTickColor;
    }

    public final long getDisabledActiveTrackColor-0d7_KjU() {
        return this.disabledActiveTrackColor;
    }

    public final long getDisabledInactiveTickColor-0d7_KjU() {
        return this.disabledInactiveTickColor;
    }

    public final long getDisabledInactiveTrackColor-0d7_KjU() {
        return this.disabledInactiveTrackColor;
    }

    public final long getDisabledThumbColor-0d7_KjU() {
        return this.disabledThumbColor;
    }

    public final long getInactiveTickColor-0d7_KjU() {
        return this.inactiveTickColor;
    }

    public final long getInactiveTrackColor-0d7_KjU() {
        return this.inactiveTrackColor;
    }

    public final long getThumbColor-0d7_KjU() {
        return this.thumbColor;
    }

    public int hashCode() {
        return result8 += i20;
    }

    public final long thumbColor-vNxB06k$material3_release(boolean enabled) {
        long disabledThumbColor;
        disabledThumbColor = enabled ? this.thumbColor : this.disabledThumbColor;
        return disabledThumbColor;
    }

    public final long tickColor-WaAFU9c$material3_release(boolean enabled, boolean active) {
        long disabledInactiveTickColor;
        if (enabled) {
            disabledInactiveTickColor = active ? this.activeTickColor : this.inactiveTickColor;
        } else {
            disabledInactiveTickColor = active ? this.disabledActiveTickColor : this.disabledInactiveTickColor;
        }
        return disabledInactiveTickColor;
    }

    public final long trackColor-WaAFU9c$material3_release(boolean enabled, boolean active) {
        long disabledInactiveTrackColor;
        if (enabled) {
            disabledInactiveTrackColor = active ? this.activeTrackColor : this.inactiveTrackColor;
        } else {
            disabledInactiveTrackColor = active ? this.disabledActiveTrackColor : this.disabledInactiveTrackColor;
        }
        return disabledInactiveTrackColor;
    }
}
