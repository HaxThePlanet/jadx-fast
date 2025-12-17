package app.dogo.com.dogo_android.s.b;

import android.content.res.Resources;
import app.dogo.com.dogo_android.repository.domain.LibraryTag;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0017\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/repository/local/PredefinedContentRepository;", "", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "libraryTagAll", "Lapp/dogo/com/dogo_android/repository/domain/LibraryTag;", "getLibraryTagAll", "()Lapp/dogo/com/dogo_android/repository/domain/LibraryTag;", "programComingSoonMockData", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "getProgramComingSoonMockData", "()Ljava/util/List;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h1 {

    private final LibraryTag a;
    private final List<ProgramDescriptionItem> b;
    public h1(Resources resources) {
        n.f(resources, "resources");
        super();
        final String string = resources.getString(2131886124);
        n.e(string, "getString(R.string.all_general)");
        super(0, string, "id_all", 1, 0);
        this.a = obj8;
        this.b = p.g();
    }

    public final LibraryTag a() {
        return this.a;
    }

    public final List<ProgramDescriptionItem> b() {
        return this.b;
    }
}
