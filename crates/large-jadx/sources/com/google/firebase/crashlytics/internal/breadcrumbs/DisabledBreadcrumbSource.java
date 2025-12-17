package com.google.firebase.crashlytics.internal.breadcrumbs;

import com.google.firebase.crashlytics.internal.Logger;

/* loaded from: classes2.dex */
public class DisabledBreadcrumbSource implements com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource {
    @Override // com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource
    public void registerBreadcrumbHandler(com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler breadcrumbHandler) {
        Logger.getLogger().d("Could not register handler for breadcrumbs events.");
    }
}
