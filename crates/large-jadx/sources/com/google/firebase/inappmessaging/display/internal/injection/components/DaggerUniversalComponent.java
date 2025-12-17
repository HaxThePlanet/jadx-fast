package com.google.firebase.inappmessaging.display.internal.injection.components;

import android.app.Application;
import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.dagger.internal.DoubleCheck;
import com.google.firebase.inappmessaging.display.dagger.internal.MapBuilder;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory_Factory;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager_Factory;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.ApplicationModule_ProvidesApplicationFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesBannerPortraitLayoutConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesCardLandscapeConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesCardPortraitConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesDisplayMetricsFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesLandscapeImageLayoutConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesModalLandscapeConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesModalPortraitConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory;
import j.a.a;
import java.util.Map;

/* loaded from: classes2.dex */
public final class DaggerUniversalComponent implements com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent {

    private a<BindingWrapperFactory> bindingWrapperFactoryProvider;
    private a<FiamWindowManager> fiamWindowManagerProvider;
    private final InflaterConfigModule inflaterConfigModule;
    private a<Application> providesApplicationProvider;
    private a<InAppMessageLayoutConfig> providesBannerLandscapeLayoutConfigProvider;
    private a<InAppMessageLayoutConfig> providesBannerPortraitLayoutConfigProvider;
    private a<InAppMessageLayoutConfig> providesCardLandscapeConfigProvider;
    private a<InAppMessageLayoutConfig> providesCardPortraitConfigProvider;
    private a<DisplayMetrics> providesDisplayMetricsProvider;
    private a<InAppMessageLayoutConfig> providesLandscapeImageLayoutConfigProvider;
    private a<InAppMessageLayoutConfig> providesModalLandscapeConfigProvider;
    private a<InAppMessageLayoutConfig> providesModalPortraitConfigProvider;
    private a<InAppMessageLayoutConfig> providesPortraitImageLayoutConfigProvider;

    public static final class Builder {

        private ApplicationModule applicationModule;
        private InflaterConfigModule inflaterConfigModule;
        Builder(com.google.firebase.inappmessaging.display.internal.injection.components.DaggerUniversalComponent.1 daggerUniversalComponent$1) {
            super();
        }

        public com.google.firebase.inappmessaging.display.internal.injection.components.DaggerUniversalComponent.Builder applicationModule(ApplicationModule applicationModule) {
            this.applicationModule = (ApplicationModule)Preconditions.checkNotNull(applicationModule);
            return this;
        }

        public com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent build() {
            InflaterConfigModule inflaterConfigModule;
            Preconditions.checkBuilderRequirement(this.applicationModule, ApplicationModule.class);
            if (this.inflaterConfigModule == null) {
                inflaterConfigModule = new InflaterConfigModule();
                this.inflaterConfigModule = inflaterConfigModule;
            }
            DaggerUniversalComponent daggerUniversalComponent = new DaggerUniversalComponent(this.applicationModule, this.inflaterConfigModule, 0);
            return daggerUniversalComponent;
        }

        public com.google.firebase.inappmessaging.display.internal.injection.components.DaggerUniversalComponent.Builder inflaterConfigModule(InflaterConfigModule inflaterConfigModule) {
            this.inflaterConfigModule = (InflaterConfigModule)Preconditions.checkNotNull(inflaterConfigModule);
            return this;
        }
    }
    private DaggerUniversalComponent(ApplicationModule applicationModule, InflaterConfigModule inflaterConfigModule2) {
        super();
        this.inflaterConfigModule = inflaterConfigModule2;
        initialize(applicationModule, inflaterConfigModule2);
    }

    DaggerUniversalComponent(ApplicationModule applicationModule, InflaterConfigModule inflaterConfigModule2, com.google.firebase.inappmessaging.display.internal.injection.components.DaggerUniversalComponent.1 daggerUniversalComponent$13) {
        super(applicationModule, inflaterConfigModule2);
    }

