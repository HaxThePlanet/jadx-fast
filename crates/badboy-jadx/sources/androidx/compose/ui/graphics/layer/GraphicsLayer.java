package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.os.Build.VERSION;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.BlendMode.Companion;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Outline.Generic;
import androidx.compose.ui.graphics.Outline.Rectangle;
import androidx.compose.ui.graphics.Outline.Rounded;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffset.Companion;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 ¶\u00012\u00020\u0001:\u0002¶\u0001B\u0019\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0085\u0001\u001a\u0002082\u0007\u0010\u0086\u0001\u001a\u00020\u0000H\u0002J\t\u0010\u0087\u0001\u001a\u000208H\u0002J\t\u0010\u0088\u0001\u001a\u000208H\u0002J\u000f\u0010\u0089\u0001\u001a\u000208H\u0000¢\u0006\u0003\u0008\u008a\u0001J$\u0010\u008b\u0001\u001a\u0002082\u0008\u0010\u008c\u0001\u001a\u00030\u008d\u00012\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0003\u0008\u008f\u0001J\u0019\u0010\u0090\u0001\u001a\u0002082\u0008\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0000¢\u0006\u0003\u0008\u0091\u0001J\u000f\u0010\u0092\u0001\u001a\u000208H\u0001¢\u0006\u0003\u0008\u0093\u0001J\t\u0010\u0094\u0001\u001a\u00020\u0015H\u0002J\t\u0010\u0095\u0001\u001a\u000208H\u0002J\t\u0010\u0096\u0001\u001a\u000208H\u0002JE\u0010\u0097\u0001\u001a\u0002082\u0006\u00103\u001a\u0002042\u0006\u0010C\u001a\u00020D2\u0006\u0010r\u001a\u00020q2\u0018\u0010\u0098\u0001\u001a\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020806¢\u0006\u0002\u00089ø\u0001\u0000¢\u0006\u0006\u0008\u0099\u0001\u0010\u009a\u0001J\t\u0010\u009b\u0001\u001a\u000208H\u0002J\t\u0010\u009c\u0001\u001a\u000208H\u0002J\u000f\u0010\u009d\u0001\u001a\u000208H\u0000¢\u0006\u0003\u0008\u009e\u0001J\t\u0010\u009f\u0001\u001a\u000208H\u0002J5\u0010 \u0001\u001a\u0003H¡\u0001\"\u0005\u0008\u0000\u0010¡\u00012\u001b\u0010\u0098\u0001\u001a\u0016\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020f\u0012\u0005\u0012\u0003H¡\u00010¢\u0001H\u0082\u0008¢\u0006\u0003\u0010£\u0001J\u0010\u0010¤\u0001\u001a\u0002082\u0007\u0010¥\u0001\u001a\u00020JJ%\u0010¦\u0001\u001a\u0002082\u0006\u0010{\u001a\u00020z2\u0006\u0010r\u001a\u00020qH\u0002ø\u0001\u0000¢\u0006\u0006\u0008§\u0001\u0010¨\u0001J'\u0010©\u0001\u001a\u0002082\u0008\u0008\u0002\u0010{\u001a\u00020O2\u0008\u0008\u0002\u0010r\u001a\u00020fø\u0001\u0000¢\u0006\u0006\u0008ª\u0001\u0010¨\u0001J2\u0010«\u0001\u001a\u0002082\u0008\u0008\u0002\u0010{\u001a\u00020O2\u0008\u0008\u0002\u0010r\u001a\u00020f2\t\u0008\u0002\u0010¬\u0001\u001a\u00020\u0008ø\u0001\u0000¢\u0006\u0006\u0008­\u0001\u0010®\u0001J\u0011\u0010¯\u0001\u001a\u00030°\u0001H\u0086@¢\u0006\u0003\u0010±\u0001J\u0013\u0010²\u0001\u001a\u0002082\u0008\u0010³\u0001\u001a\u00030´\u0001H\u0002J\u0012\u0010µ\u0001\u001a\u00020\u00152\u0007\u0010¥\u0001\u001a\u00020JH\u0002R$\u0010\t\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u00088F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e8F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00168F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008\u0018\u0010\u0019\"\u0004\u0008\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u00088F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u001d\u0010\u000b\"\u0004\u0008\u001e\u0010\rR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\"\u001a\u00020!2\u0006\u0010\u0007\u001a\u00020!8F@FX\u0086\u000e¢\u0006\u0012\u0012\u0004\u0008#\u0010$\u001a\u0004\u0008%\u0010&\"\u0004\u0008'\u0010(R(\u0010*\u001a\u0004\u0018\u00010)2\u0008\u0010\u0007\u001a\u0004\u0018\u00010)8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008+\u0010,\"\u0004\u0008-\u0010.R*\u00100\u001a\u00020/2\u0006\u0010\u0007\u001a\u00020/8F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u00081\u0010\u0019\"\u0004\u00082\u0010\u001bR\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u00105\u001a\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020806¢\u0006\u0002\u00089X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u0010;R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010?\u001a\u00020!2\u0006\u0010>\u001a\u00020!@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008?\u0010&R\u0011\u0010@\u001a\u00020A8F¢\u0006\u0006\u001a\u0004\u0008B\u0010\u0011R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010E\u001a\u00020=8F¢\u0006\u0006\u001a\u0004\u0008F\u0010GR\u000e\u0010H\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010K\u001a\u00020A8F¢\u0006\u0006\u001a\u0004\u0008L\u0010\u0011R\u000e\u0010M\u001a\u00020NX\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010P\u001a\u00020O2\u0006\u0010\u0007\u001a\u00020O@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\u0008Q\u0010\u0011\"\u0004\u0008R\u0010\u0013R(\u0010U\u001a\u0004\u0018\u00010T2\u0008\u0010\u0007\u001a\u0004\u0018\u00010T8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008V\u0010W\"\u0004\u0008X\u0010YR$\u0010Z\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u00088F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008[\u0010\u000b\"\u0004\u0008\\\u0010\rR$\u0010]\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u00088F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008^\u0010\u000b\"\u0004\u0008_\u0010\rR$\u0010`\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u00088F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008a\u0010\u000b\"\u0004\u0008b\u0010\rR\u0010\u0010c\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010e\u001a\u00020fX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010SR\u0016\u0010g\u001a\u00020OX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010SR$\u0010h\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u00088F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008i\u0010\u000b\"\u0004\u0008j\u0010\rR$\u0010k\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u00088F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008l\u0010\u000b\"\u0004\u0008m\u0010\rR$\u0010n\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u00088F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008o\u0010\u000b\"\u0004\u0008p\u0010\rR,\u0010r\u001a\u00020q2\u0006\u0010\u0007\u001a\u00020q@BX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\u0008s\u0010\u0011\"\u0004\u0008t\u0010\u0013R\u0010\u0010u\u001a\u0004\u0018\u00010vX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010w\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e8F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008x\u0010\u0011\"\u0004\u0008y\u0010\u0013R,\u0010{\u001a\u00020z2\u0006\u0010\u0007\u001a\u00020z@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\u0008|\u0010\u0011\"\u0004\u0008}\u0010\u0013R%\u0010~\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u00088F@FX\u0086\u000e¢\u0006\r\u001a\u0004\u0008\u007f\u0010\u000b\"\u0005\u0008\u0080\u0001\u0010\rR'\u0010\u0081\u0001\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u00088F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008\u0082\u0001\u0010\u000b\"\u0005\u0008\u0083\u0001\u0010\rR\u000f\u0010\u0084\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006·\u0001", d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "", "impl", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "layerManager", "Landroidx/compose/ui/graphics/layer/LayerManager;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;Landroidx/compose/ui/graphics/layer/LayerManager;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "androidOutline", "Landroid/graphics/Outline;", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "cameraDistance", "getCameraDistance", "setCameraDistance", "childDependenciesTracker", "Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "", "clip", "getClip$annotations", "()V", "getClip", "()Z", "setClip", "(Z)V", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", "density", "Landroidx/compose/ui/unit/Density;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "getImpl$ui_graphics_release", "()Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "internalOutline", "Landroidx/compose/ui/graphics/Outline;", "<set-?>", "isReleased", "layerId", "", "getLayerId", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outline", "getOutline", "()Landroidx/compose/ui/graphics/Outline;", "outlineDirty", "outlinePath", "Landroidx/compose/ui/graphics/Path;", "ownerViewId", "getOwnerViewId", "parentLayerUsages", "", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "J", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "roundRectClipPath", "roundRectCornerRadius", "roundRectOutlineSize", "Landroidx/compose/ui/geometry/Size;", "roundRectOutlineTopLeft", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "Landroidx/compose/ui/unit/IntSize;", "size", "getSize-YbymL2g", "setSize-ozmzZPI", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "Landroidx/compose/ui/unit/IntOffset;", "topLeft", "getTopLeft-nOcc-ac", "setTopLeft--gyyYBs", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "usePathForClip", "addSubLayer", "graphicsLayer", "configureOutline", "discardContentIfReleasedAndHaveNoParentLayerUsages", "discardDisplayList", "discardDisplayList$ui_graphics_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "parentLayer", "draw$ui_graphics_release", "drawForPersistence", "drawForPersistence$ui_graphics_release", "emulateTrimMemory", "emulateTrimMemory$ui_graphics_release", "obtainAndroidOutline", "onAddedToParentLayer", "onRemovedFromParentLayer", "record", "block", "record-mL-hObY", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;JLkotlin/jvm/functions/Function1;)V", "recordInternal", "recreateDisplayListIfNeeded", "release", "release$ui_graphics_release", "resetOutlineParams", "resolveOutlinePosition", "T", "Lkotlin/Function2;", "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "setPathOutline", "path", "setPosition", "setPosition-VbeCjmY", "(JJ)V", "setRectOutline", "setRectOutline-tz77jQw", "setRoundRectOutline", "cornerRadius", "setRoundRectOutline-TNW_H78", "(JJF)V", "toImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformCanvas", "androidCanvas", "Landroid/graphics/Canvas;", "updatePathOutline", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GraphicsLayer {

    public static final androidx.compose.ui.graphics.layer.GraphicsLayer.Companion Companion;
    private static final androidx.compose.ui.graphics.layer.LayerSnapshotImpl SnapshotImpl;
    private Outline androidOutline;
    private final androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker childDependenciesTracker;
    private Density density;
    private Function1<? super DrawScope, Unit> drawBlock;
    private final androidx.compose.ui.graphics.layer.GraphicsLayerImpl impl;
    private Outline internalOutline;
    private boolean isReleased;
    private final androidx.compose.ui.graphics.layer.LayerManager layerManager;
    private LayoutDirection layoutDirection;
    private boolean outlineDirty = true;
    private Path outlinePath;
    private int parentLayerUsages;
    private long pivotOffset;
    private Path roundRectClipPath;
    private float roundRectCornerRadius;
    private long roundRectOutlineSize;
    private long roundRectOutlineTopLeft;
    private long size;
    private Paint softwareLayerPaint;
    private long topLeft;
    private boolean usePathForClip;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayer$Companion;", "", "()V", "SnapshotImpl", "Landroidx/compose/ui/graphics/layer/LayerSnapshotImpl;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        GraphicsLayer.Companion companion = new GraphicsLayer.Companion(0);
        GraphicsLayer.Companion = companion;
        GraphicsLayer.SnapshotImpl = (LayerSnapshotImpl)LayerSnapshotV28.INSTANCE;
    }

    public GraphicsLayer(androidx.compose.ui.graphics.layer.GraphicsLayerImpl impl, androidx.compose.ui.graphics.layer.LayerManager layerManager) {
        super();
        this.impl = impl;
        this.layerManager = layerManager;
        this.density = DrawContextKt.getDefaultDensity();
        this.layoutDirection = LayoutDirection.Ltr;
        this.drawBlock = (Function1)GraphicsLayer.drawBlock.1.INSTANCE;
        int i = 1;
        this.roundRectOutlineTopLeft = Offset.Companion.getZero-F1C5BW0();
        this.roundRectOutlineSize = Size.Companion.getUnspecified-NH-jbRc();
        ChildLayerDependenciesTracker childLayerDependenciesTracker = new ChildLayerDependenciesTracker();
        this.childDependenciesTracker = childLayerDependenciesTracker;
        this.impl.setClip(false);
        this.topLeft = IntOffset.Companion.getZero-nOcc-ac();
        this.size = IntSize.Companion.getZero-YbymL2g();
        this.pivotOffset = Offset.Companion.getUnspecified-F1C5BW0();
    }

    private final void addSubLayer(androidx.compose.ui.graphics.layer.GraphicsLayer graphicsLayer) {
        if (this.childDependenciesTracker.onDependencyAdded(graphicsLayer)) {
            graphicsLayer.onAddedToParentLayer();
        }
    }

    private final void configureOutline() {
        boolean outlineDirty;
        boolean clip;
        Object pathOutline;
        int i2;
        int outlinePath;
        Object androidOutline;
        int i;
        float alpha;
        long l4;
        int rRectSize$iv;
        int i4;
        float roundRectCornerRadius;
        int i5;
        Object obj;
        int i3;
        long size-ozmzZPI;
        long l;
        long l5;
        long l6;
        long l2;
        int $this$fastRoundToInt$iv2;
        int $this$fastRoundToInt$iv;
        long $i$f$fastRoundToInt;
        long l3;
        final Object obj2 = this;
        final int i6 = 0;
        if (obj2.outlineDirty) {
            if (!obj2.getClip()) {
                if (Float.compare(shadowElevation, outlinePath) > 0) {
                    outlineDirty = i2;
                } else {
                    outlineDirty = i6;
                }
            } else {
            }
            if (outlineDirty == 0) {
                obj2.impl.setOutline(0);
            } else {
                outlinePath = obj2.outlinePath;
                if (outlinePath != null) {
                    pathOutline = obj2.updatePathOutline(outlinePath);
                    i = 0;
                    pathOutline.setAlpha(obj2.getAlpha());
                    obj2.impl.setOutline(pathOutline);
                } else {
                    androidOutline = obj2.obtainAndroidOutline();
                    i5 = 0;
                    obj = this;
                    i3 = 0;
                    long roundRectOutlineTopLeft = obj.roundRectOutlineTopLeft;
                    long roundRectOutlineSize = obj.roundRectOutlineSize;
                    int i8 = 0;
                    if (Long.compare(l7, l8) == 0) {
                    } else {
                        i2 = i6;
                    }
                    l = i2 != 0 ? size-ozmzZPI : roundRectOutlineSize;
                    l5 = roundRectOutlineTopLeft;
                    l6 = l;
                    int i7 = 0;
                    int i9 = 0;
                    int i10 = 0;
                    int i12 = 0;
                    int i14 = 0;
                    $i$f$fastRoundToInt = roundRectOutlineTopLeft;
                    l2 = l3;
                    androidOutline.setRoundRect(Math.round(Offset.getX-impl(l5)), Math.round(Offset.getY-impl(l5)), Math.round(x-impl2 += width-impl), Math.round(y-impl2 += height-impl), obj2.roundRectCornerRadius);
                    i = 0;
                    androidOutline.setAlpha(obj2.getAlpha());
                    obj2.impl.setOutline(androidOutline);
                }
            }
        }
        obj2.outlineDirty = i6;
    }

    private final void discardContentIfReleasedAndHaveNoParentLayerUsages() {
        boolean parentLayerUsages;
        if (this.isReleased && this.parentLayerUsages == 0) {
            if (this.parentLayerUsages == 0) {
                if (this.layerManager != null) {
                    this.layerManager.release(this);
                } else {
                    discardDisplayList$ui_graphics_release();
                }
            }
        }
    }

    public static void getClip$annotations() {
    }

    private final Outline obtainAndroidOutline() {
        Outline androidOutline;
        Outline outline;
        int i;
        if (this.androidOutline == null) {
            androidOutline = new Outline();
            i = 0;
            this.androidOutline = androidOutline;
        }
        return androidOutline;
    }

    private final void onAddedToParentLayer() {
        this.parentLayerUsages = parentLayerUsages++;
    }

    private final void onRemovedFromParentLayer() {
        this.parentLayerUsages = parentLayerUsages--;
        discardContentIfReleasedAndHaveNoParentLayerUsages();
    }

    private final void recordInternal() {
        Object cmp;
        androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker childDependenciesTracker;
        int j$iv$iv$iv;
        int i4;
        int $i$f$isFull;
        boolean mutableScatterSetOf;
        MutableScatterSet set2;
        Density density;
        int i3;
        boolean layoutDirection;
        Function1 drawBlock;
        Object[] elements;
        MutableScatterSet set;
        int i5;
        long[] metadata;
        int i2;
        int i$iv$iv$iv;
        long slot$iv$iv$iv;
        androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker this_$iv;
        int i6;
        int i7;
        long cmp2;
        int i;
        cmp = this;
        childDependenciesTracker = cmp.childDependenciesTracker;
        final int i15 = 0;
        ChildLayerDependenciesTracker.access$setOldDependency$p(childDependenciesTracker, ChildLayerDependenciesTracker.access$getDependency$p(childDependenciesTracker));
        MutableScatterSet set3 = ChildLayerDependenciesTracker.access$getDependenciesSet$p(childDependenciesTracker);
        i4 = 0;
        if (set3 != null && set3.isNotEmpty() && ChildLayerDependenciesTracker.access$getOldDependenciesSet$p(childDependenciesTracker) == null) {
            i4 = 0;
            if (set3.isNotEmpty()) {
                if (ChildLayerDependenciesTracker.access$getOldDependenciesSet$p(childDependenciesTracker) == null) {
                    i3 = 0;
                    ChildLayerDependenciesTracker.access$setOldDependenciesSet$p(childDependenciesTracker, ScatterSetKt.mutableScatterSetOf());
                }
                mutableScatterSetOf.addAll((ScatterSet)set3);
                set3.clear();
            }
        }
        ChildLayerDependenciesTracker.access$setTrackingInProgress$p(childDependenciesTracker, true);
        int i16 = 0;
        cmp.impl.record(cmp.density, cmp.layoutDirection, cmp, cmp.drawBlock);
        ChildLayerDependenciesTracker.access$setTrackingInProgress$p(childDependenciesTracker, false);
        androidx.compose.ui.graphics.layer.GraphicsLayer graphicsLayer2 = ChildLayerDependenciesTracker.access$getOldDependency$p(childDependenciesTracker);
        if (graphicsLayer2 != null) {
            density = 0;
            graphicsLayer2.onRemovedFromParentLayer();
        }
        MutableScatterSet set4 = ChildLayerDependenciesTracker.access$getOldDependenciesSet$p(childDependenciesTracker);
        if (set4 != null) {
            density = 0;
            if (set4.isNotEmpty()) {
                layoutDirection = set4;
                drawBlock = 0;
                i5 = 0;
                metadata = set.metadata;
                length += -2;
                if (0 <= i2) {
                } else {
                    this_$iv = childDependenciesTracker;
                }
                set4.clear();
            } else {
                this_$iv = childDependenciesTracker;
            }
        } else {
            this_$iv = childDependenciesTracker;
        }
    }

    private final void recreateDisplayListIfNeeded() {
        boolean hasDisplayList;
        if (!this.impl.getHasDisplayList()) {
            recordInternal();
        }
    }

    private final void resetOutlineParams() {
        int i = 0;
        this.internalOutline = i;
        this.outlinePath = i;
        this.roundRectOutlineSize = Size.Companion.getUnspecified-NH-jbRc();
        this.roundRectOutlineTopLeft = Offset.Companion.getZero-F1C5BW0();
        this.roundRectCornerRadius = 0;
        this.outlineDirty = true;
        this.usePathForClip = false;
    }

    private final <T> T resolveOutlinePosition(Function2<? super Offset, ? super Size, ? extends T> block) {
        long l;
        int i;
        final int i2 = 0;
        final long roundRectOutlineSize = this.roundRectOutlineSize;
        int i3 = 0;
        i = Long.compare(l2, l3) == 0 ? 1 : 0;
        l = i != 0 ? size-ozmzZPI : roundRectOutlineSize;
        return block.invoke(Offset.box-impl(this.roundRectOutlineTopLeft), Size.box-impl(l));
    }

    private final void setPosition-VbeCjmY(long topLeft, long size) {
        this.impl.setPosition-H0pRuoY(IntOffset.getX-impl(topLeft), IntOffset.getY-impl(topLeft), obj6);
    }

    public static void setRectOutline-tz77jQw$default(androidx.compose.ui.graphics.layer.GraphicsLayer graphicsLayer, long l2, long l3, int i4, Object object5) {
        long obj1;
        long obj3;
        if (obj5 & 1 != 0) {
            obj1 = Offset.Companion.getZero-F1C5BW0();
        }
        if (obj5 &= 2 != 0) {
            obj3 = Size.Companion.getUnspecified-NH-jbRc();
        }
        graphicsLayer.setRectOutline-tz77jQw(obj1, l3);
    }

    public static void setRoundRectOutline-TNW_H78$default(androidx.compose.ui.graphics.layer.GraphicsLayer graphicsLayer, long l2, long l3, float f4, int i5, Object object6) {
        long l4;
        long l;
        int i;
        long obj7;
        long obj9;
        int obj11;
        if (obj12 & 1 != 0) {
            l4 = obj7;
        } else {
            l4 = l2;
        }
        if (obj12 & 2 != 0) {
            l = obj9;
        } else {
            l = f4;
        }
        i = obj12 & 4 != 0 ? obj11 : object6;
        graphicsLayer.setRoundRectOutline-TNW_H78(l4, obj2, l);
    }

    private final void setSize-ozmzZPI(long value) {
        boolean roundRectOutlineSize;
        int i2;
        int i;
        int i3;
        if (!IntSize.equals-impl0(this.size, obj1)) {
            this.size = value;
            setPosition-VbeCjmY(this.topLeft, obj1);
            i2 = 0;
            i3 = 1;
            i = Long.compare(roundRectOutlineSize, l) == 0 ? i3 : 0;
            if (i != 0) {
                this.outlineDirty = i3;
                configureOutline();
            }
        }
    }

    private final void transformCanvas(Canvas androidCanvas) {
        int i;
        long androidCanvas2;
        Paint softwareLayerPaint;
        int cmp;
        long offscreen-ke2Ky5w;
        Paint paint;
        final float f5 = (float)x-impl;
        final float f6 = (float)y-impl;
        float f3 = (float)width-impl;
        float alpha = getAlpha();
        final ColorFilter colorFilter = getColorFilter();
        final int blendMode-0nO6VwU = getBlendMode-0nO6VwU();
        if (Float.compare(alpha, i2) >= 0 && BlendMode.equals-impl0(blendMode-0nO6VwU, BlendMode.Companion.getSrcOver-0nO6VwU()) && colorFilter == null) {
            if (BlendMode.equals-impl0(blendMode-0nO6VwU, BlendMode.Companion.getSrcOver-0nO6VwU())) {
                if (colorFilter == null) {
                    if (CompositingStrategy.equals-impl0(getCompositingStrategy-ke2Ky5w(), CompositingStrategy.Companion.getOffscreen-ke2Ky5w())) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (i != 0) {
            if (this.softwareLayerPaint == null) {
                paint = 0;
                this.softwareLayerPaint = AndroidPaint_androidKt.Paint();
            }
            Paint it = softwareLayerPaint;
            int i6 = 0;
            it.setAlpha(alpha);
            it.setBlendMode-s9anfk8(blendMode-0nO6VwU);
            it.setColorFilter(colorFilter);
            androidCanvas.saveLayer(f5, f6, f + f3, f2 + f4, softwareLayerPaint.asFrameworkPaint());
        } else {
            androidCanvas.save();
        }
        androidCanvas2.translate(f5, f6);
        androidCanvas2.concat(this.impl.calculateMatrix());
    }

    private final Outline updatePathOutline(Path path) {
        Object iNSTANCE;
        int i;
        android.graphics.Path internalPath;
        final Outline androidOutline = obtainAndroidOutline();
        if (Build.VERSION.SDK_INT > 30) {
            OutlineVerificationHelper.INSTANCE.setPath(androidOutline, path);
            this.usePathForClip = clip ^= 1;
            this.outlinePath = path;
            return androidOutline;
        } else {
            iNSTANCE = path;
            i = 0;
            if (iNSTANCE instanceof AndroidPath == null) {
            } else {
                androidOutline.setConvexPath((AndroidPath)iNSTANCE.getInternalPath());
            }
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        throw unsupportedOperationException;
    }

    public final void discardDisplayList$ui_graphics_release() {
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i6;
        int j$iv$iv$iv;
        int i5;
        int i7;
        int i;
        Object[] elements;
        MutableScatterSet set;
        int i8;
        long[] metadata;
        int i10;
        int i$iv$iv$iv;
        long slot$iv$iv$iv;
        MutableScatterSet $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int i2;
        int i3;
        androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker this_$iv;
        int i9;
        long l;
        Object obj;
        int i4;
        final Object obj2 = this;
        $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = obj2.childDependenciesTracker;
        i6 = 0;
        androidx.compose.ui.graphics.layer.GraphicsLayer graphicsLayer = ChildLayerDependenciesTracker.access$getDependency$p($this$maskEmptyOrDeleted$iv$iv$iv$iv2);
        if (graphicsLayer != null) {
            i5 = 0;
            i = 0;
            graphicsLayer.onRemovedFromParentLayer();
            ChildLayerDependenciesTracker.access$setDependency$p($this$maskEmptyOrDeleted$iv$iv$iv$iv2, 0);
        }
        j$iv$iv$iv = ChildLayerDependenciesTracker.access$getDependenciesSet$p($this$maskEmptyOrDeleted$iv$iv$iv$iv2);
        if (j$iv$iv$iv != null) {
            i7 = j$iv$iv$iv;
            i = 0;
            i8 = 0;
            metadata = set.metadata;
            length += -2;
            if (0 <= i10) {
            } else {
                this_$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
                i9 = i6;
                $this$maskEmptyOrDeleted$iv$iv$iv$iv = j$iv$iv$iv;
                i2 = i5;
            }
            $this$maskEmptyOrDeleted$iv$iv$iv$iv.clear();
        } else {
            this_$iv = $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
            i9 = i6;
        }
        obj2.impl.discardDisplayList();
    }

    public final void draw$ui_graphics_release(Canvas canvas, androidx.compose.ui.graphics.layer.GraphicsLayer parentLayer) {
        int i;
        int i3;
        boolean usePathForClip;
        Path roundRectClipPath;
        int i5;
        int i2;
        Path path;
        androidx.compose.ui.geometry.RoundRect roundRect;
        int i4;
        if (this.isReleased) {
        }
        recreateDisplayListIfNeeded();
        configureOutline();
        i3 = 1;
        int i7 = 0;
        i = Float.compare(shadowElevation, i6) > 0 ? i3 : i7;
        if (i != 0) {
            canvas.enableZ();
        }
        final Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        hardwareAccelerated ^= i3;
        if (i8 != 0) {
            nativeCanvas.save();
            transformCanvas(nativeCanvas);
        }
        if (!this.usePathForClip) {
            if (i8 != 0 && getClip()) {
                if (getClip()) {
                } else {
                    i3 = i7;
                }
            } else {
            }
        }
        if (i3 != 0) {
            canvas.save();
            usePathForClip = getOutline();
            i5 = 2;
            i2 = 0;
            if (usePathForClip instanceof Outline.Rectangle) {
                Canvas.clipRect-mtrdD-E$default(canvas, usePathForClip.getBounds(), i7, i5, i2);
            } else {
                if (usePathForClip instanceof Outline.Rounded) {
                    roundRectClipPath = this.roundRectClipPath;
                    if (roundRectClipPath != null) {
                        i4 = 0;
                        roundRectClipPath.rewind();
                    } else {
                        i4 = 0;
                        this.roundRectClipPath = AndroidPath_androidKt.Path();
                    }
                    Path.addRoundRect$default(roundRectClipPath, (Outline.Rounded)usePathForClip.getRoundRect(), i2, i5, i2);
                    Canvas.clipPath-mtrdD-E$default(canvas, roundRectClipPath, i7, i5, i2);
                } else {
                    if (usePathForClip instanceof Outline.Generic) {
                        Canvas.clipPath-mtrdD-E$default(canvas, (Outline.Generic)usePathForClip.getPath(), i7, i5, i2);
                    }
                }
            }
        }
        if (parentLayer != null) {
            parentLayer.addSubLayer(this);
        }
        this.impl.draw(canvas);
        if (i3 != 0) {
            canvas.restore();
        }
        if (i != 0) {
            canvas.disableZ();
        }
        if (i8 != 0) {
            nativeCanvas.restore();
        }
    }

    public final void drawForPersistence$ui_graphics_release(Canvas canvas) {
        boolean hardwareAccelerated;
        if (AndroidCanvas_androidKt.getNativeCanvas(canvas).isHardwareAccelerated()) {
            recreateDisplayListIfNeeded();
            this.impl.draw(canvas);
        }
    }

    public final void emulateTrimMemory$ui_graphics_release() {
        this.impl.discardDisplayList();
    }

    public final float getAlpha() {
        return this.impl.getAlpha();
    }

    public final long getAmbientShadowColor-0d7_KjU() {
        return this.impl.getAmbientShadowColor-0d7_KjU();
    }

    public final int getBlendMode-0nO6VwU() {
        return this.impl.getBlendMode-0nO6VwU();
    }

    public final float getCameraDistance() {
        return this.impl.getCameraDistance();
    }

    public final boolean getClip() {
        return this.impl.getClip();
    }

    public final ColorFilter getColorFilter() {
        return this.impl.getColorFilter();
    }

    public final int getCompositingStrategy-ke2Ky5w() {
        return this.impl.getCompositingStrategy-ke2Ky5w();
    }

    public final androidx.compose.ui.graphics.layer.GraphicsLayerImpl getImpl$ui_graphics_release() {
        return this.impl;
    }

    public final long getLayerId() {
        return this.impl.getLayerId();
    }

    public final Outline getOutline() {
        Outline internalOutline;
        int cornerRadius;
        Path outlinePath;
        Outline rectangle;
        Outline generic;
        Outline.Generic $i$f$resolveOutlinePosition;
        int layerSize$iv;
        long l3;
        long roundRectOutlineTopLeft;
        long roundRectOutlineSize;
        long l2;
        long l4;
        int i5;
        long l5;
        int i3;
        float left;
        float y-impl;
        int i4;
        int i;
        long cmp;
        Outline outline;
        Path path;
        Object this_$iv;
        int i2;
        long l;
        final Object obj = this;
        internalOutline = obj.internalOutline;
        outlinePath = obj.outlinePath;
        if (internalOutline != null) {
            outline = generic;
            path = outlinePath;
        } else {
            if (outlinePath != null) {
                generic = new Outline.Generic(outlinePath);
                layerSize$iv = 0;
                obj.internalOutline = (Outline)generic;
                outline = internalOutline;
                path = outlinePath;
            } else {
                Object obj2 = this;
                int i6 = 0;
                long size-ozmzZPI = IntSizeKt.toSize-ozmzZPI(obj2.size);
                roundRectOutlineSize = obj2.roundRectOutlineSize;
                int i7 = 0;
                i5 = Long.compare(l6, l7) == 0 ? 1 : 0;
                l2 = i5 != 0 ? size-ozmzZPI : roundRectOutlineSize;
                l4 = roundRectOutlineTopLeft;
                l5 = l2;
                i3 = 0;
                float x-impl = Offset.getX-impl(l4);
                y-impl = Offset.getY-impl(l4);
                width-impl += x-impl;
                height-impl += y-impl;
                outline = internalOutline;
                float tmpOutline = obj.roundRectCornerRadius;
                path = outlinePath;
                if (Float.compare(tmpOutline, tmpPath) > 0) {
                    this_$iv = obj2;
                    i2 = i6;
                    l = size-ozmzZPI;
                    $i$f$resolveOutlinePosition = x-impl;
                    layerSize$iv = y-impl;
                    l3 = i4;
                    left = tmpOutline;
                    cornerRadius = i;
                    rectangle = new Outline.Rounded(RoundRectKt.RoundRect-gG7oq9Y(x-impl, y-impl, i4, i, CornerRadiusKt.CornerRadius$default(tmpOutline, 0, 2, 0)));
                    generic = rectangle;
                } else {
                    this_$iv = obj2;
                    i2 = i6;
                    l = size-ozmzZPI;
                    left = tmpOutline;
                    Rect rect = new Rect(x-impl, y-impl, i4, i);
                    rectangle = new Outline.Rectangle(rect);
                    generic = rectangle;
                }
                outlinePath = 0;
                obj.internalOutline = generic;
            }
        }
        return generic;
    }

    public final long getOwnerViewId() {
        return this.impl.getOwnerId();
    }

    public final long getPivotOffset-F1C5BW0() {
        return this.pivotOffset;
    }

    public final RenderEffect getRenderEffect() {
        return this.impl.getRenderEffect();
    }

    public final float getRotationX() {
        return this.impl.getRotationX();
    }

    public final float getRotationY() {
        return this.impl.getRotationY();
    }

    public final float getRotationZ() {
        return this.impl.getRotationZ();
    }

    public final float getScaleX() {
        return this.impl.getScaleX();
    }

    public final float getScaleY() {
        return this.impl.getScaleY();
    }

    public final float getShadowElevation() {
        return this.impl.getShadowElevation();
    }

    public final long getSize-YbymL2g() {
        return this.size;
    }

    public final long getSpotShadowColor-0d7_KjU() {
        return this.impl.getSpotShadowColor-0d7_KjU();
    }

    public final long getTopLeft-nOcc-ac() {
        return this.topLeft;
    }

    public final float getTranslationX() {
        return this.impl.getTranslationX();
    }

    public final float getTranslationY() {
        return this.impl.getTranslationY();
    }

    public final boolean isReleased() {
        return this.isReleased;
    }

    public final void record-mL-hObY(Density density, LayoutDirection layoutDirection, long size, Function1<? super DrawScope, Unit> block) {
        setSize-ozmzZPI(size);
        this.density = density;
        this.layoutDirection = layoutDirection;
        this.drawBlock = obj7;
        this.impl.setInvalidated(true);
        recordInternal();
    }

    public final void release$ui_graphics_release() {
        boolean isReleased;
        if (!this.isReleased) {
            this.isReleased = true;
            discardContentIfReleasedAndHaveNoParentLayerUsages();
        }
    }

    public final void setAlpha(float value) {
        int impl;
        impl = Float.compare(alpha, value) == 0 ? 1 : 0;
        if (impl == 0) {
            this.impl.setAlpha(value);
        }
    }

    public final void setAmbientShadowColor-8_81llA(long value) {
        boolean impl;
        if (!Color.equals-impl0(value, obj4)) {
            this.impl.setAmbientShadowColor-8_81llA(value);
        }
    }

    public final void setBlendMode-s9anfk8(int value) {
        boolean impl;
        if (!BlendMode.equals-impl0(this.impl.getBlendMode-0nO6VwU(), value)) {
            this.impl.setBlendMode-s9anfk8(value);
        }
    }

    public final void setCameraDistance(float value) {
        int impl;
        impl = Float.compare(cameraDistance, value) == 0 ? 1 : 0;
        if (impl == 0) {
            this.impl.setCameraDistance(value);
        }
    }

    public final void setClip(boolean value) {
        boolean clip;
        if (this.impl.getClip() != value) {
            this.impl.setClip(value);
            this.outlineDirty = true;
            configureOutline();
        }
    }

    public final void setColorFilter(ColorFilter value) {
        boolean equal;
        if (!Intrinsics.areEqual(this.impl.getColorFilter(), value)) {
            this.impl.setColorFilter(value);
        }
    }

    public final void setCompositingStrategy-Wpw9cng(int value) {
        boolean impl;
        if (!CompositingStrategy.equals-impl0(this.impl.getCompositingStrategy-ke2Ky5w(), value)) {
            this.impl.setCompositingStrategy-Wpw9cng(value);
        }
    }

    public final void setPathOutline(Path path) {
        resetOutlineParams();
        this.outlinePath = path;
        configureOutline();
    }

    public final void setPivotOffset-k-4lQ0M(long value) {
        boolean impl;
        if (!Offset.equals-impl0(this.pivotOffset, obj1)) {
            this.pivotOffset = value;
            this.impl.setPivotOffset-k-4lQ0M(value);
        }
    }

    public final void setRectOutline-tz77jQw(long topLeft, long size) {
        this.setRoundRectOutline-TNW_H78(topLeft, obj2, obj9);
    }

    public final void setRenderEffect(RenderEffect value) {
        boolean equal;
        if (!Intrinsics.areEqual(this.impl.getRenderEffect(), value)) {
            this.impl.setRenderEffect(value);
        }
    }

    public final void setRotationX(float value) {
        int impl;
        impl = Float.compare(rotationX, value) == 0 ? 1 : 0;
        if (impl == 0) {
            this.impl.setRotationX(value);
        }
    }

    public final void setRotationY(float value) {
        int impl;
        impl = Float.compare(rotationY, value) == 0 ? 1 : 0;
        if (impl == 0) {
            this.impl.setRotationY(value);
        }
    }

    public final void setRotationZ(float value) {
        int impl;
        impl = Float.compare(rotationZ, value) == 0 ? 1 : 0;
        if (impl == 0) {
            this.impl.setRotationZ(value);
        }
    }

    public final void setRoundRectOutline-TNW_H78(long topLeft, long size, float cornerRadius) {
        boolean outlinePath;
        if (Offset.equals-impl0(this.roundRectOutlineTopLeft, obj1) && Size.equals-impl0(this.roundRectOutlineSize, obj1)) {
            if (Size.equals-impl0(this.roundRectOutlineSize, obj1)) {
                outlinePath = Float.compare(roundRectCornerRadius, obj7) == 0 ? 1 : 0;
                if (outlinePath != null) {
                    if (this.outlinePath != null) {
                        resetOutlineParams();
                        this.roundRectOutlineTopLeft = topLeft;
                        this.roundRectOutlineSize = cornerRadius;
                        this.roundRectCornerRadius = obj7;
                        configureOutline();
                    }
                } else {
                }
            } else {
            }
        } else {
        }
    }

    public final void setScaleX(float value) {
        int impl;
        impl = Float.compare(scaleX, value) == 0 ? 1 : 0;
        if (impl == 0) {
            this.impl.setScaleX(value);
        }
    }

    public final void setScaleY(float value) {
        int impl;
        impl = Float.compare(scaleY, value) == 0 ? 1 : 0;
        if (impl == 0) {
            this.impl.setScaleY(value);
        }
    }

    public final void setShadowElevation(float value) {
        int impl;
        int i;
        boolean clip;
        final int i2 = 1;
        impl = Float.compare(shadowElevation, value) == 0 ? i2 : i;
        if (impl == 0) {
            this.impl.setShadowElevation(value);
            if (!getClip()) {
                if (Float.compare(value, i3) > 0) {
                    i = i2;
                }
            } else {
            }
            this.impl.setClip(i);
            this.outlineDirty = i2;
            configureOutline();
        }
    }

    public final void setSpotShadowColor-8_81llA(long value) {
        boolean impl;
        if (!Color.equals-impl0(value, obj4)) {
            this.impl.setSpotShadowColor-8_81llA(value);
        }
    }

    public final void setTopLeft--gyyYBs(long value) {
        boolean size;
        if (!IntOffset.equals-impl0(this.topLeft, obj1)) {
            this.topLeft = value;
            setPosition-VbeCjmY(value, obj4);
        }
    }

    public final void setTranslationX(float value) {
        int impl;
        impl = Float.compare(translationX, value) == 0 ? 1 : 0;
        if (impl == 0) {
            this.impl.setTranslationX(value);
        }
    }

    public final void setTranslationY(float value) {
        int impl;
        impl = Float.compare(translationY, value) == 0 ? 1 : 0;
        if (impl == 0) {
            this.impl.setTranslationY(value);
        }
    }

    public final Object toImageBitmap(Continuation<? super ImageBitmap> continuation) {
        boolean anon;
        int i;
        int i3;
        Object _this;
        androidx.compose.ui.graphics.layer.LayerSnapshotImpl snapshotImpl;
        int i2;
        Object obj6;
        anon = continuation;
        i3 = Integer.MIN_VALUE;
        if (continuation instanceof GraphicsLayer.toImageBitmap.1 && label &= i3 != 0) {
            anon = continuation;
            i3 = Integer.MIN_VALUE;
            if (label &= i3 != 0) {
                anon.label = obj6 -= i3;
            } else {
                anon = new GraphicsLayer.toImageBitmap.1(this, continuation);
            }
        } else {
        }
        obj6 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj6);
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                ResultKt.throwOnFailure(obj6);
                _this = obj6;
                break;
            default:
                obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj6;
        }
        return AndroidImageBitmap_androidKt.asImageBitmap((Bitmap)_this);
    }
}
