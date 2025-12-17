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
        int i14;
        boolean changed5;
        int $dirty13;
        float f2;
        int $dirty14;
        int $dirty16;
        Object endRestartGroup;
        int changed2;
        int modifier4;
        int defaultsInvalid;
        Object modifier3;
        int i6;
        int i19;
        int $dirty15;
        int i11;
        float tonalElevation2;
        boolean traceInProgress;
        int iNSTANCE2;
        int iNSTANCE3;
        Object obj6;
        Object $composer2;
        int $dirty3;
        long $dirty;
        long l3;
        long l4;
        long textContentColor2;
        Object obj8;
        Object obj;
        Object modifier2;
        Object obj4;
        Object obj9;
        Object dismissButton3;
        Object obj7;
        Object dismissButton2;
        Object dismissButton4;
        Object icon2;
        Object i;
        Object obj3;
        int shape3;
        int shape4;
        int iNSTANCE;
        long title2;
        int i7;
        Object obj2;
        Object obj10;
        Object icon3;
        long shape2;
        Object title3;
        int i20;
        int i4;
        long l2;
        Object text2;
        Object obj5;
        long l;
        int i8;
        long i13;
        int i15;
        int i10;
        float f;
        long l5;
        DialogProperties textContentColor3;
        int $dirty12;
        int $dirty1;
        int i9;
        float containerColor3;
        long containerColor2;
        int changed;
        int i16;
        long iconContentColor2;
        Composer composer;
        int changed6;
        int i12;
        int i2;
        long titleContentColor2;
        int i3;
        int i5;
        int i17;
        int changed3;
        int $dirty4;
        int $dirty2;
        int changed4;
        ScopeUpdateScope scopeUpdateScope;
        DialogProperties obj33;
        int obj34;
        int obj35;
        int obj36;
        int obj37;
        int obj38;
        i14 = obj50;
        int i22 = obj51;
        i6 = obj52;
        Composer restartGroup = obj49.startRestartGroup(-2081346864);
        ComposerKt.sourceInformation(restartGroup, "C(AlertDialog)P(6!1,5,2,3,11,9,8,1:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color,10:c#ui.graphics.Color,13:c#ui.unit.Dp)62@4918L5,62@4973L14,62@5039L16,62@5108L17,62@5177L16,46@1648L513:AndroidAlertDialog.android.kt#uh7d8r");
        $dirty3 = obj50;
        int i62 = obj51;
        if (i6 & 1 != 0) {
            $dirty3 |= 6;
            obj4 = onDismissRequest;
        } else {
            if (i14 & 6 == 0) {
                i7 = restartGroup.changedInstance(onDismissRequest) ? 4 : 2;
                $dirty3 |= i7;
            } else {
                obj4 = onDismissRequest;
            }
        }
        if (i6 & 2 != 0) {
            $dirty3 |= 48;
            obj2 = confirmButton;
        } else {
            if (i14 & 48 == 0) {
                i20 = restartGroup.changedInstance(confirmButton) ? 32 : 16;
                $dirty3 |= i20;
            } else {
                obj2 = confirmButton;
            }
        }
        i4 = i6 & 4;
        if (i4 != 0) {
            $dirty3 |= 384;
            obj7 = modifier;
        } else {
            if (i14 & 384 == 0) {
                i8 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty3 |= i8;
            } else {
                obj7 = modifier;
            }
        }
        i13 = i6 & 8;
        int i73 = 1024;
        if (i13 != 0) {
            $dirty3 |= 3072;
            i = dismissButton;
        } else {
            if (i14 & 3072 == 0) {
                i9 = restartGroup.changedInstance(dismissButton) ? i15 : i73;
                $dirty3 |= i9;
            } else {
                i = dismissButton;
            }
        }
        containerColor3 = i6 & 16;
        if (containerColor3 != 0) {
            $dirty3 |= 24576;
            obj10 = icon;
        } else {
            if (i14 & 24576 == 0) {
                i16 = restartGroup.changedInstance(icon) ? 16384 : 8192;
                $dirty3 |= i16;
            } else {
                obj10 = icon;
            }
        }
        iconContentColor2 = i6 & 32;
        changed6 = 196608;
        if (iconContentColor2 != 0) {
            $dirty3 |= changed6;
            title3 = title;
        } else {
            if (i14 & changed6 == 0) {
                i2 = restartGroup.changedInstance(title) ? 131072 : 65536;
                $dirty3 |= i2;
            } else {
                title3 = title;
            }
        }
        titleContentColor2 = i6 & 64;
        i3 = 1572864;
        if (titleContentColor2 != 0) {
            $dirty3 |= i3;
            text2 = text;
        } else {
            if (i14 & i3 == 0) {
                i5 = restartGroup.changedInstance(text) ? 1048576 : 524288;
                $dirty3 |= i5;
            } else {
                text2 = text;
            }
        }
        if (i14 & i78 == 0) {
            if (i6 & 128 == 0) {
                changed3 = restartGroup.changed(shape) ? 8388608 : 4194304;
            } else {
                obj5 = shape;
            }
            $dirty3 |= changed3;
        } else {
            obj5 = shape;
        }
        if (i14 & i79 == 0) {
            if (i6 & 256 == 0) {
                $dirty2 = $dirty3;
                i19 = i62;
                changed4 = restartGroup.changed(containerColor) ? 67108864 : 33554432;
            } else {
                $dirty2 = $dirty3;
                i19 = i62;
                $dirty = containerColor;
            }
            $dirty2 |= changed4;
        } else {
            $dirty4 = $dirty3;
            i19 = i62;
            $dirty = containerColor;
        }
        if (i14 & i81 == 0) {
            if (i6 & 512 == 0) {
                i14 = restartGroup.changed(titleContentColor) ? 536870912 : 268435456;
            } else {
                l3 = titleContentColor;
            }
            $dirty4 |= i14;
        } else {
            l3 = titleContentColor;
        }
        if (i22 & 6 == 0) {
            if (i6 & 1024 == 0) {
                $dirty12 = restartGroup.changed(tonalElevation) ? 4 : 2;
            } else {
                l4 = tonalElevation;
            }
            $dirty13 = i19 | $dirty12;
        } else {
            l4 = tonalElevation;
            $dirty13 = i19;
        }
        if (i22 & 48 == 0) {
            if (i6 & 2048 == 0) {
                changed = restartGroup.changed($composer) ? 32 : 16;
            } else {
                textContentColor2 = $composer;
            }
            $dirty13 |= changed;
        } else {
            textContentColor2 = $composer;
        }
        int i29 = i6 & 4096;
        if (i29 != 0) {
            $dirty13 |= 384;
        } else {
            if (i22 & 384 == 0) {
                i17 = restartGroup.changed($changed1) ? 256 : 128;
                $dirty12 |= i17;
            } else {
                f2 = $changed1;
            }
            $dirty14 = $dirty12;
        }
        int i30 = i6 & 8192;
        if (i30 != 0) {
            $dirty14 |= 3072;
        } else {
            changed = $dirty14;
            if (i22 & 3072 == 0) {
                if (restartGroup.changed(i18)) {
                } else {
                    i15 = i73;
                }
                $dirty16 = i15;
            } else {
                Object obj11 = i18;
                $dirty16 = changed;
            }
        }
        if ($dirty4 & i72 == 306783378 && $dirty16 & 1171 == 1170) {
            if ($dirty16 & 1171 == 1170) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    tonalElevation2 = -1879048193;
                    int i74 = -234881025;
                    int i76 = -29360129;
                    if (obj50 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i4 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = obj7;
                            }
                            dismissButton4 = i13 != 0 ? 0 : i;
                            if (containerColor3 != 0) {
                                obj10 = i;
                            }
                            if (iconContentColor2 != 0) {
                                title3 = i;
                            }
                            if (titleContentColor2 != 0) {
                                text2 = i;
                            }
                            i4 = 6;
                            if (i6 & 128 != 0) {
                                $dirty4 &= i76;
                                obj5 = shape3;
                            }
                            if (i6 & 256 != 0) {
                                containerColor2 = AlertDialogDefaults.INSTANCE.getContainerColor(restartGroup, i4);
                                $dirty4 &= i74;
                            } else {
                                containerColor2 = containerColor;
                            }
                            if (i6 & 512 != 0) {
                                iconContentColor2 = AlertDialogDefaults.INSTANCE.getIconContentColor(restartGroup, i4);
                                $dirty4 &= tonalElevation2;
                            } else {
                                iconContentColor2 = titleContentColor;
                            }
                            if (i6 & 1024 != 0) {
                                titleContentColor2 = AlertDialogDefaults.INSTANCE.getTitleContentColor(restartGroup, i4);
                                $dirty16 &= -15;
                            } else {
                                titleContentColor2 = tonalElevation;
                            }
                            if (i6 & 2048 != 0) {
                                textContentColor2 = AlertDialogDefaults.INSTANCE.getTextContentColor(restartGroup, i4);
                                $dirty16 &= -113;
                            }
                            if (i29 != 0) {
                                tonalElevation2 = AlertDialogDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                            } else {
                                tonalElevation2 = $changed1;
                            }
                            if (i30 != 0) {
                                super(0, 0, 0, 7, 0);
                                changed = dialogProperties;
                                obj3 = title3;
                                title3 = l6;
                                containerColor3 = tonalElevation2;
                                l5 = textContentColor2;
                                obj9 = dismissButton4;
                                dismissButton2 = obj10;
                                obj2 = text2;
                                icon3 = obj5;
                                text2 = iconContentColor2;
                                i13 = titleContentColor2;
                                obj = modifier3;
                                modifier4 = $dirty4;
                            } else {
                                l5 = textContentColor2;
                                obj9 = dismissButton4;
                                dismissButton2 = obj10;
                                obj3 = title3;
                                obj2 = text2;
                                icon3 = obj5;
                                title3 = containerColor2;
                                text2 = iconContentColor2;
                                i13 = titleContentColor2;
                                changed = i18;
                                obj = modifier3;
                                containerColor3 = tonalElevation2;
                                modifier4 = $dirty4;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i6 & 128 != 0) {
                                $dirty4 &= i76;
                            }
                            if (i6 & 256 != 0) {
                                $dirty4 &= i74;
                            }
                            if (i6 & 512 != 0) {
                                $dirty4 &= tonalElevation2;
                            }
                            if (i6 & 1024 != 0) {
                                $dirty16 &= -15;
                            }
                            if (i6 & 2048 != 0) {
                                $dirty16 &= -113;
                            }
                            i13 = tonalElevation;
                            containerColor3 = $changed1;
                            changed = i18;
                            l5 = textContentColor2;
                            obj = obj7;
                            obj9 = i;
                            dismissButton2 = obj10;
                            obj3 = title3;
                            obj2 = text2;
                            icon3 = obj5;
                            modifier4 = $dirty4;
                            title3 = containerColor;
                            text2 = titleContentColor;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2081346864, modifier4, $dirty16, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                    }
                    AlertDialogKt.AlertDialogImpl-wrnwzgE(onDismissRequest, confirmButton, obj, obj9, dismissButton2, obj3, obj2, icon3, title3, i4, text2, obj5, i13, i10, l5, $dirty1, containerColor3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $dirty4 = modifier4;
                    obj6 = obj;
                    $composer2 = obj9;
                    obj8 = dismissButton2;
                    modifier2 = obj3;
                    dismissButton3 = obj2;
                    icon2 = icon3;
                    title2 = title3;
                    shape2 = text2;
                    l2 = i13;
                    l = l5;
                    f = containerColor3;
                    textContentColor3 = changed;
                    i12 = $dirty16;
                } else {
                    restartGroup.skipToGroupEnd();
                    f = $changed1;
                    textContentColor3 = i18;
                    composer = restartGroup;
                    obj6 = obj7;
                    $composer2 = i;
                    dismissButton3 = text2;
                    icon2 = obj5;
                    title2 = containerColor;
                    l2 = tonalElevation;
                    l = textContentColor2;
                    obj8 = obj10;
                    modifier2 = title3;
                    shape2 = titleContentColor;
                    i12 = $dirty16;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new AndroidAlertDialog_androidKt.AlertDialog.1(onDismissRequest, confirmButton, obj6, $composer2, obj8, modifier2, dismissButton3, icon2, title2, obj2, shape2, title3, l2, text2, l, i13, f, textContentColor3, obj50, obj51, i6);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }
}
