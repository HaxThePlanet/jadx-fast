package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0008\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001a\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0008\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001b\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0008\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001c²\u0006\n\u0010\u001d\u001a\u00020\u001eX\u008a\u0084\u0002", d2 = {"Button", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "elevation", "Landroidx/compose/material/ButtonElevation;", "shape", "Landroidx/compose/ui/graphics/Shape;", "border", "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ButtonColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/ButtonElevation;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ButtonColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedButton", "TextButton", "material_release", "contentColor", "Landroidx/compose/ui/graphics/Color;"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ButtonKt {
    public static final void Button(Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, androidx.compose.material.ButtonElevation elevation, Shape shape, BorderStroke border, androidx.compose.material.ButtonColors colors, PaddingValues contentPadding, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj9;
        int i8;
        int $dirty;
        int defaultsInvalid;
        Object modifier3;
        int $dirty2;
        boolean traceInProgress;
        androidx.compose.material.ButtonElevation elevation2;
        int i20;
        Object obj;
        int $dirty3;
        boolean traceInProgress2;
        Object $i$a$CacheButtonKt$Button$interactionSource$1;
        Object shape3;
        boolean modifier2;
        Object shape2;
        int i14;
        Object obj5;
        int border2;
        boolean z;
        androidx.compose.material.ButtonElevation contentPadding3;
        int i19;
        Object contentPadding2;
        int i17;
        Object colors2;
        int i7;
        androidx.compose.material.ButtonColors i5;
        Object $composer2;
        Object i3;
        androidx.compose.material.ButtonColors interactionSource2;
        int i22;
        int changed2;
        int i;
        int i4;
        Object i12;
        Object obj2;
        Object obj11;
        int unbox-impl2;
        int changed3;
        Object rememberedValue;
        int i9;
        int i16;
        Object obj6;
        Object obj10;
        State constructor-impl;
        Object obj3;
        Object i21;
        int i15;
        int changed;
        int unbox-impl;
        int i10;
        long copy-wmQWz5c$default;
        int i18;
        Object obj7;
        Composer composer3;
        Composer composer;
        float f;
        Object obj8;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer2;
        int i11;
        int i6;
        int i2;
        Object obj4;
        long obj31;
        androidx.compose.material.ButtonElevation obj32;
        int obj33;
        int obj34;
        int obj35;
        int obj36;
        int obj37;
        int obj38;
        final Object obj13 = content;
        final int i63 = $changed;
        final int i64 = i13;
        Composer restartGroup = $composer.startRestartGroup(-2116133464);
        ComposerKt.sourceInformation(restartGroup, "C(Button)P(8,7,5,6,4,9!2,3)97@4671L11,98@4717L6,100@4807L14,106@5091L21,112@5288L24,117@5536L699,107@5117L1118:Button.kt#jmzs0o");
        $dirty2 = $changed;
        if (i64 & 1 != 0) {
            $dirty2 |= 6;
            rememberedValue = onClick;
        } else {
            if (i63 & 6 == 0) {
                i20 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty2 |= i20;
            } else {
                rememberedValue = onClick;
            }
        }
        $dirty3 = i64 & 2;
        if ($dirty3 != 0) {
            $dirty2 |= 48;
            shape3 = modifier;
        } else {
            if (i63 & 48 == 0) {
                i14 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i14;
            } else {
                shape3 = modifier;
            }
        }
        border2 = i64 & 4;
        if (border2 != 0) {
            $dirty2 |= 384;
            z = enabled;
        } else {
            if (i63 & 384 == 0) {
                i17 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty2 |= i17;
            } else {
                z = enabled;
            }
        }
        i7 = i64 & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            i3 = interactionSource;
        } else {
            if (i63 & 3072 == 0) {
                i22 = restartGroup.changed(interactionSource) ? 2048 : 1024;
                $dirty2 |= i22;
            } else {
                i3 = interactionSource;
            }
        }
        if (i63 & 24576 == 0) {
            if (i64 & 16 == 0) {
                i = restartGroup.changed(elevation) ? 16384 : 8192;
            } else {
                obj6 = elevation;
            }
            $dirty2 |= i;
        } else {
            obj6 = elevation;
        }
        if (i49 &= i63 == 0) {
            if (i64 & 32 == 0) {
                i4 = restartGroup.changed(shape) ? 131072 : 65536;
            } else {
                obj3 = shape;
            }
            $dirty2 |= i4;
        } else {
            obj3 = shape;
        }
        i21 = i64 & 64;
        int i50 = 1572864;
        if (i21 != 0) {
            $dirty2 |= i50;
            i12 = border;
        } else {
            if (i50 &= i63 == 0) {
                i15 = restartGroup.changed(border) ? 1048576 : 524288;
                $dirty2 |= i15;
            } else {
                i12 = border;
            }
        }
        if (i63 & i72 == 0) {
            if (i64 & 128 == 0) {
                changed = restartGroup.changed(colors) ? 8388608 : 4194304;
            } else {
                obj9 = colors;
            }
            $dirty2 |= changed;
        } else {
            obj9 = colors;
        }
        int i68 = i64 & 256;
        int i73 = 100663296;
        if (i68 != 0) {
            $dirty2 |= i73;
            unbox-impl = i68;
            obj10 = contentPadding;
        } else {
            if (i63 & i73 == 0) {
                unbox-impl = i68;
                i10 = restartGroup.changed(contentPadding) ? 67108864 : 33554432;
                $dirty2 |= i10;
            } else {
                unbox-impl = i68;
                obj10 = contentPadding;
            }
        }
        i11 = 805306368;
        if (i64 & 512 != 0) {
            $dirty2 |= i11;
        } else {
            if (i63 & i11 == 0) {
                i8 = restartGroup.changedInstance(obj13) ? 536870912 : 268435456;
                $dirty2 |= i8;
            }
        }
        int i25 = $dirty2;
        final int obj40 = i25;
        if ($dirty4 &= i25 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i81 = -29360129;
                i10 = -458753;
                int i77 = -57345;
                if (i63 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if ($dirty3 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = shape3;
                        }
                        i2 = border2 != 0 ? traceInProgress : z;
                        obj4 = i7 != 0 ? traceInProgress : i3;
                        if (i64 & 16 != 0) {
                            elevation2 = ButtonDefaults.INSTANCE.elevation-R_JCAzs(0, 0, 0, 0, 0, restartGroup, 196608, 31);
                            $dirty3 = obj40 & i77;
                        } else {
                            elevation2 = elevation;
                            $dirty3 = obj40;
                        }
                        if (i64 & 32 != 0) {
                            shape2 = MaterialTheme.INSTANCE.getShapes(restartGroup, 6).getSmall();
                            $dirty3 &= i10;
                        } else {
                            shape2 = obj3;
                        }
                        border2 = i21 != 0 ? 0 : border;
                        if (i64 & 128 != 0) {
                            i19 = unbox-impl;
                            i5 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(0, obj3, 0, unbox-impl, 0, i77, 0);
                            $dirty3 &= i81;
                        } else {
                            i19 = unbox-impl;
                            i5 = colors;
                        }
                        if (i19 != 0) {
                            contentPadding2 = ButtonDefaults.INSTANCE.getContentPadding();
                            i21 = shape2;
                            obj7 = border2;
                            obj3 = i2;
                            i3 = obj4;
                            shape3 = modifier3;
                            $dirty = $dirty3;
                        } else {
                            contentPadding2 = contentPadding;
                            i21 = shape2;
                            obj7 = border2;
                            obj3 = i2;
                            i3 = obj4;
                            shape3 = modifier3;
                            $dirty = $dirty3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty = i64 & 16 != 0 ? obj40 & i77 : obj40;
                        if (i64 & 32 != 0) {
                            $dirty &= i10;
                        }
                        if (i64 & 128 != 0) {
                            $dirty &= i81;
                        }
                        elevation2 = elevation;
                        i5 = colors;
                        obj7 = i12;
                        i21 = obj3;
                        obj3 = z;
                        contentPadding2 = obj10;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2116133464, $dirty, -1, "androidx.compose.material.Button (Button.kt:103)");
                }
                if (i3 == null) {
                    restartGroup.startReplaceGroup(1050577827);
                    ComposerKt.sourceInformation(restartGroup, "105@5020L39");
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -243205057, "CC(remember):Button.kt#9igjgp");
                    border2 = restartGroup;
                    i12 = 0;
                    rememberedValue = border2.rememberedValue();
                    obj10 = 0;
                    obj31 = i37;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i38 = 0;
                        border2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        $i$a$CacheButtonKt$Button$interactionSource$1 = rememberedValue;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    restartGroup.endReplaceGroup();
                    obj8 = $i$a$CacheButtonKt$Button$interactionSource$1;
                } else {
                    restartGroup.startReplaceGroup(-243205708);
                    restartGroup.endReplaceGroup();
                    obj8 = i3;
                }
                State contentColor = i5.contentColor(obj3, restartGroup, i40 |= i45);
                if (elevation2 == null) {
                    restartGroup.startReplaceGroup(1050984484);
                } else {
                    restartGroup.startReplaceGroup(-243191939);
                    ComposerKt.sourceInformation(restartGroup, "115@5430L37");
                    constructor-impl = elevation2.elevation(obj3, (InteractionSource)obj8, restartGroup, i67 |= i71);
                }
                restartGroup.endReplaceGroup();
                if (constructor-impl != null) {
                    f = unbox-impl2;
                } else {
                    i16 = 0;
                    f = constructor-impl;
                }
                ButtonKt.Button.2 anon = new ButtonKt.Button.2(contentColor, contentPadding2, obj13);
                composer2 = restartGroup;
                SurfaceKt.Surface-LPr_se0(onClick, SemanticsModifierKt.semantics$default(shape3, false, (Function1)ButtonKt.Button.1.INSTANCE, 1, 0), obj3, i21, (Color)i5.backgroundColor(obj3, restartGroup, i54 |= i75).getValue().unbox-impl(), i10, Color.copy-wmQWz5c$default(ButtonKt.Button$lambda$1(contentColor), enabled, 1065353216, 0, 0, 0, 14), i18, obj7, f, obj8, (Function2)ComposableLambdaKt.rememberComposableLambda(7524271, true, anon, restartGroup, 54), composer2);
                composer3 = composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i9 = $dirty;
                obj = shape3;
                obj2 = contentPadding2;
                obj5 = i3;
                modifier2 = obj3;
                $composer2 = obj7;
                contentPadding3 = obj32;
                interactionSource2 = i5;
                colors2 = i21;
            } else {
                restartGroup.skipToGroupEnd();
                i9 = obj40;
                obj = shape3;
                modifier2 = z;
                composer3 = restartGroup;
                obj5 = i3;
                $composer2 = i12;
                obj2 = obj10;
                colors2 = obj3;
                contentPadding3 = elevation;
                interactionSource2 = colors;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = new ButtonKt.Button.3(onClick, obj, modifier2, obj5, contentPadding3, colors2, $composer2, interactionSource2, obj2, obj13, i63, i64);
            endRestartGroup.updateScope((Function2)$dirty);
        }
    }

    private static final long Button$lambda$1(State<Color> $contentColor$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Color)$contentColor$delegate.getValue().unbox-impl();
    }

    public static final void OutlinedButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, androidx.compose.material.ButtonElevation elevation, Shape shape, BorderStroke border, androidx.compose.material.ButtonColors colors, PaddingValues contentPadding, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        int companion2;
        int i3;
        int i5;
        int i;
        int small;
        int outlinedBorder;
        int outlinedButtonColors-RGew2ao;
        PaddingValues contentPadding2;
        boolean traceInProgress;
        int str;
        int i2;
        int i6;
        androidx.compose.material.ButtonColors buttonColors;
        int i8;
        PaddingValues paddingValues;
        int i10;
        androidx.compose.ui.Modifier.Companion companion;
        int i7;
        int i4;
        int i9;
        androidx.compose.foundation.shape.CornerBasedShape cornerBasedShape;
        BorderStroke borderStroke;
        Composer composer = $composer;
        final int i42 = $changed;
        int i39 = i13;
        int i40 = -1776134358;
        ComposerKt.sourceInformationMarkerStart(composer, i40, "C(OutlinedButton)P(8,7,5,6,4,9!2,3)174@8227L6,175@8284L14,176@8342L22,179@8482L270:Button.kt#jmzs0o");
        if (i39 & 2 != 0) {
            companion = companion2;
        } else {
            companion = modifier;
        }
        i7 = i39 & 4 != 0 ? i3 : enabled;
        i4 = i39 & 8 != 0 ? i5 : interactionSource;
        i9 = i39 & 16 != 0 ? i : elevation;
        str = 6;
        if (i39 & 32 != 0) {
            cornerBasedShape = small;
        } else {
            cornerBasedShape = shape;
        }
        if (i39 & 64 != 0) {
            borderStroke = outlinedBorder;
        } else {
            borderStroke = border;
        }
        if (i39 & 128 != 0) {
            buttonColors = outlinedButtonColors-RGew2ao;
        } else {
            buttonColors = colors;
        }
        if (i39 & 256 != 0) {
            paddingValues = contentPadding2;
        } else {
            paddingValues = contentPadding;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i40, i42, -1, "androidx.compose.material.OutlinedButton (Button.kt:179)");
        }
        ButtonKt.Button(onClick, companion, i7, i4, i9, cornerBasedShape, borderStroke, buttonColors, paddingValues, content, $composer, i20 | i35, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final void TextButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, androidx.compose.material.ButtonElevation elevation, Shape shape, BorderStroke border, androidx.compose.material.ButtonColors colors, PaddingValues contentPadding, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        int companion2;
        int i;
        int i7;
        int i12;
        int small;
        int i6;
        int textButtonColors-RGew2ao;
        PaddingValues textButtonContentPadding;
        boolean traceInProgress;
        int str;
        int i10;
        int i4;
        androidx.compose.material.ButtonColors buttonColors;
        int i8;
        PaddingValues paddingValues;
        int i11;
        androidx.compose.ui.Modifier.Companion companion;
        int i9;
        int i2;
        int i3;
        androidx.compose.foundation.shape.CornerBasedShape cornerBasedShape;
        int i5;
        Composer composer = $composer;
        final int i45 = $changed;
        int i42 = i13;
        int i43 = 288797557;
        ComposerKt.sourceInformationMarkerStart(composer, i43, "C(TextButton)P(8,7,5,6,4,9!2,3)228@10754L6,230@10844L18,233@10990L270:Button.kt#jmzs0o");
        if (i42 & 2 != 0) {
            companion = companion2;
        } else {
            companion = modifier;
        }
        i9 = i42 & 4 != 0 ? i : enabled;
        i2 = i42 & 8 != 0 ? i7 : interactionSource;
        i3 = i42 & 16 != 0 ? i12 : elevation;
        if (i42 & 32 != 0) {
            cornerBasedShape = small;
        } else {
            cornerBasedShape = shape;
        }
        i5 = i42 & 64 != 0 ? i6 : border;
        if (i42 & 128 != 0) {
            buttonColors = textButtonColors-RGew2ao;
        } else {
            buttonColors = colors;
        }
        if (i42 & 256 != 0) {
            paddingValues = textButtonContentPadding;
        } else {
            paddingValues = contentPadding;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i43, i45, -1, "androidx.compose.material.TextButton (Button.kt:233)");
        }
        ButtonKt.Button(onClick, companion, i9, i2, i3, cornerBasedShape, i5, buttonColors, paddingValues, content, $composer, i22 | i37, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final long access$Button$lambda$1(State $contentColor$delegate) {
        return ButtonKt.Button$lambda$1($contentColor$delegate);
    }
}
