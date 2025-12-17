package androidx.compose.material;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\u0008\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0008\n¢\u0006\u0002\u0008\u000bH\u0007¢\u0006\u0002\u0010\u000c\u001a6\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0005H\u0002\u001a\"\u0010\u0015\u001a\u00020\u0007*\u00020\u00072\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u0019²\u0006\n\u0010\u001a\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0013X\u008a\u008e\u0002", d2 = {"ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "updateHeight", "view", "Landroid/view/View;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "verticalMarginInPx", "", "onHeightUpdate", "expandable", "Lkotlin/Function0;", "menuLabel", "", "material_release", "width", "menuHeight"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ExposedDropdownMenu_androidKt {
    public static final void ExposedDropdownMenuBox(boolean expanded, Function1<? super Boolean, Unit> onExpandedChange, Modifier modifier, Function3<? super androidx.compose.material.ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i7) {
        int anon3;
        Object traceInProgress2;
        boolean maybeCachedBoxMeasurePolicy;
        int $dirty;
        Object coordinates2;
        int $dirty2;
        boolean traceInProgress;
        Ref ref2;
        Object this_$iv;
        int i;
        Object coordinates;
        Function0 factory$iv$iv$iv;
        int i2;
        int i8;
        int str;
        Object obj5;
        int i6;
        Object it$iv2;
        Composer composer2;
        Object currentCompositionLocalMap;
        Object menuHeight$delegate;
        Object mutableIntStateOf2;
        Object verticalMarginInPx;
        Object mutableIntStateOf;
        Object modifier4;
        int i12;
        int i14;
        int anon;
        Object ref;
        int empty2;
        int i16;
        Object empty;
        int i13;
        Object anon4;
        Object anon2;
        int it$iv;
        int i3;
        Object obj2;
        Composer.Companion companion2;
        Composer composer3;
        Object companion3;
        Object focusRequester;
        Object view;
        int i19;
        int invalid$iv;
        Object obj;
        int companion;
        Object obj4;
        Object modifier3;
        int i4;
        Object obj3;
        int i5;
        int i18;
        int i15;
        int i17;
        Modifier modifier2;
        int i20;
        int i9;
        Alignment alignment;
        int i11;
        Function0 function0;
        BoxScopeInstance boxScopeInstance;
        Composer composer;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        int i10;
        int obj41;
        final boolean z = expanded;
        traceInProgress2 = onExpandedChange;
        final Object obj7 = content;
        i = $changed;
        anon3 = -617870381;
        final Composer restartGroup = $composer.startRestartGroup(anon3);
        ComposerKt.sourceInformation(restartGroup, "C(ExposedDropdownMenuBox)P(1,3,2)96@4191L7,97@4224L7,98@4249L33,99@4305L33,101@4439L37,103@4494L488,116@5008L29,119@5086L289,130@5419L31,131@5476L38,118@5043L550,137@5610L59,137@5599L70,141@5698L418,141@5675L441:ExposedDropdownMenu.android.kt#jmzs0o");
        $dirty = $changed;
        if (i7 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i & 6 == 0) {
                i2 = restartGroup.changed(z) ? 4 : 2;
                $dirty |= i2;
            }
        }
        if (i7 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i & 48 == 0) {
                i8 = restartGroup.changedInstance(traceInProgress2) ? 32 : 16;
                $dirty |= i8;
            }
        }
        str = i7 & 4;
        if (str != null) {
            $dirty |= 384;
            modifier4 = modifier;
        } else {
            if (i & 384 == 0) {
                i12 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i12;
            } else {
                modifier4 = modifier;
            }
        }
        if (i7 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i & 3072 == 0) {
                i14 = restartGroup.changedInstance(obj7) ? 2048 : 1024;
                $dirty |= i14;
            }
        }
        anon = $dirty;
        if (anon & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (str != null) {
                    modifier4 = $dirty2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon3, anon, -1, "androidx.compose.material.ExposedDropdownMenuBox (ExposedDropdownMenu.android.kt:95)");
                }
                int i30 = 0;
                int i34 = 0;
                int i61 = 2023513938;
                String str4 = "CC:CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, i61, str4);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv2 = consume2;
                int i35 = 0;
                int i74 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i61, str4);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                this_$iv = consume;
                String str3 = "CC(remember):ExposedDropdownMenu.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1870741442, str3);
                int i37 = 0;
                Composer composer7 = restartGroup;
                int i75 = 0;
                Object rememberedValue5 = composer7.rememberedValue();
                int i87 = 0;
                int i53 = 0;
                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                    int i52 = 0;
                    composer7.updateRememberedValue(SnapshotIntStateKt.mutableIntStateOf(i53));
                } else {
                    mutableIntStateOf2 = rememberedValue5;
                }
                Object invalid$iv2 = mutableIntStateOf2;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1870743234, str3);
                int i51 = 0;
                Composer composer8 = restartGroup;
                int i76 = 0;
                Object rememberedValue6 = composer8.rememberedValue();
                int i88 = 0;
                obj41 = i53;
                if (rememberedValue6 == Composer.Companion.getEmpty()) {
                    int i54 = 0;
                    composer8.updateRememberedValue(SnapshotIntStateKt.mutableIntStateOf(obj41));
                } else {
                    mutableIntStateOf = rememberedValue6;
                }
                Object invalid$iv3 = mutableIntStateOf;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i62 = 0;
                int $this$ExposedDropdownMenuBox_u24lambda_u246 = (Density)this_$iv2.roundToPx-0680j_4(MenuKt.getMenuVerticalMargin());
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1870747526, str3);
                int i64 = 0;
                Composer composer12 = restartGroup;
                int i85 = 0;
                Object rememberedValue3 = composer12.rememberedValue();
                int i89 = 0;
                i4 = anon;
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    int i58 = 0;
                    companion3 = new Ref();
                    composer12.updateRememberedValue(companion3);
                } else {
                    ref = rememberedValue3;
                }
                Ref ref3 = ref;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1870749737, str3);
                i60 |= changed5;
                Composer composer9 = restartGroup;
                int i78 = 0;
                Object rememberedValue7 = composer9.rememberedValue();
                int i90 = 0;
                if (empty2 == 0) {
                    invalid$iv = empty2;
                    if (rememberedValue7 == Composer.Companion.getEmpty()) {
                        companion3 = invalid$iv4;
                        anon = new ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox.scope.1.1(this_$iv2, invalid$iv3, invalid$iv2);
                        composer9.updateRememberedValue(anon);
                    } else {
                        anon = rememberedValue7;
                    }
                } else {
                    invalid$iv = empty2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1870765726, str3);
                int i67 = 0;
                Composer composer13 = restartGroup;
                int i86 = 0;
                obj3 = this_$iv2;
                Object rememberedValue = composer13.rememberedValue();
                companion2 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    int i49 = 0;
                    focusRequester = new FocusRequester();
                    composer13.updateRememberedValue(focusRequester);
                } else {
                    obj5 = rememberedValue;
                }
                anon3 = obj5;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1870768482, str3);
                Composer composer10 = restartGroup;
                int i79 = 0;
                Object rememberedValue8 = composer10.rememberedValue();
                int i95 = 0;
                if (i39 |= changed6 == 0) {
                    if (rememberedValue8 == Composer.Companion.getEmpty()) {
                        Ref it$iv4 = ref3;
                        companion = invalid$iv3;
                        invalid$iv = $this$ExposedDropdownMenuBox_u24lambda_u246;
                        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox.1.1 it$iv3 = new ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox.1.1(it$iv4, view, invalid$iv, invalid$iv2, companion);
                        int coordinates4 = view2;
                        ref2 = ref4;
                        menuHeight$delegate = view;
                        verticalMarginInPx = companion;
                        it$iv = invalid$iv;
                        obj2 = coordinates3;
                        composer10.updateRememberedValue((Function1)it$iv3);
                    } else {
                        ref2 = ref3;
                        obj2 = coordinates;
                        it$iv = $this$ExposedDropdownMenuBox_u24lambda_u246;
                        verticalMarginInPx = invalid$iv3;
                        menuHeight$delegate = view;
                    }
                } else {
                    view = this_$iv;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1870778880, str3);
                i6 = i4 & 112 == 32 ? 1 : obj41;
                i13 = i4 & 14 == 4 ? 1 : obj41;
                Composer composer11 = restartGroup;
                int i82 = 0;
                it$iv2 = composer11.rememberedValue();
                int i93 = 0;
                if (i6 |= i13 == 0) {
                    modifier3 = modifier4;
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        modifier4 = 0;
                        obj4 = it$iv2;
                        it$iv2 = new ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox.2.1(traceInProgress2, z);
                        composer11.updateRememberedValue((Function0)it$iv2);
                    } else {
                        obj4 = it$iv2;
                    }
                } else {
                    modifier3 = modifier4;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i69 = 6;
                Modifier focusRequester2 = FocusRequesterModifierKt.focusRequester(ExposedDropdownMenu_androidKt.expandable(OnGloballyPositionedModifierKt.onGloballyPositioned(modifier4, (Function1)coordinates), (Function0)it$iv2, Strings_androidKt.getString-4foXLRw(Strings.Companion.getExposedDropdownMenu-UdPEhr4(), restartGroup, i69)), (FocusRequester)anon3);
                int i44 = obj41;
                int i92 = i69;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment topStart = Alignment.Companion.getTopStart();
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                companion = 0;
                i18 = i56;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                i15 = currentCompositeKeyHash;
                modifier2 = focusRequester2;
                Function0 function02 = constructor;
                i17 = 0;
                alignment = topStart;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function02);
                } else {
                    factory$iv$iv$iv = function02;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i96 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i97 = 0;
                Composer composer14 = constructor-impl;
                int i98 = 0;
                if (!composer14.getInserting()) {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    map = currentCompositionLocalMap;
                    if (!Intrinsics.areEqual(composer14.rememberedValue(), Integer.valueOf(i15))) {
                        composer14.updateRememberedValue(Integer.valueOf(i15));
                        constructor-impl.apply(Integer.valueOf(i15), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer14;
                    }
                } else {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    map = currentCompositionLocalMap;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, focusRequester2), ComposeUiNode.Companion.getSetModifier());
                Composer composer5 = restartGroup;
                i20 = i22;
                ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i72 |= 6;
                i11 = 0;
                boxScopeInstance = iNSTANCE;
                i10 = i46;
                Composer composer6 = composer3;
                ComposerKt.sourceInformationMarkerStart(composer6, 1037976660, "C134@5578L9:ExposedDropdownMenu.android.kt#jmzs0o");
                obj7.invoke((ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox.scope.1.1)anon, composer6, Integer.valueOf(i23 &= 112));
                ComposerKt.sourceInformationMarkerEnd(composer6);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1870785020, str3);
                i3 = i4 & 14 == 4 ? 1 : 0;
                Composer composer4 = restartGroup;
                int i33 = 0;
                Object rememberedValue4 = composer4.rememberedValue();
                int i57 = 0;
                if (i3 == 0) {
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon2 = new ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox.4.1(z, anon3);
                        composer4.updateRememberedValue((Function0)anon2);
                    } else {
                        anon2 = rememberedValue4;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.SideEffect((Function0)anon2, restartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1870788195, str3);
                i = restartGroup;
                int i48 = 0;
                modifier4 = i.rememberedValue();
                i16 = 0;
                if (i28 |= changed == 0) {
                    if (modifier4 == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon4 = new ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox.5.1(menuHeight$delegate, ref2, it$iv, verticalMarginInPx);
                        i.updateRememberedValue((Function1)anon4);
                    } else {
                        anon4 = modifier4;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.DisposableEffect(menuHeight$delegate, (Function1)anon4, restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                coordinates2 = modifier3;
            } else {
                restartGroup.skipToGroupEnd();
                coordinates2 = modifier4;
                i4 = anon;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            anon3 = new ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox.6(z, onExpandedChange, coordinates2, obj7, $changed, i7);
            endRestartGroup.updateScope((Function2)anon3);
        }
    }

    private static final int ExposedDropdownMenuBox$lambda$1(MutableIntState $width$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (IntState)$width$delegate.getIntValue();
    }

    private static final void ExposedDropdownMenuBox$lambda$2(MutableIntState $width$delegate, int value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $width$delegate.setIntValue(value);
    }

    private static final int ExposedDropdownMenuBox$lambda$4(MutableIntState $menuHeight$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (IntState)$menuHeight$delegate.getIntValue();
    }

    private static final void ExposedDropdownMenuBox$lambda$5(MutableIntState $menuHeight$delegate, int value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $menuHeight$delegate.setIntValue(value);
    }

    public static final int access$ExposedDropdownMenuBox$lambda$1(MutableIntState $width$delegate) {
        return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$1($width$delegate);
    }

    public static final void access$ExposedDropdownMenuBox$lambda$2(MutableIntState $width$delegate, int value) {
        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$2($width$delegate, value);
    }

    public static final int access$ExposedDropdownMenuBox$lambda$4(MutableIntState $menuHeight$delegate) {
        return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$4($menuHeight$delegate);
    }

    public static final void access$ExposedDropdownMenuBox$lambda$5(MutableIntState $menuHeight$delegate, int value) {
        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$5($menuHeight$delegate, value);
    }

    public static final void access$updateHeight(View view, LayoutCoordinates coordinates, int verticalMarginInPx, Function1 onHeightUpdate) {
        ExposedDropdownMenu_androidKt.updateHeight(view, coordinates, verticalMarginInPx, onHeightUpdate);
    }

    private static final Modifier expandable(Modifier $this$expandable, Function0<Unit> onExpandedChange, String menuLabel) {
        final int i = 0;
        ExposedDropdownMenu_androidKt.expandable.1 anon = new ExposedDropdownMenu_androidKt.expandable.1(onExpandedChange, i);
        ExposedDropdownMenu_androidKt.expandable.2 anon2 = new ExposedDropdownMenu_androidKt.expandable.2(menuLabel, onExpandedChange);
        return SemanticsModifierKt.semantics$default(SuspendingPointerInputFilterKt.pointerInput($this$expandable, onExpandedChange, (Function2)anon), false, (Function1)anon2, 1, i);
    }

    private static final void updateHeight(View view, LayoutCoordinates coordinates, int verticalMarginInPx, Function1<? super Integer, Unit> onHeightUpdate) {
        if (coordinates == null) {
        }
        Rect rect = new Rect();
        int i = 0;
        view.getWindowVisibleDisplayFrame(rect);
        onHeightUpdate.invoke(Integer.valueOf(i5 -= verticalMarginInPx));
    }
}
