package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.BlendMode.Companion;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorFilter.Companion;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0008\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00080\u0007H\u0007¢\u0006\u0002\u0010\t\u001a$\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u001a*\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!\u001a\u0015\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010$\u001a\u0096\u0001\u0010\"\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u001e2\u0008\u0008\u0002\u0010(\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2@\u0010)\u001a<\u0012\u0013\u0012\u00110\u001e¢\u0006\u000c\u0008+\u0012\u0008\u0008(\u0012\u0004\u0008\u0008(\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\u000c\u0008+\u0012\u0008\u0008(\u0012\u0004\u0008\u0008(\u001f\u0012\u0004\u0012\u00020\u00030*¢\u0006\u0002\u0008,¢\u0006\u0002\u0008-H\u0007ø\u0001\u0000¢\u0006\u0004\u0008.\u0010/\u001a \u0001\u0010\"\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u001e2\u0008\u0008\u0002\u0010(\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u00100\u001a\u0002012@\u0010)\u001a<\u0012\u0013\u0012\u00110\u001e¢\u0006\u000c\u0008+\u0012\u0008\u0008(\u0012\u0004\u0008\u0008(\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\u000c\u0008+\u0012\u0008\u0008(\u0012\u0004\u0008\u0008(\u001f\u0012\u0004\u0012\u00020\u00030*¢\u0006\u0002\u0008,¢\u0006\u0002\u0008-H\u0007ø\u0001\u0000¢\u0006\u0004\u00082\u00103\u001aD\u00104\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u001b2\u0008\u0008\u0002\u0010(\u001a\u00020\u00012\u0008\u00106\u001a\u0004\u0018\u00010\u000b2\u0008\u0008\u0002\u00100\u001a\u000201H\u0000ø\u0001\u0000¢\u0006\u0004\u00087\u00108\u001a\u0014\u00109\u001a\u00020\u0019*\u00020\u00192\u0006\u0010:\u001a\u00020\u0005H\u0000\u001a&\u0010;\u001a\u00020\u0003*\u00020<2\u0017\u0010=\u001a\u0013\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00030>¢\u0006\u0002\u0008?H\u0082\u0008\u001a&\u0010@\u001a\u00020\u001b*\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\u0008A\u0010B\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006C", d2 = {"RootGroupName", "", "RenderVectorGroup", "", "group", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "configs", "", "Landroidx/compose/ui/graphics/vector/VectorConfig;", "(Landroidx/compose/ui/graphics/vector/VectorGroup;Ljava/util/Map;Landroidx/compose/runtime/Composer;II)V", "createColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "createColorFilter-xETnrds", "(JI)Landroidx/compose/ui/graphics/ColorFilter;", "createVectorPainterFromImageVector", "Landroidx/compose/ui/graphics/vector/VectorPainter;", "density", "Landroidx/compose/ui/unit/Density;", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "obtainViewportSize", "Landroidx/compose/ui/geometry/Size;", "defaultSize", "viewportWidth", "", "viewportHeight", "obtainViewportSize-Pq9zytI", "(JFF)J", "rememberVectorPainter", "image", "(Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/VectorPainter;", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "name", "content", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "rememberVectorPainter-mlNsNFs", "(FFFFLjava/lang/String;JILkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "autoMirror", "", "rememberVectorPainter-vIP8VLU", "(FFFFLjava/lang/String;JIZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "configureVectorPainter", "viewportSize", "intrinsicColorFilter", "configureVectorPainter-T4PVSW8", "(Landroidx/compose/ui/graphics/vector/VectorPainter;JJLjava/lang/String;Landroidx/compose/ui/graphics/ColorFilter;Z)Landroidx/compose/ui/graphics/vector/VectorPainter;", "createGroupComponent", "currentGroup", "mirror", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "obtainSizePx", "obtainSizePx-VpY3zN4", "(Landroidx/compose/ui/unit/Density;FF)J", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class VectorPainterKt {

    public static final String RootGroupName = "VectorRootGroup";
    public static final void RenderVectorGroup(androidx.compose.ui.graphics.vector.VectorGroup group, Map<String, ? extends androidx.compose.ui.graphics.vector.VectorConfig> configs, Composer $composer, int $changed, int i5) {
        Object configs4;
        int vectorNode;
        int $dirty3;
        Object obj2;
        Object anon;
        int i4;
        int configs3;
        Object obj4;
        boolean vectorNode2;
        int i6;
        boolean config2;
        Object anon2;
        int floatValue2;
        Object floatValue;
        float floatValue4;
        float floatValue3;
        int i7;
        int i2;
        Composer restartGroup;
        float f2;
        float config;
        Object configs2;
        Composer $dirty;
        int i3;
        int $dirty2;
        int i;
        float f;
        Object obj;
        Object obj3;
        Object obj26;
        int obj27;
        configs4 = group;
        final int i8 = $changed;
        final int i9 = i5;
        vectorNode = -446179233;
        restartGroup = $composer.startRestartGroup(vectorNode);
        ComposerKt.sourceInformation(restartGroup, "C(RenderVectorGroup)P(1):VectorPainter.kt#huu6hf");
        $dirty3 = $changed;
        if (i9 & 1 != 0) {
            $dirty3 |= 6;
        } else {
            if (i8 & 6 == 0) {
                i4 = restartGroup.changed(configs4) ? 4 : 2;
                $dirty3 |= i4;
            }
        }
        configs3 = i9 & 2;
        if (configs3 != 0) {
            $dirty3 |= 48;
            obj4 = configs;
        } else {
            if (i8 & 48 == 0) {
                i6 = restartGroup.changedInstance(configs) ? 32 : 16;
                $dirty3 |= i6;
            } else {
                obj4 = configs;
            }
        }
        if ($dirty3 & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (configs3 != 0) {
                    configs3 = MapsKt.emptyMap();
                } else {
                    configs3 = obj4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(vectorNode, $dirty3, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup (VectorPainter.kt:430)");
                }
                vectorNode = configs4.iterator();
                while (vectorNode.hasNext()) {
                    vectorNode2 = vectorNode.next();
                    if (vectorNode2 instanceof VectorPath != null) {
                    } else {
                    }
                    obj26 = vectorNode;
                    obj27 = $dirty3;
                    Object obj6 = configs3;
                    boolean z2 = vectorNode2;
                    if (z2 instanceof VectorGroup) {
                    } else {
                    }
                    $dirty = z2;
                    restartGroup.startReplaceGroup(-20402883);
                    restartGroup.endReplaceGroup();
                    configs4 = group;
                    vectorNode = obj26;
                    $dirty3 = obj27;
                    configs3 = configs2;
                    restartGroup.startReplaceGroup(-21815553);
                    ComposerKt.sourceInformation(restartGroup, "513@19224L88,479@17944L1368");
                    if ((VectorConfig)obj6.get((VectorGroup)z2.getName()) == null) {
                    }
                    VectorPainterKt.RenderVectorGroup.1 anon3 = new VectorPainterKt.RenderVectorGroup.1(z2, obj6);
                    $dirty = z2;
                    Object obj7 = obj9;
                    VectorComposeKt.Group((VectorGroup)z2.getName(), (Number)anon.getOrDefault((VectorProperty)VectorProperty.Rotation.INSTANCE, Float.valueOf((VectorGroup)z2.getRotation())).floatValue(), (Number)anon.getOrDefault((VectorProperty)VectorProperty.PivotX.INSTANCE, Float.valueOf((VectorGroup)z2.getPivotX())).floatValue(), (Number)anon.getOrDefault((VectorProperty)VectorProperty.PivotY.INSTANCE, Float.valueOf((VectorGroup)z2.getPivotY())).floatValue(), (Number)anon.getOrDefault((VectorProperty)VectorProperty.ScaleX.INSTANCE, Float.valueOf((VectorGroup)z2.getScaleX())).floatValue(), (Number)anon.getOrDefault((VectorProperty)VectorProperty.ScaleY.INSTANCE, Float.valueOf((VectorGroup)z2.getScaleY())).floatValue(), (Number)anon.getOrDefault((VectorProperty)VectorProperty.TranslateX.INSTANCE, Float.valueOf((VectorGroup)z2.getTranslationX())).floatValue(), (Number)anon.getOrDefault((VectorProperty)VectorProperty.TranslateY.INSTANCE, Float.valueOf((VectorGroup)z2.getTranslationY())).floatValue(), (List)anon.getOrDefault((VectorProperty)VectorProperty.PathData.INSTANCE, (VectorGroup)z2.getClipPathData()), (Function2)ComposableLambdaKt.rememberComposableLambda(1450046638, true, anon3, restartGroup, 54), restartGroup, 805306368, 0);
                    restartGroup.endReplaceGroup();
                    configs4 = group;
                    vectorNode = obj26;
                    $dirty3 = obj27;
                    configs3 = configs2;
                    anon = new VectorPainterKt.RenderVectorGroup.config.2();
                    restartGroup.startReplaceGroup(-23647808);
                    ComposerKt.sourceInformation(restartGroup, "434@16086L1719");
                    if ((VectorConfig)configs3.get((VectorPath)(VectorNode)vectorNode2.getName()) == null) {
                    }
                    obj = obj8;
                    $dirty = restartGroup;
                    boolean z = vectorNode2;
                    VectorComposeKt.Path-9cdaXJ4((List)anon2.getOrDefault((VectorProperty)VectorProperty.PathData.INSTANCE, (VectorPath)vectorNode2.getPathData()), (VectorPath)vectorNode2.getPathFillType-Rg-k1Os(), (VectorPath)vectorNode2.getName(), (Brush)anon2.getOrDefault((VectorProperty)VectorProperty.Fill.INSTANCE, (VectorPath)vectorNode2.getFill()), (Number)anon2.getOrDefault((VectorProperty)VectorProperty.FillAlpha.INSTANCE, Float.valueOf((VectorPath)vectorNode2.getFillAlpha())).floatValue(), (Brush)anon2.getOrDefault((VectorProperty)VectorProperty.Stroke.INSTANCE, (VectorPath)vectorNode2.getStroke()), (Number)anon2.getOrDefault((VectorProperty)VectorProperty.StrokeAlpha.INSTANCE, Float.valueOf((VectorPath)vectorNode2.getStrokeAlpha())).floatValue(), (Number)anon2.getOrDefault((VectorProperty)VectorProperty.StrokeLineWidth.INSTANCE, Float.valueOf((VectorPath)vectorNode2.getStrokeLineWidth())).floatValue(), (VectorPath)vectorNode2.getStrokeLineCap-KaPHkGw(), (VectorPath)vectorNode2.getStrokeLineJoin-LxFBmk8(), (VectorPath)vectorNode2.getStrokeLineMiter(), (Number)anon2.getOrDefault((VectorProperty)VectorProperty.TrimPathStart.INSTANCE, Float.valueOf((VectorPath)vectorNode2.getTrimPathStart())).floatValue(), (Number)anon2.getOrDefault((VectorProperty)VectorProperty.TrimPathEnd.INSTANCE, Float.valueOf((VectorPath)vectorNode2.getTrimPathEnd())).floatValue(), (Number)anon2.getOrDefault((VectorProperty)VectorProperty.TrimPathOffset.INSTANCE, Float.valueOf((VectorPath)vectorNode2.getTrimPathOffset())).floatValue(), $dirty, 0, 0, 0);
                    $dirty.endReplaceGroup();
                    vectorNode = obj26;
                    $dirty3 = obj27;
                    configs3 = obj5;
                    configs4 = group;
                    anon2 = new VectorPainterKt.RenderVectorGroup.config.1();
                }
                obj27 = $dirty3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = configs2;
            } else {
                restartGroup.skipToGroupEnd();
                obj27 = $dirty3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            vectorNode = new VectorPainterKt.RenderVectorGroup.2(group, obj4, i8, i9);
            endRestartGroup.updateScope((Function2)vectorNode);
        } else {
            obj2 = group;
        }
    }

    public static final androidx.compose.ui.graphics.vector.VectorPainter configureVectorPainter-T4PVSW8(androidx.compose.ui.graphics.vector.VectorPainter $this$configureVectorPainter_u2dT4PVSW8, long defaultSize, long viewportSize, String name, ColorFilter intrinsicColorFilter, boolean autoMirror) {
        final Object obj = $this$configureVectorPainter_u2dT4PVSW8;
        final int i = 0;
        obj.setSize-uvyYCjk$ui_release(defaultSize);
        obj.setAutoMirror$ui_release(obj9);
        obj.setIntrinsicColorFilter$ui_release(obj8);
        obj.setViewportSize-uvyYCjk$ui_release(name);
        obj.setName$ui_release(autoMirror);
        return $this$configureVectorPainter_u2dT4PVSW8;
    }

    public static androidx.compose.ui.graphics.vector.VectorPainter configureVectorPainter-T4PVSW8$default(androidx.compose.ui.graphics.vector.VectorPainter vectorPainter, long l2, long l3, String string4, ColorFilter colorFilter5, boolean z6, int i7, Object object8) {
        String str;
        int i;
        String obj13;
        str = obj16 & 4 != 0 ? obj13 : z6;
        i = obj16 & 16 != 0 ? obj13 : object8;
        return VectorPainterKt.configureVectorPainter-T4PVSW8(vectorPainter, l2, obj2, string4, obj4, str);
    }

    private static final ColorFilter createColorFilter-xETnrds(long tintColor, int tintBlendMode) {
        int tint-xETnrds;
        int i;
        final int i3 = 0;
        i = Long.compare(i2, i4) != 0 ? 1 : 0;
        if (i != 0) {
            tint-xETnrds = ColorFilter.Companion.tint-xETnrds(tintColor, tintBlendMode);
        } else {
            tint-xETnrds = 0;
        }
        return tint-xETnrds;
    }

    public static final androidx.compose.ui.graphics.vector.GroupComponent createGroupComponent(androidx.compose.ui.graphics.vector.GroupComponent $this$createGroupComponent, androidx.compose.ui.graphics.vector.VectorGroup currentGroup) {
        int index;
        androidx.compose.ui.graphics.vector.VectorNode vectorNode;
        androidx.compose.ui.graphics.vector.PathComponent groupComponent;
        androidx.compose.ui.graphics.vector.PathComponent pathComponent;
        int i;
        float trimPathOffset;
        index = 0;
        while (index < currentGroup.getSize()) {
            vectorNode = currentGroup.get(index);
            if (vectorNode instanceof VectorPath != null) {
            } else {
            }
            if (vectorNode instanceof VectorGroup) {
            }
            index++;
            groupComponent = new GroupComponent();
            androidx.compose.ui.graphics.vector.GroupComponent groupComponent2 = groupComponent;
            i = 0;
            groupComponent2.setName((VectorGroup)vectorNode.getName());
            groupComponent2.setRotation((VectorGroup)vectorNode.getRotation());
            groupComponent2.setScaleX((VectorGroup)vectorNode.getScaleX());
            groupComponent2.setScaleY((VectorGroup)vectorNode.getScaleY());
            groupComponent2.setTranslationX((VectorGroup)vectorNode.getTranslationX());
            groupComponent2.setTranslationY((VectorGroup)vectorNode.getTranslationY());
            groupComponent2.setPivotX((VectorGroup)vectorNode.getPivotX());
            groupComponent2.setPivotY((VectorGroup)vectorNode.getPivotY());
            groupComponent2.setClipPathData((VectorGroup)vectorNode.getClipPathData());
            VectorPainterKt.createGroupComponent(groupComponent2, (VectorGroup)vectorNode);
            $this$createGroupComponent.insertAt(index, (VNode)groupComponent);
            groupComponent = new PathComponent();
            androidx.compose.ui.graphics.vector.PathComponent pathComponent2 = groupComponent;
            i = 0;
            pathComponent2.setPathData((VectorPath)vectorNode.getPathData());
            pathComponent2.setPathFillType-oQ8Xj4U((VectorPath)vectorNode.getPathFillType-Rg-k1Os());
            pathComponent2.setName((VectorPath)vectorNode.getName());
            pathComponent2.setFill((VectorPath)vectorNode.getFill());
            pathComponent2.setFillAlpha((VectorPath)vectorNode.getFillAlpha());
            pathComponent2.setStroke((VectorPath)vectorNode.getStroke());
            pathComponent2.setStrokeAlpha((VectorPath)vectorNode.getStrokeAlpha());
            pathComponent2.setStrokeLineWidth((VectorPath)vectorNode.getStrokeLineWidth());
            pathComponent2.setStrokeLineCap-BeK7IIE((VectorPath)vectorNode.getStrokeLineCap-KaPHkGw());
            pathComponent2.setStrokeLineJoin-Ww9F2mQ((VectorPath)vectorNode.getStrokeLineJoin-LxFBmk8());
            pathComponent2.setStrokeLineMiter((VectorPath)vectorNode.getStrokeLineMiter());
            pathComponent2.setTrimPathStart((VectorPath)vectorNode.getTrimPathStart());
            pathComponent2.setTrimPathEnd((VectorPath)vectorNode.getTrimPathEnd());
            pathComponent2.setTrimPathOffset((VectorPath)vectorNode.getTrimPathOffset());
            $this$createGroupComponent.insertAt(index, (VNode)groupComponent);
        }
        return $this$createGroupComponent;
    }

    public static final androidx.compose.ui.graphics.vector.VectorPainter createVectorPainterFromImageVector(Density density, androidx.compose.ui.graphics.vector.ImageVector imageVector, androidx.compose.ui.graphics.vector.GroupComponent root) {
        final long sizePx-VpY3zN4 = VectorPainterKt.obtainSizePx-VpY3zN4(density, imageVector.getDefaultWidth-D9Ej5fM(), imageVector.getDefaultHeight-D9Ej5fM());
        float viewportHeight = imageVector.getViewportHeight();
        VectorPainter vectorPainter = new VectorPainter(root);
        return VectorPainterKt.configureVectorPainter-T4PVSW8(vectorPainter, sizePx-VpY3zN4, obj4, VectorPainterKt.obtainViewportSize-Pq9zytI(sizePx-VpY3zN4, obj4, imageVector.getViewportWidth()), obj6, imageVector.getName());
    }

    private static final void mirror(DrawScope $this$mirror, Function1<? super DrawScope, Unit> block) {
        Object obj3;
        final int i2 = 0;
        final Object obj = $this$mirror;
        final int i5 = 0;
        final Object obj2 = obj;
        final int i6 = 0;
        final DrawContext drawContext = obj2.getDrawContext();
        final int i7 = 0;
        drawContext.getCanvas().save();
        int i8 = 0;
        drawContext.getTransform().scale-0AR0LA0(-1082130432, 1065353216, obj.getCenter-F1C5BW0());
        block.invoke(obj2);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
    }

    private static final long obtainSizePx-VpY3zN4(Density $this$obtainSizePx_u2dVpY3zN4, float defaultWidth, float defaultHeight) {
        return SizeKt.Size($this$obtainSizePx_u2dVpY3zN4.toPx-0680j_4(defaultWidth), $this$obtainSizePx_u2dVpY3zN4.toPx-0680j_4(defaultHeight));
    }

    private static final long obtainViewportSize-Pq9zytI(long defaultSize, float viewportWidth, float viewportHeight) {
        float width-impl;
        float height-impl;
        if (Float.isNaN(viewportHeight)) {
            width-impl = Size.getWidth-impl(defaultSize);
        } else {
            width-impl = viewportHeight;
        }
        if (Float.isNaN(obj5)) {
            height-impl = Size.getHeight-impl(defaultSize);
        } else {
            height-impl = obj5;
        }
        return SizeKt.Size(width-impl, height-impl);
    }

    public static final androidx.compose.ui.graphics.vector.VectorPainter rememberVectorPainter(androidx.compose.ui.graphics.vector.ImageVector image, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object vectorPainterFromImageVector;
        int empty;
        androidx.compose.ui.graphics.vector.GroupComponent groupComponent;
        int $this$rememberVectorPainter_u24lambda_u245_u24lambda_u244;
        int i;
        androidx.compose.ui.graphics.vector.VectorGroup root;
        int i2 = 1413834416;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberVectorPainter)172@7145L7,174@7229L215:VectorPainter.kt#huu6hf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:171)");
        }
        int i3 = 6;
        int i4 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        Object this_$iv = consume;
        float density = (Density)this_$iv.getDensity();
        int i6 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, -1837470287, "CC(remember):VectorPainter.kt#9igjgp");
        Composer composer = $composer;
        final int i8 = 0;
        Object rememberedValue = composer.rememberedValue();
        final int i9 = 0;
        if (!$composer.changed(empty | $this$rememberVectorPainter_u24lambda_u245_u24lambda_u244)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                int i11 = 0;
                groupComponent = new GroupComponent();
                i = 0;
                VectorPainterKt.createGroupComponent(groupComponent, image.getRoot());
                $this$rememberVectorPainter_u24lambda_u245_u24lambda_u244 = Unit.INSTANCE;
                composer.updateRememberedValue(VectorPainterKt.createVectorPainterFromImageVector(this_$iv, image, groupComponent));
            } else {
                vectorPainterFromImageVector = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (VectorPainter)vectorPainterFromImageVector;
    }

    @Deprecated(message = "Replace rememberVectorPainter graphicsLayer that consumes the auto mirror flag", replaceWith = @ReplaceWith(...))
    public static final androidx.compose.ui.graphics.vector.VectorPainter rememberVectorPainter-mlNsNFs(float defaultWidth, float defaultHeight, float viewportWidth, float viewportHeight, String name, long tintColor, int tintBlendMode, Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        int i3;
        int i2;
        String str;
        int unspecified-0d7_KjU;
        int srcIn-0nO6VwU;
        boolean traceInProgress;
        String str2;
        int i4;
        int i5;
        String str3;
        long l;
        int i;
        final int i6 = i11;
        int i7 = -964365210;
        final Composer composer = $changed;
        ComposerKt.sourceInformationMarkerStart(composer, i7, "C(rememberVectorPainter)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp,7,6,3,5:c#ui.graphics.Color,4:c#ui.graphics.BlendMode)86@3732L207:VectorPainter.kt#huu6hf");
        i4 = obj27 & 4 != 0 ? i3 : viewportWidth;
        i5 = obj27 & 8 != 0 ? i2 : viewportHeight;
        str3 = obj27 & 16 != 0 ? str : name;
        if (obj27 & 32 != 0) {
            l = unspecified-0d7_KjU;
        } else {
            l = tintColor;
        }
        if (obj27 & 64 != 0) {
            i = srcIn-0nO6VwU;
        } else {
            i = content;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i7, i6, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:86)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
        return VectorPainterKt.rememberVectorPainter-vIP8VLU(defaultWidth, defaultHeight, i4, i5, str3, l, obj9, i, 0, $composer, composer, i16 | i28);
    }

    public static final androidx.compose.ui.graphics.vector.VectorPainter rememberVectorPainter-vIP8VLU(float defaultWidth, float defaultHeight, float viewportWidth, float viewportHeight, String name, long tintColor, int tintBlendMode, boolean autoMirror, Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i12) {
        int i3;
        Object it$iv2;
        int i7;
        int i2;
        int i6;
        Composition it$iv;
        int changed3;
        Composer composer;
        int composableLambdaInstance;
        int i5;
        int i;
        boolean traceInProgress;
        boolean changed;
        Object obj;
        int i8;
        androidx.compose.runtime.CompositionContext compositionContext;
        int changed4;
        int viewportWidth2;
        int viewportHeight2;
        int str3;
        long tintColor2;
        Object empty2;
        Object vectorPainter;
        int tintBlendMode2;
        String str;
        Object colorFilter-xETnrds;
        float empty;
        String str2;
        int changed2;
        int i4;
        Composer.Companion companion;
        boolean companion2;
        Composer.Companion composition$ui_release;
        boolean disposed;
        Object obj29;
        Object obj30;
        int obj34;
        composer = $changed;
        composableLambdaInstance = i12;
        int i22 = obj34;
        int i28 = 1068590786;
        ComposerKt.sourceInformationMarkerStart(composer, i28, "C(rememberVectorPainter)P(3:c#ui.unit.Dp,2:c#ui.unit.Dp,8,7,4,6:c#ui.graphics.Color,5:c#ui.graphics.BlendMode)131@5630L7,134@5823L94:VectorPainter.kt#huu6hf");
        viewportWidth2 = i22 & 4 != 0 ? 0x7fc00000 /* Unknown resource */ : viewportWidth;
        viewportHeight2 = i22 & 8 != 0 ? 0x7fc00000 /* Unknown resource */ : viewportHeight;
        str2 = i22 & 16 != 0 ? str3 : name;
        if (i22 & 32 != 0) {
            tintColor2 = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            tintColor2 = tintColor;
        }
        if (i22 & 64 != 0) {
            tintBlendMode2 = BlendMode.Companion.getSrcIn-0nO6VwU();
        } else {
            tintBlendMode2 = autoMirror;
        }
        i4 = i22 &= 128 != 0 ? i : content;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i28, composableLambdaInstance, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:130)");
        }
        int i29 = 6;
        int i39 = 0;
        final String str6 = "CC:CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, str6);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Object this_$iv = consume;
        float f = defaultWidth;
        final Object obj24 = this_$iv;
        long density = sizePx-VpY3zN4;
        long viewportSize-Pq9zytI = VectorPainterKt.obtainViewportSize-Pq9zytI(density, f, viewportWidth2);
        String defaultSize = "CC(remember):VectorPainter.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer, -1837515400, defaultSize);
        int i44 = 196608;
        int i45 = 131072;
        if (i31 ^= i44 > i45) {
            if (!composer.changed(tintColor2)) {
                i8 = composableLambdaInstance & obj27 == i45 ? 1 : 0;
            } else {
            }
        } else {
        }
        int i49 = 1572864;
        int i9 = 1048576;
        if (i47 ^= i49 > i9) {
            if (!composer.changed(tintBlendMode2)) {
                i3 = composableLambdaInstance & i49 == i9 ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer3 = $changed;
        int i48 = 0;
        Object rememberedValue = composer3.rememberedValue();
        int i50 = 0;
        if (i3 |= i8 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                int i41 = 0;
                composer3.updateRememberedValue(VectorPainterKt.createColorFilter-xETnrds(tintColor2, obj8));
            } else {
                colorFilter-xETnrds = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.startReplaceGroup(-1837510348);
        ComposerKt.sourceInformation(composer, "*137@5929L28,145@6235L28,146@6291L487");
        ComposerKt.sourceInformationMarkerStart(composer, -1837512074, defaultSize);
        Composer composer4 = $changed;
        obj29 = i14;
        it$iv2 = composer4.rememberedValue();
        int i51 = 0;
        final long l = tintColor2;
        if (it$iv2 == Composer.Companion.getEmpty()) {
            obj30 = it$iv2;
            it$iv2 = 0;
            obj34 = i36;
            vectorPainter = new VectorPainter(it$iv2, 1, it$iv2);
            composer4.updateRememberedValue(vectorPainter);
        } else {
            vectorPainter = obj30;
        }
        Object obj2 = vectorPainter;
        ComposerKt.sourceInformationMarkerEnd(composer);
        Object obj3 = obj2;
        int i37 = tintBlendMode2;
        VectorPainterKt.configureVectorPainter-T4PVSW8(obj3, density, 0, viewportSize-Pq9zytI, str6, str2);
        final int obj26 = i32;
        compositionContext = ComposablesKt.rememberCompositionContext(composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 904082560, defaultSize);
        int i23 = 256;
        if (i17 ^= 384 > i23) {
            if (!composer.changed(viewportWidth2)) {
                i7 = composableLambdaInstance & 384 == i23 ? 1 : 0;
            } else {
            }
        } else {
        }
        int i18 = 2048;
        if (i24 ^= 3072 > i18) {
            if (!composer.changed(viewportHeight2)) {
                i2 = composableLambdaInstance & 3072 == i18 ? 1 : 0;
            } else {
            }
        } else {
        }
        int i52 = 100663296;
        int i20 = 67108864;
        if (i26 ^= i52 > i20) {
            if (!composer.changed($composer)) {
                i6 = composableLambdaInstance & i52 == i20 ? 1 : 0;
            } else {
            }
        } else {
            obj = $composer;
        }
        Composer composer2 = $changed;
        int i53 = 0;
        it$iv = composer2.rememberedValue();
        int i54 = 0;
        if (obj29 | i6 == 0) {
            if (it$iv == Composer.Companion.getEmpty()) {
                i5 = 0;
                composition$ui_release = obj3.getComposition$ui_release();
                if (composition$ui_release != null) {
                    if (composition$ui_release.isDisposed()) {
                        obj29 = it$iv;
                        obj30 = i5;
                        VectorApplier it$iv3 = new VectorApplier((VNode)obj3.getVector$ui_release().getRoot());
                        it$iv = CompositionKt.Composition((Applier)it$iv3, compositionContext);
                    } else {
                        obj29 = it$iv;
                        obj30 = i5;
                        it$iv = composition$ui_release;
                    }
                } else {
                }
                VectorPainterKt.rememberVectorPainter.2.1.1 anon = new VectorPainterKt.rememberVectorPainter.2.1.1(obj, viewportSize-Pq9zytI, str6);
                obj34 = compositionContext;
                it$iv.setContent((Function2)ComposableLambdaKt.composableLambdaInstance(-824421385, true, anon));
                composer2.updateRememberedValue(it$iv);
            } else {
                obj29 = it$iv;
                obj34 = compositionContext;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
        obj3.setComposition$ui_release((Composition)it$iv);
        $changed.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
        return (VectorPainter)obj2;
    }
}
