package com.google.firebase.inappmessaging.display.internal.injection.components;

import android.app.Application;
import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.dagger.Component;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule;
import j.a.a;
import java.util.Map;

/* loaded from: classes2.dex */
@Component(modules = {ApplicationModule.class, InflaterConfigModule.class})
public interface UniversalComponent {
    public abstract DisplayMetrics displayMetrics();

    public abstract FiamWindowManager fiamWindowManager();

    public abstract BindingWrapperFactory inflaterClient();

    public abstract Map<String, a<InAppMessageLayoutConfig>> myKeyStringMap();

    public abstract Application providesApplication();
}
