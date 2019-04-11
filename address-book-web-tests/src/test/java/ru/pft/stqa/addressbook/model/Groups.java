package ru.pft.stqa.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<GroupInfo> {

    private Set<GroupInfo> delegate;

    public Groups(Groups groups) {
        this.delegate = new HashSet<GroupInfo>(groups.delegate);
    }

    public Groups() {
        this.delegate = new HashSet<>();
    }

    @Override
    protected Set delegate() {
        return delegate;
    }

public Groups withAdded(GroupInfo group){
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
}

    public Groups without(GroupInfo group){
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }
}



