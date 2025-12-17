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
        int $dirty;
        boolean $dirty2;
        int i5;
        Object obj5;
        boolean traceInProgress;
        Object str;
        Object obj3;
        int i10;
        int i;
        Object obj2;
        Object obj;
        int i9;
        int i13;
        int i2;
        Object obj4;
        int i14;
        int i11;
        DialogProperties dialogProperties;
        int i3;
        int i12;
        int i4;
        int i6;
        int i8;
        final int i23 = $changed;
        traceInProgress2 = 325249497;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(AlertDialog)P(2,1,3)201@8986L65:AlertDialog.kt#uh7d8r");
        $dirty = $changed;
        if (i7 & 1 != 0) {
            $dirty |= 6;
            obj2 = onDismissRequest;
        } else {
            if (i23 & 6 == 0) {
                i5 = restartGroup.changedInstance(onDismissRequest) ? 4 : 2;
                $dirty |= i5;
            } else {
                obj2 = onDismissRequest;
            }
        }
        int i18 = i7 & 2;
        if (i18 != 0) {
            $dirty |= 48;
            str = modifier;
        } else {
            if (i23 & 48 == 0) {
                i10 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i10;
            } else {
                str = modifier;
            }
        }
        i = i7 & 4;
        if (i != 0) {
            $dirty |= 384;
            obj = properties;
        } else {
            if (i23 & 384 == 0) {
                i9 = restartGroup.changed(properties) ? 256 : 128;
                $dirty |= i9;
            } else {
                obj = properties;
            }
        }
        if (i7 & 8 != 0) {
            $dirty |= 3072;
            obj4 = content;
        } else {
            if (i23 & 3072 == 0) {
                i13 = restartGroup.changedInstance(content) ? 2048 : 1024;
                $dirty |= i13;
            } else {
                obj4 = content;
            }
        }
        final int i25 = $dirty;
        if (i25 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (i18 != 0) {
                    $dirty2 = Modifier.Companion;
                } else {
                    $dirty2 = str;
                }
                if (i != 0) {
                    dialogProperties = new DialogProperties(0, 0, 0, 7, 0);
                    i2 = dialogProperties;
                } else {
                    i2 = obj;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i25, -1, "androidx.compose.material3.AlertDialog (AlertDialog.kt:201)");
                }
                obj = $dirty2;
                AlertDialogKt.BasicAlertDialog(obj2, obj, i2, obj4, restartGroup, i17 | i21, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj;
                obj3 = i2;
            } else {
                restartGroup.skipToGroupEnd();
                obj5 = str;
                obj3 = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new AlertDialogKt.AlertDialog.1(onDismissRequest, obj5, obj3, content, i23, i7);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void AlertDialogContent-4hvqGtA(Function2<? super Composer, ? super Integer, Unit> buttons, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> text, Shape shape, long containerColor, float tonalElevation, long buttonContentColor, long iconContentColor, long titleContentColor, long textContentColor, Composer $composer, int $changed, int $changed1, int i16) {
        int changed;
        long l6;
        boolean traceInProgress;
        Object endRestartGroup;
        boolean traceInProgress2;
        int i10;
        long l2;
        long l4;
        long l;
        Object obj4;
        int $dirty;
        int $dirty1;
        Object obj;
        Object obj6;
        long l3;
        int i17;
        float f;
        int i8;
        int i6;
        int $dirty2;
        Object modifier2;
        int i7;
        int i3;
        Object obj2;
        int i4;
        Object obj7;
        Object obj3;
        int i9;
        int i15;
        int changed2;
        int i14;
        int i12;
        int i;
        int i13;
        int $dirty3;
        int i11;
        int i2;
        int i5;
        Composer composer;
        long l5;
        Object obj5;
        ScopeUpdateScope scopeUpdateScope;
        int i18 = obj47;
        int i27 = obj49;
        final Composer restartGroup = obj46.startRestartGroup(1522575799);
        ComposerKt.sourceInformation(restartGroup, "C(AlertDialogContent)P(1,5,3,9,7,6,2:c#ui.graphics.Color,11:c#ui.unit.Dp,0:c#ui.graphics.Color,4:c#ui.graphics.Color,10:c#ui.graphics.Color,8:c#ui.graphics.Color)299@12328L2062,294@12188L2202:AlertDialog.kt#uh7d8r");
        $dirty = obj47;
        $dirty1 = obj48;
        if (i27 & 1 != 0) {
            $dirty |= 6;
            obj = buttons;
        } else {
            if (i18 & 6 == 0) {
                i17 = restartGroup.changedInstance(buttons) ? 4 : 2;
                $dirty |= i17;
            } else {
                obj = buttons;
            }
        }
        int i39 = i27 & 2;
        if (i39 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else {
            if (i18 & 48 == 0) {
                i7 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i7;
            } else {
                modifier2 = modifier;
            }
        }
        if (i27 & 4 != 0) {
            $dirty |= 384;
            obj3 = icon;
        } else {
            if (i18 & 384 == 0) {
                i3 = restartGroup.changedInstance(icon) ? 256 : 128;
                $dirty |= i3;
            } else {
                obj3 = icon;
            }
        }
        if (i27 & 8 != 0) {
            $dirty |= 3072;
            obj2 = title;
        } else {
            if (i18 & 3072 == 0) {
                i4 = restartGroup.changedInstance(title) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                obj2 = title;
            }
        }
        if (i27 & 16 != 0) {
            $dirty |= 24576;
            obj7 = text;
        } else {
            if (i18 & 24576 == 0) {
                i9 = restartGroup.changedInstance(text) ? 16384 : 8192;
                $dirty |= i9;
            } else {
                obj7 = text;
            }
        }
        int i47 = 196608;
        if (i27 & 32 != 0) {
            $dirty |= i47;
            obj6 = shape;
        } else {
            if (i18 & i47 == 0) {
                i15 = restartGroup.changed(shape) ? 131072 : 65536;
                $dirty |= i15;
            } else {
                obj6 = shape;
            }
        }
        int i48 = 1572864;
        if (i27 & 64 != 0) {
            $dirty |= i48;
            i12 = i39;
            l3 = containerColor;
        } else {
            if (i18 & i48 == 0) {
                i12 = i39;
                i = restartGroup.changed(containerColor) ? 1048576 : 524288;
                $dirty |= i;
            } else {
                i12 = i39;
                l3 = containerColor;
            }
        }
        final int i52 = 12582912;
        if (i27 & 128 != 0) {
            $dirty |= i52;
            f = buttonContentColor;
        } else {
            if (i18 & i52 == 0) {
                i13 = restartGroup.changed(buttonContentColor) ? 8388608 : 4194304;
                $dirty |= i13;
            } else {
                f = buttonContentColor;
            }
        }
        int i49 = 100663296;
        if (i27 & 256 != 0) {
            $dirty3 = $dirty;
            l2 = iconContentColor;
        } else {
            if (i18 & i49 == 0) {
                i11 = restartGroup.changed(iconContentColor) ? 67108864 : 33554432;
                i50 |= i11;
            } else {
                $dirty3 = $dirty;
                l2 = iconContentColor;
            }
        }
        int i51 = 805306368;
        if (i27 & 512 != 0) {
            $dirty3 |= i51;
            l4 = textContentColor;
        } else {
            if (i18 & i51 == 0) {
                i6 = restartGroup.changed(textContentColor) ? 536870912 : 268435456;
                $dirty3 |= i6;
            } else {
                l4 = textContentColor;
            }
        }
        $dirty2 = $dirty3;
        if (i27 & 1024 != 0) {
            $dirty1 |= 6;
            l = $changed;
        } else {
            if (obj48 & 6 == 0) {
                changed2 = restartGroup.changed($changed) ? 4 : 2;
                $dirty1 |= changed2;
            } else {
                l = $changed;
            }
        }
        if (i27 & 2048 != 0) {
            $dirty1 |= 48;
            l6 = i16;
        } else {
            if (obj48 & 48 == 0) {
                i = restartGroup.changed(i16) ? 32 : 16;
                $dirty1 |= i;
            } else {
                l6 = i16;
            }
        }
        if ($dirty2 & i14 == 306783378 && $dirty1 & 19 == 18) {
            if ($dirty1 & 19 == 18) {
                if (!restartGroup.getSkipping()) {
                    if (i12 != 0) {
                        modifier2 = traceInProgress;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1522575799, $dirty2, $dirty1, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:293)");
                    }
                    AlertDialogKt.AlertDialogContent.1 anon = new AlertDialogKt.AlertDialogContent.1(obj3, obj2, text, textContentColor, i13, l, i11, i16, obj23, iconContentColor, obj25, obj);
                    $dirty = modifier2;
                    i2 = $dirty1;
                    i5 = $dirty3;
                    SurfaceKt.Surface-T9BRK9s($dirty, obj6, containerColor, obj6, 0, i39, f, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-2126308228, true, anon, restartGroup, 54), restartGroup);
                    composer = restartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj4 = $dirty;
                } else {
                    restartGroup.skipToGroupEnd();
                    i2 = $dirty1;
                    i5 = $dirty2;
                    obj4 = modifier2;
                    composer = restartGroup;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new AlertDialogKt.AlertDialogContent.2(buttons, obj4, icon, title, text, shape, containerColor, i39, buttonContentColor, iconContentColor, modifier2, textContentColor, restartGroup, $changed, obj3, i16, i12, obj47, obj48, obj49);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void AlertDialogFlowRow-ixp7dh8(float mainAxisSpacing, float crossAxisSpacing, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress;
        int i13;
        Integer invalid$iv;
        int $dirty;
        int i5;
        int i8;
        int i4;
        boolean setCompositeKeyHash;
        boolean traceInProgress2;
        int i7;
        int i11;
        Integer valueOf;
        int companion;
        int currentCompositeKeyHash;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Object materializeModifier;
        Function0 constructor;
        Object anon;
        int i3;
        int i6;
        int i9;
        int i;
        int i10;
        Composer composer;
        int i12;
        Object measurePolicy$iv;
        int i2;
        int obj26;
        final float f = mainAxisSpacing;
        final float f2 = crossAxisSpacing;
        final Object obj = content;
        final int i14 = $changed;
        traceInProgress = 586821353;
        Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(AlertDialogFlowRow)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp)365@14664L3370,365@14648L3386:AlertDialog.kt#uh7d8r");
        i11 = 4;
        if (i14 & 6 == 0) {
            i5 = restartGroup.changed(f) ? i11 : 2;
            $dirty |= i5;
        }
        companion = 32;
        if (i14 & 48 == 0) {
            i8 = restartGroup.changed(f2) ? companion : 16;
            $dirty |= i8;
        }
        if (i14 & 384 == 0) {
            i4 = restartGroup.changedInstance(obj) ? 256 : 128;
            $dirty |= i4;
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.AlertDialogFlowRow (AlertDialog.kt:364)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -767073803, "CC(remember):AlertDialog.kt#9igjgp");
                int i26 = 0;
                i13 = $dirty & 14 == i11 ? i7 : i26;
                if ($dirty & 112 == companion) {
                } else {
                    i7 = i26;
                }
                Composer composer2 = restartGroup;
                int i24 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                int i27 = 0;
                if (i13 |= i7 == 0) {
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
                i6 = 0;
                obj26 = $dirty;
                i9 = i21;
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
                i10 = i22;
                Updater.set-impl($dirty, (MeasurePolicy)invalid$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($dirty, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i = 0;
                composer = $dirty;
                i12 = 0;
                if (!composer.getInserting()) {
                    measurePolicy$iv = invalid$iv;
                    i2 = valueOf;
                    if (!Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        $dirty.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        i11 = composer;
                    }
                } else {
                    measurePolicy$iv = invalid$iv;
                    i2 = valueOf;
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
        Object obj9;
        boolean traceInProgress;
        Object endRestartGroup;
        boolean traceInProgress2;
        int i19;
        long l3;
        long l2;
        long l;
        int $dirty3;
        int $dirty1;
        Object obj10;
        Object obj6;
        Object restartGroup;
        Object obj7;
        int i18;
        Object obj4;
        int $dirty2;
        Object obj5;
        Object obj;
        int i14;
        Object anon;
        long l4;
        Object obj3;
        int i17;
        Object obj8;
        int i6;
        int i5;
        int i13;
        int i;
        int i2;
        boolean changed;
        int i3;
        int i4;
        int i7;
        int i16;
        int i10;
        int i8;
        int i9;
        Composer composer;
        int i15;
        int $dirty4;
        boolean $dirty;
        int i11;
        int i12;
        Object obj11;
        Object obj2;
        ScopeUpdateScope scopeUpdateScope;
        int i20 = obj48;
        int i27 = obj49;
        restartGroup = obj47.startRestartGroup(-919826268);
        ComposerKt.sourceInformation(restartGroup, "C(AlertDialogImpl)P(6!1,5,2,3,11,9,8,1:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color,10:c#ui.graphics.Color,13:c#ui.unit.Dp)251@10652L1109,247@10522L1239:AlertDialog.kt#uh7d8r");
        if (i20 & 6 == 0) {
            i18 = restartGroup.changedInstance(onDismissRequest) ? 4 : 2;
            $dirty3 |= i18;
        } else {
            obj10 = onDismissRequest;
        }
        if (i20 & 48 == 0) {
            i14 = restartGroup.changedInstance(confirmButton) ? 32 : 16;
            $dirty3 |= i14;
        } else {
            obj4 = confirmButton;
        }
        if (i20 & 384 == 0) {
            i17 = restartGroup.changed(modifier) ? 256 : 128;
            $dirty3 |= i17;
        } else {
            anon = modifier;
        }
        i13 = 1024;
        if (i20 & 3072 == 0) {
            i = restartGroup.changedInstance(dismissButton) ? i6 : i13;
            $dirty3 |= i;
        } else {
            obj8 = dismissButton;
        }
        if (i20 & 24576 == 0) {
            i = restartGroup.changedInstance(icon) ? 16384 : 8192;
            $dirty3 |= i;
        } else {
            obj6 = icon;
        }
        if (i20 & i38 == 0) {
            i3 = restartGroup.changedInstance(title) ? 131072 : 65536;
            $dirty3 |= i3;
        } else {
            obj7 = title;
        }
        if (i20 & i39 == 0) {
            i7 = restartGroup.changedInstance(text) ? 1048576 : 524288;
            $dirty3 |= i7;
        } else {
            obj5 = text;
        }
        if (i20 & i40 == 0) {
            i10 = restartGroup.changed(shape) ? 8388608 : 4194304;
            $dirty3 |= i10;
        } else {
            obj = shape;
        }
        if (i20 & i41 == 0) {
            i15 = restartGroup.changed(containerColor) ? 67108864 : 33554432;
            $dirty3 |= i15;
        } else {
            l4 = containerColor;
        }
        int i43 = i20 & i42;
        if (i43 == 0) {
            i12 = restartGroup.changed(titleContentColor) ? 536870912 : 268435456;
            i44 |= i12;
        } else {
            $dirty4 = $dirty3;
            l3 = titleContentColor;
        }
        $dirty2 = $dirty4;
        if (i27 & 6 == 0) {
            i2 = restartGroup.changed(tonalElevation) ? 4 : 2;
            $dirty1 |= i2;
        } else {
            l2 = tonalElevation;
        }
        if (i27 & 48 == 0) {
            i4 = restartGroup.changed($composer) ? 32 : 16;
            $dirty1 |= i4;
        } else {
            l = $composer;
        }
        if (i27 & 384 == 0) {
            i8 = restartGroup.changed($changed1) ? 256 : 128;
            $dirty1 |= i8;
        } else {
            f = $changed1;
        }
        if (i27 & 3072 == 0) {
            if (restartGroup.changed(obj46)) {
            } else {
                i6 = i13;
            }
            $dirty1 |= i6;
        } else {
            obj9 = obj46;
        }
        if ($dirty2 & i5 == 306783378 && $dirty1 & 1171 == 1170) {
            if ($dirty1 & 1171 == 1170) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-919826268, $dirty2, $dirty1, "androidx.compose.material3.AlertDialogImpl (AlertDialog.kt:247)");
                    }
                    anon = new AlertDialogKt.AlertDialogImpl.1(obj6, obj7, obj5, obj, l4, changed, $changed1, titleContentColor, i8, tonalElevation, i43, l, i12, obj8, confirmButton);
                    i11 = $dirty2;
                    i9 = $dirty1;
                    AlertDialogKt.BasicAlertDialog(obj10, modifier, obj46, (Function2)ComposableLambdaKt.rememberComposableLambda(-1852840226, true, anon, restartGroup, 54), restartGroup, i26 | i19, 0);
                    composer = restartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    i9 = $dirty1;
                    composer = restartGroup;
                    i11 = $dirty2;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new AlertDialogKt.AlertDialogImpl.2(onDismissRequest, confirmButton, modifier, dismissButton, icon, title, text, shape, containerColor, obj5, titleContentColor, anon, tonalElevation, obj3, $composer, i5, $changed1, obj46, obj48, obj49);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void BasicAlertDialog(Function0<Unit> onDismissRequest, Modifier modifier, DialogProperties properties, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i7) {
        int traceInProgress2;
        int $dirty;
        boolean $dirty2;
        int i;
        Object obj4;
        boolean traceInProgress;
        Object str;
        Object obj3;
        Object obj;
        int i3;
        int i5;
        Object obj2;
        int i2;
        int i13;
        int i6;
        int i9;
        DialogProperties dialogProperties;
        int i4;
        int i10;
        int i12;
        int i11;
        int i8;
        final Object obj6 = content;
        final int i22 = $changed;
        traceInProgress2 = -1922902937;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(BasicAlertDialog)P(2,1,3)149@6931L384,146@6839L476:AlertDialog.kt#uh7d8r");
        $dirty = $changed;
        if (i7 & 1 != 0) {
            $dirty |= 6;
            obj = onDismissRequest;
        } else {
            if (i22 & 6 == 0) {
                i = restartGroup.changedInstance(onDismissRequest) ? 4 : 2;
                $dirty |= i;
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
                i3 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i3;
            } else {
                str = modifier;
            }
        }
        i5 = i7 & 4;
        if (i5 != 0) {
            $dirty |= 384;
            obj2 = properties;
        } else {
            if (i22 & 384 == 0) {
                i2 = restartGroup.changed(properties) ? 256 : 128;
                $dirty |= i2;
            } else {
                obj2 = properties;
            }
        }
        if (i7 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i22 & 3072 == 0) {
                i13 = restartGroup.changedInstance(obj6) ? 2048 : 1024;
                $dirty |= i13;
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
                if (i5 != 0) {
                    dialogProperties = new DialogProperties(0, 0, 0, 7, 0);
                    i5 = dialogProperties;
                } else {
                    i5 = obj2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i25, -1, "androidx.compose.material3.BasicAlertDialog (AlertDialog.kt:145)");
                }
                AlertDialogKt.BasicAlertDialog.1 anon = new AlertDialogKt.BasicAlertDialog.1($dirty2, obj6);
                AndroidDialog_androidKt.Dialog(obj, i5, (Function2)ComposableLambdaKt.rememberComposableLambda(905289008, true, anon, restartGroup, 54), restartGroup, i15 | i19, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = $dirty2;
                obj3 = i5;
            } else {
                restartGroup.skipToGroupEnd();
                obj4 = str;
                obj3 = obj2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new AlertDialogKt.BasicAlertDialog.2(onDismissRequest, obj4, obj3, obj6, i22, i7);
            endRestartGroup.updateScope((Function2)traceInProgress2);
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
