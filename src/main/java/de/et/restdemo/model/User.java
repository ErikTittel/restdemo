package de.et.restdemo.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Respresentation of a natural person that uses this application.
 *
 * Created by Erik on 24.10.2015.
 */
@XmlRootElement
public class User {

    public String id;
    public String name;
    public String email;
    public int age;

}
