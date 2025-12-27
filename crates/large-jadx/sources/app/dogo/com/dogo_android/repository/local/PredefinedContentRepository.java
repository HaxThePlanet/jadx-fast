package app.dogo.com.dogo_android.s.b;

import android.content.res.Resources;
import app.dogo.com.dogo_android.repository.domain.LibraryTag;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: PredefinedContentRepository.kt */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0017\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/repository/local/PredefinedContentRepository;", "", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "libraryTagAll", "Lapp/dogo/com/dogo_android/repository/domain/LibraryTag;", "getLibraryTagAll", "()Lapp/dogo/com/dogo_android/repository/domain/LibraryTag;", "programComingSoonMockData", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "getProgramComingSoonMockData", "()Ljava/util/List;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h1, reason: from kotlin metadata */
public final class PredefinedContentRepository {

    /* renamed from: a, reason: from kotlin metadata */
    private final LibraryTag libraryTagAll;
    /* renamed from: b, reason: from kotlin metadata */
    private final List<ProgramDescriptionItem> programComingSoonMockData;
    public h1(Resources resources) throws android.content.res.Resources.NotFoundException {
        n.f(resources, "resources");
        super();
        final String string = resources.getString(2131886124);
        n.e(string, "getString(R.string.all_general)");
        super(false, string, "id_all", 1, null);
        this.libraryTagAll = resources2;
        this.programComingSoonMockData = p.g();
    }

    public final LibraryTag a() {
        return this.libraryTagAll;
    }

    public final List<ProgramDescriptionItem> b() {
        return this.programComingSoonMockData;
    }
}
