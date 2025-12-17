package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001aß\u0001\u0010\u0000\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0015\u0008\u0002\u0010\u0008\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\u0008\u00052\u0015\u0008\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\u0008\u00052\u0015\u0008\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\u0008\u00052\u0015\u0008\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\u0008\u00052\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0019", d2 = {"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "iconContentColor", "titleContentColor", "textContentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-Oix01E0", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;III)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidAlertDialog_androidKt {
    public static final void AlertDialog-Oix01E0(Function0<Unit> onDismissRequest, Function2<? super Composer, ? super Integer, Unit> confirmButton, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> dismissButton, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> text, Shape shape, long containerColor, long iconContentColor, long titleContentColor, long textContentColor, float tonalElevation, DialogProperties properties, Composer $composer, int $changed, int $changed1, int i18) {
        int i13;
        boolean changed3;
        int $dirty12;
        float f;
        int $dirty1;
        int $dirty13;
        Object endRestartGroup;
        int changed2;
        int modifier4;
        int defaultsInvalid;
        Object modifier3;
        int i5;
        int i6;
        int $dirty14;
        int i9;
        float tonalElevation2;
        boolean traceInProgress;
        int iNSTANCE2;
        int iNSTANCE3;
        Object obj9;
        Object $composer2;
        int $dirty3;
        long $dirty4;
        long l2;
        long l5;
        long textContentColor2;
        Object obj8;
        Object obj3;
        Object modifier2;
        Object obj2;
        Object obj7;
        Object dismissButton2;
        Object obj10;
        Object dismissButton3;
        Object dismissButton4;
        Object icon3;
        Object i4;
        Object obj6;
        int shape2;
        int shape4;
        int iNSTANCE;
        long title3;
        int i10;
        Object obj5;
        Object obj4;
        Object icon2;
        long shape3;
        Object title2;
        int i11;
        int i12;
        long l;
        Object text2;
        Object obj;
        long l4;
        int i16;
        long i20;
        int i7;
        int i2;
        float f2;
        long l3;
        DialogProperties textContentColor3;
        int $dirty15;
        int $dirty16;
        int i14;
        float containerColor2;
        long containerColor3;
        int changed5;
        int i8;
        long iconContentColor2;
        Composer composer;
        int changed4;
        int i;
        int i3;
        long titleContentColor2;
        int i17;
        int i15;
        int i19;
        int changed;
        int $dirty2;
        int $dirty;
        int changed6;
        ScopeUpdateScope scopeUpdateScope;
        DialogProperties obj33;
        int obj34;
        int obj35;
        int obj36;
        int obj37;
        int obj38;
        i13 = obj50;
        int i22 = obj51;
        i5 = obj52;
        Composer restartGroup = obj49.startRestartGroup(-2081346864);
        ComposerKt.sourceInformation(restartGroup, "C(AlertDialog)P(6!1,5,2,3,11,9,8,1:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color,10:c#ui.graphics.Color,13:c#ui.unit.Dp)62@4918L5,62@4973L14,62@5039L16,62@5108L17,62@5177L16,46@1648L513:AndroidAlertDialog.android.kt#uh7d8r");
        $dirty3 = obj50;
        int i62 = obj51;
        if (i5 & 1 != 0) {
            $dirty3 |= 6;
            obj2 = onDismissRequest;
        } else {
            if (i13 & 6 == 0) {
                i10 = restartGroup.changedInstance(onDismissRequest) ? 4 : 2;
                $dirty3 |= i10;
            } else {
                obj2 = onDismissRequest;
            }
        }
        if (i5 & 2 != 0) {
            $dirty3 |= 48;
            obj5 = confirmButton;
        } else {
            if (i13 & 48 == 0) {
                i11 = restartGroup.changedInstance(confirmButton) ? 32 : 16;
                $dirty3 |= i11;
            } else {
                obj5 = confirmButton;
            }
        }
        i12 = i5 & 4;
        if (i12 != 0) {
            $dirty3 |= 384;
            obj10 = modifier;
        } else {
            if (i13 & 384 == 0) {
                i16 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty3 |= i16;
            } else {
                obj10 = modifier;
            }
        }
        i20 = i5 & 8;
        int i73 = 1024;
        if (i20 != 0) {
            $dirty3 |= 3072;
            i4 = dismissButton;
        } else {
            if (i13 & 3072 == 0) {
                i14 = restartGroup.changedInstance(dismissButton) ? i7 : i73;
                $dirty3 |= i14;
            } else {
                i4 = dismissButton;
            }
        }
        containerColor2 = i5 & 16;
        if (containerColor2 != 0) {
            $dirty3 |= 24576;
            obj4 = icon;
        } else {
            if (i13 & 24576 == 0) {
                i8 = restartGroup.changedInstance(icon) ? 16384 : 8192;
                $dirty3 |= i8;
            } else {
                obj4 = icon;
            }
        }
        iconContentColor2 = i5 & 32;
        changed4 = 196608;
        if (iconContentColor2 != 0) {
            $dirty3 |= changed4;
            title2 = title;
        } else {
            if (i13 & changed4 == 0) {
                i3 = restartGroup.changedInstance(title) ? 131072 : 65536;
                $dirty3 |= i3;
            } else {
                title2 = title;
            }
        }
        titleContentColor2 = i5 & 64;
        i17 = 1572864;
        if (titleContentColor2 != 0) {
            $dirty3 |= i17;
            text2 = text;
        } else {
            if (i13 & i17 == 0) {
                i15 = restartGroup.changedInstance(text) ? 1048576 : 524288;
                $dirty3 |= i15;
            } else {
                text2 = text;
            }
        }
        if (i13 & i78 == 0) {
            if (i5 & 128 == 0) {
                changed = restartGroup.changed(shape) ? 8388608 : 4194304;
            } else {
                obj = shape;
            }
            $dirty3 |= changed;
        } else {
            obj = shape;
        }
        if (i13 & i79 == 0) {
            if (i5 & 256 == 0) {
                $dirty = $dirty3;
                i6 = i62;
                changed6 = restartGroup.changed(containerColor) ? 67108864 : 33554432;
            } else {
                $dirty = $dirty3;
                i6 = i62;
                $dirty4 = containerColor;
            }
            $dirty |= changed6;
        } else {
            $dirty2 = $dirty3;
            i6 = i62;
            $dirty4 = containerColor;
        }
        if (i13 & i81 == 0) {
            if (i5 & 512 == 0) {
                i13 = restartGroup.changed(titleContentColor) ? 536870912 : 268435456;
            } else {
                l2 = titleContentColor;
            }
            $dirty2 |= i13;
        } else {
            l2 = titleContentColor;
        }
        if (i22 & 6 == 0) {
            if (i5 & 1024 == 0) {
                $dirty15 = restartGroup.changed(tonalElevation) ? 4 : 2;
            } else {
                l5 = tonalElevation;
            }
            $dirty12 = i6 | $dirty15;
        } else {
            l5 = tonalElevation;
            $dirty12 = i6;
        }
        if (i22 & 48 == 0) {
            if (i5 & 2048 == 0) {
                changed5 = restartGroup.changed($composer) ? 32 : 16;
            } else {
                textContentColor2 = $composer;
            }
            $dirty12 |= changed5;
        } else {
            textContentColor2 = $composer;
        }
        int i29 = i5 & 4096;
        if (i29 != 0) {
            $dirty12 |= 384;
        } else {
            if (i22 & 384 == 0) {
                i19 = restartGroup.changed($changed1) ? 256 : 128;
                $dirty15 |= i19;
            } else {
                f = $changed1;
            }
            $dirty1 = $dirty15;
        }
        int i30 = i5 & 8192;
        if (i30 != 0) {
            $dirty1 |= 3072;
        } else {
            changed5 = $dirty1;
            if (i22 & 3072 == 0) {
                if (restartGroup.changed(i18)) {
                } else {
                    i7 = i73;
                }
                $dirty13 = i7;
            } else {
                Object obj11 = i18;
                $dirty13 = changed5;
            }
        }
        if ($dirty2 & i72 == 306783378 && $dirty13 & 1171 == 1170) {
            if ($dirty13 & 1171 == 1170) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    tonalElevation2 = -1879048193;
                    int i74 = -234881025;
                    int i76 = -29360129;
                    if (obj50 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = obj10;
                            }
                            dismissButton4 = i20 != 0 ? 0 : i4;
                            if (containerColor2 != 0) {
                                obj4 = i4;
                            }
                            if (iconContentColor2 != 0) {
                                title2 = i4;
                            }
                            if (titleContentColor2 != 0) {
                                text2 = i4;
                            }
                            i12 = 6;
                            if (i5 & 128 != 0) {
                                $dirty2 &= i76;
                                obj = shape2;
                            }
                            if (i5 & 256 != 0) {
                                containerColor3 = AlertDialogDefaults.INSTANCE.getContainerColor(restartGroup, i12);
                                $dirty2 &= i74;
                            } else {
                                containerColor3 = containerColor;
                            }
                            if (i5 & 512 != 0) {
                                iconContentColor2 = AlertDialogDefaults.INSTANCE.getIconContentColor(restartGroup, i12);
                                $dirty2 &= tonalElevation2;
                            } else {
                                iconContentColor2 = titleContentColor;
                            }
                            if (i5 & 1024 != 0) {
                                titleContentColor2 = AlertDialogDefaults.INSTANCE.getTitleContentColor(restartGroup, i12);
                                $dirty13 &= -15;
                            } else {
                                titleContentColor2 = tonalElevation;
                            }
                            if (i5 & 2048 != 0) {
                                textContentColor2 = AlertDialogDefaults.INSTANCE.getTextContentColor(restartGroup, i12);
                                $dirty13 &= -113;
                            }
                            if (i29 != 0) {
                                tonalElevation2 = AlertDialogDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                            } else {
                                tonalElevation2 = $changed1;
                            }
                            if (i30 != 0) {
                                super(0, 0, 0, 7, 0);
                                changed5 = dialogProperties;
                                obj6 = title2;
                                title2 = l6;
                                containerColor2 = tonalElevation2;
                                l3 = textContentColor2;
                                obj7 = dismissButton4;
                                dismissButton3 = obj4;
                                obj5 = text2;
                                icon2 = obj;
                                text2 = iconContentColor2;
                                i20 = titleContentColor2;
                                obj3 = modifier3;
                                modifier4 = $dirty2;
                            } else {
                                l3 = textContentColor2;
                                obj7 = dismissButton4;
                                dismissButton3 = obj4;
                                obj6 = title2;
                                obj5 = text2;
                                icon2 = obj;
                                title2 = containerColor3;
                                text2 = iconContentColor2;
                                i20 = titleContentColor2;
                                changed5 = i18;
                                obj3 = modifier3;
                                containerColor2 = tonalElevation2;
                                modifier4 = $dirty2;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i5 & 128 != 0) {
                                $dirty2 &= i76;
                            }
                            if (i5 & 256 != 0) {
                                $dirty2 &= i74;
                            }
                            if (i5 & 512 != 0) {
                                $dirty2 &= tonalElevation2;
                            }
                            if (i5 & 1024 != 0) {
                                $dirty13 &= -15;
                            }
                            if (i5 & 2048 != 0) {
                                $dirty13 &= -113;
                            }
                            i20 = tonalElevation;
                            containerColor2 = $changed1;
                            changed5 = i18;
                            l3 = textContentColor2;
                            obj3 = obj10;
                            obj7 = i4;
                            dismissButton3 = obj4;
                            obj6 = title2;
                            obj5 = text2;
                            icon2 = obj;
                            modifier4 = $dirty2;
                            title2 = containerColor;
                            text2 = titleContentColor;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2081346864, modifier4, $dirty13, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                    }
                    AlertDialogKt.AlertDialogImpl-wrnwzgE(onDismissRequest, confirmButton, obj3, obj7, dismissButton3, obj6, obj5, icon2, title2, i12, text2, obj, i20, i2, l3, $dirty16, containerColor2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $dirty2 = modifier4;
                    obj9 = obj3;
                    $composer2 = obj7;
                    obj8 = dismissButton3;
                    modifier2 = obj6;
                    dismissButton2 = obj5;
                    icon3 = icon2;
                    title3 = title2;
                    shape3 = text2;
                    l = i20;
                    l4 = l3;
                    f2 = containerColor2;
                    textContentColor3 = changed5;
                    i = $dirty13;
                } else {
                    restartGroup.skipToGroupEnd();
                    f2 = $changed1;
                    textContentColor3 = i18;
                    composer = restartGroup;
                    obj9 = obj10;
                    $composer2 = i4;
                    dismissButton2 = text2;
                    icon3 = obj;
                    title3 = containerColor;
                    l = tonalElevation;
                    l4 = textContentColor2;
                    obj8 = obj4;
                    modifier2 = title2;
                    shape3 = titleContentColor;
                    i = $dirty13;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new AndroidAlertDialog_androidKt.AlertDialog.1(onDismissRequest, confirmButton, obj9, $composer2, obj8, modifier2, dismissButton2, icon3, title3, obj5, shape3, title2, l, text2, l4, i20, f2, textContentColor3, obj50, obj51, i5);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }
}
