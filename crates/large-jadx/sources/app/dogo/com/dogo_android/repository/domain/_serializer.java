@Metadata(d1 = "\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0008\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u000c\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0014", d2 = {"app/dogo/com/dogo_android/repository/domain/SpecialOfferCoupon.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lapp/dogo/com/dogo_android/repository/domain/SpecialOfferCoupon;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* renamed from: serializer */
public static final class _serializer implements kotlinx.serialization.c.b<SpecialOfferCoupon> {

    public static final app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon$$serializer INSTANCE = new SpecialOfferCoupon$$serializer();
    public static final /* synthetic */ kotlinx.serialization.descriptors.SerialDescriptor descriptor = new k();
    static {
        boolean z = false;
        obj.g("discount", z);
        obj.g("offeringId", z);
        obj.g("startTimeMs", z);
        obj.g("endTimeMs", z);
        obj.g("offerCode", z);
        obj.g("style", z);
        obj.g("text", z);
        obj.g("discountText", z);
    }

    private serializer() {
        super();
    }

    public kotlinx.serialization.KSerializer<?>[] childSerializers() {
        kotlinx.serialization.KSerializer[] arr = new KSerializer[8];
        kotlinx.serialization.c.p pVar = StringSerializer.a;
        kotlinx.serialization.c.f fVar = LongSerializer.a;
        return new KSerializer[] { IntSerializer.a, pVar, fVar, fVar, pVar, pVar, new LinkedHashMapSerializer(pVar, pVar), new LinkedHashMapSerializer(pVar, pVar) };
    }

    public SpecialOfferCoupon deserialize(kotlinx.serialization.encoding.Decoder decoder) throws kotlinx.serialization.UnknownFieldException {
        int i;
        Object obj;
        int i2 = 2;
        int i3 = 1;
        kotlinx.serialization.c.e linkedHashMapSerializer;
        String str3;
        long l;
        long l3;
        String str8;
        int i4;
        Object decoder2 = decoder;
        n.f(decoder2, "decoder");
        kotlinx.serialization.descriptors.SerialDescriptor descriptor = getDescriptor();
        kotlinx.serialization.encoding.a aVar = decoder2.a(descriptor);
        int i6 = 7;
        int i7 = 6;
        int i8 = 5;
        int i9 = 3;
        i = 4;
        i2 = 2;
        i3 = 1;
        obj = null;
        i = 0;
        if (aVar.g()) {
            pVar = StringSerializer.a;
            obj = aVar.d(descriptor, i7, new LinkedHashMapSerializer(pVar, pVar), obj);
            obj = aVar.d(descriptor, i6, new LinkedHashMapSerializer(pVar, pVar), obj);
            i = 255;
        } else {
            while (i3 != 0) {
                int i10 = aVar.f(descriptor);
                pVar2 = StringSerializer.a;
                obj = aVar.d(descriptor, i6, new LinkedHashMapSerializer(pVar2, pVar2), obj);
                i = i | 128;
                i2 = 2;
                i3 = 1;
                kotlinx.serialization.c.p pVar3 = StringSerializer.a;
                obj = aVar.d(descriptor, i7, new LinkedHashMapSerializer(pVar3, pVar3), obj);
                i = i | 64;
                String str7 = aVar.e(descriptor, i8);
                i = i | 32;
                String str6 = aVar.e(descriptor, i);
                i = i | 16;
                long l5 = aVar.b(descriptor, i9);
                i = i | 8;
                long l4 = aVar.b(descriptor, i2);
                i = i | 4;
                i3 = 1;
                String str5 = aVar.e(descriptor, i3);
                i = i | 2;
                i3 = 1;
                i = i | 1;
                i3 = 0;
            }
        }
        aVar.a(descriptor);
        SpecialOfferCoupon specialOfferCoupon = new SpecialOfferCoupon(i, i, str3, l, l3, str8, str9, obj, obj, (Map)obj, (Map)obj, 0);
        return specialOfferCoupon;
    }

    public void serialize(kotlinx.serialization.encoding.Encoder encoder, SpecialOfferCoupon value) {
        n.f(encoder, "encoder");
        n.f(value, "value");
        kotlinx.serialization.descriptors.SerialDescriptor descriptor = getDescriptor();
        final kotlinx.serialization.encoding.b bVar = encoder.a(descriptor);
        SpecialOfferCoupon.write$Self(value, bVar, descriptor);
        bVar.a(descriptor);
    }

    public kotlinx.serialization.KSerializer<?>[] typeParametersSerializers() {
        return kotlinx.serialization.internal.b.a.a(this);
    }

    public kotlinx.serialization.descriptors.SerialDescriptor getDescriptor() {
        return _serializer.descriptor;
    }
}
