/*
 * Here to Help
 * This is a restful web service used to log hours for non-profits to submit for money grants.
 *
 * OpenAPI spec version: 1.0.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.dsmhack.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

/**
 * UserOrganization
 */
@Entity
@Table(name = "user_org")
public class UserOrganization {
    @EmbeddedId
    private MyKey myKey;

    public MyKey getMyKey() {
        return myKey;
    }

    public void setMyKey(MyKey myKey) {
        this.myKey = myKey;
    }

    @Embeddable
    public class MyKey implements Serializable {

        @Column(name = "USER_GUID", nullable = false)
        private String userGuid;

        @Column(name = "ORG_GUID", nullable = false)
        private String orgGuid;

        public String getUserGuid() {
            return userGuid;
        }

        public void setUserGuid(String userGuid) {
            this.userGuid = userGuid;
        }

        public String getOrgGuid() {
            return orgGuid;
        }

        public void setOrgGuid(String orgGuid) {
            this.orgGuid = orgGuid;
        }
    }
}

