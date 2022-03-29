package constants;

public enum ClassType {


    ECONOMY("Economy"),
    PREMIUM_ECONOMY("Premium Economy"),
    BUSINESS("Business"),
    FIRST("First");


    private String classType;

    ClassType(String cabinType)
    {
        this.classType=cabinType;
    }

    public String getClassType()
    {
        return classType;
    }

}