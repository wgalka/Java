import java.util.Date;

public class Student {
    private String name;
    private String surname;
    private long albumnumber;
    private Date creationDate;

    public Student() {

    }

    public Student(String name, String surname, long albumnumber) {
        this.name = name;
        this.surname = surname;
        this.albumnumber = albumnumber;
        this.creationDate = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getAlbumnumber() {
        return albumnumber;
    }

    public void setAlbumnumber(long albumnumber) {
        this.albumnumber = albumnumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return this.creationDate.toString();
    }
}
