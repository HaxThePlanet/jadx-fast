package app.dogo.com.dogo_android.k;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: DogGender.kt */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\u0008\u0086\u0001\u0018\u0000 \u000b2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\u0008\u0002\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\n¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/enums/DogGender;", "", "trackTag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTrackTag", "()Ljava/lang/String;", "UNKNOWN", "MALE", "FEMALE", "OTHER", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public enum DogGender {

    FEMALE,
    MALE,
    OTHER,
    UNKNOWN;

    private final String trackTag;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\tH\u0007¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/enums/DogGender$Companion;", "", "()V", "enumFromApiGender", "Lapp/dogo/com/dogo_android/enums/DogGender;", "apiGender", "", "genderIntToEnum", "value", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final d enumFromApiGender(String apiGender) {
            int i = 0;
            app.dogo.com.dogo_android.k.d uNKNOWN2 = null;
            boolean z;
            n.f(apiGender, "apiGender");
            app.dogo.com.dogo_android.k.d[] values = DogGender.values();
            i = 0;
            for (app.dogo.com.dogo_android.k.d uNKNOWN2 : values) {
                if (n.b(uNKNOWN2.getTrackTag(), apiGender)) {
                    break;
                }
            }
            int i2 = 0;
            if (uNKNOWN2 == null) {
                uNKNOWN2 = DogGender.UNKNOWN;
            }
            return uNKNOWN2;
        }

        /* renamed from: b, reason: from kotlin metadata */
        public final d genderIntToEnum(int value) {
            app.dogo.com.dogo_android.k.d fEMALE2;
            if (value == null) {
                fEMALE2 = DogGender.MALE;
            } else {
                int i = 1;
                if (value == 1) {
                    fEMALE2 = DogGender.FEMALE;
                } else {
                    i = 2;
                    if (value != 2) {
                        i = 3;
                        value = DogGender.UNKNOWN;
                    } else {
                        value = DogGender.OTHER;
                    }
                }
            }
            return DogGender.UNKNOWN;
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    @Override // java.lang.Enum
    public final String getTrackTag() {
        return this.trackTag;
    }

    private static final /* synthetic */ d[] $values() {
        app.dogo.com.dogo_android.k.d[] arr = new d[4];
        return new d[] { DogGender.UNKNOWN, DogGender.MALE, DogGender.FEMALE, DogGender.OTHER };
    }

    public static final d genderIntToEnum(int i) {
        return DogGender.INSTANCE.genderIntToEnum(i);
    }
}