    public static com.google.firebase.inappmessaging.display.internal.injection.components.DaggerUniversalComponent.Builder builder() {
        DaggerUniversalComponent.Builder builder = new DaggerUniversalComponent.Builder(0);
        return builder;
    }

    private void initialize(ApplicationModule applicationModule, InflaterConfigModule inflaterConfigModule2) {
        this.providesApplicationProvider = DoubleCheck.provider(ApplicationModule_ProvidesApplicationFactory.create(applicationModule));
        this.fiamWindowManagerProvider = DoubleCheck.provider(FiamWindowManager_Factory.create());
        this.bindingWrapperFactoryProvider = DoubleCheck.provider(BindingWrapperFactory_Factory.create(this.providesApplicationProvider));
        InflaterConfigModule_ProvidesDisplayMetricsFactory obj1 = InflaterConfigModule_ProvidesDisplayMetricsFactory.create(inflaterConfigModule2, this.providesApplicationProvider);
        this.providesDisplayMetricsProvider = obj1;
        this.providesPortraitImageLayoutConfigProvider = InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory.create(inflaterConfigModule2, obj1);
        this.providesLandscapeImageLayoutConfigProvider = InflaterConfigModule_ProvidesLandscapeImageLayoutConfigFactory.create(inflaterConfigModule2, this.providesDisplayMetricsProvider);
        this.providesModalLandscapeConfigProvider = InflaterConfigModule_ProvidesModalLandscapeConfigFactory.create(inflaterConfigModule2, this.providesDisplayMetricsProvider);
        this.providesModalPortraitConfigProvider = InflaterConfigModule_ProvidesModalPortraitConfigFactory.create(inflaterConfigModule2, this.providesDisplayMetricsProvider);
        this.providesCardLandscapeConfigProvider = InflaterConfigModule_ProvidesCardLandscapeConfigFactory.create(inflaterConfigModule2, this.providesDisplayMetricsProvider);
        this.providesCardPortraitConfigProvider = InflaterConfigModule_ProvidesCardPortraitConfigFactory.create(inflaterConfigModule2, this.providesDisplayMetricsProvider);
        this.providesBannerPortraitLayoutConfigProvider = InflaterConfigModule_ProvidesBannerPortraitLayoutConfigFactory.create(inflaterConfigModule2, this.providesDisplayMetricsProvider);
        this.providesBannerLandscapeLayoutConfigProvider = InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory.create(inflaterConfigModule2, this.providesDisplayMetricsProvider);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent
    public DisplayMetrics displayMetrics() {
        return InflaterConfigModule_ProvidesDisplayMetricsFactory.providesDisplayMetrics(this.inflaterConfigModule, (Application)this.providesApplicationProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent
    public FiamWindowManager fiamWindowManager() {
        return (FiamWindowManager)this.fiamWindowManagerProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent
    public BindingWrapperFactory inflaterClient() {
        return (BindingWrapperFactory)this.bindingWrapperFactoryProvider.get();
    }

    public Map<String, a<InAppMessageLayoutConfig>> myKeyStringMap() {
        return MapBuilder.newMapBuilder(8).put("IMAGE_ONLY_PORTRAIT", this.providesPortraitImageLayoutConfigProvider).put("IMAGE_ONLY_LANDSCAPE", this.providesLandscapeImageLayoutConfigProvider).put("MODAL_LANDSCAPE", this.providesModalLandscapeConfigProvider).put("MODAL_PORTRAIT", this.providesModalPortraitConfigProvider).put("CARD_LANDSCAPE", this.providesCardLandscapeConfigProvider).put("CARD_PORTRAIT", this.providesCardPortraitConfigProvider).put("BANNER_PORTRAIT", this.providesBannerPortraitLayoutConfigProvider).put("BANNER_LANDSCAPE", this.providesBannerLandscapeLayoutConfigProvider).build();
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent
    public Application providesApplication() {
        return (Application)this.providesApplicationProvider.get();
    }
}
