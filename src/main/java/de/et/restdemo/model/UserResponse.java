package de.et.restdemo.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Standard answer to a REST request.
 *
 * Created by Erik on 01.11.2015.
 */
@XmlRootElement
public class UserResponse {

    public String message;
}
