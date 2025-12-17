package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0017\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u001f\u0008\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\u000c\u0010\nR\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000f\u0010\u0010\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0016", d2 = {"Landroidx/compose/material3/SearchBarColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "dividerColor", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "inputFieldColors", "Landroidx/compose/material3/TextFieldColors;", "(JJLandroidx/compose/material3/TextFieldColors;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getDividerColor-0d7_KjU", "getInputFieldColors$annotations", "()V", "getInputFieldColors", "()Landroidx/compose/material3/TextFieldColors;", "equals", "", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SearchBarColors {

    public static final int $stable;
    private final long containerColor;
    private final long dividerColor;
    private final androidx.compose.material3.TextFieldColors inputFieldColors;
    static {
    }

    private SearchBarColors(long containerColor, long dividerColor) {
        super(containerColor, obj2, obj10, obj4, SearchBar_androidKt.access$getUnspecifiedTextFieldColors$p(), 0);
    }

    private SearchBarColors(long containerColor, long dividerColor, androidx.compose.material3.TextFieldColors inputFieldColors) {
        super();
        this.containerColor = containerColor;
        this.dividerColor = inputFieldColors;
        this.inputFieldColors = obj5;
    }

    @Deprecated(message = "Search bars now take the input field as a parameter. TextFieldColors should be passed explicitly to the input field. The `inputFieldColors` parameter will be removed in a future version of the library.")
    public SearchBarColors(long l, long l2, androidx.compose.material3.TextFieldColors textFieldColors3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(l, l2, textFieldColors3, defaultConstructorMarker4, obj5);
    }

    public SearchBarColors(long l, long l2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(l, l2, defaultConstructorMarker3, obj4);
    }

    @Deprecated(message = "Search bars now take the input field as a parameter. TextFieldColors should be passed explicitly to the input field. The `inputFieldColors` property will be removed in a future version of the library.")
    public static void getInputFieldColors$annotations() {
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof SearchBarColors) {
            return i2;
        }
        if (!Color.equals-impl0(this.containerColor, obj4)) {
            return i2;
        }
        if (!Color.equals-impl0(this.dividerColor, obj4)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.inputFieldColors, obj3.inputFieldColors)) {
            return i2;
        }
        return i;
    }

    public final long getContainerColor-0d7_KjU() {
        return this.containerColor;
    }

    public final long getDividerColor-0d7_KjU() {
        return this.dividerColor;
    }

    public final androidx.compose.material3.TextFieldColors getInputFieldColors() {
        return this.inputFieldColors;
    }

    public int hashCode() {
        return result += i6;
    }
}
