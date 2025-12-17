package f.c.a.d.b.j;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import f.c.a.d.c.b;
import f.c.a.d.c.g;
import f.c.a.d.c.j;
import f.c.a.d.c.l;
import f.c.a.d.c.n;

/* loaded from: classes2.dex */
public abstract class g extends f.c.a.d.b.j.b implements f.c.a.d.b.j.f {
    public g() {
        super("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
    }

    @Override // f.c.a.d.b.j.b
    protected final boolean j(int i, Parcel parcel2, Parcel parcel3, int i4) {
        int obj3 = 1;
        if (i != obj3) {
            int obj4 = 0;
            if (i == 2) {
            } else {
                if (i == 3) {
                } else {
                    if (i == 4) {
                    } else {
                        if (i == 6) {
                        } else {
                            if (i == 8) {
                            } else {
                                if (i == 15) {
                                } else {
                                    if (i == 10) {
                                    } else {
                                        if (i == 11) {
                                        } else {
                                            return 0;
                                        }
                                        l((Status)c.a(parcel2, Status.CREATOR));
                                        throw obj4;
                                    }
                                    D1((Status)c.a(parcel2, Status.CREATOR), c.c(parcel2));
                                    throw obj4;
                                }
                                F1((Status)c.a(parcel2, Status.CREATOR), (n)c.a(parcel2, n.CREATOR));
                                throw obj4;
                            }
                            A1((Status)c.a(parcel2, Status.CREATOR), (j)c.a(parcel2, j.CREATOR));
                            throw obj4;
                        }
                        O0((Status)c.a(parcel2, Status.CREATOR), (l)c.a(parcel2, l.CREATOR));
                        throw obj4;
                    }
                    Y1((Status)c.a(parcel2, Status.CREATOR), c.c(parcel2));
                    throw obj4;
                }
                n0((Status)c.a(parcel2, Status.CREATOR), (b)c.a(parcel2, b.CREATOR));
                throw obj4;
            }
            zza(parcel2.readString());
            throw obj4;
        }
        G((Status)c.a(parcel2, Status.CREATOR), (g)c.a(parcel2, g.CREATOR));
        return obj3;
    }
}
