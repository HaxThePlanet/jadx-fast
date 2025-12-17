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
        androidx.compose.ui.Modifier.Companion companion;
        androidx.compose.runtime.ProvidableCompositionLocal localContentAlpha;
        boolean traceInProgress;
        androidx.compose.ui.Modifier.Companion companion2;
        long tint2;
        int i6;
        Object consume2;
        String str;
        Object consume;
        Object bitmapPainter;
        long unbox-impl;
        long i;
        float floatValue;
        int i3;
        int i4;
        int i5;
        int i9;
        int i2;
        int i8;
        final Composer composer2 = $changed;
        final int i23 = i7;
        int i10 = -554892675;
        ComposerKt.sourceInformationMarkerStart(composer2, i10, "C(Icon)P(!,3:c#ui.graphics.Color)99@4800L7,99@4839L7,101@4870L42,102@4917L136:Icon.kt#jmzs0o");
        if (obj26 & 4 != 0) {
            companion2 = companion;
        } else {
            companion2 = modifier;
        }
        if (obj26 & 8 != 0) {
            int i14 = 6;
            int i16 = 0;
            int i21 = 2023513938;
            str = "CC:CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composer2, i21, str);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            int i15 = 6;
            i6 = 0;
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
                i8 = 0;
                bitmapPainter = new BitmapPainter(obj2, 0, floatValue, 0, i4, 6, 0);
                composer.updateRememberedValue(bitmapPainter);
            } else {
                bitmapPainter = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        IconKt.Icon-ww6aTOc((Painter)(BitmapPainter)bitmapPainter, contentDescription, companion2, tint2, i6, composer2, i19 |= i13);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
    }

    public static final void Icon-ww6aTOc(Painter painter, String contentDescription, Modifier modifier, long tint, Composer $composer, int $changed, int i7) {
        int traceInProgress2;
        int changed2;
        int i5;
        Object colorFilter;
        Modifier semantics$default;
        Object obj;
        int $dirty;
        int i14;
        int i4;
        Object obj3;
        Object modifier3;
        boolean traceInProgress;
        int i2;
        int str2;
        long l4;
        Object companion;
        Object copy-wmQWz5c$default;
        int i12;
        int i6;
        int i16;
        boolean $dirty2;
        int defaultsInvalid;
        boolean changed;
        int i13;
        int composer;
        int i3;
        Object rememberedValue;
        Object obj2;
        long l3;
        Modifier modifier2;
        Object it$iv;
        long l2;
        String str;
        int i8;
        Object companion2;
        long unbox-impl;
        long l;
        float floatValue;
        int i15;
        int i11;
        int i;
        int i9;
        int i10;
        int obj29;
        Object obj30;
        obj = painter;
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
                i14 = restartGroup.changedInstance(obj) ? 4 : 2;
                $dirty |= i14;
            }
        }
        if (obj32 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i30 & 48 == 0) {
                i4 = restartGroup.changed(obj2) ? 32 : 16;
                $dirty |= i4;
            }
        }
        int i19 = obj32 & 4;
        if (i19 != 0) {
            $dirty |= 384;
            copy-wmQWz5c$default = modifier;
        } else {
            if (i30 & 384 == 0) {
                i6 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i6;
            } else {
                copy-wmQWz5c$default = modifier;
            }
        }
        i13 = 2048;
        if (i30 & 3072 == 0) {
            if (obj32 & 8 == 0) {
                i16 = restartGroup.changed(tint) ? i13 : 1024;
            } else {
                l3 = tint;
            }
            $dirty |= i16;
        } else {
            l3 = tint;
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i30 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i19 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = copy-wmQWz5c$default;
                        }
                        if (obj32 & 8 != 0) {
                            int i27 = 6;
                            int i29 = 0;
                            int i31 = 2023513938;
                            str = "CC:CompositionLocal.kt#9igjgp";
                            ComposerKt.sourceInformationMarkerStart(restartGroup, i31, str);
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            defaultsInvalid = 6;
                            i3 = 0;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, i31, str);
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $dirty &= -7169;
                            l3 = modifier3;
                            l2 = copy-wmQWz5c$default;
                        } else {
                            l2 = l3;
                            l3 = modifier3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj32 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        l2 = l3;
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
                if (i18 ^= 3072 > i13) {
                    if (!restartGroup.changed(l2)) {
                        i5 = $dirty & 3072 == i13 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                composer = restartGroup;
                rememberedValue = 0;
                it$iv = composer.rememberedValue();
                floatValue = 0;
                if (i5 == 0) {
                    if (it$iv == Composer.Companion.getEmpty()) {
                        int i26 = 0;
                        obj29 = i26;
                        if (Color.equals-impl0(l2, str)) {
                            companion = it$iv;
                            copy-wmQWz5c$default = 0;
                        } else {
                            companion = it$iv;
                            copy-wmQWz5c$default = ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, l2, str, 0, 2);
                        }
                        composer.updateRememberedValue(copy-wmQWz5c$default);
                    } else {
                        companion = it$iv;
                    }
                } else {
                }
                Object invalid$iv = it$iv;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (obj2 != null) {
                    restartGroup.startReplaceGroup(980462681);
                    ComposerKt.sourceInformation(restartGroup, "139@6706L103");
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 724365382, str2);
                    i2 = $dirty & 112 == 32 ? 1 : 0;
                    Composer composer2 = restartGroup;
                    composer = 0;
                    rememberedValue = composer2.rememberedValue();
                    it$iv = 0;
                    if (i2 == 0) {
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
                    i12 = 0;
                    restartGroup.startReplaceGroup(980601995);
                    restartGroup.endReplaceGroup();
                    semantics$default = Modifier.Companion;
                }
                i8 = i28;
                BoxKt.Box(PainterModifierKt.paint$default(IconKt.defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(l3), obj), obj, false, 0, ContentScale.Companion.getFit(), 0, obj30, 22, 0).then(semantics$default), restartGroup, i12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = l3;
                l4 = l2;
            } else {
                restartGroup.skipToGroupEnd();
                i8 = $dirty;
                obj3 = copy-wmQWz5c$default;
                l4 = l3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new IconKt.Icon.1(painter, contentDescription, obj3, l4, copy-wmQWz5c$default, i30, obj32);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void Icon-ww6aTOc(ImageVector imageVector, String contentDescription, Modifier modifier, long tint, Composer $composer, int $changed, int i7) {
        int companion;
        int localContentAlpha;
        boolean traceInProgress;
        androidx.compose.ui.Modifier.Companion companion2;
        long tint2;
        int i6;
        Object consume;
        String str;
        Object consume2;
        long unbox-impl;
        float floatValue;
        int i;
        int i2;
        int i5;
        int i3;
        int i4;
        final Composer composer = $changed;
        final int i21 = i7;
        int i8 = -800853103;
        ComposerKt.sourceInformationMarkerStart(composer, i8, "C(Icon)P(1!,3:c#ui.graphics.Color)65@3149L7,65@3188L7,68@3229L34,67@3205L163:Icon.kt#jmzs0o");
        if (obj25 & 4 != 0) {
            companion2 = companion;
        } else {
            companion2 = modifier;
        }
        if (obj25 & 8 != 0) {
            int i12 = 6;
            int i14 = 0;
            int i19 = 2023513938;
            str = "CC:CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composer, i19, str);
            ComposerKt.sourceInformationMarkerEnd(composer);
            int i13 = 6;
            i6 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, i19, str);
            ComposerKt.sourceInformationMarkerEnd(composer);
            tint2 = Color.copy-wmQWz5c$default((Color)composer.consume((CompositionLocal)ContentColorKt.getLocalContentColor()).unbox-impl(), obj11, (Number)composer.consume((CompositionLocal)ContentAlphaKt.getLocalContentAlpha()).floatValue(), 0, 0, 0, 14);
        } else {
            tint2 = tint;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, i21, -1, "androidx.compose.material.Icon (Icon.kt:66)");
        }
        IconKt.Icon-ww6aTOc((Painter)VectorPainterKt.rememberVectorPainter(imageVector, composer, i21 & 14), contentDescription, companion2, tint2, i6, composer, i17 |= i11);
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
