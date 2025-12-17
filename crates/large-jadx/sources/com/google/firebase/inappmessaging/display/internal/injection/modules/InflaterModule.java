package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.dagger.Module;
import com.google.firebase.inappmessaging.display.dagger.Provides;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* loaded from: classes2.dex */
@Module
public class InflaterModule {

    private final Application application;
    private final InAppMessage inAppMessage;
    private final InAppMessageLayoutConfig inAppMessageLayoutConfig;
    public InflaterModule(InAppMessage inAppMessage, InAppMessageLayoutConfig inAppMessageLayoutConfig2, Application application3) {
        super();
        this.inAppMessage = inAppMessage;
        this.inAppMessageLayoutConfig = inAppMessageLayoutConfig2;
        this.application = application3;
    }

    @Provides
    InAppMessageLayoutConfig inAppMessageLayoutConfig() {
        return this.inAppMessageLayoutConfig;
    }

    @Provides
    InAppMessage providesBannerMessage() {
        return this.inAppMessage;
    }

    @Provides
    public LayoutInflater providesInflaterservice() {
        return (LayoutInflater)this.application.getSystemService("layout_inflater");
    }
}
