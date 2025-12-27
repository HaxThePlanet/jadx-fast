package f.c.a.d.b.j;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import f.c.a.d.c.b;
import f.c.a.d.c.g;
import f.c.a.d.c.j;
import f.c.a.d.c.l;
import f.c.a.d.c.n;

/* loaded from: classes2.dex */
public abstract class g extends b implements f {
    public g() {
        super("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
    }

    @Override // f.c.a.d.b.j.b
    protected final boolean j(int i, Parcel parcel, Parcel parcel2, int i2) {
        int i3 = 1;
        if (i != i3 && i != 2) {
            if (i == 3) {
                n0((Status)c.a(parcel, Status.CREATOR), (b)c.a(parcel, b.CREATOR));
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i13;
            } else {
                if (Status.CREATOR == 4) {
                    Y1((Status)c.a(parcel, Status.CREATOR), c.c(parcel));
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i13;
                } else {
                    if (Status.CREATOR == 6) {
                        O0((Status)c.a(parcel, Status.CREATOR), (l)c.a(parcel, l.CREATOR));
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i13;
                    } else {
                        if (Status.CREATOR == 8) {
                            A1((Status)c.a(parcel, Status.CREATOR), (j)c.a(parcel, j.CREATOR));
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i13;
                        } else {
                            if (Status.CREATOR == 15) {
                                F1((Status)c.a(parcel, Status.CREATOR), (n)c.a(parcel, n.CREATOR));
                                /* Dexterity WARN: Type inference failed for thrown value */
                                throw (Throwable) i13;
                            } else {
                                if (Status.CREATOR == 10) {
                                    D1((Status)c.a(parcel, Status.CREATOR), c.c(parcel));
                                    /* Dexterity WARN: Type inference failed for thrown value */
                                    throw (Throwable) i13;
                                } else {
                                    if (Status.CREATOR == 11) {
                                        l((Status)c.a(parcel, Status.CREATOR));
                                        /* Dexterity WARN: Type inference failed for thrown value */
                                        throw (Throwable) i13;
                                    } else {
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        G((Status)c.a(parcel, Status.CREATOR), (g)c.a(parcel, g.CREATOR));
        return true;
    }
}
