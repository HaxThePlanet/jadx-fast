package androidx.compose.material3.internal;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityServicesStateChangeListener;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u000c\n\u0002\u0008\u0003\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0006*\u0002\u0010\u0013\u0008\u0003\u0018\u00002\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\"B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0019J\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0019R+\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u00020\u0003*\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u001b¨\u0006#", d2 = {"Landroidx/compose/material3/internal/Listener;", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "Landroidx/compose/runtime/State;", "", "listenToTouchExplorationState", "listenToSwitchAccessState", "(ZZ)V", "<set-?>", "accessibilityEnabled", "getAccessibilityEnabled", "()Z", "setAccessibilityEnabled", "(Z)V", "accessibilityEnabled$delegate", "Landroidx/compose/runtime/MutableState;", "switchAccessListener", "androidx/compose/material3/internal/Listener$switchAccessListener$1", "Landroidx/compose/material3/internal/Listener$switchAccessListener$1;", "touchExplorationListener", "androidx/compose/material3/internal/Listener$touchExplorationListener$1", "Landroidx/compose/material3/internal/Listener$touchExplorationListener$1;", "value", "getValue", "()Ljava/lang/Boolean;", "switchAccessEnabled", "Landroid/view/accessibility/AccessibilityManager;", "getSwitchAccessEnabled", "(Landroid/view/accessibility/AccessibilityManager;)Z", "onAccessibilityStateChanged", "", "enabled", "register", "am", "unregister", "Api33Impl", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class Listener implements AccessibilityManager.AccessibilityStateChangeListener, State<Boolean> {

    private final MutableState accessibilityEnabled$delegate;
    private final androidx.compose.material3.internal.Listener.switchAccessListener.1 switchAccessListener;
    private final androidx.compose.material3.internal.Listener.touchExplorationListener.1 touchExplorationListener = null;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0007¨\u0006\n", d2 = {"Landroidx/compose/material3/internal/Listener$Api33Impl;", "", "()V", "addAccessibilityServicesStateChangeListener", "", "am", "Landroid/view/accessibility/AccessibilityManager;", "listener", "Landroid/view/accessibility/AccessibilityManager$AccessibilityServicesStateChangeListener;", "removeAccessibilityServicesStateChangeListener", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Api33Impl {

        public static final androidx.compose.material3.internal.Listener.Api33Impl INSTANCE;
        static {
            Listener.Api33Impl api33Impl = new Listener.Api33Impl();
            Listener.Api33Impl.INSTANCE = api33Impl;
        }

        @JvmStatic
        public static final void addAccessibilityServicesStateChangeListener(AccessibilityManager am, AccessibilityManager.AccessibilityServicesStateChangeListener listener) {
            am.addAccessibilityServicesStateChangeListener(listener);
        }

        @JvmStatic
        public static final void removeAccessibilityServicesStateChangeListener(AccessibilityManager am, AccessibilityManager.AccessibilityServicesStateChangeListener listener) {
            am.removeAccessibilityServicesStateChangeListener(listener);
        }
    }
    public Listener(boolean listenToTouchExplorationState, boolean listenToSwitchAccessState) {
        int sDK_INT;
        int i;
        androidx.compose.material3.internal.Listener.switchAccessListener.1 anon;
        super();
        anon = 0;
        this.accessibilityEnabled$delegate = SnapshotStateKt.mutableStateOf$default(false, anon, 2, anon);
        if (listenToTouchExplorationState) {
            Listener.touchExplorationListener.1 anon2 = new Listener.touchExplorationListener.1();
        }
        sDK_INT = anon;
        if (listenToSwitchAccessState && Build.VERSION.SDK_INT >= 33) {
            if (Build.VERSION.SDK_INT >= 33) {
                anon = new Listener.switchAccessListener.1(this);
            } else {
            }
        } else {
        }
        this.switchAccessListener = anon;
    }

    public static final boolean access$getSwitchAccessEnabled(androidx.compose.material3.internal.Listener $this, AccessibilityManager $receiver) {
        return $this.getSwitchAccessEnabled($receiver);
    }

    private final boolean getAccessibilityEnabled() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.accessibilityEnabled$delegate.getValue().booleanValue();
    }

    private final boolean getSwitchAccessEnabled(AccessibilityManager $this$switchAccessEnabled) {
        List enabledAccessibilityServiceList;
        int index$iv$iv;
        int i2;
        Object obj2;
        Object obj;
        int i4;
        Object obj3;
        int i;
        int i3;
        int i5;
        String str;
        List $this$fastAny$iv;
        final int i7 = 0;
        final List list = enabledAccessibilityServiceList;
        final int i8 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list.size()) {
            i4 = 0;
            i = 0;
            String settingsActivityName = (AccessibilityServiceInfo)list.get(index$iv$iv).getSettingsActivityName();
            if (settingsActivityName != null) {
            } else {
            }
            $this$fastAny$iv = enabledAccessibilityServiceList;
            i3 = 1;
            index$iv$iv++;
            enabledAccessibilityServiceList = $this$fastAny$iv;
            $this$fastAny$iv = enabledAccessibilityServiceList;
            i3 = 1;
            if (StringsKt.contains$default((CharSequence)settingsActivityName, (CharSequence)"SwitchAccess", false, 2, 0) == i3) {
            }
            i2 = i3;
        }
        $this$fastAny$iv = enabledAccessibilityServiceList;
        return i2;
    }

    private final void setAccessibilityEnabled(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.accessibilityEnabled$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    @Override // android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener
    public Boolean getValue() {
        boolean accessibilityEnabled;
        int i;
        i = 0;
        if (getAccessibilityEnabled()) {
            androidx.compose.material3.internal.Listener.touchExplorationListener.1 touchExplorationListener = this.touchExplorationListener;
            if (touchExplorationListener != null) {
                accessibilityEnabled = touchExplorationListener.getEnabled();
            } else {
                accessibilityEnabled = i;
            }
            if (accessibilityEnabled == 0) {
                androidx.compose.material3.internal.Listener.switchAccessListener.1 switchAccessListener = this.switchAccessListener;
                if (switchAccessListener != null) {
                    accessibilityEnabled = switchAccessListener.getEnabled();
                } else {
                    accessibilityEnabled = i;
                }
                if (accessibilityEnabled != 0) {
                    i = 1;
                } else {
                }
            } else {
            }
        } else {
        }
        return Boolean.valueOf(i);
    }

    @Override // android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener
    public Object getValue() {
        return getValue();
    }

    @Override // android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener
    public void onAccessibilityStateChanged(boolean enabled) {
        setAccessibilityEnabled(enabled);
    }

    @Override // android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener
    public final void register(AccessibilityManager am) {
        int switchAccessListener;
        int i;
        int i2;
        androidx.compose.material3.internal.Listener.touchExplorationListener.1 list;
        setAccessibilityEnabled(am.isEnabled());
        am.addAccessibilityStateChangeListener((AccessibilityManager.AccessibilityStateChangeListener)this);
        androidx.compose.material3.internal.Listener.touchExplorationListener.1 touchExplorationListener = this.touchExplorationListener;
        if (touchExplorationListener != null) {
            i = 0;
            touchExplorationListener.setEnabled(am.isTouchExplorationEnabled());
            am.addTouchExplorationStateChangeListener((AccessibilityManager.TouchExplorationStateChangeListener)touchExplorationListener);
        }
        switchAccessListener = this.switchAccessListener;
        if (Build.VERSION.SDK_INT >= 33 && switchAccessListener != null) {
            switchAccessListener = this.switchAccessListener;
            if (switchAccessListener != null) {
                i2 = 0;
                switchAccessListener.setEnabled(getSwitchAccessEnabled(am));
                Listener.Api33Impl.addAccessibilityServicesStateChangeListener(am, (AccessibilityManager.AccessibilityServicesStateChangeListener)switchAccessListener);
            }
        }
    }

    @Override // android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener
    public final void unregister(AccessibilityManager am) {
        int it;
        int i2;
        int i;
        androidx.compose.material3.internal.Listener.touchExplorationListener.1 list;
        am.removeAccessibilityStateChangeListener((AccessibilityManager.AccessibilityStateChangeListener)this);
        androidx.compose.material3.internal.Listener.touchExplorationListener.1 touchExplorationListener = this.touchExplorationListener;
        if (touchExplorationListener != null) {
            i2 = 0;
            am.removeTouchExplorationStateChangeListener((AccessibilityManager.TouchExplorationStateChangeListener)touchExplorationListener);
        }
        it = this.switchAccessListener;
        if (Build.VERSION.SDK_INT >= 33 && it != null) {
            it = this.switchAccessListener;
            if (it != null) {
                i = 0;
                Listener.Api33Impl.removeAccessibilityServicesStateChangeListener(am, (AccessibilityManager.AccessibilityServicesStateChangeListener)it);
            }
        }
    }
}
