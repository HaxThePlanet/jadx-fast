package app.dogo.com.dogo_android.d.b;

import app.dogo.com.dogo_android.k.i;
import app.dogo.com.dogo_android.k.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: CommentSource.kt */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\u0008\u0086\u0001\u0018\u0000 \n2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\t¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/CommentSource;", "", "source", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getSource", "()Ljava/lang/String;", "COMMENT_LIST", "VOTER_PROFILE", "PHOTO_LIST", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: y, reason: from kotlin metadata */
public enum CommentSource {

    COMMENT_LIST,
    PHOTO_LIST,
    VOTER_PROFILE;

    private final String source;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/CommentSource$Companion;", "", "()V", "commentSourceParser", "Lapp/dogo/com/dogo_android/challenge/comments/CommentSource;", "tag", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final y commentSourceParser(String tag) {
            int i = 0;
            if (n.b(tag, FullScreenTag.CHALLENGE_COMMENTS_DIALOG.getTag())) {
                return CommentSource.COMMENT_LIST;
            }
            if (n.b(tag, FullScreenTag.CHALLENGE_PROFILE_DETAILS_DIALOG_FRAGMENT.getTag()) != null) {
                return CommentSource.VOTER_PROFILE;
            }
            tag = n.b(tag, FragmentTags.CHALLENGE_HOME_FRAGMENT.getTag()) ? CommentSource.PHOTO_LIST : 0;
            return (n.b(tag, FragmentTags.CHALLENGE_HOME_FRAGMENT.getTag()) ? CommentSource.PHOTO_LIST : 0);
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    @Override // java.lang.Enum
    public final String getSource() {
        return this.source;
    }

    private static final /* synthetic */ y[] $values() {
        app.dogo.com.dogo_android.d.b.y[] arr = new y[3];
        return new y[] { CommentSource.COMMENT_LIST, CommentSource.VOTER_PROFILE, CommentSource.PHOTO_LIST };
    }

    public static final y commentSourceParser(String str) {
        return CommentSource.INSTANCE.commentSourceParser(str);
    }
}
