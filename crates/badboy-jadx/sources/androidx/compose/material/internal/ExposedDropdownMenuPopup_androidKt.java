package androidx.compose.material.internal;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a:\u0010\u0005\u001a\u00020\u00062\u0010\u0008\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00060\u0008¢\u0006\u0002\u0008\u000cH\u0001¢\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0013\u0008\u0008\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00060\u0008¢\u0006\u0002\u0008\u000cH\u0083\u0008¢\u0006\u0002\u0010\u0011\"\u001a\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\u0012²\u0006\u0015\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00060\u0008¢\u0006\u0002\u0008\u000cX\u008a\u0084\u0002", d2 = {"LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ExposedDropdownMenuPopup", "", "onDismissRequest", "Lkotlin/Function0;", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ExposedDropdownMenuPopup_androidKt {

    private static final ProvidableCompositionLocal<String> LocalPopupTestTag;
    static {
        final int i2 = 0;
        ExposedDropdownMenuPopup_androidKt.LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default(i2, (Function0)ExposedDropdownMenuPopup_androidKt.LocalPopupTestTag.1.INSTANCE, 1, i2);
    }

    public static final void ExposedDropdownMenuPopup(Function0<Unit> onDismissRequest, PopupPositionProvider popupPositionProvider, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i6) {
        Object view;
        Object testTag2;
        int traceInProgress;
        int $dirty3;
        Object $dirty2;
        Object $dirty;
        Object testTag3;
        Object anon;
        boolean valueOf;
        Object onDismissRequest2;
        Object invalid$iv;
        Composer composer;
        Integer currentCompositeKeyHash;
        int i3;
        int density;
        int i7;
        int i9;
        int i11;
        Object density2;
        boolean traceInProgress2;
        int i4;
        int i2;
        int i10;
        int testTag;
        Object obj2;
        int i12;
        Object rememberSaveable;
        int i8;
        int i14;
        Object anon3;
        int currentCompositionLocalMap;
        Modifier materializeModifier;
        int rememberedValue;
        Function0 constructor;
        Object anon2;
        int rememberedValue2;
        Object empty;
        int i16;
        int i5;
        Object obj;
        Composer.Companion companion;
        int i13;
        int i15;
        Object obj4;
        int i18;
        int i17;
        Composer composer2;
        int i19;
        androidx.compose.material.internal.PopupLayout $changed$iv;
        Object obj5;
        int i;
        Object obj3;
        Object obj28;
        Modifier obj31;
        testTag3 = popupPositionProvider;
        obj2 = content;
        i12 = $changed;
        traceInProgress = -707851182;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(ExposedDropdownMenuPopup)P(1,2)84@3429L7,85@3468L7,86@3512L7,87@3567L7,88@3603L28,89@3658L29,90@3706L38,91@3767L907,118@4710L350,118@4680L380,132@5077L181,132@5066L192,140@5304L126,140@5264L166,151@5687L462,162@6156L99,149@5608L647:ExposedDropdownMenuPopup.android.kt#mnwmf7");
        $dirty3 = $changed;
        i3 = i6 & 1;
        if (i3 != 0) {
            $dirty3 |= 6;
            density2 = onDismissRequest;
        } else {
            if (i12 & 6 == 0) {
                i4 = restartGroup.changedInstance(onDismissRequest) ? 4 : 2;
                $dirty3 |= i4;
            } else {
                density2 = onDismissRequest;
            }
        }
        i14 = 32;
        if (i6 & 2 != 0) {
            $dirty3 |= 48;
        } else {
            if (i12 & 48 == 0) {
                i2 = restartGroup.changed(testTag3) ? i14 : 16;
                $dirty3 |= i2;
            }
        }
        if (i6 & 4 != 0) {
            $dirty3 |= 384;
        } else {
            if (i12 & 384 == 0) {
                i10 = restartGroup.changedInstance(obj2) ? 256 : 128;
                $dirty3 |= i10;
            }
        }
        if ($dirty3 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                onDismissRequest2 = i3 != 0 ? 0 : density2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty3, -1, "androidx.compose.material.internal.ExposedDropdownMenuPopup (ExposedDropdownMenuPopup.android.kt:83)");
                }
                int i46 = 0;
                int i47 = 0;
                int i50 = 2023513938;
                String str2 = "CC:CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, i50, str2);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv = consume2;
                int i48 = 0;
                int i62 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i50, str2);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv2 = consume3;
                int i63 = 6;
                int i64 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i50, str2);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv3 = consume4;
                int i65 = 0;
                int i73 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i50, str2);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i59 = 0;
                int i80 = i74;
                int i81 = i59;
                String str3 = "CC(remember):ExposedDropdownMenuPopup.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1502143506, str3);
                int i52 = 0;
                Composer composer8 = restartGroup;
                int i68 = 0;
                Object rememberedValue7 = composer8.rememberedValue();
                int i78 = 0;
                obj28 = rememberSaveable;
                if (rememberedValue7 == Composer.Companion.getEmpty()) {
                    companion = 0;
                    Object $dirty4 = onDismissRequest2;
                    Object onDismissRequest3 = this_$iv;
                    i15 = i44;
                    Object $dirty5 = this_$iv2;
                    Object density3 = testTag3;
                    Object obj6 = this_$iv3;
                    PopupLayout view2 = new PopupLayout($dirty4, obj6, onDismissRequest3, $dirty5, density3, obj28);
                    $dirty2 = view2;
                    view = obj6;
                    testTag3 = density3;
                    density2 = obj3;
                    obj28 = $dirty2;
                    i19 = 0;
                    $changed$iv = $dirty2;
                    rememberSaveable = new ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup.popupLayout.1.1.1($dirty2, SnapshotStateKt.rememberUpdatedState(obj2, restartGroup, i66 &= 14));
                    obj28 = onDismissRequest3;
                    obj5 = $dirty5;
                    $dirty2.setContent(ComposablesKt.rememberCompositionContext(restartGroup, i59), (Function2)ComposableLambdaKt.composableLambdaInstance(580081703, true, rememberSaveable));
                    composer8.updateRememberedValue($dirty2);
                } else {
                    testTag = obj28;
                    obj28 = this_$iv;
                    view = obj7;
                    i15 = $dirty3;
                    obj5 = this_$iv2;
                    density = 1;
                    density2 = onDismissRequest2;
                    $dirty2 = rememberedValue7;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1502173125, str3);
                i8 = i15 & 14 == 4 ? density : 0;
                i14 = obj8;
                Composer composer9 = restartGroup;
                int i69 = 0;
                rememberedValue2 = composer9.rememberedValue();
                int i79 = 0;
                if (i27 |= changed6 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        density = 0;
                        anon3 = new ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup.1.1($dirty2, density2, view, i14);
                        composer9.updateRememberedValue((Function1)anon3);
                    } else {
                        anon3 = rememberedValue2;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.DisposableEffect($dirty2, (Function1)anon3, restartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1502184700, str3);
                i7 = i15 & 14 == 4 ? 1 : 0;
                i32 |= changed3;
                Composer composer5 = restartGroup;
                int i55 = 0;
                Object rememberedValue5 = composer5.rememberedValue();
                int i70 = 0;
                if (i33 == 0) {
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = 0;
                        i5 = i33;
                        invalid$iv = new ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup.2.1($dirty2, density2, view, i14);
                        composer5.updateRememberedValue((Function0)invalid$iv);
                    } else {
                        i5 = i33;
                        invalid$iv = rememberedValue5;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.SideEffect((Function0)invalid$iv, restartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1502191909, str3);
                i9 = i15 & 112 == 32 ? 1 : 0;
                Composer composer6 = restartGroup;
                int i56 = 0;
                Object rememberedValue6 = composer6.rememberedValue();
                int i71 = 0;
                if (changedInstance4 |= i9 == 0) {
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        empty = 0;
                        obj = view;
                        testTag2 = new ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup.3.1($dirty2, testTag3);
                        composer6.updateRememberedValue((Function1)testTag2);
                    } else {
                        obj = view;
                        testTag2 = rememberedValue6;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.DisposableEffect(testTag3, (Function1)testTag2, restartGroup, i36 &= 14);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1502204501, str3);
                Composer composer7 = restartGroup;
                int i57 = 0;
                rememberedValue = composer7.rememberedValue();
                int i72 = 0;
                if (!restartGroup.changedInstance($dirty2)) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup.5.1($dirty2);
                        composer7.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned((Modifier)Modifier.Companion, (Function1)anon);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1502219146, str3);
                Composer composer4 = restartGroup;
                int i43 = 0;
                Object rememberedValue4 = composer4.rememberedValue();
                int i61 = 0;
                if (changedInstance |= changed == 0) {
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        rememberedValue = 0;
                        anon2 = new ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup.6.1($dirty2, i14);
                        composer4.updateRememberedValue((MeasurePolicy)anon2);
                    } else {
                        anon2 = rememberedValue4;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i39 = 0;
                valueOf = i39;
                i11 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, i39);
                i13 = 0;
                obj31 = onGloballyPositioned;
                obj4 = $dirty2;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(ComposeUiNode.Companion.getConstructor());
                } else {
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                i17 = i22;
                Updater.set-impl(constructor-impl, (MeasurePolicy)anon2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i82 = 0;
                composer2 = constructor-impl;
                i19 = 0;
                if (!composer2.getInserting()) {
                    $changed$iv = valueOf;
                    if (!Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer2.updateRememberedValue(Integer.valueOf(i));
                        constructor-impl.apply(Integer.valueOf(i), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer2;
                    }
                } else {
                    $changed$iv = valueOf;
                    i = currentCompositeKeyHash;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, onGloballyPositioned), ComposeUiNode.Companion.getSetModifier());
                Composer composer3 = restartGroup;
                testTag3 = 0;
                i18 = i21;
                ComposerKt.sourceInformationMarkerStart(composer3, 355624765, "C:ExposedDropdownMenuPopup.android.kt#mnwmf7");
                ComposerKt.sourceInformationMarkerEnd(composer3);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty = density2;
            } else {
                restartGroup.skipToGroupEnd();
                i15 = $dirty3;
                $dirty = density2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup.7($dirty, popupPositionProvider, content, $changed, i6);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final Function2<Composer, Integer, Unit> ExposedDropdownMenuPopup$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> $currentContent$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Function2)$currentContent$delegate.getValue();
    }

    private static final void SimpleStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Integer valueOf;
        Composer composer;
        Object iNSTANCE;
        int $i$f$SimpleStack;
        androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt.SimpleStack.1 stack;
        final Composer composer2 = $composer;
        valueOf = 0;
        ComposerKt.sourceInformationMarkerStart(composer2, -1085885553, "CC(SimpleStack)P(1)178@6799L979:ExposedDropdownMenuPopup.android.kt#mnwmf7");
        iNSTANCE = ExposedDropdownMenuPopup_androidKt.SimpleStack.1.INSTANCE;
        int i10 = 0;
        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
        final int i16 = 0;
        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        if (!applier instanceof Applier) {
            ComposablesKt.invalidApplier();
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
            composer2.createNode(ComposeUiNode.Companion.getConstructor());
        } else {
            composer2.useNode();
        }
        Composer constructor-impl = Updater.constructor-impl(composer2);
        int i18 = 0;
        Updater.set-impl(constructor-impl, (MeasurePolicy)iNSTANCE, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(constructor-impl, composer2.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        final int i19 = 0;
        final Composer composer3 = constructor-impl;
        final int i20 = 0;
        if (!composer3.getInserting()) {
            $i$f$SimpleStack = valueOf;
            stack = iNSTANCE;
            if (!Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
            } else {
                composer = composer3;
            }
        } else {
            $i$f$SimpleStack = valueOf;
            stack = iNSTANCE;
        }
        Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(composer2, modifier), ComposeUiNode.Companion.getSetModifier());
        content.invoke(composer2, Integer.valueOf(i &= 14));
        composer2.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
    }

    public static final Function2 access$ExposedDropdownMenuPopup$lambda$0(State $currentContent$delegate) {
        return ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup$lambda$0($currentContent$delegate);
    }

    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return ExposedDropdownMenuPopup_androidKt.LocalPopupTestTag;
    }
}
