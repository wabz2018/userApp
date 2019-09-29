package com.userapp.userapps.services;

import com.userapp.userapps.entities.Users;
import com.userapp.userapps.repositories.UserRepository;
import com.userapp.userapps.utils.GeneralRequest;
import com.userapp.userapps.utils.GeneralRespose;
import com.userapp.userapps.utils.UserRequest;
import com.userapp.userapps.utils.UserResponse;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author Maelo
 */
@Service
public class UserService {

    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    UserResponse response;

    @Autowired
    UserRepository userrepos;

    public UserResponse userLogin(UserRequest userRequest) {
        response = new UserResponse();
        Users username = userrepos.findByUsername(userRequest.getUsername());
        Users password = userrepos.findByPassword(userRequest.getPassword());
        //response.setHttpStatus(HttpStatus.OK);
        response.setMessage("Invalid login credentials");
        response.setRequestStatus(Boolean.FALSE);
        response.setToken(null);

        if (username != null && password != null) {
            //  response.setHttpStatus(HttpStatus.OK);
            response.setMessage("Successfully Logged in");
            response.setRequestStatus(Boolean.TRUE);
            // response.setToken("iuyiuuoluootrtrtiwyqio1152628272181719367192hj,hdqjw");
            response.setToken(CreateToken(username).toString());
        } else {
            //   response.setHttpStatus(HttpStatus.OK);
            response.setMessage("Invalid login credentials");
            response.setRequestStatus(Boolean.TRUE);
            response.setToken(null);
        }

        return response;
    }

    public GeneralRespose register(GeneralRequest<Users> generalRequest) {
        GeneralRespose respose = new GeneralRespose();
        Users users = new Users();
        Users username = userrepos.findByUsername(generalRequest.getObject().getUsername());
        respose.setHttpStatus(HttpStatus.OK);
        respose.setMessage("Failed");
        respose.setPayload(null);
        respose.setStatus(true);
        if (username == null) {
            users.setFirstname(generalRequest.getObject().getFirstname());
            users.setLastname(generalRequest.getObject().getLastname());
            users.setUsername(generalRequest.getObject().getUsername());
            users.setPassword(generalRequest.getObject().getPassword());
            users.setToken(generalRequest.getObject().getToken());
            users.setEmail(generalRequest.getObject().getEmail());
            users.setIsloggedIn(Boolean.FALSE);
            userrepos.save(users);
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Success");
            respose.setPayload(users);
            respose.setStatus(true);

        } else {
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Username with username " + generalRequest.getObject().getUsername() + " exists");
            respose.setPayload(null);
            respose.setStatus(true);
        }
        return respose;
    }

    public String CreateToken(Users user) {

        SecureRandom random = new SecureRandom();
        byte[] bite = new byte[64];
        random.nextBytes(bite);
        return base64Encoder.encodeToString(bite) + user.getUsername();
    }

    public GeneralRespose findAllUsers(GeneralRequest<Users> generalRequest) {
        GeneralRespose respose = new GeneralRespose();
        List<Users> users = userrepos.findAll();
        respose.setHttpStatus(HttpStatus.OK);
        respose.setMessage("Error occurred");
        respose.setPayload(null);
        respose.setStatus(false);
        if (users != null) {
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Successfully listed all users");
            respose.setPayload(users);
            respose.setStatus(true);
        } else {
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Data not found");
            respose.setPayload(null);
            respose.setStatus(true);
        }
        return respose;
    }

    public GeneralRespose findByEmail(GeneralRequest<Users> generalRequest) {
        GeneralRespose respose = new GeneralRespose();
        Users email = userrepos.findByEmail(generalRequest.getObject().getEmail());
        respose.setHttpStatus(HttpStatus.OK);
        respose.setMessage("Error occurred");
        respose.setPayload(null);
        respose.setStatus(false);
        if (email != null) {
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Successfully listed user");
            respose.setPayload(email);
            respose.setStatus(true);
        } else {
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Data not found");
            respose.setPayload(null);
            respose.setStatus(true);
        }
        return respose;
    }

    public GeneralRespose deleteUser(GeneralRequest<Users> generalRequest) {
        GeneralRespose respose = new GeneralRespose();
        Users email = userrepos.findByEmail(generalRequest.getObject().getEmail());
        respose.setHttpStatus(HttpStatus.OK);
        respose.setMessage("Error occurred");
        respose.setPayload(null);
        respose.setStatus(false);
        if (email != null) {
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Successfully deleted user");
            respose.setPayload(email);
            respose.setStatus(true);
        } else {
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Data not found");
            respose.setPayload(null);
            respose.setStatus(true);
        }
        return respose;
    }
}
