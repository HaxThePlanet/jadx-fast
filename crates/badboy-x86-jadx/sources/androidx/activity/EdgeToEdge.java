package androidx.activity;

import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a%\u0010\u000b\u001a\u00020\u000c*\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0008\u0011\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0002\u0010\u0003\u001a\u0004\u0008\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0007\u0010\u0003\u001a\u0004\u0008\u0008\u0010\u0005\"\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"DefaultDarkScrim", "", "getDefaultDarkScrim$annotations", "()V", "getDefaultDarkScrim", "()I", "DefaultLightScrim", "getDefaultLightScrim$annotations", "getDefaultLightScrim", "Impl", "Landroidx/activity/EdgeToEdgeImpl;", "enableEdgeToEdge", "", "Landroidx/activity/ComponentActivity;", "statusBarStyle", "Landroidx/activity/SystemBarStyle;", "navigationBarStyle", "enable", "activity_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EdgeToEdge {

    private static final int DefaultDarkScrim;
    private static final int DefaultLightScrim;
    private static androidx.activity.EdgeToEdgeImpl Impl;
    static {
        int i3 = 255;
        EdgeToEdge.DefaultLightScrim = Color.argb(230, i3, i3, i3);
        int i4 = 27;
        EdgeToEdge.DefaultDarkScrim = Color.argb(128, i4, i4, i4);
    }

    public static final void enable(androidx.activity.ComponentActivity $this$enableEdgeToEdge) {
        Intrinsics.checkNotNullParameter($this$enableEdgeToEdge, "<this>");
        int i = 0;
        EdgeToEdge.enable$default($this$enableEdgeToEdge, i, i, 3, i);
    }

    public static final void enable(androidx.activity.ComponentActivity $this$enableEdgeToEdge, androidx.activity.SystemBarStyle statusBarStyle) {
        Intrinsics.checkNotNullParameter($this$enableEdgeToEdge, "<this>");
        Intrinsics.checkNotNullParameter(statusBarStyle, "statusBarStyle");
        int i = 0;
        EdgeToEdge.enable$default($this$enableEdgeToEdge, statusBarStyle, i, 2, i);
    }

    public static final void enable(androidx.activity.ComponentActivity $this$enableEdgeToEdge, androidx.activity.SystemBarStyle statusBarStyle, androidx.activity.SystemBarStyle navigationBarStyle) {
        androidx.activity.EdgeToEdgeApi29 impl;
        android.content.res.Resources resources;
        androidx.activity.EdgeToEdgeImpl edgeToEdgeImpl;
        Intrinsics.checkNotNullParameter($this$enableEdgeToEdge, "<this>");
        Intrinsics.checkNotNullParameter(statusBarStyle, "statusBarStyle");
        Intrinsics.checkNotNullParameter(navigationBarStyle, "navigationBarStyle");
        View decorView = $this$enableEdgeToEdge.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        final View view = decorView;
        android.content.res.Resources resources2 = view.getResources();
        String str6 = "view.resources";
        Intrinsics.checkNotNullExpressionValue(resources2, str6);
        resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, str6);
        impl = EdgeToEdge.Impl;
        if (impl == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                impl = new EdgeToEdgeApi30();
            } else {
                impl = new EdgeToEdgeApi29();
            }
            edgeToEdgeImpl = impl;
        } else {
            edgeToEdgeImpl = impl;
        }
        final Window window2 = $this$enableEdgeToEdge.getWindow();
        String str4 = "window";
        Intrinsics.checkNotNullExpressionValue(window2, str4);
        edgeToEdgeImpl.setUp(statusBarStyle, navigationBarStyle, window2, view, (Boolean)statusBarStyle.getDetectDarkMode$activity_release().invoke(resources2).booleanValue(), (Boolean)navigationBarStyle.getDetectDarkMode$activity_release().invoke(resources).booleanValue());
        final Window obj10 = $this$enableEdgeToEdge.getWindow();
        Intrinsics.checkNotNullExpressionValue(obj10, str4);
        edgeToEdgeImpl.adjustLayoutInDisplayCutoutMode(obj10);
    }

    public static void enable$default(androidx.activity.ComponentActivity componentActivity, androidx.activity.SystemBarStyle systemBarStyle2, androidx.activity.SystemBarStyle systemBarStyle3, int i4, Object object5) {
        androidx.activity.SystemBarStyle.Companion companion;
        int defaultLightScrim;
        int defaultDarkScrim;
        int i2;
        int i;
        int i3;
        androidx.activity.SystemBarStyle obj7;
        androidx.activity.SystemBarStyle obj8;
        if (i4 & 1 != 0) {
            obj7 = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, 0, 0, 0, 4, 0);
        }
        if (i4 &= 2 != 0) {
            obj8 = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, EdgeToEdge.DefaultLightScrim, EdgeToEdge.DefaultDarkScrim, 0, 4, 0);
        }
        EdgeToEdge.enable(componentActivity, obj7, obj8);
    }

    public static final int getDefaultDarkScrim() {
        return EdgeToEdge.DefaultDarkScrim;
    }

    public static void getDefaultDarkScrim$annotations() {
    }

    public static final int getDefaultLightScrim() {
        return EdgeToEdge.DefaultLightScrim;
    }

    public static void getDefaultLightScrim$annotations() {
    }
}
