package com.google.firebase.perf.transport;

import com.google.firebase.inject.Provider;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.v1.PerfMetric;
import f.c.a.b.b;
import f.c.a.b.c;
import f.c.a.b.f;
import f.c.a.b.g;

/* loaded from: classes2.dex */
final class FlgTransport {

    private static final AndroidLogger logger;
    private f<PerfMetric> flgTransport;
    private final Provider<g> flgTransportFactoryProvider;
    private final String logSourceName;
    static {
        FlgTransport.logger = AndroidLogger.getInstance();
    }

    FlgTransport(Provider<g> provider, String string2) {
        super();
        this.logSourceName = string2;
        this.flgTransportFactoryProvider = provider;
    }

    private boolean initializeFlgTransportClient() {
        Object flgTransport;
        int i;
        String logSourceName;
        Class<PerfMetric> obj;
        b bVar;
        com.google.firebase.perf.transport.a aVar;
        if (this.flgTransport == null) {
            Object obj2 = this.flgTransportFactoryProvider.get();
            if ((g)obj2 != null) {
                this.flgTransport = (g)obj2.b(this.logSourceName, PerfMetric.class, b.b("proto"), a.a);
            } else {
                FlgTransport.logger.warn("Flg TransportFactory is not available at the moment");
            }
        }
        i = this.flgTransport != null ? 1 : 0;
        return i;
    }

    public void log(PerfMetric perfMetric) {
        if (!initializeFlgTransportClient()) {
            FlgTransport.logger.warn("Unable to dispatch event because Flg Transport is not available");
        }
        this.flgTransport.a(c.d(perfMetric));
    }
}
