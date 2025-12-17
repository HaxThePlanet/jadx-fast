package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001aª\u0001\u0010\u0000\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0015\u0008\u0002\u0010\u0008\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\u0008\u00052\u0015\u0008\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\u0008\u00052\u0015\u0008\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\u0008\u00052\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013\u001a\u0093\u0001\u0010\u0000\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0015\u0008\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\u0008\u00052\u0015\u0008\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\u0008\u00052\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0017", d2 = {"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-6oU6zVQ", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "buttons", "AlertDialog-wqdebIU", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidAlertDialog_androidKt {
    public static final void AlertDialog-6oU6zVQ(Function0<Unit> onDismissRequest, Function2<? super Composer, ? super Integer, Unit> confirmButton, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> dismissButton, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> text, Shape shape, long backgroundColor, long contentColor, DialogProperties properties, Composer $composer, int $changed, int i13) {
        int $dirty4;
        int $dirty7;
        Object obj7;
        int skipping;
        int defaultsInvalid;
        int medium;
        int shape2;
        int i7;
        int i10;
        int $dirty;
        boolean traceInProgress;
        int $dirty2;
        long $dirty5;
        long l3;
        int i19;
        boolean traceInProgress2;
        Object obj8;
        int i16;
        int i3;
        int str;
        Object obj3;
        Object obj12;
        Object obj5;
        int i5;
        int i4;
        Object obj6;
        Object i17;
        Object dismissButton2;
        int i15;
        int i8;
        long l4;
        Object obj2;
        int i12;
        int i18;
        long l;
        Object obj;
        int i9;
        Object obj9;
        DialogProperties dialogProperties;
        Object obj4;
        int changed2;
        androidx.compose.runtime.internal.ComposableLambda i;
        int changed;
        int i2;
        int $dirty6;
        Object $dirty3;
        int i6;
        int i11;
        Object contentColor2;
        int surface-0d7_KjU;
        long contentColor3;
        Object obj11;
        long l2;
        long l5;
        Object obj10;
        Composer composer;
        int i14;
        int i20;
        DialogProperties obj31;
        int obj32;
        int obj33;
        int obj34;
        int obj35;
        int obj36;
        int obj41;
        final Object obj14 = confirmButton;
        final int i66 = obj42;
        final int i67 = obj43;
        traceInProgress = i13.startRestartGroup(-606536823);
        ComposerKt.sourceInformation(traceInProgress, "C(AlertDialog)P(5,1,4,3,9,8,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color)70@3471L6,71@3529L6,72@3571L32,77@3743L444,75@3667L735:AndroidAlertDialog.android.kt#jmzs0o");
        $dirty2 = obj42;
        if (i67 & 1 != 0) {
            $dirty2 |= 6;
            obj4 = onDismissRequest;
        } else {
            if (i66 & 6 == 0) {
                i16 = traceInProgress.changedInstance(onDismissRequest) ? 4 : 2;
                $dirty2 |= i16;
            } else {
                obj4 = onDismissRequest;
            }
        }
        if (i67 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i66 & 48 == 0) {
                i3 = traceInProgress.changedInstance(obj14) ? 32 : 16;
                $dirty2 |= i3;
            }
        }
        int i36 = i67 & 4;
        if (i36 != 0) {
            $dirty2 |= 384;
            obj12 = modifier;
        } else {
            if (i66 & 384 == 0) {
                i5 = traceInProgress.changed(modifier) ? 256 : 128;
                $dirty2 |= i5;
            } else {
                obj12 = modifier;
            }
        }
        i4 = i67 & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            i17 = dismissButton;
        } else {
            if (i66 & 3072 == 0) {
                i15 = traceInProgress.changedInstance(dismissButton) ? 2048 : 1024;
                $dirty2 |= i15;
            } else {
                i17 = dismissButton;
            }
        }
        i8 = i67 & 16;
        if (i8 != 0) {
            $dirty2 |= 24576;
            obj2 = title;
        } else {
            if (i66 & 24576 == 0) {
                i12 = traceInProgress.changedInstance(title) ? 16384 : 8192;
                $dirty2 |= i12;
            } else {
                obj2 = title;
            }
        }
        i18 = i67 & 32;
        int i61 = 196608;
        if (i18 != 0) {
            $dirty2 |= i61;
            obj = text;
        } else {
            if (i61 &= i66 == 0) {
                i9 = traceInProgress.changedInstance(text) ? 131072 : 65536;
                $dirty2 |= i9;
            } else {
                obj = text;
            }
        }
        if (i63 &= i66 == 0) {
            if (i67 & 64 == 0) {
                changed2 = traceInProgress.changed(shape) ? 1048576 : 524288;
            } else {
                obj9 = shape;
            }
            $dirty2 |= changed2;
        } else {
            obj9 = shape;
        }
        if (i66 & i68 == 0) {
            if (i67 & 128 == 0) {
                $dirty4 = $dirty2;
                obj41 = i36;
                changed = traceInProgress.changed(backgroundColor) ? 8388608 : 4194304;
            } else {
                $dirty4 = $dirty2;
                obj41 = i36;
                $dirty5 = backgroundColor;
            }
            $dirty4 |= changed;
        } else {
            $dirty7 = $dirty2;
            obj41 = i36;
            $dirty5 = backgroundColor;
        }
        if (i66 & i69 == 0) {
            if (i67 & 256 == 0) {
                i10 = traceInProgress.changed(properties) ? 67108864 : 33554432;
            } else {
                l3 = properties;
            }
            $dirty7 = i2 | i10;
        } else {
            l3 = properties;
            i2 = $dirty7;
        }
        $dirty6 = $dirty7;
        int $dirty8 = i67 & 512;
        int i71 = 805306368;
        if ($dirty8 != 0) {
            $dirty6 |= i71;
            i6 = $dirty8;
            obj7 = $changed;
        } else {
            if (i66 & i71 == 0) {
                i6 = $dirty8;
                i11 = traceInProgress.changed($changed) ? 536870912 : 268435456;
                $dirty6 |= i11;
            } else {
                i6 = $dirty8;
                obj7 = $changed;
            }
        }
        if ($dirty6 & contentColor2 == 306783378) {
            if (!traceInProgress.getSkipping()) {
                traceInProgress.startDefaults();
                i19 = -234881025;
                str = -29360129;
                surface-0d7_KjU = -3670017;
                if (i66 & 1 != 0) {
                    if (traceInProgress.getDefaultsInvalid()) {
                        if (obj41 != null) {
                            obj12 = defaultsInvalid;
                        }
                        if (i4 != 0) {
                            i17 = defaultsInvalid;
                        }
                        if (i8 != 0) {
                            obj2 = defaultsInvalid;
                        }
                        if (i18 != 0) {
                            obj = defaultsInvalid;
                        }
                        i4 = 6;
                        if (i67 & 64 != 0) {
                            $dirty6 &= surface-0d7_KjU;
                            obj9 = medium;
                        }
                        if (i67 & 128 != 0) {
                            $dirty6 &= str;
                            obj41 = i19;
                            i19 = surface-0d7_KjU;
                        } else {
                            obj41 = i19;
                            i19 = backgroundColor;
                        }
                        if (i67 & 256 != 0) {
                            contentColor3 = ColorsKt.contentColorFor-ek8zF_U(i19, str, traceInProgress);
                            $dirty6 &= obj41;
                        } else {
                            contentColor3 = properties;
                        }
                        if (i6 != 0) {
                            super(0, 0, 0, 7, 0);
                            obj10 = dialogProperties2;
                            l2 = i19;
                            i6 = obj2;
                            skipping = $dirty6;
                            l5 = contentColor3;
                            $dirty3 = obj12;
                            contentColor2 = obj;
                            obj11 = obj9;
                        } else {
                            obj10 = $changed;
                            l2 = i19;
                            i6 = obj2;
                            skipping = $dirty6;
                            l5 = contentColor3;
                            $dirty3 = obj12;
                            contentColor2 = obj;
                            obj11 = obj9;
                        }
                    } else {
                        traceInProgress.skipToGroupEnd();
                        if (i67 & 64 != 0) {
                            $dirty6 &= surface-0d7_KjU;
                        }
                        if (i67 & 128 != 0) {
                            $dirty6 &= str;
                        }
                        if (i67 & 256 != 0) {
                            skipping = $dirty6 & i19;
                            l2 = backgroundColor;
                            l5 = properties;
                            obj10 = $changed;
                            $dirty3 = obj12;
                            i6 = obj2;
                            contentColor2 = obj;
                            obj11 = obj9;
                        } else {
                            l2 = backgroundColor;
                            l5 = properties;
                            obj10 = $changed;
                            i6 = obj2;
                            contentColor2 = obj;
                            obj11 = obj9;
                            skipping = $dirty6;
                            $dirty3 = obj12;
                        }
                    }
                } else {
                }
                traceInProgress.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-606536823, skipping, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:74)");
                }
                AndroidAlertDialog_androidKt.AlertDialog.1 anon = new AndroidAlertDialog_androidKt.AlertDialog.1(i17, obj14);
                AndroidAlertDialog_androidKt.AlertDialog-wqdebIU(obj4, (Function2)ComposableLambdaKt.rememberComposableLambda(-1849673151, true, anon, traceInProgress, 54), $dirty3, i6, contentColor2, obj11, l2, obj22, l5, obj24, obj10, traceInProgress);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = i17;
                obj8 = $dirty3;
                obj5 = i6;
                obj6 = contentColor2;
                dismissButton2 = obj11;
                l4 = l2;
                l = l5;
                dialogProperties = obj10;
                $dirty6 = skipping;
            } else {
                traceInProgress.skipToGroupEnd();
                composer = traceInProgress;
                obj8 = obj12;
                obj3 = i17;
                obj5 = obj2;
                obj6 = obj;
                dismissButton2 = obj9;
                l4 = backgroundColor;
                l = properties;
                dialogProperties = $changed;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new AndroidAlertDialog_androidKt.AlertDialog.2(onDismissRequest, obj14, obj8, obj3, obj5, obj6, dismissButton2, l4, obj2, l, obj, dialogProperties, i66, i67);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    public static final void AlertDialog-wqdebIU(Function0<Unit> onDismissRequest, Function2<? super Composer, ? super Integer, Unit> buttons, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> text, Shape shape, long backgroundColor, long contentColor, DialogProperties properties, Composer $composer, int $changed, int i12) {
        int i4;
        Object obj;
        int properties2;
        int defaultsInvalid;
        int medium;
        int shape2;
        int i6;
        int i10;
        int changed2;
        Composer traceInProgress2;
        int $dirty;
        long $dirty3;
        int i2;
        Object obj2;
        int i9;
        boolean traceInProgress;
        Object obj8;
        int i14;
        Object obj6;
        Object obj7;
        int i3;
        int str;
        Object obj5;
        Object dialogProperties;
        Object modifier2;
        int i8;
        int i7;
        long l2;
        Object i5;
        int i15;
        int i16;
        long l;
        Object obj4;
        int i11;
        Object obj3;
        Object shape3;
        int changed;
        long surface-0d7_KjU;
        int changed3;
        Composer composer;
        int i;
        int i13;
        int $dirty2;
        long contentColor2;
        DialogProperties obj23;
        int obj24;
        int obj25;
        int obj26;
        int obj27;
        int obj28;
        long obj29;
        long obj31;
        int obj32;
        final int i44 = obj33;
        final int i45 = obj34;
        traceInProgress2 = i12.startRestartGroup(1035523925);
        ComposerKt.sourceInformation(traceInProgress2, "C(AlertDialog)P(4,1,3,8,7,6,0:c#ui.graphics.Color,2:c#ui.graphics.Color)131@6133L6,132@6191L6,133@6233L32,139@6420L275,136@6329L366:AndroidAlertDialog.android.kt#jmzs0o");
        $dirty = obj33;
        if (i45 & 1 != 0) {
            $dirty |= 6;
            obj2 = onDismissRequest;
        } else {
            if (i44 & 6 == 0) {
                i14 = traceInProgress2.changedInstance(onDismissRequest) ? 4 : 2;
                $dirty |= i14;
            } else {
                obj2 = onDismissRequest;
            }
        }
        if (i45 & 2 != 0) {
            $dirty |= 48;
            obj6 = buttons;
        } else {
            if (i44 & 48 == 0) {
                i3 = traceInProgress2.changedInstance(buttons) ? 32 : 16;
                $dirty |= i3;
            } else {
                obj6 = buttons;
            }
        }
        str = i45 & 4;
        if (str != null) {
            $dirty |= 384;
            dialogProperties = modifier;
        } else {
            if (i44 & 384 == 0) {
                i8 = traceInProgress2.changed(modifier) ? 256 : 128;
                $dirty |= i8;
            } else {
                dialogProperties = modifier;
            }
        }
        i7 = i45 & 8;
        if (i7 != 0) {
            $dirty |= 3072;
            i5 = title;
        } else {
            if (i44 & 3072 == 0) {
                i15 = traceInProgress2.changedInstance(title) ? 2048 : 1024;
                $dirty |= i15;
            } else {
                i5 = title;
            }
        }
        i16 = i45 & 16;
        if (i16 != 0) {
            $dirty |= 24576;
            obj4 = text;
        } else {
            if (i44 & 24576 == 0) {
                i11 = traceInProgress2.changedInstance(text) ? 16384 : 8192;
                $dirty |= i11;
            } else {
                obj4 = text;
            }
        }
        if (i41 &= i44 == 0) {
            if (i45 & 32 == 0) {
                changed = traceInProgress2.changed(shape) ? 131072 : 65536;
            } else {
                obj3 = shape;
            }
            $dirty |= changed;
        } else {
            obj3 = shape;
        }
        if (i46 &= i44 == 0) {
            if (i45 & 64 == 0) {
                changed3 = traceInProgress2.changed(backgroundColor) ? 1048576 : 524288;
            } else {
                surface-0d7_KjU = backgroundColor;
            }
            $dirty |= changed3;
        } else {
            surface-0d7_KjU = backgroundColor;
        }
        if (i44 & i49 == 0) {
            if (i45 & 128 == 0) {
                obj32 = $dirty;
                i10 = traceInProgress2.changed(properties) ? 8388608 : 4194304;
            } else {
                obj32 = $dirty;
                $dirty3 = properties;
            }
            i4 = obj32 | i10;
        } else {
            $dirty3 = properties;
            i4 = obj32;
        }
        obj32 = i4;
        int $dirty4 = i45 & 256;
        int i51 = 100663296;
        if ($dirty4 != 0) {
            $dirty2 = i52;
            i = $dirty4;
            obj = $changed;
        } else {
            if (i44 & i51 == 0) {
                i = $dirty4;
                i13 = traceInProgress2.changed($changed) ? 67108864 : 33554432;
                $dirty2 = obj32 | i13;
            } else {
                i = $dirty4;
                obj = $changed;
                $dirty2 = obj32;
            }
        }
        if ($dirty2 & contentColor2 == 38347922) {
            if (!traceInProgress2.getSkipping()) {
                traceInProgress2.startDefaults();
                int i23 = -29360129;
                i9 = -3670017;
                int i53 = -458753;
                if (i44 & 1 != 0) {
                    if (traceInProgress2.getDefaultsInvalid()) {
                        if (str != null) {
                            dialogProperties = defaultsInvalid;
                        }
                        if (i7 != 0) {
                            i5 = defaultsInvalid;
                        }
                        if (i16 != 0) {
                            obj4 = defaultsInvalid;
                        }
                        str = 6;
                        if (i45 & 32 != 0) {
                            $dirty2 &= i53;
                            obj3 = medium;
                        }
                        if (i45 & 64 != 0) {
                            surface-0d7_KjU = MaterialTheme.INSTANCE.getColors(traceInProgress2, str).getSurface-0d7_KjU();
                            $dirty2 &= i9;
                        }
                        if (i45 & 128 != 0) {
                            contentColor2 = ColorsKt.contentColorFor-ek8zF_U(surface-0d7_KjU, obj15, traceInProgress2);
                            $dirty2 &= i23;
                        } else {
                            contentColor2 = properties;
                        }
                        if (i != 0) {
                            super(0, 0, 0, 7, 0);
                            i2 = $dirty2;
                        } else {
                            properties2 = $changed;
                            i2 = $dirty2;
                        }
                    } else {
                        traceInProgress2.skipToGroupEnd();
                        if (i45 & 32 != 0) {
                            $dirty2 &= i53;
                        }
                        if (i45 & 64 != 0) {
                            $dirty2 &= i9;
                        }
                        if (i45 & 128 != 0) {
                            contentColor2 = properties;
                            i2 = i22;
                            properties2 = $changed;
                        } else {
                            contentColor2 = properties;
                            properties2 = $changed;
                            i2 = $dirty2;
                        }
                    }
                } else {
                }
                traceInProgress2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1035523925, i2, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:135)");
                }
                super(obj6, dialogProperties, i5, obj4, obj3, surface-0d7_KjU, $composer, contentColor2, obj32);
                obj26 = traceInProgress2;
                AndroidDialog_androidKt.Dialog(onDismissRequest, properties2, (Function2)ComposableLambdaKt.rememberComposableLambda(-1787418772, true, anon, traceInProgress2, 54), obj26, i31 |= i35, 0);
                composer = obj26;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty2 = i2;
                obj8 = dialogProperties;
                obj5 = obj4;
                modifier2 = obj3;
                l = contentColor2;
                shape3 = properties2;
                obj7 = i5;
                l2 = surface-0d7_KjU;
            } else {
                traceInProgress2.skipToGroupEnd();
                composer = traceInProgress2;
                obj8 = dialogProperties;
                obj5 = obj4;
                modifier2 = obj3;
                l = properties;
                shape3 = $changed;
                obj7 = i5;
                l2 = surface-0d7_KjU;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            properties2 = new AndroidAlertDialog_androidKt.AlertDialog.4(onDismissRequest, buttons, obj8, obj7, obj5, modifier2, l2, i5, l, obj4, shape3, i44, i45);
            endRestartGroup.updateScope((Function2)properties2);
        }
    }
}
