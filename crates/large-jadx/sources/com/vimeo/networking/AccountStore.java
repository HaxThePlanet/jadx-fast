package com.vimeo.networking;

import com.vimeo.networking.model.VimeoAccount;

/* loaded from: classes2.dex */
public interface AccountStore {
    public abstract void deleteAccount(VimeoAccount vimeoAccount);

    public abstract VimeoAccount loadAccount();

    public abstract void saveAccount(VimeoAccount vimeoAccount, String string2);

    @Deprecated
    public abstract void saveAccount(VimeoAccount vimeoAccount, String string2, String string3);
}
