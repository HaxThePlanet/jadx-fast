package com.google.firebase.encoders.json;

import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public final class JsonDataEncoderBuilder implements EncoderConfig<com.google.firebase.encoders.json.JsonDataEncoderBuilder> {

    private static final ValueEncoder<Boolean> BOOLEAN_ENCODER;
    private static final ObjectEncoder<Object> DEFAULT_FALLBACK_ENCODER;
    private static final ValueEncoder<String> STRING_ENCODER;
    private static final com.google.firebase.encoders.json.JsonDataEncoderBuilder.TimestampEncoder TIMESTAMP_ENCODER;
    private ObjectEncoder<Object> fallbackEncoder;
    private boolean ignoreNullValues = false;
    private final Map<Class<?>, ObjectEncoder<?>> objectEncoders;
    private final Map<Class<?>, ValueEncoder<?>> valueEncoders;

    private static final class TimestampEncoder implements ValueEncoder<Date> {

        private static final DateFormat rfc339;
        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            JsonDataEncoderBuilder.TimestampEncoder.rfc339 = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        TimestampEncoder(com.google.firebase.encoders.json.JsonDataEncoderBuilder.1 jsonDataEncoderBuilder$1) {
            super();
        }

        @Override // com.google.firebase.encoders.ValueEncoder
        public void encode(Object object, Object object2) {
            encode((Date)object, (ValueEncoderContext)object2);
        }

        @Override // com.google.firebase.encoders.ValueEncoder
        public void encode(Date date, ValueEncoderContext valueEncoderContext2) {
            valueEncoderContext2.add(JsonDataEncoderBuilder.TimestampEncoder.rfc339.format(date));
        }
    }
    static {
        JsonDataEncoderBuilder.DEFAULT_FALLBACK_ENCODER = a.a;
        JsonDataEncoderBuilder.STRING_ENCODER = b.a;
        JsonDataEncoderBuilder.BOOLEAN_ENCODER = c.a;
        JsonDataEncoderBuilder.TimestampEncoder timestampEncoder = new JsonDataEncoderBuilder.TimestampEncoder(0);
        JsonDataEncoderBuilder.TIMESTAMP_ENCODER = timestampEncoder;
    }

    public JsonDataEncoderBuilder() {
        super();
        HashMap hashMap = new HashMap();
        this.objectEncoders = hashMap;
        HashMap hashMap2 = new HashMap();
        this.valueEncoders = hashMap2;
        this.fallbackEncoder = JsonDataEncoderBuilder.DEFAULT_FALLBACK_ENCODER;
        int i = 0;
        registerEncoder(String.class, JsonDataEncoderBuilder.STRING_ENCODER);
        registerEncoder(Boolean.class, JsonDataEncoderBuilder.BOOLEAN_ENCODER);
        registerEncoder(Date.class, JsonDataEncoderBuilder.TIMESTAMP_ENCODER);
    }

    static void a(Object object, ObjectEncoderContext objectEncoderContext2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Couldn't find encoder for type ");
        stringBuilder.append(object.getClass().getCanonicalName());
        EncodingException obj3 = new EncodingException(stringBuilder.toString());
        throw obj3;
    }

    static Map access$100(com.google.firebase.encoders.json.JsonDataEncoderBuilder jsonDataEncoderBuilder) {
        return jsonDataEncoderBuilder.objectEncoders;
    }

    static Map access$200(com.google.firebase.encoders.json.JsonDataEncoderBuilder jsonDataEncoderBuilder) {
        return jsonDataEncoderBuilder.valueEncoders;
    }

    static ObjectEncoder access$300(com.google.firebase.encoders.json.JsonDataEncoderBuilder jsonDataEncoderBuilder) {
        return jsonDataEncoderBuilder.fallbackEncoder;
    }

    static boolean access$400(com.google.firebase.encoders.json.JsonDataEncoderBuilder jsonDataEncoderBuilder) {
        return jsonDataEncoderBuilder.ignoreNullValues;
    }

    static void b(String string, ValueEncoderContext valueEncoderContext2) {
        valueEncoderContext2.add(string);
    }

    static void c(Boolean boolean, ValueEncoderContext valueEncoderContext2) {
        valueEncoderContext2.add(boolean.booleanValue());
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    public DataEncoder build() {
        JsonDataEncoderBuilder.1 anon = new JsonDataEncoderBuilder.1(this);
        return anon;
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    public com.google.firebase.encoders.json.JsonDataEncoderBuilder configureWith(Configurator configurator) {
        configurator.configure(this);
        return this;
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    public com.google.firebase.encoders.json.JsonDataEncoderBuilder ignoreNullValues(boolean z) {
        this.ignoreNullValues = z;
        return this;
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    public EncoderConfig registerEncoder(Class class, ObjectEncoder objectEncoder2) {
        return registerEncoder(class, objectEncoder2);
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    public EncoderConfig registerEncoder(Class class, ValueEncoder valueEncoder2) {
        return registerEncoder(class, valueEncoder2);
    }

    public <T> com.google.firebase.encoders.json.JsonDataEncoderBuilder registerEncoder(Class<T> class, ObjectEncoder<? super T> objectEncoder2) {
        this.objectEncoders.put(class, objectEncoder2);
        this.valueEncoders.remove(class);
        return this;
    }

    public <T> com.google.firebase.encoders.json.JsonDataEncoderBuilder registerEncoder(Class<T> class, ValueEncoder<? super T> valueEncoder2) {
        this.valueEncoders.put(class, valueEncoder2);
        this.objectEncoders.remove(class);
        return this;
    }

    public com.google.firebase.encoders.json.JsonDataEncoderBuilder registerFallbackEncoder(ObjectEncoder<Object> objectEncoder) {
        this.fallbackEncoder = objectEncoder;
        return this;
    }
}
