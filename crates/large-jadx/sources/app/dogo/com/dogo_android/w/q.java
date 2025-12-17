package app.dogo.com.dogo_android.w;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c0\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000c0\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$BitingProgram;", "", "()V", "BitingArticleTapped", "Lapp/dogo/com/dogo_android/tracking/Event1;", "Lapp/dogo/com/dogo_android/tracking/EP$ArticleId;", "BitingCertificateTapped", "Lapp/dogo/com/dogo_android/tracking/EP$Type;", "BitingProgramTrickTapped", "SpecialProgramTrickTapped", "Lapp/dogo/com/dogo_android/tracking/Event2;", "Lapp/dogo/com/dogo_android/tracking/EP$ProgramId;", "Lapp/dogo/com/dogo_android/tracking/EP$TrickId;", "SpecialProgramVariationTapped", "Lapp/dogo/com/dogo_android/tracking/Event3;", "Lapp/dogo/com/dogo_android/tracking/EP$Id;", "VariationTapped", "Lapp/dogo/com/dogo_android/tracking/EP$ViewSource;", "VariationTipsTapped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class q {

    public static final app.dogo.com.dogo_android.w.u2<app.dogo.com.dogo_android.w.o2> a;
    public static final app.dogo.com.dogo_android.w.u2<app.dogo.com.dogo_android.w.o2> b;
    public static final app.dogo.com.dogo_android.w.v2<app.dogo.com.dogo_android.w.r2, app.dogo.com.dogo_android.w.n2> c;
    public static final app.dogo.com.dogo_android.w.v2<app.dogo.com.dogo_android.w.e2, app.dogo.com.dogo_android.w.n2> d;
    public static final app.dogo.com.dogo_android.w.w2<app.dogo.com.dogo_android.w.e2, app.dogo.com.dogo_android.w.n2, app.dogo.com.dogo_android.w.q1> e;
    public static final app.dogo.com.dogo_android.w.u2<app.dogo.com.dogo_android.w.w0> f;
    static {
        app.dogo.com.dogo_android.w.s2.a companion = s2.Companion;
        o2 o2Var = new o2();
        q.a = companion.a("biting_certificate_tapped").b(o2Var);
        o2 o2Var2 = new o2();
        q.b = companion.a("biting_program_button_tapped").b(o2Var2);
        n2 n2Var = new n2();
        companion.a("variation_tips_tapped").b(n2Var);
        r2 r2Var = new r2();
        n2 n2Var2 = new n2();
        q.c = companion.a("variation_tapped").c(r2Var, n2Var2);
        e2 e2Var = new e2();
        n2 n2Var3 = new n2();
        q.d = companion.a("special_program_trick_tapped").c(e2Var, n2Var3);
        e2 e2Var2 = new e2();
        n2 n2Var4 = new n2();
        q1 q1Var = new q1();
        q.e = companion.a("special_program_variation_tapped").d(e2Var2, n2Var4, q1Var);
        w0 w0Var = new w0();
        q.f = companion.a("biting_article_tapped").b(w0Var);
    }
}
