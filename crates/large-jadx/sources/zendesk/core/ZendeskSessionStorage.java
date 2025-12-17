package zendesk.core;

import f.g.c.a;
import f.g.e.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import okhttp3.Cache;

/* loaded from: classes3.dex */
class ZendeskSessionStorage implements zendesk.core.SessionStorage {

    private static final String LOG_TAG = "SessionStorage";
    private final zendesk.core.BaseStorage additionalSdkStorage;
    private final zendesk.core.IdentityStorage identityStorage;
    private final zendesk.core.BaseStorage mediaCache;
    private final List<File> registeredFolders;
    private final Cache responseCache;
    private final File zendeskCacheDir;
    private final File zendeskDataDir;
    ZendeskSessionStorage(zendesk.core.IdentityStorage identityStorage, zendesk.core.BaseStorage baseStorage2, Cache cache3, zendesk.core.BaseStorage baseStorage4, File file5, File file6, File file7) {
        super();
        this.identityStorage = identityStorage;
        this.additionalSdkStorage = baseStorage2;
        this.responseCache = cache3;
        this.zendeskCacheDir = file5;
        this.zendeskDataDir = file6;
        this.mediaCache = baseStorage4;
        File[] obj2 = new File[3];
        ArrayList obj1 = new ArrayList(Arrays.asList(file5, file6, file7));
        this.registeredFolders = obj1;
    }

    private static void clearDirectory(File file) {
        boolean listFiles;
        boolean directory;
        int i;
        File file2;
        listFiles = file.listFiles();
        if (file != null && file.exists() != null && listFiles != null && file.isDirectory() != null && a.j(listFiles) != null) {
            if (file.exists() != null) {
                listFiles = file.listFiles();
                if (listFiles != null) {
                    if (file.isDirectory() != null) {
                        if (a.j(listFiles) != null) {
                            i = 0;
                            while (i < listFiles.length) {
                                ZendeskSessionStorage.clearDirectory(listFiles[i]);
                                i++;
                            }
                        }
                    }
                }
                file.delete();
            }
        }
    }

    private File createDirIfNotExists(File file) {
        boolean exists;
        Object[] arr;
        String str;
        String absolutePath;
        if (file.exists() != null) {
            arr = new Object[2];
            a.b("SessionStorage", "Created dir %s, success: %s", file.getAbsolutePath(), Boolean.valueOf(file.mkdirs()));
        }
        return file;
    }

    @Override // zendesk.core.SessionStorage
    public void clear() {
        Object next;
        this.identityStorage.clear();
        this.additionalSdkStorage.clear();
        this.mediaCache.clear();
        this.responseCache.evictAll();
        Iterator iterator = this.registeredFolders.iterator();
        for (File next : iterator) {
            ZendeskSessionStorage.clearDirectory(next);
        }
    }

    @Override // zendesk.core.SessionStorage
    public zendesk.core.BaseStorage getAdditionalSdkStorage() {
        return this.additionalSdkStorage;
    }

    @Override // zendesk.core.SessionStorage
    public File getZendeskCacheDir() {
        return createDirIfNotExists(this.zendeskCacheDir);
    }

    @Override // zendesk.core.SessionStorage
    public File getZendeskDataDir() {
        return createDirIfNotExists(this.zendeskDataDir);
    }
}
