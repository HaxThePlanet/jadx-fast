package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;

/* loaded from: classes2.dex */
public final class b implements BreadcrumbHandler {

    public final com.google.firebase.crashlytics.internal.common.CrashlyticsCore a;
    public b(com.google.firebase.crashlytics.internal.common.CrashlyticsCore crashlyticsCore) {
        super();
        this.a = crashlyticsCore;
    }

    @Override // com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler
    public final void handleBreadcrumb(String string) {
        this.a.log(string);
    }
}
