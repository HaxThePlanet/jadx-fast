package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\u0008\u0016¢\u0006\u0002\u0010\u0002B\u0019\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0008\u0010\u000c\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Lkotlin/collections/builders/SerializedCollection;", "Ljava/io/Externalizable;", "()V", "collection", "", "tag", "", "(Ljava/util/Collection;I)V", "readExternal", "", "input", "Ljava/io/ObjectInput;", "readResolve", "", "writeExternal", "output", "Ljava/io/ObjectOutput;", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SerializedCollection implements Externalizable {

    public static final kotlin.collections.builders.SerializedCollection.Companion Companion = null;
    private static final long serialVersionUID = 0L;
    public static final int tagList = 0;
    public static final int tagSet = 1;
    private Collection<?> collection;
    private final int tag;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Lkotlin/collections/builders/SerializedCollection$Companion;", "", "()V", "serialVersionUID", "", "tagList", "", "tagSet", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        SerializedCollection.Companion companion = new SerializedCollection.Companion(0);
        SerializedCollection.Companion = companion;
    }

    public SerializedCollection() {
        super((Collection)CollectionsKt.emptyList(), 0);
    }

    public SerializedCollection(Collection<?> collection, int tag) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        super();
        this.collection = collection;
        this.tag = tag;
    }

    private final Object readResolve() {
        return this.collection;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput input) {
        Object build;
        int i4;
        Object obj;
        int i;
        int i3;
        int i2;
        Object object;
        Intrinsics.checkNotNullParameter(input, "input");
        byte byte = input.readByte();
        final int i5 = byte & 1;
        int i7 = 46;
        if (byte & -2 != 0) {
        } else {
            int int = input.readInt();
            if (int < 0) {
            } else {
                i4 = 0;
                switch (i5) {
                    case 0:
                        List listBuilder = CollectionsKt.createListBuilder(int);
                        i = 0;
                        i3 = i4;
                        i2 = 0;
                        listBuilder.add(input.readObject());
                        i4++;
                        build = CollectionsKt.build(listBuilder);
                        break;
                    case 1:
                        Set setBuilder = SetsKt.createSetBuilder(int);
                        i = 0;
                        i3 = i4;
                        i2 = 0;
                        setBuilder.add(input.readObject());
                        i4++;
                        build = SetsKt.build(setBuilder);
                        break;
                    default:
                        StringBuilder stringBuilder2 = new StringBuilder();
                        InvalidObjectException invalidObjectException = new InvalidObjectException(stringBuilder2.append("Unsupported collection type tag: ").append(i5).append(i7).toString());
                        throw invalidObjectException;
                }
                this.collection = build;
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            InvalidObjectException invalidObjectException2 = new InvalidObjectException(stringBuilder3.append("Illegal size value: ").append(int).append(i7).toString());
            throw invalidObjectException2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        InvalidObjectException size = new InvalidObjectException(stringBuilder.append("Unsupported flags value: ").append(byte).append(i7).toString());
        throw size;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput output) {
        Object next;
        Intrinsics.checkNotNullParameter(output, "output");
        output.writeByte(this.tag);
        output.writeInt(this.collection.size());
        Iterator iterator = this.collection.iterator();
        for (Object next : iterator) {
            output.writeObject(next);
        }
    }
}
