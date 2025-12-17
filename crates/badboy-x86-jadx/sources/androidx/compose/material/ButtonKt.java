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
        Object obj6;
        int i4;
        int $dirty2;
        int defaultsInvalid;
        Object modifier3;
        int $dirty;
        boolean traceInProgress2;
        androidx.compose.material.ButtonElevation elevation2;
        int i8;
        Object obj3;
        int $dirty3;
        boolean traceInProgress;
        Object i18;
        Object shape2;
        boolean modifier2;
        Object shape3;
        int i12;
        Object obj10;
        int border2;
        boolean z;
        androidx.compose.material.ButtonElevation contentPadding2;
        int i22;
        Object contentPadding3;
        int i19;
        Object colors2;
        int i23;
        androidx.compose.material.ButtonColors i20;
        Object $composer2;
        Object i6;
        androidx.compose.material.ButtonColors interactionSource2;
        int i10;
        int changed2;
        int i9;
        int i15;
        Object i2;
        Object obj;
        Object obj2;
        int unbox-impl;
        int changed;
        Object rememberedValue;
        int i11;
        int i14;
        Object obj4;
        Object obj11;
        State constructor-impl;
        Object obj5;
        Object i;
        int i7;
        int changed3;
        int unbox-impl2;
        int i3;
        long copy-wmQWz5c$default;
        int i5;
        Object obj7;
        Composer composer;
        Composer composer2;
        float f;
        Object obj8;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer3;
        int i16;
        int i21;
        int i17;
        Object obj9;
        long obj31;
        androidx.compose.material.ButtonElevation obj32;
        int obj33;
        int obj34;
        int obj35;
        int obj36;
        int obj37;
        int obj38;
        final Object obj13 = content;
        final int i64 = $changed;
        final int i65 = i13;
        Composer restartGroup = $composer.startRestartGroup(-2116133464);
        ComposerKt.sourceInformation(restartGroup, "C(Button)P(8,7,5,6,4,9!2,3)97@4671L11,98@4717L6,100@4807L14,106@5091L21,112@5288L24,117@5536L699,107@5117L1118:Button.kt#jmzs0o");
        $dirty = $changed;
        if (i65 & 1 != 0) {
            $dirty |= 6;
            rememberedValue = onClick;
        } else {
            if (i64 & 6 == 0) {
                i8 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty |= i8;
            } else {
                rememberedValue = onClick;
            }
        }
        $dirty3 = i65 & 2;
        if ($dirty3 != 0) {
            $dirty |= 48;
            shape2 = modifier;
        } else {
            if (i64 & 48 == 0) {
                i12 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i12;
            } else {
                shape2 = modifier;
            }
        }
        border2 = i65 & 4;
        if (border2 != 0) {
            $dirty |= 384;
            z = enabled;
        } else {
            if (i64 & 384 == 0) {
                i19 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty |= i19;
            } else {
                z = enabled;
            }
        }
        i23 = i65 & 8;
        if (i23 != 0) {
            $dirty |= 3072;
            i6 = interactionSource;
        } else {
            if (i64 & 3072 == 0) {
                i10 = restartGroup.changed(interactionSource) ? 2048 : 1024;
                $dirty |= i10;
            } else {
                i6 = interactionSource;
            }
        }
        if (i64 & 24576 == 0) {
            if (i65 & 16 == 0) {
                i9 = restartGroup.changed(elevation) ? 16384 : 8192;
            } else {
                obj4 = elevation;
            }
            $dirty |= i9;
        } else {
            obj4 = elevation;
        }
        if (i50 &= i64 == 0) {
            if (i65 & 32 == 0) {
                i15 = restartGroup.changed(shape) ? 131072 : 65536;
            } else {
                obj5 = shape;
            }
            $dirty |= i15;
        } else {
            obj5 = shape;
        }
        i = i65 & 64;
        int i51 = 1572864;
        if (i != 0) {
            $dirty |= i51;
            i2 = border;
        } else {
            if (i51 &= i64 == 0) {
                i7 = restartGroup.changed(border) ? 1048576 : 524288;
                $dirty |= i7;
            } else {
                i2 = border;
            }
        }
        if (i64 & i73 == 0) {
            if (i65 & 128 == 0) {
                changed3 = restartGroup.changed(colors) ? 8388608 : 4194304;
            } else {
                obj6 = colors;
            }
            $dirty |= changed3;
        } else {
            obj6 = colors;
        }
        int i69 = i65 & 256;
        int i74 = 100663296;
        if (i69 != 0) {
            $dirty |= i74;
            unbox-impl2 = i69;
            obj11 = contentPadding;
        } else {
            if (i64 & i74 == 0) {
                unbox-impl2 = i69;
                i3 = restartGroup.changed(contentPadding) ? 67108864 : 33554432;
                $dirty |= i3;
            } else {
                unbox-impl2 = i69;
                obj11 = contentPadding;
            }
        }
        i16 = 805306368;
        if (i65 & 512 != 0) {
            $dirty |= i16;
        } else {
            if (i64 & i16 == 0) {
                i4 = restartGroup.changedInstance(obj13) ? 536870912 : 268435456;
                $dirty |= i4;
            }
        }
        int i26 = $dirty;
        final int obj40 = i26;
        if ($dirty4 &= i26 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i82 = -29360129;
                i3 = -458753;
                int i78 = -57345;
                if (i64 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if ($dirty3 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = shape2;
                        }
                        i17 = border2 != 0 ? traceInProgress2 : z;
                        obj9 = i23 != 0 ? traceInProgress2 : i6;
                        if (i65 & 16 != 0) {
                            elevation2 = ButtonDefaults.INSTANCE.elevation-R_JCAzs(0, 0, 0, 0, 0, restartGroup, 196608, 31);
                            $dirty3 = obj40 & i78;
                        } else {
                            elevation2 = elevation;
                            $dirty3 = obj40;
                        }
                        if (i65 & 32 != 0) {
                            shape3 = MaterialTheme.INSTANCE.getShapes(restartGroup, 6).getSmall();
                            $dirty3 &= i3;
                        } else {
                            shape3 = obj5;
                        }
                        border2 = i != 0 ? 0 : border;
                        if (i65 & 128 != 0) {
                            i22 = unbox-impl2;
                            i20 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(0, obj5, 0, unbox-impl2, 0, i78, 0);
                            $dirty3 &= i82;
                        } else {
                            i22 = unbox-impl2;
                            i20 = colors;
                        }
                        if (i22 != 0) {
                            contentPadding3 = ButtonDefaults.INSTANCE.getContentPadding();
                            i = shape3;
                            obj7 = border2;
                            obj5 = i17;
                            i6 = obj9;
                            shape2 = modifier3;
                            $dirty2 = $dirty3;
                        } else {
                            contentPadding3 = contentPadding;
                            i = shape3;
                            obj7 = border2;
                            obj5 = i17;
                            i6 = obj9;
                            shape2 = modifier3;
                            $dirty2 = $dirty3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty2 = i65 & 16 != 0 ? obj40 & i78 : obj40;
                        if (i65 & 32 != 0) {
                            $dirty2 &= i3;
                        }
                        if (i65 & 128 != 0) {
                            $dirty2 &= i82;
                        }
                        elevation2 = elevation;
                        i20 = colors;
                        obj7 = i2;
                        i = obj5;
                        obj5 = z;
                        contentPadding3 = obj11;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2116133464, $dirty2, -1, "androidx.compose.material.Button (Button.kt:103)");
                }
                if (i6 == null) {
                    restartGroup.startReplaceGroup(1050577827);
                    ComposerKt.sourceInformation(restartGroup, "105@5020L39");
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -243205057, "CC(remember):Button.kt#9igjgp");
                    border2 = restartGroup;
                    i2 = 0;
                    rememberedValue = border2.rememberedValue();
                    obj11 = 0;
                    obj31 = i38;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i39 = 0;
                        border2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        i18 = rememberedValue;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    restartGroup.endReplaceGroup();
                    obj8 = i18;
                } else {
                    restartGroup.startReplaceGroup(-243205708);
                    restartGroup.endReplaceGroup();
                    obj8 = i6;
                }
                State contentColor = i20.contentColor(obj5, restartGroup, i41 |= i46);
                if (elevation2 == null) {
                    restartGroup.startReplaceGroup(1050984484);
                } else {
                    restartGroup.startReplaceGroup(-243191939);
                    ComposerKt.sourceInformation(restartGroup, "115@5430L37");
                    constructor-impl = elevation2.elevation(obj5, (InteractionSource)obj8, restartGroup, i68 |= i72);
                }
                restartGroup.endReplaceGroup();
                if (constructor-impl != null) {
                    f = unbox-impl;
                } else {
                    i14 = 0;
                    f = constructor-impl;
                }
                ButtonKt.Button.2 anon = new ButtonKt.Button.2(contentColor, contentPadding3, obj13);
                composer3 = restartGroup;
                SurfaceKt.Surface-LPr_se0(onClick, SemanticsModifierKt.semantics$default(shape2, false, (Function1)ButtonKt.Button.1.INSTANCE, 1, 0), obj5, i, (Color)i20.backgroundColor(obj5, restartGroup, i55 |= i76).getValue().unbox-impl(), i3, Color.copy-wmQWz5c$default(ButtonKt.Button$lambda$1(contentColor), enabled, 1065353216, 0, 0, 0, 14), i5, obj7, f, obj8, (Function2)ComposableLambdaKt.rememberComposableLambda(7524271, true, anon, restartGroup, 54), composer3);
                composer = composer3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i11 = $dirty2;
                obj3 = shape2;
                obj = contentPadding3;
                obj10 = i6;
                modifier2 = obj5;
                $composer2 = obj7;
                contentPadding2 = obj32;
                interactionSource2 = i20;
                colors2 = i;
            } else {
                restartGroup.skipToGroupEnd();
                i11 = obj40;
                obj3 = shape2;
                modifier2 = z;
                composer = restartGroup;
                obj10 = i6;
                $composer2 = i2;
                obj = obj11;
                colors2 = obj5;
                contentPadding2 = elevation;
                interactionSource2 = colors;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = new ButtonKt.Button.3(onClick, obj3, modifier2, obj10, contentPadding2, colors2, $composer2, interactionSource2, obj, obj13, i64, i65);
            endRestartGroup.updateScope((Function2)$dirty2);
        }
    }

    private static final long Button$lambda$1(State<Color> $contentColor$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Color)$contentColor$delegate.getValue().unbox-impl();
    }

    public static final void OutlinedButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, androidx.compose.material.ButtonElevation elevation, Shape shape, BorderStroke border, androidx.compose.material.ButtonColors colors, PaddingValues contentPadding, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        int companion;
        int i;
        int i4;
        int i3;
        int small;
        int outlinedBorder;
        int outlinedButtonColors-RGew2ao;
        PaddingValues contentPadding2;
        boolean traceInProgress;
        int str;
        int i9;
        int i2;
        androidx.compose.material.ButtonColors buttonColors;
        int i8;
        PaddingValues paddingValues;
        int i5;
        androidx.compose.ui.Modifier.Companion companion2;
        int i10;
        int i6;
        int i7;
        androidx.compose.foundation.shape.CornerBasedShape cornerBasedShape;
        BorderStroke borderStroke;
        Composer composer = $composer;
        final int i42 = $changed;
        int i39 = i13;
        int i40 = -1776134358;
        ComposerKt.sourceInformationMarkerStart(composer, i40, "C(OutlinedButton)P(8,7,5,6,4,9!2,3)174@8227L6,175@8284L14,176@8342L22,179@8482L270:Button.kt#jmzs0o");
        if (i39 & 2 != 0) {
            companion2 = companion;
        } else {
            companion2 = modifier;
        }
        i10 = i39 & 4 != 0 ? i : enabled;
        i6 = i39 & 8 != 0 ? i4 : interactionSource;
        i7 = i39 & 16 != 0 ? i3 : elevation;
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
        ButtonKt.Button(onClick, companion2, i10, i6, i7, cornerBasedShape, borderStroke, buttonColors, paddingValues, content, $composer, i20 | i35, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final void TextButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, androidx.compose.material.ButtonElevation elevation, Shape shape, BorderStroke border, androidx.compose.material.ButtonColors colors, PaddingValues contentPadding, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        int companion;
        int i6;
        int i4;
        int i7;
        int small;
        int i;
        int textButtonColors-RGew2ao;
        PaddingValues textButtonContentPadding;
        boolean traceInProgress;
        int str;
        int i8;
        int i11;
        androidx.compose.material.ButtonColors buttonColors;
        int i9;
        PaddingValues paddingValues;
        int i10;
        androidx.compose.ui.Modifier.Companion companion2;
        int i2;
        int i12;
        int i5;
        androidx.compose.foundation.shape.CornerBasedShape cornerBasedShape;
        int i3;
        Composer composer = $composer;
        final int i45 = $changed;
        int i42 = i13;
        int i43 = 288797557;
        ComposerKt.sourceInformationMarkerStart(composer, i43, "C(TextButton)P(8,7,5,6,4,9!2,3)228@10754L6,230@10844L18,233@10990L270:Button.kt#jmzs0o");
        if (i42 & 2 != 0) {
            companion2 = companion;
        } else {
            companion2 = modifier;
        }
        i2 = i42 & 4 != 0 ? i6 : enabled;
        i12 = i42 & 8 != 0 ? i4 : interactionSource;
        i5 = i42 & 16 != 0 ? i7 : elevation;
        if (i42 & 32 != 0) {
            cornerBasedShape = small;
        } else {
            cornerBasedShape = shape;
        }
        i3 = i42 & 64 != 0 ? i : border;
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
        ButtonKt.Button(onClick, companion2, i2, i12, i5, cornerBasedShape, i3, buttonColors, paddingValues, content, $composer, i22 | i37, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final long access$Button$lambda$1(State $contentColor$delegate) {
        return ButtonKt.Button$lambda$1($contentColor$delegate);
    }
}
