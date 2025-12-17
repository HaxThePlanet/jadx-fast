package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeDecoder.DefaultImpls;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Decoder.DefaultImpls;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0001\n\u0002\u0008\u0003\n\u0002\u0010\u0005\n\u0002\u0008\u0002\n\u0002\u0010\n\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0006\n\u0002\u0008\u0002\n\u0002\u0010\u000c\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0010\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000f\u0008'\u0018\u0000*\n\u0008\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0019\u0010\u000b\u001a\u00028\u0000*\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH$¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0015J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0011\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0015J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010!J\u0015\u0010\"\u001a\u00020#2\u0006\u0010\u0011\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010$J\u0015\u0010%\u001a\u00020&2\u0006\u0010\u0011\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010'J\u0015\u0010(\u001a\u00020)2\u0006\u0010\u0011\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010*J\u0015\u0010+\u001a\u00020,2\u0006\u0010\u0011\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010-J\u0015\u0010.\u001a\u00020/2\u0006\u0010\u0011\u001a\u00028\u0000H\u0014¢\u0006\u0002\u00100J\u001d\u00101\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u00102\u001a\u00020\u000cH\u0014¢\u0006\u0002\u00103J\u001d\u00104\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u00105\u001a\u00020\u000cH\u0014¢\u0006\u0002\u00106J1\u00107\u001a\u0002H8\"\n\u0008\u0001\u00108*\u0004\u0018\u00010\u00022\u000c\u00109\u001a\u0008\u0012\u0004\u0012\u0002H80:2\u0008\u0010;\u001a\u0004\u0018\u0001H8H\u0014¢\u0006\u0002\u0010<J\u0010\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u000cH\u0016J\u0008\u0010?\u001a\u00020\u0014H\u0016J\u0008\u0010@\u001a\u0004\u0018\u00010\u0017J\u0006\u0010A\u001a\u00020\u0014J\u0006\u0010B\u001a\u00020\u001bJ\u0006\u0010C\u001a\u00020\u001eJ\u0006\u0010D\u001a\u00020\u000eJ\u0006\u0010E\u001a\u00020#J\u0006\u0010F\u001a\u00020&J\u0006\u0010G\u001a\u00020)J\u0006\u0010H\u001a\u00020,J\u0006\u0010I\u001a\u00020/J\u000e\u0010J\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u000cJ\u0010\u0010K\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u000cH\u0016J\u0010\u0010L\u001a\u00020M2\u0006\u0010>\u001a\u00020\u000cH\u0016J\u0016\u0010N\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010O\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010P\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010Q\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010R\u001a\u00020#2\u0006\u0010>\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010S\u001a\u00020&2\u0006\u0010>\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010T\u001a\u00020)2\u0006\u0010>\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010U\u001a\u00020,2\u0006\u0010>\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010V\u001a\u00020/2\u0006\u0010>\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010W\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eJ?\u0010X\u001a\u0002H8\"\n\u0008\u0001\u00108*\u0004\u0018\u00010\u00022\u0006\u0010>\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u000c\u00109\u001a\u0008\u0012\u0004\u0012\u0002H80:2\u0008\u0010;\u001a\u0004\u0018\u0001H8¢\u0006\u0002\u0010YJA\u0010Z\u001a\u0004\u0018\u0001H8\"\u0008\u0008\u0001\u00108*\u00020\u00022\u0006\u0010>\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H80:2\u0008\u0010;\u001a\u0004\u0018\u0001H8¢\u0006\u0002\u0010YJ)\u0010[\u001a\u0002H\\\"\u0004\u0008\u0001\u0010\\2\u0006\u0010\u0011\u001a\u00028\u00002\u000c\u0010]\u001a\u0008\u0012\u0004\u0012\u0002H\\0^H\u0002¢\u0006\u0002\u0010_J\u0015\u0010j\u001a\u00020M2\u0006\u0010k\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010lJ\u0016\u0010m\u001a\u00020M2\u000c\u0010n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0000H\u0004J\r\u0010p\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010gR\u0014\u0010\u0007\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR$\u0010`\u001a\u0012\u0012\u0004\u0012\u00028\u00000aj\u0008\u0012\u0004\u0012\u00028\u0000`bX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008c\u0010dR\u0014\u0010e\u001a\u00028\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008f\u0010gR\u0016\u0010h\u001a\u0004\u0018\u00018\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008i\u0010gR\u000e\u0010o\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006q", d2 = {"Lkotlinx/serialization/internal/TaggedDecoder;", "Tag", "", "Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "<init>", "()V", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "getTag", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/Object;", "decodeTaggedValue", "tag", "(Ljava/lang/Object;)Ljava/lang/Object;", "decodeTaggedNotNullMark", "", "(Ljava/lang/Object;)Z", "decodeTaggedNull", "", "(Ljava/lang/Object;)Ljava/lang/Void;", "decodeTaggedBoolean", "decodeTaggedByte", "", "(Ljava/lang/Object;)B", "decodeTaggedShort", "", "(Ljava/lang/Object;)S", "decodeTaggedInt", "(Ljava/lang/Object;)I", "decodeTaggedLong", "", "(Ljava/lang/Object;)J", "decodeTaggedFloat", "", "(Ljava/lang/Object;)F", "decodeTaggedDouble", "", "(Ljava/lang/Object;)D", "decodeTaggedChar", "", "(Ljava/lang/Object;)C", "decodeTaggedString", "", "(Ljava/lang/Object;)Ljava/lang/String;", "decodeTaggedEnum", "enumDescriptor", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "decodeTaggedInline", "inlineDescriptor", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "previousValue", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeInline", "descriptor", "decodeNotNullMark", "decodeNull", "decodeBoolean", "decodeByte", "decodeShort", "decodeInt", "decodeLong", "decodeFloat", "decodeDouble", "decodeChar", "decodeString", "decodeEnum", "beginStructure", "endStructure", "", "decodeBooleanElement", "decodeByteElement", "decodeShortElement", "decodeIntElement", "decodeLongElement", "decodeFloatElement", "decodeDoubleElement", "decodeCharElement", "decodeStringElement", "decodeInlineElement", "decodeSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeNullableSerializableElement", "tagBlock", "E", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "tagStack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTagStack$kotlinx_serialization_core", "()Ljava/util/ArrayList;", "currentTag", "getCurrentTag", "()Ljava/lang/Object;", "currentTagOrNull", "getCurrentTagOrNull", "pushTag", "name", "(Ljava/lang/Object;)V", "copyTagsTo", "other", "flag", "popTag", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@InternalSerializationApi
public abstract class TaggedDecoder<Tag>  implements Decoder, CompositeDecoder {

    private boolean flag;
    private final ArrayList<Tag> tagStack;
    public static Object $r8$lambda$7xD3FkFxe2TcpBFw0RQZ8crXUxk(kotlinx.serialization.internal.TaggedDecoder taggedDecoder, DeserializationStrategy deserializationStrategy2, Object object3) {
        return TaggedDecoder.decodeNullableSerializableElement$lambda$3(taggedDecoder, deserializationStrategy2, object3);
    }

    public static Object $r8$lambda$DBYIndnlKB76_oyt-Ap4f_T35nM(kotlinx.serialization.internal.TaggedDecoder taggedDecoder, DeserializationStrategy deserializationStrategy2, Object object3) {
        return TaggedDecoder.decodeSerializableElement$lambda$1(taggedDecoder, deserializationStrategy2, object3);
    }

    public TaggedDecoder() {
        super();
        ArrayList arrayList = new ArrayList();
        this.tagStack = arrayList;
    }

    private static final Object decodeNullableSerializableElement$lambda$3(kotlinx.serialization.internal.TaggedDecoder this$0, DeserializationStrategy $deserializer, Object $previousValue) {
        Object decodeSerializableValue;
        boolean decodeNotNullMark;
        final Decoder decoder = this$0;
        final int i = 0;
        if (!$deserializer.getDescriptor().isNullable()) {
            if ((Decoder)decoder.decodeNotNullMark()) {
                int i2 = 0;
                decodeSerializableValue = this$0.decodeSerializableValue($deserializer, $previousValue);
            } else {
                decodeSerializableValue = decoder.decodeNull();
            }
        } else {
        }
        return decodeSerializableValue;
    }

    private static final Object decodeSerializableElement$lambda$1(kotlinx.serialization.internal.TaggedDecoder this$0, DeserializationStrategy $deserializer, Object $previousValue) {
        return this$0.decodeSerializableValue($deserializer, $previousValue);
    }

    private final <E> E tagBlock(Tag tag, Function0<? extends E> block) {
        pushTag(tag);
        if (!this.flag) {
            popTag();
        }
        this.flag = false;
        return block.invoke();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return (CompositeDecoder)this;
    }

    protected final void copyTagsTo(kotlinx.serialization.internal.TaggedDecoder<Tag> other) {
        Intrinsics.checkNotNullParameter(other, "other");
        other.tagStack.addAll((Collection)this.tagStack);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final boolean decodeBoolean() {
        return decodeTaggedBoolean(popTag());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final boolean decodeBooleanElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedBoolean(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final byte decodeByte() {
        return decodeTaggedByte(popTag());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final byte decodeByteElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedByte(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final char decodeChar() {
        return decodeTaggedChar(popTag());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final char decodeCharElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedChar(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public int decodeCollectionSize(SerialDescriptor descriptor) {
        return CompositeDecoder.DefaultImpls.decodeCollectionSize(this, descriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final double decodeDouble() {
        return decodeTaggedDouble(popTag());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final double decodeDoubleElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedDouble(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int decodeEnum(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return decodeTaggedEnum(popTag(), enumDescriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final float decodeFloat() {
        return decodeTaggedFloat(popTag());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final float decodeFloatElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedFloat(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Decoder decodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedInline(popTag(), descriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final Decoder decodeInlineElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedInline(getTag(descriptor, index), descriptor.getElementDescriptor(index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int decodeInt() {
        return decodeTaggedInt(popTag());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int decodeIntElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedInt(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final long decodeLong() {
        return decodeTaggedLong(popTag());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final long decodeLongElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedLong(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        Object currentTagOrNull = getCurrentTagOrNull();
        if (currentTagOrNull == null) {
            return 0;
        }
        return decodeTaggedNotNullMark(currentTagOrNull);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final Void decodeNull() {
        return null;
    }

    public final <T> T decodeNullableSerializableElement(SerialDescriptor descriptor, int index, DeserializationStrategy<? extends T> deserializer, T previousValue) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        TaggedDecoder$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new TaggedDecoder$$ExternalSyntheticLambda1(this, deserializer, previousValue);
        return tagBlock(getTag(descriptor, index), externalSyntheticLambda1);
    }

    @ExperimentalSerializationApi
    public <T> T decodeNullableSerializableValue(DeserializationStrategy<? extends T> deserializer) {
        return Decoder.DefaultImpls.decodeNullableSerializableValue(this, deserializer);
    }

    @ExperimentalSerializationApi
    public boolean decodeSequentially() {
        return CompositeDecoder.DefaultImpls.decodeSequentially(this);
    }

    public final <T> T decodeSerializableElement(SerialDescriptor descriptor, int index, DeserializationStrategy<? extends T> deserializer, T previousValue) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        TaggedDecoder$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new TaggedDecoder$$ExternalSyntheticLambda0(this, deserializer, previousValue);
        return tagBlock(getTag(descriptor, index), externalSyntheticLambda0);
    }

    public <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializer) {
        return Decoder.DefaultImpls.decodeSerializableValue(this, deserializer);
    }

    protected <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializer, T previousValue) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return decodeSerializableValue(deserializer);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final short decodeShort() {
        return decodeTaggedShort(popTag());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final short decodeShortElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedShort(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final String decodeString() {
        return decodeTaggedString(popTag());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final String decodeStringElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedString(getTag(descriptor, index));
    }

    protected boolean decodeTaggedBoolean(Tag tag) {
        Object decodeTaggedValue = decodeTaggedValue(tag);
        Intrinsics.checkNotNull(decodeTaggedValue, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean)decodeTaggedValue.booleanValue();
    }

    protected byte decodeTaggedByte(Tag tag) {
        Object decodeTaggedValue = decodeTaggedValue(tag);
        Intrinsics.checkNotNull(decodeTaggedValue, "null cannot be cast to non-null type kotlin.Byte");
        return (Byte)decodeTaggedValue.byteValue();
    }

    protected char decodeTaggedChar(Tag tag) {
        Object decodeTaggedValue = decodeTaggedValue(tag);
        Intrinsics.checkNotNull(decodeTaggedValue, "null cannot be cast to non-null type kotlin.Char");
        return (Character)decodeTaggedValue.charValue();
    }

    protected double decodeTaggedDouble(Tag tag) {
        Object decodeTaggedValue = decodeTaggedValue(tag);
        Intrinsics.checkNotNull(decodeTaggedValue, "null cannot be cast to non-null type kotlin.Double");
        return (Double)decodeTaggedValue.doubleValue();
    }

    protected int decodeTaggedEnum(Tag tag, SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        Object decodeTaggedValue = decodeTaggedValue(tag);
        Intrinsics.checkNotNull(decodeTaggedValue, "null cannot be cast to non-null type kotlin.Int");
        return (Integer)decodeTaggedValue.intValue();
    }

    protected float decodeTaggedFloat(Tag tag) {
        Object decodeTaggedValue = decodeTaggedValue(tag);
        Intrinsics.checkNotNull(decodeTaggedValue, "null cannot be cast to non-null type kotlin.Float");
        return (Float)decodeTaggedValue.floatValue();
    }

    protected Decoder decodeTaggedInline(Tag tag, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        final int i = 0;
        (TaggedDecoder)this.pushTag(tag);
        return (Decoder)this;
    }

    protected int decodeTaggedInt(Tag tag) {
        Object decodeTaggedValue = decodeTaggedValue(tag);
        Intrinsics.checkNotNull(decodeTaggedValue, "null cannot be cast to non-null type kotlin.Int");
        return (Integer)decodeTaggedValue.intValue();
    }

    protected long decodeTaggedLong(Tag tag) {
        Object decodeTaggedValue = decodeTaggedValue(tag);
        Intrinsics.checkNotNull(decodeTaggedValue, "null cannot be cast to non-null type kotlin.Long");
        return (Long)decodeTaggedValue.longValue();
    }

    protected boolean decodeTaggedNotNullMark(Tag tag) {
        return 1;
    }

    protected Void decodeTaggedNull(Tag tag) {
        return null;
    }

    protected short decodeTaggedShort(Tag tag) {
        Object decodeTaggedValue = decodeTaggedValue(tag);
        Intrinsics.checkNotNull(decodeTaggedValue, "null cannot be cast to non-null type kotlin.Short");
        return (Short)decodeTaggedValue.shortValue();
    }

    protected String decodeTaggedString(Tag tag) {
        final Object decodeTaggedValue = decodeTaggedValue(tag);
        Intrinsics.checkNotNull(decodeTaggedValue, "null cannot be cast to non-null type kotlin.String");
        return (String)decodeTaggedValue;
    }

    protected Object decodeTaggedValue(Tag tag) {
        StringBuilder stringBuilder = new StringBuilder();
        SerializationException serializationException = new SerializationException(stringBuilder.append(Reflection.getOrCreateKotlinClass(getClass())).append(" can't retrieve untyped values").toString());
        throw serializationException;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    protected final Tag getCurrentTag() {
        return CollectionsKt.last((List)this.tagStack);
    }

    protected final Tag getCurrentTagOrNull() {
        return CollectionsKt.lastOrNull((List)this.tagStack);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public SerializersModule getSerializersModule() {
        return SerializersModuleBuildersKt.EmptySerializersModule();
    }

    protected abstract Tag getTag(SerialDescriptor serialDescriptor, int i2);

    public final ArrayList<Tag> getTagStack$kotlinx_serialization_core() {
        return this.tagStack;
    }

    protected final Tag popTag() {
        this.flag = true;
        return this.tagStack.remove(CollectionsKt.getLastIndex((List)this.tagStack));
    }

    protected final void pushTag(Tag name) {
        this.tagStack.add(name);
    }
}
