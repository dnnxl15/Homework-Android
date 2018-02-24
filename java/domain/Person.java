package domain;

/**
 * Created by esteb on 22/2/2018.
 */

public class Person
{
    private String name;

    public Person(String pName)
    {
        this.name = pName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
