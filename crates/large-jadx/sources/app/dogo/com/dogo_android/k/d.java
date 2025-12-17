package app.dogo.com.dogo_android.k;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\u0008\u0086\u0001\u0018\u0000 \u000b2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\u0008\u0002\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\n¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/enums/DogGender;", "", "trackTag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTrackTag", "()Ljava/lang/String;", "UNKNOWN", "MALE", "FEMALE", "OTHER", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum d {

    UNKNOWN(false),
    MALE("male"),
    FEMALE("male"),
    OTHER("male");

    private final String trackTag;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\tH\u0007¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/enums/DogGender$Companion;", "", "()V", "enumFromApiGender", "Lapp/dogo/com/dogo_android/enums/DogGender;", "apiGender", "", "genderIntToEnum", "value", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final app.dogo.com.dogo_android.k.d a(String string) {
            int i;
            app.dogo.com.dogo_android.k.d uNKNOWN;
            boolean z;
            n.f(string, "apiGender");
            app.dogo.com.dogo_android.k.d[] values = d.values();
            i = 0;
            while (i < values.length) {
                i++;
            }
            uNKNOWN = 0;
            if (uNKNOWN == null) {
                uNKNOWN = d.UNKNOWN;
            }
            return uNKNOWN;
        }

        public final app.dogo.com.dogo_android.k.d b(int i) {
            int i2;
            app.dogo.com.dogo_android.k.d obj2;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        obj2 = i != 3 ? d.UNKNOWN : d.UNKNOWN;
                    } else {
                        obj2 = d.OTHER;
                    }
                } else {
                    obj2 = d.FEMALE;
                }
            } else {
                obj2 = d.MALE;
            }
            return obj2;
        }
    }
    private static final app.dogo.com.dogo_android.k.d[] $values() {
        app.dogo.com.dogo_android.k.d[] arr = new d[4];
        return arr;
    }

    public static final app.dogo.com.dogo_android.k.d genderIntToEnum(int i) {
        return d.Companion.b(i);
    }

    @Override // java.lang.Enum
    public final String getTrackTag() {
        return this.trackTag;
    }
}
