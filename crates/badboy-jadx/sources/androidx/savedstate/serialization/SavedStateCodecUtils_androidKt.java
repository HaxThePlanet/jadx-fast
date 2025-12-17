package androidx.savedstate.serialization;

import androidx.savedstate.serialization.serializers.CharSequenceSerializer;
import androidx.savedstate.serialization.serializers.DefaultParcelableSerializer;
import androidx.savedstate.serialization.serializers.SparseArraySerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008$\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0003\"\u0014\u0010\u0008\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0003\"\u001a\u0010\n\u001a\u00020\u0001X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000b\u0010\u000c\u001a\u0004\u0008\r\u0010\u0003\"\u001a\u0010\u000e\u001a\u00020\u0001X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000f\u0010\u000c\u001a\u0004\u0008\u0010\u0010\u0003\"\u0014\u0010\u0011\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0003\"\u0014\u0010\u0013\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0003\"\u001a\u0010\u0015\u001a\u00020\u0001X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0016\u0010\u000c\u001a\u0004\u0008\u0017\u0010\u0003\"\u001a\u0010\u0018\u001a\u00020\u0001X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0019\u0010\u000c\u001a\u0004\u0008\u001a\u0010\u0003\"\u0014\u0010\u001b\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0003\"\u0014\u0010\u001d\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0003\"\u0014\u0010\u001f\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0003\"\u0014\u0010!\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u0003\"\u0014\u0010#\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u0003¨\u0006%", d2 = {"polymorphicCharSequenceDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getPolymorphicCharSequenceDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "polymorphicParcelableDescriptor", "getPolymorphicParcelableDescriptor", "polymorphicJavaSerializableDescriptor", "getPolymorphicJavaSerializableDescriptor", "polymorphicIBinderDescriptor", "getPolymorphicIBinderDescriptor", "parcelableArrayDescriptor", "getParcelableArrayDescriptor$annotations", "()V", "getParcelableArrayDescriptor", "polymorphicParcelableArrayDescriptor", "getPolymorphicParcelableArrayDescriptor$annotations", "getPolymorphicParcelableArrayDescriptor", "parcelableListDescriptor", "getParcelableListDescriptor", "polymorphicParcelableListDescriptor", "getPolymorphicParcelableListDescriptor", "charSequenceArrayDescriptor", "getCharSequenceArrayDescriptor$annotations", "getCharSequenceArrayDescriptor", "polymorphicCharSequenceArrayDescriptor", "getPolymorphicCharSequenceArrayDescriptor$annotations", "getPolymorphicCharSequenceArrayDescriptor", "charSequenceListDescriptor", "getCharSequenceListDescriptor", "polymorphicCharSequenceListDescriptor", "getPolymorphicCharSequenceListDescriptor", "sparseParcelableArrayDescriptor", "getSparseParcelableArrayDescriptor", "polymorphicSparseParcelableArrayDescriptor", "getPolymorphicSparseParcelableArrayDescriptor", "nullablePolymorphicSparseParcelableArrayDescriptor", "getNullablePolymorphicSparseParcelableArrayDescriptor", "savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SavedStateCodecUtils_androidKt {

    private static final SerialDescriptor charSequenceArrayDescriptor;
    private static final SerialDescriptor charSequenceListDescriptor;
    private static final SerialDescriptor nullablePolymorphicSparseParcelableArrayDescriptor;
    private static final SerialDescriptor parcelableArrayDescriptor;
    private static final SerialDescriptor parcelableListDescriptor;
    private static final SerialDescriptor polymorphicCharSequenceArrayDescriptor;
    private static final SerialDescriptor polymorphicCharSequenceDescriptor;
    private static final SerialDescriptor polymorphicCharSequenceListDescriptor;
    private static final SerialDescriptor polymorphicIBinderDescriptor;
    private static final SerialDescriptor polymorphicJavaSerializableDescriptor;
    private static final SerialDescriptor polymorphicParcelableArrayDescriptor;
    private static final SerialDescriptor polymorphicParcelableDescriptor;
    private static final SerialDescriptor polymorphicParcelableListDescriptor;
    private static final SerialDescriptor polymorphicSparseParcelableArrayDescriptor;
    private static final SerialDescriptor sparseParcelableArrayDescriptor;
    static {
        PolymorphicSerializer polymorphicSerializer = new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(CharSequence.class));
        SavedStateCodecUtils_androidKt.polymorphicCharSequenceDescriptor = polymorphicSerializer.getDescriptor();
        PolymorphicSerializer polymorphicSerializer2 = new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(Parcelable.class));
        SavedStateCodecUtils_androidKt.polymorphicParcelableDescriptor = polymorphicSerializer2.getDescriptor();
        PolymorphicSerializer polymorphicSerializer3 = new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(Serializable.class));
        SavedStateCodecUtils_androidKt.polymorphicJavaSerializableDescriptor = polymorphicSerializer3.getDescriptor();
        PolymorphicSerializer polymorphicSerializer4 = new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(IBinder.class));
        SavedStateCodecUtils_androidKt.polymorphicIBinderDescriptor = polymorphicSerializer4.getDescriptor();
        int i = 0;
        SavedStateCodecUtils_androidKt.parcelableArrayDescriptor = BuiltinSerializersKt.ArraySerializer(Reflection.getOrCreateKotlinClass(Parcelable.class), (KSerializer)DefaultParcelableSerializer.INSTANCE).getDescriptor();
        PolymorphicSerializer polymorphicSerializer5 = new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(Parcelable.class));
        int i2 = 0;
        SavedStateCodecUtils_androidKt.polymorphicParcelableArrayDescriptor = BuiltinSerializersKt.ArraySerializer(Reflection.getOrCreateKotlinClass(Parcelable.class), (KSerializer)polymorphicSerializer5).getDescriptor();
        SavedStateCodecUtils_androidKt.parcelableListDescriptor = BuiltinSerializersKt.ListSerializer((KSerializer)DefaultParcelableSerializer.INSTANCE).getDescriptor();
        PolymorphicSerializer polymorphicSerializer6 = new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(Parcelable.class));
        SavedStateCodecUtils_androidKt.polymorphicParcelableListDescriptor = BuiltinSerializersKt.ListSerializer((KSerializer)polymorphicSerializer6).getDescriptor();
        int i3 = 0;
        SavedStateCodecUtils_androidKt.charSequenceArrayDescriptor = BuiltinSerializersKt.ArraySerializer(Reflection.getOrCreateKotlinClass(CharSequence.class), (KSerializer)CharSequenceSerializer.INSTANCE).getDescriptor();
        PolymorphicSerializer polymorphicSerializer7 = new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(CharSequence.class));
        int i4 = 0;
        SavedStateCodecUtils_androidKt.polymorphicCharSequenceArrayDescriptor = BuiltinSerializersKt.ArraySerializer(Reflection.getOrCreateKotlinClass(CharSequence.class), (KSerializer)polymorphicSerializer7).getDescriptor();
        SavedStateCodecUtils_androidKt.charSequenceListDescriptor = BuiltinSerializersKt.ListSerializer((KSerializer)CharSequenceSerializer.INSTANCE).getDescriptor();
        PolymorphicSerializer polymorphicSerializer8 = new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(CharSequence.class));
        SavedStateCodecUtils_androidKt.polymorphicCharSequenceListDescriptor = BuiltinSerializersKt.ListSerializer((KSerializer)polymorphicSerializer8).getDescriptor();
        SparseArraySerializer sparseArraySerializer = new SparseArraySerializer((KSerializer)DefaultParcelableSerializer.INSTANCE);
        SavedStateCodecUtils_androidKt.sparseParcelableArrayDescriptor = sparseArraySerializer.getDescriptor();
        PolymorphicSerializer polymorphicSerializer9 = new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(Parcelable.class));
        SparseArraySerializer sparseArraySerializer2 = new SparseArraySerializer((KSerializer)polymorphicSerializer9);
        SavedStateCodecUtils_androidKt.polymorphicSparseParcelableArrayDescriptor = sparseArraySerializer2.getDescriptor();
        PolymorphicSerializer polymorphicSerializer10 = new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(Parcelable.class));
        SparseArraySerializer sparseArraySerializer3 = new SparseArraySerializer(BuiltinSerializersKt.getNullable((KSerializer)polymorphicSerializer10));
        SavedStateCodecUtils_androidKt.nullablePolymorphicSparseParcelableArrayDescriptor = sparseArraySerializer3.getDescriptor();
    }

    public static final SerialDescriptor getCharSequenceArrayDescriptor() {
        return SavedStateCodecUtils_androidKt.charSequenceArrayDescriptor;
    }

    public static void getCharSequenceArrayDescriptor$annotations() {
    }

    public static final SerialDescriptor getCharSequenceListDescriptor() {
        return SavedStateCodecUtils_androidKt.charSequenceListDescriptor;
    }

    public static final SerialDescriptor getNullablePolymorphicSparseParcelableArrayDescriptor() {
        return SavedStateCodecUtils_androidKt.nullablePolymorphicSparseParcelableArrayDescriptor;
    }

    public static final SerialDescriptor getParcelableArrayDescriptor() {
        return SavedStateCodecUtils_androidKt.parcelableArrayDescriptor;
    }

    public static void getParcelableArrayDescriptor$annotations() {
    }

    public static final SerialDescriptor getParcelableListDescriptor() {
        return SavedStateCodecUtils_androidKt.parcelableListDescriptor;
    }

    public static final SerialDescriptor getPolymorphicCharSequenceArrayDescriptor() {
        return SavedStateCodecUtils_androidKt.polymorphicCharSequenceArrayDescriptor;
    }

    public static void getPolymorphicCharSequenceArrayDescriptor$annotations() {
    }

    public static final SerialDescriptor getPolymorphicCharSequenceDescriptor() {
        return SavedStateCodecUtils_androidKt.polymorphicCharSequenceDescriptor;
    }

    public static final SerialDescriptor getPolymorphicCharSequenceListDescriptor() {
        return SavedStateCodecUtils_androidKt.polymorphicCharSequenceListDescriptor;
    }

    public static final SerialDescriptor getPolymorphicIBinderDescriptor() {
        return SavedStateCodecUtils_androidKt.polymorphicIBinderDescriptor;
    }

    public static final SerialDescriptor getPolymorphicJavaSerializableDescriptor() {
        return SavedStateCodecUtils_androidKt.polymorphicJavaSerializableDescriptor;
    }

    public static final SerialDescriptor getPolymorphicParcelableArrayDescriptor() {
        return SavedStateCodecUtils_androidKt.polymorphicParcelableArrayDescriptor;
    }

    public static void getPolymorphicParcelableArrayDescriptor$annotations() {
    }

    public static final SerialDescriptor getPolymorphicParcelableDescriptor() {
        return SavedStateCodecUtils_androidKt.polymorphicParcelableDescriptor;
    }

    public static final SerialDescriptor getPolymorphicParcelableListDescriptor() {
        return SavedStateCodecUtils_androidKt.polymorphicParcelableListDescriptor;
    }

    public static final SerialDescriptor getPolymorphicSparseParcelableArrayDescriptor() {
        return SavedStateCodecUtils_androidKt.polymorphicSparseParcelableArrayDescriptor;
    }

    public static final SerialDescriptor getSparseParcelableArrayDescriptor() {
        return SavedStateCodecUtils_androidKt.sparseParcelableArrayDescriptor;
    }
}
