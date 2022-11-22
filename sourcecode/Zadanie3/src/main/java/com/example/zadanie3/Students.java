package com.example.zadanie3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "students")
public class Students {

    List<Student> studenci = new ArrayList<>();

    public Students() {
    }

    public List<Student> getStudenci() {
        return studenci;
    }

    @XmlElement(name = "student", type = Student.class)
    public void setStudenci(List<Student> studenci) {
        this.studenci = studenci;
    }
}
