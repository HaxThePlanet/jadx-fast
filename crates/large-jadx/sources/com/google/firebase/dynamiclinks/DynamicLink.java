package com.google.firebase.dynamiclinks;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.tasks.j;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.dynamiclinks.internal.FirebaseDynamicLinksImpl;

/* loaded from: classes2.dex */
public final class DynamicLink {

    private final Bundle builderParameters;

    public static final class AndroidParameters {

        public static final String KEY_ANDROID_FALLBACK_LINK = "afl";
        public static final String KEY_ANDROID_MIN_VERSION_CODE = "amv";
        public static final String KEY_ANDROID_PACKAGE_NAME = "apn";
        final Bundle parameters;
        private AndroidParameters(Bundle bundle) {
            super();
            this.parameters = bundle;
        }

        AndroidParameters(Bundle bundle, com.google.firebase.dynamiclinks.DynamicLink.1 dynamicLink$12) {
            super(bundle);
        }
    }

    public static final class Builder {

        private static final String APP_GOO_GL_PATTERN = "(https:\\/\\/)?[a-z0-9]{3,}\\.app\\.goo\\.gl$";
        public static final String KEY_API_KEY = "apiKey";
        public static final String KEY_DOMAIN = "domain";
        public static final String KEY_DOMAIN_URI_PREFIX = "domainUriPrefix";
        public static final String KEY_DYNAMIC_LINK = "dynamicLink";
        public static final String KEY_DYNAMIC_LINK_PARAMETERS = "parameters";
        public static final String KEY_LINK = "link";
        public static final String KEY_SUFFIX = "suffix";
        private static final String PAGE_LINK_PATTERN = "(https:\\/\\/)?[a-z0-9]{3,}\\.page\\.link$";
        private static final String SCHEME_PREFIX = "https://";
        private final Bundle builderParameters;
        private final Bundle fdlParameters;
        private final FirebaseDynamicLinksImpl firebaseDynamicLinksImpl;
        public Builder(FirebaseDynamicLinksImpl firebaseDynamicLinksImpl) {
            super();
            this.firebaseDynamicLinksImpl = firebaseDynamicLinksImpl;
            Bundle bundle = new Bundle();
            this.builderParameters = bundle;
            bundle.putString("apiKey", firebaseDynamicLinksImpl.getFirebaseApp().getOptions().getApiKey());
            Bundle obj3 = new Bundle();
            this.fdlParameters = obj3;
            bundle.putBundle("parameters", obj3);
        }

        private void verifyApiKey() {
            if (this.builderParameters.getString("apiKey") == null) {
            } else {
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Missing API key. Set with setApiKey().");
            throw illegalArgumentException;
        }

        public com.google.firebase.dynamiclinks.DynamicLink buildDynamicLink() {
            FirebaseDynamicLinksImpl.verifyDomainUriPrefix(this.builderParameters);
            DynamicLink dynamicLink = new DynamicLink(this.builderParameters);
            return dynamicLink;
        }

        public j<com.google.firebase.dynamiclinks.ShortDynamicLink> buildShortDynamicLink() {
            verifyApiKey();
            return this.firebaseDynamicLinksImpl.createShortDynamicLink(this.builderParameters);
        }

        public j<com.google.firebase.dynamiclinks.ShortDynamicLink> buildShortDynamicLink(int i) {
            verifyApiKey();
            this.builderParameters.putInt("suffix", i);
            return this.firebaseDynamicLinksImpl.createShortDynamicLink(this.builderParameters);
        }

        public String getDomainUriPrefix() {
            return this.builderParameters.getString("domainUriPrefix", "");
        }

        public Uri getLink() {
            Object parcelable;
            if ((Uri)this.fdlParameters.getParcelable("link") == null) {
                parcelable = Uri.EMPTY;
            }
            return parcelable;
        }

        public Uri getLongLink() {
            Object parcelable;
            if ((Uri)this.fdlParameters.getParcelable("dynamicLink") == null) {
                parcelable = Uri.EMPTY;
            }
            return parcelable;
        }

        public com.google.firebase.dynamiclinks.DynamicLink.Builder setAndroidParameters(com.google.firebase.dynamiclinks.DynamicLink.AndroidParameters dynamicLink$AndroidParameters) {
            this.fdlParameters.putAll(androidParameters.parameters);
            return this;
        }

        public com.google.firebase.dynamiclinks.DynamicLink.Builder setDomainUriPrefix(String string) {
            boolean builderParameters;
            String replace;
            String str;
            if (!string.matches("(https:\\/\\/)?[a-z0-9]{3,}\\.app\\.goo\\.gl$")) {
                if (string.matches("(https:\\/\\/)?[a-z0-9]{3,}\\.page\\.link$")) {
                    this.builderParameters.putString("domain", string.replace("https://", ""));
                }
            } else {
            }
            this.builderParameters.putString("domainUriPrefix", string);
            return this;
        }

        @Deprecated
        public com.google.firebase.dynamiclinks.DynamicLink.Builder setDynamicLinkDomain(String string) {
            boolean matches;
            if (!string.matches("(https:\\/\\/)?[a-z0-9]{3,}\\.app\\.goo\\.gl$")) {
                if (!string.matches("(https:\\/\\/)?[a-z0-9]{3,}\\.page\\.link$")) {
                } else {
                }
                IllegalArgumentException obj4 = new IllegalArgumentException("Use setDomainUriPrefix() instead, setDynamicLinkDomain() is only applicable for *.page.link and *.app.goo.gl domains.");
                throw obj4;
            }
            this.builderParameters.putString("domain", string);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https://");
            stringBuilder.append(string);
            this.builderParameters.putString("domainUriPrefix", stringBuilder.toString());
            return this;
        }

        public com.google.firebase.dynamiclinks.DynamicLink.Builder setGoogleAnalyticsParameters(com.google.firebase.dynamiclinks.DynamicLink.GoogleAnalyticsParameters dynamicLink$GoogleAnalyticsParameters) {
            this.fdlParameters.putAll(googleAnalyticsParameters.parameters);
            return this;
        }

        public com.google.firebase.dynamiclinks.DynamicLink.Builder setIosParameters(com.google.firebase.dynamiclinks.DynamicLink.IosParameters dynamicLink$IosParameters) {
            this.fdlParameters.putAll(iosParameters.parameters);
            return this;
        }

        public com.google.firebase.dynamiclinks.DynamicLink.Builder setItunesConnectAnalyticsParameters(com.google.firebase.dynamiclinks.DynamicLink.ItunesConnectAnalyticsParameters dynamicLink$ItunesConnectAnalyticsParameters) {
            this.fdlParameters.putAll(itunesConnectAnalyticsParameters.parameters);
            return this;
        }

        public com.google.firebase.dynamiclinks.DynamicLink.Builder setLink(Uri uri) {
            this.fdlParameters.putParcelable("link", uri);
            return this;
        }

        public com.google.firebase.dynamiclinks.DynamicLink.Builder setLongLink(Uri uri) {
            this.builderParameters.putParcelable("dynamicLink", uri);
            return this;
        }

        public com.google.firebase.dynamiclinks.DynamicLink.Builder setNavigationInfoParameters(com.google.firebase.dynamiclinks.DynamicLink.NavigationInfoParameters dynamicLink$NavigationInfoParameters) {
            this.fdlParameters.putAll(navigationInfoParameters.parameters);
            return this;
        }

        public com.google.firebase.dynamiclinks.DynamicLink.Builder setSocialMetaTagParameters(com.google.firebase.dynamiclinks.DynamicLink.SocialMetaTagParameters dynamicLink$SocialMetaTagParameters) {
            this.fdlParameters.putAll(socialMetaTagParameters.parameters);
            return this;
        }
    }

