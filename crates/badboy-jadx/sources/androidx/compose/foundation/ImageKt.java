package androidx.compose.foundation;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.FilterQuality.Companion;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope.Companion;
import androidx.compose.ui.graphics.painter.BitmapPainterKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ContentScale.Companion;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001ab\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0017\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u001a\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"Image", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "Image-5h-nEew", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ImageKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Consider usage of the Image composable that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(...))
    public static final void Image(ImageBitmap bitmap, String contentDescription, Modifier modifier, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, Composer $composer, int $changed, int i10) {
        androidx.compose.ui.Modifier.Companion companion;
        Alignment center;
        ContentScale fit;
        int i;
        int i2;
        boolean traceInProgress;
        String str;
        androidx.compose.ui.Modifier.Companion companion2;
        Alignment alignment2;
        ContentScale contentScale2;
        int i3;
        int i4;
        final int i5 = $changed;
        int i6 = -2123228673;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i6, "C(Image)P(2,4,6!1,5)96@4585L177:Image.kt#71ulvw");
        if (i10 & 4 != 0) {
            companion2 = companion;
        } else {
            companion2 = modifier;
        }
        if (i10 & 8 != 0) {
            alignment2 = center;
        } else {
            alignment2 = alignment;
        }
        if (i10 & 16 != 0) {
            contentScale2 = fit;
        } else {
            contentScale2 = contentScale;
        }
        i3 = i10 & 32 != 0 ? i : alpha;
        i4 = i10 & 64 != 0 ? i2 : colorFilter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i6, i5, -1, "androidx.compose.foundation.Image (Image.kt:95)");
        }
        ImageKt.Image-5h-nEew(bitmap, contentDescription, companion2, alignment2, contentScale2, i3, i4, FilterQuality.Companion.getLow-f-v9h1I(), composer, i13 | i22, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final void Image(Painter painter, String contentDescription, Modifier modifier, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, Composer $composer, int $changed, int i10) {
        boolean traceInProgress;
        Object modifier2;
        int $dirty;
        Object valueOf;
        int i8;
        int i11;
        Object obj6;
        int center;
        Object colorFilter2;
        Composer composer;
        Object paint$default;
        Object obj4;
        Object obj;
        boolean traceInProgress2;
        Modifier semantics$default;
        Object companion2;
        Object obj2;
        int i12;
        float f;
        int i5;
        int i13;
        Object obj3;
        Object obj5;
        int i9;
        int currentCompositeKeyHash;
        Object materializeModifier;
        Object currentCompositionLocalMap;
        int $dirty2;
        int i7;
        int constructor;
        float f2;
        int i6;
        int rememberedValue;
        int i;
        int i14;
        int i2;
        Composer.Companion companion;
        int i3;
        int i15;
        int i4;
        boolean inserting;
        Object obj25;
        int obj26;
        Object obj27;
        Modifier obj28;
        int obj30;
        valueOf = contentDescription;
        final int i28 = $changed;
        final Composer restartGroup = $composer.startRestartGroup(1142754848);
        ComposerKt.sourceInformation(restartGroup, "C(Image)P(6,3,5!1,4)255@11931L329:Image.kt#71ulvw");
        $dirty = $changed;
        if (i10 & 1 != 0) {
            $dirty |= 6;
            currentCompositionLocalMap = painter;
        } else {
            if (i28 & 6 == 0) {
                i8 = restartGroup.changedInstance(painter) ? 4 : 2;
                $dirty |= i8;
            } else {
                currentCompositionLocalMap = painter;
            }
        }
        if (i10 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i28 & 48 == 0) {
                i11 = restartGroup.changed(valueOf) ? 32 : 16;
                $dirty |= i11;
            }
        }
        int i18 = i10 & 4;
        if (i18 != 0) {
            $dirty |= 384;
            companion2 = modifier;
        } else {
            if (i28 & 384 == 0) {
                i12 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i12;
            } else {
                companion2 = modifier;
            }
        }
        i5 = i10 & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            obj3 = alignment;
        } else {
            if (i28 & 3072 == 0) {
                i9 = restartGroup.changed(alignment) ? 2048 : 1024;
                $dirty |= i9;
            } else {
                obj3 = alignment;
            }
        }
        currentCompositeKeyHash = i10 & 16;
        if (currentCompositeKeyHash != 0) {
            $dirty |= 24576;
            materializeModifier = contentScale;
        } else {
            if (i28 & 24576 == 0) {
                i7 = restartGroup.changed(contentScale) ? 16384 : 8192;
                $dirty |= i7;
            } else {
                materializeModifier = contentScale;
            }
        }
        constructor = i10 & 32;
        int i34 = 196608;
        if (constructor != null) {
            $dirty |= i34;
            f2 = alpha;
        } else {
            if (i34 &= i28 == 0) {
                i6 = restartGroup.changed(alpha) ? 131072 : 65536;
                $dirty |= i6;
            } else {
                f2 = alpha;
            }
        }
        rememberedValue = i10 & 64;
        i = 1572864;
        if (rememberedValue != 0) {
            $dirty |= i;
            obj4 = colorFilter;
        } else {
            if (i28 & i == 0) {
                i = restartGroup.changed(colorFilter) ? 1048576 : 524288;
                $dirty |= i;
            } else {
                obj4 = colorFilter;
            }
        }
        if ($dirty & i36 == 599186) {
            if (!restartGroup.getSkipping()) {
                if (i18 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = companion2;
                }
                if (i5 != 0) {
                    obj3 = center;
                }
                if (currentCompositeKeyHash != 0) {
                    materializeModifier = center;
                }
                i14 = constructor != null ? center : f2;
                colorFilter2 = rememberedValue != 0 ? 0 : obj4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1142754848, $dirty, -1, "androidx.compose.foundation.Image (Image.kt:243)");
                }
                if (valueOf != null) {
                    restartGroup.startReplaceGroup(1040258775);
                    ComposerKt.sourceInformation(restartGroup, "245@11667L103");
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 449199624, "CC(remember):Image.kt#9igjgp");
                    i13 = $dirty & 112 == 32 ? 1 : 0;
                    Composer composer2 = restartGroup;
                    f2 = 0;
                    rememberedValue = composer2.rememberedValue();
                    i2 = 0;
                    if (i13 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            traceInProgress2 = 0;
                            currentCompositeKeyHash = new ImageKt.Image.semantics.1.1(valueOf);
                            composer2.updateRememberedValue((Function1)currentCompositeKeyHash);
                        } else {
                            currentCompositeKeyHash = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    semantics$default = SemanticsModifierKt.semantics$default((Modifier)Modifier.Companion, false, (Function1)currentCompositeKeyHash, 1, 0);
                    restartGroup.endReplaceGroup();
                } else {
                    restartGroup.startReplaceGroup(1040398089);
                    restartGroup.endReplaceGroup();
                    semantics$default = Modifier.Companion;
                }
                i2 = colorFilter2;
                f2 = obj3;
                rememberedValue = materializeModifier;
                paint$default = PainterModifierKt.paint$default(ClipKt.clipToBounds(modifier2.then(semantics$default)), currentCompositionLocalMap, false, f2, rememberedValue, i14, i2, 2, 0);
                int i25 = 48;
                int i27 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 544976794, "CC(Layout)P(1)124@4836L23,127@4987L385:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                companion = 6;
                i3 = 0;
                obj30 = $dirty;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(ComposeUiNode.Companion.getConstructor());
                } else {
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                obj26 = i17;
                Updater.set-impl(constructor-impl, (MeasurePolicy)ImageKt.Image.1.INSTANCE, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, paint$default), ComposeUiNode.Companion.getSetModifier());
                i15 = 0;
                obj27 = constructor-impl;
                i4 = 0;
                if (!obj27.getInserting()) {
                    obj28 = paint$default;
                    if (!Intrinsics.areEqual(obj27.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        obj27.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = obj27;
                    }
                } else {
                    obj28 = paint$default;
                }
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj6 = obj25;
                obj = f2;
                obj2 = rememberedValue;
                f = i14;
                obj5 = i2;
            } else {
                restartGroup.skipToGroupEnd();
                obj5 = obj4;
                obj = obj30;
                obj30 = $dirty;
                obj6 = companion2;
                obj2 = materializeModifier;
                f = f2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = obj30;
            traceInProgress = new ImageKt.Image.2(painter, contentDescription, obj6, obj, obj2, f, obj5, i28, i10);
            endRestartGroup.updateScope((Function2)traceInProgress);
        } else {
            $dirty2 = obj30;
        }
    }

    public static final void Image(ImageVector imageVector, String contentDescription, Modifier modifier, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, Composer $composer, int $changed, int i10) {
        androidx.compose.ui.Modifier.Companion companion;
        androidx.compose.ui.Modifier.Companion companion2;
        Alignment alignment2;
        ContentScale contentScale2;
        int i;
        int i2;
        androidx.compose.ui.Modifier.Companion obj13;
        Alignment obj14;
        ContentScale obj15;
        final Composer composer = $composer;
        final int i6 = $changed;
        int i3 = 1595907091;
        ComposerKt.sourceInformationMarkerStart(composer, i3, "C(Image)P(5,3,6!1,4)198@9330L34,197@9309L237:Image.kt#71ulvw");
        if (i10 & 4 != 0) {
            companion2 = obj13;
        } else {
            companion2 = modifier;
        }
        if (i10 & 8 != 0) {
            alignment2 = obj14;
        } else {
            alignment2 = alignment;
        }
        if (i10 & 16 != 0) {
            contentScale2 = obj15;
        } else {
            contentScale2 = contentScale;
        }
        i = i10 & 32 != 0 ? obj13 : alpha;
        i2 = i10 & 64 != 0 ? obj13 : colorFilter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, i6, -1, "androidx.compose.foundation.Image (Image.kt:197)");
        }
        ImageKt.Image((Painter)VectorPainterKt.rememberVectorPainter(imageVector, composer, i6 & 14), contentDescription, companion2, alignment2, contentScale2, i, i2, composer, obj13 | obj14, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final void Image-5h-nEew(ImageBitmap bitmap, String contentDescription, Modifier modifier, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, int filterQuality, Composer $composer, int $changed, int i11) {
        int defaultFilterQuality-f-v9h1I;
        boolean traceInProgress;
        androidx.compose.ui.Modifier.Companion modifier2;
        Alignment alignment2;
        ContentScale contentScale2;
        int alpha2;
        int colorFilter2;
        String str;
        Object obj;
        Object empty;
        int i3;
        int i4;
        int i5;
        int i2;
        int i;
        final Composer composer2 = $composer;
        final int i31 = $changed;
        int i6 = i11;
        int i8 = -1396260732;
        ComposerKt.sourceInformationMarkerStart(composer2, i8, "C(Image)P(2,4,7!1,5!,6:c#ui.graphics.FilterQuality)153@7224L73,154@7302L248:Image.kt#71ulvw");
        if (i6 & 4 != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        if (i6 & 8 != 0) {
            alignment2 = Alignment.Companion.getCenter();
        } else {
            alignment2 = alignment;
        }
        if (i6 & 16 != 0) {
            contentScale2 = ContentScale.Companion.getFit();
        } else {
            contentScale2 = contentScale;
        }
        alpha2 = i6 & 32 != 0 ? 1065353216 : alpha;
        colorFilter2 = i6 & 64 != 0 ? 0 : colorFilter;
        if (i6 &= 128 != 0) {
            i4 = defaultFilterQuality-f-v9h1I;
        } else {
            i4 = filterQuality;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, i31, -1, "androidx.compose.foundation.Image (Image.kt:152)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 449057418, "CC(remember):Image.kt#9igjgp");
        Object obj3 = bitmap;
        Composer composer = $composer;
        int i20 = 0;
        Object rememberedValue = composer.rememberedValue();
        final int i33 = 0;
        if (!composer2.changed(obj3)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i = 0;
                composer.updateRememberedValue(BitmapPainterKt.BitmapPainter-QZhYCtY$default(obj3, 0, obj13, 0, obj15, i4));
            } else {
                obj = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ImageKt.Image((Painter)(BitmapPainter)obj, contentDescription, modifier2, alignment2, contentScale2, alpha2, colorFilter2, composer2, i28 |= i14, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }
}
