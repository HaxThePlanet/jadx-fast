package androidx.core.os;

import android.os.Build.VERSION;
import android.os.ext.SdkExtensions;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0002\u0008\u000b\u0008Æ\u0002\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0008\u001a\u00020\tH\u0007J\u0008\u0010\n\u001a\u00020\tH\u0007J\u0008\u0010\u000b\u001a\u00020\tH\u0007J\u0008\u0010\u000c\u001a\u00020\tH\u0007J\u0008\u0010\r\u001a\u00020\tH\u0007J\u0008\u0010\u000e\u001a\u00020\tH\u0007J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0007J\u0008\u0010\u0013\u001a\u00020\tH\u0007J\u0008\u0010\u0014\u001a\u00020\tH\u0007J\u0008\u0010\u0015\u001a\u00020\tH\u0007J\u0008\u0010\u0016\u001a\u00020\tH\u0007J\u0008\u0010\u0017\u001a\u00020\tH\u0007J\u0008\u0010\u0018\u001a\u00020\tH\u0007J\u0008\u0010\u0019\u001a\u00020\tH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Landroidx/core/os/BuildCompat;", "", "()V", "AD_SERVICES_EXTENSION_INT", "", "R_EXTENSION_INT", "S_EXTENSION_INT", "T_EXTENSION_INT", "isAtLeastB", "", "isAtLeastN", "isAtLeastNMR1", "isAtLeastO", "isAtLeastOMR1", "isAtLeastP", "isAtLeastPreReleaseCodename", "codename", "", "buildCodename", "isAtLeastQ", "isAtLeastR", "isAtLeastS", "isAtLeastSv2", "isAtLeastT", "isAtLeastU", "isAtLeastV", "Api30Impl", "PrereleaseSdkCheck", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BuildCompat {

    public static final int AD_SERVICES_EXTENSION_INT;
    public static final androidx.core.os.BuildCompat INSTANCE;
    public static final int R_EXTENSION_INT = 0;
    public static final int S_EXTENSION_INT = 0;
    public static final int T_EXTENSION_INT = 0;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006", d2 = {"Landroidx/core/os/BuildCompat$Api30Impl;", "", "()V", "getExtensionVersion", "", "extension", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Api30Impl {

        public static final androidx.core.os.BuildCompat.Api30Impl INSTANCE;
        static {
            BuildCompat.Api30Impl api30Impl = new BuildCompat.Api30Impl();
            BuildCompat.Api30Impl.INSTANCE = api30Impl;
        }

        public final int getExtensionVersion(int extension) {
            return SdkExtensions.getExtensionVersion(extension);
        }
    }

    @Retention(RetentionPolicy.CLASS)
    @Metadata(d1 = "\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\u0008\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002", d2 = {"Landroidx/core/os/BuildCompat$PrereleaseSdkCheck;", "", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(AnnotationRetention.BINARY)
    public @interface PrereleaseSdkCheck {
    }
    static {
        androidx.core.os.BuildCompat.Api30Impl iNSTANCE;
        int extensionVersion;
        BuildCompat buildCompat = new BuildCompat();
        BuildCompat.INSTANCE = buildCompat;
        extensionVersion = 0;
        final int i5 = 30;
        if (Build.VERSION.SDK_INT >= i5) {
            int extensionVersion4 = BuildCompat.Api30Impl.INSTANCE.getExtensionVersion(i5);
        }
        int i = extensionVersion;
        if (Build.VERSION.SDK_INT >= i5) {
            int extensionVersion2 = BuildCompat.Api30Impl.INSTANCE.getExtensionVersion(31);
        }
        int i2 = extensionVersion;
        if (Build.VERSION.SDK_INT >= i5) {
            int extensionVersion3 = BuildCompat.Api30Impl.INSTANCE.getExtensionVersion(33);
        }
        int i3 = extensionVersion;
        if (Build.VERSION.SDK_INT >= i5) {
            extensionVersion = BuildCompat.Api30Impl.INSTANCE.getExtensionVersion(1000000);
        } else {
        }
        BuildCompat.AD_SERVICES_EXTENSION_INT = extensionVersion;
    }

    @JvmStatic
    public static final boolean isAtLeastB() {
        int atLeastPreReleaseCodename;
        int i;
        int str;
        if (Build.VERSION.SDK_INT < 36) {
            String cODENAME = Build.VERSION.CODENAME;
            Intrinsics.checkNotNullExpressionValue(cODENAME, "CODENAME");
            if (Build.VERSION.SDK_INT >= 35 && BuildCompat.isAtLeastPreReleaseCodename("Baklava", cODENAME)) {
                cODENAME = Build.VERSION.CODENAME;
                Intrinsics.checkNotNullExpressionValue(cODENAME, "CODENAME");
                if (BuildCompat.isAtLeastPreReleaseCodename("Baklava", cODENAME)) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Deprecated(message = "Android N is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 24`.", replaceWith = @ReplaceWith(...))
    @JvmStatic
    public static final boolean isAtLeastN() {
        return 1;
    }

    @Deprecated(message = "Android N MR1 is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 25`.", replaceWith = @ReplaceWith(...))
    @JvmStatic
    public static final boolean isAtLeastNMR1() {
        return 1;
    }

    @Deprecated(message = "Android O is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead use `Build.VERSION.SDK_INT >= 26`.", replaceWith = @ReplaceWith(...))
    @JvmStatic
    public static final boolean isAtLeastO() {
        return 1;
    }

    @Deprecated(message = "Android O MR1 is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 27`.", replaceWith = @ReplaceWith(...))
    @JvmStatic
    public static final boolean isAtLeastOMR1() {
        return 1;
    }

    @Deprecated(message = "Android P is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 28`.", replaceWith = @ReplaceWith(...))
    @JvmStatic
    public static final boolean isAtLeastP() {
        return 1;
    }

    @JvmStatic
    public static final boolean isAtLeastPreReleaseCodename(String codename, String buildCodename) {
        int i;
        Intrinsics.checkNotNullParameter(codename, "codename");
        Intrinsics.checkNotNullParameter(buildCodename, "buildCodename");
        if (Intrinsics.areEqual("REL", buildCodename)) {
            return 0;
        }
        Integer atLeastPreReleaseCodename$codenameToInt = BuildCompat.isAtLeastPreReleaseCodename$codenameToInt(buildCodename);
        final Integer atLeastPreReleaseCodename$codenameToInt2 = BuildCompat.isAtLeastPreReleaseCodename$codenameToInt(codename);
        final int i2 = 1;
        if (atLeastPreReleaseCodename$codenameToInt != null && atLeastPreReleaseCodename$codenameToInt2 != null && atLeastPreReleaseCodename$codenameToInt.intValue() >= atLeastPreReleaseCodename$codenameToInt2.intValue()) {
            if (atLeastPreReleaseCodename$codenameToInt2 != null) {
                if (atLeastPreReleaseCodename$codenameToInt.intValue() >= atLeastPreReleaseCodename$codenameToInt2.intValue()) {
                    i = i2;
                }
                return i;
            }
        }
        String upperCase = buildCodename.toUpperCase(Locale.ROOT);
        String str4 = "this as java.lang.String).toUpperCase(Locale.ROOT)";
        Intrinsics.checkNotNullExpressionValue(upperCase, str4);
        String upperCase2 = codename.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase2, str4);
        if (atLeastPreReleaseCodename$codenameToInt == null && atLeastPreReleaseCodename$codenameToInt2 == null && upperCase.compareTo(upperCase2) >= 0) {
            if (atLeastPreReleaseCodename$codenameToInt2 == null) {
                upperCase = buildCodename.toUpperCase(Locale.ROOT);
                str4 = "this as java.lang.String).toUpperCase(Locale.ROOT)";
                Intrinsics.checkNotNullExpressionValue(upperCase, str4);
                upperCase2 = codename.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase2, str4);
                if (upperCase.compareTo(upperCase2) >= 0) {
                    i = i2;
                }
                return i;
            }
        }
        if (atLeastPreReleaseCodename$codenameToInt != null) {
            i = i2;
        }
        return i;
    }

    private static final Integer isAtLeastPreReleaseCodename$codenameToInt(String codename) {
        Integer valueOf;
        String upperCase = codename.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (Intrinsics.areEqual(upperCase, "BAKLAVA")) {
            valueOf = 0;
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    @Deprecated(message = "Android Q is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 29`.", replaceWith = @ReplaceWith(...))
    @JvmStatic
    public static final boolean isAtLeastQ() {
        return 1;
    }

    @Deprecated(message = "Android R is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 30`.", replaceWith = @ReplaceWith(...))
    @JvmStatic
    public static final boolean isAtLeastR() {
        int i;
        i = Build.VERSION.SDK_INT >= 30 ? 1 : 0;
        return i;
    }

    @Deprecated(message = "Android S is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 31`.", replaceWith = @ReplaceWith(...))
    @JvmStatic
    public static final boolean isAtLeastS() {
        int atLeastPreReleaseCodename;
        int i;
        int str;
        if (Build.VERSION.SDK_INT < 31) {
            String cODENAME = Build.VERSION.CODENAME;
            Intrinsics.checkNotNullExpressionValue(cODENAME, "CODENAME");
            if (Build.VERSION.SDK_INT >= 30 && BuildCompat.isAtLeastPreReleaseCodename("S", cODENAME)) {
                cODENAME = Build.VERSION.CODENAME;
                Intrinsics.checkNotNullExpressionValue(cODENAME, "CODENAME");
                if (BuildCompat.isAtLeastPreReleaseCodename("S", cODENAME)) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Deprecated(message = "Android Sv2 is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 32`.", replaceWith = @ReplaceWith(...))
    @JvmStatic
    public static final boolean isAtLeastSv2() {
        int atLeastPreReleaseCodename;
        int i;
        int str;
        if (Build.VERSION.SDK_INT < 32) {
            String cODENAME = Build.VERSION.CODENAME;
            Intrinsics.checkNotNullExpressionValue(cODENAME, "CODENAME");
            if (Build.VERSION.SDK_INT >= 31 && BuildCompat.isAtLeastPreReleaseCodename("Sv2", cODENAME)) {
                cODENAME = Build.VERSION.CODENAME;
                Intrinsics.checkNotNullExpressionValue(cODENAME, "CODENAME");
                if (BuildCompat.isAtLeastPreReleaseCodename("Sv2", cODENAME)) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Deprecated(message = "Android Tiramisu is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 33`.", replaceWith = @ReplaceWith(...))
    @JvmStatic
    public static final boolean isAtLeastT() {
        int atLeastPreReleaseCodename;
        int i;
        int str;
        if (Build.VERSION.SDK_INT < 33) {
            String cODENAME = Build.VERSION.CODENAME;
            Intrinsics.checkNotNullExpressionValue(cODENAME, "CODENAME");
            if (Build.VERSION.SDK_INT >= 32 && BuildCompat.isAtLeastPreReleaseCodename("Tiramisu", cODENAME)) {
                cODENAME = Build.VERSION.CODENAME;
                Intrinsics.checkNotNullExpressionValue(cODENAME, "CODENAME");
                if (BuildCompat.isAtLeastPreReleaseCodename("Tiramisu", cODENAME)) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Deprecated(message = "Android UpsideDownCase is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 34`.", replaceWith = @ReplaceWith(...))
    @JvmStatic
    public static final boolean isAtLeastU() {
        int atLeastPreReleaseCodename;
        int i;
        int str;
        if (Build.VERSION.SDK_INT < 34) {
            String cODENAME = Build.VERSION.CODENAME;
            Intrinsics.checkNotNullExpressionValue(cODENAME, "CODENAME");
            if (Build.VERSION.SDK_INT >= 33 && BuildCompat.isAtLeastPreReleaseCodename("UpsideDownCake", cODENAME)) {
                cODENAME = Build.VERSION.CODENAME;
                Intrinsics.checkNotNullExpressionValue(cODENAME, "CODENAME");
                if (BuildCompat.isAtLeastPreReleaseCodename("UpsideDownCake", cODENAME)) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Deprecated(message = "Android VanillaIceCream is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 35`.", replaceWith = @ReplaceWith(...))
    @JvmStatic
    public static final boolean isAtLeastV() {
        int atLeastPreReleaseCodename;
        int i;
        int str;
        if (Build.VERSION.SDK_INT < 35) {
            String cODENAME = Build.VERSION.CODENAME;
            Intrinsics.checkNotNullExpressionValue(cODENAME, "CODENAME");
            if (Build.VERSION.SDK_INT >= 34 && BuildCompat.isAtLeastPreReleaseCodename("VanillaIceCream", cODENAME)) {
                cODENAME = Build.VERSION.CODENAME;
                Intrinsics.checkNotNullExpressionValue(cODENAME, "CODENAME");
                if (BuildCompat.isAtLeastPreReleaseCodename("VanillaIceCream", cODENAME)) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }
}
