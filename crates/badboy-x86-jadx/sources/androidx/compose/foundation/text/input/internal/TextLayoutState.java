package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect.Companion;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u00101\u001a\u0002022\u0006\u00103\u001a\u000202H\u0000ø\u0001\u0000¢\u0006\u0004\u00084\u00105J\"\u00106\u001a\u0002072\u0006\u00108\u001a\u0002022\u0008\u0008\u0002\u00109\u001a\u00020:ø\u0001\u0000¢\u0006\u0004\u0008;\u0010<J\u0018\u0010=\u001a\u00020:2\u0006\u00103\u001a\u000202ø\u0001\u0000¢\u0006\u0004\u0008>\u0010?J0\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020Gø\u0001\u0000¢\u0006\u0004\u0008H\u0010IJ&\u0010J\u001a\u00020'2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020:2\u0006\u0010P\u001a\u00020:R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R/\u0010\t\u001a\u0004\u0018\u00010\u00082\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR/\u0010\u0010\u001a\u0004\u0018\u00010\u00082\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0013\u0010\u000f\u001a\u0004\u0008\u0011\u0010\u000b\"\u0004\u0008\u0012\u0010\rR\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u001a\u0010\u001b\u001a\u0004\u0008\u0018\u0010\u0019R1\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u001c8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008\"\u0010\u000f\u001a\u0004\u0008\u001e\u0010\u001f\"\u0004\u0008 \u0010!R;\u0010#\u001a#\u0012\u0004\u0012\u00020%\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170&\u0012\u0004\u0012\u00020'\u0018\u00010$¢\u0006\u0002\u0008(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008)\u0010*\"\u0004\u0008+\u0010,R/\u0010-\u001a\u0004\u0018\u00010\u00082\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u00080\u0010\u000f\u001a\u0004\u0008.\u0010\u000b\"\u0004\u0008/\u0010\r\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006Q", d2 = {"Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "", "()V", "bringIntoViewRequester", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "getBringIntoViewRequester", "()Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "coreNodeCoordinates", "getCoreNodeCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setCoreNodeCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "coreNodeCoordinates$delegate", "Landroidx/compose/runtime/MutableState;", "decoratorNodeCoordinates", "getDecoratorNodeCoordinates", "setDecoratorNodeCoordinates", "decoratorNodeCoordinates$delegate", "layoutCache", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "layoutResult$delegate", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache;", "Landroidx/compose/ui/unit/Dp;", "minHeightForSingleLineField", "getMinHeightForSingleLineField-D9Ej5fM", "()F", "setMinHeightForSingleLineField-0680j_4", "(F)V", "minHeightForSingleLineField$delegate", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "", "Lkotlin/ExtensionFunctionType;", "getOnTextLayout", "()Lkotlin/jvm/functions/Function2;", "setOnTextLayout", "(Lkotlin/jvm/functions/Function2;)V", "textLayoutNodeCoordinates", "getTextLayoutNodeCoordinates", "setTextLayoutNodeCoordinates", "textLayoutNodeCoordinates$delegate", "coercedInVisibleBoundsOfInputText", "Landroidx/compose/ui/geometry/Offset;", "offset", "coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation_release", "(J)J", "getOffsetForPosition", "", "position", "coerceInVisibleBounds", "", "getOffsetForPosition-3MmeM6k", "(JZ)I", "isPositionOnText", "isPositionOnText-k-4lQ0M", "(J)Z", "layoutWithNewMeasureInputs", "density", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutWithNewMeasureInputs--hBUhpc", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)Landroidx/compose/ui/text/TextLayoutResult;", "updateNonMeasureInputs", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "softWrap", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextLayoutState {

    public static final int $stable = 8;
    private final BringIntoViewRequester bringIntoViewRequester;
    private final MutableState coreNodeCoordinates$delegate;
    private final MutableState decoratorNodeCoordinates$delegate;
    private androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache layoutCache;
    private final androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache layoutResult$delegate;
    private final MutableState minHeightForSingleLineField$delegate;
    private Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> onTextLayout;
    private final MutableState textLayoutNodeCoordinates$delegate;
    static {
        final int i = 8;
    }

    public TextLayoutState() {
        super();
        TextFieldLayoutStateCache textFieldLayoutStateCache = new TextFieldLayoutStateCache();
        this.layoutCache = textFieldLayoutStateCache;
        this.layoutResult$delegate = this.layoutCache;
        final int i2 = 0;
        this.textLayoutNodeCoordinates$delegate = SnapshotStateKt.mutableStateOf(i2, SnapshotStateKt.neverEqualPolicy());
        this.coreNodeCoordinates$delegate = SnapshotStateKt.mutableStateOf(i2, SnapshotStateKt.neverEqualPolicy());
        this.decoratorNodeCoordinates$delegate = SnapshotStateKt.mutableStateOf(i2, SnapshotStateKt.neverEqualPolicy());
        int i3 = 0;
        this.minHeightForSingleLineField$delegate = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(Dp.constructor-impl((float)i)), i2, 2, i2);
        this.bringIntoViewRequester = BringIntoViewRequesterKt.BringIntoViewRequester();
    }

    public static final androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache access$getLayoutCache$p(androidx.compose.foundation.text.input.internal.TextLayoutState $this) {
        return $this.layoutCache;
    }

    public static int getOffsetForPosition-3MmeM6k$default(androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState, long l2, boolean z3, int i4, Object object5) {
        int obj3;
        if (object5 &= 2 != 0) {
            obj3 = 1;
        }
        return textLayoutState.getOffsetForPosition-3MmeM6k(l2, z3);
    }

    public final long coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation_release(long offset) {
        Object textLayoutNodeCoordinates;
        int i;
        LayoutCoordinates decoratorNodeCoordinates;
        Rect localBoundingBoxOf$default;
        int i2;
        int i3;
        textLayoutNodeCoordinates = getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates != null) {
            i = 0;
            if (textLayoutNodeCoordinates.isAttached()) {
                decoratorNodeCoordinates = getDecoratorNodeCoordinates();
                if (decoratorNodeCoordinates != null) {
                    localBoundingBoxOf$default = LayoutCoordinates.localBoundingBoxOf$default(decoratorNodeCoordinates, textLayoutNodeCoordinates, false, 2, 0);
                }
            } else {
                localBoundingBoxOf$default = Rect.Companion.getZero();
            }
            if (localBoundingBoxOf$default == 0) {
                localBoundingBoxOf$default = Rect.Companion.getZero();
            }
        } else {
        }
        return TextLayoutStateKt.coerceIn-3MmeM6k(offset, obj8);
    }

    public final BringIntoViewRequester getBringIntoViewRequester() {
        return this.bringIntoViewRequester;
    }

    public final LayoutCoordinates getCoreNodeCoordinates() {
        final int i = 0;
        final int i2 = 0;
        return (LayoutCoordinates)(State)this.coreNodeCoordinates$delegate.getValue();
    }

    public final LayoutCoordinates getDecoratorNodeCoordinates() {
        final int i = 0;
        final int i2 = 0;
        return (LayoutCoordinates)(State)this.decoratorNodeCoordinates$delegate.getValue();
    }

    public final TextLayoutResult getLayoutResult() {
        final int i = 0;
        final int i2 = 0;
        return (TextLayoutResult)(State)this.layoutResult$delegate.getValue();
    }

    public final float getMinHeightForSingleLineField-D9Ej5fM() {
        final int i = 0;
        final int i2 = 0;
        return (Dp)(State)this.minHeightForSingleLineField$delegate.getValue().unbox-impl();
    }

    public final int getOffsetForPosition-3MmeM6k(long position, boolean coerceInVisibleBounds) {
        long coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation_release;
        TextLayoutResult layoutResult = getLayoutResult();
        if (layoutResult == null) {
            return -1;
        }
        if (obj9 != null) {
            coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation_release = coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation_release(position);
        } else {
            coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation_release = position;
        }
        return layoutResult.getOffsetForPosition-k-4lQ0M(TextLayoutStateKt.fromDecorationToTextLayout-Uv8p0NA(this, coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation_release));
    }

    public final Function2<Density, Function0<TextLayoutResult>, Unit> getOnTextLayout() {
        return this.onTextLayout;
    }

    public final LayoutCoordinates getTextLayoutNodeCoordinates() {
        final int i = 0;
        final int i2 = 0;
        return (LayoutCoordinates)(State)this.textLayoutNodeCoordinates$delegate.getValue();
    }

    public final boolean isPositionOnText-k-4lQ0M(long offset) {
        int i;
        int cmp;
        float lineRight;
        final TextLayoutResult layoutResult = getLayoutResult();
        if (layoutResult == null) {
            return 0;
        }
        long decorationToTextLayout-Uv8p0NA = TextLayoutStateKt.fromDecorationToTextLayout-Uv8p0NA(this, coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation_release(offset));
        int lineForVerticalPosition = layoutResult.getLineForVerticalPosition(Offset.getY-impl(decorationToTextLayout-Uv8p0NA));
        if (Float.compare(x-impl, lineRight) >= 0 && Float.compare(x-impl2, lineRight) <= 0) {
            if (Float.compare(x-impl2, lineRight) <= 0) {
                i = 1;
            } else {
            }
        } else {
        }
        return i;
    }

    public final TextLayoutResult layoutWithNewMeasureInputs--hBUhpc(Density density, LayoutDirection layoutDirection, FontFamily.Resolver fontFamilyResolver, long constraints) {
        int obj9;
        androidx.compose.foundation.text.input.internal.TextLayoutState.layoutWithNewMeasureInputs.1.textLayoutProvider.1 obj10;
        final Density density2 = density;
        final Function2 obj8 = this.onTextLayout;
        if (obj8 != null) {
            obj9 = 0;
            obj10 = new TextLayoutState.layoutWithNewMeasureInputs.1.textLayoutProvider.1(this);
            obj8.invoke(density2, (Function0)obj10);
        }
        return this.layoutCache.layoutWithNewMeasureInputs--hBUhpc(density2, layoutDirection, fontFamilyResolver, constraints);
    }

    public final void setCoreNodeCoordinates(LayoutCoordinates <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.coreNodeCoordinates$delegate.setValue(<set-?>);
    }

    public final void setDecoratorNodeCoordinates(LayoutCoordinates <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.decoratorNodeCoordinates$delegate.setValue(<set-?>);
    }

    public final void setMinHeightForSingleLineField-0680j_4(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.minHeightForSingleLineField$delegate.setValue(Dp.box-impl(<set-?>));
    }

    public final void setOnTextLayout(Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> <set-?>) {
        this.onTextLayout = <set-?>;
    }

    public final void setTextLayoutNodeCoordinates(LayoutCoordinates <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.textLayoutNodeCoordinates$delegate.setValue(<set-?>);
    }

    public final void updateNonMeasureInputs(androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState, TextStyle textStyle, boolean singleLine, boolean softWrap) {
        this.layoutCache.updateNonMeasureInputs(textFieldState, textStyle, singleLine, softWrap);
    }
}
