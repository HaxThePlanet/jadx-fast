package androidx.core.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;

/* loaded from: classes5.dex */
public final class WindowCompat {

    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;

    static class Api16Impl {
        static void setDecorFitsSystemWindows(Window window, boolean decorFitsSystemWindows) {
            int i;
            final int i2 = 1792;
            final View decorView = window.getDecorView();
            final int systemUiVisibility = decorView.getSystemUiVisibility();
            i = decorFitsSystemWindows ? systemUiVisibility & -1793 : systemUiVisibility | 1792;
            decorView.setSystemUiVisibility(i);
        }
    }

    static class Api28Impl {
        static <T> T requireViewById(Window window, int id) {
            return window.requireViewById(id);
        }
    }

    static class Api30Impl {
        static void setDecorFitsSystemWindows(Window window, boolean decorFitsSystemWindows) {
            int i;
            final int i2 = 256;
            final View decorView = window.getDecorView();
            final int systemUiVisibility = decorView.getSystemUiVisibility();
            i = decorFitsSystemWindows ? systemUiVisibility & -257 : systemUiVisibility | 256;
            decorView.setSystemUiVisibility(i);
            window.setDecorFitsSystemWindows(decorFitsSystemWindows);
        }
    }

    static class Api35Impl {
        static void setDecorFitsSystemWindows(Window window, boolean decorFitsSystemWindows) {
            window.setDecorFitsSystemWindows(decorFitsSystemWindows);
        }
    }
    public static androidx.core.view.WindowInsetsControllerCompat getInsetsController(Window window, View view) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, view);
        return windowInsetsControllerCompat;
    }

    public static <T extends View> T requireViewById(Window window, int id) {
        return (View)WindowCompat.Api28Impl.requireViewById(window, id);
    }

    public static void setDecorFitsSystemWindows(Window window, boolean decorFitsSystemWindows) {
        int sDK_INT;
        int i;
        if (Build.VERSION.SDK_INT >= 35) {
            WindowCompat.Api35Impl.setDecorFitsSystemWindows(window, decorFitsSystemWindows);
        } else {
            if (Build.VERSION.SDK_INT >= 30) {
                WindowCompat.Api30Impl.setDecorFitsSystemWindows(window, decorFitsSystemWindows);
            } else {
                WindowCompat.Api16Impl.setDecorFitsSystemWindows(window, decorFitsSystemWindows);
            }
        }
    }
}
