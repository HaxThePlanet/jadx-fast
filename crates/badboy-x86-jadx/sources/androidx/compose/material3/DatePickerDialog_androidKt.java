package androidx.compose.material3;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u009a\u0001\u0010\u0006\u001a\u00020\u00072\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00070\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\u0008\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0015\u0008\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0002\u0008\u000b2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00070\u0017¢\u0006\u0002\u0008\u000b¢\u0006\u0002\u0008\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001b\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001c", d2 = {"DialogButtonsCrossAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "DialogButtonsMainAxisSpacing", "DialogButtonsPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "shape", "Landroidx/compose/ui/graphics/Shape;", "tonalElevation", "colors", "Landroidx/compose/material3/DatePickerColors;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DatePickerDialog-GmEhDVc", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DatePickerDialog_androidKt {

    private static final float DialogButtonsCrossAxisSpacing;
    private static final float DialogButtonsMainAxisSpacing;
    private static final PaddingValues DialogButtonsPadding;
    static {
        int i4 = 0;
        int i5 = 0;
        DatePickerDialog_androidKt.DialogButtonsPadding = PaddingKt.PaddingValues-a9UjIt4$default(0, 0, Dp.constructor-impl((float)$this$dp$iv), Dp.constructor-impl((float)i), 3, 0);
        int i6 = 0;
        DatePickerDialog_androidKt.DialogButtonsMainAxisSpacing = Dp.constructor-impl((float)i2);
        int i7 = 0;
        DatePickerDialog_androidKt.DialogButtonsCrossAxisSpacing = Dp.constructor-impl((float)i3);
    }

    public static final void DatePickerDialog-GmEhDVc(Function0<Unit> onDismissRequest, Function2<? super Composer, ? super Integer, Unit> confirmButton, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> dismissButton, Shape shape, float tonalElevation, androidx.compose.material3.DatePickerColors colors, DialogProperties properties, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i12) {
        Object obj11;
        Object obj6;
        boolean $dirty;
        int defaultsInvalid;
        int tonalElevation-D9Ej5fM;
        int colors2;
        int $dirty3;
        int $dirty2;
        int $dirty6;
        boolean traceInProgress;
        Object obj2;
        int i6;
        Object obj5;
        Object properties2;
        Object obj10;
        int i15;
        Object obj4;
        int str;
        Object $composer2;
        Object obj3;
        float f2;
        int i2;
        Object obj7;
        int $dirty4;
        Object obj;
        Object $dirty5;
        int dismissButton2;
        int i16;
        Object obj8;
        int changed2;
        Composer composer;
        float f;
        int shape2;
        Object tonalElevation2;
        int i7;
        Object obj12;
        int changed;
        int i11;
        int i9;
        int i;
        int i13;
        int i3;
        int i5;
        int i10;
        int i4;
        int i14;
        int i8;
        Object obj9;
        final int i43 = $changed;
        final int i44 = i12;
        Composer restartGroup = $composer.startRestartGroup(-36517340);
        ComposerKt.sourceInformation(restartGroup, "C(DatePickerDialog)P(5,1,4,3,7,8:c#ui.unit.Dp!1,6)71@3518L5,73@3635L8,81@3937L1615,77@3787L1765:DatePickerDialog.android.kt#uh7d8r");
        $dirty2 = $changed;
        if (i44 & 1 != 0) {
            $dirty2 |= 6;
            obj2 = onDismissRequest;
        } else {
            if (i43 & 6 == 0) {
                i6 = restartGroup.changedInstance(onDismissRequest) ? 4 : 2;
                $dirty2 |= i6;
            } else {
                obj2 = onDismissRequest;
            }
        }
        if (i44 & 2 != 0) {
            $dirty2 |= 48;
            obj5 = confirmButton;
        } else {
            if (i43 & 48 == 0) {
                i15 = restartGroup.changedInstance(confirmButton) ? 32 : 16;
                $dirty2 |= i15;
            } else {
                obj5 = confirmButton;
            }
        }
        int i27 = i44 & 4;
        if (i27 != 0) {
            $dirty2 |= 384;
            obj3 = modifier;
        } else {
            if (i43 & 384 == 0) {
                i2 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i2;
            } else {
                obj3 = modifier;
            }
        }
        $dirty4 = i44 & 8;
        if ($dirty4 != 0) {
            $dirty2 |= 3072;
            obj = dismissButton;
        } else {
            if (i43 & 3072 == 0) {
                i16 = restartGroup.changedInstance(dismissButton) ? 2048 : 1024;
                $dirty2 |= i16;
            } else {
                obj = dismissButton;
            }
        }
        if (i43 & 24576 == 0) {
            if (i44 & 16 == 0) {
                changed2 = restartGroup.changed(shape) ? 16384 : 8192;
            } else {
                obj8 = shape;
            }
            $dirty2 |= changed2;
        } else {
            obj8 = shape;
        }
        int i45 = i44 & 32;
        int i46 = 196608;
        if (i45 != 0) {
            $dirty2 |= i46;
            f = tonalElevation;
        } else {
            if (i46 &= i43 == 0) {
                i7 = restartGroup.changed(tonalElevation) ? 131072 : 65536;
                $dirty2 |= i7;
            } else {
                f = tonalElevation;
            }
        }
        if (i48 &= i43 == 0) {
            if (i44 & 64 == 0) {
                changed = restartGroup.changed(colors) ? 1048576 : 524288;
            } else {
                obj12 = colors;
            }
            $dirty2 |= changed;
        } else {
            obj12 = colors;
        }
        i11 = i44 & 128;
        i9 = 12582912;
        if (i11 != 0) {
            $dirty2 |= i9;
            obj11 = properties;
        } else {
            if (i43 & i9 == 0) {
                i = restartGroup.changed(properties) ? 8388608 : 4194304;
                $dirty2 |= i;
            } else {
                obj11 = properties;
            }
        }
        i13 = 100663296;
        if (i44 & 256 != 0) {
            $dirty2 |= i13;
            obj6 = content;
        } else {
            if (i43 & i13 == 0) {
                i13 = restartGroup.changedInstance(content) ? 67108864 : 33554432;
                $dirty2 |= i13;
            } else {
                obj6 = content;
            }
        }
        final int obj33 = $dirty2;
        if ($dirty2 & i3 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i21 = -3670017;
                int i51 = -57345;
                if (i43 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i27 != 0) {
                            obj3 = defaultsInvalid;
                        }
                        if ($dirty4 != 0) {
                            obj = defaultsInvalid;
                        }
                        str = 6;
                        if (i44 & 16 != 0) {
                            $dirty4 = obj33 & i51;
                            obj8 = tonalElevation-D9Ej5fM;
                        } else {
                            $dirty4 = obj33;
                        }
                        if (i45 != 0) {
                            f = tonalElevation-D9Ej5fM;
                        }
                        if (i44 & 64 != 0) {
                            $dirty4 &= i21;
                            obj12 = colors2;
                        }
                        if (i11 != 0) {
                            DialogProperties dialogProperties = new DialogProperties(0, 0, 0, 3, 0);
                            $dirty = obj3;
                            i11 = f;
                            obj10 = dialogProperties;
                            i3 = obj;
                            tonalElevation2 = obj8;
                            dismissButton2 = $dirty4;
                        } else {
                            obj10 = properties;
                            $dirty = obj3;
                            i3 = obj;
                            i11 = f;
                            dismissButton2 = $dirty4;
                            tonalElevation2 = obj8;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty3 = i44 & 16 != 0 ? obj33 & i51 : obj33;
                        if (i44 & 64 != 0) {
                            $dirty3 &= i21;
                        }
                        obj10 = properties;
                        i3 = obj;
                        i11 = f;
                        dismissButton2 = $dirty3;
                        $dirty = obj3;
                        tonalElevation2 = obj8;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-36517340, dismissButton2, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:76)");
                }
                int i31 = 0;
                DatePickerDialog_androidKt.DatePickerDialog.1 anon = new DatePickerDialog_androidKt.DatePickerDialog.1(tonalElevation2, obj12, i11, content, i3, confirmButton);
                AlertDialogKt.BasicAlertDialog(obj2, SizeKt.wrapContentHeight$default($dirty, i31, false, 3, i31), obj10, (Function2)ComposableLambdaKt.rememberComposableLambda(-10625622, true, anon, restartGroup, 54), restartGroup, i34 |= i38, 0);
                composer = restartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = tonalElevation2;
                f2 = i11;
                obj4 = i3;
                shape2 = dismissButton2;
                $dirty5 = obj10;
                properties2 = $dirty;
                obj7 = obj12;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                properties2 = obj3;
                obj4 = obj;
                $composer2 = obj8;
                f2 = f;
                $dirty5 = properties;
                shape2 = obj33;
                obj7 = obj12;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = new DatePickerDialog_androidKt.DatePickerDialog.2(onDismissRequest, confirmButton, properties2, obj4, $composer2, f2, obj7, $dirty5, content, i43, i44);
            endRestartGroup.updateScope((Function2)$dirty);
        }
    }

    public static final float access$getDialogButtonsCrossAxisSpacing$p() {
        return DatePickerDialog_androidKt.DialogButtonsCrossAxisSpacing;
    }

    public static final float access$getDialogButtonsMainAxisSpacing$p() {
        return DatePickerDialog_androidKt.DialogButtonsMainAxisSpacing;
    }

    public static final PaddingValues access$getDialogButtonsPadding$p() {
        return DatePickerDialog_androidKt.DialogButtonsPadding;
    }
}
