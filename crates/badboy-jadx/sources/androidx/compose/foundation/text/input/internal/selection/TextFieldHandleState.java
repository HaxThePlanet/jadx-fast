package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0080\u0008\u0018\u0000  2\u00020\u0001:\u0001 B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\u0013\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u000fJ\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00032\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\r\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006!", d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "", "visible", "", "position", "Landroidx/compose/ui/geometry/Offset;", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "handlesCrossed", "(ZJLandroidx/compose/ui/text/style/ResolvedTextDirection;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDirection", "()Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getHandlesCrossed", "()Z", "getPosition-F1C5BW0", "()J", "J", "getVisible", "component1", "component2", "component2-F1C5BW0", "component3", "component4", "copy", "copy-ubNVwUQ", "(ZJLandroidx/compose/ui/text/style/ResolvedTextDirection;Z)Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "equals", "other", "hashCode", "", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldHandleState {

    public static final int $stable;
    public static final androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState.Companion Companion;
    private static final androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState Hidden;
    private final ResolvedTextDirection direction;
    private final boolean handlesCrossed;
    private final long position;
    private final boolean visible;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState$Companion;", "", "()V", "Hidden", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "getHidden", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState getHidden() {
            return TextFieldHandleState.access$getHidden$cp();
        }
    }
    static {
        TextFieldHandleState.Companion companion = new TextFieldHandleState.Companion(0);
        TextFieldHandleState.Companion = companion;
        TextFieldHandleState textFieldHandleState = new TextFieldHandleState(0, Offset.Companion.getUnspecified-F1C5BW0(), obj5, ResolvedTextDirection.Ltr, 0, 0);
        TextFieldHandleState.Hidden = textFieldHandleState;
    }

    private TextFieldHandleState(boolean visible, long position, ResolvedTextDirection direction, boolean handlesCrossed) {
        super();
        this.visible = visible;
        this.position = position;
        this.direction = handlesCrossed;
        this.handlesCrossed = obj5;
    }

    public TextFieldHandleState(boolean z, long l2, ResolvedTextDirection resolvedTextDirection3, boolean z4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(z, l2, resolvedTextDirection3, z4, defaultConstructorMarker5);
    }

    public static final androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState access$getHidden$cp() {
        return TextFieldHandleState.Hidden;
    }

    public static androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState copy-ubNVwUQ$default(androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState textFieldHandleState, boolean z2, long l3, ResolvedTextDirection resolvedTextDirection4, boolean z5, int i6, Object object7) {
        boolean obj1;
        long obj2;
        ResolvedTextDirection obj4;
        boolean obj5;
        if (object7 & 1 != 0) {
            obj1 = textFieldHandleState.visible;
        }
        if (object7 & 2 != 0) {
            obj2 = textFieldHandleState.position;
        }
        if (object7 & 4 != 0) {
            obj4 = textFieldHandleState.direction;
        }
        if (object7 &= 8 != 0) {
            obj5 = textFieldHandleState.handlesCrossed;
        }
        return textFieldHandleState.copy-ubNVwUQ(obj1, obj2, obj5, obj4);
    }

    public final boolean component1() {
        return this.visible;
    }

    public final long component2-F1C5BW0() {
        return this.position;
    }

    public final ResolvedTextDirection component3() {
        return this.direction;
    }

    public final boolean component4() {
        return this.handlesCrossed;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState copy-ubNVwUQ(boolean z, long l2, ResolvedTextDirection resolvedTextDirection3, boolean z4) {
        TextFieldHandleState textFieldHandleState = new TextFieldHandleState(z, l2, obj3, z4, obj12, 0);
        return textFieldHandleState;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof TextFieldHandleState) {
            return i2;
        }
        Object obj = object;
        boolean visible2 = obj.visible;
        if (this.visible != visible2) {
            return i2;
        }
        if (!Offset.equals-impl0(this.position, visible2)) {
            return i2;
        }
        if (this.direction != obj.direction) {
            return i2;
        }
        if (this.handlesCrossed != obj.handlesCrossed) {
            return i2;
        }
        return i;
    }

    public final ResolvedTextDirection getDirection() {
        return this.direction;
    }

    public final boolean getHandlesCrossed() {
        return this.handlesCrossed;
    }

    public final long getPosition-F1C5BW0() {
        return this.position;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        return i6 += i10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TextFieldHandleState(visible=").append(this.visible).append(", position=").append(Offset.toString-impl(this.position)).append(", direction=").append(this.direction).append(", handlesCrossed=").append(this.handlesCrossed).append(')').toString();
    }
}
