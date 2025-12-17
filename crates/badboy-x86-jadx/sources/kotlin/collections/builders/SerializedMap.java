package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u0008\u0016¢\u0006\u0002\u0010\u0002B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016J\u0008\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u000c\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lkotlin/collections/builders/SerializedMap;", "Ljava/io/Externalizable;", "()V", "map", "", "(Ljava/util/Map;)V", "readExternal", "", "input", "Ljava/io/ObjectInput;", "readResolve", "", "writeExternal", "output", "Ljava/io/ObjectOutput;", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class SerializedMap implements Externalizable {

    public static final kotlin.collections.builders.SerializedMap.Companion Companion;
    private static final long serialVersionUID;
    private Map<?, ?> map;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lkotlin/collections/builders/SerializedMap$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        SerializedMap.Companion companion = new SerializedMap.Companion(0);
        SerializedMap.Companion = companion;
    }

    public SerializedMap() {
        super(MapsKt.emptyMap());
    }

    public SerializedMap(Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        super();
        this.map = map;
    }

    private final Object readResolve() {
        return this.map;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput input) {
        int i2;
        int i;
        int i3;
        Object object2;
        Object object;
        Intrinsics.checkNotNullParameter(input, "input");
        byte byte = input.readByte();
        if (byte != 0) {
        } else {
            int int = input.readInt();
            if (int < 0) {
            } else {
                Map mapBuilder = MapsKt.createMapBuilder(int);
                int i5 = 0;
                i2 = 0;
                while (i2 < int) {
                    i = i2;
                    i3 = 0;
                    mapBuilder.put(input.readObject(), input.readObject());
                    i2++;
                }
                this.map = MapsKt.build(mapBuilder);
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            InvalidObjectException invalidObjectException = new InvalidObjectException(stringBuilder2.append("Illegal size value: ").append(int).append('.').toString());
            throw invalidObjectException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        InvalidObjectException size = new InvalidObjectException(stringBuilder.append("Unsupported flags value: ").append(byte).toString());
        throw size;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput output) {
        Object next;
        Object value;
        Intrinsics.checkNotNullParameter(output, "output");
        output.writeByte(0);
        output.writeInt(this.map.size());
        Iterator iterator = this.map.entrySet().iterator();
        for (Map.Entry next : iterator) {
            output.writeObject(next.getKey());
            output.writeObject(next.getValue());
        }
    }
}
