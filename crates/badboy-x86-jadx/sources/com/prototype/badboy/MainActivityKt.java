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

/* compiled from: MainActivity.kt */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0006\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u001a\u0008\u0002\u0010\u0006\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u0008\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\t\u001a\r\u0010\n\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\u000c²\u0006\n\u0010\r\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u000e\u001a\u00020\u0003X\u008a\u008e\u0002", d2 = {"Greeting", "", "name", "", "modifier", "Landroidx/compose/ui/Modifier;", "requestPermissions", "Lkotlin/Function1;", "", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "GreetingPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "androidId", "displayText"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MainActivityKt {
    private static final Unit Greeting$lambda$1$lambda$0(String[] it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public static final void Greeting(String name, Modifier modifier, Function1<? super String[], Unit> requestPermissions, Composer $composer, int $changed, int i) {
        Object this_4;
        boolean name2;
        com.prototype.badboy.MainActivityKt$$ExternalSyntheticLambda2 invalid32;
        com.prototype.badboy.MainActivityKt$$ExternalSyntheticLambda3 invalid36;
        Object invalid40;
        com.prototype.badboy.MainActivityKt$$ExternalSyntheticLambda5 CacheMainActivityKt;
        int fillMaxWidth$default = 0;
        int $dirty;
        Modifier modifier9;
        Modifier modifier4;
        Object invalid28;
        int i116 = 0;
        int i26 = 0;
        int i51 = 0;
        Function1 function1;
        MutableState $changed2;
        Object invalid1;
        Object mutableStateOf$default;
        int i118 = 16;
        float f = 0;
        Object requestPermissions2;
        kotlin.jvm.functions.Function0 factory132;
        int i89 = 256;
        kotlin.jvm.functions.Function0 factory22;
        int empty2 = 0;
        com.prototype.badboy.MainActivityKt$$ExternalSyntheticLambda0 externalSyntheticLambda0;
        Object CacheMainActivityKt2;
        androidx.compose.runtime.CompositionLocalMap localMap12;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i7 = 432;
        int padding3ABfNKs = 0;
        int i21 = 0;
        kotlin.jvm.functions.Function0 function0 = null;
        Modifier modifier8 = null;
        androidx.compose.runtime.CompositionLocalMap localMap21;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        Object obj7 = null;
        boolean z = false;
        androidx.compose.ui.graphics.Shape shape = null;
        int $i$f$cache40156;
        int $i$f$cache361302;
        int $i$f$cache32104;
        androidx.compose.material3.ButtonColors buttonColors = null;
        androidx.compose.foundation.BorderStroke borderStroke = null;
        androidx.compose.foundation.layout.PaddingValues paddingValues = null;
        androidx.compose.foundation.interaction.MutableInteractionSource mutableInteractionSource = null;
        kotlin.jvm.functions.Function3 lambda5$app_debug = null;
        Composer $composer272;
        Composer composer12 = null;
        int i56 = 805306416;
        Composer $composer18;
        Composer composer2;
        int i46 = 0;
        int i86 = 131068;
        int invalid442;
        int $changed2 = $changed;
        Intrinsics.checkNotNullParameter(name, "name");
        int this_42 = 654543564;
        final Composer restartGroup = $composer.startRestartGroup(this_42);
        ComposerKt.sourceInformation(restartGroup, "C(Greeting)P(1)70@2603L2,72@2641L7,73@2670L31,74@2725L31,76@2762L5249:MainActivity.kt#3hk3sw");
        $dirty = $changed;
        int i103 = i & 2;
        if (i103 != 0) {
            $dirty = $dirty | 48;
            invalid1 = modifier;
        } else {
            if (($changed2 & 48) == 0) {
                int r7 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty = $dirty | (restartGroup.changed(modifier) ? 32 : 16);
            } else {
                invalid1 = modifier;
            }
        }
        int $this$Greeting_u24lambda_u241918 = i & 4;
        if ($this$Greeting_u24lambda_u241918 != 0) {
            $dirty = $dirty | 384;
            requestPermissions2 = requestPermissions;
        } else {
            if (($changed2 & 384) == 0) {
                int r10 = restartGroup.changedInstance(requestPermissions) ? 256 : 128;
                $dirty = $dirty | (restartGroup.changedInstance(requestPermissions) ? 256 : 128);
            } else {
                requestPermissions2 = requestPermissions;
            }
        }
        int i178 = $dirty;
        int $dirty2 = i178 & 145;
        int i22 = 144;
        if ((i178 & 145) != 144 || !restartGroup.getSkipping()) {
            androidx.compose.ui.Modifier.Companion modifier42 = i103 != 0 ? (Modifier)modifier4 : invalid1;
            String str3 = "CC(remember):MainActivity.kt#9igjgp";
            if ($this$Greeting_u24lambda_u241918 != 0) {
                restartGroup.startReplaceGroup(-1388754071);
                ComposerKt.sourceInformation(restartGroup, str3);
                $this$Greeting_u24lambda_u241918 = restartGroup;
                i22 = 0;
                Object rememberedValue4 = $this$Greeting_u24lambda_u241918.rememberedValue();
                int i78 = 0;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    empty2 = 0;
                    $this$Greeting_u24lambda_u241918.updateRememberedValue(new MainActivityKt$$ExternalSyntheticLambda0());
                } else {
                    externalSyntheticLambda0 = rememberedValue4;
                }
                invalid1 = externalSyntheticLambda0;
                restartGroup.endReplaceGroup();
            } else {
                invalid1 = requestPermissions2;
            }
            if (ComposerKt.isTraceInProgress()) {
                requestPermissions2 = "com.prototype.badboy.Greeting (MainActivity.kt:71)";
                ComposerKt.traceEventStart(this_42, i178, -1, requestPermissions2);
            }
            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            ComposerKt.sourceInformationMarkerEnd(restartGroup);
            this_4 = restartGroup.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalContext());
            restartGroup.startReplaceGroup(-1388751898);
            ComposerKt.sourceInformation(restartGroup, str3);
            Composer composer21 = restartGroup;
            Object rememberedValue2 = composer21.rememberedValue();
            String str5 = "";
            int i131 = 0;
            int i35 = 2;
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                androidx.compose.runtime.SnapshotMutationPolicy name22 = null;
                composer21.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(str5, name22, i35, name22));
            } else {
                CacheMainActivityKt2 = rememberedValue2;
            }
            MutableState mutableState2 = CacheMainActivityKt2;
            restartGroup.endReplaceGroup();
            restartGroup.startReplaceGroup(-1388750138);
            ComposerKt.sourceInformation(restartGroup, str3);
            Composer composer7 = restartGroup;
            Object rememberedValue3 = composer7.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                int empty = 0;
                androidx.compose.runtime.SnapshotMutationPolicy $changed22 = null;
                composer7.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(str5, $changed22, i35, $changed22));
            } else {
                mutableStateOf$default = rememberedValue3;
            }
            $changed2 = mutableStateOf$default;
            restartGroup.endReplaceGroup();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null);
            int modifier2 = i131;
            String str7 = "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(restartGroup, -483455358, str7);
            androidx.compose.ui.Alignment.Horizontal start = Alignment.Companion.getStart();
            androidx.compose.ui.layout.MeasurePolicy measurePolicy11 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), start, restartGroup, (modifier2 >> 3) & 14 | (modifier2 >> 3) & 112);
            int i4 = (modifier2 << 3) & 112;
            int i169 = 0;
            String modifier6 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, modifier6);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, i131);
            androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap2 = restartGroup.getCurrentCompositionLocalMap();
            androidx.compose.ui.Alignment.Horizontal horizontal = start;
            Modifier horizontalAlignment11 = ComposedModifierKt.materializeModifier(restartGroup, fillMaxSize$default);
            int i12 = (i4 << 6) & 896 | 6;
            kotlin.jvm.functions.Function0 function02 = ComposeUiNode.Companion.getConstructor();
            int i111 = 0;
            Modifier modifier10 = fillMaxSize$default;
            String modifier11 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, modifier11);
            if (!(restartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            restartGroup.startReusableNode();
            if (restartGroup.getInserting()) {
                restartGroup.createNode(function02);
            } else {
                factory132 = function02;
                restartGroup.useNode();
            }
            kotlin.jvm.functions.Function0 function03 = factory132;
            Composer factory13 = Updater.constructor_impl(restartGroup);
            int i60 = 0;
            Updater.set_impl(factory13, measurePolicy11, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set_impl(factory13, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Composer composer = factory13;
            if (composer.getInserting()) {
                localMap12 = currentCompositionLocalMap2;
                measurePolicy = measurePolicy11;
            } else {
                localMap12 = currentCompositionLocalMap2;
                measurePolicy = measurePolicy11;
                if (!Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    factory13.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                } else {
                    Composer composer13 = composer;
                }
            }
            Updater.set_impl(factory13, horizontalAlignment11, ComposeUiNode.Companion.getSetModifier());
            Composer composer5 = restartGroup;
            Modifier modifier5 = horizontalAlignment11;
            ComposerKt.sourceInformationMarkerStart(composer5, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            $this$Greeting_u24lambda_u241918 = composer5;
            int i75 = 0;
            int i39 = (modifier2 << 3 & 112 << 6 & 896 | 6) >> 6 & 14;
            ComposerKt.sourceInformationMarkerStart($this$Greeting_u24lambda_u241918, 1157528740, "C82@2928L21,79@2828L4950:MainActivity.kt#3hk3sw");
            int i127 = 0;
            int i9 = 0;
            i7 = 432;
            padding3ABfNKs = 0;
            int i100 = (modifier2 >> 6) & 112 | 6;
            ComposerKt.sourceInformationMarkerStart($this$Greeting_u24lambda_u241918, -483455358, str7);
            androidx.compose.ui.layout.MeasurePolicy measurePolicy20 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getCenterHorizontally(), $this$Greeting_u24lambda_u241918, (i7 >> 3) & 14 | (i7 >> 3) & 112);
            int i23 = 0;
            ComposerKt.sourceInformationMarkerStart($this$Greeting_u24lambda_u241918, -1323940314, modifier6);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($this$Greeting_u24lambda_u241918, 0);
            androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap22 = $this$Greeting_u24lambda_u241918.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier($this$Greeting_u24lambda_u241918, PaddingKt.padding_3ABfNKs(ScrollKt.verticalScroll$default(ColumnScope.weight$default((ColumnScope)ColumnScopeInstance.INSTANCE, (Modifier)Modifier.Companion, 1f, false, 2, null), ScrollKt.rememberScrollState(i127, $this$Greeting_u24lambda_u241918, i127, 1), false, null, false, 14, null), Dp.constructor_impl((float)16)));
            kotlin.jvm.functions.Function0 function04 = ComposeUiNode.Companion.getConstructor();
            int i71 = 0;
            int i2 = (i7 << 3) & 112 << 6 & 896 | 6;
            ComposerKt.sourceInformationMarkerStart($this$Greeting_u24lambda_u241918, -692256719, modifier11);
            if (!($this$Greeting_u24lambda_u241918.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $this$Greeting_u24lambda_u241918.startReusableNode();
            if ($this$Greeting_u24lambda_u241918.getInserting()) {
                $this$Greeting_u24lambda_u241918.createNode(function04);
            } else {
                factory22 = function04;
                $this$Greeting_u24lambda_u241918.useNode();
            }
            Composer constructorImpl = Updater.constructor_impl($this$Greeting_u24lambda_u241918);
            function0 = factory22;
            Updater.set_impl(constructorImpl, measurePolicy20, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set_impl(constructorImpl, currentCompositionLocalMap22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Composer composer10 = constructorImpl;
            if (composer10.getInserting()) {
                localMap21 = currentCompositionLocalMap22;
                measurePolicy2 = measurePolicy20;
            } else {
                localMap21 = currentCompositionLocalMap22;
                measurePolicy2 = measurePolicy20;
                if (!Intrinsics.areEqual(composer10.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composer10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    constructorImpl.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                } else {
                    Composer composer14 = composer10;
                }
            }
            Updater.set_impl(constructorImpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            Composer $composer27 = $this$Greeting_u24lambda_u241918;
            i22 = 0;
            int i31 = (i2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer27, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            int i172 = (i7 >> 6) & 112 | 6;
            i21 = 0;
            modifier8 = materializeModifier;
            ComposerKt.sourceInformationMarkerStart($composer27, 653305464, "C88@3156L259,87@3122L410,100@3546L40,103@3634L879,102@3600L1028,126@4642L40,129@4730L860,128@4696L1013,152@5723L40,155@5811L710,154@5777L859,174@6650L40,177@6738L910,176@6704L1064:MainActivity.kt#3hk3sw");
            $composer27.startReplaceGroup(1406544392);
            ComposerKt.sourceInformation($composer27, str3);
            Composer composer17 = $composer27;
            invalid28 = composer17.rememberedValue();
            if ($composer27.changedInstance(this_4)) {
                $composer272 = $composer27;
            } else {
                $composer272 = $composer27;
                if (invalid28 == Composer.Companion.getEmpty()) {
                    int $composer273 = 0;
                    Object obj3 = invalid28;
                    composer17.updateRememberedValue(new MainActivityKt$$ExternalSyntheticLambda1(this_4, mutableState2, $changed2));
                } else {
                    obj3 = invalid28;
                }
            }
            $composer272.endReplaceGroup();
            MutableState mutableState = mutableState2;
            boolean companion27 = false;
            ButtonKt.Button((Function0)invalid28, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0f, 1, null), companion27, null, null, null, null, null, null, ComposableSingletons.MainActivityKt.INSTANCE.getLambda_1$app_debug(), $composer272, 805306416, 508);
            Composer composer11 = $composer272;
            SpacerKt.Spacer(SizeKt.height_3ABfNKs((Modifier)Modifier.Companion, Dp.constructor_impl((float)8)), composer11, 6);
            composer11.startReplaceGroup(1406560308);
            ComposerKt.sourceInformation(composer11, str3);
            int r2 = (i178 & 896) == 256 ? 1 : 0;
            r2 = composer11;
            int $i$f$cache321042 = 0;
            invalid32 = r2.rememberedValue();
            if ((restartGroup.changedInstance(this_4) | ((i178 & 896) == 256 ? 1 : 0)) != 0) {
                $i$f$cache32104 = $i$f$cache321042;
            } else {
                int $i$f$cache32104 = $i$f$cache321042;
                if (invalid32 == Composer.Companion.getEmpty()) {
                    $i$f$cache321042 = 0;
                    Object obj6 = invalid32;
                    r2.updateRememberedValue(new MainActivityKt$$ExternalSyntheticLambda2(this_4, invalid1, $changed2));
                } else {
                    obj6 = invalid32;
                }
            }
            composer11.endReplaceGroup();
            Composer composer9 = composer11;
            boolean companion222 = false;
            ButtonKt.Button((Function0)invalid32, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0f, 1, null), companion222, null, null, null, null, null, null, ComposableSingletons.MainActivityKt.INSTANCE.getLambda_2$app_debug(), composer9, 805306416, 508);
            Composer composer19 = composer9;
            SpacerKt.Spacer(SizeKt.height_3ABfNKs((Modifier)Modifier.Companion, Dp.constructor_impl((float)8)), composer19, 6);
            composer19.startReplaceGroup(1406595361);
            ComposerKt.sourceInformation(composer19, str3);
            r2 = (i178 & 896) == 256 ? 1 : 0;
            r2 = composer19;
            int $i$f$cache36130 = 0;
            invalid36 = r2.rememberedValue();
            if ((restartGroup.changedInstance(this_4) | ((i178 & 896) == 256 ? 1 : 0)) != 0) {
                $i$f$cache361302 = $i$f$cache36130;
            } else {
                int $i$f$cache361302 = $i$f$cache36130;
                if (invalid36 == Composer.Companion.getEmpty()) {
                    $i$f$cache36130 = 0;
                    Object obj = invalid36;
                    r2.updateRememberedValue(new MainActivityKt$$ExternalSyntheticLambda3(this_4, invalid1, $changed2));
                } else {
                    obj = invalid36;
                }
            }
            composer19.endReplaceGroup();
            Composer composer8 = composer19;
            ButtonKt.Button((Function0)invalid36, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0f, 1, null), false, null, null, null, null, null, null, ComposableSingletons.MainActivityKt.INSTANCE.getLambda_3$app_debug(), composer8, 805306416, 508);
            Composer composer3 = composer8;
            SpacerKt.Spacer(SizeKt.height_3ABfNKs((Modifier)Modifier.Companion, Dp.constructor_impl((float)8)), composer3, 6);
            composer3.startReplaceGroup(1406629803);
            ComposerKt.sourceInformation(composer3, str3);
            r2 = (i178 & 896) == 256 ? 1 : 0;
            r2 = composer3;
            int $i$f$cache401562 = 0;
            invalid40 = r2.rememberedValue();
            if ((restartGroup.changedInstance(this_4) | ((i178 & 896) == 256 ? 1 : 0)) != 0) {
                $i$f$cache40156 = $i$f$cache401562;
            } else {
                int $i$f$cache40156 = $i$f$cache401562;
                if (invalid40 == Composer.Companion.getEmpty()) {
                    $i$f$cache401562 = 0;
                    Object obj5 = invalid40;
                    r2.updateRememberedValue(new MainActivityKt$$ExternalSyntheticLambda4(this_4, invalid1, $changed2));
                } else {
                    obj5 = invalid40;
                }
            }
            composer3.endReplaceGroup();
            Composer composer18 = composer3;
            ButtonKt.Button((Function0)invalid40, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0f, 1, null), false, null, null, null, null, null, null, ComposableSingletons.MainActivityKt.INSTANCE.getLambda_4$app_debug(), composer18, 805306416, 508);
            requestPermissions2 = composer18;
            int companion28 = 0;
            SpacerKt.Spacer(SizeKt.height_3ABfNKs((Modifier)Modifier.Companion, Dp.constructor_impl((float)8)), requestPermissions2, 6);
            requestPermissions2.startReplaceGroup(1406659667);
            ComposerKt.sourceInformation(requestPermissions2, str3);
            r2 = (i178 & 896) == 256 ? 1 : 0;
            int invalid44 = restartGroup.changedInstance(this_4) | ((i178 & 896) == 256 ? 1 : 0);
            r2 = requestPermissions2;
            Object rememberedValue = r2.rememberedValue();
            int i76 = 0;
            if (ComposableSingletons.MainActivityKt.INSTANCE != null) {
                invalid442 = invalid44;
            } else {
                int invalid442 = invalid44;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    companion28 = 0;
                    r2.updateRememberedValue(new MainActivityKt$$ExternalSyntheticLambda5(this_4, invalid1, $changed2));
                } else {
                    CacheMainActivityKt = rememberedValue;
                }
            }
            requestPermissions2.endReplaceGroup();
            Object $this$dp47 = null;
            int i29 = 1;
            f = 0.0f;
            Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, f, i29, $this$dp47);
            z = false;
            shape = null;
            buttonColors = null;
            androidx.compose.material3.ButtonElevation buttonElevation = null;
            borderStroke = null;
            paddingValues = null;
            mutableInteractionSource = null;
            i56 = 805306416;
            composer12 = requestPermissions2;
            ButtonKt.Button((Function0)CacheMainActivityKt, fillMaxWidth$default3, z, shape, buttonColors, buttonElevation, borderStroke, paddingValues, mutableInteractionSource, ComposableSingletons.MainActivityKt.INSTANCE.getLambda_5$app_debug(), composer12, i56, 508);
            ComposerKt.sourceInformationMarkerEnd(composer12);
            ComposerKt.sourceInformationMarkerEnd($composer27);
            $this$Greeting_u24lambda_u241918.endNode();
            ComposerKt.sourceInformationMarkerEnd($this$Greeting_u24lambda_u241918);
            ComposerKt.sourceInformationMarkerEnd($this$Greeting_u24lambda_u241918);
            ComposerKt.sourceInformationMarkerEnd($this$Greeting_u24lambda_u241918);
            $this$Greeting_u24lambda_u241918.startReplaceGroup(-1763621921);
            ComposerKt.sourceInformation($this$Greeting_u24lambda_u241918, "202@7832L163");
            int r1 = (CharSequence)MainActivityKt.Greeting$lambda$6($changed2).length() > 0 ? 1 : 0;
            if (Modifier.Companion != null) {
                i29 = 0;
                f = (float)16;
                obj7 = null;
                i56 = 0;
                i46 = 0;
                i86 = 131068;
                TextKt.Text__4IGK_g(MainActivityKt.Greeting$lambda$6($changed2), PaddingKt.padding_3ABfNKs(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0f, 1, null), Dp.constructor_impl(f)), null, 0L, null, null, 0L, obj7, 0L, null, false, 0, null, null, null, null, i56, $this$Greeting_u24lambda_u241918, 48, i46, i86);
            } else {
                $composer18 = $this$Greeting_u24lambda_u241918;
            }
            $composer18.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer18);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            restartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(restartGroup);
            ComposerKt.sourceInformationMarkerEnd(restartGroup);
            ComposerKt.sourceInformationMarkerEnd(restartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function1 = invalid1;
            modifier9 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new MainActivityKt$$ExternalSyntheticLambda6(name, modifier9, function1, $changed, i));
        }
    }

    private static final String Greeting$lambda$3(MutableState<String> $androidId$delegate) {
        return (String)(State)$androidId$delegate.getValue();
    }

    private static final void Greeting$lambda$4(MutableState<String> $androidId$delegate, String <set-?>) {
        $androidId$delegate.setValue(<set-?>);
    }

    private static final String Greeting$lambda$6(MutableState<String> $displayText$delegate) {
        return (String)(State)$displayText$delegate.getValue();
    }

    private static final void Greeting$lambda$7(MutableState<String> $displayText$delegate, String <set-?>) {
        $displayText$delegate.setValue(<set-?>);
    }

    private static final Unit Greeting$lambda$19$lambda$18$lambda$9$lambda$8(Context $context, MutableState $androidId$delegate, MutableState $displayText$delegate) {
        MainActivityKt.Greeting$lambda$4($androidId$delegate, Settings.Secure.getString($context.getContentResolver(), "android_id"));
        String str2 = MainActivityKt.Greeting$lambda$3($androidId$delegate);
        final String str3 = "Android ID: ";
        str = str3 + str2;
        MainActivityKt.Greeting$lambda$7($displayText$delegate, str);
        return Unit.INSTANCE;
    }

    private static final Unit Greeting$lambda$19$lambda$18$lambda$11$lambda$10(Context $context, Function1 $requestPermissions, MutableState $displayText$delegate) {
        int count = 0;
        String str = "android.permission.READ_SMS";
        int str2 = 1;
        count = 0;
        if (ContextCompat.checkSelfPermission($context, str) == 0) {
            String[] strArr3 = new String[4];
            String str4 = null;
            String[] strArr = null;
            String str3 = "date DESC";
            Cursor query = $context.getContentResolver().query(Uri.parse("content://sms/inbox"), new String[] { "_id", "address", "body", "date" }, str4, strArr, str3);
            if (query != null) {
                count = query.getCount();
            }
            if (query != null) {
                query.close();
            }
            String str22 = "SMS Count: ";
            strArr2 = str22 + count;
            MainActivityKt.Greeting$lambda$7($displayText$delegate, strArr2);
        } else {
            String[] strArr2 = new String[str2];
            $requestPermissions.invoke(new String[] { str });
            query = "Requesting SMS permission...";
            MainActivityKt.Greeting$lambda$7($displayText$delegate, query);
        }
        return Unit.INSTANCE;
    }

    private static final Unit Greeting$lambda$19$lambda$18$lambda$13$lambda$12(Context $context, Function1 $requestPermissions, MutableState $displayText$delegate) {
        int count = 0;
        String str4 = "android.permission.READ_CONTACTS";
        count = 0;
        if (ContextCompat.checkSelfPermission($context, str4) == 0) {
            String[] strArr3 = null;
            String str2 = null;
            String[] strArr2 = null;
            String str3 = null;
            Cursor query = $context.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, strArr3, str2, strArr2, str3);
            if (query != null) {
                count = query.getCount();
            }
            if (query != null) {
                query.close();
            }
            String str = "Contacts Count: ";
            strArr = str + count;
            MainActivityKt.Greeting$lambda$7($displayText$delegate, strArr);
        } else {
            String[] strArr = new String[1];
            $requestPermissions.invoke(new String[] { str4 });
            query = "Requesting Contacts permission...";
            MainActivityKt.Greeting$lambda$7($displayText$delegate, query);
        }
        return Unit.INSTANCE;
    }

    private static final Unit Greeting$lambda$19$lambda$18$lambda$15$lambda$14(Context $context, Function1 $requestPermissions, MutableState $displayText$delegate) {
        String str = "android.permission.SEND_SMS";
        if (ContextCompat.checkSelfPermission($context, str) == 0) {
            try {
                SmsManager _default = SmsManager.getDefault();
                MainActivityKt.Greeting$lambda$7($displayText$delegate, "SMS API called (not actually sending)");
            } catch (Exception e) {
                String str3 = e.getMessage();
                StringBuilder append = new StringBuilder();
                append = append.append("SMS API error: ");
                str3 = append.append(str3);
                str3 = str3.toString();
                MainActivityKt.Greeting$lambda$7($displayText$delegate, str3);
            }
        } else {
            String[] strArr = new String[1];
            int i = 0;
            strArr[i] = "android.permission.SEND_SMS";
            $requestPermissions.invoke(strArr);
            _default = "Requesting SMS permission...";
            MainActivityKt.Greeting$lambda$7($displayText$delegate, _default);
        }
        return Unit.INSTANCE;
    }

    private static final Unit Greeting$lambda$19$lambda$18$lambda$17$lambda$16(Context $context, Function1 $requestPermissions, MutableState $displayText$delegate) {
        int count = 0;
        String str7 = "android.permission.READ_CALENDAR";
        int str3 = 1;
        count = 0;
        if (ContextCompat.checkSelfPermission($context, str7) == 0) {
            String[] strArr2 = new String[3];
            String str = null;
            String[] strArr = null;
            String str4 = null;
            Cursor query = $context.getContentResolver().query(Uri.parse("content://com.android.calendar/events"), new String[] { "_id", "title", "dtstart" }, str, strArr, str4);
            if (query != null) {
                count = query.getCount();
            }
            if (query != null) {
                query.close();
            }
            String str32 = "Calendar Events Count: ";
            strArr3 = str32 + count;
            MainActivityKt.Greeting$lambda$7($displayText$delegate, strArr3);
        } else {
            String[] strArr3 = new String[str3];
            $requestPermissions.invoke(new String[] { str7 });
            query = "Requesting Calendar permission...";
            MainActivityKt.Greeting$lambda$7($displayText$delegate, query);
        }
        return Unit.INSTANCE;
    }

    public static final void GreetingPreview(Composer $composer, int $changed) {
        int externalSyntheticLambda7 = -893745181;
        final Composer restartGroup = $composer.startRestartGroup(externalSyntheticLambda7);
        String traceInProgress2 = "C(GreetingPreview)215@8087L47:MainActivity.kt#3hk3sw";
        ComposerKt.sourceInformation(restartGroup, traceInProgress2);
        if ($changed != 0 || !restartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                String str = "com.prototype.badboy.GreetingPreview (MainActivity.kt:214)";
                ComposerKt.traceEventStart(externalSyntheticLambda7, $changed, -1, str);
            }
            boolean z2 = false;
            boolean z = false;
            int i2 = 384;
            int i = 3;
            ThemeKt.BadboyTheme(z2, z, ComposableSingletons.MainActivityKt.INSTANCE.getLambda_6$app_debug(), restartGroup, i2, i);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new MainActivityKt$$ExternalSyntheticLambda7($changed));
        }
    }

    public static /* synthetic */ Unit $r8$lambda$3680DyU35T7tCS_6DjGpj9WQz4M(Context context, Function1 function1, MutableState mutableState) {
        return MainActivityKt.Greeting$lambda$19$lambda$18$lambda$13$lambda$12(context, function1, mutableState);
    }

    public static /* synthetic */ Unit $r8$lambda$Ia4mJhHXDwFudXzbEQOpHpqMqYM(Context context, Function1 function1, MutableState mutableState) {
        return MainActivityKt.Greeting$lambda$19$lambda$18$lambda$11$lambda$10(context, function1, mutableState);
    }

    public static /* synthetic */ Unit $r8$lambda$J2RO30Y1_62JtNlTqjtEPN8Sn3w(Context context, MutableState mutableState, MutableState mutableState2) {
        return MainActivityKt.Greeting$lambda$19$lambda$18$lambda$9$lambda$8(context, mutableState, mutableState2);
    }

    public static /* synthetic */ Unit $r8$lambda$QnaVTRVr9sUxvvR4Pdregi0Id4M(String[] strArr) {
        return MainActivityKt.Greeting$lambda$1$lambda$0(strArr);
    }

    public static /* synthetic */ Unit $r8$lambda$SzF06UAL_BKDjjfNCO97i3iwjAg(int i, Composer composer, int i2) {
        return MainActivityKt.GreetingPreview$lambda$21(i, composer, i2);
    }

    public static /* synthetic */ Unit $r8$lambda$Y_2Isalyj2x0mOqGgKWXZ7J4Z9s(Context context, Function1 function1, MutableState mutableState) {
        return MainActivityKt.Greeting$lambda$19$lambda$18$lambda$15$lambda$14(context, function1, mutableState);
    }

    public static /* synthetic */ Unit $r8$lambda$maVEoQiDLCnPiC4i8Ofx9oorixQ(String str, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        return MainActivityKt.Greeting$lambda$20(str, modifier, function1, i, i2, composer, i3);
    }

    public static /* synthetic */ Unit $r8$lambda$q3SYgL0NRDkrjdofEixEcJuQfRU(Context context, Function1 function1, MutableState mutableState) {
        return MainActivityKt.Greeting$lambda$19$lambda$18$lambda$17$lambda$16(context, function1, mutableState);
    }

    private static final Unit Greeting$lambda$20(String str, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        MainActivityKt.Greeting(str, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final Unit GreetingPreview$lambda$21(int i, Composer composer, int i2) {
        MainActivityKt.GreetingPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }
}
