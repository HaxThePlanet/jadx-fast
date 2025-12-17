package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composition;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000e\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0011\u0008\u0000\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u0019H\u0014J\u0012\u0010B\u001a\u00020\u00062\u0008\u0010C\u001a\u0004\u0018\u00010\u001bH\u0014J\u000c\u0010D\u001a\u00020E*\u00020FH\u0014R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000c\u0010\r\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u000f8@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001f\u001a\u0004\u0018\u00010\u001b2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001b8@@@X\u0080\u000e¢\u0006\u000c\u001a\u0004\u0008 \u0010!\"\u0004\u0008\"\u0010#R\u001a\u0010$\u001a\u00020%8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008&\u0010'R+\u0010(\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u001d8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008,\u0010-\u001a\u0004\u0008)\u0010\u0011\"\u0004\u0008*\u0010+R$\u0010/\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020.8@@@X\u0080\u000e¢\u0006\u000c\u001a\u0004\u00080\u00101\"\u0004\u00082\u00103R1\u00104\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020%8@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u00088\u0010\r\u001a\u0004\u00085\u0010'\"\u0004\u00086\u00107R\u0014\u00109\u001a\u00020:X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010<R*\u0010=\u001a\u00020%2\u0006\u0010\u001e\u001a\u00020%8@@@X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008>\u0010'\"\u0004\u0008?\u00107\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006G", d2 = {"Landroidx/compose/ui/graphics/vector/VectorPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "(Landroidx/compose/ui/graphics/vector/GroupComponent;)V", "<set-?>", "", "autoMirror", "getAutoMirror$ui_release", "()Z", "setAutoMirror$ui_release", "(Z)V", "autoMirror$delegate", "Landroidx/compose/runtime/MutableState;", "bitmapConfig", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getBitmapConfig-_sVssgQ$ui_release", "()I", "composition", "Landroidx/compose/runtime/Composition;", "getComposition$ui_release", "()Landroidx/compose/runtime/Composition;", "setComposition$ui_release", "(Landroidx/compose/runtime/Composition;)V", "currentAlpha", "", "currentColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "drawCount", "", "value", "intrinsicColorFilter", "getIntrinsicColorFilter$ui_release", "()Landroidx/compose/ui/graphics/ColorFilter;", "setIntrinsicColorFilter$ui_release", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "invalidateCount", "getInvalidateCount", "setInvalidateCount", "(I)V", "invalidateCount$delegate", "Landroidx/compose/runtime/MutableIntState;", "", "name", "getName$ui_release", "()Ljava/lang/String;", "setName$ui_release", "(Ljava/lang/String;)V", "size", "getSize-NH-jbRc$ui_release", "setSize-uvyYCjk$ui_release", "(J)V", "size$delegate", "vector", "Landroidx/compose/ui/graphics/vector/VectorComponent;", "getVector$ui_release", "()Landroidx/compose/ui/graphics/vector/VectorComponent;", "viewportSize", "getViewportSize-NH-jbRc$ui_release", "setViewportSize-uvyYCjk$ui_release", "applyAlpha", "alpha", "applyColorFilter", "colorFilter", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VectorPainter extends Painter {

    public static final int $stable = 8;
    private final MutableState autoMirror$delegate;
    private Composition composition;
    private float currentAlpha;
    private ColorFilter currentColorFilter;
    private int drawCount;
    private final MutableIntState invalidateCount$delegate;
    private final MutableState size$delegate;
    private final androidx.compose.ui.graphics.vector.VectorComponent vector;
    static {
        final int i = 8;
    }

    public VectorPainter() {
        final int i = 0;
        super(i, 1, i);
    }

    public VectorPainter(androidx.compose.ui.graphics.vector.GroupComponent root) {
        super();
        int i4 = 0;
        int i5 = 2;
        this.size$delegate = SnapshotStateKt.mutableStateOf$default(Size.box-impl(Size.Companion.getZero-NH-jbRc()), i4, i5, i4);
        int i = 0;
        this.autoMirror$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i), i4, i5, i4);
        VectorComponent vectorComponent = new VectorComponent(root);
        int i6 = 0;
        VectorPainter.vector.1.1 anon = new VectorPainter.vector.1.1(this);
        vectorComponent.setInvalidateCallback$ui_release((Function0)anon);
        this.vector = vectorComponent;
        this.invalidateCount$delegate = SnapshotIntStateKt.mutableIntStateOf(i);
        this.currentAlpha = 1065353216;
        this.drawCount = -1;
    }

    public VectorPainter(androidx.compose.ui.graphics.vector.GroupComponent groupComponent, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        androidx.compose.ui.graphics.vector.GroupComponent obj1;
        if (i2 &= 1 != 0) {
            obj1 = new GroupComponent();
        }
        super(obj1);
    }

    public static final int access$getDrawCount$p(androidx.compose.ui.graphics.vector.VectorPainter $this) {
        return $this.drawCount;
    }

    public static final int access$getInvalidateCount(androidx.compose.ui.graphics.vector.VectorPainter $this) {
        return $this.getInvalidateCount();
    }

    public static final void access$setInvalidateCount(androidx.compose.ui.graphics.vector.VectorPainter $this, int <set-?>) {
        $this.setInvalidateCount(<set-?>);
    }

    private final int getInvalidateCount() {
        final int i = 0;
        final int i2 = 0;
        return (IntState)this.invalidateCount$delegate.getIntValue();
    }

    private final void setInvalidateCount(int <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.invalidateCount$delegate.setIntValue(<set-?>);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyAlpha(float alpha) {
        this.currentAlpha = alpha;
        return 1;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyColorFilter(ColorFilter colorFilter) {
        this.currentColorFilter = colorFilter;
        return 1;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean getAutoMirror$ui_release() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.autoMirror$delegate.getValue().booleanValue();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final int getBitmapConfig-_sVssgQ$ui_release() {
        return this.vector.getCacheBitmapConfig-_sVssgQ$ui_release();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final Composition getComposition$ui_release() {
        return this.composition;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final ColorFilter getIntrinsicColorFilter$ui_release() {
        return this.vector.getIntrinsicColorFilter$ui_release();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public long getIntrinsicSize-NH-jbRc() {
        return getSize-NH-jbRc$ui_release();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final String getName$ui_release() {
        return this.vector.getName();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final long getSize-NH-jbRc$ui_release() {
        final int i = 0;
        final int i2 = 0;
        return (Size)(State)this.size$delegate.getValue().unbox-impl();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final androidx.compose.ui.graphics.vector.VectorComponent getVector$ui_release() {
        return this.vector;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final long getViewportSize-NH-jbRc$ui_release() {
        return this.vector.getViewportSize-NH-jbRc$ui_release();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected void onDraw(DrawScope $this$onDraw) {
        ColorFilter intrinsicColorFilter$ui_release;
        Canvas currentAlpha;
        boolean autoMirror$ui_release;
        DrawScope drawScope3;
        long size-NH-jbRc;
        int i3;
        int i;
        int i8;
        DrawScope drawScope;
        long center-F1C5BW0;
        int i4;
        DrawScope drawScope4;
        int i6;
        DrawContext drawContext;
        int i2;
        DrawScope drawScope2;
        int i7;
        int i5;
        Canvas canvas;
        int $i$a$WithVectorPainter$onDraw$1;
        final Object obj = this;
        final androidx.compose.ui.graphics.vector.VectorComponent vector = obj.vector;
        int i10 = 0;
        if (obj.currentColorFilter == null) {
            intrinsicColorFilter$ui_release = vector.getIntrinsicColorFilter$ui_release();
        }
        final ColorFilter colorFilter = intrinsicColorFilter$ui_release;
        if (obj.getAutoMirror$ui_release() && $this$onDraw.getLayoutDirection() == LayoutDirection.Rtl) {
            if ($this$onDraw.getLayoutDirection() == LayoutDirection.Rtl) {
                DrawScope drawScope6 = $this$onDraw;
                i3 = 0;
                drawScope = drawScope6;
                i4 = 0;
                drawScope4 = drawScope;
                i6 = 0;
                drawContext = drawScope4.getDrawContext();
                i2 = 0;
                drawScope2 = drawScope6;
                i7 = i3;
                drawContext.getCanvas().save();
                int i11 = 0;
                drawContext.getTransform().scale-0AR0LA0(-1082130432, 1065353216, drawScope.getCenter-F1C5BW0());
                i5 = 0;
                $i$a$WithVectorPainter$onDraw$1 = i10;
                vector.draw(drawScope4, obj.currentAlpha, colorFilter);
                drawContext.getCanvas().restore();
                drawContext.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
                drawScope3 = $this$onDraw;
            } else {
                $i$a$WithVectorPainter$onDraw$1 = i10;
                vector.draw($this$onDraw, obj.currentAlpha, colorFilter);
            }
        } else {
        }
        obj.drawCount = obj.getInvalidateCount();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void setAutoMirror$ui_release(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.autoMirror$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void setComposition$ui_release(Composition <set-?>) {
        this.composition = <set-?>;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void setIntrinsicColorFilter$ui_release(ColorFilter value) {
        this.vector.setIntrinsicColorFilter$ui_release(value);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void setName$ui_release(String value) {
        this.vector.setName(value);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void setSize-uvyYCjk$ui_release(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.size$delegate.setValue(Size.box-impl(<set-?>));
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void setViewportSize-uvyYCjk$ui_release(long value) {
        this.vector.setViewportSize-uvyYCjk$ui_release(value);
    }
}
