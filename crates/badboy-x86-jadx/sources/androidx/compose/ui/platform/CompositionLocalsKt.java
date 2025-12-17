package androidx.compose.ui.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.text.font.Font.ResourceLoader;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ô\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a0\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020?2\u0011\u0010L\u001a\r\u0012\u0004\u0012\u00020H0M¢\u0006\u0002\u0008NH\u0001¢\u0006\u0002\u0010O\u001a\u0010\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0002\"\u0019\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004\"$\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00018GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0007\u0010\u0008\u001a\u0004\u0008\t\u0010\u0004\"\"\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u00018GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000c\u0010\u0008\u001a\u0004\u0008\r\u0010\u0004\"\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0004\"\u0017\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0004\"\u0017\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0004\"\u0017\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00180\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0004\"\"\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u00018GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u001c\u0010\u0008\u001a\u0004\u0008\u001d\u0010\u0004\"\u0017\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0004\"\u0017\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\"0\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u0004\"\u0017\u0010$\u001a\u0008\u0012\u0004\u0012\u00020%0\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010\u0004\"\u0017\u0010'\u001a\u0008\u0012\u0004\u0012\u00020(0\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010\u0004\"\u001c\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u0004\"\u001a\u0010-\u001a\u0008\u0012\u0004\u0012\u00020.0\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u0010\u0004\"\u0017\u00100\u001a\u0008\u0012\u0004\u0012\u00020.018F¢\u0006\u0006\u001a\u0004\u00082\u00103\"\u0019\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u0010\u0004\"$\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080\u00018\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u00089\u0010\u0008\u001a\u0004\u0008:\u0010\u0004\"\u0017\u0010;\u001a\u0008\u0012\u0004\u0012\u00020<0\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008=\u0010\u0004\"\u0017\u0010>\u001a\u0008\u0012\u0004\u0012\u00020?0\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008@\u0010\u0004\"\u0017\u0010A\u001a\u0008\u0012\u0004\u0012\u00020B0\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008C\u0010\u0004\"\u0017\u0010D\u001a\u0008\u0012\u0004\u0012\u00020E0\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008F\u0010\u0004¨\u0006T", d2 = {"LocalAccessibilityManager", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/platform/AccessibilityManager;", "getLocalAccessibilityManager", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalAutofill", "Landroidx/compose/ui/autofill/Autofill;", "getLocalAutofill$annotations", "()V", "getLocalAutofill", "LocalAutofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getLocalAutofillTree$annotations", "getLocalAutofillTree", "LocalClipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getLocalClipboardManager", "LocalDensity", "Landroidx/compose/ui/unit/Density;", "getLocalDensity", "LocalFocusManager", "Landroidx/compose/ui/focus/FocusManager;", "getLocalFocusManager", "LocalFontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getLocalFontFamilyResolver", "LocalFontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getLocalFontLoader$annotations", "getLocalFontLoader", "LocalGraphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "getLocalGraphicsContext", "LocalHapticFeedback", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getLocalHapticFeedback", "LocalInputModeManager", "Landroidx/compose/ui/input/InputModeManager;", "getLocalInputModeManager", "LocalLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLocalLayoutDirection", "LocalPointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getLocalPointerIconService", "LocalProvidableScrollCaptureInProgress", "", "getLocalProvidableScrollCaptureInProgress", "LocalScrollCaptureInProgress", "Landroidx/compose/runtime/CompositionLocal;", "getLocalScrollCaptureInProgress", "()Landroidx/compose/runtime/CompositionLocal;", "LocalSoftwareKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "getLocalSoftwareKeyboardController", "LocalTextInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getLocalTextInputService$annotations", "getLocalTextInputService", "LocalTextToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getLocalTextToolbar", "LocalUriHandler", "Landroidx/compose/ui/platform/UriHandler;", "getLocalUriHandler", "LocalViewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getLocalViewConfiguration", "LocalWindowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getLocalWindowInfo", "ProvideCommonCompositionLocals", "", "owner", "Landroidx/compose/ui/node/Owner;", "uriHandler", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/node/Owner;Landroidx/compose/ui/platform/UriHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "noLocalProvidedFor", "", "name", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CompositionLocalsKt {

    private static final ProvidableCompositionLocal<androidx.compose.ui.platform.AccessibilityManager> LocalAccessibilityManager;
    private static final ProvidableCompositionLocal<Autofill> LocalAutofill;
    private static final ProvidableCompositionLocal<AutofillTree> LocalAutofillTree;
    private static final ProvidableCompositionLocal<androidx.compose.ui.platform.ClipboardManager> LocalClipboardManager;
    private static final ProvidableCompositionLocal<Density> LocalDensity;
    private static final ProvidableCompositionLocal<FocusManager> LocalFocusManager;
    private static final ProvidableCompositionLocal<FontFamily.Resolver> LocalFontFamilyResolver;
    private static final ProvidableCompositionLocal<Font.ResourceLoader> LocalFontLoader;
    private static final ProvidableCompositionLocal<GraphicsContext> LocalGraphicsContext;
    private static final ProvidableCompositionLocal<HapticFeedback> LocalHapticFeedback;
    private static final ProvidableCompositionLocal<InputModeManager> LocalInputModeManager;
    private static final ProvidableCompositionLocal<LayoutDirection> LocalLayoutDirection;
    private static final ProvidableCompositionLocal<PointerIconService> LocalPointerIconService;
    private static final ProvidableCompositionLocal<Boolean> LocalProvidableScrollCaptureInProgress;
    private static final ProvidableCompositionLocal<androidx.compose.ui.platform.SoftwareKeyboardController> LocalSoftwareKeyboardController;
    private static final ProvidableCompositionLocal<TextInputService> LocalTextInputService;
    private static final ProvidableCompositionLocal<androidx.compose.ui.platform.TextToolbar> LocalTextToolbar;
    private static final ProvidableCompositionLocal<androidx.compose.ui.platform.UriHandler> LocalUriHandler;
    private static final ProvidableCompositionLocal<androidx.compose.ui.platform.ViewConfiguration> LocalViewConfiguration;
    private static final ProvidableCompositionLocal<androidx.compose.ui.platform.WindowInfo> LocalWindowInfo;
    static {
        CompositionLocalsKt.LocalAccessibilityManager = CompositionLocalKt.staticCompositionLocalOf((Function0)CompositionLocalsKt.LocalAccessibilityManager.1.INSTANCE);
        CompositionLocalsKt.LocalAutofill = CompositionLocalKt.staticCompositionLocalOf((Function0)CompositionLocalsKt.LocalAutofill.1.INSTANCE);
        CompositionLocalsKt.LocalAutofillTree = CompositionLocalKt.staticCompositionLocalOf((Function0)CompositionLocalsKt.LocalAutofillTree.1.INSTANCE);
        CompositionLocalsKt.LocalClipboardManager = CompositionLocalKt.staticCompositionLocalOf((Function0)CompositionLocalsKt.LocalClipboardManager.1.INSTANCE);
        CompositionLocalsKt.LocalGraphicsContext = CompositionLocalKt.staticCompositionLocalOf((Function0)CompositionLocalsKt.LocalGraphicsContext.1.INSTANCE);
        CompositionLocalsKt.LocalDensity = CompositionLocalKt.staticCompositionLocalOf((Function0)CompositionLocalsKt.LocalDensity.1.INSTANCE);
        CompositionLocalsKt.LocalFocusManager = CompositionLocalKt.staticCompositionLocalOf((Function0)CompositionLocalsKt.LocalFocusManager.1.INSTANCE);
        CompositionLocalsKt.LocalFontLoader = CompositionLocalKt.staticCompositionLocalOf((Function0)CompositionLocalsKt.LocalFontLoader.1.INSTANCE);
        CompositionLocalsKt.LocalFontFamilyResolver = CompositionLocalKt.staticCompositionLocalOf((Function0)CompositionLocalsKt.LocalFontFamilyResolver.1.INSTANCE);
        CompositionLocalsKt.LocalHapticFeedback = CompositionLocalKt.staticCompositionLocalOf((Function0)CompositionLocalsKt.LocalHapticFeedback.1.INSTANCE);
        CompositionLocalsKt.LocalInputModeManager = CompositionLocalKt.staticCompositionLocalOf((Function0)CompositionLocalsKt.LocalInputModeManager.1.INSTANCE);
        CompositionLocalsKt.LocalLayoutDirection = CompositionLocalKt.staticCompositionLocalOf((Function0)CompositionLocalsKt.LocalLayoutDirection.1.INSTANCE);
        CompositionLocalsKt.LocalTextInputService = CompositionLocalKt.staticCompositionLocalOf((Function0)CompositionLocalsKt.LocalTextInputService.1.INSTANCE);
        CompositionLocalsKt.LocalSoftwareKeyboardController = CompositionLocalKt.staticCompositionLocalOf((Function0)CompositionLocalsKt.LocalSoftwareKeyboardController.1.INSTANCE);
        CompositionLocalsKt.LocalTextToolbar = CompositionLocalKt.staticCompositionLocalOf((Function0)CompositionLocalsKt.LocalTextToolbar.1.INSTANCE);
        CompositionLocalsKt.LocalUriHandler = CompositionLocalKt.staticCompositionLocalOf((Function0)CompositionLocalsKt.LocalUriHandler.1.INSTANCE);
        CompositionLocalsKt.LocalViewConfiguration = CompositionLocalKt.staticCompositionLocalOf((Function0)CompositionLocalsKt.LocalViewConfiguration.1.INSTANCE);
        CompositionLocalsKt.LocalWindowInfo = CompositionLocalKt.staticCompositionLocalOf((Function0)CompositionLocalsKt.LocalWindowInfo.1.INSTANCE);
        CompositionLocalsKt.LocalPointerIconService = CompositionLocalKt.staticCompositionLocalOf((Function0)CompositionLocalsKt.LocalPointerIconService.1.INSTANCE);
        final int i2 = 0;
        CompositionLocalsKt.LocalProvidableScrollCaptureInProgress = CompositionLocalKt.compositionLocalOf$default(i2, (Function0)CompositionLocalsKt.LocalProvidableScrollCaptureInProgress.1.INSTANCE, 1, i2);
    }

    public static final void ProvideCommonCompositionLocals(Owner owner, androidx.compose.ui.platform.UriHandler uriHandler, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress2;
        int $dirty;
        int i2;
        boolean changedInstance2;
        int i;
        int i3;
        int skipping;
        boolean traceInProgress;
        boolean changedInstance;
        int i4;
        int density;
        int autofillTree;
        traceInProgress2 = 874662829;
        final Composer obj10 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj10, "C(ProvideCommonCompositionLocals)P(1,2)215@7394L1256:CompositionLocals.kt#itgzvw");
        i4 = 4;
        density = 2;
        if ($changed & 6 == 0) {
            if ($changed & 8 == 0) {
                changedInstance = obj10.changed(owner);
            } else {
                changedInstance = obj10.changedInstance(owner);
            }
            i2 = changedInstance != null ? i4 : density;
            $dirty |= i2;
        }
        final int i23 = 16;
        if ($changed & 48 == 0) {
            if ($changed & 64 == 0) {
                changedInstance2 = obj10.changed(uriHandler);
            } else {
                changedInstance2 = obj10.changedInstance(uriHandler);
            }
            i = changedInstance2 ? 32 : i23;
            $dirty |= i;
        }
        if ($changed & 384 == 0) {
            i3 = obj10.changedInstance(content) ? 256 : 128;
            $dirty |= i3;
        }
        if ($dirty & 147 == 146) {
            if (!obj10.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.ui.platform.ProvideCommonCompositionLocals (CompositionLocals.kt:214)");
                }
                ProvidedValue[] arr = new ProvidedValue[19];
                arr[density] = CompositionLocalsKt.LocalAutofillTree.provides(owner.getAutofillTree());
                arr[3] = CompositionLocalsKt.LocalClipboardManager.provides(owner.getClipboardManager());
                arr[i4] = CompositionLocalsKt.LocalDensity.provides(owner.getDensity());
                arr[5] = CompositionLocalsKt.LocalFocusManager.provides(owner.getFocusOwner());
                arr[6] = CompositionLocalsKt.LocalFontLoader.providesDefault(owner.getFontLoader());
                arr[7] = CompositionLocalsKt.LocalFontFamilyResolver.providesDefault(owner.getFontFamilyResolver());
                arr[8] = CompositionLocalsKt.LocalHapticFeedback.provides(owner.getHapticFeedBack());
                arr[9] = CompositionLocalsKt.LocalInputModeManager.provides(owner.getInputModeManager());
                arr[10] = CompositionLocalsKt.LocalLayoutDirection.provides(owner.getLayoutDirection());
                arr[11] = CompositionLocalsKt.LocalTextInputService.provides(owner.getTextInputService());
                arr[12] = CompositionLocalsKt.LocalSoftwareKeyboardController.provides(owner.getSoftwareKeyboardController());
                arr[13] = CompositionLocalsKt.LocalTextToolbar.provides(owner.getTextToolbar());
                arr[14] = CompositionLocalsKt.LocalUriHandler.provides(uriHandler);
                arr[15] = CompositionLocalsKt.LocalViewConfiguration.provides(owner.getViewConfiguration());
                arr[i23] = CompositionLocalsKt.LocalWindowInfo.provides(owner.getWindowInfo());
                arr[17] = CompositionLocalsKt.LocalPointerIconService.provides(owner.getPointerIconService());
                arr[18] = CompositionLocalsKt.LocalGraphicsContext.provides(owner.getGraphicsContext());
                CompositionLocalKt.CompositionLocalProvider(arr, content, obj10, $stable |= i4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj10.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj10.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new CompositionLocalsKt.ProvideCommonCompositionLocals.1(owner, uriHandler, content, $changed);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    public static final Void access$noLocalProvidedFor(String name) {
        return CompositionLocalsKt.noLocalProvidedFor(name);
    }

    public static final ProvidableCompositionLocal<androidx.compose.ui.platform.AccessibilityManager> getLocalAccessibilityManager() {
        return CompositionLocalsKt.LocalAccessibilityManager;
    }

    public static final ProvidableCompositionLocal<Autofill> getLocalAutofill() {
        return CompositionLocalsKt.LocalAutofill;
    }

    public static void getLocalAutofill$annotations() {
    }

    public static final ProvidableCompositionLocal<AutofillTree> getLocalAutofillTree() {
        return CompositionLocalsKt.LocalAutofillTree;
    }

    public static void getLocalAutofillTree$annotations() {
    }

    public static final ProvidableCompositionLocal<androidx.compose.ui.platform.ClipboardManager> getLocalClipboardManager() {
        return CompositionLocalsKt.LocalClipboardManager;
    }

    public static final ProvidableCompositionLocal<Density> getLocalDensity() {
        return CompositionLocalsKt.LocalDensity;
    }

    public static final ProvidableCompositionLocal<FocusManager> getLocalFocusManager() {
        return CompositionLocalsKt.LocalFocusManager;
    }

    public static final ProvidableCompositionLocal<FontFamily.Resolver> getLocalFontFamilyResolver() {
        return CompositionLocalsKt.LocalFontFamilyResolver;
    }

    public static final ProvidableCompositionLocal<Font.ResourceLoader> getLocalFontLoader() {
        return CompositionLocalsKt.LocalFontLoader;
    }

    @Deprecated(message = "LocalFontLoader is replaced with LocalFontFamilyResolver", replaceWith = @ReplaceWith(...))
    public static void getLocalFontLoader$annotations() {
    }

    public static final ProvidableCompositionLocal<GraphicsContext> getLocalGraphicsContext() {
        return CompositionLocalsKt.LocalGraphicsContext;
    }

    public static final ProvidableCompositionLocal<HapticFeedback> getLocalHapticFeedback() {
        return CompositionLocalsKt.LocalHapticFeedback;
    }

    public static final ProvidableCompositionLocal<InputModeManager> getLocalInputModeManager() {
        return CompositionLocalsKt.LocalInputModeManager;
    }

    public static final ProvidableCompositionLocal<LayoutDirection> getLocalLayoutDirection() {
        return CompositionLocalsKt.LocalLayoutDirection;
    }

    public static final ProvidableCompositionLocal<PointerIconService> getLocalPointerIconService() {
        return CompositionLocalsKt.LocalPointerIconService;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalProvidableScrollCaptureInProgress() {
        return CompositionLocalsKt.LocalProvidableScrollCaptureInProgress;
    }

    public static final CompositionLocal<Boolean> getLocalScrollCaptureInProgress() {
        return (CompositionLocal)CompositionLocalsKt.LocalProvidableScrollCaptureInProgress;
    }

    public static final ProvidableCompositionLocal<androidx.compose.ui.platform.SoftwareKeyboardController> getLocalSoftwareKeyboardController() {
        return CompositionLocalsKt.LocalSoftwareKeyboardController;
    }

    public static final ProvidableCompositionLocal<TextInputService> getLocalTextInputService() {
        return CompositionLocalsKt.LocalTextInputService;
    }

    @Deprecated(message = "Use PlatformTextInputModifierNode instead.")
    public static void getLocalTextInputService$annotations() {
    }

    public static final ProvidableCompositionLocal<androidx.compose.ui.platform.TextToolbar> getLocalTextToolbar() {
        return CompositionLocalsKt.LocalTextToolbar;
    }

    public static final ProvidableCompositionLocal<androidx.compose.ui.platform.UriHandler> getLocalUriHandler() {
        return CompositionLocalsKt.LocalUriHandler;
    }

    public static final ProvidableCompositionLocal<androidx.compose.ui.platform.ViewConfiguration> getLocalViewConfiguration() {
        return CompositionLocalsKt.LocalViewConfiguration;
    }

    public static final ProvidableCompositionLocal<androidx.compose.ui.platform.WindowInfo> getLocalWindowInfo() {
        return CompositionLocalsKt.LocalWindowInfo;
    }

    private static final Void noLocalProvidedFor(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("CompositionLocal ").append(name).append(" not present").toString().toString());
        throw illegalStateException;
    }
}
