package app.dogo.com.dogo_android.util.g0;

import android.content.res.Resources;
import android.os.CountDownTimer;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.v2;

/* loaded from: classes.dex */
public class b extends app.dogo.com.dogo_android.util.g0.a {

    private final Resources A;
    private CountDownTimer B;
    private app.dogo.com.dogo_android.util.g0.b.b C;
    private long D;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            b.a.a = iArr;
            iArr[b.b.FIRST_UPLOAD.ordinal()] = 1;
            b.a.a[b.b.ADDITIONAL_UPLOAD.ordinal()] = 2;
            b.a.a[b.b.TIMEOUT.ordinal()] = 3;
            b.a.a[b.b.LOADING.ordinal()] = 4;
        }
    }

    public static enum b {

        FIRST_UPLOAD,
        ADDITIONAL_UPLOAD,
        TIMEOUT,
        LOADING;
    }
    public b(Resources resources) {
        super(2131100336, 1, 2131231360, 2131099706, resources.getString(2131886304), 2131099706, 1065353216, 1);
        l(true);
        this.A = resources;
    }

    private void n() {
        CountDownTimer time;
        time = this.B;
        if (time != null) {
            time.cancel();
            this.B = 0;
        }
    }

    private void q(app.dogo.com.dogo_android.util.g0.b.b b$b) {
        Object i5;
        int i2;
        Boolean bool;
        int i3;
        int i7;
        String string;
        int i6;
        int i4;
        int i;
        Boolean fALSE;
        i5 = b.a.a[b.ordinal()];
        int i8 = 1;
        if (i5 != i8) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 4) {
                    } else {
                        this.m(0, 0, 2131231360, 0, 0, 0, 1050253722, 0, 0);
                        n();
                    }
                } else {
                    fALSE = Boolean.FALSE;
                    Object[] arr = new Object[i8];
                    arr[0] = s(this.D).toLowerCase();
                    this.m(2131099697, fALSE, 2131231360, 2131100375, this.A.getString(2131886303, arr), 2131100379, 1056964608, 2, fALSE);
                }
            } else {
                fALSE = Boolean.TRUE;
                this.m(2131100336, fALSE, 2131231360, 2131099706, this.A.getString(2131886302), 2131099706, 1065353216, 1, fALSE);
                n();
            }
        } else {
            fALSE = Boolean.TRUE;
            this.m(2131100336, fALSE, 2131231360, 2131099706, this.A.getString(2131886304), 2131099706, 1065353216, 1, fALSE);
            n();
        }
        this.C = b;
    }

    private String s(long l) {
        return App.p().k(l, obj4);
    }

    @Override // app.dogo.com.dogo_android.util.g0.a
    public void o() {
        q(b.b.LOADING);
    }

    @Override // app.dogo.com.dogo_android.util.g0.a
    public void p(app.dogo.com.dogo_android.util.g0.b.b b$b) {
        q(b);
    }

    @Override // app.dogo.com.dogo_android.util.g0.a
    public app.dogo.com.dogo_android.util.g0.b.b r() {
        return this.C;
    }

    @Override // app.dogo.com.dogo_android.util.g0.a
    public boolean t() {
        return this.C.equals(b.b.LOADING);
    }

    @Override // app.dogo.com.dogo_android.util.g0.a
    public void u(ChallengeEntryModel challengeEntryModel, long l2) {
        int cmp;
        int i;
        app.dogo.com.dogo_android.util.g0.b.b obj5;
        if (challengeEntryModel == null) {
            q(b.b.FIRST_UPLOAD);
        } else {
            if (Long.compare(timeTillAdditionalUploadInMillis, i) < 0) {
                q(b.b.ADDITIONAL_UPLOAD);
            } else {
                this.D = challengeEntryModel.computeTimeTillAdditionalUploadInMillis(l2);
                q(b.b.TIMEOUT);
            }
        }
    }
}
