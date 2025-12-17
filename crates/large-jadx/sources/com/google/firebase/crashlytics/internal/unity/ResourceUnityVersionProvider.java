package com.google.firebase.crashlytics.internal.unity;

import android.content.Context;
import android.content.res.Resources;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;

/* loaded from: classes2.dex */
public class ResourceUnityVersionProvider implements com.google.firebase.crashlytics.internal.unity.UnityVersionProvider {

    private static final String UNITY_EDITOR_VERSION = "com.google.firebase.crashlytics.unity_version";
    private static boolean isUnityVersionSet = false;
    private static String unityVersion;
    private final Context context;
    static {
    }

    public ResourceUnityVersionProvider(Context context) {
        super();
        this.context = context;
    }

    public static String resolveUnityEditorVersion(Context context) {
        int resourcesIdentifier;
        String unityVersion;
        Object obj3;
        final Class<com.google.firebase.crashlytics.internal.unity.ResourceUnityVersionProvider> obj = ResourceUnityVersionProvider.class;
        synchronized (obj) {
            return ResourceUnityVersionProvider.unityVersion;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.unity.UnityVersionProvider
    public String getUnityVersion() {
        return ResourceUnityVersionProvider.resolveUnityEditorVersion(this.context);
    }
}