    public static final class GoogleAnalyticsParameters {

        public static final String KEY_UTM_CAMPAIGN = "utm_campaign";
        public static final String KEY_UTM_CONTENT = "utm_content";
        public static final String KEY_UTM_MEDIUM = "utm_medium";
        public static final String KEY_UTM_SOURCE = "utm_source";
        public static final String KEY_UTM_TERM = "utm_term";
        Bundle parameters;
        private GoogleAnalyticsParameters(Bundle bundle) {
            super();
            this.parameters = bundle;
        }

        GoogleAnalyticsParameters(Bundle bundle, com.google.firebase.dynamiclinks.DynamicLink.1 dynamicLink$12) {
            super(bundle);
        }
    }

    public static final class IosParameters {

        public static final String KEY_IOS_APP_STORE_ID = "isi";
        public static final String KEY_IOS_BUNDLE_ID = "ibi";
        public static final String KEY_IOS_CUSTOM_SCHEME = "ius";
        public static final String KEY_IOS_FALLBACK_LINK = "ifl";
        public static final String KEY_IOS_MINIMUM_VERSION = "imv";
        public static final String KEY_IPAD_BUNDLE_ID = "ipbi";
        public static final String KEY_IPAD_FALLBACK_LINK = "ipfl";
        final Bundle parameters;
        private IosParameters(Bundle bundle) {
            super();
            this.parameters = bundle;
        }

        IosParameters(Bundle bundle, com.google.firebase.dynamiclinks.DynamicLink.1 dynamicLink$12) {
            super(bundle);
        }
    }

    public static final class ItunesConnectAnalyticsParameters {

        public static final String KEY_ITUNES_CONNECT_AT = "at";
        public static final String KEY_ITUNES_CONNECT_CT = "ct";
        public static final String KEY_ITUNES_CONNECT_PT = "pt";
        final Bundle parameters;
        private ItunesConnectAnalyticsParameters(Bundle bundle) {
            super();
            this.parameters = bundle;
        }

        ItunesConnectAnalyticsParameters(Bundle bundle, com.google.firebase.dynamiclinks.DynamicLink.1 dynamicLink$12) {
            super(bundle);
        }
    }

    public static final class NavigationInfoParameters {

        public static final String KEY_FORCED_REDIRECT = "efr";
        final Bundle parameters;
        private NavigationInfoParameters(Bundle bundle) {
            super();
            this.parameters = bundle;
        }

        NavigationInfoParameters(Bundle bundle, com.google.firebase.dynamiclinks.DynamicLink.1 dynamicLink$12) {
            super(bundle);
        }
    }

    public static final class SocialMetaTagParameters {

        public static final String KEY_SOCIAL_DESCRIPTION = "sd";
        public static final String KEY_SOCIAL_IMAGE_LINK = "si";
        public static final String KEY_SOCIAL_TITLE = "st";
        final Bundle parameters;
        private SocialMetaTagParameters(Bundle bundle) {
            super();
            this.parameters = bundle;
        }

        SocialMetaTagParameters(Bundle bundle, com.google.firebase.dynamiclinks.DynamicLink.1 dynamicLink$12) {
            super(bundle);
        }
    }
    DynamicLink(Bundle bundle) {
        super();
        this.builderParameters = bundle;
    }

    public Uri getUri() {
        return FirebaseDynamicLinksImpl.createDynamicLink(this.builderParameters);
    }
}
