package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u001c\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0010\u0008\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000c\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ%\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#J%\u0010$\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008%\u0010#J%\u0010&\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010'\u001a\u00020 H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008(\u0010#J\u0088\u0001\u0010)\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\r\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+J\u0013\u0010,\u001a\u00020 2\u0008\u0010-\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010.\u001a\u00020/H\u0016R\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0010\u0010\u0011R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0013\u0010\u0011R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0014\u0010\u0011R\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0015\u0010\u0011R\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0016\u0010\u0011R\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0017\u0010\u0011R\u0019\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0018\u0010\u0011R\u0019\u0010\u000c\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0019\u0010\u0011R\u0019\u0010\r\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u001a\u0010\u0011R\u0019\u0010\u0008\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u001b\u0010\u0011R\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u001c\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u001d\u0010\u0011\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00060", d2 = {"Landroidx/compose/material3/SegmentedButtonColors;", "", "activeContainerColor", "Landroidx/compose/ui/graphics/Color;", "activeContentColor", "activeBorderColor", "inactiveContainerColor", "inactiveContentColor", "inactiveBorderColor", "disabledActiveContainerColor", "disabledActiveContentColor", "disabledActiveBorderColor", "disabledInactiveContainerColor", "disabledInactiveContentColor", "disabledInactiveBorderColor", "(JJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActiveBorderColor-0d7_KjU", "()J", "J", "getActiveContainerColor-0d7_KjU", "getActiveContentColor-0d7_KjU", "getDisabledActiveBorderColor-0d7_KjU", "getDisabledActiveContainerColor-0d7_KjU", "getDisabledActiveContentColor-0d7_KjU", "getDisabledInactiveBorderColor-0d7_KjU", "getDisabledInactiveContainerColor-0d7_KjU", "getDisabledInactiveContentColor-0d7_KjU", "getInactiveBorderColor-0d7_KjU", "getInactiveContainerColor-0d7_KjU", "getInactiveContentColor-0d7_KjU", "borderColor", "enabled", "", "active", "borderColor-WaAFU9c$material3_release", "(ZZ)J", "containerColor", "containerColor-WaAFU9c$material3_release", "contentColor", "checked", "contentColor-WaAFU9c$material3_release", "copy", "copy-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material3/SegmentedButtonColors;", "equals", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SegmentedButtonColors {

    public static final int $stable;
    private final long activeBorderColor;
    private final long activeContainerColor;
    private final long activeContentColor;
    private final long disabledActiveBorderColor;
    private final long disabledActiveContainerColor;
    private final long disabledActiveContentColor;
    private final long disabledInactiveBorderColor;
    private final long disabledInactiveContainerColor;
    private final long disabledInactiveContentColor;
    private final long inactiveBorderColor;
    private final long inactiveContainerColor;
    private final long inactiveContentColor;
    static {
    }

    private SegmentedButtonColors(long activeContainerColor, long activeContentColor, long activeBorderColor, long inactiveContainerColor, long inactiveContentColor, long inactiveBorderColor, long disabledActiveContainerColor, long disabledActiveContentColor, long disabledActiveBorderColor, long disabledInactiveContainerColor, long disabledInactiveContentColor, long disabledInactiveBorderColor) {
        super();
        this.activeContainerColor = activeContainerColor;
        this.activeContentColor = activeBorderColor;
        this.activeBorderColor = inactiveContentColor;
        this.inactiveContainerColor = disabledActiveContainerColor;
        this.inactiveContentColor = disabledActiveBorderColor;
        this.inactiveBorderColor = disabledInactiveContentColor;
        this.disabledActiveContainerColor = obj27;
        this.disabledActiveContentColor = obj29;
        this.disabledActiveBorderColor = obj31;
        this.disabledInactiveContainerColor = obj33;
        this.disabledInactiveContentColor = obj35;
        this.disabledInactiveBorderColor = obj37;
    }

    public SegmentedButtonColors(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, DefaultConstructorMarker defaultConstructorMarker13) {
        super(l, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, defaultConstructorMarker13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24);
    }

    public static androidx.compose.material3.SegmentedButtonColors copy-2qZNXz8$default(androidx.compose.material3.SegmentedButtonColors segmentedButtonColors, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, long l13, int i14, Object object15) {
        long disabledInactiveBorderColor;
        long activeContainerColor;
        long disabledActiveContentColor;
        long disabledActiveBorderColor;
        long disabledInactiveContainerColor;
        long disabledInactiveContentColor;
        long activeContentColor;
        long activeBorderColor;
        long inactiveContainerColor;
        long inactiveContentColor;
        long inactiveBorderColor;
        long disabledActiveContainerColor;
        long obj25;
        Object obj = segmentedButtonColors;
        int i = obj43;
        activeContainerColor = i & 1 != 0 ? obj.activeContainerColor : l2;
        activeContentColor = i & 2 != 0 ? obj.activeContentColor : l4;
        activeBorderColor = i & 4 != 0 ? obj.activeBorderColor : l6;
        inactiveContainerColor = i & 8 != 0 ? obj.inactiveContainerColor : l8;
        inactiveContentColor = i & 16 != 0 ? obj.inactiveContentColor : l10;
        inactiveBorderColor = i & 32 != 0 ? obj.inactiveBorderColor : l12;
        disabledActiveContainerColor = i & 64 != 0 ? obj.disabledActiveContainerColor : i14;
        disabledActiveContentColor = i & 128 != 0 ? obj.disabledActiveContentColor : obj33;
        disabledActiveBorderColor = i & 256 != 0 ? obj.disabledActiveBorderColor : obj35;
        final long obj21 = disabledActiveBorderColor;
        disabledInactiveContainerColor = i & 512 != 0 ? obj.disabledInactiveContainerColor : obj37;
        final long obj23 = disabledInactiveContainerColor;
        disabledInactiveContentColor = i & 1024 != 0 ? obj.disabledInactiveContentColor : obj39;
        disabledInactiveBorderColor = i &= 2048 != 0 ? obj.disabledInactiveBorderColor : obj41;
        return obj.copy-2qZNXz8(activeContainerColor, obj21, activeContentColor, obj23, activeBorderColor, obj25, inactiveContainerColor, l10, inactiveContentColor, l12, inactiveBorderColor, i14);
    }

    public final long borderColor-WaAFU9c$material3_release(boolean enabled, boolean active) {
        long disabledActiveBorderColor;
        if (enabled && active) {
            if (active) {
                disabledActiveBorderColor = this.activeBorderColor;
            } else {
                if (enabled && !active) {
                    if (!active) {
                        disabledActiveBorderColor = this.inactiveBorderColor;
                    } else {
                        if (!enabled && active) {
                            disabledActiveBorderColor = active ? this.disabledActiveBorderColor : this.disabledInactiveBorderColor;
                        } else {
                        }
                    }
                } else {
                }
            }
        } else {
        }
        return disabledActiveBorderColor;
    }

    public final long containerColor-WaAFU9c$material3_release(boolean enabled, boolean active) {
        long disabledActiveContainerColor;
        if (enabled && active) {
            if (active) {
                disabledActiveContainerColor = this.activeContainerColor;
            } else {
                if (enabled && !active) {
                    if (!active) {
                        disabledActiveContainerColor = this.inactiveContainerColor;
                    } else {
                        if (!enabled && active) {
                            disabledActiveContainerColor = active ? this.disabledActiveContainerColor : this.disabledInactiveContainerColor;
                        } else {
                        }
                    }
                } else {
                }
            }
        } else {
        }
        return disabledActiveContainerColor;
    }

    public final long contentColor-WaAFU9c$material3_release(boolean enabled, boolean checked) {
        long disabledActiveContentColor;
        if (enabled && checked) {
            if (checked) {
                disabledActiveContentColor = this.activeContentColor;
            } else {
                if (enabled && !checked) {
                    if (!checked) {
                        disabledActiveContentColor = this.inactiveContentColor;
                    } else {
                        if (!enabled && checked) {
                            disabledActiveContentColor = checked ? this.disabledActiveContentColor : this.disabledInactiveContentColor;
                        } else {
                        }
                    }
                } else {
                }
            }
        } else {
        }
        return disabledActiveContentColor;
    }

    public final androidx.compose.material3.SegmentedButtonColors copy-2qZNXz8(long activeContainerColor, long activeContentColor, long activeBorderColor, long inactiveContainerColor, long inactiveContentColor, long inactiveBorderColor, long disabledActiveContainerColor, long disabledActiveContentColor, long disabledActiveBorderColor, long disabledInactiveContainerColor, long disabledInactiveContentColor, long disabledInactiveBorderColor) {
        int $i$a$TakeOrElseDxMtmZcSegmentedButtonColors$copy$1;
        int $i$a$TakeOrElseDxMtmZcSegmentedButtonColors$copy$2;
        int $i$a$TakeOrElseDxMtmZcSegmentedButtonColors$copy$3;
        int $i$a$TakeOrElseDxMtmZcSegmentedButtonColors$copy$4;
        int $this$isSpecified$iv$iv7;
        int $this$isSpecified$iv$iv5;
        int $this$isSpecified$iv$iv6;
        int $this$isSpecified$iv$iv3;
        int $this$isSpecified$iv$iv4;
        int $this$isSpecified$iv$iv;
        int $this$isSpecified$iv$iv2;
        long $i$a$TakeOrElseDxMtmZcSegmentedButtonColors$copy$12;
        int i;
        long l10;
        long l7;
        long l;
        long l5;
        long l9;
        long l6;
        long l11;
        long l12;
        long l2;
        long l3;
        long l8;
        long l4;
        final Object obj = this;
        int i2 = activeContainerColor;
        int i3 = 0;
        int i38 = 0;
        int i50 = 16;
        i = 1;
        final int i51 = 0;
        $i$a$TakeOrElseDxMtmZcSegmentedButtonColors$copy$1 = Long.compare(i15, i50) != 0 ? i : i51;
        if ($i$a$TakeOrElseDxMtmZcSegmentedButtonColors$copy$1 != 0) {
            l10 = i2;
        } else {
            int i37 = 0;
            l10 = $i$a$TakeOrElseDxMtmZcSegmentedButtonColors$copy$1;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv = activeBorderColor;
        int i4 = 0;
        int i39 = 0;
        $i$a$TakeOrElseDxMtmZcSegmentedButtonColors$copy$2 = Long.compare(i16, i50) != 0 ? i : i51;
        if ($i$a$TakeOrElseDxMtmZcSegmentedButtonColors$copy$2 != 0) {
            l7 = $this$takeOrElse_u2dDxMtmZc$iv;
        } else {
            int i36 = 0;
            l7 = $i$a$TakeOrElseDxMtmZcSegmentedButtonColors$copy$2;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv2 = inactiveContentColor;
        int i5 = 0;
        int i40 = 0;
        $i$a$TakeOrElseDxMtmZcSegmentedButtonColors$copy$3 = Long.compare(i17, i50) != 0 ? i : i51;
        if ($i$a$TakeOrElseDxMtmZcSegmentedButtonColors$copy$3 != 0) {
            l = $this$takeOrElse_u2dDxMtmZc$iv2;
        } else {
            int i35 = 0;
            l = $i$a$TakeOrElseDxMtmZcSegmentedButtonColors$copy$3;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv3 = disabledActiveContainerColor;
        int i6 = 0;
        int i41 = 0;
        $i$a$TakeOrElseDxMtmZcSegmentedButtonColors$copy$4 = Long.compare(i18, i50) != 0 ? i : i51;
        if ($i$a$TakeOrElseDxMtmZcSegmentedButtonColors$copy$4 != 0) {
            l5 = $this$takeOrElse_u2dDxMtmZc$iv3;
        } else {
            int i34 = 0;
            l5 = $i$a$TakeOrElseDxMtmZcSegmentedButtonColors$copy$4;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv4 = disabledActiveBorderColor;
        int i7 = 0;
        int i42 = 0;
        $this$isSpecified$iv$iv7 = Long.compare(i19, i50) != 0 ? i : i51;
        if ($this$isSpecified$iv$iv7 != 0) {
            l9 = $this$takeOrElse_u2dDxMtmZc$iv4;
        } else {
            int i33 = 0;
            l9 = $this$isSpecified$iv$iv7;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv5 = disabledInactiveContentColor;
        int i8 = 0;
        int i43 = 0;
        $this$isSpecified$iv$iv5 = Long.compare(i20, i50) != 0 ? i : i51;
        if ($this$isSpecified$iv$iv5 != 0) {
            l6 = $this$takeOrElse_u2dDxMtmZc$iv5;
        } else {
            int i32 = 0;
            l6 = $this$isSpecified$iv$iv5;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv6 = obj51;
        int i9 = 0;
        int i44 = 0;
        $this$isSpecified$iv$iv6 = Long.compare(i21, i50) != 0 ? i : i51;
        if ($this$isSpecified$iv$iv6 != 0) {
            l11 = $this$takeOrElse_u2dDxMtmZc$iv6;
        } else {
            int i31 = 0;
            l11 = $this$isSpecified$iv$iv6;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv7 = obj53;
        int i10 = 0;
        int i45 = 0;
        $this$isSpecified$iv$iv3 = Long.compare(i22, i50) != 0 ? i : i51;
        if ($this$isSpecified$iv$iv3 != 0) {
            l12 = $this$takeOrElse_u2dDxMtmZc$iv7;
        } else {
            int i30 = 0;
            l12 = $this$isSpecified$iv$iv3;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv8 = obj55;
        int i11 = 0;
        int i46 = 0;
        $this$isSpecified$iv$iv4 = Long.compare(i23, i50) != 0 ? i : i51;
        if ($this$isSpecified$iv$iv4 != 0) {
            l2 = $this$takeOrElse_u2dDxMtmZc$iv8;
        } else {
            int i29 = 0;
            l2 = $this$isSpecified$iv$iv4;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv9 = obj57;
        int i12 = 0;
        int i47 = 0;
        $this$isSpecified$iv$iv = Long.compare(i24, i50) != 0 ? i : i51;
        if ($this$isSpecified$iv$iv != 0) {
            l3 = $this$takeOrElse_u2dDxMtmZc$iv9;
        } else {
            int i28 = 0;
            l3 = $this$isSpecified$iv$iv;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv10 = obj59;
        int i13 = 0;
        int i48 = 0;
        $this$isSpecified$iv$iv2 = Long.compare(i25, i50) != 0 ? i : i51;
        if ($this$isSpecified$iv$iv2 != 0) {
            l8 = $this$takeOrElse_u2dDxMtmZc$iv10;
        } else {
            int i27 = 0;
            l8 = $this$isSpecified$iv$iv2;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv11 = obj61;
        int i14 = 0;
        int i49 = 0;
        if (Long.compare($i$a$TakeOrElseDxMtmZcSegmentedButtonColors$copy$12, i50) != 0) {
        } else {
            i = i51;
        }
        if (i != 0) {
            l4 = $this$takeOrElse_u2dDxMtmZc$iv11;
        } else {
            int i26 = 0;
            l4 = $i$a$TakeOrElseDxMtmZcSegmentedButtonColors$copy$12;
        }
        SegmentedButtonColors segmentedButtonColors = new SegmentedButtonColors(l10, obj14, l7, obj16, l, obj18, l5, obj20, l9, obj22, l6, obj24, l11, obj26, l12, obj28, l2, obj30, l3, obj32, l8, obj34, l4, obj36, 0);
        return segmentedButtonColors;
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other == null) {
            return i2;
        }
        final Class class2 = other.getClass();
        if (getClass() != class2) {
            return i2;
        }
        Object obj = other;
        if (!Color.equals-impl0(this.activeBorderColor, class2)) {
            return i2;
        }
        if (!Color.equals-impl0(this.activeContentColor, class2)) {
            return i2;
        }
        if (!Color.equals-impl0(this.activeContainerColor, class2)) {
            return i2;
        }
        if (!Color.equals-impl0(this.inactiveBorderColor, class2)) {
            return i2;
        }
        if (!Color.equals-impl0(this.inactiveContentColor, class2)) {
            return i2;
        }
        if (!Color.equals-impl0(this.inactiveContainerColor, class2)) {
            return i2;
        }
        if (!Color.equals-impl0(this.disabledActiveBorderColor, class2)) {
            return i2;
        }
        if (!Color.equals-impl0(this.disabledActiveContentColor, class2)) {
            return i2;
        }
        if (!Color.equals-impl0(this.disabledActiveContainerColor, class2)) {
            return i2;
        }
        if (!Color.equals-impl0(this.disabledInactiveBorderColor, class2)) {
            return i2;
        }
        if (!Color.equals-impl0(this.disabledInactiveContentColor, class2)) {
            return i2;
        }
        if (!Color.equals-impl0(this.disabledInactiveContainerColor, class2)) {
            return i2;
        }
        return i;
    }

    public final long getActiveBorderColor-0d7_KjU() {
        return this.activeBorderColor;
    }

    public final long getActiveContainerColor-0d7_KjU() {
        return this.activeContainerColor;
    }

    public final long getActiveContentColor-0d7_KjU() {
        return this.activeContentColor;
    }

    public final long getDisabledActiveBorderColor-0d7_KjU() {
        return this.disabledActiveBorderColor;
    }

    public final long getDisabledActiveContainerColor-0d7_KjU() {
        return this.disabledActiveContainerColor;
    }

    public final long getDisabledActiveContentColor-0d7_KjU() {
        return this.disabledActiveContentColor;
    }

    public final long getDisabledInactiveBorderColor-0d7_KjU() {
        return this.disabledInactiveBorderColor;
    }

    public final long getDisabledInactiveContainerColor-0d7_KjU() {
        return this.disabledInactiveContainerColor;
    }

    public final long getDisabledInactiveContentColor-0d7_KjU() {
        return this.disabledInactiveContentColor;
    }

    public final long getInactiveBorderColor-0d7_KjU() {
        return this.inactiveBorderColor;
    }

    public final long getInactiveContainerColor-0d7_KjU() {
        return this.inactiveContainerColor;
    }

    public final long getInactiveContentColor-0d7_KjU() {
        return this.inactiveContentColor;
    }

    public int hashCode() {
        return result10 += i24;
    }
}
