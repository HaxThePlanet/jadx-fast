package app.dogo.com.dogo_android.util.g0;

import android.content.res.Resources;
import android.os.CountDownTimer;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.v2;

/* compiled from: ParticipateButtonHelper.java */
/* loaded from: classes.dex */
public class b extends a {

    private final Resources A;
    private CountDownTimer B;
    private b.b C;
    private long D;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[b.b.values().length];
            b.a.a = iArr;
            try {
                iArr[b.b.FIRST_UPLOAD.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                b.a.a[b.b.ADDITIONAL_UPLOAD.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                b.a.a[b.b.TIMEOUT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                b.a.a[b.b.LOADING.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    public enum b {

        ADDITIONAL_UPLOAD,
        FIRST_UPLOAD,
        LOADING,
        TIMEOUT;
    }
    public b(Resources resources) throws android.content.res.Resources.NotFoundException {
        super(2131100336, true, 2131231360, 2131099706, resources.getString(2131886304), 2131099706, 1f, 1);
        l(true);
        this.A = resources;
    }

    private void n() {
        if (this.B != null) {
            this.B.cancel();
            CountDownTimer countDownTimer = null;
            this.B = countDownTimer;
        }
    }

    private void q(b.b bVar) throws android.content.res.Resources.NotFoundException {
        int i6 = b.a.a[bVar.ordinal()];
        int i7 = 1;
        if (b.a.a == i7) {
            int i = 2131100336;
            tRUE2 = Boolean.TRUE;
            int i2 = 2131231360;
            int i3 = 2131099706;
            int i4 = 2131099706;
            float f = 1f;
            int i5 = 1;
            this.m(i, tRUE2, i2, i3, this.A.getString(2131886304), i4, f, i5, tRUE2);
            n();
        } else {
            if (this.A == 2) {
                i = 2131100336;
                tRUE2 = Boolean.TRUE;
                i2 = 2131231360;
                i3 = 2131099706;
                i4 = 2131099706;
                f = 1f;
                i5 = 1;
                this.m(i, tRUE2, i2, i3, this.A.getString(2131886302), i4, f, i5, tRUE2);
                n();
            } else {
                if (this.A == 3) {
                    tRUE2 = Boolean.FALSE;
                    i2 = 2131231360;
                    i3 = 2131100375;
                    Object[] arr = new Object[i7];
                    i4 = 2131100379;
                    f = 0.5f;
                    i5 = 2;
                    this.m(R.color.black, tRUE2, i2, i3, this.A.getString(2131886303, new Object[] { s(this.D).toLowerCase() }), i4, f, i5, tRUE2);
                } else {
                    i = 4;
                    if (this.A == 4) {
                        i = 0;
                        Boolean tRUE2 = null;
                        i2 = 2131231360;
                        i3 = 0;
                        String string = null;
                        i4 = 0;
                        f = 0.3f;
                        i5 = 0;
                        tRUE2 = null;
                        this.m(i, tRUE2, i2, i3, string, i4, f, i5, tRUE2);
                        n();
                    }
                }
            }
        }
        this.C = bVar;
    }

    private String s(long j) {
        return App.p().k(j, true);
    }

    @Override // app.dogo.com.dogo_android.util.g0.a
    public void o() {
        q(b.b.LOADING);
    }

    @Override // app.dogo.com.dogo_android.util.g0.a
    public void p(b.b bVar) {
        q(bVar);
    }

    @Override // app.dogo.com.dogo_android.util.g0.a
    public b.b r() {
        return this.C;
    }

    @Override // app.dogo.com.dogo_android.util.g0.a
    public boolean t() {
        return this.C.equals(b.b.LOADING);
    }

    @Override // app.dogo.com.dogo_android.util.g0.a
    public void u(ChallengeEntryModel challengeEntryModel, long j) {
        if (challengeEntryModel == null) {
            q(b.b.FIRST_UPLOAD);
        } else {
            long timeTillAdditionalUploadInMillis = challengeEntryModel.computeTimeTillAdditionalUploadInMillis(j);
            long l = 0L;
            if (timeTillAdditionalUploadInMillis < l) {
                q(b.b.ADDITIONAL_UPLOAD);
            } else {
                this.D = challengeEntryModel.computeTimeTillAdditionalUploadInMillis(j);
                q(b.b.TIMEOUT);
            }
        }
    }
}
