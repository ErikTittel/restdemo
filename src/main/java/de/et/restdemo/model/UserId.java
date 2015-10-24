package de.et.restdemo.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Just a user ID.
 *
 * Created by Erik on 24.10.2015.
 */
@XmlRootElement
public class UserId {

    private String id;

    public UserId(String id) {
        this.id = id;
    }

    @XmlElement
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
