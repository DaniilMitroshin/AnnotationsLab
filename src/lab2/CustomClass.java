package lab2;

public class CustomClass {
    String information = "";
    public CustomClass(){this.information = "Custom Method is succeed";}
    public CustomClass(String str){this.information = "custom" + str;}

    public String getInformation() {
        return information;
    }
}
