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
        int i12;
        Object modifier3;
        int str;
        boolean z2;
        Object obj2;
        int interactionSource2;
        Composer composer2;
        Integer valueOf;
        int i11;
        int i17;
        boolean traceInProgress2;
        int i9;
        boolean str2;
        int i5;
        androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy;
        Object function0;
        int i10;
        int i7;
        int skipping;
        int i;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        boolean z;
        int i6;
        int i13;
        int i2;
        Alignment alignment;
        int i3;
        Composer composer3;
        int i14;
        int i16;
        BoxScopeInstance boxScopeInstance;
        androidx.compose.ui.Modifier.Companion modifier4;
        int i15;
        Modifier modifier2;
        Composer composer;
        int i4;
        int obj30;
        Modifier obj31;
        Function0 obj32;
        int obj34;
        final Object obj3 = content;
        final int i37 = $changed;
        traceInProgress = -111063634;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(IconButton)P(4,3,1,2)71@3004L70,63@2710L623:IconButton.kt#jmzs0o");
        $dirty = $changed;
        if (i8 & 1 != 0) {
            $dirty |= 6;
            obj = onClick;
        } else {
            if (i37 & 6 == 0) {
                i12 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty |= i12;
            } else {
                obj = onClick;
            }
        }
        int i30 = i8 & 2;
        if (i30 != 0) {
            $dirty |= 48;
            obj2 = modifier;
        } else {
            if (i37 & 48 == 0) {
                i17 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i17;
            } else {
                obj2 = modifier;
            }
        }
        i9 = i8 & 4;
        if (i9 != 0) {
            $dirty |= 384;
            str2 = enabled;
        } else {
            if (i37 & 384 == 0) {
                i5 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty |= i5;
            } else {
                str2 = enabled;
            }
        }
        maybeCachedBoxMeasurePolicy = i8 & 8;
        if (maybeCachedBoxMeasurePolicy != 0) {
            $dirty |= 3072;
            function0 = interactionSource;
        } else {
            if (i37 & 3072 == 0) {
                i10 = restartGroup.changed(interactionSource) ? 2048 : 1024;
                $dirty |= i10;
            } else {
                function0 = interactionSource;
            }
        }
        if (i8 & 16 != 0) {
            $dirty |= 24576;
        } else {
            if (i37 & 24576 == 0) {
                i7 = restartGroup.changedInstance(obj3) ? 16384 : 8192;
                $dirty |= i7;
            }
        }
        if ($dirty & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                if (i30 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = obj2;
                }
                z = i9 != 0 ? obj2 : str2;
                interactionSource2 = maybeCachedBoxMeasurePolicy != 0 ? 0 : function0;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.IconButton (IconButton.kt:62)");
                }
                i = interactionSource2;
                Modifier clickable-O2vRcR0$default = ClickableKt.clickable-O2vRcR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), i, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(false, IconButtonKt.RippleRadius, 0, function0, restartGroup, 54), z, 0, Role.box-impl(Role.Companion.getButton-o7Vup1c()), obj, 8, 0);
                Alignment center = Alignment.Companion.getCenter();
                valueOf = 48;
                i9 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                skipping = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                obj30 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, clickable-O2vRcR0$default);
                obj31 = clickable-O2vRcR0$default;
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
                int i51 = 0;
                obj32 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(center, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i52 = 0;
                Composer composer5 = constructor-impl;
                int i54 = 0;
                if (!composer5.getInserting()) {
                    modifier4 = modifier3;
                    i15 = valueOf;
                    if (!Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(obj30))) {
                        composer5.updateRememberedValue(Integer.valueOf(obj30));
                        constructor-impl.apply(Integer.valueOf(obj30), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer5;
                    }
                } else {
                    modifier4 = modifier3;
                    i15 = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer4 = restartGroup;
                str = 0;
                i3 = i22;
                ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i35 |= 6;
                composer3 = composer4;
                i16 = 0;
                boxScopeInstance = iNSTANCE;
                modifier2 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer4, -1682424830, "C76@3243L84:IconButton.kt#jmzs0o");
                if (z) {
                    composer4.startReplaceGroup(1885392311);
                    ComposerKt.sourceInformation(composer4, "75@3200L7");
                    composer3 = 0;
                    obj34 = i27;
                    i4 = str;
                    ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    floatValue = (Number)composer4.consume((CompositionLocal)ContentAlphaKt.getLocalContentAlpha()).floatValue();
                } else {
                    i4 = str;
                    composer4.startReplaceGroup(1885393144);
                    ComposerKt.sourceInformation(composer4, "75@3226L8");
                    floatValue = ContentAlpha.INSTANCE.getDisabled(composer4, 6);
                }
                composer4.endReplaceGroup();
                CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(floatValue)), obj3, composer4, $stable |= i14);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i11 = i;
                z2 = z;
                companion = modifier4;
            } else {
                restartGroup.skipToGroupEnd();
                i6 = $dirty;
                companion = obj2;
                z2 = str2;
                i11 = function0;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new IconButtonKt.IconButton.2(onClick, companion, z2, i11, obj3, i37, i8);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void IconToggleButton(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        int traceInProgress;
        Function0 factory$iv$iv$iv;
        float floatValue;
        int $dirty;
        int consume;
        boolean z3;
        int i4;
        Object obj;
        Object obj2;
        boolean valueOf;
        int str2;
        int i;
        boolean z2;
        Object modifier3;
        Composer composer;
        Object obj3;
        Object obj5;
        boolean traceInProgress2;
        int i5;
        int str;
        boolean maybeCachedBoxMeasurePolicy;
        int i10;
        int i8;
        int $dirty2;
        Object obj7;
        int i7;
        int i2;
        boolean currentCompositeKeyHash;
        int currentCompositionLocalMap;
        Object obj4;
        int i6;
        boolean z;
        int i13;
        Alignment alignment;
        int i14;
        int i11;
        Composer composer2;
        int i12;
        BoxScopeInstance boxScopeInstance;
        int $changed$iv;
        Object obj6;
        Modifier modifier2;
        Composer composer3;
        int i3;
        Object obj31;
        Function0 obj32;
        int obj33;
        int obj35;
        final Object obj9 = content;
        final int i35 = $changed;
        traceInProgress = -54657793;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(IconToggleButton)P(!1,5,4,2,3)116@4932L70,107@4612L645:IconButton.kt#jmzs0o");
        $dirty = $changed;
        if (i9 & 1 != 0) {
            $dirty |= 6;
            z3 = checked;
        } else {
            if (i35 & 6 == 0) {
                i4 = restartGroup.changed(checked) ? 4 : 2;
                $dirty |= i4;
            } else {
                z3 = checked;
            }
        }
        if (i9 & 2 != 0) {
            $dirty |= 48;
            obj = onCheckedChange;
        } else {
            if (i35 & 48 == 0) {
                i = restartGroup.changedInstance(onCheckedChange) ? 32 : 16;
                $dirty |= i;
            } else {
                obj = onCheckedChange;
            }
        }
        int i28 = i9 & 4;
        if (i28 != 0) {
            $dirty |= 384;
            obj3 = modifier;
        } else {
            if (i35 & 384 == 0) {
                i5 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i5;
            } else {
                obj3 = modifier;
            }
        }
        str = i9 & 8;
        if (str != null) {
            $dirty |= 3072;
            maybeCachedBoxMeasurePolicy = enabled;
        } else {
            if (i35 & 3072 == 0) {
                i10 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i10;
            } else {
                maybeCachedBoxMeasurePolicy = enabled;
            }
        }
        i8 = i9 & 16;
        if (i8 != 0) {
            $dirty |= 24576;
            obj7 = interactionSource;
        } else {
            if (i35 & 24576 == 0) {
                i7 = restartGroup.changed(interactionSource) ? 16384 : 8192;
                $dirty |= i7;
            } else {
                obj7 = interactionSource;
            }
        }
        int i46 = 196608;
        if (i9 & 32 != 0) {
            $dirty |= i46;
        } else {
            if (i35 & i46 == 0) {
                i2 = restartGroup.changedInstance(obj9) ? 131072 : 65536;
                $dirty |= i2;
            }
        }
        if (i42 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                if (i28 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = obj3;
                }
                z = str != null ? obj3 : maybeCachedBoxMeasurePolicy;
                obj4 = i8 != 0 ? obj3 : obj7;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.IconToggleButton (IconButton.kt:106)");
                }
                Modifier toggleable-O2vRcR0 = ToggleableKt.toggleable-O2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), z3, obj4, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(false, IconButtonKt.RippleRadius, 0, obj7, restartGroup, 54), z, Role.box-impl(Role.Companion.getCheckbox-o7Vup1c()), obj);
                Alignment center = Alignment.Companion.getCenter();
                valueOf = 48;
                int i34 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                obj7 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, toggleable-O2vRcR0);
                obj31 = toggleable-O2vRcR0;
                obj32 = constructor;
                i6 = 0;
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
                int i49 = 0;
                obj32 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(center, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i50 = 0;
                Composer composer4 = constructor-impl;
                int i52 = 0;
                if (!composer4.getInserting()) {
                    $changed$iv = valueOf;
                    obj6 = modifier3;
                    if (!Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer4;
                    }
                } else {
                    $changed$iv = valueOf;
                    obj6 = modifier3;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                z3 = restartGroup;
                str2 = 0;
                i14 = i19;
                ComposerKt.sourceInformationMarkerStart(z3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i31 |= 6;
                composer2 = z3;
                i12 = 0;
                boxScopeInstance = iNSTANCE;
                modifier2 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(z3, 1341775822, "C121@5167L84:IconButton.kt#jmzs0o");
                if (z) {
                    z3.startReplaceGroup(-2034925461);
                    ComposerKt.sourceInformation(z3, "120@5124L7");
                    composer2 = 0;
                    obj33 = i22;
                    i3 = str2;
                    ComposerKt.sourceInformationMarkerStart(z3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(z3);
                    floatValue = (Number)z3.consume((CompositionLocal)ContentAlphaKt.getLocalContentAlpha()).floatValue();
                } else {
                    i3 = str2;
                    z3.startReplaceGroup(-2034924628);
                    ComposerKt.sourceInformation(z3, "120@5150L8");
                    floatValue = ContentAlpha.INSTANCE.getDisabled(z3, 6);
                }
                z3.endReplaceGroup();
                CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(floatValue)), obj9, z3, $stable |= i11);
                ComposerKt.sourceInformationMarkerEnd(z3);
                ComposerKt.sourceInformationMarkerEnd(z3);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj4;
                z2 = z;
                obj2 = obj6;
            } else {
                restartGroup.skipToGroupEnd();
                obj35 = $dirty;
                obj2 = obj3;
                z2 = maybeCachedBoxMeasurePolicy;
                obj5 = obj7;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = obj35;
            traceInProgress = new IconButtonKt.IconToggleButton.2(checked, onCheckedChange, obj2, z2, obj5, obj9, i35, i9);
            endRestartGroup.updateScope((Function2)traceInProgress);
        } else {
            $dirty2 = obj35;
        }
    }
}
