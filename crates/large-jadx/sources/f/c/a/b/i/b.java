package f.c.a.b.i;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.FieldDescriptor.Builder;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.proto.AtProtobuf;
import f.c.a.b.i.x.a.a;
import f.c.a.b.i.x.a.b;
import f.c.a.b.i.x.a.c;
import f.c.a.b.i.x.a.d;
import f.c.a.b.i.x.a.e;
import f.c.a.b.i.x.a.f;

/* compiled from: AutoProtoEncoderDoNotUseEncoder.java */
/* loaded from: classes.dex */
public final class b implements Configurator {

    public static final Configurator a = new b();

    private static final class a implements ObjectEncoder<a> {

        static final b.a a = new b$a();
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        static {
            b.a.b = FieldDescriptor.builder("window").withProperty(AtProtobuf.builder().tag(1).build()).build();
            b.a.c = FieldDescriptor.builder("logSourceMetrics").withProperty(AtProtobuf.builder().tag(2).build()).build();
            b.a.d = FieldDescriptor.builder("globalMetrics").withProperty(AtProtobuf.builder().tag(3).build()).build();
            b.a.e = FieldDescriptor.builder("appNamespace").withProperty(AtProtobuf.builder().tag(4).build()).build();
        }

        private a() {
            super();
        }

        public void a(a aVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(b.a.b, aVar.d());
            objectEncoderContext.add(b.a.c, aVar.c());
            objectEncoderContext.add(b.a.d, aVar.b());
            objectEncoderContext.add(b.a.e, aVar.a());
        }
    }

    private static final class b implements ObjectEncoder<b> {

        static final b.b a = new b$b();
        private static final FieldDescriptor b;
        static {
            b.b.b = FieldDescriptor.builder("storageMetrics").withProperty(AtProtobuf.builder().tag(1).build()).build();
        }

        private b() {
            super();
        }

        public void a(b bVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(b.b.b, bVar.a());
        }
    }

    private static final class c implements ObjectEncoder<c> {

        static final b.c a = new b$c();
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        static {
            b.c.b = FieldDescriptor.builder("eventsDroppedCount").withProperty(AtProtobuf.builder().tag(1).build()).build();
            b.c.c = FieldDescriptor.builder("reason").withProperty(AtProtobuf.builder().tag(3).build()).build();
        }

        private c() {
            super();
        }

        public void a(c cVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(b.c.b, cVar.a());
            objectEncoderContext.add(b.c.c, cVar.b());
        }
    }

    private static final class d implements ObjectEncoder<d> {

        static final b.d a = new b$d();
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        static {
            b.d.b = FieldDescriptor.builder("logSource").withProperty(AtProtobuf.builder().tag(1).build()).build();
            b.d.c = FieldDescriptor.builder("logEventDropped").withProperty(AtProtobuf.builder().tag(2).build()).build();
        }

        private d() {
            super();
        }

        public void a(d dVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(b.d.b, dVar.b());
            objectEncoderContext.add(b.d.c, dVar.a());
        }
    }

    private static final class e implements ObjectEncoder<m> {

        static final b.e a = new b$e();
        private static final FieldDescriptor b;
        static {
            b.e.b = FieldDescriptor.of("clientMetrics");
        }

        private e() {
            super();
        }

        public void a(m mVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(b.e.b, mVar.b());
        }
    }

    private static final class f implements ObjectEncoder<e> {

        static final b.f a = new b$f();
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        static {
            b.f.b = FieldDescriptor.builder("currentCacheSizeBytes").withProperty(AtProtobuf.builder().tag(1).build()).build();
            b.f.c = FieldDescriptor.builder("maxCacheSizeBytes").withProperty(AtProtobuf.builder().tag(2).build()).build();
        }

        private f() {
            super();
        }

        public void a(e eVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(b.f.b, eVar.a());
            objectEncoderContext.add(b.f.c, eVar.b());
        }
    }

    private static final class g implements ObjectEncoder<f> {

        static final b.g a = new b$g();
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        static {
            b.g.b = FieldDescriptor.builder("startMs").withProperty(AtProtobuf.builder().tag(1).build()).build();
            b.g.c = FieldDescriptor.builder("endMs").withProperty(AtProtobuf.builder().tag(2).build()).build();
        }

        private g() {
            super();
        }

        public void a(f fVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(b.g.b, fVar.b());
            objectEncoderContext.add(b.g.c, fVar.a());
        }
    }

    private b() {
        super();
    }

    public void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder(m.class, b.e.a);
        encoderConfig.registerEncoder(a.class, b.a.a);
        encoderConfig.registerEncoder(f.class, b.g.a);
        encoderConfig.registerEncoder(d.class, b.d.a);
        encoderConfig.registerEncoder(c.class, b.c.a);
        encoderConfig.registerEncoder(b.class, b.b.a);
        encoderConfig.registerEncoder(e.class, b.f.a);
    }
}
