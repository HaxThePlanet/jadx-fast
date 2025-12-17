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
        Object obj9;
        int contentColor;
        int defaultsInvalid;
        Object shape2;
        int i19;
        boolean traceInProgress;
        Object $composer2;
        Composer traceInProgress2;
        int $dirty;
        int i18;
        Object $dirty2;
        Object obj3;
        boolean z;
        int i10;
        int $dirty3;
        Object obj2;
        Object obj5;
        Object modifier2;
        int i11;
        int border2;
        Object colors2;
        boolean z2;
        Object leadingIcon2;
        int i13;
        Composer $composer3;
        Object obj4;
        Object obj7;
        int i9;
        Object iNSTANCE;
        int changed2;
        Object obj10;
        Object obj8;
        int i17;
        Object obj6;
        int changed;
        int i6;
        int i20;
        int $dirty4;
        int i7;
        long copy-wmQWz5c$default;
        int i14;
        int i15;
        int i16;
        Object obj;
        int i4;
        Composer composer;
        Composer composer2;
        int i;
        int i2;
        int i8;
        int i3;
        int i5;
        Object obj32;
        State obj33;
        int obj34;
        Object obj35;
        boolean obj36;
        Object obj37;
        int obj40;
        final int i63 = $changed;
        final int i64 = i12;
        traceInProgress2 = $composer.startRestartGroup(-368396408);
        ComposerKt.sourceInformation(traceInProgress2, "C(Chip)P(7,6,3,4,8!2,5)93@4288L6,95@4405L12,99@4550L21,105@4747L24,109@4905L1458,100@4576L1787:Chip.kt#jmzs0o");
        $dirty = $changed;
        if (i64 & 1 != 0) {
            $dirty |= 6;
            obj3 = onClick;
        } else {
            if (i63 & 6 == 0) {
                i10 = traceInProgress2.changedInstance(onClick) ? 4 : 2;
                $dirty |= i10;
            } else {
                obj3 = onClick;
            }
        }
        $dirty3 = i64 & 2;
        if ($dirty3 != 0) {
            $dirty |= 48;
            obj5 = modifier;
        } else {
            if (i63 & 48 == 0) {
                i11 = traceInProgress2.changed(modifier) ? 32 : 16;
                $dirty |= i11;
            } else {
                obj5 = modifier;
            }
        }
        border2 = i64 & 4;
        if (border2 != 0) {
            $dirty |= 384;
            z2 = enabled;
        } else {
            if (i63 & 384 == 0) {
                i13 = traceInProgress2.changed(enabled) ? 256 : 128;
                $dirty |= i13;
            } else {
                z2 = enabled;
            }
        }
        int i52 = i64 & 8;
        if (i52 != 0) {
            $dirty |= 3072;
            obj7 = interactionSource;
        } else {
            if (i63 & 3072 == 0) {
                i9 = traceInProgress2.changed(interactionSource) ? 2048 : 1024;
                $dirty |= i9;
            } else {
                obj7 = interactionSource;
            }
        }
        if (i63 & 24576 == 0) {
            if (i64 & 16 == 0) {
                changed2 = traceInProgress2.changed(shape) ? 16384 : 8192;
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
                i17 = traceInProgress2.changed(border) ? 131072 : 65536;
                $dirty |= i17;
            } else {
                obj8 = border;
            }
        }
        if (i74 &= i63 == 0) {
            if (i64 & 64 == 0) {
                changed = traceInProgress2.changed(colors) ? 1048576 : 524288;
            } else {
                obj6 = colors;
            }
            $dirty |= changed;
        } else {
            obj6 = colors;
        }
        int i22 = i64 & 128;
        i6 = 12582912;
        if (i22 != 0) {
            $dirty |= i6;
            obj40 = i70;
            obj10 = leadingIcon;
        } else {
            if (i63 & i6 == 0) {
                obj40 = i70;
                i6 = traceInProgress2.changedInstance(leadingIcon) ? 8388608 : 4194304;
                $dirty |= i6;
            } else {
                obj40 = i70;
                obj10 = leadingIcon;
            }
        }
        i20 = 100663296;
        if (i64 & 256 != 0) {
            $dirty |= i20;
            obj9 = content;
        } else {
            if (i63 & i20 == 0) {
                i20 = traceInProgress2.changedInstance(content) ? 67108864 : 33554432;
                $dirty |= i20;
            } else {
                obj9 = content;
            }
        }
        $dirty4 = $dirty;
        if ($dirty & i77 == 38347922) {
            if (!traceInProgress2.getSkipping()) {
                traceInProgress2.startDefaults();
                int i34 = -3670017;
                i7 = -57345;
                if (i63 & 1 != 0) {
                    if (traceInProgress2.getDefaultsInvalid()) {
                        if ($dirty3 != 0) {
                            obj5 = defaultsInvalid;
                        }
                        if (border2 != 0) {
                            z2 = defaultsInvalid;
                        }
                        if (i52 != 0) {
                            obj7 = defaultsInvalid;
                        }
                        if (i64 & 16 != 0) {
                            shape2 = MaterialTheme.INSTANCE.getShapes(traceInProgress2, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            $dirty3 = $dirty4 & i7;
                        } else {
                            shape2 = iNSTANCE;
                            $dirty3 = $dirty4;
                        }
                        border2 = obj40 != null ? 0 : obj8;
                        if (i64 & 64 != 0) {
                            composer2 = traceInProgress2;
                            $composer2 = ChipDefaults.INSTANCE.chipColors-5tl4gsc(0, obj8, 0, $dirty4, 0, obj18, 0, obj20, 0);
                            $composer3 = composer2;
                            $dirty3 &= i34;
                        } else {
                            $composer3 = traceInProgress2;
                            $composer2 = colors;
                        }
                        if (i22 != 0) {
                            obj6 = shape2;
                            obj10 = i35;
                            i18 = $dirty3;
                            i15 = border2;
                            obj8 = z2;
                            obj = obj7;
                        } else {
                            obj10 = leadingIcon;
                            obj6 = shape2;
                            i18 = $dirty3;
                            i15 = border2;
                            obj8 = z2;
                            obj = obj7;
                        }
                    } else {
                        traceInProgress2.skipToGroupEnd();
                        if (i64 & 16 != 0) {
                            $dirty4 = i19;
                        }
                        if (i64 & 64 != 0) {
                            i18 = shape2;
                            $composer3 = traceInProgress2;
                            obj = obj7;
                            i15 = obj8;
                            $composer2 = obj6;
                            obj8 = z2;
                            obj6 = iNSTANCE;
                        } else {
                            $composer3 = traceInProgress2;
                            obj = obj7;
                            i15 = obj8;
                            $composer2 = obj6;
                            i18 = $dirty4;
                            obj8 = z2;
                            obj6 = iNSTANCE;
                        }
                    }
                } else {
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-368396408, i18, -1, "androidx.compose.material.Chip (Chip.kt:98)");
                }
                contentColor = $composer2.contentColor(obj8, $composer3, i27 |= i41);
                int i55 = 1;
                obj35 = $composer2;
                obj32 = anon2;
                obj34 = obj10;
                super(contentColor, obj34, obj35, obj8, content);
                SurfaceKt.Surface-LPr_se0(obj3, SemanticsModifierKt.semantics$default(obj5, false, (Function1)ChipKt.Chip.1.INSTANCE, i55, 0), obj8, obj6, (Color)$composer2.backgroundColor(obj8, $composer3, i45 |= i50).getValue().unbox-impl(), i7, Color.copy-wmQWz5c$default(ChipKt.Chip$lambda$0(contentColor), obj24, 1065353216, 0, 0, 0, 14), i14, i15, 0, obj, (Function2)ComposableLambdaKt.rememberComposableLambda(139076687, i55, obj32, $composer3, 54), $composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty4 = i18;
                $dirty2 = obj5;
                obj4 = i51;
                z = obj8;
                modifier2 = obj6;
                obj2 = obj;
                leadingIcon2 = chipColors;
                colors2 = i15;
            } else {
                traceInProgress2.skipToGroupEnd();
                composer = traceInProgress2;
                $dirty2 = obj5;
                z = z2;
                obj2 = obj7;
                modifier2 = iNSTANCE;
                obj4 = obj10;
                colors2 = obj8;
                leadingIcon2 = obj6;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            contentColor = new ChipKt.Chip.3(onClick, $dirty2, z, obj2, modifier2, colors2, leadingIcon2, obj4, content, i63, i64);
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
        Object obj6;
        boolean skipping;
        int modifier4;
        int defaultsInvalid;
        Object modifier3;
        int i5;
        int modifier2;
        Object enabled3;
        boolean enabled4;
        Object enabled2;
        int changedInstance2;
        int i20;
        boolean shape2;
        Object leadingIcon3;
        int leadingIcon2;
        int $dirty;
        Object $dirty4;
        Object $dirty3;
        Object $dirty1;
        Object obj9;
        Object obj4;
        Object $dirty12;
        int selectedIcon2;
        int i;
        int selectedIcon3;
        int i11;
        Object obj3;
        Object obj;
        int i14;
        boolean l;
        Object obj7;
        int copy;
        Object obj8;
        int border2;
        Object obj2;
        Object obj11;
        int obj10;
        int i15;
        Object obj16;
        int interactionSource2;
        Object obj13;
        int i21;
        int $dirty2;
        int i4;
        Composer restartGroup;
        Object obj12;
        boolean traceInProgress;
        int i13;
        int i3;
        int i9;
        Composer composer;
        int i17;
        int i2;
        int $dirty13;
        int i8;
        int $dirty15;
        int i7;
        int $dirty14;
        int changed;
        int $dirty17;
        int i27;
        int $dirty16;
        int i10;
        int i22;
        int i24;
        int i18;
        boolean changedInstance;
        int i26;
        int i23;
        Object obj5;
        Object obj14;
        int i19;
        int $dirty5;
        Object obj15;
        int i25;
        int i12;
        int i6;
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
                i11 = restartGroup.changed(traceInProgress2) ? 4 : 2;
                $dirty |= i11;
            }
        }
        if (i34 & 2 != 0) {
            $dirty |= 48;
            obj3 = onClick;
        } else {
            if (i33 & 48 == 0) {
                i21 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty |= i21;
            } else {
                obj3 = onClick;
            }
        }
        $dirty2 = i34 & 4;
        if ($dirty2 != 0) {
            $dirty |= 384;
            obj12 = modifier;
        } else {
            if (i33 & 384 == 0) {
                i13 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i13;
            } else {
                obj12 = modifier;
            }
        }
        i3 = i34 & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            l = enabled;
        } else {
            if (i33 & 3072 == 0) {
                i9 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i9;
            } else {
                l = enabled;
            }
        }
        i17 = i34 & 16;
        if (i17 != 0) {
            $dirty |= 24576;
            obj8 = interactionSource;
        } else {
            if (i33 & 24576 == 0) {
                i7 = restartGroup.changed(interactionSource) ? 16384 : 8192;
                $dirty |= i7;
            } else {
                obj8 = interactionSource;
            }
        }
        if (i33 & i87 == 0) {
            if (i34 & 32 == 0) {
                changed = restartGroup.changed(shape) ? 131072 : 65536;
            } else {
                obj11 = shape;
            }
            $dirty |= changed;
        } else {
            obj11 = shape;
        }
        int i89 = i34 & 64;
        $dirty17 = 1572864;
        if (i89 != 0) {
            $dirty |= $dirty17;
            obj16 = border;
        } else {
            if (i33 & $dirty17 == 0) {
                i27 = restartGroup.changed(border) ? 1048576 : 524288;
                $dirty |= i27;
            } else {
                obj16 = border;
            }
        }
        if (i33 & i92 == 0) {
            if (i34 & 128 == 0) {
                if (i41 &= i33 == 0) {
                    changedInstance2 = restartGroup.changed(obj17);
                } else {
                    changedInstance2 = restartGroup.changedInstance(obj17);
                }
                i20 = changedInstance2 ? 8388608 : 4194304;
            } else {
            }
            $dirty |= i20;
        }
        int i43 = i34 & 256;
        int i94 = 100663296;
        if (i43 != 0) {
            $dirty |= i94;
            $dirty16 = i59;
            $dirty1 = leadingIcon;
        } else {
            if (i33 & i94 == 0) {
                $dirty16 = i59;
                i10 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i10;
            } else {
                $dirty16 = i59;
                $dirty1 = leadingIcon;
            }
        }
        int $dirty19 = i34 & 512;
        int i97 = 805306368;
        if ($dirty19 != 0) {
            $dirty |= i97;
            i22 = $dirty19;
            obj9 = selectedIcon;
        } else {
            if (i33 & i97 == 0) {
                i22 = $dirty19;
                i24 = restartGroup.changedInstance(selectedIcon) ? 536870912 : 268435456;
                $dirty |= i24;
            } else {
                i22 = $dirty19;
                obj9 = selectedIcon;
            }
        }
        int i60 = i34 & 1024;
        if (i60 != 0) {
            $dirty13 = $dirty16 | 6;
            i18 = i60;
            obj4 = trailingIcon;
        } else {
        }
        if (i34 & 2048 != 0) {
            $dirty13 |= 48;
            obj6 = content;
        } else {
            if ($changed1 & 48 == 0) {
                $dirty14 = restartGroup.changedInstance(content) ? 32 : 16;
                $dirty13 |= $dirty14;
            } else {
                obj6 = content;
            }
        }
        i = $dirty13;
        if ($dirty & $dirty15 == 306783378 && i & 19 == 18) {
            if (i & 19 == 18) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if ($dirty2 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = obj12;
                            }
                            enabled4 = i3 != 0 ? 1 : l;
                            obj5 = i17 != 0 ? l : obj8;
                            if (i34 & 32 != 0) {
                                obj14 = copy;
                                $dirty5 = $dirty;
                            } else {
                                obj14 = obj11;
                                $dirty5 = $dirty;
                            }
                            obj15 = i89 != 0 ? $dirty : obj16;
                            if (i34 & 128 != 0) {
                                $dirty15 = i;
                                changedInstance = restartGroup;
                                i12 = i22;
                                i6 = i18;
                                obj37 = modifier3;
                                modifier4 = i25;
                                $dirty3 = ChipDefaults.INSTANCE.filterChipColors-J08w3-E(0, obj3, 0, obj8, 0, obj16, 0, restartGroup, 0, i3, 0, $dirty15);
                                restartGroup = changedInstance;
                                $dirty5 &= i;
                            } else {
                                obj37 = modifier3;
                                modifier4 = i;
                                i12 = i22;
                                i6 = i18;
                                $dirty3 = colors;
                            }
                            leadingIcon2 = i43 != 0 ? 0 : leadingIcon;
                            selectedIcon3 = i12 != 0 ? 0 : selectedIcon;
                            if (i6 != 0) {
                                l = enabled4;
                                i15 = i67;
                                obj13 = obj5;
                                i4 = $dirty5;
                                obj2 = obj15;
                                enabled3 = obj37;
                                i14 = selectedIcon3;
                                selectedIcon2 = leadingIcon2;
                                leadingIcon3 = obj14;
                            } else {
                                i15 = trailingIcon;
                                l = enabled4;
                                i14 = selectedIcon3;
                                obj13 = obj5;
                                i4 = $dirty5;
                                obj2 = obj15;
                                enabled3 = obj37;
                                selectedIcon2 = leadingIcon2;
                                leadingIcon3 = obj14;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i34 & 32 != 0) {
                                $dirty &= i5;
                            }
                            if (i34 & 128 != 0) {
                                obj13 = obj8;
                                obj2 = obj18;
                                $dirty3 = colors;
                                i14 = selectedIcon;
                                i4 = i31;
                                modifier4 = i;
                                leadingIcon3 = obj11;
                                enabled3 = obj12;
                                selectedIcon2 = leadingIcon;
                                i15 = trailingIcon;
                            } else {
                                obj13 = obj8;
                                obj2 = $dirty6;
                                i14 = selectedIcon;
                                i4 = $dirty;
                                modifier4 = i;
                                leadingIcon3 = obj11;
                                enabled3 = obj12;
                                $dirty3 = colors;
                                selectedIcon2 = leadingIcon;
                                i15 = trailingIcon;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1259208246, i4, modifier4, "androidx.compose.material.FilterChip (Chip.kt:197)");
                    }
                    State contentColor = $dirty3.contentColor(l, traceInProgress2, restartGroup, i75 |= i81);
                    i8 = modifier4;
                    int shape3 = 1;
                    obj37 = anon2;
                    obj44 = $dirty3;
                    obj39 = selectedIcon2;
                    obj41 = i14;
                    obj45 = l;
                    obj42 = i15;
                    obj38 = contentColor;
                    super(obj38, obj39, traceInProgress2, obj41, obj42, content, obj44, obj45);
                    $dirty17 = obj38;
                    boolean z3 = obj45;
                    int i64 = i4 << 15;
                    Object obj19 = obj47;
                    i19 = i4;
                    SurfaceKt.Surface-Ny5ogXk(selected, onClick, SemanticsModifierKt.semantics$default(enabled3, false, (Function1)ChipKt.FilterChip.1.INSTANCE, shape3, 0), z3, obj19, (Color)$dirty3.backgroundColor(l, traceInProgress2, restartGroup, i38 |= i85).getValue().unbox-impl(), i64, Color.copy-wmQWz5c$default((Color)contentColor.getValue().unbox-impl(), enabled, 1065353216, 0, 0, 0, 14), l, obj2, 0, obj13, (Function2)ComposableLambdaKt.rememberComposableLambda(722126431, shape3, obj37, restartGroup, 54), restartGroup, i48 | i57);
                    composer = restartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $dirty12 = obj19;
                    obj = obj2;
                    $dirty4 = obj13;
                    obj7 = $dirty16;
                    border2 = i22;
                    obj10 = i18;
                    interactionSource2 = changedInstance;
                    shape2 = z3;
                    enabled2 = $dirty14;
                } else {
                    restartGroup.skipToGroupEnd();
                    i19 = $dirty;
                    i8 = i;
                    shape2 = l;
                    $dirty4 = obj8;
                    $dirty12 = obj11;
                    obj = obj16;
                    composer = restartGroup;
                    enabled2 = obj12;
                    obj7 = colors;
                    border2 = leadingIcon;
                    obj10 = selectedIcon;
                    interactionSource2 = trailingIcon;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new ChipKt.FilterChip.3(selected, onClick, enabled2, shape2, $dirty4, $dirty12, obj, obj7, border2, obj10, interactionSource2, content, $changed, $changed1, i16);
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
