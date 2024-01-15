package org.lkathary.cft.savers;

import org.lkathary.cft.storages.BaseStorage;

public interface ISave {
    void save(String file, boolean append, BaseStorage<?> storage);
}
