package com.users.api.dto;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.users.api.models.Phone;
import com.users.api.models.UserEntity;
import lombok.Builder;

@Builder
public class UserEntityDto {

    private Integer id;

    private String name;
    @NotEmpty(message = "The email address is required.")
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    private String password;

    private PhoneDto[] phones;

    private Date created;

    private Date modified;

    private Date lastLogin;

    public UserEntityDto() {
    }

    public UserEntityDto(Integer id, String name, String email, String password, PhoneDto[] phones, Date created, Date modified, Date lastLogin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
        this.created = created;
        this.modified = modified;
        this.lastLogin = lastLogin;
    }

    public UserEntityDto(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.email = userEntity.getEmail();
        this.password = userEntity.getPassword();
        this.created = userEntity.getCreated();
        this.modified = userEntity.getModified();
        this.lastLogin = userEntity.getLastLogin();
        List<Phone> phonesU = userEntity.getPhones();

        if (phonesU==null) {
           return;
        }

        phones = new PhoneDto[phonesU.size()];
        int i=0;

        for (Phone phone:phonesU) {
            phones[i] = new PhoneDto(phone);
            i++;
        }
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PhoneDto[] getPhones() {
        return phones;
    }

    public void setPhones(PhoneDto[] phones) {
        this.phones = phones;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

}
