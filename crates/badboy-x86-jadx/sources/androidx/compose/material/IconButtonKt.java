package androidx.compose.material;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
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
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.Role.Companion;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aN\u0010\u0003\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\u0008\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a\\\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u00132\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\u0008\u000eH\u0007¢\u0006\u0002\u0010\u0014\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0015", d2 = {"RippleRadius", "Landroidx/compose/ui/unit/Dp;", "F", "IconButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconToggleButton", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IconButtonKt {

    private static final float RippleRadius;
    static {
        final int i2 = 0;
        IconButtonKt.RippleRadius = Dp.constructor-impl((float)i);
    }

    public static final void IconButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i8) {
        Function0 factory$iv$iv$iv;
        float floatValue;
        boolean traceInProgress;
        int $dirty;
        int consume;
        Object obj;
        Object companion;
        int i14;
        Object modifier3;
        int $i$a$LayoutBoxKt$Box$1$iv;
        boolean z2;
        Object obj2;
        int interactionSource2;
        Composer composer2;
        Integer valueOf;
        int i12;
        int i7;
        boolean traceInProgress2;
        int i13;
        boolean str;
        int i10;
        androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy;
        Object function0;
        int i11;
        int i15;
        int skipping;
        int i6;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        boolean z;
        int i2;
        int i16;
        int i;
        Alignment alignment;
        int i4;
        Composer composer3;
        int i3;
        int i9;
        BoxScopeInstance boxScopeInstance;
        androidx.compose.ui.Modifier.Companion modifier2;
        int i5;
        Modifier modifier4;
        Composer composer;
        int $i$a$LayoutBoxKt$Box$1$iv2;
        int obj30;
        Modifier obj31;
        Function0 obj32;
        int obj34;
        final Object obj3 = content;
        final int i36 = $changed;
        traceInProgress = -111063634;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(IconButton)P(4,3,1,2)71@3004L70,63@2710L623:IconButton.kt#jmzs0o");
        $dirty = $changed;
        if (i8 & 1 != 0) {
            $dirty |= 6;
            obj = onClick;
        } else {
            if (i36 & 6 == 0) {
                i14 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty |= i14;
            } else {
                obj = onClick;
            }
        }
        int i29 = i8 & 2;
        if (i29 != 0) {
            $dirty |= 48;
            obj2 = modifier;
        } else {
            if (i36 & 48 == 0) {
                i7 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i7;
            } else {
                obj2 = modifier;
            }
        }
        i13 = i8 & 4;
        if (i13 != 0) {
            $dirty |= 384;
            str = enabled;
        } else {
            if (i36 & 384 == 0) {
                i10 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty |= i10;
            } else {
                str = enabled;
            }
        }
        maybeCachedBoxMeasurePolicy = i8 & 8;
        if (maybeCachedBoxMeasurePolicy != 0) {
            $dirty |= 3072;
            function0 = interactionSource;
        } else {
            if (i36 & 3072 == 0) {
                i11 = restartGroup.changed(interactionSource) ? 2048 : 1024;
                $dirty |= i11;
            } else {
                function0 = interactionSource;
            }
        }
        if (i8 & 16 != 0) {
            $dirty |= 24576;
        } else {
            if (i36 & 24576 == 0) {
                i15 = restartGroup.changedInstance(obj3) ? 16384 : 8192;
                $dirty |= i15;
            }
        }
        if ($dirty & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                if (i29 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = obj2;
                }
                z = i13 != 0 ? obj2 : str;
                interactionSource2 = maybeCachedBoxMeasurePolicy != 0 ? 0 : function0;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.IconButton (IconButton.kt:62)");
                }
                i6 = interactionSource2;
                Modifier clickable-O2vRcR0$default = ClickableKt.clickable-O2vRcR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), i6, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(false, IconButtonKt.RippleRadius, 0, function0, restartGroup, 54), z, 0, Role.box-impl(Role.Companion.getButton-o7Vup1c()), obj, 8, 0);
                Alignment center = Alignment.Companion.getCenter();
                valueOf = 48;
                i13 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                skipping = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                obj30 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, clickable-O2vRcR0$default);
                obj31 = clickable-O2vRcR0$default;
                obj32 = constructor;
                i16 = 0;
                alignment = center;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(obj32);
                } else {
                    factory$iv$iv$iv = obj32;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i50 = 0;
                obj32 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(center, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i51 = 0;
                Composer composer5 = constructor-impl;
                int i53 = 0;
                if (!composer5.getInserting()) {
                    modifier2 = modifier3;
                    i5 = valueOf;
                    if (!Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(obj30))) {
                        composer5.updateRememberedValue(Integer.valueOf(obj30));
                        constructor-impl.apply(Integer.valueOf(obj30), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer5;
                    }
                } else {
                    modifier2 = modifier3;
                    i5 = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer4 = restartGroup;
                $i$a$LayoutBoxKt$Box$1$iv = 0;
                i4 = i21;
                ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i34 |= 6;
                composer3 = composer4;
                i9 = 0;
                boxScopeInstance = iNSTANCE;
                modifier4 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer4, -1682424830, "C76@3243L84:IconButton.kt#jmzs0o");
                if (z) {
                    composer4.startReplaceGroup(1885392311);
                    ComposerKt.sourceInformation(composer4, "75@3200L7");
                    composer3 = 0;
                    obj34 = i26;
                    $i$a$LayoutBoxKt$Box$1$iv2 = $i$a$LayoutBoxKt$Box$1$iv;
                    ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    floatValue = (Number)composer4.consume((CompositionLocal)ContentAlphaKt.getLocalContentAlpha()).floatValue();
                } else {
                    $i$a$LayoutBoxKt$Box$1$iv2 = $i$a$LayoutBoxKt$Box$1$iv;
                    composer4.startReplaceGroup(1885393144);
                    ComposerKt.sourceInformation(composer4, "75@3226L8");
                    floatValue = ContentAlpha.INSTANCE.getDisabled(composer4, 6);
                }
                composer4.endReplaceGroup();
                CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(floatValue)), obj3, composer4, $stable |= i3);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i12 = i6;
                z2 = z;
                companion = modifier2;
            } else {
                restartGroup.skipToGroupEnd();
                i2 = $dirty;
                companion = obj2;
                z2 = str;
                i12 = function0;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new IconButtonKt.IconButton.2(onClick, companion, z2, i12, obj3, i36, i8);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void IconToggleButton(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        int traceInProgress;
        Function0 factory$iv$iv$iv;
        float floatValue;
        int $dirty;
        int consume;
        boolean z2;
        int i12;
        Object obj3;
        Object obj;
        boolean valueOf;
        int $i$a$LayoutBoxKt$Box$1$iv;
        int i4;
        boolean z;
        Object modifier2;
        Composer composer;
        Object obj5;
        Object obj2;
        boolean traceInProgress2;
        int i10;
        int str;
        boolean maybeCachedBoxMeasurePolicy;
        int i3;
        int i11;
        int $dirty2;
        Object obj6;
        int i;
        int i8;
        boolean currentCompositeKeyHash;
        int currentCompositionLocalMap;
        Object obj4;
        int i13;
        boolean z3;
        int i6;
        Alignment alignment;
        int i2;
        int i7;
        Composer composer2;
        int i5;
        BoxScopeInstance boxScopeInstance;
        int $changed$iv;
        Object obj7;
        Modifier modifier3;
        Composer composer3;
        int $i$a$LayoutBoxKt$Box$1$iv2;
        Object obj31;
        Function0 obj32;
        int obj33;
        int obj35;
        final Object obj9 = content;
        final int i34 = $changed;
        traceInProgress = -54657793;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(IconToggleButton)P(!1,5,4,2,3)116@4932L70,107@4612L645:IconButton.kt#jmzs0o");
        $dirty = $changed;
        if (i9 & 1 != 0) {
            $dirty |= 6;
            z2 = checked;
        } else {
            if (i34 & 6 == 0) {
                i12 = restartGroup.changed(checked) ? 4 : 2;
                $dirty |= i12;
            } else {
                z2 = checked;
            }
        }
        if (i9 & 2 != 0) {
            $dirty |= 48;
            obj3 = onCheckedChange;
        } else {
            if (i34 & 48 == 0) {
                i4 = restartGroup.changedInstance(onCheckedChange) ? 32 : 16;
                $dirty |= i4;
            } else {
                obj3 = onCheckedChange;
            }
        }
        int i27 = i9 & 4;
        if (i27 != 0) {
            $dirty |= 384;
            obj5 = modifier;
        } else {
            if (i34 & 384 == 0) {
                i10 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i10;
            } else {
                obj5 = modifier;
            }
        }
        str = i9 & 8;
        if (str != null) {
            $dirty |= 3072;
            maybeCachedBoxMeasurePolicy = enabled;
        } else {
            if (i34 & 3072 == 0) {
                i3 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i3;
            } else {
                maybeCachedBoxMeasurePolicy = enabled;
            }
        }
        i11 = i9 & 16;
        if (i11 != 0) {
            $dirty |= 24576;
            obj6 = interactionSource;
        } else {
            if (i34 & 24576 == 0) {
                i = restartGroup.changed(interactionSource) ? 16384 : 8192;
                $dirty |= i;
            } else {
                obj6 = interactionSource;
            }
        }
        int i45 = 196608;
        if (i9 & 32 != 0) {
            $dirty |= i45;
        } else {
            if (i34 & i45 == 0) {
                i8 = restartGroup.changedInstance(obj9) ? 131072 : 65536;
                $dirty |= i8;
            }
        }
        if (i41 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                if (i27 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj5;
                }
                z3 = str != null ? obj5 : maybeCachedBoxMeasurePolicy;
                obj4 = i11 != 0 ? obj5 : obj6;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.IconToggleButton (IconButton.kt:106)");
                }
                Modifier toggleable-O2vRcR0 = ToggleableKt.toggleable-O2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2), z2, obj4, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(false, IconButtonKt.RippleRadius, 0, obj6, restartGroup, 54), z3, Role.box-impl(Role.Companion.getCheckbox-o7Vup1c()), obj3);
                Alignment center = Alignment.Companion.getCenter();
                valueOf = 48;
                int i33 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                obj6 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, toggleable-O2vRcR0);
                obj31 = toggleable-O2vRcR0;
                obj32 = constructor;
                i13 = 0;
                alignment = center;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(obj32);
                } else {
                    factory$iv$iv$iv = obj32;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i48 = 0;
                obj32 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(center, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i49 = 0;
                Composer composer4 = constructor-impl;
                int i51 = 0;
                if (!composer4.getInserting()) {
                    $changed$iv = valueOf;
                    obj7 = modifier2;
                    if (!Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer4;
                    }
                } else {
                    $changed$iv = valueOf;
                    obj7 = modifier2;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                z2 = restartGroup;
                $i$a$LayoutBoxKt$Box$1$iv = 0;
                i2 = i18;
                ComposerKt.sourceInformationMarkerStart(z2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i30 |= 6;
                composer2 = z2;
                i5 = 0;
                boxScopeInstance = iNSTANCE;
                modifier3 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(z2, 1341775822, "C121@5167L84:IconButton.kt#jmzs0o");
                if (z3) {
                    z2.startReplaceGroup(-2034925461);
                    ComposerKt.sourceInformation(z2, "120@5124L7");
                    composer2 = 0;
                    obj33 = i21;
                    $i$a$LayoutBoxKt$Box$1$iv2 = $i$a$LayoutBoxKt$Box$1$iv;
                    ComposerKt.sourceInformationMarkerStart(z2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(z2);
                    floatValue = (Number)z2.consume((CompositionLocal)ContentAlphaKt.getLocalContentAlpha()).floatValue();
                } else {
                    $i$a$LayoutBoxKt$Box$1$iv2 = $i$a$LayoutBoxKt$Box$1$iv;
                    z2.startReplaceGroup(-2034924628);
                    ComposerKt.sourceInformation(z2, "120@5150L8");
                    floatValue = ContentAlpha.INSTANCE.getDisabled(z2, 6);
                }
                z2.endReplaceGroup();
                CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(floatValue)), obj9, z2, $stable |= i7);
                ComposerKt.sourceInformationMarkerEnd(z2);
                ComposerKt.sourceInformationMarkerEnd(z2);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = obj4;
                z = z3;
                obj = obj7;
            } else {
                restartGroup.skipToGroupEnd();
                obj35 = $dirty;
                obj = obj5;
                z = maybeCachedBoxMeasurePolicy;
                obj2 = obj6;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = obj35;
            traceInProgress = new IconButtonKt.IconToggleButton.2(checked, onCheckedChange, obj, z, obj2, obj9, i34, i9);
            endRestartGroup.updateScope((Function2)traceInProgress);
        } else {
            $dirty2 = obj35;
        }
    }
}
