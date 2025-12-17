package com.google.android.datatransport.cct.f;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;

/* loaded from: classes.dex */
public final class b implements Configurator {

    public static final Configurator a;

    private static final class a implements ObjectEncoder<com.google.android.datatransport.cct.f.a> {

        static final com.google.android.datatransport.cct.f.b.a a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        private static final FieldDescriptor f;
        private static final FieldDescriptor g;
        private static final FieldDescriptor h;
        private static final FieldDescriptor i;
        private static final FieldDescriptor j;
        private static final FieldDescriptor k;
        private static final FieldDescriptor l;
        private static final FieldDescriptor m;
        static {
            b.a aVar = new b.a();
            b.a.a = aVar;
            b.a.b = FieldDescriptor.of("sdkVersion");
            b.a.c = FieldDescriptor.of("model");
            b.a.d = FieldDescriptor.of("hardware");
            b.a.e = FieldDescriptor.of("device");
            b.a.f = FieldDescriptor.of("product");
            b.a.g = FieldDescriptor.of("osBuild");
            b.a.h = FieldDescriptor.of("manufacturer");
            b.a.i = FieldDescriptor.of("fingerprint");
            b.a.j = FieldDescriptor.of("locale");
            b.a.k = FieldDescriptor.of("country");
            b.a.l = FieldDescriptor.of("mccMnc");
            b.a.m = FieldDescriptor.of("applicationBuild");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void a(com.google.android.datatransport.cct.f.a a, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(b.a.b, a.m());
            objectEncoderContext2.add(b.a.c, a.j());
            objectEncoderContext2.add(b.a.d, a.f());
            objectEncoderContext2.add(b.a.e, a.d());
            objectEncoderContext2.add(b.a.f, a.l());
            objectEncoderContext2.add(b.a.g, a.k());
            objectEncoderContext2.add(b.a.h, a.h());
            objectEncoderContext2.add(b.a.i, a.e());
            objectEncoderContext2.add(b.a.j, a.g());
            objectEncoderContext2.add(b.a.k, a.c());
            objectEncoderContext2.add(b.a.l, a.i());
            objectEncoderContext2.add(b.a.m, a.b());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            a((a)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class b implements ObjectEncoder<com.google.android.datatransport.cct.f.j> {

        static final com.google.android.datatransport.cct.f.b.b a;
        private static final FieldDescriptor b;
        static {
            b.b bVar = new b.b();
            b.b.a = bVar;
            b.b.b = FieldDescriptor.of("logRequest");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void a(com.google.android.datatransport.cct.f.j j, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(b.b.b, j.c());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            a((j)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class c implements ObjectEncoder<com.google.android.datatransport.cct.f.k> {

        static final com.google.android.datatransport.cct.f.b.c a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        static {
            b.c cVar = new b.c();
            b.c.a = cVar;
            b.c.b = FieldDescriptor.of("clientType");
            b.c.c = FieldDescriptor.of("androidClientInfo");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void a(com.google.android.datatransport.cct.f.k k, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(b.c.b, k.c());
            objectEncoderContext2.add(b.c.c, k.b());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            a((k)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class d implements ObjectEncoder<com.google.android.datatransport.cct.f.l> {

        static final com.google.android.datatransport.cct.f.b.d a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        private static final FieldDescriptor f;
        private static final FieldDescriptor g;
        private static final FieldDescriptor h;
        static {
            b.d dVar = new b.d();
            b.d.a = dVar;
            b.d.b = FieldDescriptor.of("eventTimeMs");
            b.d.c = FieldDescriptor.of("eventCode");
            b.d.d = FieldDescriptor.of("eventUptimeMs");
            b.d.e = FieldDescriptor.of("sourceExtension");
            b.d.f = FieldDescriptor.of("sourceExtensionJsonProto3");
            b.d.g = FieldDescriptor.of("timezoneOffsetSeconds");
            b.d.h = FieldDescriptor.of("networkConnectionInfo");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void a(com.google.android.datatransport.cct.f.l l, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(b.d.b, l.c());
            objectEncoderContext2.add(b.d.c, l.b());
            objectEncoderContext2.add(b.d.d, l.d());
            objectEncoderContext2.add(b.d.e, l.f());
            objectEncoderContext2.add(b.d.f, l.g());
            objectEncoderContext2.add(b.d.g, l.h());
            objectEncoderContext2.add(b.d.h, l.e());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            a((l)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class e implements ObjectEncoder<com.google.android.datatransport.cct.f.m> {

        static final com.google.android.datatransport.cct.f.b.e a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        private static final FieldDescriptor f;
        private static final FieldDescriptor g;
        private static final FieldDescriptor h;
        static {
            b.e eVar = new b.e();
            b.e.a = eVar;
            b.e.b = FieldDescriptor.of("requestTimeMs");
            b.e.c = FieldDescriptor.of("requestUptimeMs");
            b.e.d = FieldDescriptor.of("clientInfo");
            b.e.e = FieldDescriptor.of("logSource");
            b.e.f = FieldDescriptor.of("logSourceName");
            b.e.g = FieldDescriptor.of("logEvent");
            b.e.h = FieldDescriptor.of("qosTier");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void a(com.google.android.datatransport.cct.f.m m, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(b.e.b, m.g());
            objectEncoderContext2.add(b.e.c, m.h());
            objectEncoderContext2.add(b.e.d, m.b());
            objectEncoderContext2.add(b.e.e, m.d());
            objectEncoderContext2.add(b.e.f, m.e());
            objectEncoderContext2.add(b.e.g, m.c());
            objectEncoderContext2.add(b.e.h, m.f());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            a((m)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class f implements ObjectEncoder<com.google.android.datatransport.cct.f.o> {

        static final com.google.android.datatransport.cct.f.b.f a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        static {
            b.f fVar = new b.f();
            b.f.a = fVar;
            b.f.b = FieldDescriptor.of("networkType");
            b.f.c = FieldDescriptor.of("mobileSubtype");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void a(com.google.android.datatransport.cct.f.o o, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(b.f.b, o.c());
            objectEncoderContext2.add(b.f.c, o.b());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            a((o)object, (ObjectEncoderContext)object2);
        }
    }
    static {
        b bVar = new b();
        b.a = bVar;
    }

    public void configure(EncoderConfig<?> encoderConfig) {
        com.google.android.datatransport.cct.f.b.b bVar = b.b.a;
        encoderConfig.registerEncoder(j.class, bVar);
        encoderConfig.registerEncoder(d.class, bVar);
        com.google.android.datatransport.cct.f.b.e eVar = b.e.a;
        encoderConfig.registerEncoder(m.class, eVar);
        encoderConfig.registerEncoder(g.class, eVar);
        com.google.android.datatransport.cct.f.b.c cVar = b.c.a;
        encoderConfig.registerEncoder(k.class, cVar);
        encoderConfig.registerEncoder(e.class, cVar);
        com.google.android.datatransport.cct.f.b.a aVar = b.a.a;
        encoderConfig.registerEncoder(a.class, aVar);
        encoderConfig.registerEncoder(c.class, aVar);
        com.google.android.datatransport.cct.f.b.d dVar = b.d.a;
        encoderConfig.registerEncoder(l.class, dVar);
        encoderConfig.registerEncoder(f.class, dVar);
        com.google.android.datatransport.cct.f.b.f fVar = b.f.a;
        encoderConfig.registerEncoder(o.class, fVar);
        encoderConfig.registerEncoder(i.class, fVar);
    }
}
