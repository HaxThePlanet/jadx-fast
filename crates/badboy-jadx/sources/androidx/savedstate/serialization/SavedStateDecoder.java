package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind.LIST;
import kotlinx.serialization.descriptors.StructureKind.MAP;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.modules.SerializersModule;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000c\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\u0008\u0010\u001c\u001a\u00020\u001dH\u0016J\u0008\u0010\u001e\u001a\u00020\u001fH\u0016J\u0008\u0010 \u001a\u00020\u0012H\u0016J\u0008\u0010!\u001a\u00020\"H\u0016J\u0008\u0010#\u001a\u00020$H\u0016J\u0008\u0010%\u001a\u00020&H\u0016J\u0008\u0010'\u001a\u00020(H\u0016J\u0008\u0010)\u001a\u00020\rH\u0016J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0019H\u0016J\u000e\u0010,\u001a\u0008\u0012\u0004\u0012\u00020\u00120-H\u0002J\u000e\u0010.\u001a\u0008\u0012\u0004\u0012\u00020\r0-H\u0002J\u0008\u0010/\u001a\u000200H\u0002J\u0008\u00101\u001a\u000202H\u0002J\u0008\u00103\u001a\u000204H\u0002J\u0008\u00105\u001a\u000206H\u0002J\u0008\u00107\u001a\u000208H\u0002J\u0008\u00109\u001a\u00020:H\u0002J\u0013\u0010;\u001a\u0008\u0012\u0004\u0012\u00020\r0<H\u0002¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020?2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0008\u0010@\u001a\u00020\u001bH\u0016J!\u0010A\u001a\u0002HB\"\u0004\u0008\u0000\u0010B2\u000c\u0010C\u001a\u0008\u0012\u0004\u0012\u0002HB0DH\u0016¢\u0006\u0002\u0010EJ#\u0010F\u001a\u0004\u0018\u0001HB\"\u0004\u0008\u0000\u0010B2\u000c\u0010C\u001a\u0008\u0012\u0004\u0012\u0002HB0DH\u0002¢\u0006\u0002\u0010ER\u001a\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\r@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006G", d2 = {"Landroidx/savedstate/serialization/SavedStateDecoder;", "Lkotlinx/serialization/encoding/AbstractDecoder;", "savedState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "<init>", "(Landroid/os/Bundle;Landroidx/savedstate/serialization/SavedStateConfiguration;)V", "getSavedState$savedstate_release", "()Landroid/os/Bundle;", "Landroid/os/Bundle;", "value", "", "key", "getKey$savedstate_release", "()Ljava/lang/String;", "index", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "decodeElementIndex", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeBoolean", "", "decodeByte", "", "decodeShort", "", "decodeInt", "decodeLong", "", "decodeFloat", "", "decodeDouble", "", "decodeChar", "", "decodeString", "decodeEnum", "enumDescriptor", "decodeIntList", "", "decodeStringList", "decodeBooleanArray", "", "decodeCharArray", "", "decodeDoubleArray", "", "decodeFloatArray", "", "decodeIntArray", "", "decodeLongArray", "", "decodeStringArray", "", "()[Ljava/lang/String;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decodeNotNullMark", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeFormatSpecificTypes", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedStateDecoder extends AbstractDecoder {

    private final androidx.savedstate.serialization.SavedStateConfiguration configuration;
    private int index;
    private String key;
    private final Bundle savedState;
    private final SerializersModule serializersModule;
    public SavedStateDecoder(Bundle savedState, androidx.savedstate.serialization.SavedStateConfiguration configuration) {
        Intrinsics.checkNotNullParameter(savedState, "savedState");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        super();
        this.savedState = savedState;
        this.configuration = configuration;
        this.key = "";
        this.serializersModule = this.configuration.getSerializersModule();
    }

    private final boolean[] decodeBooleanArray() {
        final int i = 0;
        final int i2 = 0;
        return SavedStateReader.getBooleanArray-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    private final char[] decodeCharArray() {
        final int i = 0;
        final int i2 = 0;
        return SavedStateReader.getCharArray-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    private final double[] decodeDoubleArray() {
        final int i = 0;
        final int i2 = 0;
        return SavedStateReader.getDoubleArray-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    private static final boolean decodeElementIndex$hasDefaultValueDefined(SerialDescriptor $descriptor, int index) {
        return $descriptor.isElementOptional(index);
    }

    private static final boolean decodeElementIndex$presentInEncoding(androidx.savedstate.serialization.SavedStateDecoder this$0, SerialDescriptor $descriptor, int index) {
        final int i = 0;
        final int i2 = 0;
        return SavedStateReader.contains-impl(SavedStateReader.constructor-impl(this$0.savedState), $descriptor.getElementName(index));
    }

    private final float[] decodeFloatArray() {
        final int i = 0;
        final int i2 = 0;
        return SavedStateReader.getFloatArray-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    private final <T> T decodeFormatSpecificTypes(DeserializationStrategy<? extends T> deserializer) {
        Object decodeFormatSpecificTypesOnPlatform;
        boolean stringArrayDescriptor;
        if (SavedStateDecoder_androidKt.decodeFormatSpecificTypesOnPlatform(this, deserializer) == null) {
            SerialDescriptor descriptor = deserializer.getDescriptor();
            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getIntListDescriptor())) {
                decodeFormatSpecificTypesOnPlatform = decodeIntList();
            } else {
                if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getStringListDescriptor())) {
                    decodeFormatSpecificTypesOnPlatform = decodeStringList();
                } else {
                    if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getBooleanArrayDescriptor())) {
                        decodeFormatSpecificTypesOnPlatform = decodeBooleanArray();
                    } else {
                        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getCharArrayDescriptor())) {
                            decodeFormatSpecificTypesOnPlatform = decodeCharArray();
                        } else {
                            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getDoubleArrayDescriptor())) {
                                decodeFormatSpecificTypesOnPlatform = decodeDoubleArray();
                            } else {
                                if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getFloatArrayDescriptor())) {
                                    decodeFormatSpecificTypesOnPlatform = decodeFloatArray();
                                } else {
                                    if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getIntArrayDescriptor())) {
                                        decodeFormatSpecificTypesOnPlatform = decodeIntArray();
                                    } else {
                                        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getLongArrayDescriptor())) {
                                            decodeFormatSpecificTypesOnPlatform = decodeLongArray();
                                        } else {
                                            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getStringArrayDescriptor())) {
                                                decodeFormatSpecificTypesOnPlatform = decodeStringArray();
                                            } else {
                                                decodeFormatSpecificTypesOnPlatform = 0;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return decodeFormatSpecificTypesOnPlatform;
    }

    private final int[] decodeIntArray() {
        final int i = 0;
        final int i2 = 0;
        return SavedStateReader.getIntArray-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    private final List<Integer> decodeIntList() {
        final int i = 0;
        final int i2 = 0;
        return SavedStateReader.getIntList-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    private final long[] decodeLongArray() {
        final int i = 0;
        final int i2 = 0;
        return SavedStateReader.getLongArray-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    private final String[] decodeStringArray() {
        final int i = 0;
        final int i2 = 0;
        return SavedStateReader.getStringArray-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    private final List<String> decodeStringList() {
        final int i = 0;
        final int i2 = 0;
        return SavedStateReader.getStringList-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        Object obj;
        Object savedStateDecoder;
        Bundle $this$beginStructure_u24lambda_u2421;
        int i;
        String key;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (Intrinsics.areEqual(this.key, "")) {
            obj = this;
        } else {
            int i2 = 0;
            i = 0;
            savedStateDecoder = new SavedStateDecoder(SavedStateReader.getSavedState-impl(SavedStateReader.constructor-impl(this.savedState), this.key), this.configuration);
            obj = savedStateDecoder;
        }
        return obj;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder
    public boolean decodeBoolean() {
        final int i = 0;
        final int i2 = 0;
        return SavedStateReader.getBoolean-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder
    public byte decodeByte() {
        final int i = 0;
        final int i2 = 0;
        return (byte)int-impl;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder
    public char decodeChar() {
        final int i = 0;
        final int i2 = 0;
        return SavedStateReader.getChar-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder
    public double decodeDouble() {
        final int i = 0;
        final int i2 = 0;
        return SavedStateReader.getDouble-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder
    public int decodeElementIndex(SerialDescriptor descriptor) {
        int $this$read$iv;
        boolean equal;
        StructureKind.MAP iNSTANCE;
        int decodeElementIndex$hasDefaultValueDefined;
        int $this$decodeElementIndex_u24lambda_u240;
        int i;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (!Intrinsics.areEqual(descriptor.getKind(), StructureKind.LIST.INSTANCE)) {
            if (Intrinsics.areEqual(descriptor.getKind(), StructureKind.MAP.INSTANCE)) {
                iNSTANCE = 0;
                i = 0;
                $this$read$iv = $this$decodeElementIndex_u24lambda_u240;
            } else {
                $this$read$iv = descriptor.getElementsCount();
            }
        } else {
        }
        while (this.index < $this$read$iv) {
            if (SavedStateDecoder.decodeElementIndex$hasDefaultValueDefined(descriptor, this.index)) {
            }
            if (!SavedStateDecoder.decodeElementIndex$presentInEncoding(this, descriptor, this.index)) {
            }
            this.index = index3++;
        }
        if (this.index < $this$read$iv) {
            this.key = descriptor.getElementName(this.index);
            int index6 = this.index;
            this.index = index6 + 1;
            return index6;
        }
        return -1;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder
    public int decodeEnum(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        final int i = 0;
        final int i2 = 0;
        return SavedStateReader.getInt-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder
    public float decodeFloat() {
        final int i = 0;
        final int i2 = 0;
        return SavedStateReader.getFloat-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder
    public int decodeInt() {
        final int i = 0;
        final int i2 = 0;
        return SavedStateReader.getInt-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder
    public long decodeLong() {
        final int i = 0;
        final int i2 = 0;
        return SavedStateReader.getLong-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder
    public boolean decodeNotNullMark() {
        final int i = 0;
        final int i2 = 0;
        return null-impl ^ 1;
    }

    public <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializer) {
        Object decodeFormatSpecificTypes;
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        if (decodeFormatSpecificTypes(deserializer) == null) {
            decodeFormatSpecificTypes = super.decodeSerializableValue(deserializer);
        }
        return decodeFormatSpecificTypes;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder
    public short decodeShort() {
        final int i = 0;
        final int i2 = 0;
        return (short)int-impl;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder
    public String decodeString() {
        final int i = 0;
        final int i2 = 0;
        return SavedStateReader.getString-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder
    public final String getKey$savedstate_release() {
        return this.key;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder
    public final Bundle getSavedState$savedstate_release() {
        return this.savedState;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }
}
