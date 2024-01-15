package org.lkathary.cft.storages;

import lombok.Getter;
import org.lkathary.cft.models.CommandLine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
public abstract class BaseStorage<T> implements Iterable<T> {

    protected final List<T> storage = new ArrayList<>();
    protected TypeFile typeStorage;

    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }

    public boolean add(T entity) {
        return storage.add(entity);
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }

    public abstract void showStatistic(CommandLine commandLine);
}
