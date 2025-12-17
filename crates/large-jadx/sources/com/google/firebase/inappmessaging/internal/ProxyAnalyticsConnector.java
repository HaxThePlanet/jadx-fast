package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import com.google.firebase.analytics.connector.AnalyticsConnector.ConditionalUserProperty;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class ProxyAnalyticsConnector implements AnalyticsConnector {

    private volatile Object instance;

    private static class ProxyAnalyticsConnectorHandle implements AnalyticsConnector.AnalyticsConnectorHandle {

        private static final Object UNREGISTERED;
        private Set<String> eventNames;
        private volatile Object instance;
        static {
            Object object = new Object();
            ProxyAnalyticsConnector.ProxyAnalyticsConnectorHandle.UNREGISTERED = object;
        }

        private ProxyAnalyticsConnectorHandle(String string, AnalyticsConnector.AnalyticsConnectorListener analyticsConnector$AnalyticsConnectorListener2, Deferred<AnalyticsConnector> deferred3) {
            super();
            HashSet hashSet = new HashSet();
            this.eventNames = hashSet;
            t1 t1Var = new t1(this, string, analyticsConnectorListener2);
            deferred3.whenAvailable(t1Var);
        }

        ProxyAnalyticsConnectorHandle(String string, AnalyticsConnector.AnalyticsConnectorListener analyticsConnector$AnalyticsConnectorListener2, Deferred deferred3, com.google.firebase.inappmessaging.internal.ProxyAnalyticsConnector.1 proxyAnalyticsConnector$14) {
            super(string, analyticsConnectorListener2, deferred3);
        }

        private void a(String string, AnalyticsConnector.AnalyticsConnectorListener analyticsConnector$AnalyticsConnectorListener2, Provider provider3) {
            Object obj3;
            boolean obj4;
            if (this.instance == ProxyAnalyticsConnector.ProxyAnalyticsConnectorHandle.UNREGISTERED) {
            }
            obj3 = (AnalyticsConnector)provider3.get().registerAnalyticsConnectorListener(string, analyticsConnectorListener2);
            this.instance = obj3;
            synchronized (this) {
                obj3.registerEventNames(this.eventNames);
                obj3 = new HashSet();
                this.eventNames = obj3;
            }
        }

        @Override // com.google.firebase.analytics.connector.AnalyticsConnector$AnalyticsConnectorHandle
        public void b(String string, AnalyticsConnector.AnalyticsConnectorListener analyticsConnector$AnalyticsConnectorListener2, Provider provider3) {
            a(string, analyticsConnectorListener2, provider3);
        }

        public void registerEventNames(Set<String> set) {
            Object instance = this.instance;
            if (instance == ProxyAnalyticsConnector.ProxyAnalyticsConnectorHandle.UNREGISTERED) {
            }
            if (instance != null) {
                (AnalyticsConnector.AnalyticsConnectorHandle)instance.registerEventNames(set);
            }
            this.eventNames.addAll(set);
            return;
            synchronized (this) {
                this.eventNames.addAll(set);
            }
        }

        @Override // com.google.firebase.analytics.connector.AnalyticsConnector$AnalyticsConnectorHandle
        public void unregister() {
            Object instance = this.instance;
            final Object uNREGISTERED = ProxyAnalyticsConnector.ProxyAnalyticsConnectorHandle.UNREGISTERED;
            if (instance == uNREGISTERED) {
            }
            if (instance != null) {
                (AnalyticsConnector.AnalyticsConnectorHandle)instance.unregister();
            }
            this.instance = uNREGISTERED;
            this.eventNames.clear();
            return;
            synchronized (this) {
                this.instance = uNREGISTERED;
                this.eventNames.clear();
            }
        }

        @Override // com.google.firebase.analytics.connector.AnalyticsConnector$AnalyticsConnectorHandle
        public void unregisterEventNames() {
            Object instance = this.instance;
            if (instance == ProxyAnalyticsConnector.ProxyAnalyticsConnectorHandle.UNREGISTERED) {
            }
            if (instance != null) {
                (AnalyticsConnector.AnalyticsConnectorHandle)instance.unregisterEventNames();
            }
            this.eventNames.clear();
            return;
            synchronized (this) {
                this.eventNames.clear();
            }
        }
    }
    public ProxyAnalyticsConnector(Deferred<AnalyticsConnector> deferred) {
        super();
        this.instance = deferred;
        u1 u1Var = new u1(this);
        deferred.whenAvailable(u1Var);
    }

    private void a(Provider provider) {
        this.instance = provider.get();
    }

    private AnalyticsConnector safeGet() {
        Object instance = this.instance;
        if (instance instanceof AnalyticsConnector) {
            return (AnalyticsConnector)instance;
        }
        return null;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void b(Provider provider) {
        a(provider);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void clearConditionalUserProperty(String string, String string2, Bundle bundle3) {
    }

    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(String string, String string2) {
        return Collections.emptyList();
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public int getMaxUserProperties(String string) {
        return 0;
    }

    public Map<String, Object> getUserProperties(boolean z) {
        return Collections.emptyMap();
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void logEvent(String string, String string2, Bundle bundle3) {
        final AnalyticsConnector safeGet = safeGet();
        if (safeGet != null) {
            safeGet.logEvent(string, string2, bundle3);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(String string, AnalyticsConnector.AnalyticsConnectorListener analyticsConnector$AnalyticsConnectorListener2) {
        final Object instance = this.instance;
        if (instance instanceof AnalyticsConnector) {
            return (AnalyticsConnector)instance.registerAnalyticsConnectorListener(string, analyticsConnectorListener2);
        }
        ProxyAnalyticsConnector.ProxyAnalyticsConnectorHandle proxyAnalyticsConnectorHandle = new ProxyAnalyticsConnector.ProxyAnalyticsConnectorHandle(string, analyticsConnectorListener2, (Deferred)instance, 0);
        return proxyAnalyticsConnectorHandle;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setConditionalUserProperty(AnalyticsConnector.ConditionalUserProperty analyticsConnector$ConditionalUserProperty) {
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setUserProperty(String string, String string2, Object object3) {
        final AnalyticsConnector safeGet = safeGet();
        if (safeGet != null) {
            safeGet.setUserProperty(string, string2, object3);
        }
    }
}
