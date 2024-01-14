package org.lkathary.cft.savers;

import org.lkathary.cft.storages.BaseStorage;

import java.util.List;

public interface ISave {
    void save(String file, boolean append, BaseStorage<?> storage);
}
