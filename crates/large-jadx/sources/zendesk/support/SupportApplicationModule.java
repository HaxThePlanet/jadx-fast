package zendesk.support;

import android.content.Context;
import java.util.Locale;

/* loaded from: classes3.dex */
class SupportApplicationModule {

    private zendesk.support.ApplicationScope applicationScope;
    SupportApplicationModule(zendesk.support.ApplicationScope applicationScope) {
        super();
        this.applicationScope = applicationScope;
    }

    Locale provideLocale() {
        return this.applicationScope.getLocale();
    }

    zendesk.support.SupportSdkMetadata provideMetadata(Context context) {
        SupportSdkMetadata supportSdkMetadata = new SupportSdkMetadata(context);
        return supportSdkMetadata;
    }

    zendesk.support.ZendeskTracker providesZendeskTracker() {
        return this.applicationScope.getZendeskTracker();
    }
}
