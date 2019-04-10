package ru.pft.stqa.addressbook.model;

import java.util.Objects;

public class GroupInfo {
    private String nameGroup;
    private String header;
    private String footer;
    private int id = Integer.MAX_VALUE;



    public int getId() {
        return id;
    }

    public GroupInfo withId(int id) {
        this.id = id;
        return this;
    }

    public GroupInfo withName(String nameGroup) {
        this.nameGroup = nameGroup;
        return this;
    }

    public GroupInfo withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupInfo withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupInfo groupInfo = (GroupInfo) o;
        return id == groupInfo.id &&
                Objects.equals(nameGroup, groupInfo.nameGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameGroup);
    }

    @Override
    public String toString() {
        return "GroupInfo{" +
                "id=" + id +
                ", nameGroup='" + nameGroup + '\'' +
                '}';
    }

}
