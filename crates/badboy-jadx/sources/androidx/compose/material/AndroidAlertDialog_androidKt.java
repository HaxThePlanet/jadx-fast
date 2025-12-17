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
        int $dirty3;
        int $dirty6;
        Object obj12;
        int skipping;
        int defaultsInvalid;
        int medium;
        int shape2;
        int i18;
        int i6;
        int $dirty7;
        boolean traceInProgress;
        int $dirty4;
        long $dirty5;
        long l2;
        int i10;
        boolean traceInProgress2;
        Object obj4;
        int i15;
        int i2;
        int str;
        Object obj7;
        Object obj8;
        Object obj6;
        int i17;
        int i16;
        Object obj9;
        Object i7;
        Object dismissButton2;
        int i14;
        int i19;
        long l3;
        Object obj10;
        int i8;
        int i3;
        long l;
        Object obj;
        int i12;
        Object obj2;
        DialogProperties dialogProperties;
        Object obj11;
        int changed2;
        androidx.compose.runtime.internal.ComposableLambda i4;
        int changed;
        int i;
        int $dirty;
        Object $dirty2;
        int i9;
        int i5;
        Object contentColor3;
        int surface-0d7_KjU;
        long contentColor2;
        Object obj5;
        long l5;
        long l4;
        Object obj3;
        Composer composer;
        int i11;
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
        $dirty4 = obj42;
        if (i67 & 1 != 0) {
            $dirty4 |= 6;
            obj11 = onDismissRequest;
        } else {
            if (i66 & 6 == 0) {
                i15 = traceInProgress.changedInstance(onDismissRequest) ? 4 : 2;
                $dirty4 |= i15;
            } else {
                obj11 = onDismissRequest;
            }
        }
        if (i67 & 2 != 0) {
            $dirty4 |= 48;
        } else {
            if (i66 & 48 == 0) {
                i2 = traceInProgress.changedInstance(obj14) ? 32 : 16;
                $dirty4 |= i2;
            }
        }
        int i36 = i67 & 4;
        if (i36 != 0) {
            $dirty4 |= 384;
            obj8 = modifier;
        } else {
            if (i66 & 384 == 0) {
                i17 = traceInProgress.changed(modifier) ? 256 : 128;
                $dirty4 |= i17;
            } else {
                obj8 = modifier;
            }
        }
        i16 = i67 & 8;
        if (i16 != 0) {
            $dirty4 |= 3072;
            i7 = dismissButton;
        } else {
            if (i66 & 3072 == 0) {
                i14 = traceInProgress.changedInstance(dismissButton) ? 2048 : 1024;
                $dirty4 |= i14;
            } else {
                i7 = dismissButton;
            }
        }
        i19 = i67 & 16;
        if (i19 != 0) {
            $dirty4 |= 24576;
            obj10 = title;
        } else {
            if (i66 & 24576 == 0) {
                i8 = traceInProgress.changedInstance(title) ? 16384 : 8192;
                $dirty4 |= i8;
            } else {
                obj10 = title;
            }
        }
        i3 = i67 & 32;
        int i61 = 196608;
        if (i3 != 0) {
            $dirty4 |= i61;
            obj = text;
        } else {
            if (i61 &= i66 == 0) {
                i12 = traceInProgress.changedInstance(text) ? 131072 : 65536;
                $dirty4 |= i12;
            } else {
                obj = text;
            }
        }
        if (i63 &= i66 == 0) {
            if (i67 & 64 == 0) {
                changed2 = traceInProgress.changed(shape) ? 1048576 : 524288;
            } else {
                obj2 = shape;
            }
            $dirty4 |= changed2;
        } else {
            obj2 = shape;
        }
        if (i66 & i68 == 0) {
            if (i67 & 128 == 0) {
                $dirty3 = $dirty4;
                obj41 = i36;
                changed = traceInProgress.changed(backgroundColor) ? 8388608 : 4194304;
            } else {
                $dirty3 = $dirty4;
                obj41 = i36;
                $dirty5 = backgroundColor;
            }
            $dirty3 |= changed;
        } else {
            $dirty6 = $dirty4;
            obj41 = i36;
            $dirty5 = backgroundColor;
        }
        if (i66 & i69 == 0) {
            if (i67 & 256 == 0) {
                i6 = traceInProgress.changed(properties) ? 67108864 : 33554432;
            } else {
                l2 = properties;
            }
            $dirty6 = i | i6;
        } else {
            l2 = properties;
            i = $dirty6;
        }
        $dirty = $dirty6;
        int $dirty8 = i67 & 512;
        int i71 = 805306368;
        if ($dirty8 != 0) {
            $dirty |= i71;
            i9 = $dirty8;
            obj12 = $changed;
        } else {
            if (i66 & i71 == 0) {
                i9 = $dirty8;
                i5 = traceInProgress.changed($changed) ? 536870912 : 268435456;
                $dirty |= i5;
            } else {
                i9 = $dirty8;
                obj12 = $changed;
            }
        }
        if ($dirty & contentColor3 == 306783378) {
            if (!traceInProgress.getSkipping()) {
                traceInProgress.startDefaults();
                i10 = -234881025;
                str = -29360129;
                surface-0d7_KjU = -3670017;
                if (i66 & 1 != 0) {
                    if (traceInProgress.getDefaultsInvalid()) {
                        if (obj41 != null) {
                            obj8 = defaultsInvalid;
                        }
                        if (i16 != 0) {
                            i7 = defaultsInvalid;
                        }
                        if (i19 != 0) {
                            obj10 = defaultsInvalid;
                        }
                        if (i3 != 0) {
                            obj = defaultsInvalid;
                        }
                        i16 = 6;
                        if (i67 & 64 != 0) {
                            $dirty &= surface-0d7_KjU;
                            obj2 = medium;
                        }
                        if (i67 & 128 != 0) {
                            $dirty &= str;
                            obj41 = i10;
                            i10 = surface-0d7_KjU;
                        } else {
                            obj41 = i10;
                            i10 = backgroundColor;
                        }
                        if (i67 & 256 != 0) {
                            contentColor2 = ColorsKt.contentColorFor-ek8zF_U(i10, str, traceInProgress);
                            $dirty &= obj41;
                        } else {
                            contentColor2 = properties;
                        }
                        if (i9 != 0) {
                            super(0, 0, 0, 7, 0);
                            obj3 = dialogProperties2;
                            l5 = i10;
                            i9 = obj10;
                            skipping = $dirty;
                            l4 = contentColor2;
                            $dirty2 = obj8;
                            contentColor3 = obj;
                            obj5 = obj2;
                        } else {
                            obj3 = $changed;
                            l5 = i10;
                            i9 = obj10;
                            skipping = $dirty;
                            l4 = contentColor2;
                            $dirty2 = obj8;
                            contentColor3 = obj;
                            obj5 = obj2;
                        }
                    } else {
                        traceInProgress.skipToGroupEnd();
                        if (i67 & 64 != 0) {
                            $dirty &= surface-0d7_KjU;
                        }
                        if (i67 & 128 != 0) {
                            $dirty &= str;
                        }
                        if (i67 & 256 != 0) {
                            skipping = $dirty & i10;
                            l5 = backgroundColor;
                            l4 = properties;
                            obj3 = $changed;
                            $dirty2 = obj8;
                            i9 = obj10;
                            contentColor3 = obj;
                            obj5 = obj2;
                        } else {
                            l5 = backgroundColor;
                            l4 = properties;
                            obj3 = $changed;
                            i9 = obj10;
                            contentColor3 = obj;
                            obj5 = obj2;
                            skipping = $dirty;
                            $dirty2 = obj8;
                        }
                    }
                } else {
                }
                traceInProgress.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-606536823, skipping, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:74)");
                }
                AndroidAlertDialog_androidKt.AlertDialog.1 anon = new AndroidAlertDialog_androidKt.AlertDialog.1(i7, obj14);
                AndroidAlertDialog_androidKt.AlertDialog-wqdebIU(obj11, (Function2)ComposableLambdaKt.rememberComposableLambda(-1849673151, true, anon, traceInProgress, 54), $dirty2, i9, contentColor3, obj5, l5, obj22, l4, obj24, obj3, traceInProgress);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj7 = i7;
                obj4 = $dirty2;
                obj6 = i9;
                obj9 = contentColor3;
                dismissButton2 = obj5;
                l3 = l5;
                l = l4;
                dialogProperties = obj3;
                $dirty = skipping;
            } else {
                traceInProgress.skipToGroupEnd();
                composer = traceInProgress;
                obj4 = obj8;
                obj7 = i7;
                obj6 = obj10;
                obj9 = obj;
                dismissButton2 = obj2;
                l3 = backgroundColor;
                l = properties;
                dialogProperties = $changed;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new AndroidAlertDialog_androidKt.AlertDialog.2(onDismissRequest, obj14, obj4, obj7, obj6, obj9, dismissButton2, l3, obj10, l, obj, dialogProperties, i66, i67);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    public static final void AlertDialog-wqdebIU(Function0<Unit> onDismissRequest, Function2<? super Composer, ? super Integer, Unit> buttons, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> text, Shape shape, long backgroundColor, long contentColor, DialogProperties properties, Composer $composer, int $changed, int i12) {
        int i14;
        Object obj3;
        int properties2;
        int defaultsInvalid;
        int medium;
        int shape2;
        int i3;
        int i;
        int changed;
        Composer traceInProgress;
        int $dirty;
        long $dirty3;
        int i15;
        Object obj7;
        int i8;
        boolean traceInProgress2;
        Object obj8;
        int i4;
        Object obj4;
        Object obj;
        int i6;
        int str;
        Object obj5;
        Object dialogProperties;
        Object modifier2;
        int i16;
        int i13;
        long l;
        Object i7;
        int i9;
        int i11;
        long l2;
        Object obj2;
        int i5;
        Object obj6;
        Object shape3;
        int changed2;
        long surface-0d7_KjU;
        int changed3;
        Composer composer;
        int i10;
        int i2;
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
        traceInProgress = i12.startRestartGroup(1035523925);
        ComposerKt.sourceInformation(traceInProgress, "C(AlertDialog)P(4,1,3,8,7,6,0:c#ui.graphics.Color,2:c#ui.graphics.Color)131@6133L6,132@6191L6,133@6233L32,139@6420L275,136@6329L366:AndroidAlertDialog.android.kt#jmzs0o");
        $dirty = obj33;
        if (i45 & 1 != 0) {
            $dirty |= 6;
            obj7 = onDismissRequest;
        } else {
            if (i44 & 6 == 0) {
                i4 = traceInProgress.changedInstance(onDismissRequest) ? 4 : 2;
                $dirty |= i4;
            } else {
                obj7 = onDismissRequest;
            }
        }
        if (i45 & 2 != 0) {
            $dirty |= 48;
            obj4 = buttons;
        } else {
            if (i44 & 48 == 0) {
                i6 = traceInProgress.changedInstance(buttons) ? 32 : 16;
                $dirty |= i6;
            } else {
                obj4 = buttons;
            }
        }
        str = i45 & 4;
        if (str != null) {
            $dirty |= 384;
            dialogProperties = modifier;
        } else {
            if (i44 & 384 == 0) {
                i16 = traceInProgress.changed(modifier) ? 256 : 128;
                $dirty |= i16;
            } else {
                dialogProperties = modifier;
            }
        }
        i13 = i45 & 8;
        if (i13 != 0) {
            $dirty |= 3072;
            i7 = title;
        } else {
            if (i44 & 3072 == 0) {
                i9 = traceInProgress.changedInstance(title) ? 2048 : 1024;
                $dirty |= i9;
            } else {
                i7 = title;
            }
        }
        i11 = i45 & 16;
        if (i11 != 0) {
            $dirty |= 24576;
            obj2 = text;
        } else {
            if (i44 & 24576 == 0) {
                i5 = traceInProgress.changedInstance(text) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                obj2 = text;
            }
        }
        if (i41 &= i44 == 0) {
            if (i45 & 32 == 0) {
                changed2 = traceInProgress.changed(shape) ? 131072 : 65536;
            } else {
                obj6 = shape;
            }
            $dirty |= changed2;
        } else {
            obj6 = shape;
        }
        if (i46 &= i44 == 0) {
            if (i45 & 64 == 0) {
                changed3 = traceInProgress.changed(backgroundColor) ? 1048576 : 524288;
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
                i = traceInProgress.changed(properties) ? 8388608 : 4194304;
            } else {
                obj32 = $dirty;
                $dirty3 = properties;
            }
            i14 = obj32 | i;
        } else {
            $dirty3 = properties;
            i14 = obj32;
        }
        obj32 = i14;
        int $dirty4 = i45 & 256;
        int i51 = 100663296;
        if ($dirty4 != 0) {
            $dirty2 = i52;
            i10 = $dirty4;
            obj3 = $changed;
        } else {
            if (i44 & i51 == 0) {
                i10 = $dirty4;
                i2 = traceInProgress.changed($changed) ? 67108864 : 33554432;
                $dirty2 = obj32 | i2;
            } else {
                i10 = $dirty4;
                obj3 = $changed;
                $dirty2 = obj32;
            }
        }
        if ($dirty2 & contentColor2 == 38347922) {
            if (!traceInProgress.getSkipping()) {
                traceInProgress.startDefaults();
                int i23 = -29360129;
                i8 = -3670017;
                int i53 = -458753;
                if (i44 & 1 != 0) {
                    if (traceInProgress.getDefaultsInvalid()) {
                        if (str != null) {
                            dialogProperties = defaultsInvalid;
                        }
                        if (i13 != 0) {
                            i7 = defaultsInvalid;
                        }
                        if (i11 != 0) {
                            obj2 = defaultsInvalid;
                        }
                        str = 6;
                        if (i45 & 32 != 0) {
                            $dirty2 &= i53;
                            obj6 = medium;
                        }
                        if (i45 & 64 != 0) {
                            surface-0d7_KjU = MaterialTheme.INSTANCE.getColors(traceInProgress, str).getSurface-0d7_KjU();
                            $dirty2 &= i8;
                        }
                        if (i45 & 128 != 0) {
                            contentColor2 = ColorsKt.contentColorFor-ek8zF_U(surface-0d7_KjU, obj15, traceInProgress);
                            $dirty2 &= i23;
                        } else {
                            contentColor2 = properties;
                        }
                        if (i10 != 0) {
                            super(0, 0, 0, 7, 0);
                            i15 = $dirty2;
                        } else {
                            properties2 = $changed;
                            i15 = $dirty2;
                        }
                    } else {
                        traceInProgress.skipToGroupEnd();
                        if (i45 & 32 != 0) {
                            $dirty2 &= i53;
                        }
                        if (i45 & 64 != 0) {
                            $dirty2 &= i8;
                        }
                        if (i45 & 128 != 0) {
                            contentColor2 = properties;
                            i15 = i22;
                            properties2 = $changed;
                        } else {
                            contentColor2 = properties;
                            properties2 = $changed;
                            i15 = $dirty2;
                        }
                    }
                } else {
                }
                traceInProgress.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1035523925, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:135)");
                }
                super(obj4, dialogProperties, i7, obj2, obj6, surface-0d7_KjU, $composer, contentColor2, obj32);
                obj26 = traceInProgress;
                AndroidDialog_androidKt.Dialog(onDismissRequest, properties2, (Function2)ComposableLambdaKt.rememberComposableLambda(-1787418772, true, anon, traceInProgress, 54), obj26, i31 |= i35, 0);
                composer = obj26;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty2 = i15;
                obj8 = dialogProperties;
                obj5 = obj2;
                modifier2 = obj6;
                l2 = contentColor2;
                shape3 = properties2;
                obj = i7;
                l = surface-0d7_KjU;
            } else {
                traceInProgress.skipToGroupEnd();
                composer = traceInProgress;
                obj8 = dialogProperties;
                obj5 = obj2;
                modifier2 = obj6;
                l2 = properties;
                shape3 = $changed;
                obj = i7;
                l = surface-0d7_KjU;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            properties2 = new AndroidAlertDialog_androidKt.AlertDialog.4(onDismissRequest, buttons, obj8, obj, obj5, modifier2, l, i7, l2, obj2, shape3, i44, i45);
            endRestartGroup.updateScope((Function2)properties2);
        }
    }
}
