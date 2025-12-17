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
        int traceInProgress2;
        Object restartGroup;
        int $dirty2;
        Object $dirty;
        Object $dirty3;
        int i3;
        Object modifier3;
        boolean modifier2;
        Object obj6;
        int filledShape;
        int shape2;
        int interactionSource2;
        Object $dirty4;
        int i6;
        int i5;
        boolean traceInProgress;
        Object obj5;
        boolean str;
        Object obj2;
        Object obj4;
        int i15;
        Object obj;
        int i8;
        int changed;
        Object colors2;
        int changed2;
        Object i2;
        Object containerColor-vNxB06k$material3_release;
        int i12;
        int i13;
        int defaultsInvalid;
        int contentColor-vNxB06k$material3_release;
        int i14;
        int i;
        int i9;
        Object obj3;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i11;
        int i7;
        int i4;
        Object obj27;
        final Object obj9 = content;
        final int i34 = $changed;
        traceInProgress2 = 1594730011;
        restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(FilledIconButton)P(5,4,2,6!1,3)217@10330L11,218@10393L24,230@10821L320,222@10520L621:IconButton.kt#uh7d8r");
        $dirty2 = $changed;
        if (i10 & 1 != 0) {
            $dirty2 |= 6;
            obj4 = onClick;
        } else {
            if (i34 & 6 == 0) {
                i3 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty2 |= i3;
            } else {
                obj4 = onClick;
            }
        }
        int i20 = i10 & 2;
        if (i20 != 0) {
            $dirty2 |= 48;
            obj6 = modifier;
        } else {
            if (i34 & 48 == 0) {
                i6 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i6;
            } else {
                obj6 = modifier;
            }
        }
        i5 = i10 & 4;
        if (i5 != 0) {
            $dirty2 |= 384;
            str = enabled;
        } else {
            if (i34 & 384 == 0) {
                i15 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty2 |= i15;
            } else {
                str = enabled;
            }
        }
        if (i34 & 3072 == 0) {
            if (i10 & 8 == 0) {
                changed = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj = shape;
            }
            $dirty2 |= changed;
        } else {
            obj = shape;
        }
        if (i34 & 24576 == 0) {
            if (i10 & 16 == 0) {
                changed2 = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                colors2 = colors;
            }
            $dirty2 |= changed2;
        } else {
            colors2 = colors;
        }
        i2 = i10 & 32;
        int i40 = 196608;
        if (i2 != 0) {
            $dirty2 |= i40;
            containerColor-vNxB06k$material3_release = interactionSource;
        } else {
            if (i40 &= i34 == 0) {
                i12 = restartGroup.changed(interactionSource) ? 131072 : 65536;
                $dirty2 |= i12;
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
                            modifier3 = obj6;
                        }
                        if (i5 != 0) {
                            str = obj6;
                        }
                        i5 = 6;
                        if (i10 & 8 != 0) {
                            $dirty2 &= -7169;
                            obj = filledShape;
                        }
                        if (i10 & 16 != 0) {
                            $dirty2 &= i44;
                            colors2 = shape2;
                        }
                        if (i2 != 0) {
                            obj3 = i24;
                            i2 = obj;
                            interactionSource2 = $dirty2;
                            $dirty = colors2;
                            colors2 = str;
                        } else {
                            interactionSource2 = $dirty2;
                            i2 = obj;
                            $dirty = colors2;
                            obj3 = containerColor-vNxB06k$material3_release;
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
                        modifier3 = obj6;
                        i2 = obj;
                        obj3 = containerColor-vNxB06k$material3_release;
                        interactionSource2 = $dirty2;
                        $dirty = colors2;
                        colors2 = str;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, interactionSource2, -1, "androidx.compose.material3.FilledIconButton (IconButton.kt:222)");
                }
                int i37 = 1;
                IconButtonKt.FilledIconButton.2 anon = new IconButtonKt.FilledIconButton.2(obj9);
                SurfaceKt.Surface-o_FOJdg(obj4, SemanticsModifierKt.semantics$default(modifier3, false, (Function1)IconButtonKt.FilledIconButton.1.INSTANCE, i37, 0), colors2, i2, $dirty.containerColor-vNxB06k$material3_release(colors2), defaultsInvalid, $dirty.contentColor-vNxB06k$material3_release(colors2), obj16, 0, 0, 0, obj3, (Function2)ComposableLambdaKt.rememberComposableLambda(-1560623888, i37, anon, restartGroup, 54), restartGroup, i19 | i29);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = $dirty;
                $dirty3 = modifier3;
                i8 = interactionSource2;
                modifier2 = colors2;
                $dirty4 = i2;
                obj2 = obj3;
            } else {
                restartGroup.skipToGroupEnd();
                i8 = $dirty2;
                $dirty3 = obj6;
                $dirty4 = obj8;
                composer = restartGroup;
                modifier2 = str;
                obj5 = colors2;
                obj2 = containerColor-vNxB06k$material3_release;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new IconButtonKt.FilledIconButton.3(onClick, $dirty3, modifier2, $dirty4, obj5, obj2, obj9, i34, i10);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void FilledIconToggleButton(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.IconToggleButtonColors colors, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        boolean traceInProgress;
        boolean obj9;
        int modifier2;
        int defaultsInvalid;
        int filledShape;
        int shape2;
        Object obj5;
        boolean z;
        Object enabled2;
        int i8;
        Object obj7;
        boolean shape3;
        int $dirty2;
        Object $dirty3;
        Object $dirty;
        int i6;
        Object obj;
        Object obj8;
        int i5;
        int i7;
        Object obj2;
        Object semantics$default;
        boolean traceInProgress2;
        int i;
        int str;
        boolean colors4;
        int i4;
        Object colors5;
        int changed2;
        Object colors3;
        int changed;
        androidx.compose.runtime.internal.ComposableLambda i2;
        Object obj6;
        int i3;
        int colors6;
        int colors2;
        Object obj4;
        Object obj3;
        long l;
        traceInProgress = checked;
        obj9 = content;
        int i23 = $changed;
        int i28 = i11;
        final Composer restartGroup = $composer.startRestartGroup(-1708189280);
        ComposerKt.sourceInformation(restartGroup, "C(FilledIconToggleButton)P(!1,6,5,3,7!1,4)349@16472L11,350@16541L30,360@16890L32,361@16960L30,363@17050L320,354@16674L696:IconButton.kt#uh7d8r");
        $dirty2 = $changed;
        if (i28 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i23 & 6 == 0) {
                i6 = restartGroup.changed(traceInProgress) ? 4 : 2;
                $dirty2 |= i6;
            }
        }
        if (i28 & 2 != 0) {
            $dirty2 |= 48;
            obj = onCheckedChange;
        } else {
            if (i23 & 48 == 0) {
                i5 = restartGroup.changedInstance(onCheckedChange) ? 32 : 16;
                $dirty2 |= i5;
            } else {
                obj = onCheckedChange;
            }
        }
        int i35 = i28 & 4;
        if (i35 != 0) {
            $dirty2 |= 384;
            semantics$default = modifier;
        } else {
            if (i23 & 384 == 0) {
                i = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i;
            } else {
                semantics$default = modifier;
            }
        }
        str = i28 & 8;
        if (str != null) {
            $dirty2 |= 3072;
            colors4 = enabled;
        } else {
            if (i23 & 3072 == 0) {
                i4 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                colors4 = enabled;
            }
        }
        if (i23 & 24576 == 0) {
            if (i28 & 16 == 0) {
                changed2 = restartGroup.changed(shape) ? 16384 : 8192;
            } else {
                colors5 = shape;
            }
            $dirty2 |= changed2;
        } else {
            colors5 = shape;
        }
        if (i52 &= i23 == 0) {
            if (i28 & 32 == 0) {
                changed = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                colors3 = colors;
            }
            $dirty2 |= changed;
        } else {
            colors3 = colors;
        }
        i2 = i28 & 64;
        int i59 = 1572864;
        if (i2 != 0) {
            $dirty2 |= i59;
            obj6 = interactionSource;
        } else {
            if (i59 &= i23 == 0) {
                i3 = restartGroup.changed(interactionSource) ? 1048576 : 524288;
                $dirty2 |= i3;
            } else {
                obj6 = interactionSource;
            }
        }
        colors6 = 12582912;
        if (i28 & 128 != 0) {
            $dirty2 |= colors6;
        } else {
            if (i23 & colors6 == 0) {
                i8 = restartGroup.changedInstance(obj9) ? 8388608 : 4194304;
                $dirty2 |= i8;
            }
        }
        if (i30 &= $dirty2 == 4793490) {
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
                            colors4 = defaultsInvalid;
                        }
                        int i36 = 6;
                        if (i28 & 16 != 0) {
                            $dirty2 &= i65;
                            colors5 = filledShape;
                        }
                        if (i28 & 32 != 0) {
                            $dirty2 &= i32;
                            colors3 = shape2;
                        }
                        if (i2 != 0) {
                            i7 = $dirty2;
                            z = colors4;
                            obj7 = colors5;
                            $dirty3 = colors3;
                            colors3 = i24;
                            obj5 = semantics$default;
                        } else {
                            i7 = $dirty2;
                            obj5 = semantics$default;
                            z = colors4;
                            obj7 = colors5;
                            $dirty3 = colors3;
                            colors3 = obj6;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i28 & 16 != 0) {
                            $dirty2 &= i65;
                        }
                        if (i28 & 32 != 0) {
                            i7 = i27;
                            obj5 = semantics$default;
                            z = colors4;
                            obj7 = colors5;
                            $dirty3 = colors3;
                            colors3 = obj6;
                        } else {
                            i7 = $dirty2;
                            obj5 = semantics$default;
                            z = colors4;
                            obj7 = colors5;
                            $dirty3 = colors3;
                            colors3 = obj6;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1708189280, i7, -1, "androidx.compose.material3.FilledIconToggleButton (IconButton.kt:354)");
                }
                int i50 = 1;
                semantics$default = SemanticsModifierKt.semantics$default(obj5, false, (Function1)IconButtonKt.FilledIconToggleButton.1.INSTANCE, i50, 0);
                IconButtonKt.FilledIconToggleButton.2 anon = new IconButtonKt.FilledIconToggleButton.2(obj9);
                colors2 = i7;
                SurfaceKt.Surface-d85dljk(checked, onCheckedChange, semantics$default, z, obj7, (Color)$dirty3.containerColor$material3_release(z, traceInProgress, restartGroup, i41 |= i48).getValue().unbox-impl(), obj, (Color)$dirty3.contentColor$material3_release(z, traceInProgress, restartGroup, i57 |= i64).getValue().unbox-impl(), semantics$default, 0, 0, 0, colors3, (Function2)ComposableLambdaKt.rememberComposableLambda(1235871670, i50, anon, restartGroup, 54), restartGroup, i13 |= i19);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty = obj7;
                obj2 = colors3;
                obj8 = obj3;
                shape3 = z;
                enabled2 = obj4;
            } else {
                restartGroup.skipToGroupEnd();
                colors2 = $dirty2;
                enabled2 = semantics$default;
                shape3 = colors4;
                $dirty = colors5;
                obj8 = colors3;
                obj2 = obj6;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new IconButtonKt.FilledIconToggleButton.3(checked, onCheckedChange, enabled2, shape3, $dirty, obj8, obj2, content, $changed, i11);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void FilledTonalIconButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.IconButtonColors colors, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int traceInProgress;
        Object restartGroup;
        int $dirty3;
        Object $dirty4;
        Object $dirty;
        int i3;
        Object modifier3;
        boolean modifier2;
        Object obj4;
        int filledShape;
        int shape2;
        int interactionSource2;
        Object $dirty2;
        int i15;
        int i8;
        boolean traceInProgress2;
        Object obj2;
        boolean str;
        Object obj;
        Object obj3;
        int i4;
        Object obj6;
        int i9;
        int changed2;
        Object colors2;
        int changed;
        Object i11;
        Object containerColor-vNxB06k$material3_release;
        int i;
        int i12;
        int defaultsInvalid;
        int contentColor-vNxB06k$material3_release;
        int i6;
        int i14;
        int i13;
        Object obj5;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i5;
        int i7;
        int i2;
        Object obj27;
        final Object obj9 = content;
        final int i34 = $changed;
        traceInProgress = -783937767;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(FilledTonalIconButton)P(5,4,2,6!1,3)284@13478L11,285@13541L29,297@13974L330,289@13673L631:IconButton.kt#uh7d8r");
        $dirty3 = $changed;
        if (i10 & 1 != 0) {
            $dirty3 |= 6;
            obj3 = onClick;
        } else {
            if (i34 & 6 == 0) {
                i3 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty3 |= i3;
            } else {
                obj3 = onClick;
            }
        }
        int i20 = i10 & 2;
        if (i20 != 0) {
            $dirty3 |= 48;
            obj4 = modifier;
        } else {
            if (i34 & 48 == 0) {
                i15 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i15;
            } else {
                obj4 = modifier;
            }
        }
        i8 = i10 & 4;
        if (i8 != 0) {
            $dirty3 |= 384;
            str = enabled;
        } else {
            if (i34 & 384 == 0) {
                i4 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty3 |= i4;
            } else {
                str = enabled;
            }
        }
        if (i34 & 3072 == 0) {
            if (i10 & 8 == 0) {
                changed2 = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj6 = shape;
            }
            $dirty3 |= changed2;
        } else {
            obj6 = shape;
        }
        if (i34 & 24576 == 0) {
            if (i10 & 16 == 0) {
                changed = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                colors2 = colors;
            }
            $dirty3 |= changed;
        } else {
            colors2 = colors;
        }
        i11 = i10 & 32;
        int i40 = 196608;
        if (i11 != 0) {
            $dirty3 |= i40;
            containerColor-vNxB06k$material3_release = interactionSource;
        } else {
            if (i40 &= i34 == 0) {
                i = restartGroup.changed(interactionSource) ? 131072 : 65536;
                $dirty3 |= i;
            } else {
                containerColor-vNxB06k$material3_release = interactionSource;
            }
        }
        int i43 = 1572864;
        if (i10 & 64 != 0) {
            $dirty3 |= i43;
        } else {
            if (i34 & i43 == 0) {
                i12 = restartGroup.changedInstance(obj9) ? 1048576 : 524288;
                $dirty3 |= i12;
            }
        }
        if (i42 &= $dirty3 == 599186) {
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
                        if (i8 != 0) {
                            str = obj4;
                        }
                        i8 = 6;
                        if (i10 & 8 != 0) {
                            $dirty3 &= -7169;
                            obj6 = filledShape;
                        }
                        if (i10 & 16 != 0) {
                            $dirty3 &= i44;
                            colors2 = shape2;
                        }
                        if (i11 != 0) {
                            obj5 = i24;
                            i11 = obj6;
                            interactionSource2 = $dirty3;
                            $dirty4 = colors2;
                            colors2 = str;
                        } else {
                            interactionSource2 = $dirty3;
                            i11 = obj6;
                            $dirty4 = colors2;
                            obj5 = containerColor-vNxB06k$material3_release;
                            colors2 = str;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i10 & 8 != 0) {
                            $dirty3 &= -7169;
                        }
                        if (i10 & 16 != 0) {
                            $dirty3 &= i44;
                        }
                        modifier3 = obj4;
                        i11 = obj6;
                        obj5 = containerColor-vNxB06k$material3_release;
                        interactionSource2 = $dirty3;
                        $dirty4 = colors2;
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
                SurfaceKt.Surface-o_FOJdg(obj3, SemanticsModifierKt.semantics$default(modifier3, false, (Function1)IconButtonKt.FilledTonalIconButton.1.INSTANCE, i37, 0), colors2, i11, $dirty4.containerColor-vNxB06k$material3_release(colors2), defaultsInvalid, $dirty4.contentColor-vNxB06k$material3_release(colors2), obj16, 0, 0, 0, obj5, (Function2)ComposableLambdaKt.rememberComposableLambda(-1772884636, i37, anon, restartGroup, 54), restartGroup, i19 | i29);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = $dirty4;
                $dirty = modifier3;
                i9 = interactionSource2;
                modifier2 = colors2;
                $dirty2 = i11;
                obj = obj5;
            } else {
                restartGroup.skipToGroupEnd();
                i9 = $dirty3;
                $dirty = obj4;
                $dirty2 = obj8;
                composer = restartGroup;
                modifier2 = str;
                obj2 = colors2;
                obj = containerColor-vNxB06k$material3_release;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new IconButtonKt.FilledTonalIconButton.3(onClick, $dirty, modifier2, $dirty2, obj2, obj, obj9, i34, i10);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void FilledTonalIconToggleButton(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.IconToggleButtonColors colors, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        boolean traceInProgress;
        boolean obj8;
        int modifier2;
        int defaultsInvalid;
        int filledShape;
        int shape2;
        Object obj6;
        boolean z;
        Object enabled2;
        int i;
        Object obj2;
        boolean shape3;
        int $dirty2;
        Object $dirty3;
        Object $dirty;
        int i2;
        Object obj3;
        Object obj7;
        int i3;
        int i7;
        Object obj5;
        Object semantics$default;
        boolean traceInProgress2;
        int i5;
        int str;
        boolean colors5;
        int i4;
        Object colors4;
        int changed;
        Object colors6;
        int changed2;
        androidx.compose.runtime.internal.ComposableLambda i6;
        Object obj;
        int i8;
        int colors3;
        int colors2;
        Object obj9;
        Object obj4;
        long l;
        traceInProgress = checked;
        obj8 = content;
        int i23 = $changed;
        int i28 = i11;
        final Composer restartGroup = $composer.startRestartGroup(1676089246);
        ComposerKt.sourceInformation(restartGroup, "C(FilledTonalIconToggleButton)P(!1,6,5,3,7!1,4)420@19894L11,421@19963L35,431@20317L32,432@20387L30,434@20477L330,425@20101L706:IconButton.kt#uh7d8r");
        $dirty2 = $changed;
        if (i28 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i23 & 6 == 0) {
                i2 = restartGroup.changed(traceInProgress) ? 4 : 2;
                $dirty2 |= i2;
            }
        }
        if (i28 & 2 != 0) {
            $dirty2 |= 48;
            obj3 = onCheckedChange;
        } else {
            if (i23 & 48 == 0) {
                i3 = restartGroup.changedInstance(onCheckedChange) ? 32 : 16;
                $dirty2 |= i3;
            } else {
                obj3 = onCheckedChange;
            }
        }
        int i35 = i28 & 4;
        if (i35 != 0) {
            $dirty2 |= 384;
            semantics$default = modifier;
        } else {
            if (i23 & 384 == 0) {
                i5 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i5;
            } else {
                semantics$default = modifier;
            }
        }
        str = i28 & 8;
        if (str != null) {
            $dirty2 |= 3072;
            colors5 = enabled;
        } else {
            if (i23 & 3072 == 0) {
                i4 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                colors5 = enabled;
            }
        }
        if (i23 & 24576 == 0) {
            if (i28 & 16 == 0) {
                changed = restartGroup.changed(shape) ? 16384 : 8192;
            } else {
                colors4 = shape;
            }
            $dirty2 |= changed;
        } else {
            colors4 = shape;
        }
        if (i52 &= i23 == 0) {
            if (i28 & 32 == 0) {
                changed2 = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                colors6 = colors;
            }
            $dirty2 |= changed2;
        } else {
            colors6 = colors;
        }
        i6 = i28 & 64;
        int i59 = 1572864;
        if (i6 != 0) {
            $dirty2 |= i59;
            obj = interactionSource;
        } else {
            if (i59 &= i23 == 0) {
                i8 = restartGroup.changed(interactionSource) ? 1048576 : 524288;
                $dirty2 |= i8;
            } else {
                obj = interactionSource;
            }
        }
        colors3 = 12582912;
        if (i28 & 128 != 0) {
            $dirty2 |= colors3;
        } else {
            if (i23 & colors3 == 0) {
                i = restartGroup.changedInstance(obj8) ? 8388608 : 4194304;
                $dirty2 |= i;
            }
        }
        if (i30 &= $dirty2 == 4793490) {
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
                            colors5 = defaultsInvalid;
                        }
                        int i36 = 6;
                        if (i28 & 16 != 0) {
                            $dirty2 &= i65;
                            colors4 = filledShape;
                        }
                        if (i28 & 32 != 0) {
                            $dirty2 &= i32;
                            colors6 = shape2;
                        }
                        if (i6 != 0) {
                            i7 = $dirty2;
                            z = colors5;
                            obj2 = colors4;
                            $dirty3 = colors6;
                            colors6 = i24;
                            obj6 = semantics$default;
                        } else {
                            i7 = $dirty2;
                            obj6 = semantics$default;
                            z = colors5;
                            obj2 = colors4;
                            $dirty3 = colors6;
                            colors6 = obj;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i28 & 16 != 0) {
                            $dirty2 &= i65;
                        }
                        if (i28 & 32 != 0) {
                            i7 = i27;
                            obj6 = semantics$default;
                            z = colors5;
                            obj2 = colors4;
                            $dirty3 = colors6;
                            colors6 = obj;
                        } else {
                            i7 = $dirty2;
                            obj6 = semantics$default;
                            z = colors5;
                            obj2 = colors4;
                            $dirty3 = colors6;
                            colors6 = obj;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1676089246, i7, -1, "androidx.compose.material3.FilledTonalIconToggleButton (IconButton.kt:425)");
                }
                int i50 = 1;
                semantics$default = SemanticsModifierKt.semantics$default(obj6, false, (Function1)IconButtonKt.FilledTonalIconToggleButton.1.INSTANCE, i50, 0);
                IconButtonKt.FilledTonalIconToggleButton.2 anon = new IconButtonKt.FilledTonalIconToggleButton.2(obj8);
                colors2 = i7;
                SurfaceKt.Surface-d85dljk(checked, onCheckedChange, semantics$default, z, obj2, (Color)$dirty3.containerColor$material3_release(z, traceInProgress, restartGroup, i41 |= i48).getValue().unbox-impl(), obj3, (Color)$dirty3.contentColor$material3_release(z, traceInProgress, restartGroup, i57 |= i64).getValue().unbox-impl(), semantics$default, 0, 0, 0, colors6, (Function2)ComposableLambdaKt.rememberComposableLambda(-58218680, i50, anon, restartGroup, 54), restartGroup, i13 |= i19);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty = obj2;
                obj5 = colors6;
                obj7 = obj4;
                shape3 = z;
                enabled2 = obj9;
            } else {
                restartGroup.skipToGroupEnd();
                colors2 = $dirty2;
                enabled2 = semantics$default;
                shape3 = colors5;
                $dirty = colors4;
                obj7 = colors6;
                obj5 = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new IconButtonKt.FilledTonalIconToggleButton.3(checked, onCheckedChange, enabled2, shape3, $dirty, obj7, obj5, content, $changed, i11);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void IconButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, androidx.compose.material3.IconButtonColors colors, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        int traceInProgress;
        int $dirty;
        boolean $dirty2;
        Function0 factory$iv$iv$iv;
        Object obj3;
        Object obj4;
        boolean currentCompositionLocalMap;
        int i7;
        boolean z2;
        Object modifier2;
        Object obj6;
        Object obj5;
        int iconButtonColors;
        int i10;
        Object obj2;
        Object obj7;
        Composer composer2;
        Integer valueOf;
        boolean z;
        int enabled2;
        int i12;
        Object obj;
        boolean traceInProgress2;
        int changed;
        int str;
        Object maybeCachedBoxMeasurePolicy;
        int i14;
        int i6;
        boolean skipping;
        boolean defaultsInvalid;
        int i13;
        int i8;
        int i15;
        int i;
        long l;
        int i4;
        BoxScopeInstance boxScopeInstance;
        Function0 function0;
        int i5;
        int i11;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        int i2;
        Composer composer;
        long l2;
        int i3;
        Object obj31;
        Alignment obj32;
        int obj33;
        Object obj34;
        Modifier obj36;
        final Object obj8 = content;
        final int i35 = $changed;
        traceInProgress = -1142896114;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(IconButton)P(5,4,2!1,3)85@4039L18,94@4366L5,102@4703L175,89@4160L944:IconButton.kt#uh7d8r");
        $dirty = $changed;
        if (i9 & 1 != 0) {
            $dirty |= 6;
            obj3 = onClick;
        } else {
            if (i35 & 6 == 0) {
                i7 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty |= i7;
            } else {
                obj3 = onClick;
            }
        }
        int i25 = i9 & 2;
        if (i25 != 0) {
            $dirty |= 48;
            obj6 = modifier;
        } else {
            if (i35 & 48 == 0) {
                i10 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i10;
            } else {
                obj6 = modifier;
            }
        }
        int i30 = i9 & 4;
        if (i30 != 0) {
            $dirty |= 384;
            z = enabled;
        } else {
            if (i35 & 384 == 0) {
                i12 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty |= i12;
            } else {
                z = enabled;
            }
        }
        if (i35 & 3072 == 0) {
            if (i9 & 8 == 0) {
                changed = restartGroup.changed(colors) ? 2048 : 1024;
            } else {
                obj = colors;
            }
            $dirty |= changed;
        } else {
            obj = colors;
        }
        str = i9 & 16;
        if (str != null) {
            $dirty |= 24576;
            maybeCachedBoxMeasurePolicy = interactionSource;
        } else {
            if (i35 & 24576 == 0) {
                i14 = restartGroup.changed(interactionSource) ? 16384 : 8192;
                $dirty |= i14;
            } else {
                maybeCachedBoxMeasurePolicy = interactionSource;
            }
        }
        int i47 = 196608;
        if (i9 & 32 != 0) {
            $dirty |= i47;
        } else {
            if (i35 & i47 == 0) {
                i6 = restartGroup.changedInstance(obj8) ? 131072 : 65536;
                $dirty |= i6;
            }
        }
        if (i43 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i49 = 6;
                if (i35 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i25 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj6;
                        }
                        if (i30 != 0) {
                            z = obj6;
                        }
                        if (i9 & 8 != 0) {
                            $dirty &= -7169;
                            obj = iconButtonColors;
                        }
                        if (str != null) {
                            enabled2 = $dirty;
                            $dirty2 = z5;
                            obj7 = i29;
                            obj5 = obj;
                        } else {
                            enabled2 = $dirty;
                            $dirty2 = interactionSource2;
                            obj5 = obj;
                            obj7 = maybeCachedBoxMeasurePolicy;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i9 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        enabled2 = $dirty;
                        $dirty2 = z4;
                        modifier2 = obj6;
                        obj5 = obj;
                        obj7 = maybeCachedBoxMeasurePolicy;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, enabled2, -1, "androidx.compose.material3.IconButton (IconButton.kt:88)");
                }
                int i57 = 0;
                boolean z6 = $dirty2;
                i13 = obj7;
                Modifier clickable-O2vRcR0$default = ClickableKt.clickable-O2vRcR0$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2), IconButtonTokens.INSTANCE.getStateLayerSize-D9Ej5fM()), ShapesKt.getValue(IconButtonTokens.INSTANCE.getStateLayerShape(), restartGroup, i49)), obj5.containerColor-vNxB06k$material3_release($dirty2), obj18, 0, 2), i13, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(false, Dp.constructor-impl(stateLayerSize-D9Ej5fM2 / f), 0, 0, restartGroup, 54), z6, 0, Role.box-impl(Role.Companion.getButton-o7Vup1c()), obj3, 8, i57);
                z = z6;
                Alignment center = Alignment.Companion.getCenter();
                valueOf = 48;
                obj = 0;
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
                i15 = 0;
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
                    i2 = valueOf;
                    if (!Intrinsics.areEqual(obj36.rememberedValue(), Integer.valueOf(obj33))) {
                        obj36.updateRememberedValue(Integer.valueOf(obj33));
                        constructor-impl.apply(Integer.valueOf(obj33), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = obj36;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    i2 = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer3 = restartGroup;
                int i26 = 0;
                obj36 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i33 |= 6;
                obj31 = composer3;
                i4 = 0;
                boxScopeInstance = iNSTANCE;
                i11 = i22;
                ComposerKt.sourceInformationMarkerStart(composer3, 782643754, "C110@5014L84:IconButton.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(obj5.contentColor-vNxB06k$material3_release(z))), obj8, composer3, $stable |= i3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = i13;
                obj4 = l;
                z2 = z;
            } else {
                restartGroup.skipToGroupEnd();
                i5 = $dirty;
                obj4 = obj6;
                obj5 = obj;
                obj2 = maybeCachedBoxMeasurePolicy;
                z2 = z;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new IconButtonKt.IconButton.2(onClick, obj4, z2, obj5, obj2, obj8, i35, i9);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void IconToggleButton(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, androidx.compose.material3.IconToggleButtonColors colors, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int traceInProgress2;
        Function0 factory$iv$iv$iv;
        int $dirty2;
        Object $dirty;
        int i5;
        int i14;
        Object obj6;
        int modifier4;
        Integer currentCompositionLocalMap;
        Object modifier2;
        Object obj7;
        boolean enabled2;
        int i9;
        Object obj5;
        Object obj3;
        int iconToggleButtonColors;
        Object obj4;
        Object obj;
        Composer composer2;
        int valueOf;
        boolean z;
        int i3;
        Object obj2;
        int colors2;
        boolean traceInProgress;
        int changed;
        int str;
        Object maybeCachedBoxMeasurePolicy;
        int i4;
        int i11;
        boolean skipping;
        boolean defaultsInvalid;
        int i2;
        Object obj8;
        int i8;
        int i13;
        long l;
        int i6;
        int i12;
        int i7;
        BoxScopeInstance boxScopeInstance;
        Modifier modifier3;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        int i;
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
                i5 = restartGroup.changed(z3) ? 4 : 2;
                $dirty2 |= i5;
            }
        }
        if (i10 & 2 != 0) {
            $dirty2 |= 48;
            obj4 = onCheckedChange;
        } else {
            if (i42 & 48 == 0) {
                i14 = restartGroup.changedInstance(onCheckedChange) ? 32 : 16;
                $dirty2 |= i14;
            } else {
                obj4 = onCheckedChange;
            }
        }
        int i32 = i10 & 4;
        if (i32 != 0) {
            $dirty2 |= 384;
            obj7 = modifier;
        } else {
            if (i42 & 384 == 0) {
                i9 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i9;
            } else {
                obj7 = modifier;
            }
        }
        int i35 = i10 & 8;
        if (i35 != 0) {
            $dirty2 |= 3072;
            z = enabled;
        } else {
            if (i42 & 3072 == 0) {
                i3 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i3;
            } else {
                z = enabled;
            }
        }
        if (i42 & 24576 == 0) {
            if (i10 & 16 == 0) {
                changed = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                obj2 = colors;
            }
            $dirty2 |= changed;
        } else {
            obj2 = colors;
        }
        str = i10 & 32;
        int i55 = 196608;
        if (str != null) {
            $dirty2 |= i55;
            maybeCachedBoxMeasurePolicy = interactionSource;
        } else {
            if (i55 &= i42 == 0) {
                i4 = restartGroup.changed(interactionSource) ? 131072 : 65536;
                $dirty2 |= i4;
            } else {
                maybeCachedBoxMeasurePolicy = interactionSource;
            }
        }
        int i63 = 1572864;
        if (i10 & 64 != 0) {
            $dirty2 |= i63;
        } else {
            if (i42 & i63 == 0) {
                i11 = restartGroup.changedInstance(obj9) ? 1048576 : 524288;
                $dirty2 |= i11;
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
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj7;
                        }
                        enabled2 = i35 != 0 ? 1 : enabled;
                        if (i10 & 16 != 0) {
                            $dirty2 &= i64;
                            obj2 = iconToggleButtonColors;
                        }
                        if (str != null) {
                            obj3 = 0;
                            obj8 = modifier2;
                            modifier4 = $dirty2;
                            $dirty = obj2;
                        } else {
                            obj8 = modifier2;
                            obj3 = maybeCachedBoxMeasurePolicy;
                            modifier4 = $dirty2;
                            $dirty = obj2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i10 & 16 != 0) {
                            $dirty2 &= i64;
                        }
                        modifier4 = $dirty2;
                        obj8 = obj7;
                        $dirty = obj2;
                        obj3 = maybeCachedBoxMeasurePolicy;
                        enabled2 = enabled;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, modifier4, -1, "androidx.compose.material3.IconToggleButton (IconButton.kt:153)");
                }
                int i67 = i65;
                Object obj10 = $dirty;
                Object colors3 = obj3;
                z = modifier4;
                Modifier toggleable-O2vRcR0 = ToggleableKt.toggleable-O2vRcR0(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(obj8), IconButtonTokens.INSTANCE.getStateLayerSize-D9Ej5fM()), ShapesKt.getValue(IconButtonTokens.INSTANCE.getStateLayerShape(), restartGroup, i44)), (Color)$dirty.containerColor$material3_release(enabled2, z3, restartGroup, i17 |= i50).getValue().unbox-impl(), obj19, 0, 2), z3, colors3, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(false, Dp.constructor-impl(stateLayerSize-D9Ej5fM2 / f), 0, 0, restartGroup, 54), enabled2, Role.box-impl(Role.Companion.getCheckbox-o7Vup1c()), obj4);
                Alignment center = Alignment.Companion.getCenter();
                int i36 = 48;
                valueOf = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                i2 = 0;
                obj34 = center;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                obj35 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, toggleable-O2vRcR0);
                obj36 = toggleable-O2vRcR0;
                obj38 = constructor;
                i8 = 0;
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
                    i = valueOf;
                    if (!Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(obj35))) {
                        composer5.updateRememberedValue(Integer.valueOf(obj35));
                        constructor-impl.apply(Integer.valueOf(obj35), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer5;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    i = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer3 = restartGroup;
                int i37 = 0;
                i12 = i22;
                ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i40 |= 6;
                Composer composer4 = composer3;
                i7 = 0;
                boxScopeInstance = iNSTANCE;
                modifier3 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer3, -131204793, "C175@8190L30,176@8235L84:IconButton.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl((Color)obj10.contentColor$material3_release(enabled2, z3, composer3, i25 |= i31).getValue().unbox-impl())), obj9, composer3, $stable |= i13);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj33;
                obj5 = obj10;
                obj6 = obj8;
                colors2 = z;
            } else {
                restartGroup.skipToGroupEnd();
                obj6 = obj7;
                enabled2 = z;
                obj5 = obj2;
                obj = maybeCachedBoxMeasurePolicy;
                colors2 = $dirty2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new IconButtonKt.IconToggleButton.2(z3, onCheckedChange, obj6, enabled2, obj5, obj, obj9, i42, i10);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void OutlinedIconButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.IconButtonColors colors, BorderStroke border, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        int i7;
        int modifier2;
        int defaultsInvalid;
        boolean traceInProgress2;
        int $dirty3;
        Object $dirty2;
        Object colors3;
        int i4;
        int interactionSource2;
        boolean $dirty;
        Object colors2;
        boolean traceInProgress;
        int outlinedShape;
        int shape2;
        Object obj6;
        int i3;
        int str;
        Object obj2;
        boolean z;
        Object obj5;
        int i13;
        Object obj7;
        Object obj;
        Object obj8;
        int i12;
        int changed2;
        Object semantics$default;
        int changed3;
        Object border2;
        int changed;
        Object i5;
        Object containerColor-vNxB06k$material3_release;
        int i6;
        long contentColor-vNxB06k$material3_release;
        int i;
        int i2;
        Object obj4;
        Object obj3;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i9;
        int i8;
        int i10;
        final Object obj10 = content;
        final int i47 = $changed;
        final int i48 = i11;
        traceInProgress2 = $composer.startRestartGroup(-1746603025);
        ComposerKt.sourceInformation(traceInProgress2, "C(OutlinedIconButton)P(6,5,3,7,1!1,4)491@23280L13,492@23345L26,493@23420L33,506@23882L190,497@23556L516:IconButton.kt#uh7d8r");
        $dirty3 = $changed;
        if (i48 & 1 != 0) {
            $dirty3 |= 6;
            obj8 = onClick;
        } else {
            if (i47 & 6 == 0) {
                i4 = traceInProgress2.changedInstance(onClick) ? 4 : 2;
                $dirty3 |= i4;
            } else {
                obj8 = onClick;
            }
        }
        int i20 = i48 & 2;
        if (i20 != 0) {
            $dirty3 |= 48;
            colors2 = modifier;
        } else {
            if (i47 & 48 == 0) {
                i3 = traceInProgress2.changed(modifier) ? 32 : 16;
                $dirty3 |= i3;
            } else {
                colors2 = modifier;
            }
        }
        str = i48 & 4;
        if (str != null) {
            $dirty3 |= 384;
            z = enabled;
        } else {
            if (i47 & 384 == 0) {
                i13 = traceInProgress2.changed(enabled) ? 256 : 128;
                $dirty3 |= i13;
            } else {
                z = enabled;
            }
        }
        if (i47 & 3072 == 0) {
            if (i48 & 8 == 0) {
                changed2 = traceInProgress2.changed(shape) ? 2048 : 1024;
            } else {
                obj7 = shape;
            }
            $dirty3 |= changed2;
        } else {
            obj7 = shape;
        }
        if (i47 & 24576 == 0) {
            if (i48 & 16 == 0) {
                changed3 = traceInProgress2.changed(colors) ? 16384 : 8192;
            } else {
                semantics$default = colors;
            }
            $dirty3 |= changed3;
        } else {
            semantics$default = colors;
        }
        if (i51 &= i47 == 0) {
            if (i48 & 32 == 0) {
                changed = traceInProgress2.changed(border) ? 131072 : 65536;
            } else {
                border2 = border;
            }
            $dirty3 |= changed;
        } else {
            border2 = border;
        }
        i5 = i48 & 64;
        int i54 = 1572864;
        if (i5 != 0) {
            $dirty3 |= i54;
            containerColor-vNxB06k$material3_release = interactionSource;
        } else {
            if (i54 &= i47 == 0) {
                i6 = traceInProgress2.changed(interactionSource) ? 1048576 : 524288;
                $dirty3 |= i6;
            } else {
                containerColor-vNxB06k$material3_release = interactionSource;
            }
        }
        contentColor-vNxB06k$material3_release = 12582912;
        if (i48 & 128 != 0) {
            $dirty3 |= contentColor-vNxB06k$material3_release;
        } else {
            if (i47 & contentColor-vNxB06k$material3_release == 0) {
                i7 = traceInProgress2.changedInstance(obj10) ? 8388608 : 4194304;
                $dirty3 |= i7;
            }
        }
        if (i15 &= $dirty3 == 4793490) {
            if (!traceInProgress2.getSkipping()) {
                traceInProgress2.startDefaults();
                int i22 = -458753;
                int i56 = -57345;
                if (i47 & 1 != 0) {
                    if (traceInProgress2.getDefaultsInvalid()) {
                        if (i20 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = colors2;
                        }
                        if (str != null) {
                            z = colors2;
                        }
                        str = 6;
                        if (i48 & 8 != 0) {
                            $dirty3 &= -7169;
                            obj7 = outlinedShape;
                        }
                        if (i48 & 16 != 0) {
                            $dirty3 &= i56;
                            semantics$default = shape2;
                        }
                        if (i48 & 32 != 0) {
                            $dirty3 &= i22;
                            border2 = colors2;
                        }
                        if (i5 != 0) {
                            obj3 = i23;
                            i5 = obj7;
                            obj4 = border2;
                            interactionSource2 = $dirty3;
                            border2 = z;
                            $dirty2 = semantics$default;
                        } else {
                            interactionSource2 = $dirty3;
                            i5 = obj7;
                            $dirty2 = semantics$default;
                            obj4 = border2;
                            obj3 = containerColor-vNxB06k$material3_release;
                            border2 = z;
                        }
                    } else {
                        traceInProgress2.skipToGroupEnd();
                        if (i48 & 8 != 0) {
                            $dirty3 &= -7169;
                        }
                        if (i48 & 16 != 0) {
                            $dirty3 &= i56;
                        }
                        if (i48 & 32 != 0) {
                            interactionSource2 = i19;
                            modifier2 = colors2;
                            i5 = obj7;
                            $dirty2 = semantics$default;
                            obj4 = border2;
                            obj3 = containerColor-vNxB06k$material3_release;
                            border2 = z;
                        } else {
                            interactionSource2 = $dirty3;
                            modifier2 = colors2;
                            i5 = obj7;
                            $dirty2 = semantics$default;
                            obj4 = border2;
                            obj3 = containerColor-vNxB06k$material3_release;
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
                SurfaceKt.Surface-o_FOJdg(obj8, SemanticsModifierKt.semantics$default(modifier2, false, (Function1)IconButtonKt.OutlinedIconButton.1.INSTANCE, i46, 0), border2, i5, $dirty2.containerColor-vNxB06k$material3_release(border2), i6, $dirty2.contentColor-vNxB06k$material3_release(border2), obj18, 0, 0, obj4, obj3, (Function2)ComposableLambdaKt.rememberComposableLambda(582332538, i46, anon, traceInProgress2, 54), traceInProgress2, i28 | i36);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = $dirty2;
                i12 = interactionSource2;
                $dirty = border2;
                obj6 = i5;
                obj5 = obj4;
                obj = obj3;
                colors3 = modifier2;
            } else {
                traceInProgress2.skipToGroupEnd();
                composer = traceInProgress2;
                i12 = $dirty3;
                colors3 = colors2;
                $dirty = z;
                obj6 = obj7;
                obj2 = semantics$default;
                obj5 = border2;
                obj = containerColor-vNxB06k$material3_release;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            modifier2 = new IconButtonKt.OutlinedIconButton.3(onClick, colors3, $dirty, obj6, obj2, obj5, obj, obj10, i47, i48);
            endRestartGroup.updateScope((Function2)modifier2);
        }
    }

    public static final void OutlinedIconToggleButton(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, Shape shape, androidx.compose.material3.IconToggleButtonColors colors, BorderStroke border, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i12) {
        boolean traceInProgress2;
        boolean obj7;
        int i10;
        int colors4;
        Object obj12;
        int defaultsInvalid;
        int outlinedShape;
        int shape3;
        int colors3;
        boolean z;
        Object enabled2;
        Object obj3;
        Object obj5;
        boolean shape4;
        int $dirty2;
        Object $dirty3;
        Object $dirty;
        int i8;
        Object obj2;
        Object obj4;
        int i5;
        int i;
        int i2;
        Object obj11;
        Object obj8;
        boolean traceInProgress;
        Object obj9;
        int i3;
        int str;
        boolean z2;
        int i9;
        Object shape2;
        int changed;
        Object colors2;
        int changed2;
        Object obj10;
        int changed3;
        int i4;
        int i7;
        int i6;
        int modifier3;
        int modifier2;
        Object obj6;
        Object obj;
        traceInProgress2 = checked;
        obj7 = content;
        int i28 = $changed;
        int i36 = i12;
        final Composer restartGroup = $composer.startRestartGroup(1470292106);
        ComposerKt.sourceInformation(restartGroup, "C(OutlinedIconToggleButton)P(1,7,6,4,8,2!1,5)555@26419L13,556@26490L32,557@26571L48,567@26938L32,568@27008L30,571@27123L190,561@26722L591:IconButton.kt#uh7d8r");
        $dirty2 = $changed;
        if (i36 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i28 & 6 == 0) {
                i8 = restartGroup.changed(traceInProgress2) ? 4 : 2;
                $dirty2 |= i8;
            }
        }
        if (i36 & 2 != 0) {
            $dirty2 |= 48;
            obj2 = onCheckedChange;
        } else {
            if (i28 & 48 == 0) {
                i5 = restartGroup.changedInstance(onCheckedChange) ? 32 : 16;
                $dirty2 |= i5;
            } else {
                obj2 = onCheckedChange;
            }
        }
        int i42 = i36 & 4;
        if (i42 != 0) {
            $dirty2 |= 384;
            obj8 = modifier;
        } else {
            if (i28 & 384 == 0) {
                i3 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                obj8 = modifier;
            }
        }
        str = i36 & 8;
        if (str != null) {
            $dirty2 |= 3072;
            z2 = enabled;
        } else {
            if (i28 & 3072 == 0) {
                i9 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i9;
            } else {
                z2 = enabled;
            }
        }
        if (i28 & 24576 == 0) {
            if (i36 & 16 == 0) {
                changed = restartGroup.changed(shape) ? 16384 : 8192;
            } else {
                shape2 = shape;
            }
            $dirty2 |= changed;
        } else {
            shape2 = shape;
        }
        if (i61 &= i28 == 0) {
            if (i36 & 32 == 0) {
                changed2 = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                colors2 = colors;
            }
            $dirty2 |= changed2;
        } else {
            colors2 = colors;
        }
        if (i64 &= i28 == 0) {
            if (i36 & 64 == 0) {
                changed3 = restartGroup.changed(border) ? 1048576 : 524288;
            } else {
                obj10 = border;
            }
            $dirty2 |= changed3;
        } else {
            obj10 = border;
        }
        i4 = i36 & 128;
        i7 = 12582912;
        if (i4 != 0) {
            $dirty2 |= i7;
            obj3 = interactionSource;
        } else {
            if (i28 & i7 == 0) {
                i6 = restartGroup.changed(interactionSource) ? 8388608 : 4194304;
                $dirty2 |= i6;
            } else {
                obj3 = interactionSource;
            }
        }
        modifier3 = 100663296;
        if (i36 & 256 != 0) {
            $dirty2 |= modifier3;
        } else {
            if ($changed & modifier3 == 0) {
                i10 = restartGroup.changedInstance(obj7) ? 67108864 : 33554432;
                $dirty2 |= i10;
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
                            obj8 = defaultsInvalid;
                        }
                        if (str != null) {
                            z2 = defaultsInvalid;
                        }
                        i2 = 6;
                        if (i12 & 16 != 0) {
                            $dirty2 &= i77;
                            shape2 = outlinedShape;
                        }
                        if (i12 & 32 != 0) {
                            $dirty2 &= i76;
                            colors2 = shape3;
                        }
                        if (i12 & 64 != 0) {
                            $dirty2 &= i38;
                            obj10 = colors3;
                        }
                        if (i4 != 0) {
                            i = $dirty2;
                            z = z2;
                            obj5 = shape2;
                            $dirty3 = colors2;
                            shape2 = obj10;
                            colors2 = i35;
                            obj12 = obj8;
                        } else {
                            i = $dirty2;
                            obj12 = obj8;
                            z = z2;
                            $dirty3 = colors2;
                            colors2 = obj3;
                            obj5 = shape2;
                            shape2 = obj10;
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
                            obj12 = obj8;
                            z = z2;
                            $dirty3 = colors2;
                            colors2 = obj3;
                            obj5 = shape2;
                            shape2 = obj10;
                        } else {
                            i = $dirty2;
                            obj12 = obj8;
                            z = z2;
                            $dirty3 = colors2;
                            colors2 = obj3;
                            obj5 = shape2;
                            shape2 = obj10;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1470292106, i, -1, "androidx.compose.material3.OutlinedIconToggleButton (IconButton.kt:561)");
                }
                Modifier semantics$default = SemanticsModifierKt.semantics$default(obj12, false, (Function1)IconButtonKt.OutlinedIconToggleButton.1.INSTANCE, 1, 0);
                IconButtonKt.OutlinedIconToggleButton.2 anon = new IconButtonKt.OutlinedIconToggleButton.2(obj7);
                modifier2 = i;
                SurfaceKt.Surface-d85dljk(checked, onCheckedChange, semantics$default, z, obj5, (Color)$dirty3.containerColor$material3_release(z, traceInProgress2, restartGroup, i50 |= i58).getValue().unbox-impl(), obj2, (Color)$dirty3.contentColor$material3_release(z, traceInProgress2, restartGroup, i68 |= i73).getValue().unbox-impl(), semantics$default, 0, 0, shape2, colors2, (Function2)ComposableLambdaKt.rememberComposableLambda(1207657396, true, anon, restartGroup, 54), restartGroup, i16 |= i24);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty = obj5;
                obj11 = shape2;
                obj9 = colors2;
                obj4 = obj;
                shape4 = z;
                enabled2 = obj6;
            } else {
                restartGroup.skipToGroupEnd();
                modifier2 = $dirty2;
                enabled2 = obj8;
                $dirty = shape2;
                obj4 = colors2;
                obj11 = obj10;
                obj9 = obj3;
                shape4 = z2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new IconButtonKt.OutlinedIconToggleButton.3(checked, onCheckedChange, enabled2, shape4, $dirty, obj4, obj11, obj9, content, $changed, i12);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }
}
