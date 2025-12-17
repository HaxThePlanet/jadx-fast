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
        int i2;
        boolean changed2;
        int $dirty13;
        float f2;
        int $dirty15;
        int $dirty16;
        Object endRestartGroup;
        int changed6;
        int modifier3;
        int defaultsInvalid;
        Object modifier2;
        int i17;
        int i16;
        int $dirty12;
        int i7;
        float tonalElevation2;
        boolean traceInProgress;
        int iNSTANCE3;
        int iNSTANCE;
        Object obj5;
        Object $composer2;
        int $dirty;
        long $dirty4;
        long l2;
        long l;
        long textContentColor2;
        Object obj8;
        Object obj;
        Object modifier4;
        Object obj6;
        Object obj10;
        Object dismissButton3;
        Object obj4;
        Object dismissButton2;
        Object dismissButton4;
        Object icon2;
        Object i11;
        Object obj2;
        int shape3;
        int shape2;
        int iNSTANCE2;
        long title2;
        int i6;
        Object obj3;
        Object obj7;
        Object icon3;
        long shape4;
        Object title3;
        int i9;
        int i3;
        long l3;
        Object text2;
        Object obj9;
        long l5;
        int i8;
        long i13;
        int i10;
        int i19;
        float f;
        long l4;
        DialogProperties textContentColor3;
        int $dirty1;
        int $dirty14;
        int i20;
        float containerColor3;
        long containerColor2;
        int changed3;
        int i14;
        long iconContentColor2;
        Composer composer;
        int changed4;
        int i5;
        int i15;
        long titleContentColor2;
        int i12;
        int i;
        int i4;
        int changed;
        int $dirty3;
        int $dirty2;
        int changed5;
        ScopeUpdateScope scopeUpdateScope;
        DialogProperties obj33;
        int obj34;
        int obj35;
        int obj36;
        int obj37;
        int obj38;
        i2 = obj50;
        int i22 = obj51;
        i17 = obj52;
        Composer restartGroup = obj49.startRestartGroup(-2081346864);
        ComposerKt.sourceInformation(restartGroup, "C(AlertDialog)P(6!1,5,2,3,11,9,8,1:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color,10:c#ui.graphics.Color,13:c#ui.unit.Dp)62@4918L5,62@4973L14,62@5039L16,62@5108L17,62@5177L16,46@1648L513:AndroidAlertDialog.android.kt#uh7d8r");
        $dirty = obj50;
        int i62 = obj51;
        if (i17 & 1 != 0) {
            $dirty |= 6;
            obj6 = onDismissRequest;
        } else {
            if (i2 & 6 == 0) {
                i6 = restartGroup.changedInstance(onDismissRequest) ? 4 : 2;
                $dirty |= i6;
            } else {
                obj6 = onDismissRequest;
            }
        }
        if (i17 & 2 != 0) {
            $dirty |= 48;
            obj3 = confirmButton;
        } else {
            if (i2 & 48 == 0) {
                i9 = restartGroup.changedInstance(confirmButton) ? 32 : 16;
                $dirty |= i9;
            } else {
                obj3 = confirmButton;
            }
        }
        i3 = i17 & 4;
        if (i3 != 0) {
            $dirty |= 384;
            obj4 = modifier;
        } else {
            if (i2 & 384 == 0) {
                i8 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i8;
            } else {
                obj4 = modifier;
            }
        }
        i13 = i17 & 8;
        int i73 = 1024;
        if (i13 != 0) {
            $dirty |= 3072;
            i11 = dismissButton;
        } else {
            if (i2 & 3072 == 0) {
                i20 = restartGroup.changedInstance(dismissButton) ? i10 : i73;
                $dirty |= i20;
            } else {
                i11 = dismissButton;
            }
        }
        containerColor3 = i17 & 16;
        if (containerColor3 != 0) {
            $dirty |= 24576;
            obj7 = icon;
        } else {
            if (i2 & 24576 == 0) {
                i14 = restartGroup.changedInstance(icon) ? 16384 : 8192;
                $dirty |= i14;
            } else {
                obj7 = icon;
            }
        }
        iconContentColor2 = i17 & 32;
        changed4 = 196608;
        if (iconContentColor2 != 0) {
            $dirty |= changed4;
            title3 = title;
        } else {
            if (i2 & changed4 == 0) {
                i15 = restartGroup.changedInstance(title) ? 131072 : 65536;
                $dirty |= i15;
            } else {
                title3 = title;
            }
        }
        titleContentColor2 = i17 & 64;
        i12 = 1572864;
        if (titleContentColor2 != 0) {
            $dirty |= i12;
            text2 = text;
        } else {
            if (i2 & i12 == 0) {
                i = restartGroup.changedInstance(text) ? 1048576 : 524288;
                $dirty |= i;
            } else {
                text2 = text;
            }
        }
        if (i2 & i78 == 0) {
            if (i17 & 128 == 0) {
                changed = restartGroup.changed(shape) ? 8388608 : 4194304;
            } else {
                obj9 = shape;
            }
            $dirty |= changed;
        } else {
            obj9 = shape;
        }
        if (i2 & i79 == 0) {
            if (i17 & 256 == 0) {
                $dirty2 = $dirty;
                i16 = i62;
                changed5 = restartGroup.changed(containerColor) ? 67108864 : 33554432;
            } else {
                $dirty2 = $dirty;
                i16 = i62;
                $dirty4 = containerColor;
            }
            $dirty2 |= changed5;
        } else {
            $dirty3 = $dirty;
            i16 = i62;
            $dirty4 = containerColor;
        }
        if (i2 & i81 == 0) {
            if (i17 & 512 == 0) {
                i2 = restartGroup.changed(titleContentColor) ? 536870912 : 268435456;
            } else {
                l2 = titleContentColor;
            }
            $dirty3 |= i2;
        } else {
            l2 = titleContentColor;
        }
        if (i22 & 6 == 0) {
            if (i17 & 1024 == 0) {
                $dirty1 = restartGroup.changed(tonalElevation) ? 4 : 2;
            } else {
                l = tonalElevation;
            }
            $dirty13 = i16 | $dirty1;
        } else {
            l = tonalElevation;
            $dirty13 = i16;
        }
        if (i22 & 48 == 0) {
            if (i17 & 2048 == 0) {
                changed3 = restartGroup.changed($composer) ? 32 : 16;
            } else {
                textContentColor2 = $composer;
            }
            $dirty13 |= changed3;
        } else {
            textContentColor2 = $composer;
        }
        int i29 = i17 & 4096;
        if (i29 != 0) {
            $dirty13 |= 384;
        } else {
            if (i22 & 384 == 0) {
                i4 = restartGroup.changed($changed1) ? 256 : 128;
                $dirty1 |= i4;
            } else {
                f2 = $changed1;
            }
            $dirty15 = $dirty1;
        }
        int i30 = i17 & 8192;
        if (i30 != 0) {
            $dirty15 |= 3072;
        } else {
            changed3 = $dirty15;
            if (i22 & 3072 == 0) {
                if (restartGroup.changed(i18)) {
                } else {
                    i10 = i73;
                }
                $dirty16 = i10;
            } else {
                Object obj11 = i18;
                $dirty16 = changed3;
            }
        }
        if ($dirty3 & i72 == 306783378 && $dirty16 & 1171 == 1170) {
            if ($dirty16 & 1171 == 1170) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    tonalElevation2 = -1879048193;
                    int i74 = -234881025;
                    int i76 = -29360129;
                    if (obj50 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i3 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj4;
                            }
                            dismissButton4 = i13 != 0 ? 0 : i11;
                            if (containerColor3 != 0) {
                                obj7 = i11;
                            }
                            if (iconContentColor2 != 0) {
                                title3 = i11;
                            }
                            if (titleContentColor2 != 0) {
                                text2 = i11;
                            }
                            i3 = 6;
                            if (i17 & 128 != 0) {
                                $dirty3 &= i76;
                                obj9 = shape3;
                            }
                            if (i17 & 256 != 0) {
                                containerColor2 = AlertDialogDefaults.INSTANCE.getContainerColor(restartGroup, i3);
                                $dirty3 &= i74;
                            } else {
                                containerColor2 = containerColor;
                            }
                            if (i17 & 512 != 0) {
                                iconContentColor2 = AlertDialogDefaults.INSTANCE.getIconContentColor(restartGroup, i3);
                                $dirty3 &= tonalElevation2;
                            } else {
                                iconContentColor2 = titleContentColor;
                            }
                            if (i17 & 1024 != 0) {
                                titleContentColor2 = AlertDialogDefaults.INSTANCE.getTitleContentColor(restartGroup, i3);
                                $dirty16 &= -15;
                            } else {
                                titleContentColor2 = tonalElevation;
                            }
                            if (i17 & 2048 != 0) {
                                textContentColor2 = AlertDialogDefaults.INSTANCE.getTextContentColor(restartGroup, i3);
                                $dirty16 &= -113;
                            }
                            if (i29 != 0) {
                                tonalElevation2 = AlertDialogDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                            } else {
                                tonalElevation2 = $changed1;
                            }
                            if (i30 != 0) {
                                super(0, 0, 0, 7, 0);
                                changed3 = dialogProperties;
                                obj2 = title3;
                                title3 = l6;
                                containerColor3 = tonalElevation2;
                                l4 = textContentColor2;
                                obj10 = dismissButton4;
                                dismissButton2 = obj7;
                                obj3 = text2;
                                icon3 = obj9;
                                text2 = iconContentColor2;
                                i13 = titleContentColor2;
                                obj = modifier2;
                                modifier3 = $dirty3;
                            } else {
                                l4 = textContentColor2;
                                obj10 = dismissButton4;
                                dismissButton2 = obj7;
                                obj2 = title3;
                                obj3 = text2;
                                icon3 = obj9;
                                title3 = containerColor2;
                                text2 = iconContentColor2;
                                i13 = titleContentColor2;
                                changed3 = i18;
                                obj = modifier2;
                                containerColor3 = tonalElevation2;
                                modifier3 = $dirty3;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i17 & 128 != 0) {
                                $dirty3 &= i76;
                            }
                            if (i17 & 256 != 0) {
                                $dirty3 &= i74;
                            }
                            if (i17 & 512 != 0) {
                                $dirty3 &= tonalElevation2;
                            }
                            if (i17 & 1024 != 0) {
                                $dirty16 &= -15;
                            }
                            if (i17 & 2048 != 0) {
                                $dirty16 &= -113;
                            }
                            i13 = tonalElevation;
                            containerColor3 = $changed1;
                            changed3 = i18;
                            l4 = textContentColor2;
                            obj = obj4;
                            obj10 = i11;
                            dismissButton2 = obj7;
                            obj2 = title3;
                            obj3 = text2;
                            icon3 = obj9;
                            modifier3 = $dirty3;
                            title3 = containerColor;
                            text2 = titleContentColor;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2081346864, modifier3, $dirty16, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                    }
                    AlertDialogKt.AlertDialogImpl-wrnwzgE(onDismissRequest, confirmButton, obj, obj10, dismissButton2, obj2, obj3, icon3, title3, i3, text2, obj9, i13, i19, l4, $dirty14, containerColor3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $dirty3 = modifier3;
                    obj5 = obj;
                    $composer2 = obj10;
                    obj8 = dismissButton2;
                    modifier4 = obj2;
                    dismissButton3 = obj3;
                    icon2 = icon3;
                    title2 = title3;
                    shape4 = text2;
                    l3 = i13;
                    l5 = l4;
                    f = containerColor3;
                    textContentColor3 = changed3;
                    i5 = $dirty16;
                } else {
                    restartGroup.skipToGroupEnd();
                    f = $changed1;
                    textContentColor3 = i18;
                    composer = restartGroup;
                    obj5 = obj4;
                    $composer2 = i11;
                    dismissButton3 = text2;
                    icon2 = obj9;
                    title2 = containerColor;
                    l3 = tonalElevation;
                    l5 = textContentColor2;
                    obj8 = obj7;
                    modifier4 = title3;
                    shape4 = titleContentColor;
                    i5 = $dirty16;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new AndroidAlertDialog_androidKt.AlertDialog.1(onDismissRequest, confirmButton, obj5, $composer2, obj8, modifier4, dismissButton3, icon2, title2, obj3, shape4, title3, l3, text2, l5, i13, f, textContentColor3, obj50, obj51, i17);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }
}
