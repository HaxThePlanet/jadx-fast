package app.dogo.com.dogo_android.w;

import kotlin.Metadata;

/* compiled from: Events.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c0\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000c0\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$BitingProgram;", "", "()V", "BitingArticleTapped", "Lapp/dogo/com/dogo_android/tracking/Event1;", "Lapp/dogo/com/dogo_android/tracking/EP$ArticleId;", "BitingCertificateTapped", "Lapp/dogo/com/dogo_android/tracking/EP$Type;", "BitingProgramTrickTapped", "SpecialProgramTrickTapped", "Lapp/dogo/com/dogo_android/tracking/Event2;", "Lapp/dogo/com/dogo_android/tracking/EP$ProgramId;", "Lapp/dogo/com/dogo_android/tracking/EP$TrickId;", "SpecialProgramVariationTapped", "Lapp/dogo/com/dogo_android/tracking/Event3;", "Lapp/dogo/com/dogo_android/tracking/EP$Id;", "VariationTapped", "Lapp/dogo/com/dogo_android/tracking/EP$ViewSource;", "VariationTipsTapped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: q, reason: from kotlin metadata */
public final class E_BitingProgram {

    public static final u2<o2> a;
    public static final u2<o2> b;
    public static final v2<r2, n2> c;
    public static final v2<e2, n2> d;
    public static final w2<e2, n2, q1> e;
    public static final u2<w0> f;
    static {
        app.dogo.com.dogo_android.w.s2.a companion2 = Event.Companion;
        E_BitingProgram.a = companion2.a("biting_certificate_tapped").b(new EP_Type());
        E_BitingProgram.b = companion2.a("biting_program_button_tapped").b(new EP_Type());
        companion2.a("variation_tips_tapped").b(new EP_TrickId());
        E_BitingProgram.c = companion2.a("variation_tapped").c(new EP_ViewSource(), new EP_TrickId());
        E_BitingProgram.d = companion2.a("special_program_trick_tapped").c(new EP_ProgramId(), new EP_TrickId());
        E_BitingProgram.e = companion2.a("special_program_variation_tapped").d(new EP_ProgramId(), new EP_TrickId(), new EP_Id());
        E_BitingProgram.f = companion2.a("biting_article_tapped").b(new EP_ArticleId());
    }
}
