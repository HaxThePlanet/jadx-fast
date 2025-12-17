package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.u;
import kotlin.y.j0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001(B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0008\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0014\u0010\u000c\u001a\u00020\r2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000fJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0010J\u001e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J)\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0014\u0008\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\u000e\u0010 \u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0003J\u0016\u0010!\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003J\t\u0010\"\u001a\u00020\u0017HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0019\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006)", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramKnowledgeHolder;", "Landroid/os/Parcelable;", "dogId", "", "tricks", "", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramKnowledgeHolder$TrickAndVariationKnowledge;", "(Ljava/lang/String;Ljava/util/Map;)V", "getDogId", "()Ljava/lang/String;", "getTricks", "()Ljava/util/Map;", "addAll", "", "events", "", "Lapp/dogo/com/dogo_android/repository/domain/BitingProgramProgress$TrickVariationEvent;", "addTrickEvent", "event", "addTrickRating", "trickId", "variationId", "rating", "", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "getTrickKnowledgeData", "getVariationKnowledge", "hashCode", "toString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "TrickAndVariationKnowledge", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SpecialProgramKnowledgeHolder implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder> CREATOR;
    private final String dogId;
    private final Map<String, app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge> tricks;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder createFromParcel(Parcel parcel) {
            int i;
            String string;
            Object fromParcel;
            n.f(parcel, "parcel");
            final int int = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(int);
            i = 0;
            while (i != int) {
                linkedHashMap.put(parcel.readString(), SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge.CREATOR.createFromParcel(parcel));
                i++;
            }
            SpecialProgramKnowledgeHolder obj7 = new SpecialProgramKnowledgeHolder(parcel.readString(), linkedHashMap);
            return obj7;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder[] newArray(int i) {
            return new SpecialProgramKnowledgeHolder[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010%\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0008\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0014\u0008\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramKnowledgeHolder$TrickAndVariationKnowledge;", "Landroid/os/Parcelable;", "trickId", "", "knowledge", "", "variations", "", "(Ljava/lang/String;ILjava/util/Map;)V", "getKnowledge", "()I", "setKnowledge", "(I)V", "getTrickId", "()Ljava/lang/String;", "getVariations", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickAndVariationKnowledge implements Parcelable {

        public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge> CREATOR;
        private int knowledge;
        private final String trickId;
        private final Map<String, Integer> variations;
        static {
            SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge.Creator creator = new SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge.Creator();
            SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge.CREATOR = creator;
        }

        public TrickAndVariationKnowledge(String string, int i2, Map<String, Integer> map3) {
            n.f(string, "trickId");
            n.f(map3, "variations");
            super();
            this.trickId = string;
            this.knowledge = i2;
            this.variations = map3;
        }

        public TrickAndVariationKnowledge(String string, int i2, Map map3, int i4, g g5) {
            int obj2;
            LinkedHashMap obj3;
            obj2 = i4 & 2 != 0 ? 0 : obj2;
            if (i4 &= 4 != 0) {
                obj3 = new LinkedHashMap();
            }
            super(string, obj2, obj3);
        }

        public static app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge copy$default(app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge specialProgramKnowledgeHolder$TrickAndVariationKnowledge, String string2, int i3, Map map4, int i5, Object object6) {
            String obj1;
            int obj2;
            Map obj3;
            if (i5 & 1 != 0) {
                obj1 = trickAndVariationKnowledge.trickId;
            }
            if (i5 & 2 != 0) {
                obj2 = trickAndVariationKnowledge.knowledge;
            }
            if (i5 &= 4 != 0) {
                obj3 = trickAndVariationKnowledge.variations;
            }
            return trickAndVariationKnowledge.copy(obj1, obj2, obj3);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.trickId;
        }

        @Override // android.os.Parcelable
        public final int component2() {
            return this.knowledge;
        }

        public final Map<String, Integer> component3() {
            return this.variations;
        }

        public final app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge copy(String string, int i2, Map<String, Integer> map3) {
            n.f(string, "trickId");
            n.f(map3, "variations");
            SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge trickAndVariationKnowledge = new SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge(string, i2, map3);
            return trickAndVariationKnowledge;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge) {
                return i2;
            }
            if (!n.b(this.trickId, object.trickId)) {
                return i2;
            }
            if (this.knowledge != object.knowledge) {
                return i2;
            }
            if (!n.b(this.variations, object.variations)) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final int getKnowledge() {
            return this.knowledge;
        }

        @Override // android.os.Parcelable
        public final String getTrickId() {
            return this.trickId;
        }

        public final Map<String, Integer> getVariations() {
            return this.variations;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i4 += i7;
        }

        @Override // android.os.Parcelable
        public final void setKnowledge(int i) {
            this.knowledge = i;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TrickAndVariationKnowledge(trickId=");
            stringBuilder.append(this.trickId);
            stringBuilder.append(", knowledge=");
            stringBuilder.append(this.knowledge);
            stringBuilder.append(", variations=");
            stringBuilder.append(this.variations);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            int intValue;
            Object key;
            n.f(parcel, "out");
            parcel.writeString(this.trickId);
            parcel.writeInt(this.knowledge);
            Map obj4 = this.variations;
            parcel.writeInt(obj4.size());
            obj4 = obj4.entrySet().iterator();
            for (Map.Entry next2 : obj4) {
                parcel.writeString((String)next2.getKey());
                parcel.writeInt((Number)next2.getValue().intValue());
            }
        }
    }
    static {
        SpecialProgramKnowledgeHolder.Creator creator = new SpecialProgramKnowledgeHolder.Creator();
        SpecialProgramKnowledgeHolder.CREATOR = creator;
    }

    public SpecialProgramKnowledgeHolder(String string, Map<String, app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge> map2) {
        n.f(string, "dogId");
        n.f(map2, "tricks");
        super();
        this.dogId = string;
        this.tricks = map2;
    }

    public SpecialProgramKnowledgeHolder(String string, Map map2, int i3, g g4) {
        LinkedHashMap obj2;
        if (i3 &= 2 != 0) {
            obj2 = new LinkedHashMap();
        }
        super(string, obj2);
    }

    public static app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder copy$default(app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder specialProgramKnowledgeHolder, String string2, Map map3, int i4, Object object5) {
        String obj1;
        Map obj2;
        if (i4 & 1 != 0) {
            obj1 = specialProgramKnowledgeHolder.dogId;
        }
        if (i4 &= 2 != 0) {
            obj2 = specialProgramKnowledgeHolder.tricks;
        }
        return specialProgramKnowledgeHolder.copy(obj1, obj2);
    }

    public final void addAll(List<app.dogo.com.dogo_android.repository.domain.BitingProgramProgress.TrickVariationEvent> list) {
        String next;
        n.f(list, "events");
        final Iterator obj2 = list.iterator();
        for (BitingProgramProgress.TrickVariationEvent next : obj2) {
            addTrickEvent(next);
        }
    }

    @Override // android.os.Parcelable
    public final void addTrickEvent(app.dogo.com.dogo_android.repository.domain.BitingProgramProgress.TrickVariationEvent bitingProgramProgress$TrickVariationEvent) {
        n.f(trickVariationEvent, "event");
        addTrickRating(trickVariationEvent.getTrickId(), trickVariationEvent.getVariationId(), trickVariationEvent.getKnowledge());
    }

    @Override // android.os.Parcelable
    public final void addTrickRating(String string, String string2, int i3) {
        Object tricks;
        Object obj2;
        Object obj;
        int i2;
        Map map;
        int i;
        int trickAndVariationKnowledge2;
        app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge trickAndVariationKnowledge;
        Map obj9;
        Object obj10;
        Integer obj11;
        n.f(string, "trickId");
        n.f(string2, "variationId");
        tricks = this.tricks.get(string);
        if ((SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge)tricks != null) {
            if (l.z(string2)) {
                (SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge)tricks.setKnowledge(i3);
            } else {
                tricks.getVariations().put(string2, Integer.valueOf(i3));
            }
        } else {
            if (l.z(string2)) {
                super(string, i3, 0, 4, 0);
                this.tricks.put(string, trickAndVariationKnowledge2);
            } else {
                kotlin.o[] arr = new o[1];
                super(string, 0, j0.m(u.a(string2, Integer.valueOf(i3))), 2, 0);
                this.tricks.put(string, trickAndVariationKnowledge);
            }
        }
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.dogId;
    }

    public final Map<String, app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge> component2() {
        return this.tricks;
    }

    public final app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder copy(String string, Map<String, app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge> map2) {
        n.f(string, "dogId");
        n.f(map2, "tricks");
        SpecialProgramKnowledgeHolder specialProgramKnowledgeHolder = new SpecialProgramKnowledgeHolder(string, map2);
        return specialProgramKnowledgeHolder;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof SpecialProgramKnowledgeHolder) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (!n.b(this.tricks, object.tricks)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getDogId() {
        return this.dogId;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge getTrickKnowledgeData(String string) {
        Object trickAndVariationKnowledge;
        app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge trickAndVariationKnowledge2;
        Object obj;
        int i3;
        int i4;
        int i;
        int i2;
        n.f(string, "trickId");
        if ((SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge)this.tricks.get(string) == null) {
            super(string, 0, 0, 6, 0);
        }
        return trickAndVariationKnowledge;
    }

    public final Map<String, app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge> getTricks() {
        return this.tricks;
    }

    @Override // android.os.Parcelable
    public final int getVariationKnowledge(String string, String string2) {
        int intValue;
        Object obj2;
        n.f(string, "trickId");
        n.f(string2, "variationId");
        obj2 = this.tricks.get(string);
        intValue = 0;
        if ((SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge)obj2 == null) {
        } else {
            obj2 = (SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge)obj2.getVariations().get(string2);
            if ((Integer)obj2 == null) {
            } else {
                intValue = (Integer)obj2.intValue();
            }
        }
        return intValue;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i2 += i4;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SpecialProgramKnowledgeHolder(dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", tricks=");
        stringBuilder.append(this.tricks);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int value;
        Object key;
        n.f(parcel, "out");
        parcel.writeString(this.dogId);
        Map tricks = this.tricks;
        parcel.writeInt(tricks.size());
        Iterator iterator = tricks.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            parcel.writeString((String)next2.getKey());
            (SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge)next2.getValue().writeToParcel(parcel, i2);
        }
    }
}
