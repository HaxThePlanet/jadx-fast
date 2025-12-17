package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010I\u001a\u00020\u00142\u0006\u0010J\u001a\u00020&2\u0006\u0010K\u001a\u00020\u0001J\u0008\u0010L\u001a\u00020\u0014H\u0002J\u0012\u0010M\u001a\u00020\u00142\u0008\u0010N\u001a\u0004\u0018\u00010OH\u0002J\u001a\u0010P\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020;H\u0002ø\u0001\u0000¢\u0006\u0004\u0008R\u0010SJ\u0010\u0010T\u001a\u00020\u00142\u0006\u0010U\u001a\u00020\u0001H\u0002J\u001e\u0010V\u001a\u00020\u00142\u0006\u0010W\u001a\u00020&2\u0006\u0010X\u001a\u00020&2\u0006\u0010Y\u001a\u00020&J\u0016\u0010Z\u001a\u00020\u00142\u0006\u0010J\u001a\u00020&2\u0006\u0010Y\u001a\u00020&J\u0008\u0010[\u001a\u00020\u001fH\u0016J\u0008\u0010\\\u001a\u00020\u0014H\u0002J\u0008\u0010]\u001a\u00020\u0014H\u0002J\u000c\u0010^\u001a\u00020\u0014*\u00020_H\u0016R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR$\u0010 \u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\u001f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\"\"\u0004\u0008#\u0010$R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\u0008'\u0010(R$\u0010*\u001a\u00020)2\u0006\u0010\u0007\u001a\u00020)@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008+\u0010,\"\u0004\u0008-\u0010.R$\u0010/\u001a\u00020)2\u0006\u0010\u0007\u001a\u00020)@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00080\u0010,\"\u0004\u00081\u0010.R$\u00102\u001a\u00020)2\u0006\u0010\u0007\u001a\u00020)@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00083\u0010,\"\u0004\u00084\u0010.R$\u00105\u001a\u00020)2\u0006\u0010\u0007\u001a\u00020)@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00086\u0010,\"\u0004\u00087\u0010.R$\u00108\u001a\u00020)2\u0006\u0010\u0007\u001a\u00020)@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00089\u0010,\"\u0004\u0008:\u0010.R&\u0010<\u001a\u00020;2\u0006\u0010\u001c\u001a\u00020;@BX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010?\u001a\u0004\u0008=\u0010>R$\u0010@\u001a\u00020)2\u0006\u0010\u0007\u001a\u00020)@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008A\u0010,\"\u0004\u0008B\u0010.R$\u0010C\u001a\u00020)2\u0006\u0010\u0007\u001a\u00020)@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008D\u0010,\"\u0004\u0008E\u0010.R\u0014\u0010F\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008G\u0010\u001eR\u001a\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006`", d2 = {"Landroidx/compose/ui/graphics/vector/GroupComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "()V", "children", "", "clipPath", "Landroidx/compose/ui/graphics/Path;", "value", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "clipPathData", "getClipPathData", "()Ljava/util/List;", "setClipPathData", "(Ljava/util/List;)V", "groupMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "invalidateListener", "Lkotlin/Function1;", "", "getInvalidateListener$ui_release", "()Lkotlin/jvm/functions/Function1;", "setInvalidateListener$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "isClipPathDirty", "", "isMatrixDirty", "<set-?>", "isTintable", "()Z", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "numChildren", "", "getNumChildren", "()I", "", "pivotX", "getPivotX", "()F", "setPivotX", "(F)V", "pivotY", "getPivotY", "setPivotY", "rotation", "getRotation", "setRotation", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "Landroidx/compose/ui/graphics/Color;", "tintColor", "getTintColor-0d7_KjU", "()J", "J", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "willClipPath", "getWillClipPath", "wrappedListener", "insertAt", "index", "instance", "markNotTintable", "markTintForBrush", "brush", "Landroidx/compose/ui/graphics/Brush;", "markTintForColor", "color", "markTintForColor-8_81llA", "(J)V", "markTintForVNode", "node", "move", "from", "to", "count", "remove", "toString", "updateClipPath", "updateMatrix", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GroupComponent extends androidx.compose.ui.graphics.vector.VNode {

    public static final int $stable = 8;
    private final List<androidx.compose.ui.graphics.vector.VNode> children;
    private Path clipPath;
    private List<? extends androidx.compose.ui.graphics.vector.PathNode> clipPathData;
    private float[] groupMatrix;
    private Function1<? super androidx.compose.ui.graphics.vector.VNode, Unit> invalidateListener;
    private boolean isClipPathDirty = true;
    private boolean isMatrixDirty = true;
    private boolean isTintable = true;
    private String name;
    private float pivotX;
    private float pivotY;
    private float rotation;
    private float scaleX = 1f;
    private float scaleY = 1f;
    private long tintColor;
    private float translationX;
    private float translationY;
    private final Function1<androidx.compose.ui.graphics.vector.VNode, Unit> wrappedListener;
    static {
        final int i = 8;
    }

    public GroupComponent() {
        super(0);
        ArrayList arrayList = new ArrayList();
        this.children = (List)arrayList;
        int i2 = 1;
        this.tintColor = Color.Companion.getUnspecified-0d7_KjU();
        this.clipPathData = VectorKt.getEmptyPath();
        GroupComponent.wrappedListener.1 anon = new GroupComponent.wrappedListener.1(this);
        this.wrappedListener = (Function1)anon;
        this.name = "";
        int i3 = 1065353216;
    }

    public static final void access$markTintForVNode(androidx.compose.ui.graphics.vector.GroupComponent $this, androidx.compose.ui.graphics.vector.VNode node) {
        $this.markTintForVNode(node);
    }

    private final boolean getWillClipPath() {
        return empty ^= 1;
    }

    private final void markNotTintable() {
        this.isTintable = false;
        this.tintColor = Color.Companion.getUnspecified-0d7_KjU();
    }

    private final void markTintForBrush(Brush brush) {
        boolean value-0d7_KjU;
        if (!this.isTintable) {
        }
        if (brush != null) {
            if (brush instanceof SolidColor) {
                markTintForColor-8_81llA((SolidColor)brush.getValue-0d7_KjU());
            } else {
                markNotTintable();
            }
        }
    }

    private final void markTintForColor-8_81llA(long color) {
        int $this$isSpecified$iv;
        int i2;
        int cmp;
        int i;
        if (!this.isTintable) {
        }
        i2 = 0;
        cmp = 16;
        final int i4 = 0;
        $this$isSpecified$iv = Long.compare(i3, cmp) != 0 ? i : i4;
        if ($this$isSpecified$iv != 0) {
            i2 = 0;
            if (Long.compare($this$isSpecified$iv, cmp) == 0) {
            } else {
                i = i4;
            }
            if (i != 0) {
                this.tintColor = color;
            } else {
                if (!VectorKt.rgbEqual--OWjLjI(this.tintColor, obj1)) {
                    markNotTintable();
                }
            }
        }
    }

    private final void markTintForVNode(androidx.compose.ui.graphics.vector.VNode node) {
        boolean isTintable;
        if (node instanceof PathComponent) {
            markTintForBrush((PathComponent)node.getFill());
            markTintForBrush((PathComponent)node.getStroke());
        } else {
            if (node instanceof GroupComponent) {
                if (obj.isTintable && this.isTintable) {
                    if (this.isTintable) {
                        markTintForColor-8_81llA(obj2.tintColor);
                    } else {
                        markNotTintable();
                    }
                } else {
                }
            }
        }
    }

    private final void updateClipPath() {
        Path targetClip;
        List clipPathData;
        if (getWillClipPath() && this.clipPath == null) {
            if (this.clipPath == null) {
                this.clipPath = AndroidPath_androidKt.Path();
            }
            PathParserKt.toPath(this.clipPathData, targetClip);
        }
    }

    private final void updateMatrix() {
        float[] matrix;
        float[] fArr;
        int i;
        int i2 = 0;
        final float[] groupMatrix = this.groupMatrix;
        if (groupMatrix == null) {
            i = 0;
            matrix = Matrix.constructor-impl$default(i, 1, i);
            this.groupMatrix = matrix;
            fArr = matrix;
        } else {
            matrix = groupMatrix;
            Matrix.reset-impl(matrix);
            fArr = matrix;
        }
        final int i10 = 4;
        final int i11 = 0;
        final int i9 = 0;
        Matrix.translate-impl$default(fArr, pivotX2 += matrix2, pivotY2 += translationY, i9, i10, i11);
        Matrix.rotateZ-impl(fArr, this.rotation);
        Matrix.scale-impl(fArr, this.scaleX, this.scaleY, 1065353216);
        Matrix.translate-impl$default(fArr, -pivotX, -pivotY, i9, i10, i11);
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void draw(DrawScope $this$draw) {
        DrawScope drawScope2;
        DrawScope drawScope;
        Object obj3;
        float[] groupMatrix;
        Matrix box-impl;
        int index$iv;
        int i;
        boolean willClipPath;
        Object obj2;
        Object obj;
        int i2;
        DrawScope $this$draw_u24lambda_u247_u24lambda_u246_u24lambda_u245;
        int i3;
        obj3 = this;
        int i4 = 0;
        if (obj3.isMatrixDirty) {
            obj3.updateMatrix();
            obj3.isMatrixDirty = i4;
        }
        if (obj3.isClipPathDirty) {
            obj3.updateClipPath();
            obj3.isClipPathDirty = i4;
        }
        final DrawScope drawScope5 = $this$draw;
        final int i6 = 0;
        final DrawContext drawContext = drawScope5.getDrawContext();
        final int i7 = 0;
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        int i8 = 0;
        groupMatrix = obj3.groupMatrix;
        int i10 = 0;
        if (groupMatrix != null) {
            if (groupMatrix != null) {
                box-impl = Matrix.box-impl(groupMatrix);
            } else {
                box-impl = i10;
            }
            i = 0;
            transform.transform-58bKbWc(box-impl.unbox-impl());
        }
        Path it = obj3.clipPath;
        if (obj3.getWillClipPath() && it != null) {
            if (it != null) {
                DrawTransform.clipPath-mtrdD-E$default(transform, it, i4, 2, i10);
            }
        }
        drawScope2 = drawScope5;
        int i5 = 0;
        List children = obj3.children;
        int i9 = 0;
        index$iv = 0;
        while (index$iv < children.size()) {
            i2 = 0;
            i3 = 0;
            (VNode)children.get(index$iv).draw($this$draw);
            index$iv++;
            obj3 = this;
            drawScope2 = $this$draw_u24lambda_u247_u24lambda_u246_u24lambda_u245;
        }
        DrawScope drawScope4 = $this$draw;
        DrawScope drawScope6 = drawScope2;
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
    }

    public final List<androidx.compose.ui.graphics.vector.PathNode> getClipPathData() {
        return this.clipPathData;
    }

    public Function1<androidx.compose.ui.graphics.vector.VNode, Unit> getInvalidateListener$ui_release() {
        return this.invalidateListener;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final String getName() {
        return this.name;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final int getNumChildren() {
        return this.children.size();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final float getPivotX() {
        return this.pivotX;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final float getPivotY() {
        return this.pivotY;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final float getRotation() {
        return this.rotation;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final float getScaleX() {
        return this.scaleX;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final float getScaleY() {
        return this.scaleY;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final long getTintColor-0d7_KjU() {
        return this.tintColor;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final float getTranslationX() {
        return this.translationX;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final float getTranslationY() {
        return this.translationY;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void insertAt(int index, androidx.compose.ui.graphics.vector.VNode instance) {
        List children;
        if (index < getNumChildren()) {
            this.children.set(index, instance);
        } else {
            this.children.add(instance);
        }
        markTintForVNode(instance);
        instance.setInvalidateListener$ui_release(this.wrappedListener);
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final boolean isTintable() {
        return this.isTintable;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void move(int from, int to, int count) {
        int i2;
        int current;
        int i;
        int i3;
        Object children2;
        List children;
        i2 = 0;
        if (from > to) {
            int i4 = 0;
            current = to;
            while (i2 < count) {
                i = i2;
                i3 = 0;
                this.children.remove(from);
                this.children.add(current, (VNode)this.children.get(from));
                current++;
                i2++;
            }
        } else {
            while (i2 < count) {
                current = i2;
                i = 0;
                this.children.remove(from);
                this.children.add(to + -1, (VNode)this.children.get(from));
                i2++;
            }
        }
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void remove(int index, int count) {
        int i4;
        int i2;
        int i;
        int children;
        int i3;
        i4 = 0;
        while (i4 < count) {
            i2 = i4;
            i = 0;
            if (index < this.children.size()) {
            }
            i4++;
            (VNode)this.children.get(index).setInvalidateListener$ui_release(0);
            this.children.remove(index);
        }
        invalidate();
    }

    public final void setClipPathData(List<? extends androidx.compose.ui.graphics.vector.PathNode> value) {
        this.clipPathData = value;
        this.isClipPathDirty = true;
        invalidate();
    }

    public void setInvalidateListener$ui_release(Function1<? super androidx.compose.ui.graphics.vector.VNode, Unit> <set-?>) {
        this.invalidateListener = <set-?>;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setName(String value) {
        this.name = value;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setPivotX(float value) {
        this.pivotX = value;
        this.isMatrixDirty = true;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setPivotY(float value) {
        this.pivotY = value;
        this.isMatrixDirty = true;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setRotation(float value) {
        this.rotation = value;
        this.isMatrixDirty = true;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setScaleX(float value) {
        this.scaleX = value;
        this.isMatrixDirty = true;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setScaleY(float value) {
        this.scaleY = value;
        this.isMatrixDirty = true;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setTranslationX(float value) {
        this.translationX = value;
        this.isMatrixDirty = true;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setTranslationY(float value) {
        this.translationY = value;
        this.isMatrixDirty = true;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public String toString() {
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        StringBuilder append;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append3 = stringBuilder.append("VGroup: ").append(this.name);
        List children = this.children;
        final int i2 = 0;
        index$iv = 0;
        while (index$iv < children.size()) {
            i = 0;
            append3.append("\t").append((VNode)children.get(index$iv).toString()).append("\n");
            index$iv++;
        }
        return append3.toString();
    }
}
