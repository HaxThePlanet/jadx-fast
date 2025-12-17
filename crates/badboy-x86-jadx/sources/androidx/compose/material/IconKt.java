package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorFilter.Companion;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ContentScale.Companion;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00012\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\u001a8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00012\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000f\u001a8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00012\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0019", d2 = {"DefaultIconSizeModifier", "Landroidx/compose/ui/Modifier;", "Icon", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "tint", "Landroidx/compose/ui/graphics/Color;", "Icon-ww6aTOc", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "defaultSizeFor", "isInfinite", "", "Landroidx/compose/ui/geometry/Size;", "isInfinite-uvyYCjk", "(J)Z", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IconKt {

    private static final Modifier DefaultIconSizeModifier;
    static {
        final int i2 = 0;
        IconKt.DefaultIconSizeModifier = SizeKt.size-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i));
    }

    public static final void Icon-ww6aTOc(ImageBitmap bitmap, String contentDescription, Modifier modifier, long tint, Composer $composer, int $changed, int i7) {
        androidx.compose.ui.Modifier.Companion companion2;
        androidx.compose.runtime.ProvidableCompositionLocal localContentAlpha;
        boolean traceInProgress;
        androidx.compose.ui.Modifier.Companion companion;
        long tint2;
        int i;
        Object consume2;
        String str;
        Object consume;
        Object bitmapPainter;
        long unbox-impl;
        long i2;
        float floatValue;
        int i3;
        int i6;
        int i4;
        int i9;
        int i8;
        int i5;
        final Composer composer2 = $changed;
        final int i23 = i7;
        int i10 = -554892675;
        ComposerKt.sourceInformationMarkerStart(composer2, i10, "C(Icon)P(!,3:c#ui.graphics.Color)99@4800L7,99@4839L7,101@4870L42,102@4917L136:Icon.kt#jmzs0o");
        if (obj26 & 4 != 0) {
            companion = companion2;
        } else {
            companion = modifier;
        }
        if (obj26 & 8 != 0) {
            int i14 = 6;
            int i16 = 0;
            int i21 = 2023513938;
            str = "CC:CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composer2, i21, str);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            int i15 = 6;
            i = 0;
            ComposerKt.sourceInformationMarkerStart(composer2, i21, str);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            tint2 = Color.copy-wmQWz5c$default((Color)composer2.consume((CompositionLocal)ContentColorKt.getLocalContentColor()).unbox-impl(), obj11, (Number)composer2.consume((CompositionLocal)ContentAlphaKt.getLocalContentAlpha()).floatValue(), 0, 0, 0, 14);
        } else {
            tint2 = tint;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i10, i23, -1, "androidx.compose.material.Icon (Icon.kt:100)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 724306569, "CC(remember):Icon.kt#9igjgp");
        Object obj2 = bitmap;
        Composer composer = $changed;
        int i17 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i24 = 0;
        if (!composer2.changed(obj2)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i5 = 0;
                bitmapPainter = new BitmapPainter(obj2, 0, floatValue, 0, i6, 6, 0);
                composer.updateRememberedValue(bitmapPainter);
            } else {
                bitmapPainter = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        IconKt.Icon-ww6aTOc((Painter)(BitmapPainter)bitmapPainter, contentDescription, companion, tint2, i, composer2, i19 |= i13);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
    }

    public static final void Icon-ww6aTOc(Painter painter, String contentDescription, Modifier modifier, long tint, Composer $composer, int $changed, int i7) {
        int traceInProgress2;
        int changed2;
        int i12;
        Object colorFilter;
        Modifier semantics$default;
        Object obj3;
        int $dirty;
        int i16;
        int i3;
        Object obj;
        Object modifier2;
        boolean traceInProgress;
        int i14;
        int str2;
        long l2;
        Object companion2;
        Object copy-wmQWz5c$default;
        int i4;
        int i13;
        int i;
        boolean $dirty2;
        int defaultsInvalid;
        boolean changed;
        int i15;
        int composer;
        int i5;
        Object rememberedValue;
        Object obj2;
        long l3;
        Modifier modifier3;
        Object it$iv;
        long l;
        String str;
        int i9;
        Object companion;
        long unbox-impl;
        long l4;
        float floatValue;
        int i8;
        int i2;
        int i10;
        int i6;
        int i11;
        int obj29;
        Object obj30;
        obj3 = painter;
        obj2 = contentDescription;
        final int i30 = i7;
        traceInProgress2 = -1142959010;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(Icon)P(2!,3:c#ui.graphics.Color)133@6456L7,133@6495L7,135@6530L94,146@6850L253:Icon.kt#jmzs0o");
        $dirty = i7;
        if (obj32 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i30 & 6 == 0) {
                i16 = restartGroup.changedInstance(obj3) ? 4 : 2;
                $dirty |= i16;
            }
        }
        if (obj32 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i30 & 48 == 0) {
                i3 = restartGroup.changed(obj2) ? 32 : 16;
                $dirty |= i3;
            }
        }
        int i19 = obj32 & 4;
        if (i19 != 0) {
            $dirty |= 384;
            copy-wmQWz5c$default = modifier;
        } else {
            if (i30 & 384 == 0) {
                i13 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i13;
            } else {
                copy-wmQWz5c$default = modifier;
            }
        }
        i15 = 2048;
        if (i30 & 3072 == 0) {
            if (obj32 & 8 == 0) {
                i = restartGroup.changed(tint) ? i15 : 1024;
            } else {
                l3 = tint;
            }
            $dirty |= i;
        } else {
            l3 = tint;
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i30 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i19 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = copy-wmQWz5c$default;
                        }
                        if (obj32 & 8 != 0) {
                            int i27 = 6;
                            int i29 = 0;
                            int i31 = 2023513938;
                            str = "CC:CompositionLocal.kt#9igjgp";
                            ComposerKt.sourceInformationMarkerStart(restartGroup, i31, str);
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            defaultsInvalid = 6;
                            i5 = 0;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, i31, str);
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $dirty &= -7169;
                            l3 = modifier2;
                            l = copy-wmQWz5c$default;
                        } else {
                            l = l3;
                            l3 = modifier2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj32 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        l = l3;
                        l3 = copy-wmQWz5c$default;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material.Icon (Icon.kt:134)");
                }
                str2 = "CC(remember):Icon.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 724359741, str2);
                if (i18 ^= 3072 > i15) {
                    if (!restartGroup.changed(l)) {
                        i12 = $dirty & 3072 == i15 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                composer = restartGroup;
                rememberedValue = 0;
                it$iv = composer.rememberedValue();
                floatValue = 0;
                if (i12 == 0) {
                    if (it$iv == Composer.Companion.getEmpty()) {
                        int i26 = 0;
                        obj29 = i26;
                        if (Color.equals-impl0(l, str)) {
                            companion2 = it$iv;
                            copy-wmQWz5c$default = 0;
                        } else {
                            companion2 = it$iv;
                            copy-wmQWz5c$default = ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, l, str, 0, 2);
                        }
                        composer.updateRememberedValue(copy-wmQWz5c$default);
                    } else {
                        companion2 = it$iv;
                    }
                } else {
                }
                Object invalid$iv = it$iv;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (obj2 != null) {
                    restartGroup.startReplaceGroup(980462681);
                    ComposerKt.sourceInformation(restartGroup, "139@6706L103");
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 724365382, str2);
                    i14 = $dirty & 112 == 32 ? 1 : 0;
                    Composer composer2 = restartGroup;
                    composer = 0;
                    rememberedValue = composer2.rememberedValue();
                    it$iv = 0;
                    if (i14 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            defaultsInvalid = 0;
                            obj30 = invalid$iv;
                            colorFilter = new IconKt.Icon.semantics.1.1(obj2);
                            composer2.updateRememberedValue((Function1)colorFilter);
                        } else {
                            obj30 = invalid$iv;
                            colorFilter = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    semantics$default = SemanticsModifierKt.semantics$default((Modifier)Modifier.Companion, false, (Function1)colorFilter, 1, 0);
                    restartGroup.endReplaceGroup();
                } else {
                    obj30 = invalid$iv;
                    i4 = 0;
                    restartGroup.startReplaceGroup(980601995);
                    restartGroup.endReplaceGroup();
                    semantics$default = Modifier.Companion;
                }
                i9 = i28;
                BoxKt.Box(PainterModifierKt.paint$default(IconKt.defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(l3), obj3), obj3, false, 0, ContentScale.Companion.getFit(), 0, obj30, 22, 0).then(semantics$default), restartGroup, i4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = l3;
                l2 = l;
            } else {
                restartGroup.skipToGroupEnd();
                i9 = $dirty;
                obj = copy-wmQWz5c$default;
                l2 = l3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new IconKt.Icon.1(painter, contentDescription, obj, l2, copy-wmQWz5c$default, i30, obj32);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void Icon-ww6aTOc(ImageVector imageVector, String contentDescription, Modifier modifier, long tint, Composer $composer, int $changed, int i7) {
        int companion2;
        int localContentAlpha;
        boolean traceInProgress;
        androidx.compose.ui.Modifier.Companion companion;
        long tint2;
        int i;
        Object consume;
        String str;
        Object consume2;
        long unbox-impl;
        float floatValue;
        int i4;
        int i3;
        int i6;
        int i5;
        int i2;
        final Composer composer = $changed;
        final int i21 = i7;
        int i8 = -800853103;
        ComposerKt.sourceInformationMarkerStart(composer, i8, "C(Icon)P(1!,3:c#ui.graphics.Color)65@3149L7,65@3188L7,68@3229L34,67@3205L163:Icon.kt#jmzs0o");
        if (obj25 & 4 != 0) {
            companion = companion2;
        } else {
            companion = modifier;
        }
        if (obj25 & 8 != 0) {
            int i12 = 6;
            int i14 = 0;
            int i19 = 2023513938;
            str = "CC:CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composer, i19, str);
            ComposerKt.sourceInformationMarkerEnd(composer);
            int i13 = 6;
            i = 0;
            ComposerKt.sourceInformationMarkerStart(composer, i19, str);
            ComposerKt.sourceInformationMarkerEnd(composer);
            tint2 = Color.copy-wmQWz5c$default((Color)composer.consume((CompositionLocal)ContentColorKt.getLocalContentColor()).unbox-impl(), obj11, (Number)composer.consume((CompositionLocal)ContentAlphaKt.getLocalContentAlpha()).floatValue(), 0, 0, 0, 14);
        } else {
            tint2 = tint;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, i21, -1, "androidx.compose.material.Icon (Icon.kt:66)");
        }
        IconKt.Icon-ww6aTOc((Painter)VectorPainterKt.rememberVectorPainter(imageVector, composer, i21 & 14), contentDescription, companion, tint2, i, composer, i17 |= i11);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
    }

    private static final Modifier defaultSizeFor(Modifier $this$defaultSizeFor, Painter painter) {
        Modifier defaultIconSizeModifier;
        boolean infinite-uvyYCjk;
        if (!Size.equals-impl0(painter.getIntrinsicSize-NH-jbRc(), obj1)) {
            if (IconKt.isInfinite-uvyYCjk(painter.getIntrinsicSize-NH-jbRc())) {
                defaultIconSizeModifier = IconKt.DefaultIconSizeModifier;
            } else {
                defaultIconSizeModifier = Modifier.Companion;
            }
        } else {
        }
        return $this$defaultSizeFor.then(defaultIconSizeModifier);
    }

    private static final boolean isInfinite-uvyYCjk(long $this$isInfinite_u2duvyYCjk) {
        boolean infinite;
        int i;
        if (Float.isInfinite(Size.getWidth-impl($this$isInfinite_u2duvyYCjk)) && Float.isInfinite(Size.getHeight-impl($this$isInfinite_u2duvyYCjk))) {
            i = Float.isInfinite(Size.getHeight-impl($this$isInfinite_u2duvyYCjk)) ? 1 : 0;
        } else {
        }
        return i;
    }
}
