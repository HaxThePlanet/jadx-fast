package kotlin.text;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0019\u0008\u0086\u0081\u0002\u0018\u0000 \u001b2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001bB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011j\u0002\u0008\u0012j\u0002\u0008\u0013j\u0002\u0008\u0014j\u0002\u0008\u0015j\u0002\u0008\u0016j\u0002\u0008\u0017j\u0002\u0008\u0018j\u0002\u0008\u0019j\u0002\u0008\u001a¨\u0006\u001c", d2 = {"Lkotlin/text/CharDirectionality;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "LEFT_TO_RIGHT", "RIGHT_TO_LEFT", "RIGHT_TO_LEFT_ARABIC", "EUROPEAN_NUMBER", "EUROPEAN_NUMBER_SEPARATOR", "EUROPEAN_NUMBER_TERMINATOR", "ARABIC_NUMBER", "COMMON_NUMBER_SEPARATOR", "NONSPACING_MARK", "BOUNDARY_NEUTRAL", "PARAGRAPH_SEPARATOR", "SEGMENT_SEPARATOR", "WHITESPACE", "OTHER_NEUTRALS", "LEFT_TO_RIGHT_EMBEDDING", "LEFT_TO_RIGHT_OVERRIDE", "RIGHT_TO_LEFT_EMBEDDING", "RIGHT_TO_LEFT_OVERRIDE", "POP_DIRECTIONAL_FORMAT", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum CharDirectionality {

    UNDEFINED(-1),
    LEFT_TO_RIGHT(false),
    RIGHT_TO_LEFT("UNDEFINED"),
    RIGHT_TO_LEFT_ARABIC(false),
    EUROPEAN_NUMBER("UNDEFINED"),
    EUROPEAN_NUMBER_SEPARATOR(false),
    EUROPEAN_NUMBER_TERMINATOR("UNDEFINED"),
    ARABIC_NUMBER(false),
    COMMON_NUMBER_SEPARATOR("UNDEFINED"),
    NONSPACING_MARK(false),
    BOUNDARY_NEUTRAL("UNDEFINED"),
    PARAGRAPH_SEPARATOR(false),
    SEGMENT_SEPARATOR("UNDEFINED"),
    WHITESPACE(false),
    OTHER_NEUTRALS("UNDEFINED"),
    LEFT_TO_RIGHT_EMBEDDING(false),
    LEFT_TO_RIGHT_OVERRIDE("UNDEFINED"),
    RIGHT_TO_LEFT_EMBEDDING(false),
    RIGHT_TO_LEFT_OVERRIDE("UNDEFINED"),
    POP_DIRECTIONAL_FORMAT(false);

    private final int value;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u0005R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\r", d2 = {"Lkotlin/text/CharDirectionality$Companion;", "", "()V", "directionalityMap", "", "", "Lkotlin/text/CharDirectionality;", "getDirectionalityMap", "()Ljava/util/Map;", "directionalityMap$delegate", "Lkotlin/Lazy;", "valueOf", "directionality", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        private final Map<Integer, kotlin.text.CharDirectionality> getDirectionalityMap() {
            return (Map)CharDirectionality.access$getDirectionalityMap$delegate$cp().getValue();
        }

        public final kotlin.text.CharDirectionality valueOf(int directionality) {
            Object obj = getDirectionalityMap().get(Integer.valueOf(directionality));
            if ((CharDirectionality)obj == null) {
            } else {
                return (CharDirectionality)obj;
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Directionality #").append(directionality).append(" is not defined.").toString());
            throw illegalArgumentException;
        }
    }
    private static final kotlin.text.CharDirectionality[] $values() {
        return /* result */;
    }

    public static final Lazy access$getDirectionalityMap$delegate$cp() {
        return CharDirectionality.directionalityMap$delegate;
    }

    public static EnumEntries<kotlin.text.CharDirectionality> getEntries() {
        return CharDirectionality.$ENTRIES;
    }

    @Override // java.lang.Enum
    public final int getValue() {
        return this.value;
    }
}
