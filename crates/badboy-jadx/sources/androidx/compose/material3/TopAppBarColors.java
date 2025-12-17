package androidx.compose.material3;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\u0008J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013JB\u0010\u0014\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016R\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\nR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\u000c\u0010\nR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\r\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\u000e\u0010\nR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\u000f\u0010\n\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001c", d2 = {"Landroidx/compose/material3/TopAppBarColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "scrolledContainerColor", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActionIconContentColor-0d7_KjU", "()J", "J", "getContainerColor-0d7_KjU", "getNavigationIconContentColor-0d7_KjU", "getScrolledContainerColor-0d7_KjU", "getTitleContentColor-0d7_KjU", "colorTransitionFraction", "", "containerColor-vNxB06k$material3_release", "(F)J", "copy", "copy-t635Npw", "(JJJJJ)Landroidx/compose/material3/TopAppBarColors;", "equals", "", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TopAppBarColors {

    public static final int $stable;
    private final long actionIconContentColor;
    private final long containerColor;
    private final long navigationIconContentColor;
    private final long scrolledContainerColor;
    private final long titleContentColor;
    static {
    }

    private TopAppBarColors(long containerColor, long scrolledContainerColor, long navigationIconContentColor, long titleContentColor, long actionIconContentColor) {
        super();
        this.containerColor = containerColor;
        this.scrolledContainerColor = navigationIconContentColor;
        this.navigationIconContentColor = actionIconContentColor;
        this.titleContentColor = obj7;
        this.actionIconContentColor = obj9;
    }

    public TopAppBarColors(long l, long l2, long l3, long l4, long l5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(l, l2, l3, l4, l5, defaultConstructorMarker6, obj7, obj8, obj9, obj10);
    }

    public static androidx.compose.material3.TopAppBarColors copy-t635Npw$default(androidx.compose.material3.TopAppBarColors topAppBarColors, long l2, long l3, long l4, long l5, long l6, int i7, Object object8) {
        long l9;
        long l10;
        long l7;
        long l;
        long l8;
        long obj12;
        long obj14;
        l9 = obj22 & 1 != 0 ? obj12 : l2;
        l10 = obj22 & 2 != 0 ? obj14 : l4;
        l7 = obj22 & 4 != 0 ? obj12 : l6;
        l = obj22 & 8 != 0 ? obj12 : object8;
        l8 = obj22 & 16 != 0 ? obj12 : obj20;
        return topAppBarColors.copy-t635Npw(l9, obj2, l10, obj4, l7);
    }

    public final long containerColor-vNxB06k$material3_release(float colorTransitionFraction) {
        return ColorKt.lerp-jxsXWHM(this.containerColor, obj1, this.scrolledContainerColor);
    }

    public final androidx.compose.material3.TopAppBarColors copy-t635Npw(long containerColor, long scrolledContainerColor, long navigationIconContentColor, long titleContentColor, long actionIconContentColor) {
        int $i$a$TakeOrElseDxMtmZcTopAppBarColors$copy$1;
        int $i$a$TakeOrElseDxMtmZcTopAppBarColors$copy$2;
        int $i$a$TakeOrElseDxMtmZcTopAppBarColors$copy$3;
        int $i$a$TakeOrElseDxMtmZcTopAppBarColors$copy$4;
        int $i$a$TakeOrElseDxMtmZcTopAppBarColors$copy$5;
        int i;
        long l3;
        long l;
        long l2;
        long i3;
        long i2;
        final Object obj = this;
        int i4 = containerColor;
        int i5 = 0;
        int i19 = 0;
        int i24 = 16;
        i = 1;
        final int i25 = 0;
        $i$a$TakeOrElseDxMtmZcTopAppBarColors$copy$1 = Long.compare(i10, i24) != 0 ? i : i25;
        if ($i$a$TakeOrElseDxMtmZcTopAppBarColors$copy$1 != 0) {
            l3 = i4;
        } else {
            int i18 = 0;
            l3 = $i$a$TakeOrElseDxMtmZcTopAppBarColors$copy$1;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv = navigationIconContentColor;
        int i6 = 0;
        int i20 = 0;
        $i$a$TakeOrElseDxMtmZcTopAppBarColors$copy$2 = Long.compare(i11, i24) != 0 ? i : i25;
        if ($i$a$TakeOrElseDxMtmZcTopAppBarColors$copy$2 != 0) {
            l = $this$takeOrElse_u2dDxMtmZc$iv;
        } else {
            int i17 = 0;
            l = $i$a$TakeOrElseDxMtmZcTopAppBarColors$copy$2;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv2 = actionIconContentColor;
        int i7 = 0;
        int i21 = 0;
        $i$a$TakeOrElseDxMtmZcTopAppBarColors$copy$3 = Long.compare(i12, i24) != 0 ? i : i25;
        if ($i$a$TakeOrElseDxMtmZcTopAppBarColors$copy$3 != 0) {
            l2 = $this$takeOrElse_u2dDxMtmZc$iv2;
        } else {
            int i16 = 0;
            l2 = $i$a$TakeOrElseDxMtmZcTopAppBarColors$copy$3;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv3 = obj31;
        int i8 = 0;
        int i22 = 0;
        $i$a$TakeOrElseDxMtmZcTopAppBarColors$copy$4 = Long.compare(i13, i24) != 0 ? i : i25;
        if ($i$a$TakeOrElseDxMtmZcTopAppBarColors$copy$4 != 0) {
            i3 = $this$takeOrElse_u2dDxMtmZc$iv3;
        } else {
            int i15 = 0;
            i3 = $i$a$TakeOrElseDxMtmZcTopAppBarColors$copy$4;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv4 = obj33;
        int i9 = 0;
        int i23 = 0;
        if (Long.compare($i$a$TakeOrElseDxMtmZcTopAppBarColors$copy$5, i24) != 0) {
        } else {
            i = i25;
        }
        if (i != 0) {
            i2 = $this$takeOrElse_u2dDxMtmZc$iv4;
        } else {
            int i14 = 0;
            i2 = $i$a$TakeOrElseDxMtmZcTopAppBarColors$copy$5;
        }
        TopAppBarColors topAppBarColors = new TopAppBarColors(l3, obj14, l, obj16, l2, obj18, i3, obj20, i2, obj22, 0);
        return topAppBarColors;
    }

    public boolean equals(Object other) {
        boolean z;
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other != null) {
            if (!other instanceof TopAppBarColors) {
            } else {
                if (!Color.equals-impl0(this.containerColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.scrolledContainerColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.navigationIconContentColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.titleContentColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.actionIconContentColor, obj3)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public final long getActionIconContentColor-0d7_KjU() {
        return this.actionIconContentColor;
    }

    public final long getContainerColor-0d7_KjU() {
        return this.containerColor;
    }

    public final long getNavigationIconContentColor-0d7_KjU() {
        return this.navigationIconContentColor;
    }

    public final long getScrolledContainerColor-0d7_KjU() {
        return this.scrolledContainerColor;
    }

    public final long getTitleContentColor-0d7_KjU() {
        return this.titleContentColor;
    }

    public int hashCode() {
        return result2 += i10;
    }
}
