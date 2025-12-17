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
        Object this_4;
        boolean traceInProgress2;
        Object it32;
        Object it36;
        Object it40;
        int empty2;
        Object $i$a$CacheMainActivityKt$Greeting$2$1$54633827;
        int fillMaxWidth$default;
        int $dirty2;
        Object obj2;
        int $dirty;
        Object modifier3;
        Integer currentCompositionLocalMap;
        Object it28;
        int i17;
        int i34;
        int i26;
        int i22;
        int $this$dp47;
        Object obj4;
        int i27;
        Object i30;
        Object invalid1;
        int i8;
        Composer $this$Greeting_u24lambda_u241918;
        boolean traceInProgress;
        Object mutableStateOf$default;
        int i23;
        Integer currentCompositionLocalMap2;
        int $i$f$cache32104;
        int $i$f$cache361302;
        Object $i$f$cache401562;
        Object str;
        kotlin.jvm.functions.Function0 factory13;
        Composer composer3;
        Object $composer272;
        Object columnMeasurePolicy;
        int i;
        int i9;
        kotlin.jvm.functions.Function0 factory22;
        int rememberedValue;
        int i31;
        Composer composer2;
        Object columnMeasurePolicy2;
        int currentCompositeKeyHash;
        Object top;
        Object $i$a$CacheMainActivityKt$Greeting$androidId$272290;
        Object empty;
        int i18;
        int i38;
        int i32;
        Object obj5;
        int i36;
        int currentCompositeKeyHash2;
        androidx.compose.ui.Alignment.Horizontal horizontal;
        int i29;
        int i25;
        int i12;
        kotlin.jvm.functions.Function0 function0;
        int i15;
        Modifier modifier4;
        int i20;
        Modifier modifier5;
        int i35;
        int i13;
        int i19;
        Composer composer4;
        androidx.compose.runtime.CompositionLocalMap localMap12;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        ColumnScopeInstance columnScopeInstance;
        int i16;
        int padding-3ABfNKs;
        int i37;
        int i33;
        kotlin.jvm.functions.Function0 function02;
        ColumnScopeInstance columnScopeInstance2;
        Modifier modifier2;
        androidx.compose.runtime.CompositionLocalMap localMap21;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        com.prototype.badboy.MainActivityKt$$ExternalSyntheticLambda5 activity;
        int companion2;
        Modifier fillMaxWidth$default2;
        int i28;
        Object obj3;
        Object obj6;
        Object obj7;
        Composer.Companion companion;
        int companion4;
        int companion3;
        int companion5;
        Object obj8;
        int $i$f$cache321042;
        int $i$f$cache36130;
        int $i$f$cache40156;
        int i24;
        int i2;
        int i14;
        int i21;
        int i3;
        kotlin.jvm.functions.Function3 lambda-5$app_debug;
        Composer composer5;
        Composer $composer27;
        int i10;
        Composer $composer18;
        Composer composer;
        int i4;
        int i5;
        int i7;
        int i11;
        Object obj;
        int obj67;
        int obj69;
        i30 = $changed;
        Intrinsics.checkNotNullParameter(name, "name");
        this_4 = 654543564;
        final Composer restartGroup = $composer.startRestartGroup(this_4);
        ComposerKt.sourceInformation(restartGroup, "C(Greeting)P(1)70@2603L2,72@2641L7,73@2670L31,74@2725L31,76@2762L5249:MainActivity.kt#3hk3sw");
        $dirty2 = $changed;
        int i69 = i6 & 2;
        if (i69 != 0) {
            $dirty2 |= 48;
            invalid1 = modifier;
        } else {
            if (i30 & 48 == 0) {
                i8 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i8;
            } else {
                invalid1 = modifier;
            }
        }
        $this$Greeting_u24lambda_u241918 = i6 & 4;
        if ($this$Greeting_u24lambda_u241918 != 0) {
            $dirty2 |= 384;
            str = requestPermissions;
        } else {
            if (i30 & 384 == 0) {
                i = restartGroup.changedInstance(requestPermissions) ? 256 : 128;
                $dirty2 |= i;
            } else {
                str = requestPermissions;
            }
        }
        int i111 = $dirty2;
        if (i111 & 145 == 144) {
            if (!restartGroup.getSkipping()) {
                if (i69 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = invalid1;
                }
                String str6 = "CC(remember):MainActivity.kt#9igjgp";
                if ($this$Greeting_u24lambda_u241918 != 0) {
                    restartGroup.startReplaceGroup(-1388754071);
                    ComposerKt.sourceInformation(restartGroup, str6);
                    int i72 = 0;
                    $this$Greeting_u24lambda_u241918 = restartGroup;
                    i9 = 0;
                    rememberedValue = $this$Greeting_u24lambda_u241918.rememberedValue();
                    i31 = 0;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        currentCompositeKeyHash = 0;
                        top = new MainActivityKt$$ExternalSyntheticLambda0();
                        $this$Greeting_u24lambda_u241918.updateRememberedValue(top);
                    } else {
                        top = rememberedValue;
                    }
                    invalid1 = top;
                    restartGroup.endReplaceGroup();
                } else {
                    invalid1 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(this_4, i111, -1, "com.prototype.badboy.Greeting (MainActivity.kt:71)");
                }
                int i74 = 0;
                int i99 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                this_4 = consume;
                restartGroup.startReplaceGroup(-1388751898);
                ComposerKt.sourceInformation(restartGroup, str6);
                int i76 = 0;
                int i100 = i76;
                Composer composer15 = restartGroup;
                int i113 = 0;
                Object rememberedValue5 = composer15.rememberedValue();
                int i133 = 0;
                String str7 = "";
                obj67 = i76;
                int i77 = 2;
                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                    int i138 = 0;
                    traceInProgress2 = 0;
                    composer15.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(str7, traceInProgress2, i77, traceInProgress2));
                } else {
                    $i$a$CacheMainActivityKt$Greeting$androidId$272290 = rememberedValue5;
                }
                Object obj9 = $i$a$CacheMainActivityKt$Greeting$androidId$272290;
                restartGroup.endReplaceGroup();
                restartGroup.startReplaceGroup(-1388750138);
                ComposerKt.sourceInformation(restartGroup, str6);
                int i102 = obj67;
                Composer composer16 = restartGroup;
                int i114 = 0;
                Object rememberedValue6 = composer16.rememberedValue();
                int i134 = 0;
                if (rememberedValue6 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    i30 = 0;
                    composer16.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(str7, i30, i77, i30));
                } else {
                    mutableStateOf$default = rememberedValue6;
                }
                i30 = mutableStateOf$default;
                restartGroup.endReplaceGroup();
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier3, 0, 1, 0);
                int i104 = obj67;
                String str9 = "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -483455358, str9);
                androidx.compose.ui.Alignment.Horizontal start = Alignment.Companion.getStart();
                columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), start, restartGroup, i140 | i143);
                i38 = 0;
                String modifier6 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, modifier6);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, obj67);
                currentCompositionLocalMap2 = restartGroup.getCurrentCompositionLocalMap();
                horizontal = start;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, fillMaxSize$default);
                kotlin.jvm.functions.Function0 function03 = constructor2;
                i29 = 0;
                modifier4 = fillMaxSize$default;
                String modifier11 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, modifier11);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function03);
                } else {
                    factory13 = function03;
                    restartGroup.useNode();
                }
                function0 = factory13;
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i147 = 0;
                i13 = i115;
                Updater.set-impl(constructor-impl, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i148 = 0;
                Composer composer17 = constructor-impl;
                int i149 = 0;
                if (!composer17.getInserting()) {
                    localMap12 = currentCompositionLocalMap2;
                    measurePolicy = columnMeasurePolicy2;
                    if (!Intrinsics.areEqual(composer17.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer17.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer17;
                    }
                } else {
                    localMap12 = currentCompositionLocalMap2;
                    measurePolicy = columnMeasurePolicy2;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer11 = restartGroup;
                modifier5 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer11, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                $this$Greeting_u24lambda_u241918 = composer11;
                i35 = 0;
                i19 = i83;
                ComposerKt.sourceInformationMarkerStart($this$Greeting_u24lambda_u241918, 1157528740, "C82@2928L21,79@2828L4950:MainActivity.kt#3hk3sw");
                int i84 = 0;
                int i150 = 0;
                i7 = i116;
                i16 = 432;
                padding-3ABfNKs = 0;
                i11 = i129;
                ComposerKt.sourceInformationMarkerStart($this$Greeting_u24lambda_u241918, -483455358, str9);
                columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getCenterHorizontally(), $this$Greeting_u24lambda_u241918, i131 |= i136);
                i31 = 0;
                ComposerKt.sourceInformationMarkerStart($this$Greeting_u24lambda_u241918, -1323940314, modifier6);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($this$Greeting_u24lambda_u241918, 0);
                currentCompositionLocalMap = $this$Greeting_u24lambda_u241918.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier($this$Greeting_u24lambda_u241918, PaddingKt.padding-3ABfNKs(ScrollKt.verticalScroll$default(ColumnScope.weight$default((ColumnScope)ColumnScopeInstance.INSTANCE, (Modifier)Modifier.Companion, 1065353216, false, 2, 0), ScrollKt.rememberScrollState(i84, $this$Greeting_u24lambda_u241918, i84, 1), false, 0, false, 14, 0), Dp.constructor-impl((float)i109)));
                kotlin.jvm.functions.Function0 function04 = constructor;
                i32 = 0;
                i33 = i120;
                ComposerKt.sourceInformationMarkerStart($this$Greeting_u24lambda_u241918, -692256719, modifier11);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $this$Greeting_u24lambda_u241918.startReusableNode();
                if ($this$Greeting_u24lambda_u241918.getInserting()) {
                    $this$Greeting_u24lambda_u241918.createNode(function04);
                } else {
                    factory22 = function04;
                    $this$Greeting_u24lambda_u241918.useNode();
                }
                Composer constructor-impl2 = Updater.constructor-impl($this$Greeting_u24lambda_u241918);
                int i146 = 0;
                function02 = factory22;
                Updater.set-impl(constructor-impl2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i153 = 0;
                Composer composer18 = constructor-impl2;
                int i156 = 0;
                if (!composer18.getInserting()) {
                    localMap21 = currentCompositionLocalMap;
                    measurePolicy2 = columnMeasurePolicy;
                    if (!Intrinsics.areEqual(composer18.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer18.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer18;
                    }
                } else {
                    localMap21 = currentCompositionLocalMap;
                    measurePolicy2 = columnMeasurePolicy;
                }
                Updater.set-impl(constructor-impl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                $composer272 = $this$Greeting_u24lambda_u241918;
                i9 = 0;
                i20 = i50;
                ComposerKt.sourceInformationMarkerStart($composer272, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                i123 |= 6;
                Composer composer19 = $composer272;
                i37 = 0;
                modifier2 = materializeModifier2;
                ComposerKt.sourceInformationMarkerStart($composer272, 653305464, "C88@3156L259,87@3122L410,100@3546L40,103@3634L879,102@3600L1028,126@4642L40,129@4730L860,128@4696L1013,152@5723L40,155@5811L710,154@5777L859,174@6650L40,177@6738L910,176@6704L1064:MainActivity.kt#3hk3sw");
                $composer272.startReplaceGroup(1406544392);
                ComposerKt.sourceInformation($composer272, str6);
                Composer composer10 = $composer272;
                int i160 = 0;
                it28 = composer10.rememberedValue();
                int i172 = 0;
                if (!$composer272.changedInstance((Context)this_4)) {
                    $composer27 = $composer272;
                    if (it28 == Composer.Companion.getEmpty()) {
                        $composer272 = 0;
                        obj8 = it28;
                        it28 = new MainActivityKt$$ExternalSyntheticLambda1(this_4, (MutableState)obj9, (MutableState)i30);
                        composer10.updateRememberedValue(it28);
                    } else {
                        obj8 = it28;
                    }
                } else {
                    $composer27 = $composer272;
                }
                $composer27.endReplaceGroup();
                obj = obj9;
                ButtonKt.Button((Function0)it28, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), false, 0, 0, 0, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-1$app_debug(), $composer27, 805306416, 508);
                Composer composer12 = $composer27;
                int i161 = i86;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i52)), composer12, 6);
                composer12.startReplaceGroup(1406560308);
                ComposerKt.sourceInformation(composer12, str6);
                i17 = i111 & 896 == 256 ? 1 : 0;
                Composer composer6 = composer12;
                $i$f$cache32104 = 0;
                it32 = composer6.rememberedValue();
                int i168 = 0;
                if (changedInstance |= i17 == 0) {
                    $i$f$cache321042 = $i$f$cache32104;
                    if (it32 == Composer.Companion.getEmpty()) {
                        $i$f$cache32104 = 0;
                        obj3 = it32;
                        it32 = new MainActivityKt$$ExternalSyntheticLambda2(this_4, invalid1, i30);
                        composer6.updateRememberedValue(it32);
                    } else {
                        obj3 = it32;
                    }
                } else {
                    $i$f$cache321042 = $i$f$cache32104;
                }
                composer12.endReplaceGroup();
                Composer composer20 = composer12;
                ButtonKt.Button((Function0)it32, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), false, 0, 0, 0, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-2$app_debug(), composer20, 805306416, 508);
                Composer composer13 = composer20;
                int i163 = i89;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i56)), composer13, 6);
                composer13.startReplaceGroup(1406595361);
                ComposerKt.sourceInformation(composer13, str6);
                i34 = i111 & 896 == 256 ? 1 : 0;
                Composer composer7 = composer13;
                $i$f$cache361302 = 0;
                it36 = composer7.rememberedValue();
                int i169 = 0;
                if (changedInstance2 |= i34 == 0) {
                    $i$f$cache36130 = $i$f$cache361302;
                    if (it36 == Composer.Companion.getEmpty()) {
                        $i$f$cache361302 = 0;
                        obj6 = it36;
                        it36 = new MainActivityKt$$ExternalSyntheticLambda3(this_4, invalid1, i30);
                        composer7.updateRememberedValue(it36);
                    } else {
                        obj6 = it36;
                    }
                } else {
                    $i$f$cache36130 = $i$f$cache361302;
                }
                composer13.endReplaceGroup();
                Composer composer21 = composer13;
                ButtonKt.Button((Function0)it36, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), false, 0, 0, 0, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-3$app_debug(), composer21, 805306416, 508);
                Composer composer14 = composer21;
                int i165 = i92;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i60)), composer14, 6);
                composer14.startReplaceGroup(1406629803);
                ComposerKt.sourceInformation(composer14, str6);
                i26 = i111 & 896 == 256 ? 1 : 0;
                Composer composer8 = composer14;
                $i$f$cache401562 = 0;
                it40 = composer8.rememberedValue();
                int i170 = 0;
                if (changedInstance3 |= i26 == 0) {
                    $i$f$cache40156 = $i$f$cache401562;
                    if (it40 == Composer.Companion.getEmpty()) {
                        $i$f$cache401562 = 0;
                        obj7 = it40;
                        it40 = new MainActivityKt$$ExternalSyntheticLambda4(this_4, invalid1, i30);
                        composer8.updateRememberedValue(it40);
                    } else {
                        obj7 = it40;
                    }
                } else {
                    $i$f$cache40156 = $i$f$cache401562;
                }
                composer14.endReplaceGroup();
                Composer composer22 = composer14;
                ButtonKt.Button((Function0)it40, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), false, 0, 0, 0, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-4$app_debug(), composer22, 805306416, 508);
                str = composer22;
                companion2 = i95;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i64)), str, 6);
                str.startReplaceGroup(1406659667);
                ComposerKt.sourceInformation(str, str6);
                i22 = i111 & 896 == 256 ? 1 : 0;
                changedInstance4 |= i22;
                Composer composer9 = str;
                int i70 = 0;
                Object rememberedValue3 = composer9.rememberedValue();
                i15 = 0;
                if (empty2 == 0) {
                    obj69 = empty2;
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        companion2 = invalid44;
                        $i$a$CacheMainActivityKt$Greeting$2$1$54633827 = new MainActivityKt$$ExternalSyntheticLambda5(this_4, invalid1, i30);
                        composer9.updateRememberedValue($i$a$CacheMainActivityKt$Greeting$2$1$54633827);
                    } else {
                        $i$a$CacheMainActivityKt$Greeting$2$1$54633827 = rememberedValue3;
                    }
                } else {
                    obj69 = empty2;
                }
                str.endReplaceGroup();
                fillMaxWidth$default2 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0);
                i2 = 0;
                composer5 = str;
                ButtonKt.Button((Function0)$i$a$CacheMainActivityKt$Greeting$2$1$54633827, fillMaxWidth$default2, false, 0, 0, i2, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-5$app_debug(), composer5, 805306416, 508);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd($composer272);
                $this$Greeting_u24lambda_u241918.endNode();
                ComposerKt.sourceInformationMarkerEnd($this$Greeting_u24lambda_u241918);
                ComposerKt.sourceInformationMarkerEnd($this$Greeting_u24lambda_u241918);
                ComposerKt.sourceInformationMarkerEnd($this$Greeting_u24lambda_u241918);
                $this$Greeting_u24lambda_u241918.startReplaceGroup(-1763621921);
                ComposerKt.sourceInformation($this$Greeting_u24lambda_u241918, "202@7832L163");
                fillMaxWidth$default = (CharSequence)MainActivityKt.Greeting$lambda$6(i30).length() > 0 ? 1 : 0;
                if (fillMaxWidth$default != 0) {
                    i27 = 0;
                    TextKt.Text--4IGK_g(MainActivityKt.Greeting$lambda$6(i30), PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), Dp.constructor-impl((float)i68)), 0, i33, 0, (ColumnScope)ColumnScopeInstance.INSTANCE, 0, 0, 0, 0, fillMaxWidth$default2, 0, false, 0, i2, 0, 0, 0, 0, 0, 0);
                } else {
                    $composer18 = $this$Greeting_u24lambda_u241918;
                }
                $composer18.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer18);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = invalid1;
                obj2 = obj5;
            } else {
                restartGroup.skipToGroupEnd();
                obj2 = invalid1;
                obj4 = str;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            this_4 = new MainActivityKt$$ExternalSyntheticLambda6(name, obj2, obj4, $changed, i6);
            endRestartGroup.updateScope(this_4);
        }
    }

    private static final Unit Greeting$lambda$1$lambda$0(String[] it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    private static final Unit Greeting$lambda$19$lambda$18$lambda$11$lambda$10(Context $context, Function1 $requestPermissions, MutableState $displayText$delegate) {
        Object query;
        String[] strArr2;
        int str2;
        int count;
        ContentResolver contentResolver;
        Uri parse;
        String[] strArr;
        int i2;
        int i;
        String str;
        String str3 = "android.permission.READ_SMS";
        str2 = 1;
        count = 0;
        if (ContextCompat.checkSelfPermission($context, str3) == 0) {
            strArr = new String[4];
            strArr[count] = "_id";
            strArr[str2] = "address";
            strArr[2] = "body";
            strArr[3] = "date";
            query = $context.getContentResolver().query(Uri.parse("content://sms/inbox"), strArr, 0, 0, "date DESC");
            if (query != null) {
                count = query.getCount();
            }
            if (query != null) {
                query.close();
            }
            StringBuilder stringBuilder = new StringBuilder();
            MainActivityKt.Greeting$lambda$7($displayText$delegate, stringBuilder.append("SMS Count: ").append(count).toString());
        } else {
            strArr2 = new String[str2];
            strArr2[count] = str3;
            $requestPermissions.invoke(strArr2);
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
        int i4;
        int i2;
        int i;
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
        String[] strArr2;
        int str;
        int count;
        ContentResolver contentResolver;
        Uri parse;
        String[] strArr;
        int i;
        int i2;
        int i3;
        String str2 = "android.permission.READ_CALENDAR";
        str = 1;
        count = 0;
        if (ContextCompat.checkSelfPermission($context, str2) == 0) {
            strArr = new String[3];
            strArr[count] = "_id";
            strArr[str] = "title";
            strArr[2] = "dtstart";
            query = $context.getContentResolver().query(Uri.parse("content://com.android.calendar/events"), strArr, 0, 0, 0);
            if (query != null) {
                count = query.getCount();
            }
            if (query != null) {
                query.close();
            }
            StringBuilder stringBuilder = new StringBuilder();
            MainActivityKt.Greeting$lambda$7($displayText$delegate, stringBuilder.append("Calendar Events Count: ").append(count).toString());
        } else {
            strArr2 = new String[str];
            strArr2[count] = str2;
            $requestPermissions.invoke(strArr2);
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
        int i2;
        kotlin.jvm.functions.Function2 lambda-6$app_debug;
        int i;
        int i3;
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
