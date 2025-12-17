package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0090\u0001\u0010\n\u001a\u00020\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\u0008\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\u0008\u001b¢\u0006\u0002\u0008\u001fH\u0007¢\u0006\u0002\u0010 \u001aÆ\u0001\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00112\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020#2\u0015\u0008\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\u0008\u001b2\u0015\u0008\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\u0008\u001b2\u0015\u0008\u0002\u0010%\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\u0008\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\u0008\u001b¢\u0006\u0002\u0008\u001fH\u0007¢\u0006\u0002\u0010&\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0008\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006'²\u0006\n\u0010(\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020)X\u008a\u0084\u0002", d2 = {"HorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LeadingIconEndSpacing", "LeadingIconStartSpacing", "SelectedIconContainerSize", "SelectedOverlayOpacity", "", "SurfaceOverlayOpacity", "TrailingIconSpacing", "Chip", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "border", "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ChipColors;", "leadingIcon", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "selected", "Landroidx/compose/material/SelectableChipColors;", "selectedIcon", "trailingIcon", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/SelectableChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "material_release", "contentColor", "Landroidx/compose/ui/graphics/Color;", "leadingIconContentColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ChipKt {

    private static final float HorizontalPadding = 0f;
    private static final float LeadingIconEndSpacing = 0f;
    private static final float LeadingIconStartSpacing = 0f;
    private static final float SelectedIconContainerSize = 0f;
    private static final float SelectedOverlayOpacity = 0.16f;
    private static final float SurfaceOverlayOpacity = 0.12f;
    private static final float TrailingIconSpacing;
    static {
        int i6 = 0;
        ChipKt.HorizontalPadding = Dp.constructor-impl((float)i);
        int i7 = 0;
        ChipKt.LeadingIconStartSpacing = Dp.constructor-impl((float)i2);
        int i8 = 0;
        ChipKt.LeadingIconEndSpacing = Dp.constructor-impl((float)i3);
        int i9 = 0;
        ChipKt.TrailingIconSpacing = Dp.constructor-impl((float)i4);
        int i10 = 0;
        ChipKt.SelectedIconContainerSize = Dp.constructor-impl((float)i5);
    }

    public static final void Chip(Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, Shape shape, BorderStroke border, androidx.compose.material.ChipColors colors, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i12) {
        Object obj4;
        int contentColor;
        int defaultsInvalid;
        Object shape2;
        int i13;
        boolean traceInProgress2;
        Object $composer2;
        Composer traceInProgress;
        int $dirty;
        int i;
        Object $dirty2;
        Object obj9;
        boolean z2;
        int i16;
        int $dirty4;
        Object obj5;
        Object obj2;
        Object modifier2;
        int i7;
        int border2;
        Object colors2;
        boolean z;
        Object leadingIcon2;
        int i15;
        Composer $composer3;
        Object obj10;
        Object obj;
        int i6;
        Object iNSTANCE;
        int changed;
        Object obj7;
        Object obj3;
        int i8;
        Object obj6;
        int changed2;
        int i18;
        int i20;
        int $dirty3;
        int i2;
        long copy-wmQWz5c$default;
        int i3;
        int i17;
        int i19;
        Object obj8;
        int i9;
        Composer composer;
        Composer composer2;
        int i5;
        int i10;
        int i14;
        int i11;
        int i4;
        Object obj32;
        State obj33;
        int obj34;
        Object obj35;
        boolean obj36;
        Object obj37;
        int obj40;
        final int i63 = $changed;
        final int i64 = i12;
        traceInProgress = $composer.startRestartGroup(-368396408);
        ComposerKt.sourceInformation(traceInProgress, "C(Chip)P(7,6,3,4,8!2,5)93@4288L6,95@4405L12,99@4550L21,105@4747L24,109@4905L1458,100@4576L1787:Chip.kt#jmzs0o");
        $dirty = $changed;
        if (i64 & 1 != 0) {
            $dirty |= 6;
            obj9 = onClick;
        } else {
            if (i63 & 6 == 0) {
                i16 = traceInProgress.changedInstance(onClick) ? 4 : 2;
                $dirty |= i16;
            } else {
                obj9 = onClick;
            }
        }
        $dirty4 = i64 & 2;
        if ($dirty4 != 0) {
            $dirty |= 48;
            obj2 = modifier;
        } else {
            if (i63 & 48 == 0) {
                i7 = traceInProgress.changed(modifier) ? 32 : 16;
                $dirty |= i7;
            } else {
                obj2 = modifier;
            }
        }
        border2 = i64 & 4;
        if (border2 != 0) {
            $dirty |= 384;
            z = enabled;
        } else {
            if (i63 & 384 == 0) {
                i15 = traceInProgress.changed(enabled) ? 256 : 128;
                $dirty |= i15;
            } else {
                z = enabled;
            }
        }
        int i52 = i64 & 8;
        if (i52 != 0) {
            $dirty |= 3072;
            obj = interactionSource;
        } else {
            if (i63 & 3072 == 0) {
                i6 = traceInProgress.changed(interactionSource) ? 2048 : 1024;
                $dirty |= i6;
            } else {
                obj = interactionSource;
            }
        }
        if (i63 & 24576 == 0) {
            if (i64 & 16 == 0) {
                changed = traceInProgress.changed(shape) ? 16384 : 8192;
            } else {
                iNSTANCE = shape;
            }
            $dirty |= changed;
        } else {
            iNSTANCE = shape;
        }
        int i70 = i64 & 32;
        int i72 = 196608;
        if (i70 != 0) {
            $dirty |= i72;
            obj3 = border;
        } else {
            if (i72 &= i63 == 0) {
                i8 = traceInProgress.changed(border) ? 131072 : 65536;
                $dirty |= i8;
            } else {
                obj3 = border;
            }
        }
        if (i74 &= i63 == 0) {
            if (i64 & 64 == 0) {
                changed2 = traceInProgress.changed(colors) ? 1048576 : 524288;
            } else {
                obj6 = colors;
            }
            $dirty |= changed2;
        } else {
            obj6 = colors;
        }
        int i22 = i64 & 128;
        i18 = 12582912;
        if (i22 != 0) {
            $dirty |= i18;
            obj40 = i70;
            obj7 = leadingIcon;
        } else {
            if (i63 & i18 == 0) {
                obj40 = i70;
                i18 = traceInProgress.changedInstance(leadingIcon) ? 8388608 : 4194304;
                $dirty |= i18;
            } else {
                obj40 = i70;
                obj7 = leadingIcon;
            }
        }
        i20 = 100663296;
        if (i64 & 256 != 0) {
            $dirty |= i20;
            obj4 = content;
        } else {
            if (i63 & i20 == 0) {
                i20 = traceInProgress.changedInstance(content) ? 67108864 : 33554432;
                $dirty |= i20;
            } else {
                obj4 = content;
            }
        }
        $dirty3 = $dirty;
        if ($dirty & i77 == 38347922) {
            if (!traceInProgress.getSkipping()) {
                traceInProgress.startDefaults();
                int i34 = -3670017;
                i2 = -57345;
                if (i63 & 1 != 0) {
                    if (traceInProgress.getDefaultsInvalid()) {
                        if ($dirty4 != 0) {
                            obj2 = defaultsInvalid;
                        }
                        if (border2 != 0) {
                            z = defaultsInvalid;
                        }
                        if (i52 != 0) {
                            obj = defaultsInvalid;
                        }
                        if (i64 & 16 != 0) {
                            shape2 = MaterialTheme.INSTANCE.getShapes(traceInProgress, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            $dirty4 = $dirty3 & i2;
                        } else {
                            shape2 = iNSTANCE;
                            $dirty4 = $dirty3;
                        }
                        border2 = obj40 != null ? 0 : obj3;
                        if (i64 & 64 != 0) {
                            composer2 = traceInProgress;
                            $composer2 = ChipDefaults.INSTANCE.chipColors-5tl4gsc(0, obj3, 0, $dirty3, 0, obj18, 0, obj20, 0);
                            $composer3 = composer2;
                            $dirty4 &= i34;
                        } else {
                            $composer3 = traceInProgress;
                            $composer2 = colors;
                        }
                        if (i22 != 0) {
                            obj6 = shape2;
                            obj7 = i35;
                            i = $dirty4;
                            i17 = border2;
                            obj3 = z;
                            obj8 = obj;
                        } else {
                            obj7 = leadingIcon;
                            obj6 = shape2;
                            i = $dirty4;
                            i17 = border2;
                            obj3 = z;
                            obj8 = obj;
                        }
                    } else {
                        traceInProgress.skipToGroupEnd();
                        if (i64 & 16 != 0) {
                            $dirty3 = i13;
                        }
                        if (i64 & 64 != 0) {
                            i = shape2;
                            $composer3 = traceInProgress;
                            obj8 = obj;
                            i17 = obj3;
                            $composer2 = obj6;
                            obj3 = z;
                            obj6 = iNSTANCE;
                        } else {
                            $composer3 = traceInProgress;
                            obj8 = obj;
                            i17 = obj3;
                            $composer2 = obj6;
                            i = $dirty3;
                            obj3 = z;
                            obj6 = iNSTANCE;
                        }
                    }
                } else {
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-368396408, i, -1, "androidx.compose.material.Chip (Chip.kt:98)");
                }
                contentColor = $composer2.contentColor(obj3, $composer3, i27 |= i41);
                int i55 = 1;
                obj35 = $composer2;
                obj32 = anon2;
                obj34 = obj7;
                super(contentColor, obj34, obj35, obj3, content);
                SurfaceKt.Surface-LPr_se0(obj9, SemanticsModifierKt.semantics$default(obj2, false, (Function1)ChipKt.Chip.1.INSTANCE, i55, 0), obj3, obj6, (Color)$composer2.backgroundColor(obj3, $composer3, i45 |= i50).getValue().unbox-impl(), i2, Color.copy-wmQWz5c$default(ChipKt.Chip$lambda$0(contentColor), obj24, 1065353216, 0, 0, 0, 14), i3, i17, 0, obj8, (Function2)ComposableLambdaKt.rememberComposableLambda(139076687, i55, obj32, $composer3, 54), $composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty3 = i;
                $dirty2 = obj2;
                obj10 = i51;
                z2 = obj3;
                modifier2 = obj6;
                obj5 = obj8;
                leadingIcon2 = chipColors;
                colors2 = i17;
            } else {
                traceInProgress.skipToGroupEnd();
                composer = traceInProgress;
                $dirty2 = obj2;
                z2 = z;
                obj5 = obj;
                modifier2 = iNSTANCE;
                obj10 = obj7;
                colors2 = obj3;
                leadingIcon2 = obj6;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            contentColor = new ChipKt.Chip.3(onClick, $dirty2, z2, obj5, modifier2, colors2, leadingIcon2, obj10, content, i63, i64);
            endRestartGroup.updateScope((Function2)contentColor);
        }
    }

    private static final long Chip$lambda$0(State<Color> $contentColor$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Color)$contentColor$delegate.getValue().unbox-impl();
    }

    public static final void FilterChip(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, Shape shape, BorderStroke border, androidx.compose.material.SelectableChipColors colors, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> selectedIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i16) {
        boolean traceInProgress;
        Object endRestartGroup;
        Object obj6;
        boolean skipping;
        int modifier3;
        int defaultsInvalid;
        Object modifier4;
        int i3;
        int modifier2;
        Object enabled3;
        boolean enabled2;
        Object enabled4;
        int changedInstance;
        int i17;
        boolean shape2;
        Object leadingIcon3;
        int leadingIcon2;
        int $dirty2;
        Object $dirty;
        Object $dirty3;
        Object $dirty16;
        Object obj15;
        Object obj13;
        Object $dirty12;
        int selectedIcon3;
        int i;
        int selectedIcon2;
        int i13;
        Object obj7;
        Object obj8;
        int i5;
        boolean l;
        Object obj4;
        int copy;
        Object obj2;
        int border2;
        Object obj12;
        Object obj10;
        int obj3;
        int i2;
        Object obj9;
        int interactionSource2;
        Object obj16;
        int i4;
        int $dirty5;
        int i24;
        Composer restartGroup;
        Object obj5;
        boolean traceInProgress2;
        int i9;
        int i10;
        int i12;
        Composer composer;
        int i21;
        int i20;
        int $dirty17;
        int i22;
        int $dirty15;
        int i25;
        int $dirty13;
        int changed;
        int $dirty14;
        int i26;
        int $dirty1;
        int i8;
        int i27;
        int i6;
        int i23;
        boolean changedInstance2;
        int i7;
        int i19;
        Object obj14;
        Object obj11;
        int i11;
        int $dirty4;
        Object obj;
        int i18;
        int i14;
        int i15;
        ScopeUpdateScope scopeUpdateScope;
        Object obj37;
        long obj38;
        int obj39;
        boolean obj40;
        int obj41;
        int obj42;
        Object obj43;
        Object obj44;
        boolean obj45;
        Object obj47;
        traceInProgress = selected;
        Object obj17 = colors;
        int i33 = $changed;
        int i34 = i16;
        restartGroup = $composer.startRestartGroup(-1259208246);
        ComposerKt.sourceInformation(restartGroup, "C(FilterChip)P(8,7,6,3,4,10!2,5,9,11)190@8782L6,192@8909L18,199@9240L31,206@9478L34,210@9652L3966,200@9276L4342:Chip.kt#jmzs0o");
        $dirty2 = $changed;
        int i59 = $changed1;
        if (i34 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i33 & 6 == 0) {
                i13 = restartGroup.changed(traceInProgress) ? 4 : 2;
                $dirty2 |= i13;
            }
        }
        if (i34 & 2 != 0) {
            $dirty2 |= 48;
            obj7 = onClick;
        } else {
            if (i33 & 48 == 0) {
                i4 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty2 |= i4;
            } else {
                obj7 = onClick;
            }
        }
        $dirty5 = i34 & 4;
        if ($dirty5 != 0) {
            $dirty2 |= 384;
            obj5 = modifier;
        } else {
            if (i33 & 384 == 0) {
                i9 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i9;
            } else {
                obj5 = modifier;
            }
        }
        i10 = i34 & 8;
        if (i10 != 0) {
            $dirty2 |= 3072;
            l = enabled;
        } else {
            if (i33 & 3072 == 0) {
                i12 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i12;
            } else {
                l = enabled;
            }
        }
        i21 = i34 & 16;
        if (i21 != 0) {
            $dirty2 |= 24576;
            obj2 = interactionSource;
        } else {
            if (i33 & 24576 == 0) {
                i25 = restartGroup.changed(interactionSource) ? 16384 : 8192;
                $dirty2 |= i25;
            } else {
                obj2 = interactionSource;
            }
        }
        if (i33 & i87 == 0) {
            if (i34 & 32 == 0) {
                changed = restartGroup.changed(shape) ? 131072 : 65536;
            } else {
                obj10 = shape;
            }
            $dirty2 |= changed;
        } else {
            obj10 = shape;
        }
        int i89 = i34 & 64;
        $dirty14 = 1572864;
        if (i89 != 0) {
            $dirty2 |= $dirty14;
            obj9 = border;
        } else {
            if (i33 & $dirty14 == 0) {
                i26 = restartGroup.changed(border) ? 1048576 : 524288;
                $dirty2 |= i26;
            } else {
                obj9 = border;
            }
        }
        if (i33 & i92 == 0) {
            if (i34 & 128 == 0) {
                if (i41 &= i33 == 0) {
                    changedInstance = restartGroup.changed(obj17);
                } else {
                    changedInstance = restartGroup.changedInstance(obj17);
                }
                i17 = changedInstance != null ? 8388608 : 4194304;
            } else {
            }
            $dirty2 |= i17;
        }
        int i43 = i34 & 256;
        int i94 = 100663296;
        if (i43 != 0) {
            $dirty2 |= i94;
            $dirty1 = i59;
            $dirty16 = leadingIcon;
        } else {
            if (i33 & i94 == 0) {
                $dirty1 = i59;
                i8 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty2 |= i8;
            } else {
                $dirty1 = i59;
                $dirty16 = leadingIcon;
            }
        }
        int $dirty19 = i34 & 512;
        int i97 = 805306368;
        if ($dirty19 != 0) {
            $dirty2 |= i97;
            i27 = $dirty19;
            obj15 = selectedIcon;
        } else {
            if (i33 & i97 == 0) {
                i27 = $dirty19;
                i6 = restartGroup.changedInstance(selectedIcon) ? 536870912 : 268435456;
                $dirty2 |= i6;
            } else {
                i27 = $dirty19;
                obj15 = selectedIcon;
            }
        }
        int i60 = i34 & 1024;
        if (i60 != 0) {
            $dirty17 = $dirty1 | 6;
            i23 = i60;
            obj13 = trailingIcon;
        } else {
        }
        if (i34 & 2048 != 0) {
            $dirty17 |= 48;
            obj6 = content;
        } else {
            if ($changed1 & 48 == 0) {
                $dirty13 = restartGroup.changedInstance(content) ? 32 : 16;
                $dirty17 |= $dirty13;
            } else {
                obj6 = content;
            }
        }
        i = $dirty17;
        if ($dirty2 & $dirty15 == 306783378 && i & 19 == 18) {
            if (i & 19 == 18) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if ($dirty5 != 0) {
                                modifier4 = Modifier.Companion;
                            } else {
                                modifier4 = obj5;
                            }
                            enabled2 = i10 != 0 ? 1 : l;
                            obj14 = i21 != 0 ? l : obj2;
                            if (i34 & 32 != 0) {
                                obj11 = copy;
                                $dirty4 = $dirty2;
                            } else {
                                obj11 = obj10;
                                $dirty4 = $dirty2;
                            }
                            obj = i89 != 0 ? $dirty2 : obj9;
                            if (i34 & 128 != 0) {
                                $dirty15 = i;
                                changedInstance2 = restartGroup;
                                i14 = i27;
                                i15 = i23;
                                obj37 = modifier4;
                                modifier3 = i18;
                                $dirty3 = ChipDefaults.INSTANCE.filterChipColors-J08w3-E(0, obj7, 0, obj2, 0, obj9, 0, restartGroup, 0, i10, 0, $dirty15);
                                restartGroup = changedInstance2;
                                $dirty4 &= i;
                            } else {
                                obj37 = modifier4;
                                modifier3 = i;
                                i14 = i27;
                                i15 = i23;
                                $dirty3 = colors;
                            }
                            leadingIcon2 = i43 != 0 ? 0 : leadingIcon;
                            selectedIcon2 = i14 != 0 ? 0 : selectedIcon;
                            if (i15 != 0) {
                                l = enabled2;
                                i2 = i67;
                                obj16 = obj14;
                                i24 = $dirty4;
                                obj12 = obj;
                                enabled3 = obj37;
                                i5 = selectedIcon2;
                                selectedIcon3 = leadingIcon2;
                                leadingIcon3 = obj11;
                            } else {
                                i2 = trailingIcon;
                                l = enabled2;
                                i5 = selectedIcon2;
                                obj16 = obj14;
                                i24 = $dirty4;
                                obj12 = obj;
                                enabled3 = obj37;
                                selectedIcon3 = leadingIcon2;
                                leadingIcon3 = obj11;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i34 & 32 != 0) {
                                $dirty2 &= i3;
                            }
                            if (i34 & 128 != 0) {
                                obj16 = obj2;
                                obj12 = obj18;
                                $dirty3 = colors;
                                i5 = selectedIcon;
                                i24 = i31;
                                modifier3 = i;
                                leadingIcon3 = obj10;
                                enabled3 = obj5;
                                selectedIcon3 = leadingIcon;
                                i2 = trailingIcon;
                            } else {
                                obj16 = obj2;
                                obj12 = $dirty6;
                                i5 = selectedIcon;
                                i24 = $dirty2;
                                modifier3 = i;
                                leadingIcon3 = obj10;
                                enabled3 = obj5;
                                $dirty3 = colors;
                                selectedIcon3 = leadingIcon;
                                i2 = trailingIcon;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1259208246, i24, modifier3, "androidx.compose.material.FilterChip (Chip.kt:197)");
                    }
                    State contentColor = $dirty3.contentColor(l, traceInProgress, restartGroup, i75 |= i81);
                    i22 = modifier3;
                    int shape3 = 1;
                    obj37 = anon2;
                    obj44 = $dirty3;
                    obj39 = selectedIcon3;
                    obj41 = i5;
                    obj45 = l;
                    obj42 = i2;
                    obj38 = contentColor;
                    super(obj38, obj39, traceInProgress, obj41, obj42, content, obj44, obj45);
                    $dirty14 = obj38;
                    boolean z3 = obj45;
                    int i64 = i24 << 15;
                    Object obj19 = obj47;
                    i11 = i24;
                    SurfaceKt.Surface-Ny5ogXk(selected, onClick, SemanticsModifierKt.semantics$default(enabled3, false, (Function1)ChipKt.FilterChip.1.INSTANCE, shape3, 0), z3, obj19, (Color)$dirty3.backgroundColor(l, traceInProgress, restartGroup, i38 |= i85).getValue().unbox-impl(), i64, Color.copy-wmQWz5c$default((Color)contentColor.getValue().unbox-impl(), enabled, 1065353216, 0, 0, 0, 14), l, obj12, 0, obj16, (Function2)ComposableLambdaKt.rememberComposableLambda(722126431, shape3, obj37, restartGroup, 54), restartGroup, i48 | i57);
                    composer = restartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $dirty12 = obj19;
                    obj8 = obj12;
                    $dirty = obj16;
                    obj4 = $dirty1;
                    border2 = i27;
                    obj3 = i23;
                    interactionSource2 = changedInstance2;
                    shape2 = z3;
                    enabled4 = $dirty13;
                } else {
                    restartGroup.skipToGroupEnd();
                    i11 = $dirty2;
                    i22 = i;
                    shape2 = l;
                    $dirty = obj2;
                    $dirty12 = obj10;
                    obj8 = obj9;
                    composer = restartGroup;
                    enabled4 = obj5;
                    obj4 = colors;
                    border2 = leadingIcon;
                    obj3 = selectedIcon;
                    interactionSource2 = trailingIcon;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new ChipKt.FilterChip.3(selected, onClick, enabled4, shape2, $dirty, $dirty12, obj8, obj4, border2, obj3, interactionSource2, content, $changed, $changed1, i16);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final long access$Chip$lambda$0(State $contentColor$delegate) {
        return ChipKt.Chip$lambda$0($contentColor$delegate);
    }

    public static final float access$getHorizontalPadding$p() {
        return ChipKt.HorizontalPadding;
    }

    public static final float access$getLeadingIconEndSpacing$p() {
        return ChipKt.LeadingIconEndSpacing;
    }

    public static final float access$getLeadingIconStartSpacing$p() {
        return ChipKt.LeadingIconStartSpacing;
    }

    public static final float access$getSelectedIconContainerSize$p() {
        return ChipKt.SelectedIconContainerSize;
    }

    public static final float access$getTrailingIconSpacing$p() {
        return ChipKt.TrailingIconSpacing;
    }
}
