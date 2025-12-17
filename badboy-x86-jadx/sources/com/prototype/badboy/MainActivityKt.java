package com.prototype.badboy;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import android.provider.Settings.Secure;
import android.telephony.SmsManager;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.content.ContextCompat;
import com.prototype.badboy.ui.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0006\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u001a\u0008\u0002\u0010\u0006\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u0008\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\t\u001a\r\u0010\n\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\u000c²\u0006\n\u0010\r\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u000e\u001a\u00020\u0003X\u008a\u008e\u0002", d2 = {"Greeting", "", "name", "", "modifier", "Landroidx/compose/ui/Modifier;", "requestPermissions", "Lkotlin/Function1;", "", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "GreetingPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "androidId", "displayText"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MainActivityKt {
    public static Unit $r8$lambda$3680DyU35T7tCS-6DjGpj9WQz4M(Context context, Function1 function12, MutableState mutableState3) {
        return MainActivityKt.Greeting$lambda$19$lambda$18$lambda$13$lambda$12(context, function12, mutableState3);
    }

    public static Unit $r8$lambda$Ia4mJhHXDwFudXzbEQOpHpqMqYM(Context context, Function1 function12, MutableState mutableState3) {
        return MainActivityKt.Greeting$lambda$19$lambda$18$lambda$11$lambda$10(context, function12, mutableState3);
    }

    public static Unit $r8$lambda$J2RO30Y1-62JtNlTqjtEPN8Sn3w(Context context, MutableState mutableState2, MutableState mutableState3) {
        return MainActivityKt.Greeting$lambda$19$lambda$18$lambda$9$lambda$8(context, mutableState2, mutableState3);
    }

    public static Unit $r8$lambda$QnaVTRVr9sUxvvR4Pdregi0Id4M(String[] stringArr) {
        return MainActivityKt.Greeting$lambda$1$lambda$0(stringArr);
    }

    public static Unit $r8$lambda$SzF06UAL_BKDjjfNCO97i3iwjAg(int i, Composer composer2, int i3) {
        return MainActivityKt.GreetingPreview$lambda$21(i, composer2, i3);
    }

    public static Unit $r8$lambda$Y-2Isalyj2x0mOqGgKWXZ7J4Z9s(Context context, Function1 function12, MutableState mutableState3) {
        return MainActivityKt.Greeting$lambda$19$lambda$18$lambda$15$lambda$14(context, function12, mutableState3);
    }

    public static Unit $r8$lambda$maVEoQiDLCnPiC4i8Ofx9oorixQ(String string, Modifier modifier2, Function1 function13, int i4, int i5, Composer composer6, int i7) {
        return MainActivityKt.Greeting$lambda$20(string, modifier2, function13, i4, i5, composer6, i7);
    }

    public static Unit $r8$lambda$q3SYgL0NRDkrjdofEixEcJuQfRU(Context context, Function1 function12, MutableState mutableState3) {
        return MainActivityKt.Greeting$lambda$19$lambda$18$lambda$17$lambda$16(context, function12, mutableState3);
    }

    public static final void Greeting(String name, Modifier modifier, Function1<? super String[], Unit> requestPermissions, Composer $composer, int $changed, int i6) {
        Object externalSyntheticLambda6;
        boolean traceInProgress;
        Object rememberedValue2;
        Object rememberedValue5;
        Object rememberedValue4;
        int empty;
        Object externalSyntheticLambda5;
        int fillMaxWidth$default2;
        int $dirty2;
        Object obj8;
        int $dirty;
        Object modifier2;
        Integer currentCompositionLocalMap2;
        Object rememberedValue3;
        int i15;
        int i40;
        int i9;
        int i38;
        int constructor-impl;
        Object obj5;
        int i29;
        Object i26;
        Object requestPermissions2;
        int i22;
        Composer i;
        boolean traceInProgress2;
        Object mutableStateOf$default2;
        int i5;
        Integer currentCompositionLocalMap;
        int empty2;
        int empty4;
        Object empty5;
        Object str;
        kotlin.jvm.functions.Function0 function03;
        Composer composer;
        Object empty6;
        Object columnMeasurePolicy2;
        int i23;
        int i27;
        kotlin.jvm.functions.Function0 function0;
        int rememberedValue;
        int i18;
        Composer composer2;
        Object columnMeasurePolicy;
        int currentCompositeKeyHash;
        Object top;
        Object mutableStateOf$default;
        Object empty3;
        int i42;
        int i30;
        int i24;
        Object obj;
        int i25;
        int currentCompositeKeyHash2;
        androidx.compose.ui.Alignment.Horizontal horizontal;
        int i39;
        int i33;
        int i4;
        kotlin.jvm.functions.Function0 function02;
        int i20;
        Modifier modifier3;
        int i16;
        Modifier modifier5;
        int i35;
        int i2;
        int i21;
        Composer composer3;
        androidx.compose.runtime.CompositionLocalMap map2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        ColumnScopeInstance columnScopeInstance;
        int i7;
        int padding-3ABfNKs;
        int i11;
        int i3;
        kotlin.jvm.functions.Function0 function04;
        ColumnScopeInstance columnScopeInstance2;
        Modifier modifier4;
        androidx.compose.runtime.CompositionLocalMap map;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        com.prototype.badboy.MainActivityKt$$ExternalSyntheticLambda5 activity;
        int companion5;
        Modifier fillMaxWidth$default;
        int i14;
        Object obj4;
        Object obj7;
        Object obj2;
        Composer.Companion companion3;
        int companion;
        int companion4;
        int companion2;
        Object obj6;
        int i13;
        int i8;
        int i28;
        int i31;
        int i17;
        int i19;
        int i32;
        int i34;
        kotlin.jvm.functions.Function3 lambda-5$app_debug;
        Composer composer4;
        Composer composer5;
        int i36;
        Composer composer7;
        Composer composer6;
        int i41;
        int i37;
        int i10;
        int i12;
        Object obj3;
        int obj67;
        int obj69;
        i26 = $changed;
        Intrinsics.checkNotNullParameter(name, "name");
        externalSyntheticLambda6 = 654543564;
        final Composer restartGroup = $composer.startRestartGroup(externalSyntheticLambda6);
        ComposerKt.sourceInformation(restartGroup, "C(Greeting)P(1)70@2603L2,72@2641L7,73@2670L31,74@2725L31,76@2762L5249:MainActivity.kt#3hk3sw");
        $dirty2 = $changed;
        int i75 = i6 & 2;
        if (i75 != 0) {
            $dirty2 |= 48;
            requestPermissions2 = modifier;
        } else {
            if (i26 & 48 == 0) {
                i22 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i22;
            } else {
                requestPermissions2 = modifier;
            }
        }
        i = i6 & 4;
        if (i != 0) {
            $dirty2 |= 384;
            str = requestPermissions;
        } else {
            if (i26 & 384 == 0) {
                i23 = restartGroup.changedInstance(requestPermissions) ? 256 : 128;
                $dirty2 |= i23;
            } else {
                str = requestPermissions;
            }
        }
        int i122 = $dirty2;
        if (i122 & 145 == 144) {
            if (!restartGroup.getSkipping()) {
                if (i75 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = requestPermissions2;
                }
                String str7 = "CC(remember):MainActivity.kt#9igjgp";
                if (i != 0) {
                    restartGroup.startReplaceGroup(-1388754071);
                    ComposerKt.sourceInformation(restartGroup, str7);
                    int i78 = 0;
                    i = restartGroup;
                    i27 = 0;
                    rememberedValue = i.rememberedValue();
                    i18 = 0;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        currentCompositeKeyHash = 0;
                        top = new MainActivityKt$$ExternalSyntheticLambda0();
                        i.updateRememberedValue(top);
                    } else {
                        top = rememberedValue;
                    }
                    requestPermissions2 = top;
                    restartGroup.endReplaceGroup();
                } else {
                    requestPermissions2 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(externalSyntheticLambda6, i122, -1, "com.prototype.badboy.Greeting (MainActivity.kt:71)");
                }
                int i80 = 0;
                int i106 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                externalSyntheticLambda6 = consume;
                restartGroup.startReplaceGroup(-1388751898);
                ComposerKt.sourceInformation(restartGroup, str7);
                int i82 = 0;
                int i107 = i82;
                Composer composer17 = restartGroup;
                int i124 = 0;
                Object rememberedValue9 = composer17.rememberedValue();
                int i147 = 0;
                String str9 = "";
                obj67 = i82;
                int i83 = 2;
                if (rememberedValue9 == Composer.Companion.getEmpty()) {
                    int i152 = 0;
                    traceInProgress = 0;
                    composer17.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(str9, traceInProgress, i83, traceInProgress));
                } else {
                    mutableStateOf$default = rememberedValue9;
                }
                Object obj9 = mutableStateOf$default;
                restartGroup.endReplaceGroup();
                restartGroup.startReplaceGroup(-1388750138);
                ComposerKt.sourceInformation(restartGroup, str7);
                int i109 = obj67;
                Composer composer18 = restartGroup;
                int i125 = 0;
                Object rememberedValue10 = composer18.rememberedValue();
                int i148 = 0;
                if (rememberedValue10 == Composer.Companion.getEmpty()) {
                    empty3 = 0;
                    i26 = 0;
                    composer18.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(str9, i26, i83, i26));
                } else {
                    mutableStateOf$default2 = rememberedValue10;
                }
                i26 = mutableStateOf$default2;
                restartGroup.endReplaceGroup();
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier2, 0, 1, 0);
                int i111 = obj67;
                String str14 = "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -483455358, str14);
                androidx.compose.ui.Alignment.Horizontal start = Alignment.Companion.getStart();
                columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), start, restartGroup, i154 | i157);
                i30 = 0;
                String modifier6 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, modifier6);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, obj67);
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                horizontal = start;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, fillMaxSize$default);
                kotlin.jvm.functions.Function0 function05 = constructor2;
                i39 = 0;
                modifier3 = fillMaxSize$default;
                String str12 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, str12);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function05);
                } else {
                    function03 = function05;
                    restartGroup.useNode();
                }
                function02 = function03;
                Composer constructor-impl6 = Updater.constructor-impl(restartGroup);
                int i161 = 0;
                i2 = i126;
                Updater.set-impl(constructor-impl6, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i162 = 0;
                Composer composer19 = constructor-impl6;
                int i163 = 0;
                if (!composer19.getInserting()) {
                    map2 = currentCompositionLocalMap;
                    measurePolicy2 = columnMeasurePolicy;
                    if (!Intrinsics.areEqual(composer19.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer19.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl6.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer19;
                    }
                } else {
                    map2 = currentCompositionLocalMap;
                    measurePolicy2 = columnMeasurePolicy;
                }
                Updater.set-impl(constructor-impl6, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer13 = restartGroup;
                modifier5 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer13, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                i = composer13;
                i35 = 0;
                i21 = i89;
                ComposerKt.sourceInformationMarkerStart(i, 1157528740, "C82@2928L21,79@2828L4950:MainActivity.kt#3hk3sw");
                int i91 = 0;
                int i164 = 0;
                i10 = i127;
                i7 = 432;
                padding-3ABfNKs = 0;
                i12 = i142;
                ComposerKt.sourceInformationMarkerStart(i, -483455358, str14);
                columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getCenterHorizontally(), i, i145 |= i150);
                i18 = 0;
                ComposerKt.sourceInformationMarkerStart(i, -1323940314, modifier6);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(i, 0);
                currentCompositionLocalMap2 = i.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(i, PaddingKt.padding-3ABfNKs(ScrollKt.verticalScroll$default(ColumnScope.weight$default((ColumnScope)ColumnScopeInstance.INSTANCE, (Modifier)Modifier.Companion, 1065353216, false, 2, 0), ScrollKt.rememberScrollState(i91, i, i91, 1), false, 0, false, 14, 0), Dp.constructor-impl((float)i117)));
                kotlin.jvm.functions.Function0 function06 = constructor;
                i24 = 0;
                i3 = i132;
                ComposerKt.sourceInformationMarkerStart(i, -692256719, str12);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                i.startReusableNode();
                if (i.getInserting()) {
                    i.createNode(function06);
                } else {
                    function0 = function06;
                    i.useNode();
                }
                Composer constructor-impl8 = Updater.constructor-impl(i);
                int i160 = 0;
                function04 = function0;
                Updater.set-impl(constructor-impl8, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl8, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i167 = 0;
                Composer composer20 = constructor-impl8;
                int i170 = 0;
                if (!composer20.getInserting()) {
                    map = currentCompositionLocalMap2;
                    measurePolicy = columnMeasurePolicy2;
                    if (!Intrinsics.areEqual(composer20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl8.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer20;
                    }
                } else {
                    map = currentCompositionLocalMap2;
                    measurePolicy = columnMeasurePolicy2;
                }
                Updater.set-impl(constructor-impl8, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                empty6 = i;
                i27 = 0;
                i16 = i55;
                ComposerKt.sourceInformationMarkerStart(empty6, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                i136 |= 6;
                Composer composer21 = empty6;
                i11 = 0;
                modifier4 = materializeModifier2;
                ComposerKt.sourceInformationMarkerStart(empty6, 653305464, "C88@3156L259,87@3122L410,100@3546L40,103@3634L879,102@3600L1028,126@4642L40,129@4730L860,128@4696L1013,152@5723L40,155@5811L710,154@5777L859,174@6650L40,177@6738L910,176@6704L1064:MainActivity.kt#3hk3sw");
                empty6.startReplaceGroup(1406544392);
                ComposerKt.sourceInformation(empty6, str7);
                Composer composer12 = empty6;
                int i174 = 0;
                rememberedValue3 = composer12.rememberedValue();
                int i186 = 0;
                if (!empty6.changedInstance((Context)externalSyntheticLambda6)) {
                    composer5 = empty6;
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        empty6 = 0;
                        obj6 = rememberedValue3;
                        rememberedValue3 = new MainActivityKt$$ExternalSyntheticLambda1(externalSyntheticLambda6, (MutableState)obj9, (MutableState)i26);
                        composer12.updateRememberedValue(rememberedValue3);
                    } else {
                        obj6 = rememberedValue3;
                    }
                } else {
                    composer5 = empty6;
                }
                composer5.endReplaceGroup();
                obj3 = obj9;
                ButtonKt.Button((Function0)rememberedValue3, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), false, 0, 0, 0, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-1$app_debug(), composer5, 805306416, 508);
                Composer composer14 = composer5;
                int i175 = i93;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i58)), composer14, 6);
                composer14.startReplaceGroup(1406560308);
                ComposerKt.sourceInformation(composer14, str7);
                i15 = i122 & 896 == 256 ? 1 : 0;
                Composer composer8 = composer14;
                empty2 = 0;
                rememberedValue2 = composer8.rememberedValue();
                int i182 = 0;
                if (changedInstance |= i15 == 0) {
                    i13 = empty2;
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        empty2 = 0;
                        obj4 = rememberedValue2;
                        rememberedValue2 = new MainActivityKt$$ExternalSyntheticLambda2(externalSyntheticLambda6, requestPermissions2, i26);
                        composer8.updateRememberedValue(rememberedValue2);
                    } else {
                        obj4 = rememberedValue2;
                    }
                } else {
                    i13 = empty2;
                }
                composer14.endReplaceGroup();
                Composer composer22 = composer14;
                ButtonKt.Button((Function0)rememberedValue2, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), false, 0, 0, 0, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-2$app_debug(), composer22, 805306416, 508);
                Composer composer15 = composer22;
                int i177 = i96;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i62)), composer15, 6);
                composer15.startReplaceGroup(1406595361);
                ComposerKt.sourceInformation(composer15, str7);
                i40 = i122 & 896 == 256 ? 1 : 0;
                Composer composer9 = composer15;
                empty4 = 0;
                rememberedValue5 = composer9.rememberedValue();
                int i183 = 0;
                if (changedInstance2 |= i40 == 0) {
                    i8 = empty4;
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        empty4 = 0;
                        obj7 = rememberedValue5;
                        rememberedValue5 = new MainActivityKt$$ExternalSyntheticLambda3(externalSyntheticLambda6, requestPermissions2, i26);
                        composer9.updateRememberedValue(rememberedValue5);
                    } else {
                        obj7 = rememberedValue5;
                    }
                } else {
                    i8 = empty4;
                }
                composer15.endReplaceGroup();
                Composer composer23 = composer15;
                ButtonKt.Button((Function0)rememberedValue5, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), false, 0, 0, 0, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-3$app_debug(), composer23, 805306416, 508);
                Composer composer16 = composer23;
                int i179 = i99;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i66)), composer16, 6);
                composer16.startReplaceGroup(1406629803);
                ComposerKt.sourceInformation(composer16, str7);
                i9 = i122 & 896 == 256 ? 1 : 0;
                Composer composer10 = composer16;
                empty5 = 0;
                rememberedValue4 = composer10.rememberedValue();
                int i184 = 0;
                if (changedInstance3 |= i9 == 0) {
                    i28 = empty5;
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        empty5 = 0;
                        obj2 = rememberedValue4;
                        rememberedValue4 = new MainActivityKt$$ExternalSyntheticLambda4(externalSyntheticLambda6, requestPermissions2, i26);
                        composer10.updateRememberedValue(rememberedValue4);
                    } else {
                        obj2 = rememberedValue4;
                    }
                } else {
                    i28 = empty5;
                }
                composer16.endReplaceGroup();
                Composer composer24 = composer16;
                ButtonKt.Button((Function0)rememberedValue4, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), false, 0, 0, 0, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-4$app_debug(), composer24, 805306416, 508);
                str = composer24;
                companion5 = i102;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i70)), str, 6);
                str.startReplaceGroup(1406659667);
                ComposerKt.sourceInformation(str, str7);
                i38 = i122 & 896 == 256 ? 1 : 0;
                changedInstance4 |= i38;
                Composer composer11 = str;
                int i76 = 0;
                Object rememberedValue7 = composer11.rememberedValue();
                i20 = 0;
                if (empty == 0) {
                    obj69 = empty;
                    if (rememberedValue7 == Composer.Companion.getEmpty()) {
                        companion5 = i50;
                        externalSyntheticLambda5 = new MainActivityKt$$ExternalSyntheticLambda5(externalSyntheticLambda6, requestPermissions2, i26);
                        composer11.updateRememberedValue(externalSyntheticLambda5);
                    } else {
                        externalSyntheticLambda5 = rememberedValue7;
                    }
                } else {
                    obj69 = empty;
                }
                str.endReplaceGroup();
                fillMaxWidth$default = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0);
                i17 = 0;
                composer4 = str;
                ButtonKt.Button((Function0)externalSyntheticLambda5, fillMaxWidth$default, false, 0, 0, i17, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-5$app_debug(), composer4, 805306416, 508);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(empty6);
                i.endNode();
                ComposerKt.sourceInformationMarkerEnd(i);
                ComposerKt.sourceInformationMarkerEnd(i);
                ComposerKt.sourceInformationMarkerEnd(i);
                i.startReplaceGroup(-1763621921);
                ComposerKt.sourceInformation(i, "202@7832L163");
                fillMaxWidth$default2 = (CharSequence)MainActivityKt.Greeting$lambda$6(i26).length() > 0 ? 1 : 0;
                if (fillMaxWidth$default2 != 0) {
                    i29 = 0;
                    TextKt.Text--4IGK_g(MainActivityKt.Greeting$lambda$6(i26), PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), Dp.constructor-impl((float)i74)), 0, i3, 0, (ColumnScope)ColumnScopeInstance.INSTANCE, 0, 0, 0, 0, fillMaxWidth$default, 0, false, 0, i17, 0, 0, 0, 0, 0, 0, i, 48, 0, 131068);
                } else {
                    composer7 = i;
                }
                composer7.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer13);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = requestPermissions2;
                obj8 = obj;
            } else {
                restartGroup.skipToGroupEnd();
                obj8 = requestPermissions2;
                obj5 = str;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            externalSyntheticLambda6 = new MainActivityKt$$ExternalSyntheticLambda6(name, obj8, obj5, $changed, i6);
            endRestartGroup.updateScope(externalSyntheticLambda6);
        }
    }

    private static final Unit Greeting$lambda$1$lambda$0(String[] it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    private static final Unit Greeting$lambda$19$lambda$18$lambda$11$lambda$10(Context $context, Function1 $requestPermissions, MutableState $displayText$delegate) {
        Object query;
        String[] strArr;
        int str;
        int count;
        ContentResolver contentResolver;
        Uri parse;
        String[] strArr2;
        int i;
        int i2;
        String str2;
        String str3 = "android.permission.READ_SMS";
        str = 1;
        count = 0;
        if (ContextCompat.checkSelfPermission($context, str3) == 0) {
            strArr2 = new String[4];
            strArr2[count] = "_id";
            strArr2[str] = "address";
            strArr2[2] = "body";
            strArr2[3] = "date";
            query = $context.getContentResolver().query(Uri.parse("content://sms/inbox"), strArr2, 0, 0, "date DESC");
            if (query != null) {
                count = query.getCount();
            }
            if (query != null) {
                query.close();
            }
            StringBuilder stringBuilder = new StringBuilder();
            MainActivityKt.Greeting$lambda$7($displayText$delegate, stringBuilder.append("SMS Count: ").append(count).toString());
        } else {
            strArr = new String[str];
            strArr[count] = str3;
            $requestPermissions.invoke(strArr);
            MainActivityKt.Greeting$lambda$7($displayText$delegate, "Requesting SMS permission...");
        }
        return Unit.INSTANCE;
    }

    private static final Unit Greeting$lambda$19$lambda$18$lambda$13$lambda$12(Context $context, Function1 $requestPermissions, MutableState $displayText$delegate) {
        Object query;
        String[] strArr;
        int count;
        String str;
        Uri cONTENT_URI;
        int i;
        int i4;
        int i2;
        int i3;
        String str2 = "android.permission.READ_CONTACTS";
        if (ContextCompat.checkSelfPermission($context, str2) == 0) {
            query = $context.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, 0, 0, 0, 0);
            if (query != null) {
                count = query.getCount();
            }
            if (query != null) {
                query.close();
            }
            StringBuilder stringBuilder = new StringBuilder();
            MainActivityKt.Greeting$lambda$7($displayText$delegate, stringBuilder.append("Contacts Count: ").append(count).toString());
        } else {
            strArr = new String[1];
            $requestPermissions.invoke(strArr);
            MainActivityKt.Greeting$lambda$7($displayText$delegate, "Requesting Contacts permission...");
        }
        return Unit.INSTANCE;
    }

    private static final Unit Greeting$lambda$19$lambda$18$lambda$15$lambda$14(Context $context, Function1 $requestPermissions, MutableState $displayText$delegate) {
        Object default;
        String[] strArr;
        int append;
        String str;
        String str2 = "android.permission.SEND_SMS";
        if (ContextCompat.checkSelfPermission($context, str2) == 0) {
            default = SmsManager.getDefault();
            MainActivityKt.Greeting$lambda$7($displayText$delegate, "SMS API called (not actually sending)");
        } else {
            strArr = new String[1];
            $requestPermissions.invoke(strArr);
            MainActivityKt.Greeting$lambda$7($displayText$delegate, "Requesting SMS permission...");
        }
        return Unit.INSTANCE;
    }

    private static final Unit Greeting$lambda$19$lambda$18$lambda$17$lambda$16(Context $context, Function1 $requestPermissions, MutableState $displayText$delegate) {
        Object query;
        String[] strArr;
        int str;
        int count;
        ContentResolver contentResolver;
        Uri parse;
        String[] strArr2;
        int i2;
        int i;
        int i3;
        String str2 = "android.permission.READ_CALENDAR";
        str = 1;
        count = 0;
        if (ContextCompat.checkSelfPermission($context, str2) == 0) {
            strArr2 = new String[3];
            strArr2[count] = "_id";
            strArr2[str] = "title";
            strArr2[2] = "dtstart";
            query = $context.getContentResolver().query(Uri.parse("content://com.android.calendar/events"), strArr2, 0, 0, 0);
            if (query != null) {
                count = query.getCount();
            }
            if (query != null) {
                query.close();
            }
            StringBuilder stringBuilder = new StringBuilder();
            MainActivityKt.Greeting$lambda$7($displayText$delegate, stringBuilder.append("Calendar Events Count: ").append(count).toString());
        } else {
            strArr = new String[str];
            strArr[count] = str2;
            $requestPermissions.invoke(strArr);
            MainActivityKt.Greeting$lambda$7($displayText$delegate, "Requesting Calendar permission...");
        }
        return Unit.INSTANCE;
    }

    private static final Unit Greeting$lambda$19$lambda$18$lambda$9$lambda$8(Context $context, MutableState $androidId$delegate, MutableState $displayText$delegate) {
        MainActivityKt.Greeting$lambda$4($androidId$delegate, Settings.Secure.getString($context.getContentResolver(), "android_id"));
        StringBuilder stringBuilder = new StringBuilder();
        MainActivityKt.Greeting$lambda$7($displayText$delegate, stringBuilder.append("Android ID: ").append(MainActivityKt.Greeting$lambda$3($androidId$delegate)).toString());
        return Unit.INSTANCE;
    }

    private static final Unit Greeting$lambda$20(String string, Modifier modifier2, Function1 function13, int i4, int i5, Composer composer6, int i7) {
        MainActivityKt.Greeting(string, modifier2, function13, composer6, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    private static final String Greeting$lambda$3(MutableState<String> $androidId$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (String)(State)$androidId$delegate.getValue();
    }

    private static final void Greeting$lambda$4(MutableState<String> $androidId$delegate, String <set-?>) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $androidId$delegate.setValue(<set-?>);
    }

    private static final String Greeting$lambda$6(MutableState<String> $displayText$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (String)(State)$displayText$delegate.getValue();
    }

    private static final void Greeting$lambda$7(MutableState<String> $displayText$delegate, String <set-?>) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $displayText$delegate.setValue(<set-?>);
    }

    public static final void GreetingPreview(Composer $composer, int $changed) {
        int externalSyntheticLambda7;
        int str;
        int i;
        kotlin.jvm.functions.Function2 lambda-6$app_debug;
        int i3;
        int i2;
        boolean obj7;
        externalSyntheticLambda7 = -893745181;
        final Composer restartGroup = $composer.startRestartGroup(externalSyntheticLambda7);
        ComposerKt.sourceInformation(restartGroup, "C(GreetingPreview)215@8087L47:MainActivity.kt#3hk3sw");
        if ($changed == 0) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(externalSyntheticLambda7, $changed, -1, "com.prototype.badboy.GreetingPreview (MainActivity.kt:214)");
                }
                ThemeKt.BadboyTheme(false, false, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-6$app_debug(), restartGroup, 384, 3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
            }
        } else {
        }
        obj7 = restartGroup.endRestartGroup();
        if (obj7 != null) {
            externalSyntheticLambda7 = new MainActivityKt$$ExternalSyntheticLambda7($changed);
            obj7.updateScope(externalSyntheticLambda7);
        }
    }

    private static final Unit GreetingPreview$lambda$21(int i, Composer composer2, int i3) {
        MainActivityKt.GreetingPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }
}
