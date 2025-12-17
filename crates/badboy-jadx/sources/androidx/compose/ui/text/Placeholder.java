package androidx.compose.ui.text;

import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J.\u0010\u000f\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u0008\u0010\tR\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\u0008\u000b\u0010\u000cR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u000e\u0010\t\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0019", d2 = {"Landroidx/compose/ui/text/Placeholder;", "", "width", "Landroidx/compose/ui/unit/TextUnit;", "height", "placeholderVerticalAlign", "Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "(JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHeight-XSAIIZE", "()J", "J", "getPlaceholderVerticalAlign-J6kI3mc", "()I", "I", "getWidth-XSAIIZE", "copy", "copy-K8Q-__8", "(JJI)Landroidx/compose/ui/text/Placeholder;", "equals", "", "other", "hashCode", "", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Placeholder {

    public static final int $stable;
    private final long height;
    private final int placeholderVerticalAlign;
    private final long width;
    static {
    }

    private Placeholder(long width, long height, int placeholderVerticalAlign) {
        super();
        this.width = width;
        this.height = placeholderVerticalAlign;
        this.placeholderVerticalAlign = obj7;
        if (TextUnitKt.isUnspecified--R2X_6o(this.width)) {
        } else {
            if (TextUnitKt.isUnspecified--R2X_6o(this.height)) {
            } else {
            }
            int i = 0;
            IllegalArgumentException $i$a$RequirePlaceholder$2 = new IllegalArgumentException("height cannot be TextUnit.Unspecified".toString());
            throw $i$a$RequirePlaceholder$2;
        }
        int i2 = 0;
        IllegalArgumentException $i$a$RequirePlaceholder$1 = new IllegalArgumentException("width cannot be TextUnit.Unspecified".toString());
        throw $i$a$RequirePlaceholder$1;
    }

    public Placeholder(long l, long l2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(l, l2, i3, defaultConstructorMarker4, obj5);
    }

    public static androidx.compose.ui.text.Placeholder copy-K8Q-__8$default(androidx.compose.ui.text.Placeholder placeholder, long l2, long l3, int i4, int i5, Object object6) {
        long l;
        long l4;
        int i;
        long obj7;
        long obj9;
        int obj11;
        l = obj12 & 1 != 0 ? obj7 : l2;
        l4 = obj12 & 2 != 0 ? obj9 : i4;
        i = obj12 & 4 != 0 ? obj11 : object6;
        return placeholder.copy-K8Q-__8(l, obj2, l4);
    }

    public final androidx.compose.ui.text.Placeholder copy-K8Q-__8(long width, long height, int placeholderVerticalAlign) {
        Placeholder placeholder = new Placeholder(width, obj2, placeholderVerticalAlign, obj4, obj12, 0);
        return placeholder;
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof Placeholder) {
            return i2;
        }
        if (!TextUnit.equals-impl0(this.width, obj4)) {
            return i2;
        }
        if (!TextUnit.equals-impl0(this.height, obj4)) {
            return i2;
        }
        if (!PlaceholderVerticalAlign.equals-impl0(this.placeholderVerticalAlign, obj3.placeholderVerticalAlign)) {
            return i2;
        }
        return i;
    }

    public final long getHeight-XSAIIZE() {
        return this.height;
    }

    public final int getPlaceholderVerticalAlign-J6kI3mc() {
        return this.placeholderVerticalAlign;
    }

    public final long getWidth-XSAIIZE() {
        return this.width;
    }

    public int hashCode() {
        return result += i6;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Placeholder(width=").append(TextUnit.toString-impl(this.width)).append(", height=").append(TextUnit.toString-impl(this.height)).append(", placeholderVerticalAlign=").append(PlaceholderVerticalAlign.toString-impl(this.placeholderVerticalAlign)).append(')').toString();
    }
}
