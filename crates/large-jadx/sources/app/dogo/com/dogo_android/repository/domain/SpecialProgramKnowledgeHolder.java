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

/* compiled from: SpecialProgramKnowledgeHolder.kt */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001(B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0008\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0014\u0010\u000c\u001a\u00020\r2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000fJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0010J\u001e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J)\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0014\u0008\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\u000e\u0010 \u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0003J\u0016\u0010!\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003J\t\u0010\"\u001a\u00020\u0017HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0019\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006)", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramKnowledgeHolder;", "Landroid/os/Parcelable;", "dogId", "", "tricks", "", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramKnowledgeHolder$TrickAndVariationKnowledge;", "(Ljava/lang/String;Ljava/util/Map;)V", "getDogId", "()Ljava/lang/String;", "getTricks", "()Ljava/util/Map;", "addAll", "", "events", "", "Lapp/dogo/com/dogo_android/repository/domain/BitingProgramProgress$TrickVariationEvent;", "addTrickEvent", "event", "addTrickRating", "trickId", "variationId", "rating", "", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "getTrickKnowledgeData", "getVariationKnowledge", "hashCode", "toString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "TrickAndVariationKnowledge", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SpecialProgramKnowledgeHolder implements Parcelable {

    public static final Parcelable.Creator<SpecialProgramKnowledgeHolder> CREATOR = new SpecialProgramKnowledgeHolder$Creator<>();
    private final String dogId;
    private final Map<String, SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge> tricks;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SpecialProgramKnowledgeHolder> {
        @Override // android.os.Parcelable$Creator
        public final SpecialProgramKnowledgeHolder createFromParcel(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            final int _int = parcel.readInt();
            final LinkedHashMap linkedHashMap = new LinkedHashMap(_int);
            i = 0;
            while (i != _int) {
                linkedHashMap.put(parcel.readString(), SpecialProgramKnowledgeHolder_TrickAndVariationKnowledge.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new SpecialProgramKnowledgeHolder(parcel.readString(), linkedHashMap);
        }

        @Override // android.os.Parcelable$Creator
        public final SpecialProgramKnowledgeHolder[] newArray(int i) {
            return new SpecialProgramKnowledgeHolder[i];
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010%\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0008\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0014\u0008\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramKnowledgeHolder$TrickAndVariationKnowledge;", "Landroid/os/Parcelable;", "trickId", "", "knowledge", "", "variations", "", "(Ljava/lang/String;ILjava/util/Map;)V", "getKnowledge", "()I", "setKnowledge", "(I)V", "getTrickId", "()Ljava/lang/String;", "getVariations", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickAndVariationKnowledge implements Parcelable {

        public static final Parcelable.Creator<SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge> CREATOR = new SpecialProgramKnowledgeHolder$TrickAndVariationKnowledge$Creator<>();
        private int knowledge;
        private final String trickId;
        private final Map<String, Integer> variations;
        public TrickAndVariationKnowledge(String str, int i, Map<String, Integer> map) {
            n.f(str, "trickId");
            n.f(map, "variations");
            super();
            this.trickId = str;
            this.knowledge = i;
            this.variations = map;
        }

        public final int getKnowledge() {
            return this.knowledge;
        }

        public final String getTrickId() {
            return this.trickId;
        }

        public final Map<String, Integer> getVariations() {
            return this.variations;
        }

        public final void setKnowledge(int i) {
            this.knowledge = i;
        }

        public /* synthetic */ TrickAndVariationKnowledge(String str, int i, Map map, int i2, g gVar) {
            Object obj;
            i = i2 & 2 != 0 ? 0 : i;
            if (i2 & 4 != 0) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
            }
            this(str, i, obj);
        }


        public static /* synthetic */ SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge copy$default(SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge trickAndVariationKnowledge, String str, int i, Map map, int i2, Object object) {
            String trickId2;
            int knowledge2;
            Map variations2;
            if (i2 & 1 != 0) {
            }
            if (i2 & 2 != 0) {
            }
            if (i2 & 4 != 0) {
            }
            return trickAndVariationKnowledge.copy(trickId2, knowledge2, variations2);
        }

        /* operator */ public final String component1() {
            return this.trickId;
        }

        /* operator */ public final int component2() {
            return this.knowledge;
        }

        /* operator */ public final Map<String, Integer> component3() {
            return this.variations;
        }

        public final SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge copy(String trickId, int knowledge, Map<String, Integer> variations) {
            n.f(trickId, "trickId");
            n.f(variations, "variations");
            return new SpecialProgramKnowledgeHolder_TrickAndVariationKnowledge(trickId, knowledge, variations);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z4 = false;
            if (!(other instanceof SpecialProgramKnowledgeHolder_TrickAndVariationKnowledge)) {
                return false;
            }
            if (!n.b(this.trickId, other.trickId)) {
                return false;
            }
            if (this.knowledge != other.knowledge) {
                return false;
            }
            return !n.b(this.variations, other.variations) ? z4 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.trickId.hashCode() * 31) + Integer.hashCode(this.knowledge) * 31 + this.variations.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "TrickAndVariationKnowledge(trickId=";
            String str3 = ", knowledge=";
            String str4 = ", variations=";
            str = str2 + this.trickId + str3 + this.knowledge + str4 + this.variations + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.trickId);
            parcel.writeInt(this.knowledge);
            parcel.writeInt(this.variations.size());
            Iterator it = this.variations.entrySet().iterator();
            while (it.hasNext()) {
                Object item = it.next();
                parcel.writeString((String)item.getKey());
                parcel.writeInt((Number)item.getValue().intValue());
            }
        }
    }
    public SpecialProgramKnowledgeHolder(String str, Map<String, SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge> map) {
        n.f(str, "dogId");
        n.f(map, "tricks");
        super();
        this.dogId = str;
        this.tricks = map;
    }

    public final void addAll(List<BitingProgramProgress.TrickVariationEvent> events) {
        item = "events";
        n.f(events, item);
        final Iterator it = events.iterator();
        while (it.hasNext()) {
            addTrickEvent((BitingProgramProgress_TrickVariationEvent)it.next());
        }
    }

    public final void addTrickEvent(BitingProgramProgress.TrickVariationEvent event) {
        n.f(event, "event");
        addTrickRating(event.getTrickId(), event.getVariationId(), event.getKnowledge());
    }

    public final void addTrickRating(String trickId, String variationId, int rating) {
        n.f(trickId, "trickId");
        n.f(variationId, "variationId");
        Object value = this.tricks.get(trickId);
        if (value != null) {
            if (l.z(variationId)) {
                value.setKnowledge(rating);
            } else {
                value.getVariations().put(variationId, Integer.valueOf(rating));
            }
        } else {
            if (l.z(variationId)) {
                SpecialProgramKnowledgeHolder_TrickAndVariationKnowledge specialProgramKnowledgeHolder_TrickAndVariationKnowledge = new SpecialProgramKnowledgeHolder_TrickAndVariationKnowledge(trickId, rating, null, 4, null);
                this.tricks.put(trickId, specialProgramKnowledgeHolder_TrickAndVariationKnowledge);
            } else {
                int i = 0;
                kotlin.o[] arr = new o[1];
                int i2 = 2;
                g gVar = null;
                SpecialProgramKnowledgeHolder_TrickAndVariationKnowledge specialProgramKnowledgeHolder_TrickAndVariationKnowledge2 = new SpecialProgramKnowledgeHolder_TrickAndVariationKnowledge(trickId, i, j0.m(new o[] { u.a(variationId, Integer.valueOf(rating)) }), i2, gVar);
                this.tricks.put(trickId, specialProgramKnowledgeHolder_TrickAndVariationKnowledge2);
            }
        }
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge getTrickKnowledgeData(String trickId) {
        Object value;
        n.f(trickId, "trickId");
        if ((SpecialProgramKnowledgeHolder_TrickAndVariationKnowledge)this.tricks.get(trickId) == null) {
            int i = 0;
            Map map = null;
            int i2 = 6;
            g gVar = null;
            SpecialProgramKnowledgeHolder_TrickAndVariationKnowledge specialProgramKnowledgeHolder_TrickAndVariationKnowledge = new SpecialProgramKnowledgeHolder_TrickAndVariationKnowledge(trickId, i, map, i2, gVar);
        }
        return value;
    }

    public final Map<String, SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge> getTricks() {
        return this.tricks;
    }

    public final int getVariationKnowledge(String trickId, String variationId) {
        int value = 0;
        n.f(trickId, "trickId");
        n.f(variationId, "variationId");
        Object value2 = this.tricks.get(trickId);
        value = 0;
        if (value2 != null) {
            value2 = value2.getVariations().get(variationId);
            if (value2 != null) {
                value = value2.intValue();
            }
        }
        return value;
    }

    public /* synthetic */ SpecialProgramKnowledgeHolder(String str, Map map, int i, g gVar) {
        Object obj;
        if (i & 2 != 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
        }
        this(str, obj);
    }


    public static /* synthetic */ SpecialProgramKnowledgeHolder copy$default(SpecialProgramKnowledgeHolder specialProgramKnowledgeHolder, String str, Map map, int i, Object object) {
        String dogId2;
        Map tricks2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return specialProgramKnowledgeHolder.copy(dogId2, tricks2);
    }

    /* operator */ public final String component1() {
        return this.dogId;
    }

    /* operator */ public final Map<String, SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge> component2() {
        return this.tricks;
    }

    public final SpecialProgramKnowledgeHolder copy(String dogId, Map<String, SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge> tricks) {
        n.f(dogId, "dogId");
        n.f(tricks, "tricks");
        return new SpecialProgramKnowledgeHolder(dogId, tricks);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z4 = false;
        if (!(other instanceof SpecialProgramKnowledgeHolder)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        return !n.b(this.tricks, other.tricks) ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.dogId.hashCode() * 31) + this.tricks.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SpecialProgramKnowledgeHolder(dogId=";
        String str3 = ", tricks=";
        str = str2 + this.dogId + str3 + this.tricks + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.dogId);
        parcel.writeInt(this.tricks.size());
        Iterator it = this.tricks.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            parcel.writeString((String)item.getKey());
            (SpecialProgramKnowledgeHolder_TrickAndVariationKnowledge)item.getValue().writeToParcel(parcel, flags);
        }
    }
}
