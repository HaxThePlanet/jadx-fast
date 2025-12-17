package com.google.firebase.dynamiclinks.internal;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.a.d.c;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.u;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.d;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.m;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.dynamiclinks.DynamicLink.Builder;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import com.google.firebase.inject.Provider;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public class FirebaseDynamicLinksImpl extends FirebaseDynamicLinks {

    private static final String ANALYTICS_FDL_ORIGIN = "fdl";
    public static final String EXTRA_DYNAMIC_LINK_DATA = "com.google.firebase.dynamiclinks.DYNAMIC_LINK_DATA";
    public static final String KEY_SCION_DATA = "scionData";
    private static final String TAG = "FDL";
    private final Provider<AnalyticsConnector> analytics;
    private final FirebaseApp firebaseApp;
    private final c<a.d.c> googleApi;

    static final class CreateShortDynamicLinkImpl extends t<com.google.firebase.dynamiclinks.internal.DynamicLinksClient, ShortDynamicLink> {

        private final Bundle builderParameters;
        CreateShortDynamicLinkImpl(Bundle bundle) {
            super(0, 0, 13202);
            this.builderParameters = bundle;
        }

        @Override // com.google.android.gms.common.api.internal.t
        protected void doExecute(a.b a$b, k k2) {
            doExecute((DynamicLinksClient)b, k2);
        }

        protected void doExecute(com.google.firebase.dynamiclinks.internal.DynamicLinksClient dynamicLinksClient, k<ShortDynamicLink> k2) {
            FirebaseDynamicLinksImpl.CreateShortDynamicLinkCallbacks createShortDynamicLinkCallbacks = new FirebaseDynamicLinksImpl.CreateShortDynamicLinkCallbacks(k2);
            dynamicLinksClient.createShortDynamicLink(createShortDynamicLinkCallbacks, this.builderParameters);
        }
    }

    static final class GetDynamicLinkImpl extends t<com.google.firebase.dynamiclinks.internal.DynamicLinksClient, PendingDynamicLinkData> {

        private final Provider<AnalyticsConnector> analytics;
        private final String dynamicLink;
        GetDynamicLinkImpl(Provider<AnalyticsConnector> provider, String string2) {
            super(0, 0, 13201);
            this.dynamicLink = string2;
            this.analytics = provider;
        }

        @Override // com.google.android.gms.common.api.internal.t
        protected void doExecute(a.b a$b, k k2) {
            doExecute((DynamicLinksClient)b, k2);
        }

        protected void doExecute(com.google.firebase.dynamiclinks.internal.DynamicLinksClient dynamicLinksClient, k<PendingDynamicLinkData> k2) {
            FirebaseDynamicLinksImpl.DynamicLinkCallbacks dynamicLinkCallbacks = new FirebaseDynamicLinksImpl.DynamicLinkCallbacks(this.analytics, k2);
            dynamicLinksClient.getDynamicLink(dynamicLinkCallbacks, this.dynamicLink);
        }
    }

    static class AbstractDynamicLinkCallbacks extends com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks.Stub {
        @Override // com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks$Stub
        public void onCreateShortDynamicLink(Status status, com.google.firebase.dynamiclinks.internal.ShortDynamicLinkImpl shortDynamicLinkImpl2) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        @Override // com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks$Stub
        public void onGetDynamicLink(Status status, com.google.firebase.dynamiclinks.internal.DynamicLinkData dynamicLinkData2) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }
    }

    static class CreateShortDynamicLinkCallbacks extends com.google.firebase.dynamiclinks.internal.FirebaseDynamicLinksImpl.AbstractDynamicLinkCallbacks {

        private final k<ShortDynamicLink> completionSource;
        CreateShortDynamicLinkCallbacks(k<ShortDynamicLink> k) {
            super();
            this.completionSource = k;
        }

        @Override // com.google.firebase.dynamiclinks.internal.FirebaseDynamicLinksImpl$AbstractDynamicLinkCallbacks
        public void onCreateShortDynamicLink(Status status, com.google.firebase.dynamiclinks.internal.ShortDynamicLinkImpl shortDynamicLinkImpl2) {
            u.b(status, shortDynamicLinkImpl2, this.completionSource);
        }
    }

    static class DynamicLinkCallbacks extends com.google.firebase.dynamiclinks.internal.FirebaseDynamicLinksImpl.AbstractDynamicLinkCallbacks {

        private final Provider<AnalyticsConnector> analytics;
        private final k<PendingDynamicLinkData> completionSource;
        public DynamicLinkCallbacks(Provider<AnalyticsConnector> provider, k<PendingDynamicLinkData> k2) {
            super();
            this.analytics = provider;
            this.completionSource = k2;
        }

        @Override // com.google.firebase.dynamiclinks.internal.FirebaseDynamicLinksImpl$AbstractDynamicLinkCallbacks
        public void onGetDynamicLink(Status status, com.google.firebase.dynamiclinks.internal.DynamicLinkData dynamicLinkData2) {
            PendingDynamicLinkData pendingDynamicLinkData;
            k completionSource;
            Bundle bundle;
            String str;
            Object obj6;
            if (dynamicLinkData2 == null) {
                pendingDynamicLinkData = 0;
            } else {
                pendingDynamicLinkData = new PendingDynamicLinkData(dynamicLinkData2);
            }
            u.b(status, pendingDynamicLinkData, this.completionSource);
            if (dynamicLinkData2 == null) {
            }
            Bundle obj5 = dynamicLinkData2.getExtensionBundle().getBundle("scionData");
            if (obj5 != null) {
                if (obj5.keySet() == null) {
                } else {
                    obj6 = this.analytics.get();
                    if ((AnalyticsConnector)obj6 == null) {
                    }
                    pendingDynamicLinkData = obj5.keySet().iterator();
                    for (String completionSource : pendingDynamicLinkData) {
                        (AnalyticsConnector)obj6.logEvent("fdl", completionSource, obj5.getBundle(completionSource));
                    }
                }
            }
        }
    }
    public FirebaseDynamicLinksImpl(c<a.d.c> c, FirebaseApp firebaseApp2, Provider<AnalyticsConnector> provider3) {
        Object obj1;
        Object obj2;
        super();
        this.googleApi = c;
        r.j(firebaseApp2);
        this.firebaseApp = (FirebaseApp)firebaseApp2;
        this.analytics = provider3;
        if (provider3.get() == null) {
            Log.w("FDL", "FDL logging failed. Add a dependency for Firebase Analytics to your app to enable logging of Dynamic Link events.");
        }
    }

    public FirebaseDynamicLinksImpl(FirebaseApp firebaseApp, Provider<AnalyticsConnector> provider2) {
        DynamicLinksApi dynamicLinksApi = new DynamicLinksApi(firebaseApp.getApplicationContext());
        super(dynamicLinksApi, firebaseApp, provider2);
    }

    public static Uri createDynamicLink(Bundle bundle) {
        Object parcelable;
        Object iterator;
        String authority;
        Object string;
        Bundle obj4;
        FirebaseDynamicLinksImpl.verifyDomainUriPrefix(bundle);
        Uri.Builder builder = new Uri.Builder();
        String string2 = bundle.getString("domainUriPrefix");
        r.j(string2);
        Uri parse = Uri.parse((String)string2);
        builder.scheme(parse.getScheme());
        builder.authority(parse.getAuthority());
        builder.path(parse.getPath());
        obj4 = bundle.getBundle("parameters");
        if ((Uri)bundle.getParcelable("dynamicLink") == null && obj4 != null) {
            builder = new Uri.Builder();
            string2 = bundle.getString("domainUriPrefix");
            r.j(string2);
            parse = Uri.parse((String)string2);
            builder.scheme(parse.getScheme());
            builder.authority(parse.getAuthority());
            builder.path(parse.getPath());
            obj4 = bundle.getBundle("parameters");
            if (obj4 != null) {
                iterator = obj4.keySet().iterator();
                while (iterator.hasNext()) {
                    authority = iterator.next();
                    string = obj4.get((String)authority);
                    if (string != null) {
                    }
                    builder.appendQueryParameter(authority, string.toString());
                }
            }
            parcelable = builder.build();
        }
        return parcelable;
    }

    public static void verifyDomainUriPrefix(Bundle bundle) {
        if (TextUtils.isEmpty(bundle.getString("domainUriPrefix"))) {
            if ((Uri)bundle.getParcelable("dynamicLink") == null) {
            } else {
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("FDL domain is missing. Set with setDomainUriPrefix() or setDynamicLinkDomain().");
            throw obj2;
        }
    }

    @Override // com.google.firebase.dynamiclinks.FirebaseDynamicLinks
    public DynamicLink.Builder createDynamicLink() {
        DynamicLink.Builder builder = new DynamicLink.Builder(this);
        return builder;
    }

    public j<ShortDynamicLink> createShortDynamicLink(Bundle bundle) {
        FirebaseDynamicLinksImpl.verifyDomainUriPrefix(bundle);
        FirebaseDynamicLinksImpl.CreateShortDynamicLinkImpl createShortDynamicLinkImpl = new FirebaseDynamicLinksImpl.CreateShortDynamicLinkImpl(bundle);
        return this.googleApi.doWrite(createShortDynamicLinkImpl);
    }

    public j<PendingDynamicLinkData> getDynamicLink(Intent intent) {
        String dataString;
        j doWrite;
        Object obj5;
        if (intent != null) {
            dataString = intent.getDataString();
        } else {
            dataString = 0;
        }
        FirebaseDynamicLinksImpl.GetDynamicLinkImpl getDynamicLinkImpl = new FirebaseDynamicLinksImpl.GetDynamicLinkImpl(this.analytics, dataString);
        doWrite = this.googleApi.doWrite(getDynamicLinkImpl);
        obj5 = getPendingDynamicLinkData(intent);
        if (intent != null && obj5 != null) {
            obj5 = getPendingDynamicLinkData(intent);
            if (obj5 != null) {
                doWrite = m.e(obj5);
            }
        }
        return doWrite;
    }

    public j<PendingDynamicLinkData> getDynamicLink(Uri uri) {
        FirebaseDynamicLinksImpl.GetDynamicLinkImpl getDynamicLinkImpl = new FirebaseDynamicLinksImpl.GetDynamicLinkImpl(this.analytics, uri.toString());
        return this.googleApi.doWrite(getDynamicLinkImpl);
    }

    @Override // com.google.firebase.dynamiclinks.FirebaseDynamicLinks
    public FirebaseApp getFirebaseApp() {
        return this.firebaseApp;
    }

    @Override // com.google.firebase.dynamiclinks.FirebaseDynamicLinks
    public PendingDynamicLinkData getPendingDynamicLinkData(Intent intent) {
        PendingDynamicLinkData pendingDynamicLinkData;
        final com.google.android.gms.common.internal.safeparcel.c obj3 = d.b(intent, "com.google.firebase.dynamiclinks.DYNAMIC_LINK_DATA", DynamicLinkData.CREATOR);
        if ((DynamicLinkData)obj3 != null) {
            pendingDynamicLinkData = new PendingDynamicLinkData((DynamicLinkData)obj3);
        } else {
            pendingDynamicLinkData = 0;
        }
        return pendingDynamicLinkData;
    }
}
