
package SE02;

public class Group {
    String groupName;
    int groupId;
    CLASSNAME[] classname;
    CLASSNAME className;

    Group(String groupName, int groupId) {
        this.groupName = groupName;
        this.groupId = groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setClassName(CLASSNAME className) {
        this.className = className;
    }

    public void setClassname(CLASSNAME[] classname) {
        this.classname = classname;
    }

    public CLASSNAME[] getClassname() {
        return this.classname;
    }

    public void setClassName(String className) {
        this.groupName = className;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public String getClassName() {
        return this.groupName;
    }
}
