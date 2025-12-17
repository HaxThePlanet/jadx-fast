package androidx.compose.foundation.text.selection;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\r\u001a\u00020\u000eH\u0016J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\t\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0011", d2 = {"Landroidx/compose/foundation/text/selection/TextSelectionColors;", "", "handleColor", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackgroundColor-0d7_KjU", "()J", "J", "getHandleColor-0d7_KjU", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextSelectionColors {

    public static final int $stable;
    private final long backgroundColor;
    private final long handleColor;
    static {
    }

    private TextSelectionColors(long handleColor, long backgroundColor) {
        super();
        this.handleColor = handleColor;
        this.backgroundColor = obj3;
    }

    public TextSelectionColors(long l, long l2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(l, l2, defaultConstructorMarker3, obj4);
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof TextSelectionColors) {
            return i2;
        }
        if (!Color.equals-impl0(this.handleColor, obj4)) {
            return i2;
        }
        if (!Color.equals-impl0(this.backgroundColor, obj4)) {
            return i2;
        }
        return i;
    }

    public final long getBackgroundColor-0d7_KjU() {
        return this.backgroundColor;
    }

    public final long getHandleColor-0d7_KjU() {
        return this.handleColor;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SelectionColors(selectionHandleColor=").append(Color.toString-impl(this.handleColor)).append(", selectionBackgroundColor=").append(Color.toString-impl(this.backgroundColor)).append(')').toString();
    }
}
