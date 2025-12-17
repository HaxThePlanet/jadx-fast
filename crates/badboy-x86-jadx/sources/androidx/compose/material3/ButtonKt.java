package androidx.compose.material3;

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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0008\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001a\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0008\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001b\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0008\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001c\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0008\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001d\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0008\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001e", d2 = {"Button", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ButtonColors;", "elevation", "Landroidx/compose/material3/ButtonElevation;", "border", "Landroidx/compose/foundation/BorderStroke;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ButtonColors;Landroidx/compose/material3/ButtonElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ElevatedButton", "FilledTonalButton", "OutlinedButton", "TextButton", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ButtonKt {
    public static final void Button(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.ButtonColors colors, androidx.compose.material3.ButtonElevation elevation, BorderStroke border, PaddingValues contentPadding, MutableInteractionSource interactionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        int i6;
        int traceInProgress2;
        int defaultsInvalid;
        Object modifier3;
        Object modifier2;
        int $dirty4;
        int $dirty;
        int border2;
        int $dirty3;
        int shadowElevation$material3_release;
        int unbox-impl;
        int i19;
        Object obj;
        Object obj7;
        int i17;
        Object contentPadding2;
        Object contentPadding3;
        Object interactionSource2;
        Shape shape3;
        int buttonColors;
        boolean modifier4;
        int i11;
        int i4;
        int i5;
        Object $dirty6;
        boolean z;
        int i;
        String str2;
        Object obj4;
        int i12;
        Object obj2;
        boolean traceInProgress;
        Object obj6;
        Object $composer2;
        int changed3;
        Object obj8;
        PaddingValues colors2;
        boolean changed;
        int i8;
        Object str;
        int i21;
        int changed2;
        Object obj5;
        int i16;
        Object rememberedValue;
        boolean i10;
        int i9;
        int i3;
        int containerColor-vNxB06k$material3_release;
        int i20;
        int companion;
        long i2;
        boolean z2;
        Object shape2;
        Object obj3;
        int $dirty2;
        Object $dirty5;
        int i15;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i18;
        int i7;
        int i14;
        int obj31;
        Modifier obj32;
        Object obj33;
        int obj40;
        final Object obj10 = content;
        final int i60 = $changed;
        final int i61 = i13;
        Composer restartGroup = $composer.startRestartGroup(650121315);
        ComposerKt.sourceInformation(restartGroup, "C(Button)P(8,7,5,9,1,4!1,3,6)111@5461L5,112@5510L14,113@5575L17,134@6467L587,124@6130L924:Button.kt#uh7d8r");
        $dirty4 = $changed;
        if (i61 & 1 != 0) {
            $dirty4 |= 6;
            obj5 = onClick;
        } else {
            if (i60 & 6 == 0) {
                i19 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty4 |= i19;
            } else {
                obj5 = onClick;
            }
        }
        int i41 = i61 & 2;
        if (i41 != 0) {
            $dirty4 |= 48;
            interactionSource2 = modifier;
        } else {
            if (i60 & 48 == 0) {
                i11 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty4 |= i11;
            } else {
                interactionSource2 = modifier;
            }
        }
        int i46 = i61 & 4;
        if (i46 != 0) {
            $dirty4 |= 384;
            z = enabled;
        } else {
            if (i60 & 384 == 0) {
                i12 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty4 |= i12;
            } else {
                z = enabled;
            }
        }
        if (i60 & 3072 == 0) {
            if (i61 & 8 == 0) {
                changed3 = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj2 = shape;
            }
            $dirty4 |= changed3;
        } else {
            obj2 = shape;
        }
        if (i60 & 24576 == 0) {
            if (i61 & 16 == 0) {
                changed = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                obj8 = colors;
            }
            $dirty4 |= changed;
        } else {
            obj8 = colors;
        }
        if (i54 &= i60 == 0) {
            if (i61 & 32 == 0) {
                i8 = restartGroup.changed(elevation) ? 131072 : 65536;
            } else {
                rememberedValue = elevation;
            }
            $dirty4 |= i8;
        } else {
            rememberedValue = elevation;
        }
        i10 = i61 & 64;
        int i55 = 1572864;
        if (i10 != 0) {
            $dirty4 |= i55;
            str = border;
        } else {
            if (i55 &= i60 == 0) {
                i9 = restartGroup.changed(border) ? 1048576 : 524288;
                $dirty4 |= i9;
            } else {
                str = border;
            }
        }
        int i23 = i61 & 128;
        i3 = 12582912;
        if (i23 != 0) {
            $dirty4 |= i3;
            obj40 = i41;
            obj = contentPadding;
        } else {
            if (i60 & i3 == 0) {
                obj40 = i41;
                i3 = restartGroup.changed(contentPadding) ? 8388608 : 4194304;
                $dirty4 |= i3;
            } else {
                obj40 = i41;
                obj = contentPadding;
            }
        }
        int i42 = i61 & 256;
        int i64 = 100663296;
        if (i42 != 0) {
            $dirty4 |= i64;
            containerColor-vNxB06k$material3_release = i42;
            obj7 = interactionSource;
        } else {
            if (i60 & i64 == 0) {
                containerColor-vNxB06k$material3_release = i42;
                i20 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty4 |= i20;
            } else {
                containerColor-vNxB06k$material3_release = i42;
                obj7 = interactionSource;
            }
        }
        i2 = 805306368;
        if (i61 & 512 != 0) {
            $dirty4 |= i2;
        } else {
            if (i60 & i2 == 0) {
                i6 = restartGroup.changedInstance(obj10) ? 536870912 : 268435456;
                $dirty4 |= i6;
            }
        }
        if (i24 &= $dirty4 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i66 = -458753;
                i17 = -57345;
                if (i60 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (obj40 != null) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = interactionSource2;
                        }
                        z2 = i46 != 0 ? interactionSource2 : z;
                        i4 = 6;
                        if (i61 & 8 != 0) {
                            $dirty4 &= -7169;
                            shape2 = shape3;
                        } else {
                            shape2 = obj2;
                        }
                        if (i61 & 16 != 0) {
                            obj3 = buttonColors;
                            $dirty2 = $dirty4;
                        } else {
                            obj3 = obj8;
                            $dirty2 = $dirty4;
                        }
                        if (i61 & 32 != 0) {
                            $dirty2 &= i66;
                            rememberedValue = $dirty;
                        }
                        border2 = i10 != 0 ? 0 : border;
                        if (i23 != 0) {
                            contentPadding2 = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding2 = contentPadding;
                        }
                        if (containerColor-vNxB06k$material3_release != 0) {
                            i10 = z2;
                            i9 = shape2;
                            obj8 = obj3;
                            i5 = $dirty2;
                            i = 650121315;
                            $dirty5 = border2;
                            $dirty3 = i45;
                            interactionSource2 = modifier3;
                            modifier2 = rememberedValue;
                        } else {
                            interactionSource2 = modifier3;
                            modifier2 = rememberedValue;
                            i10 = z2;
                            i9 = shape2;
                            obj8 = obj3;
                            i5 = $dirty2;
                            i = 650121315;
                            $dirty5 = border2;
                            $dirty3 = interactionSource;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i61 & 8 != 0) {
                            $dirty4 &= -7169;
                        }
                        if (i61 & 16 != 0) {
                            $dirty4 &= i17;
                        }
                        if (i61 & 32 != 0) {
                            contentPadding2 = contentPadding;
                            $dirty3 = interactionSource;
                            i5 = i28;
                            i10 = z;
                            i9 = obj2;
                            $dirty5 = str;
                            modifier2 = rememberedValue;
                            i = 650121315;
                        } else {
                            contentPadding2 = contentPadding;
                            i5 = $dirty4;
                            i10 = z;
                            i9 = obj2;
                            $dirty5 = str;
                            modifier2 = rememberedValue;
                            i = 650121315;
                            $dirty3 = interactionSource;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i, i5, -1, "androidx.compose.material3.Button (Button.kt:118)");
                }
                restartGroup.startReplaceGroup(-239156623);
                ComposerKt.sourceInformation(restartGroup, "120@5882L39");
                if ($dirty3 == 0) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -239155972, "CC(remember):Button.kt#9igjgp");
                    str2 = 0;
                    traceInProgress = restartGroup;
                    str = 0;
                    rememberedValue = traceInProgress.rememberedValue();
                    containerColor-vNxB06k$material3_release = 0;
                    obj31 = $dirty3;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i40 = 0;
                        traceInProgress.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        $dirty3 = rememberedValue;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    i15 = $dirty3;
                } else {
                    i15 = obj31;
                }
                restartGroup.endReplaceGroup();
                long contentColor-vNxB06k$material3_release = obj8.contentColor-vNxB06k$material3_release(i10);
                restartGroup.startReplaceGroup(-239150048);
                ComposerKt.sourceInformation(restartGroup, "123@6067L43");
                if (modifier2 == null) {
                    shadowElevation$material3_release = 0;
                } else {
                    shadowElevation$material3_release = modifier2.shadowElevation$material3_release(i10, (InteractionSource)i15, restartGroup, i38 |= rememberedValue);
                }
                restartGroup.endReplaceGroup();
                if (shadowElevation$material3_release != 0) {
                    obj3 = unbox-impl;
                } else {
                    str = 0;
                    obj3 = rememberedValue;
                }
                int i62 = 1;
                ButtonKt.Button.2 anon = new ButtonKt.Button.2(contentColor-vNxB06k$material3_release, traceInProgress, contentPadding2, obj10);
                SurfaceKt.Surface-o_FOJdg(obj5, SemanticsModifierKt.semantics$default(interactionSource2, false, (Function1)ButtonKt.Button.1.INSTANCE, i62, 0), i10, i9, obj8.containerColor-vNxB06k$material3_release(i10), companion, contentColor-vNxB06k$material3_release, z2, 0, obj3, $dirty5, i15, (Function2)ComposableLambdaKt.rememberComposableLambda(956488494, i62, anon, restartGroup, 54), restartGroup, i32 | $dirty4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i21 = obj31;
                obj6 = obj33;
                i16 = i5;
                obj4 = obj8;
                $dirty6 = i9;
                $composer2 = $dirty5;
                colors2 = contentPadding2;
                contentPadding3 = interactionSource2;
                modifier4 = i10;
            } else {
                restartGroup.skipToGroupEnd();
                i16 = $dirty4;
                contentPadding3 = interactionSource2;
                modifier4 = z;
                $dirty6 = obj2;
                composer = restartGroup;
                obj4 = obj8;
                $composer2 = str;
                obj6 = rememberedValue;
                colors2 = contentPadding;
                i21 = interactionSource;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ButtonKt.Button.3(onClick, contentPadding3, modifier4, $dirty6, obj4, obj6, $composer2, colors2, i21, obj10, i60, i61);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void ElevatedButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.ButtonColors colors, androidx.compose.material3.ButtonElevation elevation, BorderStroke border, PaddingValues contentPadding, MutableInteractionSource interactionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj3;
        Object obj4;
        boolean traceInProgress2;
        int defaultsInvalid;
        Object modifier2;
        int modifier3;
        int $dirty3;
        int $dirty2;
        Object contentPadding2;
        int i19;
        Object obj;
        Object obj2;
        int i;
        boolean traceInProgress;
        Object elevatedButtonColors;
        boolean z;
        int elevatedShape;
        int i21;
        Object obj6;
        int i6;
        boolean z3;
        Object obj10;
        int i4;
        Object obj11;
        Object obj12;
        Object $composer2;
        int changed2;
        Object obj5;
        PaddingValues paddingValues;
        boolean changed3;
        int i8;
        int i3;
        int i7;
        int i5;
        int changed;
        Object obj9;
        Object obj13;
        int i18;
        Object i10;
        Object border2;
        int i15;
        int i2;
        int i17;
        int i9;
        int i11;
        Object i16;
        Object enabled2;
        boolean z2;
        Object shape2;
        Object obj7;
        int colors2;
        Object obj8;
        Function3 $dirty;
        Composer composer;
        int i20;
        int i12;
        int i14;
        final int i68 = $changed;
        final int i69 = i13;
        Composer restartGroup = $composer.startRestartGroup(1466887385);
        ComposerKt.sourceInformation(restartGroup, "C(ElevatedButton)P(8,7,5,9,1,4!1,3,6)204@9975L13,205@10032L22,206@10105L25,212@10343L314:Button.kt#uh7d8r");
        $dirty3 = $changed;
        if (i69 & 1 != 0) {
            $dirty3 |= 6;
            obj13 = onClick;
        } else {
            if (i68 & 6 == 0) {
                i19 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty3 |= i19;
            } else {
                obj13 = onClick;
            }
        }
        int i38 = i69 & 2;
        if (i38 != 0) {
            $dirty3 |= 48;
            elevatedButtonColors = modifier;
        } else {
            if (i68 & 48 == 0) {
                i21 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i21;
            } else {
                elevatedButtonColors = modifier;
            }
        }
        i6 = i69 & 4;
        if (i6 != 0) {
            $dirty3 |= 384;
            z3 = enabled;
        } else {
            if (i68 & 384 == 0) {
                i4 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty3 |= i4;
            } else {
                z3 = enabled;
            }
        }
        if (i68 & 3072 == 0) {
            if (i69 & 8 == 0) {
                changed2 = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj11 = shape;
            }
            $dirty3 |= changed2;
        } else {
            obj11 = shape;
        }
        if (i68 & 24576 == 0) {
            if (i69 & 16 == 0) {
                changed3 = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                obj5 = colors;
            }
            $dirty3 |= changed3;
        } else {
            obj5 = colors;
        }
        if (i67 &= i68 == 0) {
            if (i69 & 32 == 0) {
                i8 = restartGroup.changed(elevation) ? 131072 : 65536;
            } else {
                obj9 = elevation;
            }
            $dirty3 |= i8;
        } else {
            obj9 = elevation;
        }
        i10 = i69 & 64;
        i3 = 1572864;
        if (i10 != 0) {
            $dirty3 |= i3;
            border2 = border;
        } else {
            if (i3 &= i68 == 0) {
                i3 = restartGroup.changed(border) ? 1048576 : 524288;
                $dirty3 |= i3;
            } else {
                border2 = border;
            }
        }
        i5 = i69 & 128;
        i15 = 12582912;
        if (i5 != 0) {
            $dirty3 |= i15;
            obj3 = contentPadding;
        } else {
            if (i68 & i15 == 0) {
                i2 = restartGroup.changed(contentPadding) ? 8388608 : 4194304;
                $dirty3 |= i2;
            } else {
                obj3 = contentPadding;
            }
        }
        int i39 = i69 & 256;
        int i70 = 100663296;
        if (i39 != 0) {
            $dirty3 |= i70;
            i17 = i39;
            obj = interactionSource;
        } else {
            if (i68 & i70 == 0) {
                i17 = i39;
                i9 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty3 |= i9;
            } else {
                i17 = i39;
                obj = interactionSource;
            }
        }
        i11 = 805306368;
        if (i69 & 512 != 0) {
            $dirty3 |= i11;
            obj4 = content;
        } else {
            if (i68 & i11 == 0) {
                i11 = restartGroup.changedInstance(content) ? 536870912 : 268435456;
                $dirty3 |= i11;
            } else {
                obj4 = content;
            }
        }
        if ($dirty3 & i16 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i72 = -458753;
                i = -57345;
                if (i68 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i38 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = elevatedButtonColors;
                        }
                        z2 = i6 != 0 ? elevatedButtonColors : z3;
                        i6 = 6;
                        if (i69 & 8 != 0) {
                            $dirty3 &= -7169;
                            obj7 = elevatedShape;
                        } else {
                            obj7 = obj11;
                        }
                        if (i69 & 16 != 0) {
                            obj8 = elevatedButtonColors;
                            $dirty = $dirty3;
                        } else {
                            obj8 = obj5;
                            $dirty = $dirty3;
                        }
                        if (i69 & 32 != 0) {
                            i20 = i64;
                            $dirty &= i72;
                            obj9 = $dirty2;
                        } else {
                            i20 = i5;
                        }
                        if (i10 != 0) {
                            border2 = $dirty2;
                        }
                        if (i20 != 0) {
                            contentPadding2 = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding2 = contentPadding;
                        }
                        if (i17 != 0) {
                            enabled2 = border2;
                            border2 = z5;
                            i10 = modifier2;
                            i16 = obj9;
                            i15 = obj7;
                            i17 = obj8;
                            modifier3 = 1466887385;
                            shape2 = contentPadding2;
                            colors2 = i;
                            $dirty3 = $dirty;
                        } else {
                            enabled2 = border2;
                            border2 = z4;
                            i10 = modifier2;
                            i16 = obj9;
                            i15 = obj7;
                            i17 = obj8;
                            modifier3 = 1466887385;
                            colors2 = interactionSource;
                            shape2 = contentPadding2;
                            $dirty3 = $dirty;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i69 & 8 != 0) {
                            $dirty3 &= -7169;
                        }
                        if (i69 & 16 != 0) {
                            $dirty3 &= i;
                        }
                        if (i69 & 32 != 0) {
                            shape2 = contentPadding;
                            colors2 = interactionSource;
                            $dirty3 = i28;
                            i10 = elevatedButtonColors;
                            i15 = obj11;
                            i17 = obj5;
                            i16 = obj9;
                            enabled2 = border2;
                            modifier3 = 1466887385;
                            border2 = z3;
                        } else {
                            shape2 = contentPadding;
                            colors2 = interactionSource;
                            i10 = elevatedButtonColors;
                            i15 = obj11;
                            i17 = obj5;
                            i16 = obj9;
                            enabled2 = border2;
                            modifier3 = 1466887385;
                            border2 = z3;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier3, $dirty3, -1, "androidx.compose.material3.ElevatedButton (Button.kt:212)");
                }
                ButtonKt.Button(obj13, i10, border2, i15, i17, i16, enabled2, shape2, colors2, content, restartGroup, i37 | i56, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = i10;
                z = border2;
                obj6 = i15;
                obj10 = i17;
                obj12 = i16;
                $composer2 = enabled2;
                paddingValues = shape2;
                i7 = colors2;
                i18 = $dirty3;
            } else {
                restartGroup.skipToGroupEnd();
                i7 = interactionSource;
                obj2 = elevatedButtonColors;
                z = z3;
                obj6 = obj11;
                composer = restartGroup;
                obj10 = obj5;
                obj12 = obj9;
                $composer2 = border2;
                paddingValues = contentPadding;
                i18 = $dirty3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ButtonKt.ElevatedButton.1(onClick, obj2, z, obj6, obj10, obj12, $composer2, paddingValues, i7, content, i68, i69);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void FilledTonalButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.ButtonColors colors, androidx.compose.material3.ButtonElevation elevation, BorderStroke border, PaddingValues contentPadding, MutableInteractionSource interactionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj10;
        Object obj;
        boolean traceInProgress2;
        int defaultsInvalid;
        Object modifier3;
        int modifier2;
        int $dirty;
        int $dirty2;
        Object contentPadding2;
        int i8;
        Object obj6;
        Object obj3;
        int i10;
        boolean traceInProgress;
        Object filledTonalButtonColors;
        boolean z2;
        int filledTonalShape;
        int i5;
        Object obj4;
        int i12;
        boolean z3;
        Object obj2;
        int i9;
        Object obj7;
        Object obj11;
        Object $composer2;
        int changed;
        Object obj5;
        PaddingValues paddingValues;
        boolean changed3;
        int i16;
        int i17;
        int i21;
        int i11;
        int changed2;
        Object obj13;
        Object obj9;
        int i14;
        Object i;
        Object border2;
        int i18;
        int i20;
        int i7;
        int i4;
        int i2;
        Object i15;
        Object enabled2;
        boolean z;
        Object shape2;
        Object obj12;
        int colors2;
        Object obj8;
        Function3 $dirty3;
        Composer composer;
        int i3;
        int i6;
        int i19;
        final int i68 = $changed;
        final int i69 = i13;
        Composer restartGroup = $composer.startRestartGroup(-1717924381);
        ComposerKt.sourceInformation(restartGroup, "C(FilledTonalButton)P(8,7,5,9,1,4!1,3,6)277@13636L16,278@13696L25,279@13772L28,285@14013L314:Button.kt#uh7d8r");
        $dirty = $changed;
        if (i69 & 1 != 0) {
            $dirty |= 6;
            obj9 = onClick;
        } else {
            if (i68 & 6 == 0) {
                i8 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty |= i8;
            } else {
                obj9 = onClick;
            }
        }
        int i38 = i69 & 2;
        if (i38 != 0) {
            $dirty |= 48;
            filledTonalButtonColors = modifier;
        } else {
            if (i68 & 48 == 0) {
                i5 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i5;
            } else {
                filledTonalButtonColors = modifier;
            }
        }
        i12 = i69 & 4;
        if (i12 != 0) {
            $dirty |= 384;
            z3 = enabled;
        } else {
            if (i68 & 384 == 0) {
                i9 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty |= i9;
            } else {
                z3 = enabled;
            }
        }
        if (i68 & 3072 == 0) {
            if (i69 & 8 == 0) {
                changed = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj7 = shape;
            }
            $dirty |= changed;
        } else {
            obj7 = shape;
        }
        if (i68 & 24576 == 0) {
            if (i69 & 16 == 0) {
                changed3 = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                obj5 = colors;
            }
            $dirty |= changed3;
        } else {
            obj5 = colors;
        }
        if (i67 &= i68 == 0) {
            if (i69 & 32 == 0) {
                i16 = restartGroup.changed(elevation) ? 131072 : 65536;
            } else {
                obj13 = elevation;
            }
            $dirty |= i16;
        } else {
            obj13 = elevation;
        }
        i = i69 & 64;
        i17 = 1572864;
        if (i != 0) {
            $dirty |= i17;
            border2 = border;
        } else {
            if (i17 &= i68 == 0) {
                i17 = restartGroup.changed(border) ? 1048576 : 524288;
                $dirty |= i17;
            } else {
                border2 = border;
            }
        }
        i11 = i69 & 128;
        i18 = 12582912;
        if (i11 != 0) {
            $dirty |= i18;
            obj10 = contentPadding;
        } else {
            if (i68 & i18 == 0) {
                i20 = restartGroup.changed(contentPadding) ? 8388608 : 4194304;
                $dirty |= i20;
            } else {
                obj10 = contentPadding;
            }
        }
        int i39 = i69 & 256;
        int i70 = 100663296;
        if (i39 != 0) {
            $dirty |= i70;
            i7 = i39;
            obj6 = interactionSource;
        } else {
            if (i68 & i70 == 0) {
                i7 = i39;
                i4 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty |= i4;
            } else {
                i7 = i39;
                obj6 = interactionSource;
            }
        }
        i2 = 805306368;
        if (i69 & 512 != 0) {
            $dirty |= i2;
            obj = content;
        } else {
            if (i68 & i2 == 0) {
                i2 = restartGroup.changedInstance(content) ? 536870912 : 268435456;
                $dirty |= i2;
            } else {
                obj = content;
            }
        }
        if ($dirty & i15 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i72 = -458753;
                i10 = -57345;
                if (i68 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i38 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = filledTonalButtonColors;
                        }
                        z = i12 != 0 ? filledTonalButtonColors : z3;
                        i12 = 6;
                        if (i69 & 8 != 0) {
                            $dirty &= -7169;
                            obj12 = filledTonalShape;
                        } else {
                            obj12 = obj7;
                        }
                        if (i69 & 16 != 0) {
                            obj8 = filledTonalButtonColors;
                            $dirty3 = $dirty;
                        } else {
                            obj8 = obj5;
                            $dirty3 = $dirty;
                        }
                        if (i69 & 32 != 0) {
                            i3 = i64;
                            $dirty3 &= i72;
                            obj13 = $dirty2;
                        } else {
                            i3 = i11;
                        }
                        if (i != 0) {
                            border2 = $dirty2;
                        }
                        if (i3 != 0) {
                            contentPadding2 = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding2 = contentPadding;
                        }
                        if (i7 != 0) {
                            enabled2 = border2;
                            border2 = z5;
                            i = modifier3;
                            i15 = obj13;
                            i18 = obj12;
                            i7 = obj8;
                            modifier2 = -1717924381;
                            shape2 = contentPadding2;
                            colors2 = i10;
                            $dirty = $dirty3;
                        } else {
                            enabled2 = border2;
                            border2 = z4;
                            i = modifier3;
                            i15 = obj13;
                            i18 = obj12;
                            i7 = obj8;
                            modifier2 = -1717924381;
                            colors2 = interactionSource;
                            shape2 = contentPadding2;
                            $dirty = $dirty3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i69 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        if (i69 & 16 != 0) {
                            $dirty &= i10;
                        }
                        if (i69 & 32 != 0) {
                            shape2 = contentPadding;
                            colors2 = interactionSource;
                            $dirty = i28;
                            i = filledTonalButtonColors;
                            i18 = obj7;
                            i7 = obj5;
                            i15 = obj13;
                            enabled2 = border2;
                            modifier2 = -1717924381;
                            border2 = z3;
                        } else {
                            shape2 = contentPadding;
                            colors2 = interactionSource;
                            i = filledTonalButtonColors;
                            i18 = obj7;
                            i7 = obj5;
                            i15 = obj13;
                            enabled2 = border2;
                            modifier2 = -1717924381;
                            border2 = z3;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier2, $dirty, -1, "androidx.compose.material3.FilledTonalButton (Button.kt:285)");
                }
                ButtonKt.Button(obj9, i, border2, i18, i7, i15, enabled2, shape2, colors2, content, restartGroup, i37 | i56, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = i;
                z2 = border2;
                obj4 = i18;
                obj2 = i7;
                obj11 = i15;
                $composer2 = enabled2;
                paddingValues = shape2;
                i21 = colors2;
                i14 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                i21 = interactionSource;
                obj3 = filledTonalButtonColors;
                z2 = z3;
                obj4 = obj7;
                composer = restartGroup;
                obj2 = obj5;
                obj11 = obj13;
                $composer2 = border2;
                paddingValues = contentPadding;
                i14 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ButtonKt.FilledTonalButton.1(onClick, obj3, z2, obj4, obj2, obj11, $composer2, paddingValues, i21, content, i68, i69);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void OutlinedButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.ButtonColors colors, androidx.compose.material3.ButtonElevation elevation, BorderStroke border, PaddingValues contentPadding, MutableInteractionSource interactionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj9;
        Object obj7;
        Object obj3;
        int traceInProgress;
        int contentPadding3;
        int defaultsInvalid;
        int outlinedShape;
        int shape2;
        int outlinedButtonBorder;
        Object contentPadding2;
        Object restartGroup;
        int $dirty2;
        Object $dirty;
        int i19;
        int i5;
        boolean traceInProgress2;
        boolean z;
        Object str;
        Object obj10;
        int i2;
        int i20;
        Object obj;
        boolean z2;
        Object obj2;
        int i16;
        Object obj13;
        Object obj6;
        int changed3;
        Object obj4;
        PaddingValues paddingValues;
        boolean changed;
        int i;
        int i10;
        Object obj5;
        Object obj11;
        int i4;
        int i6;
        Object border2;
        int changed2;
        boolean i3;
        int i7;
        int i8;
        int i9;
        int i11;
        int i18;
        Object i15;
        Object obj12;
        Object obj8;
        int i12;
        Function3 function3;
        Composer composer;
        int i17;
        int i14;
        final int i65 = $changed;
        final int i66 = i13;
        restartGroup = $composer.startRestartGroup(-1694808287);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedButton)P(8,7,5,9,1,4!1,3,6)349@17203L13,350@17260L22,352@17367L29,357@17575L314:Button.kt#uh7d8r");
        $dirty2 = $changed;
        if (i66 & 1 != 0) {
            $dirty2 |= 6;
            obj11 = onClick;
        } else {
            if (i65 & 6 == 0) {
                i19 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty2 |= i19;
            } else {
                obj11 = onClick;
            }
        }
        int i38 = i66 & 2;
        if (i38 != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i65 & 48 == 0) {
                i2 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i2;
            } else {
                str = modifier;
            }
        }
        i20 = i66 & 4;
        if (i20 != 0) {
            $dirty2 |= 384;
            z2 = enabled;
        } else {
            if (i65 & 384 == 0) {
                i16 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty2 |= i16;
            } else {
                z2 = enabled;
            }
        }
        if (i65 & 3072 == 0) {
            if (i66 & 8 == 0) {
                changed3 = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj13 = shape;
            }
            $dirty2 |= changed3;
        } else {
            obj13 = shape;
        }
        if (i65 & 24576 == 0) {
            if (i66 & 16 == 0) {
                changed = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                obj4 = colors;
            }
            $dirty2 |= changed;
        } else {
            obj4 = colors;
        }
        i = i66 & 32;
        int i63 = 196608;
        if (i != 0) {
            $dirty2 |= i63;
            obj5 = elevation;
        } else {
            if (i63 &= i65 == 0) {
                i6 = restartGroup.changed(elevation) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                obj5 = elevation;
            }
        }
        if (i67 &= i65 == 0) {
            if (i66 & 64 == 0) {
                changed2 = restartGroup.changed(border) ? 1048576 : 524288;
            } else {
                border2 = border;
            }
            $dirty2 |= changed2;
        } else {
            border2 = border;
        }
        i3 = i66 & 128;
        i7 = 12582912;
        if (i3 != 0) {
            $dirty2 |= i7;
            obj9 = contentPadding;
        } else {
            if (i65 & i7 == 0) {
                i8 = restartGroup.changed(contentPadding) ? 8388608 : 4194304;
                $dirty2 |= i8;
            } else {
                obj9 = contentPadding;
            }
        }
        int i22 = i66 & 256;
        int i70 = 100663296;
        if (i22 != 0) {
            $dirty2 |= i70;
            i9 = i22;
            obj7 = interactionSource;
        } else {
            if (i65 & i70 == 0) {
                i9 = i22;
                i11 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty2 |= i11;
            } else {
                i9 = i22;
                obj7 = interactionSource;
            }
        }
        i18 = 805306368;
        if (i66 & 512 != 0) {
            $dirty2 |= i18;
            obj3 = content;
        } else {
            if (i65 & i18 == 0) {
                i18 = restartGroup.changedInstance(content) ? 536870912 : 268435456;
                $dirty2 |= i18;
            } else {
                obj3 = content;
            }
        }
        if ($dirty2 & i15 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i5 = -3670017;
                int i72 = -57345;
                if (i65 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i38 != 0) {
                            str = defaultsInvalid;
                        }
                        if (i20 != 0) {
                            z2 = defaultsInvalid;
                        }
                        i20 = 6;
                        if (i66 & 8 != 0) {
                            $dirty2 &= -7169;
                            obj13 = outlinedShape;
                        }
                        if (i66 & 16 != 0) {
                            $dirty2 &= i72;
                            obj4 = shape2;
                        }
                        if (i != 0) {
                            obj5 = shape2;
                        }
                        if (i66 & 64 != 0) {
                            $dirty2 &= i5;
                            border2 = outlinedButtonBorder;
                        }
                        if (i3 != 0) {
                            contentPadding2 = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding2 = contentPadding;
                        }
                        if (i9 != 0) {
                            obj8 = contentPadding2;
                            i12 = i5;
                            i3 = z2;
                            i7 = obj13;
                            i9 = obj4;
                            i15 = obj5;
                            obj12 = border2;
                            contentPadding3 = -1694808287;
                            border2 = str;
                        } else {
                            i12 = interactionSource;
                            obj8 = contentPadding2;
                            i3 = z2;
                            i7 = obj13;
                            i9 = obj4;
                            i15 = obj5;
                            obj12 = border2;
                            contentPadding3 = -1694808287;
                            border2 = str;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i66 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (i66 & 16 != 0) {
                            $dirty2 &= i72;
                        }
                        if (i66 & 64 != 0) {
                            obj8 = contentPadding;
                            i12 = interactionSource;
                            $dirty2 = i37;
                            i3 = z2;
                            i7 = obj13;
                            i9 = obj4;
                            i15 = obj5;
                            obj12 = border2;
                            contentPadding3 = -1694808287;
                            border2 = str;
                        } else {
                            obj8 = contentPadding;
                            i12 = interactionSource;
                            i3 = z2;
                            i7 = obj13;
                            i9 = obj4;
                            i15 = obj5;
                            obj12 = border2;
                            contentPadding3 = -1694808287;
                            border2 = str;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(contentPadding3, $dirty2, -1, "androidx.compose.material3.OutlinedButton (Button.kt:357)");
                }
                ButtonKt.Button(obj11, border2, i3, i7, i9, i15, obj12, obj8, i12, content, restartGroup, i33 | i54, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i4 = $dirty2;
                $dirty = border2;
                z = i3;
                obj10 = i7;
                obj = i9;
                obj2 = i15;
                obj6 = obj12;
                paddingValues = obj8;
                i10 = i12;
            } else {
                restartGroup.skipToGroupEnd();
                i10 = interactionSource;
                composer = restartGroup;
                i4 = $dirty2;
                $dirty = str;
                z = z2;
                obj10 = obj13;
                obj = obj4;
                obj2 = obj5;
                obj6 = border2;
                paddingValues = contentPadding;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ButtonKt.OutlinedButton.1(onClick, $dirty, z, obj10, obj, obj2, obj6, paddingValues, i10, content, i65, i66);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void TextButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.ButtonColors colors, androidx.compose.material3.ButtonElevation elevation, BorderStroke border, PaddingValues contentPadding, MutableInteractionSource interactionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj2;
        Object obj;
        Object obj11;
        int traceInProgress;
        int contentPadding3;
        int defaultsInvalid;
        int textShape;
        int shape2;
        Object contentPadding2;
        Object restartGroup;
        int $dirty;
        Object $dirty2;
        int i11;
        int i9;
        boolean traceInProgress2;
        boolean z;
        Object str;
        Object obj4;
        int i12;
        int i4;
        Object obj10;
        boolean z2;
        Object obj3;
        int i7;
        Object obj12;
        Object obj13;
        int changed2;
        Object obj5;
        PaddingValues paddingValues;
        boolean changed;
        int i;
        Object obj7;
        Object obj6;
        int i15;
        int i18;
        Object i3;
        Object border2;
        int i5;
        int i8;
        int i14;
        int i16;
        int i6;
        int i17;
        Object i19;
        Object obj8;
        int obj9;
        Function3 function3;
        Composer composer;
        int i2;
        int i10;
        final int i63 = $changed;
        final int i64 = i13;
        restartGroup = $composer.startRestartGroup(-2106428362);
        ComposerKt.sourceInformation(restartGroup, "C(TextButton)P(8,7,5,9,1,4!1,3,6)422@20900L9,423@20953L18,430@21234L314:Button.kt#uh7d8r");
        $dirty = $changed;
        if (i64 & 1 != 0) {
            $dirty |= 6;
            obj6 = onClick;
        } else {
            if (i63 & 6 == 0) {
                i11 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty |= i11;
            } else {
                obj6 = onClick;
            }
        }
        int i37 = i64 & 2;
        if (i37 != 0) {
            $dirty |= 48;
            str = modifier;
        } else {
            if (i63 & 48 == 0) {
                i12 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i12;
            } else {
                str = modifier;
            }
        }
        i4 = i64 & 4;
        if (i4 != 0) {
            $dirty |= 384;
            z2 = enabled;
        } else {
            if (i63 & 384 == 0) {
                i7 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty |= i7;
            } else {
                z2 = enabled;
            }
        }
        if (i63 & 3072 == 0) {
            if (i64 & 8 == 0) {
                changed2 = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj12 = shape;
            }
            $dirty |= changed2;
        } else {
            obj12 = shape;
        }
        if (i63 & 24576 == 0) {
            if (i64 & 16 == 0) {
                changed = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                obj5 = colors;
            }
            $dirty |= changed;
        } else {
            obj5 = colors;
        }
        int i60 = i64 & 32;
        int i61 = 196608;
        if (i60 != 0) {
            $dirty |= i61;
            obj7 = elevation;
        } else {
            if (i61 &= i63 == 0) {
                i18 = restartGroup.changed(elevation) ? 131072 : 65536;
                $dirty |= i18;
            } else {
                obj7 = elevation;
            }
        }
        i3 = i64 & 64;
        int i65 = 1572864;
        if (i3 != 0) {
            $dirty |= i65;
            border2 = border;
        } else {
            if (i65 &= i63 == 0) {
                i5 = restartGroup.changed(border) ? 1048576 : 524288;
                $dirty |= i5;
            } else {
                border2 = border;
            }
        }
        int i21 = i64 & 128;
        int i67 = 12582912;
        if (i21 != 0) {
            $dirty |= i67;
            i8 = i21;
            obj2 = contentPadding;
        } else {
            if (i63 & i67 == 0) {
                i8 = i21;
                i14 = restartGroup.changed(contentPadding) ? 8388608 : 4194304;
                $dirty |= i14;
            } else {
                i8 = i21;
                obj2 = contentPadding;
            }
        }
        int i22 = i64 & 256;
        int i69 = 100663296;
        if (i22 != 0) {
            $dirty |= i69;
            i16 = i22;
            obj = interactionSource;
        } else {
            if (i63 & i69 == 0) {
                i16 = i22;
                i6 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty |= i6;
            } else {
                i16 = i22;
                obj = interactionSource;
            }
        }
        i17 = 805306368;
        if (i64 & 512 != 0) {
            $dirty |= i17;
            obj11 = content;
        } else {
            if (i63 & i17 == 0) {
                i17 = restartGroup.changedInstance(content) ? 536870912 : 268435456;
                $dirty |= i17;
            } else {
                obj11 = content;
            }
        }
        if ($dirty & i19 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i9 = -57345;
                if (i63 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i37 != 0) {
                            str = defaultsInvalid;
                        }
                        if (i4 != 0) {
                            z2 = defaultsInvalid;
                        }
                        i4 = 6;
                        if (i64 & 8 != 0) {
                            $dirty &= -7169;
                            obj12 = textShape;
                        }
                        if (i64 & 16 != 0) {
                            $dirty &= i9;
                            obj5 = shape2;
                        }
                        if (i60 != 0) {
                            obj7 = shape2;
                        }
                        if (i3 != 0) {
                            border2 = shape2;
                        }
                        if (i8 != 0) {
                            contentPadding2 = ButtonDefaults.INSTANCE.getTextButtonContentPadding();
                        } else {
                            contentPadding2 = contentPadding;
                        }
                        if (i16 != 0) {
                            obj8 = contentPadding2;
                            obj9 = i9;
                            i3 = str;
                            i5 = obj12;
                            i8 = obj5;
                            i16 = obj7;
                            i19 = border2;
                            contentPadding3 = -2106428362;
                            border2 = z2;
                        } else {
                            obj9 = interactionSource;
                            obj8 = contentPadding2;
                            i3 = str;
                            i5 = obj12;
                            i8 = obj5;
                            i16 = obj7;
                            i19 = border2;
                            contentPadding3 = -2106428362;
                            border2 = z2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i64 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        if (i64 & 16 != 0) {
                            obj8 = contentPadding;
                            obj9 = interactionSource;
                            $dirty = i27;
                            i3 = str;
                            i5 = obj12;
                            i8 = obj5;
                            i16 = obj7;
                            i19 = border2;
                            contentPadding3 = -2106428362;
                            border2 = z2;
                        } else {
                            obj8 = contentPadding;
                            obj9 = interactionSource;
                            i3 = str;
                            i5 = obj12;
                            i8 = obj5;
                            i16 = obj7;
                            i19 = border2;
                            contentPadding3 = -2106428362;
                            border2 = z2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(contentPadding3, $dirty, -1, "androidx.compose.material3.TextButton (Button.kt:430)");
                }
                ButtonKt.Button(obj6, i3, border2, i5, i8, i16, i19, obj8, obj9, content, restartGroup, i36 | i53, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i15 = $dirty;
                $dirty2 = i3;
                z = border2;
                obj4 = i5;
                obj10 = i8;
                obj3 = i16;
                obj13 = i19;
                paddingValues = obj8;
                i = obj9;
            } else {
                restartGroup.skipToGroupEnd();
                i = interactionSource;
                composer = restartGroup;
                i15 = $dirty;
                $dirty2 = str;
                z = z2;
                obj4 = obj12;
                obj10 = obj5;
                obj3 = obj7;
                obj13 = border2;
                paddingValues = contentPadding;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ButtonKt.TextButton.1(onClick, $dirty2, z, obj4, obj10, obj3, obj13, paddingValues, i, content, i63, i64);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }
}
