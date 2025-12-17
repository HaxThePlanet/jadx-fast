package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ%\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\u0008\u0016\u0010\u0017J%\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\u0008\u0018\u0010\u0017JL\u0010\u0019\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00142\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u001e\u001a\u00020\u001fH\u0016R\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000bR\u0019\u0010\u0008\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\r\u0010\u000bR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\u000e\u0010\u000bR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\u000f\u0010\u000bR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\u0010\u0010\u000bR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\u0011\u0010\u000b\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006 ", d2 = {"Landroidx/compose/material3/IconToggleButtonColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "checkedContainerColor", "checkedContentColor", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCheckedContainerColor-0d7_KjU", "()J", "J", "getCheckedContentColor-0d7_KjU", "getContainerColor-0d7_KjU", "getContentColor-0d7_KjU", "getDisabledContainerColor-0d7_KjU", "getDisabledContentColor-0d7_KjU", "Landroidx/compose/runtime/State;", "enabled", "", "checked", "containerColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "contentColor$material3_release", "copy", "copy-tNS2XkQ", "(JJJJJJ)Landroidx/compose/material3/IconToggleButtonColors;", "equals", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IconToggleButtonColors {

    public static final int $stable;
    private final long checkedContainerColor;
    private final long checkedContentColor;
    private final long containerColor;
    private final long contentColor;
    private final long disabledContainerColor;
    private final long disabledContentColor;
    static {
    }

    private IconToggleButtonColors(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, long checkedContainerColor, long checkedContentColor) {
        super();
        this.containerColor = containerColor;
        this.contentColor = disabledContainerColor;
        this.disabledContainerColor = checkedContainerColor;
        this.disabledContentColor = obj7;
        this.checkedContainerColor = obj9;
        this.checkedContentColor = obj11;
    }

    public IconToggleButtonColors(long l, long l2, long l3, long l4, long l5, long l6, DefaultConstructorMarker defaultConstructorMarker7) {
        super(l, l2, l3, l4, l5, l6, defaultConstructorMarker7, obj8, obj9, obj10, obj11, obj12);
    }

    public static androidx.compose.material3.IconToggleButtonColors copy-tNS2XkQ$default(androidx.compose.material3.IconToggleButtonColors iconToggleButtonColors, long l2, long l3, long l4, long l5, long l6, long l7, int i8, Object object9) {
        long l11;
        long l9;
        long l8;
        long l10;
        long l12;
        long l;
        long obj14;
        l11 = obj26 & 1 != 0 ? obj14 : l2;
        l9 = obj26 & 2 != 0 ? obj14 : l4;
        l8 = obj26 & 4 != 0 ? obj14 : l6;
        l10 = obj26 & 8 != 0 ? obj14 : i8;
        l12 = obj26 & 16 != 0 ? obj14 : obj22;
        l = obj26 & 32 != 0 ? obj14 : obj24;
        return iconToggleButtonColors.copy-tNS2XkQ(l11, obj2, l9, obj4, l8, obj6);
    }

    public final State<Color> containerColor$material3_release(boolean enabled, boolean checked, Composer $composer, int $changed) {
        long disabledContainerColor;
        boolean traceInProgress;
        String str;
        int i = 1175394478;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(containerColor)P(1)1246@57659L28:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.IconToggleButtonColors.containerColor (IconButton.kt:1239)");
        }
        disabledContainerColor = !enabled ? this.disabledContainerColor : !checked ? this.containerColor : this.checkedContainerColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(disabledContainerColor), $composer, 0);
    }

    public final State<Color> contentColor$material3_release(boolean enabled, boolean checked, Composer $composer, int $changed) {
        long disabledContentColor;
        boolean traceInProgress;
        String str;
        int i = 1340854054;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(contentColor)P(1)1263@58229L28:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.IconToggleButtonColors.contentColor (IconButton.kt:1256)");
        }
        disabledContentColor = !enabled ? this.disabledContentColor : !checked ? this.contentColor : this.checkedContentColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(disabledContentColor), $composer, 0);
    }

    public final androidx.compose.material3.IconToggleButtonColors copy-tNS2XkQ(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, long checkedContainerColor, long checkedContentColor) {
        int $this$isSpecified$iv$iv4;
        int $this$isSpecified$iv$iv2;
        int $this$isSpecified$iv$iv;
        int $this$isSpecified$iv$iv5;
        int $this$isSpecified$iv$iv3;
        int checkedContentColor2;
        int i;
        long l2;
        long l3;
        long l;
        long i2;
        long i4;
        long i3;
        final Object obj = this;
        int i5 = containerColor;
        int i6 = 0;
        int i23 = 0;
        int i29 = 16;
        i = 1;
        final int i30 = 0;
        $this$isSpecified$iv$iv4 = Long.compare(i12, i29) != 0 ? i : i30;
        if ($this$isSpecified$iv$iv4 != 0) {
            l2 = i5;
        } else {
            int i22 = 0;
            l2 = $this$isSpecified$iv$iv4;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv = disabledContainerColor;
        int i7 = 0;
        int i24 = 0;
        $this$isSpecified$iv$iv2 = Long.compare(i13, i29) != 0 ? i : i30;
        if ($this$isSpecified$iv$iv2 != 0) {
            l3 = $this$takeOrElse_u2dDxMtmZc$iv;
        } else {
            int i21 = 0;
            l3 = $this$isSpecified$iv$iv2;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv2 = checkedContainerColor;
        int i8 = 0;
        int i25 = 0;
        $this$isSpecified$iv$iv = Long.compare(i14, i29) != 0 ? i : i30;
        if ($this$isSpecified$iv$iv != 0) {
            l = $this$takeOrElse_u2dDxMtmZc$iv2;
        } else {
            int i20 = 0;
            l = $this$isSpecified$iv$iv;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv3 = obj33;
        int i9 = 0;
        int i26 = 0;
        $this$isSpecified$iv$iv5 = Long.compare(i15, i29) != 0 ? i : i30;
        if ($this$isSpecified$iv$iv5 != 0) {
            i2 = $this$takeOrElse_u2dDxMtmZc$iv3;
        } else {
            int i19 = 0;
            i2 = $this$isSpecified$iv$iv5;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv4 = obj35;
        int i10 = 0;
        int i27 = 0;
        $this$isSpecified$iv$iv3 = Long.compare(i16, i29) != 0 ? i : i30;
        if ($this$isSpecified$iv$iv3 != 0) {
            i4 = $this$takeOrElse_u2dDxMtmZc$iv4;
        } else {
            int i18 = 0;
            i4 = $this$isSpecified$iv$iv3;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv5 = obj37;
        int i11 = 0;
        int i28 = 0;
        if (Long.compare(checkedContentColor2, i29) != 0) {
        } else {
            i = i30;
        }
        if (i != 0) {
            i3 = $this$takeOrElse_u2dDxMtmZc$iv5;
        } else {
            int i17 = 0;
            i3 = checkedContentColor2;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(l2, obj14, l3, obj16, l, obj18, i2, obj20, i4, obj22, i3, obj24, 0);
        return iconToggleButtonColors;
    }

    public boolean equals(Object other) {
        boolean z;
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other != null) {
            if (!other instanceof IconToggleButtonColors) {
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
                if (!Color.equals-impl0(this.checkedContainerColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.checkedContentColor, obj3)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public final long getCheckedContainerColor-0d7_KjU() {
        return this.checkedContainerColor;
    }

    public final long getCheckedContentColor-0d7_KjU() {
        return this.checkedContentColor;
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
        return result4 += i12;
    }
}
