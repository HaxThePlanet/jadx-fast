package f.c.a.e.d0;

/* compiled from: CutCornerTreatment.java */
/* loaded from: classes2.dex */
public class e extends d {

    float a = -1f;
    public e() {
        super();
    }

    @Override // f.c.a.e.d0.d
    public void a(m mVar, float f, float f2, float f3) {
        float f6 = 180f;
        mVar.o(0.0f, f3 * f2, f6, f6 - f);
        double d4 = (double)f3;
        final double d9 = (double)f2;
        mVar.m((float)(Math.sin(Math.toRadians((double)f)) * d4) * d9, (float)(Math.sin(Math.toRadians((double)(90f - f)))) * d4 * d9);
    }
}
