package java_dev.framework.hibernate_jpa.entity;


import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee implements Serializable {

    @Id
    private Integer id;

    private String name;
    private String mailId;
    private Long contactNumber;


    public Employee() {
    }

    
    public Employee(Integer id, String name, String mailId, Long contactNumber) {
        this.id = id;
        this.name = name;
        this.mailId = mailId;
        this.contactNumber = contactNumber;
    }

  

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", mailId=" + mailId +
                ", contactNumber=" + contactNumber + "]";
    }
}