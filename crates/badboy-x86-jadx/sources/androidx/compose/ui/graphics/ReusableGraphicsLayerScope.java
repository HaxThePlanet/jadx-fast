package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010k\u001a\u00020lJ\r\u0010m\u001a\u00020lH\u0000¢\u0006\u0002\u0008nR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u0007\"\u0004\u0008\u0013\u0010\tR$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0014@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R,\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u001a@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\u0008\u001c\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\"\u0010\u0007R\u0014\u0010#\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008$\u0010\u0007R\u001a\u0010%\u001a\u00020&X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008'\u0010(\"\u0004\u0008)\u0010*R\u001a\u0010+\u001a\u00020,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008-\u0010.\"\u0004\u0008/\u00100R\u001a\u00101\u001a\u000202X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00083\u0010\u001d\"\u0004\u00084\u0010\u001fR(\u00107\u001a\u0004\u0018\u0001062\u0008\u00105\u001a\u0004\u0018\u000106@AX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00088\u00109\"\u0004\u0008:\u0010;R(\u0010=\u001a\u0004\u0018\u00010<2\u0008\u0010\u0003\u001a\u0004\u0018\u00010<@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008>\u0010?\"\u0004\u0008@\u0010AR$\u0010B\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008C\u0010\u0007\"\u0004\u0008D\u0010\tR$\u0010E\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008F\u0010\u0007\"\u0004\u0008G\u0010\tR$\u0010H\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008I\u0010\u0007\"\u0004\u0008J\u0010\tR$\u0010K\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008L\u0010\u0007\"\u0004\u0008M\u0010\tR$\u0010N\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008O\u0010\u0007\"\u0004\u0008P\u0010\tR$\u0010Q\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008R\u0010\u0007\"\u0004\u0008S\u0010\tR$\u0010U\u001a\u00020T2\u0006\u0010\u0003\u001a\u00020T@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008V\u0010W\"\u0004\u0008X\u0010YR\"\u0010Z\u001a\u00020[X\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\u0008\\\u0010\r\"\u0004\u0008]\u0010\u000fR,\u0010^\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\u0008_\u0010\r\"\u0004\u0008`\u0010\u000fR,\u0010b\u001a\u00020a2\u0006\u0010\u0003\u001a\u00020a@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\u0008c\u0010\r\"\u0004\u0008d\u0010\u000fR$\u0010e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008f\u0010\u0007\"\u0004\u0008g\u0010\tR$\u0010h\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008i\u0010\u0007\"\u0004\u0008j\u0010\t\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006o", d2 = {"Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "()V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "J", "cameraDistance", "getCameraDistance", "setCameraDistance", "", "clip", "getClip", "()Z", "setClip", "(Z)V", "Landroidx/compose/ui/graphics/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy--NrFUSI", "()I", "setCompositingStrategy-aDBOjCE", "(I)V", "I", "density", "getDensity", "fontScale", "getFontScale", "graphicsDensity", "Landroidx/compose/ui/unit/Density;", "getGraphicsDensity$ui_release", "()Landroidx/compose/ui/unit/Density;", "setGraphicsDensity$ui_release", "(Landroidx/compose/ui/unit/Density;)V", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection$ui_release", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection$ui_release", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "mutatedFields", "", "getMutatedFields$ui_release", "setMutatedFields$ui_release", "<set-?>", "Landroidx/compose/ui/graphics/Outline;", "outline", "getOutline$ui_release", "()Landroidx/compose/ui/graphics/Outline;", "setOutline$ui_release", "(Landroidx/compose/ui/graphics/Outline;)V", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "Landroidx/compose/ui/graphics/Shape;", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "setSize-uvyYCjk", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "Landroidx/compose/ui/graphics/TransformOrigin;", "transformOrigin", "getTransformOrigin-SzJe1aQ", "setTransformOrigin-__ExYCQ", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "reset", "", "updateOutline", "updateOutline$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ReusableGraphicsLayerScope implements androidx.compose.ui.graphics.GraphicsLayerScope {

    public static final int $stable;
    private float alpha = 1f;
    private long ambientShadowColor;
    private float cameraDistance = 8f;
    private boolean clip;
    private int compositingStrategy;
    private Density graphicsDensity;
    private LayoutDirection layoutDirection;
    private int mutatedFields;
    private androidx.compose.ui.graphics.Outline outline;
    private androidx.compose.ui.graphics.RenderEffect renderEffect;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX = 1f;
    private float scaleY = 1f;
    private float shadowElevation;
    private androidx.compose.ui.graphics.Shape shape;
    private long size;
    private long spotShadowColor;
    private long transformOrigin;
    private float translationX;
    private float translationY;
    static {
    }

    public ReusableGraphicsLayerScope() {
        super();
        this.ambientShadowColor = GraphicsLayerScopeKt.getDefaultShadowColor();
        this.spotShadowColor = GraphicsLayerScopeKt.getDefaultShadowColor();
        int i2 = 1090519040;
        this.transformOrigin = TransformOrigin.Companion.getCenter-SzJe1aQ();
        this.shape = RectangleShapeKt.getRectangleShape();
        this.compositingStrategy = CompositingStrategy.Companion.getAuto--NrFUSI();
        this.size = Size.Companion.getUnspecified-NH-jbRc();
        this.graphicsDensity = DensityKt.Density$default(1065353216, 0, 2, 0);
        this.layoutDirection = LayoutDirection.Ltr;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public long getAmbientShadowColor-0d7_KjU() {
        return this.ambientShadowColor;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public float getCameraDistance() {
        return this.cameraDistance;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public boolean getClip() {
        return this.clip;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public int getCompositingStrategy--NrFUSI() {
        return this.compositingStrategy;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public float getDensity() {
        return this.graphicsDensity.getDensity();
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public float getFontScale() {
        return this.graphicsDensity.getFontScale();
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final Density getGraphicsDensity$ui_release() {
        return this.graphicsDensity;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final LayoutDirection getLayoutDirection$ui_release() {
        return this.layoutDirection;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final int getMutatedFields$ui_release() {
        return this.mutatedFields;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final androidx.compose.ui.graphics.Outline getOutline$ui_release() {
        return this.outline;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public androidx.compose.ui.graphics.RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public float getRotationX() {
        return this.rotationX;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public float getRotationY() {
        return this.rotationY;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public float getRotationZ() {
        return this.rotationZ;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public float getScaleX() {
        return this.scaleX;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public float getScaleY() {
        return this.scaleY;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public float getShadowElevation() {
        return this.shadowElevation;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public androidx.compose.ui.graphics.Shape getShape() {
        return this.shape;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public long getSize-NH-jbRc() {
        return this.size;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public long getSpotShadowColor-0d7_KjU() {
        return this.spotShadowColor;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public long getTransformOrigin-SzJe1aQ() {
        return this.transformOrigin;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public float getTranslationX() {
        return this.translationX;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public float getTranslationY() {
        return this.translationY;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final void reset() {
        int i = 1065353216;
        setScaleX(i);
        setScaleY(i);
        setAlpha(i);
        int i2 = 0;
        setTranslationX(i2);
        setTranslationY(i2);
        setShadowElevation(i2);
        setAmbientShadowColor-8_81llA(GraphicsLayerScopeKt.getDefaultShadowColor());
        long defaultShadowColor2 = GraphicsLayerScopeKt.getDefaultShadowColor();
        setSpotShadowColor-8_81llA(defaultShadowColor2);
        setRotationX(i2);
        setRotationY(i2);
        setRotationZ(i2);
        setCameraDistance(1090519040);
        setTransformOrigin-__ExYCQ(TransformOrigin.Companion.getCenter-SzJe1aQ());
        setShape(RectangleShapeKt.getRectangleShape());
        int i4 = 0;
        setClip(i4);
        int i5 = 0;
        setRenderEffect(i5);
        setCompositingStrategy-aDBOjCE(CompositingStrategy.Companion.getAuto--NrFUSI());
        setSize-uvyYCjk(Size.Companion.getUnspecified-NH-jbRc());
        this.outline = i5;
        this.mutatedFields = i4;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void setAlpha(float value) {
        int i;
        i = Float.compare(alpha, value) == 0 ? 1 : 0;
        if (i == 0) {
            this.mutatedFields = mutatedFields |= 4;
            this.alpha = value;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void setAmbientShadowColor-8_81llA(long value) {
        boolean equals-impl0;
        if (!Color.equals-impl0(this.ambientShadowColor, obj1)) {
            this.mutatedFields = mutatedFields |= 64;
            this.ambientShadowColor = value;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void setCameraDistance(float value) {
        int i;
        i = Float.compare(cameraDistance, value) == 0 ? 1 : 0;
        if (i == 0) {
            this.mutatedFields = mutatedFields |= 2048;
            this.cameraDistance = value;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void setClip(boolean value) {
        boolean clip;
        if (this.clip != value) {
            this.mutatedFields = mutatedFields |= 16384;
            this.clip = value;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void setCompositingStrategy-aDBOjCE(int value) {
        boolean equals-impl0;
        int i;
        if (!CompositingStrategy.equals-impl0(this.compositingStrategy, value)) {
            this.mutatedFields = mutatedFields |= i;
            this.compositingStrategy = value;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final void setGraphicsDensity$ui_release(Density <set-?>) {
        this.graphicsDensity = <set-?>;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final void setLayoutDirection$ui_release(LayoutDirection <set-?>) {
        this.layoutDirection = <set-?>;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final void setMutatedFields$ui_release(int <set-?>) {
        this.mutatedFields = <set-?>;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final void setOutline$ui_release(androidx.compose.ui.graphics.Outline <set-?>) {
        this.outline = <set-?>;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void setRenderEffect(androidx.compose.ui.graphics.RenderEffect value) {
        boolean equal;
        int i;
        if (!Intrinsics.areEqual(this.renderEffect, value)) {
            this.mutatedFields = mutatedFields |= i;
            this.renderEffect = value;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void setRotationX(float value) {
        int i;
        i = Float.compare(rotationX, value) == 0 ? 1 : 0;
        if (i == 0) {
            this.mutatedFields = mutatedFields |= 256;
            this.rotationX = value;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void setRotationY(float value) {
        int i;
        i = Float.compare(rotationY, value) == 0 ? 1 : 0;
        if (i == 0) {
            this.mutatedFields = mutatedFields |= 512;
            this.rotationY = value;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void setRotationZ(float value) {
        int i;
        i = Float.compare(rotationZ, value) == 0 ? 1 : 0;
        if (i == 0) {
            this.mutatedFields = mutatedFields |= 1024;
            this.rotationZ = value;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void setScaleX(float value) {
        int i;
        final int i2 = 1;
        i = Float.compare(scaleX, value) == 0 ? i2 : 0;
        if (i == 0) {
            this.mutatedFields = mutatedFields |= i2;
            this.scaleX = value;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void setScaleY(float value) {
        int i;
        i = Float.compare(scaleY, value) == 0 ? 1 : 0;
        if (i == 0) {
            this.mutatedFields = mutatedFields |= 2;
            this.scaleY = value;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void setShadowElevation(float value) {
        int i;
        i = Float.compare(shadowElevation, value) == 0 ? 1 : 0;
        if (i == 0) {
            this.mutatedFields = mutatedFields |= 32;
            this.shadowElevation = value;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void setShape(androidx.compose.ui.graphics.Shape value) {
        boolean equal;
        if (!Intrinsics.areEqual(this.shape, value)) {
            this.mutatedFields = mutatedFields |= 8192;
            this.shape = value;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void setSize-uvyYCjk(long <set-?>) {
        this.size = <set-?>;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void setSpotShadowColor-8_81llA(long value) {
        boolean equals-impl0;
        if (!Color.equals-impl0(this.spotShadowColor, obj1)) {
            this.mutatedFields = mutatedFields |= 128;
            this.spotShadowColor = value;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void setTransformOrigin-__ExYCQ(long value) {
        boolean equals-impl0;
        if (!TransformOrigin.equals-impl0(this.transformOrigin, obj1)) {
            this.mutatedFields = mutatedFields |= 4096;
            this.transformOrigin = value;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void setTranslationX(float value) {
        int i;
        i = Float.compare(translationX, value) == 0 ? 1 : 0;
        if (i == 0) {
            this.mutatedFields = mutatedFields |= 8;
            this.translationX = value;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public void setTranslationY(float value) {
        int i;
        i = Float.compare(translationY, value) == 0 ? 1 : 0;
        if (i == 0) {
            this.mutatedFields = mutatedFields |= 16;
            this.translationY = value;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final void updateOutline$ui_release() {
        this.outline = getShape().createOutline-Pq9zytI(getSize-NH-jbRc(), obj2, this.layoutDirection);
    }
}
