package app.dogo.com.dogo_android.repository.domain;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001:\u0002\u000c\rB\u0005¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SimpleVimeoVideo;", "", "()V", "files", "", "Lapp/dogo/com/dogo_android/repository/domain/SimpleVimeoVideo$VideoFile;", "getFiles", "()Ljava/util/List;", "pictures", "Lapp/dogo/com/dogo_android/repository/domain/SimpleVimeoVideo$PictureFiles;", "getPictures", "()Lapp/dogo/com/dogo_android/repository/domain/SimpleVimeoVideo$PictureFiles;", "PictureFiles", "VideoFile", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SimpleVimeoVideo {

    private final List<app.dogo.com.dogo_android.repository.domain.SimpleVimeoVideo.VideoFile> files;
    private final app.dogo.com.dogo_android.repository.domain.SimpleVimeoVideo.PictureFiles pictures;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\r¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SimpleVimeoVideo$PictureFiles;", "", "()V", "link", "", "getLink", "()Ljava/lang/String;", "sizes", "Ljava/util/ArrayList;", "Lapp/dogo/com/dogo_android/repository/domain/SimpleVimeoVideo$PictureFiles$PictureFile;", "getSizes", "()Ljava/util/ArrayList;", "setSizes", "(Ljava/util/ArrayList;)V", "PictureFile", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class PictureFiles {

        private final String link;
        private ArrayList<app.dogo.com.dogo_android.repository.domain.SimpleVimeoVideo.PictureFiles.PictureFile> sizes;
        public final String getLink() {
            return this.link;
        }

        public final ArrayList<app.dogo.com.dogo_android.repository.domain.SimpleVimeoVideo.PictureFiles.PictureFile> getSizes() {
            return this.sizes;
        }

        public final void setSizes(ArrayList<app.dogo.com.dogo_android.repository.domain.SimpleVimeoVideo.PictureFiles.PictureFile> arrayList) {
            this.sizes = arrayList;
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SimpleVimeoVideo$VideoFile;", "", "()V", "link", "", "getLink", "()Ljava/lang/String;", "quality", "getQuality", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class VideoFile {

        private final String link;
        private final String quality;
        public final String getLink() {
            return this.link;
        }

        public final String getQuality() {
            return this.quality;
        }
    }
    public final List<app.dogo.com.dogo_android.repository.domain.SimpleVimeoVideo.VideoFile> getFiles() {
        return this.files;
    }

    public final app.dogo.com.dogo_android.repository.domain.SimpleVimeoVideo.PictureFiles getPictures() {
        return this.pictures;
    }
}
