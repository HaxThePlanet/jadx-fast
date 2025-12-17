package androidx.core.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class KeyEventDispatcher {

    private static boolean sActionBarFieldsFetched;
    private static Method sActionBarOnMenuKeyMethod;
    private static boolean sDialogFieldsFetched;
    private static Field sDialogKeyListenerField;

    public interface Component {
        public abstract boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }
    static {
        final int i = 0;
        KeyEventDispatcher.sActionBarFieldsFetched = i;
        final int i2 = 0;
        KeyEventDispatcher.sActionBarOnMenuKeyMethod = i2;
        KeyEventDispatcher.sDialogFieldsFetched = i;
        KeyEventDispatcher.sDialogKeyListenerField = i2;
    }

    private static boolean actionBarOnMenuKeyEventPre28(ActionBar actionBar, KeyEvent event) {
        boolean sActionBarFieldsFetched;
        Method sActionBarOnMenuKeyMethod;
        Method method;
        String str;
        Class[] arr;
        Class<KeyEvent> obj;
        int i = 0;
        if (!KeyEventDispatcher.sActionBarFieldsFetched) {
            sActionBarFieldsFetched = 1;
            arr = new Class[sActionBarFieldsFetched];
            arr[i] = KeyEvent.class;
            KeyEventDispatcher.sActionBarOnMenuKeyMethod = actionBar.getClass().getMethod("onMenuKeyEvent", arr);
            KeyEventDispatcher.sActionBarFieldsFetched = sActionBarFieldsFetched;
        }
        Object invoke = KeyEventDispatcher.sActionBarOnMenuKeyMethod.invoke(actionBar, /* result */);
        if (KeyEventDispatcher.sActionBarOnMenuKeyMethod != null && invoke == null) {
            invoke = KeyEventDispatcher.sActionBarOnMenuKeyMethod.invoke(actionBar, /* result */);
            if (invoke == null) {
                return i;
            }
            try {
                return (Boolean)invoke.booleanValue();
                return i;
            } catch (java.lang.IllegalAccessException illegalAccess) {
            } catch (java.lang.reflect.InvocationTargetException invocationTarget1) {
            }
        }
    }

    private static boolean activitySuperDispatchKeyEventPre28(Activity activity, KeyEvent event) {
        boolean actionBar;
        int keyDispatcherState;
        int keyCode;
        int i;
        activity.onUserInteraction();
        final Window window = activity.getWindow();
        int i3 = 1;
        actionBar = activity.getActionBar();
        if (window.hasFeature(8) && event.getKeyCode() == 82 && actionBar != null && KeyEventDispatcher.actionBarOnMenuKeyEventPre28(actionBar, event)) {
            actionBar = activity.getActionBar();
            if (event.getKeyCode() == 82) {
                if (actionBar != null) {
                    if (KeyEventDispatcher.actionBarOnMenuKeyEventPre28(actionBar, event)) {
                        return i3;
                    }
                }
            }
        }
        if (window.superDispatchKeyEvent(event)) {
            return i3;
        }
        View decorView = window.getDecorView();
        if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(decorView, event)) {
            return i3;
        }
        if (decorView != null) {
            keyDispatcherState = decorView.getKeyDispatcherState();
        } else {
            keyDispatcherState = 0;
        }
        return event.dispatch(activity, keyDispatcherState, activity);
    }

    private static boolean dialogSuperDispatchKeyEventPre28(Dialog dialog, KeyEvent event) {
        int keyDispatcherState;
        boolean onKey;
        final DialogInterface.OnKeyListener dialogKeyListenerPre28 = KeyEventDispatcher.getDialogKeyListenerPre28(dialog);
        int i = 1;
        if (dialogKeyListenerPre28 != null && dialogKeyListenerPre28.onKey(dialog, event.getKeyCode(), event)) {
            if (dialogKeyListenerPre28.onKey(dialog, event.getKeyCode(), event)) {
                return i;
            }
        }
        Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(event)) {
            return i;
        }
        View decorView = window.getDecorView();
        if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(decorView, event)) {
            return i;
        }
        if (decorView != null) {
            keyDispatcherState = decorView.getKeyDispatcherState();
        } else {
            keyDispatcherState = 0;
        }
        return event.dispatch(dialog, keyDispatcherState, dialog);
    }

    public static boolean dispatchBeforeHierarchy(View root, KeyEvent event) {
        return ViewCompat.dispatchUnhandledKeyEventBeforeHierarchy(root, event);
    }

    public static boolean dispatchKeyEvent(androidx.core.view.KeyEventDispatcher.Component component, View root, Window.Callback callback, KeyEvent event) {
        if (component == null) {
            return 0;
        }
        return component.superDispatchKeyEvent(event);
    }

    private static DialogInterface.OnKeyListener getDialogKeyListenerPre28(Dialog dialog) {
        boolean sDialogFieldsFetched;
        Field sDialogKeyListenerField2;
        Field sDialogKeyListenerField;
        String str;
        if (!KeyEventDispatcher.sDialogFieldsFetched) {
            sDialogFieldsFetched = 1;
            KeyEventDispatcher.sDialogKeyListenerField = Dialog.class.getDeclaredField("mOnKeyListener");
            KeyEventDispatcher.sDialogKeyListenerField.setAccessible(sDialogFieldsFetched);
            KeyEventDispatcher.sDialogFieldsFetched = sDialogFieldsFetched;
        }
        if (KeyEventDispatcher.sDialogKeyListenerField != null) {
            try {
                return (DialogInterface.OnKeyListener)KeyEventDispatcher.sDialogKeyListenerField.get(dialog);
                return null;
            } catch (java.lang.IllegalAccessException illegalAccess) {
            }
        }
    }
}
