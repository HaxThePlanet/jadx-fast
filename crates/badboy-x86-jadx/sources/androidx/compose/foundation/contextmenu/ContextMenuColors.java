package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0001\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\u0008J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\nR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\u000c\u0010\nR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\r\u0010\nR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\u000e\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\u000f\u0010\n\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0017", d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "textColor", "iconColor", "disabledTextColor", "disabledIconColor", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackgroundColor-0d7_KjU", "()J", "J", "getDisabledIconColor-0d7_KjU", "getDisabledTextColor-0d7_KjU", "getIconColor-0d7_KjU", "getTextColor-0d7_KjU", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContextMenuColors {

    public static final int $stable;
    private final long backgroundColor;
    private final long disabledIconColor;
    private final long disabledTextColor;
    private final long iconColor;
    private final long textColor;
    static {
    }

    private ContextMenuColors(long backgroundColor, long textColor, long iconColor, long disabledTextColor, long disabledIconColor) {
        super();
        this.backgroundColor = backgroundColor;
        this.textColor = iconColor;
        this.iconColor = disabledIconColor;
        this.disabledTextColor = obj7;
        this.disabledIconColor = obj9;
    }

    public ContextMenuColors(long l, long l2, long l3, long l4, long l5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(l, l2, l3, l4, l5, defaultConstructorMarker6, obj7, obj8, obj9, obj10);
    }

    public boolean equals(Object other) {
        boolean z;
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other != null) {
            if (!other instanceof ContextMenuColors) {
            } else {
                if (!Color.equals-impl0(this.backgroundColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.textColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.iconColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledTextColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledIconColor, obj3)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public final long getBackgroundColor-0d7_KjU() {
        return this.backgroundColor;
    }

    public final long getDisabledIconColor-0d7_KjU() {
        return this.disabledIconColor;
    }

    public final long getDisabledTextColor-0d7_KjU() {
        return this.disabledTextColor;
    }

    public final long getIconColor-0d7_KjU() {
        return this.iconColor;
    }

    public final long getTextColor-0d7_KjU() {
        return this.textColor;
    }

    public int hashCode() {
        return result2 += i10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ContextMenuColors(backgroundColor=").append(Color.toString-impl(this.backgroundColor)).append(", textColor=").append(Color.toString-impl(this.textColor)).append(", iconColor=").append(Color.toString-impl(this.iconColor)).append(", disabledTextColor=").append(Color.toString-impl(this.disabledTextColor)).append(", disabledIconColor=").append(Color.toString-impl(this.disabledIconColor)).append(')').toString();
    }
}
