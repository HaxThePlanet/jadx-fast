package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.tokens.IconButtonTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.Role.Companion;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001ab\u0010\u0000\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001ap\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00142\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u00152\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u000fH\u0007¢\u0006\u0002\u0010\u0016\u001ab\u0010\u0017\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001ap\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00142\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u00152\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u000fH\u0007¢\u0006\u0002\u0010\u0016\u001aX\u0010\u0019\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u000fH\u0007¢\u0006\u0002\u0010\u001a\u001af\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00142\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\n\u001a\u00020\u00152\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u000fH\u0007¢\u0006\u0002\u0010\u001c\u001an\u0010\u001d\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u000fH\u0007¢\u0006\u0002\u0010 \u001a|\u0010!\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00142\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u00152\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u000fH\u0007¢\u0006\u0002\u0010\"¨\u0006#", d2 = {"FilledIconButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/IconButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "FilledIconToggleButton", "checked", "onCheckedChange", "Lkotlin/Function1;", "Landroidx/compose/material3/IconToggleButtonColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "FilledTonalIconButton", "FilledTonalIconToggleButton", "IconButton", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconToggleButton", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OutlinedIconButton", "border", "Landroidx/compose/foundation/BorderStroke;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OutlinedIconToggleButton", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IconButtonKt {
    public static final void FilledIconButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.IconButtonColors colors, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int traceInProgress;
        Object restartGroup;
        int $dirty2;
        Object $dirty4;
        Object $dirty;
        int i3;
        Object modifier3;
        boolean modifier2;
        Object obj4;
        int filledShape;
        int shape2;
        int interactionSource2;
        Object $dirty3;
        int i9;
        int i6;
        boolean traceInProgress2;
        Object obj;
        boolean str;
        Object obj3;
        Object obj5;
        int i11;
        Object obj2;
        int i;
        int changed2;
        Object colors2;
        int changed;
        Object i12;
        Object containerColor-vNxB06k$material3_release;
        int i14;
        int i13;
        int defaultsInvalid;
        int contentColor-vNxB06k$material3_release;
        int i8;
        int i5;
        int i2;
        Object obj6;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i15;
        int i4;
        int i7;
        Object obj27;
        final Object obj9 = content;
        final int i34 = $changed;
        traceInProgress = 1594730011;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(FilledIconButton)P(5,4,2,6!1,3)217@10330L11,218@10393L24,230@10821L320,222@10520L621:IconButton.kt#uh7d8r");
        $dirty2 = $changed;
        if (i10 & 1 != 0) {
            $dirty2 |= 6;
            obj5 = onClick;
        } else {
            if (i34 & 6 == 0) {
                i3 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty2 |= i3;
            } else {
                obj5 = onClick;
            }
        }
        int i20 = i10 & 2;
        if (i20 != 0) {
            $dirty2 |= 48;
            obj4 = modifier;
        } else {
            if (i34 & 48 == 0) {
                i9 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i9;
            } else {
                obj4 = modifier;
            }
        }
        i6 = i10 & 4;
        if (i6 != 0) {
            $dirty2 |= 384;
            str = enabled;
        } else {
            if (i34 & 384 == 0) {
                i11 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty2 |= i11;
            } else {
                str = enabled;
            }
        }
        if (i34 & 3072 == 0) {
            if (i10 & 8 == 0) {
                changed2 = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj2 = shape;
            }
            $dirty2 |= changed2;
        } else {
            obj2 = shape;
        }
        if (i34 & 24576 == 0) {
            if (i10 & 16 == 0) {
                changed = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                colors2 = colors;
            }
            $dirty2 |= changed;
        } else {
            colors2 = colors;
        }
        i12 = i10 & 32;
        int i40 = 196608;
        if (i12 != 0) {
            $dirty2 |= i40;
            containerColor-vNxB06k$material3_release = interactionSource;
        } else {
            if (i40 &= i34 == 0) {
                i14 = restartGroup.changed(interactionSource) ? 131072 : 65536;
                $dirty2 |= i14;
            } else {
                containerColor-vNxB06k$material3_release = interactionSource;
            }
        }
        int i43 = 1572864;
        if (i10 & 64 != 0) {
            $dirty2 |= i43;
        } else {
            if (i34 & i43 == 0) {
                i13 = restartGroup.changedInstance(obj9) ? 1048576 : 524288;
                $dirty2 |= i13;
            }
        }
        if (i42 &= $dirty2 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i44 = -57345;
                if (i34 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i20 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = obj4;
                        }
                        if (i6 != 0) {
                            str = obj4;
                        }
                        i6 = 6;
                        if (i10 & 8 != 0) {
                            $dirty2 &= -7169;
                            obj2 = filledShape;
                        }
                        if (i10 & 16 != 0) {
                            $dirty2 &= i44;
                            colors2 = shape2;
                        }
                        if (i12 != 0) {
                            obj6 = i24;
                            i12 = obj2;
                            interactionSource2 = $dirty2;
                            $dirty4 = colors2;
                            colors2 = str;
                        } else {
                            interactionSource2 = $dirty2;
                            i12 = obj2;
                            $dirty4 = colors2;
                            obj6 = containerColor-vNxB06k$material3_release;
                            colors2 = str;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i10 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (i10 & 16 != 0) {
                            $dirty2 &= i44;
                        }
                        modifier3 = obj4;
                        i12 = obj2;
                        obj6 = containerColor-vNxB06k$material3_release;
                        interactionSource2 = $dirty2;
                        $dirty4 = colors2;
                        colors2 = str;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, interactionSource2, -1, "androidx.compose.material3.FilledIconButton (IconButton.kt:222)");
                }
                int i37 = 1;
                IconButtonKt.FilledIconButton.2 anon = new IconButtonKt.FilledIconButton.2(obj9);
                SurfaceKt.Surface-o_FOJdg(obj5, SemanticsModifierKt.semantics$default(modifier3, false, (Function1)IconButtonKt.FilledIconButton.1.INSTANCE, i37, 0), colors2, i12, $dirty4.containerColor-vNxB06k$material3_release(colors2), defaultsInvalid, $dirty4.contentColor-vNxB06k$material3_release(colors2), obj16, 0, 0, 0, obj6, (Function2)ComposableLambdaKt.rememberComposableLambda(-1560623888, i37, anon, restartGroup, 54), restartGroup, i19 | i29);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = $dirty4;
                $dirty = modifier3;
                i = interactionSource2;
                modifier2 = colors2;
                $dirty3 = i12;
                obj3 = obj6;
            } else {
                restartGroup.skipToGroupEnd();
                i = $dirty2;
                $dirty = obj4;
                $dirty3 = obj8;
                composer = restartGroup;
                modifier2 = str;
                obj = colors2;
                obj3 = containerColor-vNxB06k$material3_release;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new IconButtonKt.FilledIconButton.3(onClick, $dirty, modifier2, $dirty3, obj, obj3, obj9, i34, i10);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void FilledIconToggleButton(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.IconToggleButtonColors colors, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        boolean traceInProgress;
        boolean obj2;
        int modifier2;
        int defaultsInvalid;
        int filledShape;
        int shape3;
        Object obj3;
        boolean z;
        Object enabled2;
        int i8;
        Object obj7;
        boolean shape2;
        int $dirty3;
        Object $dirty2;
        Object $dirty;
        int i7;
        Object obj8;
        Object obj;
        int i4;
        int i5;
        Object obj9;
        Object semantics$default;
        boolean traceInProgress2;
        int i3;
        int str;
        boolean colors6;
        int i;
        Object colors4;
        int changed;
        Object colors2;
        int changed2;
        androidx.compose.runtime.internal.ComposableLambda i6;
        Object obj6;
        int i2;
        int colors3;
        int colors5;
        Object obj4;
        Object obj5;
        long l;
        traceInProgress = checked;
        obj2 = content;
        int i23 = $changed;
        int i28 = i11;
        final Composer restartGroup = $composer.startRestartGroup(-1708189280);
        ComposerKt.sourceInformation(restartGroup, "C(FilledIconToggleButton)P(!1,6,5,3,7!1,4)349@16472L11,350@16541L30,360@16890L32,361@16960L30,363@17050L320,354@16674L696:IconButton.kt#uh7d8r");
        $dirty3 = $changed;
        if (i28 & 1 != 0) {
            $dirty3 |= 6;
        } else {
            if (i23 & 6 == 0) {
                i7 = restartGroup.changed(traceInProgress) ? 4 : 2;
                $dirty3 |= i7;
            }
        }
        if (i28 & 2 != 0) {
            $dirty3 |= 48;
            obj8 = onCheckedChange;
        } else {
            if (i23 & 48 == 0) {
                i4 = restartGroup.changedInstance(onCheckedChange) ? 32 : 16;
                $dirty3 |= i4;
            } else {
                obj8 = onCheckedChange;
            }
        }
        int i35 = i28 & 4;
        if (i35 != 0) {
            $dirty3 |= 384;
            semantics$default = modifier;
        } else {
            if (i23 & 384 == 0) {
                i3 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty3 |= i3;
            } else {
                semantics$default = modifier;
            }
        }
        str = i28 & 8;
        if (str != null) {
            $dirty3 |= 3072;
            colors6 = enabled;
        } else {
            if (i23 & 3072 == 0) {
                i = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty3 |= i;
            } else {
                colors6 = enabled;
            }
        }
        if (i23 & 24576 == 0) {
            if (i28 & 16 == 0) {
                changed = restartGroup.changed(shape) ? 16384 : 8192;
            } else {
                colors4 = shape;
            }
            $dirty3 |= changed;
        } else {
            colors4 = shape;
        }
        if (i52 &= i23 == 0) {
            if (i28 & 32 == 0) {
                changed2 = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                colors2 = colors;
            }
            $dirty3 |= changed2;
        } else {
            colors2 = colors;
        }
        i6 = i28 & 64;
        int i59 = 1572864;
        if (i6 != 0) {
            $dirty3 |= i59;
            obj6 = interactionSource;
        } else {
            if (i59 &= i23 == 0) {
                i2 = restartGroup.changed(interactionSource) ? 1048576 : 524288;
                $dirty3 |= i2;
            } else {
                obj6 = interactionSource;
            }
        }
        colors3 = 12582912;
        if (i28 & 128 != 0) {
            $dirty3 |= colors3;
        } else {
            if (i23 & colors3 == 0) {
                i8 = restartGroup.changedInstance(obj2) ? 8388608 : 4194304;
                $dirty3 |= i8;
            }
        }
        if (i30 &= $dirty3 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i32 = -458753;
                int i65 = -57345;
                if ($changed & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i35 != 0) {
                            semantics$default = defaultsInvalid;
                        }
                        if (str != null) {
                            colors6 = defaultsInvalid;
                        }
                        int i36 = 6;
                        if (i28 & 16 != 0) {
                            $dirty3 &= i65;
                            colors4 = filledShape;
                        }
                        if (i28 & 32 != 0) {
                            $dirty3 &= i32;
                            colors2 = shape3;
                        }
                        if (i6 != 0) {
                            i5 = $dirty3;
                            z = colors6;
                            obj7 = colors4;
                            $dirty2 = colors2;
                            colors2 = i24;
                            obj3 = semantics$default;
                        } else {
                            i5 = $dirty3;
                            obj3 = semantics$default;
                            z = colors6;
                            obj7 = colors4;
                            $dirty2 = colors2;
                            colors2 = obj6;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i28 & 16 != 0) {
                            $dirty3 &= i65;
                        }
                        if (i28 & 32 != 0) {
                            i5 = i27;
                            obj3 = semantics$default;
                            z = colors6;
                            obj7 = colors4;
                            $dirty2 = colors2;
                            colors2 = obj6;
                        } else {
                            i5 = $dirty3;
                            obj3 = semantics$default;
                            z = colors6;
                            obj7 = colors4;
                            $dirty2 = colors2;
                            colors2 = obj6;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1708189280, i5, -1, "androidx.compose.material3.FilledIconToggleButton (IconButton.kt:354)");
                }
                int i50 = 1;
                semantics$default = SemanticsModifierKt.semantics$default(obj3, false, (Function1)IconButtonKt.FilledIconToggleButton.1.INSTANCE, i50, 0);
                IconButtonKt.FilledIconToggleButton.2 anon = new IconButtonKt.FilledIconToggleButton.2(obj2);
                colors5 = i5;
                SurfaceKt.Surface-d85dljk(checked, onCheckedChange, semantics$default, z, obj7, (Color)$dirty2.containerColor$material3_release(z, traceInProgress, restartGroup, i41 |= i48).getValue().unbox-impl(), obj8, (Color)$dirty2.contentColor$material3_release(z, traceInProgress, restartGroup, i57 |= i64).getValue().unbox-impl(), semantics$default, 0, 0, 0, colors2, (Function2)ComposableLambdaKt.rememberComposableLambda(1235871670, i50, anon, restartGroup, 54), restartGroup, i13 |= i19);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty = obj7;
                obj9 = colors2;
                obj = obj5;
                shape2 = z;
                enabled2 = obj4;
            } else {
                restartGroup.skipToGroupEnd();
                colors5 = $dirty3;
                enabled2 = semantics$default;
                shape2 = colors6;
                $dirty = colors4;
                obj = colors2;
                obj9 = obj6;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new IconButtonKt.FilledIconToggleButton.3(checked, onCheckedChange, enabled2, shape2, $dirty, obj, obj9, content, $changed, i11);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void FilledTonalIconButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.IconButtonColors colors, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int traceInProgress;
        Object restartGroup;
        int $dirty4;
        Object $dirty2;
        Object $dirty;
        int i7;
        Object modifier2;
        boolean modifier3;
        Object obj2;
        int filledShape;
        int shape2;
        int interactionSource2;
        Object $dirty3;
        int i8;
        int i12;
        boolean traceInProgress2;
        Object obj6;
        boolean str;
        Object obj4;
        Object obj;
        int i;
        Object obj5;
        int i15;
        int changed2;
        Object colors2;
        int changed;
        Object i13;
        Object containerColor-vNxB06k$material3_release;
        int i5;
        int i2;
        int defaultsInvalid;
        int contentColor-vNxB06k$material3_release;
        int i9;
        int i6;
        int i3;
        Object obj3;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i14;
        int i4;
        int i11;
        Object obj27;
        final Object obj9 = content;
        final int i34 = $changed;
        traceInProgress = -783937767;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(FilledTonalIconButton)P(5,4,2,6!1,3)284@13478L11,285@13541L29,297@13974L330,289@13673L631:IconButton.kt#uh7d8r");
        $dirty4 = $changed;
        if (i10 & 1 != 0) {
            $dirty4 |= 6;
            obj = onClick;
        } else {
            if (i34 & 6 == 0) {
                i7 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty4 |= i7;
            } else {
                obj = onClick;
            }
        }
        int i20 = i10 & 2;
        if (i20 != 0) {
            $dirty4 |= 48;
            obj2 = modifier;
        } else {
            if (i34 & 48 == 0) {
                i8 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty4 |= i8;
            } else {
                obj2 = modifier;
            }
        }
        i12 = i10 & 4;
        if (i12 != 0) {
            $dirty4 |= 384;
            str = enabled;
        } else {
            if (i34 & 384 == 0) {
                i = restartGroup.changed(enabled) ? 256 : 128;
                $dirty4 |= i;
            } else {
                str = enabled;
            }
        }
        if (i34 & 3072 == 0) {
            if (i10 & 8 == 0) {
                changed2 = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj5 = shape;
            }
            $dirty4 |= changed2;
        } else {
            obj5 = shape;
        }
        if (i34 & 24576 == 0) {
            if (i10 & 16 == 0) {
                changed = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                colors2 = colors;
            }
            $dirty4 |= changed;
        } else {
            colors2 = colors;
        }
        i13 = i10 & 32;
        int i40 = 196608;
        if (i13 != 0) {
            $dirty4 |= i40;
            containerColor-vNxB06k$material3_release = interactionSource;
        } else {
            if (i40 &= i34 == 0) {
                i5 = restartGroup.changed(interactionSource) ? 131072 : 65536;
                $dirty4 |= i5;
            } else {
                containerColor-vNxB06k$material3_release = interactionSource;
            }
        }
        int i43 = 1572864;
        if (i10 & 64 != 0) {
            $dirty4 |= i43;
        } else {
            if (i34 & i43 == 0) {
                i2 = restartGroup.changedInstance(obj9) ? 1048576 : 524288;
                $dirty4 |= i2;
            }
        }
        if (i42 &= $dirty4 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i44 = -57345;
                if (i34 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i20 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj2;
                        }
                        if (i12 != 0) {
                            str = obj2;
                        }
                        i12 = 6;
                        if (i10 & 8 != 0) {
                            $dirty4 &= -7169;
                            obj5 = filledShape;
                        }
                        if (i10 & 16 != 0) {
                            $dirty4 &= i44;
                            colors2 = shape2;
                        }
                        if (i13 != 0) {
                            obj3 = i24;
                            i13 = obj5;
                            interactionSource2 = $dirty4;
                            $dirty2 = colors2;
                            colors2 = str;
                        } else {
                            interactionSource2 = $dirty4;
                            i13 = obj5;
                            $dirty2 = colors2;
                            obj3 = containerColor-vNxB06k$material3_release;
                            colors2 = str;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i10 & 8 != 0) {
                            $dirty4 &= -7169;
                        }
                        if (i10 & 16 != 0) {
                            $dirty4 &= i44;
                        }
                        modifier2 = obj2;
                        i13 = obj5;
                        obj3 = containerColor-vNxB06k$material3_release;
                        interactionSource2 = $dirty4;
                        $dirty2 = colors2;
                        colors2 = str;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, interactionSource2, -1, "androidx.compose.material3.FilledTonalIconButton (IconButton.kt:289)");
                }
                int i37 = 1;
                IconButtonKt.FilledTonalIconButton.2 anon = new IconButtonKt.FilledTonalIconButton.2(obj9);
                SurfaceKt.Surface-o_FOJdg(obj, SemanticsModifierKt.semantics$default(modifier2, false, (Function1)IconButtonKt.FilledTonalIconButton.1.INSTANCE, i37, 0), colors2, i13, $dirty2.containerColor-vNxB06k$material3_release(colors2), defaultsInvalid, $dirty2.contentColor-vNxB06k$material3_release(colors2), obj16, 0, 0, 0, obj3, (Function2)ComposableLambdaKt.rememberComposableLambda(-1772884636, i37, anon, restartGroup, 54), restartGroup, i19 | i29);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj6 = $dirty2;
                $dirty = modifier2;
                i15 = interactionSource2;
                modifier3 = colors2;
                $dirty3 = i13;
                obj4 = obj3;
            } else {
                restartGroup.skipToGroupEnd();
                i15 = $dirty4;
                $dirty = obj2;
                $dirty3 = obj8;
                composer = restartGroup;
                modifier3 = str;
                obj6 = colors2;
                obj4 = containerColor-vNxB06k$material3_release;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new IconButtonKt.FilledTonalIconButton.3(onClick, $dirty, modifier3, $dirty3, obj6, obj4, obj9, i34, i10);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void FilledTonalIconToggleButton(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.IconToggleButtonColors colors, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        boolean traceInProgress2;
        boolean obj5;
        int modifier2;
        int defaultsInvalid;
        int filledShape;
        int shape2;
        Object obj2;
        boolean z;
        Object enabled2;
        int i8;
        Object obj3;
        boolean shape3;
        int $dirty3;
        Object $dirty2;
        Object $dirty;
        int i5;
        Object obj4;
        Object obj8;
        int i;
        int i4;
        Object obj7;
        Object semantics$default;
        boolean traceInProgress;
        int i2;
        int str;
        boolean colors3;
        int i3;
        Object colors6;
        int changed;
        Object colors4;
        int changed2;
        androidx.compose.runtime.internal.ComposableLambda i6;
        Object obj9;
        int i7;
        int colors5;
        int colors2;
        Object obj6;
        Object obj;
        long l;
        traceInProgress2 = checked;
        obj5 = content;
        int i23 = $changed;
        int i28 = i11;
        final Composer restartGroup = $composer.startRestartGroup(1676089246);
        ComposerKt.sourceInformation(restartGroup, "C(FilledTonalIconToggleButton)P(!1,6,5,3,7!1,4)420@19894L11,421@19963L35,431@20317L32,432@20387L30,434@20477L330,425@20101L706:IconButton.kt#uh7d8r");
        $dirty3 = $changed;
        if (i28 & 1 != 0) {
            $dirty3 |= 6;
        } else {
            if (i23 & 6 == 0) {
                i5 = restartGroup.changed(traceInProgress2) ? 4 : 2;
                $dirty3 |= i5;
            }
        }
        if (i28 & 2 != 0) {
            $dirty3 |= 48;
            obj4 = onCheckedChange;
        } else {
            if (i23 & 48 == 0) {
                i = restartGroup.changedInstance(onCheckedChange) ? 32 : 16;
                $dirty3 |= i;
            } else {
                obj4 = onCheckedChange;
            }
        }
        int i35 = i28 & 4;
        if (i35 != 0) {
            $dirty3 |= 384;
            semantics$default = modifier;
        } else {
            if (i23 & 384 == 0) {
                i2 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty3 |= i2;
            } else {
                semantics$default = modifier;
            }
        }
        str = i28 & 8;
        if (str != null) {
            $dirty3 |= 3072;
            colors3 = enabled;
        } else {
            if (i23 & 3072 == 0) {
                i3 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty3 |= i3;
            } else {
                colors3 = enabled;
            }
        }
        if (i23 & 24576 == 0) {
            if (i28 & 16 == 0) {
                changed = restartGroup.changed(shape) ? 16384 : 8192;
            } else {
                colors6 = shape;
            }
            $dirty3 |= changed;
        } else {
            colors6 = shape;
        }
        if (i52 &= i23 == 0) {
            if (i28 & 32 == 0) {
                changed2 = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                colors4 = colors;
            }
            $dirty3 |= changed2;
        } else {
            colors4 = colors;
        }
        i6 = i28 & 64;
        int i59 = 1572864;
        if (i6 != 0) {
            $dirty3 |= i59;
            obj9 = interactionSource;
        } else {
            if (i59 &= i23 == 0) {
                i7 = restartGroup.changed(interactionSource) ? 1048576 : 524288;
                $dirty3 |= i7;
            } else {
                obj9 = interactionSource;
            }
        }
        colors5 = 12582912;
        if (i28 & 128 != 0) {
            $dirty3 |= colors5;
        } else {
            if (i23 & colors5 == 0) {
                i8 = restartGroup.changedInstance(obj5) ? 8388608 : 4194304;
                $dirty3 |= i8;
            }
        }
        if (i30 &= $dirty3 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i32 = -458753;
                int i65 = -57345;
                if ($changed & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i35 != 0) {
                            semantics$default = defaultsInvalid;
                        }
                        if (str != null) {
                            colors3 = defaultsInvalid;
                        }
                        int i36 = 6;
                        if (i28 & 16 != 0) {
                            $dirty3 &= i65;
                            colors6 = filledShape;
                        }
                        if (i28 & 32 != 0) {
                            $dirty3 &= i32;
                            colors4 = shape2;
                        }
                        if (i6 != 0) {
                            i4 = $dirty3;
                            z = colors3;
                            obj3 = colors6;
                            $dirty2 = colors4;
                            colors4 = i24;
                            obj2 = semantics$default;
                        } else {
                            i4 = $dirty3;
                            obj2 = semantics$default;
                            z = colors3;
                            obj3 = colors6;
                            $dirty2 = colors4;
                            colors4 = obj9;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i28 & 16 != 0) {
                            $dirty3 &= i65;
                        }
                        if (i28 & 32 != 0) {
                            i4 = i27;
                            obj2 = semantics$default;
                            z = colors3;
                            obj3 = colors6;
                            $dirty2 = colors4;
                            colors4 = obj9;
                        } else {
                            i4 = $dirty3;
                            obj2 = semantics$default;
                            z = colors3;
                            obj3 = colors6;
                            $dirty2 = colors4;
                            colors4 = obj9;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1676089246, i4, -1, "androidx.compose.material3.FilledTonalIconToggleButton (IconButton.kt:425)");
                }
                int i50 = 1;
                semantics$default = SemanticsModifierKt.semantics$default(obj2, false, (Function1)IconButtonKt.FilledTonalIconToggleButton.1.INSTANCE, i50, 0);
                IconButtonKt.FilledTonalIconToggleButton.2 anon = new IconButtonKt.FilledTonalIconToggleButton.2(obj5);
                colors2 = i4;
                SurfaceKt.Surface-d85dljk(checked, onCheckedChange, semantics$default, z, obj3, (Color)$dirty2.containerColor$material3_release(z, traceInProgress2, restartGroup, i41 |= i48).getValue().unbox-impl(), obj4, (Color)$dirty2.contentColor$material3_release(z, traceInProgress2, restartGroup, i57 |= i64).getValue().unbox-impl(), semantics$default, 0, 0, 0, colors4, (Function2)ComposableLambdaKt.rememberComposableLambda(-58218680, i50, anon, restartGroup, 54), restartGroup, i13 |= i19);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty = obj3;
                obj7 = colors4;
                obj8 = obj;
                shape3 = z;
                enabled2 = obj6;
            } else {
                restartGroup.skipToGroupEnd();
                colors2 = $dirty3;
                enabled2 = semantics$default;
                shape3 = colors3;
                $dirty = colors6;
                obj8 = colors4;
                obj7 = obj9;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new IconButtonKt.FilledTonalIconToggleButton.3(checked, onCheckedChange, enabled2, shape3, $dirty, obj8, obj7, content, $changed, i11);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void IconButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, androidx.compose.material3.IconButtonColors colors, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        int traceInProgress2;
        int $dirty2;
        boolean $dirty;
        Function0 factory$iv$iv$iv;
        Object obj5;
        Object obj4;
        boolean currentCompositionLocalMap;
        int i12;
        boolean z2;
        Object modifier2;
        Object obj;
        Object obj3;
        int iconButtonColors;
        int i5;
        Object obj2;
        Object obj6;
        Composer composer2;
        Integer valueOf;
        boolean z;
        int enabled2;
        int i;
        Object obj7;
        boolean traceInProgress;
        int changed;
        int str;
        Object maybeCachedBoxMeasurePolicy;
        int i13;
        int i14;
        boolean skipping;
        boolean defaultsInvalid;
        int i4;
        int i8;
        int i2;
        int i6;
        long l2;
        int i10;
        BoxScopeInstance boxScopeInstance;
        Function0 function0;
        int i3;
        int i7;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        int i15;
        Composer composer;
        long l;
        int i11;
        Object obj31;
        Alignment obj32;
        int obj33;
        Object obj34;
        Modifier obj36;
        final Object obj8 = content;
        final int i35 = $changed;
        traceInProgress2 = -1142896114;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(IconButton)P(5,4,2!1,3)85@4039L18,94@4366L5,102@4703L175,89@4160L944:IconButton.kt#uh7d8r");
        $dirty2 = $changed;
        if (i9 & 1 != 0) {
            $dirty2 |= 6;
            obj5 = onClick;
        } else {
            if (i35 & 6 == 0) {
                i12 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty2 |= i12;
            } else {
                obj5 = onClick;
            }
        }
        int i25 = i9 & 2;
        if (i25 != 0) {
            $dirty2 |= 48;
            obj = modifier;
        } else {
            if (i35 & 48 == 0) {
                i5 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i5;
            } else {
                obj = modifier;
            }
        }
        int i30 = i9 & 4;
        if (i30 != 0) {
            $dirty2 |= 384;
            z = enabled;
        } else {
            if (i35 & 384 == 0) {
                i = restartGroup.changed(enabled) ? 256 : 128;
                $dirty2 |= i;
            } else {
                z = enabled;
            }
        }
        if (i35 & 3072 == 0) {
            if (i9 & 8 == 0) {
                changed = restartGroup.changed(colors) ? 2048 : 1024;
            } else {
                obj7 = colors;
            }
            $dirty2 |= changed;
        } else {
            obj7 = colors;
        }
        str = i9 & 16;
        if (str != null) {
            $dirty2 |= 24576;
            maybeCachedBoxMeasurePolicy = interactionSource;
        } else {
            if (i35 & 24576 == 0) {
                i13 = restartGroup.changed(interactionSource) ? 16384 : 8192;
                $dirty2 |= i13;
            } else {
                maybeCachedBoxMeasurePolicy = interactionSource;
            }
        }
        int i47 = 196608;
        if (i9 & 32 != 0) {
            $dirty2 |= i47;
        } else {
            if (i35 & i47 == 0) {
                i14 = restartGroup.changedInstance(obj8) ? 131072 : 65536;
                $dirty2 |= i14;
            }
        }
        if (i43 &= $dirty2 == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i49 = 6;
                if (i35 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i25 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj;
                        }
                        if (i30 != 0) {
                            z = obj;
                        }
                        if (i9 & 8 != 0) {
                            $dirty2 &= -7169;
                            obj7 = iconButtonColors;
                        }
                        if (str != null) {
                            enabled2 = $dirty2;
                            $dirty = z5;
                            obj6 = i29;
                            obj3 = obj7;
                        } else {
                            enabled2 = $dirty2;
                            $dirty = interactionSource2;
                            obj3 = obj7;
                            obj6 = maybeCachedBoxMeasurePolicy;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i9 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        enabled2 = $dirty2;
                        $dirty = z4;
                        modifier2 = obj;
                        obj3 = obj7;
                        obj6 = maybeCachedBoxMeasurePolicy;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, enabled2, -1, "androidx.compose.material3.IconButton (IconButton.kt:88)");
                }
                int i57 = 0;
                boolean z6 = $dirty;
                i4 = obj6;
                Modifier clickable-O2vRcR0$default = ClickableKt.clickable-O2vRcR0$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2), IconButtonTokens.INSTANCE.getStateLayerSize-D9Ej5fM()), ShapesKt.getValue(IconButtonTokens.INSTANCE.getStateLayerShape(), restartGroup, i49)), obj3.containerColor-vNxB06k$material3_release($dirty), obj18, 0, 2), i4, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(false, Dp.constructor-impl(stateLayerSize-D9Ej5fM2 / f), 0, 0, restartGroup, 54), z6, 0, Role.box-impl(Role.Companion.getButton-o7Vup1c()), obj5, 8, i57);
                z = z6;
                Alignment center = Alignment.Companion.getCenter();
                valueOf = 48;
                obj7 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                i8 = 0;
                obj31 = i16;
                obj32 = center;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                obj33 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, clickable-O2vRcR0$default);
                obj34 = clickable-O2vRcR0$default;
                obj36 = constructor;
                i2 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(obj36);
                } else {
                    factory$iv$iv$iv = obj36;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i53 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(center, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i56 = 0;
                obj36 = constructor-impl;
                int i58 = 0;
                if (!obj36.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap;
                    i15 = valueOf;
                    if (!Intrinsics.areEqual(obj36.rememberedValue(), Integer.valueOf(obj33))) {
                        obj36.updateRememberedValue(Integer.valueOf(obj33));
                        constructor-impl.apply(Integer.valueOf(obj33), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = obj36;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    i15 = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer3 = restartGroup;
                int i26 = 0;
                obj36 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i33 |= 6;
                obj31 = composer3;
                i10 = 0;
                boxScopeInstance = iNSTANCE;
                i7 = i22;
                ComposerKt.sourceInformationMarkerStart(composer3, 782643754, "C110@5014L84:IconButton.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(obj3.contentColor-vNxB06k$material3_release(z))), obj8, composer3, $stable |= i11);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = i4;
                obj4 = l2;
                z2 = z;
            } else {
                restartGroup.skipToGroupEnd();
                i3 = $dirty2;
                obj4 = obj;
                obj3 = obj7;
                obj2 = maybeCachedBoxMeasurePolicy;
                z2 = z;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new IconButtonKt.IconButton.2(onClick, obj4, z2, obj3, obj2, obj8, i35, i9);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void IconToggleButton(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, androidx.compose.material3.IconToggleButtonColors colors, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int traceInProgress2;
        Function0 factory$iv$iv$iv;
        int $dirty2;
        Object $dirty;
        int i2;
        int i9;
        Object obj5;
        int modifier2;
        Integer currentCompositionLocalMap;
        Object modifier4;
        Object obj8;
        boolean enabled2;
        int i11;
        Object obj4;
        Object obj7;
        int iconToggleButtonColors;
        Object obj2;
        Object obj3;
        Composer composer2;
        int valueOf;
        boolean z;
        int i4;
        Object obj6;
        int colors2;
        boolean traceInProgress;
        int changed;
        int str;
        Object maybeCachedBoxMeasurePolicy;
        int i;
        int i13;
        boolean skipping;
        boolean defaultsInvalid;
        int i6;
        Object obj;
        int i7;
        int i3;
        long l;
        int i5;
        int i8;
        int i12;
        BoxScopeInstance boxScopeInstance;
        Modifier modifier3;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        int i14;
        Composer composer;
        long unbox-impl;
        androidx.compose.foundation.Indication indication;
        Object obj33;
        Alignment obj34;
        int obj35;
        Object obj36;
        Function0 obj38;
        final boolean z3 = checked;
        final Object obj9 = content;
        final int i42 = $changed;
        traceInProgress2 = 692561811;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(IconToggleButton)P(!1,6,5,3!1,4)150@7170L24,159@7503L5,160@7553L32,168@7909L175,154@7297L1028:IconButton.kt#uh7d8r");
        $dirty2 = $changed;
        if (i10 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i42 & 6 == 0) {
                i2 = restartGroup.changed(z3) ? 4 : 2;
                $dirty2 |= i2;
            }
        }
        if (i10 & 2 != 0) {
            $dirty2 |= 48;
            obj2 = onCheckedChange;
        } else {
            if (i42 & 48 == 0) {
                i9 = restartGroup.changedInstance(onCheckedChange) ? 32 : 16;
                $dirty2 |= i9;
            } else {
                obj2 = onCheckedChange;
            }
        }
        int i32 = i10 & 4;
        if (i32 != 0) {
            $dirty2 |= 384;
            obj8 = modifier;
        } else {
            if (i42 & 384 == 0) {
                i11 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i11;
            } else {
                obj8 = modifier;
            }
        }
        int i35 = i10 & 8;
        if (i35 != 0) {
            $dirty2 |= 3072;
            z = enabled;
        } else {
            if (i42 & 3072 == 0) {
                i4 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                z = enabled;
            }
        }
        if (i42 & 24576 == 0) {
            if (i10 & 16 == 0) {
                changed = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                obj6 = colors;
            }
            $dirty2 |= changed;
        } else {
            obj6 = colors;
        }
        str = i10 & 32;
        int i55 = 196608;
        if (str != null) {
            $dirty2 |= i55;
            maybeCachedBoxMeasurePolicy = interactionSource;
        } else {
            if (i55 &= i42 == 0) {
                i = restartGroup.changed(interactionSource) ? 131072 : 65536;
                $dirty2 |= i;
            } else {
                maybeCachedBoxMeasurePolicy = interactionSource;
            }
        }
        int i63 = 1572864;
        if (i10 & 64 != 0) {
            $dirty2 |= i63;
        } else {
            if (i42 & i63 == 0) {
                i13 = restartGroup.changedInstance(obj9) ? 1048576 : 524288;
                $dirty2 |= i13;
            }
        }
        if (i58 &= $dirty2 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i64 = -57345;
                int i44 = 6;
                if (i42 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i32 != 0) {
                            modifier4 = Modifier.Companion;
                        } else {
                            modifier4 = obj8;
                        }
                        enabled2 = i35 != 0 ? 1 : enabled;
                        if (i10 & 16 != 0) {
                            $dirty2 &= i64;
                            obj6 = iconToggleButtonColors;
                        }
                        if (str != null) {
                            obj7 = 0;
                            obj = modifier4;
                            modifier2 = $dirty2;
                            $dirty = obj6;
                        } else {
                            obj = modifier4;
                            obj7 = maybeCachedBoxMeasurePolicy;
                            modifier2 = $dirty2;
                            $dirty = obj6;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i10 & 16 != 0) {
                            $dirty2 &= i64;
                        }
                        modifier2 = $dirty2;
                        obj = obj8;
                        $dirty = obj6;
                        obj7 = maybeCachedBoxMeasurePolicy;
                        enabled2 = enabled;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, modifier2, -1, "androidx.compose.material3.IconToggleButton (IconButton.kt:153)");
                }
                int i67 = i65;
                Object obj10 = $dirty;
                Object colors3 = obj7;
                z = modifier2;
                Modifier toggleable-O2vRcR0 = ToggleableKt.toggleable-O2vRcR0(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(obj), IconButtonTokens.INSTANCE.getStateLayerSize-D9Ej5fM()), ShapesKt.getValue(IconButtonTokens.INSTANCE.getStateLayerShape(), restartGroup, i44)), (Color)$dirty.containerColor$material3_release(enabled2, z3, restartGroup, i17 |= i50).getValue().unbox-impl(), obj19, 0, 2), z3, colors3, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(false, Dp.constructor-impl(stateLayerSize-D9Ej5fM2 / f), 0, 0, restartGroup, 54), enabled2, Role.box-impl(Role.Companion.getCheckbox-o7Vup1c()), obj2);
                Alignment center = Alignment.Companion.getCenter();
                int i36 = 48;
                valueOf = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                i6 = 0;
                obj34 = center;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                obj35 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, toggleable-O2vRcR0);
                obj36 = toggleable-O2vRcR0;
                obj38 = constructor;
                i7 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(obj38);
                } else {
                    factory$iv$iv$iv = obj38;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i71 = 0;
                obj38 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(center, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i73 = 0;
                Composer composer5 = constructor-impl;
                int i74 = 0;
                if (!composer5.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap;
                    i14 = valueOf;
                    if (!Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(obj35))) {
                        composer5.updateRememberedValue(Integer.valueOf(obj35));
                        constructor-impl.apply(Integer.valueOf(obj35), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer5;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    i14 = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer3 = restartGroup;
                int i37 = 0;
                i8 = i22;
                ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i40 |= 6;
                Composer composer4 = composer3;
                i12 = 0;
                boxScopeInstance = iNSTANCE;
                modifier3 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer3, -131204793, "C175@8190L30,176@8235L84:IconButton.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl((Color)obj10.contentColor$material3_release(enabled2, z3, composer3, i25 |= i31).getValue().unbox-impl())), obj9, composer3, $stable |= i3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = obj33;
                obj4 = obj10;
                obj5 = obj;
                colors2 = z;
            } else {
                restartGroup.skipToGroupEnd();
                obj5 = obj8;
                enabled2 = z;
                obj4 = obj6;
                obj3 = maybeCachedBoxMeasurePolicy;
                colors2 = $dirty2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new IconButtonKt.IconToggleButton.2(z3, onCheckedChange, obj5, enabled2, obj4, obj3, obj9, i42, i10);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void OutlinedIconButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.IconButtonColors colors, BorderStroke border, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        int i9;
        int modifier2;
        int defaultsInvalid;
        boolean traceInProgress2;
        int $dirty2;
        Object $dirty;
        Object colors2;
        int i5;
        int interactionSource2;
        boolean $dirty3;
        Object colors3;
        boolean traceInProgress;
        int outlinedShape;
        int shape2;
        Object obj8;
        int i2;
        int str;
        Object obj5;
        boolean z;
        Object obj7;
        int i4;
        Object obj6;
        Object obj2;
        Object obj;
        int i7;
        int changed3;
        Object semantics$default;
        int changed;
        Object border2;
        int changed2;
        Object i13;
        Object containerColor-vNxB06k$material3_release;
        int i;
        long contentColor-vNxB06k$material3_release;
        int i3;
        int i8;
        Object obj3;
        Object obj4;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i6;
        int i12;
        int i10;
        final Object obj10 = content;
        final int i47 = $changed;
        final int i48 = i11;
        traceInProgress2 = $composer.startRestartGroup(-1746603025);
        ComposerKt.sourceInformation(traceInProgress2, "C(OutlinedIconButton)P(6,5,3,7,1!1,4)491@23280L13,492@23345L26,493@23420L33,506@23882L190,497@23556L516:IconButton.kt#uh7d8r");
        $dirty2 = $changed;
        if (i48 & 1 != 0) {
            $dirty2 |= 6;
            obj = onClick;
        } else {
            if (i47 & 6 == 0) {
                i5 = traceInProgress2.changedInstance(onClick) ? 4 : 2;
                $dirty2 |= i5;
            } else {
                obj = onClick;
            }
        }
        int i20 = i48 & 2;
        if (i20 != 0) {
            $dirty2 |= 48;
            colors3 = modifier;
        } else {
            if (i47 & 48 == 0) {
                i2 = traceInProgress2.changed(modifier) ? 32 : 16;
                $dirty2 |= i2;
            } else {
                colors3 = modifier;
            }
        }
        str = i48 & 4;
        if (str != null) {
            $dirty2 |= 384;
            z = enabled;
        } else {
            if (i47 & 384 == 0) {
                i4 = traceInProgress2.changed(enabled) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                z = enabled;
            }
        }
        if (i47 & 3072 == 0) {
            if (i48 & 8 == 0) {
                changed3 = traceInProgress2.changed(shape) ? 2048 : 1024;
            } else {
                obj6 = shape;
            }
            $dirty2 |= changed3;
        } else {
            obj6 = shape;
        }
        if (i47 & 24576 == 0) {
            if (i48 & 16 == 0) {
                changed = traceInProgress2.changed(colors) ? 16384 : 8192;
            } else {
                semantics$default = colors;
            }
            $dirty2 |= changed;
        } else {
            semantics$default = colors;
        }
        if (i51 &= i47 == 0) {
            if (i48 & 32 == 0) {
                changed2 = traceInProgress2.changed(border) ? 131072 : 65536;
            } else {
                border2 = border;
            }
            $dirty2 |= changed2;
        } else {
            border2 = border;
        }
        i13 = i48 & 64;
        int i54 = 1572864;
        if (i13 != 0) {
            $dirty2 |= i54;
            containerColor-vNxB06k$material3_release = interactionSource;
        } else {
            if (i54 &= i47 == 0) {
                i = traceInProgress2.changed(interactionSource) ? 1048576 : 524288;
                $dirty2 |= i;
            } else {
                containerColor-vNxB06k$material3_release = interactionSource;
            }
        }
        contentColor-vNxB06k$material3_release = 12582912;
        if (i48 & 128 != 0) {
            $dirty2 |= contentColor-vNxB06k$material3_release;
        } else {
            if (i47 & contentColor-vNxB06k$material3_release == 0) {
                i9 = traceInProgress2.changedInstance(obj10) ? 8388608 : 4194304;
                $dirty2 |= i9;
            }
        }
        if (i15 &= $dirty2 == 4793490) {
            if (!traceInProgress2.getSkipping()) {
                traceInProgress2.startDefaults();
                int i22 = -458753;
                int i56 = -57345;
                if (i47 & 1 != 0) {
                    if (traceInProgress2.getDefaultsInvalid()) {
                        if (i20 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = colors3;
                        }
                        if (str != null) {
                            z = colors3;
                        }
                        str = 6;
                        if (i48 & 8 != 0) {
                            $dirty2 &= -7169;
                            obj6 = outlinedShape;
                        }
                        if (i48 & 16 != 0) {
                            $dirty2 &= i56;
                            semantics$default = shape2;
                        }
                        if (i48 & 32 != 0) {
                            $dirty2 &= i22;
                            border2 = colors3;
                        }
                        if (i13 != 0) {
                            obj4 = i23;
                            i13 = obj6;
                            obj3 = border2;
                            interactionSource2 = $dirty2;
                            border2 = z;
                            $dirty = semantics$default;
                        } else {
                            interactionSource2 = $dirty2;
                            i13 = obj6;
                            $dirty = semantics$default;
                            obj3 = border2;
                            obj4 = containerColor-vNxB06k$material3_release;
                            border2 = z;
                        }
                    } else {
                        traceInProgress2.skipToGroupEnd();
                        if (i48 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (i48 & 16 != 0) {
                            $dirty2 &= i56;
                        }
                        if (i48 & 32 != 0) {
                            interactionSource2 = i19;
                            modifier2 = colors3;
                            i13 = obj6;
                            $dirty = semantics$default;
                            obj3 = border2;
                            obj4 = containerColor-vNxB06k$material3_release;
                            border2 = z;
                        } else {
                            interactionSource2 = $dirty2;
                            modifier2 = colors3;
                            i13 = obj6;
                            $dirty = semantics$default;
                            obj3 = border2;
                            obj4 = containerColor-vNxB06k$material3_release;
                            border2 = z;
                        }
                    }
                } else {
                }
                traceInProgress2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1746603025, interactionSource2, -1, "androidx.compose.material3.OutlinedIconButton (IconButton.kt:497)");
                }
                int i46 = 1;
                IconButtonKt.OutlinedIconButton.2 anon = new IconButtonKt.OutlinedIconButton.2(obj10);
                SurfaceKt.Surface-o_FOJdg(obj, SemanticsModifierKt.semantics$default(modifier2, false, (Function1)IconButtonKt.OutlinedIconButton.1.INSTANCE, i46, 0), border2, i13, $dirty.containerColor-vNxB06k$material3_release(border2), i, $dirty.contentColor-vNxB06k$material3_release(border2), obj18, 0, 0, obj3, obj4, (Function2)ComposableLambdaKt.rememberComposableLambda(582332538, i46, anon, traceInProgress2, 54), traceInProgress2, i28 | i36);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = $dirty;
                i7 = interactionSource2;
                $dirty3 = border2;
                obj8 = i13;
                obj7 = obj3;
                obj2 = obj4;
                colors2 = modifier2;
            } else {
                traceInProgress2.skipToGroupEnd();
                composer = traceInProgress2;
                i7 = $dirty2;
                colors2 = colors3;
                $dirty3 = z;
                obj8 = obj6;
                obj5 = semantics$default;
                obj7 = border2;
                obj2 = containerColor-vNxB06k$material3_release;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            modifier2 = new IconButtonKt.OutlinedIconButton.3(onClick, colors2, $dirty3, obj8, obj5, obj7, obj2, obj10, i47, i48);
            endRestartGroup.updateScope((Function2)modifier2);
        }
    }

    public static final void OutlinedIconToggleButton(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.IconToggleButtonColors colors, BorderStroke border, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i12) {
        boolean traceInProgress2;
        boolean obj9;
        int i3;
        int colors4;
        Object obj7;
        int defaultsInvalid;
        int outlinedShape;
        int shape4;
        int colors3;
        boolean z;
        Object enabled2;
        Object obj3;
        Object obj11;
        boolean shape3;
        int $dirty2;
        Object $dirty3;
        Object $dirty;
        int i5;
        Object obj2;
        Object obj12;
        int i4;
        int i;
        int i6;
        Object obj5;
        Object obj;
        boolean traceInProgress;
        Object obj6;
        int i9;
        int str;
        boolean z2;
        int i10;
        Object shape2;
        int changed2;
        Object colors2;
        int changed;
        Object obj8;
        int changed3;
        int i2;
        int i8;
        int i7;
        int modifier2;
        int modifier3;
        Object obj10;
        Object obj4;
        traceInProgress2 = checked;
        obj9 = content;
        int i28 = $changed;
        int i36 = i12;
        final Composer restartGroup = $composer.startRestartGroup(1470292106);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedIconToggleButton)P(1,7,6,4,8,2!1,5)555@26419L13,556@26490L32,557@26571L48,567@26938L32,568@27008L30,571@27123L190,561@26722L591:IconButton.kt#uh7d8r");
        $dirty2 = $changed;
        if (i36 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i28 & 6 == 0) {
                i5 = restartGroup.changed(traceInProgress2) ? 4 : 2;
                $dirty2 |= i5;
            }
        }
        if (i36 & 2 != 0) {
            $dirty2 |= 48;
            obj2 = onCheckedChange;
        } else {
            if (i28 & 48 == 0) {
                i4 = restartGroup.changedInstance(onCheckedChange) ? 32 : 16;
                $dirty2 |= i4;
            } else {
                obj2 = onCheckedChange;
            }
        }
        int i42 = i36 & 4;
        if (i42 != 0) {
            $dirty2 |= 384;
            obj = modifier;
        } else {
            if (i28 & 384 == 0) {
                i9 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i9;
            } else {
                obj = modifier;
            }
        }
        str = i36 & 8;
        if (str != null) {
            $dirty2 |= 3072;
            z2 = enabled;
        } else {
            if (i28 & 3072 == 0) {
                i10 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i10;
            } else {
                z2 = enabled;
            }
        }
        if (i28 & 24576 == 0) {
            if (i36 & 16 == 0) {
                changed2 = restartGroup.changed(shape) ? 16384 : 8192;
            } else {
                shape2 = shape;
            }
            $dirty2 |= changed2;
        } else {
            shape2 = shape;
        }
        if (i61 &= i28 == 0) {
            if (i36 & 32 == 0) {
                changed = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                colors2 = colors;
            }
            $dirty2 |= changed;
        } else {
            colors2 = colors;
        }
        if (i64 &= i28 == 0) {
            if (i36 & 64 == 0) {
                changed3 = restartGroup.changed(border) ? 1048576 : 524288;
            } else {
                obj8 = border;
            }
            $dirty2 |= changed3;
        } else {
            obj8 = border;
        }
        i2 = i36 & 128;
        i8 = 12582912;
        if (i2 != 0) {
            $dirty2 |= i8;
            obj3 = interactionSource;
        } else {
            if (i28 & i8 == 0) {
                i7 = restartGroup.changed(interactionSource) ? 8388608 : 4194304;
                $dirty2 |= i7;
            } else {
                obj3 = interactionSource;
            }
        }
        modifier2 = 100663296;
        if (i36 & 256 != 0) {
            $dirty2 |= modifier2;
        } else {
            if ($changed & modifier2 == 0) {
                i3 = restartGroup.changedInstance(obj9) ? 67108864 : 33554432;
                $dirty2 |= i3;
            }
        }
        if (i29 &= $dirty2 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i38 = -3670017;
                int i76 = -458753;
                int i77 = -57345;
                if ($changed & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i42 != 0) {
                            obj = defaultsInvalid;
                        }
                        if (str != null) {
                            z2 = defaultsInvalid;
                        }
                        i6 = 6;
                        if (i12 & 16 != 0) {
                            $dirty2 &= i77;
                            shape2 = outlinedShape;
                        }
                        if (i12 & 32 != 0) {
                            $dirty2 &= i76;
                            colors2 = shape4;
                        }
                        if (i12 & 64 != 0) {
                            $dirty2 &= i38;
                            obj8 = colors3;
                        }
                        if (i2 != 0) {
                            i = $dirty2;
                            z = z2;
                            obj11 = shape2;
                            $dirty3 = colors2;
                            shape2 = obj8;
                            colors2 = i35;
                            obj7 = obj;
                        } else {
                            i = $dirty2;
                            obj7 = obj;
                            z = z2;
                            $dirty3 = colors2;
                            colors2 = obj3;
                            obj11 = shape2;
                            shape2 = obj8;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i12 & 16 != 0) {
                            $dirty2 &= i77;
                        }
                        if (i12 & 32 != 0) {
                            $dirty2 &= i76;
                        }
                        if (i12 & 64 != 0) {
                            i = i33;
                            obj7 = obj;
                            z = z2;
                            $dirty3 = colors2;
                            colors2 = obj3;
                            obj11 = shape2;
                            shape2 = obj8;
                        } else {
                            i = $dirty2;
                            obj7 = obj;
                            z = z2;
                            $dirty3 = colors2;
                            colors2 = obj3;
                            obj11 = shape2;
                            shape2 = obj8;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1470292106, i, -1, "androidx.compose.material3.OutlinedIconToggleButton (IconButton.kt:561)");
                }
                Modifier semantics$default = SemanticsModifierKt.semantics$default(obj7, false, (Function1)IconButtonKt.OutlinedIconToggleButton.1.INSTANCE, 1, 0);
                IconButtonKt.OutlinedIconToggleButton.2 anon = new IconButtonKt.OutlinedIconToggleButton.2(obj9);
                modifier3 = i;
                SurfaceKt.Surface-d85dljk(checked, onCheckedChange, semantics$default, z, obj11, (Color)$dirty3.containerColor$material3_release(z, traceInProgress2, restartGroup, i50 |= i58).getValue().unbox-impl(), obj2, (Color)$dirty3.contentColor$material3_release(z, traceInProgress2, restartGroup, i68 |= i73).getValue().unbox-impl(), semantics$default, 0, 0, shape2, colors2, (Function2)ComposableLambdaKt.rememberComposableLambda(1207657396, true, anon, restartGroup, 54), restartGroup, i16 |= i24);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty = obj11;
                obj5 = shape2;
                obj6 = colors2;
                obj12 = obj4;
                shape3 = z;
                enabled2 = obj10;
            } else {
                restartGroup.skipToGroupEnd();
                modifier3 = $dirty2;
                enabled2 = obj;
                $dirty = shape2;
                obj12 = colors2;
                obj5 = obj8;
                obj6 = obj3;
                shape3 = z2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new IconButtonKt.OutlinedIconToggleButton.3(checked, onCheckedChange, enabled2, shape3, $dirty, obj12, obj5, obj6, content, $changed, i12);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }
}
