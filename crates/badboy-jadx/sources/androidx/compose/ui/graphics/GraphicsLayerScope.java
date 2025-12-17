package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.layout.PlacementScopeMarker;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;

/* loaded from: classes.dex */
@PlacementScopeMarker
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0018\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008g\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u0004\u0010\u0005\"\u0004\u0008\u0006\u0010\u0007R*\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\t8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u0018\u0010\u000e\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u000f\u0010\u0005\"\u0004\u0008\u0010\u0010\u0007R \u0010\u0011\u001a\u00020\u00128fX¦\u000e¢\u0006\u0012\u0012\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R*\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001eR(\u0010!\u001a\u0004\u0018\u00010 2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\"\u0010#\"\u0004\u0008$\u0010%R\u0018\u0010&\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008'\u0010\u0005\"\u0004\u0008(\u0010\u0007R\u0018\u0010)\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008*\u0010\u0005\"\u0004\u0008+\u0010\u0007R\u0018\u0010,\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008-\u0010\u0005\"\u0004\u0008.\u0010\u0007R\u0018\u0010/\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u00080\u0010\u0005\"\u0004\u00081\u0010\u0007R\u0018\u00102\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u00083\u0010\u0005\"\u0004\u00084\u0010\u0007R\u0018\u00105\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u00086\u0010\u0005\"\u0004\u00087\u0010\u0007R\u0018\u00108\u001a\u000209X¦\u000e¢\u0006\u000c\u001a\u0004\u0008:\u0010;\"\u0004\u0008<\u0010=R\u001a\u0010>\u001a\u00020?8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008@\u0010\u000bR*\u0010A\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008B\u0010\u000b\"\u0004\u0008C\u0010\rR\u001e\u0010D\u001a\u00020EX¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008F\u0010\u000b\"\u0004\u0008G\u0010\rR\u0018\u0010H\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008I\u0010\u0005\"\u0004\u0008J\u0010\u0007R\u0018\u0010K\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008L\u0010\u0005\"\u0004\u0008M\u0010\u0007ø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006NÀ\u0006\u0003", d2 = {"Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Landroidx/compose/ui/unit/Density;", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "", "getClip$annotations", "()V", "getClip", "()Z", "setClip", "(Z)V", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "getCompositingStrategy--NrFUSI", "()I", "setCompositingStrategy-aDBOjCE", "(I)V", "<anonymous parameter 0>", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "getTransformOrigin-SzJe1aQ", "setTransformOrigin-__ExYCQ", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface GraphicsLayerScope extends Density {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static long getAmbientShadowColor-0d7_KjU(androidx.compose.ui.graphics.GraphicsLayerScope $this) {
            return GraphicsLayerScope.access$getAmbientShadowColor-0d7_KjU$jd($this);
        }

        public static void getClip$annotations() {
        }

        @Deprecated
        public static int getCompositingStrategy--NrFUSI(androidx.compose.ui.graphics.GraphicsLayerScope $this) {
            return GraphicsLayerScope.access$getCompositingStrategy--NrFUSI$jd($this);
        }

        @Deprecated
        public static androidx.compose.ui.graphics.RenderEffect getRenderEffect(androidx.compose.ui.graphics.GraphicsLayerScope $this) {
            return GraphicsLayerScope.access$getRenderEffect$jd($this);
        }

        @Deprecated
        public static long getSize-NH-jbRc(androidx.compose.ui.graphics.GraphicsLayerScope $this) {
            return GraphicsLayerScope.access$getSize-NH-jbRc$jd($this);
        }

        @Deprecated
        public static long getSpotShadowColor-0d7_KjU(androidx.compose.ui.graphics.GraphicsLayerScope $this) {
            return GraphicsLayerScope.access$getSpotShadowColor-0d7_KjU$jd($this);
        }

        @Deprecated
        public static int roundToPx--R2X_6o(androidx.compose.ui.graphics.GraphicsLayerScope $this, long $receiver) {
            return GraphicsLayerScope.access$roundToPx--R2X_6o$jd($this, $receiver);
        }

        @Deprecated
        public static int roundToPx-0680j_4(androidx.compose.ui.graphics.GraphicsLayerScope $this, float $receiver) {
            return GraphicsLayerScope.access$roundToPx-0680j_4$jd($this, $receiver);
        }

        @Deprecated
        public static void setAmbientShadowColor-8_81llA(androidx.compose.ui.graphics.GraphicsLayerScope $this, long ambientShadowColor) {
            GraphicsLayerScope.access$setAmbientShadowColor-8_81llA$jd($this, ambientShadowColor);
        }

        @Deprecated
        public static void setCompositingStrategy-aDBOjCE(androidx.compose.ui.graphics.GraphicsLayerScope $this, int compositingStrategy) {
            GraphicsLayerScope.access$setCompositingStrategy-aDBOjCE$jd($this, compositingStrategy);
        }

        @Deprecated
        public static void setRenderEffect(androidx.compose.ui.graphics.GraphicsLayerScope $this, androidx.compose.ui.graphics.RenderEffect renderEffect2) {
            GraphicsLayerScope.access$setRenderEffect$jd($this, renderEffect2);
        }

        @Deprecated
        public static void setSpotShadowColor-8_81llA(androidx.compose.ui.graphics.GraphicsLayerScope $this, long spotShadowColor) {
            GraphicsLayerScope.access$setSpotShadowColor-8_81llA$jd($this, spotShadowColor);
        }

        @Deprecated
        public static float toDp-GaN1DYA(androidx.compose.ui.graphics.GraphicsLayerScope $this, long $receiver) {
            return GraphicsLayerScope.access$toDp-GaN1DYA$jd($this, $receiver);
        }

        @Deprecated
        public static float toDp-u2uoSUM(androidx.compose.ui.graphics.GraphicsLayerScope $this, float $receiver) {
            return GraphicsLayerScope.access$toDp-u2uoSUM$jd($this, $receiver);
        }

        @Deprecated
        public static float toDp-u2uoSUM(androidx.compose.ui.graphics.GraphicsLayerScope $this, int $receiver) {
            return GraphicsLayerScope.access$toDp-u2uoSUM$jd($this, $receiver);
        }

        @Deprecated
        public static long toDpSize-k-rfVVM(androidx.compose.ui.graphics.GraphicsLayerScope $this, long $receiver) {
            return GraphicsLayerScope.access$toDpSize-k-rfVVM$jd($this, $receiver);
        }

        @Deprecated
        public static float toPx--R2X_6o(androidx.compose.ui.graphics.GraphicsLayerScope $this, long $receiver) {
            return GraphicsLayerScope.access$toPx--R2X_6o$jd($this, $receiver);
        }

        @Deprecated
        public static float toPx-0680j_4(androidx.compose.ui.graphics.GraphicsLayerScope $this, float $receiver) {
            return GraphicsLayerScope.access$toPx-0680j_4$jd($this, $receiver);
        }

        @Deprecated
        public static Rect toRect(androidx.compose.ui.graphics.GraphicsLayerScope $this, DpRect $receiver) {
            return GraphicsLayerScope.access$toRect$jd($this, $receiver);
        }

        @Deprecated
        public static long toSize-XkaWNTQ(androidx.compose.ui.graphics.GraphicsLayerScope $this, long $receiver) {
            return GraphicsLayerScope.access$toSize-XkaWNTQ$jd($this, $receiver);
        }

        @Deprecated
        public static long toSp-0xMU5do(androidx.compose.ui.graphics.GraphicsLayerScope $this, float $receiver) {
            return GraphicsLayerScope.access$toSp-0xMU5do$jd($this, $receiver);
        }

        @Deprecated
        public static long toSp-kPz2Gy4(androidx.compose.ui.graphics.GraphicsLayerScope $this, float $receiver) {
            return GraphicsLayerScope.access$toSp-kPz2Gy4$jd($this, $receiver);
        }

        @Deprecated
        public static long toSp-kPz2Gy4(androidx.compose.ui.graphics.GraphicsLayerScope $this, int $receiver) {
            return GraphicsLayerScope.access$toSp-kPz2Gy4$jd($this, $receiver);
        }
    }
    public static long access$getAmbientShadowColor-0d7_KjU$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this) {
        return super.getAmbientShadowColor-0d7_KjU();
    }

    public static int access$getCompositingStrategy--NrFUSI$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this) {
        return super.getCompositingStrategy--NrFUSI();
    }

    public static androidx.compose.ui.graphics.RenderEffect access$getRenderEffect$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this) {
        return super.getRenderEffect();
    }

    public static long access$getSize-NH-jbRc$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this) {
        return super.getSize-NH-jbRc();
    }

    public static long access$getSpotShadowColor-0d7_KjU$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this) {
        return super.getSpotShadowColor-0d7_KjU();
    }

    public static int access$roundToPx--R2X_6o$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this, long $receiver) {
        return super.roundToPx--R2X_6o($receiver);
    }

    public static int access$roundToPx-0680j_4$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this, float $receiver) {
        return super.roundToPx-0680j_4($receiver);
    }

    public static void access$setAmbientShadowColor-8_81llA$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this, long ambientShadowColor) {
        super.setAmbientShadowColor-8_81llA(ambientShadowColor);
    }

    public static void access$setCompositingStrategy-aDBOjCE$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this, int compositingStrategy) {
        super.setCompositingStrategy-aDBOjCE(compositingStrategy);
    }

    public static void access$setRenderEffect$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this, androidx.compose.ui.graphics.RenderEffect <anonymous parameter 0>) {
        super.setRenderEffect(<anonymous parameter 0>);
    }

    public static void access$setSpotShadowColor-8_81llA$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this, long spotShadowColor) {
        super.setSpotShadowColor-8_81llA(spotShadowColor);
    }

    public static float access$toDp-GaN1DYA$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this, long $receiver) {
        return super.toDp-GaN1DYA($receiver);
    }

    public static float access$toDp-u2uoSUM$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this, float $receiver) {
        return super.toDp-u2uoSUM($receiver);
    }

    public static float access$toDp-u2uoSUM$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this, int $receiver) {
        return super.toDp-u2uoSUM($receiver);
    }

    public static long access$toDpSize-k-rfVVM$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this, long $receiver) {
        return super.toDpSize-k-rfVVM($receiver);
    }

    public static float access$toPx--R2X_6o$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this, long $receiver) {
        return super.toPx--R2X_6o($receiver);
    }

    public static float access$toPx-0680j_4$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this, float $receiver) {
        return super.toPx-0680j_4($receiver);
    }

    public static Rect access$toRect$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this, DpRect $receiver) {
        return super.toRect($receiver);
    }

    public static long access$toSize-XkaWNTQ$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this, long $receiver) {
        return super.toSize-XkaWNTQ($receiver);
    }

    public static long access$toSp-0xMU5do$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this, float $receiver) {
        return super.toSp-0xMU5do($receiver);
    }

    public static long access$toSp-kPz2Gy4$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this, float $receiver) {
        return super.toSp-kPz2Gy4($receiver);
    }

    public static long access$toSp-kPz2Gy4$jd(androidx.compose.ui.graphics.GraphicsLayerScope $this, int $receiver) {
        return super.toSp-kPz2Gy4($receiver);
    }

    @Override // androidx.compose.ui.unit.Density
    public abstract float getAlpha();

    @Override // androidx.compose.ui.unit.Density
    public long getAmbientShadowColor-0d7_KjU() {
        return GraphicsLayerScopeKt.getDefaultShadowColor();
    }

    @Override // androidx.compose.ui.unit.Density
    public abstract float getCameraDistance();

    @Override // androidx.compose.ui.unit.Density
    public abstract boolean getClip();

    @Override // androidx.compose.ui.unit.Density
    public int getCompositingStrategy--NrFUSI() {
        return CompositingStrategy.Companion.getAuto--NrFUSI();
    }

    @Override // androidx.compose.ui.unit.Density
    public androidx.compose.ui.graphics.RenderEffect getRenderEffect() {
        return null;
    }

    @Override // androidx.compose.ui.unit.Density
    public abstract float getRotationX();

    @Override // androidx.compose.ui.unit.Density
    public abstract float getRotationY();

    @Override // androidx.compose.ui.unit.Density
    public abstract float getRotationZ();

    @Override // androidx.compose.ui.unit.Density
    public abstract float getScaleX();

    @Override // androidx.compose.ui.unit.Density
    public abstract float getScaleY();

    @Override // androidx.compose.ui.unit.Density
    public abstract float getShadowElevation();

    @Override // androidx.compose.ui.unit.Density
    public abstract androidx.compose.ui.graphics.Shape getShape();

    @Override // androidx.compose.ui.unit.Density
    public long getSize-NH-jbRc() {
        return Size.Companion.getUnspecified-NH-jbRc();
    }

    @Override // androidx.compose.ui.unit.Density
    public long getSpotShadowColor-0d7_KjU() {
        return GraphicsLayerScopeKt.getDefaultShadowColor();
    }

    @Override // androidx.compose.ui.unit.Density
    public abstract long getTransformOrigin-SzJe1aQ();

    @Override // androidx.compose.ui.unit.Density
    public abstract float getTranslationX();

    @Override // androidx.compose.ui.unit.Density
    public abstract float getTranslationY();

    @Override // androidx.compose.ui.unit.Density
    public abstract void setAlpha(float f);

    @Override // androidx.compose.ui.unit.Density
    public void setAmbientShadowColor-8_81llA(long ambientShadowColor) {
    }

    @Override // androidx.compose.ui.unit.Density
    public abstract void setCameraDistance(float f);

    @Override // androidx.compose.ui.unit.Density
    public abstract void setClip(boolean z);

    @Override // androidx.compose.ui.unit.Density
    public void setCompositingStrategy-aDBOjCE(int compositingStrategy) {
    }

    @Override // androidx.compose.ui.unit.Density
    public void setRenderEffect(androidx.compose.ui.graphics.RenderEffect renderEffect) {
    }

    @Override // androidx.compose.ui.unit.Density
    public abstract void setRotationX(float f);

    @Override // androidx.compose.ui.unit.Density
    public abstract void setRotationY(float f);

    @Override // androidx.compose.ui.unit.Density
    public abstract void setRotationZ(float f);

    @Override // androidx.compose.ui.unit.Density
    public abstract void setScaleX(float f);

    @Override // androidx.compose.ui.unit.Density
    public abstract void setScaleY(float f);

    @Override // androidx.compose.ui.unit.Density
    public abstract void setShadowElevation(float f);

    @Override // androidx.compose.ui.unit.Density
    public abstract void setShape(androidx.compose.ui.graphics.Shape shape);

    @Override // androidx.compose.ui.unit.Density
    public void setSpotShadowColor-8_81llA(long spotShadowColor) {
    }

    @Override // androidx.compose.ui.unit.Density
    public abstract void setTransformOrigin-__ExYCQ(long l);

    @Override // androidx.compose.ui.unit.Density
    public abstract void setTranslationX(float f);

    @Override // androidx.compose.ui.unit.Density
    public abstract void setTranslationY(float f);
}
