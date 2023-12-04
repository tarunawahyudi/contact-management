package com.stacklab.contactmanagementrestfulapi.controller;

import com.stacklab.contactmanagementrestfulapi.entity.User;
import com.stacklab.contactmanagementrestfulapi.model.AddressResponse;
import com.stacklab.contactmanagementrestfulapi.model.CreateAddressRequest;
import com.stacklab.contactmanagementrestfulapi.model.WebResponse;
import com.stacklab.contactmanagementrestfulapi.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(
            path = "/api/v1/contacts/{contactId}/addresses"
    )
    public WebResponse<AddressResponse> create(
            User user,
            @RequestBody CreateAddressRequest request,
            @PathVariable("contactId") String contactId) {

        request.setContactId(contactId);
        AddressResponse response = addressService.create(user, request);
        return WebResponse.<AddressResponse>builder().data(response).build();

    }
}
