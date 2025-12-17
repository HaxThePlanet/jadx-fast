package androidx.compose.material3;

import androidx.compose.animation.core.SnapSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.Role.Companion;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001al\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0015\u0008\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0002\u0010\u001f\u001aR\u0010 \u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0006\u0010\u001d\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0003¢\u0006\u0002\u0010$\"\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0010\u0010\u0008\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0016\u0010\t\u001a\u00020\u0006X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\n\u0010\u000b\"\u0010\u0010\u000c\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0016\u0010\r\u001a\u00020\u0006X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000e\u0010\u000b¨\u0006%", d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "SnapSpec", "Landroidx/compose/animation/core/SnapSpec;", "SwitchHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchWidth", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPadding", "UncheckedThumbDiameter", "getUncheckedThumbDiameter", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "thumbContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "enabled", "colors", "Landroidx/compose/material3/SwitchColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/SwitchColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/interaction/InteractionSource;", "thumbShape", "Landroidx/compose/ui/graphics/Shape;", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/material3/SwitchColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SwitchKt {

    private static final TweenSpec<Float> AnimationSpec;
    private static final SnapSpec<Float> SnapSpec;
    private static final float SwitchHeight;
    private static final float SwitchWidth;
    private static final float ThumbDiameter;
    private static final float ThumbPadding;
    private static final float UncheckedThumbDiameter;
    static {
        SwitchKt.ThumbDiameter = SwitchTokens.INSTANCE.getSelectedHandleWidth-D9Ej5fM();
        SwitchKt.UncheckedThumbDiameter = SwitchTokens.INSTANCE.getUnselectedHandleWidth-D9Ej5fM();
        SwitchKt.SwitchWidth = SwitchTokens.INSTANCE.getTrackWidth-D9Ej5fM();
        SwitchKt.SwitchHeight = SwitchTokens.INSTANCE.getTrackHeight-D9Ej5fM();
        int i2 = 0;
        int i3 = 0;
        SwitchKt.ThumbPadding = Dp.constructor-impl(arg0$iv / f);
        SnapSpec snapSpec = new SnapSpec(0, 1, 0);
        SwitchKt.SnapSpec = snapSpec;
        TweenSpec tweenSpec = new TweenSpec(100, 0, 0, 6, 0);
        SwitchKt.AnimationSpec = tweenSpec;
    }

    public static final void Switch(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> thumbContent, boolean enabled, androidx.compose.material3.SwitchColors colors, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i10) {
        boolean companion;
        int modifier2;
        boolean traceInProgress;
        int str;
        int defaultsInvalid;
        int $dirty3;
        int i3;
        int i2;
        int thumbContent2;
        Object $dirty;
        int i9;
        Object enabled2;
        boolean z3;
        Object box-impl;
        boolean z;
        Object obj;
        Object $composer2;
        int i11;
        boolean z2;
        int i;
        int i8;
        int modifier3;
        Object obj2;
        boolean enabled3;
        int i4;
        Object colors2;
        int changed;
        int $dirty2;
        int i7;
        Object value;
        int i5;
        Composer composer;
        int i6;
        Object obj3;
        Object obj5 = onCheckedChange;
        final int i32 = $changed;
        Composer restartGroup = $composer.startRestartGroup(1580463220);
        ComposerKt.sourceInformation(restartGroup, "C(Switch)P(!1,5,4,6,2)97@4514L8,129@5619L5,119@5244L424:Switch.kt#uh7d8r");
        $dirty3 = $changed;
        if (i10 & 1 != 0) {
            $dirty3 |= 6;
            z2 = checked;
        } else {
            if (i32 & 6 == 0) {
                i3 = restartGroup.changed(checked) ? 4 : 2;
                $dirty3 |= i3;
            } else {
                z2 = checked;
            }
        }
        if (i10 & 2 != 0) {
            $dirty3 |= 48;
        } else {
            if (i32 & 48 == 0) {
                i2 = restartGroup.changedInstance(obj5) ? 32 : 16;
                $dirty3 |= i2;
            }
        }
        thumbContent2 = i10 & 4;
        if (thumbContent2 != 0) {
            $dirty3 |= 384;
            $dirty = modifier;
        } else {
            if (i32 & 384 == 0) {
                i9 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty3 |= i9;
            } else {
                $dirty = modifier;
            }
        }
        int i18 = i10 & 8;
        if (i18 != 0) {
            $dirty3 |= 3072;
            box-impl = thumbContent;
        } else {
            if (i32 & 3072 == 0) {
                i8 = restartGroup.changedInstance(thumbContent) ? 2048 : 1024;
                $dirty3 |= i8;
            } else {
                box-impl = thumbContent;
            }
        }
        modifier3 = i10 & 16;
        if (modifier3 != 0) {
            $dirty3 |= 24576;
            enabled3 = enabled;
        } else {
            if (i32 & 24576 == 0) {
                i4 = restartGroup.changed(enabled) ? 16384 : 8192;
                $dirty3 |= i4;
            } else {
                enabled3 = enabled;
            }
        }
        if (i37 &= i32 == 0) {
            if (i10 & 32 == 0) {
                changed = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                colors2 = colors;
            }
            $dirty3 |= changed;
        } else {
            colors2 = colors;
        }
        $dirty2 = i10 & 64;
        int i40 = 1572864;
        if ($dirty2 != 0) {
            $dirty3 |= i40;
            value = interactionSource;
        } else {
            if (i40 &= i32 == 0) {
                i5 = restartGroup.changed(interactionSource) ? 1048576 : 524288;
                $dirty3 |= i5;
            } else {
                value = interactionSource;
            }
        }
        if ($dirty3 & i43 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i44 = -458753;
                int i33 = 6;
                if (i32 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (thumbContent2 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = $dirty;
                        }
                        thumbContent2 = i18 != 0 ? 0 : box-impl;
                        if (modifier3 != 0) {
                            enabled3 = $dirty;
                        }
                        if (i10 & 32 != 0) {
                            $dirty3 &= i44;
                            colors2 = $dirty;
                        }
                        if ($dirty2 != 0) {
                            obj2 = modifier2;
                            i7 = $dirty3;
                            obj3 = $dirty;
                            z3 = enabled3;
                            enabled3 = colors2;
                            colors2 = thumbContent2;
                        } else {
                            obj2 = modifier2;
                            i7 = $dirty3;
                            z3 = enabled3;
                            enabled3 = colors2;
                            obj3 = value;
                            colors2 = thumbContent2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i10 & 32 != 0) {
                            $dirty3 &= i44;
                        }
                        i7 = $dirty3;
                        obj2 = $dirty;
                        z3 = enabled3;
                        enabled3 = colors2;
                        obj3 = value;
                        colors2 = box-impl;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1580463220, i7, -1, "androidx.compose.material3.Switch (Switch.kt:99)");
                }
                restartGroup.startReplaceGroup(783532531);
                ComposerKt.sourceInformation(restartGroup, "101@4666L39");
                if (obj3 == null) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 783533182, "CC(remember):Switch.kt#9igjgp");
                    str = 0;
                    $dirty3 = restartGroup;
                    int i15 = 0;
                    $dirty = $dirty3.rememberedValue();
                    box-impl = 0;
                    if ($dirty == Composer.Companion.getEmpty()) {
                        int i42 = 0;
                        $dirty3.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        value = $dirty;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    thumbContent2 = value;
                } else {
                    thumbContent2 = obj3;
                }
                restartGroup.endReplaceGroup();
                if (obj5 != null) {
                    companion = ToggleableKt.toggleable-O2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize((Modifier)Modifier.Companion), z2, thumbContent2, 0, z3, Role.box-impl(Role.Companion.getSwitch-o7Vup1c()), obj5);
                } else {
                    companion = Modifier.Companion;
                }
                int i17 = i7;
                SwitchKt.SwitchImpl(SizeKt.requiredSize-VpY3zN4(SizeKt.wrapContentSize$default(obj2.then(companion), Alignment.Companion.getCenter(), false, 2, 0), SwitchKt.SwitchWidth, SwitchKt.SwitchHeight), checked, z3, enabled3, colors2, (InteractionSource)thumbContent2, ShapesKt.getValue(SwitchTokens.INSTANCE.getHandleShape(), restartGroup, i33), restartGroup, i24 | i31);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i = i17;
                z = z3;
                obj = enabled3;
                enabled2 = colors2;
                $composer2 = obj3;
                $dirty = $dirty3;
            } else {
                restartGroup.skipToGroupEnd();
                i = $dirty3;
                enabled2 = box-impl;
                composer = restartGroup;
                z = enabled3;
                obj = colors2;
                $composer2 = value;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            companion = new SwitchKt.Switch.1(checked, onCheckedChange, $dirty, enabled2, z, obj, $composer2, i32, i10);
            endRestartGroup.updateScope((Function2)companion);
        }
    }

    private static final void SwitchImpl(Modifier modifier, boolean checked, boolean enabled, androidx.compose.material3.SwitchColors colors, Function2<? super Composer, ? super Integer, Unit> thumbContent, InteractionSource interactionSource, Shape thumbShape, Composer $composer, int $changed) {
        int traceInProgress;
        Object provides;
        Object $this$SwitchImpl_u24lambda_u242_u24lambda_u241;
        boolean currentCompositionLocalMap2;
        Object $changed$iv;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        Object obj;
        Modifier background-bw27NRU;
        int i11;
        Object currentCompositionLocalMap;
        Composer composer4;
        Object maybeCachedBoxMeasurePolicy;
        int $dirty;
        Composer composer;
        Object maybeCachedBoxMeasurePolicy2;
        int i25;
        int i2;
        int i;
        int i19;
        int i16;
        int i4;
        int i17;
        boolean materializeModifier;
        boolean traceInProgress2;
        int constructor;
        long thumbColor-WaAFU9c$material3_release;
        int i24;
        int i15;
        int i26;
        Shape shape;
        int i20;
        int i13;
        int i12;
        int i6;
        int i23;
        Alignment alignment;
        int i21;
        int currentCompositeKeyHash;
        long l;
        Modifier modifier3;
        int i9;
        int i30;
        int i31;
        int i28;
        int i8;
        int $this$SwitchImpl_u24lambda_u242;
        Composer composer2;
        int i7;
        int i27;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i29;
        int i5;
        int i14;
        long l2;
        Modifier modifier2;
        int i3;
        kotlin.jvm.functions.Function0 function0;
        BoxScopeInstance boxScopeInstance;
        Composer composer3;
        int i22;
        BoxScopeInstance boxScopeInstance2;
        int i10;
        int i18;
        Modifier modifier$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        long l3;
        Composer obj65;
        $this$SwitchImpl_u24lambda_u242_u24lambda_u241 = modifier;
        final boolean z = checked;
        final boolean z2 = enabled;
        final Object obj2 = colors;
        final Object obj3 = thumbContent;
        $changed$iv = interactionSource;
        i11 = $changed;
        traceInProgress = -1594099146;
        maybeCachedBoxMeasurePolicy = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(maybeCachedBoxMeasurePolicy, "C(SwitchImpl)P(4!1,2!1,5)147@6165L5,149@6176L1114:Switch.kt#uh7d8r");
        if (i11 & 6 == 0) {
            i25 = maybeCachedBoxMeasurePolicy.changed($this$SwitchImpl_u24lambda_u242_u24lambda_u241) ? 4 : 2;
            $dirty |= i25;
        }
        if (i11 & 48 == 0) {
            i2 = maybeCachedBoxMeasurePolicy.changed(z) ? 32 : 16;
            $dirty |= i2;
        }
        if (i11 & 384 == 0) {
            i = maybeCachedBoxMeasurePolicy.changed(z2) ? 256 : 128;
            $dirty |= i;
        }
        if (i11 & 3072 == 0) {
            i19 = maybeCachedBoxMeasurePolicy.changed(obj2) ? 2048 : 1024;
            $dirty |= i19;
        }
        if (i11 & 24576 == 0) {
            i16 = maybeCachedBoxMeasurePolicy.changedInstance(obj3) ? 16384 : 8192;
            $dirty |= i16;
        }
        if (i52 &= i11 == 0) {
            i4 = maybeCachedBoxMeasurePolicy.changed($changed$iv) ? 131072 : 65536;
            $dirty |= i4;
        }
        if (i53 &= i11 == 0) {
            i17 = maybeCachedBoxMeasurePolicy.changed(thumbShape) ? 1048576 : 524288;
            $dirty |= i17;
        }
        if (i54 &= $dirty == 599186) {
            if (!maybeCachedBoxMeasurePolicy.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.SwitchImpl (Switch.kt:144)");
                }
                long trackColor-WaAFU9c$material3_release = obj2.trackColor-WaAFU9c$material3_release(z2, z);
                int i55 = 6;
                Shape value = ShapesKt.getValue(SwitchTokens.INSTANCE.getTrackShape(), maybeCachedBoxMeasurePolicy, i55);
                obj65 = i55;
                Modifier background-bw27NRU2 = BackgroundKt.background-bw27NRU(BorderKt.border-xT4_qwU($this$SwitchImpl_u24lambda_u242_u24lambda_u241, SwitchTokens.INSTANCE.getTrackOutlineWidth-D9Ej5fM(), obj2.borderColor-WaAFU9c$material3_release(z2, z), i11), trackColor-WaAFU9c$material3_release, constructor);
                int i56 = i46;
                i15 = 0;
                shape = value;
                String trackShape2 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(maybeCachedBoxMeasurePolicy, 733328855, trackShape2);
                Alignment topStart = Alignment.Companion.getTopStart();
                int i35 = 0;
                maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i35);
                i6 = 0;
                i23 = i35;
                alignment = topStart;
                String contentAlignment$iv2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(maybeCachedBoxMeasurePolicy, -1323940314, contentAlignment$iv2);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(maybeCachedBoxMeasurePolicy, 0);
                currentCompositionLocalMap2 = maybeCachedBoxMeasurePolicy.getCurrentCompositionLocalMap();
                l = trackColor-WaAFU9c$material3_release;
                modifier3 = background-bw27NRU2;
                i9 = 0;
                String $changed$iv3 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(maybeCachedBoxMeasurePolicy, -692256719, $changed$iv3);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                maybeCachedBoxMeasurePolicy.startReusableNode();
                if (maybeCachedBoxMeasurePolicy.getInserting()) {
                    maybeCachedBoxMeasurePolicy.createNode(ComposeUiNode.Companion.getConstructor());
                } else {
                    maybeCachedBoxMeasurePolicy.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(maybeCachedBoxMeasurePolicy);
                int i63 = 0;
                composer2 = maybeCachedBoxMeasurePolicy;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i64 = 0;
                Composer composer8 = constructor-impl;
                int i67 = 0;
                if (!composer8.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy2;
                    if (!Intrinsics.areEqual(composer8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer8;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy2;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(maybeCachedBoxMeasurePolicy, background-bw27NRU2), ComposeUiNode.Companion.getSetModifier());
                Composer composer5 = composer2;
                i8 = i38;
                String $changed$iv2 = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, $changed$iv2);
                i66 |= 6;
                Composer composer9 = composer5;
                $this$SwitchImpl_u24lambda_u242 = 0;
                i22 = i48;
                ComposerKt.sourceInformationMarkerStart(composer9, -249502072, "C161@6662L183,154@6351L933:Switch.kt#uh7d8r");
                BoxScopeInstance $composer2 = boxScopeInstance3;
                ThumbElement thumbElement = new ThumbElement($changed$iv, z);
                int other$iv = 0;
                boxScopeInstance2 = $composer2;
                $dirty = composer9;
                background-bw27NRU = BackgroundKt.background-bw27NRU(IndicationKt.indication($composer2.align((Modifier)Modifier.Companion, Alignment.Companion.getCenterStart()).then((Modifier)thumbElement), $changed$iv, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(false, Dp.constructor-impl(other$iv2 / arg0$iv), 0, obj44, composer9, 54)), obj2.thumbColor-WaAFU9c$material3_release(z2, z), obj14);
                i29 = 48;
                i27 = 0;
                ComposerKt.sourceInformationMarkerStart($dirty, 733328855, trackShape2);
                int i32 = 0;
                Alignment alignment2 = alignment3;
                i5 = 0;
                i14 = i32;
                ComposerKt.sourceInformationMarkerStart($dirty, -1323940314, contentAlignment$iv2);
                currentCompositionLocalMap = $dirty.getCurrentCompositionLocalMap();
                i26 = currentCompositeKeyHash2;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier($dirty, background-bw27NRU);
                l2 = alignment2;
                kotlin.jvm.functions.Function0 function02 = constructor2;
                i21 = 0;
                ComposerKt.sourceInformationMarkerStart($dirty, -692256719, $changed$iv3);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $dirty.startReusableNode();
                if ($dirty.getInserting()) {
                    $dirty.createNode(function02);
                } else {
                    factory$iv$iv$iv = function02;
                    $dirty.useNode();
                }
                Composer constructor-impl2 = Updater.constructor-impl($dirty);
                int i62 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl2, BoxKt.maybeCachedBoxMeasurePolicy(alignment2, i32), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i71 = 0;
                Composer composer10 = constructor-impl2;
                i18 = 0;
                if (!composer10.getInserting()) {
                    modifier$iv = background-bw27NRU;
                    map = currentCompositionLocalMap;
                    if (!Intrinsics.areEqual(composer10.rememberedValue(), Integer.valueOf(i26))) {
                        composer10.updateRememberedValue(Integer.valueOf(i26));
                        constructor-impl2.apply(Integer.valueOf(i26), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer4 = composer10;
                    }
                } else {
                    modifier$iv = background-bw27NRU;
                    map = currentCompositionLocalMap;
                }
                Updater.set-impl(constructor-impl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                obj = $dirty;
                i11 = 0;
                ComposerKt.sourceInformationMarkerStart(obj, -2146769399, $changed$iv2);
                i59 |= 6;
                i28 = 0;
                modifier2 = materializeModifier2;
                boxScopeInstance = iNSTANCE2;
                i10 = i43;
                $changed$iv = obj65;
                ComposerKt.sourceInformationMarkerStart($changed$iv, 1707453249, "C:Switch.kt#uh7d8r");
                $changed$iv.startReplaceGroup(1163457794);
                ComposerKt.sourceInformation($changed$iv, "171@7116L144");
                if (obj3 != null) {
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(obj2.iconColor-WaAFU9c$material3_release(z2, z))), obj3, $changed$iv, $stable |= i18);
                }
                $changed$iv.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($changed$iv);
                ComposerKt.sourceInformationMarkerEnd(obj);
                $dirty.endNode();
                ComposerKt.sourceInformationMarkerEnd($dirty);
                ComposerKt.sourceInformationMarkerEnd($dirty);
                ComposerKt.sourceInformationMarkerEnd($dirty);
                ComposerKt.sourceInformationMarkerEnd($dirty);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                maybeCachedBoxMeasurePolicy.skipToGroupEnd();
                composer2 = maybeCachedBoxMeasurePolicy;
                i20 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new SwitchKt.SwitchImpl.2(modifier, z, z2, obj2, obj3, interactionSource, thumbShape, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void access$SwitchImpl(Modifier modifier, boolean checked, boolean enabled, androidx.compose.material3.SwitchColors colors, Function2 thumbContent, InteractionSource interactionSource, Shape thumbShape, Composer $composer, int $changed) {
        SwitchKt.SwitchImpl(modifier, checked, enabled, colors, thumbContent, interactionSource, thumbShape, $composer, $changed);
    }

    public static final TweenSpec access$getAnimationSpec$p() {
        return SwitchKt.AnimationSpec;
    }

    public static final SnapSpec access$getSnapSpec$p() {
        return SwitchKt.SnapSpec;
    }

    public static final float access$getSwitchHeight$p() {
        return SwitchKt.SwitchHeight;
    }

    public static final float access$getSwitchWidth$p() {
        return SwitchKt.SwitchWidth;
    }

    public static final float access$getThumbPadding$p() {
        return SwitchKt.ThumbPadding;
    }

    public static final float getThumbDiameter() {
        return SwitchKt.ThumbDiameter;
    }

    public static final float getUncheckedThumbDiameter() {
        return SwitchKt.UncheckedThumbDiameter;
    }
}
