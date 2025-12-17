package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0013\u001aB\u0010\u000e\u001a\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0002\u0008\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a¦\u0001\u0010\u0019\u001a\u00020\u000f2\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0002\u0008\u00172\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011¢\u0006\u0002\u0008\u00172\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011¢\u0006\u0002\u0008\u00172\u0013\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011¢\u0006\u0002\u0008\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020!H\u0001ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(\u001a5\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u00012\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0002\u0008\u0017H\u0001ø\u0001\u0000¢\u0006\u0004\u0008,\u0010-\u001aÇ\u0001\u0010.\u001a\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u00112\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0002\u0008\u00172\u0006\u0010\u0012\u001a\u00020\u00132\u0013\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011¢\u0006\u0002\u0008\u00172\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011¢\u0006\u0002\u0008\u00172\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011¢\u0006\u0002\u0008\u00172\u0013\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011¢\u0006\u0002\u0008\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0001ø\u0001\u0000¢\u0006\u0004\u00081\u00102\u001aB\u00103\u001a\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0002\u0008\u0017H\u0007¢\u0006\u0002\u0010\u0018\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\u0008\u0005\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\u0008\u0008\u0010\u0006\"\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000c\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00064", d2 = {"ButtonsCrossAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonsMainAxisSpacing", "DialogMaxWidth", "getDialogMaxWidth", "()F", "DialogMinWidth", "getDialogMinWidth", "DialogPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "IconPadding", "TextPadding", "TitlePadding", "AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "AlertDialogContent", "buttons", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "buttonContentColor", "iconContentColor", "titleContentColor", "textContentColor", "AlertDialogContent-4hvqGtA", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JFJJJJLandroidx/compose/runtime/Composer;III)V", "AlertDialogFlowRow", "mainAxisSpacing", "crossAxisSpacing", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "AlertDialogImpl", "confirmButton", "dismissButton", "AlertDialogImpl-wrnwzgE", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "BasicAlertDialog", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AlertDialogKt {

    private static final float ButtonsCrossAxisSpacing;
    private static final float ButtonsMainAxisSpacing;
    private static final float DialogMaxWidth;
    private static final float DialogMinWidth;
    private static final PaddingValues DialogPadding;
    private static final PaddingValues IconPadding;
    private static final PaddingValues TextPadding;
    private static final PaddingValues TitlePadding;
    static {
        int i9 = 0;
        AlertDialogKt.DialogMinWidth = Dp.constructor-impl((float)i);
        int i10 = 0;
        AlertDialogKt.DialogMaxWidth = Dp.constructor-impl((float)i2);
        int i11 = 0;
        AlertDialogKt.ButtonsMainAxisSpacing = Dp.constructor-impl((float)i3);
        int i12 = 0;
        AlertDialogKt.ButtonsCrossAxisSpacing = Dp.constructor-impl((float)i4);
        int i13 = 0;
        AlertDialogKt.DialogPadding = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl((float)i5));
        int i14 = 0;
        final int i20 = 7;
        final int i21 = 0;
        final int i17 = 0;
        final int i18 = 0;
        final int i19 = 0;
        AlertDialogKt.IconPadding = PaddingKt.PaddingValues-a9UjIt4$default(i17, i18, i19, Dp.constructor-impl((float)i6), i20, i21);
        int i15 = 0;
        AlertDialogKt.TitlePadding = PaddingKt.PaddingValues-a9UjIt4$default(i17, i18, i19, Dp.constructor-impl((float)i7), i20, i21);
        int i16 = 0;
        AlertDialogKt.TextPadding = PaddingKt.PaddingValues-a9UjIt4$default(i17, i18, i19, Dp.constructor-impl((float)i8), i20, i21);
    }

    @Deprecated(message = "Use BasicAlertDialog instead", replaceWith = @ReplaceWith(...))
    public static final void AlertDialog(Function0<Unit> onDismissRequest, Modifier modifier, DialogProperties properties, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i7) {
        int traceInProgress2;
        int $dirty2;
        boolean $dirty;
        int i4;
        Object obj3;
        boolean traceInProgress;
        Object str;
        Object obj2;
        int i;
        int i9;
        Object obj4;
        Object obj5;
        int i14;
        int i13;
        int i2;
        Object obj;
        int i10;
        int i3;
        DialogProperties dialogProperties;
        int i5;
        int i6;
        int i8;
        int i11;
        int i12;
        final int i23 = $changed;
        traceInProgress2 = 325249497;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(AlertDialog)P(2,1,3)201@8986L65:AlertDialog.kt#uh7d8r");
        $dirty2 = $changed;
        if (i7 & 1 != 0) {
            $dirty2 |= 6;
            obj4 = onDismissRequest;
        } else {
            if (i23 & 6 == 0) {
                i4 = restartGroup.changedInstance(onDismissRequest) ? 4 : 2;
                $dirty2 |= i4;
            } else {
                obj4 = onDismissRequest;
            }
        }
        int i18 = i7 & 2;
        if (i18 != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i23 & 48 == 0) {
                i = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i;
            } else {
                str = modifier;
            }
        }
        i9 = i7 & 4;
        if (i9 != 0) {
            $dirty2 |= 384;
            obj5 = properties;
        } else {
            if (i23 & 384 == 0) {
                i14 = restartGroup.changed(properties) ? 256 : 128;
                $dirty2 |= i14;
            } else {
                obj5 = properties;
            }
        }
        if (i7 & 8 != 0) {
            $dirty2 |= 3072;
            obj = content;
        } else {
            if (i23 & 3072 == 0) {
                i13 = restartGroup.changedInstance(content) ? 2048 : 1024;
                $dirty2 |= i13;
            } else {
                obj = content;
            }
        }
        final int i25 = $dirty2;
        if (i25 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (i18 != 0) {
                    $dirty = Modifier.Companion;
                } else {
                    $dirty = str;
                }
                if (i9 != 0) {
                    dialogProperties = new DialogProperties(0, 0, 0, 7, 0);
                    i2 = dialogProperties;
                } else {
                    i2 = obj5;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i25, -1, "androidx.compose.material3.AlertDialog (AlertDialog.kt:201)");
                }
                obj5 = $dirty;
                AlertDialogKt.BasicAlertDialog(obj4, obj5, i2, obj, restartGroup, i17 | i21, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = obj5;
                obj2 = i2;
            } else {
                restartGroup.skipToGroupEnd();
                obj3 = str;
                obj2 = obj5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new AlertDialogKt.AlertDialog.1(onDismissRequest, obj3, obj2, content, i23, i7);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void AlertDialogContent-4hvqGtA(Function2<? super Composer, ? super Integer, Unit> buttons, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> text, Shape shape, long containerColor, float tonalElevation, long buttonContentColor, long iconContentColor, long titleContentColor, long textContentColor, Composer $composer, int $changed, int $changed1, int i16) {
        int changed;
        long l5;
        boolean traceInProgress;
        Object endRestartGroup;
        boolean traceInProgress2;
        int i11;
        long l;
        long l2;
        long l4;
        Object obj4;
        int $dirty3;
        int $dirty1;
        Object obj7;
        Object obj3;
        long l3;
        int i15;
        float f;
        int i9;
        int i14;
        int $dirty2;
        Object modifier2;
        int i10;
        int i2;
        Object obj;
        int i4;
        Object obj2;
        Object obj5;
        int i17;
        int i5;
        int changed2;
        int i;
        int i12;
        int i6;
        int i7;
        int $dirty;
        int i8;
        int i3;
        int i13;
        Composer composer;
        long l6;
        Object obj6;
        ScopeUpdateScope scopeUpdateScope;
        int i18 = obj47;
        int i27 = obj49;
        final Composer restartGroup = obj46.startRestartGroup(1522575799);
        ComposerKt.sourceInformation(restartGroup, "C(AlertDialogContent)P(1,5,3,9,7,6,2:c#ui.graphics.Color,11:c#ui.unit.Dp,0:c#ui.graphics.Color,4:c#ui.graphics.Color,10:c#ui.graphics.Color,8:c#ui.graphics.Color)299@12328L2062,294@12188L2202:AlertDialog.kt#uh7d8r");
        $dirty3 = obj47;
        $dirty1 = obj48;
        if (i27 & 1 != 0) {
            $dirty3 |= 6;
            obj7 = buttons;
        } else {
            if (i18 & 6 == 0) {
                i15 = restartGroup.changedInstance(buttons) ? 4 : 2;
                $dirty3 |= i15;
            } else {
                obj7 = buttons;
            }
        }
        int i39 = i27 & 2;
        if (i39 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else {
            if (i18 & 48 == 0) {
                i10 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i10;
            } else {
                modifier2 = modifier;
            }
        }
        if (i27 & 4 != 0) {
            $dirty3 |= 384;
            obj5 = icon;
        } else {
            if (i18 & 384 == 0) {
                i2 = restartGroup.changedInstance(icon) ? 256 : 128;
                $dirty3 |= i2;
            } else {
                obj5 = icon;
            }
        }
        if (i27 & 8 != 0) {
            $dirty3 |= 3072;
            obj = title;
        } else {
            if (i18 & 3072 == 0) {
                i4 = restartGroup.changedInstance(title) ? 2048 : 1024;
                $dirty3 |= i4;
            } else {
                obj = title;
            }
        }
        if (i27 & 16 != 0) {
            $dirty3 |= 24576;
            obj2 = text;
        } else {
            if (i18 & 24576 == 0) {
                i17 = restartGroup.changedInstance(text) ? 16384 : 8192;
                $dirty3 |= i17;
            } else {
                obj2 = text;
            }
        }
        int i47 = 196608;
        if (i27 & 32 != 0) {
            $dirty3 |= i47;
            obj3 = shape;
        } else {
            if (i18 & i47 == 0) {
                i5 = restartGroup.changed(shape) ? 131072 : 65536;
                $dirty3 |= i5;
            } else {
                obj3 = shape;
            }
        }
        int i48 = 1572864;
        if (i27 & 64 != 0) {
            $dirty3 |= i48;
            i12 = i39;
            l3 = containerColor;
        } else {
            if (i18 & i48 == 0) {
                i12 = i39;
                i6 = restartGroup.changed(containerColor) ? 1048576 : 524288;
                $dirty3 |= i6;
            } else {
                i12 = i39;
                l3 = containerColor;
            }
        }
        final int i52 = 12582912;
        if (i27 & 128 != 0) {
            $dirty3 |= i52;
            f = buttonContentColor;
        } else {
            if (i18 & i52 == 0) {
                i7 = restartGroup.changed(buttonContentColor) ? 8388608 : 4194304;
                $dirty3 |= i7;
            } else {
                f = buttonContentColor;
            }
        }
        int i49 = 100663296;
        if (i27 & 256 != 0) {
            $dirty = $dirty3;
            l = iconContentColor;
        } else {
            if (i18 & i49 == 0) {
                i8 = restartGroup.changed(iconContentColor) ? 67108864 : 33554432;
                i50 |= i8;
            } else {
                $dirty = $dirty3;
                l = iconContentColor;
            }
        }
        int i51 = 805306368;
        if (i27 & 512 != 0) {
            $dirty |= i51;
            l2 = textContentColor;
        } else {
            if (i18 & i51 == 0) {
                i14 = restartGroup.changed(textContentColor) ? 536870912 : 268435456;
                $dirty |= i14;
            } else {
                l2 = textContentColor;
            }
        }
        $dirty2 = $dirty;
        if (i27 & 1024 != 0) {
            $dirty1 |= 6;
            l4 = $changed;
        } else {
            if (obj48 & 6 == 0) {
                changed2 = restartGroup.changed($changed) ? 4 : 2;
                $dirty1 |= changed2;
            } else {
                l4 = $changed;
            }
        }
        if (i27 & 2048 != 0) {
            $dirty1 |= 48;
            l5 = i16;
        } else {
            if (obj48 & 48 == 0) {
                i6 = restartGroup.changed(i16) ? 32 : 16;
                $dirty1 |= i6;
            } else {
                l5 = i16;
            }
        }
        if ($dirty2 & i == 306783378 && $dirty1 & 19 == 18) {
            if ($dirty1 & 19 == 18) {
                if (!restartGroup.getSkipping()) {
                    if (i12 != 0) {
                        modifier2 = traceInProgress;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1522575799, $dirty2, $dirty1, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:293)");
                    }
                    AlertDialogKt.AlertDialogContent.1 anon = new AlertDialogKt.AlertDialogContent.1(obj5, obj, text, textContentColor, i7, l4, i8, i16, obj23, iconContentColor, obj25, obj7);
                    $dirty3 = modifier2;
                    i3 = $dirty1;
                    i13 = $dirty;
                    SurfaceKt.Surface-T9BRK9s($dirty3, obj3, containerColor, obj3, 0, i39, f, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-2126308228, true, anon, restartGroup, 54), restartGroup);
                    composer = restartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj4 = $dirty3;
                } else {
                    restartGroup.skipToGroupEnd();
                    i3 = $dirty1;
                    i13 = $dirty2;
                    obj4 = modifier2;
                    composer = restartGroup;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new AlertDialogKt.AlertDialogContent.2(buttons, obj4, icon, title, text, shape, containerColor, i39, buttonContentColor, iconContentColor, modifier2, textContentColor, restartGroup, $changed, obj5, i16, i12, obj47, obj48, obj49);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void AlertDialogFlowRow-ixp7dh8(float mainAxisSpacing, float crossAxisSpacing, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress;
        int i7;
        Integer invalid$iv;
        int $dirty;
        int i;
        int i3;
        int i9;
        boolean setCompositeKeyHash;
        boolean traceInProgress2;
        int i6;
        int i2;
        Integer valueOf;
        int companion;
        int currentCompositeKeyHash;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Object materializeModifier;
        Function0 constructor;
        Object anon;
        int i10;
        int i4;
        int i8;
        int i5;
        int i11;
        Composer composer;
        int i12;
        Object measurePolicy$iv;
        int i13;
        int obj26;
        final float f = mainAxisSpacing;
        final float f2 = crossAxisSpacing;
        final Object obj = content;
        final int i14 = $changed;
        traceInProgress = 586821353;
        Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(AlertDialogFlowRow)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp)365@14664L3370,365@14648L3386:AlertDialog.kt#uh7d8r");
        i2 = 4;
        if (i14 & 6 == 0) {
            i = restartGroup.changed(f) ? i2 : 2;
            $dirty |= i;
        }
        companion = 32;
        if (i14 & 48 == 0) {
            i3 = restartGroup.changed(f2) ? companion : 16;
            $dirty |= i3;
        }
        if (i14 & 384 == 0) {
            i9 = restartGroup.changedInstance(obj) ? 256 : 128;
            $dirty |= i9;
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.AlertDialogFlowRow (AlertDialog.kt:364)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -767073803, "CC(remember):AlertDialog.kt#9igjgp");
                int i26 = 0;
                i7 = $dirty & 14 == i2 ? i6 : i26;
                if ($dirty & 112 == companion) {
                } else {
                    i6 = i26;
                }
                Composer composer2 = restartGroup;
                int i24 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                int i27 = 0;
                if (i7 |= i6 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        materializeModifier = 0;
                        anon = new AlertDialogKt.AlertDialogFlowRow.1.1(f, f2);
                        composer2.updateRememberedValue((MeasurePolicy)anon);
                    } else {
                        anon = rememberedValue2;
                    }
                } else {
                }
                invalid$iv = anon;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                i20 &= 14;
                valueOf = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, i26);
                i4 = 0;
                obj26 = $dirty;
                i8 = i21;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(ComposeUiNode.Companion.getConstructor());
                } else {
                    restartGroup.useNode();
                }
                $dirty = Updater.constructor-impl(restartGroup);
                i11 = i22;
                Updater.set-impl($dirty, (MeasurePolicy)invalid$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($dirty, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i5 = 0;
                composer = $dirty;
                i12 = 0;
                if (!composer.getInserting()) {
                    measurePolicy$iv = invalid$iv;
                    i13 = valueOf;
                    if (!Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        $dirty.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        i2 = composer;
                    }
                } else {
                    measurePolicy$iv = invalid$iv;
                    i13 = valueOf;
                }
                Updater.set-impl($dirty, ComposedModifierKt.materializeModifier(restartGroup, (Modifier)Modifier.Companion), ComposeUiNode.Companion.getSetModifier());
                obj.invoke(restartGroup, Integer.valueOf(i18 &= 14));
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                obj26 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = new AlertDialogKt.AlertDialogFlowRow.2(f, f2, obj, i14);
            endRestartGroup.updateScope((Function2)$dirty);
        }
    }

    public static final void AlertDialogImpl-wrnwzgE(Function0<Unit> onDismissRequest, Function2<? super Composer, ? super Integer, Unit> confirmButton, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> dismissButton, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> text, Shape shape, long containerColor, long iconContentColor, long titleContentColor, long textContentColor, float tonalElevation, DialogProperties properties, Composer $composer, int $changed, int $changed1) {
        float f;
        Object obj;
        boolean traceInProgress;
        Object endRestartGroup;
        boolean traceInProgress2;
        int i10;
        long l2;
        long l;
        long l4;
        int $dirty3;
        int $dirty1;
        Object obj3;
        Object obj2;
        Object restartGroup;
        Object obj4;
        int i5;
        Object obj8;
        int $dirty;
        Object obj11;
        Object obj6;
        int i;
        Object anon;
        long l3;
        Object obj5;
        int i6;
        Object obj10;
        int i7;
        int i18;
        int i13;
        int i2;
        int i8;
        boolean changed;
        int i14;
        int i17;
        int i15;
        int i16;
        int i9;
        int i11;
        int i3;
        Composer composer;
        int i12;
        int $dirty2;
        boolean $dirty4;
        int i4;
        int i19;
        Object obj7;
        Object obj9;
        ScopeUpdateScope scopeUpdateScope;
        int i20 = obj48;
        int i27 = obj49;
        restartGroup = obj47.startRestartGroup(-919826268);
        ComposerKt.sourceInformation(restartGroup, "C(AlertDialogImpl)P(6!1,5,2,3,11,9,8,1:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color,10:c#ui.graphics.Color,13:c#ui.unit.Dp)251@10652L1109,247@10522L1239:AlertDialog.kt#uh7d8r");
        if (i20 & 6 == 0) {
            i5 = restartGroup.changedInstance(onDismissRequest) ? 4 : 2;
            $dirty3 |= i5;
        } else {
            obj3 = onDismissRequest;
        }
        if (i20 & 48 == 0) {
            i = restartGroup.changedInstance(confirmButton) ? 32 : 16;
            $dirty3 |= i;
        } else {
            obj8 = confirmButton;
        }
        if (i20 & 384 == 0) {
            i6 = restartGroup.changed(modifier) ? 256 : 128;
            $dirty3 |= i6;
        } else {
            anon = modifier;
        }
        i13 = 1024;
        if (i20 & 3072 == 0) {
            i2 = restartGroup.changedInstance(dismissButton) ? i7 : i13;
            $dirty3 |= i2;
        } else {
            obj10 = dismissButton;
        }
        if (i20 & 24576 == 0) {
            i2 = restartGroup.changedInstance(icon) ? 16384 : 8192;
            $dirty3 |= i2;
        } else {
            obj2 = icon;
        }
        if (i20 & i38 == 0) {
            i14 = restartGroup.changedInstance(title) ? 131072 : 65536;
            $dirty3 |= i14;
        } else {
            obj4 = title;
        }
        if (i20 & i39 == 0) {
            i15 = restartGroup.changedInstance(text) ? 1048576 : 524288;
            $dirty3 |= i15;
        } else {
            obj11 = text;
        }
        if (i20 & i40 == 0) {
            i9 = restartGroup.changed(shape) ? 8388608 : 4194304;
            $dirty3 |= i9;
        } else {
            obj6 = shape;
        }
        if (i20 & i41 == 0) {
            i12 = restartGroup.changed(containerColor) ? 67108864 : 33554432;
            $dirty3 |= i12;
        } else {
            l3 = containerColor;
        }
        int i43 = i20 & i42;
        if (i43 == 0) {
            i19 = restartGroup.changed(titleContentColor) ? 536870912 : 268435456;
            i44 |= i19;
        } else {
            $dirty2 = $dirty3;
            l2 = titleContentColor;
        }
        $dirty = $dirty2;
        if (i27 & 6 == 0) {
            i8 = restartGroup.changed(tonalElevation) ? 4 : 2;
            $dirty1 |= i8;
        } else {
            l = tonalElevation;
        }
        if (i27 & 48 == 0) {
            i17 = restartGroup.changed($composer) ? 32 : 16;
            $dirty1 |= i17;
        } else {
            l4 = $composer;
        }
        if (i27 & 384 == 0) {
            i11 = restartGroup.changed($changed1) ? 256 : 128;
            $dirty1 |= i11;
        } else {
            f = $changed1;
        }
        if (i27 & 3072 == 0) {
            if (restartGroup.changed(obj46)) {
            } else {
                i7 = i13;
            }
            $dirty1 |= i7;
        } else {
            obj = obj46;
        }
        if ($dirty & i18 == 306783378 && $dirty1 & 1171 == 1170) {
            if ($dirty1 & 1171 == 1170) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-919826268, $dirty, $dirty1, "androidx.compose.material3.AlertDialogImpl (AlertDialog.kt:247)");
                    }
                    anon = new AlertDialogKt.AlertDialogImpl.1(obj2, obj4, obj11, obj6, l3, changed, $changed1, titleContentColor, i11, tonalElevation, i43, l4, i19, obj10, confirmButton);
                    i4 = $dirty;
                    i3 = $dirty1;
                    AlertDialogKt.BasicAlertDialog(obj3, modifier, obj46, (Function2)ComposableLambdaKt.rememberComposableLambda(-1852840226, true, anon, restartGroup, 54), restartGroup, i26 | i10, 0);
                    composer = restartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    i3 = $dirty1;
                    composer = restartGroup;
                    i4 = $dirty;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new AlertDialogKt.AlertDialogImpl.2(onDismissRequest, confirmButton, modifier, dismissButton, icon, title, text, shape, containerColor, obj11, titleContentColor, anon, tonalElevation, obj5, $composer, i18, $changed1, obj46, obj48, obj49);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void BasicAlertDialog(Function0<Unit> onDismissRequest, Modifier modifier, DialogProperties properties, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i7) {
        int traceInProgress;
        int $dirty;
        boolean $dirty2;
        int i3;
        Object obj3;
        boolean traceInProgress2;
        Object str;
        Object obj4;
        Object obj;
        int i;
        int i8;
        Object obj2;
        int i4;
        int i12;
        int i13;
        int i5;
        DialogProperties dialogProperties;
        int i2;
        int i6;
        int i9;
        int i10;
        int i11;
        final Object obj6 = content;
        final int i22 = $changed;
        traceInProgress = -1922902937;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(BasicAlertDialog)P(2,1,3)149@6931L384,146@6839L476:AlertDialog.kt#uh7d8r");
        $dirty = $changed;
        if (i7 & 1 != 0) {
            $dirty |= 6;
            obj = onDismissRequest;
        } else {
            if (i22 & 6 == 0) {
                i3 = restartGroup.changedInstance(onDismissRequest) ? 4 : 2;
                $dirty |= i3;
            } else {
                obj = onDismissRequest;
            }
        }
        int i16 = i7 & 2;
        if (i16 != 0) {
            $dirty |= 48;
            str = modifier;
        } else {
            if (i22 & 48 == 0) {
                i = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i;
            } else {
                str = modifier;
            }
        }
        i8 = i7 & 4;
        if (i8 != 0) {
            $dirty |= 384;
            obj2 = properties;
        } else {
            if (i22 & 384 == 0) {
                i4 = restartGroup.changed(properties) ? 256 : 128;
                $dirty |= i4;
            } else {
                obj2 = properties;
            }
        }
        if (i7 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i22 & 3072 == 0) {
                i12 = restartGroup.changedInstance(obj6) ? 2048 : 1024;
                $dirty |= i12;
            }
        }
        final int i25 = $dirty;
        if (i25 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (i16 != 0) {
                    $dirty2 = Modifier.Companion;
                } else {
                    $dirty2 = str;
                }
                if (i8 != 0) {
                    dialogProperties = new DialogProperties(0, 0, 0, 7, 0);
                    i8 = dialogProperties;
                } else {
                    i8 = obj2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i25, -1, "androidx.compose.material3.BasicAlertDialog (AlertDialog.kt:145)");
                }
                AlertDialogKt.BasicAlertDialog.1 anon = new AlertDialogKt.BasicAlertDialog.1($dirty2, obj6);
                AndroidDialog_androidKt.Dialog(obj, i8, (Function2)ComposableLambdaKt.rememberComposableLambda(905289008, true, anon, restartGroup, 54), restartGroup, i15 | i19, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = $dirty2;
                obj4 = i8;
            } else {
                restartGroup.skipToGroupEnd();
                obj3 = str;
                obj4 = obj2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new AlertDialogKt.BasicAlertDialog.2(onDismissRequest, obj3, obj4, obj6, i22, i7);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final float access$getButtonsCrossAxisSpacing$p() {
        return AlertDialogKt.ButtonsCrossAxisSpacing;
    }

    public static final float access$getButtonsMainAxisSpacing$p() {
        return AlertDialogKt.ButtonsMainAxisSpacing;
    }

    public static final PaddingValues access$getDialogPadding$p() {
        return AlertDialogKt.DialogPadding;
    }

    public static final PaddingValues access$getIconPadding$p() {
        return AlertDialogKt.IconPadding;
    }

    public static final PaddingValues access$getTextPadding$p() {
        return AlertDialogKt.TextPadding;
    }

    public static final PaddingValues access$getTitlePadding$p() {
        return AlertDialogKt.TitlePadding;
    }

    public static final float getDialogMaxWidth() {
        return AlertDialogKt.DialogMaxWidth;
    }

    public static final float getDialogMinWidth() {
        return AlertDialogKt.DialogMinWidth;
    }
}
