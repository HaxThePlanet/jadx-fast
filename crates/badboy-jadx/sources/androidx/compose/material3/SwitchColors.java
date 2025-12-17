package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008$\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0008\u0007\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000c\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0002\u0010\u0013J%\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+J°\u0001\u0010,\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\r\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\u0008-\u0010.J\u0013\u0010/\u001a\u00020(2\u0008\u00100\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u00101\u001a\u000202H\u0016J%\u00103\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u00084\u0010+J%\u00105\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u00086\u0010+J%\u00107\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u00088\u0010+R\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008\u0014\u0010\u0015R\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008\u0017\u0010\u0015R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008\u0018\u0010\u0015R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008\u0019\u0010\u0015R\u0019\u0010\r\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008\u001a\u0010\u0015R\u0019\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008\u001b\u0010\u0015R\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008\u001c\u0010\u0015R\u0019\u0010\u000c\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008\u001d\u0010\u0015R\u0019\u0010\u0011\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008\u001e\u0010\u0015R\u0019\u0010\u0012\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008\u001f\u0010\u0015R\u0019\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008 \u0010\u0015R\u0019\u0010\u0010\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008!\u0010\u0015R\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008\"\u0010\u0015R\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008#\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008$\u0010\u0015R\u0019\u0010\u0008\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008%\u0010\u0015\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00069", d2 = {"Landroidx/compose/material3/SwitchColors;", "", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "(JJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCheckedBorderColor-0d7_KjU", "()J", "J", "getCheckedIconColor-0d7_KjU", "getCheckedThumbColor-0d7_KjU", "getCheckedTrackColor-0d7_KjU", "getDisabledCheckedBorderColor-0d7_KjU", "getDisabledCheckedIconColor-0d7_KjU", "getDisabledCheckedThumbColor-0d7_KjU", "getDisabledCheckedTrackColor-0d7_KjU", "getDisabledUncheckedBorderColor-0d7_KjU", "getDisabledUncheckedIconColor-0d7_KjU", "getDisabledUncheckedThumbColor-0d7_KjU", "getDisabledUncheckedTrackColor-0d7_KjU", "getUncheckedBorderColor-0d7_KjU", "getUncheckedIconColor-0d7_KjU", "getUncheckedThumbColor-0d7_KjU", "getUncheckedTrackColor-0d7_KjU", "borderColor", "enabled", "", "checked", "borderColor-WaAFU9c$material3_release", "(ZZ)J", "copy", "copy-Q_H9qLU", "(JJJJJJJJJJJJJJJJ)Landroidx/compose/material3/SwitchColors;", "equals", "other", "hashCode", "", "iconColor", "iconColor-WaAFU9c$material3_release", "thumbColor", "thumbColor-WaAFU9c$material3_release", "trackColor", "trackColor-WaAFU9c$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwitchColors {

    public static final int $stable;
    private final long checkedBorderColor;
    private final long checkedIconColor;
    private final long checkedThumbColor;
    private final long checkedTrackColor;
    private final long disabledCheckedBorderColor;
    private final long disabledCheckedIconColor;
    private final long disabledCheckedThumbColor;
    private final long disabledCheckedTrackColor;
    private final long disabledUncheckedBorderColor;
    private final long disabledUncheckedIconColor;
    private final long disabledUncheckedThumbColor;
    private final long disabledUncheckedTrackColor;
    private final long uncheckedBorderColor;
    private final long uncheckedIconColor;
    private final long uncheckedThumbColor;
    private final long uncheckedTrackColor;
    static {
    }

    private SwitchColors(long checkedThumbColor, long checkedTrackColor, long checkedBorderColor, long checkedIconColor, long uncheckedThumbColor, long uncheckedTrackColor, long uncheckedBorderColor, long uncheckedIconColor, long disabledCheckedThumbColor, long disabledCheckedTrackColor, long disabledCheckedBorderColor, long disabledCheckedIconColor, long disabledUncheckedThumbColor, long disabledUncheckedTrackColor, long disabledUncheckedBorderColor, long disabledUncheckedIconColor) {
        super();
        this.checkedThumbColor = checkedThumbColor;
        this.checkedTrackColor = checkedBorderColor;
        this.checkedBorderColor = uncheckedThumbColor;
        this.checkedIconColor = uncheckedBorderColor;
        this.uncheckedThumbColor = disabledCheckedThumbColor;
        this.uncheckedTrackColor = disabledCheckedBorderColor;
        this.uncheckedBorderColor = disabledUncheckedThumbColor;
        this.uncheckedIconColor = disabledUncheckedBorderColor;
        this.disabledCheckedThumbColor = obj31;
        this.disabledCheckedTrackColor = obj33;
        this.disabledCheckedBorderColor = obj35;
        this.disabledCheckedIconColor = obj37;
        this.disabledUncheckedThumbColor = obj39;
        this.disabledUncheckedTrackColor = obj41;
        this.disabledUncheckedBorderColor = obj43;
        this.disabledUncheckedIconColor = obj45;
    }

    public SwitchColors(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, long l13, long l14, long l15, long l16, DefaultConstructorMarker defaultConstructorMarker17) {
        super(l, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, defaultConstructorMarker17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28, obj29, obj30, obj31, obj32);
    }

    public static androidx.compose.material3.SwitchColors copy-Q_H9qLU$default(androidx.compose.material3.SwitchColors switchColors, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, long l13, long l14, long l15, long l16, long l17, int i18, Object object19) {
        long disabledUncheckedIconColor;
        long checkedThumbColor;
        long uncheckedIconColor;
        long disabledCheckedThumbColor;
        long disabledCheckedTrackColor;
        long disabledCheckedBorderColor;
        long disabledCheckedIconColor;
        long disabledUncheckedThumbColor;
        long disabledUncheckedTrackColor;
        long disabledUncheckedBorderColor;
        long checkedTrackColor;
        long checkedBorderColor;
        long checkedIconColor;
        long uncheckedThumbColor;
        long uncheckedTrackColor;
        long uncheckedBorderColor;
        long obj34;
        Object obj = switchColors;
        int i = obj52;
        checkedThumbColor = i & 1 != 0 ? obj.checkedThumbColor : l2;
        checkedTrackColor = i & 2 != 0 ? obj.checkedTrackColor : l4;
        checkedBorderColor = i & 4 != 0 ? obj.checkedBorderColor : l6;
        checkedIconColor = i & 8 != 0 ? obj.checkedIconColor : l8;
        uncheckedThumbColor = i & 16 != 0 ? obj.uncheckedThumbColor : l10;
        uncheckedTrackColor = i & 32 != 0 ? obj.uncheckedTrackColor : l12;
        uncheckedBorderColor = i & 64 != 0 ? obj.uncheckedBorderColor : l14;
        uncheckedIconColor = i & 128 != 0 ? obj.uncheckedIconColor : l16;
        disabledCheckedThumbColor = i & 256 != 0 ? obj.disabledCheckedThumbColor : i18;
        final long obj22 = disabledCheckedThumbColor;
        disabledCheckedTrackColor = i & 512 != 0 ? obj.disabledCheckedTrackColor : obj38;
        final long obj24 = disabledCheckedTrackColor;
        disabledCheckedBorderColor = i & 1024 != 0 ? obj.disabledCheckedBorderColor : obj40;
        final long obj26 = disabledCheckedBorderColor;
        disabledCheckedIconColor = i & 2048 != 0 ? obj.disabledCheckedIconColor : obj42;
        final long obj28 = disabledCheckedIconColor;
        disabledUncheckedThumbColor = i & 4096 != 0 ? obj.disabledUncheckedThumbColor : obj44;
        final long obj30 = disabledUncheckedThumbColor;
        disabledUncheckedTrackColor = i & 8192 != 0 ? obj.disabledUncheckedTrackColor : obj46;
        final long obj32 = disabledUncheckedTrackColor;
        disabledUncheckedBorderColor = i & 16384 != 0 ? obj.disabledUncheckedBorderColor : obj48;
        disabledUncheckedIconColor = i &= i19 != 0 ? obj.disabledUncheckedIconColor : obj50;
        return obj.copy-Q_H9qLU(checkedThumbColor, obj22, checkedTrackColor, obj24, checkedBorderColor, obj26, checkedIconColor, obj28, uncheckedThumbColor, obj30, uncheckedTrackColor, obj32, uncheckedBorderColor, obj34, uncheckedIconColor, i18);
    }

    public final long borderColor-WaAFU9c$material3_release(boolean enabled, boolean checked) {
        long uncheckedBorderColor;
        if (enabled) {
            uncheckedBorderColor = checked ? this.checkedBorderColor : this.uncheckedBorderColor;
        } else {
            uncheckedBorderColor = checked ? this.disabledCheckedBorderColor : this.disabledUncheckedBorderColor;
        }
        return uncheckedBorderColor;
    }

    public final androidx.compose.material3.SwitchColors copy-Q_H9qLU(long checkedThumbColor, long checkedTrackColor, long checkedBorderColor, long checkedIconColor, long uncheckedThumbColor, long uncheckedTrackColor, long uncheckedBorderColor, long uncheckedIconColor, long disabledCheckedThumbColor, long disabledCheckedTrackColor, long disabledCheckedBorderColor, long disabledCheckedIconColor, long disabledUncheckedThumbColor, long disabledUncheckedTrackColor, long disabledUncheckedBorderColor, long disabledUncheckedIconColor) {
        int $i$a$TakeOrElseDxMtmZcSwitchColors$copy$1;
        int $i$a$TakeOrElseDxMtmZcSwitchColors$copy$2;
        int $i$a$TakeOrElseDxMtmZcSwitchColors$copy$3;
        int $i$a$TakeOrElseDxMtmZcSwitchColors$copy$4;
        int $this$isSpecified$iv$iv;
        int $this$isSpecified$iv$iv7;
        int $this$isSpecified$iv$iv5;
        int $this$isSpecified$iv$iv6;
        int $this$isSpecified$iv$iv3;
        int $this$isSpecified$iv$iv4;
        int $this$isSpecified$iv$iv2;
        int $i$a$TakeOrElseDxMtmZcSwitchColors$copy$12;
        int $i$a$TakeOrElseDxMtmZcSwitchColors$copy$13;
        int $i$a$TakeOrElseDxMtmZcSwitchColors$copy$14;
        int $i$a$TakeOrElseDxMtmZcSwitchColors$copy$15;
        int $i$a$TakeOrElseDxMtmZcSwitchColors$copy$16;
        int i2;
        long l8;
        long l3;
        long l5;
        long l7;
        long l4;
        long l10;
        long l12;
        long l14;
        long l;
        long l6;
        long l9;
        long l13;
        long l11;
        long l2;
        long i3;
        long i;
        final Object obj = this;
        int i4 = checkedThumbColor;
        int i5 = 0;
        int i52 = 0;
        int i68 = 16;
        i2 = 1;
        final int i69 = 0;
        $i$a$TakeOrElseDxMtmZcSwitchColors$copy$1 = Long.compare(i21, i68) != 0 ? i2 : i69;
        if ($i$a$TakeOrElseDxMtmZcSwitchColors$copy$1 != 0) {
            l8 = i4;
        } else {
            int i51 = 0;
            l8 = $i$a$TakeOrElseDxMtmZcSwitchColors$copy$1;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv = checkedBorderColor;
        int i6 = 0;
        int i53 = 0;
        $i$a$TakeOrElseDxMtmZcSwitchColors$copy$2 = Long.compare(i22, i68) != 0 ? i2 : i69;
        if ($i$a$TakeOrElseDxMtmZcSwitchColors$copy$2 != 0) {
            l3 = $this$takeOrElse_u2dDxMtmZc$iv;
        } else {
            int i50 = 0;
            l3 = $i$a$TakeOrElseDxMtmZcSwitchColors$copy$2;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv2 = uncheckedThumbColor;
        int i7 = 0;
        int i54 = 0;
        $i$a$TakeOrElseDxMtmZcSwitchColors$copy$3 = Long.compare(i23, i68) != 0 ? i2 : i69;
        if ($i$a$TakeOrElseDxMtmZcSwitchColors$copy$3 != 0) {
            l5 = $this$takeOrElse_u2dDxMtmZc$iv2;
        } else {
            int i49 = 0;
            l5 = $i$a$TakeOrElseDxMtmZcSwitchColors$copy$3;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv3 = uncheckedBorderColor;
        int i8 = 0;
        int i55 = 0;
        $i$a$TakeOrElseDxMtmZcSwitchColors$copy$4 = Long.compare(i24, i68) != 0 ? i2 : i69;
        if ($i$a$TakeOrElseDxMtmZcSwitchColors$copy$4 != 0) {
            l7 = $this$takeOrElse_u2dDxMtmZc$iv3;
        } else {
            int i48 = 0;
            l7 = $i$a$TakeOrElseDxMtmZcSwitchColors$copy$4;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv4 = disabledCheckedThumbColor;
        int i9 = 0;
        int i56 = 0;
        $this$isSpecified$iv$iv = Long.compare(i25, i68) != 0 ? i2 : i69;
        if ($this$isSpecified$iv$iv != 0) {
            l4 = $this$takeOrElse_u2dDxMtmZc$iv4;
        } else {
            int i47 = 0;
            l4 = $this$isSpecified$iv$iv;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv5 = disabledCheckedBorderColor;
        int i10 = 0;
        int i57 = 0;
        $this$isSpecified$iv$iv7 = Long.compare(i26, i68) != 0 ? i2 : i69;
        if ($this$isSpecified$iv$iv7 != 0) {
            l10 = $this$takeOrElse_u2dDxMtmZc$iv5;
        } else {
            int i46 = 0;
            l10 = $this$isSpecified$iv$iv7;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv6 = disabledUncheckedThumbColor;
        int i11 = 0;
        int i58 = 0;
        $this$isSpecified$iv$iv5 = Long.compare(i27, i68) != 0 ? i2 : i69;
        if ($this$isSpecified$iv$iv5 != 0) {
            l12 = $this$takeOrElse_u2dDxMtmZc$iv6;
        } else {
            int i45 = 0;
            l12 = $this$isSpecified$iv$iv5;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv7 = disabledUncheckedBorderColor;
        int i12 = 0;
        int i59 = 0;
        $this$isSpecified$iv$iv6 = Long.compare(i28, i68) != 0 ? i2 : i69;
        if ($this$isSpecified$iv$iv6 != 0) {
            l14 = $this$takeOrElse_u2dDxMtmZc$iv7;
        } else {
            int i44 = 0;
            l14 = $this$isSpecified$iv$iv6;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv8 = obj63;
        int i13 = 0;
        int i60 = 0;
        $this$isSpecified$iv$iv3 = Long.compare(i29, i68) != 0 ? i2 : i69;
        if ($this$isSpecified$iv$iv3 != 0) {
            l = $this$takeOrElse_u2dDxMtmZc$iv8;
        } else {
            int i43 = 0;
            l = $this$isSpecified$iv$iv3;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv9 = obj65;
        int i14 = 0;
        int i61 = 0;
        $this$isSpecified$iv$iv4 = Long.compare(i30, i68) != 0 ? i2 : i69;
        if ($this$isSpecified$iv$iv4 != 0) {
            l6 = $this$takeOrElse_u2dDxMtmZc$iv9;
        } else {
            int i42 = 0;
            l6 = $this$isSpecified$iv$iv4;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv10 = obj67;
        int i15 = 0;
        int i62 = 0;
        $this$isSpecified$iv$iv2 = Long.compare(i31, i68) != 0 ? i2 : i69;
        if ($this$isSpecified$iv$iv2 != 0) {
            l9 = $this$takeOrElse_u2dDxMtmZc$iv10;
        } else {
            int i41 = 0;
            l9 = $this$isSpecified$iv$iv2;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv11 = obj69;
        int i16 = 0;
        int i63 = 0;
        $i$a$TakeOrElseDxMtmZcSwitchColors$copy$12 = Long.compare(i32, i68) != 0 ? i2 : i69;
        if ($i$a$TakeOrElseDxMtmZcSwitchColors$copy$12 != 0) {
            l13 = $this$takeOrElse_u2dDxMtmZc$iv11;
        } else {
            int i40 = 0;
            l13 = $i$a$TakeOrElseDxMtmZcSwitchColors$copy$12;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv12 = obj71;
        int i17 = 0;
        int i64 = 0;
        $i$a$TakeOrElseDxMtmZcSwitchColors$copy$13 = Long.compare(i33, i68) != 0 ? i2 : i69;
        if ($i$a$TakeOrElseDxMtmZcSwitchColors$copy$13 != 0) {
            l11 = $this$takeOrElse_u2dDxMtmZc$iv12;
        } else {
            int i39 = 0;
            l11 = $i$a$TakeOrElseDxMtmZcSwitchColors$copy$13;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv13 = obj73;
        int i18 = 0;
        int i65 = 0;
        $i$a$TakeOrElseDxMtmZcSwitchColors$copy$14 = Long.compare(i34, i68) != 0 ? i2 : i69;
        if ($i$a$TakeOrElseDxMtmZcSwitchColors$copy$14 != 0) {
            l2 = $this$takeOrElse_u2dDxMtmZc$iv13;
        } else {
            int i38 = 0;
            l2 = $i$a$TakeOrElseDxMtmZcSwitchColors$copy$14;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv14 = obj75;
        int i19 = 0;
        int i66 = 0;
        $i$a$TakeOrElseDxMtmZcSwitchColors$copy$15 = Long.compare(i35, i68) != 0 ? i2 : i69;
        if ($i$a$TakeOrElseDxMtmZcSwitchColors$copy$15 != 0) {
            i3 = $this$takeOrElse_u2dDxMtmZc$iv14;
        } else {
            int i37 = 0;
            i3 = $i$a$TakeOrElseDxMtmZcSwitchColors$copy$15;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv15 = obj77;
        int i20 = 0;
        int i67 = 0;
        if (Long.compare($i$a$TakeOrElseDxMtmZcSwitchColors$copy$16, i68) != 0) {
        } else {
            i2 = i69;
        }
        if (i2 != 0) {
            i = $this$takeOrElse_u2dDxMtmZc$iv15;
        } else {
            int i36 = 0;
            i = $i$a$TakeOrElseDxMtmZcSwitchColors$copy$16;
        }
        SwitchColors switchColors = new SwitchColors(l8, obj14, l3, obj16, l5, obj18, l7, obj20, l4, obj22, l10, obj24, l12, obj26, l14, obj28, l, obj30, l6, obj32, l9, obj34, l13, obj36, l11, obj38, l2, obj40, i3, obj42, i, obj44, 0);
        return switchColors;
    }

    public boolean equals(Object other) {
        boolean z;
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other != null) {
            if (!other instanceof SwitchColors) {
            } else {
                if (!Color.equals-impl0(this.checkedThumbColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.checkedTrackColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.checkedBorderColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.checkedIconColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.uncheckedThumbColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.uncheckedTrackColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.uncheckedBorderColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.uncheckedIconColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledCheckedThumbColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledCheckedTrackColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledCheckedBorderColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledCheckedIconColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledUncheckedThumbColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledUncheckedTrackColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledUncheckedBorderColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledUncheckedIconColor, obj3)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public final long getCheckedBorderColor-0d7_KjU() {
        return this.checkedBorderColor;
    }

    public final long getCheckedIconColor-0d7_KjU() {
        return this.checkedIconColor;
    }

    public final long getCheckedThumbColor-0d7_KjU() {
        return this.checkedThumbColor;
    }

    public final long getCheckedTrackColor-0d7_KjU() {
        return this.checkedTrackColor;
    }

    public final long getDisabledCheckedBorderColor-0d7_KjU() {
        return this.disabledCheckedBorderColor;
    }

    public final long getDisabledCheckedIconColor-0d7_KjU() {
        return this.disabledCheckedIconColor;
    }

    public final long getDisabledCheckedThumbColor-0d7_KjU() {
        return this.disabledCheckedThumbColor;
    }

    public final long getDisabledCheckedTrackColor-0d7_KjU() {
        return this.disabledCheckedTrackColor;
    }

    public final long getDisabledUncheckedBorderColor-0d7_KjU() {
        return this.disabledUncheckedBorderColor;
    }

    public final long getDisabledUncheckedIconColor-0d7_KjU() {
        return this.disabledUncheckedIconColor;
    }

    public final long getDisabledUncheckedThumbColor-0d7_KjU() {
        return this.disabledUncheckedThumbColor;
    }

    public final long getDisabledUncheckedTrackColor-0d7_KjU() {
        return this.disabledUncheckedTrackColor;
    }

    public final long getUncheckedBorderColor-0d7_KjU() {
        return this.uncheckedBorderColor;
    }

    public final long getUncheckedIconColor-0d7_KjU() {
        return this.uncheckedIconColor;
    }

    public final long getUncheckedThumbColor-0d7_KjU() {
        return this.uncheckedThumbColor;
    }

    public final long getUncheckedTrackColor-0d7_KjU() {
        return this.uncheckedTrackColor;
    }

    public int hashCode() {
        return result14 += i32;
    }

    public final long iconColor-WaAFU9c$material3_release(boolean enabled, boolean checked) {
        long disabledUncheckedIconColor;
        if (enabled) {
            disabledUncheckedIconColor = checked ? this.checkedIconColor : this.uncheckedIconColor;
        } else {
            disabledUncheckedIconColor = checked ? this.disabledCheckedIconColor : this.disabledUncheckedIconColor;
        }
        return disabledUncheckedIconColor;
    }

    public final long thumbColor-WaAFU9c$material3_release(boolean enabled, boolean checked) {
        long disabledUncheckedThumbColor;
        if (enabled) {
            disabledUncheckedThumbColor = checked ? this.checkedThumbColor : this.uncheckedThumbColor;
        } else {
            disabledUncheckedThumbColor = checked ? this.disabledCheckedThumbColor : this.disabledUncheckedThumbColor;
        }
        return disabledUncheckedThumbColor;
    }

    public final long trackColor-WaAFU9c$material3_release(boolean enabled, boolean checked) {
        long disabledUncheckedTrackColor;
        if (enabled) {
            disabledUncheckedTrackColor = checked ? this.checkedTrackColor : this.uncheckedTrackColor;
        } else {
            disabledUncheckedTrackColor = checked ? this.disabledCheckedTrackColor : this.disabledUncheckedTrackColor;
        }
        return disabledUncheckedTrackColor;
    }
}
