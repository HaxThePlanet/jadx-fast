package app.dogo.com.dogo_android.d.b;

import app.dogo.com.dogo_android.k.i;
import app.dogo.com.dogo_android.k.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\u0008\u0086\u0001\u0018\u0000 \n2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\t¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/CommentSource;", "", "source", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getSource", "()Ljava/lang/String;", "COMMENT_LIST", "VOTER_PROFILE", "PHOTO_LIST", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum y {

    COMMENT_LIST("commentList"),
    VOTER_PROFILE("commentList"),
    PHOTO_LIST("commentList");

    private final String source;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/CommentSource$Companion;", "", "()V", "commentSourceParser", "Lapp/dogo/com/dogo_android/challenge/comments/CommentSource;", "tag", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final app.dogo.com.dogo_android.d.b.y a(String string) {
            int obj2;
            if (n.b(string, j.CHALLENGE_COMMENTS_DIALOG.getTag())) {
                return y.COMMENT_LIST;
            }
            if (n.b(string, j.CHALLENGE_PROFILE_DETAILS_DIALOG_FRAGMENT.getTag()) != null) {
                return y.VOTER_PROFILE;
            }
            obj2 = n.b(string, i.CHALLENGE_HOME_FRAGMENT.getTag()) ? y.PHOTO_LIST : 0;
            return obj2;
        }
    }
    private static final app.dogo.com.dogo_android.d.b.y[] $values() {
        app.dogo.com.dogo_android.d.b.y[] arr = new y[3];
        return arr;
    }

    public static final app.dogo.com.dogo_android.d.b.y commentSourceParser(String string) {
        return y.Companion.a(string);
    }

    @Override // java.lang.Enum
    public final String getSource() {
        return this.source;
    }
}
