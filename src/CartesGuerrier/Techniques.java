package CartesGuerrier;

import Personnages.Warrior;

public abstract class Techniques {
    private String name;
    private int cout;
    private String desc;
    private int level;
    private String type;




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

    public abstract void utilisation (Warrior guerrier, int invest);
    public abstract void effetFinDeTour( Warrior warrior);

    public abstract  String getMoveDesc();
    public abstract  String getMoveDesc2();
    public abstract  String getMoveDesc3();
}
