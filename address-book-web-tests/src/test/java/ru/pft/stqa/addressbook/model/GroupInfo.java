package ru.pft.stqa.addressbook.model;

import java.util.Objects;

public class GroupInfo {
    private final String nameGroup;
    private final String header;
    private final String footer;
    private int id;
    public GroupInfo(String nameGroup, String header, String footer) {
        this.id = 0;
        this.nameGroup = nameGroup;
        this.header = header;
        this.footer = footer;
    }

    public GroupInfo(Integer id, String nameGroup, String header, String footer) {
        this.id = id;
        this.nameGroup = nameGroup;
        this.header = header;
        this.footer = footer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
