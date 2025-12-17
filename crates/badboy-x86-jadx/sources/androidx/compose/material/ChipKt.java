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
        Object obj2;
        int contentColor;
        int defaultsInvalid;
        Object shape2;
        int i2;
        boolean traceInProgress2;
        Object $composer2;
        Composer traceInProgress;
        int $dirty;
        int i6;
        Object $dirty3;
        Object obj5;
        boolean z;
        int i8;
        int $dirty2;
        Object obj;
        Object obj6;
        Object modifier2;
        int i10;
        int border2;
        Object colors2;
        boolean z2;
        Object leadingIcon2;
        int i9;
        Composer $composer3;
        Object obj7;
        Object obj9;
        int i3;
        Object iNSTANCE;
        int changed2;
        Object obj4;
        Object obj8;
        int i11;
        Object obj10;
        int changed;
        int i4;
        int i20;
        int $dirty4;
        int i13;
        long copy-wmQWz5c$default;
        int i15;
        int i;
        int i19;
        Object obj3;
        int i5;
        Composer composer2;
        Composer composer;
        int i17;
        int i14;
        int i16;
        int i7;
        int i18;
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
            obj5 = onClick;
        } else {
            if (i63 & 6 == 0) {
                i8 = traceInProgress.changedInstance(onClick) ? 4 : 2;
                $dirty |= i8;
            } else {
                obj5 = onClick;
            }
        }
        $dirty2 = i64 & 2;
        if ($dirty2 != 0) {
            $dirty |= 48;
            obj6 = modifier;
        } else {
            if (i63 & 48 == 0) {
                i10 = traceInProgress.changed(modifier) ? 32 : 16;
                $dirty |= i10;
            } else {
                obj6 = modifier;
            }
        }
        border2 = i64 & 4;
        if (border2 != 0) {
            $dirty |= 384;
            z2 = enabled;
        } else {
            if (i63 & 384 == 0) {
                i9 = traceInProgress.changed(enabled) ? 256 : 128;
                $dirty |= i9;
            } else {
                z2 = enabled;
            }
        }
        int i52 = i64 & 8;
        if (i52 != 0) {
            $dirty |= 3072;
            obj9 = interactionSource;
        } else {
            if (i63 & 3072 == 0) {
                i3 = traceInProgress.changed(interactionSource) ? 2048 : 1024;
                $dirty |= i3;
            } else {
                obj9 = interactionSource;
            }
        }
        if (i63 & 24576 == 0) {
            if (i64 & 16 == 0) {
                changed2 = traceInProgress.changed(shape) ? 16384 : 8192;
            } else {
                iNSTANCE = shape;
            }
            $dirty |= changed2;
        } else {
            iNSTANCE = shape;
        }
        int i70 = i64 & 32;
        int i72 = 196608;
        if (i70 != 0) {
            $dirty |= i72;
            obj8 = border;
        } else {
            if (i72 &= i63 == 0) {
                i11 = traceInProgress.changed(border) ? 131072 : 65536;
                $dirty |= i11;
            } else {
                obj8 = border;
            }
        }
        if (i74 &= i63 == 0) {
            if (i64 & 64 == 0) {
                changed = traceInProgress.changed(colors) ? 1048576 : 524288;
            } else {
                obj10 = colors;
            }
            $dirty |= changed;
        } else {
            obj10 = colors;
        }
        int i22 = i64 & 128;
        i4 = 12582912;
        if (i22 != 0) {
            $dirty |= i4;
            obj40 = i70;
            obj4 = leadingIcon;
        } else {
            if (i63 & i4 == 0) {
                obj40 = i70;
                i4 = traceInProgress.changedInstance(leadingIcon) ? 8388608 : 4194304;
                $dirty |= i4;
            } else {
                obj40 = i70;
                obj4 = leadingIcon;
            }
        }
        i20 = 100663296;
        if (i64 & 256 != 0) {
            $dirty |= i20;
            obj2 = content;
        } else {
            if (i63 & i20 == 0) {
                i20 = traceInProgress.changedInstance(content) ? 67108864 : 33554432;
                $dirty |= i20;
            } else {
                obj2 = content;
            }
        }
        $dirty4 = $dirty;
        if ($dirty & i77 == 38347922) {
            if (!traceInProgress.getSkipping()) {
                traceInProgress.startDefaults();
                int i34 = -3670017;
                i13 = -57345;
                if (i63 & 1 != 0) {
                    if (traceInProgress.getDefaultsInvalid()) {
                        if ($dirty2 != 0) {
                            obj6 = defaultsInvalid;
                        }
                        if (border2 != 0) {
                            z2 = defaultsInvalid;
                        }
                        if (i52 != 0) {
                            obj9 = defaultsInvalid;
                        }
                        if (i64 & 16 != 0) {
                            shape2 = MaterialTheme.INSTANCE.getShapes(traceInProgress, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            $dirty2 = $dirty4 & i13;
                        } else {
                            shape2 = iNSTANCE;
                            $dirty2 = $dirty4;
                        }
                        border2 = obj40 != null ? 0 : obj8;
                        if (i64 & 64 != 0) {
                            composer = traceInProgress;
                            $composer2 = ChipDefaults.INSTANCE.chipColors-5tl4gsc(0, obj8, 0, $dirty4, 0, obj18, 0, obj20, 0);
                            $composer3 = composer;
                            $dirty2 &= i34;
                        } else {
                            $composer3 = traceInProgress;
                            $composer2 = colors;
                        }
                        if (i22 != 0) {
                            obj10 = shape2;
                            obj4 = i35;
                            i6 = $dirty2;
                            i = border2;
                            obj8 = z2;
                            obj3 = obj9;
                        } else {
                            obj4 = leadingIcon;
                            obj10 = shape2;
                            i6 = $dirty2;
                            i = border2;
                            obj8 = z2;
                            obj3 = obj9;
                        }
                    } else {
                        traceInProgress.skipToGroupEnd();
                        if (i64 & 16 != 0) {
                            $dirty4 = i2;
                        }
                        if (i64 & 64 != 0) {
                            i6 = shape2;
                            $composer3 = traceInProgress;
                            obj3 = obj9;
                            i = obj8;
                            $composer2 = obj10;
                            obj8 = z2;
                            obj10 = iNSTANCE;
                        } else {
                            $composer3 = traceInProgress;
                            obj3 = obj9;
                            i = obj8;
                            $composer2 = obj10;
                            i6 = $dirty4;
                            obj8 = z2;
                            obj10 = iNSTANCE;
                        }
                    }
                } else {
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-368396408, i6, -1, "androidx.compose.material.Chip (Chip.kt:98)");
                }
                contentColor = $composer2.contentColor(obj8, $composer3, i27 |= i41);
                int i55 = 1;
                obj35 = $composer2;
                obj32 = anon2;
                obj34 = obj4;
                super(contentColor, obj34, obj35, obj8, content);
                SurfaceKt.Surface-LPr_se0(obj5, SemanticsModifierKt.semantics$default(obj6, false, (Function1)ChipKt.Chip.1.INSTANCE, i55, 0), obj8, obj10, (Color)$composer2.backgroundColor(obj8, $composer3, i45 |= i50).getValue().unbox-impl(), i13, Color.copy-wmQWz5c$default(ChipKt.Chip$lambda$0(contentColor), obj24, 1065353216, 0, 0, 0, 14), i15, i, 0, obj3, (Function2)ComposableLambdaKt.rememberComposableLambda(139076687, i55, obj32, $composer3, 54), $composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty4 = i6;
                $dirty3 = obj6;
                obj7 = i51;
                z = obj8;
                modifier2 = obj10;
                obj = obj3;
                leadingIcon2 = chipColors;
                colors2 = i;
            } else {
                traceInProgress.skipToGroupEnd();
                composer2 = traceInProgress;
                $dirty3 = obj6;
                z = z2;
                obj = obj9;
                modifier2 = iNSTANCE;
                obj7 = obj4;
                colors2 = obj8;
                leadingIcon2 = obj10;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            contentColor = new ChipKt.Chip.3(onClick, $dirty3, z, obj, modifier2, colors2, leadingIcon2, obj7, content, i63, i64);
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
        boolean traceInProgress2;
        Object endRestartGroup;
        Object obj;
        boolean skipping;
        int modifier2;
        int defaultsInvalid;
        Object modifier4;
        int i5;
        int modifier3;
        Object enabled4;
        boolean enabled3;
        Object enabled2;
        int changedInstance;
        int i9;
        boolean shape2;
        Object leadingIcon3;
        int leadingIcon2;
        int $dirty;
        Object $dirty3;
        Object $dirty2;
        Object $dirty16;
        Object obj6;
        Object obj9;
        Object $dirty15;
        int selectedIcon3;
        int i27;
        int selectedIcon2;
        int i14;
        Object obj11;
        Object obj12;
        int i13;
        boolean l;
        Object obj4;
        int copy;
        Object obj5;
        int border2;
        Object obj3;
        Object obj8;
        int obj7;
        int i3;
        Object obj13;
        int interactionSource2;
        Object obj10;
        int i22;
        int $dirty5;
        int i21;
        Composer restartGroup;
        Object obj16;
        boolean traceInProgress;
        int i6;
        int i7;
        int i23;
        Composer composer;
        int i25;
        int i8;
        int $dirty14;
        int i15;
        int $dirty13;
        int i18;
        int $dirty1;
        int changed;
        int $dirty12;
        int i10;
        int $dirty17;
        int i17;
        int i12;
        int i11;
        int i24;
        boolean changedInstance2;
        int i;
        int i4;
        Object obj15;
        Object obj2;
        int i2;
        int $dirty4;
        Object obj14;
        int i26;
        int i20;
        int i19;
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
        traceInProgress2 = selected;
        Object obj17 = colors;
        int i33 = $changed;
        int i34 = i16;
        restartGroup = $composer.startRestartGroup(-1259208246);
        ComposerKt.sourceInformation(restartGroup, "C(FilterChip)P(8,7,6,3,4,10!2,5,9,11)190@8782L6,192@8909L18,199@9240L31,206@9478L34,210@9652L3966,200@9276L4342:Chip.kt#jmzs0o");
        $dirty = $changed;
        int i59 = $changed1;
        if (i34 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i33 & 6 == 0) {
                i14 = restartGroup.changed(traceInProgress2) ? 4 : 2;
                $dirty |= i14;
            }
        }
        if (i34 & 2 != 0) {
            $dirty |= 48;
            obj11 = onClick;
        } else {
            if (i33 & 48 == 0) {
                i22 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty |= i22;
            } else {
                obj11 = onClick;
            }
        }
        $dirty5 = i34 & 4;
        if ($dirty5 != 0) {
            $dirty |= 384;
            obj16 = modifier;
        } else {
            if (i33 & 384 == 0) {
                i6 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i6;
            } else {
                obj16 = modifier;
            }
        }
        i7 = i34 & 8;
        if (i7 != 0) {
            $dirty |= 3072;
            l = enabled;
        } else {
            if (i33 & 3072 == 0) {
                i23 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i23;
            } else {
                l = enabled;
            }
        }
        i25 = i34 & 16;
        if (i25 != 0) {
            $dirty |= 24576;
            obj5 = interactionSource;
        } else {
            if (i33 & 24576 == 0) {
                i18 = restartGroup.changed(interactionSource) ? 16384 : 8192;
                $dirty |= i18;
            } else {
                obj5 = interactionSource;
            }
        }
        if (i33 & i87 == 0) {
            if (i34 & 32 == 0) {
                changed = restartGroup.changed(shape) ? 131072 : 65536;
            } else {
                obj8 = shape;
            }
            $dirty |= changed;
        } else {
            obj8 = shape;
        }
        int i89 = i34 & 64;
        $dirty12 = 1572864;
        if (i89 != 0) {
            $dirty |= $dirty12;
            obj13 = border;
        } else {
            if (i33 & $dirty12 == 0) {
                i10 = restartGroup.changed(border) ? 1048576 : 524288;
                $dirty |= i10;
            } else {
                obj13 = border;
            }
        }
        if (i33 & i92 == 0) {
            if (i34 & 128 == 0) {
                if (i41 &= i33 == 0) {
                    changedInstance = restartGroup.changed(obj17);
                } else {
                    changedInstance = restartGroup.changedInstance(obj17);
                }
                i9 = changedInstance != null ? 8388608 : 4194304;
            } else {
            }
            $dirty |= i9;
        }
        int i43 = i34 & 256;
        int i94 = 100663296;
        if (i43 != 0) {
            $dirty |= i94;
            $dirty17 = i59;
            $dirty16 = leadingIcon;
        } else {
            if (i33 & i94 == 0) {
                $dirty17 = i59;
                i17 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i17;
            } else {
                $dirty17 = i59;
                $dirty16 = leadingIcon;
            }
        }
        int $dirty19 = i34 & 512;
        int i97 = 805306368;
        if ($dirty19 != 0) {
            $dirty |= i97;
            i12 = $dirty19;
            obj6 = selectedIcon;
        } else {
            if (i33 & i97 == 0) {
                i12 = $dirty19;
                i11 = restartGroup.changedInstance(selectedIcon) ? 536870912 : 268435456;
                $dirty |= i11;
            } else {
                i12 = $dirty19;
                obj6 = selectedIcon;
            }
        }
        int i60 = i34 & 1024;
        if (i60 != 0) {
            $dirty14 = $dirty17 | 6;
            i24 = i60;
            obj9 = trailingIcon;
        } else {
        }
        if (i34 & 2048 != 0) {
            $dirty14 |= 48;
            obj = content;
        } else {
            if ($changed1 & 48 == 0) {
                $dirty1 = restartGroup.changedInstance(content) ? 32 : 16;
                $dirty14 |= $dirty1;
            } else {
                obj = content;
            }
        }
        i27 = $dirty14;
        if ($dirty & $dirty13 == 306783378 && i27 & 19 == 18) {
            if (i27 & 19 == 18) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if ($dirty5 != 0) {
                                modifier4 = Modifier.Companion;
                            } else {
                                modifier4 = obj16;
                            }
                            enabled3 = i7 != 0 ? 1 : l;
                            obj15 = i25 != 0 ? l : obj5;
                            if (i34 & 32 != 0) {
                                obj2 = copy;
                                $dirty4 = $dirty;
                            } else {
                                obj2 = obj8;
                                $dirty4 = $dirty;
                            }
                            obj14 = i89 != 0 ? $dirty : obj13;
                            if (i34 & 128 != 0) {
                                $dirty13 = i27;
                                changedInstance2 = restartGroup;
                                i20 = i12;
                                i19 = i24;
                                obj37 = modifier4;
                                modifier2 = i26;
                                $dirty2 = ChipDefaults.INSTANCE.filterChipColors-J08w3-E(0, obj11, 0, obj5, 0, obj13, 0, restartGroup, 0, i7, 0, $dirty13);
                                restartGroup = changedInstance2;
                                $dirty4 &= i27;
                            } else {
                                obj37 = modifier4;
                                modifier2 = i27;
                                i20 = i12;
                                i19 = i24;
                                $dirty2 = colors;
                            }
                            leadingIcon2 = i43 != 0 ? 0 : leadingIcon;
                            selectedIcon2 = i20 != 0 ? 0 : selectedIcon;
                            if (i19 != 0) {
                                l = enabled3;
                                i3 = i67;
                                obj10 = obj15;
                                i21 = $dirty4;
                                obj3 = obj14;
                                enabled4 = obj37;
                                i13 = selectedIcon2;
                                selectedIcon3 = leadingIcon2;
                                leadingIcon3 = obj2;
                            } else {
                                i3 = trailingIcon;
                                l = enabled3;
                                i13 = selectedIcon2;
                                obj10 = obj15;
                                i21 = $dirty4;
                                obj3 = obj14;
                                enabled4 = obj37;
                                selectedIcon3 = leadingIcon2;
                                leadingIcon3 = obj2;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i34 & 32 != 0) {
                                $dirty &= i5;
                            }
                            if (i34 & 128 != 0) {
                                obj10 = obj5;
                                obj3 = obj18;
                                $dirty2 = colors;
                                i13 = selectedIcon;
                                i21 = i31;
                                modifier2 = i27;
                                leadingIcon3 = obj8;
                                enabled4 = obj16;
                                selectedIcon3 = leadingIcon;
                                i3 = trailingIcon;
                            } else {
                                obj10 = obj5;
                                obj3 = $dirty6;
                                i13 = selectedIcon;
                                i21 = $dirty;
                                modifier2 = i27;
                                leadingIcon3 = obj8;
                                enabled4 = obj16;
                                $dirty2 = colors;
                                selectedIcon3 = leadingIcon;
                                i3 = trailingIcon;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1259208246, i21, modifier2, "androidx.compose.material.FilterChip (Chip.kt:197)");
                    }
                    State contentColor = $dirty2.contentColor(l, traceInProgress2, restartGroup, i75 |= i81);
                    i15 = modifier2;
                    int shape3 = 1;
                    obj37 = anon2;
                    obj44 = $dirty2;
                    obj39 = selectedIcon3;
                    obj41 = i13;
                    obj45 = l;
                    obj42 = i3;
                    obj38 = contentColor;
                    super(obj38, obj39, traceInProgress2, obj41, obj42, content, obj44, obj45);
                    $dirty12 = obj38;
                    boolean z3 = obj45;
                    int i64 = i21 << 15;
                    Object obj19 = obj47;
                    i2 = i21;
                    SurfaceKt.Surface-Ny5ogXk(selected, onClick, SemanticsModifierKt.semantics$default(enabled4, false, (Function1)ChipKt.FilterChip.1.INSTANCE, shape3, 0), z3, obj19, (Color)$dirty2.backgroundColor(l, traceInProgress2, restartGroup, i38 |= i85).getValue().unbox-impl(), i64, Color.copy-wmQWz5c$default((Color)contentColor.getValue().unbox-impl(), enabled, 1065353216, 0, 0, 0, 14), l, obj3, 0, obj10, (Function2)ComposableLambdaKt.rememberComposableLambda(722126431, shape3, obj37, restartGroup, 54), restartGroup, i48 | i57);
                    composer = restartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $dirty15 = obj19;
                    obj12 = obj3;
                    $dirty3 = obj10;
                    obj4 = $dirty17;
                    border2 = i12;
                    obj7 = i24;
                    interactionSource2 = changedInstance2;
                    shape2 = z3;
                    enabled2 = $dirty1;
                } else {
                    restartGroup.skipToGroupEnd();
                    i2 = $dirty;
                    i15 = i27;
                    shape2 = l;
                    $dirty3 = obj5;
                    $dirty15 = obj8;
                    obj12 = obj13;
                    composer = restartGroup;
                    enabled2 = obj16;
                    obj4 = colors;
                    border2 = leadingIcon;
                    obj7 = selectedIcon;
                    interactionSource2 = trailingIcon;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new ChipKt.FilterChip.3(selected, onClick, enabled2, shape2, $dirty3, $dirty15, obj12, obj4, border2, obj7, interactionSource2, content, $changed, $changed1, i16);
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
