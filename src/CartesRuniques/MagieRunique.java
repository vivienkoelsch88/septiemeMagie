package CartesRuniques;

public abstract class MagieRunique {
    private String name;
    private int cout;
    private String desc;
    private int level;
    private String type;
    public String moveDesc;
    public String moveDesc2;
    public String moveDesc3;


    public String getMoveDesc() {
        return moveDesc;
    }

    public void setMoveDesc(String moveDesc) {
        this.moveDesc = moveDesc;
    }

    public String getMoveDesc2() {
        return moveDesc2;
    }

    public void setMoveDesc2(String moveDesc2) {
        this.moveDesc2 = moveDesc2;
    }

    public String getMoveDesc3() {
        return moveDesc3;
    }

    public void setMoveDesc3(String moveDesc3) {
        this.moveDesc3 = moveDesc3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
