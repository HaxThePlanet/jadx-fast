package androidx.compose.material3;

import android.graphics.Rect;
import android.view.View;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect.Companion;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001aQ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u00040\u0008¢\u0006\u0002\u0008\r¢\u0006\u0002\u0008\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0016H\u0003¢\u0006\u0002\u0010\u0017\u001a\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0019H\u0002\u001aV\u0010\u001e\u001a\u00020\n*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0002ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(\u001a\u000e\u0010)\u001a\u00020\u001b*\u0004\u0018\u00010*H\u0002\u001a\u000c\u0010+\u001a\u00020\u001b*\u00020\u0012H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006,²\u0006\u000c\u0010-\u001a\u0004\u0018\u00010*X\u008a\u008e\u0002²\u0006\n\u0010.\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u00020\u0019X\u008a\u008e\u0002", d2 = {"ExposedDropdownMenuItemHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SoftKeyboardListener", "view", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "onKeyboardVisibilityChange", "Lkotlin/Function0;", "(Landroid/view/View;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "calculateMaxHeight", "", "windowBounds", "Landroidx/compose/ui/geometry/Rect;", "anchorBounds", "verticalMargin", "expandable", "anchorType", "Landroidx/compose/material3/MenuAnchorType;", "expandedDescription", "", "collapsedDescription", "toggleDescription", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "expandable-Gq7TBQ4", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Landroidx/compose/ui/Modifier;", "getAnchorBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getWindowBounds", "material3_release", "anchorCoordinates", "anchorWidth", "menuMaxHeight"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ExposedDropdownMenu_androidKt {

    private static final float ExposedDropdownMenuItemHorizontalPadding;
    static {
        final int i2 = 0;
        ExposedDropdownMenu_androidKt.ExposedDropdownMenuItemHorizontalPadding = Dp.constructor-impl((float)i);
    }

    public static final void ExposedDropdownMenuBox(boolean expanded, Function1<? super Boolean, Unit> onExpandedChange, Modifier modifier, Function3<? super androidx.compose.material3.ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i7) {
        boolean traceInProgress2;
        Object config;
        Object focusRequester;
        boolean anchorTypeState;
        Object $i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$anchorWidth$2;
        Object $i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$focusRequester$1;
        Object mutableStateOf$default;
        Function1 $this$cache$iv2;
        Composer $this$cache$iv;
        Composer composer;
        int i13;
        int $dirty2;
        Object $dirty;
        int i6;
        String it$iv3;
        Composer it$iv2;
        Integer currentCompositionLocalMap;
        Object $i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$3;
        int empty3;
        int empty2;
        Object $i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$4;
        int i;
        int i18;
        Object obj3;
        Object modifier3;
        String modifier4;
        Object $i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$1;
        Function0 factory$iv$iv$iv;
        Object density;
        Object $i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$anchorCoordinates$2;
        String expandedDescription;
        Object obj11;
        boolean traceInProgress;
        Object view;
        Composer composer3;
        int i11;
        Object maybeCachedBoxMeasurePolicy;
        int i19;
        int i20;
        Object rememberedValue2;
        Object density2;
        Object rememberedValue;
        Object i8;
        int empty4;
        int anchorWidth$delegate;
        Object collapsedDescription;
        Object menuMaxHeight$delegate;
        int obj9;
        Composer composer4;
        int i2;
        Object toggleDescription;
        Object $i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$menuMaxHeight$2;
        int empty;
        Object verticalMargin;
        Object obj10;
        int companion;
        Object obj4;
        boolean companion2;
        String str2;
        Object i21;
        Object obj5;
        Object focusRequester2;
        Object focusRequester3;
        int invalid$iv2;
        int invalid$iv;
        Object obj8;
        int i17;
        int i5;
        Object obj2;
        int i4;
        int i10;
        Alignment alignment;
        Composer.Companion companion3;
        Object keyboardController;
        int i14;
        Object it$iv;
        Object obj6;
        Object obj7;
        String str;
        int i15;
        String collapsedDescription2;
        int i3;
        Modifier modifier2;
        int i9;
        int i12;
        Object obj;
        Composer composer5;
        Function0 function0;
        int i16;
        BoxScopeInstance boxScopeInstance;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Composer composer2;
        Modifier modifier5;
        Function1 function1;
        int obj49;
        obj9 = content;
        toggleDescription = $changed;
        traceInProgress2 = 2067579792;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(ExposedDropdownMenuBox)P(1,3,2)140@6498L7,141@6531L7,142@6570L7,146@6683L53,147@6760L33,148@6819L33,150@6879L29,151@6970L7,152@7008L31,153@7071L32,154@7132L37,155@7196L62,158@7284L2210,200@9543L361,199@9500L442,225@10317L47,225@10306L58,229@10529L27,229@10497L59:ExposedDropdownMenu.android.kt#uh7d8r");
        $dirty2 = $changed;
        if (i7 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (toggleDescription & 6 == 0) {
                i = restartGroup.changed(expanded) ? 4 : 2;
                $dirty2 |= i;
            }
        }
        if (i7 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (toggleDescription & 48 == 0) {
                i18 = restartGroup.changedInstance(onExpandedChange) ? 32 : 16;
                $dirty2 |= i18;
            }
        }
        int i52 = i7 & 4;
        if (i52 != 0) {
            $dirty2 |= 384;
            obj11 = modifier;
        } else {
            if (toggleDescription & 384 == 0) {
                i19 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i19;
            } else {
                obj11 = modifier;
            }
        }
        if (i7 & 8 != 0) {
            $dirty2 |= 3072;
        } else {
            if (toggleDescription & 3072 == 0) {
                i20 = restartGroup.changedInstance(obj9) ? 2048 : 1024;
                $dirty2 |= i20;
            }
        }
        if ($dirty2 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (i52 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = obj11;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty2, -1, "androidx.compose.material3.ExposedDropdownMenuBox (ExposedDropdownMenu.android.kt:139)");
                }
                int i58 = 0;
                int i65 = 0;
                int i71 = 2023513938;
                String str4 = "CC:CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, i71, str4);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv = consume2;
                int i66 = 0;
                int i79 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i71, str4);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv4 = consume3;
                int i80 = 0;
                int i88 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i71, str4);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv5 = consume4;
                int i89 = 0;
                int roundToPx-0680j_4 = (Density)this_$iv5.roundToPx-0680j_4(MenuKt.getMenuVerticalMargin());
                empty = "CC(remember):ExposedDropdownMenu.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 426259219, empty);
                int i81 = 0;
                obj49 = restartGroup;
                int i91 = 0;
                Object rememberedValue6 = obj49.rememberedValue();
                int i98 = 0;
                int i22 = 0;
                if (rememberedValue6 == Composer.Companion.getEmpty()) {
                    int i57 = 0;
                    obj49.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(i22, i22, 2, i22));
                } else {
                    $this$cache$iv = obj49;
                    $i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$anchorCoordinates$2 = rememberedValue6;
                }
                Object obj18 = $i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$anchorCoordinates$2;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 426261663, empty);
                int i26 = 0;
                Composer composer9 = restartGroup;
                int i72 = 0;
                Object rememberedValue7 = composer9.rememberedValue();
                int i92 = 0;
                int i84 = 0;
                if (rememberedValue7 == Composer.Companion.getEmpty()) {
                    int i24 = 0;
                    composer9.updateRememberedValue(SnapshotIntStateKt.mutableIntStateOf(i84));
                } else {
                    $i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$anchorWidth$2 = rememberedValue7;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 426263551, empty);
                int i28 = 0;
                Composer composer10 = restartGroup;
                int i73 = 0;
                Object rememberedValue8 = composer10.rememberedValue();
                int i93 = 0;
                int i100 = i84;
                if (rememberedValue8 == Composer.Companion.getEmpty()) {
                    int i87 = 0;
                    composer10.updateRememberedValue(SnapshotIntStateKt.mutableIntStateOf(i100));
                } else {
                    $i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$menuMaxHeight$2 = rememberedValue8;
                }
                Object obj16 = $i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$menuMaxHeight$2;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 426265467, empty);
                int i30 = 0;
                Composer composer11 = restartGroup;
                int i74 = 0;
                Object rememberedValue10 = composer11.rememberedValue();
                int i94 = 0;
                obj2 = $i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$anchorWidth$2;
                if (rememberedValue10 == Composer.Companion.getEmpty()) {
                    int i23 = 0;
                    focusRequester2 = new FocusRequester();
                    composer11.updateRememberedValue(focusRequester2);
                } else {
                    $i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$focusRequester$1 = rememberedValue10;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i55 = 0;
                int i75 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, str4);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                androidx.compose.material3.internal.Strings.Companion companion8 = Strings.Companion;
                int i76 = 0;
                int $i$f$getMenuExpanded8iCLdWM = i100;
                String string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_dropdown_menu_expanded), restartGroup, $i$f$getMenuExpanded8iCLdWM);
                androidx.compose.material3.internal.Strings.Companion companion10 = Strings.Companion;
                int i86 = 0;
                String string-2EP1pXo2 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_dropdown_menu_collapsed), restartGroup, $i$f$getMenuExpanded8iCLdWM);
                androidx.compose.material3.internal.Strings.Companion companion11 = Strings.Companion;
                int i95 = 0;
                String string-2EP1pXo3 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_dropdown_menu_toggle), restartGroup, $i$f$getMenuExpanded8iCLdWM);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 426275644, empty);
                int i78 = 0;
                Composer composer14 = restartGroup;
                int i97 = 0;
                Object obj17 = $i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$focusRequester$1;
                mutableStateOf$default = composer14.rememberedValue();
                int i101 = 0;
                Object obj19 = this_$iv2;
                if (mutableStateOf$default == Composer.Companion.getEmpty()) {
                    it$iv = mutableStateOf$default;
                    companion3 = i36;
                    i17 = $dirty2;
                    $dirty2 = 0;
                    composer14.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(MenuAnchorType.box-impl(MenuAnchorType.Companion.getPrimaryNotEditable-Mg6Rgbw()), $dirty2, 2, $dirty2));
                } else {
                    it$iv = mutableStateOf$default;
                    i17 = $dirty2;
                    composer = composer14;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 426280608, empty);
                i10 = 1;
                i13 = i17 & 14 == 4 ? i10 : 0;
                i6 = i17 & 112 == 32 ? i10 : 0;
                Composer composer6 = restartGroup;
                i21 = 0;
                Object rememberedValue3 = composer6.rememberedValue();
                int i102 = 0;
                if (i35 | changed3 == 0) {
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        it$iv = 0;
                        obj7 = modifier3;
                        obj6 = this_$iv5;
                        obj49 = i17;
                        boolean $this$cache$iv3 = expanded;
                        Object anchorTypeState2 = obj17;
                        focusRequester3 = rememberedValue3;
                        toggleDescription = this_$iv4;
                        keyboardController = obj14;
                        Function1 config3 = onExpandedChange;
                        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox.scope.1.1 config2 = new ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox.scope.1.1(anchorTypeState2, $this$cache$iv3, string-2EP1pXo, string-2EP1pXo2, string-2EP1pXo3, obj19, (MutableState)mutableStateOf$default, config3, obj2, (MutableIntState)obj16);
                        config = anchorTypeState2;
                        anchorTypeState = $this$cache$iv3;
                        $this$cache$iv2 = function1;
                        composer6.updateRememberedValue(config2);
                    } else {
                        composer4 = composer6;
                        obj7 = modifier3;
                        obj6 = this_$iv5;
                        modifier4 = string-2EP1pXo2;
                        obj49 = i17;
                        collapsedDescription = obj2;
                        $this$cache$iv2 = onExpandedChange;
                        density2 = mutableStateOf$default;
                        it$iv3 = string-2EP1pXo;
                        expandedDescription = string-2EP1pXo3;
                        anchorTypeState = expanded;
                        toggleDescription = this_$iv4;
                        view = obj19;
                        keyboardController = this_$iv;
                        config = obj17;
                        focusRequester3 = i8;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 426351047, empty);
                Composer composer15 = restartGroup;
                int i103 = 0;
                str = it$iv3;
                Object rememberedValue4 = composer15.rememberedValue();
                int i104 = 0;
                if (changedInstance4 |= companion2 == 0) {
                    collapsedDescription2 = modifier4;
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        int collapsedDescription3 = 0;
                        obj2 = obj16;
                        focusRequester3 = roundToPx-0680j_4;
                        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox.1.1 anon = new ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox.1.1(toggleDescription, focusRequester3, (MutableState)obj18, collapsedDescription, obj2);
                        anchorWidth$delegate = focusRequester3;
                        menuMaxHeight$delegate = obj18;
                        verticalMargin = obj2;
                        obj4 = rememberedValue4;
                        composer15.updateRememberedValue((Function1)anon);
                    } else {
                        obj4 = $i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$1;
                        obj8 = collapsedDescription;
                        anchorWidth$delegate = roundToPx-0680j_4;
                        it$iv2 = composer15;
                        verticalMargin = obj16;
                        menuMaxHeight$delegate = obj18;
                    }
                } else {
                    collapsedDescription2 = modifier4;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(obj7, (Function1)$i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$1);
                i2 = i4;
                companion = 0;
                str2 = expandedDescription;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment topStart = Alignment.Companion.getTopStart();
                int i56 = 0;
                obj5 = view;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i56);
                i5 = 0;
                alignment = topStart;
                i14 = i56;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                i15 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, onGloballyPositioned);
                modifier2 = onGloballyPositioned;
                Function0 function02 = constructor;
                i3 = 0;
                obj = density2;
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
                int i105 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i106 = 0;
                Composer composer16 = constructor-impl;
                int i107 = 0;
                if (!composer16.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                    if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(i15))) {
                        composer16.updateRememberedValue(Integer.valueOf(i15));
                        constructor-impl.apply(Integer.valueOf(i15), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer16;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer8 = restartGroup;
                i11 = 0;
                i9 = i42;
                ComposerKt.sourceInformationMarkerStart(composer8, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i69 |= 6;
                i16 = 0;
                boxScopeInstance = iNSTANCE;
                modifier5 = materializeModifier;
                Composer materialized$iv$iv = composer5;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -615130921, "C211@9927L9:ExposedDropdownMenu.android.kt#uh7d8r");
                content.invoke((ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox.scope.1.1)i8, materialized$iv$iv, Integer.valueOf(i43 &= 112));
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                restartGroup.startReplaceGroup(426363998);
                ComposerKt.sourceInformation(restartGroup, "215@10008L286,215@9972L322");
                if (anchorTypeState) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 426365852, empty);
                    changedInstance |= changed5;
                    Composer composer12 = restartGroup;
                    int i59 = 0;
                    rememberedValue = composer12.rememberedValue();
                    i2 = 0;
                    if (empty3 == 0) {
                        invalid$iv = empty3;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            companion = invalid$iv3;
                            $i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$3 = new ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox.3.1(toggleDescription, anchorWidth$delegate, menuMaxHeight$delegate, verticalMargin);
                            composer12.updateRememberedValue((Function0)$i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$3);
                        } else {
                            $i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$3 = rememberedValue;
                        }
                    } else {
                        invalid$iv = empty3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ExposedDropdownMenu_androidKt.SoftKeyboardListener(toggleDescription, obj6, (Function0)$i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$3, restartGroup, 0);
                } else {
                    density = obj6;
                }
                restartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(restartGroup, 426375501, empty);
                empty2 = obj49 & 14 == 4 ? i10 : 0;
                Composer composer13 = restartGroup;
                int i70 = 0;
                Object rememberedValue9 = composer13.rememberedValue();
                int i90 = 0;
                if (empty2 == 0) {
                    invalid$iv2 = empty2;
                    if (rememberedValue9 == Composer.Companion.getEmpty()) {
                        companion = invalid$iv4;
                        $i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$4 = new ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox.4.1(anchorTypeState, config);
                        composer13.updateRememberedValue((Function0)$i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$4);
                    } else {
                        $i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$4 = rememberedValue9;
                    }
                } else {
                    invalid$iv2 = empty2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.SideEffect((Function0)$i$a$CacheExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$4, restartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 426382265, empty);
                if (obj49 & 112 == 32) {
                } else {
                    i10 = 0;
                }
                Composer composer7 = restartGroup;
                int i63 = 0;
                rememberedValue2 = composer7.rememberedValue();
                obj9 = 0;
                if (i10 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        empty = 0;
                        obj10 = config;
                        focusRequester = new ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox.5.1($this$cache$iv2);
                        composer7.updateRememberedValue((Function0)focusRequester);
                    } else {
                        obj10 = config;
                        focusRequester = rememberedValue2;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                BackHandlerKt.BackHandler(anchorTypeState, (Function0)focusRequester, restartGroup, obj49 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty = obj7;
            } else {
                restartGroup.skipToGroupEnd();
                obj49 = $dirty2;
                $dirty = obj11;
                obj3 = obj9;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox.6(anchorTypeState, $this$cache$iv2, $dirty, obj3, $changed, i7);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final LayoutCoordinates ExposedDropdownMenuBox$lambda$2(MutableState<LayoutCoordinates> $anchorCoordinates$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (LayoutCoordinates)(State)$anchorCoordinates$delegate.getValue();
    }

    private static final void ExposedDropdownMenuBox$lambda$3(MutableState<LayoutCoordinates> $anchorCoordinates$delegate, LayoutCoordinates value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $anchorCoordinates$delegate.setValue(value);
    }

    private static final int ExposedDropdownMenuBox$lambda$5(MutableIntState $anchorWidth$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (IntState)$anchorWidth$delegate.getIntValue();
    }

    private static final void ExposedDropdownMenuBox$lambda$6(MutableIntState $anchorWidth$delegate, int value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $anchorWidth$delegate.setIntValue(value);
    }

    private static final int ExposedDropdownMenuBox$lambda$8(MutableIntState $menuMaxHeight$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (IntState)$menuMaxHeight$delegate.getIntValue();
    }

    private static final void ExposedDropdownMenuBox$lambda$9(MutableIntState $menuMaxHeight$delegate, int value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $menuMaxHeight$delegate.setIntValue(value);
    }

    private static final void SoftKeyboardListener(View view, Density density, Function0<Unit> onKeyboardVisibilityChange, Composer $composer, int $changed) {
        int traceInProgress2;
        int $dirty;
        int i6;
        int i4;
        int i5;
        boolean skipping;
        boolean traceInProgress;
        int i2;
        int i3;
        int rememberedValue;
        int i;
        Object empty;
        Object anon;
        traceInProgress2 = -1319522472;
        final Composer obj11 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj11, "C(SoftKeyboardListener)P(2)240@10912L1420,240@10880L1452:ExposedDropdownMenu.android.kt#uh7d8r");
        if ($changed & 6 == 0) {
            i6 = obj11.changedInstance(view) ? 4 : 2;
            $dirty |= i6;
        }
        if ($changed & 48 == 0) {
            i4 = obj11.changed(density) ? 32 : 16;
            $dirty |= i4;
        }
        i3 = 256;
        if ($changed & 384 == 0) {
            i5 = obj11.changedInstance(onKeyboardVisibilityChange) ? i3 : 128;
            $dirty |= i5;
        }
        if ($dirty & 147 == 146) {
            if (!obj11.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.SoftKeyboardListener (ExposedDropdownMenu.android.kt:237)");
                }
                ComposerKt.sourceInformationMarkerStart(obj11, 1935200244, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                i2 = $dirty & 896 == i3 ? 1 : 0;
                Composer composer = obj11;
                i3 = 0;
                rememberedValue = composer.rememberedValue();
                i = 0;
                if (changedInstance |= i2 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new ExposedDropdownMenu_androidKt.SoftKeyboardListener.1.1(view, onKeyboardVisibilityChange);
                        composer.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(obj11);
                EffectsKt.DisposableEffect(view, density, (Function1)anon, obj11, i9 |= skipping);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj11.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj11.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new ExposedDropdownMenu_androidKt.SoftKeyboardListener.2(view, density, onKeyboardVisibilityChange, $changed);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    public static final LayoutCoordinates access$ExposedDropdownMenuBox$lambda$2(MutableState $anchorCoordinates$delegate) {
        return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$2($anchorCoordinates$delegate);
    }

    public static final void access$ExposedDropdownMenuBox$lambda$3(MutableState $anchorCoordinates$delegate, LayoutCoordinates value) {
        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$3($anchorCoordinates$delegate, value);
    }

    public static final int access$ExposedDropdownMenuBox$lambda$5(MutableIntState $anchorWidth$delegate) {
        return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$5($anchorWidth$delegate);
    }

    public static final void access$ExposedDropdownMenuBox$lambda$6(MutableIntState $anchorWidth$delegate, int value) {
        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$6($anchorWidth$delegate, value);
    }

    public static final int access$ExposedDropdownMenuBox$lambda$8(MutableIntState $menuMaxHeight$delegate) {
        return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$8($menuMaxHeight$delegate);
    }

    public static final void access$ExposedDropdownMenuBox$lambda$9(MutableIntState $menuMaxHeight$delegate, int value) {
        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$9($menuMaxHeight$delegate, value);
    }

    public static final void access$SoftKeyboardListener(View view, Density density, Function0 onKeyboardVisibilityChange, Composer $composer, int $changed) {
        ExposedDropdownMenu_androidKt.SoftKeyboardListener(view, density, onKeyboardVisibilityChange, $composer, $changed);
    }

    public static final int access$calculateMaxHeight(Rect windowBounds, Rect anchorBounds, int verticalMargin) {
        return ExposedDropdownMenu_androidKt.calculateMaxHeight(windowBounds, anchorBounds, verticalMargin);
    }

    public static final Modifier access$expandable-Gq7TBQ4(Modifier $receiver, boolean expanded, Function0 onExpandedChange, String anchorType, String expandedDescription, String collapsedDescription, String toggleDescription, SoftwareKeyboardController keyboardController) {
        return ExposedDropdownMenu_androidKt.expandable-Gq7TBQ4($receiver, expanded, onExpandedChange, anchorType, expandedDescription, collapsedDescription, toggleDescription, keyboardController);
    }

    public static final Rect access$getAnchorBounds(LayoutCoordinates $receiver) {
        return ExposedDropdownMenu_androidKt.getAnchorBounds($receiver);
    }

    public static final float access$getExposedDropdownMenuItemHorizontalPadding$p() {
        return ExposedDropdownMenu_androidKt.ExposedDropdownMenuItemHorizontalPadding;
    }

    public static final Rect access$getWindowBounds(View $receiver) {
        return ExposedDropdownMenu_androidKt.getWindowBounds($receiver);
    }

    private static final int calculateMaxHeight(Rect windowBounds, Rect anchorBounds, int verticalMargin) {
        int heightAbove;
        int cmp;
        int bottom;
        int roundToInt;
        int i = 0;
        if (anchorBounds == null) {
            return i;
        }
        top += f;
        bottom2 -= f2;
        if (Float.compare(top2, bottom) <= 0) {
            if (Float.compare(bottom3, bottom) < 0) {
                roundToInt = MathKt.roundToInt(i4 - i3);
            } else {
                roundToInt = MathKt.roundToInt(Math.max(top3 -= i3, i4 - bottom4));
            }
        } else {
        }
        return Math.max(roundToInt, i);
    }

    private static final Modifier expandable-Gq7TBQ4(Modifier $this$expandable_u2dGq7TBQ4, boolean expanded, Function0<Unit> onExpandedChange, String anchorType, String expandedDescription, String collapsedDescription, String toggleDescription, SoftwareKeyboardController keyboardController) {
        final int i = 0;
        ExposedDropdownMenu_androidKt.expandable.1 anon = new ExposedDropdownMenu_androidKt.expandable.1(anchorType, onExpandedChange, i);
        ExposedDropdownMenu_androidKt.expandable.2 anon2 = new ExposedDropdownMenu_androidKt.expandable.2(anchorType, expanded, expandedDescription, collapsedDescription, toggleDescription, onExpandedChange, keyboardController);
        return SemanticsModifierKt.semantics$default(SuspendingPointerInputFilterKt.pointerInput($this$expandable_u2dGq7TBQ4, onExpandedChange, (Function2)anon), false, (Function1)anon2, 1, i);
    }

    private static final Rect getAnchorBounds(LayoutCoordinates $this$getAnchorBounds) {
        Rect zero;
        long size-ozmzZPI;
        if ($this$getAnchorBounds == null) {
            zero = Rect.Companion.getZero();
        } else {
            zero = RectKt.Rect-tz77jQw(LayoutCoordinatesKt.positionInWindow($this$getAnchorBounds), obj1);
        }
        return zero;
    }

    private static final Rect getWindowBounds(View $this$getWindowBounds) {
        Rect rect = new Rect();
        final int i = 0;
        $this$getWindowBounds.getWindowVisibleDisplayFrame(rect);
        return RectHelper_androidKt.toComposeRect(rect);
    }
}
