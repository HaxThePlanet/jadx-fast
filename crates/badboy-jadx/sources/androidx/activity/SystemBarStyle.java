package androidx.activity;

import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\r\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B3\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u0015\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\tH\u0000¢\u0006\u0002\u0008\u0012J\u0015\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\tH\u0000¢\u0006\u0002\u0008\u0014R\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000c¨\u0006\u0016", d2 = {"Landroidx/activity/SystemBarStyle;", "", "lightScrim", "", "darkScrim", "nightMode", "detectDarkMode", "Lkotlin/Function1;", "Landroid/content/res/Resources;", "", "(IIILkotlin/jvm/functions/Function1;)V", "getDarkScrim$activity_release", "()I", "getDetectDarkMode$activity_release", "()Lkotlin/jvm/functions/Function1;", "getNightMode$activity_release", "getScrim", "isDark", "getScrim$activity_release", "getScrimWithEnforcedContrast", "getScrimWithEnforcedContrast$activity_release", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SystemBarStyle {

    public static final androidx.activity.SystemBarStyle.Companion Companion;
    private final int darkScrim;
    private final Function1<Resources, Boolean> detectDarkMode;
    private final int lightScrim;
    private final int nightMode;

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0001\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u0007\u001a\u00020\u00062\u0014\u0008\u0002\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0007J\u0012\u0010\u000c\u001a\u00020\u00042\u0008\u0008\u0001\u0010\r\u001a\u00020\u0006H\u0007J\u001c\u0010\u000e\u001a\u00020\u00042\u0008\u0008\u0001\u0010\r\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\u000f", d2 = {"Landroidx/activity/SystemBarStyle$Companion;", "", "()V", "auto", "Landroidx/activity/SystemBarStyle;", "lightScrim", "", "darkScrim", "detectDarkMode", "Lkotlin/Function1;", "Landroid/content/res/Resources;", "", "dark", "scrim", "light", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static androidx.activity.SystemBarStyle auto$default(androidx.activity.SystemBarStyle.Companion systemBarStyle$Companion, int i2, int i3, Function1 function14, int i5, Object object6) {
            androidx.activity.SystemBarStyle.Companion.auto.1 obj3;
            if (i5 &= 4 != 0) {
                obj3 = SystemBarStyle.Companion.auto.1.INSTANCE;
            }
            return companion.auto(i2, i3, obj3);
        }

        @JvmStatic
        public final androidx.activity.SystemBarStyle auto(int lightScrim, int darkScrim) {
            return SystemBarStyle.Companion.auto$default(this, lightScrim, darkScrim, 0, 4, 0);
        }

        @JvmStatic
        public final androidx.activity.SystemBarStyle auto(int lightScrim, int darkScrim, Function1<? super Resources, Boolean> detectDarkMode) {
            Intrinsics.checkNotNullParameter(detectDarkMode, "detectDarkMode");
            SystemBarStyle systemBarStyle = new SystemBarStyle(lightScrim, darkScrim, 0, detectDarkMode, 0);
            return systemBarStyle;
        }

        @JvmStatic
        public final androidx.activity.SystemBarStyle dark(int scrim) {
            SystemBarStyle systemBarStyle = new SystemBarStyle(scrim, scrim, 2, (Function1)SystemBarStyle.Companion.dark.1.INSTANCE, 0);
            return systemBarStyle;
        }

        @JvmStatic
        public final androidx.activity.SystemBarStyle light(int scrim, int darkScrim) {
            SystemBarStyle systemBarStyle = new SystemBarStyle(scrim, darkScrim, 1, (Function1)SystemBarStyle.Companion.light.1.INSTANCE, 0);
            return systemBarStyle;
        }
    }
    static {
        SystemBarStyle.Companion companion = new SystemBarStyle.Companion(0);
        SystemBarStyle.Companion = companion;
    }

    private SystemBarStyle(int lightScrim, int darkScrim, int nightMode, Function1<? super Resources, Boolean> detectDarkMode) {
        super();
        this.lightScrim = lightScrim;
        this.darkScrim = darkScrim;
        this.nightMode = nightMode;
        this.detectDarkMode = detectDarkMode;
    }

    public SystemBarStyle(int i, int i2, int i3, Function1 function14, DefaultConstructorMarker defaultConstructorMarker5) {
        super(i, i2, i3, function14);
    }

    @JvmStatic
    public static final androidx.activity.SystemBarStyle auto(int lightScrim, int darkScrim) {
        return SystemBarStyle.Companion.auto(lightScrim, darkScrim);
    }

    @JvmStatic
    public static final androidx.activity.SystemBarStyle auto(int lightScrim, int darkScrim, Function1<? super Resources, Boolean> detectDarkMode) {
        return SystemBarStyle.Companion.auto(lightScrim, darkScrim, detectDarkMode);
    }

    @JvmStatic
    public static final androidx.activity.SystemBarStyle dark(int scrim) {
        return SystemBarStyle.Companion.dark(scrim);
    }

    @JvmStatic
    public static final androidx.activity.SystemBarStyle light(int scrim, int darkScrim) {
        return SystemBarStyle.Companion.light(scrim, darkScrim);
    }

    public final int getDarkScrim$activity_release() {
        return this.darkScrim;
    }

    public final Function1<Resources, Boolean> getDetectDarkMode$activity_release() {
        return this.detectDarkMode;
    }

    public final int getNightMode$activity_release() {
        return this.nightMode;
    }

    public final int getScrim$activity_release(boolean isDark) {
        int lightScrim;
        lightScrim = isDark ? this.darkScrim : this.lightScrim;
        return lightScrim;
    }

    public final int getScrimWithEnforcedContrast$activity_release(boolean isDark) {
        int lightScrim;
        lightScrim = this.nightMode == 0 ? 0 : isDark ? this.darkScrim : this.lightScrim;
        return lightScrim;
    }
}
