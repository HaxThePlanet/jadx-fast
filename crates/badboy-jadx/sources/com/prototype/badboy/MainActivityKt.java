package com.prototype.badboy;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.provider.CallLog.Calls;
import android.provider.ContactsContract.Contacts;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.telephony.SmsManager;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.ButtonDefaults;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontStyle.Companion;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeight.Companion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import androidx.compose.ui.unit.TextUnitType.Companion;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.prototype.badboy.ui.theme.ThemeKt;
import dalvik.system.DexClassLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0006\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u001a\u0008\u0002\u0010\u0006\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u0008\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\t\u001a\r\u0010\n\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\u000c²\u0006\n\u0010\r\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u000e\u001a\u00020\u0003X\u008a\u008e\u0002", d2 = {"Greeting", "", "name", "", "modifier", "Landroidx/compose/ui/Modifier;", "requestPermissions", "Lkotlin/Function1;", "", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "GreetingPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "androidId", "displayText"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MainActivityKt {
    public static Unit $r8$lambda$6qY5_KIdQhB-XZ1R33CyP2BIfX4(Context context, Function1 function12, MutableState mutableState3) {
        return MainActivityKt.Greeting$lambda$42$lambda$41$lambda$14$lambda$13(context, function12, mutableState3);
    }

    public static Unit $r8$lambda$6qjSKlKG5o5k3c4gbVz9DB7K6Lw(Context context, Function1 function12, MutableState mutableState3) {
        return MainActivityKt.Greeting$lambda$42$lambda$41$lambda$16$lambda$15(context, function12, mutableState3);
    }

    public static Unit $r8$lambda$AU495hKuWdRAEphQ8UBW9_6rojA(int i, Composer composer2, int i3) {
        return MainActivityKt.GreetingPreview$lambda$44(i, composer2, i3);
    }

    public static Unit $r8$lambda$Ar6i3LnrzvLHuQEUe9pu4LDrweA(Context context, MutableState mutableState2) {
        return MainActivityKt.Greeting$lambda$42$lambda$41$lambda$31$lambda$30(context, mutableState2);
    }

    public static Unit $r8$lambda$AtgKxZk5T5s8JXTfecjOLf8wLlw(Context context, Function1 function12, MutableState mutableState3) {
        return MainActivityKt.Greeting$lambda$42$lambda$41$lambda$18$lambda$17(context, function12, mutableState3);
    }

    public static Unit $r8$lambda$FIRujkfrYUlAwEyKBiBtBjwBGpM(Context context, MutableState mutableState2) {
        return MainActivityKt.Greeting$lambda$42$lambda$41$lambda$40$lambda$39(context, mutableState2);
    }

    public static Unit $r8$lambda$MqHuR1m6Uk0LVGAV0zWcbodM0aM(MutableState mutableState) {
        return MainActivityKt.Greeting$lambda$42$lambda$41$lambda$37$lambda$36(mutableState);
    }

    public static Unit $r8$lambda$QnaVTRVr9sUxvvR4Pdregi0Id4M(String[] stringArr) {
        return MainActivityKt.Greeting$lambda$1$lambda$0(stringArr);
    }

    public static Unit $r8$lambda$RVCHzZHcufWHhdJ-ik1thtx_GvU(Context context, MutableState mutableState2) {
        return MainActivityKt.Greeting$lambda$42$lambda$41$lambda$23$lambda$22(context, mutableState2);
    }

    public static Unit $r8$lambda$T5snrnC1sPfrKeen4XiaeNPDx8E(MutableState mutableState) {
        return MainActivityKt.Greeting$lambda$42$lambda$41$lambda$33$lambda$32(mutableState);
    }

    public static void $r8$lambda$_52539QmaFcg_KMYGd8eAISM-vI(WindowManager windowManager, TextView textView2, View view3) {
        MainActivityKt.Greeting$lambda$42$lambda$41$lambda$29$lambda$28$lambda$27$lambda$26(windowManager, textView2, view3);
    }

    public static Unit $r8$lambda$_PZZk52mmgTnvZNuveArn-LIQeg(Context context, MutableState mutableState2) {
        return MainActivityKt.Greeting$lambda$42$lambda$41$lambda$20$lambda$19(context, mutableState2);
    }

    public static Unit $r8$lambda$a3kJkXM7Chtfn2V-kJpw00DV6R0(String string, Modifier modifier2, Function1 function13, int i4, int i5, Composer composer6, int i7) {
        return MainActivityKt.Greeting$lambda$43(string, modifier2, function13, i4, i5, composer6, i7);
    }

    public static Unit $r8$lambda$aTbmapmRqf2C6hjJCxO1q7a1o4o(Context context, MutableState mutableState2) {
        return MainActivityKt.Greeting$lambda$42$lambda$41$lambda$29$lambda$28(context, mutableState2);
    }

    public static Unit $r8$lambda$e4bu7Z7XUeHZ_uadUjwXNgsHRik(Context context, Function1 function12, MutableState mutableState3) {
        return MainActivityKt.Greeting$lambda$42$lambda$41$lambda$35$lambda$34(context, function12, mutableState3);
    }

    public static Unit $r8$lambda$eT90GBi3YJv_nMtvs29JP4MG-q4(Context context, MutableState mutableState2, MutableState mutableState3) {
        return MainActivityKt.Greeting$lambda$42$lambda$41$lambda$10$lambda$9(context, mutableState2, mutableState3);
    }

    public static Unit $r8$lambda$uHOLv3rsD1xRYvBIRZCi6aSJYu4(Context context, MutableState mutableState2) {
        return MainActivityKt.Greeting$lambda$42$lambda$41$lambda$25$lambda$24(context, mutableState2);
    }

    public static Unit $r8$lambda$x_hGZXaXHFofVVjg7abrVqu_b6Q(Context context, Function1 function12, MutableState mutableState3) {
        return MainActivityKt.Greeting$lambda$42$lambda$41$lambda$12$lambda$11(context, function12, mutableState3);
    }

    public static final void Greeting(String name, Modifier modifier, Function1<? super String[], Unit> requestPermissions, Composer $composer, int $changed, int i6) {
        Object this_4;
        boolean traceInProgress2;
        Object mutableStateOf$default;
        Object it46;
        Object it50;
        Object it54;
        Object it58;
        Object it62;
        Object it66;
        Object it70;
        Object it74;
        Object it78;
        Object it822;
        Object it86;
        Object $i$a$CacheMainActivityKt$Greeting$2$2$139276541;
        Object $i$a$CacheMainActivityKt$Greeting$2$2$149677241;
        int fillMaxWidth$default;
        boolean changedInstance;
        int $dirty;
        Object obj7;
        int $dirty2;
        Object modifier4;
        Integer currentCompositionLocalMap2;
        Object it42;
        int i76;
        int i14;
        int i41;
        int i29;
        int i75;
        int $this$dp97;
        Object obj10;
        int i77;
        Object mutableStateOf$default2;
        Object $i$a$CacheMainActivityKt$Greeting$2$2$24868841;
        Object invalid1;
        Integer currentCompositionLocalMap3;
        int empty;
        int $composer3;
        int i25;
        int i85;
        boolean traceInProgress;
        Object $this$Greeting_u24lambda_u2442_u24lambda_u244141;
        int $composer414;
        Object $composer4113;
        int $composer4117;
        Object $composer417;
        int $composer412;
        Object $composer419;
        int $composer4112;
        Object $composer4111;
        Object empty2;
        int i31;
        Integer columnMeasurePolicy2;
        kotlin.jvm.functions.Function0 factory22;
        Composer composer3;
        Object columnMeasurePolicy3;
        Object str;
        Composer composer;
        Object currentCompositionLocalMap;
        int i61;
        int i45;
        kotlin.jvm.functions.Function0 factory13;
        Composer composer4;
        kotlin.jvm.functions.Function0 factory36;
        Object columnMeasurePolicy;
        int rememberedValue;
        int i86;
        int empty3;
        int currentCompositeKeyHash;
        Object empty4;
        Object empty5;
        int i70;
        int i48;
        Object obj5;
        int i8;
        int currentCompositeKeyHash2;
        androidx.compose.ui.Alignment.Horizontal horizontal;
        int i78;
        Modifier modifier2;
        int i55;
        kotlin.jvm.functions.Function0 function0;
        int companion6;
        int i65;
        int i23;
        Modifier modifier3;
        int i59;
        int i10;
        int i42;
        int i46;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy11;
        androidx.compose.runtime.CompositionLocalMap map;
        ColumnScopeInstance columnScopeInstance2;
        int i84;
        Modifier padding-3ABfNKs;
        int i62;
        kotlin.jvm.functions.Function0 function02;
        ColumnScopeInstance columnScopeInstance;
        Composer composer6;
        androidx.compose.runtime.CompositionLocalMap localMap35;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        com.prototype.badboy.MainActivityKt$$ExternalSyntheticLambda13 activity;
        Modifier fillMaxWidth$default4;
        Object obj12;
        Object obj6;
        Composer.Companion companion;
        Object fillMaxWidth$default3;
        Object fillMaxWidth$default2;
        int i39;
        int companion8;
        Object obj4;
        int $i$f$cache46162;
        Object obj2;
        Object obj9;
        Object obj14;
        Object obj11;
        Object obj8;
        Object obj15;
        Object obj;
        Object obj13;
        Object it82;
        Composer.Companion companion2;
        int companion10;
        Composer.Companion companion11;
        int companion4;
        Composer.Companion companion9;
        int companion3;
        Composer.Companion companion5;
        int companion7;
        int i30;
        int i3;
        int i43;
        int i80;
        int i79;
        int i64;
        androidx.compose.runtime.CompositionLocalMap localMap21;
        int i50;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        kotlin.jvm.functions.Function3 lambda-14$app_debug;
        Composer composer7;
        Composer $composer413;
        Composer $composer41;
        Composer $composer4110;
        Composer $composer415;
        Composer $composer4114;
        Composer $composer4115;
        Composer $composer418;
        Composer $composer416;
        Composer $composer4116;
        int i63;
        int i16;
        Composer $composer18;
        int i17;
        int i15;
        int i24;
        int i7;
        Composer composer5;
        int i;
        androidx.compose.foundation.layout.Arrangement.Vertical vertical;
        Composer $composer2;
        Object obj3;
        Modifier padding-qDBjuR0$default;
        int i69;
        int i73;
        int i47;
        int i27;
        int i71;
        int i28;
        int i18;
        int i66;
        int i11;
        int i72;
        int i19;
        int i49;
        int i52;
        int i32;
        int i54;
        int i74;
        int i33;
        int i2;
        TextStyle textStyle;
        Composer composer2;
        int i36;
        int i53;
        int i20;
        long l;
        int i56;
        FontWeight medium;
        int i51;
        int i4;
        int i60;
        int i38;
        int i21;
        int i5;
        int i26;
        int i34;
        int i37;
        int i12;
        int i57;
        int i9;
        int i35;
        int i81;
        int i13;
        int i22;
        int i67;
        int i58;
        int i40;
        int i82;
        int i83;
        int i68;
        int i44;
        int obj122;
        int obj123;
        boolean obj124;
        mutableStateOf$default2 = $changed;
        Intrinsics.checkNotNullParameter(name, "name");
        this_4 = 654543564;
        $composer3 = $composer.startRestartGroup(this_4);
        ComposerKt.sourceInformation($composer3, "C(Greeting)P(1)81@2982L2,83@3020L7,84@3049L31,85@3104L31,87@3141L20018:MainActivity.kt#3hk3sw");
        $dirty = $changed;
        int i164 = i6 & 2;
        if (i164 != 0) {
            $dirty |= 48;
            $i$a$CacheMainActivityKt$Greeting$2$2$24868841 = modifier;
        } else {
            if (mutableStateOf$default2 & 48 == 0) {
                i25 = $composer3.changed(modifier) ? 32 : 16;
                $dirty |= i25;
            } else {
                $i$a$CacheMainActivityKt$Greeting$2$2$24868841 = modifier;
            }
        }
        i85 = i6 & 4;
        if (i85 != 0) {
            $dirty |= 384;
            str = requestPermissions;
        } else {
            if (mutableStateOf$default2 & 384 == 0) {
                i61 = $composer3.changedInstance(requestPermissions) ? 256 : 128;
                $dirty |= i61;
            } else {
                str = requestPermissions;
            }
        }
        int i256 = $dirty;
        if (i256 & 145 == 144) {
            if (!$composer3.getSkipping()) {
                if (i164 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = $i$a$CacheMainActivityKt$Greeting$2$2$24868841;
                }
                String str7 = "CC(remember):MainActivity.kt#9igjgp";
                if (i85 != 0) {
                    $composer3.startReplaceGroup(-1388741943);
                    ComposerKt.sourceInformation($composer3, str7);
                    int i166 = 0;
                    i85 = $composer3;
                    i45 = 0;
                    rememberedValue = i85.rememberedValue();
                    i86 = 0;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty3 = 0;
                        currentCompositeKeyHash = new MainActivityKt$$ExternalSyntheticLambda0();
                        i85.updateRememberedValue(currentCompositeKeyHash);
                    } else {
                        currentCompositeKeyHash = rememberedValue;
                    }
                    invalid1 = currentCompositeKeyHash;
                    $composer3.endReplaceGroup();
                } else {
                    invalid1 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(this_4, i256, -1, "com.prototype.badboy.Greeting (MainActivity.kt:82)");
                }
                int i185 = 0;
                int i249 = 0;
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd($composer3);
                this_4 = consume;
                $composer3.startReplaceGroup(-1388739770);
                ComposerKt.sourceInformation($composer3, str7);
                int i187 = 0;
                int i250 = i187;
                Composer composer27 = $composer3;
                int i270 = 0;
                Object rememberedValue7 = composer27.rememberedValue();
                int i289 = 0;
                int i200 = 0;
                obj122 = i187;
                int i188 = 2;
                if (rememberedValue7 == Composer.Companion.getEmpty()) {
                    empty4 = 0;
                    composer27.updateRememberedValue(SnapshotStateKt.mutableStateOf$default("", i200, i188, i200));
                } else {
                    mutableStateOf$default = rememberedValue7;
                }
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(-1388738010);
                ComposerKt.sourceInformation($composer3, str7);
                int i252 = obj122;
                Composer composer28 = $composer3;
                int i271 = 0;
                Object rememberedValue8 = composer28.rememberedValue();
                int i290 = 0;
                if (rememberedValue8 == Composer.Companion.getEmpty()) {
                    empty5 = 0;
                    composer28.updateRememberedValue(SnapshotStateKt.mutableStateOf$default("", i200, i188, i200));
                } else {
                    mutableStateOf$default2 = rememberedValue8;
                }
                $composer3.endReplaceGroup();
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier4, 0, 1, i200);
                int i272 = obj122;
                String str10 = "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart($composer3, -483455358, str10);
                androidx.compose.foundation.layout.Arrangement.Vertical top2 = Arrangement.INSTANCE.getTop();
                androidx.compose.ui.Alignment.Horizontal start = Alignment.Companion.getStart();
                columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(top2, start, $composer3, i302 | i305);
                i48 = 0;
                String modifier5 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, modifier5);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, obj122);
                currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
                horizontal = start;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier($composer3, fillMaxSize$default);
                modifier2 = fillMaxSize$default;
                kotlin.jvm.functions.Function0 function03 = constructor2;
                i78 = 0;
                String $changed11 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, $changed11);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(function03);
                } else {
                    factory13 = function03;
                    $composer3.useNode();
                }
                function0 = factory13;
                Composer constructor-impl3 = Updater.constructor-impl($composer3);
                int i312 = 0;
                i10 = i276;
                Updater.set-impl(constructor-impl3, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i313 = 0;
                Composer composer30 = constructor-impl3;
                int i316 = 0;
                if (!composer30.getInserting()) {
                    measurePolicy11 = columnMeasurePolicy2;
                    map = currentCompositionLocalMap;
                    if (!Intrinsics.areEqual(composer30.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer30.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer30;
                    }
                } else {
                    measurePolicy11 = columnMeasurePolicy2;
                    map = currentCompositionLocalMap;
                }
                Updater.set-impl(constructor-impl3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                str = $composer3;
                modifier3 = materializeModifier2;
                String materialized12 = "C87@4365L9:Column.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(str, -384862393, materialized12);
                i315 |= 6;
                i59 = 0;
                i7 = i203;
                ComposerKt.sourceInformationMarkerStart(str, 1158396182, "C91@3242L2268,140@5619L21,137@5519L17407:MainActivity.kt#3hk3sw");
                i = i261;
                vertical = top2;
                int verticalArrangement11 = 1;
                int i280 = 0;
                com.prototype.badboy.MainActivityKt$$ExternalSyntheticLambda0 activity5 = invalid1;
                Modifier padding-VpY3zN4$default = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, verticalArrangement11, 0), ColorKt.Color(4279900698L), obj39, 0, 2), 0, Dp.constructor-impl((float)i262), 1, 0);
                androidx.compose.ui.Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
                int i263 = 390;
                ComposerKt.sourceInformationMarkerStart(str, -483455358, str10);
                androidx.compose.foundation.layout.Arrangement.Vertical top3 = Arrangement.INSTANCE.getTop();
                int i326 = i263;
                columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top3, centerHorizontally, str, i318 | i322);
                int i323 = 0;
                androidx.compose.ui.Alignment.Horizontal horizontal2 = centerHorizontally;
                ComposerKt.sourceInformationMarkerStart(str, -1323940314, modifier5);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(str, 0);
                currentCompositionLocalMap3 = str.getCurrentCompositionLocalMap();
                int i333 = i282;
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(str, padding-VpY3zN4$default);
                Modifier modifier7 = padding-VpY3zN4$default;
                kotlin.jvm.functions.Function0 function05 = constructor3;
                int i338 = 0;
                ComposerKt.sourceInformationMarkerStart(str, -692256719, $changed11);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                str.startReusableNode();
                if (str.getInserting()) {
                    str.createNode(function05);
                } else {
                    factory22 = function05;
                    str.useNode();
                }
                kotlin.jvm.functions.Function0 function06 = factory22;
                Composer constructor-impl = Updater.constructor-impl(str);
                int i370 = 0;
                androidx.compose.foundation.layout.Arrangement.Vertical vertical2 = top3;
                Updater.set-impl(constructor-impl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i379 = 0;
                Composer composer32 = constructor-impl;
                int i423 = 0;
                if (!composer32.getInserting()) {
                    localMap21 = currentCompositionLocalMap3;
                    measurePolicy = columnMeasurePolicy;
                    if (!Intrinsics.areEqual(composer32.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer32.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer4 = composer32;
                    }
                } else {
                    localMap21 = currentCompositionLocalMap3;
                    measurePolicy = columnMeasurePolicy;
                }
                Updater.set-impl(constructor-impl, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                Composer composer25 = str;
                ComposerKt.sourceInformationMarkerStart(composer25, -384862393, materialized12);
                ColumnScopeInstance iNSTANCE18 = ColumnScopeInstance.INSTANCE;
                i372 |= 6;
                int i380 = 0;
                int i407 = i169;
                int i465 = i264;
                Composer $i$a$LayoutColumnKt$Column$12663620 = composer43;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutColumnKt$Column$12663620, 653618595, "C98@3521L582,109@4116L40,110@4169L390,118@4572L464,127@5049L451:MainActivity.kt#3hk3sw");
                ColumnScopeInstance columnScopeInstance3 = iNSTANCE18;
                long l10 = TextUnitKt.TextUnit-anM5pPY(1094713344, TextUnitType.Companion.getSp-UIouoOA());
                FontWeight bold = FontWeight.Companion.getBold();
                int i547 = 16777208;
                i38 = 0;
                i71 = 0;
                i28 = 0;
                i18 = 0;
                int i510 = 0;
                i19 = 0;
                int i515 = 0;
                i2 = 0;
                TextStyle textStyle2 = textStyle4;
                int i543 = 0;
                i56 = 0;
                int i544 = 0;
                int i546 = 0;
                i4 = 0;
                super(Color.Companion.getGreen-0d7_KjU(), obj69, l10, obj71, bold, i71, i28, i18, 0, i510, obj78, i19, 0, i515, 0, obj83, 0, 0, i2, 0, 0, 0, obj90, 0, i543, i56, i544, i546, i4, i547, i38);
                int i295 = 0;
                Modifier modifier10 = modifier6;
                int i296 = 0;
                Composer composer44 = $i$a$LayoutColumnKt$Column$12663620;
                int i497 = 0;
                int i501 = 0;
                int i511 = 0;
                int i519 = 0;
                int i535 = 0;
                TextKt.Text--4IGK_g("SAFE TEST APP", PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU$default((Modifier)Modifier.Companion, ColorKt.Color(4278209792L), str, 0, 2), Dp.constructor-impl((float)i283), Dp.constructor-impl((float)$this$dp28)), i497, l10, i501, bold, i71, i28, i18, 0, i510, i511, i19, 0, i515, 0, i519, 0, 0, i2, textStyle2);
                Composer composer29 = composer44;
                int i284 = 0;
                float f7 = (float)i206;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl(f7)), composer29, 6);
                long l11 = TextUnitKt.TextUnit-anM5pPY(1107296256, TextUnitType.Companion.getSp-UIouoOA());
                FontWeight bold2 = FontWeight.Companion.getBold();
                i11 = 0;
                i52 = 0;
                TextStyle textStyle3 = textStyle6;
                super(Color.Companion.getRed-0d7_KjU(), i497, l11, i501, bold2, i71, i28, i18, 0, i11, i511, i19, 0, i52, 0, i519, 0, 0, i2, 0, 0, 0, i535, 0, i543, i56, i544, i546, i4, i547, i38);
                i66 = 0;
                i72 = 0;
                i49 = 0;
                i32 = 0;
                i54 = 0;
                i74 = 0;
                i33 = 0;
                int i541 = 65534;
                composer2 = composer29;
                TextKt.Text--4IGK_g("BADBOY", 0, 0, l11, 0, bold2, i71, i28, i18, i66, i11, i72, i19, i49, i52, i32, i54, i74, i33, i2, textStyle3);
                i44 = 0;
                i60 = 0;
                i21 = 0;
                i5 = 0;
                i26 = 0;
                i34 = 0;
                i37 = 0;
                i12 = 0;
                i57 = 0;
                i9 = 0;
                i35 = 0;
                i81 = 0;
                i13 = 0;
                i22 = 0;
                i67 = 0;
                i58 = 0;
                i40 = 0;
                i82 = 0;
                i83 = 0;
                super(Color.Companion.getGray-0d7_KjU(), i541, TextUnitKt.TextUnit-anM5pPY(1096810496, TextUnitType.Companion.getSp-UIouoOA()), i56, 0, FontStyle.box-impl(FontStyle.Companion.getItalic-_-LCdwA()), i4, i60, i38, i21, obj100, i5, i26, i34, i37, obj105, i12, i57, i9, i35, i81, i13, obj112, i22, i67, i58, i40, i82, i83, 16777204, i44);
                int i208 = 0;
                int i506 = 13;
                int i500 = 0;
                int i542 = 65532;
                TextKt.Text--4IGK_g("animalistic tendencies", PaddingKt.padding-qDBjuR0$default((Modifier)Modifier.Companion, 0, Dp.constructor-impl((float)i173), i500, 0, i506, i71), 0, i500, 0, i506, i71, i28, i18, i66, i11, i72, i19, i49, i52, i32, i54, i74, i33, i2, textStyle8);
                super(Color.Companion.getWhite-0d7_KjU(), i542, TextUnitKt.TextUnit-anM5pPY(1099956224, TextUnitType.Companion.getSp-UIouoOA()), i56, FontWeight.Companion.getMedium(), 0, i4, i60, i38, i21, obj100, i5, i26, i34, i37, obj105, i12, i57, i9, i35, i81, i13, obj112, i22, i67, i58, i40, i82, i83, 16777208, i44);
                int i209 = 0;
                i27 = 13;
                i73 = 0;
                TextKt.Text--4IGK_g("v1.0.0", PaddingKt.padding-qDBjuR0$default((Modifier)Modifier.Companion, 0, Dp.constructor-impl((float)i175), i73, 0, i27, i71), 0, i73, 0, i27, i71, i28, i18, i66, i11, i72, i19, i49, i52, i32, i54, i74, i33, i2, textStyle);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer25);
                str.endNode();
                ComposerKt.sourceInformationMarkerEnd(str);
                ComposerKt.sourceInformationMarkerEnd(str);
                ComposerKt.sourceInformationMarkerEnd(str);
                int i176 = 0;
                int i265 = 0;
                empty3 = 0;
                i84 = i285;
                ComposerKt.sourceInformationMarkerStart(str, -483455358, str10);
                columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getCenterHorizontally(), str, i287 |= i299);
                i86 = 0;
                ComposerKt.sourceInformationMarkerStart(str, -1323940314, modifier5);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(str, 0);
                currentCompositionLocalMap2 = str.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(str, PaddingKt.padding-3ABfNKs(ScrollKt.verticalScroll$default(ColumnScope.weight$default((ColumnScope)ColumnScopeInstance.INSTANCE, (Modifier)Modifier.Companion, 1065353216, false, 2, 0), ScrollKt.rememberScrollState(i176, str, i176, 1), false, 0, false, 14, 0), Dp.constructor-impl((float)i210)));
                int i308 = 6;
                kotlin.jvm.functions.Function0 function04 = constructor;
                i8 = 0;
                ComposerKt.sourceInformationMarkerStart(str, -692256719, $changed11);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                str.startReusableNode();
                if (str.getInserting()) {
                    str.createNode(function04);
                } else {
                    factory36 = function04;
                    str.useNode();
                }
                Composer constructor-impl5 = Updater.constructor-impl(str);
                int i311 = 0;
                Updater.set-impl(constructor-impl5, columnMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl5, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i325 = 0;
                Composer composer31 = constructor-impl5;
                int i334 = 0;
                if (!composer31.getInserting()) {
                    localMap35 = currentCompositionLocalMap2;
                    measurePolicy2 = columnMeasurePolicy3;
                    if (!Intrinsics.areEqual(composer31.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer31.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl5.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer31;
                    }
                } else {
                    localMap35 = currentCompositionLocalMap2;
                    measurePolicy2 = columnMeasurePolicy3;
                }
                Updater.set-impl(constructor-impl5, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer26 = str;
                i45 = 0;
                ComposerKt.sourceInformationMarkerStart(composer26, -384862393, materialized12);
                int i309 = 6;
                i275 |= 6;
                i23 = 0;
                i46 = i117;
                padding-3ABfNKs = materializeModifier;
                columnScopeInstance = iNSTANCE15;
                $this$Greeting_u24lambda_u2442_u24lambda_u244141 = composer36;
                ComposerKt.sourceInformationMarkerStart($this$Greeting_u24lambda_u2442_u24lambda_u244141, 656361103, "C146@5847L259,145@5813L410,158@6237L40,161@6325L879,160@6291L1028,184@7333L40,187@7421L860,186@7387L1013,210@8414L40,213@8502L710,212@8468L859,232@9341L40,235@9429L910,234@9395L1064,258@10473L40,261@10561L1901,260@10527L2060,296@12601L40,299@12689L1487,298@12655L1639,335@14308L40,338@14396L706,337@14362L861,358@15237L40,362@15376L2283,401@17780L115,361@15342L2621,408@17977L40,412@18138L1315,437@19574L115,411@18104L1659,444@19777L40,448@19905L428,447@19871L578,463@20463L40,467@20590L892,466@20556L1046,490@21616L40,494@21758L105,493@21724L259,502@21997L40,506@22141L656,505@22107L809:MainActivity.kt#3hk3sw");
                $this$Greeting_u24lambda_u2442_u24lambda_u244141.startReplaceGroup(1406630504);
                ComposerKt.sourceInformation($this$Greeting_u24lambda_u2442_u24lambda_u244141, str7);
                Composer composer20 = $this$Greeting_u24lambda_u2442_u24lambda_u244141;
                int i335 = 0;
                it42 = composer20.rememberedValue();
                int i360 = 0;
                if (!$this$Greeting_u24lambda_u2442_u24lambda_u244141.changedInstance((Context)this_4)) {
                    $composer413 = $this$Greeting_u24lambda_u2442_u24lambda_u244141;
                    if (it42 == Composer.Companion.getEmpty()) {
                        $this$Greeting_u24lambda_u2442_u24lambda_u244141 = 0;
                        obj4 = it42;
                        it42 = new MainActivityKt$$ExternalSyntheticLambda15(this_4, (MutableState)mutableStateOf$default, (MutableState)mutableStateOf$default2);
                        composer20.updateRememberedValue(it42);
                    } else {
                        obj4 = it42;
                    }
                } else {
                    $composer413 = $this$Greeting_u24lambda_u2442_u24lambda_u244141;
                }
                $composer413.endReplaceGroup();
                obj3 = mutableStateOf$default;
                ButtonKt.Button((Function0)it42, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), false, 0, 0, 0, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-1$app_debug(), $composer413, 805306416, 508);
                Composer composer22 = $composer413;
                int i336 = i178;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i119)), composer22, 6);
                composer22.startReplaceGroup(1406646420);
                ComposerKt.sourceInformation(composer22, str7);
                i76 = i256 & 896 == 256 ? 1 : 0;
                Composer composer8 = composer22;
                empty = 0;
                it46 = composer8.rememberedValue();
                int i341 = 0;
                if (changedInstance2 |= i76 == 0) {
                    $i$f$cache46162 = empty;
                    if (it46 == Composer.Companion.getEmpty()) {
                        obj12 = it46;
                        i3 = $i$f$cache461622;
                        it46 = new MainActivityKt$$ExternalSyntheticLambda16(this_4, activity5, mutableStateOf$default2);
                        composer8.updateRememberedValue(it46);
                    } else {
                        obj12 = it46;
                        $i$a$CacheMainActivityKt$Greeting$2$2$24868841 = activity5;
                    }
                } else {
                    $i$f$cache46162 = empty;
                }
                composer22.endReplaceGroup();
                Composer composer37 = composer22;
                composer6 = composer26;
                ButtonKt.Button((Function0)it46, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), false, 0, 0, 0, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-2$app_debug(), composer37, 805306416, 508);
                $composer414 = composer37;
                int i342 = i211;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i123)), $composer414, 6);
                $composer414.startReplaceGroup(1406681473);
                ComposerKt.sourceInformation($composer414, str7);
                i14 = i256 & 896 == 256 ? 1 : 0;
                Composer composer9 = $composer414;
                int i213 = 0;
                it50 = composer9.rememberedValue();
                int i361 = 0;
                if (changedInstance3 |= i14 == 0) {
                    $composer41 = $composer414;
                    if (it50 == Composer.Companion.getEmpty()) {
                        $composer414 = 0;
                        obj2 = it50;
                        it50 = new MainActivityKt$$ExternalSyntheticLambda17(this_4, $i$a$CacheMainActivityKt$Greeting$2$2$24868841, mutableStateOf$default2);
                        composer9.updateRememberedValue(it50);
                    } else {
                        obj2 = it50;
                    }
                } else {
                    $composer41 = $composer414;
                }
                $composer41.endReplaceGroup();
                ButtonKt.Button((Function0)it50, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), false, 0, 0, 0, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-3$app_debug(), $composer41, 805306416, 508);
                $composer4113 = $composer41;
                int i344 = i215;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i127)), $composer4113, 6);
                $composer4113.startReplaceGroup(1406715915);
                ComposerKt.sourceInformation($composer4113, str7);
                i41 = i256 & 896 == 256 ? 1 : 0;
                Composer composer10 = $composer4113;
                int i217 = 0;
                it54 = composer10.rememberedValue();
                int i362 = 0;
                if (changedInstance4 |= i41 == 0) {
                    $composer4110 = $composer4113;
                    if (it54 == Composer.Companion.getEmpty()) {
                        $composer4113 = 0;
                        obj9 = it54;
                        it54 = new MainActivityKt$$ExternalSyntheticLambda1(this_4, $i$a$CacheMainActivityKt$Greeting$2$2$24868841, mutableStateOf$default2);
                        composer10.updateRememberedValue(it54);
                    } else {
                        obj9 = it54;
                    }
                } else {
                    $composer4110 = $composer4113;
                }
                $composer4110.endReplaceGroup();
                ButtonKt.Button((Function0)it54, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), false, 0, 0, 0, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-4$app_debug(), $composer4110, 805306416, 508);
                $composer4117 = $composer4110;
                int i346 = i219;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i131)), $composer4117, 6);
                $composer4117.startReplaceGroup(1406745779);
                ComposerKt.sourceInformation($composer4117, str7);
                i29 = i256 & 896 == 256 ? 1 : 0;
                Composer composer11 = $composer4117;
                int i221 = 0;
                it58 = composer11.rememberedValue();
                int i363 = 0;
                if (changedInstance5 |= i29 == 0) {
                    $composer415 = $composer4117;
                    if (it58 == Composer.Companion.getEmpty()) {
                        $composer4117 = 0;
                        obj14 = it58;
                        it58 = new MainActivityKt$$ExternalSyntheticLambda2(this_4, $i$a$CacheMainActivityKt$Greeting$2$2$24868841, mutableStateOf$default2);
                        composer11.updateRememberedValue(it58);
                    } else {
                        obj14 = it58;
                    }
                } else {
                    $composer415 = $composer4117;
                }
                $composer415.endReplaceGroup();
                ButtonKt.Button((Function0)it58, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), false, 0, 0, 0, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-5$app_debug(), $composer415, 805306416, 508);
                $composer417 = $composer415;
                int i348 = i223;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i135)), $composer417, 6);
                $composer417.startReplaceGroup(1406782994);
                ComposerKt.sourceInformation($composer417, str7);
                Composer composer12 = $composer417;
                int i224 = 0;
                it62 = composer12.rememberedValue();
                int i364 = 0;
                if (!$composer417.changedInstance(this_4)) {
                    $composer4114 = $composer417;
                    if (it62 == Composer.Companion.getEmpty()) {
                        $composer417 = 0;
                        obj11 = it62;
                        it62 = new MainActivityKt$$ExternalSyntheticLambda3(this_4, mutableStateOf$default2);
                        composer12.updateRememberedValue(it62);
                    } else {
                        obj11 = it62;
                    }
                } else {
                    $composer4114 = $composer417;
                }
                $composer4114.endReplaceGroup();
                ButtonKt.Button((Function0)it62, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), false, 0, 0, 0, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-6$app_debug(), $composer4114, 805306416, 508);
                $composer412 = $composer4114;
                int i349 = i226;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i138)), $composer412, 6);
                $composer412.startReplaceGroup(1406850676);
                ComposerKt.sourceInformation($composer412, str7);
                Composer composer13 = $composer412;
                int i227 = 0;
                it66 = composer13.rememberedValue();
                int i365 = 0;
                if (!$composer412.changedInstance(this_4)) {
                    $composer4115 = $composer412;
                    if (it66 == Composer.Companion.getEmpty()) {
                        $composer412 = 0;
                        obj8 = it66;
                        it66 = new MainActivityKt$$ExternalSyntheticLambda4(this_4, mutableStateOf$default2);
                        composer13.updateRememberedValue(it66);
                    } else {
                        obj8 = it66;
                    }
                } else {
                    $composer4115 = $composer412;
                }
                $composer4115.endReplaceGroup();
                ButtonKt.Button((Function0)it66, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), false, 0, 0, 0, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-7$app_debug(), $composer4115, 805306416, 508);
                $composer419 = $composer4115;
                int i350 = i229;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i141)), $composer419, 6);
                $composer419.startReplaceGroup(1406904519);
                ComposerKt.sourceInformation($composer419, str7);
                Composer composer14 = $composer419;
                int i230 = 0;
                it70 = composer14.rememberedValue();
                int i366 = 0;
                if (!$composer419.changedInstance(this_4)) {
                    $composer418 = $composer419;
                    if (it70 == Composer.Companion.getEmpty()) {
                        $composer419 = 0;
                        obj15 = it70;
                        it70 = new MainActivityKt$$ExternalSyntheticLambda5(this_4, mutableStateOf$default2);
                        composer14.updateRememberedValue(it70);
                    } else {
                        obj15 = it70;
                    }
                } else {
                    $composer418 = $composer419;
                }
                $composer418.endReplaceGroup();
                int i403 = 0;
                int i431 = 0;
                int i459 = 0;
                ButtonKt.Button((Function0)it70, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), false, 0, i403, 0, i431, 0, i459, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-8$app_debug(), $composer418, 805306416, 508);
                $composer4112 = $composer418;
                int i351 = i232;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i144)), $composer4112, 6);
                $composer4112.startReplaceGroup(1406937456);
                ComposerKt.sourceInformation($composer4112, str7);
                Composer composer15 = $composer4112;
                int i233 = 0;
                it74 = composer15.rememberedValue();
                int i367 = 0;
                if (!$composer4112.changedInstance(this_4)) {
                    $composer416 = $composer4112;
                    if (it74 == Composer.Companion.getEmpty()) {
                        $composer4112 = 0;
                        obj = it74;
                        it74 = new MainActivityKt$$ExternalSyntheticLambda6(this_4, mutableStateOf$default2);
                        composer15.updateRememberedValue(it74);
                    } else {
                        obj = it74;
                    }
                } else {
                    $composer416 = $composer4112;
                }
                $composer416.endReplaceGroup();
                int i234 = 0;
                int i310 = 6;
                Composer composer34 = $composer416;
                androidx.compose.material3.ButtonColors buttonColors-ro_MJ88 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(ColorKt.Color(4294924066L), obj, 0, i403, 0, i431, 0);
                Composer composer38 = composer34;
                int i432 = 0;
                int i460 = 0;
                ButtonKt.Button((Function0)it74, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, i234), false, 0, buttonColors-ro_MJ88, 0, i432, 0, i460, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-9$app_debug(), composer38, 805306416, 492);
                $composer4111 = composer38;
                int i352 = i235;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i146)), $composer4111, 6);
                $composer4111.startReplaceGroup(1407024872);
                ComposerKt.sourceInformation($composer4111, str7);
                Composer composer16 = $composer4111;
                int i236 = 0;
                it78 = composer16.rememberedValue();
                int i368 = 0;
                if (!$composer4111.changedInstance(this_4)) {
                    $composer4116 = $composer4111;
                    if (it78 == Composer.Companion.getEmpty()) {
                        $composer4111 = 0;
                        obj13 = it78;
                        it78 = new MainActivityKt$$ExternalSyntheticLambda9(this_4, mutableStateOf$default2);
                        composer16.updateRememberedValue(it78);
                    } else {
                        obj13 = it78;
                    }
                } else {
                    $composer4116 = $composer4111;
                }
                $composer4116.endReplaceGroup();
                int i237 = 0;
                companion6 = 6;
                Composer composer35 = $composer4116;
                Composer composer39 = composer35;
                ButtonKt.Button((Function0)it78, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, i237), false, 0, ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(ColorKt.Color(4293467747L), obj13, 0, buttonColors-ro_MJ88, 0, i432, 0), 0, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-10$app_debug(), composer39, 805306416, 492);
                Composer composer23 = composer39;
                int i353 = i238;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i148)), composer23, 6);
                composer23.startReplaceGroup(1407080529);
                ComposerKt.sourceInformation(composer23, str7);
                Composer composer17 = composer23;
                int i239 = 0;
                int i354 = i107;
                it822 = composer17.rememberedValue();
                int i369 = 0;
                if (it822 == Composer.Companion.getEmpty()) {
                    empty2 = 0;
                    it82 = it822;
                    it822 = new MainActivityKt$$ExternalSyntheticLambda10(mutableStateOf$default2);
                    composer17.updateRememberedValue(it822);
                } else {
                    it82 = it822;
                }
                composer39.endReplaceGroup();
                ButtonKt.Button((Function0)it822, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), false, 0, 0, 0, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-11$app_debug(), composer39, 805306422, 508);
                Composer composer24 = composer39;
                int i355 = i241;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i152)), composer24, 6);
                composer24.startReplaceGroup(1407102913);
                ComposerKt.sourceInformation(composer24, str7);
                i75 = i256 & 896 == 256 ? 1 : 0;
                Composer composer18 = composer24;
                int i243 = 0;
                it86 = composer18.rememberedValue();
                int i356 = 0;
                if (changedInstance11 |= i75 == 0) {
                    $composer2 = $composer3;
                    if (it86 == Composer.Companion.getEmpty()) {
                        $composer3 = 0;
                        obj6 = it86;
                        it86 = new MainActivityKt$$ExternalSyntheticLambda11(this_4, $i$a$CacheMainActivityKt$Greeting$2$2$24868841, mutableStateOf$default2);
                        composer18.updateRememberedValue(it86);
                    } else {
                        obj6 = it86;
                    }
                } else {
                    $composer2 = $composer3;
                }
                composer24.endReplaceGroup();
                ButtonKt.Button((Function0)it86, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), false, 0, 0, 0, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-12$app_debug(), composer24, 805306416, 508);
                int i182 = 0;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i156)), composer24, 6);
                composer24.startReplaceGroup(1407139502);
                ComposerKt.sourceInformation(composer24, str7);
                Composer composer21 = composer24;
                int i245 = 0;
                Object rememberedValue2 = composer21.rememberedValue();
                int i357 = 0;
                obj124 = i111;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    companion = i114;
                    $i$a$CacheMainActivityKt$Greeting$2$2$139276541 = new MainActivityKt$$ExternalSyntheticLambda12(mutableStateOf$default2);
                    composer21.updateRememberedValue($i$a$CacheMainActivityKt$Greeting$2$2$139276541);
                } else {
                    $i$a$CacheMainActivityKt$Greeting$2$2$139276541 = rememberedValue2;
                }
                composer24.endReplaceGroup();
                ButtonKt.Button((Function0)$i$a$CacheMainActivityKt$Greeting$2$2$139276541, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), false, 0, 0, 0, 0, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-13$app_debug(), composer24, 805306422, 508);
                int i184 = 0;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl((float)i160)), composer24, 6);
                composer24.startReplaceGroup(1407152309);
                ComposerKt.sourceInformation(composer24, str7);
                changedInstance = composer24.changedInstance(this_4);
                Composer composer19 = composer24;
                i77 = 0;
                Object rememberedValue5 = composer19.rememberedValue();
                int i247 = 0;
                if (changedInstance == null) {
                    obj124 = changedInstance;
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        companion6 = invalid94;
                        $i$a$CacheMainActivityKt$Greeting$2$2$149677241 = new MainActivityKt$$ExternalSyntheticLambda13(this_4, mutableStateOf$default2);
                        composer19.updateRememberedValue($i$a$CacheMainActivityKt$Greeting$2$2$149677241);
                    } else {
                        $i$a$CacheMainActivityKt$Greeting$2$2$149677241 = rememberedValue5;
                    }
                } else {
                    obj124 = changedInstance;
                }
                composer24.endReplaceGroup();
                i39 = 0;
                i79 = 0;
                composer7 = composer24;
                ButtonKt.Button((Function0)$i$a$CacheMainActivityKt$Greeting$2$2$149677241, SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), i39, 0, 0, 0, i79, 0, 0, ComposableSingletons.MainActivityKt.INSTANCE.getLambda-14$app_debug(), composer7, 805306416, 508);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                str.endNode();
                ComposerKt.sourceInformationMarkerEnd(str);
                ComposerKt.sourceInformationMarkerEnd(str);
                ComposerKt.sourceInformationMarkerEnd(str);
                str.startReplaceGroup(-1763137185);
                ComposerKt.sourceInformation(str, "528@22980L163");
                i85 = (CharSequence)MainActivityKt.Greeting$lambda$6(mutableStateOf$default2).length() > 0 ? 1 : 0;
                if (i85 != 0) {
                    i77 = 0;
                    TextKt.Text--4IGK_g(MainActivityKt.Greeting$lambda$6(mutableStateOf$default2), PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), Dp.constructor-impl((float)i163)), 0, factory36, 0, composer6, 0, 0, 0, 0, i39, 0, false, 0, i79, 0, 0, 0, 0, 0, 0);
                } else {
                    $composer18 = str;
                }
                $composer18.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer18);
                ComposerKt.sourceInformationMarkerEnd(str);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj10 = $i$a$CacheMainActivityKt$Greeting$2$2$24868841;
                obj7 = obj5;
            } else {
                $composer3.skipToGroupEnd();
                obj7 = $i$a$CacheMainActivityKt$Greeting$2$2$24868841;
                $composer2 = $composer3;
                obj10 = str;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            this_4 = new MainActivityKt$$ExternalSyntheticLambda14(name, obj7, obj10, $changed, i6);
            endRestartGroup.updateScope(this_4);
        }
    }

    private static final Unit Greeting$lambda$1$lambda$0(String[] it) {
        Intrinsics.checkNotNullParameter(it, "it");
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

    private static final Unit Greeting$lambda$42$lambda$41$lambda$10$lambda$9(Context $context, MutableState $androidId$delegate, MutableState $displayText$delegate) {
        MainActivityKt.Greeting$lambda$4($androidId$delegate, Settings.Secure.getString($context.getContentResolver(), "android_id"));
        StringBuilder stringBuilder = new StringBuilder();
        MainActivityKt.Greeting$lambda$7($displayText$delegate, stringBuilder.append("Android ID: ").append(MainActivityKt.Greeting$lambda$3($androidId$delegate)).toString());
        return Unit.INSTANCE;
    }

    private static final Unit Greeting$lambda$42$lambda$41$lambda$12$lambda$11(Context $context, Function1 $requestPermissions, MutableState $displayText$delegate) {
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

    private static final Unit Greeting$lambda$42$lambda$41$lambda$14$lambda$13(Context $context, Function1 $requestPermissions, MutableState $displayText$delegate) {
        Object query;
        String[] strArr;
        int count;
        String str;
        Uri cONTENT_URI;
        int i4;
        int i2;
        int i3;
        int i;
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

    private static final Unit Greeting$lambda$42$lambda$41$lambda$16$lambda$15(Context $context, Function1 $requestPermissions, MutableState $displayText$delegate) {
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

    private static final Unit Greeting$lambda$42$lambda$41$lambda$18$lambda$17(Context $context, Function1 $requestPermissions, MutableState $displayText$delegate) {
        Object query;
        String[] strArr;
        int str;
        int count;
        ContentResolver contentResolver;
        Uri parse;
        String[] strArr2;
        int i2;
        int i3;
        int i;
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

    private static final Unit Greeting$lambda$42$lambda$41$lambda$20$lambda$19(Context $context, MutableState $displayText$delegate) {
        Object systemService;
        String str;
        DownloadManager.Request allowedOverRoaming;
        long enqueue;
        if (!$context.getPackageManager().canRequestPackageInstalls()) {
            Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
            StringBuilder stringBuilder = new StringBuilder();
            Intent data = intent.setData(Uri.parse(stringBuilder.append("package:").append($context.getPackageName()).toString()));
            Intrinsics.checkNotNullExpressionValue(data, "setData(...)");
            data.setFlags(268435456);
            $context.startActivity(data);
            MainActivityKt.Greeting$lambda$7($displayText$delegate, "Dropper: Enable unknown sources first");
            return Unit.INSTANCE;
        }
        try {
            systemService = $context.getSystemService("download");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.DownloadManager");
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse("https://f-droid.org/F-Droid.apk"));
            final String str10 = "fdroid.apk";
            int i2 = 1;
            StringBuilder stringBuilder2 = new StringBuilder();
            MainActivityKt.Greeting$lambda$7($displayText$delegate, stringBuilder2.append("Dropper: Downloading F-Droid (ID: ").append((DownloadManager)systemService.enqueue(request.setTitle((CharSequence)"F-Droid").setDescription((CharSequence)"Downloading APK...").setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, str10).setNotificationVisibility(i2).setAllowedOverMetered(i2).setAllowedOverRoaming(i2))).append(")").toString());
            String string = th.getMessage();
            StringBuilder append2 = new StringBuilder();
            append2 = append2.append("Dropper error: ");
            string = append2.append(string);
            string = string.toString();
            MainActivityKt.Greeting$lambda$7($displayText$delegate, string);
            return Unit.INSTANCE;
        }
    }

    private static final Unit Greeting$lambda$42$lambda$41$lambda$23$lambda$22(Context $context, MutableState $displayText$delegate) {
        File file;
        Uri uriForFile;
        Intent intent;
        String str;
        file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "fdroid.apk");
        if (file.exists() == null) {
            try {
                MainActivityKt.Greeting$lambda$7($displayText$delegate, "Install: APK not found. Download first.");
                return Unit.INSTANCE;
                StringBuilder stringBuilder = new StringBuilder();
                intent = new Intent("android.intent.action.VIEW");
                Intent intent2 = intent;
                final int i = 0;
                intent2.setDataAndType(FileProvider.getUriForFile($context, stringBuilder.append($context.getPackageName()).append(".fileprovider").toString(), file), "application/vnd.android.package-archive");
                intent2.setFlags(268435457);
                $context.startActivity(intent);
                MainActivityKt.Greeting$lambda$7($displayText$delegate, "Install: Launching installer...");
                String string = th.getMessage();
                StringBuilder append3 = new StringBuilder();
                append3 = append3.append("Install error: ");
                string = append3.append(string);
                string = string.toString();
                MainActivityKt.Greeting$lambda$7($displayText$delegate, string);
                return Unit.INSTANCE;
            }
        }
    }

    private static final Unit Greeting$lambda$42$lambda$41$lambda$25$lambda$24(Context $context, MutableState $displayText$delegate) {
        String absolutePath;
        String absolutePath2;
        DexClassLoader dexClassLoader;
        String string;
        File file = new File($context.getFilesDir(), "classes.dex");
        absolutePath = file.getAbsolutePath();
        dexClassLoader = new DexClassLoader(absolutePath, $context.getDir("dex", 0).getAbsolutePath(), 0, $context.getClassLoader());
        StringBuilder stringBuilder = new StringBuilder();
        MainActivityKt.Greeting$lambda$7($displayText$delegate, stringBuilder.append("DexClassLoader: Initialized (path: ").append(absolutePath).append(")").toString());
        return Unit.INSTANCE;
    }

    private static final Unit Greeting$lambda$42$lambda$41$lambda$29$lambda$28(Context $context, MutableState $displayText$delegate) {
        boolean drawOverlays;
        Object systemService;
        Object layoutParams;
        Object textView;
        Object append;
        Object str;
        com.prototype.badboy.MainActivityKt$$ExternalSyntheticLambda8 externalSyntheticLambda8;
        int i;
        if (!Settings.canDrawOverlays($context)) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                systemService = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(stringBuilder.append("package:").append($context.getPackageName()).toString()));
                systemService.setFlags(268435456);
                $context.startActivity(systemService);
                MainActivityKt.Greeting$lambda$7($displayText$delegate, "Overlay: Grant permission first!");
                systemService = $context.getSystemService("window");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                layoutParams = new WindowManager.LayoutParams(-1, 200, 2038, 8, -3);
                layoutParams.gravity = 48;
                textView = new TextView($context);
                TextView view = textView;
                int i7 = 0;
                view.setText((CharSequence)"OVERLAY ABUSE DEMO - Tap anywhere");
                view.setBackgroundColor(Color.parseColor("#CC000000"));
                view.setTextColor(-65536);
                view.setTextSize(1099956224);
                view.setGravity(17);
                int i12 = 40;
                i = 20;
                view.setPadding(i, i12, i, i12);
                externalSyntheticLambda8 = new MainActivityKt$$ExternalSyntheticLambda8((WindowManager)systemService, view);
                view.setOnClickListener(externalSyntheticLambda8);
                systemService.addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
                MainActivityKt.Greeting$lambda$7($displayText$delegate, "Overlay: Showing overlay! Tap it to dismiss.");
                String string = th.getMessage();
                StringBuilder append2 = new StringBuilder();
                append2 = append2.append("Overlay error: ");
                string = append2.append(string);
                string = string.toString();
                MainActivityKt.Greeting$lambda$7($displayText$delegate, string);
                return Unit.INSTANCE;
            }
        } else {
        }
    }

    private static final void Greeting$lambda$42$lambda$41$lambda$29$lambda$28$lambda$27$lambda$26(WindowManager $wm, TextView $this_apply, View it) {
        $wm.removeView((View)$this_apply);
    }

    private static final Unit Greeting$lambda$42$lambda$41$lambda$31$lambda$30(Context $context, MutableState $displayText$delegate) {
        String string;
        boolean contains$default;
        Object intent;
        String str;
        if (Settings.Secure.getString($context.getContentResolver(), "enabled_accessibility_services") == null) {
            string = "";
        }
        try {
            String packageName = $context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            if (!StringsKt.contains$default((CharSequence)string, (CharSequence)packageName, false, 2, 0)) {
            } else {
            }
            intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
            intent.setFlags(268435456);
            $context.startActivity(intent);
            MainActivityKt.Greeting$lambda$7($displayText$delegate, "Accessibility: Enable BadAccessibilityService!\nCapabilities: Keylogging, UI automation, credential theft");
            MainActivityKt.Greeting$lambda$7($displayText$delegate, "Accessibility: ENABLED!\nNow capturing: keystrokes, screen content, gestures\nCan: click buttons, fill forms, bypass prompts");
            String string2 = th.getMessage();
            StringBuilder append = new StringBuilder();
            append = append.append("Accessibility error: ");
            string2 = append.append(string2);
            string2 = string2.toString();
            MainActivityKt.Greeting$lambda$7($displayText$delegate, string2);
            return Unit.INSTANCE;
        }
    }

    private static final Unit Greeting$lambda$42$lambda$41$lambda$33$lambda$32(MutableState $displayText$delegate) {
        java.lang.Process exec;
        boolean bufferedReader;
        String text;
        java.nio.charset.Charset uTF_8;
        String string;
        Object inputStreamReader;
        String str;
        exec = Runtime.getRuntime().exec("id");
        java.io.InputStream inputStream = exec.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
        if (inputStreamReader instanceof BufferedReader) {
            try {
                bufferedReader = new BufferedReader((BufferedReader)(Reader)inputStreamReader, 8192);
                inputStreamReader = bufferedReader;
                exec.waitFor();
                StringBuilder stringBuilder = new StringBuilder();
                MainActivityKt.Greeting$lambda$7($displayText$delegate, stringBuilder.append("Exec: ").append(TextStreamsKt.readText((Reader)inputStreamReader)).toString());
                String string2 = th.getMessage();
                StringBuilder append = new StringBuilder();
                append = append.append("Exec error: ");
                string2 = append.append(string2);
                string2 = string2.toString();
                MainActivityKt.Greeting$lambda$7($displayText$delegate, string2);
                return Unit.INSTANCE;
            }
        } else {
        }
    }

    private static final Unit Greeting$lambda$42$lambda$41$lambda$35$lambda$34(Context $context, Function1 $requestPermissions, MutableState $displayText$delegate) {
        Object query;
        String[] strArr;
        int str;
        int count;
        ContentResolver contentResolver;
        Uri cONTENT_URI;
        String[] strArr2;
        int i;
        int i3;
        int i2;
        String str2 = "android.permission.READ_CALL_LOG";
        str = 1;
        count = 0;
        if (ContextCompat.checkSelfPermission($context, str2) == 0) {
            strArr2 = new String[2];
            strArr2[count] = "_id";
            strArr2[str] = "number";
            query = $context.getContentResolver().query(CallLog.Calls.CONTENT_URI, strArr2, 0, 0, 0);
            if (query != null) {
                count = query.getCount();
            }
            if (query != null) {
                query.close();
            }
            StringBuilder stringBuilder = new StringBuilder();
            MainActivityKt.Greeting$lambda$7($displayText$delegate, stringBuilder.append("Call Log Count: ").append(count).toString());
        } else {
            strArr = new String[str];
            strArr[count] = str2;
            $requestPermissions.invoke(strArr);
            MainActivityKt.Greeting$lambda$7($displayText$delegate, "Requesting Call Log permission...");
        }
        return Unit.INSTANCE;
    }

    private static final Unit Greeting$lambda$42$lambda$41$lambda$37$lambda$36(MutableState $displayText$delegate) {
        MainActivityKt.Greeting$lambda$7($displayText$delegate, "Boot: RECEIVE_BOOT_COMPLETED declared in manifest");
        return Unit.INSTANCE;
    }

    private static final Unit Greeting$lambda$42$lambda$41$lambda$40$lambda$39(Context $context, MutableState $displayText$delegate) {
        Intent intent;
        String str;
        int i;
        int i2;
        intent = new Intent();
        Intent intent2 = intent;
        i = 0;
        intent2.setClassName("com.android.settings", "com.android.settings.DeviceAdminSettings");
        intent2.setFlags(268435456);
        $context.startActivity(intent);
        MainActivityKt.Greeting$lambda$7($displayText$delegate, "DeviceAdmin: Settings opened");
        return Unit.INSTANCE;
    }

    private static final Unit Greeting$lambda$43(String string, Modifier modifier2, Function1 function13, int i4, int i5, Composer composer6, int i7) {
        MainActivityKt.Greeting(string, modifier2, function13, composer6, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
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
        int traceInProgress2;
        boolean skipping;
        boolean traceInProgress;
        String str;
        traceInProgress2 = -893745181;
        final Composer obj3 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj3, "C(GreetingPreview)541@23235L47:MainActivity.kt#3hk3sw");
        if ($changed == 0) {
            if (!obj3.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $changed, -1, "com.prototype.badboy.GreetingPreview (MainActivity.kt:540)");
                }
                ThemeKt.BadboyTheme(ComposableSingletons.MainActivityKt.INSTANCE.getLambda-15$app_debug(), obj3, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj3.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj3.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new MainActivityKt$$ExternalSyntheticLambda7($changed);
            endRestartGroup.updateScope(skipping);
        }
    }

    private static final Unit GreetingPreview$lambda$44(int i, Composer composer2, int i3) {
        MainActivityKt.GreetingPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }
}
