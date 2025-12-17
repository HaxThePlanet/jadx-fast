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
        int i10;
        int traceInProgress;
        int defaultsInvalid;
        Object modifier3;
        Object modifier2;
        int $dirty6;
        int $dirty2;
        int border2;
        int $dirty5;
        int shadowElevation$material3_release;
        int unbox-impl;
        int i4;
        Object obj3;
        Object obj7;
        int i5;
        Object contentPadding2;
        Object contentPadding3;
        Object interactionSource2;
        Shape shape3;
        int buttonColors;
        boolean modifier4;
        int i;
        int i20;
        int i8;
        Object $dirty3;
        boolean z2;
        int i12;
        String str2;
        Object obj2;
        int i21;
        Object obj8;
        boolean traceInProgress2;
        Object obj6;
        Object $composer2;
        int changed;
        Object obj;
        PaddingValues colors2;
        boolean changed3;
        int i15;
        Object str;
        int i11;
        int changed2;
        Object obj5;
        int i7;
        Object rememberedValue;
        boolean i9;
        int i6;
        int i3;
        int containerColor-vNxB06k$material3_release;
        int i17;
        int companion;
        long i18;
        boolean z;
        Object shape2;
        Object obj4;
        int $dirty4;
        Object $dirty;
        int i14;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i2;
        int i19;
        int i16;
        int obj31;
        Modifier obj32;
        Object obj33;
        int obj40;
        final Object obj10 = content;
        final int i60 = $changed;
        final int i61 = i13;
        Composer restartGroup = $composer.startRestartGroup(650121315);
        ComposerKt.sourceInformation(restartGroup, "C(Button)P(8,7,5,9,1,4!1,3,6)111@5461L5,112@5510L14,113@5575L17,134@6467L587,124@6130L924:Button.kt#uh7d8r");
        $dirty6 = $changed;
        if (i61 & 1 != 0) {
            $dirty6 |= 6;
            obj5 = onClick;
        } else {
            if (i60 & 6 == 0) {
                i4 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty6 |= i4;
            } else {
                obj5 = onClick;
            }
        }
        int i41 = i61 & 2;
        if (i41 != 0) {
            $dirty6 |= 48;
            interactionSource2 = modifier;
        } else {
            if (i60 & 48 == 0) {
                i = restartGroup.changed(modifier) ? 32 : 16;
                $dirty6 |= i;
            } else {
                interactionSource2 = modifier;
            }
        }
        int i46 = i61 & 4;
        if (i46 != 0) {
            $dirty6 |= 384;
            z2 = enabled;
        } else {
            if (i60 & 384 == 0) {
                i21 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty6 |= i21;
            } else {
                z2 = enabled;
            }
        }
        if (i60 & 3072 == 0) {
            if (i61 & 8 == 0) {
                changed = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj8 = shape;
            }
            $dirty6 |= changed;
        } else {
            obj8 = shape;
        }
        if (i60 & 24576 == 0) {
            if (i61 & 16 == 0) {
                changed3 = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                obj = colors;
            }
            $dirty6 |= changed3;
        } else {
            obj = colors;
        }
        if (i54 &= i60 == 0) {
            if (i61 & 32 == 0) {
                i15 = restartGroup.changed(elevation) ? 131072 : 65536;
            } else {
                rememberedValue = elevation;
            }
            $dirty6 |= i15;
        } else {
            rememberedValue = elevation;
        }
        i9 = i61 & 64;
        int i55 = 1572864;
        if (i9 != 0) {
            $dirty6 |= i55;
            str = border;
        } else {
            if (i55 &= i60 == 0) {
                i6 = restartGroup.changed(border) ? 1048576 : 524288;
                $dirty6 |= i6;
            } else {
                str = border;
            }
        }
        int i23 = i61 & 128;
        i3 = 12582912;
        if (i23 != 0) {
            $dirty6 |= i3;
            obj40 = i41;
            obj3 = contentPadding;
        } else {
            if (i60 & i3 == 0) {
                obj40 = i41;
                i3 = restartGroup.changed(contentPadding) ? 8388608 : 4194304;
                $dirty6 |= i3;
            } else {
                obj40 = i41;
                obj3 = contentPadding;
            }
        }
        int i42 = i61 & 256;
        int i64 = 100663296;
        if (i42 != 0) {
            $dirty6 |= i64;
            containerColor-vNxB06k$material3_release = i42;
            obj7 = interactionSource;
        } else {
            if (i60 & i64 == 0) {
                containerColor-vNxB06k$material3_release = i42;
                i17 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty6 |= i17;
            } else {
                containerColor-vNxB06k$material3_release = i42;
                obj7 = interactionSource;
            }
        }
        i18 = 805306368;
        if (i61 & 512 != 0) {
            $dirty6 |= i18;
        } else {
            if (i60 & i18 == 0) {
                i10 = restartGroup.changedInstance(obj10) ? 536870912 : 268435456;
                $dirty6 |= i10;
            }
        }
        if (i24 &= $dirty6 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i66 = -458753;
                i5 = -57345;
                if (i60 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (obj40 != null) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = interactionSource2;
                        }
                        z = i46 != 0 ? interactionSource2 : z2;
                        i20 = 6;
                        if (i61 & 8 != 0) {
                            $dirty6 &= -7169;
                            shape2 = shape3;
                        } else {
                            shape2 = obj8;
                        }
                        if (i61 & 16 != 0) {
                            obj4 = buttonColors;
                            $dirty4 = $dirty6;
                        } else {
                            obj4 = obj;
                            $dirty4 = $dirty6;
                        }
                        if (i61 & 32 != 0) {
                            $dirty4 &= i66;
                            rememberedValue = $dirty2;
                        }
                        border2 = i9 != 0 ? 0 : border;
                        if (i23 != 0) {
                            contentPadding2 = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding2 = contentPadding;
                        }
                        if (containerColor-vNxB06k$material3_release != 0) {
                            i9 = z;
                            i6 = shape2;
                            obj = obj4;
                            i8 = $dirty4;
                            i12 = 650121315;
                            $dirty = border2;
                            $dirty5 = i45;
                            interactionSource2 = modifier3;
                            modifier2 = rememberedValue;
                        } else {
                            interactionSource2 = modifier3;
                            modifier2 = rememberedValue;
                            i9 = z;
                            i6 = shape2;
                            obj = obj4;
                            i8 = $dirty4;
                            i12 = 650121315;
                            $dirty = border2;
                            $dirty5 = interactionSource;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i61 & 8 != 0) {
                            $dirty6 &= -7169;
                        }
                        if (i61 & 16 != 0) {
                            $dirty6 &= i5;
                        }
                        if (i61 & 32 != 0) {
                            contentPadding2 = contentPadding;
                            $dirty5 = interactionSource;
                            i8 = i28;
                            i9 = z2;
                            i6 = obj8;
                            $dirty = str;
                            modifier2 = rememberedValue;
                            i12 = 650121315;
                        } else {
                            contentPadding2 = contentPadding;
                            i8 = $dirty6;
                            i9 = z2;
                            i6 = obj8;
                            $dirty = str;
                            modifier2 = rememberedValue;
                            i12 = 650121315;
                            $dirty5 = interactionSource;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i12, i8, -1, "androidx.compose.material3.Button (Button.kt:118)");
                }
                restartGroup.startReplaceGroup(-239156623);
                ComposerKt.sourceInformation(restartGroup, "120@5882L39");
                if ($dirty5 == 0) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -239155972, "CC(remember):Button.kt#9igjgp");
                    str2 = 0;
                    traceInProgress2 = restartGroup;
                    str = 0;
                    rememberedValue = traceInProgress2.rememberedValue();
                    containerColor-vNxB06k$material3_release = 0;
                    obj31 = $dirty5;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i40 = 0;
                        traceInProgress2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        $dirty5 = rememberedValue;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    i14 = $dirty5;
                } else {
                    i14 = obj31;
                }
                restartGroup.endReplaceGroup();
                long contentColor-vNxB06k$material3_release = obj.contentColor-vNxB06k$material3_release(i9);
                restartGroup.startReplaceGroup(-239150048);
                ComposerKt.sourceInformation(restartGroup, "123@6067L43");
                if (modifier2 == null) {
                    shadowElevation$material3_release = 0;
                } else {
                    shadowElevation$material3_release = modifier2.shadowElevation$material3_release(i9, (InteractionSource)i14, restartGroup, i38 |= rememberedValue);
                }
                restartGroup.endReplaceGroup();
                if (shadowElevation$material3_release != 0) {
                    obj4 = unbox-impl;
                } else {
                    str = 0;
                    obj4 = rememberedValue;
                }
                int i62 = 1;
                ButtonKt.Button.2 anon = new ButtonKt.Button.2(contentColor-vNxB06k$material3_release, traceInProgress2, contentPadding2, obj10);
                SurfaceKt.Surface-o_FOJdg(obj5, SemanticsModifierKt.semantics$default(interactionSource2, false, (Function1)ButtonKt.Button.1.INSTANCE, i62, 0), i9, i6, obj.containerColor-vNxB06k$material3_release(i9), companion, contentColor-vNxB06k$material3_release, z, 0, obj4, $dirty, i14, (Function2)ComposableLambdaKt.rememberComposableLambda(956488494, i62, anon, restartGroup, 54), restartGroup, i32 | $dirty6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i11 = obj31;
                obj6 = obj33;
                i7 = i8;
                obj2 = obj;
                $dirty3 = i6;
                $composer2 = $dirty;
                colors2 = contentPadding2;
                contentPadding3 = interactionSource2;
                modifier4 = i9;
            } else {
                restartGroup.skipToGroupEnd();
                i7 = $dirty6;
                contentPadding3 = interactionSource2;
                modifier4 = z2;
                $dirty3 = obj8;
                composer = restartGroup;
                obj2 = obj;
                $composer2 = str;
                obj6 = rememberedValue;
                colors2 = contentPadding;
                i11 = interactionSource;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ButtonKt.Button.3(onClick, contentPadding3, modifier4, $dirty3, obj2, obj6, $composer2, colors2, i11, obj10, i60, i61);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void ElevatedButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.ButtonColors colors, androidx.compose.material3.ButtonElevation elevation, BorderStroke border, PaddingValues contentPadding, MutableInteractionSource interactionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj13;
        Object obj5;
        boolean traceInProgress2;
        int defaultsInvalid;
        Object modifier2;
        int modifier3;
        int $dirty3;
        int $dirty2;
        Object contentPadding2;
        int i18;
        Object obj2;
        Object obj;
        int i11;
        boolean traceInProgress;
        Object elevatedButtonColors;
        boolean z;
        int elevatedShape;
        int i4;
        Object obj6;
        int i16;
        boolean z3;
        Object obj12;
        int i21;
        Object obj10;
        Object obj8;
        Object $composer2;
        int changed2;
        Object obj9;
        PaddingValues paddingValues;
        boolean changed3;
        int i7;
        int i6;
        int i15;
        int i5;
        int changed;
        Object obj4;
        Object obj3;
        int i8;
        Object i;
        Object border2;
        int i3;
        int i20;
        int i14;
        int i2;
        int i10;
        Object i19;
        Object enabled2;
        boolean z2;
        Object shape2;
        Object obj7;
        int colors2;
        Object obj11;
        Function3 $dirty;
        Composer composer;
        int i12;
        int i9;
        int i17;
        final int i68 = $changed;
        final int i69 = i13;
        Composer restartGroup = $composer.startRestartGroup(1466887385);
        ComposerKt.sourceInformation(restartGroup, "C(ElevatedButton)P(8,7,5,9,1,4!1,3,6)204@9975L13,205@10032L22,206@10105L25,212@10343L314:Button.kt#uh7d8r");
        $dirty3 = $changed;
        if (i69 & 1 != 0) {
            $dirty3 |= 6;
            obj3 = onClick;
        } else {
            if (i68 & 6 == 0) {
                i18 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty3 |= i18;
            } else {
                obj3 = onClick;
            }
        }
        int i38 = i69 & 2;
        if (i38 != 0) {
            $dirty3 |= 48;
            elevatedButtonColors = modifier;
        } else {
            if (i68 & 48 == 0) {
                i4 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i4;
            } else {
                elevatedButtonColors = modifier;
            }
        }
        i16 = i69 & 4;
        if (i16 != 0) {
            $dirty3 |= 384;
            z3 = enabled;
        } else {
            if (i68 & 384 == 0) {
                i21 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty3 |= i21;
            } else {
                z3 = enabled;
            }
        }
        if (i68 & 3072 == 0) {
            if (i69 & 8 == 0) {
                changed2 = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj10 = shape;
            }
            $dirty3 |= changed2;
        } else {
            obj10 = shape;
        }
        if (i68 & 24576 == 0) {
            if (i69 & 16 == 0) {
                changed3 = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                obj9 = colors;
            }
            $dirty3 |= changed3;
        } else {
            obj9 = colors;
        }
        if (i67 &= i68 == 0) {
            if (i69 & 32 == 0) {
                i7 = restartGroup.changed(elevation) ? 131072 : 65536;
            } else {
                obj4 = elevation;
            }
            $dirty3 |= i7;
        } else {
            obj4 = elevation;
        }
        i = i69 & 64;
        i6 = 1572864;
        if (i != 0) {
            $dirty3 |= i6;
            border2 = border;
        } else {
            if (i6 &= i68 == 0) {
                i6 = restartGroup.changed(border) ? 1048576 : 524288;
                $dirty3 |= i6;
            } else {
                border2 = border;
            }
        }
        i5 = i69 & 128;
        i3 = 12582912;
        if (i5 != 0) {
            $dirty3 |= i3;
            obj13 = contentPadding;
        } else {
            if (i68 & i3 == 0) {
                i20 = restartGroup.changed(contentPadding) ? 8388608 : 4194304;
                $dirty3 |= i20;
            } else {
                obj13 = contentPadding;
            }
        }
        int i39 = i69 & 256;
        int i70 = 100663296;
        if (i39 != 0) {
            $dirty3 |= i70;
            i14 = i39;
            obj2 = interactionSource;
        } else {
            if (i68 & i70 == 0) {
                i14 = i39;
                i2 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty3 |= i2;
            } else {
                i14 = i39;
                obj2 = interactionSource;
            }
        }
        i10 = 805306368;
        if (i69 & 512 != 0) {
            $dirty3 |= i10;
            obj5 = content;
        } else {
            if (i68 & i10 == 0) {
                i10 = restartGroup.changedInstance(content) ? 536870912 : 268435456;
                $dirty3 |= i10;
            } else {
                obj5 = content;
            }
        }
        if ($dirty3 & i19 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i72 = -458753;
                i11 = -57345;
                if (i68 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i38 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = elevatedButtonColors;
                        }
                        z2 = i16 != 0 ? elevatedButtonColors : z3;
                        i16 = 6;
                        if (i69 & 8 != 0) {
                            $dirty3 &= -7169;
                            obj7 = elevatedShape;
                        } else {
                            obj7 = obj10;
                        }
                        if (i69 & 16 != 0) {
                            obj11 = elevatedButtonColors;
                            $dirty = $dirty3;
                        } else {
                            obj11 = obj9;
                            $dirty = $dirty3;
                        }
                        if (i69 & 32 != 0) {
                            i12 = i64;
                            $dirty &= i72;
                            obj4 = $dirty2;
                        } else {
                            i12 = i5;
                        }
                        if (i != 0) {
                            border2 = $dirty2;
                        }
                        if (i12 != 0) {
                            contentPadding2 = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding2 = contentPadding;
                        }
                        if (i14 != 0) {
                            enabled2 = border2;
                            border2 = z5;
                            i = modifier2;
                            i19 = obj4;
                            i3 = obj7;
                            i14 = obj11;
                            modifier3 = 1466887385;
                            shape2 = contentPadding2;
                            colors2 = i11;
                            $dirty3 = $dirty;
                        } else {
                            enabled2 = border2;
                            border2 = z4;
                            i = modifier2;
                            i19 = obj4;
                            i3 = obj7;
                            i14 = obj11;
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
                            $dirty3 &= i11;
                        }
                        if (i69 & 32 != 0) {
                            shape2 = contentPadding;
                            colors2 = interactionSource;
                            $dirty3 = i28;
                            i = elevatedButtonColors;
                            i3 = obj10;
                            i14 = obj9;
                            i19 = obj4;
                            enabled2 = border2;
                            modifier3 = 1466887385;
                            border2 = z3;
                        } else {
                            shape2 = contentPadding;
                            colors2 = interactionSource;
                            i = elevatedButtonColors;
                            i3 = obj10;
                            i14 = obj9;
                            i19 = obj4;
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
                ButtonKt.Button(obj3, i, border2, i3, i14, i19, enabled2, shape2, colors2, content, restartGroup, i37 | i56, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = i;
                z = border2;
                obj6 = i3;
                obj12 = i14;
                obj8 = i19;
                $composer2 = enabled2;
                paddingValues = shape2;
                i15 = colors2;
                i8 = $dirty3;
            } else {
                restartGroup.skipToGroupEnd();
                i15 = interactionSource;
                obj = elevatedButtonColors;
                z = z3;
                obj6 = obj10;
                composer = restartGroup;
                obj12 = obj9;
                obj8 = obj4;
                $composer2 = border2;
                paddingValues = contentPadding;
                i8 = $dirty3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ButtonKt.ElevatedButton.1(onClick, obj, z, obj6, obj12, obj8, $composer2, paddingValues, i15, content, i68, i69);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void FilledTonalButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.ButtonColors colors, androidx.compose.material3.ButtonElevation elevation, BorderStroke border, PaddingValues contentPadding, MutableInteractionSource interactionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj9;
        Object obj13;
        boolean traceInProgress2;
        int defaultsInvalid;
        Object modifier3;
        int modifier2;
        int $dirty;
        int $dirty3;
        Object contentPadding2;
        int i14;
        Object obj10;
        Object obj7;
        int i3;
        boolean traceInProgress;
        Object filledTonalButtonColors;
        boolean z2;
        int filledTonalShape;
        int i20;
        Object obj5;
        int i12;
        boolean z3;
        Object obj11;
        int i19;
        Object obj2;
        Object obj12;
        Object $composer2;
        int changed3;
        Object obj;
        PaddingValues paddingValues;
        boolean changed2;
        int i11;
        int i6;
        int i16;
        int i7;
        int changed;
        Object obj6;
        Object obj4;
        int i8;
        Object i17;
        Object border2;
        int i5;
        int i15;
        int i21;
        int i10;
        int i2;
        Object i9;
        Object enabled2;
        boolean z;
        Object shape2;
        Object obj3;
        int colors2;
        Object obj8;
        Function3 $dirty2;
        Composer composer;
        int i18;
        int i4;
        int i;
        final int i68 = $changed;
        final int i69 = i13;
        Composer restartGroup = $composer.startRestartGroup(-1717924381);
        ComposerKt.sourceInformation(restartGroup, "C(FilledTonalButton)P(8,7,5,9,1,4!1,3,6)277@13636L16,278@13696L25,279@13772L28,285@14013L314:Button.kt#uh7d8r");
        $dirty = $changed;
        if (i69 & 1 != 0) {
            $dirty |= 6;
            obj4 = onClick;
        } else {
            if (i68 & 6 == 0) {
                i14 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty |= i14;
            } else {
                obj4 = onClick;
            }
        }
        int i38 = i69 & 2;
        if (i38 != 0) {
            $dirty |= 48;
            filledTonalButtonColors = modifier;
        } else {
            if (i68 & 48 == 0) {
                i20 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i20;
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
                i19 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty |= i19;
            } else {
                z3 = enabled;
            }
        }
        if (i68 & 3072 == 0) {
            if (i69 & 8 == 0) {
                changed3 = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj2 = shape;
            }
            $dirty |= changed3;
        } else {
            obj2 = shape;
        }
        if (i68 & 24576 == 0) {
            if (i69 & 16 == 0) {
                changed2 = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                obj = colors;
            }
            $dirty |= changed2;
        } else {
            obj = colors;
        }
        if (i67 &= i68 == 0) {
            if (i69 & 32 == 0) {
                i11 = restartGroup.changed(elevation) ? 131072 : 65536;
            } else {
                obj6 = elevation;
            }
            $dirty |= i11;
        } else {
            obj6 = elevation;
        }
        i17 = i69 & 64;
        i6 = 1572864;
        if (i17 != 0) {
            $dirty |= i6;
            border2 = border;
        } else {
            if (i6 &= i68 == 0) {
                i6 = restartGroup.changed(border) ? 1048576 : 524288;
                $dirty |= i6;
            } else {
                border2 = border;
            }
        }
        i7 = i69 & 128;
        i5 = 12582912;
        if (i7 != 0) {
            $dirty |= i5;
            obj9 = contentPadding;
        } else {
            if (i68 & i5 == 0) {
                i15 = restartGroup.changed(contentPadding) ? 8388608 : 4194304;
                $dirty |= i15;
            } else {
                obj9 = contentPadding;
            }
        }
        int i39 = i69 & 256;
        int i70 = 100663296;
        if (i39 != 0) {
            $dirty |= i70;
            i21 = i39;
            obj10 = interactionSource;
        } else {
            if (i68 & i70 == 0) {
                i21 = i39;
                i10 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty |= i10;
            } else {
                i21 = i39;
                obj10 = interactionSource;
            }
        }
        i2 = 805306368;
        if (i69 & 512 != 0) {
            $dirty |= i2;
            obj13 = content;
        } else {
            if (i68 & i2 == 0) {
                i2 = restartGroup.changedInstance(content) ? 536870912 : 268435456;
                $dirty |= i2;
            } else {
                obj13 = content;
            }
        }
        if ($dirty & i9 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i72 = -458753;
                i3 = -57345;
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
                            obj3 = filledTonalShape;
                        } else {
                            obj3 = obj2;
                        }
                        if (i69 & 16 != 0) {
                            obj8 = filledTonalButtonColors;
                            $dirty2 = $dirty;
                        } else {
                            obj8 = obj;
                            $dirty2 = $dirty;
                        }
                        if (i69 & 32 != 0) {
                            i18 = i64;
                            $dirty2 &= i72;
                            obj6 = $dirty3;
                        } else {
                            i18 = i7;
                        }
                        if (i17 != 0) {
                            border2 = $dirty3;
                        }
                        if (i18 != 0) {
                            contentPadding2 = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding2 = contentPadding;
                        }
                        if (i21 != 0) {
                            enabled2 = border2;
                            border2 = z5;
                            i17 = modifier3;
                            i9 = obj6;
                            i5 = obj3;
                            i21 = obj8;
                            modifier2 = -1717924381;
                            shape2 = contentPadding2;
                            colors2 = i3;
                            $dirty = $dirty2;
                        } else {
                            enabled2 = border2;
                            border2 = z4;
                            i17 = modifier3;
                            i9 = obj6;
                            i5 = obj3;
                            i21 = obj8;
                            modifier2 = -1717924381;
                            colors2 = interactionSource;
                            shape2 = contentPadding2;
                            $dirty = $dirty2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i69 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        if (i69 & 16 != 0) {
                            $dirty &= i3;
                        }
                        if (i69 & 32 != 0) {
                            shape2 = contentPadding;
                            colors2 = interactionSource;
                            $dirty = i28;
                            i17 = filledTonalButtonColors;
                            i5 = obj2;
                            i21 = obj;
                            i9 = obj6;
                            enabled2 = border2;
                            modifier2 = -1717924381;
                            border2 = z3;
                        } else {
                            shape2 = contentPadding;
                            colors2 = interactionSource;
                            i17 = filledTonalButtonColors;
                            i5 = obj2;
                            i21 = obj;
                            i9 = obj6;
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
                ButtonKt.Button(obj4, i17, border2, i5, i21, i9, enabled2, shape2, colors2, content, restartGroup, i37 | i56, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj7 = i17;
                z2 = border2;
                obj5 = i5;
                obj11 = i21;
                obj12 = i9;
                $composer2 = enabled2;
                paddingValues = shape2;
                i16 = colors2;
                i8 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                i16 = interactionSource;
                obj7 = filledTonalButtonColors;
                z2 = z3;
                obj5 = obj2;
                composer = restartGroup;
                obj11 = obj;
                obj12 = obj6;
                $composer2 = border2;
                paddingValues = contentPadding;
                i8 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ButtonKt.FilledTonalButton.1(onClick, obj7, z2, obj5, obj11, obj12, $composer2, paddingValues, i16, content, i68, i69);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void OutlinedButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.ButtonColors colors, androidx.compose.material3.ButtonElevation elevation, BorderStroke border, PaddingValues contentPadding, MutableInteractionSource interactionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj11;
        Object obj9;
        Object obj13;
        int traceInProgress2;
        int contentPadding2;
        int defaultsInvalid;
        int outlinedShape;
        int shape2;
        int outlinedButtonBorder;
        Object contentPadding3;
        Object restartGroup;
        int $dirty;
        Object $dirty2;
        int i9;
        int i6;
        boolean traceInProgress;
        boolean z2;
        Object str;
        Object obj12;
        int i5;
        int i18;
        Object obj6;
        boolean z;
        Object obj3;
        int i19;
        Object obj;
        Object obj10;
        int changed3;
        Object obj8;
        PaddingValues paddingValues;
        boolean changed2;
        int i7;
        int i20;
        Object obj2;
        Object obj7;
        int i3;
        int i;
        Object border2;
        int changed;
        boolean i10;
        int i12;
        int i16;
        int i17;
        int i4;
        int i2;
        Object i8;
        Object obj4;
        Object obj5;
        int i11;
        Function3 function3;
        Composer composer;
        int i14;
        int i15;
        final int i65 = $changed;
        final int i66 = i13;
        restartGroup = $composer.startRestartGroup(-1694808287);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedButton)P(8,7,5,9,1,4!1,3,6)349@17203L13,350@17260L22,352@17367L29,357@17575L314:Button.kt#uh7d8r");
        $dirty = $changed;
        if (i66 & 1 != 0) {
            $dirty |= 6;
            obj7 = onClick;
        } else {
            if (i65 & 6 == 0) {
                i9 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty |= i9;
            } else {
                obj7 = onClick;
            }
        }
        int i38 = i66 & 2;
        if (i38 != 0) {
            $dirty |= 48;
            str = modifier;
        } else {
            if (i65 & 48 == 0) {
                i5 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i5;
            } else {
                str = modifier;
            }
        }
        i18 = i66 & 4;
        if (i18 != 0) {
            $dirty |= 384;
            z = enabled;
        } else {
            if (i65 & 384 == 0) {
                i19 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty |= i19;
            } else {
                z = enabled;
            }
        }
        if (i65 & 3072 == 0) {
            if (i66 & 8 == 0) {
                changed3 = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj = shape;
            }
            $dirty |= changed3;
        } else {
            obj = shape;
        }
        if (i65 & 24576 == 0) {
            if (i66 & 16 == 0) {
                changed2 = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                obj8 = colors;
            }
            $dirty |= changed2;
        } else {
            obj8 = colors;
        }
        i7 = i66 & 32;
        int i63 = 196608;
        if (i7 != 0) {
            $dirty |= i63;
            obj2 = elevation;
        } else {
            if (i63 &= i65 == 0) {
                i = restartGroup.changed(elevation) ? 131072 : 65536;
                $dirty |= i;
            } else {
                obj2 = elevation;
            }
        }
        if (i67 &= i65 == 0) {
            if (i66 & 64 == 0) {
                changed = restartGroup.changed(border) ? 1048576 : 524288;
            } else {
                border2 = border;
            }
            $dirty |= changed;
        } else {
            border2 = border;
        }
        i10 = i66 & 128;
        i12 = 12582912;
        if (i10 != 0) {
            $dirty |= i12;
            obj11 = contentPadding;
        } else {
            if (i65 & i12 == 0) {
                i16 = restartGroup.changed(contentPadding) ? 8388608 : 4194304;
                $dirty |= i16;
            } else {
                obj11 = contentPadding;
            }
        }
        int i22 = i66 & 256;
        int i70 = 100663296;
        if (i22 != 0) {
            $dirty |= i70;
            i17 = i22;
            obj9 = interactionSource;
        } else {
            if (i65 & i70 == 0) {
                i17 = i22;
                i4 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty |= i4;
            } else {
                i17 = i22;
                obj9 = interactionSource;
            }
        }
        i2 = 805306368;
        if (i66 & 512 != 0) {
            $dirty |= i2;
            obj13 = content;
        } else {
            if (i65 & i2 == 0) {
                i2 = restartGroup.changedInstance(content) ? 536870912 : 268435456;
                $dirty |= i2;
            } else {
                obj13 = content;
            }
        }
        if ($dirty & i8 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i6 = -3670017;
                int i72 = -57345;
                if (i65 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i38 != 0) {
                            str = defaultsInvalid;
                        }
                        if (i18 != 0) {
                            z = defaultsInvalid;
                        }
                        i18 = 6;
                        if (i66 & 8 != 0) {
                            $dirty &= -7169;
                            obj = outlinedShape;
                        }
                        if (i66 & 16 != 0) {
                            $dirty &= i72;
                            obj8 = shape2;
                        }
                        if (i7 != 0) {
                            obj2 = shape2;
                        }
                        if (i66 & 64 != 0) {
                            $dirty &= i6;
                            border2 = outlinedButtonBorder;
                        }
                        if (i10 != 0) {
                            contentPadding3 = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding3 = contentPadding;
                        }
                        if (i17 != 0) {
                            obj5 = contentPadding3;
                            i11 = i6;
                            i10 = z;
                            i12 = obj;
                            i17 = obj8;
                            i8 = obj2;
                            obj4 = border2;
                            contentPadding2 = -1694808287;
                            border2 = str;
                        } else {
                            i11 = interactionSource;
                            obj5 = contentPadding3;
                            i10 = z;
                            i12 = obj;
                            i17 = obj8;
                            i8 = obj2;
                            obj4 = border2;
                            contentPadding2 = -1694808287;
                            border2 = str;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i66 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        if (i66 & 16 != 0) {
                            $dirty &= i72;
                        }
                        if (i66 & 64 != 0) {
                            obj5 = contentPadding;
                            i11 = interactionSource;
                            $dirty = i37;
                            i10 = z;
                            i12 = obj;
                            i17 = obj8;
                            i8 = obj2;
                            obj4 = border2;
                            contentPadding2 = -1694808287;
                            border2 = str;
                        } else {
                            obj5 = contentPadding;
                            i11 = interactionSource;
                            i10 = z;
                            i12 = obj;
                            i17 = obj8;
                            i8 = obj2;
                            obj4 = border2;
                            contentPadding2 = -1694808287;
                            border2 = str;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(contentPadding2, $dirty, -1, "androidx.compose.material3.OutlinedButton (Button.kt:357)");
                }
                ButtonKt.Button(obj7, border2, i10, i12, i17, i8, obj4, obj5, i11, content, restartGroup, i33 | i54, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i3 = $dirty;
                $dirty2 = border2;
                z2 = i10;
                obj12 = i12;
                obj6 = i17;
                obj3 = i8;
                obj10 = obj4;
                paddingValues = obj5;
                i20 = i11;
            } else {
                restartGroup.skipToGroupEnd();
                i20 = interactionSource;
                composer = restartGroup;
                i3 = $dirty;
                $dirty2 = str;
                z2 = z;
                obj12 = obj;
                obj6 = obj8;
                obj3 = obj2;
                obj10 = border2;
                paddingValues = contentPadding;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ButtonKt.OutlinedButton.1(onClick, $dirty2, z2, obj12, obj6, obj3, obj10, paddingValues, i20, content, i65, i66);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void TextButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.ButtonColors colors, androidx.compose.material3.ButtonElevation elevation, BorderStroke border, PaddingValues contentPadding, MutableInteractionSource interactionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj8;
        Object obj2;
        Object obj7;
        int traceInProgress;
        int contentPadding2;
        int defaultsInvalid;
        int textShape;
        int shape2;
        Object contentPadding3;
        Object restartGroup;
        int $dirty;
        Object $dirty2;
        int i6;
        int i;
        boolean traceInProgress2;
        boolean z2;
        Object str;
        Object obj4;
        int i12;
        int i16;
        Object obj5;
        boolean z;
        Object obj12;
        int i4;
        Object obj;
        Object obj10;
        int changed;
        Object obj9;
        PaddingValues paddingValues;
        boolean changed2;
        int i14;
        Object obj11;
        Object obj6;
        int i17;
        int i3;
        Object i15;
        Object border2;
        int i7;
        int i18;
        int i9;
        int i5;
        int i2;
        int i19;
        Object i11;
        Object obj13;
        int obj3;
        Function3 function3;
        Composer composer;
        int i10;
        int i8;
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
                i6 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty |= i6;
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
        i16 = i64 & 4;
        if (i16 != 0) {
            $dirty |= 384;
            z = enabled;
        } else {
            if (i63 & 384 == 0) {
                i4 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty |= i4;
            } else {
                z = enabled;
            }
        }
        if (i63 & 3072 == 0) {
            if (i64 & 8 == 0) {
                changed = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj = shape;
            }
            $dirty |= changed;
        } else {
            obj = shape;
        }
        if (i63 & 24576 == 0) {
            if (i64 & 16 == 0) {
                changed2 = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                obj9 = colors;
            }
            $dirty |= changed2;
        } else {
            obj9 = colors;
        }
        int i60 = i64 & 32;
        int i61 = 196608;
        if (i60 != 0) {
            $dirty |= i61;
            obj11 = elevation;
        } else {
            if (i61 &= i63 == 0) {
                i3 = restartGroup.changed(elevation) ? 131072 : 65536;
                $dirty |= i3;
            } else {
                obj11 = elevation;
            }
        }
        i15 = i64 & 64;
        int i65 = 1572864;
        if (i15 != 0) {
            $dirty |= i65;
            border2 = border;
        } else {
            if (i65 &= i63 == 0) {
                i7 = restartGroup.changed(border) ? 1048576 : 524288;
                $dirty |= i7;
            } else {
                border2 = border;
            }
        }
        int i21 = i64 & 128;
        int i67 = 12582912;
        if (i21 != 0) {
            $dirty |= i67;
            i18 = i21;
            obj8 = contentPadding;
        } else {
            if (i63 & i67 == 0) {
                i18 = i21;
                i9 = restartGroup.changed(contentPadding) ? 8388608 : 4194304;
                $dirty |= i9;
            } else {
                i18 = i21;
                obj8 = contentPadding;
            }
        }
        int i22 = i64 & 256;
        int i69 = 100663296;
        if (i22 != 0) {
            $dirty |= i69;
            i5 = i22;
            obj2 = interactionSource;
        } else {
            if (i63 & i69 == 0) {
                i5 = i22;
                i2 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty |= i2;
            } else {
                i5 = i22;
                obj2 = interactionSource;
            }
        }
        i19 = 805306368;
        if (i64 & 512 != 0) {
            $dirty |= i19;
            obj7 = content;
        } else {
            if (i63 & i19 == 0) {
                i19 = restartGroup.changedInstance(content) ? 536870912 : 268435456;
                $dirty |= i19;
            } else {
                obj7 = content;
            }
        }
        if ($dirty & i11 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i = -57345;
                if (i63 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i37 != 0) {
                            str = defaultsInvalid;
                        }
                        if (i16 != 0) {
                            z = defaultsInvalid;
                        }
                        i16 = 6;
                        if (i64 & 8 != 0) {
                            $dirty &= -7169;
                            obj = textShape;
                        }
                        if (i64 & 16 != 0) {
                            $dirty &= i;
                            obj9 = shape2;
                        }
                        if (i60 != 0) {
                            obj11 = shape2;
                        }
                        if (i15 != 0) {
                            border2 = shape2;
                        }
                        if (i18 != 0) {
                            contentPadding3 = ButtonDefaults.INSTANCE.getTextButtonContentPadding();
                        } else {
                            contentPadding3 = contentPadding;
                        }
                        if (i5 != 0) {
                            obj13 = contentPadding3;
                            obj3 = i;
                            i15 = str;
                            i7 = obj;
                            i18 = obj9;
                            i5 = obj11;
                            i11 = border2;
                            contentPadding2 = -2106428362;
                            border2 = z;
                        } else {
                            obj3 = interactionSource;
                            obj13 = contentPadding3;
                            i15 = str;
                            i7 = obj;
                            i18 = obj9;
                            i5 = obj11;
                            i11 = border2;
                            contentPadding2 = -2106428362;
                            border2 = z;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i64 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        if (i64 & 16 != 0) {
                            obj13 = contentPadding;
                            obj3 = interactionSource;
                            $dirty = i27;
                            i15 = str;
                            i7 = obj;
                            i18 = obj9;
                            i5 = obj11;
                            i11 = border2;
                            contentPadding2 = -2106428362;
                            border2 = z;
                        } else {
                            obj13 = contentPadding;
                            obj3 = interactionSource;
                            i15 = str;
                            i7 = obj;
                            i18 = obj9;
                            i5 = obj11;
                            i11 = border2;
                            contentPadding2 = -2106428362;
                            border2 = z;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(contentPadding2, $dirty, -1, "androidx.compose.material3.TextButton (Button.kt:430)");
                }
                ButtonKt.Button(obj6, i15, border2, i7, i18, i5, i11, obj13, obj3, content, restartGroup, i36 | i53, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i17 = $dirty;
                $dirty2 = i15;
                z2 = border2;
                obj4 = i7;
                obj5 = i18;
                obj12 = i5;
                obj10 = i11;
                paddingValues = obj13;
                i14 = obj3;
            } else {
                restartGroup.skipToGroupEnd();
                i14 = interactionSource;
                composer = restartGroup;
                i17 = $dirty;
                $dirty2 = str;
                z2 = z;
                obj4 = obj;
                obj5 = obj9;
                obj12 = obj11;
                obj10 = border2;
                paddingValues = contentPadding;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ButtonKt.TextButton.1(onClick, $dirty2, z2, obj4, obj5, obj12, obj10, paddingValues, i14, content, i63, i64);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }
}
