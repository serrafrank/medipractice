package org.medipractice.clientui.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.json.JSONPropertyName;

@Data
public class TokenBean {

    @JsonProperty(value = "access_token")
    private String accessToken;


    @JsonProperty(value = "token_type")
    private String tokenType;

    @JsonProperty(value = "refresh_token")
    private String refreshToken;

    @JsonProperty(value = "expires_in")
    private String expiresIn;

    @JsonProperty(value = "scope")
    private String scope;

}
