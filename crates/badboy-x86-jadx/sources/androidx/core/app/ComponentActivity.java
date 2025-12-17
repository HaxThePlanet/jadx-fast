package androidx.core.app;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import androidx.collection.SimpleArrayMap;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.KeyEventDispatcher.Component;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.ReportFragment.Companion;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001)B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J'\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\u0008\u0008\u0000\u0010\u0017*\u00020\u00082\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u00170\u0007H\u0017¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001dH\u0015J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0008H\u0017J\u001d\u0010\"\u001a\u00020\u00122\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0004¢\u0006\u0002\u0010&J\u001d\u0010'\u001a\u00020\u00122\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0002¢\u0006\u0002\u0010&J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0017R(\u0010\u0005\u001a\u0016\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020\u00080\u0007\u0012\u0004\u0012\u00020\u00080\u0006X\u0082\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0010\u0010\u0004¨\u0006*", d2 = {"Landroidx/core/app/ComponentActivity;", "Landroid/app/Activity;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/core/view/KeyEventDispatcher$Component;", "()V", "extraDataMap", "Landroidx/collection/SimpleArrayMap;", "Ljava/lang/Class;", "Landroidx/core/app/ComponentActivity$ExtraData;", "getExtraDataMap$annotations", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycleRegistry$annotations", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "dispatchKeyShortcutEvent", "getExtraData", "T", "extraDataClass", "(Ljava/lang/Class;)Landroidx/core/app/ComponentActivity$ExtraData;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "putExtraData", "extraData", "shouldDumpInternalState", "args", "", "", "([Ljava/lang/String;)Z", "shouldSkipDump", "superDispatchKeyEvent", "ExtraData", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ComponentActivity extends Activity implements LifecycleOwner, KeyEventDispatcher.Component {

    private final SimpleArrayMap<Class<? extends androidx.core.app.ComponentActivity.ExtraData>, androidx.core.app.ComponentActivity.ExtraData> extraDataMap;
    private final LifecycleRegistry lifecycleRegistry;

    @Deprecated(message = "Store the object you want to save directly by using\n      {@link View#setTag(int, Object)} with the window's decor view.")
    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Landroidx/core/app/ComponentActivity$ExtraData;", "", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class ExtraData {
    }
    public ComponentActivity() {
        super();
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap(0, 1, 0);
        this.extraDataMap = simpleArrayMap;
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry((LifecycleOwner)this);
        this.lifecycleRegistry = lifecycleRegistry;
    }

    private static void getExtraDataMap$annotations() {
    }

    private static void getLifecycleRegistry$annotations() {
    }

    private final boolean shouldSkipDump(String[] args) {
        int i3;
        int equals;
        int i;
        int str;
        i3 = 0;
        final int i4 = 1;
        if (args != null) {
            i = args.length == 0 ? i4 : i3;
            if (i != 0) {
                equals = i4;
            } else {
                equals = i3;
            }
        } else {
        }
        if (equals == 0) {
            equals = args[i3];
            switch (equals) {
                case "--translation":
                    i3 = i4;
                    return i3;
                case "--dump-dumpable":
                    i3 = i4;
                    return i3;
                case "--list-dumpables":
                    i3 = i4;
                    return i3;
                case "--contentcapture":
                    return i4;
                case "--autofill":
                    return i4;
            }
        }
        return i3;
    }

    @Override // android.app.Activity
    public boolean dispatchKeyEvent(KeyEvent event) {
        int dispatchKeyEvent;
        android.view.Window.Callback callback;
        Intrinsics.checkNotNullParameter(event, "event");
        android.view.View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        if (KeyEventDispatcher.dispatchBeforeHierarchy(decorView, event)) {
            dispatchKeyEvent = 1;
        } else {
            dispatchKeyEvent = KeyEventDispatcher.dispatchKeyEvent((KeyEventDispatcher.Component)this, decorView, (Window.Callback)this, event);
        }
        return dispatchKeyEvent;
    }

    @Override // android.app.Activity
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        int dispatchKeyShortcutEvent;
        Intrinsics.checkNotNullParameter(event, "event");
        android.view.View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        if (KeyEventDispatcher.dispatchBeforeHierarchy(decorView, event)) {
            dispatchKeyShortcutEvent = 1;
        } else {
            dispatchKeyShortcutEvent = super.dispatchKeyShortcutEvent(event);
        }
        return dispatchKeyShortcutEvent;
    }

    @Deprecated(message = "Use {@link View#getTag(int)} with the window's decor view.")
    public <T extends androidx.core.app.ComponentActivity.ExtraData> T getExtraData(Class<T> extraDataClass) {
        Intrinsics.checkNotNullParameter(extraDataClass, "extraDataClass");
        return (ComponentActivity.ExtraData)this.extraDataMap.get(extraDataClass);
    }

    @Override // android.app.Activity
    public Lifecycle getLifecycle() {
        return (Lifecycle)this.lifecycleRegistry;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ReportFragment.Companion.injectIfNeededIn((Activity)this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        super.onSaveInstanceState(outState);
    }

    @Deprecated(message = "Use {@link View#setTag(int, Object)} with the window's decor view.")
    public void putExtraData(androidx.core.app.ComponentActivity.ExtraData extraData) {
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        this.extraDataMap.put(extraData.getClass(), extraData);
    }

    @Override // android.app.Activity
    protected final boolean shouldDumpInternalState(String[] args) {
        return skipDump ^= 1;
    }

    @Override // android.app.Activity
    public boolean superDispatchKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return super.dispatchKeyEvent(event);
    }
}
