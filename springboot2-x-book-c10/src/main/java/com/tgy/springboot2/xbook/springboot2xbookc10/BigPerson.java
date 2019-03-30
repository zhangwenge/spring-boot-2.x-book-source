package com.tgy.springboot2.xbook.springboot2xbookc10;

import java.util.List;

/**
 * @ClassName BigPerson
 */
public class BigPerson extends BaseRequestBo {

    private static final long serialVersionUID = -2496928288298335862L;
    private List<Person> persons;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "BigPerson{" +
                "persons=" + persons +
                '}';
    }
}
