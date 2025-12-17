package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.util.Log;
import androidx.core.provider.FontRequest;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class DefaultEmojiCompatConfig {

    public static class DefaultEmojiCompatConfigFactory {

        private static final String DEFAULT_EMOJI_QUERY = "emojicompat-emoji-font";
        private static final String INTENT_LOAD_EMOJI_FONT = "androidx.content.action.LOAD_EMOJI_FONT";
        private static final String TAG = "emoji2.text.DefaultEmojiConfig";
        private final androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper mHelper;
        public DefaultEmojiCompatConfigFactory(androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper helper) {
            androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper helperForApi;
            super();
            if (helper != null) {
                helperForApi = helper;
            } else {
                helperForApi = DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory.getHelperForApi();
            }
            this.mHelper = helperForApi;
        }

        private androidx.emoji2.text.EmojiCompat.Config configOrNull(Context context, FontRequest fontRequest) {
            if (fontRequest == null) {
                return null;
            }
            FontRequestEmojiCompatConfig fontRequestEmojiCompatConfig = new FontRequestEmojiCompatConfig(context, fontRequest);
            return fontRequestEmojiCompatConfig;
        }

        private List<List<byte[]>> convertToByteArray(Signature[] signatures) {
            int i;
            Object obj;
            byte[] byteArray;
            ArrayList arrayList = new ArrayList();
            i = 0;
            while (i < signatures.length) {
                arrayList.add(signatures[i].toByteArray());
                i++;
            }
            return Collections.singletonList(arrayList);
        }

        private FontRequest generateFontRequestFrom(ProviderInfo providerInfo, PackageManager packageManager) throws PackageManager.NameNotFoundException {
            final String packageName = providerInfo.packageName;
            FontRequest fontRequest = new FontRequest(providerInfo.authority, packageName, "emojicompat-emoji-font", convertToByteArray(this.mHelper.getSigningSignatures(packageManager, packageName)));
            return fontRequest;
        }

        private static androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper getHelperForApi() {
            DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper_API28 defaultEmojiCompatConfigHelper_API28 = new DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper_API28();
            return defaultEmojiCompatConfigHelper_API28;
        }

        private boolean hasFlagSystem(ProviderInfo providerInfo) {
            int applicationInfo;
            int i;
            i = 1;
            if (providerInfo != null && providerInfo.applicationInfo != null && flags &= i == i) {
                if (providerInfo.applicationInfo != null) {
                    i = 1;
                    if (flags &= i == i) {
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        private ProviderInfo queryDefaultInstalledContentProvider(PackageManager packageManager) {
            int next;
            ProviderInfo providerInfo;
            boolean flagSystem;
            Intent intent = new Intent("androidx.content.action.LOAD_EMOJI_FONT");
            Iterator iterator = this.mHelper.queryIntentContentProviders(packageManager, intent, 0).iterator();
            for (ResolveInfo next : iterator) {
                providerInfo = this.mHelper.getProviderInfo(next);
            }
            return null;
        }

        public androidx.emoji2.text.EmojiCompat.Config create(Context context) {
            return configOrNull(context, queryForDefaultFontRequest(context));
        }

        FontRequest queryForDefaultFontRequest(Context context) {
            final PackageManager packageManager = context.getPackageManager();
            Preconditions.checkNotNull(packageManager, "Package manager required to locate emoji font provider");
            ProviderInfo defaultInstalledContentProvider = queryDefaultInstalledContentProvider(packageManager);
            if (defaultInstalledContentProvider == null) {
                return null;
            }
            return generateFontRequestFrom(defaultInstalledContentProvider, packageManager);
        }
    }

    public static class DefaultEmojiCompatConfigHelper {
        public ProviderInfo getProviderInfo(ResolveInfo resolveInfo) {
            IllegalStateException illegalStateException = new IllegalStateException("Unable to get provider info prior to API 19");
            throw illegalStateException;
        }

        public Signature[] getSigningSignatures(PackageManager packageManager, String providerPackage) throws PackageManager.NameNotFoundException {
            return packageInfo.signatures;
        }

        public List<ResolveInfo> queryIntentContentProviders(PackageManager packageManager, Intent intent, int flags) {
            return Collections.emptyList();
        }
    }

    public static class DefaultEmojiCompatConfigHelper_API19 extends androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper {
        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig$DefaultEmojiCompatConfigHelper
        public ProviderInfo getProviderInfo(ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }

        public List<ResolveInfo> queryIntentContentProviders(PackageManager packageManager, Intent intent, int flags) {
            return packageManager.queryIntentContentProviders(intent, flags);
        }
    }

    public static class DefaultEmojiCompatConfigHelper_API28 extends androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper_API19 {
        public Signature[] getSigningSignatures(PackageManager packageManager, String providerPackage) throws PackageManager.NameNotFoundException {
            return packageInfo.signatures;
        }
    }
    public static androidx.emoji2.text.FontRequestEmojiCompatConfig create(Context context) {
        DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory defaultEmojiCompatConfigFactory = new DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory(0);
        return (FontRequestEmojiCompatConfig)defaultEmojiCompatConfigFactory.create(context);
    }
}
