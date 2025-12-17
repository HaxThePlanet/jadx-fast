package androidx.compose.foundation.layout;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import androidx.compose.ui.R.id;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat.Type;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0010\u0002\n\u0002\u0008\u0008\u0008\u0000\u0018\u0000 E2\u00020\u0001:\u0001EB\u0019\u0008\u0002\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010=\u001a\u00020>2\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010?\u001a\u00020>2\u0006\u0010\u0004\u001a\u00020\u0005J\u0018\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u00020\u00032\u0008\u0008\u0002\u0010B\u001a\u00020\u0008J\u000e\u0010C\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0003J\u000e\u0010D\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0003R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u000cR\u0011\u0010\u0017\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u000cR\u0011\u0010\u0019\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0010R\u0011\u0010\u001b\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0010R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u000cR\u0011\u0010!\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u000cR\u0011\u0010#\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u0010R\u0011\u0010%\u001a\u00020&¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u0011\u0010)\u001a\u00020&¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010(R\u0011\u0010+\u001a\u00020&¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010(R\u0011\u0010-\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010\u000cR\u0011\u0010/\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u0010\u0010R\u0011\u00101\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u0010\u000cR\u0011\u00103\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u0010\u0010R\u0011\u00105\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u0010\u000cR\u0011\u00107\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u0010\u000cR\u0011\u00109\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u0010\u0010R\u0011\u0010;\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008<\u0010\u0010¨\u0006F", d2 = {"Landroidx/compose/foundation/layout/WindowInsetsHolder;", "", "insets", "Landroidx/core/view/WindowInsetsCompat;", "view", "Landroid/view/View;", "(Landroidx/core/view/WindowInsetsCompat;Landroid/view/View;)V", "accessCount", "", "captionBar", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "getCaptionBar", "()Landroidx/compose/foundation/layout/AndroidWindowInsets;", "captionBarIgnoringVisibility", "Landroidx/compose/foundation/layout/ValueInsets;", "getCaptionBarIgnoringVisibility", "()Landroidx/compose/foundation/layout/ValueInsets;", "consumes", "", "getConsumes", "()Z", "displayCutout", "getDisplayCutout", "ime", "getIme", "imeAnimationSource", "getImeAnimationSource", "imeAnimationTarget", "getImeAnimationTarget", "insetsListener", "Landroidx/compose/foundation/layout/InsetsListener;", "mandatorySystemGestures", "getMandatorySystemGestures", "navigationBars", "getNavigationBars", "navigationBarsIgnoringVisibility", "getNavigationBarsIgnoringVisibility", "safeContent", "Landroidx/compose/foundation/layout/WindowInsets;", "getSafeContent", "()Landroidx/compose/foundation/layout/WindowInsets;", "safeDrawing", "getSafeDrawing", "safeGestures", "getSafeGestures", "statusBars", "getStatusBars", "statusBarsIgnoringVisibility", "getStatusBarsIgnoringVisibility", "systemBars", "getSystemBars", "systemBarsIgnoringVisibility", "getSystemBarsIgnoringVisibility", "systemGestures", "getSystemGestures", "tappableElement", "getTappableElement", "tappableElementIgnoringVisibility", "getTappableElementIgnoringVisibility", "waterfall", "getWaterfall", "decrementAccessors", "", "incrementAccessors", "update", "windowInsets", "types", "updateImeAnimationSource", "updateImeAnimationTarget", "Companion", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WindowInsetsHolder {

    public static final int $stable = 8;
    public static final androidx.compose.foundation.layout.WindowInsetsHolder.Companion Companion;
    private static boolean testInsets;
    private static final WeakHashMap<View, androidx.compose.foundation.layout.WindowInsetsHolder> viewMap;
    private int accessCount;
    private final androidx.compose.foundation.layout.AndroidWindowInsets captionBar;
    private final androidx.compose.foundation.layout.ValueInsets captionBarIgnoringVisibility;
    private final boolean consumes;
    private final androidx.compose.foundation.layout.AndroidWindowInsets displayCutout;
    private final androidx.compose.foundation.layout.AndroidWindowInsets ime;
    private final androidx.compose.foundation.layout.ValueInsets imeAnimationSource;
    private final androidx.compose.foundation.layout.ValueInsets imeAnimationTarget;
    private final androidx.compose.foundation.layout.InsetsListener insetsListener;
    private final androidx.compose.foundation.layout.AndroidWindowInsets mandatorySystemGestures;
    private final androidx.compose.foundation.layout.AndroidWindowInsets navigationBars;
    private final androidx.compose.foundation.layout.ValueInsets navigationBarsIgnoringVisibility;
    private final androidx.compose.foundation.layout.WindowInsets safeContent;
    private final androidx.compose.foundation.layout.WindowInsets safeDrawing;
    private final androidx.compose.foundation.layout.WindowInsets safeGestures;
    private final androidx.compose.foundation.layout.AndroidWindowInsets statusBars;
    private final androidx.compose.foundation.layout.ValueInsets statusBarsIgnoringVisibility;
    private final androidx.compose.foundation.layout.AndroidWindowInsets systemBars;
    private final androidx.compose.foundation.layout.ValueInsets systemBarsIgnoringVisibility;
    private final androidx.compose.foundation.layout.AndroidWindowInsets systemGestures;
    private final androidx.compose.foundation.layout.AndroidWindowInsets tappableElement;
    private final androidx.compose.foundation.layout.ValueInsets tappableElementIgnoringVisibility;
    private final androidx.compose.foundation.layout.ValueInsets waterfall;

    @Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\t\u001a\u00020\u0008H\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007J\"\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\"\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Landroidx/compose/foundation/layout/WindowInsetsHolder$Companion;", "", "()V", "testInsets", "", "viewMap", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "Landroidx/compose/foundation/layout/WindowInsetsHolder;", "current", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsetsHolder;", "getOrCreateFor", "view", "setUseTestInsets", "", "systemInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "windowInsets", "Landroidx/core/view/WindowInsetsCompat;", "type", "", "name", "", "valueInsetsIgnoringVisibility", "Landroidx/compose/foundation/layout/ValueInsets;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static final androidx.compose.foundation.layout.AndroidWindowInsets access$systemInsets(androidx.compose.foundation.layout.WindowInsetsHolder.Companion $this, WindowInsetsCompat windowInsets, int type, String name) {
            return $this.systemInsets(windowInsets, type, name);
        }

        public static final androidx.compose.foundation.layout.ValueInsets access$valueInsetsIgnoringVisibility(androidx.compose.foundation.layout.WindowInsetsHolder.Companion $this, WindowInsetsCompat windowInsets, int type, String name) {
            return $this.valueInsetsIgnoringVisibility(windowInsets, type, name);
        }

        private final androidx.compose.foundation.layout.WindowInsetsHolder getOrCreateFor(View view) {
            int i2;
            int i;
            Object windowInsetsHolder;
            int i3;
            final WeakHashMap map = WindowInsetsHolder.access$getViewMap$cp();
            final int i4 = 0;
            final WeakHashMap map2 = WindowInsetsHolder.access$getViewMap$cp();
            final int i5 = 0;
            final Object obj = (Map)map2.get(view);
            synchronized (map) {
                i2 = 0;
                windowInsetsHolder = new WindowInsetsHolder(0, view, 0);
                map2.put(view, windowInsetsHolder);
                return (WindowInsetsHolder)windowInsetsHolder;
            }
        }

        private final androidx.compose.foundation.layout.AndroidWindowInsets systemInsets(WindowInsetsCompat windowInsets, int type, String name) {
            WindowInsetsCompat windowInsetsCompat;
            int i;
            AndroidWindowInsets androidWindowInsets = new AndroidWindowInsets(type, name);
            final int i2 = 0;
            if (windowInsets != null) {
                i = 0;
                androidWindowInsets.update$foundation_layout_release(windowInsets, type);
            }
            return androidWindowInsets;
        }

        private final androidx.compose.foundation.layout.ValueInsets valueInsetsIgnoringVisibility(WindowInsetsCompat windowInsets, int type, String name) {
            Insets insetsIgnoringVisibility;
            if (windowInsets != null) {
                if (windowInsets.getInsetsIgnoringVisibility(type) == null) {
                    insetsIgnoringVisibility = Insets.NONE;
                }
            } else {
            }
            return WindowInsets_androidKt.ValueInsets(insetsIgnoringVisibility, name);
        }

        public final androidx.compose.foundation.layout.WindowInsetsHolder current(Composer $composer, int $changed) {
            boolean traceInProgress;
            String str;
            Object empty;
            Object anon;
            int i = -1366542614;
            ComposerKt.sourceInformationMarkerStart($composer, i, "C(current)627@22834L7,630@22926L161,630@22901L186:WindowInsets.android.kt#2w3rfo");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.WindowInsetsHolder.Companion.current (WindowInsets.android.kt:626)");
            }
            int i2 = 0;
            int i3 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            ComposerKt.sourceInformationMarkerEnd($composer);
            Object this_$iv = consume;
            androidx.compose.foundation.layout.WindowInsetsHolder orCreateFor = getOrCreateFor((View)this_$iv);
            ComposerKt.sourceInformationMarkerStart($composer, 334587174, "CC(remember):WindowInsets.android.kt#9igjgp");
            Composer composer = $composer;
            int i8 = 0;
            final Object rememberedValue = composer.rememberedValue();
            final int i9 = 0;
            if (changedInstance |= changedInstance2 == 0) {
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty = 0;
                    anon = new WindowInsetsHolder.Companion.current.1.1(orCreateFor, this_$iv);
                    composer.updateRememberedValue((Function1)anon);
                } else {
                    anon = rememberedValue;
                }
            } else {
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.DisposableEffect(orCreateFor, (Function1)anon, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            return orCreateFor;
        }

        public final void setUseTestInsets(boolean testInsets) {
            WindowInsetsHolder.access$setTestInsets$cp(testInsets);
        }
    }
    static {
        WindowInsetsHolder.Companion companion = new WindowInsetsHolder.Companion(0);
        WindowInsetsHolder.Companion = companion;
        int i = 8;
        WeakHashMap weakHashMap = new WeakHashMap();
        WindowInsetsHolder.viewMap = weakHashMap;
    }

    private WindowInsetsHolder(WindowInsetsCompat insets, View view) {
        Object waterfallInsets;
        int parent;
        int tag;
        int booleanValue;
        boolean consume_window_insets_tag;
        int i;
        super();
        this.captionBar = WindowInsetsHolder.Companion.access$systemInsets(WindowInsetsHolder.Companion, insets, WindowInsetsCompat.Type.captionBar(), "captionBar");
        this.displayCutout = WindowInsetsHolder.Companion.access$systemInsets(WindowInsetsHolder.Companion, insets, WindowInsetsCompat.Type.displayCutout(), "displayCutout");
        this.ime = WindowInsetsHolder.Companion.access$systemInsets(WindowInsetsHolder.Companion, insets, WindowInsetsCompat.Type.ime(), "ime");
        this.mandatorySystemGestures = WindowInsetsHolder.Companion.access$systemInsets(WindowInsetsHolder.Companion, insets, WindowInsetsCompat.Type.mandatorySystemGestures(), "mandatorySystemGestures");
        this.navigationBars = WindowInsetsHolder.Companion.access$systemInsets(WindowInsetsHolder.Companion, insets, WindowInsetsCompat.Type.navigationBars(), "navigationBars");
        this.statusBars = WindowInsetsHolder.Companion.access$systemInsets(WindowInsetsHolder.Companion, insets, WindowInsetsCompat.Type.statusBars(), "statusBars");
        this.systemBars = WindowInsetsHolder.Companion.access$systemInsets(WindowInsetsHolder.Companion, insets, WindowInsetsCompat.Type.systemBars(), "systemBars");
        this.systemGestures = WindowInsetsHolder.Companion.access$systemInsets(WindowInsetsHolder.Companion, insets, WindowInsetsCompat.Type.systemGestures(), "systemGestures");
        this.tappableElement = WindowInsetsHolder.Companion.access$systemInsets(WindowInsetsHolder.Companion, insets, WindowInsetsCompat.Type.tappableElement(), "tappableElement");
        waterfallInsets = insets.getDisplayCutout();
        if (insets != null && waterfallInsets != null) {
            waterfallInsets = insets.getDisplayCutout();
            if (waterfallInsets != null) {
                waterfallInsets = waterfallInsets.getWaterfallInsets() == null ? Insets.NONE : waterfallInsets;
            } else {
            }
        } else {
        }
        this.waterfall = WindowInsets_androidKt.ValueInsets(waterfallInsets, "waterfall");
        this.safeDrawing = WindowInsetsKt.union(WindowInsetsKt.union((WindowInsets)this.systemBars, (WindowInsets)this.ime), (WindowInsets)this.displayCutout);
        this.safeGestures = WindowInsetsKt.union(WindowInsetsKt.union(WindowInsetsKt.union((WindowInsets)this.tappableElement, (WindowInsets)this.mandatorySystemGestures), (WindowInsets)this.systemGestures), (WindowInsets)this.waterfall);
        this.safeContent = WindowInsetsKt.union(this.safeDrawing, this.safeGestures);
        this.captionBarIgnoringVisibility = WindowInsetsHolder.Companion.access$valueInsetsIgnoringVisibility(WindowInsetsHolder.Companion, insets, WindowInsetsCompat.Type.captionBar(), "captionBarIgnoringVisibility");
        this.navigationBarsIgnoringVisibility = WindowInsetsHolder.Companion.access$valueInsetsIgnoringVisibility(WindowInsetsHolder.Companion, insets, WindowInsetsCompat.Type.navigationBars(), "navigationBarsIgnoringVisibility");
        this.statusBarsIgnoringVisibility = WindowInsetsHolder.Companion.access$valueInsetsIgnoringVisibility(WindowInsetsHolder.Companion, insets, WindowInsetsCompat.Type.statusBars(), "statusBarsIgnoringVisibility");
        this.systemBarsIgnoringVisibility = WindowInsetsHolder.Companion.access$valueInsetsIgnoringVisibility(WindowInsetsHolder.Companion, insets, WindowInsetsCompat.Type.systemBars(), "systemBarsIgnoringVisibility");
        this.tappableElementIgnoringVisibility = WindowInsetsHolder.Companion.access$valueInsetsIgnoringVisibility(WindowInsetsHolder.Companion, insets, WindowInsetsCompat.Type.tappableElement(), "tappableElementIgnoringVisibility");
        this.imeAnimationTarget = WindowInsetsHolder.Companion.access$valueInsetsIgnoringVisibility(WindowInsetsHolder.Companion, insets, WindowInsetsCompat.Type.ime(), "imeAnimationTarget");
        this.imeAnimationSource = WindowInsetsHolder.Companion.access$valueInsetsIgnoringVisibility(WindowInsetsHolder.Companion, insets, WindowInsetsCompat.Type.ime(), "imeAnimationSource");
        i = 0;
        if (parent instanceof View != null) {
        } else {
            parent = i;
        }
        if (parent != 0) {
            tag = parent.getTag(R.id.consume_window_insets_tag);
        } else {
            tag = i;
        }
        if (tag instanceof Boolean) {
            i = tag;
        }
        if (i != 0) {
            booleanValue = i.booleanValue();
        } else {
            booleanValue = 1;
        }
        this.consumes = booleanValue;
        InsetsListener insetsListener = new InsetsListener(this);
        this.insetsListener = insetsListener;
    }

    public WindowInsetsHolder(WindowInsetsCompat windowInsetsCompat, View view2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(windowInsetsCompat, view2);
    }

    public static final WeakHashMap access$getViewMap$cp() {
        return WindowInsetsHolder.viewMap;
    }

    public static final void access$setTestInsets$cp(boolean <set-?>) {
        WindowInsetsHolder.testInsets = <set-?>;
    }

    public static void update$default(androidx.compose.foundation.layout.WindowInsetsHolder windowInsetsHolder, WindowInsetsCompat windowInsetsCompat2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        windowInsetsHolder.update(windowInsetsCompat2, obj2);
    }

    public final void decrementAccessors(View view) {
        int insetsListener;
        this.accessCount = accessCount--;
        if (this.accessCount == 0) {
            int i2 = 0;
            ViewCompat.setOnApplyWindowInsetsListener(view, i2);
            ViewCompat.setWindowInsetsAnimationCallback(view, i2);
            view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this.insetsListener);
        }
    }

    public final androidx.compose.foundation.layout.AndroidWindowInsets getCaptionBar() {
        return this.captionBar;
    }

    public final androidx.compose.foundation.layout.ValueInsets getCaptionBarIgnoringVisibility() {
        return this.captionBarIgnoringVisibility;
    }

    public final boolean getConsumes() {
        return this.consumes;
    }

    public final androidx.compose.foundation.layout.AndroidWindowInsets getDisplayCutout() {
        return this.displayCutout;
    }

    public final androidx.compose.foundation.layout.AndroidWindowInsets getIme() {
        return this.ime;
    }

    public final androidx.compose.foundation.layout.ValueInsets getImeAnimationSource() {
        return this.imeAnimationSource;
    }

    public final androidx.compose.foundation.layout.ValueInsets getImeAnimationTarget() {
        return this.imeAnimationTarget;
    }

    public final androidx.compose.foundation.layout.AndroidWindowInsets getMandatorySystemGestures() {
        return this.mandatorySystemGestures;
    }

    public final androidx.compose.foundation.layout.AndroidWindowInsets getNavigationBars() {
        return this.navigationBars;
    }

    public final androidx.compose.foundation.layout.ValueInsets getNavigationBarsIgnoringVisibility() {
        return this.navigationBarsIgnoringVisibility;
    }

    public final androidx.compose.foundation.layout.WindowInsets getSafeContent() {
        return this.safeContent;
    }

    public final androidx.compose.foundation.layout.WindowInsets getSafeDrawing() {
        return this.safeDrawing;
    }

    public final androidx.compose.foundation.layout.WindowInsets getSafeGestures() {
        return this.safeGestures;
    }

    public final androidx.compose.foundation.layout.AndroidWindowInsets getStatusBars() {
        return this.statusBars;
    }

    public final androidx.compose.foundation.layout.ValueInsets getStatusBarsIgnoringVisibility() {
        return this.statusBarsIgnoringVisibility;
    }

    public final androidx.compose.foundation.layout.AndroidWindowInsets getSystemBars() {
        return this.systemBars;
    }

    public final androidx.compose.foundation.layout.ValueInsets getSystemBarsIgnoringVisibility() {
        return this.systemBarsIgnoringVisibility;
    }

    public final androidx.compose.foundation.layout.AndroidWindowInsets getSystemGestures() {
        return this.systemGestures;
    }

    public final androidx.compose.foundation.layout.AndroidWindowInsets getTappableElement() {
        return this.tappableElement;
    }

    public final androidx.compose.foundation.layout.ValueInsets getTappableElementIgnoringVisibility() {
        return this.tappableElementIgnoringVisibility;
    }

    public final androidx.compose.foundation.layout.ValueInsets getWaterfall() {
        return this.waterfall;
    }

    public final void incrementAccessors(View view) {
        int insetsListener;
        ViewCompat.setOnApplyWindowInsetsListener(view, (OnApplyWindowInsetsListener)this.insetsListener);
        if (this.accessCount == 0 && view.isAttachedToWindow()) {
            ViewCompat.setOnApplyWindowInsetsListener(view, (OnApplyWindowInsetsListener)this.insetsListener);
            if (view.isAttachedToWindow()) {
                view.requestApplyInsets();
            }
            view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this.insetsListener);
            ViewCompat.setWindowInsetsAnimationCallback(view, (WindowInsetsAnimationCompat.Callback)this.insetsListener);
        }
        this.accessCount = accessCount++;
    }

    public final void update(WindowInsetsCompat windowInsets, int types) {
        WindowInsetsCompat windowInsetsCompat;
        Object mandatorySystemGestures;
        Object waterfallInsets;
        androidx.compose.foundation.layout.ValueInsets waterfall;
        androidx.compose.foundation.layout.InsetsValues insetsValues;
        if (WindowInsetsHolder.testInsets) {
            android.view.WindowInsets windowInsets2 = windowInsets.toWindowInsets();
            Intrinsics.checkNotNull(windowInsets2);
            windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets2);
        } else {
            windowInsetsCompat = windowInsets;
        }
        this.captionBar.update$foundation_layout_release(windowInsetsCompat, types);
        this.ime.update$foundation_layout_release(windowInsetsCompat, types);
        this.displayCutout.update$foundation_layout_release(windowInsetsCompat, types);
        this.navigationBars.update$foundation_layout_release(windowInsetsCompat, types);
        this.statusBars.update$foundation_layout_release(windowInsetsCompat, types);
        this.systemBars.update$foundation_layout_release(windowInsetsCompat, types);
        this.systemGestures.update$foundation_layout_release(windowInsetsCompat, types);
        this.tappableElement.update$foundation_layout_release(windowInsetsCompat, types);
        this.mandatorySystemGestures.update$foundation_layout_release(windowInsetsCompat, types);
        this.captionBarIgnoringVisibility.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.captionBar())));
        this.navigationBarsIgnoringVisibility.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.navigationBars())));
        this.statusBarsIgnoringVisibility.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.statusBars())));
        this.systemBarsIgnoringVisibility.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars())));
        this.tappableElementIgnoringVisibility.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.tappableElement())));
        mandatorySystemGestures = windowInsetsCompat.getDisplayCutout();
        if (types == 0 && mandatorySystemGestures != null) {
            this.captionBarIgnoringVisibility.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.captionBar())));
            this.navigationBarsIgnoringVisibility.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.navigationBars())));
            this.statusBarsIgnoringVisibility.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.statusBars())));
            this.systemBarsIgnoringVisibility.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars())));
            this.tappableElementIgnoringVisibility.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.tappableElement())));
            mandatorySystemGestures = windowInsetsCompat.getDisplayCutout();
            if (mandatorySystemGestures != null) {
                this.waterfall.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(mandatorySystemGestures.getWaterfallInsets()));
            }
        }
        Snapshot.Companion.sendApplyNotifications();
    }

    public final void updateImeAnimationSource(WindowInsetsCompat windowInsets) {
        this.imeAnimationSource.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(windowInsets.getInsets(WindowInsetsCompat.Type.ime())));
    }

    public final void updateImeAnimationTarget(WindowInsetsCompat windowInsets) {
        this.imeAnimationTarget.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(windowInsets.getInsets(WindowInsetsCompat.Type.ime())));
    }
}
