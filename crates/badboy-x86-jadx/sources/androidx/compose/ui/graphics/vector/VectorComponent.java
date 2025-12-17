package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorFilter.Companion;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapConfig.Companion;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u000e\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u00106\u001a\u00020\u000eH\u0002J\u0008\u00107\u001a\u00020\"H\u0016J\u000c\u00108\u001a\u00020\u000e*\u00020\rH\u0016J\u001c\u00108\u001a\u00020\u000e*\u00020\r2\u0006\u00109\u001a\u00020-2\u0008\u0010:\u001a\u0004\u0018\u00010\u0011R\u001a\u0010\u0005\u001a\u00020\u00068@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000c¢\u0006\u0002\u0008\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00118@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0017\u0010\u0018\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R \u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008#\u0010$\"\u0004\u0008%\u0010&R\u0016\u0010'\u001a\u00020(X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R1\u00100\u001a\u00020(2\u0006\u0010\u0010\u001a\u00020(8@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u00085\u0010\u0018\u001a\u0004\u00081\u00102\"\u0004\u00083\u00104\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006;", d2 = {"Landroidx/compose/ui/graphics/vector/VectorComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "(Landroidx/compose/ui/graphics/vector/GroupComponent;)V", "cacheBitmapConfig", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getCacheBitmapConfig-_sVssgQ$ui_release", "()I", "cacheDrawScope", "Landroidx/compose/ui/graphics/vector/DrawCache;", "drawVectorBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "<set-?>", "Landroidx/compose/ui/graphics/ColorFilter;", "intrinsicColorFilter", "getIntrinsicColorFilter$ui_release", "()Landroidx/compose/ui/graphics/ColorFilter;", "setIntrinsicColorFilter$ui_release", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "intrinsicColorFilter$delegate", "Landroidx/compose/runtime/MutableState;", "invalidateCallback", "Lkotlin/Function0;", "getInvalidateCallback$ui_release", "()Lkotlin/jvm/functions/Function0;", "setInvalidateCallback$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "isDirty", "", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "previousDrawSize", "Landroidx/compose/ui/geometry/Size;", "J", "getRoot", "()Landroidx/compose/ui/graphics/vector/GroupComponent;", "rootScaleX", "", "rootScaleY", "tintFilter", "viewportSize", "getViewportSize-NH-jbRc$ui_release", "()J", "setViewportSize-uvyYCjk$ui_release", "(J)V", "viewportSize$delegate", "doInvalidate", "toString", "draw", "alpha", "colorFilter", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VectorComponent extends androidx.compose.ui.graphics.vector.VNode {

    public static final int $stable = 8;
    private final androidx.compose.ui.graphics.vector.DrawCache cacheDrawScope;
    private final Function1<DrawScope, Unit> drawVectorBlock;
    private final MutableState intrinsicColorFilter$delegate;
    private Function0<Unit> invalidateCallback;
    private boolean isDirty = true;
    private String name;
    private long previousDrawSize;
    private final androidx.compose.ui.graphics.vector.GroupComponent root;
    private float rootScaleX = 1f;
    private float rootScaleY = 1f;
    private ColorFilter tintFilter;
    private final MutableState viewportSize$delegate;
    static {
        final int i = 8;
    }

    public VectorComponent(androidx.compose.ui.graphics.vector.GroupComponent root) {
        int i = 0;
        super(i);
        this.root = root;
        VectorComponent.1 anon2 = new VectorComponent.1(this);
        this.root.setInvalidateListener$ui_release((Function1)anon2);
        this.name = "";
        int i3 = 1;
        DrawCache drawCache = new DrawCache();
        this.cacheDrawScope = drawCache;
        this.invalidateCallback = (Function0)VectorComponent.invalidateCallback.1.INSTANCE;
        int i4 = 2;
        this.intrinsicColorFilter$delegate = SnapshotStateKt.mutableStateOf$default(i, i, i4, i);
        this.viewportSize$delegate = SnapshotStateKt.mutableStateOf$default(Size.box-impl(Size.Companion.getZero-NH-jbRc()), i, i4, i);
        this.previousDrawSize = Size.Companion.getUnspecified-NH-jbRc();
        int i2 = 1065353216;
        VectorComponent.drawVectorBlock.1 anon = new VectorComponent.drawVectorBlock.1(this);
        this.drawVectorBlock = (Function1)anon;
    }

    public static final void access$doInvalidate(androidx.compose.ui.graphics.vector.VectorComponent $this) {
        $this.doInvalidate();
    }

    public static final float access$getRootScaleX$p(androidx.compose.ui.graphics.vector.VectorComponent $this) {
        return $this.rootScaleX;
    }

    public static final float access$getRootScaleY$p(androidx.compose.ui.graphics.vector.VectorComponent $this) {
        return $this.rootScaleY;
    }

    private final void doInvalidate() {
        this.isDirty = true;
        this.invalidateCallback.invoke();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void draw(DrawScope $this$draw) {
        draw($this$draw, 1065353216, 0);
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void draw(DrawScope $this$draw, float alpha, ColorFilter colorFilter) {
        boolean $i$f$isSpecified8_81llA;
        int argb8888-_sVssgQ;
        boolean size-NH-jbRc2;
        int tint-xETnrds$default;
        ColorFilter intrinsicColorFilter$ui_release;
        long tintColor-0d7_KjU;
        int cmp;
        int i;
        androidx.compose.ui.graphics.vector.DrawCache cacheDrawScope;
        long size-NH-jbRc;
        long tintColor-0d7_KjU2;
        androidx.compose.ui.unit.LayoutDirection layoutDirection2;
        int layoutDirection;
        int drawVectorBlock;
        int i2;
        final Object obj = this;
        final DrawScope drawScope = $this$draw;
        int i7 = 0;
        if (obj.root.isTintable()) {
            int i3 = 0;
            $i$f$isSpecified8_81llA = Long.compare(tintColor-0d7_KjU, i8) != 0 ? i : i7;
            if ($i$f$isSpecified8_81llA != 0) {
            } else {
                i = i7;
            }
        } else {
        }
        if (i != 0 && VectorKt.tintableWithAlphaMask(obj.getIntrinsicColorFilter$ui_release()) && VectorKt.tintableWithAlphaMask(colorFilter)) {
            if (VectorKt.tintableWithAlphaMask(obj.getIntrinsicColorFilter$ui_release())) {
                if (VectorKt.tintableWithAlphaMask(colorFilter)) {
                    argb8888-_sVssgQ = ImageBitmapConfig.Companion.getAlpha8-_sVssgQ();
                } else {
                    argb8888-_sVssgQ = ImageBitmapConfig.Companion.getArgb8888-_sVssgQ();
                }
            } else {
            }
        } else {
        }
        final int i9 = argb8888-_sVssgQ;
        if (!obj.isDirty && Size.equals-impl0(obj.previousDrawSize, obj5)) {
            if (Size.equals-impl0(obj.previousDrawSize, obj5)) {
                if (!ImageBitmapConfig.equals-impl0(i9, obj.getCacheBitmapConfig-_sVssgQ$ui_release())) {
                    if (ImageBitmapConfig.equals-impl0(i9, ImageBitmapConfig.Companion.getAlpha8-_sVssgQ())) {
                        tint-xETnrds$default = ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, obj.root.getTintColor-0d7_KjU(), obj12, 0, 2);
                    } else {
                        tint-xETnrds$default = 0;
                    }
                    obj.tintFilter = tint-xETnrds$default;
                    obj.rootScaleX = width-impl /= width-impl3;
                    obj.rootScaleY = height-impl /= height-impl2;
                    obj.cacheDrawScope.drawCachedImage-FqjB98A(i9, IntSizeKt.IntSize((int)f, (int)f2), tintColor-0d7_KjU2, (Density)drawScope, drawScope.getLayoutDirection());
                    obj.isDirty = i7;
                    obj.previousDrawSize = drawScope.getSize-NH-jbRc();
                }
            } else {
            }
        } else {
        }
        if (colorFilter != null) {
            intrinsicColorFilter$ui_release = colorFilter;
        } else {
            if (obj.getIntrinsicColorFilter$ui_release() != null) {
                intrinsicColorFilter$ui_release = obj.getIntrinsicColorFilter$ui_release();
            } else {
                intrinsicColorFilter$ui_release = obj.tintFilter;
            }
        }
        obj.cacheDrawScope.drawInto(drawScope, alpha, intrinsicColorFilter$ui_release);
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final int getCacheBitmapConfig-_sVssgQ$ui_release() {
        int argb8888-_sVssgQ;
        ImageBitmap mCachedImage = this.cacheDrawScope.getMCachedImage();
        if (mCachedImage != null) {
            argb8888-_sVssgQ = mCachedImage.getConfig-_sVssgQ();
        } else {
            argb8888-_sVssgQ = ImageBitmapConfig.Companion.getArgb8888-_sVssgQ();
        }
        return argb8888-_sVssgQ;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final ColorFilter getIntrinsicColorFilter$ui_release() {
        final int i = 0;
        final int i2 = 0;
        return (ColorFilter)(State)this.intrinsicColorFilter$delegate.getValue();
    }

    public final Function0<Unit> getInvalidateCallback$ui_release() {
        return this.invalidateCallback;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final String getName() {
        return this.name;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final androidx.compose.ui.graphics.vector.GroupComponent getRoot() {
        return this.root;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final long getViewportSize-NH-jbRc$ui_release() {
        final int i = 0;
        final int i2 = 0;
        return (Size)(State)this.viewportSize$delegate.getValue().unbox-impl();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setIntrinsicColorFilter$ui_release(ColorFilter <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.intrinsicColorFilter$delegate.setValue(<set-?>);
    }

    public final void setInvalidateCallback$ui_release(Function0<Unit> <set-?>) {
        this.invalidateCallback = <set-?>;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setName(String <set-?>) {
        this.name = <set-?>;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setViewportSize-uvyYCjk$ui_release(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.viewportSize$delegate.setValue(Size.box-impl(<set-?>));
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = stringBuilder;
        final int i = 0;
        sb.append("Params: ");
        String str6 = "\n";
        sb.append("\tname: ").append(this.name).append(str6);
        sb.append("\tviewportWidth: ").append(Size.getWidth-impl(getViewportSize-NH-jbRc$ui_release())).append(str6);
        sb.append("\tviewportHeight: ").append(Size.getHeight-impl(getViewportSize-NH-jbRc$ui_release())).append(str6);
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
