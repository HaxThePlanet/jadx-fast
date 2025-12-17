package androidx.compose.foundation.text.modifiers;

import androidx.collection.LongObjectMap;
import androidx.compose.foundation.text.TextPointerIcon_androidKt;
import androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate;
import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.Selection.AnchorInfo;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.ClipOp.Companion;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0008\u0010\u0016\u001a\u00020\u0013H\u0016J\u0008\u0010\u0017\u001a\u00020\u0013H\u0016J\u0008\u0010\u0018\u001a\u00020\u0013H\u0016J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eR\u0016\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001f", d2 = {"Landroidx/compose/foundation/text/modifiers/SelectionController;", "Landroidx/compose/runtime/RememberObserver;", "selectableId", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "backgroundSelectionColor", "Landroidx/compose/ui/graphics/Color;", "params", "Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;", "(JLandroidx/compose/foundation/text/selection/SelectionRegistrar;JLandroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "selectable", "Landroidx/compose/foundation/text/selection/Selectable;", "draw", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "onAbandoned", "onForgotten", "onRemembered", "updateGlobalPosition", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "updateTextLayout", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectionController implements RememberObserver {

    public static final int $stable = 8;
    private final long backgroundSelectionColor;
    private final Modifier modifier;
    private androidx.compose.foundation.text.modifiers.StaticTextSelectionParams params;
    private Selectable selectable;
    private final long selectableId;
    private final SelectionRegistrar selectionRegistrar;
    static {
        final int i = 8;
    }

    private SelectionController(long selectableId, SelectionRegistrar selectionRegistrar, long backgroundSelectionColor, androidx.compose.foundation.text.modifiers.StaticTextSelectionParams params) {
        super();
        this.selectableId = selectableId;
        this.selectionRegistrar = backgroundSelectionColor;
        this.backgroundSelectionColor = params;
        this.params = obj11;
        SelectionController.modifier.1 anon = new SelectionController.modifier.1(this);
        this.modifier = PointerIconKt.pointerHoverIcon$default(SelectionControllerKt.access$makeSelectionModifier(this.selectionRegistrar, this.selectableId, obj2), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, 0);
    }

    public SelectionController(long l, SelectionRegistrar selectionRegistrar2, long l3, androidx.compose.foundation.text.modifiers.StaticTextSelectionParams staticTextSelectionParams4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        androidx.compose.foundation.text.modifiers.StaticTextSelectionParams staticTextSelectionParams;
        androidx.compose.foundation.text.modifiers.StaticTextSelectionParams obj14;
        if (obj15 & 8 != 0) {
            staticTextSelectionParams = obj14;
        } else {
            staticTextSelectionParams = defaultConstructorMarker6;
        }
        super(l, obj2, l3, staticTextSelectionParams4, obj5, staticTextSelectionParams, 0);
    }

    public SelectionController(long l, SelectionRegistrar selectionRegistrar2, long l3, androidx.compose.foundation.text.modifiers.StaticTextSelectionParams staticTextSelectionParams4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(l, selectionRegistrar2, l3, staticTextSelectionParams4, defaultConstructorMarker5, obj6);
    }

    public static final androidx.compose.foundation.text.modifiers.StaticTextSelectionParams access$getParams$p(androidx.compose.foundation.text.modifiers.SelectionController $this) {
        return $this.params;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void draw(DrawScope drawScope) {
        int offset;
        int offset2;
        int lastVisibleOffset;
        boolean shouldClip;
        Object size-NH-jbRc;
        long obj3;
        long $this$withTransform_u24lambda_u246$iv$iv;
        long l4;
        int $this$withTransform_u24lambda_u246$iv$iv4;
        int $this$withTransform_u24lambda_u246$iv$iv3;
        long bottom$iv;
        int i4;
        int $this$withTransform_u24lambda_u246$iv$iv2;
        int i;
        int i2;
        Object obj5;
        int i6;
        Object obj6;
        int i5;
        int i3;
        Object selection;
        int i7;
        long l;
        long l6;
        float f;
        long l3;
        long l2;
        DrawContext context;
        long l5;
        final Object obj2 = this;
        Object obj = obj2.selectionRegistrar.getSubselections().get(obj2.selectableId);
        if ((Selection)obj == null) {
        }
        size-NH-jbRc = obj;
        if (!size-NH-jbRc.getHandlesCrossed()) {
            offset = size-NH-jbRc.getStart().getOffset();
        } else {
            offset = size-NH-jbRc.getEnd().getOffset();
        }
        final int i10 = offset;
        if (!size-NH-jbRc.getHandlesCrossed()) {
            offset2 = size-NH-jbRc.getEnd().getOffset();
        } else {
            offset2 = size-NH-jbRc.getStart().getOffset();
        }
        final int i11 = offset2;
        if (i10 == i11) {
        }
        Selectable selectable = obj2.selectable;
        if (selectable != null) {
            lastVisibleOffset = selectable.getLastVisibleOffset();
        } else {
            lastVisibleOffset = 0;
        }
        final int i12 = lastVisibleOffset;
        androidx.compose.ui.graphics.Path pathForRange = obj2.params.getPathForRange(RangesKt.coerceAtMost(i10, i12), RangesKt.coerceAtMost(i11, i12));
        if (pathForRange == null) {
        }
        final androidx.compose.ui.graphics.Path path = pathForRange;
        final Object obj4 = drawScope;
        final int i14 = 0;
        if (obj2.params.getShouldClip()) {
            obj5 = obj4;
            l4 = 0;
            int i13 = 0;
            float width-impl = Size.getWidth-impl(obj5.getSize-NH-jbRc());
            float height-impl = Size.getHeight-impl(obj5.getSize-NH-jbRc());
            int intersect-rtfAjoo = ClipOp.Companion.getIntersect-rtfAjoo();
            i6 = 0;
            obj6 = obj5;
            i5 = 0;
            DrawContext drawContext = obj6.getDrawContext();
            i3 = 0;
            selection = size-NH-jbRc;
            i7 = i10;
            drawContext.getCanvas().save();
            int i8 = 0;
            drawContext.getTransform().clipRect-N_I0leg(l4, i13, width-impl, height-impl, intersect-rtfAjoo);
            l = l4;
            l6 = i13;
            f = width-impl;
            l3 = height-impl;
            l2 = intersect-rtfAjoo;
            int i9 = 0;
            l5 = context;
            DrawScope.drawPath-LG529CI$default(obj6, path, obj2.backgroundSelectionColor, l4, 0, 0, 0, 0, 60);
            l5.getCanvas().restore();
            l5.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
            obj3 = obj4;
        } else {
            selection = size-NH-jbRc;
            i7 = i10;
            DrawScope.drawPath-LG529CI$default(obj4, path, obj2.backgroundSelectionColor, obj11, 0, 0, 0, 0, 60);
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        int i;
        final Selectable selectable = this.selectable;
        if (selectable != null) {
            this.selectionRegistrar.unsubscribe(selectable);
            this.selectable = 0;
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        int i;
        final Selectable selectable = this.selectable;
        if (selectable != null) {
            this.selectionRegistrar.unsubscribe(selectable);
            this.selectable = 0;
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        SelectionController.onRemembered.1 anon = new SelectionController.onRemembered.1(this);
        SelectionController.onRemembered.2 anon2 = new SelectionController.onRemembered.2(this);
        MultiWidgetSelectionDelegate multiWidgetSelectionDelegate = new MultiWidgetSelectionDelegate(this.selectableId, obj3, (Function0)anon, (Function0)anon2);
        this.selectable = this.selectionRegistrar.subscribe((Selectable)multiWidgetSelectionDelegate);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void updateGlobalPosition(LayoutCoordinates coordinates) {
        int i = 0;
        final int i2 = 2;
        this.params = StaticTextSelectionParams.copy$default(this.params, coordinates, i, i2, i);
        this.selectionRegistrar.notifyPositionChange(this.selectableId);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void updateTextLayout(TextLayoutResult textLayoutResult) {
        boolean selectionRegistrar;
        androidx.compose.ui.text.AnnotatedString selectableId;
        TextLayoutResult textLayoutResult2 = this.params.getTextLayoutResult();
        if (textLayoutResult2 != null && !Intrinsics.areEqual(textLayoutResult2.getLayoutInput().getText(), textLayoutResult.getLayoutInput().getText())) {
            if (!Intrinsics.areEqual(textLayoutResult2.getLayoutInput().getText(), textLayoutResult.getLayoutInput().getText())) {
                this.selectionRegistrar.notifySelectableChange(this.selectableId);
            }
        }
        final int i2 = 0;
        this.params = StaticTextSelectionParams.copy$default(this.params, i2, textLayoutResult, 1, i2);
    }
}
