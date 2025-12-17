package com.google.firebase.crashlytics;

import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;

/* loaded from: classes2.dex */
public final class c implements BreadcrumbSource {

    public final com.google.firebase.crashlytics.AnalyticsDeferredProxy a;
    public c(com.google.firebase.crashlytics.AnalyticsDeferredProxy analyticsDeferredProxy) {
        super();
        this.a = analyticsDeferredProxy;
    }

    @Override // com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource
    public final void registerBreadcrumbHandler(BreadcrumbHandler breadcrumbHandler) {
        this.a.d(breadcrumbHandler);
    }
}
