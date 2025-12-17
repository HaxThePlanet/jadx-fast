package androidx.compose.material3;

import android.view.View;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a¹\u0001\u0010\u0000\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\r2\u0015\u0008\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\u0008\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\u0008\u0012¢\u0006\u0002\u0008\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001c\u001aJ\u0010\u001d\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0012H\u0001¢\u0006\u0002\u0010\"\u001a\u000c\u0010#\u001a\u00020$*\u00020%H\u0000\u001a\u0014\u0010&\u001a\u00020$*\u00020'2\u0006\u0010(\u001a\u00020$H\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006)²\u0006\u0015\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0012X\u008a\u0084\u0002", d2 = {"ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "sheetMaxWidth", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-dYc4hso", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheetDialog", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/ModalBottomSheetProperties;Landroidx/compose/animation/core/Animatable;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "isFlagSecureEnabled", "", "Landroid/view/View;", "shouldApplySecureFlag", "Landroidx/compose/ui/window/SecureFlagPolicy;", "isSecureFlagSetOnParent", "material3_release", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ModalBottomSheet_androidKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal2;
            int ordinal3;
            int ordinal;
            int[] iArr = new int[values.length];
            iArr[SecureFlagPolicy.SecureOff.ordinal()] = 1;
            iArr[SecureFlagPolicy.SecureOn.ordinal()] = 2;
            iArr[SecureFlagPolicy.Inherit.ordinal()] = 3;
            ModalBottomSheet_androidKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use constructor with contentWindowInsets parameter.", replaceWith = @ReplaceWith(...))
    public static final void ModalBottomSheet-dYc4hso(Function0 onDismissRequest, Modifier modifier, androidx.compose.material3.SheetState sheetState, float sheetMaxWidth, Shape shape, long containerColor, long contentColor, float tonalElevation, long scrimColor, Function2 dragHandle, WindowInsets windowInsets, androidx.compose.material3.ModalBottomSheetProperties properties, Function3 content, Composer $composer, int $changed, int $changed1, int i17) {
        int i11;
        Object i13;
        int $dirty7;
        Object endRestartGroup;
        Object windowInsets2;
        int changed;
        WindowInsets skipping;
        int defaultsInvalid;
        int rememberModalBottomSheetState;
        float sheetMaxWidth2;
        int i9;
        Object obj6;
        int str;
        float f;
        Object obj3;
        Object i15;
        int $dirty12;
        Object $dirty5;
        int $dirty13;
        float $composer2;
        Composer $composer4;
        int $dirty6;
        long $dirty;
        long l2;
        Object obj5;
        Object modifier2;
        boolean changedInstance;
        long sheetState2;
        int i21;
        int i;
        Object shape2;
        Object shape4;
        Object obj2;
        float f2;
        long shape3;
        float tonalElevation3;
        Object tonalElevation4;
        Object containerColor2;
        int i4;
        float f3;
        int i7;
        long l;
        long contentColor2;
        long contentColor3;
        Object obj;
        Function2 tonalElevation2;
        int i2;
        Object obj4;
        WindowInsets scrimColor2;
        long sheetState3;
        androidx.compose.material3.ModalBottomSheetProperties modalBottomSheetProperties;
        int scrimColor3;
        int i16;
        int i8;
        int changed4;
        androidx.compose.material3.ModalBottomSheet_androidKt.ModalBottomSheet.1 dragHandle2;
        int i5;
        int $dirty1;
        int i14;
        boolean changed2;
        int i22;
        Composer $composer3;
        int changed5;
        boolean z;
        int i10;
        int i19;
        int $dirty4;
        int $dirty2;
        int $dirty3;
        int i12;
        int changed3;
        int i6;
        int i18;
        int i20;
        int i3;
        ScopeUpdateScope scopeUpdateScope;
        float obj29;
        int obj30;
        float obj31;
        int obj44;
        i11 = obj45;
        int i24 = obj46;
        str = obj47;
        $composer4 = i17.startRestartGroup(944867294);
        ComposerKt.sourceInformation($composer4, "C(ModalBottomSheet)P(5,4,10,9:c#ui.unit.Dp,8,0:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.unit.Dp,7:c#ui.graphics.Color,3,12,6)235@10240L31,237@10371L13,238@10434L14,239@10476L31,241@10584L10,243@10731L12,247@10884L485:ModalBottomSheet.android.kt#uh7d8r");
        $dirty6 = obj45;
        changedInstance = obj46;
        if (str & 1 != 0) {
            $dirty6 |= 6;
            obj2 = onDismissRequest;
        } else {
            if (i11 & 6 == 0) {
                i4 = $composer4.changedInstance(onDismissRequest) ? 4 : 2;
                $dirty6 |= i4;
            } else {
                obj2 = onDismissRequest;
            }
        }
        i7 = str & 2;
        if (i7 != 0) {
            $dirty6 |= 48;
            obj = modifier;
        } else {
            if (i11 & 48 == 0) {
                i2 = $composer4.changed(modifier) ? 32 : 16;
                $dirty6 |= i2;
            } else {
                obj = modifier;
            }
        }
        if (i11 & 384 == 0) {
            if (str & 4 == 0) {
                changed4 = $composer4.changed(sheetState) ? i16 : 128;
            } else {
                obj4 = sheetState;
            }
            $dirty6 |= changed4;
        } else {
            obj4 = sheetState;
        }
        dragHandle2 = str & 8;
        if (dragHandle2 != 0) {
            $dirty6 |= 3072;
            f2 = sheetMaxWidth;
        } else {
            if (i11 & 3072 == 0) {
                i5 = $composer4.changed(sheetMaxWidth) ? 2048 : 1024;
                $dirty6 |= i5;
            } else {
                f2 = sheetMaxWidth;
            }
        }
        if (i11 & 24576 == 0) {
            if (str & 16 == 0) {
                changed2 = $composer4.changed(shape) ? 16384 : 8192;
            } else {
                containerColor2 = shape;
            }
            $dirty6 |= changed2;
        } else {
            containerColor2 = shape;
        }
        if (i11 & i80 == 0) {
            if (str & 32 == 0) {
                changed5 = $composer4.changed(containerColor) ? 131072 : 65536;
            } else {
                l = containerColor;
            }
            $dirty6 |= changed5;
        } else {
            l = containerColor;
        }
        if (i11 & i81 == 0) {
            if (str & 64 == 0) {
                $dirty4 = $dirty6;
                z = changedInstance;
                changed3 = $composer4.changed(tonalElevation) ? 1048576 : 524288;
            } else {
                $dirty4 = $dirty6;
                z = changedInstance;
                $dirty = tonalElevation;
            }
            $dirty4 |= changed3;
        } else {
            $dirty2 = $dirty6;
            z = changedInstance;
            $dirty = tonalElevation;
        }
        scrimColor3 = str & 128;
        i6 = 12582912;
        if (scrimColor3 != 0) {
            $dirty2 |= i6;
            f = dragHandle;
        } else {
            if (i11 & i6 == 0) {
                i18 = $composer4.changed(dragHandle) ? 8388608 : 4194304;
                $dirty2 |= i18;
            } else {
                f = dragHandle;
            }
        }
        if (i11 & i87 == 0) {
            if (str & 256 == 0) {
                i11 = $composer4.changed(windowInsets) ? 67108864 : 33554432;
            } else {
                l2 = windowInsets;
            }
            $dirty2 |= i11;
        } else {
            l2 = windowInsets;
        }
        i13 = str & 512;
        int i89 = 805306368;
        if (i13 != 0) {
            $dirty2 |= i89;
            i20 = i13;
        } else {
            if (obj45 & i89 == 0) {
                i20 = i13;
                i3 = $composer4.changedInstance(content) ? 536870912 : 268435456;
                $dirty2 |= i3;
            } else {
                i20 = i13;
                i13 = content;
            }
        }
        $dirty7 = $dirty2;
        if (i24 & 6 == 0) {
            if (str & 1024 == 0) {
                i14 = $composer4.changed($composer) ? 4 : 2;
            } else {
                obj3 = $composer;
            }
            $dirty1 = z | i14;
        } else {
            obj3 = $composer;
            $dirty1 = z;
        }
        i15 = str & 2048;
        if (i15 != 0) {
            $dirty1 |= 48;
            i10 = i15;
        } else {
            if (i24 & 48 == 0) {
                i10 = i15;
                i22 = $composer4.changed($changed) ? 32 : 16;
                $dirty1 |= i22;
            } else {
                i10 = i15;
                i15 = $changed;
            }
        }
        $dirty12 = $dirty1;
        if (str & 4096 != 0) {
            $dirty12 |= 384;
            obj5 = $changed1;
        } else {
            if (i24 & 384 == 0) {
                if ($composer4.changedInstance($changed1)) {
                } else {
                    i16 = 128;
                }
                $dirty12 |= i16;
            } else {
                obj5 = $changed1;
            }
        }
        if (i63 &= $dirty7 == 306783378 && $dirty12 & 147 == 146) {
            if ($dirty12 & 147 == 146) {
                if (!$composer4.getSkipping()) {
                    $composer4.startDefaults();
                    i = -3670017;
                    i8 = -458753;
                    int i79 = -57345;
                    if (obj45 & 1 != 0) {
                        if ($composer4.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                obj = defaultsInvalid;
                            }
                            if (str & 4 != 0) {
                                obj44 = i;
                                i = 0;
                                $dirty7 &= -897;
                                obj4 = rememberModalBottomSheetState;
                            } else {
                                obj44 = i;
                            }
                            if (dragHandle2 != 0) {
                                sheetMaxWidth2 = BottomSheetDefaults.INSTANCE.getSheetMaxWidth-D9Ej5fM();
                            } else {
                                sheetMaxWidth2 = f2;
                            }
                            int i67 = 6;
                            if (str & 16 != 0) {
                                shape2 = BottomSheetDefaults.INSTANCE.getExpandedShape($composer4, i67);
                                $dirty7 &= i79;
                            } else {
                                shape2 = containerColor2;
                            }
                            if (str & 32 != 0) {
                                containerColor2 = BottomSheetDefaults.INSTANCE.getContainerColor($composer4, i67);
                                $dirty7 &= i8;
                            } else {
                                containerColor2 = l;
                            }
                            if (str & 64 != 0) {
                                contentColor3 = ColorSchemeKt.contentColorFor-ek8zF_U(containerColor2, i7, $composer4);
                                $dirty7 &= obj44;
                            } else {
                                contentColor3 = tonalElevation;
                            }
                            if (scrimColor3 != 0) {
                                i8 = 0;
                                tonalElevation3 = Dp.constructor-impl((float)scrimColor3);
                            } else {
                                tonalElevation3 = dragHandle;
                            }
                            if (str & 256 != 0) {
                                scrimColor3 = BottomSheetDefaults.INSTANCE.getScrimColor($composer4, 6);
                                $dirty7 = obj30 & i23;
                            } else {
                                obj30 = $dirty7;
                                scrimColor3 = windowInsets;
                            }
                            if (i20 != 0) {
                                dragHandle2 = ComposableSingletons.ModalBottomSheet_androidKt.INSTANCE.getLambda-1$material3_release();
                            } else {
                                dragHandle2 = content;
                            }
                            obj30 = $dirty7;
                            if (str & 1024 != 0) {
                                obj31 = sheetMaxWidth2;
                                windowInsets2 = BottomSheetDefaults.INSTANCE.getWindowInsets($composer4, 6);
                                $dirty12 &= -15;
                            } else {
                                obj31 = sheetMaxWidth2;
                                windowInsets2 = $composer;
                            }
                            if (i10 != 0) {
                                obj2 = obj31;
                                $dirty1 = properties2;
                                obj29 = tonalElevation3;
                                skipping = windowInsets2;
                                $dirty7 = $dirty12;
                                tonalElevation4 = shape2;
                                shape4 = obj4;
                                sheetState3 = scrimColor3;
                                i16 = dragHandle2;
                                $dirty13 = obj30;
                            } else {
                                obj2 = obj31;
                                $dirty1 = $changed;
                                skipping = windowInsets2;
                                $dirty7 = $dirty12;
                                obj29 = tonalElevation3;
                                $dirty13 = obj30;
                                tonalElevation4 = shape2;
                                shape4 = obj4;
                                sheetState3 = scrimColor3;
                                i16 = dragHandle2;
                            }
                        } else {
                            $composer4.skipToGroupEnd();
                            if (str & 4 != 0) {
                                $dirty7 &= -897;
                            }
                            if (str & 16 != 0) {
                                $dirty7 &= i79;
                            }
                            if (str & 32 != 0) {
                                $dirty7 &= i8;
                            }
                            if (str & 64 != 0) {
                                $dirty7 &= i;
                            }
                            if (str & 256 != 0) {
                                $dirty7 &= i9;
                            }
                            if (str & 1024 != 0) {
                                obj29 = dragHandle;
                                i16 = content;
                                $dirty1 = $changed;
                                $dirty13 = $dirty7;
                                $dirty7 = i31;
                                obj2 = f2;
                                tonalElevation4 = containerColor2;
                                containerColor2 = l;
                                shape4 = obj4;
                                contentColor3 = tonalElevation;
                                sheetState3 = windowInsets;
                                skipping = $composer;
                            } else {
                                $dirty13 = $dirty7;
                                $dirty7 = obj29;
                                obj29 = dragHandle;
                                i16 = content;
                                skipping = $composer;
                                $dirty1 = $changed;
                                obj2 = f2;
                                tonalElevation4 = containerColor2;
                                containerColor2 = l;
                                shape4 = obj4;
                                contentColor3 = tonalElevation;
                                sheetState3 = windowInsets;
                            }
                        }
                    } else {
                    }
                    $composer4.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        $composer3 = $composer4;
                        ComposerKt.traceEventStart(944867294, $dirty13, $dirty7, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:247)");
                    } else {
                        $composer3 = $composer4;
                    }
                    ModalBottomSheet_androidKt.ModalBottomSheet.1 anon = new ModalBottomSheet_androidKt.ModalBottomSheet.1(skipping);
                    Object obj8 = obj;
                    float modifier3 = obj29;
                    ModalBottomSheetKt.ModalBottomSheet-dYc4hso(onDismissRequest, obj8, shape4, obj2, tonalElevation4, containerColor2, i7, contentColor3, obj12, modifier3, sheetState3, scrimColor3, i16, (Function2)anon, $dirty1, obj5, $composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i12 = $dirty7;
                    i19 = $dirty13;
                    obj6 = obj8;
                    $dirty5 = shape4;
                    $composer2 = obj2;
                    modifier2 = tonalElevation4;
                    sheetState2 = containerColor2;
                    shape3 = contentColor3;
                    f3 = modifier3;
                    contentColor2 = sheetState3;
                    tonalElevation2 = i16;
                    modalBottomSheetProperties = $dirty1;
                    scrimColor2 = skipping;
                } else {
                    $composer4.skipToGroupEnd();
                    f3 = dragHandle;
                    modalBottomSheetProperties = $changed;
                    i19 = $dirty7;
                    i12 = $dirty12;
                    $composer3 = $composer4;
                    $composer2 = f2;
                    modifier2 = containerColor2;
                    sheetState2 = l;
                    obj6 = obj;
                    $dirty5 = obj4;
                    shape3 = tonalElevation;
                    contentColor2 = windowInsets;
                    tonalElevation2 = content;
                    scrimColor2 = $composer;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new ModalBottomSheet_androidKt.ModalBottomSheet.2(onDismissRequest, obj6, $dirty5, $composer2, modifier2, sheetState2, obj2, shape3, containerColor2, f3, contentColor2, obj12, tonalElevation2, scrimColor2, modalBottomSheetProperties, $changed1, obj45, obj46, obj47);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void ModalBottomSheetDialog(Function0<Unit> onDismissRequest, androidx.compose.material3.ModalBottomSheetProperties properties, Animatable<Float, AnimationVector1D> predictiveBackProgress, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int view;
        Object it$iv;
        Object compositionCoroutineScope;
        Object $this$cache$iv;
        Object compositionScopedCoroutineScopeCanceller;
        Object traceInProgress;
        int view2;
        Object it$iv2;
        Object invalid$iv;
        Object restartGroup;
        int $dirty;
        Object density3;
        int i6;
        int i7;
        int i9;
        int i;
        int i3;
        boolean density;
        boolean traceInProgress2;
        boolean changedInstance;
        int i2;
        Object empty;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int systemInDarkTheme;
        Object obj3;
        int dialogId;
        Composer composer2;
        Object rememberedValue;
        int i5;
        Composer composer;
        Object empty2;
        int i10;
        Object obj2;
        Composer.Companion companion3;
        Object obj;
        int companion2;
        Object density2;
        int companion;
        androidx.compose.runtime.CompositionContext context;
        State state;
        Object it$iv$iv;
        int i4;
        int i8;
        androidx.compose.material3.ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper;
        Object obj4;
        int obj32;
        traceInProgress = predictiveBackProgress;
        obj3 = content;
        final int i32 = $changed;
        view = 1254951810;
        restartGroup = $composer.startRestartGroup(view);
        ComposerKt.sourceInformation(restartGroup, "C(ModalBottomSheetDialog)P(1,3,2)273@11822L7,274@11861L7,275@11916L7,276@11946L28,277@12001L29,278@12050L38,279@12105L24,280@12157L21,282@12204L697,305@12932L129,305@12907L154,314@13078L182,314@13067L193:ModalBottomSheet.android.kt#uh7d8r");
        if (i32 & 6 == 0) {
            i7 = restartGroup.changedInstance(onDismissRequest) ? 4 : 2;
            $dirty |= i7;
        }
        if (i32 & 48 == 0) {
            i9 = restartGroup.changed(properties) ? 32 : 16;
            $dirty |= i9;
        }
        if (i32 & 384 == 0) {
            if (i32 & 512 == 0) {
                changedInstance = restartGroup.changed(traceInProgress);
            } else {
                changedInstance = restartGroup.changedInstance(traceInProgress);
            }
            i = changedInstance != null ? 256 : 128;
            $dirty |= i;
        }
        if (i32 & 3072 == 0) {
            i3 = restartGroup.changedInstance(obj3) ? 2048 : 1024;
            $dirty |= i3;
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(view, $dirty, -1, "androidx.compose.material3.ModalBottomSheetDialog (ModalBottomSheet.android.kt:272)");
                }
                int i22 = 0;
                int i29 = 0;
                int i33 = 2023513938;
                String str4 = "CC:CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, i33, str4);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv = consume2;
                int i30 = 0;
                int i35 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i33, str4);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv2 = consume3;
                int i36 = 0;
                int i40 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i33, str4);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i34 = 0;
                int i41 = i34;
                Composer composer6 = restartGroup;
                context = context2;
                Object rememberSaveable = RememberSaveableKt.rememberSaveable(new Object[i41], 0, 0, (Function0)ModalBottomSheet_androidKt.ModalBottomSheetDialog.dialogId.1.INSTANCE, composer6, 3072, 6);
                composer2 = composer6;
                int i39 = $composer2;
                int i42 = 0;
                ComposerKt.sourceInformationMarkerStart(composer2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composer2, -954363344, "CC(remember):Effects.kt#9igjgp");
                int i19 = 0;
                Composer composer4 = composer2;
                int i48 = 0;
                compositionCoroutineScope = composer4.rememberedValue();
                int i49 = 0;
                if (compositionCoroutineScope == Composer.Companion.getEmpty()) {
                    int i51 = 0;
                    it$iv$iv = compositionCoroutineScope;
                    companion = i13;
                    compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, composer2));
                    composer4.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                } else {
                    compositionScopedCoroutineScopeCanceller = it$iv$iv;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                restartGroup = this_$iv3;
                String str5 = "CC(remember):ModalBottomSheet.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(composer2, -1981517173, str5);
                Composer composer3 = composer2;
                companion2 = 0;
                Object rememberedValue2 = composer3.rememberedValue();
                int i50 = 0;
                if (changed |= changed2 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        companion = 0;
                        Object obj6 = this_$iv;
                        dialogId = $dirty;
                        obj2 = rememberedValue2;
                        int i31 = 1;
                        ModalBottomSheetDialogWrapper view3 = new ModalBottomSheetDialogWrapper(onDismissRequest, properties, obj6, restartGroup, this_$iv2, (UUID)rememberSaveable, predictiveBackProgress, (CompositionScopedCoroutineScopeCanceller)compositionScopedCoroutineScopeCanceller.getCoroutineScope(), DarkThemeKt.isSystemInDarkTheme(composer2, 0));
                        i4 = 0;
                        ModalBottomSheet_androidKt.ModalBottomSheetDialog.dialog.1.1.1 anon = new ModalBottomSheet_androidKt.ModalBottomSheetDialog.dialog.1.1.1(SnapshotStateKt.rememberUpdatedState(obj3, restartGroup, i37 &= 14));
                        obj4 = obj6;
                        view3.setContent(context, (Function2)ComposableLambdaKt.composableLambdaInstance(-1560960657, true, anon));
                        composer3.updateRememberedValue(view3);
                    } else {
                        dialogId = $dirty;
                        density3 = this_$iv2;
                        density = obj7;
                        obj4 = this_$iv;
                        obj2 = view;
                        composer = composer3;
                        obj3 = context;
                        view2 = 1;
                        it$iv = onDismissRequest;
                        $this$cache$iv = properties;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -1981494445, str5);
                Composer composer5 = composer2;
                int i44 = 0;
                it$iv2 = composer5.rememberedValue();
                companion3 = 0;
                if (!composer2.changedInstance((ModalBottomSheetDialogWrapper)view)) {
                    density2 = density3;
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        density3 = 0;
                        obj = it$iv2;
                        it$iv2 = new ModalBottomSheet_androidKt.ModalBottomSheetDialog.1.1(view);
                        composer5.updateRememberedValue((Function1)it$iv2);
                    } else {
                        obj = it$iv2;
                    }
                } else {
                    density2 = density3;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                empty2 = 0;
                EffectsKt.DisposableEffect(view, (Function1)it$iv2, composer2, empty2);
                ComposerKt.sourceInformationMarkerStart(composer2, -1981489720, str5);
                i6 = dialogId & 14 == 4 ? 1 : empty2;
                i8 = dialogId & 112 == 32 ? 1 : empty2;
                i16 |= changed3;
                $dirty = composer2;
                i2 = 0;
                rememberedValue = $dirty.rememberedValue();
                i10 = 0;
                if (i17 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty2 = 0;
                        obj32 = i17;
                        invalid$iv = new ModalBottomSheet_androidKt.ModalBottomSheetDialog.2.1(view, it$iv, $this$cache$iv, restartGroup);
                        $dirty.updateRememberedValue((Function0)invalid$iv);
                    } else {
                        obj32 = i17;
                        invalid$iv = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.SideEffect((Function0)invalid$iv, composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer2 = restartGroup;
                dialogId = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            view = new ModalBottomSheet_androidKt.ModalBottomSheetDialog.3(it$iv, $this$cache$iv, predictiveBackProgress, content, i32);
            endRestartGroup.updateScope((Function2)view);
        }
    }

    private static final Function2<Composer, Integer, Unit> ModalBottomSheetDialog$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> $currentContent$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Function2)$currentContent$delegate.getValue();
    }

    public static final Function2 access$ModalBottomSheetDialog$lambda$0(State $currentContent$delegate) {
        return ModalBottomSheet_androidKt.ModalBottomSheetDialog$lambda$0($currentContent$delegate);
    }

    public static final boolean access$shouldApplySecureFlag(SecureFlagPolicy $receiver, boolean isSecureFlagSetOnParent) {
        return ModalBottomSheet_androidKt.shouldApplySecureFlag($receiver, isSecureFlagSetOnParent);
    }

    public static final boolean isFlagSecureEnabled(View $this$isFlagSecureEnabled) {
        int layoutParams;
        int i;
        if (layoutParams instanceof WindowManager.LayoutParams) {
        } else {
            layoutParams = 0;
        }
        if (layoutParams != 0 && flags &= 8192 != 0) {
            if (flags &= 8192 != 0) {
                i = 1;
            }
            return i;
        }
        return 0;
    }

    private static final boolean shouldApplySecureFlag(SecureFlagPolicy $this$shouldApplySecureFlag, boolean isSecureFlagSetOnParent) {
        int i;
        switch (i2) {
            case 1:
                i = 0;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                i = isSecureFlagSetOnParent;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return i;
    }
}
