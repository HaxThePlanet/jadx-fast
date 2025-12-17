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

/* loaded from: classes.dex */
public final class b implements Configurator {

    public static final Configurator a;

    private static final class a implements ObjectEncoder<a> {

        static final f.c.a.b.i.b.a a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        static {
            b.a aVar = new b.a();
            b.a.a = aVar;
            b.a.b = FieldDescriptor.builder("window").withProperty(AtProtobuf.builder().tag(1).build()).build();
            b.a.c = FieldDescriptor.builder("logSourceMetrics").withProperty(AtProtobuf.builder().tag(2).build()).build();
            b.a.d = FieldDescriptor.builder("globalMetrics").withProperty(AtProtobuf.builder().tag(3).build()).build();
            b.a.e = FieldDescriptor.builder("appNamespace").withProperty(AtProtobuf.builder().tag(4).build()).build();
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void a(a a, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(b.a.b, a.d());
            objectEncoderContext2.add(b.a.c, a.c());
            objectEncoderContext2.add(b.a.d, a.b());
            objectEncoderContext2.add(b.a.e, a.a());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            a((a)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class b implements ObjectEncoder<b> {

        static final f.c.a.b.i.b.b a;
        private static final FieldDescriptor b;
        static {
            b.b bVar = new b.b();
            b.b.a = bVar;
            b.b.b = FieldDescriptor.builder("storageMetrics").withProperty(AtProtobuf.builder().tag(1).build()).build();
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void a(b b, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(b.b.b, b.a());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            a((b)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class c implements ObjectEncoder<c> {

        static final f.c.a.b.i.b.c a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        static {
            b.c cVar = new b.c();
            b.c.a = cVar;
            b.c.b = FieldDescriptor.builder("eventsDroppedCount").withProperty(AtProtobuf.builder().tag(1).build()).build();
            b.c.c = FieldDescriptor.builder("reason").withProperty(AtProtobuf.builder().tag(3).build()).build();
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void a(c c, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(b.c.b, c.a());
            objectEncoderContext2.add(b.c.c, c.b());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            a((c)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class d implements ObjectEncoder<d> {

        static final f.c.a.b.i.b.d a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        static {
            b.d dVar = new b.d();
            b.d.a = dVar;
            b.d.b = FieldDescriptor.builder("logSource").withProperty(AtProtobuf.builder().tag(1).build()).build();
            b.d.c = FieldDescriptor.builder("logEventDropped").withProperty(AtProtobuf.builder().tag(2).build()).build();
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void a(d d, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(b.d.b, d.b());
            objectEncoderContext2.add(b.d.c, d.a());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            a((d)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class e implements ObjectEncoder<f.c.a.b.i.m> {

        static final f.c.a.b.i.b.e a;
        private static final FieldDescriptor b;
        static {
            b.e eVar = new b.e();
            b.e.a = eVar;
            b.e.b = FieldDescriptor.of("clientMetrics");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void a(f.c.a.b.i.m m, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(b.e.b, m.b());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            a((m)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class f implements ObjectEncoder<e> {

        static final f.c.a.b.i.b.f a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        static {
            b.f fVar = new b.f();
            b.f.a = fVar;
            b.f.b = FieldDescriptor.builder("currentCacheSizeBytes").withProperty(AtProtobuf.builder().tag(1).build()).build();
            b.f.c = FieldDescriptor.builder("maxCacheSizeBytes").withProperty(AtProtobuf.builder().tag(2).build()).build();
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void a(e e, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(b.f.b, e.a());
            objectEncoderContext2.add(b.f.c, e.b());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            a((e)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class g implements ObjectEncoder<f> {

        static final f.c.a.b.i.b.g a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        static {
            b.g gVar = new b.g();
            b.g.a = gVar;
            b.g.b = FieldDescriptor.builder("startMs").withProperty(AtProtobuf.builder().tag(1).build()).build();
            b.g.c = FieldDescriptor.builder("endMs").withProperty(AtProtobuf.builder().tag(2).build()).build();
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void a(f f, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(b.g.b, f.b());
            objectEncoderContext2.add(b.g.c, f.a());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            a((f)object, (ObjectEncoderContext)object2);
        }
    }
    static {
        b bVar = new b();
        b.a = bVar;
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
