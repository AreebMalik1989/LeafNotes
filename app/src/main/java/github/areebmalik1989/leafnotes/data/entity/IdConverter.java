package github.areebmalik1989.leafnotes.data.entity;

import github.areebmalik1989.core.domain.Identity;

public final class IdConverter {

    public static Long convertId(Identity id) {
        if (id != null && id.getId() != Long.MIN_VALUE) {
            return id.getId();
        }

        return null;
    }
}