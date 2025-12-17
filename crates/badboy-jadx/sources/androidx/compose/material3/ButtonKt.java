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
        int i3;
        int traceInProgress2;
        int defaultsInvalid;
        Object modifier2;
        Object modifier3;
        int $dirty;
        int $dirty5;
        int border2;
        int $dirty4;
        int shadowElevation$material3_release;
        int unbox-impl;
        int i5;
        Object obj6;
        Object obj7;
        int i6;
        Object contentPadding2;
        Object contentPadding3;
        Object interactionSource2;
        Shape shape3;
        int buttonColors;
        boolean modifier4;
        int i21;
        int i19;
        int i10;
        Object $dirty3;
        boolean z;
        int i9;
        String str;
        Object obj5;
        int i8;
        Object obj4;
        boolean traceInProgress;
        Object obj3;
        Object $composer2;
        int changed2;
        Object obj;
        PaddingValues colors2;
        boolean changed;
        int i20;
        Object str2;
        int i14;
        int changed3;
        Object obj2;
        int i15;
        Object rememberedValue;
        boolean i11;
        int i18;
        int i4;
        int containerColor-vNxB06k$material3_release;
        int i12;
        int companion;
        long i2;
        boolean z2;
        Object shape2;
        Object obj8;
        int $dirty2;
        Object $dirty6;
        int i16;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i7;
        int i17;
        int i;
        int obj31;
        Modifier obj32;
        Object obj33;
        int obj40;
        final Object obj10 = content;
        final int i60 = $changed;
        final int i61 = i13;
        Composer restartGroup = $composer.startRestartGroup(650121315);
        ComposerKt.sourceInformation(restartGroup, "C(Button)P(8,7,5,9,1,4!1,3,6)111@5461L5,112@5510L14,113@5575L17,134@6467L587,124@6130L924:Button.kt#uh7d8r");
        $dirty = $changed;
        if (i61 & 1 != 0) {
            $dirty |= 6;
            obj2 = onClick;
        } else {
            if (i60 & 6 == 0) {
                i5 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty |= i5;
            } else {
                obj2 = onClick;
            }
        }
        int i41 = i61 & 2;
        if (i41 != 0) {
            $dirty |= 48;
            interactionSource2 = modifier;
        } else {
            if (i60 & 48 == 0) {
                i21 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i21;
            } else {
                interactionSource2 = modifier;
            }
        }
        int i46 = i61 & 4;
        if (i46 != 0) {
            $dirty |= 384;
            z = enabled;
        } else {
            if (i60 & 384 == 0) {
                i8 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty |= i8;
            } else {
                z = enabled;
            }
        }
        if (i60 & 3072 == 0) {
            if (i61 & 8 == 0) {
                changed2 = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj4 = shape;
            }
            $dirty |= changed2;
        } else {
            obj4 = shape;
        }
        if (i60 & 24576 == 0) {
            if (i61 & 16 == 0) {
                changed = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                obj = colors;
            }
            $dirty |= changed;
        } else {
            obj = colors;
        }
        if (i54 &= i60 == 0) {
            if (i61 & 32 == 0) {
                i20 = restartGroup.changed(elevation) ? 131072 : 65536;
            } else {
                rememberedValue = elevation;
            }
            $dirty |= i20;
        } else {
            rememberedValue = elevation;
        }
        i11 = i61 & 64;
        int i55 = 1572864;
        if (i11 != 0) {
            $dirty |= i55;
            str2 = border;
        } else {
            if (i55 &= i60 == 0) {
                i18 = restartGroup.changed(border) ? 1048576 : 524288;
                $dirty |= i18;
            } else {
                str2 = border;
            }
        }
        int i23 = i61 & 128;
        i4 = 12582912;
        if (i23 != 0) {
            $dirty |= i4;
            obj40 = i41;
            obj6 = contentPadding;
        } else {
            if (i60 & i4 == 0) {
                obj40 = i41;
                i4 = restartGroup.changed(contentPadding) ? 8388608 : 4194304;
                $dirty |= i4;
            } else {
                obj40 = i41;
                obj6 = contentPadding;
            }
        }
        int i42 = i61 & 256;
        int i64 = 100663296;
        if (i42 != 0) {
            $dirty |= i64;
            containerColor-vNxB06k$material3_release = i42;
            obj7 = interactionSource;
        } else {
            if (i60 & i64 == 0) {
                containerColor-vNxB06k$material3_release = i42;
                i12 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty |= i12;
            } else {
                containerColor-vNxB06k$material3_release = i42;
                obj7 = interactionSource;
            }
        }
        i2 = 805306368;
        if (i61 & 512 != 0) {
            $dirty |= i2;
        } else {
            if (i60 & i2 == 0) {
                i3 = restartGroup.changedInstance(obj10) ? 536870912 : 268435456;
                $dirty |= i3;
            }
        }
        if (i24 &= $dirty == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i66 = -458753;
                i6 = -57345;
                if (i60 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (obj40 != null) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = interactionSource2;
                        }
                        z2 = i46 != 0 ? interactionSource2 : z;
                        i19 = 6;
                        if (i61 & 8 != 0) {
                            $dirty &= -7169;
                            shape2 = shape3;
                        } else {
                            shape2 = obj4;
                        }
                        if (i61 & 16 != 0) {
                            obj8 = buttonColors;
                            $dirty2 = $dirty;
                        } else {
                            obj8 = obj;
                            $dirty2 = $dirty;
                        }
                        if (i61 & 32 != 0) {
                            $dirty2 &= i66;
                            rememberedValue = $dirty5;
                        }
                        border2 = i11 != 0 ? 0 : border;
                        if (i23 != 0) {
                            contentPadding2 = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding2 = contentPadding;
                        }
                        if (containerColor-vNxB06k$material3_release != 0) {
                            i11 = z2;
                            i18 = shape2;
                            obj = obj8;
                            i10 = $dirty2;
                            i9 = 650121315;
                            $dirty6 = border2;
                            $dirty4 = i45;
                            interactionSource2 = modifier2;
                            modifier3 = rememberedValue;
                        } else {
                            interactionSource2 = modifier2;
                            modifier3 = rememberedValue;
                            i11 = z2;
                            i18 = shape2;
                            obj = obj8;
                            i10 = $dirty2;
                            i9 = 650121315;
                            $dirty6 = border2;
                            $dirty4 = interactionSource;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i61 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        if (i61 & 16 != 0) {
                            $dirty &= i6;
                        }
                        if (i61 & 32 != 0) {
                            contentPadding2 = contentPadding;
                            $dirty4 = interactionSource;
                            i10 = i28;
                            i11 = z;
                            i18 = obj4;
                            $dirty6 = str2;
                            modifier3 = rememberedValue;
                            i9 = 650121315;
                        } else {
                            contentPadding2 = contentPadding;
                            i10 = $dirty;
                            i11 = z;
                            i18 = obj4;
                            $dirty6 = str2;
                            modifier3 = rememberedValue;
                            i9 = 650121315;
                            $dirty4 = interactionSource;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i9, i10, -1, "androidx.compose.material3.Button (Button.kt:118)");
                }
                restartGroup.startReplaceGroup(-239156623);
                ComposerKt.sourceInformation(restartGroup, "120@5882L39");
                if ($dirty4 == 0) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -239155972, "CC(remember):Button.kt#9igjgp");
                    str = 0;
                    traceInProgress = restartGroup;
                    str2 = 0;
                    rememberedValue = traceInProgress.rememberedValue();
                    containerColor-vNxB06k$material3_release = 0;
                    obj31 = $dirty4;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i40 = 0;
                        traceInProgress.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        $dirty4 = rememberedValue;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    i16 = $dirty4;
                } else {
                    i16 = obj31;
                }
                restartGroup.endReplaceGroup();
                long contentColor-vNxB06k$material3_release = obj.contentColor-vNxB06k$material3_release(i11);
                restartGroup.startReplaceGroup(-239150048);
                ComposerKt.sourceInformation(restartGroup, "123@6067L43");
                if (modifier3 == null) {
                    shadowElevation$material3_release = 0;
                } else {
                    shadowElevation$material3_release = modifier3.shadowElevation$material3_release(i11, (InteractionSource)i16, restartGroup, i38 |= rememberedValue);
                }
                restartGroup.endReplaceGroup();
                if (shadowElevation$material3_release != 0) {
                    obj8 = unbox-impl;
                } else {
                    str2 = 0;
                    obj8 = rememberedValue;
                }
                int i62 = 1;
                ButtonKt.Button.2 anon = new ButtonKt.Button.2(contentColor-vNxB06k$material3_release, traceInProgress, contentPadding2, obj10);
                SurfaceKt.Surface-o_FOJdg(obj2, SemanticsModifierKt.semantics$default(interactionSource2, false, (Function1)ButtonKt.Button.1.INSTANCE, i62, 0), i11, i18, obj.containerColor-vNxB06k$material3_release(i11), companion, contentColor-vNxB06k$material3_release, z2, 0, obj8, $dirty6, i16, (Function2)ComposableLambdaKt.rememberComposableLambda(956488494, i62, anon, restartGroup, 54), restartGroup, i32 | $dirty);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i14 = obj31;
                obj3 = obj33;
                i15 = i10;
                obj5 = obj;
                $dirty3 = i18;
                $composer2 = $dirty6;
                colors2 = contentPadding2;
                contentPadding3 = interactionSource2;
                modifier4 = i11;
            } else {
                restartGroup.skipToGroupEnd();
                i15 = $dirty;
                contentPadding3 = interactionSource2;
                modifier4 = z;
                $dirty3 = obj4;
                composer = restartGroup;
                obj5 = obj;
                $composer2 = str2;
                obj3 = rememberedValue;
                colors2 = contentPadding;
                i14 = interactionSource;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ButtonKt.Button.3(onClick, contentPadding3, modifier4, $dirty3, obj5, obj3, $composer2, colors2, i14, obj10, i60, i61);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void ElevatedButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.ButtonColors colors, androidx.compose.material3.ButtonElevation elevation, BorderStroke border, PaddingValues contentPadding, MutableInteractionSource interactionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj5;
        Object obj10;
        boolean traceInProgress;
        int defaultsInvalid;
        Object modifier3;
        int modifier2;
        int $dirty;
        int $dirty3;
        Object contentPadding2;
        int i16;
        Object obj4;
        Object obj6;
        int i;
        boolean traceInProgress2;
        Object elevatedButtonColors;
        boolean z;
        int elevatedShape;
        int i2;
        Object obj11;
        int i7;
        boolean z3;
        Object obj13;
        int i20;
        Object obj3;
        Object obj;
        Object $composer2;
        int changed3;
        Object obj12;
        PaddingValues paddingValues;
        boolean changed;
        int i4;
        int i19;
        int i15;
        int i8;
        int changed2;
        Object obj7;
        Object obj2;
        int i12;
        Object i17;
        Object border2;
        int i3;
        int i5;
        int i18;
        int i21;
        int i14;
        Object i11;
        Object enabled2;
        boolean z2;
        Object shape2;
        Object obj8;
        int colors2;
        Object obj9;
        Function3 $dirty2;
        Composer composer;
        int i9;
        int i6;
        int i10;
        final int i68 = $changed;
        final int i69 = i13;
        Composer restartGroup = $composer.startRestartGroup(1466887385);
        ComposerKt.sourceInformation(restartGroup, "C(ElevatedButton)P(8,7,5,9,1,4!1,3,6)204@9975L13,205@10032L22,206@10105L25,212@10343L314:Button.kt#uh7d8r");
        $dirty = $changed;
        if (i69 & 1 != 0) {
            $dirty |= 6;
            obj2 = onClick;
        } else {
            if (i68 & 6 == 0) {
                i16 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty |= i16;
            } else {
                obj2 = onClick;
            }
        }
        int i38 = i69 & 2;
        if (i38 != 0) {
            $dirty |= 48;
            elevatedButtonColors = modifier;
        } else {
            if (i68 & 48 == 0) {
                i2 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i2;
            } else {
                elevatedButtonColors = modifier;
            }
        }
        i7 = i69 & 4;
        if (i7 != 0) {
            $dirty |= 384;
            z3 = enabled;
        } else {
            if (i68 & 384 == 0) {
                i20 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty |= i20;
            } else {
                z3 = enabled;
            }
        }
        if (i68 & 3072 == 0) {
            if (i69 & 8 == 0) {
                changed3 = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj3 = shape;
            }
            $dirty |= changed3;
        } else {
            obj3 = shape;
        }
        if (i68 & 24576 == 0) {
            if (i69 & 16 == 0) {
                changed = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                obj12 = colors;
            }
            $dirty |= changed;
        } else {
            obj12 = colors;
        }
        if (i67 &= i68 == 0) {
            if (i69 & 32 == 0) {
                i4 = restartGroup.changed(elevation) ? 131072 : 65536;
            } else {
                obj7 = elevation;
            }
            $dirty |= i4;
        } else {
            obj7 = elevation;
        }
        i17 = i69 & 64;
        i19 = 1572864;
        if (i17 != 0) {
            $dirty |= i19;
            border2 = border;
        } else {
            if (i19 &= i68 == 0) {
                i19 = restartGroup.changed(border) ? 1048576 : 524288;
                $dirty |= i19;
            } else {
                border2 = border;
            }
        }
        i8 = i69 & 128;
        i3 = 12582912;
        if (i8 != 0) {
            $dirty |= i3;
            obj5 = contentPadding;
        } else {
            if (i68 & i3 == 0) {
                i5 = restartGroup.changed(contentPadding) ? 8388608 : 4194304;
                $dirty |= i5;
            } else {
                obj5 = contentPadding;
            }
        }
        int i39 = i69 & 256;
        int i70 = 100663296;
        if (i39 != 0) {
            $dirty |= i70;
            i18 = i39;
            obj4 = interactionSource;
        } else {
            if (i68 & i70 == 0) {
                i18 = i39;
                i21 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty |= i21;
            } else {
                i18 = i39;
                obj4 = interactionSource;
            }
        }
        i14 = 805306368;
        if (i69 & 512 != 0) {
            $dirty |= i14;
            obj10 = content;
        } else {
            if (i68 & i14 == 0) {
                i14 = restartGroup.changedInstance(content) ? 536870912 : 268435456;
                $dirty |= i14;
            } else {
                obj10 = content;
            }
        }
        if ($dirty & i11 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i72 = -458753;
                i = -57345;
                if (i68 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i38 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = elevatedButtonColors;
                        }
                        z2 = i7 != 0 ? elevatedButtonColors : z3;
                        i7 = 6;
                        if (i69 & 8 != 0) {
                            $dirty &= -7169;
                            obj8 = elevatedShape;
                        } else {
                            obj8 = obj3;
                        }
                        if (i69 & 16 != 0) {
                            obj9 = elevatedButtonColors;
                            $dirty2 = $dirty;
                        } else {
                            obj9 = obj12;
                            $dirty2 = $dirty;
                        }
                        if (i69 & 32 != 0) {
                            i9 = i64;
                            $dirty2 &= i72;
                            obj7 = $dirty3;
                        } else {
                            i9 = i8;
                        }
                        if (i17 != 0) {
                            border2 = $dirty3;
                        }
                        if (i9 != 0) {
                            contentPadding2 = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding2 = contentPadding;
                        }
                        if (i18 != 0) {
                            enabled2 = border2;
                            border2 = z5;
                            i17 = modifier3;
                            i11 = obj7;
                            i3 = obj8;
                            i18 = obj9;
                            modifier2 = 1466887385;
                            shape2 = contentPadding2;
                            colors2 = i;
                            $dirty = $dirty2;
                        } else {
                            enabled2 = border2;
                            border2 = z4;
                            i17 = modifier3;
                            i11 = obj7;
                            i3 = obj8;
                            i18 = obj9;
                            modifier2 = 1466887385;
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
                            $dirty &= i;
                        }
                        if (i69 & 32 != 0) {
                            shape2 = contentPadding;
                            colors2 = interactionSource;
                            $dirty = i28;
                            i17 = elevatedButtonColors;
                            i3 = obj3;
                            i18 = obj12;
                            i11 = obj7;
                            enabled2 = border2;
                            modifier2 = 1466887385;
                            border2 = z3;
                        } else {
                            shape2 = contentPadding;
                            colors2 = interactionSource;
                            i17 = elevatedButtonColors;
                            i3 = obj3;
                            i18 = obj12;
                            i11 = obj7;
                            enabled2 = border2;
                            modifier2 = 1466887385;
                            border2 = z3;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier2, $dirty, -1, "androidx.compose.material3.ElevatedButton (Button.kt:212)");
                }
                ButtonKt.Button(obj2, i17, border2, i3, i18, i11, enabled2, shape2, colors2, content, restartGroup, i37 | i56, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj6 = i17;
                z = border2;
                obj11 = i3;
                obj13 = i18;
                obj = i11;
                $composer2 = enabled2;
                paddingValues = shape2;
                i15 = colors2;
                i12 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                i15 = interactionSource;
                obj6 = elevatedButtonColors;
                z = z3;
                obj11 = obj3;
                composer = restartGroup;
                obj13 = obj12;
                obj = obj7;
                $composer2 = border2;
                paddingValues = contentPadding;
                i12 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ButtonKt.ElevatedButton.1(onClick, obj6, z, obj11, obj13, obj, $composer2, paddingValues, i15, content, i68, i69);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void FilledTonalButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.ButtonColors colors, androidx.compose.material3.ButtonElevation elevation, BorderStroke border, PaddingValues contentPadding, MutableInteractionSource interactionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj5;
        Object obj8;
        boolean traceInProgress;
        int defaultsInvalid;
        Object modifier2;
        int modifier3;
        int $dirty2;
        int $dirty;
        Object contentPadding2;
        int i3;
        Object obj7;
        Object obj6;
        int i16;
        boolean traceInProgress2;
        Object filledTonalButtonColors;
        boolean z;
        int filledTonalShape;
        int i6;
        Object obj4;
        int i10;
        boolean z2;
        Object obj10;
        int i;
        Object obj9;
        Object obj13;
        Object $composer2;
        int changed2;
        Object obj3;
        PaddingValues paddingValues;
        boolean changed3;
        int i7;
        int i20;
        int i17;
        int i4;
        int changed;
        Object obj11;
        Object obj;
        int i5;
        Object i14;
        Object border2;
        int i12;
        int i18;
        int i19;
        int i11;
        int i21;
        Object i2;
        Object enabled2;
        boolean z3;
        Object shape2;
        Object obj12;
        int colors2;
        Object obj2;
        Function3 $dirty3;
        Composer composer;
        int i9;
        int i15;
        int i8;
        final int i68 = $changed;
        final int i69 = i13;
        Composer restartGroup = $composer.startRestartGroup(-1717924381);
        ComposerKt.sourceInformation(restartGroup, "C(FilledTonalButton)P(8,7,5,9,1,4!1,3,6)277@13636L16,278@13696L25,279@13772L28,285@14013L314:Button.kt#uh7d8r");
        $dirty2 = $changed;
        if (i69 & 1 != 0) {
            $dirty2 |= 6;
            obj = onClick;
        } else {
            if (i68 & 6 == 0) {
                i3 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty2 |= i3;
            } else {
                obj = onClick;
            }
        }
        int i38 = i69 & 2;
        if (i38 != 0) {
            $dirty2 |= 48;
            filledTonalButtonColors = modifier;
        } else {
            if (i68 & 48 == 0) {
                i6 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i6;
            } else {
                filledTonalButtonColors = modifier;
            }
        }
        i10 = i69 & 4;
        if (i10 != 0) {
            $dirty2 |= 384;
            z2 = enabled;
        } else {
            if (i68 & 384 == 0) {
                i = restartGroup.changed(enabled) ? 256 : 128;
                $dirty2 |= i;
            } else {
                z2 = enabled;
            }
        }
        if (i68 & 3072 == 0) {
            if (i69 & 8 == 0) {
                changed2 = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj9 = shape;
            }
            $dirty2 |= changed2;
        } else {
            obj9 = shape;
        }
        if (i68 & 24576 == 0) {
            if (i69 & 16 == 0) {
                changed3 = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                obj3 = colors;
            }
            $dirty2 |= changed3;
        } else {
            obj3 = colors;
        }
        if (i67 &= i68 == 0) {
            if (i69 & 32 == 0) {
                i7 = restartGroup.changed(elevation) ? 131072 : 65536;
            } else {
                obj11 = elevation;
            }
            $dirty2 |= i7;
        } else {
            obj11 = elevation;
        }
        i14 = i69 & 64;
        i20 = 1572864;
        if (i14 != 0) {
            $dirty2 |= i20;
            border2 = border;
        } else {
            if (i20 &= i68 == 0) {
                i20 = restartGroup.changed(border) ? 1048576 : 524288;
                $dirty2 |= i20;
            } else {
                border2 = border;
            }
        }
        i4 = i69 & 128;
        i12 = 12582912;
        if (i4 != 0) {
            $dirty2 |= i12;
            obj5 = contentPadding;
        } else {
            if (i68 & i12 == 0) {
                i18 = restartGroup.changed(contentPadding) ? 8388608 : 4194304;
                $dirty2 |= i18;
            } else {
                obj5 = contentPadding;
            }
        }
        int i39 = i69 & 256;
        int i70 = 100663296;
        if (i39 != 0) {
            $dirty2 |= i70;
            i19 = i39;
            obj7 = interactionSource;
        } else {
            if (i68 & i70 == 0) {
                i19 = i39;
                i11 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty2 |= i11;
            } else {
                i19 = i39;
                obj7 = interactionSource;
            }
        }
        i21 = 805306368;
        if (i69 & 512 != 0) {
            $dirty2 |= i21;
            obj8 = content;
        } else {
            if (i68 & i21 == 0) {
                i21 = restartGroup.changedInstance(content) ? 536870912 : 268435456;
                $dirty2 |= i21;
            } else {
                obj8 = content;
            }
        }
        if ($dirty2 & i2 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i72 = -458753;
                i16 = -57345;
                if (i68 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i38 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = filledTonalButtonColors;
                        }
                        z3 = i10 != 0 ? filledTonalButtonColors : z2;
                        i10 = 6;
                        if (i69 & 8 != 0) {
                            $dirty2 &= -7169;
                            obj12 = filledTonalShape;
                        } else {
                            obj12 = obj9;
                        }
                        if (i69 & 16 != 0) {
                            obj2 = filledTonalButtonColors;
                            $dirty3 = $dirty2;
                        } else {
                            obj2 = obj3;
                            $dirty3 = $dirty2;
                        }
                        if (i69 & 32 != 0) {
                            i9 = i64;
                            $dirty3 &= i72;
                            obj11 = $dirty;
                        } else {
                            i9 = i4;
                        }
                        if (i14 != 0) {
                            border2 = $dirty;
                        }
                        if (i9 != 0) {
                            contentPadding2 = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding2 = contentPadding;
                        }
                        if (i19 != 0) {
                            enabled2 = border2;
                            border2 = z5;
                            i14 = modifier2;
                            i2 = obj11;
                            i12 = obj12;
                            i19 = obj2;
                            modifier3 = -1717924381;
                            shape2 = contentPadding2;
                            colors2 = i16;
                            $dirty2 = $dirty3;
                        } else {
                            enabled2 = border2;
                            border2 = z4;
                            i14 = modifier2;
                            i2 = obj11;
                            i12 = obj12;
                            i19 = obj2;
                            modifier3 = -1717924381;
                            colors2 = interactionSource;
                            shape2 = contentPadding2;
                            $dirty2 = $dirty3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i69 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (i69 & 16 != 0) {
                            $dirty2 &= i16;
                        }
                        if (i69 & 32 != 0) {
                            shape2 = contentPadding;
                            colors2 = interactionSource;
                            $dirty2 = i28;
                            i14 = filledTonalButtonColors;
                            i12 = obj9;
                            i19 = obj3;
                            i2 = obj11;
                            enabled2 = border2;
                            modifier3 = -1717924381;
                            border2 = z2;
                        } else {
                            shape2 = contentPadding;
                            colors2 = interactionSource;
                            i14 = filledTonalButtonColors;
                            i12 = obj9;
                            i19 = obj3;
                            i2 = obj11;
                            enabled2 = border2;
                            modifier3 = -1717924381;
                            border2 = z2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier3, $dirty2, -1, "androidx.compose.material3.FilledTonalButton (Button.kt:285)");
                }
                ButtonKt.Button(obj, i14, border2, i12, i19, i2, enabled2, shape2, colors2, content, restartGroup, i37 | i56, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj6 = i14;
                z = border2;
                obj4 = i12;
                obj10 = i19;
                obj13 = i2;
                $composer2 = enabled2;
                paddingValues = shape2;
                i17 = colors2;
                i5 = $dirty2;
            } else {
                restartGroup.skipToGroupEnd();
                i17 = interactionSource;
                obj6 = filledTonalButtonColors;
                z = z2;
                obj4 = obj9;
                composer = restartGroup;
                obj10 = obj3;
                obj13 = obj11;
                $composer2 = border2;
                paddingValues = contentPadding;
                i5 = $dirty2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ButtonKt.FilledTonalButton.1(onClick, obj6, z, obj4, obj10, obj13, $composer2, paddingValues, i17, content, i68, i69);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void OutlinedButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.ButtonColors colors, androidx.compose.material3.ButtonElevation elevation, BorderStroke border, PaddingValues contentPadding, MutableInteractionSource interactionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj4;
        Object obj9;
        Object obj10;
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
        int i12;
        boolean traceInProgress2;
        boolean z;
        Object str;
        Object obj7;
        int i16;
        int i15;
        Object obj6;
        boolean z2;
        Object obj12;
        int i8;
        Object obj5;
        Object obj;
        int changed2;
        Object obj8;
        PaddingValues paddingValues;
        boolean changed;
        int i3;
        int i5;
        Object obj13;
        Object obj11;
        int i7;
        int i14;
        Object border2;
        int changed3;
        boolean i11;
        int i10;
        int i20;
        int i;
        int i2;
        int i6;
        Object i17;
        Object obj3;
        Object obj2;
        int i9;
        Function3 function3;
        Composer composer;
        int i4;
        int i18;
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
                i16 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i16;
            } else {
                str = modifier;
            }
        }
        i15 = i66 & 4;
        if (i15 != 0) {
            $dirty2 |= 384;
            z2 = enabled;
        } else {
            if (i65 & 384 == 0) {
                i8 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty2 |= i8;
            } else {
                z2 = enabled;
            }
        }
        if (i65 & 3072 == 0) {
            if (i66 & 8 == 0) {
                changed2 = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj5 = shape;
            }
            $dirty2 |= changed2;
        } else {
            obj5 = shape;
        }
        if (i65 & 24576 == 0) {
            if (i66 & 16 == 0) {
                changed = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                obj8 = colors;
            }
            $dirty2 |= changed;
        } else {
            obj8 = colors;
        }
        i3 = i66 & 32;
        int i63 = 196608;
        if (i3 != 0) {
            $dirty2 |= i63;
            obj13 = elevation;
        } else {
            if (i63 &= i65 == 0) {
                i14 = restartGroup.changed(elevation) ? 131072 : 65536;
                $dirty2 |= i14;
            } else {
                obj13 = elevation;
            }
        }
        if (i67 &= i65 == 0) {
            if (i66 & 64 == 0) {
                changed3 = restartGroup.changed(border) ? 1048576 : 524288;
            } else {
                border2 = border;
            }
            $dirty2 |= changed3;
        } else {
            border2 = border;
        }
        i11 = i66 & 128;
        i10 = 12582912;
        if (i11 != 0) {
            $dirty2 |= i10;
            obj4 = contentPadding;
        } else {
            if (i65 & i10 == 0) {
                i20 = restartGroup.changed(contentPadding) ? 8388608 : 4194304;
                $dirty2 |= i20;
            } else {
                obj4 = contentPadding;
            }
        }
        int i22 = i66 & 256;
        int i70 = 100663296;
        if (i22 != 0) {
            $dirty2 |= i70;
            i = i22;
            obj9 = interactionSource;
        } else {
            if (i65 & i70 == 0) {
                i = i22;
                i2 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty2 |= i2;
            } else {
                i = i22;
                obj9 = interactionSource;
            }
        }
        i6 = 805306368;
        if (i66 & 512 != 0) {
            $dirty2 |= i6;
            obj10 = content;
        } else {
            if (i65 & i6 == 0) {
                i6 = restartGroup.changedInstance(content) ? 536870912 : 268435456;
                $dirty2 |= i6;
            } else {
                obj10 = content;
            }
        }
        if ($dirty2 & i17 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i12 = -3670017;
                int i72 = -57345;
                if (i65 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i38 != 0) {
                            str = defaultsInvalid;
                        }
                        if (i15 != 0) {
                            z2 = defaultsInvalid;
                        }
                        i15 = 6;
                        if (i66 & 8 != 0) {
                            $dirty2 &= -7169;
                            obj5 = outlinedShape;
                        }
                        if (i66 & 16 != 0) {
                            $dirty2 &= i72;
                            obj8 = shape2;
                        }
                        if (i3 != 0) {
                            obj13 = shape2;
                        }
                        if (i66 & 64 != 0) {
                            $dirty2 &= i12;
                            border2 = outlinedButtonBorder;
                        }
                        if (i11 != 0) {
                            contentPadding2 = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding2 = contentPadding;
                        }
                        if (i != 0) {
                            obj2 = contentPadding2;
                            i9 = i12;
                            i11 = z2;
                            i10 = obj5;
                            i = obj8;
                            i17 = obj13;
                            obj3 = border2;
                            contentPadding3 = -1694808287;
                            border2 = str;
                        } else {
                            i9 = interactionSource;
                            obj2 = contentPadding2;
                            i11 = z2;
                            i10 = obj5;
                            i = obj8;
                            i17 = obj13;
                            obj3 = border2;
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
                            obj2 = contentPadding;
                            i9 = interactionSource;
                            $dirty2 = i37;
                            i11 = z2;
                            i10 = obj5;
                            i = obj8;
                            i17 = obj13;
                            obj3 = border2;
                            contentPadding3 = -1694808287;
                            border2 = str;
                        } else {
                            obj2 = contentPadding;
                            i9 = interactionSource;
                            i11 = z2;
                            i10 = obj5;
                            i = obj8;
                            i17 = obj13;
                            obj3 = border2;
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
                ButtonKt.Button(obj11, border2, i11, i10, i, i17, obj3, obj2, i9, content, restartGroup, i33 | i54, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i7 = $dirty2;
                $dirty = border2;
                z = i11;
                obj7 = i10;
                obj6 = i;
                obj12 = i17;
                obj = obj3;
                paddingValues = obj2;
                i5 = i9;
            } else {
                restartGroup.skipToGroupEnd();
                i5 = interactionSource;
                composer = restartGroup;
                i7 = $dirty2;
                $dirty = str;
                z = z2;
                obj7 = obj5;
                obj6 = obj8;
                obj12 = obj13;
                obj = border2;
                paddingValues = contentPadding;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ButtonKt.OutlinedButton.1(onClick, $dirty, z, obj7, obj6, obj12, obj, paddingValues, i5, content, i65, i66);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void TextButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.ButtonColors colors, androidx.compose.material3.ButtonElevation elevation, BorderStroke border, PaddingValues contentPadding, MutableInteractionSource interactionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj9;
        Object obj7;
        Object obj6;
        int traceInProgress;
        int contentPadding2;
        int defaultsInvalid;
        int textShape;
        int shape2;
        Object contentPadding3;
        Object restartGroup;
        int $dirty;
        Object $dirty2;
        int i2;
        int i8;
        boolean traceInProgress2;
        boolean z2;
        Object str;
        Object obj;
        int i3;
        int i4;
        Object obj3;
        boolean z;
        Object obj2;
        int i;
        Object obj8;
        Object obj4;
        int changed2;
        Object obj11;
        PaddingValues paddingValues;
        boolean changed;
        int i16;
        Object obj10;
        Object obj5;
        int i9;
        int i12;
        Object i17;
        Object border2;
        int i5;
        int i15;
        int i19;
        int i14;
        int i6;
        int i7;
        Object i18;
        Object obj12;
        int obj13;
        Function3 function3;
        Composer composer;
        int i10;
        int i11;
        final int i63 = $changed;
        final int i64 = i13;
        restartGroup = $composer.startRestartGroup(-2106428362);
        ComposerKt.sourceInformation(restartGroup, "C(TextButton)P(8,7,5,9,1,4!1,3,6)422@20900L9,423@20953L18,430@21234L314:Button.kt#uh7d8r");
        $dirty = $changed;
        if (i64 & 1 != 0) {
            $dirty |= 6;
            obj5 = onClick;
        } else {
            if (i63 & 6 == 0) {
                i2 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty |= i2;
            } else {
                obj5 = onClick;
            }
        }
        int i37 = i64 & 2;
        if (i37 != 0) {
            $dirty |= 48;
            str = modifier;
        } else {
            if (i63 & 48 == 0) {
                i3 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i3;
            } else {
                str = modifier;
            }
        }
        i4 = i64 & 4;
        if (i4 != 0) {
            $dirty |= 384;
            z = enabled;
        } else {
            if (i63 & 384 == 0) {
                i = restartGroup.changed(enabled) ? 256 : 128;
                $dirty |= i;
            } else {
                z = enabled;
            }
        }
        if (i63 & 3072 == 0) {
            if (i64 & 8 == 0) {
                changed2 = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj8 = shape;
            }
            $dirty |= changed2;
        } else {
            obj8 = shape;
        }
        if (i63 & 24576 == 0) {
            if (i64 & 16 == 0) {
                changed = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                obj11 = colors;
            }
            $dirty |= changed;
        } else {
            obj11 = colors;
        }
        int i60 = i64 & 32;
        int i61 = 196608;
        if (i60 != 0) {
            $dirty |= i61;
            obj10 = elevation;
        } else {
            if (i61 &= i63 == 0) {
                i12 = restartGroup.changed(elevation) ? 131072 : 65536;
                $dirty |= i12;
            } else {
                obj10 = elevation;
            }
        }
        i17 = i64 & 64;
        int i65 = 1572864;
        if (i17 != 0) {
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
            i15 = i21;
            obj9 = contentPadding;
        } else {
            if (i63 & i67 == 0) {
                i15 = i21;
                i19 = restartGroup.changed(contentPadding) ? 8388608 : 4194304;
                $dirty |= i19;
            } else {
                i15 = i21;
                obj9 = contentPadding;
            }
        }
        int i22 = i64 & 256;
        int i69 = 100663296;
        if (i22 != 0) {
            $dirty |= i69;
            i14 = i22;
            obj7 = interactionSource;
        } else {
            if (i63 & i69 == 0) {
                i14 = i22;
                i6 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty |= i6;
            } else {
                i14 = i22;
                obj7 = interactionSource;
            }
        }
        i7 = 805306368;
        if (i64 & 512 != 0) {
            $dirty |= i7;
            obj6 = content;
        } else {
            if (i63 & i7 == 0) {
                i7 = restartGroup.changedInstance(content) ? 536870912 : 268435456;
                $dirty |= i7;
            } else {
                obj6 = content;
            }
        }
        if ($dirty & i18 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i8 = -57345;
                if (i63 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i37 != 0) {
                            str = defaultsInvalid;
                        }
                        if (i4 != 0) {
                            z = defaultsInvalid;
                        }
                        i4 = 6;
                        if (i64 & 8 != 0) {
                            $dirty &= -7169;
                            obj8 = textShape;
                        }
                        if (i64 & 16 != 0) {
                            $dirty &= i8;
                            obj11 = shape2;
                        }
                        if (i60 != 0) {
                            obj10 = shape2;
                        }
                        if (i17 != 0) {
                            border2 = shape2;
                        }
                        if (i15 != 0) {
                            contentPadding3 = ButtonDefaults.INSTANCE.getTextButtonContentPadding();
                        } else {
                            contentPadding3 = contentPadding;
                        }
                        if (i14 != 0) {
                            obj12 = contentPadding3;
                            obj13 = i8;
                            i17 = str;
                            i5 = obj8;
                            i15 = obj11;
                            i14 = obj10;
                            i18 = border2;
                            contentPadding2 = -2106428362;
                            border2 = z;
                        } else {
                            obj13 = interactionSource;
                            obj12 = contentPadding3;
                            i17 = str;
                            i5 = obj8;
                            i15 = obj11;
                            i14 = obj10;
                            i18 = border2;
                            contentPadding2 = -2106428362;
                            border2 = z;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i64 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        if (i64 & 16 != 0) {
                            obj12 = contentPadding;
                            obj13 = interactionSource;
                            $dirty = i27;
                            i17 = str;
                            i5 = obj8;
                            i15 = obj11;
                            i14 = obj10;
                            i18 = border2;
                            contentPadding2 = -2106428362;
                            border2 = z;
                        } else {
                            obj12 = contentPadding;
                            obj13 = interactionSource;
                            i17 = str;
                            i5 = obj8;
                            i15 = obj11;
                            i14 = obj10;
                            i18 = border2;
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
                ButtonKt.Button(obj5, i17, border2, i5, i15, i14, i18, obj12, obj13, content, restartGroup, i36 | i53, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i9 = $dirty;
                $dirty2 = i17;
                z2 = border2;
                obj = i5;
                obj3 = i15;
                obj2 = i14;
                obj4 = i18;
                paddingValues = obj12;
                i16 = obj13;
            } else {
                restartGroup.skipToGroupEnd();
                i16 = interactionSource;
                composer = restartGroup;
                i9 = $dirty;
                $dirty2 = str;
                z2 = z;
                obj = obj8;
                obj3 = obj11;
                obj2 = obj10;
                obj4 = border2;
                paddingValues = contentPadding;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ButtonKt.TextButton.1(onClick, $dirty2, z2, obj, obj3, obj2, obj4, paddingValues, i16, content, i63, i64);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }
}
