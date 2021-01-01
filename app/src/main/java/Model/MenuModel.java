package Model;

public class MenuModel {
    String menuImage, menuName;

    public MenuModel() {
    }

    public MenuModel(String menuImage, String menuName) {
        this.menuImage = menuImage;
        this.menuName = menuName;
    }

    public String getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(String menuImage) {
        this.menuImage = menuImage;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
