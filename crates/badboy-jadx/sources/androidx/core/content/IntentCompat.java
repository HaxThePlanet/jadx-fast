package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class IntentCompat {

    public static final String ACTION_CREATE_REMINDER = "android.intent.action.CREATE_REMINDER";
    public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";
    public static final String EXTRA_TIME = "android.intent.extra.TIME";

    static class Api33Impl {
        static <T> T[] getParcelableArrayExtra(Intent in, String name, Class<T> class3) {
            return in.getParcelableArrayExtra(name, class3);
        }

        static <T> ArrayList<T> getParcelableArrayListExtra(Intent in, String name, Class<? extends T> class3) {
            return in.getParcelableArrayListExtra(name, class3);
        }

        static <T> T getParcelableExtra(Intent in, String name, Class<T> class3) {
            return in.getParcelableExtra(name, class3);
        }

        static <T extends java.io.Serializable> T getSerializableExtra(Intent in, String name, Class<T> class3) {
            return in.getSerializableExtra(name, class3);
        }
    }
    public static Intent createManageUnusedAppRestrictionsIntent(Context context, String packageName) {
        if (!PackageManagerCompat.areUnusedAppRestrictionsAvailable(context.getPackageManager())) {
        } else {
            int i2 = 0;
            final String str4 = "package";
            if (Build.VERSION.SDK_INT >= 31) {
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                return intent2.setData(Uri.fromParts(str4, packageName, i2));
            }
            Intent intent = new Intent("android.intent.action.AUTO_REVOKE_PERMISSIONS");
            Intent data = intent.setData(Uri.fromParts(str4, packageName, i2));
            if (Build.VERSION.SDK_INT >= 30) {
                return data;
            }
            return data.setPackage((String)Preconditions.checkNotNull(PackageManagerCompat.getPermissionRevocationVerifierApp(context.getPackageManager())));
        }
        UnsupportedOperationException permissionRevocationSettingsIntent = new UnsupportedOperationException("Unused App Restriction features are not available on this device");
        throw permissionRevocationSettingsIntent;
    }

    public static Parcelable[] getParcelableArrayExtra(Intent in, String name, Class<? extends Parcelable> class3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return (Parcelable[])IntentCompat.Api33Impl.getParcelableArrayExtra(in, name, class3);
        }
        return in.getParcelableArrayExtra(name);
    }

    public static <T> ArrayList<T> getParcelableArrayListExtra(Intent in, String name, Class<? extends T> class3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return IntentCompat.Api33Impl.getParcelableArrayListExtra(in, name, class3);
        }
        return in.getParcelableArrayListExtra(name);
    }

    public static <T> T getParcelableExtra(Intent in, String name, Class<T> class3) {
        Parcelable parcelable;
        if (Build.VERSION.SDK_INT >= 34) {
            return IntentCompat.Api33Impl.getParcelableExtra(in, name, class3);
        }
        Parcelable parcelableExtra2 = in.getParcelableExtra(name);
        parcelable = class3.isInstance(parcelableExtra2) ? parcelableExtra2 : 0;
        return parcelable;
    }

    public static <T extends java.io.Serializable> T getSerializableExtra(Intent in, String key, Class<T> class3) {
        java.io.Serializable serializable;
        if (Build.VERSION.SDK_INT >= 34) {
            return IntentCompat.Api33Impl.getSerializableExtra(in, key, class3);
        }
        java.io.Serializable serializableExtra2 = in.getSerializableExtra(key);
        serializable = class3.isInstance(serializableExtra2) ? serializableExtra2 : 0;
        return serializable;
    }

    public static Intent makeMainSelectorActivity(String selectorAction, String selectorCategory) {
        return Intent.makeMainSelectorActivity(selectorAction, selectorCategory);
    }
}
