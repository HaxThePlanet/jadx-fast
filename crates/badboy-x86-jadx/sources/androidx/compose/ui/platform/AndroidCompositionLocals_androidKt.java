package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.res.ImageVectorCache;
import androidx.compose.ui.res.ResourceIdCache;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0007\u001a(\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u001a0\u001e¢\u0006\u0002\u0008\u001fH\u0001¢\u0006\u0002\u0010 \u001a\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002\u001a\u001f\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u00062\u0008\u0010'\u001a\u0004\u0018\u00010\u0002H\u0003¢\u0006\u0002\u0010(\u001a\u0015\u0010)\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0006H\u0003¢\u0006\u0002\u0010*\"\u0017\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0004\"\u001a\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0004\" \u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00018FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000f\u0010\u0004\"\u001a\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0004\"\u0017\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0004\"\u0017\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0004¨\u0006+²\u0006\n\u0010'\u001a\u00020\u0002X\u008a\u008e\u0002", d2 = {"LocalConfiguration", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroid/content/res/Configuration;", "getLocalConfiguration", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalContext", "Landroid/content/Context;", "getLocalContext", "LocalImageVectorCache", "Landroidx/compose/ui/res/ImageVectorCache;", "getLocalImageVectorCache", "LocalLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getLocalLifecycleOwner$annotations", "()V", "getLocalLifecycleOwner", "LocalResourceIdCache", "Landroidx/compose/ui/res/ResourceIdCache;", "getLocalResourceIdCache", "LocalSavedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "getLocalSavedStateRegistryOwner", "LocalView", "Landroid/view/View;", "getLocalView", "ProvideAndroidCompositionLocals", "", "owner", "Landroidx/compose/ui/platform/AndroidComposeView;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "noLocalProvidedFor", "", "name", "", "obtainImageVectorCache", "context", "configuration", "(Landroid/content/Context;Landroid/content/res/Configuration;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/res/ImageVectorCache;", "obtainResourceIdCache", "(Landroid/content/Context;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/res/ResourceIdCache;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidCompositionLocals_androidKt {

    private static final ProvidableCompositionLocal<Configuration> LocalConfiguration;
    private static final ProvidableCompositionLocal<Context> LocalContext;
    private static final ProvidableCompositionLocal<ImageVectorCache> LocalImageVectorCache;
    private static final ProvidableCompositionLocal<ResourceIdCache> LocalResourceIdCache;
    private static final ProvidableCompositionLocal<SavedStateRegistryOwner> LocalSavedStateRegistryOwner;
    private static final ProvidableCompositionLocal<View> LocalView;
    static {
        final int i2 = 0;
        AndroidCompositionLocals_androidKt.LocalConfiguration = CompositionLocalKt.compositionLocalOf$default(i2, (Function0)AndroidCompositionLocals_androidKt.LocalConfiguration.1.INSTANCE, 1, i2);
        AndroidCompositionLocals_androidKt.LocalContext = CompositionLocalKt.staticCompositionLocalOf((Function0)AndroidCompositionLocals_androidKt.LocalContext.1.INSTANCE);
        AndroidCompositionLocals_androidKt.LocalImageVectorCache = CompositionLocalKt.staticCompositionLocalOf((Function0)AndroidCompositionLocals_androidKt.LocalImageVectorCache.1.INSTANCE);
        AndroidCompositionLocals_androidKt.LocalResourceIdCache = CompositionLocalKt.staticCompositionLocalOf((Function0)AndroidCompositionLocals_androidKt.LocalResourceIdCache.1.INSTANCE);
        AndroidCompositionLocals_androidKt.LocalSavedStateRegistryOwner = CompositionLocalKt.staticCompositionLocalOf((Function0)AndroidCompositionLocals_androidKt.LocalSavedStateRegistryOwner.1.INSTANCE);
        AndroidCompositionLocals_androidKt.LocalView = CompositionLocalKt.staticCompositionLocalOf((Function0)AndroidCompositionLocals_androidKt.LocalView.1.INSTANCE);
    }

    public static final void ProvideAndroidCompositionLocals(androidx.compose.ui.platform.AndroidComposeView owner, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int view;
        Object configuration$delegate2;
        int $dirty;
        int i6;
        int i;
        int skipping;
        boolean traceInProgress;
        Object mutableStateOf$default;
        Object invalid$iv;
        int viewTreeOwners;
        int str;
        boolean traceInProgress2;
        ResourceIdCache resourceIdCache;
        ProvidedValue[] arr;
        Object empty4;
        Object empty2;
        int i5;
        Object anon2;
        Object androidUriHandler;
        Object empty3;
        int i3;
        Object empty;
        Object empty5;
        Object anon;
        int i7;
        Object view2;
        int i2;
        Object configuration$delegate;
        int i8;
        int i4;
        int obj23;
        final Object obj = owner;
        final Object obj2 = content;
        final int i9 = $changed;
        configuration$delegate2 = 1396852028;
        Composer restartGroup = $composer.startRestartGroup(configuration$delegate2);
        ComposerKt.sourceInformation(restartGroup, "C(ProvideAndroidCompositionLocals)P(1)96@3347L87,100@3476L37,102@3536L39,107@3776L102,110@3906L81,110@3883L104,116@4016L46,117@4089L30,119@4191L7,130@4811L151,120@4236L726:AndroidCompositionLocals.android.kt#itgzvw");
        if (i9 & 6 == 0) {
            i6 = restartGroup.changedInstance(obj) ? 4 : 2;
            $dirty |= i6;
        }
        if (i9 & 48 == 0) {
            i = restartGroup.changedInstance(obj2) ? 32 : 16;
            $dirty |= i;
        }
        if ($dirty & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(configuration$delegate2, $dirty, -1, "androidx.compose.ui.platform.ProvideAndroidCompositionLocals (AndroidCompositionLocals.android.kt:91)");
                }
                view = owner;
                skipping = view.getContext();
                String str5 = "CC(remember):AndroidCompositionLocals.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1970600807, str5);
                int i16 = 0;
                Composer composer4 = restartGroup;
                int i25 = 0;
                Object rememberedValue4 = composer4.rememberedValue();
                int i33 = 0;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    obj23 = 4;
                    Configuration configuration2 = new Configuration(skipping.getResources().getConfiguration());
                    viewTreeOwners = 0;
                    view2 = view;
                    composer4.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(configuration2, viewTreeOwners, 2, viewTreeOwners));
                } else {
                    view2 = view;
                    obj23 = 4;
                    mutableStateOf$default = rememberedValue4;
                }
                Object obj3 = mutableStateOf$default;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1970596729, str5);
                int i12 = 0;
                Composer composer = restartGroup;
                int i17 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i26 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty4 = 0;
                    anon2 = new AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals.1.1((MutableState)obj3);
                    composer.updateRememberedValue((Function1)anon2);
                } else {
                    anon2 = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                obj.setConfigurationChangeObserver((Function1)anon2);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1970594807, str5);
                int i14 = 0;
                Composer composer2 = restartGroup;
                int i18 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                int i27 = 0;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    empty2 = 0;
                    androidUriHandler = new AndroidUriHandler(skipping);
                    composer2.updateRememberedValue(androidUriHandler);
                } else {
                    androidUriHandler = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                viewTreeOwners = obj.getViewTreeOwners();
                if (viewTreeOwners == null) {
                } else {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1970587064, str5);
                    int i20 = 0;
                    Composer composer5 = restartGroup;
                    int i28 = 0;
                    Object rememberedValue5 = composer5.rememberedValue();
                    empty3 = 0;
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        empty5 = 0;
                        configuration$delegate = obj3;
                        i8 = $dirty;
                        composer5.updateRememberedValue(DisposableSaveableStateRegistry_androidKt.DisposableSaveableStateRegistry((View)view2, viewTreeOwners.getSavedStateRegistryOwner()));
                    } else {
                        configuration$delegate = obj3;
                        i8 = $dirty;
                        configuration$delegate2 = rememberedValue5;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1970582925, str5);
                    Composer composer3 = restartGroup;
                    int i24 = 0;
                    Object rememberedValue3 = composer3.rememberedValue();
                    int i30 = 0;
                    if (!restartGroup.changedInstance((DisposableSaveableStateRegistry)configuration$delegate2)) {
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            empty3 = 0;
                            anon = new AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals.2.1(configuration$delegate2);
                            composer3.updateRememberedValue((Function1)anon);
                        } else {
                            anon = rememberedValue3;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i22 = 6;
                    EffectsKt.DisposableEffect(Unit.INSTANCE, (Function1)anon, restartGroup, i22);
                    int i23 = 0;
                    int i31 = 0;
                    int i34 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    arr = new ProvidedValue[9];
                    arr[i23] = AndroidCompositionLocals_androidKt.LocalConfiguration.provides(AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals$lambda$1(configuration$delegate));
                    int i32 = 1;
                    arr[i32] = AndroidCompositionLocals_androidKt.LocalContext.provides(skipping);
                    arr[2] = LocalLifecycleOwnerKt.getLocalLifecycleOwner().provides(viewTreeOwners.getLifecycleOwner());
                    arr[3] = AndroidCompositionLocals_androidKt.LocalSavedStateRegistryOwner.provides(viewTreeOwners.getSavedStateRegistryOwner());
                    arr[obj23] = SaveableStateRegistryKt.getLocalSaveableStateRegistry().provides(configuration$delegate2);
                    arr[5] = AndroidCompositionLocals_androidKt.LocalView.provides(obj.getView());
                    arr[i22] = AndroidCompositionLocals_androidKt.LocalImageVectorCache.provides(AndroidCompositionLocals_androidKt.obtainImageVectorCache(skipping, AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals$lambda$1(configuration$delegate), restartGroup, i23));
                    arr[7] = AndroidCompositionLocals_androidKt.LocalResourceIdCache.provides(AndroidCompositionLocals_androidKt.obtainResourceIdCache(skipping, restartGroup, i23));
                    arr[8] = CompositionLocalsKt.getLocalProvidableScrollCaptureInProgress().provides(Boolean.valueOf(booleanValue |= scrollCaptureInProgress$ui_release));
                    AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals.3 anon3 = new AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals.3(obj, (AndroidUriHandler)androidUriHandler, obj2);
                    CompositionLocalKt.CompositionLocalProvider(arr, (Function2)ComposableLambdaKt.rememberComposableLambda(1471621628, i32, anon3, restartGroup, 54), restartGroup, $stable |= 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        $dirty = new AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals.4(obj, obj2, i9);
                        endRestartGroup.updateScope((Function2)$dirty);
                    }
                }
            } else {
                restartGroup.skipToGroupEnd();
                i8 = $dirty;
            }
        } else {
        }
        Object obj4 = obj3;
        int i40 = $dirty;
        IllegalStateException configuration$delegate3 = new IllegalStateException("Called when the ViewTreeOwnersAvailability is not yet in Available state");
        throw configuration$delegate3;
    }

    private static final Configuration ProvideAndroidCompositionLocals$lambda$1(MutableState<Configuration> $configuration$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Configuration)(State)$configuration$delegate.getValue();
    }

    private static final void ProvideAndroidCompositionLocals$lambda$2(MutableState<Configuration> $configuration$delegate, Configuration value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $configuration$delegate.setValue(value);
    }

    public static final void access$ProvideAndroidCompositionLocals$lambda$2(MutableState $configuration$delegate, Configuration value) {
        AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals$lambda$2($configuration$delegate, value);
    }

    public static final Void access$noLocalProvidedFor(String name) {
        return AndroidCompositionLocals_androidKt.noLocalProvidedFor(name);
    }

    public static final ProvidableCompositionLocal<Configuration> getLocalConfiguration() {
        return AndroidCompositionLocals_androidKt.LocalConfiguration;
    }

    public static final ProvidableCompositionLocal<Context> getLocalContext() {
        return AndroidCompositionLocals_androidKt.LocalContext;
    }

    public static final ProvidableCompositionLocal<ImageVectorCache> getLocalImageVectorCache() {
        return AndroidCompositionLocals_androidKt.LocalImageVectorCache;
    }

    public static final ProvidableCompositionLocal<LifecycleOwner> getLocalLifecycleOwner() {
        return LocalLifecycleOwnerKt.getLocalLifecycleOwner();
    }

    @Deprecated(message = "Moved to lifecycle-runtime-compose library in androidx.lifecycle.compose package.", replaceWith = @ReplaceWith(...))
    public static void getLocalLifecycleOwner$annotations() {
    }

    public static final ProvidableCompositionLocal<ResourceIdCache> getLocalResourceIdCache() {
        return AndroidCompositionLocals_androidKt.LocalResourceIdCache;
    }

    public static final ProvidableCompositionLocal<SavedStateRegistryOwner> getLocalSavedStateRegistryOwner() {
        return AndroidCompositionLocals_androidKt.LocalSavedStateRegistryOwner;
    }

    public static final ProvidableCompositionLocal<View> getLocalView() {
        return AndroidCompositionLocals_androidKt.LocalView;
    }

    private static final Void noLocalProvidedFor(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("CompositionLocal ").append(name).append(" not present").toString().toString());
        throw illegalStateException;
    }

    private static final ImageVectorCache obtainImageVectorCache(Context context, Configuration configuration, Composer $composer, int $changed) {
        int traceInProgress;
        String str;
        int i2;
        int empty;
        Object imageVectorCache;
        int empty3;
        Object configuration2;
        int empty2;
        Configuration configuration4;
        Object anon2;
        Object anon;
        int i3;
        Configuration configuration3;
        int i;
        final Object obj = context;
        final Composer composer = $composer;
        int i4 = -485908294;
        ComposerKt.sourceInformationMarkerStart(composer, i4, "C(obtainImageVectorCache)P(1)173@5952L31,174@6030L88,177@6139L557,194@6736L189,194@6701L224:AndroidCompositionLocals.android.kt#itgzvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.compose.ui.platform.obtainImageVectorCache (AndroidCompositionLocals.android.kt:172)");
        } else {
            i2 = $changed;
        }
        String str3 = "CC(remember):AndroidCompositionLocals.android.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer, 674256202, str3);
        int i6 = 0;
        Composer composer2 = $composer;
        int i10 = 0;
        Object rememberedValue = composer2.rememberedValue();
        int i15 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            empty = 0;
            imageVectorCache = new ImageVectorCache();
            composer2.updateRememberedValue(imageVectorCache);
        } else {
            imageVectorCache = rememberedValue;
        }
        ImageVectorCache invalid$iv = imageVectorCache;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 674258755, str3);
        int i9 = 0;
        Composer composer3 = $composer;
        int i13 = 0;
        Object rememberedValue2 = composer3.rememberedValue();
        int i18 = 0;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            empty3 = 0;
            configuration2 = new Configuration();
            i3 = 0;
            if (configuration != null) {
                i = 0;
                configuration2.setTo(configuration);
            }
            composer3.updateRememberedValue(configuration2);
        } else {
            configuration2 = rememberedValue2;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 674262712, str3);
        int i12 = 0;
        Composer composer4 = $composer;
        int i16 = 0;
        Object rememberedValue3 = composer4.rememberedValue();
        int i19 = 0;
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            empty2 = 0;
            anon2 = new AndroidCompositionLocals_androidKt.obtainImageVectorCache.callbacks.1.1((Configuration)configuration2, (ImageVectorCache)invalid$iv);
            composer4.updateRememberedValue(anon2);
        } else {
            anon2 = rememberedValue3;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 674281448, str3);
        Composer composer5 = $composer;
        int i17 = 0;
        Object rememberedValue4 = composer5.rememberedValue();
        int i20 = 0;
        if (!composer.changedInstance(obj)) {
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                empty2 = 0;
                anon = new AndroidCompositionLocals_androidKt.obtainImageVectorCache.1.1(obj, (AndroidCompositionLocals_androidKt.obtainImageVectorCache.callbacks.1.1)anon2);
                composer5.updateRememberedValue((Function1)anon);
            } else {
                anon = rememberedValue4;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(invalid$iv, (Function1)anon, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return invalid$iv;
    }

    private static final ResourceIdCache obtainResourceIdCache(Context context, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int empty2;
        Object resourceIdCache;
        int empty;
        Object anon2;
        Object anon;
        int i = -1348507246;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(obtainResourceIdCache)142@5083L30,143@5134L398,158@5571L189,158@5537L223:AndroidCompositionLocals.android.kt#itgzvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.ui.platform.obtainResourceIdCache (AndroidCompositionLocals.android.kt:141)");
        }
        String str3 = "CC(remember):AndroidCompositionLocals.android.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, 1144662288, str3);
        int i3 = 0;
        Composer composer = $composer;
        int i7 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i11 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            empty2 = 0;
            resourceIdCache = new ResourceIdCache();
            composer.updateRememberedValue(resourceIdCache);
        } else {
            resourceIdCache = rememberedValue;
        }
        ResourceIdCache invalid$iv = resourceIdCache;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 1144664288, str3);
        int i6 = 0;
        Composer composer2 = $composer;
        int i9 = 0;
        Object rememberedValue2 = composer2.rememberedValue();
        int i12 = 0;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            empty = 0;
            anon2 = new AndroidCompositionLocals_androidKt.obtainResourceIdCache.callbacks.1.1((ResourceIdCache)invalid$iv);
            composer2.updateRememberedValue(anon2);
        } else {
            anon2 = rememberedValue2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 1144678063, str3);
        Composer composer3 = $composer;
        int i10 = 0;
        Object rememberedValue3 = composer3.rememberedValue();
        int i13 = 0;
        if (!$composer.changedInstance(context)) {
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new AndroidCompositionLocals_androidKt.obtainResourceIdCache.1.1(context, (AndroidCompositionLocals_androidKt.obtainResourceIdCache.callbacks.1.1)anon2);
                composer3.updateRememberedValue((Function1)anon);
            } else {
                anon = rememberedValue3;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.DisposableEffect(invalid$iv, (Function1)anon, $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return invalid$iv;
    }
}
