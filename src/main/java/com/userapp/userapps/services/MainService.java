/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.userapp.userapps.services;

import com.userapp.userapps.entities.Subprice;
import com.userapp.userapps.entities.Subtypes;
import com.userapp.userapps.repositories.SubPriceRepository;
import com.userapp.userapps.repositories.SubtypesRepository;
import com.userapp.userapps.utils.GeneralRequest;
import com.userapp.userapps.utils.GeneralRespose;

import com.userapp.userapps.utils.UserResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author Maelo
 */
@Service
public class MainService {

    UserResponse response;

    @Autowired
    SubPriceRepository pricerepos;

    @Autowired
    SubtypesRepository subtyperepos;

    public GeneralRespose SaveType(GeneralRequest<Subtypes> generalRequest) {
        GeneralRespose respose = new GeneralRespose();
        Subtypes types = new Subtypes();
        Subtypes subcode = subtyperepos.findBySubCode(generalRequest.getObject().getSubcode());
        respose.setHttpStatus(HttpStatus.OK);
        respose.setMessage("Failed");
        respose.setPayload(null);
        respose.setStatus(true);
        if (subcode == null) {
            types.setSubcode(generalRequest.getObject().getSubcode());
            types.setSubdesc(generalRequest.getObject().getSubdesc());
            subtyperepos.save(types);
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Success");
            respose.setPayload(types);
            respose.setStatus(true);

        } else {
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Subcode  with subcode " + generalRequest.getObject().getSubcode() + " exists");
            respose.setPayload(null);
            respose.setStatus(true);
        }
        return respose;
    }

    public GeneralRespose SavePrice(GeneralRequest<Subprice> generalRequest) {
        GeneralRespose respose = new GeneralRespose();
        Subprice prices = new Subprice();
        Subprice subcode = pricerepos.findBySubCode(generalRequest.getObject().getSubcode());
        respose.setHttpStatus(HttpStatus.OK);
        respose.setMessage("Failed");
        respose.setPayload(null);
        respose.setStatus(true);
        if (subcode == null) {
            prices.setSubcode(generalRequest.getObject().getSubcode());
            prices.setPrice(generalRequest.getObject().getPrice());
            pricerepos.save(prices);
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Success");
            respose.setPayload(prices);
            respose.setStatus(true);

        } else {
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Pricecode with subcode " + generalRequest.getObject().getSubcode() + " exists");
            respose.setPayload(null);
            respose.setStatus(true);
        }
        return respose;
    }

    public GeneralRespose findByType(GeneralRequest<Subtypes> generalRequest) {
        GeneralRespose respose = new GeneralRespose();
        Subtypes type = subtyperepos.findBySubCode(generalRequest.getObject().getSubcode());
        respose.setHttpStatus(HttpStatus.OK);
        respose.setMessage("Error occurred");
        respose.setPayload(null);
        respose.setStatus(false);
        if (type != null) {
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Successfully listed Type");
            respose.setPayload(type);
            respose.setStatus(true);
        } else {
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Data not found");
            respose.setPayload(null);
            respose.setStatus(true);
        }
        return respose;
    }

    public GeneralRespose findByCode(GeneralRequest<Subprice> generalRequest) {
        GeneralRespose respose = new GeneralRespose();
        Subprice code = pricerepos.findBySubCode(generalRequest.getObject().getSubcode());
        respose.setHttpStatus(HttpStatus.OK);
        respose.setMessage("Error occurred");
        respose.setPayload(null);
        respose.setStatus(false);
        if (code != null) {
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Successfully listed Plan");
            respose.setPayload(code);
            respose.setStatus(true);
        } else {
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Data not found");
            respose.setPayload(null);
            respose.setStatus(true);
        }
        return respose;
    }

    public GeneralRespose findAllTypes(GeneralRequest<Subtypes> generalRequest) {
        GeneralRespose respose = new GeneralRespose();
        List<Subtypes> types = subtyperepos.findAll();
        respose.setHttpStatus(HttpStatus.OK);
        respose.setMessage("Error occurred");
        respose.setPayload(null);
        respose.setStatus(false);
        if (types != null) {
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Successfully listed all Plans");
            respose.setPayload(types);
            respose.setStatus(true);
        } else {
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Data not found");
            respose.setPayload(null);
            respose.setStatus(true);
        }
        return respose;
    }

    public GeneralRespose findAllPrices(GeneralRequest<Subprice> generalRequest) {
        GeneralRespose respose = new GeneralRespose();
        List<Subprice> prices = pricerepos.findAll();
        respose.setHttpStatus(HttpStatus.OK);
        respose.setMessage("Error occurred");
        respose.setPayload(null);
        respose.setStatus(false);
        if (prices != null) {
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Successfully listed all Price plans");
            respose.setPayload(prices);
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
